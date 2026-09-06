package com.ziheng.system.sysdictdata.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 字典值新增/修改 DTO
 * 与前端 AddDictDataType 保持一致（dictCode 为空表示新增，不为空表示修改）
 */
@Data
public class SysDictDataAddDTO {

    /**
     * 字典数据ID，为空表示新增，不为空表示修改
     */
    private Long dictCode;

    /**
     * 所属字典类型ID（必填）
     */
    @NotNull(message = "所属字典类型不能为空")
    private Long dictId;

    /**
     * 字典排序（必填）
     */
    @NotNull(message = "字典排序不能为空")
    private Integer dictSort;

    /**
     * 字典标签（必填）
     */
    @NotBlank(message = "字典标签不能为空")
    @Size(max = 100, message = "字典标签长度不能超过100个字符")
    private String dictLabel;

    /**
     * 字典值（必填）
     */
    @NotBlank(message = "字典值不能为空")
    @Size(max = 100, message = "字典值长度不能超过100个字符")
    private String dictValue;

    /**
     * 是否默认 Y是 N否，为空时新增默认N
     */
    private String isDefault;

    /**
     * 标签类型：success、warning、error、processing、default
     */
    @Size(max = 50, message = "标签类型长度不能超过50个字符")
    private String tagType;

    /**
     * CSS样式类
     */
    @Size(max = 100, message = "CSS样式类长度不能超过100个字符")
    private String cssClass;

    /**
     * 状态 0正常(启用) 1停用，为空时新增默认启用
     */
    private String status;

    /**
     * 备注
     */
    @Size(max = 500, message = "备注长度不能超过500个字符")
    private String remark;
}
