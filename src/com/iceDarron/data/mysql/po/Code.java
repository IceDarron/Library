package com.iceDarron.data.mysql.po;

import java.io.Serializable;

public class Code implements Serializable {

    // 代码类型编号
    private String C_PID;

    // 代码
    private String C_Code;

    // 代码名称
    private String C_Name;

    // 可否维护
    private String N_KWH;

    // 分级信息
    private String C_LevelInfo;

    // 是否有效
    private String N_Valid;

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

    public String getN_KWH() {
        return N_KWH;
    }

    public void setN_KWH(String n_KWH) {
        N_KWH = n_KWH;
    }

    public String getC_LevelInfo() {
        return C_LevelInfo;
    }

    public void setC_LevelInfo(String c_LevelInfo) {
        C_LevelInfo = c_LevelInfo;
    }

    public String getN_Valid() {
        return N_Valid;
    }

    public void setN_Valid(String n_Valid) {
        N_Valid = n_Valid;
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
