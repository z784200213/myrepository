package com.springboot005.exception;

public enum BusinessEnum {
    Order("order","订单"),
    DistributionOrder("distribution","配送单");
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    private final String key;
    private final String value;
    private BusinessEnum(String key,String value){
        this.key=key;
        this.value=value;
    }
    //根据key获取枚举
    public static BusinessEnum getEnumByKey(String key){
        if(null == key){
            return null;
        }
        for(BusinessEnum temp:BusinessEnum.values()){
            if(temp.getKey().equals(key)){
                return temp;
            }
        }
        return null;
    }
}