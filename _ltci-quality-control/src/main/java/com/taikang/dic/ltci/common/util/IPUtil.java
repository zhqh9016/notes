package com.taikang.dic.ltci.common.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取ip工具类
 *
 * @author itw_muwg
 */
public class IPUtil {

  private IPUtil() {}

  /**
   * 获取服务器ip
   *
   * @return
   * @throws UnknownHostException
   * @throws SocketException
   */
  public static String getLocalIp() throws UnknownHostException, SocketException {
    if (isWindowsOS()) {
      return getWindowsLocalIp();
    } else {
      return getLinuxLocalIp();
    }
  }

  /**
   * 判断操作系统是否是windows
   *
   * @return
   */
  public static boolean isWindowsOS() {
    boolean isWindosOS = false;
    String osName = System.getProperty("os.name");
    if (osName != null && osName.toLowerCase().indexOf("windows") > -1) {
      isWindosOS = true;
    }
    return isWindosOS;
  }
  /**
   * 获取windows系统本地ip
   *
   * @return ip地址
   * @throws UnknownHostException
   */
  public static String getWindowsLocalIp() throws UnknownHostException {
    return InetAddress.getLocalHost().getHostAddress();
  }
  /**
   * 获取linux系统本地ip
   *
   * @return ip地址
   * @throws SocketException
   */
  public static String getLinuxLocalIp() throws SocketException {
    String ip = "";
    boolean flag = false;
    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
    while (networkInterfaces.hasMoreElements()) {
      if (flag) {
        break;
      }
      NetworkInterface ni = networkInterfaces.nextElement();
      if (!ni.getName().contains("docker") && !ni.getName().contains("lo")) {
        //遍历所有ip
        Enumeration<InetAddress> ips = ni.getInetAddresses();
        while (ips.hasMoreElements()) {
          InetAddress inetAddress = ips.nextElement();
          if (!inetAddress.isLoopbackAddress()) {
            String hostAddress = inetAddress.getHostAddress();
            if (!hostAddress.contains("::")
                && !hostAddress.contains("0:0:")
                && !hostAddress.contains("fe80")) {
              ip = hostAddress;
              flag = true;
              break;
            }
          }
        }
      }
    }
    return ip;
  }
  /**
   * 获取请求端host
   *
   * @param request
   * @return
   */
  public static String getRemoteHost(HttpServletRequest request) {

    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
  }
}
