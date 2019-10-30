package com.xebia.app.store.retail.discounts.app.serviceimpl;

import com.xebia.app.store.retail.discounts.app.common.RetailStoreDiscountConstants;
import com.xebia.app.store.retail.discounts.app.model.Discount;
import com.xebia.app.store.retail.discounts.app.service.DiscountBasedOnCustomerService;
import com.xebia.app.store.retail.discounts.app.utils.PropertyUtils;

public
class DiscountBasedOnCustomerServiceImpl implements DiscountBasedOnCustomerService {

    private static int employeeUserDiscount = Integer.parseInt ( PropertyUtils.getProperty("user.employee.discount") );
    private static int affiliateUserDiscount = Integer.parseInt(PropertyUtils.getProperty("user.affiliate.discount"));

    @Override
    public
    double getDiscountBasedOnUsertype (Discount discount) {
        if(null != discount.getCustomerType () && discount.getCustomerType ().equalsIgnoreCase ( RetailStoreDiscountConstants.customerEmployee ))return employeeUserDiscount;
        else if (null != discount.getCustomerType () && discount.getCustomerType ().equalsIgnoreCase ( RetailStoreDiscountConstants.customerAffiliate )) return affiliateUserDiscount;
        else return 0;
    }
}
