package com.iceDarron.data.dao;

import com.iceDarron.data.po.Code;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author IceDarron
 * @Description [代码表]
 * @since 20171018
 */
@Repository
public interface ICodeDao {
    /**
     * 获取所有代码
     */
    public List<Code> getAll();

    /**
     * 通过代码类型获得指定代码
     */
    public List<Code> getByPid(String pid);

    /**
     * 通过代码获得指定代码
     */
    public Code getByCode(String code);

    /**
     * 通过名称获得指定代码
     */
    public Code getByName(String name);


}
