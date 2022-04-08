package com.relation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.MdTableMapper;
import com.relation.pojo.po.MdTablePo;
import com.relation.service.MdTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MdTableServiceImpl extends ServiceImpl<MdTableMapper, MdTablePo> implements MdTableService {
    @Autowired
    private MdTableMapper mdTableMapper;

    @Override
    public MdTablePo findById(Long objectId) {
        QueryWrapper<MdTablePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",objectId);
        return baseMapper.selectOne(queryWrapper);
    }
}
