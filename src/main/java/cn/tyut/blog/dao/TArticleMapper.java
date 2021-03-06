package cn.tyut.blog.dao;

import cn.tyut.blog.pojo.TArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int deleteByPrimaryKey(Integer articleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int insert(TArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int insertSelective(TArticle record);

    List<TArticle> getArticleListByTag(String tagname);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    TArticle selectByPrimaryKey(Integer articleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int updateByPrimaryKeySelective(TArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(TArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int updateByPrimaryKey(TArticle record);


    List<TArticle> findByUserId(Integer userId);

    List<TArticle> getArticleListDESC(Integer limit);

    List<TArticle> getHotArticleListDESC(Integer limit);

    // 模糊查询
    List<TArticle> searchArticleList(@Param("articleName") String articleName);

    int getArticleId(@Param("createTime") Long createTime,@Param("userId") int userId);

    int addGoodNum(Integer articleid);

    int subGoodNum(Integer articleid);

    int deleteBlog(Integer articleid);

    int countUserArticleNum(Integer userid);

    int countUserGoodNum(Integer userid);
}