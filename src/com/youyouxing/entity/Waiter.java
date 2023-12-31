package com.youyouxing.entity;

public class Waiter {
    
    private String waiterID;

    private String waiterName;

    private String waiterBirthday;

    private String waiterIDCard;

    private String waiterPassword;

    private String waiterJoinDate;

    private String waiterPhoneNumber;

    private String remarks;

    public Waiter() {

    }

    public Waiter(String waiterID,
                  String waiterName,
                  String waiterBirthday,
                  String waiterIDCard,
                  String waiterPassword,
                  String waiterJoinDate,
                  String waiterPhoneNumber,
                  String remarks) {
        this.waiterID = waiterID;
        this.waiterName = waiterName;
        this.waiterBirthday = waiterBirthday;
        this.waiterIDCard = waiterIDCard;
        this.waiterPassword = waiterPassword;
        this.waiterJoinDate = waiterJoinDate;
        this.waiterPhoneNumber = waiterPhoneNumber;
        this.remarks = remarks;
    }

    public String getWaiterID() {
        return waiterID;
    }

    public void setWaiterID(String waiterID) {
        this.waiterID = waiterID;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getWaiterBirthday() {
        return waiterBirthday;
    }

    public void setWaiterBirthday(String waiterBirthday) {
        this.waiterBirthday = waiterBirthday;
    }

    public String getWaiterIDCard() {
        return waiterIDCard;
    }

    public void setWaiterIDCard(String waiterIDCard) {
        this.waiterIDCard = waiterIDCard;
    }

    public String getWaiterPassword() {
        return waiterPassword;
    }

    public void setWaiterPassword(String waiterPassword) {
        this.waiterPassword = waiterPassword;
    }

    public String getWaiterJoinDate() {
        return waiterJoinDate;
    }

    public void setWaiterJoinDate(String waiterJoinDate) {
        this.waiterJoinDate = waiterJoinDate;
    }

    public String getWaiterPhoneNumber() {
        return waiterPhoneNumber;
    }

    public void setWaiterPhoneNumber(String waiterPhoneNumber) {
        this.waiterPhoneNumber = waiterPhoneNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "waiterID='" + waiterID + '\'' +
                ", waiterName='" + waiterName + '\'' +
                ", waiterBirthday=" + waiterBirthday +
                ", waiterIDCard='" + waiterIDCard + '\'' +
                ", waiterPassword='" + waiterPassword + '\'' +
                ", waiterJoinDate=" + waiterJoinDate +
                ", waiterPhoneNumber='" + waiterPhoneNumber + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}