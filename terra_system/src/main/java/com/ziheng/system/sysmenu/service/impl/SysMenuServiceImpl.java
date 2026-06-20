package com.ziheng.system.sysmenu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziheng.system.sysmenu.domain.SysMenu;
import com.ziheng.system.sysmenu.domain.vo.MetaVo;
import com.ziheng.system.sysmenu.domain.vo.SysMenuVO;
import com.ziheng.system.sysmenu.mapper.SysMenuMapper;
import com.ziheng.system.sysmenu.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service实现
* @createDate 2026-06-15 21:41:11
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService {

    /**
     * 根据用户ID查询系统菜单列表
     * @param userId 用户ID
     * @return 系统菜单列表
     */
    @Override
    public List<SysMenu> selectMenuTreeByUserId(Long userId) {
        return baseMapper.findMenuTreeByUserId(userId);
    }

    /**
     * 构建菜单树
     * @param menuList 菜单列表
     * @return 菜单树
     */
    @Override
    public List<SysMenuVO> buildMenuTree(List<SysMenu> menuList) {

        Map<Long, SysMenuVO> menuMap = new HashMap<>();
        for (SysMenu menu : menuList) {
            SysMenuVO vo = new SysMenuVO();
            vo.setName(StringUtils.capitalize(menu.getPath()));
            vo.setPath(menu.getPath());
            vo.setComponent(menu.getComponent());
            vo.setVisible(menu.getVisible());
            vo.setPerms(menu.getPerms());
            vo.setMeta(
                    new MetaVo(
                            menu.getMenuName(),
                            menu.getIcon()
                    )
            );
            menuMap.put(menu.getMenuId(), vo);
        }

        List<SysMenuVO> rootMenus = new ArrayList<>();
        for (SysMenu menu : menuList) {
            SysMenuVO current =
                    menuMap.get(menu.getMenuId());
            if (menu.getParentId() == 0L) {
                current.setPath("/" + menu.getPath());
                current.setComponent("Layout");
                rootMenus.add(current);
                continue;
            }

            SysMenuVO parent =
                    menuMap.get(menu.getParentId());
            if (parent != null) {
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(current);
            }
        }
        return rootMenus;
    }
}




