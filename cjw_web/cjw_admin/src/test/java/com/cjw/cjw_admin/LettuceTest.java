package com.cjw.cjw_admin;

import org.junit.Test;
import io.lettuce.core.*;




public class LettuceTest {

    @Test
    public void testLettuceClient(){
        RedisClient.create();
    }

}
