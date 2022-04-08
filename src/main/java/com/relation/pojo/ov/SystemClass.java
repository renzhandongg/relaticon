package com.relation.pojo.ov;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemClass  implements Serializable {
    //系统名
    private String systemName;
    //数据源
    private String dataSource;
    //库名
    private String libraryName;
    //表英文名
    private String tableEng;
    //表中文名
    private String tableChi;
    //分级标签
    private String tagClass;
    //分类标签
    private String tagType;

    public SystemClass(String systemName, String dataSource, String libraryName, String tableEng, String tableChi, String tagClass, String tagType) {
        this.systemName = systemName;
        this.dataSource = dataSource;
        this.libraryName = libraryName;
        this.tableEng = tableEng;
        this.tableChi = tableChi;
        this.tagClass = tagClass;
        this.tagType = tagType;
    }
}
