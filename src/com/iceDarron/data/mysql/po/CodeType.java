package com.iceDarron.data.mysql.po;

import java.io.Serializable;

public class CodeType implements Serializable {

    // 代码类型编号
    private String C_ID;

    // 代码类型名称
    private String C_Name;

    // 是否有效
    private String N_Valid;

    // 是否可维
    private String N_SFKWH;

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

    public String getN_Valid() {
        return N_Valid;
    }

    public void setN_Valid(String n_Valid) {
        N_Valid = n_Valid;
    }

    public String getN_SFKWH() {
        return N_SFKWH;
    }

    public void setN_SFKWH(String n_SFKWH) {
        N_SFKWH = n_SFKWH;
    }
}
