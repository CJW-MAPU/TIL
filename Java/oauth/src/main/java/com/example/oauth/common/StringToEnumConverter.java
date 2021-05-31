package com.example.oauth.common;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, SocialType> {
    @Override
    public SocialType convert(String source) {
        return SocialType.valueOf(source.toUpperCase());
    }
}
