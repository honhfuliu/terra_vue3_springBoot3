package com.ziheng.system.sysdictdata.domain.vo;

import lombok.Data;

/**
 * 字典值编辑回显 VO
 * 字段与新增/修改提交的 SysDictDataAddDTO 一致，用于编辑表单回显
 */
@Data
public class SysDictDataEditVO {

    /**
     * 字典数据ID（有值则修改）
     */
    private Long dictCode;

    /**
     * 所属字典类型ID
     */
    private Long dictId;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 字典标签（显示名称）
     */
    private String dictLabel;

    /**
     * 字典值
     */
    private String dictValue;

    /**
     * 是否默认 Y是 N否
     */
    private String isDefault;

    /**
     * 标签类型：success、warning、error、processing、default
     */
    private String tagType;

    /**
     * CSS样式类
     */
    private String cssClass;

    /**
     * 状态 0正常(启用) 1停用
     */
    private String status;

    /**
     * 备注
     */
    private String remark;
}
