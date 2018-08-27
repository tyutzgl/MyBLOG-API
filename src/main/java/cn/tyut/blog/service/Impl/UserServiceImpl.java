package cn.tyut.blog.service.Impl;

import cn.tyut.blog.dao.TUserInfoMapper;
import cn.tyut.blog.pojo.TUserInfo;
import cn.tyut.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangguoliang
 * @date 2018-03-28 15:58
 */
@Service
public class UserServiceImpl implements UserService {

    private final TUserInfoMapper tUserInfoMapper;

    @Autowired
    public UserServiceImpl(TUserInfoMapper tUserInfoMapper) {
        this.tUserInfoMapper = tUserInfoMapper;
    }

    @Override
    public TUserInfo selecrUserById(Integer userId) {
        TUserInfo userInfo = tUserInfoMapper.selectByPrimaryKey(userId);
        return userInfo;
    }

    @Override
    public TUserInfo selecrUserByUserEmail(String userEmail) {
        TUserInfo userInfo = tUserInfoMapper.selecrUserByUserEmail(userEmail);
        return userInfo;
    }
}