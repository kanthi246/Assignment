package com.example.assignment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostMobileNumberRequest {
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("otp")
    @Expose
    private String otp;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
