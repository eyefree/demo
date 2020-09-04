package com.zjrcu.dao;

import com.zjrcu.entity.User;
import com.zjrcu.vo.BatchVO;

import java.util.List;

/**
 * User的持久层接口，访问数据库
 */
public interface UserDao {

    /**
     * 查询所有
     * @return
     * users
     */
    List<User> selectAll();

    /**
     * 插入
     * @param user
     * @return
     * true or false
     */
    boolean insert(User user);

    /**
     * 更新
     * @param user
     * @return
     * true or false
     */
    boolean update(User user);


    /**
     * 删除
     * @param id
     * @return
     * true or false
     */
    boolean delete(int id);

    /**
     * 批量插入
     * vo将用户集合进行封装
     * @param vo
     * @return
     */
    boolean insertBatch(BatchVO vo);

    /**
     * 批量更新
     * @param vo
     * @return
     */
    boolean updateBatch(BatchVO vo);

    /**
     * 批量删除
     * @param vo
     * @return
     */
    boolean deleteBatch(BatchVO vo);
}
