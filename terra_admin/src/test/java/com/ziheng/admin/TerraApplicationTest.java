package com.ziheng.admin;

import com.ziheng.system.auth.service.AuthService;
import com.ziheng.system.sysmenu.domain.vo.SysMenuVO;
import com.ziheng.system.sysmenu.mapper.SysMenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TerraApplicationTest {
    @Autowired
    private AuthService authService;
    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Test
    void test02(){
        String upperCase = UUID.randomUUID().toString().toUpperCase();
        System.out.println(upperCase);
        authService.validatePassword("admin123","admin",upperCase);
    }

    @Test
    void test01(){
//        List<SysMenuVO> menuList = sysMenuMapper.findMenuTreeByUserId(null);

//        Map<Long, SysMenuVO> menuMap = menuList.stream()
//                .collect(Collectors.toMap(
//                        SysMenuVO::getMenuId,
//                        menu -> menu));
//        List<SysMenuVO> rootMenus = new ArrayList<>();
//        for (SysMenuVO menu : menuList) {
//            if (menu.getParentId() == 0) {
//                rootMenus.add(menu);
//                continue;
//            }
//            SysMenuVO parent = menuMap.get(menu.getParentId());
//            if (parent != null) {
//                if (parent.getChildren() == null) {
//                    parent.setChildren(new ArrayList<>());
//                }
//
//                parent.getChildren().add(menu);
//            }
//        }
//        rootMenus.sort(
//                Comparator.comparing(SysMenuVO::getMenuSort)
//        );
//        rootMenus.forEach(System.out::println);

    }

}