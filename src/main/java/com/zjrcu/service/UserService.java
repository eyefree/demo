package com.zjrcu.service;

import com.zjrcu.entity.User;

import java.util.List;

/**
 * 用户修改的服务层接口
 */
public interface UserService {

    /**
     * 查询用户
     * @return
     * 返回所有用户信息
     */
    List<User> findAllUser();

    /**
     * 插入用户
     * @return
     * 成功为true，失败为false
     */
    boolean insertUser();

    /**
     * 更新用户信息（sql中判断条件为id）
     * @return
     * 成功为true，失败为false
     */
    boolean updateUser();

    /**
     * 删除用户（根据id）
     * @return
     * 成功为true，失败为false
     */
    boolean deleteUser();

    /**
     * 批量插入用户
     * @return
     * 成功为true，失败为false
     */
    boolean insertBatchUser();

    /**
     * 批量更新用户
     * @return
     * 成功为true，失败为false
     */
    boolean updateBatchUser();

    /**
     * 批量删除
     * @return
     * 成功为true，失败为false
     */
    boolean deleteBatchUser();
}
