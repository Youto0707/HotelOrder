package com.youyouxing.dao;

import com.youyouxing.entity.TimeExtension;

public interface TimeExtensionDao {
    int getRenewNum();
    boolean  addRenew(TimeExtension renew);
}
