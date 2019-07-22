package com.example.soudest.helper;

import java.io.Serializable;

public class connectionOBJ implements Cloneable,Serializable{
    public String ConnID;
    public String TransportType;
    public String Description;
    public Double TotalTime;
    public Double Price;
    public Double StartTime;
    public Double EndTime;
    public Double StartNorthCord;
    public Double StartEastCord;
    public String StartLocName;
    public Double EndNorthCord;
    public Double EndEastCord;
    public String EndLocName;

    public connectionOBJ(){}

    public connectionOBJ(String connID, String transportType, String description, Double totalTime, Double price, Double startTime, Double endTime, Double startNorthCord, Double startEastCord,String mStartLocName, Double endNorthCord, Double endEastCord, String mEndLocName) {
        this.ConnID = ConnID;
        this.TransportType = transportType;
        this.Description = description;
        this.TotalTime = totalTime;
        this.Price = price;
        this.StartTime = startTime;
        this.EndTime = endTime;
        this.StartNorthCord = startNorthCord;
        this.StartEastCord = startEastCord;
        this.EndNorthCord = endNorthCord;
        this.EndEastCord = endEastCord;
        this.StartLocName = mStartLocName;
        this.EndLocName = mEndLocName;
    }

    public Object clone() throws CloneNotSupportedException {
        connectionOBJ mClone = (connectionOBJ)super.clone();
        return mClone;
    }
}
