package com.relation.controller;

import com.relation.pojo.dto.SystemDetails;
import com.relation.pojo.ov.SystemClass;
import com.relation.pojo.ov.SystemType;
import com.relation.pojo.result.ResultUtil;
import com.relation.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/system")
@RestController
public class SystemController {

    @Autowired
    private SystemService systemService;

    @GetMapping("findBySystemList")
    @CrossOrigin
    public ResultUtil findBySystemList(){
        List<String> systemList = systemService.findBySystemList();
        return ResultUtil.success("查询成功",systemList);
    }

    @GetMapping("findBySystemType")
    public ResultUtil findBySystemType(String systemName){
        List<SystemType> systemList = systemService.findBySystemType(systemName);
        return ResultUtil.success("查询成功",systemList);
    }

    @GetMapping("findBySystemClass")
    public ResultUtil findBySystemClass(String systemName){
        List<SystemType> systemList = systemService.findBySystemClass(systemName);
        return ResultUtil.success("查询成功",systemList);
    }

    @PostMapping("findSystemTypeList")
    public ResultUtil findSystemTypeList(@RequestBody SystemDetails systemDetails){
        List<SystemClass> systemList = systemService.findSystemTypeList(systemDetails);
        int count = systemService.findSystemTypeListCount(systemDetails);
        Map map = new HashMap();
        map.put("list",systemList);
        map.put("total",count);
        return ResultUtil.success("查询成功",map);
    }

    @PostMapping("findSystemClassList")
    public ResultUtil findSystemClassList(@RequestBody SystemDetails systemDetails){
        List<SystemClass> systemList = systemService.findSystemClassList(systemDetails);
        int count = systemService.findSystemClassListCount(systemDetails);
        Map map = new HashMap();
        map.put("list",systemList);
        map.put("total",count);
        return ResultUtil.success("查询成功",map);
    }




}

/*

======================== 新页面接口sql ============================
-- 需要提供五个接口进行展示：主页面按照从左到右次序分为1/2/3个模块，跳转后共两个模块

-- 1.所有系统名称(共66个)  （系统名称）系统是通过路径截取出来的，系统与数据源是一对多的关系，所以没有系统id，只有数据源的id，只能通过系统名称去关联下面的关系了
select SUBSTRING_INDEX(md.context_path,'/',-1) as '对应系统' from  md_datasource md group by SUBSTRING_INDEX(md.context_path,'/',-1);

-- 2.根据'系统名称'查询对应系统分类所有数据   (类别,数量,占比)
select b.系统名称,c.总表数,b.标签名称,b.标签数量,(b.标签数量/c.总表数) as '占比'
from (
select SUBSTRING_INDEX(md.context_path,'/',-1) as '系统名称',a.tag_value_name as '标签名称',count(*) as '标签数量'
from md_table mt left join md_datasource md
on mt.datasourceId = md.id
inner join (
select votr.object_id,vt.tag_value_name
from vw_object_tag_relation votr left join vw_tag vt
on votr.tag_domain_id = vt.tag_value_id
where vt.tag_value_name not in ('公司内部','公司受限','公司机密','公司公开')
)a on mt.id = a.object_id
group by 系统名称,标签名称
order by 系统名称,标签名称)b
inner join
(select SUBSTRING_INDEX(md.context_path,'/',-1) as '系统名称',count(mt.context_path) as '总表数'
from md_table mt left join md_datasource md
on mt.datasourceId = md.id
group by 系统名称
)c on b.系统名称 = c.系统名称;

-- 3.根据'系统名称'查询对应系统分级所有数据   (级别,数量,占比)
select b.系统名称,c.总表数,b.标签名称,b.标签数量,(b.标签数量/c.总表数) as '占比'
from (
select SUBSTRING_INDEX(md.context_path,'/',-1) as '系统名称',a.tag_value_name as '标签名称',count(*) as '标签数量'
from md_table mt left join md_datasource md
on mt.datasourceId = md.id
inner join (
select votr.object_id,vt.tag_value_name
from vw_object_tag_relation votr left join vw_tag vt
on votr.tag_domain_id = vt.tag_value_id
where vt.tag_value_name in ('公司内部','公司受限','公司机密','公司公开')
)a on mt.id = a.object_id
group by 系统名称,标签名称
order by 系统名称,标签名称)b
inner join
(select SUBSTRING_INDEX(md.context_path,'/',-1) as '系统名称',count(mt.context_path) as '总表数'
from md_table mt left join md_datasource md
on mt.datasourceId = md.id
group by 系统名称
)c on b.系统名称 = c.系统名称;


-- 4.根据'系统分类标签'查询该类别所有详情数据  (数据源,库名,表英文名,表中文名,表分级,表分类,最高级别字段)
select SUBSTRING_INDEX(md.context_path,'/',-1) as '系统名',
SUBSTRING_INDEX(mt.context_path,'/',1) as '数据源',
mt.physical_db as '库名',
mt.physical_table as '表英文名',
mt.table_desc as '表中文名',
c.tag_fenji as '分级标签',
c.tag_fenlei as '分类标签'
from md_table mt left join md_datasource md
on mt.datasourceId = md.id
left join
(SELECT a.object_id,a.tag_fenji,b.tag_fenlei
from
(select votr.object_id,vt.tag_value_name as tag_fenji
from vw_object_tag_relation votr left join vw_tag vt
on votr.tag_domain_id = vt.tag_value_id
where vt.tag_value_name in ('公司内部','公司受限','公司机密','公司公开')
group by votr.object_id)a
inner join
(select votr.object_id,vt.tag_value_name as tag_fenlei
from vw_object_tag_relation votr left join vw_tag vt
on votr.tag_domain_id = vt.tag_value_id
where vt.tag_value_name NOT in ('公司内部','公司受限','公司机密','公司公开')
group by votr.object_id)b
on a.object_id = b.object_id)c
on mt.id = c.object_id
order by 系统名,数据源,库名,表英文名;


-- 5.根据'系统分级标签'查询该级别所有详情数据  (数据源,库名,表英文名,表中文名,表分级,表分类,最高级别字段)

同4

*/
