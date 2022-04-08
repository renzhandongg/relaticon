package com.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relation.pojo.po.VwTagPo;

public interface VwTagService extends IService<VwTagPo> {

    VwTagPo findTagValueId(String tagDomainId);
}
