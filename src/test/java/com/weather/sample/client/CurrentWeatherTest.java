package com.weather.sample.client;

import com.weather.sample.security.exception.WeatherSecurityException;
import com.weather.sample.util.impl.CriptoHashImpl;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.Test;

public class CurrentWeatherTest {


    @Test
    public void testRequest() throws WeatherSecurityException {
        HttpRequest request = new HttpRequest();
        request.method("GET")
                .protocol("https")
                .host("openweathermap.org")
                .path("/data/2.5/weather");

        request.query("id","4119617");
        request.query("appid",new CriptoHashImpl().decodeHash());

        HttpResponse response = request.send();

        System.out.println("Response code: " + response.statusCode());
        System.out.println("Body: " + response.body());
        System.out.println("Body Test: " + response.bodyText());
        System.out.println("FIN");
    }

}
