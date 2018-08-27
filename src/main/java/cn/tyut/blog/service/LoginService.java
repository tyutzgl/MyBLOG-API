package cn.tyut.blog.service;

/**
 * @author zhangguoliang
 * @date 2018-05-10 15:28
 */
public interface LoginService {

    /**
     * @param userEmail 用户登录邮箱
     * @param password  用户登录密码
     * @return 登录状态
     */
    int loginCheck(String userEmail, String password);
}
