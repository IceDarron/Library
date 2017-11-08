package com.iceDarron.data.cache;

import com.iceDarron.data.dao.ICodeDao;
import com.iceDarron.data.dao.ICodeTypeDao;
import com.iceDarron.data.po.Code;
import com.iceDarron.data.po.CodeType;
import com.iceDarron.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InitCache extends HttpServlet {

    @Autowired
    private RedisManger redisManger;

    @Autowired
    private ICodeTypeDao iCodeTypeDao;

    @Autowired
    private ICodeDao iCodeDao;

    // Servlet的init方法会在Tomcat启动的时候执行
    @Override
    public void init() throws ServletException {
        // 为了加载springBean
        super.init();
        WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);

        // 具体加载类
        initCodeType();
        initCode();


    }

    private void initCodeType() {
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

    private void initCode() {
        List<Code> codeList = iCodeDao.getAll();
        if (codeList != null && !codeList.isEmpty()) {
            Jedis jedis = redisManger.getResource();

            for (Code code : codeList) {
                Map map = new HashMap();
                map.put(code.getC_Code(),
                        code.getC_Code()
                                + ConstantUtils.SEPARATIVE_SIGN + code.getC_Name());
                jedis.hmset(ConstantUtils.HKEY_CODE, map);
            }
        }
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
