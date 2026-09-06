package com.ziheng.system.sysdictdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziheng.system.sysdictdata.domain.SysDictData;
import com.ziheng.system.sysdictdata.domain.dto.SysDictDataAddDTO;
import com.ziheng.system.sysdictdata.domain.vo.SysDictDataEditVO;
import com.ziheng.system.sysdictdata.domain.vo.SysDictDataListVO;
import com.ziheng.system.sysdictdata.domain.vo.SysDictOptionVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_dict_data(字典数据表)】的数据库操作Service
* @createDate 2026-09-03 16:35:21
*/
public interface SysDictDataService extends IService<SysDictData> {

    /**
     * 新增或修改字典值（dictCode 为空表示新增，不为空表示修改）
     * @param dto 字典值信息
     * @return 字典数据ID
     */
    Long addDictData(SysDictDataAddDTO dto);

    /**
     * 根据字典类型ID查询字典值列表（不分页，按排序升序）
     * @param dictId 字典类型ID
     * @return 字典值列表
     */
    List<SysDictDataListVO> listDictDatas(Long dictId);

    /**
     * 根据字典类型编码查询启用的字典值选项（供前端页面下拉框/标签展示使用）
     * @param dictType 字典类型编码
     * @return 字典值选项列表
     */
    List<SysDictOptionVO> listDictOptions(String dictType);

    /**
     * 根据字典数据ID查询字典值详情（编辑回显）
     * @param dictCode 字典数据ID
     * @return 字典值详情
     */
    SysDictDataEditVO getDictDataDetail(Long dictCode);

    /**
     * 删除字典值（支持单条或批量，物理删除）
     * @param dictCode 字典数据ID
     */
    void deleteDictData(Long dictCode);
}
