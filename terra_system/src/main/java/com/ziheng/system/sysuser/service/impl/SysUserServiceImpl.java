package com.ziheng.system.sysuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziheng.common.core.domain.PageResult;
import com.ziheng.system.sysuser.domain.SysUser;
import com.ziheng.system.sysuser.domain.dto.SysUserQuery;
import com.ziheng.system.sysuser.domain.vo.SysUserVo;
import com.ziheng.system.sysuser.mapper.SysUserMapper;
import com.ziheng.system.sysuser.service.SysUserService;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_user(系统用户表)】的数据库操作Service实现
* @createDate 2026-06-12 17:10:57
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {

    @Override
    public PageResult<SysUserVo> listUsers(SysUserQuery query) {
        Page<SysUser> page = Page.of(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<SysUser>()
                .like(StringUtils.hasText(query.getUsername()), SysUser::getUsername, query.getUsername())
                .like(StringUtils.hasText(query.getNickname()), SysUser::getNickname, query.getNickname())
                .eq(query.getStatus() != null, SysUser::getStatus, query.getStatus())
                .orderByDesc(SysUser::getCreateTime)
                .orderByDesc(SysUser::getUserId);

        Page<SysUser> result = page(page, wrapper);
        List<SysUserVo> rows = result.getRecords().stream()
                .map(SysUserVo::from)
                .toList();
        return PageResult.of(result.getTotal(), rows);
    }
}




