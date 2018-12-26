package com.servant.wiki.core.baidu.aip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servant.wiki.core.entity.validate.ValidateResponse;

import net.sf.json.JSONObject;

@Service
public class ValidateService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthService authService;
	
	public ValidateResponse checkContent(String content){
		String access_token = authService.getAuth();
		 // 获取token地址
        String authHost = "https://aip.baidubce.com/rest/2.0/antispam/v2/spam?";
        String getAccessTokenUrl = authHost
                + "access_token="+access_token;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();
            
            StringBuffer sb = new StringBuffer();
            sb.append("content=").append(content);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
            
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = JSONObject.fromObject(result);
            JSONObject respone = jsonObject.getJSONObject("result");
            ValidateResponse validateResponse = (ValidateResponse) JSONObject.toBean(respone, ValidateResponse.class);
            return validateResponse;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
	}
}
