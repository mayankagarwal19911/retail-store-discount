package com.app.store.retail.discounts.app.model;

/**
 * Builder Pattern for discount class
 */
public
class Discount {
    private String customerType;
    private int customerTypeDiscount;
    private int userOld;
    private int userOldDiscount;
    private int minimumAsaleForDiscount;
    private int incrementalDiscount;
    private int shoppingAmount;
    private boolean ifItemTypeIsGrocery;


    public static class Builder{
        private String customerType;
        private int customerTypeDiscount;
        private int userOld;
        private int userOldDiscount;
        private int minimumAsaleForDiscount;
        private int incrementalDiscount;
        private boolean ifItemTypeIsGrocery;
        private int shoppingAmount;

        public
        Builder(int shoppingAmount) {
            this.shoppingAmount = shoppingAmount;
        }

        public
        Builder setCustomerType (String customerType) {
            this.customerType = customerType;
            return this;
        }

        public
        Builder setCustomerTypeDiscount (int customerTypeDiscount) {
            this.customerTypeDiscount = customerTypeDiscount;
            return this;
        }

        public
        Builder setUserOld (int userOld) {
            this.userOld = userOld;
            return this;
        }

        public
        Builder setUserOldDiscount (int userOldDiscount) {
            this.userOldDiscount = userOldDiscount;
            return this;
        }

        public
        Builder setMinimumAsaleForDiscount (int minimumAsaleForDiscount) {
            this.minimumAsaleForDiscount = minimumAsaleForDiscount;
            return this;
        }

        public
        Builder setIncrementalDiscount (int incrementalDiscount) {
            this.incrementalDiscount = incrementalDiscount;
            return this;
        }

        public
        Builder setIfItemTypeIsGrocery (boolean ifItemTypeIsGrocery) {
            this.ifItemTypeIsGrocery = ifItemTypeIsGrocery;
            return this;
        }

        public Discount build(){
            Discount discount = new Discount();
            discount.customerType = customerType;
            discount.shoppingAmount = shoppingAmount;
            discount.customerTypeDiscount = customerTypeDiscount;
            discount.userOld = userOld;
            discount.userOldDiscount = userOldDiscount;
            discount.minimumAsaleForDiscount = minimumAsaleForDiscount;
            discount.incrementalDiscount = incrementalDiscount;
            discount.ifItemTypeIsGrocery = ifItemTypeIsGrocery;

            return discount;
        }
    }

    private Discount(){

    }

    public
    String getCustomerType ( ) {
        return customerType;
    }

    public
    void setCustomerType (String customerType) {
        this.customerType = customerType;
    }

    public
    int getCustomerTypeDiscount ( ) {
        return customerTypeDiscount;
    }

    public
    void setCustomerTypeDiscount (int customerTypeDiscount) {
        this.customerTypeDiscount = customerTypeDiscount;
    }

    public
    int getUserOld ( ) {
        return userOld;
    }

    public
    void setUserOld (int userOld) {
        this.userOld = userOld;
    }

    public
    int getUserOldDiscount ( ) {
        return userOldDiscount;
    }

    public
    void setUserOldDiscount (int userOldDiscount) {
        this.userOldDiscount = userOldDiscount;
    }

    public
    int getMinimumAsaleForDiscount ( ) {
        return minimumAsaleForDiscount;
    }

    public
    void setMinimumAsaleForDiscount (int minimumAsaleForDiscount) {
        this.minimumAsaleForDiscount = minimumAsaleForDiscount;
    }

    public
    int getIncrementalDiscount ( ) {
        return incrementalDiscount;
    }

    public
    void setIncrementalDiscount (int incrementalDiscount) {
        this.incrementalDiscount = incrementalDiscount;
    }

    public
    boolean getIfItemTypeIsGrocery ( ) {
        return ifItemTypeIsGrocery;
    }

    public
    void setIfItemTypeIsGrocery (boolean ifItemTypeIsGrocery) {
        this.ifItemTypeIsGrocery = ifItemTypeIsGrocery;
    }

    public
    int getShoppingAmount ( ) {
        return shoppingAmount;
    }

    public
    void setShoppingAmount (int shoppingAmount) {
        this.shoppingAmount = shoppingAmount;
    }

    @Override
    public
    String toString ( ) {
        return "Discount{" +
                "customerType='" + customerType + '\'' +
                ", customerTypeDiscount=" + customerTypeDiscount +
                ", userOld=" + userOld +
                ", userOldDiscount=" + userOldDiscount +
                ", minimumAsaleForDiscount=" + minimumAsaleForDiscount +
                ", incrementalDiscount=" + incrementalDiscount +
                ", shoppingAmount=" + shoppingAmount +
                ", ifItemTypeIsGrocery=" + ifItemTypeIsGrocery +
                '}';
    }
}
