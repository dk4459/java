package com.yedam.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yedam.Controller.Control;

public class KakaoControl implements Control {
	private static final String SECRET_KEY = "DEV8219169F8D056326FBC309F2BB53038165727"; // REST API Key
    private static final String CID = "TCSUBSCRIP"; // 테스트용 CID

    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String itemName = req.getParameter("itemName");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int totalAmount = Integer.parseInt(req.getParameter("amount"));

        String method = "POST";
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";  // 카카오페이 최신 API URL로 수정

        // 요청 파라미터 준비 (JSON 형식)
        String params = "{" +
                        "\"cid\":\"" + CID + "\"," +
                        "\"partner_order_id\":\"12345\"," +
                        "\"partner_user_id\":\"abc123\"," +
                        "\"item_name\":\"" + itemName + "\"," +
                        "\"quantity\":" + quantity + "," +
                        "\"total_amount\":" + totalAmount + "," +
                        "\"tax_free_amount\":0," +
                        "\"approval_url\":\"http://localhost/BoardWeb/main.do\"," +
                        "\"fail_url\":\"http://localhost:8080/kakaoPayFailure\"," +
                        "\"cancel_url\":\"http://localhost:8080/kakaoPayCancel\"" +
                        "}";

        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "SECRET_KEY " + SECRET_KEY);
        headers.put("Content-Type", "application/json");

        // 요청 보내기
        String result = sendRequest(url, method, headers, params);

        // JSON에서 결제 URL 추출
        String redirectUrl = extractRedirectUrl(result);
        if (redirectUrl == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "결제 URL을 찾을 수 없습니다.");
        } else {
            resp.sendRedirect(redirectUrl);
        }
    }
    private String sendRequest(String url, String method, Map<String, String> headers, String params) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        con.setDoOutput(true);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            con.setRequestProperty(entry.getKey(), entry.getValue());
        }

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = params.getBytes("utf-8");
            os.write(input, 0, input.length);
            os.flush();
        }

        int responseCode = con.getResponseCode();
        BufferedReader br;
        
        if (responseCode == 200) { // 정상 응답
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        } else { // 오류 응답 (예: 400, 401, 500 등)
            br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
        }

        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }

        System.out.println("Response Code: " + responseCode);
        System.out.println("Response: " + response.toString());

        return response.toString();
    }

    private String extractRedirectUrl(String json) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        
        // next_redirect_pc_url이 존재하는지 확인하고 처리
        if (jsonObject.has("next_redirect_pc_url")) {
            return jsonObject.get("next_redirect_pc_url").getAsString();
        } else {
            return null;  // 값이 없으면 null을 반환
        }
    }
}