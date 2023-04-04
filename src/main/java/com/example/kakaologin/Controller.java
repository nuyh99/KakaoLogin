package com.example.kakaologin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public final class Controller {

//    @GetMapping("/member/kakao")
//    public String getCode(String code) throws IOException, ParseException {
//        final String token = getToken(code);
//
//        System.out.println(getAgreementInfo(token));
//        return getUserInfo(token).entrySet().toString();
//    }

    @GetMapping("/test")
    public String showToken(@RequestParam String token) {
        return getUserInfo2(token);
    }

//    public String getToken(String code) throws IOException, ParseException {
//        URL url = new URL("https://kauth.kakao.com/oauth/token");
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//
//        String token = "";
//        urlConnection.setRequestMethod("POST");
//        urlConnection.setDoOutput(true); // 데이터 기록 알려주기
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
//        StringBuilder sb = new StringBuilder();
//        sb.append("grant_type=authorization_code");
//        sb.append("&client_id=fb51e5196a302ddfec7f2c78b64f3021");
//        sb.append("&client_secret=jSIiaA09hKs1LjmNgodYBHsvQ2hAAi3A");
//        sb.append("&redirect_uri=http://localhost:8080/member/kakao");
//        sb.append("&code=" + code);
//
//        bw.write(sb.toString());
//        bw.flush();
//
//        int responseCode = urlConnection.getResponseCode();
//        System.out.println("responseCode = " + responseCode);
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//        String line = "";
//        StringBuilder result = new StringBuilder();
//        while ((line = br.readLine()) != null) {
//            result.append(line);
//        }
//        System.out.println("result = " + result);
//
//        JSONParser parser = new JSONParser();
//        JSONObject elem = (JSONObject) parser.parse(String.valueOf(result));
//
//        String access_token = elem.get("access_token").toString();
//        String refresh_token = elem.get("refresh_token").toString();
//        System.out.println("refresh_token = " + refresh_token);
//        System.out.println("access_token = " + access_token);
//
//        token = access_token;
//
//        return token;
//    }
//
//    public Map<String, Object> getUserInfo(String access_token) {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            URL url = new URL("https://kapi.kakao.com/v2/user/me");
//
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestProperty("Authorization", "Bearer " + access_token);
//            urlConnection.setRequestMethod("GET");
//
//            int responseCode = urlConnection.getResponseCode();
//            System.out.println("responseCode = " + responseCode);
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//            String line = "";
//            String res = "";
//            while ((line = br.readLine()) != null) {
//                res += line;
//            }
//
//            System.out.println("res = " + res);
//
//            JSONParser parser = new JSONParser();
//            JSONObject obj = (JSONObject) parser.parse(res);
//            JSONObject kakao_account = (JSONObject) obj.get("kakao_account");
//
//            String id = obj.get("id").toString();
//            String email = kakao_account.get("email").toString();
//
//            result.put("id", id);
//            result.put("email", email);
//
//            br.close();
//
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }

    private String getUserInfo2(String token) {
        System.out.println("test: " + token);
        try {
            URL url = new URL("https://kapi.kakao.com/v2/user/me");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            urlConnection.setRequestMethod("GET");

            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            String res = "";
            while ((line = br.readLine()) != null) {
                res += line;
            }

            System.out.println("res = " + res);

            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "실패했당ㅎㅎㅎ";
    }
}
