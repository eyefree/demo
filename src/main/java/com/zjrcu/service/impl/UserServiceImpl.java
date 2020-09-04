package com.zjrcu.service.impl;

import com.zjrcu.dao.UserDao;
import com.zjrcu.entity.User;
import com.zjrcu.service.UserService;
import com.zjrcu.vo.BatchVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 服务层，处理用户修改业务逻辑
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 查询数据库中的所有用户
     * @return
     */
    @Override
    public List<User> findAllUser() {
        return userDao.selectAll();
    }

    /**
     * 插入一个用户
     * @return
     */
    @Override
    public boolean insertUser() {
        User user = new User();
        user.setName("test2");
        user.setGender("女");
        user.setBirthday(new Date());
        return userDao.insert(user);
    }

    /**
     * 根据id更新用户信息
     * @return
     */
    @Override
    public boolean updateUser() {
        User user = new User();
        user.setId(120); //根据id更新
        user.setName("test120Update");
        user.setGender("女");
        user.setBirthday(new Date());
        return userDao.update(user);
    }

    /**
     * 根据id删除用户
     * @return
     */
    @Override
    public boolean deleteUser() {
        return userDao.delete(15);
    }

    /**
     * 批量插入用户
     * @return
     */
    @Override
    public boolean insertBatchUser() {
        BatchVO vo = new BatchVO();
        List<User> users = new ArrayList<>();
//        User user = new User(); //实例化应该在里面，否则所有的user都是一样的，因为只复制了对象的引用，也就是浅拷贝。
        for (int i = 1; i <= 100; i++) {
            //随机生成100位用户
            User user = new User();
            if (i % 2 == 0) {
                user.setGender("男");
            } else {
                user.setGender("女");
            }
            user.setName("test" + i);
            user.setBirthday(new Date());
//            System.out.println(user);
            users.add(user);
//            System.out.println("第" + (i + 1) + "次：" + users);
        }
        vo.setUserList(users);
//        System.out.println(vo);
        return userDao.insertBatch(vo);
    }

    /**
     * 批量更新用户信息
     * @return
     */
    @Override
    public boolean updateBatchUser() {
        BatchVO vo = new BatchVO();
        List<User> users = new ArrayList<>();
        for (int i = 201; i <= 300; i++) {
            User user = new User();
            user.setId(i);
            user.setName("updateBatch" + i);
            users.add(user);
        }
        vo.setUserList(users);
        return userDao.updateBatch(vo);
    }

    /**
     * 批量删除用户
     * @return
     */
    @Override
    public boolean deleteBatchUser() {
        BatchVO vo = new BatchVO();
        List<User> users = new ArrayList<>();
        for (int i = 1200; i < 1300; i++) {
            User user = new User();
            user.setId(i);
            users.add(user);
        }
        vo.setUserList(users);
        return userDao.deleteBatch(vo);
    }
}
