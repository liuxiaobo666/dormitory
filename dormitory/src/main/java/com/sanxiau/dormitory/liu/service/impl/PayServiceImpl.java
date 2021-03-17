package com.sanxiau.dormitory.liu.service.impl;

import com.alipay.api.AlipayApiException;
import com.sanxiau.dormitory.liu.alipay.Alipay;
import com.sanxiau.dormitory.liu.alipay.AlipayBean;
import com.sanxiau.dormitory.liu.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private Alipay alipay;

	public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
		return alipay.pay(alipayBean);
	}

}
