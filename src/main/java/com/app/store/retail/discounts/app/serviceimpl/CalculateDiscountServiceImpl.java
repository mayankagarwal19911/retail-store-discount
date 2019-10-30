package com.app.store.retail.discounts.app.serviceimpl;

import com.app.store.retail.discounts.app.common.RetailStoreDiscountException;
import com.app.store.retail.discounts.app.model.Discount;
import com.app.store.retail.discounts.app.service.CalculateAmountPayableService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnCustomerService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnMinimumSaleService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnUserBeingOldCustomerService;
import com.app.store.retail.discounts.app.utils.PropertyUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

public
class CalculateDiscountServiceImpl implements CalculateAmountPayableService {

    private final static java.util.logging.Logger LOGGER  = java.util.logging.Logger.getLogger( Logger.GLOBAL_LOGGER_NAME);

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
            LOGGER.info ( "Discount for users being old customer is "+discountForOldCustomer +" $");

            // get discount based on purchase
            double discountBasedOnPurchase = discountBasedOnMinimumSaleService.getDiscountOnMinimumPredefinedAmount ( discount );
            LOGGER.info ( "Total discount for user made shopping of "+discount.getShoppingAmount ()+" is " +discountBasedOnPurchase +" $" );

            // discount based on user type
            double discountBasedOnUser = (discount.getShoppingAmount ( ) * discountBasedOnCustomerService.getDiscountBasedOnUsertype ( discount )) / 100;
            LOGGER.info ( "Discount for user type "+discount.getCustomerType ()+" is " +discountBasedOnUser +" $" );

            // getting max discount out of all
            totalDiscountedAmount = Collections.max ( Arrays.asList ( discountBasedOnUser , discountForOldCustomer , discountBasedOnPurchase ) );
            LOGGER.info ( "Maximum discount offered is " + totalDiscountedAmount + " $");

            // return net payable amount
            return discount.getShoppingAmount ( ) - totalDiscountedAmount;
        }
       return discount.getShoppingAmount ( );
    }
}
