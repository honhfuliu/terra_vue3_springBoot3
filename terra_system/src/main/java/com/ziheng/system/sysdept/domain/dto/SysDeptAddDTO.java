package com.ziheng.system.sysdept.domain.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * 部门新增/修改 DTO
 */
@Data
public class SysDeptAddDTO {

    /**
     * 部门ID，为空表示新增，不为空表示修改
     */
    private Long deptId;

    /**
     * 父部门ID，0表示顶级部门
     */
    private Long parentId;

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    @Size(max = 30, message = "部门名称长度不能超过30个字符")
    private String deptName;

    /**
     * 部门编码
     */
    @Size(max = 30, message = "部门编码长度不能超过30个字符")
    private String deptCode;

    /**
     * 显示排序
     */
    @NotNull(message = "排序不能为空")
    @Min(value = 0, message = "排序值不能小于0")
        private Integer sortOrder;

    /**
     * 负责人
     */
    @Size(max = 20, message = "负责人长度不能超过20个字符")
    private String leader;

    /**
     * 负责人联系电话
     */
    @Pattern(regexp = "^$|^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    /**
     * 部门邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 状态：1正常，0停用
     */
    private String status;

    /**
     * 备注
     */
    @Size(max = 500, message = "备注长度不能超过500个字符")
    private String remark;
}
