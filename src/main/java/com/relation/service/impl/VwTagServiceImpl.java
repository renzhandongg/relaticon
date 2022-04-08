package com.relation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.VwTagMapper;
import com.relation.pojo.po.VwTagPo;
import com.relation.service.VwTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VwTagServiceImpl extends ServiceImpl<VwTagMapper, VwTagPo> implements VwTagService {
    @Autowired
    private VwTagMapper vwTagMapper;

    @Override
    public VwTagPo findTagValueId(String tagDomainId) {
        QueryWrapper<VwTagPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tag_value_id",tagDomainId);
        return baseMapper.selectOne(queryWrapper);
    }
}
