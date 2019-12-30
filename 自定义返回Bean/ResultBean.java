package org.sang.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ztc
 * @create 2019/12/30
 */
public class ResultBean implements Serializable {
    private static final long serialVersionUID = -5285032058479776032L;
    public static final int ERROR_ACCESS_TOKEN = 50008;
    public static final int ERROR_OTHER_TERMINAL = 50012;
    public static final int ERROR_TOKEN_EXPIRE = 50014;
    private boolean success = true;
    private int errcode = 0;
    private String message = "";
    private Object data = null;

    public static ResultBean success() {
        return new ResultBean();
    }

    public static ResultBean success(String message) {
        return new ResultBean(true, message);
    }

    public static ResultBean success(String message, Object data) {
        return new ResultBean(true, message, data);
    }

    public static ResultBean failure(String message) {
        return new ResultBean(false, message, -1, (Object)null);
    }

    public static ResultBean failure(String message, Object data) {
        return new ResultBean(false, message, -1, data);
    }

    public static ResultBean failure(String message, int errcode, Object data) {
        return new ResultBean(false, message, errcode, data);
    }

    protected ResultBean() {
        this.success = true;
    }

    protected ResultBean(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    protected ResultBean(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    protected ResultBean(boolean success, String message, int errcode, Object data) {
        this.success = success;
        this.message = message;
        this.errcode = errcode;
        this.data = data;
    }

    public ResultBean createMapData() {
        return this.createMapData((Map)null);
    }

    public ResultBean createMapData(Map<String, Object> data) {
        this.data = new HashMap();
        if (data != null) {
            ((HashMap)this.data).putAll(data);
        }

        return this;
    }

    public ResultBean put(Map<String, Object> data) {
        assert this.data instanceof HashMap;

        ((HashMap)this.data).putAll(data);
        return this;
    }

    public ResultBean put(String key, Object value) {
        assert this.data instanceof HashMap;

        ((HashMap)this.data).put(key, value);
        return this;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public int getErrcode() {
        return this.errcode;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResultBean)) {
            return false;
        } else {
            ResultBean other = (ResultBean)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else if (this.getErrcode() != other.getErrcode()) {
                return false;
            } else {
                label40: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label40;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label40;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResultBean;
    }

    @Override
    public String toString() {
        return "ResultBean(success=" + this.isSuccess() + ", errcode=" + this.getErrcode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}

