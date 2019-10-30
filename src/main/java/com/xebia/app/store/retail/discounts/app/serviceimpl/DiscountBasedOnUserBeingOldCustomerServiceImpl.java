package com.xebia.app.store.retail.discounts.app.serviceimpl;

import com.xebia.app.store.retail.discounts.app.service.DiscountBasedOnUserBeingOldCustomerService;
import com.xebia.app.store.retail.discounts.app.utils.PropertyUtils;

public
class DiscountBasedOnUserBeingOldCustomerServiceImpl implements DiscountBasedOnUserBeingOldCustomerService {

    private static int oldUsersDiscount = Integer.parseInt( PropertyUtils.getProperty("user.old.discount"));

    @Override
    public
    double getDiscountForOldUsers (int discountForOldCustomers ) {
        if(0 != discountForOldCustomers) return discountForOldCustomers;
        else return oldUsersDiscount;
    }
}
