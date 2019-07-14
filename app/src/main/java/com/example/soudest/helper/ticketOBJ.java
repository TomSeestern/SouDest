package com.example.soudest.helper;

import com.example.soudest.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class ticketOBJ {

    public String TicketID;
    public Double TotalTime;
    public Double StartTime;
    public Double EndTime;
    public Double Transfers;
    public Double TotalPrice;

    public List<connectionOBJ> connections = new ArrayList<connectionOBJ>();


    public ticketOBJ(String ticketID, Double totalTime, Double startTime, Double endTime, Double transfers, Double totalPrice, List<connectionOBJ> connections) {
        this.TicketID = ticketID;
        this.TotalTime = totalTime;
        this.StartTime = startTime;
        this.EndTime = endTime;
        this.Transfers = transfers;
        this.TotalPrice = totalPrice;
        this.connections = connections;
    }
}
