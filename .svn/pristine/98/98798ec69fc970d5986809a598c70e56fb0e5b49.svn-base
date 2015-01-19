/*
 * 文 件 名:  XXTea.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014-4-25,  All rights reserved  
 */
package cn.leadeon.utils.security;

/**
 * 
 *XXTea对称加密算法
 *cookie 加密
 *邮 箱:zhaohui@yunchuangyi.cn
 * 
 * @author  zhaohui
 * @version  [1.0, 2014年6月6日]
 * @since [中国移动手机营业厅BSS系统]
 */

public class XXTea {

//	public static String defaultConfigKey = "com.weike.common.encrypt.config";

	public static int timeout = 3000;
	/**
	 * 威客网统一XXT加密KEY
	 */
	public final static String KEY = "!cn@#^~leadeon&%(xxT)T";

//	private static String init(String appName, String version) {
//		String configKey = defaultConfigKey + "." + appName + "." + version;
//		DiamondManager diamondManager = new DefaultDiamondManager(configKey,
//				(ManagerListener) null);
//		String configString = diamondManager
//				.getAvailableConfigureInfomation(timeout);
//		return configString;
//	}
//
	public static void main(String[] argv) {

		String xxt = encrypt("admin");
		System.out.println(xxt);
		System.exit(0);

	}

	/**
	 * 加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encrypt(String str) {
		//String key = init("weike", "encrypt");
		return encrypt(str, KEY);
	}

	/**
	 * 解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decrypt(String str) {
		//String key = init("weike", "encrypt");
		return decrypt(str, KEY);
	}

	/**
	 * 先XXTea加密，后Base64加密
	 * 
	 * @author zhaohui
	 * @param str需要加密的字符串
	 *            ，key
	 * @return cookie中value加密
	 */
	public static String encrypt(String str, String key) {
		//key = init("weike", "encrypt");
		key = KEY;
		String enVid = "";
		byte[] k = key.getBytes();
		byte[] v = str.getBytes();
		enVid = new String(Base64.encode(XXTea.encrypt(v, k)));
		enVid = enVid.replace('+', '-');
		enVid = enVid.replace('/', '_');
		enVid = enVid.replace('=', '.');
		return enVid;
	}

	/**
	 * 先Base64解密，后XXXTEA解密
	 * 
	 * @param enVid
	 * @return
	 */
	public static String decrypt(String str, String key) {
		//key = init("weike", "encrypt");
		key = KEY;
		String deVid = "";
		str = str.replace('-', '+');
		str = str.replace('_', '/');
		str = str.replace('.', '=');
		byte[] k = key.getBytes();
		byte[] v = Base64.decode(str);
		deVid = new String(XXTea.decrypt(v, k));
		return deVid;
	}

	/**
	 * Encrypt data with key.
	 * 
	 * @param data
	 * @param key
	 * @return
	 */
	public static byte[] encrypt(byte[] data, byte[] key) {
		if (data.length == 0) {
			return data;
		}
		return toByteArray(encrypt(toIntArray(data, true), toIntArray(key,
				false)), false);
	}

	/**
	 * Decrypt data with key.
	 * 
	 * @param data
	 * @param key
	 * @return
	 */
	public static byte[] decrypt(byte[] data, byte[] key) {
		if (data.length == 0) {
			return data;
		}
		return toByteArray(decrypt(toIntArray(data, false), toIntArray(key,
				false)), true);
	}

	/**
	 * Encrypt data with key.
	 * 
	 * @param v
	 * @param k
	 * @return
	 */
	public static int[] encrypt(int[] v, int[] k) {
		int n = v.length - 1;

		if (n < 1) {
			return v;
		}
		if (k.length < 4) {
			int[] key = new int[4];

			System.arraycopy(k, 0, key, 0, k.length);
			k = key;
		}
		int z = v[n], y = v[0], delta = 0x9E3779B9, sum = 0, e;
		int p, q = 6 + 52 / (n + 1);

		while (q-- > 0) {
			sum = sum + delta;
			e = sum >>> 2 & 3;
			for (p = 0; p < n; p++) {
				y = v[p + 1];
				z = v[p] += (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y)
						+ (k[p & 3 ^ e] ^ z);
			}
			y = v[0];
			z = v[n] += (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y)
					+ (k[p & 3 ^ e] ^ z);
		}
		return v;
	}

	/**
	 * Decrypt data with key.
	 * 
	 * @param v
	 * @param k
	 * @return
	 */
	public static int[] decrypt(int[] v, int[] k) {
		int n = v.length - 1;

		if (n < 1) {
			return v;
		}
		if (k.length < 4) {
			int[] key = new int[4];

			System.arraycopy(k, 0, key, 0, k.length);
			k = key;
		}
		int z = v[n], y = v[0], delta = 0x9E3779B9, sum, e;
		int p, q = 6 + 52 / (n + 1);

		sum = q * delta;
		while (sum != 0) {
			e = sum >>> 2 & 3;
			for (p = n; p > 0; p--) {
				z = v[p - 1];
				y = v[p] -= (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y)
						+ (k[p & 3 ^ e] ^ z);
			}
			z = v[n];
			y = v[0] -= (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y)
					+ (k[p & 3 ^ e] ^ z);
			sum = sum - delta;
		}
		return v;
	}

	/**
	 * Convert byte array to int array.
	 * 
	 * @param data
	 * @param includeLength
	 * @return
	 */
	private static int[] toIntArray(byte[] data, boolean includeLength) {
		int n = (((data.length & 3) == 0) ? (data.length >>> 2)
				: ((data.length >>> 2) + 1));
		int[] result;

		if (includeLength) {
			result = new int[n + 1];
			result[n] = data.length;
		} else {
			result = new int[n];
		}
		n = data.length;
		for (int i = 0; i < n; i++) {
			result[i >>> 2] |= (0x000000ff & data[i]) << ((i & 3) << 3);
		}
		return result;
	}

	/**
	 * Convert int array to byte array.
	 * 
	 * @param data
	 * @param includeLength
	 * @return
	 */
	private static byte[] toByteArray(int[] data, boolean includeLength) {
		int n = data.length << 2;
		if (includeLength) {
			int m = data[data.length - 1];

			if (m > n) {
				return null;
			} else {
				n = m;
			}
		}
		byte[] result = new byte[n];

		for (int i = 0; i < n; i++) {
			result[i] = (byte) ((data[i >>> 2] >>> ((i & 3) << 3)) & 0xff);
		}
		return result;
	}

}
