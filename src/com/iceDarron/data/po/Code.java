package com.iceDarron.data.po;

import java.io.Serializable;

public class Code implements Serializable {

    // 代码类型编号
    private String C_PID;

    // 代码
    private String C_Code;

    // 代码名称
    private String C_Name;

    // 可否维护
    private String C_IsMaintain;

    // 分级信息
    private String C_LevelInfo;

    // 是否有效
    private String C_IsValid;

    // 显示顺序
    private String C_Order;

    // 代码简拼
    private String C_Dmjp;

    public String getC_PID() {
        return C_PID;
    }

    public void setC_PID(String c_PID) {
        C_PID = c_PID;
    }

    public String getC_Code() {
        return C_Code;
    }

    public void setC_Code(String c_Code) {
        C_Code = c_Code;
    }

    public String getC_Name() {
        return C_Name;
    }

    public void setC_Name(String c_Name) {
        C_Name = c_Name;
    }

    public String getC_IsMaintain() {
        return C_IsMaintain;
    }

    public void setC_IsMaintain(String c_IsMaintain) {
        C_IsMaintain = c_IsMaintain;
    }

    public String getC_LevelInfo() {
        return C_LevelInfo;
    }

    public void setC_LevelInfo(String c_LevelInfo) {
        C_LevelInfo = c_LevelInfo;
    }

    public String getC_IsValid() {
        return C_IsValid;
    }

    public void setC_IsValid(String c_IsValid) {
        C_IsValid = c_IsValid;
    }

    public String getC_Order() {
        return C_Order;
    }

    public void setC_Order(String c_Order) {
        C_Order = c_Order;
    }

    public String getC_Dmjp() {
        return C_Dmjp;
    }

    public void setC_Dmjp(String c_Dmjp) {
        C_Dmjp = c_Dmjp;
    }
}
