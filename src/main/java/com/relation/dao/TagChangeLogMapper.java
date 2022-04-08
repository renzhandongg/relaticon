package com.relation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.relation.pojo.po.TagChangeLogPo;

public interface TagChangeLogMapper extends BaseMapper<TagChangeLogPo> {

    int syncTagChangeLog();
}
