package com.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relation.pojo.po.MdTablePo;

public interface MdTableService extends IService<MdTablePo> {

    MdTablePo findById(Long objectId);
}
