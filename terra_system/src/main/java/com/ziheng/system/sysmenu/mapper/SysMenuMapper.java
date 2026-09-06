package com.ziheng.system.sysmenu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziheng.system.sysmenu.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @createDate 2026-06-15 21:41:11
* @Entity generator.domain.SysMenu
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> findMenuTreeByUserId(Long userId);

    /**
     * 根据用户id查询权限列表
     * @param userId
     * @return
     */
    List<String> findPermissionsByUserId(@Param("userId") Long userId);
}




