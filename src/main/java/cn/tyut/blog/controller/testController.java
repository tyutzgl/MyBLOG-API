package cn.tyut.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangguoliang
 * @date 2018-03-23 16:16
 */

@Controller
@RequestMapping("/test")
public class testController {
    private static Logger logger = LoggerFactory.getLogger(testController.class);

    @RequestMapping("/01")
    @ResponseBody
    public String exec() {
        logger.info("console Logging loading success");
        return "hello world!7890";
    }
}
