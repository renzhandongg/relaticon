package com.relation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.relation.pojo.dto.SoruceClassDto;
import com.relation.pojo.dto.SourceInfoDto;
import com.relation.pojo.ov.SystemClass;
import com.relation.pojo.ov.SystemType;

import java.util.List;
import java.util.Map;

public interface SystemMapper extends BaseMapper<Object> {

    List<String> findBySystemList();

    List<SystemType> findBySystemType(String systemName);

    List<SystemType> findBySystemClass(String systemName);

    List<SystemClass> findSystemTypeList(Map map);

    int findSystemTypeListCount(Map map);

    List<SystemClass> findSystemClassList(Map map);

    int findSystemClassListCount(Map map);
}
