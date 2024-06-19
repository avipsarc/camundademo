package com.camunda.avipsa.network;

import lombok.Getter;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HttpClient {

    private final OkHttpClient okHttpClient = new OkHttpClient();

    public void getData(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
