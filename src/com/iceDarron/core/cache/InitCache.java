package com.iceDarron.core.cache;

import com.iceDarron.data.dao.ICodeTypeDao;
import com.iceDarron.data.po.CodeType;
import com.iceDarron.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InitCache extends HttpServlet {

    @Autowired
    private RedisManger redisManger;

    @Autowired
    private ICodeTypeDao iCodeTypeDao;

    // Servlet的init方法会在Tomcat启动的时候执行
    @Override
    public void init() throws ServletException {
        initClassifyBook();


    }

    private void initClassifyBook() {
        List<CodeType> codeTypeList = iCodeTypeDao.getAll();
        if (codeTypeList != null && !codeTypeList.isEmpty()) {
            Jedis jedis = redisManger.getResource();

            for (CodeType codeType : codeTypeList) {
                Map map = new HashMap();
                map.put(codeType.getC_ID(),
                        codeType.getC_ID()
                        + ConstantUtils.SEPARATIVE_SIGN + codeType.getC_Name()
                        + ConstantUtils.SEPARATIVE_SIGN + codeType.getC_IsMaintain()
                        + ConstantUtils.SEPARATIVE_SIGN + codeType.getC_IsValid());
                jedis.hmset(ConstantUtils.HKEY_CODE_TYPE, map);
            }
        }
    }
}
