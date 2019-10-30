package com.app.store.retail.discounts.app.api;

import com.app.store.retail.discounts.app.common.RetailStoreDiscountException;
import com.app.store.retail.discounts.app.common.RetailStoreDiscountLogger;
import com.app.store.retail.discounts.app.model.Discount;
import com.app.store.retail.discounts.app.service.CalculateAmountPayableService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnCustomerService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnMinimumSaleService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnUserBeingOldCustomerService;
import com.app.store.retail.discounts.app.serviceimpl.CalculateDiscountServiceImpl;
import com.app.store.retail.discounts.app.serviceimpl.DiscountBasedOnCustomerServiceImpl;
import com.app.store.retail.discounts.app.serviceimpl.DiscountBasedOnMinimumSaleServiceImpl;
import com.app.store.retail.discounts.app.serviceimpl.DiscountBasedOnUserBeingOldCustomerServiceImpl;
import com.app.store.retail.discounts.app.utils.PropertyUtils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RetailStoreDiscount {


    /** The logger. */
    private final static Logger LOGGER  = java.util.logging.Logger.getLogger( Logger.GLOBAL_LOGGER_NAME);

    // configurations defined in properties file.

    private static String userTypeEmployee = PropertyUtils.getProperty("user.type.employee");
    private static String userTypeAffiliate = PropertyUtils.getProperty("user.type.affiliate");
    private static int shoppingAmount = Integer.parseInt(PropertyUtils.getProperty("user.shopping.amount"));
    private static boolean ifItemIsGrocery = Boolean.parseBoolean ( PropertyUtils.getProperty("item.type.if.grocery") );

    public static void main(String[] args) throws RetailStoreDiscountException {

        LOGGER.setLevel( Level.INFO);
        RetailStoreDiscount retailStoreDiscount = new RetailStoreDiscount();
        try {
            RetailStoreDiscountLogger.setup ();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        retailStoreDiscount.performApiCalls ();
    }

    private static
    void performApiCalls ( ) throws RetailStoreDiscountException {
        DiscountBasedOnCustomerService discountBasedOnCustomerService = new DiscountBasedOnCustomerServiceImpl ();
        DiscountBasedOnMinimumSaleService discountBasedOnMinimumSale = new DiscountBasedOnMinimumSaleServiceImpl ();
        DiscountBasedOnUserBeingOldCustomerService discountBasedOnUserBeingCustomer = new DiscountBasedOnUserBeingOldCustomerServiceImpl ();
        CalculateAmountPayableService calculateDiscount = new CalculateDiscountServiceImpl (discountBasedOnCustomerService, discountBasedOnMinimumSale, discountBasedOnUserBeingCustomer);

        Discount discountForEmployee = new Discount.Builder(shoppingAmount)
                .setCustomerType ( userTypeEmployee )
                .build ();
        double discountedPriceForUserEmployee = calculateDiscount.calculatePayableAmountForUser ( discountForEmployee );
        LOGGER.info ("Total Payable amount for Customer Type Employee " +
                "is "+discountedPriceForUserEmployee +" $" );

        Discount discountForAffiliate = new Discount.Builder(10)
                .setCustomerType ( userTypeAffiliate )
                .build ();
        double discountedPriceForUserAffiliate = calculateDiscount.calculatePayableAmountForUser ( discountForAffiliate );
        LOGGER.info ("Total Payable amount for Customer Type Affiliate " +
                "is "+discountedPriceForUserAffiliate +" $" );

        Discount discountForOldUsers = new Discount.Builder(50)
                .setUserOld ( 3 )
                .build ();
        double discountedPriceForOldUsers = calculateDiscount.calculatePayableAmountForUser ( discountForOldUsers );
        LOGGER.info ("Total Payable amount for Old users " +
                "is "+discountedPriceForOldUsers +" $" );

        Discount discountForGroceryItems = new Discount.Builder(shoppingAmount)
                .setCustomerType ( userTypeAffiliate )
                .setUserOld ( 3 )
                .setIfItemTypeIsGrocery ( ifItemIsGrocery )
                .build ();
        double discountedPriceGroceryItems = calculateDiscount.calculatePayableAmountForUser ( discountForGroceryItems );
        LOGGER.info ("Total Payable amount for Grocery Items " +
                "is "+discountedPriceGroceryItems +" $" );
    }
}