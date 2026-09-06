package com.ziheng.system.sysuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziheng.common.core.domain.PageResult;
import com.ziheng.system.sysuser.domain.SysUser;
import com.ziheng.system.sysuser.domain.dto.SysUserAddDTO;
import com.ziheng.system.sysuser.domain.dto.SysUserQuery;
import com.ziheng.system.sysuser.domain.dto.SysUserResetPasswordDTO;
import com.ziheng.system.sysuser.domain.vo.SysUserEditVO;
import com.ziheng.system.sysuser.domain.vo.SysUserVo;

import java.util.List;


/**
* @author Administrator
* @description 针对表【sys_user(系统用户表)】的数据库操作Service
* @createDate 2026-06-12 17:10:57
*/
public interface SysUserService extends IService<SysUser> {
    /**
     * 分页查询用户列表
     * @param query
     * @return
     */
    PageResult<SysUserVo> listUsers(SysUserQuery query);

    /**
     * 新增或修改用户（userId 为空表示新增，不为空表示修改）
     * @param dto 用户信息
     * @return 用户ID
     */
    Long addUser(SysUserAddDTO dto);

    /**
     * 查询用户详情（编辑回显，含角色ID集合）
     * @param userId 用户ID
     * @return 用户详情
     */
    SysUserEditVO getUserDetail(Long userId);


    /**
     * 删除用户（支持单条或批量），逻辑删除并清理用户角色关联
     * @param userIds 用户ID集合
     */
    void deleteUsers(List<Long> userIds);

    /**
     * 重置用户密码（重新生成盐值并加密存储）
     * @param dto 重置密码参数
     */
    void resetPassword(SysUserResetPasswordDTO dto);
}
