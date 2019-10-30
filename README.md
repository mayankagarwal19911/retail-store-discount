# retail-store-discount
This Repository holds the application of retails store for discount calculation module based on different users category.

Main class : RetailStoreDiscount

Steps to run the application: 
  1) Downloand and unzip the repository.
  2) Open terminal/cmd at the roort directory and run 'gradle build' 
                          OR
  3) After importing the project in IDE, run gradle build task from IDE
  
  classes descriptions:
  
    RetailStoreDiscount - is the api to test the application
    RetailStoreDiscountConstants -  Constant file of application
    RetailStoreDiscountException - Custom Exception file
    RetailStoreDiscountLogger - This file generates Logger file in both html & txt format
    RetailStoreDiscountLoggerHtmlFormatter - Formats HTML log file
    Discount - Model class, builder pattern is used so that client can pass other values from it's end and get desired payable amount for the customer
    
    CalculateAmountPayableService - Service to return net payable amount
    DiscountBasedOnCustomerService - Service to return discounted percentage for different users type
    DiscountBasedOnMinimumSaleService - Service to return discounted price based on shopping done by customer
    DiscountBasedOnUserBeingOldCustomerService -  Service to return discounted percentage for the user as a priviledged customer
    
    CalculateDiscountServiceImpl - Implementation of CalculateAmountPayableService to calculate net payable amount after discount
    DiscountBasedOnCustomerServiceImpl - Implementation of DiscountBasedOnUserBeingOldCustomerService to calculate discounted percentage for different users type
    DiscountBasedOnMinimumSaleServiceImpl - Implementation of DiscountBasedOnMinimumSaleService to calculate discounted price based on shopping done by customer
    DiscountBasedOnUserBeingOldCustomerServiceImpl - Implementation of DiscountBasedOnUserBeingOldCustomerService to return discounted percentage for the user as a priviledged customer
    
    PropertyUtils - To Load the configuration from application.properties file
    
    Test case coverage : 
    
    package for test cases : /src/test/java/com/app/store/retail/discounts/app/serviceimpl
    Open build/test-results-report/tests/test/index.html to see the test coverage report
    
    
    Logs to check output : 
    /logs folder to see the generated logs output in both HTML & text formats
    
