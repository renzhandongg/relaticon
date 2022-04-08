package com.relation.pojo.dto;

import lombok.Data;

@Data
public class SystemDetails {
    private String systemName;//系统名
    private String name;
    private int page;//请求页
    private int count;//每页多少条
}
