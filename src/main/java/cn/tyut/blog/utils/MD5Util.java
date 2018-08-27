package cn.tyut.blog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5对密码进行单项加密
 * MD5（Message Digest algorithm 5，信息摘要算法）
 * 通常我们不直接使用上述MD5加密。
 * 通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串
 *
 * @author zhangguoliang
 * @date 2018-05-04 14:36
 */
public class MD5Util {

    private static final String KEY_MD5 = "MD5";

    private static Logger logger = LoggerFactory.getLogger(MD5Util.class);

    /**
     * @param password 加密对象
     * @return 加密结果
     */
    public static String getResult(String password) {
        logger.info("------MD5---start...");
        BigInteger bigInteger = null;

        try {
            // 创建消息摘要对象
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            // 将password的数据传给消息摘要对象
            md.update(password.getBytes());
            bigInteger = new BigInteger(md.digest());
            logger.info("------MD5---encrypting....");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        assert bigInteger != null;
        logger.info("------MD5---finish......");
        return bigInteger.toString(16);
    }

}
