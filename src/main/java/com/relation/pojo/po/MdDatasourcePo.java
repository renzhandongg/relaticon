package com.relation.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 数据源：md_datasource
 */
@TableName("md_datasource")
@Data
public class MdDatasourcePo {
    private Long id;

    private String dsName;

    private String identifier;

    private String dsType;

    private Integer createUserId;

    private Integer mountNodeId;

    private Date effectiveTime;

    private String product;

    private String contextPath;

    private Date creationDate;

    private String operationSystem;

    private String version;

    private String databaseInstance;

    private String description;

    private String department;

    private String manager;

    private Date collectTime;

    private Boolean hassim;

    private Integer taskTypeCount;

    private Integer sourceType;

    private String network;

    private Integer businessManager;

    private Integer techniqueManager;

    private Integer contactPerson;

    private Integer driverOption;

    private Integer validState;

    private Integer dsCnModifyUserId;

    private String dsCnModifyUserName;

    private Date dsCnModifiedDate;
}
