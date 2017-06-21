package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NurseDetailLogDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public NurseDetailLogDOExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause() {
    return orderByClause;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  public boolean isDistinct() {
    return distinct;
  }

  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria() {
    Criteria criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0) {
      oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  protected abstract static class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
      super();
      criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
      return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
      return criteria;
    }

    public List<Criterion> getCriteria() {
      return criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if (value1 == null || value2 == null) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value1, value2));
    }

    public Criteria andIdIsNull() {
      addCriterion("ID is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(String value) {
      addCriterion("ID =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(String value) {
      addCriterion("ID <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(String value) {
      addCriterion("ID >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(String value) {
      addCriterion("ID >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(String value) {
      addCriterion("ID <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(String value) {
      addCriterion("ID <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLike(String value) {
      addCriterion("ID like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotLike(String value) {
      addCriterion("ID not like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<String> values) {
      addCriterion("ID in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<String> values) {
      addCriterion("ID not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(String value1, String value2) {
      addCriterion("ID between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(String value1, String value2) {
      addCriterion("ID not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andOrgCodeIsNull() {
      addCriterion("org_code is null");
      return (Criteria) this;
    }

    public Criteria andOrgCodeIsNotNull() {
      addCriterion("org_code is not null");
      return (Criteria) this;
    }

    public Criteria andOrgCodeEqualTo(String value) {
      addCriterion("org_code =", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeNotEqualTo(String value) {
      addCriterion("org_code <>", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeGreaterThan(String value) {
      addCriterion("org_code >", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
      addCriterion("org_code >=", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeLessThan(String value) {
      addCriterion("org_code <", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeLessThanOrEqualTo(String value) {
      addCriterion("org_code <=", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeLike(String value) {
      addCriterion("org_code like", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeNotLike(String value) {
      addCriterion("org_code not like", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeIn(List<String> values) {
      addCriterion("org_code in", values, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeNotIn(List<String> values) {
      addCriterion("org_code not in", values, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeBetween(String value1, String value2) {
      addCriterion("org_code between", value1, value2, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeNotBetween(String value1, String value2) {
      addCriterion("org_code not between", value1, value2, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgNameIsNull() {
      addCriterion("org_name is null");
      return (Criteria) this;
    }

    public Criteria andOrgNameIsNotNull() {
      addCriterion("org_name is not null");
      return (Criteria) this;
    }

    public Criteria andOrgNameEqualTo(String value) {
      addCriterion("org_name =", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameNotEqualTo(String value) {
      addCriterion("org_name <>", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameGreaterThan(String value) {
      addCriterion("org_name >", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
      addCriterion("org_name >=", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameLessThan(String value) {
      addCriterion("org_name <", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameLessThanOrEqualTo(String value) {
      addCriterion("org_name <=", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameLike(String value) {
      addCriterion("org_name like", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameNotLike(String value) {
      addCriterion("org_name not like", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameIn(List<String> values) {
      addCriterion("org_name in", values, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameNotIn(List<String> values) {
      addCriterion("org_name not in", values, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameBetween(String value1, String value2) {
      addCriterion("org_name between", value1, value2, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameNotBetween(String value1, String value2) {
      addCriterion("org_name not between", value1, value2, "orgName");
      return (Criteria) this;
    }

    public Criteria andRecordidIsNull() {
      addCriterion("recordid is null");
      return (Criteria) this;
    }

    public Criteria andRecordidIsNotNull() {
      addCriterion("recordid is not null");
      return (Criteria) this;
    }

    public Criteria andRecordidEqualTo(String value) {
      addCriterion("recordid =", value, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidNotEqualTo(String value) {
      addCriterion("recordid <>", value, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidGreaterThan(String value) {
      addCriterion("recordid >", value, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidGreaterThanOrEqualTo(String value) {
      addCriterion("recordid >=", value, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidLessThan(String value) {
      addCriterion("recordid <", value, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidLessThanOrEqualTo(String value) {
      addCriterion("recordid <=", value, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidLike(String value) {
      addCriterion("recordid like", value, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidNotLike(String value) {
      addCriterion("recordid not like", value, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidIn(List<String> values) {
      addCriterion("recordid in", values, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidNotIn(List<String> values) {
      addCriterion("recordid not in", values, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidBetween(String value1, String value2) {
      addCriterion("recordid between", value1, value2, "recordid");
      return (Criteria) this;
    }

    public Criteria andRecordidNotBetween(String value1, String value2) {
      addCriterion("recordid not between", value1, value2, "recordid");
      return (Criteria) this;
    }

    public Criteria andSendTimeIsNull() {
      addCriterion("send_time is null");
      return (Criteria) this;
    }

    public Criteria andSendTimeIsNotNull() {
      addCriterion("send_time is not null");
      return (Criteria) this;
    }

    public Criteria andSendTimeEqualTo(Date value) {
      addCriterion("send_time =", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeNotEqualTo(Date value) {
      addCriterion("send_time <>", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeGreaterThan(Date value) {
      addCriterion("send_time >", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("send_time >=", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeLessThan(Date value) {
      addCriterion("send_time <", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeLessThanOrEqualTo(Date value) {
      addCriterion("send_time <=", value, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeIn(List<Date> values) {
      addCriterion("send_time in", values, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeNotIn(List<Date> values) {
      addCriterion("send_time not in", values, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeBetween(Date value1, Date value2) {
      addCriterion("send_time between", value1, value2, "sendTime");
      return (Criteria) this;
    }

    public Criteria andSendTimeNotBetween(Date value1, Date value2) {
      addCriterion("send_time not between", value1, value2, "sendTime");
      return (Criteria) this;
    }

    public Criteria andDetailNumIsNull() {
      addCriterion("detail_num is null");
      return (Criteria) this;
    }

    public Criteria andDetailNumIsNotNull() {
      addCriterion("detail_num is not null");
      return (Criteria) this;
    }

    public Criteria andDetailNumEqualTo(Integer value) {
      addCriterion("detail_num =", value, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumNotEqualTo(Integer value) {
      addCriterion("detail_num <>", value, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumGreaterThan(Integer value) {
      addCriterion("detail_num >", value, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("detail_num >=", value, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumLessThan(Integer value) {
      addCriterion("detail_num <", value, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumLessThanOrEqualTo(Integer value) {
      addCriterion("detail_num <=", value, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumIn(List<Integer> values) {
      addCriterion("detail_num in", values, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumNotIn(List<Integer> values) {
      addCriterion("detail_num not in", values, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumBetween(Integer value1, Integer value2) {
      addCriterion("detail_num between", value1, value2, "detailNum");
      return (Criteria) this;
    }

    public Criteria andDetailNumNotBetween(Integer value1, Integer value2) {
      addCriterion("detail_num not between", value1, value2, "detailNum");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagIsNull() {
      addCriterion("exception_flag is null");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagIsNotNull() {
      addCriterion("exception_flag is not null");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagEqualTo(Integer value) {
      addCriterion("exception_flag =", value, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagNotEqualTo(Integer value) {
      addCriterion("exception_flag <>", value, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagGreaterThan(Integer value) {
      addCriterion("exception_flag >", value, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagGreaterThanOrEqualTo(Integer value) {
      addCriterion("exception_flag >=", value, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagLessThan(Integer value) {
      addCriterion("exception_flag <", value, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagLessThanOrEqualTo(Integer value) {
      addCriterion("exception_flag <=", value, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagIn(List<Integer> values) {
      addCriterion("exception_flag in", values, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagNotIn(List<Integer> values) {
      addCriterion("exception_flag not in", values, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagBetween(Integer value1, Integer value2) {
      addCriterion("exception_flag between", value1, value2, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andExceptionFlagNotBetween(Integer value1, Integer value2) {
      addCriterion("exception_flag not between", value1, value2, "exceptionFlag");
      return (Criteria) this;
    }

    public Criteria andMessageContentIsNull() {
      addCriterion("message_content is null");
      return (Criteria) this;
    }

    public Criteria andMessageContentIsNotNull() {
      addCriterion("message_content is not null");
      return (Criteria) this;
    }

    public Criteria andMessageContentEqualTo(String value) {
      addCriterion("message_content =", value, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentNotEqualTo(String value) {
      addCriterion("message_content <>", value, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentGreaterThan(String value) {
      addCriterion("message_content >", value, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentGreaterThanOrEqualTo(String value) {
      addCriterion("message_content >=", value, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentLessThan(String value) {
      addCriterion("message_content <", value, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentLessThanOrEqualTo(String value) {
      addCriterion("message_content <=", value, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentLike(String value) {
      addCriterion("message_content like", value, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentNotLike(String value) {
      addCriterion("message_content not like", value, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentIn(List<String> values) {
      addCriterion("message_content in", values, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentNotIn(List<String> values) {
      addCriterion("message_content not in", values, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentBetween(String value1, String value2) {
      addCriterion("message_content between", value1, value2, "messageContent");
      return (Criteria) this;
    }

    public Criteria andMessageContentNotBetween(String value1, String value2) {
      addCriterion("message_content not between", value1, value2, "messageContent");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidIsNull() {
      addCriterion("business_serialid is null");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidIsNotNull() {
      addCriterion("business_serialid is not null");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidEqualTo(String value) {
      addCriterion("business_serialid =", value, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidNotEqualTo(String value) {
      addCriterion("business_serialid <>", value, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidGreaterThan(String value) {
      addCriterion("business_serialid >", value, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidGreaterThanOrEqualTo(String value) {
      addCriterion("business_serialid >=", value, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidLessThan(String value) {
      addCriterion("business_serialid <", value, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidLessThanOrEqualTo(String value) {
      addCriterion("business_serialid <=", value, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidLike(String value) {
      addCriterion("business_serialid like", value, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidNotLike(String value) {
      addCriterion("business_serialid not like", value, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidIn(List<String> values) {
      addCriterion("business_serialid in", values, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidNotIn(List<String> values) {
      addCriterion("business_serialid not in", values, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidBetween(String value1, String value2) {
      addCriterion("business_serialid between", value1, value2, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andBusinessSerialidNotBetween(String value1, String value2) {
      addCriterion("business_serialid not between", value1, value2, "businessSerialid");
      return (Criteria) this;
    }

    public Criteria andSysCodeIsNull() {
      addCriterion("sys_code is null");
      return (Criteria) this;
    }

    public Criteria andSysCodeIsNotNull() {
      addCriterion("sys_code is not null");
      return (Criteria) this;
    }

    public Criteria andSysCodeEqualTo(String value) {
      addCriterion("sys_code =", value, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeNotEqualTo(String value) {
      addCriterion("sys_code <>", value, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeGreaterThan(String value) {
      addCriterion("sys_code >", value, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeGreaterThanOrEqualTo(String value) {
      addCriterion("sys_code >=", value, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeLessThan(String value) {
      addCriterion("sys_code <", value, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeLessThanOrEqualTo(String value) {
      addCriterion("sys_code <=", value, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeLike(String value) {
      addCriterion("sys_code like", value, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeNotLike(String value) {
      addCriterion("sys_code not like", value, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeIn(List<String> values) {
      addCriterion("sys_code in", values, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeNotIn(List<String> values) {
      addCriterion("sys_code not in", values, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeBetween(String value1, String value2) {
      addCriterion("sys_code between", value1, value2, "sysCode");
      return (Criteria) this;
    }

    public Criteria andSysCodeNotBetween(String value1, String value2) {
      addCriterion("sys_code not between", value1, value2, "sysCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeIsNull() {
      addCriterion("module_code is null");
      return (Criteria) this;
    }

    public Criteria andModuleCodeIsNotNull() {
      addCriterion("module_code is not null");
      return (Criteria) this;
    }

    public Criteria andModuleCodeEqualTo(String value) {
      addCriterion("module_code =", value, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeNotEqualTo(String value) {
      addCriterion("module_code <>", value, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeGreaterThan(String value) {
      addCriterion("module_code >", value, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeGreaterThanOrEqualTo(String value) {
      addCriterion("module_code >=", value, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeLessThan(String value) {
      addCriterion("module_code <", value, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeLessThanOrEqualTo(String value) {
      addCriterion("module_code <=", value, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeLike(String value) {
      addCriterion("module_code like", value, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeNotLike(String value) {
      addCriterion("module_code not like", value, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeIn(List<String> values) {
      addCriterion("module_code in", values, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeNotIn(List<String> values) {
      addCriterion("module_code not in", values, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeBetween(String value1, String value2) {
      addCriterion("module_code between", value1, value2, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andModuleCodeNotBetween(String value1, String value2) {
      addCriterion("module_code not between", value1, value2, "moduleCode");
      return (Criteria) this;
    }

    public Criteria andNodeIpIsNull() {
      addCriterion("node_ip is null");
      return (Criteria) this;
    }

    public Criteria andNodeIpIsNotNull() {
      addCriterion("node_ip is not null");
      return (Criteria) this;
    }

    public Criteria andNodeIpEqualTo(String value) {
      addCriterion("node_ip =", value, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpNotEqualTo(String value) {
      addCriterion("node_ip <>", value, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpGreaterThan(String value) {
      addCriterion("node_ip >", value, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpGreaterThanOrEqualTo(String value) {
      addCriterion("node_ip >=", value, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpLessThan(String value) {
      addCriterion("node_ip <", value, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpLessThanOrEqualTo(String value) {
      addCriterion("node_ip <=", value, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpLike(String value) {
      addCriterion("node_ip like", value, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpNotLike(String value) {
      addCriterion("node_ip not like", value, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpIn(List<String> values) {
      addCriterion("node_ip in", values, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpNotIn(List<String> values) {
      addCriterion("node_ip not in", values, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpBetween(String value1, String value2) {
      addCriterion("node_ip between", value1, value2, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andNodeIpNotBetween(String value1, String value2) {
      addCriterion("node_ip not between", value1, value2, "nodeIp");
      return (Criteria) this;
    }

    public Criteria andMessageCodeIsNull() {
      addCriterion("message_code is null");
      return (Criteria) this;
    }

    public Criteria andMessageCodeIsNotNull() {
      addCriterion("message_code is not null");
      return (Criteria) this;
    }

    public Criteria andMessageCodeEqualTo(String value) {
      addCriterion("message_code =", value, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeNotEqualTo(String value) {
      addCriterion("message_code <>", value, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeGreaterThan(String value) {
      addCriterion("message_code >", value, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeGreaterThanOrEqualTo(String value) {
      addCriterion("message_code >=", value, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeLessThan(String value) {
      addCriterion("message_code <", value, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeLessThanOrEqualTo(String value) {
      addCriterion("message_code <=", value, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeLike(String value) {
      addCriterion("message_code like", value, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeNotLike(String value) {
      addCriterion("message_code not like", value, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeIn(List<String> values) {
      addCriterion("message_code in", values, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeNotIn(List<String> values) {
      addCriterion("message_code not in", values, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeBetween(String value1, String value2) {
      addCriterion("message_code between", value1, value2, "messageCode");
      return (Criteria) this;
    }

    public Criteria andMessageCodeNotBetween(String value1, String value2) {
      addCriterion("message_code not between", value1, value2, "messageCode");
      return (Criteria) this;
    }
  }

  public static class Criteria extends GeneratedCriteria {

    protected Criteria() {
      super();
    }
  }

  public static class Criterion {
    private String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    private String typeHandler;

    public String getCondition() {
      return condition;
    }

    public Object getValue() {
      return value;
    }

    public Object getSecondValue() {
      return secondValue;
    }

    public boolean isNoValue() {
      return noValue;
    }

    public boolean isSingleValue() {
      return singleValue;
    }

    public boolean isBetweenValue() {
      return betweenValue;
    }

    public boolean isListValue() {
      return listValue;
    }

    public String getTypeHandler() {
      return typeHandler;
    }

    protected Criterion(String condition) {
      super();
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if (value instanceof List<?>) {
        this.listValue = true;
      } else {
        this.singleValue = true;
      }
    }

    protected Criterion(String condition, Object value) {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.secondValue = secondValue;
      this.typeHandler = typeHandler;
      this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
      this(condition, value, secondValue, null);
    }
  }
}
