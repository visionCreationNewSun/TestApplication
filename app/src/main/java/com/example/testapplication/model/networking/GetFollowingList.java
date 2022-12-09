package com.example.testapplication.model.networking;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *   팔로잉 리스트를 GET 하는 네트워킹 클래스
 */

public class GetFollowingList{

    // HttpUrlConnection 라이브러리를 사용
    public ArrayList<FollowingDTO> httpURLConnectionGet(String urlStr, int page){

        String responseData = "";
        String data = "";
        BufferedReader bfReader = null;
        ArrayList<FollowingDTO> fList = new ArrayList<>();
        String jsonUserId = "";
        String jsonUrl = "";
        String jsonNickname = "";

        try{
            // 뒷부분 파라미터
            URL url =  new URL(urlStr + "?page=" + page);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();



            // 단순히 리스트를 얻어오기만 하면 되므로 GET, JSON 형식 헤더
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");



            // http 리퀘스트
            connection.connect();



            // 인풋스트림 -> json 파싱
            InputStream inputStream = connection.getInputStream();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(
                    new InputStreamReader(inputStream, "UTF-8")
            );

            JSONArray jsonArray = jsonObject.names();

            for(int i=0; i<jsonArray.length(); i++){
                fList.add(new FollowingDTO(
                        jsonArray.getInt(0),
                        jsonArray.getJSONObject(1).names().getString(0),
                        jsonArray.getString(2)
                ));
            }


            // 리스폰스 확인
            System.out.println("http Response Message -> "+ connection.getResponseMessage());
            System.out.println("http Response Code -> "+ connection.getResponseCode());
        }
        catch (IOException e){
            e.printStackTrace();
            // 버퍼리더 닫아주기!
        }
        catch (ParseException pe){
            pe.printStackTrace();
        }
        catch (JSONException je){
            je.printStackTrace();
        }
        finally {
            return fList;
        }

    }
}
