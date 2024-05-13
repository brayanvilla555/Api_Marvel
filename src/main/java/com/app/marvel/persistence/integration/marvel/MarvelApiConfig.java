package com.app.marvel.persistence.integration.marvel;

import com.app.marvel.util.EncodeMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Component
public class MarvelApiConfig {

    @Autowired
    @Qualifier("md5Encoder")
    private EncodeMD5 encodeMD5;

    @Value("${integration.api.marvel.private-key}")
    private String PRIVATE_KEY;

    @Value("${integration.api.marvel.public-key}")
    private String PUBLIC_KEY;

    private long timeStamp = new Timestamp(System.currentTimeMillis()).getTime();

    private String getHash(){
        String cadena = Long.toString(timeStamp).concat(PRIVATE_KEY).concat(PUBLIC_KEY);
        return encodeMD5.encode(cadena);
    }

    public Map<String, String> getAuthenticationQueryParams(){
        Map<String, String> securityQueryParams = new HashMap<>();
        securityQueryParams.put("ts", String.valueOf(timeStamp));
        securityQueryParams.put("apikey", this.PUBLIC_KEY);
        securityQueryParams.put("hash", this.getHash());
        return securityQueryParams;
    }

}
