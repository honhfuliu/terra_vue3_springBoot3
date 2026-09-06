package com.ziheng.system.sysdept.service;

import com.ziheng.system.sysdept.domain.SysDept;
import com.ziheng.system.sysdept.domain.dto.SysDeptAddDTO;
import com.ziheng.system.sysdept.domain.dto.SysDeptQuery;
import com.ziheng.system.sysdept.domain.dto.SysDeptSortDTO;
import com.ziheng.system.sysdept.domain.vo.SysDeptListVO;
import com.ziheng.system.sysdept.domain.vo.SysDeptTreeVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_dept(部门表)】的数据库操作Service
* @createDate 2026-08-23 13:15:18
*/
public interface SysDeptService extends IService<SysDept> {

    /**
     * 新增或修改部门（dto.deptId 为空则新增，不为空则修改）
     *
     * @param dto 部门DTO
     * @return 部门ID
     */
    Long addDept(SysDeptAddDTO dto);

    /**
     * 查询部门详情（用于编辑回显）
     *
     * @param deptId 部门ID
     * @return 部门信息
     */
    SysDept getDeptById(Long deptId);

    /**
     * 删除部门（逻辑删除）
     *
     * @param deptId 部门ID
     */
    void deleteDept(Long deptId);

    /**
     * 查询部门树（用于选择上级部门）
     *
     * @return 部门树
     */
    List<SysDeptTreeVO> listDeptTree();

    /**
     * 查询部门列表树（用于部门管理表格展示）
     *
     * @param query 查询条件（部门名称模糊、状态）
     * @return 部门列表树
     */
    List<SysDeptListVO> listDeptList(SysDeptQuery query);

    /**
     * 批量保存部门排序（按树形结构逐级更新 sortOrder，同层级按列表顺序重新编号）
     *
     * @param sortList 排序树形列表
     */
    void updateDeptSort(List<SysDeptSortDTO> sortList);
}
