package com.iceDarron.data.po;

import java.io.Serializable;

public class CodeType implements Serializable {

    // 代码类型编号
    private String C_ID;

    // 代码类型名称
    private String C_Name;

    // 是否有效
    private String C_IsValid;

    // 是否可维
    private String C_IsMaintain;

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

    public String getC_IsValid() {
        return C_IsValid;
    }

    public void setC_IsValid(String c_IsValid) {
        C_IsValid = c_IsValid;
    }

    public String getC_IsMaintain() {
        return C_IsValid;
    }

    public void setC_IsMaintain(String c_IsMaintain) {
        C_IsValid = c_IsMaintain;
    }
}
