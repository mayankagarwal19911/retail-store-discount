package com.app.store.retail.discounts.app.service;

import com.app.store.retail.discounts.app.common.RetailStoreDiscountException;
import com.app.store.retail.discounts.app.model.Discount;

public
interface CalculateAmountPayableService {
    double calculatePayableAmountForUser(Discount discount) throws RetailStoreDiscountException;
}
