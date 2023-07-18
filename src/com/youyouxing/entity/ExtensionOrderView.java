package com.youyouxing.entity;

public class ExtensionOrderView {

    private String orderNumber;

    private String customer;

    private String roomNumber;

    private String customerPhoneNumber;

    private String checkInTime;

    private String oldDate;

    private String newDate;

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
    public int getAddedMoney() {
        return addedMoney;
    }

    public void setAddedMoney(int addedMoney) {
        this.addedMoney = addedMoney;
    }

    private int addedMoney;

    public ExtensionOrderView() {

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getOldDate() {
        return oldDate;
    }

    public void setOldDate(String oldDate) {
        this.oldDate = oldDate;
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    @Override
    public String toString() {
        return this.orderNumber + " " +
                this.customer + " " +
        this.roomNumber + " " +
        this.customerPhoneNumber + " " +
        this.checkInTime + " " +
        this.oldDate.toString() + " " +
        this.newDate.toString();
    }
}
