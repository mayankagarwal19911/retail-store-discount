package com.xebia.app.store.retail.discounts.app.serviceimpl;

import com.xebia.app.store.retail.discounts.app.model.Discount;
import com.xebia.app.store.retail.discounts.app.service.DiscountBasedOnMinimumSaleService;
import com.xebia.app.store.retail.discounts.app.utils.PropertyUtils;

public
class DiscountBasedOnMinimumSaleServiceImpl implements DiscountBasedOnMinimumSaleService {

    private static int discountAfterMinimumSale = Integer.parseInt(PropertyUtils.getProperty("incremental.discount"));
    private static int minimumSaleForDiscount = Integer.parseInt(PropertyUtils.getProperty("minimum.sale.for.discount"));

    @Override
    public
    double getDiscountOnMinimumPredefinedAmount (Discount discount) {
        return Math.floor ( (discount.getShoppingAmount () / minimumSaleForDiscount) * discountAfterMinimumSale );
    }
}