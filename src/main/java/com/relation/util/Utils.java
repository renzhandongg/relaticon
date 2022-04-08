package com.relation.util;

import java.util.UUID;

public class Utils {

    public static String getNumUUID(int num){
        if (num<=0){
            return "";
        }
        StringBuffer uuid = new StringBuffer();
        int count = num/32+(num%32==0?0:1);
        for (int i=1;i<=count;i++){
            uuid.append(UUID.randomUUID());
        }
        return uuid.toString().replaceAll("-","").substring(0,num);
    }

}
