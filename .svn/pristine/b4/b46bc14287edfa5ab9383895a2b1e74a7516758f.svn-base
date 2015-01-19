/*
 * 文 件 名:  Cipher.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年4月22日,  All rights reserved  
 */
package cn.leadeon.utils.security;

import java.security.MessageDigest;

/**
 * md5加密
 * 
 * @author liudongdong
 * @version [1.0, 2014年4月22日]
 * @since [中国移动手机营业厅BSS系统]
 */
public class Cipher {

	/**
	 * md5 加密算法
	 * 
	 * @param s
	 * @return
	 */
	public static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * MD5的算法在RFC1321 中定义 在RFC 1321中，给出了Test suite用来检验你的实现是否正确： MD5 ("") =
	 * d41d8cd98f00b204e9800998ecf8427e MD5 ("a") =
	 * 0cc175b9c0f1b6a831c399e269772661 MD5 ("abc") =
	 * 900150983cd24fb0d6963f7d28e17f72 MD5 ("message digest") =
	 * f96b697d7cb7938d525a2f31aaf161d0 MD5 ("abcdefghijklmnopqrstuvwxyz") =
	 * c3fcd3d76192e4007dfb496cca67e13b
	 * 
	 * @author xiaoyong.bian 传入参数：一个字节数组 传出参数：字节数组的 MD5 结果字符串
	 */
	public static String getMD5(String src) {
		String s = null;
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(src.getBytes());

			// MD5 的计算结果是一个 128 位的长整数，
			byte tmp[] = md.digest();

			// 用字节表示就是 16 个字节,每个字节用 16 进制表示的话，使用两个字符，
			char str[] = new char[16 * 2];

			// 所以表示成 16 进制需要 32 个字符,表示转换结果中对应的字符位置
			int k = 0;
			for (int i = 0; i < 16; i++) {
				// 从第一个字节开始，对 MD5 的每一个字节,转换成 16 进制字符的转换,取第 i 个字节
				byte byte0 = tmp[i];

				// 取字节中高 4 位的数字转换,
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];

				// 为逻辑右移，将符号位一起右移,取字节中低 4 位的数字转换
				str[k++] = hexDigits[byte0 & 0xf];
			}

			// 换后的结果转换为字符串
			s = new String(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(Cipher.MD5(Cipher.getMD5("may6923") + "18487c"));
		System.out.println(Cipher.getMD5("8c19c87c399a03b3ee40837febd32e4f"));
		System.out.println(Cipher.getMD5(Cipher
				.getMD5("d0bb4c87b9161fd07f79a57fb16dabd4")));

		// System.out.println(Cipher.MD5("c7b2024133e4f519105790246811220"));
	}
}
