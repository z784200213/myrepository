package com.annotationtest.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.annotationtest.entity.UserInfor;
import org.springframework.util.ResourceUtils;
import org.apache.commons.io.FileUtils;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class JsonData {
    public static List<UserInfor> jsonDataString() {
        List<UserInfor> cmpNos = new ArrayList<UserInfor>();
        try {
            String jsonData = FileUtils.readFileToString(ResourceUtils.
                    getFile("classpath:cmp2.json"), Charset.forName("UTF-8"));
            JSONArray jsonObject = JSONArray.parseArray(jsonData);
         /*   JSONArray jsonArray = jsonObject.getJSONArray("rows");
            for (int i = 0; i < jsonArray.size(); i++) {
                *//*CmpNo cmpNo = new CmpNo();
                JSONArray jsonArray1 = jsonArray.getJSONArray(i);
                cmpNo.setId(jsonArray1.getInteger(0));
                cmpNo.setName(jsonArray1.getString(1));
                cmpNo.setType(jsonArray1.getString(2));
                cmpNo.setItype(jsonArray1.getInteger(3));
                cmpNos.add(cmpNo);*//*
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cmpNos;
    }
}
