package com.xebia.app.store.retail.discounts.app.service;

import com.xebia.app.store.retail.discounts.app.model.Discount;

public
interface DiscountBasedOnCustomerService {
    double getDiscountBasedOnUsertype(Discount discount);

}
