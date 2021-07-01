package com.example.assignment.models.test_profiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile__1 {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
