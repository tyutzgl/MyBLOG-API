package cn.tyut.blog.controller;

import cn.tyut.blog.dao.*;
import cn.tyut.blog.pojo.TArticle;
import cn.tyut.blog.pojo.TComment;
import cn.tyut.blog.pojo.TTags;
import cn.tyut.blog.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhangguoliang
 * @date 2018-03-26 13:49
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    private final TArticleMapper articleMapper;
    private final TUserInfoMapper userInfoMapper;
    private final TTagsMapper tTagsMapper;
    private final TArticleTagMapper articleTagMapper;
    private final TCommentMapper commentMapper;

    @Autowired
    public ArticleController(TArticleMapper articleMapper, TUserInfoMapper userInfoMapper, TTagsMapper tTagsMapper, TArticleTagMapper articleTagMapper, TCommentMapper commentMapper) {
        this.articleMapper = articleMapper;
        this.userInfoMapper = userInfoMapper;
        this.tTagsMapper = tTagsMapper;
        this.articleTagMapper = articleTagMapper;
        this.commentMapper = commentMapper;
    }

    /**
     * @param articleId
     * @return
     */
    @GetMapping("/{articleId}")
    @ResponseBody
    public RestResult articleDetails(@PathVariable(name = "articleId") Integer articleId) {
        TArticle tArticle = articleMapper.selectByPrimaryKey(articleId);
        RestResult restResult = new RestResult();
        restResult.setData(tArticle);
        restResult.setStatusCode(200);
        restResult.setMsg("success");
        return restResult;
    }

    /**
     * @param userId
     * @return
     */
    @GetMapping("/articleListByUserId")
    @ResponseBody
    public List<TArticle> getArtistList(Integer userId) {
        List<TArticle> tArticleList = articleMapper.findByUserId(userId);
        return tArticleList;
    }

    /**
     * 倒序查询{limit}条博客列表
     *
     * @param limit
     * @return
     */
    @GetMapping("/newArtivleList")
    @ResponseBody
    public List<TArticle> getArcListDESC(Integer limit) {
        List<TArticle> tArticleList = articleMapper.getArticleListDESC(limit);
        return tArticleList;
    }

    /**
     * @param articleid
     * @return
     */
    @GetMapping("/getArticleById")
    @ResponseBody
    public TArticle getArticleById(Integer articleid) {
        TArticle tArticle = articleMapper.selectByPrimaryKey(articleid);
        String tagName = articleTagMapper.getTagNameByArticleId(articleid);
        tArticle.setTag(tagName);
        String userName = userInfoMapper.getUserNameById(tArticle.getUserid());
        tArticle.setUserName(userName);
        return tArticle;
    }

    /**
     * @param tagname
     * @return
     */
    @GetMapping("/getArticleListByTag")
    @ResponseBody
    public List<TArticle> getArticleListByTag(String tagname, HttpServletRequest request) {
        List<TArticle> articleList = articleMapper.getArticleListByTag(tagname);
        return articleList;
    }

    @GetMapping("/hotArtivleList")
    @ResponseBody
    public List<TArticle> getHotArcListDESC(Integer limit) {
        List<TArticle> tHotArticleList = articleMapper.getHotArticleListDESC(limit);
        return tHotArticleList;
    }

    @GetMapping("/searchArticleList")
    @ResponseBody
    public List<TArticle> searchArticleList(String articleName) {
        List<TArticle> articleList = articleMapper.searchArticleList(articleName);
        return articleList;
    }

    /**
     * 添加Article
     * @param article 文章详细内容
     * @param request
     * @return
     */
    @RequestMapping("/addArticle")
    @ResponseBody
    public RestResult addArticle(TArticle article, HttpServletRequest request) {
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        int userId = userInfoMapper.getUserId(userEmail);
        article.setUserid(userId);
        article.setCreatetime(System.currentTimeMillis());
        // 添加标签
        if (article.getTag() == null || article.getTag().equals("")) {
            article.setTag(article.getTag_comment());
            TTags tTags = new TTags();
            tTags.setTagname(article.getTag());
            System.out.println(tTags.getTagname());
            //查询tag是否存在，不存在添加新tag
            if (tTagsMapper.selectTagsNum(tTags.getTagname()) == 0) {
                int addTagResult = tTagsMapper.insertSelective(tTags);
            }
        }
        // 添加article
        int status = articleMapper.insertSelective(article);
        // article与tag关联
        if (article.getTag() != null || !article.getTag().equals("")) {
            int tagId = tTagsMapper.selectTagId(article.getTag());
            int articleId = articleMapper.getArticleId(article.getCreatetime(), article.getUserid());
            int result = articleTagMapper.connectionTags(articleId, tagId);
        }
        RestResult restResult = new RestResult();
        if (status > 0) {
            restResult.setStatusCode(1);
        } else {
            restResult.setStatusCode(0);
        }
        return restResult;
    }

    @RequestMapping("/getArticleListByUser")
    public List<TArticle> getArticleListByUser(HttpServletRequest request){
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        int userId = userInfoMapper.getUserId(userEmail);
        List<TArticle> articleList = articleMapper.findByUserId(userId);
        return articleList;
    }

    @RequestMapping("/addGoodNum")
    public int addGoodNum(int articleId){
        return articleMapper.addGoodNum(articleId);
    }

    @RequestMapping("/subGoodNum")
    public int subGoodNum(int articleId){
        return articleMapper.subGoodNum(articleId);
    }

    @RequestMapping("/deleteBlog")
    public int deleteBlog(int articleId){
        return articleMapper.deleteBlog(articleId);
    }


    @RequestMapping("/addComment")
    public int addComment(int articleId,String content,HttpServletRequest request){
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        int userId = userInfoMapper.getUserId(userEmail);
        TComment tComment = new TComment();
        tComment.setArticleid(articleId);
        tComment.setUserid(userId);
        tComment.setContent(content);
        tComment.setCreatetime(System.currentTimeMillis());
        return commentMapper.insertSelective(tComment);
    }

    @RequestMapping("/selectCommentByArticleId")
    public List<TComment> selectCommentByArticleId(int articleId){
        List<TComment> commentList = commentMapper.selectCommentListByArticleId(articleId);
        return  commentList;
    }

    @RequestMapping("/getCommentNum")
    public int getCommentNum(int articleId){
        return commentMapper.getCommentNum(articleId);
    }

    @RequestMapping("/getArticleNum")
    public int getArticleNum(HttpServletRequest request){
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        int userId = userInfoMapper.getUserId(userEmail);
        return articleMapper.countUserArticleNum(userId);
    }

    @RequestMapping("/getGoodNum")
    public int getGoodNum(HttpServletRequest request){
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        int userId = userInfoMapper.getUserId(userEmail);
        return articleMapper.countUserGoodNum(userId);
    }
}
