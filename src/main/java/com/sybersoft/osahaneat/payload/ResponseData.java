package com.sybersoft.osahaneat.payload;

public class ResponseData {
    private int status=200;
    private boolean isSeccess=true;
    private String desc;
    private  Object data;

    public boolean isSeccess() {
        return isSeccess;
    }

    public void setSeccess(boolean seccess) {
        isSeccess = seccess;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
//public class ResponseData{
//    private int status=200;
//    private boolean isSeccess=true;
//    private String desc;
//    private Object data;
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public boolean isSeccess() {
//        return isSeccess;
//    }
//
//    public void setSeccess(boolean seccess) {
//        isSeccess = seccess;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//}