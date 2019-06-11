package com.weather.sample.client;

import com.weather.sample.constant.CurrentWeatherConstant;
import com.weather.sample.security.exception.WeatherSecurityException;
import com.weather.sample.util.impl.CriptoHashImpl;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class CurrentWeather {

    public String weatherRq(String Id) throws WeatherSecurityException {
        HttpRequest request = new HttpRequest();
        request.method(CurrentWeatherConstant.GET)
                .protocol(CurrentWeatherConstant.PROTO_SSL)
                .host(CurrentWeatherConstant.DOMAIN)
                .path(CurrentWeatherConstant.URI);

        Id = "2172797";
        request.query("id",Id);
        request.query("appid", new CriptoHashImpl().decodeHash());

        HttpResponse response = request.send();

        System.out.println("Response code: " + response.statusCode());
        System.out.println("Body: " + response.body());
        return response.body();
    }
}