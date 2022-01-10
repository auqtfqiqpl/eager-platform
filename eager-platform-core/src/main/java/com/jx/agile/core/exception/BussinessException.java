package com.jx.agile.core.exception;

/**
 * 业务异常
 */
public class BussinessException extends  RuntimeException {

    private Integer status;

    public BussinessException(Integer status,String message) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BussinessException)) return false;
        final BussinessException other = (BussinessException) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BussinessException;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "BussinessException(status=" + this.getStatus() + ")";
    }
}
