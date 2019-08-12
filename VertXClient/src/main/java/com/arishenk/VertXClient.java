package com.arishenk;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.HttpClient;

public class VertXClient {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40)); // количество обработчиков
        HttpClientOptions options = new HttpClientOptions().
                setProtocolVersion(HttpVersion.HTTP_2).
                setSsl(true).
                setUseAlpn(true).
                setTrustAll(true);

        HttpClient client = vertx.createHttpClient(options);
        client.requestAbs(HttpMethod.GET, "https://api.vk.com/method/users.get?" +
                        "user_ids=102974978&fields=bdate&access_token=...&v=5.101",
                result -> {
                    System.out.println(result.statusCode());
                    result.bodyHandler(body -> {
                        System.out.println(body.toString());
                    });
                }).end();
    }
}