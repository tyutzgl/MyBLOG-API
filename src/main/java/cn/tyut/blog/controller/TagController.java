package cn.tyut.blog.controller;

import cn.tyut.blog.dao.TTagsMapper;
import cn.tyut.blog.pojo.TTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhangguoliang
 * @date 2018-04-24 10:01
 */
@Controller
@RequestMapping("/tags")
public class TagController {

    private final TTagsMapper tTagsMapper;

    @Autowired
    public TagController(TTagsMapper tTagsMapper) {
        this.tTagsMapper = tTagsMapper;
    }

    @GetMapping("/getTagsNameList")
    @ResponseBody
    public List<TTags> getTagsNameList() {
        List<TTags> tags = this.tTagsMapper.selectTagsNameList();
        return tags;
    }
}
