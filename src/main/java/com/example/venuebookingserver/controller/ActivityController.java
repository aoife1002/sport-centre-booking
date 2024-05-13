package com.example.venuebookingserver.controller;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.Activity;
import com.example.venuebookingserver.service.ActivityService;
import com.example.venuebookingserver.vo.ActivityQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/activity")
@Controller
public class ActivityController {

    @Autowired
    ActivityService activityService;

    /**
     * 添加活动
     * @param activity 活动 (type, activityType, startTime, endTime,capacity)
     * @return R
     */
    @ResponseBody
    @PostMapping("/add")
    public R addActivity(@RequestBody Activity activity) {
        return activityService.addActivity(activity);
    }

    /**
     * 获取活动 （条件查询）
     * @param param 查询参数 (type, startTime, endTime, showAll)
     * @return R
     */
    @ResponseBody
    @PostMapping("/list")
    public R getActivity(@RequestBody ActivityQuery param) {
        return activityService.getActivity(param);
    }

    /**
     * 更新活动
     * @param activity 活动 (id, (可选 type, activityType, startTime, endTime,capacity))
     * @return R
     */
    @ResponseBody
    @PutMapping("/update")
    public R updateActivity(@RequestBody Activity activity) {
        return activityService.updateActivity(activity);
    }

    /**
     * 删除活动
     * @param id 活动id
     * localhost:8080/activity/id=1
     * @return R
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public R deleteActivityById(@PathVariable("id") Long id) {
        return activityService.deleteActivityById(id);
    }

}

// 前端上传图片
// 1、上传图片到服务器 然后把图片在服务器什么路径 保存下来 数据库里面
// 2、上传图片到第三方的（学校的图床，阿里的oss的服务） 然后把返回链接保存 保存下来
// 3、图片给他编码（一长串的code 字符串），然后保存下来 返回的时候 解码

