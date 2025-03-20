package com.example.exp4;

import java.util.ArrayList;

public class Customer {

    private long mCustomerID;
    private String mName;
    private String mPhone;
    private String mGender;
    private String mEmail;

    public Customer(){

    }

    public Customer(long mCustomerID, String mName, String mPhone, String mGender , String mEmail) {
        this.mCustomerID = mCustomerID; this.mName = mName; this.mPhone = mPhone; this.mGender = mGender; this.mEmail=mEmail;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public long getmCustomerID() {
        return mCustomerID;
    }

    public void setmCustomerID(long mCustomerID) {
        this.mCustomerID = mCustomerID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "mCustomerID=" + mCustomerID +
                ", mName='" + mName + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", mGender='" + mGender + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }

}
