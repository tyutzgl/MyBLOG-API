package cn.tyut.blog.controller;

import cn.tyut.blog.dao.TUserInfoMapper;
import cn.tyut.blog.pojo.TUserInfo;
import cn.tyut.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangguoliang
 * @date 2018-03-26 14:12
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final TUserInfoMapper userInfoMapper;

    @Autowired
    public UserController(UserService userService, TUserInfoMapper userInfoMapper) {
        this.userService = userService;
        this.userInfoMapper = userInfoMapper;
    }


    @GetMapping("/{userid}")
    @ResponseBody
    public TUserInfo selectUser(@PathVariable(name = "userid") Integer userId) {
        TUserInfo tUserInfo = userService.selecrUserById(userId);
        return tUserInfo;
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public TUserInfo selectUser(HttpServletRequest request) {
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        TUserInfo tUserInfo = userService.selecrUserByUserEmail(userEmail);
        return tUserInfo;
    }

    @RequestMapping("/editUserInfo")
    public int editUserInfo(TUserInfo userInfo,HttpServletRequest request){
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        int userId = userInfoMapper.getUserId(userEmail);
        userInfo.setUserid(userId);
        System.out.println(userInfo.toString());
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

}
