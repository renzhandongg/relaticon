package com.relation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.TagChangeLogMapper;
import com.relation.pojo.po.TagChangeLogPo;
import com.relation.pojo.po.VwTagPo;
import com.relation.service.TagChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagChangeLogServiceImpl extends ServiceImpl<TagChangeLogMapper, TagChangeLogPo> implements TagChangeLogService{
    @Autowired
    private TagChangeLogMapper tagChangeLogMapper;

    @Override
    public int syncTagChangeLog() {
        return tagChangeLogMapper.syncTagChangeLog();
    }

    @Override
    public TagChangeLogPo findByFlagId(String id) {
        QueryWrapper<TagChangeLogPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("flag_id",id);
        return baseMapper.selectOne(queryWrapper);
    }
}
