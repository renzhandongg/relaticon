package com.relation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.TagChangeLogMapper;
import com.relation.dao.VwObjectTagRelationMapper;
import com.relation.pojo.po.TagChangeLogPo;
import com.relation.pojo.po.VwObjectTagRelationPo;
import com.relation.service.TagChangeLogService;
import com.relation.service.VwObjectTagRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VwObjectTagRelationServiceImpl extends ServiceImpl<VwObjectTagRelationMapper, VwObjectTagRelationPo> implements VwObjectTagRelationService {
    @Autowired
    private VwObjectTagRelationMapper vwObjectTagRelationMapper;


    @Override
    public VwObjectTagRelationPo findById(String id) {
        QueryWrapper<VwObjectTagRelationPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return baseMapper.selectOne(queryWrapper);
    }
}
