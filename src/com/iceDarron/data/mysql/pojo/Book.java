package com.iceDarron.data.mysql.pojo;

import java.sql.Timestamp;

public class Book {

	// 主键
	private String C_ID;
	
	// 书编码
	private String C_BOOKID;
	
	// 书名称
	private String C_BOOKNAME;
	
	// 作者
	private String C_AUTHOR;
	
	// 编辑者
	private String C_EDITOR;
	
	// 翻译者
	private String C_TRANSLATOR;
	
	// 出版社
	private String C_PUBLISHER;
	
	// 出版年
	private Timestamp D_PUBLICATIONYEAR;
	
	// 版本
	private int N_VERSION;
	
	// 第几次印刷
	private int N_PRINTTIMES;
	
	// 印刷数
	private int N_PRINTNUMBER;
	
	// 价格
	private double N_PRICE;
	
	// 分类
	private String C_CATEGORY;
	
	// 描述
	private String C_DESCRIPTION;

	public String getC_ID() {
		return C_ID;
	}

	public void setC_ID(String c_ID) {
		C_ID = c_ID;
	}

	public String getC_BOOKID() {
		return C_BOOKID;
	}

	public void setC_BOOKID(String c_BOOKID) {
		C_BOOKID = c_BOOKID;
	}

	public String getC_BOOKNAME() {
		return C_BOOKNAME;
	}

	public void setC_BOOKNAME(String c_BOOKNAME) {
		C_BOOKNAME = c_BOOKNAME;
	}

	public String getC_AUTHOR() {
		return C_AUTHOR;
	}

	public void setC_AUTHOR(String c_AUTHOR) {
		C_AUTHOR = c_AUTHOR;
	}

	public String getC_EDITOR() {
		return C_EDITOR;
	}

	public void setC_EDITOR(String c_EDITOR) {
		C_EDITOR = c_EDITOR;
	}

	public String getC_TRANSLATOR() {
		return C_TRANSLATOR;
	}

	public void setC_TRANSLATOR(String c_TRANSLATOR) {
		C_TRANSLATOR = c_TRANSLATOR;
	}

	public String getC_PUBLISHER() {
		return C_PUBLISHER;
	}

	public void setC_PUBLISHER(String c_PUBLISHER) {
		C_PUBLISHER = c_PUBLISHER;
	}

	public Timestamp getD_PUBLICATIONYEAR() {
		return D_PUBLICATIONYEAR;
	}

	public void setD_PUBLICATIONYEAR(Timestamp d_PUBLICATIONYEAR) {
		D_PUBLICATIONYEAR = d_PUBLICATIONYEAR;
	}

	public int getN_VERSION() {
		return N_VERSION;
	}

	public void setN_VERSION(int n_VERSION) {
		N_VERSION = n_VERSION;
	}

	public int getN_PRINTTIMES() {
		return N_PRINTTIMES;
	}

	public void setN_PRINTTIMES(int n_PRINTTIMES) {
		N_PRINTTIMES = n_PRINTTIMES;
	}

	public int getN_PRINTNUMBER() {
		return N_PRINTNUMBER;
	}

	public void setN_PRINTNUMBER(int n_PRINTNUMBER) {
		N_PRINTNUMBER = n_PRINTNUMBER;
	}

	public double getN_PRICE() {
		return N_PRICE;
	}

	public void setN_PRICE(double n_PRICE) {
		N_PRICE = n_PRICE;
	}

	public String getC_CATEGORY() {
		return C_CATEGORY;
	}

	public void setC_CATEGORY(String c_CATEGORY) {
		C_CATEGORY = c_CATEGORY;
	}

	public String getC_DESCRIPTION() {
		return C_DESCRIPTION;
	}

	public void setC_DESCRIPTION(String c_DESCRIPTION) {
		C_DESCRIPTION = c_DESCRIPTION;
	}
	
}
