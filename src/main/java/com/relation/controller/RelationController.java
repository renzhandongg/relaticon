package com.relation.controller;

import com.alibaba.druid.util.StringUtils;
import com.relation.pojo.po.TagAuditLogPo;
import com.relation.pojo.po.*;
import com.relation.pojo.result.ResultUtil;
import com.relation.service.*;
import com.relation.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RequestMapping("/relation")
@RestController
public class RelationController {

    //日志logger
    Logger logger = LoggerFactory.getLogger(RelationController.class);

    @Autowired
    private MdDatasourceService mdDatasourceService;

    @Autowired
    private MdTableService mdTableService;

    @Autowired
    private TagAuditLogService tagAuditLogService;

    @Autowired
    private TagChangeLogService tagChangeLogService;

    @Autowired
    private VwObjectTagRelationColumnService vwObjectTagRelationColumnService;

    @Autowired
    private VwObjectTagRelationService vwObjectTagRelationService;

    @Autowired
    private VwTagService vwTagService;



    /**
     * 业务确认打标结果:
     * @return
     */
    @PostMapping("/confirmMarking")
    @Transactional
    public ResultUtil confirmMarking(@RequestBody Map<String,Object> map){
        Integer dataType = (Integer) map.get("dataType");//数据类别：1为表，2位字段
        String id = (String) map.get("id");//标签打标结果id(vw_object_tag_relation/vw_object_tag_relation_column)
        Integer updateNum = (Integer) map.get("updateNum");//修改标签数
        String operator = (String) map.get("operator");//修改人

        if (dataType==null||(dataType!=1&&dataType!=2)){
            return ResultUtil.error("数据类别(dataType)为空或不符合规范!");
        }
        if (id==null|| StringUtils.isEmpty(id)){
            return ResultUtil.error("标签打标结果id不能为空!");
        }
        if (updateNum==null){
            return ResultUtil.error("修改标签数(updateNum)不能为空!");
        }
        if (operator==null|| StringUtils.isEmpty(operator)){
            return ResultUtil.error("修改人(operator)不能为空!");
        }

        TagAuditLogPo tagAuditLogPo = new TagAuditLogPo();
        if (dataType==1){//表打标确认
            VwObjectTagRelationPo vwObjectTagRelationPo = vwObjectTagRelationService.findById(id);
            if(vwObjectTagRelationPo==null){
                return ResultUtil.error("表标签表中无对应id数据!");
            }
            if (vwObjectTagRelationPo.getObjectId()!=null){
                MdTablePo mdTablePo = mdTableService.findById(vwObjectTagRelationPo.getObjectId());
                if (mdTablePo!=null&&mdTablePo.getDatasourceid()!=null){
                    tagAuditLogPo.setContextPath(mdTablePo.getContextPath());//上下文路径
                    MdDatasourcePo mdDatasourcePo = mdDatasourceService.getById(mdTablePo.getDatasourceid());
                    if (mdDatasourcePo!=null&&mdDatasourcePo.getDsName()!=null){
                        tagAuditLogPo.setSource(mdDatasourcePo.getDsName());//数据源
                    }else {
                        return ResultUtil.error("该数据无对应数据源！");
                    }
                }else {
                    return ResultUtil.error("该数据无对应上下文路径！");
                }
            }

        }else if (dataType==2){//字段打标确认
            VwObjectTagRelationColumnPo vwObjectTagRelationColumnPo = vwObjectTagRelationColumnService.findById(id);
            if(vwObjectTagRelationColumnPo==null){
                return ResultUtil.error("字段标签表中无对应id数据!");
            }
            if (vwObjectTagRelationColumnPo.getTableId()!=null){
                MdTablePo mdTablePo = mdTableService.findById(Long.valueOf(vwObjectTagRelationColumnPo.getTableId()));
                if (mdTablePo!=null&&mdTablePo.getDatasourceid()!=null){
                    tagAuditLogPo.setContextPath(mdTablePo.getContextPath());//上下文路径
                    MdDatasourcePo mdDatasourcePo = mdDatasourceService.getById(mdTablePo.getDatasourceid());
                    if (mdDatasourcePo!=null&&mdDatasourcePo.getDsName()!=null){
                        tagAuditLogPo.setSource(mdDatasourcePo.getDsName());//数据源
                    }else {
                        return ResultUtil.error("该数据无对应数据源！");
                    }
                }else {
                    return ResultUtil.error("该数据无对应上下文路径！");
                }
            }

        }
        tagAuditLogPo.setUpdateNum(updateNum);//修改标签数
        tagAuditLogPo.setOperator(operator);//修改人
        tagAuditLogPo.setQuerenTime(new Date());//确认时间

        boolean save = tagAuditLogService.save(tagAuditLogPo);
        return ResultUtil.success("分类分级审计日志表添加成功",tagAuditLogPo);
    }

