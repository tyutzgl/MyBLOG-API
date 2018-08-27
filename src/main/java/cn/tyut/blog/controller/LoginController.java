package cn.tyut.blog.controller;

import cn.tyut.blog.service.LoginService;
import cn.tyut.blog.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zhangguoliang
 * @date 2018-04-16 15:04
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private static final int SUCCESS_STATUS_CODE = 1;
    private static final int FAILED_STATUS_CODE = 0;

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * @param userEmail 登录用户名
     * @param password  登录密码
     * @param request   登录请求信息
     * @return 返回用户验证状态
     */
    @RequestMapping("/checkLogin")
    @ResponseBody
    public int checkLogin(String userEmail, String password, HttpServletRequest request) {
        int result = loginService.loginCheck(userEmail, password);
        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", userEmail);
            return result;
        } else {
            return result;
        }
    }


    /**
     * @param request 获取request请求
     * @return FAILED_STATUS_CODE:未登录   SUCCESS_STATUS_CODE：已登录
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    public RestResult isLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        RestResult restResult = new RestResult();

        if (session.getAttribute("userEmail") == null || session.getAttribute("userEmail") == "") {
            restResult.setStatusCode(FAILED_STATUS_CODE);
            restResult.setMsg("未获取到用户信息");
            restResult.setData(null);
            return restResult;
        } else {
            restResult.setStatusCode(SUCCESS_STATUS_CODE);
            restResult.setMsg("用户已登录");
            restResult.setData(null);
            return restResult;
        }
    }

    @RequestMapping("/clearSession")
    @ResponseBody
    public int clearSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
//        当session为空时返回，不为空时清除信息
        if (session.getAttribute("userEmail") == null || session.getAttribute("userEmail") == "") {
            return 1;
        } else {
            session.removeAttribute("userEmail");
        }
        return 1;
    }
}
