package top.smartpos.blog.enums;

/**
 * 前端收到异常通知，枚举类
 */
public enum ResultEnum {
    UNKOWN_ERROR(-1, "unkow error"),
    SUCCESS(0, "success"),
    UNFOUND(20, "没有找到请求内容"),
    BAOLI_VIP_VALIDATE_ERROR(20, "保利查询会员3个参数必传一个"),
    //controller 验证时，此message信息已被更改特定内容
    PARAM_VALIDATE_ERROR(100, "param validate error");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