    /**
     * 业务修改打标结果:
     * @return
     */
    @PostMapping("/modifyMarking")
    @Transactional
    public ResultUtil modifyMarking(@RequestBody Map<String,Object> map){
        Integer dataType = (Integer) map.get("dataType");//数据类别：1为表，2位字段
        String id = (String) map.get("id");//标签打标结果id(vw_object_tag_relation/vw_object_tag_relation_column)
        String operator = (String) map.get("operator");//操作人
        if (dataType==null||(dataType!=1&&dataType!=2)){
            return ResultUtil.error("数据类别(dataType)为空或不符合规范!");
        }
        if (operator==null||StringUtils.isEmpty(operator)){
            return ResultUtil.error("操作人(operator)为空!");
        }

        if (dataType==1) {//表打标修改
            VwObjectTagRelationPo vwObjectTagRelationPo = vwObjectTagRelationService.findById(id);
            TagChangeLogPo tagChangeLogPo = new TagChangeLogPo();
            if(vwObjectTagRelationPo==null){
                return ResultUtil.error("表标签表中无对应id数据!");
            }else {
                tagChangeLogPo.setFlagId(vwObjectTagRelationPo.getId().toString());//标识id
                tagChangeLogPo.setTabColId(Long.valueOf(vwObjectTagRelationPo.getObjectId()));//表或字段id
                if (vwObjectTagRelationPo.getObjectId()!=null){
                    MdTablePo mdTablePo = mdTableService.findById(vwObjectTagRelationPo.getObjectId());
                    if (mdTablePo!=null&&mdTablePo.getDatasourceid()!=null){
                        tagChangeLogPo.setTabColName(mdTablePo.getPhysicalTable());//表名/字段英文名
                        tagChangeLogPo.setContextPath(mdTablePo.getContextPath());//上下文路径
                        MdDatasourcePo mdDatasourcePo = mdDatasourceService.getById(mdTablePo.getDatasourceid());
                        if (mdDatasourcePo!=null&&mdDatasourcePo.getDsName()!=null){
                            tagChangeLogPo.setSource(mdDatasourcePo.getDsName());//数据源
                        }
                    }
                }
                VwTagPo vwTagPo = vwTagService.findTagValueId(vwObjectTagRelationPo.getTagDomainId());
                if (vwTagPo!=null){
                    tagChangeLogPo.setTag(vwTagPo.getTagValueName());//标签名称
                }
                tagChangeLogPo.setDataType("1");//类别(1为表，2为字段)
                tagChangeLogPo.setStatus("删除");//标签变更状态：变更、删除
                tagChangeLogPo.setTagType("待确认");//已确认、待确认
                tagChangeLogPo.setOperator(operator);//操作人
                tagChangeLogPo.setCreateTime(new Date());//创建日期
            }
            VwObjectTagRelationPo newVwObjectTagRelationPo = new VwObjectTagRelationPo();
            String uuid = Utils.getNumUUID(32);//随机id
            String tagDomainId = (String) map.get("tagDomainId");//标签id(分类分级的标签)
            String tagDomainName = "TAG_VALUE";//固定字段(TAG_VALUE)
            String objectDomain = "md_table";//固定字段(md_table)
            String objectDomainSource = "dmpweb";//固定字段(dmpweb)
            Date createDate = new Date();//创建日期
            Date modifiedDate = new Date();//修改日期
            String status = "VALID";//固定字段(VALID)
            newVwObjectTagRelationPo.setId(uuid);
            newVwObjectTagRelationPo.setTagDomainName(tagDomainName);
            newVwObjectTagRelationPo.setObjectDomain(objectDomain);
            newVwObjectTagRelationPo.setObjectDomainSource(objectDomainSource);
            newVwObjectTagRelationPo.setCreateDate(createDate);
            newVwObjectTagRelationPo.setModifiedDate(modifiedDate);
            newVwObjectTagRelationPo.setStatus(status);
            newVwObjectTagRelationPo.setObjectId(vwObjectTagRelationPo.getObjectId());
            if (tagDomainId==null||StringUtils.isEmpty(tagDomainId)){
                return ResultUtil.error("标签id(tagDomainId)为空!");
            }else {
                newVwObjectTagRelationPo.setTagDomainId(tagDomainId);
            }
            //1.删除vw_object_tag_relation或vw_object_tag_relation_column中对应标签
            boolean removeVwObjectTagRelationPo = vwObjectTagRelationService.removeById(vwObjectTagRelationPo.getId());
            //2.tag_change_log中新增一条删除的数据
            boolean saveTagChangeLogPo = tagChangeLogService.save(tagChangeLogPo);
            //3.向vw_object_tag_relation或vw_object_tag_relation_column中添加修改后的标签数据
            boolean saveNewVwObjectTagRelationPo = vwObjectTagRelationService.save(newVwObjectTagRelationPo);
            //4.tag_change_log中新增一条新增的数据
            TagChangeLogPo newtagChangeLogPo = tagChangeLogService.findByFlagId(newVwObjectTagRelationPo.getId());
            if (newtagChangeLogPo!=null){
                newtagChangeLogPo.setOperator(operator);
                boolean updateNewtagChangeLogPo = tagChangeLogService.updateById(newtagChangeLogPo);
            }
            return ResultUtil.success("打标结果修改成功",newVwObjectTagRelationPo);
        }else if (dataType==2){//字段打标表修改
            VwObjectTagRelationColumnPo vwObjectTagRelationColumnPo = vwObjectTagRelationColumnService.findById(id);
            TagChangeLogPo tagChangeLogPo = new TagChangeLogPo();
            if(vwObjectTagRelationColumnPo==null){
                return ResultUtil.error("字段标签表中无对应id数据!");
            }else {
                tagChangeLogPo.setFlagId(vwObjectTagRelationColumnPo.getId().toString());//标识id
                tagChangeLogPo.setTabColId(Long.valueOf(vwObjectTagRelationColumnPo.getColId()));//表或字段id
                tagChangeLogPo.setTabColName(vwObjectTagRelationColumnPo.getCol());//表名/字段英文名
                if (vwObjectTagRelationColumnPo.getTableId()!=null){
                    MdTablePo mdTablePo = mdTableService.findById(Long.valueOf(vwObjectTagRelationColumnPo.getTableId()));
                    if (mdTablePo!=null&&mdTablePo.getDatasourceid()!=null){
                        tagChangeLogPo.setContextPath(mdTablePo.getContextPath());//上下文路径
                        MdDatasourcePo mdDatasourcePo = mdDatasourceService.getById(mdTablePo.getDatasourceid());
                        if (mdDatasourcePo!=null&&mdDatasourcePo.getDsName()!=null){
                            tagChangeLogPo.setSource(mdDatasourcePo.getDsName());//数据源
                        }
                    }
                }
                tagChangeLogPo.setTag(vwObjectTagRelationColumnPo.getTag());//标签名称
                tagChangeLogPo.setDataType("2");//类别(1为表，2为字段)
                tagChangeLogPo.setStatus("删除");//标签变更状态：变更、删除
                tagChangeLogPo.setTagType("待确认");//已确认、待确认
                tagChangeLogPo.setOperator(operator);//操作人
                tagChangeLogPo.setCreateTime(new Date());//创建日期
            }
            VwObjectTagRelationColumnPo newVwObjectTagRelationColumnPo = new VwObjectTagRelationColumnPo();
            String tag = (String) map.get("tag");//物理字段标签
            Date createTime = new Date();//创建时间
            Date updateTime = new Date();//更新时间
            newVwObjectTagRelationColumnPo.setColDesc(vwObjectTagRelationColumnPo.getColDesc());
            newVwObjectTagRelationColumnPo.setCreateTime(createTime);
            newVwObjectTagRelationColumnPo.setUpdateTime(updateTime);
            newVwObjectTagRelationColumnPo.setCol(vwObjectTagRelationColumnPo.getCol());
            newVwObjectTagRelationColumnPo.setTableName(vwObjectTagRelationColumnPo.getTableName());
            newVwObjectTagRelationColumnPo.setTableId(vwObjectTagRelationColumnPo.getTableId());
            newVwObjectTagRelationColumnPo.setTagType(vwObjectTagRelationColumnPo.getTagType());
            newVwObjectTagRelationColumnPo.setColId(vwObjectTagRelationColumnPo.getColId());
            if (tag==null||StringUtils.isEmpty(tag)){
                return ResultUtil.error("物理字段标签(tag)为空!");
            }else {
                newVwObjectTagRelationColumnPo.setTag(tag);
            }
            //1.删除vw_object_tag_relation或vw_object_tag_relation_column中对应标签
            boolean removeVwObjectTagRelationColumnPo = vwObjectTagRelationColumnService.removeById(vwObjectTagRelationColumnPo.getId());
            //2.tag_change_log中新增一条删除的数据
            boolean saveTagChangeLogPo = tagChangeLogService.save(tagChangeLogPo);
            //3.向vw_object_tag_relation或vw_object_tag_relation_column中添加修改后的标签数据
            boolean saveNewVwObjectTagRelationColumnPo = vwObjectTagRelationColumnService.save(newVwObjectTagRelationColumnPo);
            //4.tag_change_log中新增一条新增的数据
            TagChangeLogPo newtagChangeLogPo = tagChangeLogService.findByFlagId(newVwObjectTagRelationColumnPo.getId().toString());
            if (newtagChangeLogPo!=null){
                newtagChangeLogPo.setOperator(operator);
                boolean updateNewtagChangeLogPo = tagChangeLogService.updateById(newtagChangeLogPo);
            }
            return ResultUtil.success("打标结果修改成功",newVwObjectTagRelationColumnPo);
        }else {
            return ResultUtil.error("数据类别(dataType)为空或不符合规范!");
        }

    }

}
