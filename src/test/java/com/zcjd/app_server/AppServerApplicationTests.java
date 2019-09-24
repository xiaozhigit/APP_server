package com.zcjd.app_server;

import com.zcjd.app_server.model.AttendanceSetPojo;
import com.zcjd.app_server.service.PersionService;
import com.zcjd.app_server.service.PersionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServerApplicationTests {
    @Autowired
    PersionService persionService;
    @Test
    public void contextLoads() {
        try {
           List<AttendanceSetPojo> attends=persionService.getCheckInAddre();
            for (AttendanceSetPojo a:attends ) {
                System.out.println(a.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
