package com.relation.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 目的表(存储标签变更日志的表)：tag_change_log
 */
@TableName("tag_change_log")
@Data
public class TagChangeLogPo implements Serializable {
    //主键
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //标识id
    @TableField(value = "flag_id")
    private String flagId;

    //表或字段id
    @TableField(value = "tab_col_id")
    private Long tabColId;

    //表名/字段英文名
    @TableField(value = "tab_col_name")
    private String tabColName;

    //数据源
    @TableField(value = "source")
    private String source;

    //上下文路径
    @TableField(value = "context_path")
    private String contextPath;

    //标签名称
    @TableField(value = "tag")
    private String tag;

    //类别（1为表，2为字段）
    @TableField(value = "data_type")
    private String dataType;

    //标签变更状态：变更、删除
    @TableField(value = "status")
    private String status;

    //已确认、待确认
    @TableField(value = "tag_type")
    private String tagType;

    //操作人（脚本打标记为system）
    @TableField(value = "operator")
    private String operator;

    //创建日期
    @TableField(value = "create_time")
    private Date createTime;

}
