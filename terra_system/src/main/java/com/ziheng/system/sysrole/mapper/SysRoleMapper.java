package com.ziheng.system.sysrole.mapper;

import com.ziheng.system.sysrole.domain.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2026-08-16 20:32:42
* @Entity generator.domain.SysRole
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 根据用户id查询角色列表
     * @param userId
     * @return
     */
    List<String> findRolesByUserId(@Param("userId") Long userId);

    /**
     * 删除角色关联的菜单权限
     * @param roleId 角色ID
     */
    int deleteRoleMenu(@Param("roleId") Long roleId);

    /**
     * 批量插入角色菜单关联
     * @param roleId 角色ID
     * @param menuIds 菜单ID集合
     */
    int insertRoleMenu(@Param("roleId") Long roleId, @Param("menuIds") List<Long> menuIds);

    /**
     * 查询角色关联的菜单ID集合
     * @param roleId 角色ID
     * @return 菜单ID集合
     */
    List<Long> selectMenuIdsByRoleId(@Param("roleId") Long roleId);

    /**
     * 查询角色被用户关联的数量
     * @param roleId 角色ID
     * @return 关联用户数
     */
    Long countUserByRoleId(@Param("roleId") Long roleId);
}




