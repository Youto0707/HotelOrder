package com.youyouxing.entity;

public class TimeExtension {
    
    private int operatingID;

    private String orderNumber;

    private String oldExpiryDate;

    private String newExpiryDate;

    private int addedMoney;

    public TimeExtension() {

    }

    public TimeExtension(int id , String orderNumber,
                         String oldExpiryDate,
                         String newExpiryDate,
                         int addedMoney) {
        this.orderNumber = orderNumber;
        this.oldExpiryDate = oldExpiryDate;
        this.newExpiryDate = newExpiryDate;
        this.addedMoney = addedMoney;
        this.operatingID =id ;
    }

    public int getOperatingID() {
        return operatingID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOldExpiryDate() {
        return oldExpiryDate;
    }

    public void setOldExpiryDate(String oldExpiryDate) {
        this.oldExpiryDate = oldExpiryDate;
    }

    public String getNewExpiryDate() {
        return newExpiryDate;
    }

    public void setNewExpiryDate(String newExpiryDate) {
        this.newExpiryDate = newExpiryDate;
    }

    public int getAddedMoney() {
        return addedMoney;
    }

    public void setAddedMoney(int addedMoney) {
        this.addedMoney = addedMoney;
    }
}