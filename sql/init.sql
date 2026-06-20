-- ============================================
-- Terra 管理系统 - 数据库初始化脚本
-- ============================================

-- 1. 修改 sys_user 表，补充字段
ALTER TABLE sys_user ADD COLUMN IF NOT EXISTS sex CHAR(1) DEFAULT '0' COMMENT '性别 0未知 1男 2女';
ALTER TABLE sys_user ADD COLUMN IF NOT EXISTS avatar VARCHAR(500) DEFAULT '' COMMENT '头像地址';
ALTER TABLE sys_user ADD COLUMN IF NOT EXISTS login_ip VARCHAR(128) DEFAULT '' COMMENT '最后登录IP';
ALTER TABLE sys_user ADD COLUMN IF NOT EXISTS login_date DATETIME COMMENT '最后登录时间';
ALTER TABLE sys_user ADD COLUMN IF NOT EXISTS del_flag CHAR(1) DEFAULT '0' COMMENT '删除标志 0存在 1删除';

-- 2. 角色表
CREATE TABLE IF NOT EXISTS sys_role (
  role_id     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '角色ID',
  role_name   VARCHAR(64)  NOT NULL COMMENT '角色名称',
  role_key    VARCHAR(100) NOT NULL COMMENT '角色标识',
  sort        INT          DEFAULT 0 COMMENT '显示顺序',
  status      CHAR(1)      DEFAULT '1' COMMENT '状态 0禁用 1正常',
  remark      VARCHAR(500) DEFAULT '' COMMENT '备注',
  create_time DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  del_flag    CHAR(1)      DEFAULT '0' COMMENT '删除标志 0存在 1删除'
) COMMENT '角色表';

-- 3. 菜单权限表
CREATE TABLE IF NOT EXISTS sys_menu (
  menu_id     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '菜单ID',
  menu_name   VARCHAR(64)  NOT NULL COMMENT '菜单名称',
  parent_id   BIGINT       DEFAULT 0 COMMENT '父菜单ID',
  sort        INT          DEFAULT 0 COMMENT '显示顺序',
  path        VARCHAR(200) DEFAULT '' COMMENT '路由地址',
  component   VARCHAR(255) DEFAULT '' COMMENT '组件路径',
  menu_type   CHAR(1)      DEFAULT '' COMMENT '菜单类型 M目录 C菜单 F按钮',
  visible     CHAR(1)      DEFAULT '1' COMMENT '是否可见 0隐藏 1显示',
  status      CHAR(1)      DEFAULT '1' COMMENT '状态 0禁用 1正常',
  perms       VARCHAR(100) DEFAULT '' COMMENT '权限标识',
  icon        VARCHAR(100) DEFAULT '#' COMMENT '菜单图标',
  create_time DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  del_flag    CHAR(1)      DEFAULT '0' COMMENT '删除标志 0存在 1删除'
) COMMENT '菜单权限表';

-- 4. 用户角色关联表
CREATE TABLE IF NOT EXISTS sys_user_role (
  user_id BIGINT NOT NULL COMMENT '用户ID',
  role_id BIGINT NOT NULL COMMENT '角色ID',
  PRIMARY KEY (user_id, role_id)
) COMMENT '用户角色关联表';

-- 5. 角色菜单关联表
CREATE TABLE IF NOT EXISTS sys_role_menu (
  role_id BIGINT NOT NULL COMMENT '角色ID',
  menu_id BIGINT NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (role_id, menu_id)
) COMMENT '角色菜单关联表';

-- 6. 登录日志表
CREATE TABLE IF NOT EXISTS sys_login_log (
  id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '访问ID',
  user_name    VARCHAR(64)  DEFAULT '' COMMENT '用户账号',
  ip           VARCHAR(128) DEFAULT '' COMMENT '登录IP地址',
  browser      VARCHAR(128) DEFAULT '' COMMENT '浏览器类型',
  os           VARCHAR(128) DEFAULT '' COMMENT '操作系统',
  status       CHAR(1)      DEFAULT '1' COMMENT '登录状态 0成功 1失败',
  msg          VARCHAR(255) DEFAULT '' COMMENT '提示消息',
  login_time   DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '访问时间'
) COMMENT '系统访问记录';

-- ============================================
-- 初始数据
-- ============================================

-- 默认管理员用户 (密码: admin123, 盐值: a1b2c3d4e5f6g7h8)
-- MD5('admin123' + 'a1b2c3d4e5f6g7h8') = 需要实际计算
INSERT INTO sys_role (role_id, role_name, role_key, sort, status, remark) VALUES
(1, '超级管理员', 'admin', 1, '1', '超级管理员角色'),
(2, '普通用户', 'user', 2, '1', '普通用户角色');

INSERT INTO sys_menu (menu_id, menu_name, parent_id, sort, path, component, menu_type, visible, status, perms, icon) VALUES
-- 一级目录
(1, '系统管理', 0, 1, 'system', '', 'M', '1', '1', '', 'Setting'),
(2, '内容管理', 0, 2, 'content', '', 'M', '1', '1', '', 'Document'),
-- 系统管理子菜单
(100, '用户管理', 1, 1, 'user', 'system/user/index', 'C', '1', '1', 'system:user:list', 'User'),
(101, '角色管理', 1, 2, 'role', 'system/role/index', 'C', '1', '1', 'system:role:list', 'UserFilled'),
(102, '菜单管理', 1, 3, 'menu', 'system/menu/index', 'C', '1', '1', 'system:menu:list', 'Menu'),
-- 内容管理子菜单
(200, '文章管理', 2, 1, 'article', 'content/article/index', 'C', '1', '1', 'content:article:list', 'Notebook'),
(201, '分类管理', 2, 2, 'category', 'content/category/index', 'C', '1', '1', 'content:category:list', 'Folder'),
(202, '标签管理', 2, 3, 'tag', 'content/tag/index', 'C', '1', '1', 'content:tag:list', 'PriceTag'),
-- 用户管理按钮权限
(1001, '用户新增', 100, 1, '', '', 'F', '1', '1', 'system:user:add', '#'),
(1002, '用户修改', 100, 2, '', '', 'F', '1', '1', 'system:user:edit', '#'),
(1003, '用户删除', 100, 3, '', '', 'F', '1', '1', 'system:user:remove', '#'),
-- 角色管理按钮权限
(1011, '角色新增', 101, 1, '', '', 'F', '1', '1', 'system:role:add', '#'),
(1012, '角色修改', 101, 2, '', '', 'F', '1', '1', 'system:role:edit', '#'),
(1013, '角色删除', 101, 3, '', '', 'F', '1', '1', 'system:role:remove', '#');

-- 管理员拥有所有菜单权限
INSERT INTO sys_role_menu (role_id, menu_id) VALUES
(1, 1), (1, 2), (1, 100), (1, 101), (1, 102),
(1, 200), (1, 201), (1, 202),
(1, 1001), (1, 1002), (1, 1003),
(1, 1011), (1, 1012), (1, 1013);
