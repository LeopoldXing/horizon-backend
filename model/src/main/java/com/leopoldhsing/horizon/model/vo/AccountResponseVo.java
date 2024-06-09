package com.leopoldhsing.horizon.model.vo;

import java.util.List;
import java.util.Objects;

public class AccountResponseVo {

    private String id;
    private String $id;
    private double availableBalance;
    private double currentBalance;
    private String officialName;
    private String mask;
    private String institutionId;
    private String name;
    private String type;
    private String subtype;
    private String shareableId;
    private List<TransactionResponseVo> transactionList;

    public AccountResponseVo() {
    }

    public AccountResponseVo(String id, String $id, double availableBalance, double currentBalance, String officialName, String mask, String institutionId, String name, String type, String subtype, String shareableId, List<TransactionResponseVo> transactionList) {
        this.id = id;
        this.$id = $id;
        this.availableBalance = availableBalance;
        this.currentBalance = currentBalance;
        this.officialName = officialName;
        this.mask = mask;
        this.institutionId = institutionId;
        this.name = name;
        this.type = type;
        this.subtype = subtype;
        this.shareableId = shareableId;
        this.transactionList = transactionList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getShareableId() {
        return shareableId;
    }

    public void setShareableId(String shareableId) {
        this.shareableId = shareableId;
    }

    public List<TransactionResponseVo> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<TransactionResponseVo> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountResponseVo that = (AccountResponseVo) o;
        return Double.compare(availableBalance, that.availableBalance) == 0 && Double.compare(currentBalance, that.currentBalance) == 0 && Objects.equals(id, that.id) && Objects.equals($id, that.$id) && Objects.equals(officialName, that.officialName) && Objects.equals(mask, that.mask) && Objects.equals(institutionId, that.institutionId) && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(subtype, that.subtype) && Objects.equals(shareableId, that.shareableId) && Objects.equals(transactionList, that.transactionList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode($id);
        result = 31 * result + Double.hashCode(availableBalance);
        result = 31 * result + Double.hashCode(currentBalance);
        result = 31 * result + Objects.hashCode(officialName);
        result = 31 * result + Objects.hashCode(mask);
        result = 31 * result + Objects.hashCode(institutionId);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(subtype);
        result = 31 * result + Objects.hashCode(shareableId);
        result = 31 * result + Objects.hashCode(transactionList);
        return result;
    }
}
