package com.app.store.retail.discounts.app.serviceimpl;

import com.app.store.retail.discounts.app.model.Discount;
import com.app.store.retail.discounts.app.service.DiscountBasedOnMinimumSaleService;
import com.app.store.retail.discounts.app.utils.PropertyUtils;

public
class DiscountBasedOnMinimumSaleServiceImpl implements DiscountBasedOnMinimumSaleService {

    private static int discountAfterMinimumSale = Integer.parseInt(PropertyUtils.getProperty("incremental.discount"));
    private static int minimumSaleForDiscount = Integer.parseInt(PropertyUtils.getProperty("minimum.sale.for.discount"));

    @Override
    public
    double getDiscountOnMinimumPredefinedAmount (Discount discount) {
        return (discount.getShoppingAmount () / minimumSaleForDiscount) * discountAfterMinimumSale;
    }
}