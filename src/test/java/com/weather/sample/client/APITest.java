package com.weather.sample.client;

import com.weather.sample.security.exception.WeatherSecurityException;
import com.weather.sample.util.impl.CriptoHashImpl;
import org.junit.Test;

public class APITest {

    @Test
    public void testCriptoHashImpl() throws WeatherSecurityException {
        CriptoHashImpl criptoHash = new CriptoHashImpl();
        System.out.println(criptoHash.decodeHash());
    }
}
