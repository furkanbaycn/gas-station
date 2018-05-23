package com.example.furkanbaycan.gasstation.HTTPParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HTTPParser {
    private BenzinParser benzinParser = new BenzinParser();
    private MotorinParser motorinParser = new MotorinParser();
    private LPGParser lpgParser = new LPGParser();
    List<DataModel> dataModelList = new ArrayList<DataModel>();
    private final String USER_AGENT = "Mozilla/5.0";
    public List<DataModel> sendGet(String sehir, String ilce, String akaryakit) throws Exception {

        if (akaryakit.equals("lpg")){
            String url = "http://lpgal.com/"+sehir+"-lpg-fiyatlari";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();

            /* Possible convert the responseCode to JSON here for ease of parsking? */

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String html = response.toString();
            //print result


            dataModelList = lpgParser.getLPG(html);

        }
        else{
            String url = "https://benzinal.com/"+sehir+"-"+ilce+"-"+akaryakit+"-fiyatlari";
            //String url = "https://benzinal.com/istanbul-buyukcekmece-motorin-fiyatlari";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

           // int responseCode = con.getResponseCode();

            /* Possible convert the responseCode to JSON here for ease of parsking? */

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String html = response.toString();
            //print result


            if (akaryakit.equals("benzin")){
                dataModelList = benzinParser.getBenzin(html);

            }else{
                dataModelList = motorinParser.getMotorin(html);
            }
        }



        return dataModelList;
    }
}
