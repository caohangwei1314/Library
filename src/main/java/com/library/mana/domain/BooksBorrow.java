package com.library.mana.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class BooksBorrow implements Serializable {
    /**
     * 借阅id
     */
    private Integer pkId;

    /**
     * 图书id
     */
    private Integer booksId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 借书日期
     */
    private Date gmtCreate;

    /**
     * 归还日期
     */
    private Date gmtReturn;

    /**
     * 罚款金额
     */
    private BigDecimal fine;

    private Date actualReturn;

    private Integer isReturn;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final long serialVersionUID = 1L;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer booksId) {
        this.booksId = booksId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtReturn() {
        return gmtReturn;
    }

    public void setGmtReturn(Date gmtReturn) {
        this.gmtReturn = gmtReturn;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public Date getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(Date actualReturn) {
        this.actualReturn = actualReturn;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BooksBorrow other = (BooksBorrow) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getBooksId() == null ? other.getBooksId() == null : this.getBooksId().equals(other.getBooksId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtReturn() == null ? other.getGmtReturn() == null : this.getGmtReturn().equals(other.getGmtReturn()))
            && (this.getFine() == null ? other.getFine() == null : this.getFine().equals(other.getFine()))
            && (this.getActualReturn() == null ? other.getActualReturn() == null : this.getActualReturn().equals(other.getActualReturn()))
            && (this.getIsReturn() == null ? other.getIsReturn() == null : this.getIsReturn().equals(other.getIsReturn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getBooksId() == null) ? 0 : getBooksId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtReturn() == null) ? 0 : getGmtReturn().hashCode());
        result = prime * result + ((getFine() == null) ? 0 : getFine().hashCode());
        result = prime * result + ((getActualReturn() == null) ? 0 : getActualReturn().hashCode());
        result = prime * result + ((getIsReturn() == null) ? 0 : getIsReturn().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", booksId=").append(booksId);
        sb.append(", userId=").append(userId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtReturn=").append(gmtReturn);
        sb.append(", fine=").append(fine);
        sb.append(", actualReturn=").append(actualReturn);
        sb.append(", isReturn=").append(isReturn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}