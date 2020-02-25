package com.ax.shop.scheduler.service.impl;

import com.ax.shop.dto.JobAndTriggerDto;
import com.ax.shop.mapper.JobAndTriggerMapper;
import com.ax.shop.scheduler.service.IJobAndTriggerService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: JobAndTriggerImpl
 * @Description: TODO()
 * @author lixin(1309244704@qq.com)
 * @date 2018年3月15日 上午10:03:00
 * @version V1.0
 */
@Service
public class JobAndTriggerImpl implements IJobAndTriggerService {

	@Autowired
	private Scheduler scheduler;


	@Autowired
	private JobAndTriggerMapper jobAndTriggerMapper;



	@Override
	public JobAndTriggerDto getPageJobmod() {
//		return jobAndTriggerMapper.getJobAndTriggerDto();
		return null;
	}

	@Override
	public void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception {

		System.out.println("jobClassName = " + jobClassName);

		// 启动调度器
		scheduler.start();

		// 构建job信息
		JobBuilder jobBuilder = JobBuilder.newJob(getClass(jobClassName).getClass());
		jobBuilder.withIdentity(jobClassName, jobGroupName);
		JobDetail jobDetail = jobBuilder.build();

		// 表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
				.withSchedule(scheduleBuilder).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);
			System.out.println("创建定时任务成功");

		} catch (SchedulerException e) {
			System.out.println("创建定时任务失败" + e);
			throw new Exception("创建定时任务失败");
		}

	}

	@Override
	public void updateJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
			// 表达式调度构建器（动态修改后不立即执行）
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();

			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		} catch (SchedulerException e) {
			System.out.println("更新定时任务失败" + e);
			throw new Exception("更新定时任务失败");
		}
	}

	@Override
	public void deleteJob(String jobClassName, String jobGroupName) throws Exception {
		scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
	}

	@Override
	public void pauseJob(String jobClassName, String jobGroupName) throws Exception {
		scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
	}

	@Override
	public void resumejob(String jobClassName, String jobGroupName) throws Exception {
		scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
	}

	public static Job getClass(String classname) throws Exception {
		System.out.println("classname3 = " + classname);
		Class<?> class1 = Class.forName(classname);
		System.out.println("class1 = " + class1);
		return (Job) class1.newInstance();
	}

}