-- ============================================
-- 测试数据
-- ============================================

-- 管理员用户 (密码: admin123, 盐值: a1b2c3d4e5f6g7h8)
INSERT INTO sys_user (username, nickname, password, salt, email, phone, status, sex) VALUES
('admin', '超级管理员', '200d5df80717d92637105617eb0d3eb6', 'a1b2c3d4e5f6g7h8', 'admin@example.com', '13800138000', 1, '1');

-- 普通用户 (密码: user123, 盐值: x9y8z7w6v5u4t3s2)
INSERT INTO sys_user (username, nickname, password, salt, email, phone, status, sex) VALUES
('user', '普通用户', '78d24c24fd7f62b4724f93a1d662ced0', 'x9y8z7w6v5u4t3s2', 'user@example.com', '13900139000', 1, '0');

-- 管理员拥有角色1（超级管理员）
INSERT INTO sys_user_role (user_id, role_id) VALUES (1, 1);

-- 普通用户拥有角色2（普通用户）
INSERT INTO sys_user_role (user_id, role_id) VALUES (2, 2);
