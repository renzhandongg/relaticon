package com.relation.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 获取字段标签的表：vw_object_tag_relation_column
 */
@TableName("vw_object_tag_relation_column")
@Data
public class VwObjectTagRelationColumnPo implements Serializable {
    //id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //物理字段标签
    @TableField(value = "tag")
    private String tag;

    //物理字段名称
    @TableField(value = "col")
    private String col;

    //物理字段描述
    @TableField(value = "col_desc")
    private String colDesc;

    //物理字段所属表
    @TableField(value = "table_name")
    private String tableName;

    //表id
    @TableField(value = "table_id")
    private String tableId;

    //字段id
    @TableField(value = "col_id")
    private String colId;

    //标签类型
    @TableField(value = "tag_type")
    private String tagType;

    //创建时间
    @TableField(value = "create_time")
    private Date createTime;

    //更新时间
    @TableField(value = "update_time")
    private Date updateTime;
}
