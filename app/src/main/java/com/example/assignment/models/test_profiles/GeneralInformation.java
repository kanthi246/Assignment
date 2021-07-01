package com.example.assignment.models.test_profiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralInformation {

    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("date_of_birth_v1")
    @Expose
    private String dateOfBirthV1;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("drinking")
    @Expose
    private String drinking;
    @SerializedName("drinking_v1")
    @Expose
    private DrinkingV1 drinkingV1;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("marital_status_v1")
    @Expose
    private MaritalStatusV1 maritalStatusV1;
    @SerializedName("ref_id")
    @Expose
    private String refId;
    @SerializedName("smoking")
    @Expose
    private String smoking;
    @SerializedName("smoking_v1")
    @Expose
    private SmokingV1 smokingV1;
    @SerializedName("sun_sign")
    @Expose
    private String sunSign;
    @SerializedName("sun_sign_v1")
    @Expose
    private SunSignV1 sunSignV1;
    @SerializedName("mother_tongue")
    @Expose
    private MotherTongue motherTongue;
    @SerializedName("faith")
    @Expose
    private Faith faith;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("cast")
    @Expose
    private Object cast;
    @SerializedName("kid")
    @Expose
    private Object kid;
    @SerializedName("diet")
    @Expose
    private Object diet;
    @SerializedName("politics")
    @Expose
    private Object politics;
    @SerializedName("pet")
    @Expose
    private Object pet;
    @SerializedName("settle")
    @Expose
    private Object settle;
    @SerializedName("age")
    @Expose
    private Integer age;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirthV1() {
        return dateOfBirthV1;
    }

    public void setDateOfBirthV1(String dateOfBirthV1) {
        this.dateOfBirthV1 = dateOfBirthV1;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDrinking() {
        return drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking;
    }

    public DrinkingV1 getDrinkingV1() {
        return drinkingV1;
    }

    public void setDrinkingV1(DrinkingV1 drinkingV1) {
        this.drinkingV1 = drinkingV1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public MaritalStatusV1 getMaritalStatusV1() {
        return maritalStatusV1;
    }

    public void setMaritalStatusV1(MaritalStatusV1 maritalStatusV1) {
        this.maritalStatusV1 = maritalStatusV1;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public SmokingV1 getSmokingV1() {
        return smokingV1;
    }

    public void setSmokingV1(SmokingV1 smokingV1) {
        this.smokingV1 = smokingV1;
    }

    public String getSunSign() {
        return sunSign;
    }

    public void setSunSign(String sunSign) {
        this.sunSign = sunSign;
    }

    public SunSignV1 getSunSignV1() {
        return sunSignV1;
    }

    public void setSunSignV1(SunSignV1 sunSignV1) {
        this.sunSignV1 = sunSignV1;
    }

    public MotherTongue getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(MotherTongue motherTongue) {
        this.motherTongue = motherTongue;
    }

    public Faith getFaith() {
        return faith;
    }

    public void setFaith(Faith faith) {
        this.faith = faith;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Object getCast() {
        return cast;
    }

    public void setCast(Object cast) {
        this.cast = cast;
    }

    public Object getKid() {
        return kid;
    }

    public void setKid(Object kid) {
        this.kid = kid;
    }

    public Object getDiet() {
        return diet;
    }

    public void setDiet(Object diet) {
        this.diet = diet;
    }

    public Object getPolitics() {
        return politics;
    }

    public void setPolitics(Object politics) {
        this.politics = politics;
    }

    public Object getPet() {
        return pet;
    }

    public void setPet(Object pet) {
        this.pet = pet;
    }

    public Object getSettle() {
        return settle;
    }

    public void setSettle(Object settle) {
        this.settle = settle;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
