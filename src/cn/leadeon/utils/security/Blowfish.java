/*
 * 文 件 名:  Blowfish.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014-4-23,  All rights reserved  
 */
package cn.leadeon.utils.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * 
 *文件与文件加加密算法
 * 
 * @author  liudongdong
 * @version  [1.0, 2014年6月6日]
 * @since [中国移动手机营业厅BSS系统]
 */
public class Blowfish {
	static String CIPHER_NAME = "Blowfish/CFB8/NoPadding";
	static String KEY_SPEC_NAME = "Blowfish";
	static SecretKeySpec secretKeySpec = null;
	static IvParameterSpec ivParameterSpec = null;
	static Cipher enCipher;
	static Cipher deCipher;
	public static String CIPHER_KEY = "6vrza+AH5FY=";
	static String message = "alipayUser=tbtest1011@taobaotest.com|suspend=0|phone=null|nick=昵称|alipayId=20880020073791450156|email=tbtest1011@taobaotest.com|punish=null";
	static String data = "50D3AD00492930A9CB32C29CE8946288FD9F1EF8E4D30D3A20EF3CE19CDA6B9F91C0723BF850F08600EE83CE1F305448B6284E34F8641D882CC1628D961254470CAD4E9DD40B7C79CB6BCC2D6A7CD213C95ACC431BECF47ED98311BE039C73DDD1302331FDE887678C3999C97B484C4356770341B25D01834CCCA36BC52435CBF9CC71B9AC75073668A0DC61CEA5BC";

	public static void main(String[] args) {
		String CIPHER_KEY = "6vrza+AH5FY=";
		init(CIPHER_KEY);
		try {
			System.out.println(encrypt(message));
			System.out.println(decrypt(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init(String CIPHER_KEY) {
		secretKeySpec = new SecretKeySpec(Base64.decode(CIPHER_KEY),
				KEY_SPEC_NAME);
		ivParameterSpec = new IvParameterSpec((DigestUtils.md5Hex(Base64
				.decode(CIPHER_KEY)).substring(0, 8)).getBytes());
		try {
			enCipher = Cipher.getInstance(CIPHER_NAME);
			deCipher = Cipher.getInstance(CIPHER_NAME);
			enCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
			deCipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String message) throws Exception {
		return byte2hex((enCipher.doFinal(message.getBytes("utf8"))));
	}

	public static String decrypt(String data) throws Exception {
		return new String(deCipher.doFinal(hex2byte(data)), "utf8");
	}

	public static final String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";

		for (int i = 0; i < b.length; i++) {
			stmp = Integer.toHexString(b[i] & 0xFF);

			if (stmp.length() == 1) {
				hs += "0" + stmp;
			} else {
				hs += stmp;
			}
		}

		return hs.toUpperCase();
	}

	public static final byte[] hex2byte(String hex)
			throws IllegalArgumentException {
		if (hex.length() % 2 != 0) {
			throw new IllegalArgumentException();
		}

		char[] arr = hex.toCharArray();
		byte[] b = new byte[hex.length() / 2];

		for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
			String swap = "" + arr[i++] + arr[i];
			int byteint = Integer.parseInt(swap, 16) & 0xFF;

			b[j] = new Integer(byteint).byteValue();
		}
		return b;
	}

}
