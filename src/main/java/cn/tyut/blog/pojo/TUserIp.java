package cn.tyut.blog.pojo;

public class TUserIp {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_ip.userId
     *
     * @mbggenerated Wed Apr 11 17:39:04 CST 2018
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_ip.lastIp
     *
     * @mbggenerated Wed Apr 11 17:39:04 CST 2018
     */
    private String lastip;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_ip.userId
     *
     * @return the value of t_user_ip.userId
     *
     * @mbggenerated Wed Apr 11 17:39:04 CST 2018
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_ip.userId
     *
     * @param userid the value for t_user_ip.userId
     *
     * @mbggenerated Wed Apr 11 17:39:04 CST 2018
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_ip.lastIp
     *
     * @return the value of t_user_ip.lastIp
     *
     * @mbggenerated Wed Apr 11 17:39:04 CST 2018
     */
    public String getLastip() {
        return lastip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_ip.lastIp
     *
     * @param lastip the value for t_user_ip.lastIp
     *
     * @mbggenerated Wed Apr 11 17:39:04 CST 2018
     */
    public void setLastip(String lastip) {
        this.lastip = lastip;
    }
}