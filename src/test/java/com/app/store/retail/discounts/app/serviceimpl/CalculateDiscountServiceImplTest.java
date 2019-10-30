package com.app.store.retail.discounts.app.serviceimpl;

import com.app.store.retail.discounts.app.common.RetailStoreDiscountException;
import com.app.store.retail.discounts.app.model.Discount;
import com.app.store.retail.discounts.app.service.CalculateAmountPayableService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnCustomerService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnMinimumSaleService;
import com.app.store.retail.discounts.app.service.DiscountBasedOnUserBeingOldCustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public
class CalculateDiscountServiceImplTest {

    @Mock
    DiscountBasedOnCustomerService discountBasedOnCustomerServiceMock;

    @Mock
    DiscountBasedOnMinimumSaleService discountBasedOnMinimumSaleServiceMock;

    DiscountBasedOnUserBeingOldCustomerService discountBasedOnUserBeingOldCustomerServiceMock;

    CalculateAmountPayableService calculateAmountPayableService;

    Discount discountForEmployee;
    Discount discountForAffiliate;

    @Before
    public void setUp(){
        discountBasedOnCustomerServiceMock = mock(DiscountBasedOnCustomerServiceImpl.class);
        discountBasedOnMinimumSaleServiceMock = mock(DiscountBasedOnMinimumSaleServiceImpl.class);
        discountBasedOnUserBeingOldCustomerServiceMock = new DiscountBasedOnUserBeingOldCustomerServiceImpl();
        calculateAmountPayableService = new CalculateDiscountServiceImpl(discountBasedOnCustomerServiceMock,
                discountBasedOnMinimumSaleServiceMock,
                discountBasedOnUserBeingOldCustomerServiceMock);

        discountForEmployee = new Discount.Builder(990)
                .setCustomerType ( "employee" )
                .build ();

        discountForAffiliate = new Discount.Builder(990)
                .setCustomerType ( "affiliate" )
                .build ();
    }

    @Test
    public
    void calculatePayableAmountForUserEmployee ( ) throws RetailStoreDiscountException {
        when (discountBasedOnCustomerServiceMock
                .getDiscountBasedOnUsertype ( discountForEmployee ))
                .thenReturn ( 30.0 );

        when (discountBasedOnMinimumSaleServiceMock
                .getDiscountOnMinimumPredefinedAmount ( discountForEmployee ))
                .thenReturn ( 45.0 );

        Object expectedResult = 693.0;
        assertEquals( expectedResult, calculateAmountPayableService
                .calculatePayableAmountForUser (discountForEmployee));

        verify(discountBasedOnCustomerServiceMock,
                times(1))
                .getDiscountBasedOnUsertype (discountForEmployee);

        verify(discountBasedOnMinimumSaleServiceMock,
                times(1))
                .getDiscountOnMinimumPredefinedAmount (discountForEmployee);
    }
}