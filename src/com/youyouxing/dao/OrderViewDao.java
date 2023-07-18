package com.youyouxing.dao;

import com.youyouxing.entity.OrderView;

import java.util.ArrayList;

public interface OrderViewDao {
    OrderView getFullOrderViews(String roomid);
    ArrayList<OrderView> getAllOrderViews(String orderStatus);
}
