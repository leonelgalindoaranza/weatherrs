package com.weather.sample.util.impl;

import com.weather.sample.security.constant.WeatherSecurityConstants;
import com.weather.sample.security.exception.WeatherSecurityException;
import com.weather.sample.security.util.Decoder;
import com.weather.sample.security.util.Encoder;
import com.weather.sample.util.CriptoHash;

public class CriptoHashImpl implements CriptoHash {
    private String encodeHash() throws WeatherSecurityException {
        String hash = WeatherSecurityConstants.HASH;
        Encoder encoder = new Encoder();
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder(encoder.encodeBase64(hash));
        } catch (WeatherSecurityException e) {
            throw new WeatherSecurityException(e.getMessage());
        }
        return stringBuilder.toString();
    }

    public String decodeHash() throws WeatherSecurityException {
        Decoder decoder = new Decoder();
        StringBuilder stringBuilder = new StringBuilder(decoder.decodeBase64(encodeHash()));
        return stringBuilder.toString();
    }
}