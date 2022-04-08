package com.relation.task;

import com.relation.service.TagChangeLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * 检测标签表，字段标签表是否有新增
 */
@Component
public class SchedulerTask {
    //日志logger
    Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    @Autowired
    private TagChangeLogService tagChangeLogService;

    /**
     * 表示每隔10秒执行一次
     */
//    @Scheduled(cron = "*/10 * * * * ?")
//    private void syncTagChangeLog(){
//        tagChangeLogService.syncTagChangeLog();
//    }
}
