package com.youyouxing.entity;

public class Order {
    
    private String orderNumber;

    private String orderStatus;

    private String customerIDCard;

    private String roomNumber;

    private String checkInTime;

    private String checkOutTime;

    private String orderTime;

    private String waiterID;

    private int totalMoney;

    private String remarks;

    public Order() {

    }

    public Order(String orderNumber,
                 String orderStatus,
                 String customerIDCard,
                 String roomNumber,
                 String checkInTime,
                 String checkOutTime,
                 int totalMoney,String waiterID
            ,String remarks,String orderTime) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.customerIDCard = customerIDCard;
        this.roomNumber = roomNumber;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.totalMoney = totalMoney;
        this.waiterID =waiterID ;
        this.remarks = remarks;
        this.orderTime =orderTime ;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setWaiterID(String waiterID) {
        this.waiterID = waiterID;
    }

    public String getWaiterID() {
        return waiterID;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerIDCard() {
        return customerIDCard;
    }

    public void setCustomerIDCard(String customerIDCard) {
        this.customerIDCard = customerIDCard;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerIDCard='" + customerIDCard + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", orderTime=" + orderTime +
                ", waiterID='" + waiterID + '\'' +
                ", totalMoney=" + totalMoney +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}