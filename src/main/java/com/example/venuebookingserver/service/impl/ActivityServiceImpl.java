package com.example.venuebookingserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.venuebookingserver.common.CommonConstant;
import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.dao.ActivityMapper;
import com.example.venuebookingserver.dao.OrderMapper;
import com.example.venuebookingserver.entity.Activity;
import com.example.venuebookingserver.entity.Order;
import com.example.venuebookingserver.service.ActivityService;
import com.example.venuebookingserver.vo.ActivityQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityMapper activityMapper;

    @Autowired
    OrderMapper orderMapper;

    /**
     * 添加活动
     * @param activity 活动
     * @return R
     */
    @Override
    public R addActivity(Activity activity) {
        if (Objects.isNull(activity)) {
            return R.error("Activity cannot be empty");
        }
        if (Objects.isNull(activity.getType()) || Objects.isNull(activity.getActivityType()) || Objects.isNull(activity.getStartTime()) || Objects.isNull(activity.getEndTime())) {
            return R.error("Activity Param is empty");
        }
        if (activityMapper.insert(activity) > 0) {
            return R.success("Activity added successfully");
        }
        return R.error("Activity added failed");
    }

    /**
     * 获取活动
     * @param param 查询参数
     * @return R
     */
    @Override
    public R getActivity(ActivityQuery param) {
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        if (Objects.nonNull(param.getType())) {
            queryWrapper.eq("type", param.getType());
        }
        //where type = xx；
        if (Objects.nonNull(param.getStartTime())) {
            queryWrapper.ge("start_time", param.getStartTime());
        }

        if (Objects.nonNull(param.getEndTime())) {
            queryWrapper.le("end_time", param.getEndTime());
        }
        if(Objects.nonNull(param.getShowAll())&&!param.getShowAll()) {
            queryWrapper.ge("start_time", System.currentTimeMillis());
            queryWrapper.orderByAsc("start_time");
        }
        List<Activity> activities = activityMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(activities)) {
            return R.success("No data", Collections.emptyList());
        }
        // 判断是否已满 （流式编程 也可以用for-loop
        activities.forEach(activity -> {
            activity.setIsFull(false);
            if (CommonConstant.ACTIVITY_TYPE_PEOPLE.equals(activity.getActivityType())) {
                QueryWrapper<Order> queryWrapperOrder = new QueryWrapper<>();
                queryWrapperOrder.eq("activity_id", activity.getId());
                queryWrapperOrder.ne("status", CommonConstant.ORDER_STATUS_CANCEL);
                Long count = orderMapper.selectCount(queryWrapperOrder);
                if (count >= activity.getCapacity()) {
                    activity.setIsFull(true);
                }
            }else if (CommonConstant.ACTIVITY_TYPE_VENUE.equals(activity.getActivityType())) {
                QueryWrapper<Order> queryWrapperOrder = new QueryWrapper<>();
                queryWrapperOrder.eq("activity_id", activity.getId());
                queryWrapperOrder.ne("status", CommonConstant.ORDER_STATUS_CANCEL);
                Long count = orderMapper.selectCount(queryWrapperOrder);
                if (count > 0) {
                    activity.setIsFull(true);
                }
            }
        });
        return R.success("query was successful", activities);
    }

    /**
     * 更新活动
     * @param activity 活动
     * @return R
     */
    @Override
    public R updateActivity(Activity activity) {
        if (Objects.isNull(activity)) {
            return R.error("Activity cannot be empty");
        }
        if (Objects.isNull(activity.getId())) {
            return R.error("Activity id cannot be empty");
        }
        if (activityMapper.updateById(activity) > 0) {
            return R.success("Activity updated successfully");
        }
        return R.error("Activity updated failed");
    }

    /**
     * 删除活动
     * @param id 活动id
     * @return R
     */
    @Override
    public R deleteActivityById(Long id) {
        if (Objects.isNull(id)) {
            return R.error("Activity id cannot be empty");
        }
        if (activityMapper.deleteById(id) > 0) {
            return R.success("Activity deleted successfully");
        }
        return R.error("Activity deleted failed");
    }
}
