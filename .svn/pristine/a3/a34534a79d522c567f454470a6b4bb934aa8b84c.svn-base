/*
 * 文 件 名:  MyHostnameVerifier.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014-4-25,  All rights reserved  
 */
package cn.leadeon.utils.security;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * 核对主机地址
 * 
 * 实现用于主机名验证的基接口�? 在握手期间，如果 URL
 * 的主机名和服务器的标识主机名不匹配，则验证机制可以回调此接口的实现程序来确定是否应该允许此连接�?
 * 
 * @author  fei.dong
 * @version  [1.0, 2014-4-25]
 * @since [中国移动手机营业厅BSS系统]
 */

public class MyHostnameVerifier implements HostnameVerifier {
	public boolean verify(String hostname, SSLSession session) {
		if ("localhost".equals(hostname)) {
			return true;
		} else {
			return true;
		}
	}
}