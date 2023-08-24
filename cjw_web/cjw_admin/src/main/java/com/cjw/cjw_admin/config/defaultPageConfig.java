package com.cjw.cjw_admin.config;


import com.cjw.cjw_admin.bean.DefaultView;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;


//@Configuration/**/
public class defaultPageConfig {


//    @Bean(name = "error")
//    @ConditionalOnMissingBean(name = "error")
    public View defaultErrorView() {
        return new DefaultView();
    }
}
