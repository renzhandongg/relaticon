package com.relation.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 审计日志(最后生成代办交给业务方确认，记录操作的表)：tag_audit_log
 */
@TableName("tag_audit_log")
@Data
public class TagAuditLogPo implements Serializable {

    //主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //数据源
    @TableField(value = "source")
    private String source;

    //上下文路径
    @TableField(value = "context_path")
    private String contextPath;

    //更改标签数
    @TableField(value = "update_num")
    private Integer updateNum;

    //确认时间
    @TableField(value = "queren_time")
    private Date querenTime;

    //操作人
    @TableField(value = "operator")
    private String operator;
}
