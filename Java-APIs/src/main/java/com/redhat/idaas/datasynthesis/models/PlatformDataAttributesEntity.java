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
@Table(name = "platform_dataattributes", schema = "datasynthesis", catalog = "")
public class PlatformDataAttributesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short platformDataAttributesId;
    private String dataAttributeName;
    private Timestamp createdDate;
    private String createdUser;
    private String platformDataAttributeGuid;
    private RefDataStatusEntity status;
    private RefDataApplicationEntity registeredApp;
    private RefDataSensitivityFlagEntity sensitivityFlag;

    @Id
    @GeneratedValue
    @Column(name = "PlatformDataAttributesID", nullable = false)
    public short getPlatformDataAttributesId() {
        return platformDataAttributesId;
    }

    public void setPlatformDataAttributesId(short platformDataAttributesId) {
        this.platformDataAttributesId = platformDataAttributesId;
    }

    @Basic
    @Column(name = "DataAttributeName", nullable = true, length = 50)
    public String getDataAttributeName() {
        return dataAttributeName;
    }

    public void setDataAttributeName(String dataAttributeName) {
        this.dataAttributeName = dataAttributeName;
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

    @Basic
    @Column(name = "PlatformDataAttributeGUID", nullable = true, length = 38)
    public String getPlatformDataAttributeGuid() {
        return platformDataAttributeGuid;
    }

    public void setPlatformDataAttributeGuid(String platformDataAttributeGuid) {
        this.platformDataAttributeGuid = platformDataAttributeGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformDataAttributesEntity that = (PlatformDataAttributesEntity) o;

        if (platformDataAttributesId != that.platformDataAttributesId) return false;
        if (dataAttributeName != null ? !dataAttributeName.equals(that.dataAttributeName) : that.dataAttributeName != null)
            return false;
        if (sensitivityFlag != null ? !sensitivityFlag.equals(that.sensitivityFlag) : that.sensitivityFlag != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (platformDataAttributeGuid != null ? !platformDataAttributeGuid.equals(that.platformDataAttributeGuid) : that.platformDataAttributeGuid != null)
            return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) platformDataAttributesId;
        result = 31 * result + (dataAttributeName != null ? dataAttributeName.hashCode() : 0);
        result = 31 * result + (sensitivityFlag != null ? sensitivityFlag.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (platformDataAttributeGuid != null ? platformDataAttributeGuid.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SensitivityFlagID", referencedColumnName = "SensitiveFlagID")
    public RefDataSensitivityFlagEntity getSensitivityFlag() {
        return sensitivityFlag;
    }

    public void setSensitivityFlag(RefDataSensitivityFlagEntity sensitivityFlag) {
        this.sensitivityFlag = sensitivityFlag;
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
    @JoinColumn(name = "RegisteredApp", referencedColumnName = "AppGUID")
    public RefDataApplicationEntity getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(RefDataApplicationEntity registeredApp) {
        this.registeredApp = registeredApp;
    }

    public static List<PlatformDataAttributesEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}