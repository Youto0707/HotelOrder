package com.youyouxing.dao;

import com.youyouxing.entity.Customer;

public interface CustomerDao {
    boolean  addCustomer(Customer cu);
    boolean isIDexists(String id );
    int searchVIPlevel(String id);
}
