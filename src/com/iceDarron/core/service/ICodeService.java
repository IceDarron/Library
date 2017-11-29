package com.iceDarron.core.service;

import com.iceDarron.data.po.Code;

import java.util.List;

public interface ICodeService {

    /**
     * 根据父类型id获取所有子类型
     *
     * @param pid
     */
    public List<Code> getByPid(String pid);

}
