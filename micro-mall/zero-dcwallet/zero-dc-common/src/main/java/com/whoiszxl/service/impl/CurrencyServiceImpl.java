package com.whoiszxl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.whoiszxl.entity.Currency;
import com.whoiszxl.mapper.CurrencyMapper;
import com.whoiszxl.service.CurrencyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 加密货币表 服务实现类
 * </p>
 *
 * @author whoiszxl
 * @since 2021-08-03
 */
@Service
public class CurrencyServiceImpl extends ServiceImpl<CurrencyMapper, Currency> implements CurrencyService {

    @Override
    public Currency getCurrencyByName(String currencyName) {
        LambdaQueryWrapper<Currency> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Currency::getCurrencyName, currencyName);
        return this.getOne(queryWrapper);
    }
}
