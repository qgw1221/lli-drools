package com.sky.lli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.lli.dao.BaseRuleActionParamValueInfoMapper;
import com.sky.lli.exception.ExceptionEnum;
import com.sky.lli.exception.ServiceException;
import com.sky.lli.model.BaseRuleActionParamValueInfo;
import com.sky.lli.service.RuleActionParamValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleActionParamValueServiceImpl
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
@Service
public class RuleActionParamValueServiceImpl implements RuleActionParamValueService {

    @Resource
    private BaseRuleActionParamValueInfoMapper baseRuleActionParamValueInfoMapper;

    /**
     * Date 2017/7/24
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 根据动作参数或动作与规则关系id获取对应的参数信息
     *
     * @param baseRuleActionParamValueInfo 参数
     * @param page                         分页参数
     */
    @Override
    public PageInfo<BaseRuleActionParamValueInfo> findBaseRuleActionParamValueInfoPage(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleActionParamValueInfo> list = this.baseRuleActionParamValueInfoMapper.findBaseRuleActionParamValueInfoList(baseRuleActionParamValueInfo);
        return new PageInfo<>(list);
    }

    /**
     * Date 2017/7/27
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 根据参数id获取参数value
     *
     * @param paramId 参数id
     */
    @Override
    public BaseRuleActionParamValueInfo findRuleParamValueByActionParamId(Long paramId) {
        if (null == paramId) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }
        return this.baseRuleActionParamValueInfoMapper.findRuleParamValueByActionParamId(paramId);
    }
}
