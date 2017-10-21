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
    private String N_IsMaintain;

    // 分级信息
    private String C_LevelInfo;

    // 是否有效
    private String N_IsValid;

    // 显示顺序
    private String N_Order;

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

    public String getN_IsMaintain() {
        return N_IsMaintain;
    }

    public void setN_IsMaintain(String n_IsMaintain) {
        N_IsMaintain = n_IsMaintain;
    }

    public String getC_LevelInfo() {
        return C_LevelInfo;
    }

    public void setC_LevelInfo(String c_LevelInfo) {
        C_LevelInfo = c_LevelInfo;
    }

    public String getN_IsValid() {
        return N_IsValid;
    }

    public void setN_IsValid(String n_IsValid) {
        N_IsValid = n_IsValid;
    }

    public String getN_Order() {
        return N_Order;
    }

    public void setN_Order(String n_Order) {
        N_Order = n_Order;
    }

    public String getC_Dmjp() {
        return C_Dmjp;
    }

    public void setC_Dmjp(String c_Dmjp) {
        C_Dmjp = c_Dmjp;
    }
}
