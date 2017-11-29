package com.iceDarron.core.service.impl;

import com.iceDarron.core.service.ICodeService;
import com.iceDarron.data.dao.ICodeDao;
import com.iceDarron.data.po.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("codeService")
public class CodeServiceImpl implements ICodeService {

    @Autowired
    private ICodeDao iCodeDao;

    @Override
    public List<Code> getByPid(String pid) {
        return iCodeDao.getByPid(pid);
    }
}
