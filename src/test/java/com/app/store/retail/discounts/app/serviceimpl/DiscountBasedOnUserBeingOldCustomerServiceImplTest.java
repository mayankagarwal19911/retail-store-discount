package com.app.store.retail.discounts.app.serviceimpl;

import com.app.store.retail.discounts.app.model.Discount;
import com.app.store.retail.discounts.app.service.DiscountBasedOnUserBeingOldCustomerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public
class DiscountBasedOnUserBeingOldCustomerServiceImplTest {

    Discount discount;
    DiscountBasedOnUserBeingOldCustomerService discountBasedOnUserBeingOldCustomerService
            = new DiscountBasedOnUserBeingOldCustomerServiceImpl ();

    @Before
    public void setUp(){

        discount = new Discount.Builder( 50)
                .setCustomerType ( "affiliate" )
                .setUserOld ( 3 ).build ();
    }

    @Test
    public
    void getDiscountForOldUsers ( ) {
        Object expectedResult = 3.0;
        Object actualResult = discountBasedOnUserBeingOldCustomerService.getDiscountForOldUsers (discount.getUserOld ());
        assertEquals(expectedResult, actualResult);
    }
}