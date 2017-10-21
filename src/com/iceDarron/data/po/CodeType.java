package com.iceDarron.data.po;

import java.io.Serializable;

public class CodeType implements Serializable {

    // 代码类型编号
    private String C_ID;

    // 代码类型名称
    private String C_Name;

    // 是否有效
    private String N_IsValid;

    // 是否可维
    private String N_IsMaintain;

    public String getC_ID() {
        return C_ID;
    }

    public void setC_ID(String c_ID) {
        C_ID = c_ID;
    }

    public String getC_Name() {
        return C_Name;
    }

    public void setC_Name(String c_Name) {
        C_Name = c_Name;
    }

    public String getN_IsValid() {
        return N_IsValid;
    }

    public void setN_IsValid(String n_IsValid) {
        N_IsValid = n_IsValid;
    }

    public String getN_IsMaintainH() {
        return N_IsMaintain;
    }

    public void setN_IsMaintainH(String n_IsMaintain) {
        N_IsMaintain = n_IsMaintain;
    }
}
