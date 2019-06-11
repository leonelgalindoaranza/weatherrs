package com.weather.sample.util;

import com.weather.sample.security.exception.WeatherSecurityException;

public interface CriptoHash {
    String decodeHash() throws WeatherSecurityException;
}
