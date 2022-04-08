package com.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relation.pojo.po.TagChangeLogPo;

public interface TagChangeLogService extends IService<TagChangeLogPo> {

    int syncTagChangeLog();

    TagChangeLogPo findByFlagId(String id);
}
