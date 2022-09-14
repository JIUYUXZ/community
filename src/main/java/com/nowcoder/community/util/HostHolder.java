package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

/*
* 持有用户信息，用于代替session对象
* */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    //ThreadLocal类中，将当前线程作为key存入map对象中，用来存取value
    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }

}
