package com.ax.shop.mapper;


import com.ax.shop.dto.JobAndTriggerDto;
//import javafx.scene.control.Pagination;


/**  
* @ClassName: JobAndTriggerMapper  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年3月15日 上午10:02:48  
* @version V1.0  
*/ 
public interface JobAndTriggerMapper {

//	List<JobAndTriggerDto> getJobAndTriggerDetails(Pagination page);
	
	JobAndTriggerDto getJobAndTriggerDto();
}
