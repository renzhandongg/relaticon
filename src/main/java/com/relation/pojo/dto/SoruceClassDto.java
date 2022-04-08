package com.relation.pojo.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class SoruceClassDto implements Serializable {
    //公司公开
    private String companyDisclosure;
    //公司内部
    private String companyInside;
    //公司受限
    private String companyLimited;
    //公司机密
    private String companySecrets;

}
