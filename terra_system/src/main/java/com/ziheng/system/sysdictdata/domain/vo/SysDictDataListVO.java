package com.ziheng.system.sysdictdata.domain.vo;

import com.ziheng.system.sysdictdata.domain.SysDictData;
import lombok.Data;

/**
 * 字典值列表 VO（根据字典类型ID查询，不分页）
 */
@Data
public class SysDictDataListVO {

    /**
     * 字典数据ID（供行操作使用）
     */
    private Long dictCode;

    /**
     * 字典标签（显示名称）
     */
    private String dictLabel;

    /**
     * 字典值
     */
    private String dictValue;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 状态 0正常(启用) 1停用
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    public static SysDictDataListVO from(SysDictData dictData) {
        SysDictDataListVO vo = new SysDictDataListVO();
        vo.setDictCode(dictData.getDictCode());
        vo.setDictLabel(dictData.getDictLabel());
        vo.setDictValue(dictData.getDictValue());
        vo.setDictSort(dictData.getDictSort());
        vo.setStatus(dictData.getStatus());
        vo.setRemark(dictData.getRemark());
        return vo;
    }
}
