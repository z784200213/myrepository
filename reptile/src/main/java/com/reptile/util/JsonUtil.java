package com.reptile.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reptile.entity.UserInfor;

import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertObj2String(Object object) throws JsonProcessingException {
        String s = null;
        s = objectMapper.writeValueAsString(object);
        return s;
    }
    public static <T> T convertString2Obj(String s, Class<T> clazz) throws IOException {
        T t = null;
        t = objectMapper.readValue(s, clazz);
        return t;
    }
    public  static <T> T[]convertString2list(String s,Class<T[]>Class) throws  IOException{
        T[] result = objectMapper.readValue(s, Class);
        return result;
    }
}
