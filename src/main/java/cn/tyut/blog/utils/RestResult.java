package cn.tyut.blog.utils;

/**
 * @author zhangguoliang
 * @date 2018-03-27 9:25
 */
public class RestResult {

    private Integer statusCode;
    private String msg;
    private Object data;

    public RestResult() {
    }

    public RestResult(Integer statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public RestResult(Integer statusCode, String msg, Object data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
