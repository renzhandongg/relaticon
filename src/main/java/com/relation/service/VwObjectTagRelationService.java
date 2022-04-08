package com.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relation.pojo.po.TagChangeLogPo;
import com.relation.pojo.po.VwObjectTagRelationPo;

public interface VwObjectTagRelationService extends IService<VwObjectTagRelationPo> {

    VwObjectTagRelationPo findById(String id);
}
