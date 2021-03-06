package cn.tyut.blog.dao;

import cn.tyut.blog.pojo.TTags;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TTagsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int deleteByPrimaryKey(Integer tagid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int insert(TTags record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int insertSelective(TTags record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    TTags selectByPrimaryKey(Integer tagid);

    List<TTags> selectTagsNameList();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int updateByPrimaryKeySelective(TTags record);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tags
     *
     * @mbggenerated Mon Mar 26 14:01:12 CST 2018
     */
    int updateByPrimaryKey(TTags record);

    int selectTagsNum(String tagName);

    int selectTagId(String tagName);
}