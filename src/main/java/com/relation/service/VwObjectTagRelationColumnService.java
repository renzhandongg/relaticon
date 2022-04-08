package com.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relation.pojo.po.VwObjectTagRelationColumnPo;

public interface VwObjectTagRelationColumnService extends IService<VwObjectTagRelationColumnPo> {

    VwObjectTagRelationColumnPo findById(String id);
}
