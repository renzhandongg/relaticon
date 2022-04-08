package com.relation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.relation.pojo.dto.SoruceClassDto;
import com.relation.pojo.dto.SourceInfoDto;
import com.relation.pojo.po.VwTagPo;

import java.util.List;
import java.util.Map;

public interface PhpMapper extends BaseMapper<Object> {

    List<SourceInfoDto> searchSourceInfo(Map<String,Object> map);

    List<SoruceClassDto> searchSourceClass(Map<String, Object> map);
}
