package com.xebia.app.store.retail.discounts.app.serviceimpl;

import com.xebia.app.store.retail.discounts.app.model.Discount;
import com.xebia.app.store.retail.discounts.app.service.DiscountBasedOnCustomerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public
class DiscountBasedOnCustomerServiceImplTest {

    Discount discountForEmployee;
    Discount discountForAffiliate;
    Discount discountForNoCategoryCustomer;
    DiscountBasedOnCustomerService discountBasedOnCustomerService
            = new DiscountBasedOnCustomerServiceImpl ();

    @Before
    public void setUp(){

        discountForEmployee = new Discount.Builder( 990)
                .setCustomerType ( "employee" )
                .build ();

        discountForAffiliate = new Discount.Builder(990)
                .setCustomerType ( "affiliate" )
                .build ();

        discountForNoCategoryCustomer = new Discount.Builder(990)
                .build ();
    }

    @Test
    public
    void getDiscountBasedOnUsertypeEmployee ( ) {
        Object expectedResult = 30.0;
        Object actualResult = discountBasedOnCustomerService.getDiscountBasedOnUsertype (discountForEmployee);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public
    void getDiscountBasedOnUsertypeAffiliate ( ) {
        Object expectedResult = 10.0;
        Object actualResult = discountBasedOnCustomerService.getDiscountBasedOnUsertype (discountForAffiliate);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public
    void getDiscountBasedOnUsertypeNoDefinedUser ( ) {
        Object expectedResult = 0.0;
        Object actualResult = discountBasedOnCustomerService.getDiscountBasedOnUsertype (discountForNoCategoryCustomer);
        assertEquals(expectedResult, actualResult);
    }
}