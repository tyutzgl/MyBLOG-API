package cn.tyut.blog.service.Impl;

import cn.tyut.blog.dao.TUserInfoMapper;
import cn.tyut.blog.service.LoginService;
import cn.tyut.blog.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangguoliang
 * @date 2018-05-10 15:28
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final TUserInfoMapper tUserInfoMapper;

    @Autowired
    public LoginServiceImpl(TUserInfoMapper tUserInfoMapper) {
        this.tUserInfoMapper = tUserInfoMapper;
    }


    @Override
    public int loginCheck(String userEmail, String password) {

        String MD5Psw = MD5Util.getResult(password);
        int result = tUserInfoMapper.selectUser(userEmail, MD5Psw);
        if (result == 1) {
            logger.info("用户：" + userEmail + ",登录验证成功");
            return 1;
        } else {
            return 0;
        }
    }
}
