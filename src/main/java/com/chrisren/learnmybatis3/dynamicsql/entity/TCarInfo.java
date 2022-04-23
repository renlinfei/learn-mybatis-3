package com.chrisren.learnmybatis3.dynamicsql.entity;

import java.util.Date;
import javax.annotation.Generated;

public class TCarInfo {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String carNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String carName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String createdBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createdDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String updatedBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updatedDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCarNo() {
        return carNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCarName() {
        return carName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCreatedBy() {
        return createdBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreatedDate() {
        return createdDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdatedDate() {
        return updatedDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
        TCarInfo other = (TCarInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCarNo() == null ? other.getCarNo() == null : this.getCarNo().equals(other.getCarNo()))
            && (this.getCarName() == null ? other.getCarName() == null : this.getCarName().equals(other.getCarName()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedDate() == null ? other.getCreatedDate() == null : this.getCreatedDate().equals(other.getCreatedDate()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()))
            && (this.getUpdatedDate() == null ? other.getUpdatedDate() == null : this.getUpdatedDate().equals(other.getUpdatedDate()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCarNo() == null) ? 0 : getCarNo().hashCode());
        result = prime * result + ((getCarName() == null) ? 0 : getCarName().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedDate() == null) ? 0 : getCreatedDate().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getUpdatedDate() == null) ? 0 : getUpdatedDate().hashCode());
        return result;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carNo=").append(carNo);
        sb.append(", carName=").append(carName);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append("]");
        return sb.toString();
    }
}