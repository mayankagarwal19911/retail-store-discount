package com.app.store.retail.discounts.app.service;

import com.app.store.retail.discounts.app.model.Discount;

public
interface DiscountBasedOnCustomerService {
    double getDiscountBasedOnUsertype(Discount discount);

}
