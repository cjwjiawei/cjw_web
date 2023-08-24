package com.cjw.cjw_admin;


import com.cjw.cjw_admin.vo.AjaxResult;
import com.cjw.cjw_admin.vo.CalculateVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.annotation.Validated;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CjwAdminApplicationTests {


    @Test
   public void contextLoads() {
       String str ="_0";
        String[] s = str.split("_");
        System.out.println(s.length);
    }

    @Test
    public void  test01(){
        CalculateVo vo = new CalculateVo();
        vo.setApr("200.0");
        vo.setYears(4);
        vo.setLoan("6000.00");
        String seccess = AjaxResult.seccess(vo);
        System.out.println(seccess);

    }
    @Test
    public void test02(){
        System.out.println(AjaxResult.Type.SUCCESS);
    }
}
