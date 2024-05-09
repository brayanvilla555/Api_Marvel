package com.app.marvel.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


@Component("md5Encoder")
public class EncodeMD5 {
    public String encode(CharSequence input) {
        return DigestUtils.md5DigestAsHex(input.toString().getBytes());
    }

    public boolean matches(CharSequence rawPassword, String encodePassword){
        return encodePassword.equals(this.encode(rawPassword));
    }
}
