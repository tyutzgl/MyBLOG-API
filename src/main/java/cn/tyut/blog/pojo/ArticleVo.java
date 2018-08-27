package cn.tyut.blog.pojo;

/**
 * @author zhangguoliang
 * @date 2018-06-03 17:07
 */
public class ArticleVo {

    private String articlename;
    private String tag;
    private String tag_comment;
    private String description;
    private String content;

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleVo{" +
                "articlename='" + articlename + '\'' +
                ", tag='" + tag + '\'' +
                ", tag_comment='" + tag_comment + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
