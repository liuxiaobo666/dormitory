package com.sanxiau.dormitory.liu.controller;

import com.alipay.api.AlipayApiException;
import com.sanxiau.dormitory.liu.alipay.AlipayBean;
import com.sanxiau.dormitory.liu.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单接口
 * 
 * @author Louis
 * @date Dec 12, 2018
 */
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private PayService payService;

	/**
	 * String outTradeNo流水单号, String subject流水单名称, String totalAmount总价, String body描述
	 * @param
	 * @param
	 * @return
	 * @throws AlipayApiException
	 */
	@PostMapping(value = "alipay")
	public String alipay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {

			System.out.println("outTradeNo流水单号"+outTradeNo);
			System.out.println("totalAmount总价"+totalAmount);
			AlipayBean alipayBean = new AlipayBean();
			alipayBean.setOut_trade_no(outTradeNo);
			alipayBean.setSubject(subject);
			alipayBean.setTotal_amount(totalAmount);
			alipayBean.setBody(body);
			return payService.aliPay(alipayBean);


	}
}
