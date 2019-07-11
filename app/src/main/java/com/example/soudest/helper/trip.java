package com.example.soudest.helper;

import org.json.JSONObject;
import android.util.Log;

public final class trip {
    //private trip(){       throw new IllegalStateException("No instances allowed!");    }
    public final String id;
    public final String content;
    public final String details;

    public static JSONObject gettrip(double pointA, double pointB){
        //TODO Make call to API to request Connections between both Points
        JSONObject obj;

        String json = "{\n" +
                "  \"RequestID\":123,\n" +
                "  \"TimeStamp\": 1562411774,\n" +
                "  \"Valid Until\":1562441774,\n" +
                "  \n" +
                "  \"Trip\":{\n" +
                "    \"TripID\": \"DB-AR-0815\",\n" +
                "    \"ToalTime\": 15200,\n" +
                "    \"StartTime\": 1562451774,\n" +
                "    \"EndTime\": 1562466974,\n" +
                "    \"TotalPath\":{ \n" +
                "      \"type\": \"LineString / GEOJSON\",\n" +
                "      \"coordinates\": [[30, 10], [10, 30], [40, 40]]\n" +
                "    },\n" +
                "    \"Transfers\": 2,\n" +
                "    \"TotalPrice\": 251.50,\n" +
                "    \"Connection\":{\n" +
                "      \"ConnectionID\":\"DB-RE-272-84214423\",\n" +
                "      \"TransportType\":\"Train\",\n" +
                "      \"Description\":\"DB-RE-272\",\n" +
                "      \"ToalTime\":\"5200\",\n" +
                "      \"Price\":\"201.00\",\n" +
                "      \"StartTime\": 1562451774,\n" +
                "      \"EndTime\": 1562466974,\n" +
                "      \"Path\":{ \n" +
                "        \"type\": \"LineString / GEOJSON\",\n" +
                "        \"coordinates\": [[30, 10], [10, 30]]\n" +
                "      },\n" +
                "      \n" +
                "      \"Connection\":{\n" +
                "      \"ConnectionID\":\"BayerReisen213-23\",\n" +
                "      \"TransportType\":\"Bus\",\n" +
                "      \"Description\":\"Bayer Reisen Linie 27\",\n" +
                "      \"ToalTime\":\"10000\",\n" +
                "      \"Price\":\"50.50\",\n" +
                "      \"StartTime\": 1562451774,\n" +
                "      \"EndTime\": 1562466974,\n" +
                "      \"Path\":{ \n" +
                "        \"type\": \"LineString / GEOJSON\",\n" +
                "        \"coordinates\": [[10, 30],[40, 40]]\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}\n" +
                "}";

        try {
            obj = new JSONObject(json);
        } catch (Throwable tx) {
            Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
            obj = new JSONObject();
        }

        return obj;
    }


    public trip(String id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

}
