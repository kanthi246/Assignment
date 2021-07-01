package com.example.assignment.models.test_profiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HighestQualificationV1 {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("preference_only")
    @Expose
    private Boolean preferenceOnly;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPreferenceOnly() {
        return preferenceOnly;
    }

    public void setPreferenceOnly(Boolean preferenceOnly) {
        this.preferenceOnly = preferenceOnly;
    }
}
