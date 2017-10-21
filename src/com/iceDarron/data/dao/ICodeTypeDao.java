package com.iceDarron.data.dao;

import com.iceDarron.data.po.CodeType;

import java.util.List;

/**
 * @author IceDarron
 * @Description [代码类型表]
 * @since 20171018
 */
public interface ICodeTypeDao {

    /**
     * 获取所有代码类型
     */
    public List<CodeType> getAll();

    /**
     * 通过名称获得指定代码类型
     */
    public CodeType getByName(String name);
}
