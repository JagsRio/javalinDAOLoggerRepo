package com.jags;

public class OfficeModel {
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalcode;
    private String territory;

    public OfficeModel(String ofcode, String city, String phone, String add1, String add2, String state, String country, String pcode, String territory){
        this.officeCode = ofcode;
        this.city = city;
        this.phone = phone;
        this.addressLine1 = add1;
        this.addressLine2 = add2;
        this.state = state;
        this.country = country;
        this.postalcode = pcode;
        this.territory = territory;
    }

    public String getOfficeCode(){
        return officeCode;
    }
    public String getCity(){
        return city;
    }
    public String getPhone(){
        return phone;
    }
    public String getAddressLine1(){
        return addressLine1;
    }
    public String getAddressLine2(){
        return addressLine2;
    }
    public String getState(){
        return state;
    }
    public String getCountry(){
        return country;
    }
    public String getPostalCode(){
        return postalcode;
    }
    public String getTerritory(){
        return territory;
    }

    public String getOfficeDetails(){
        String ofmodelStr;
        ofmodelStr = officeCode + ", " + addressLine1 + ", "
                    + addressLine2 + "," + city + "," + state + "," + country + "," 
                    + postalcode + "," + phone + "," + territory; 
       return ofmodelStr;
    }

    @Override
    public String toString(){
        String ofmodelStr;
        ofmodelStr = officeCode + ", " + addressLine1 + ", "
                    + addressLine2 + "," + city + "," + state + "," + country + "," 
                    + postalcode + "," + phone + "," + territory; 
       return ofmodelStr;
    }

}
