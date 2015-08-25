package com.example.loc.water_body.Model;

/**
 * Created by loc on 10/05/2015.
 */
public class UserInformation_Model {
    private int IduserInfomation;
    private String UserInformation_name;
    private double UserInformationWeight;
    private double userInformationWater;
    private int IduserUnit;
    private int IduserStateSport;
    private int IduserStateSunny;

    public UserInformation_Model() {


    }

    public UserInformation_Model(int iduserInfomation, String userInformation_name, double userInformationWeight, double userInformationWater, int iduserUnit, int iduserStateSport, int iduserStateSunny) {
        IduserInfomation = iduserInfomation;
        UserInformation_name = userInformation_name;
        UserInformationWeight = userInformationWeight;
        this.userInformationWater = userInformationWater;
        IduserUnit = iduserUnit;
        IduserStateSport = iduserStateSport;
        IduserStateSunny = iduserStateSunny;
    }

    public int getIduserInfomation() {
        return IduserInfomation;
    }

    public void setIduserInfomation(int iduserInfomation) {
        IduserInfomation = iduserInfomation;
    }

    public String getUserInformation_name() {
        return UserInformation_name;
    }

    public void setUserInformation_name(String userInformation_name) {
        UserInformation_name = userInformation_name;
    }

    public double getUserInformationWeight() {
        return UserInformationWeight;
    }

    public void setUserInformationWeight(double userInformationWeight) {
        UserInformationWeight = userInformationWeight;
    }

    public double getUserInformationWater() {
        return userInformationWater;
    }

    public void setUserInformationWater(double userInformationWater) {
        this.userInformationWater = userInformationWater;
    }

    public int getIduserUnit() {
        return IduserUnit;
    }

    public void setIduserUnit(int iduserUnit) {
        IduserUnit = iduserUnit;
    }

    public int getIduserStateSport() {
        return IduserStateSport;
    }

    public void setIduserStateSport(int iduserStateSport) {
        IduserStateSport = iduserStateSport;
    }

    public int getIduserStateSunny() {
        return IduserStateSunny;
    }

    public void setIduserStateSunny(int iduserStateSunny) {
        IduserStateSunny = iduserStateSunny;
    }

    @Override
    public String toString() {
        return "id" + IduserInfomation + ", name " + UserInformation_name + ", weight " + UserInformationWeight + ", water " + userInformationWater + ", unit " + IduserUnit + ", state   " + IduserStateSport+","+IduserStateSunny;
    }
}
