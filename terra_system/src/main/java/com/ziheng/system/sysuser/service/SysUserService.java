package com.ziheng.system.sysuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziheng.common.core.domain.PageResult;
import com.ziheng.system.sysuser.domain.SysUser;
import com.ziheng.system.sysuser.domain.dto.SysUserQuery;
import com.ziheng.system.sysuser.domain.vo.SysUserVo;


/**
* @author Administrator
* @description 针对表【sys_user(系统用户表)】的数据库操作Service
* @createDate 2026-06-12 17:10:57
*/
public interface SysUserService extends IService<SysUser> {

    PageResult<SysUserVo> listUsers(SysUserQuery query);

}
