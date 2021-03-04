package com.ems.util;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @author dyf
 */
public class SecurityUtil {
    private static final String KEY = "0123456789abcdef";

    public static String encode(String content){
        //随机生成密钥
        byte[] key = KEY.getBytes();
        //构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        //加密
        return aes.encryptHex(content);
    }

}
