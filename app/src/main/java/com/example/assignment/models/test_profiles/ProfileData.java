package com.example.assignment.models.test_profiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileData {
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("preferences")
    @Expose
    private List<Preference__1> preferences = null;
    @SerializedName("invitation_type")
    @Expose
    private String invitationType;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Preference__1> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference__1> preferences) {
        this.preferences = preferences;
    }

    public String getInvitationType() {
        return invitationType;
    }

    public void setInvitationType(String invitationType) {
        this.invitationType = invitationType;
    }
}
