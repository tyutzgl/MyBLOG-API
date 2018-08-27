package cn.tyut.blog.controller;

import cn.tyut.blog.dao.TUserInfoMapper;
import cn.tyut.blog.pojo.TUserInfo;
import cn.tyut.blog.utils.MD5Util;
import cn.tyut.blog.utils.RegForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author zhangguoliang
 * @date 2018-04-25 16:07
 */
@Controller
@RequestMapping("/register")
public class RegController {

    private static Logger logger = LoggerFactory.getLogger(RegController.class);

    private final TUserInfoMapper tUserInfoMapper;


    @Autowired
    public RegController(TUserInfoMapper tUserInfoMapper) {
        this.tUserInfoMapper = tUserInfoMapper;
    }

    /**
     * @param regForm 前端注册表单
     * @return 0:error
     * 1：success
     */
    @RequestMapping("/reg")
    @ResponseBody
    public int regResult(RegForm regForm) {
        logger.info(regForm.toString());
        TUserInfo userInfo = new TUserInfo();
        // 后台对密码正确性进行二次判断
        if (!regForm.getPsw1().equals(regForm.getPsw2())) {
            return 0;
        }
        // 获取MD5加密后的密码
        String md5Password = MD5Util.getResult(regForm.getPsw1());
        // 实例化用户类对象
        userInfo.setPassword(md5Password);
        userInfo.setUsername(regForm.getUsername());
        userInfo.setEmail(regForm.getEmail());
        userInfo.setAddress(regForm.getAddress());
        userInfo.setAge(regForm.getAge());
        userInfo.setIntroduce(regForm.getIntroduce());
        userInfo.setSex(regForm.getSex());
        int result = tUserInfoMapper.insert(userInfo);
        return result;
    }
}
