package com.relation.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SourceInfoDto implements Serializable {
    //表名
    private String tableName;
    //路径
    private String path;
    //分级标签
    private String gradedLabel;
    //分类标签
    private String ClassificationLabel;
    //创建时间
    private String createDate;

}
