package com.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relation.pojo.dto.SoruceClassDto;
import com.relation.pojo.dto.SourceInfoDto;
import com.relation.pojo.dto.SystemDetails;
import com.relation.pojo.ov.SystemClass;
import com.relation.pojo.ov.SystemType;

import java.util.List;

public interface SystemService extends IService<Object> {

    List<String> findBySystemList();

    List<SystemType> findBySystemType(String systemName);

    List<SystemType> findBySystemClass(String systemName);

    List<SystemClass> findSystemTypeList(SystemDetails systemDetails);

    int findSystemTypeListCount(SystemDetails systemDetails);

    List<SystemClass> findSystemClassList(SystemDetails systemDetails);

    int findSystemClassListCount(SystemDetails systemDetails);
}
