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
@Table(name = "refdata_platformparamstodataattributes", schema = "datasynthesis", catalog = "")
public class RefDataPlatformParamsToDataAttributesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long platformParamsToDataAttributeId;
    private RefDataPlatformParamsEntity platformParams;
    private PlatformDataAttributesEntity dataAttribute;
    private Timestamp createdDate;
    private RefDataStatusEntity status;
    private RefDataApplicationEntity registeredApp;

    @Id
    @GeneratedValue
    @Column(name = "PlatformParamsToDataAttributeID", nullable = false)
    public long getPlatformParamsToDataAttributeId() {
        return platformParamsToDataAttributeId;
    }

    public void setPlatformParamsToDataAttributeId(long platformParamsToDataAttributeId) {
        this.platformParamsToDataAttributeId = platformParamsToDataAttributeId;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefDataPlatformParamsToDataAttributesEntity that = (RefDataPlatformParamsToDataAttributesEntity) o;

        if (platformParamsToDataAttributeId != that.platformParamsToDataAttributeId) return false;
        if (platformParams != null ? !platformParams.equals(that.platformParams) : that.platformParams != null)
            return false;
        if (dataAttribute != null ? !dataAttribute.equals(that.dataAttribute) : that.dataAttribute != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (platformParamsToDataAttributeId ^ (platformParamsToDataAttributeId >>> 32));
        result = 31 * result + (platformParams != null ? platformParams.hashCode() : 0);
        result = 31 * result + (dataAttribute != null ? dataAttribute.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PlatformParamsID", referencedColumnName = "PlatformParamsID")
    public RefDataPlatformParamsEntity getPlatformParams() {
        return platformParams;
    }

    public void setPlatformParams(RefDataPlatformParamsEntity platformParamsId) {
        this.platformParams = platformParamsId;
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
    @JoinColumn(name = "RegisteredApp", referencedColumnName = "AppGUID")
    public RefDataApplicationEntity getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(RefDataApplicationEntity registeredApp) {
        this.registeredApp = registeredApp;
    }

    public static List<RefDataPlatformParamsToDataAttributesEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}