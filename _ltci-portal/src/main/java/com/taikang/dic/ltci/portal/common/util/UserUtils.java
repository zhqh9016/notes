package com.taikang.dic.ltci.portal.common.util;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.taikang.dic.ltci.portal.api.model.MenuDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.exception.TKCheckedException;

/** 用户工具类 */
public class UserUtils {

  /** ------------通用的用户密码加解密方法---------------* */
  public static final String HASH_ALGORITHM = "MD5";

  public static final int HASH_INTERATIONS = 1024;
  public static final int SALT_SIZE = 8;
  public static final String USER_NAME = "username";
  public static final String PASS_WORD = "password";

  /**
   * 生成安全的密码，生成随机的16位salt并经过1024次 MD5 hash
   *
   * @throws TKCheckedException
   * @throws TKCheckedException
   */
  public static String entryptPassword(String plainPassword) throws TKCheckedException {
    //为用户生成一个随机盐
    byte[] salt = Digests.generateSalt(SALT_SIZE);
    byte[] hashPassword =
        Digests.digest(plainPassword.getBytes(), HASH_ALGORITHM, salt, HASH_INTERATIONS);
    return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
  }

  /**
   * 验证密码
   *
   * @param plainPassword 明文密码
   * @param password 密文密码
   * @return 验证成功返回true
   * @throws TKCheckedException
   */
  public static boolean validatePassword(String plainPassword, String password)
      throws TKCheckedException {
    byte[] salt = Encodes.decodeHex(password.substring(0, 16));
    byte[] hashPassword =
        Digests.digest(plainPassword.getBytes(), HASH_ALGORITHM, salt, HASH_INTERATIONS);
    return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
  }

  public static UserDTO getCurrentUser() {
    Subject subject = SecurityUtils.getSubject();
    UserDTO principal = (UserDTO) subject.getPrincipal();
    return principal;
  }

  public static List<MenuDTO> getCurrentMenu() {
    Subject subject = SecurityUtils.getSubject();
    UserDTO principal = (UserDTO) subject.getPrincipal();
    List<MenuDTO> menuList = principal.getMenu();
    return menuList;
  }
}
