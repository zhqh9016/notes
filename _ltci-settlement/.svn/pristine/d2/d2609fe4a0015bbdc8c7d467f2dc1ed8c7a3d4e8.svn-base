package com.taikang.dic.ltci.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.common.ws.LongTermCareServerImplService;
import com.taikang.dic.ltci.common.ws.LongtermCareService;
import com.taikang.dic.ltci.common.ws.NurseOutInfo;

public class NurseWebServiceTest {

  private Logger log = LoggerFactory.getLogger(NurseWebServiceTest.class);

  public void fun1() throws MalformedURLException {
    LongTermCareServerImplService service =
        new LongTermCareServerImplService(new URL("http://localhost:9090/soap/nurse?wsdl"));
    LongtermCareService port = service.getLongTermCareServerImplPort();
    ErrorReason nurseOutInfo = port.getNurseOutInfo(new NurseOutInfo());
    System.out.println(nurseOutInfo.getErrorReasonCode());
    System.out.println(nurseOutInfo.getErrorReason());
  }

  public void fun4() {
    try {
      Service service =
          Service.create(
              new URL("http://localhost:9090/soap/nurse?wsdl"),
              new QName(
                  "http://impl.server.esb.iengine.medata.com/", "LongtermCareServiceService"));
      LongtermCareService port = service.getPort(LongtermCareService.class);
      ErrorReason nurseOutInfo = port.getNurseOutInfo(new NurseOutInfo());
      System.out.println(nurseOutInfo.getErrorReasonCode());
      System.out.println(nurseOutInfo.getErrorReason());
    } catch (MalformedURLException e) {
      log.error("webService测试发生异常", e);
    }
  }

  public void fun5() {
    try {
      LongTermCareServerImplService service =
          new LongTermCareServerImplService(new URL("http://localhost:9090/soap/nurse?wsdl"));
      LongtermCareService longtermCareServicePort = service.getLongTermCareServerImplPort();

    } catch (MalformedURLException e) {
      log.error("webService测试发生异常", e);
    }
  }
}
