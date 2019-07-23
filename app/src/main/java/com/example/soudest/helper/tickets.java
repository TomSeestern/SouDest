package com.example.soudest.helper;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class tickets {

    public static List<ticketOBJ> getAllTicketsFromDB() {
        //TODO Make call to API to request all Available Tickets
        JSONObject obj;
        List<ticketOBJ> reti = new ArrayList<ticketOBJ>();


        String json = "{\"RequestID\":123,\"TimeStamp\":1562411774,\"Valid Until\":1562441774,\"Tickets\":[{\"TicketID\":\"DB-AR-0815\",\"TotalTime\":15200,\"StartTime\":1562451774,\"EndTime\":1562466974,\"TotalPath\":{\"type\":\"LineString / GEOJSON\",\"coordinates\":[[30,10],[10,30],[40,40]]},\"Transfers\":2,\"TotalPrice\":251.5,\"Connections\":[{\"ConnectionID\":\"DB-RE-272-84214423\",\"TransportType\":\"Train\",\"Description\":\"DB-RE-272\",\"TotalTime\":\"5200\",\"Price\":\"201.00\",\"StartTime\":1562451774,\"EndTime\":1562466974,\"Path\":{\"StartLocName\":\"XYZ\",\"EndLocName\":\"ABC\",\"type\":\"LineString / GEOJSON\",\"coordinates\":[[30,10],[10,30]]}},{\"ConnectionID\":\"BayerReisen213-23\",\"TransportType\":\"Bus\",\"Description\":\"Bayer Reisen Linie 27\",\"TotalTime\":\"10000\",\"Price\":\"50.50\",\"StartTime\":1562451774,\"EndTime\":1562466974,\"Path\":{\"StartLocName\":\"XYZ\",\"EndLocName\":\"ABC\",\"type\":\"LineString / GEOJSON\",\"coordinates\":[[10,30],[40,40]]}}]},{\"TicketID\":\"DB-AR-0815\",\"TotalTime\":15200,\"StartTime\":1562451774,\"EndTime\":1562466974,\"TotalPath\":{\"type\":\"LineString / GEOJSON\",\"coordinates\":[[30,10],[10,30],[40,40]]},\"Transfers\":2,\"TotalPrice\":251.5,\"Connections\":[{\"ConnectionID\":\"DB-RE-272-84214423\",\"TransportType\":\"Train\",\"Description\":\"DB-RE-272\",\"TotalTime\":\"5200\",\"Price\":\"201.00\",\"StartTime\":1562451774,\"EndTime\":1562466974,\"Path\":{\"StartLocName\":\"XYZ\",\"EndLocName\":\"ABC\",\"type\":\"LineString / GEOJSON\",\"coordinates\":[[30,10],[10,30]]}},{\"ConnectionID\":\"BayerReisen213-23\",\"TransportType\":\"Bus\",\"Description\":\"Bayer Reisen Linie 27\",\"TotalTime\":\"10000\",\"Price\":\"50.50\",\"StartTime\":1562451774,\"EndTime\":1562466974,\"Path\":{\"StartLocName\":\"XYZ\",\"EndLocName\":\"ABC\",\"type\":\"LineString / GEOJSON\",\"coordinates\":[[10,30],[40,40]]}}]},{\"TicketID\":\"DB-AR-0815\",\"TotalTime\":15200,\"StartTime\":1562451774,\"EndTime\":1562466974,\"TotalPath\":{\"type\":\"LineString / GEOJSON\",\"coordinates\":[[30,10],[10,30],[40,40]]},\"Transfers\":2,\"TotalPrice\":251.5,\"Connections\":[{\"ConnectionID\":\"DB-RE-272-84214423\",\"TransportType\":\"Train\",\"Description\":\"DB-RE-272\",\"TotalTime\":\"5200\",\"Price\":\"201.00\",\"StartTime\":1562451774,\"EndTime\":1562466974,\"Path\":{\"StartLocName\":\"XYZ\",\"EndLocName\":\"ABC\",\"type\":\"LineString / GEOJSON\",\"coordinates\":[[30,10],[10,30]]}},{\"ConnectionID\":\"BayerReisen213-23\",\"TransportType\":\"Bus\",\"Description\":\"Bayer Reisen Linie 27\",\"TotalTime\":\"10000\",\"Price\":\"50.50\",\"StartTime\":1562451774,\"EndTime\":1562466974,\"Path\":{\"StartLocName\":\"XYZ\",\"EndLocName\":\"ABC\",\"type\":\"LineString / GEOJSON\",\"coordinates\":[[10,30],[40,40]]}}]}]}";

        try {
            obj = new JSONObject(json);
            JSONArray TicketArray = obj.getJSONArray("Tickets");
            JSONObject SingleTicket;
            ticketOBJ SingleTicketObj;

            JSONArray ConnectionArray;
            JSONObject SingleConnection;
            List<connectionOBJ> ConnList = new ArrayList<connectionOBJ>();
            connectionOBJ SingleConnObj;


            for (int i = 0; i < TicketArray.length(); i++) {
                SingleTicket = TicketArray.getJSONObject(i);
                ConnList = new ArrayList<connectionOBJ>();

                ConnectionArray = SingleTicket.getJSONArray("Connections");
                for (int x = 0; x < ConnectionArray.length(); x++) {
                    SingleConnection = ConnectionArray.getJSONObject(x);
                    SingleConnObj = new connectionOBJ(SingleConnection.getString("ConnectionID"), SingleConnection.getString("TransportType"), SingleConnection.getString("Description"), SingleConnection.getDouble("TotalTime"), SingleConnection.getDouble("Price"), SingleConnection.getDouble("StartTime"), SingleConnection.getDouble("EndTime"), 0.0, 0.0, SingleConnection.getJSONObject("Path").getString("StartLocName"), 0.0, 0.0, SingleConnection.getJSONObject("Path").getString("EndLocName"));
                    ConnList.add(SingleConnObj);
                }

                SingleTicketObj = new ticketOBJ(SingleTicket.getString("TicketID"), SingleTicket.getDouble("TotalTime"), SingleTicket.getDouble("StartTime"), SingleTicket.getDouble("EndTime"), SingleTicket.getDouble("Transfers"), SingleTicket.getDouble("TotalPrice"), ConnList);
                reti.add(SingleTicketObj);

            }

        } catch (Throwable tx) {
            Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
            Log.e("My App", "Error: \"" + tx + "\"");
        }


        Log.e("Schit", "TEST: " + reti.get(0).connections.size());
        return reti;
    }

    public static List<ticketOBJ> getPossibleConnections(String startloc, String targetloc, String Date, String Time) {

        return getAllTicketsFromDB();
    }

}
