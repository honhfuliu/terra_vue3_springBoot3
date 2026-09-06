package com.ziheng.system.sysdicttype.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 字典类型新增/修改 DTO
 * 与前端 AddDictType 保持一致（dictId 为空表示新增，不为空表示修改）
 */
@Data
public class SysDictTypeAddDTO {

    /**
     * 字典ID，为空表示新增，不为空表示修改
     */
    private Long dictId;

    /**
     * 字典名称（必填）
     */
    @NotBlank(message = "字典名称不能为空")
    @Size(max = 64, message = "字典名称长度不能超过64个字符")
    private String dictName;

    /**
     * 字典编码/类型（必填，唯一）
     */
    @NotBlank(message = "字典编码不能为空")
    @Size(max = 100, message = "字典编码长度不能超过100个字符")
    private String dictType;

    /**
     * 状态 0正常(启用) 1停用，为空时默认启用
     */
    private String status;

    /**
     * 备注
     */
    @Size(max = 500, message = "备注长度不能超过500个字符")
    private String remark;
}
