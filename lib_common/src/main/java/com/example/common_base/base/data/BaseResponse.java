package com.example.common_base.base.data;

/**
 * Description:请求数据返回的数据 统一包装
 */
public class BaseResponse<T> {

    /**
     * 0 代表执行成功，不建议依赖任何非0的 errorCode.
     *  -1001 代表登录失效，需要重新登录。
     */
    private int errorCode = -1;
    private String errorMsg;
    private T data;

    /**
     * gank.io
     */
    private T results;
    private boolean error = true;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                ", results=" + results +
                '}';
    }
}
