package com.ziheng.system.sysmenu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziheng.system.sysmenu.domain.SysMenu;
import com.ziheng.system.sysmenu.domain.dto.SysMenuAddDTO;
import com.ziheng.system.sysmenu.domain.dto.SysMenuQuery;
import com.ziheng.system.sysmenu.domain.dto.SysMenuSortDTO;
import com.ziheng.system.sysmenu.domain.vo.RouterVO;
import com.ziheng.system.sysmenu.domain.vo.SysMenuListVO;
import com.ziheng.system.sysmenu.domain.vo.SysMenuTreeVO;

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
    // List<RouterVO> buildMenuTree(List<SysMenu> sysMenuList);

    // 构建树形菜单，并排序
    RouterVO convertToRouteTree(List<SysMenu> sysMenuList);

    // 获取菜单树（用于选择上级菜单，needRoot=true 时带顶级根节点"主类目"）
    List<SysMenuTreeVO> listMenuTree(Boolean needRoot);

    // 查询菜单列表树（用于菜单管理表格展示）
    List<SysMenuListVO> listMenuList(SysMenuQuery query);

    // 新增或修改菜单（dto.menuId 为空则新增，不为空则修改）
    Long addMenu(SysMenuAddDTO dto);

    // 查询菜单详情（编辑回显）
    SysMenu getMenuById(Long menuId);

    // 删除菜单
    void deleteMenu(Long menuId);

    // 批量保存菜单排序（接收树形结构，保存前端传入的 menuSort 值）
    void updateMenuSort(List<SysMenuSortDTO> sortList);



}
