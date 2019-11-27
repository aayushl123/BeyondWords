package com.beyondwords.model;

public class PersonInfo {

    private static PersonInfo singlePersonObject= new PersonInfo();

    private PersonInfo(){

    }

    public static PersonInfo getInstance(){
        return singlePersonObject;
    }



    private String mGender;
    private String mAge;
    private String mCitizenShip;
    private String mCountry;
    private String mLanguage;
    private String mEthnicity;
    private String mReligion;
    private String mSocio;
    private String mProfessionalTraining;
    private String mProfessionalStatus;
    private String mOrgnaization;
    private String mOrganiState;
    private String mOrgnFunction;
    private String mFrequency;
    private String mDescription;
    private String mConcern;
    private String mWho;
    private String mWhere;

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmCitizenShip() {
        return mCitizenShip;
    }

    public void setmCitizenShip(String mCitizenShip) {
        this.mCitizenShip = mCitizenShip;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmLanguage() {
        return mLanguage;
    }

    public void setmLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
    }

    public String getmEthnicity() {
        return mEthnicity;
    }

    public void setmEthnicity(String mEthnicity) {
        this.mEthnicity = mEthnicity;
    }

    public String getmReligion() {
        return mReligion;
    }

    public void setmReligion(String mReligion) {
        this.mReligion = mReligion;
    }

    public String getmSocio() {
        return mSocio;
    }

    public void setmSocio(String mSocio) {
        this.mSocio = mSocio;
    }

    public String getmProfessionalTraining() {
        return mProfessionalTraining;
    }

    public void setmProfessionalTraining(String mProfessionalTraining) {
        this.mProfessionalTraining = mProfessionalTraining;
    }

    public String getmProfessionalStatus() {
        return mProfessionalStatus;
    }

    public void setmProfessionalStatus(String mProfessionalStatus) {
        this.mProfessionalStatus = mProfessionalStatus;
    }

    public String getmOrgnaization() {
        return mOrgnaization;
    }

    public void setmOrgnaization(String mOrgnaization) {
        this.mOrgnaization = mOrgnaization;
    }

    public String getmOrganiState() {
        return mOrganiState;
    }

    public void setmOrganiState(String mOrganiState) {
        this.mOrganiState = mOrganiState;
    }

    public String getmOrgnFunction() {
        return mOrgnFunction;
    }

    public void setmOrgnFunction(String mOrgnFunction) {
        this.mOrgnFunction = mOrgnFunction;
    }

    public String getmFrequency() {
        return mFrequency;
    }

    public void setmFrequency(String mFrequency) {
        this.mFrequency = mFrequency;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmConcern() {
        return mConcern;
    }

    public void setmConcern(String mConcern) {
        this.mConcern = mConcern;
    }

    public String getmWho() {
        return mWho;
    }

    public void setmWho(String mWho) {
        this.mWho = mWho;
    }

    public String getmWhere() {
        return mWhere;
    }

    public void setmWhere(String mWhere) {
        this.mWhere = mWhere;
    }




}
