package cn.tyut.blog.utils;

/**
 * @author zhangguoliang
 * @date 2018-04-25 16:52
 */
public class RegForm {
    private String email;
    private String username;
    private String psw1;
    private String psw2;
    private String address;
    private Integer age;
    private String sex;
    private String introduce;

    /**
     *
     * @param email
     * @param username
     * @param psw1
     * @param psw2
     * @param address
     * @param age
     * @param sex
     * @param introduce
     */
    public RegForm(String email, String username, String psw1, String psw2, String address, Integer age, String sex, String introduce) {
        this.email = email;
        this.username = username;
        this.psw1 = psw1;
        this.psw2 = psw2;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.introduce = introduce;
    }

    public RegForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw1() {
        return psw1;
    }

    public void setPsw1(String psw1) {
        this.psw1 = psw1;
    }

    public String getPsw2() {
        return psw2;
    }

    public void setPsw2(String psw2) {
        this.psw2 = psw2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "RegForm{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", psw1='" + psw1 + '\'' +
                ", psw2='" + psw2 + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
