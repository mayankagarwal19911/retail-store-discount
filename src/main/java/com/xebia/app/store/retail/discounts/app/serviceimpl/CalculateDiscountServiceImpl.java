package com.xebia.app.store.retail.discounts.app.serviceimpl;

import com.xebia.app.store.retail.discounts.app.common.RetailStoreDiscountException;
import com.xebia.app.store.retail.discounts.app.model.Discount;
import com.xebia.app.store.retail.discounts.app.service.CalculateAmountPayableService;
import com.xebia.app.store.retail.discounts.app.service.DiscountBasedOnCustomerService;
import com.xebia.app.store.retail.discounts.app.service.DiscountBasedOnMinimumSaleService;
import com.xebia.app.store.retail.discounts.app.service.DiscountBasedOnUserBeingOldCustomerService;
import com.xebia.app.store.retail.discounts.app.utils.PropertyUtils;

import java.util.Arrays;
import java.util.Collections;

public
class CalculateDiscountServiceImpl implements CalculateAmountPayableService {

    private static int userSinceYears = Integer.parseInt ( PropertyUtils.getProperty ( "user.since" ) );

    private DiscountBasedOnCustomerService discountBasedOnCustomerService;
    private DiscountBasedOnMinimumSaleService discountBasedOnMinimumSaleService;
    private DiscountBasedOnUserBeingOldCustomerService discountBasedOnUserBeingOldCustomerService;

    public
    CalculateDiscountServiceImpl (DiscountBasedOnCustomerService discountBasedOnCustomerService ,
            DiscountBasedOnMinimumSaleService discountBasedOnMinimumSale ,
            DiscountBasedOnUserBeingOldCustomerService discountBasedOnUserBeingOldCustomer
    ) {
        this.discountBasedOnCustomerService = discountBasedOnCustomerService;
        this.discountBasedOnMinimumSaleService = discountBasedOnMinimumSale;
        this.discountBasedOnUserBeingOldCustomerService = discountBasedOnUserBeingOldCustomer;
    }

    @Override
    public
    double calculatePayableAmountForUser (Discount discount) throws RetailStoreDiscountException {
        if (!discount.getIfItemTypeIsGrocery ( )) {
            double totalDiscountedAmount = 0;
            double discountForOldCustomer = 0;

            // for old users
            if (discount.getUserOld ( ) >= userSinceYears) {
                discountForOldCustomer = (discount.getShoppingAmount ( ) * discountBasedOnUserBeingOldCustomerService.getDiscountForOldUsers (discount.getUserOldDiscount () )) / 100;
            }

            // get discount based on purchase
            double discountBasedOnPurchase = discountBasedOnMinimumSaleService.getDiscountOnMinimumPredefinedAmount ( discount );

            // discount based on user type
            double discountBasedOnUser = (discount.getShoppingAmount ( ) * discountBasedOnCustomerService.getDiscountBasedOnUsertype ( discount )) / 100;

            // getting max discount out of all
            totalDiscountedAmount = Collections.max ( Arrays.asList ( discountBasedOnUser , discountForOldCustomer , discountBasedOnPurchase ) );

            // return net payable amount
            return discount.getShoppingAmount ( ) - totalDiscountedAmount;
        }
       return discount.getShoppingAmount ( );
    }
}
