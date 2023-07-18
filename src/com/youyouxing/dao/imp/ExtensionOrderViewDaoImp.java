package com.youyouxing.dao.imp;

import com.youyouxing.dao.ExtensionOrderViewDao;
import com.youyouxing.entity.ExtensionOrderView;
import com.youyouxing.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExtensionOrderViewDaoImp implements ExtensionOrderViewDao {
    @Override
    public ArrayList<ExtensionOrderView> getAllTimeExtensionOrders() {
        ArrayList<ExtensionOrderView> allTimeExtensionOrders = new ArrayList<ExtensionOrderView>() ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection =  GetConn.getDruidConn();
            preparedStatement = connection.prepareStatement("SELECT * FROM timeExtensionOrdersView");
            //获取结果数据集
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ExtensionOrderView extensionOrderView = new ExtensionOrderView();
                extensionOrderView.setOrderNumber(resultSet.getString("orderNumber"));
                extensionOrderView.setCustomer(resultSet.getString("customerName"));
                extensionOrderView.setRoomNumber(resultSet.getString("roomNumber"));
                extensionOrderView.setOldDate(resultSet.getString("oldExpiryDate"));
                extensionOrderView.setNewDate(resultSet.getString("newExpiryDate"));
                extensionOrderView.setAddedMoney(resultSet.getInt("addedMoney"));
                extensionOrderView.setCustomerPhoneNumber(resultSet.getString("customerPhoneNumber"));
                extensionOrderView.setCheckInTime(resultSet.getString("checkInTime"));
                allTimeExtensionOrders.add(extensionOrderView);
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return allTimeExtensionOrders;
    }
}
