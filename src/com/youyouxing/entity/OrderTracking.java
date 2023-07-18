package com.youyouxing.entity;

public class OrderTracking {

    private String orderNumber;

    private String orderTime;

    private String checkInTime;

    private String checkOutTime;

    private String remarks;

    public OrderTracking() {

    }

    public OrderTracking(String orderNumber,
                         String orderTime,
                         String checkInTime,
                         String checkOutTime,
                 String remarks) {
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.remarks = remarks;

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
