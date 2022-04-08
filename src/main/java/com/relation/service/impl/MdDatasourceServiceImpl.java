package com.relation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relation.dao.MdDatasourceMapper;
import com.relation.pojo.po.MdDatasourcePo;
import com.relation.service.MdDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MdDatasourceServiceImpl extends ServiceImpl<MdDatasourceMapper, MdDatasourcePo> implements MdDatasourceService {
    @Autowired
    private MdDatasourceMapper mdDatasourceMapper;

}
