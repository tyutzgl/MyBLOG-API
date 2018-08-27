package cn.tyut.blog.service;

import cn.tyut.blog.pojo.TUserInfo;

/**
 * @author zhangguoliang
 * @date 2018-03-28 15:57
 */
public interface UserService {
    TUserInfo selecrUserById(Integer userId);

    TUserInfo selecrUserByUserEmail(String userEmail);
}
