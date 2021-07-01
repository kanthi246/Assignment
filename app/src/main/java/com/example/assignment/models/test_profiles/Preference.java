package com.example.assignment.models.test_profiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Preference {
    @SerializedName("answer_id")
    @Expose
    private Integer answerId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("preference_question")
    @Expose
    private PreferenceQuestion preferenceQuestion;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public PreferenceQuestion getPreferenceQuestion() {
        return preferenceQuestion;
    }

    public void setPreferenceQuestion(PreferenceQuestion preferenceQuestion) {
        this.preferenceQuestion = preferenceQuestion;
    }

}
