package com.example.soudest.helper;

public class connectionOBJ {
    public String ConnID;
    public String TransportType;
    public String Description;
    public Double TotalTime;
    public Double Price;
    public Double StartTime;
    public Double EndTime;
    public Double StartNorthCord;
    public Double StartEastCord;
    public Double EndNorthCord;
    public Double EndEastCord;

    public connectionOBJ(String connID, String transportType, String description, Double totalTime, Double price, Double startTime, Double endTime, Double startNorthCord, Double startEastCord, Double endNorthCord, Double endEastCord) {
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
    }
}
