package com.cjw.cjw_admin.vo;

import com.alibaba.fastjson.JSONObject;

public class AjaxResult<T> {

    private static final String CODE_TAG="code";
    private static final String MSG_TAG ="msg";
    private static final String DATA_TAG="data";
    private static final Integer SUCCESS=200;
    private static final Integer ERROR=500;


    public T data ;

    public AjaxResult() {

    }

    public static String seccess(String msg){
        JSONObject object = new JSONObject();
        object.put(CODE_TAG,SUCCESS);
        object.put(MSG_TAG,msg);

        return object.toJSONString();
    }
    public static String erro(String msg){
        JSONObject object = new JSONObject();
        object.put(CODE_TAG,ERROR);
        object.put(MSG_TAG,msg);

        return object.toJSONString();
    }
    public static String erro(Integer codeTage, String msg){
        JSONObject object = new JSONObject();
        object.put(CODE_TAG,ERROR);
        object.put(MSG_TAG,msg);

        return object.toJSONString();
    }


    public static String seccess(Object data ){
        JSONObject object = new JSONObject();
        object.put(CODE_TAG,Type.SUCCESS);
        object.put(DATA_TAG,data);

        return object.toJSONString();
    }

    public enum Type{
        SUCCESS("SUCCESS",200),
        ERROR("",500),
        WARN("",301);
        private final int value;

        Type(String str,int value)
        {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}
