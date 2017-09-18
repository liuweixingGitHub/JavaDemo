package com.ax;

import com.ax.spring.domain.IpLog;
import com.ax.spring.query.IpLogQueryObject;
import com.ax.spring.query.PageResult;
import com.ax.spring.service.IIpLogService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:application.xml")
public class IpTest extends BaseTest {

    @Autowired
    private IIpLogService ipLogService;

    public void test(){

        IpLogQueryObject queryObject = new IpLogQueryObject();
        queryObject.setBeginDate(new Date());

        queryObject.setEndDate(new Date());
        queryObject.setCurrentPage(1);
        queryObject.setPageSize(10);
        queryObject.setLike(false);
        queryObject.setUserName("jim");
        queryObject.setUserType(0);


        PageResult result = ipLogService.query(queryObject);

        System.out.println("result = " + result);


    }



}
