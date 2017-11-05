package com.iceDarron.data.dao.impl;

import com.iceDarron.core.cache.RedisManger;
import com.iceDarron.data.dao.ICodeTypeDao;
import com.iceDarron.data.po.CodeType;
import com.iceDarron.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CodeTypeDaoImpl {

    @Autowired
    RedisManger redisManger;

    public List<CodeType> getAll() {
        Jedis jedis = redisManger.getResource();
        Map<String, String> map = jedis.hgetAll(ConstantUtils.HKEY_CODE_TYPE);
        List<CodeType> codeTypes = map2CodeTypes(map);


        return null;
    }

    public CodeType getByName(String name) {
            String values = "";
            CodeType codeType = new CodeType();
        return null;
    }

    /**
     * 将redis存储的哈希数据转换为数据库对应对象
     */
    private List<CodeType> map2CodeTypes(Map<String, String> map) {
        List<CodeType> codeTypes = new ArrayList<CodeType>();
        for (Map.Entry entry : map.entrySet()) {
            String[] values = entry.getValue().toString().split(ConstantUtils.SEPARATIVE_SIGN);
            CodeType codeType = new CodeType();
            codeType.setC_ID(values[0]);
            codeType.setC_Name(values[1]);
            codeType.setC_IsValid(values[2]);
            codeType.setC_IsMaintain(values[3]);
            codeTypes.add(codeType);
        }
        return codeTypes;
    }
}
