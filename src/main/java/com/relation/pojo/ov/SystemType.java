package com.relation.pojo.ov;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemType implements Serializable {
    //系统名称
    private String systemName;
    //总表数
    private Integer tableNum;
    //标签名称
    private String tagName;
    //标签数量
    private Integer tagNum;
    //占比
    private Double proPortion;
}
