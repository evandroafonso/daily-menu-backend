package com.daily.menu.entity.baseEntity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String uuid = UUID.randomUUID().toString();

    @CreationTimestamp
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inclusionDate;

    @CreationTimestamp
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;

    private Long idUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Date inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

}