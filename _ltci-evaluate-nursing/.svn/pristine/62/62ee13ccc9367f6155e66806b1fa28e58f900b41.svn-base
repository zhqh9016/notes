package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.taikang.dic.ltci.common.enumeration.EvaluateEnum;
import com.taikang.dic.ltci.model.EvaluateTaskDO;
import com.taikang.dic.ltci.model.EvaluateTaskSpecialDO;
import com.taikang.dic.ltci.service.EvaluateTaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class EvaluateTaskControllerIT {

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired private EvaluateTaskService evaluateTaskService;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @Transactional
  @Rollback
  public void testSendEvaluateTask() throws Exception {

    //    String evaluateTaskCode = "9472b12f484a434083c3fbb4369c05a0";
    //
    //    EvaluateTaskSpecialDO evaluateTaskSpecialDO =
    //        evaluateTaskService.getEvaluateTaskSpecialDOByCode(evaluateTaskCode);
    //    if (evaluateTaskCode != null) {
    //      EvaluateTaskDO record = new EvaluateTaskDO();
    //      record.setEvaluateTaskid(evaluateTaskSpecialDO.getEvaluateTaskid());
    //      record.setTaskState(EvaluateEnum.NO_SEND.getValue());
    //      evaluateTaskService.updateByPrimaryKeySelective(record);
    //
    //      String operatedBy = "张三";
    //      String operatedOrg = "荆门市经办大厅";
    //      String evaluateAgencyCode = "001";
    //      String evaluateAgencyName = "荆门市东宝区长宁居养老院";
    //
    //      mockMvc
    //          .perform(
    //              put("/api/v1/evaluateTask")
    //                  .param("evaluateTaskCodes", evaluateTaskCode)
    //                  .param("operatedBy", operatedBy)
    //                  .param("operatedOrg", operatedOrg)
    //                  .param("evaluateAgencyCode", evaluateAgencyCode)
    //                  .param("evaluateAgencyName", evaluateAgencyName))
    //          .andExpect(status().isOk())
    //          .andDo(print()) //打印出请求和响应的内容
    //          .andReturn()
    //          .getResponse()
    //          .getContentAsString();
    //      ;
    //    }
  }

  //  @Test
  //  @Transactional
  //  @Rollback
  //  public void testReviewEvaluateTask() throws Exception {
  //    String evaluateTaskCode = "9472b12f484a434083c3fbb4369c05a0";
  //    String reevalueateResult = "通过";
  //    String operatedBy = "张三";
  //    String operatedOrg = "荆门市经办大厅";
  //    mockMvc
  //        .perform(
  //            put("/api/v1/reviewEvaluateTask")
  //                .param("evaluateTaskCode", evaluateTaskCode)
  //                .param("reevalueateResult", reevalueateResult)
  //                .param("operatedBy", operatedBy)
  //                .param("operatedOrg", operatedOrg))
  //        .andExpect(status().isOk())
  //        .andDo(print()) //打印出请求和响应的内容
  //        .andReturn()
  //        .getResponse()
  //        .getContentAsString();
  //    ;
  //  }
}
