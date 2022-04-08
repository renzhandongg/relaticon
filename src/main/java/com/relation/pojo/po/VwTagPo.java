package com.relation.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
/**
 * 标签项：vw_tag
 */
@TableName("vw_tag")
@Data
public class VwTagPo {
    private String id;

    private String tagTypeId;

    private String tagTypeName;

    private String tagValueId;

    private String tagValueName;

    private Date createDate;

    private Date modifiedDate;

    private String status;

    private Boolean isDeleted;

    private String appId;

    private String contextId;

    private String contextString;

    private String appName;
}
