package cn.tyut.blog.pojo;

public class TArticle {

    private Integer articleid;
    private String articlename;
    private Integer userid;
    private String description;
    private String tag;
    private String tag_comment;
    private Long createtime;
    private Long updatetime;
    private Integer visitcount;
    private Integer goodnum;
    private String content;
    private String userName;

    public Integer getArticleid() {
        return articleid;
    }


    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }


    public String getArticlename() {
        return articlename;
    }


    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }


    public Integer getUserid() {
        return userid;
    }


    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }


    public Long getUpdatetime() {
        return updatetime;
    }


    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }


    public Integer getVisitcount() {
        return visitcount;
    }


    public void setVisitcount(Integer visitcount) {
        this.visitcount = visitcount;
    }


    public Integer getGoodnum() {
        return goodnum;
    }


    public void setGoodnum(Integer goodnum) {
        this.goodnum = goodnum;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag_comment() {
        return tag_comment;
    }

    public void setTag_comment(String tag_comment) {
        this.tag_comment = tag_comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "TArticle{" +
                "articleid=" + articleid +
                ", articlename='" + articlename + '\'' +
                ", userid=" + userid +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", tag_comment='" + tag_comment + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", visitcount=" + visitcount +
                ", goodnum=" + goodnum +
                ", content='" + content + '\'' +
                '}';
    }
}