package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;

@Entity
public class Bank extends BaseEntity {

    private String bankName;

    private String accountId;

    private String fundingSourceUrl;

    private String shareableId;

    private String userId;

}
