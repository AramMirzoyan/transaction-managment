package com.transaction.model.trasnaction.dto.response;

public class SuccessResponse<T> {
    private boolean success;
    private T content;

    public SuccessResponse(final boolean success) {
        this.success = success;
    }

    public SuccessResponse( boolean success,  T content) {
        this.success = success;
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
