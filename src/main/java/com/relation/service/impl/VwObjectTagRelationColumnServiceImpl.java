package com.relation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.VwObjectTagRelationColumnMapper;
import com.relation.dao.VwObjectTagRelationMapper;
import com.relation.pojo.po.VwObjectTagRelationColumnPo;
import com.relation.pojo.po.VwObjectTagRelationPo;
import com.relation.service.VwObjectTagRelationColumnService;
import com.relation.service.VwObjectTagRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VwObjectTagRelationColumnServiceImpl extends ServiceImpl<VwObjectTagRelationColumnMapper, VwObjectTagRelationColumnPo> implements VwObjectTagRelationColumnService {
    @Autowired
    private VwObjectTagRelationColumnMapper vwObjectTagRelationColumnMapper;


    @Override
    public VwObjectTagRelationColumnPo findById(String id) {
        QueryWrapper<VwObjectTagRelationColumnPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return baseMapper.selectOne(queryWrapper);
    }
}
