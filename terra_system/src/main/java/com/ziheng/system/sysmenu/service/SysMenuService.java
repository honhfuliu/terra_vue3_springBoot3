package com.ziheng.system.sysmenu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziheng.system.sysmenu.domain.SysMenu;
import com.ziheng.system.sysmenu.domain.vo.SysMenuVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service
* @createDate 2026-06-15 21:41:11
*/
public interface SysMenuService extends IService<SysMenu> {

    // 根据用户ID查询系统菜单列表
    List<SysMenu> selectMenuTreeByUserId(Long userId);

    // 构建树形菜单，并排序
    List<SysMenuVO> buildMenuTree(List<SysMenu> sysMenuList);



}
