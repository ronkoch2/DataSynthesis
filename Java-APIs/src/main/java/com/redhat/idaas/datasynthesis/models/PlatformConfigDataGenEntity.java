package com.redhat.idaas.datasynthesis.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "platform_config_datagen", schema = "datasynthesis", catalog = "")
public class PlatformConfigDataGenEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short dataGenConfigId;
    private String dataTypeGenConfigName;
    private String specialInstructions;
    private Integer runQuantity;
    private Short minuteInterval;
    private Timestamp createdDate;
    private String createdUser;
    private RefDataStatusEntity status;
    private RefDataApplicationEntity application;
    private PlatformDataAttributesEntity dataAttribute;

    @Id
    @GeneratedValue
    @Column(name = "DataGenConfigID", nullable = false)
    public short getDataGenConfigId() {
        return dataGenConfigId;
    }

    public void setDataGenConfigId(short dataGenConfigId) {
        this.dataGenConfigId = dataGenConfigId;
    }

    @Basic
    @Column(name = "DataTypeGenConfigName", nullable = true, length = 25)
    public String getDataTypeGenConfigName() {
        return dataTypeGenConfigName;
    }

    public void setDataTypeGenConfigName(String dataTypeGenConfigName) {
        this.dataTypeGenConfigName = dataTypeGenConfigName;
    }

    @Basic
    @Column(name = "SpecialInstructions", nullable = true, length = 99)
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    @Basic
    @Column(name = "RunQuantity", nullable = true)
    public Integer getRunQuantity() {
        return runQuantity;
    }

    public void setRunQuantity(Integer runQuantity) {
        this.runQuantity = runQuantity;
    }

    @Basic
    @Column(name = "MinuteInterval", nullable = true)
    public Short getMinuteInterval() {
        return minuteInterval;
    }

    public void setMinuteInterval(Short minuteInterval) {
        this.minuteInterval = minuteInterval;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "CreatedUser", nullable = true, length = 20)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformConfigDataGenEntity that = (PlatformConfigDataGenEntity) o;

        if (dataGenConfigId != that.dataGenConfigId) return false;
        if (dataTypeGenConfigName != null ? !dataTypeGenConfigName.equals(that.dataTypeGenConfigName) : that.dataTypeGenConfigName != null)
            return false;
        if (dataAttribute != null ? !dataAttribute.equals(that.dataAttribute) : that.dataAttribute != null)
            return false;
        if (specialInstructions != null ? !specialInstructions.equals(that.specialInstructions) : that.specialInstructions != null)
            return false;
        if (runQuantity != null ? !runQuantity.equals(that.runQuantity) : that.runQuantity != null) return false;
        if (minuteInterval != null ? !minuteInterval.equals(that.minuteInterval) : that.minuteInterval != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) dataGenConfigId;
        result = 31 * result + (dataTypeGenConfigName != null ? dataTypeGenConfigName.hashCode() : 0);
        result = 31 * result + (dataAttribute != null ? dataAttribute.hashCode() : 0);
        result = 31 * result + (specialInstructions != null ? specialInstructions.hashCode() : 0);
        result = 31 * result + (runQuantity != null ? runQuantity.hashCode() : 0);
        result = 31 * result + (minuteInterval != null ? minuteInterval.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DataAttributeID", referencedColumnName = "PlatformDataAttributesID")
    public PlatformDataAttributesEntity getDataAttribute() {
        return dataAttribute;
    }

    public void setDataAttribute(PlatformDataAttributesEntity dataAttribute) {
        this.dataAttribute = dataAttribute;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getStatus() {
        return status;
    }

    public void setStatus(RefDataStatusEntity status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "ApplicationID", referencedColumnName = "AppGUID")
    public RefDataApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(RefDataApplicationEntity application) {
        this.application = application;
    }

    public static List<PlatformConfigDataGenEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}