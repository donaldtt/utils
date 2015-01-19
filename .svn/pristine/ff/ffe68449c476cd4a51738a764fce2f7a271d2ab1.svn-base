/*
 * 文 件 名:  DateSHA.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年4月22日,  All rights reserved  
 */
package cn.leadeon.utils.security;


import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * DateSHA
 * @author  liudongdong
 * @version  [1.0, 2014年4月22日]
 * @since [中国移动手机营业厅BSS系统]
 */
public class DateSHA {
    public static final String KEY_SHA = "SHA";
    public static final String KEY_MD5 = "MD5";


    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);

        return md5.digest();

    }

    /**
     * SHA加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {

        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(data);

        return sha.digest();

    }


    /**
     * SHA加密算法
     *
     * @param inputStr
     * @return
     */
    public static String ShaEncrypt(String inputStr) {
        byte[] inputData = inputStr.getBytes();
        String returnString = "";
        try {
            inputData = encryptSHA(inputData);
            for (int i = 0; i < inputData.length; i++) {
                returnString += byteToHexString(inputData[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnString;
    }

    // 将字节转换为十六进制字符串

    private static String byteToHexString(byte ib) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                'b', 'c', 'd', 'e', 'f'};
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];

        String s = new String(ob);

        return s;
    }

    /**
     * MD5的加密算法
     *
     * @param inputStr
     * @return
     */
    public static String md5Encrypt(String inputStr) {
        byte[] inputData = inputStr.getBytes();
        String returnString = "";
        try {
            BigInteger md5 = new BigInteger(encryptMD5(inputData));
//            System.err.println("MD5:\n" + md5.toString(16));
            returnString = md5.toString(16);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnString;
    }


    public static void main(String[] args) {
//        String inputStr = "appkey5e1c3cc7a32c5bd8formatjsonmethoduser.loginpasswordmay6923uname13926523459v1.0".concat("3l6tp8t7jvaqgqh0");
//        System.out.println(ShaEncrypt(inputStr));
        System.out.println(md5Encrypt("abc"));
    }
}
