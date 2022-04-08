package com.relation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.PhpMapper;
import com.relation.dao.SystemMapper;
import com.relation.pojo.dto.SoruceClassDto;
import com.relation.pojo.dto.SourceInfoDto;
import com.relation.pojo.dto.SystemDetails;
import com.relation.pojo.ov.SystemClass;
import com.relation.pojo.ov.SystemType;
import com.relation.service.PhpService;
import com.relation.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemServiceImpl extends ServiceImpl<SystemMapper, Object> implements SystemService {
    @Autowired
    private SystemMapper systemMapper;

    @Override
    public List<String> findBySystemList() {
        return baseMapper.findBySystemList();
    }

    @Override
    public List<SystemType> findBySystemType(String systemName) {
        return baseMapper.findBySystemType(systemName);
    }

    @Override
    public List<SystemType> findBySystemClass(String systemName) {
        return baseMapper.findBySystemClass(systemName);
    }

    @Override
    public List<SystemClass> findSystemTypeList(SystemDetails systemDetails) {
        Map map = new HashMap();
        map.put("name",systemDetails.getName());
        map.put("systemName",systemDetails.getSystemName());
        map.put("page",(systemDetails.getPage()-1)*systemDetails.getCount());
        map.put("count",systemDetails.getCount());
        return baseMapper.findSystemTypeList(map);
    }

    @Override
    public int findSystemTypeListCount(SystemDetails systemDetails) {
        Map map = new HashMap();
        map.put("name",systemDetails.getName());
        map.put("systemName",systemDetails.getSystemName());
        map.put("page",(systemDetails.getPage()-1)*systemDetails.getCount());
        map.put("count",systemDetails.getCount());
        return baseMapper.findSystemTypeListCount(map);
    }

    @Override
    public List<SystemClass> findSystemClassList(SystemDetails systemDetails) {
        Map map = new HashMap();
        map.put("name",systemDetails.getName());
        map.put("systemName",systemDetails.getSystemName());
        map.put("page",(systemDetails.getPage()-1)*systemDetails.getCount());
        map.put("count",systemDetails.getCount());
        return baseMapper.findSystemClassList(map);
    }

    @Override
    public int findSystemClassListCount(SystemDetails systemDetails) {
        Map map = new HashMap();
        map.put("name",systemDetails.getName());
        map.put("systemName",systemDetails.getSystemName());
        map.put("page",(systemDetails.getPage()-1)*systemDetails.getCount());
        map.put("count",systemDetails.getCount());
        return baseMapper.findSystemClassListCount(map);
    }


}
