package com.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relation.pojo.dto.SoruceClassDto;
import com.relation.pojo.dto.SourceInfoDto;
import com.relation.pojo.po.VwTagPo;

import java.util.List;

public interface PhpService extends IService<Object> {

    List<SourceInfoDto> searchSourceInfo(String source);

    List<SoruceClassDto> searchSourceClass(String contextPath);
}
