package com.relation.controller;

import com.relation.pojo.dto.SoruceClassDto;
import com.relation.pojo.dto.SourceInfoDto;
import com.relation.pojo.result.ResultUtil;
import com.relation.service.PhpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/php")
@RestController
public class PhpController {

    @Autowired
    private PhpService phpService;

//    @GetMapping("searchSourceInfo/{source}")
//    public ResultUtil searchSourceInfo(@PathParam("source")String source){
//        List<SourceInfoDto> list= phpService.searchSourceInfo(source);
//        if (list==null||list.isEmpty()){
//            return ResultUtil.error("找不到对应数据源");
//        }
//        return ResultUtil.success("查询成功",list.get(0));
//    }



//    @GetMapping("searchSourceClass/{contextPath}")
//    public ResultUtil searchSourceClass(@PathParam("contextPath")String contextPath){
//        List<SoruceClassDto> list= phpService.searchSourceClass(contextPath);
//        if (list==null||list.isEmpty()){
//            return ResultUtil.error("找不到对应数据源");
//        }
//        return ResultUtil.success("查询成功",list.get(0));
//    }



    @GetMapping("searchSourceInfo")
    public ResultUtil searchSourceInfo(String source){
        List<SourceInfoDto> list= phpService.searchSourceInfo(source);
        if (list==null||list.isEmpty()){
            return ResultUtil.error("找不到对应数据源");
        }
        return ResultUtil.success("查询成功",list);
    }

    @GetMapping("searchSourceClass")
    public ResultUtil searchSourceClass(String contextPath){
        List<SoruceClassDto> list= phpService.searchSourceClass(contextPath);
        if (list==null||list.isEmpty()){
            return ResultUtil.error("找不到对应路径");
        }
        return ResultUtil.success("查询成功",list);
    }

}
