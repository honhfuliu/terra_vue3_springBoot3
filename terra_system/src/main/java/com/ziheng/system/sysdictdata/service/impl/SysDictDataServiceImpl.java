package com.ziheng.system.sysdictdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziheng.common.exception.BusinessException;
import com.ziheng.system.sysdictdata.domain.SysDictData;
import com.ziheng.system.sysdictdata.domain.dto.SysDictDataAddDTO;
import com.ziheng.system.sysdictdata.domain.vo.SysDictDataEditVO;
import com.ziheng.system.sysdictdata.domain.vo.SysDictDataListVO;
import com.ziheng.system.sysdictdata.domain.vo.SysDictOptionVO;
import com.ziheng.system.sysdictdata.mapper.SysDictDataMapper;
import com.ziheng.system.sysdictdata.service.SysDictDataService;
import com.ziheng.system.sysdicttype.domain.SysDictType;
import com.ziheng.system.sysdicttype.mapper.SysDictTypeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_dict_data(字典数据表)】的数据库操作Service实现
* @createDate 2026-09-03 16:35:21
*/
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData>
    implements SysDictDataService {

    // 直接注入 Mapper 而非 SysDictTypeService，避免与 SysDictTypeServiceImpl（已依赖 SysDictDataService）形成循环依赖
    private final SysDictTypeMapper sysDictTypeMapper;

    public SysDictDataServiceImpl(SysDictTypeMapper sysDictTypeMapper) {
        this.sysDictTypeMapper = sysDictTypeMapper;
    }

    /**
     * 新增或修改字典值（dictCode 为空则新增，不为空则修改）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addDictData(SysDictDataAddDTO dto) {
        // 校验所属字典类型存在
        if (sysDictTypeMapper.selectById(dto.getDictId()) == null) {
            throw new BusinessException("所属字典类型不存在");
        }
        Long dictCode = dto.getDictCode();
        if (dictCode == null) {
            dictCode = insertDictData(dto);
        } else {
            updateDictData(dto);
        }
        return dictCode;
    }

    /**
     * 新增字典值
     */
    private Long insertDictData(SysDictDataAddDTO dto) {
        SysDictData data = new SysDictData();
        BeanUtils.copyProperties(dto, data);
        // 是否默认：为空默认 N
        if (!StringUtils.hasText(data.getIsDefault())) {
            data.setIsDefault("N");
        }
        // 状态为空默认启用(0正常)
        if (!StringUtils.hasText(data.getStatus())) {
            data.setStatus("0");
        }
        Date now = new Date();
        data.setCreateTime(now);
        data.setUpdateTime(now);
        save(data);
        return data.getDictCode();
    }

    /**
     * 修改字典值
     */
    private void updateDictData(SysDictDataAddDTO dto) {
        Long dictCode = dto.getDictCode();
        SysDictData old = getById(dictCode);
        if (old == null) {
            throw new BusinessException("字典值不存在");
        }
        SysDictData data = new SysDictData();
        BeanUtils.copyProperties(dto, data);
        // 未传是否默认/状态时保留原值（MP updateById 忽略 null 字段）
        if (!StringUtils.hasText(data.getIsDefault())) {
            data.setIsDefault(old.getIsDefault());
        }
        if (!StringUtils.hasText(data.getStatus())) {
            data.setStatus(old.getStatus());
        }
        data.setUpdateTime(new Date());
        updateById(data);
    }

    /**
     * 根据字典类型ID查询字典值列表（按排序升序，同排序按ID升序）
     */
    @Override
    public List<SysDictDataListVO> listDictDatas(Long dictId) {
        if (dictId == null) {
            throw new BusinessException("所属字典类型不能为空");
        }
        return lambdaQuery()
                .eq(SysDictData::getDictId, dictId)
                .orderByAsc(SysDictData::getDictSort)
                .orderByAsc(SysDictData::getDictCode)
                .list()
                .stream()
                .map(SysDictDataListVO::from)
                .toList();
    }

    /**
     * 根据字典类型编码查询启用的字典值选项（供前端页面下拉框/标签展示使用）
     */
    @Override
    public List<SysDictOptionVO> listDictOptions(String dictType) {
        SysDictType dictTypeRow = sysDictTypeMapper.selectOne(new LambdaQueryWrapper<SysDictType>()
                .eq(SysDictType::getDictType, dictType));
        if (dictTypeRow == null) {
            throw new BusinessException("字典类型不存在：" + dictType);
        }
        // 仅返回启用的字典值（停用的值不展示到页面）
        return lambdaQuery()
                .eq(SysDictData::getDictId, dictTypeRow.getDictId())
                .eq(SysDictData::getStatus, "1")
                .orderByAsc(SysDictData::getDictSort)
                .orderByAsc(SysDictData::getDictCode)
                .list()
                .stream()
                .map(SysDictOptionVO::from)
                .toList();
    }

    /**
     * 根据字典数据ID查询详情（编辑回显）
     */
    @Override
    public SysDictDataEditVO getDictDataDetail(Long dictCode) {
        SysDictData data = getById(dictCode);
        if (data == null) {
            throw new BusinessException("字典值不存在");
        }
        SysDictDataEditVO vo = new SysDictDataEditVO();
        BeanUtils.copyProperties(data, vo);
        return vo;
    }

    /**
     * 删除字典值（支持单条或批量，物理删除）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDictData(Long dictCode) {
        removeById(dictCode);

    }
}
