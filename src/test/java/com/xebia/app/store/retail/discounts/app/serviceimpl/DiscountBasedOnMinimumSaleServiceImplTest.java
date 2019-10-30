package com.xebia.app.store.retail.discounts.app.serviceimpl;

import com.xebia.app.store.retail.discounts.app.model.Discount;
import com.xebia.app.store.retail.discounts.app.service.DiscountBasedOnMinimumSaleService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public
class DiscountBasedOnMinimumSaleServiceImplTest {

    Discount discount;
    DiscountBasedOnMinimumSaleService discountBasedOnMinimumSaleService
            = new  DiscountBasedOnMinimumSaleServiceImpl();

    @Before
    public void setUp(){

        discount = new Discount.Builder( 990)
                .setCustomerType ( "employee" )
                .build ();
    }

    @Test
    public
    void getDiscountOnMinimumPredefinedAmount ( ) {
        Object expectedResult = 45.0;
        Object actualResult = discountBasedOnMinimumSaleService.getDiscountOnMinimumPredefinedAmount (discount);
        assertEquals(expectedResult, actualResult);
    }
}