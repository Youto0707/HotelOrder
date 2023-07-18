package com.youyouxing.dao;

import com.youyouxing.entity.ExtensionOrderView;

import java.util.ArrayList;

public interface ExtensionOrderViewDao {
    //查询续费订单(timeextension tt, orders od, customers ct)
    ArrayList<ExtensionOrderView> getAllTimeExtensionOrders();
}
