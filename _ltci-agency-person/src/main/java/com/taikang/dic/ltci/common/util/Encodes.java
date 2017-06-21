package com.taikang.dic.ltci.common.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Encodes {

  private static final Logger logger = LoggerFactory.getLogger(Encodes.class);

  private static final String DEFAULT_URL_ENCODING = "UTF-8";
  private static final char[] BASE62 =
      "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
  private static final String ERROR_MESSAGE = "错误信息：";

  private Encodes() {}

  public static String urlEncode(String part) {
    String str = null;
    try {
      str = URLEncoder.encode(part, DEFAULT_URL_ENCODING);
    } catch (Exception e) {
      logger.error(ERROR_MESSAGE + e);
    }
    return str;
  }

  public static String urlDecode(String part) {
    String str = null;
    try {
      return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
    } catch (Exception e) {
      logger.error(ERROR_MESSAGE + e);
    }
    return str;
  }

  public static String escapeXml(String xml) {
    return StringEscapeUtils.escapeXml(xml);
  }

  public static String unescapeXml(String xmlEscaped) {
    return StringEscapeUtils.unescapeXml(xmlEscaped);
  }

  public static String escapeHtml(String html) {
    return StringEscapeUtils.escapeHtml4(html);
  }

  public static String unescapeHtml(String htmlEscaped) {
    return StringEscapeUtils.unescapeHtml4(htmlEscaped);
  }

  public static byte[] decodeBase64(String input) {
    return Base64.decodeBase64(input);
  }

  public static String encodeBase62(byte[] input) {
    char[] chars = new char[input.length];
    for (int i = 0; i < input.length; i++) {
      chars[i] = BASE62[(input[i] & 0xFF) % BASE62.length];
    }
    return new String(chars);
  }

  public static String encodeBase64(byte[] input) {
    return Base64.encodeBase64String(input);
  }

  public static String encodeUrlSafeBase64(byte[] input) {
    return Base64.encodeBase64URLSafeString(input);
  }

  public static String encodeHex(byte[] input) {
    return Hex.encodeHexString(input);
  }

  public static byte[] decodeHex(String input) {
    byte[] bytes = null;
    try {
      bytes = Hex.decodeHex(input.toCharArray());
    } catch (DecoderException e) {
      logger.error(ERROR_MESSAGE + e);
    }
    return bytes;
  }
}
