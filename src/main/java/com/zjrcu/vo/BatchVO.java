package com.zjrcu.vo;

import com.zjrcu.entity.User;
import java.util.List;

/**
 * 进行批处理时parameterType参数
 * foreach collection的userList
 * 对user集合即userList进行封装
 */
public class BatchVO {

    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "BatchVO{" +
                "userList=" + userList +
                '}';
    }
}
