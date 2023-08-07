package com.cjw.cjw_admin;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CjwAdminApplicationTests {


    @Test
   public void contextLoads() {
       String str ="_0";
        String[] s = str.split("_");
        System.out.println(s.length);
    }

}
