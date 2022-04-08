package com.relation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.TagAuditLogMapper;
import com.relation.pojo.po.TagAuditLogPo;
import com.relation.service.TagAuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagAuditLogServiceImpl extends ServiceImpl<TagAuditLogMapper, TagAuditLogPo> implements TagAuditLogService {
    @Autowired
    private TagAuditLogMapper tagAuditLogMapper;

}
