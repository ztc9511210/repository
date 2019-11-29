package com.cpic.obs.web.rest.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class ENC {

    public static void main(String[] args) {
        //加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("txypt");
        //应用配置
        encryptor.setConfig(config);
        String plaintext = "txypt";
        //加密
        String ciphertext = encryptor.encrypt(plaintext);
        System.out.println(plaintext + "加密后: " + ciphertext);

        //解密
        String jm = "yqSGFqIAOTDauQDaG8oyIMGh5UTLDZmLDZBJp2z/pkM=";
        String str = ciphertext;
        System.out.println("解密后: " + encryptor.decrypt(str));
        System.out.println("解密后: " + encryptor.decrypt(jm));
    }
}
