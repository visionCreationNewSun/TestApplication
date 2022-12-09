package com.example.testapplication.model.networking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 *   특정 팔로워의 피드 게시물들 GET
 */
public class GetFollowingFeeds {

    // HttpUrlConnection 라이브러리를 사용
    public ArrayList<FeedListDTO> httpURLConnectionGet(String urlStr, int page, int targetId){

        ArrayList<FeedListDTO> fList = new ArrayList<>();

        try{
            // 뒷부분 파라미터
            URL url =  new URL(urlStr + "?page=" + page + "&targetId=" + targetId);
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
                fList.add(new FeedListDTO(
                        jsonArray.getInt(0),
                        jsonArray.getJSONArray(1),
                        jsonArray.getString(2)
                ));
            }


            // 리스폰스 확인
            System.out.println("http Response Message -> "+ connection.getResponseMessage());
            System.out.println("http Response Code -> "+ connection.getResponseCode());
        }
        catch (IOException e){
            e.printStackTrace();
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
