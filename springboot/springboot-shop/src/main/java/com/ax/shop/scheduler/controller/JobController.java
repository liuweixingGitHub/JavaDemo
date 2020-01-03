package com.ax.shop.scheduler.controller;


import com.ax.shop.controller.BaseController;
import com.ax.shop.scheduler.service.IJobAndTriggerService;
import com.ax.shop.scheduler.util.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
* @ClassName: JobController
* @Description: TODO()
* @author lixin(1309244704@qq.com)
* @date 2018年8月15日 上午10:02:00
* @version V1.0
*/
@Controller
@RequestMapping(value = "/job")
public class JobController extends BaseController {


	@Autowired
	private IJobAndTriggerService jobAndTriggerService;

	private static Logger log = LoggerFactory.getLogger(JobController.class);



	/**
	 * @Title: addJob
	 * @Description: TODO(添加Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 * @param cronExpression
	 *            表达式，如：0/5 * * * * ? (每隔5秒)
	 */
	@RequestMapping(value = "/add")
	public @ResponseBody
	ResponseEntity addJob(
			@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName,
			@RequestParam(value = "cronExpression") String cronExpression,
			HttpServletResponse response){

		try {
			System.out.println("jobClassName1 = " + jobClassName);

			Class<?> class1 = Class.forName(jobClassName);
			System.out.println("class122 = " + class1);

			jobAndTriggerService.addJob(jobClassName, jobGroupName, cronExpression);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	/**
	 * @Title: pauseJob
	 * @Description: TODO(暂停Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 */
	@RequestMapping(value = "/pause", method = RequestMethod.POST)
	public @ResponseBody
    ResponseEntity pauseJob(
			@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName,
			HttpServletResponse response) {
		try {
			jobAndTriggerService.pauseJob(jobClassName, jobGroupName);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	/**
	 * @Title: resumeJob
	 * @Description: TODO(恢复Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 */
	@RequestMapping(value = "/resume", method = RequestMethod.POST)
	public @ResponseBody
    ResponseEntity resumeJob(
			@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName,
			HttpServletResponse response) {
		try {
			jobAndTriggerService.resumejob(jobClassName, jobGroupName);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	/**
	 * @Title: rescheduleJob
	 * @Description: TODO(重新设置Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 * @param cronExpression
	 *            表达式
	 */
	@RequestMapping(value = "/reschedule", method = RequestMethod.POST)
	public @ResponseBody
    ResponseEntity rescheduleJob(
			@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName,
			@RequestParam(value = "cronExpression") String cronExpression,
			HttpServletResponse response) {
		try {
			
			jobAndTriggerService.updateJob(jobClassName, jobGroupName, cronExpression);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	/**
	 * @Title: deleteJob
	 * @Description: TODO(删除Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            表达式
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public @ResponseBody
    ResponseEntity deleteJob(@RequestParam(value = "jobClassName") String jobClassName,
							 @RequestParam(value = "jobGroupName") String jobGroupName,
                             HttpServletResponse response) {
		try {
			
			jobAndTriggerService.deleteJob(jobClassName, jobGroupName);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}


}
