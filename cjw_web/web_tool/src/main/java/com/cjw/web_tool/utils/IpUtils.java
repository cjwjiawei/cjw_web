package com.cjw.web_tool.utils;


import javax.servlet.http.HttpServletRequest;

public class IpUtils {

    /**
     * 获取IP地址
     * @return
     */
    public static String getIpAddr(HttpServletRequest request){

        ;
//        String remoteAddr = request.getRemoteAddr();
        String ip = request.getHeader("X-Real-IP");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(',');
            if (index != -1) {
                //只获取第一个值
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            //取不到真实ip则返回空，不能返回内网地址。
            return "";
        }
    }
}
