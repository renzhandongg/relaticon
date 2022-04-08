package com.relation.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 获取表标签的表：vw_object_tag_relation
 */
@TableName("vw_object_tag_relation")
@Data
public class VwObjectTagRelationPo implements Serializable {

    //id
    @TableId(value = "id")
    private String id;

    //标签id（分类分级的标签）
    @TableField(value = "tag_domain_id")
    private String tagDomainId;

    //固定字段（TAG_VALUE）
    @TableField(value = "tag_domain_name")
    private String tagDomainName;

    //表id
    @TableField(value = "object_id")
    private Long objectId;

    //固定字段(md_table)
    @TableField(value = "object_domain")
    private String objectDomain;

    //固定字段(dmpweb)
    @TableField(value = "object_domain_source")
    private String objectDomainSource;

    //创建日期
    @TableField(value = "create_date")
    private Date createDate;

    //修改日期
    @TableField(value = "modified_date")
    private Date modifiedDate;

    //固定字段（VALID）
    @TableField(value = "status")
    private String status;

    //是否被删除（0未删除，1已删除）
    @TableField(value = "is_deleted")
    private Boolean isDeleted;

}
