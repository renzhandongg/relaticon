package com.relation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.PhpMapper;
import com.relation.dao.VwTagMapper;
import com.relation.pojo.dto.SoruceClassDto;
import com.relation.pojo.dto.SourceInfoDto;
import com.relation.pojo.po.VwTagPo;
import com.relation.service.PhpService;
import com.relation.service.VwTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhpServiceImpl extends ServiceImpl<PhpMapper, Object> implements PhpService {
    @Autowired
    private PhpMapper phpMapper;


    @Override
    public List<SourceInfoDto> searchSourceInfo(String source) {
        Map<String,Object> map = new HashMap<>();
        map.put("source",source+"%");
        return phpMapper.searchSourceInfo(map);
    }

    @Override
    public List<SoruceClassDto> searchSourceClass(String contextPath) {
        Map<String,Object> map = new HashMap<>();
        map.put("contextPath",contextPath+"%");
        return phpMapper.searchSourceClass(map);
    }
}
