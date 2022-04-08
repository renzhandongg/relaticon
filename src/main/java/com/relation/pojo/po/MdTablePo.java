package com.relation.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
/**
 * 数据表：md_table
 */
@TableName("md_table")
@Data
public class MdTablePo {
    private Long id;

    private String physicalTable;

    private String physicalDb;

    private String tableSchema;

    private Long databaseid;

    private Integer datasourceid;

    private String tableType;

    private String tableName;

    private String tableDesc;

    private Date lastModifiedTime;

    private String partitionFlag;

    private String timeField;

    private Date effectiveTime;

    private String contextPath;

    private Date createTime;

    private String isKeyTable;

    private String partitionNumbers;

    private String tableSize;

    private String dimTable;
}
