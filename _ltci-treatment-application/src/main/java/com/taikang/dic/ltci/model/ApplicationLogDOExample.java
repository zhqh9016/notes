package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationLogDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public ApplicationLogDOExample() {
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

    public Criteria andApplicationLogidIsNull() {
      addCriterion("application_logid is null");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidIsNotNull() {
      addCriterion("application_logid is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidEqualTo(String value) {
      addCriterion("application_logid =", value, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidNotEqualTo(String value) {
      addCriterion("application_logid <>", value, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidGreaterThan(String value) {
      addCriterion("application_logid >", value, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidGreaterThanOrEqualTo(String value) {
      addCriterion("application_logid >=", value, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidLessThan(String value) {
      addCriterion("application_logid <", value, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidLessThanOrEqualTo(String value) {
      addCriterion("application_logid <=", value, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidLike(String value) {
      addCriterion("application_logid like", value, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidNotLike(String value) {
      addCriterion("application_logid not like", value, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidIn(List<String> values) {
      addCriterion("application_logid in", values, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidNotIn(List<String> values) {
      addCriterion("application_logid not in", values, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidBetween(String value1, String value2) {
      addCriterion("application_logid between", value1, value2, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationLogidNotBetween(String value1, String value2) {
      addCriterion("application_logid not between", value1, value2, "applicationLogid");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeIsNull() {
      addCriterion("application_code is null");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeIsNotNull() {
      addCriterion("application_code is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeEqualTo(String value) {
      addCriterion("application_code =", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeNotEqualTo(String value) {
      addCriterion("application_code <>", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeGreaterThan(String value) {
      addCriterion("application_code >", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeGreaterThanOrEqualTo(String value) {
      addCriterion("application_code >=", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeLessThan(String value) {
      addCriterion("application_code <", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeLessThanOrEqualTo(String value) {
      addCriterion("application_code <=", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeLike(String value) {
      addCriterion("application_code like", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeNotLike(String value) {
      addCriterion("application_code not like", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeIn(List<String> values) {
      addCriterion("application_code in", values, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeNotIn(List<String> values) {
      addCriterion("application_code not in", values, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeBetween(String value1, String value2) {
      addCriterion("application_code between", value1, value2, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeNotBetween(String value1, String value2) {
      addCriterion("application_code not between", value1, value2, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberIsNull() {
      addCriterion("security_number is null");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberIsNotNull() {
      addCriterion("security_number is not null");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberEqualTo(String value) {
      addCriterion("security_number =", value, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberNotEqualTo(String value) {
      addCriterion("security_number <>", value, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberGreaterThan(String value) {
      addCriterion("security_number >", value, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberGreaterThanOrEqualTo(String value) {
      addCriterion("security_number >=", value, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberLessThan(String value) {
      addCriterion("security_number <", value, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberLessThanOrEqualTo(String value) {
      addCriterion("security_number <=", value, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberLike(String value) {
      addCriterion("security_number like", value, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberNotLike(String value) {
      addCriterion("security_number not like", value, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberIn(List<String> values) {
      addCriterion("security_number in", values, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberNotIn(List<String> values) {
      addCriterion("security_number not in", values, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberBetween(String value1, String value2) {
      addCriterion("security_number between", value1, value2, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberNotBetween(String value1, String value2) {
      addCriterion("security_number not between", value1, value2, "securityNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberIsNull() {
      addCriterion("security_personal_number is null");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberIsNotNull() {
      addCriterion("security_personal_number is not null");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberEqualTo(String value) {
      addCriterion("security_personal_number =", value, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberNotEqualTo(String value) {
      addCriterion("security_personal_number <>", value, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberGreaterThan(String value) {
      addCriterion("security_personal_number >", value, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberGreaterThanOrEqualTo(String value) {
      addCriterion("security_personal_number >=", value, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberLessThan(String value) {
      addCriterion("security_personal_number <", value, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberLessThanOrEqualTo(String value) {
      addCriterion("security_personal_number <=", value, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberLike(String value) {
      addCriterion("security_personal_number like", value, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberNotLike(String value) {
      addCriterion("security_personal_number not like", value, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberIn(List<String> values) {
      addCriterion("security_personal_number in", values, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberNotIn(List<String> values) {
      addCriterion("security_personal_number not in", values, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberBetween(String value1, String value2) {
      addCriterion("security_personal_number between", value1, value2, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andSecurityPersonalNumberNotBetween(String value1, String value2) {
      addCriterion(
          "security_personal_number not between", value1, value2, "securityPersonalNumber");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardIsNull() {
      addCriterion("deputy_id_card is null");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardIsNotNull() {
      addCriterion("deputy_id_card is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardEqualTo(String value) {
      addCriterion("deputy_id_card =", value, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardNotEqualTo(String value) {
      addCriterion("deputy_id_card <>", value, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardGreaterThan(String value) {
      addCriterion("deputy_id_card >", value, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_id_card >=", value, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardLessThan(String value) {
      addCriterion("deputy_id_card <", value, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardLessThanOrEqualTo(String value) {
      addCriterion("deputy_id_card <=", value, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardLike(String value) {
      addCriterion("deputy_id_card like", value, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardNotLike(String value) {
      addCriterion("deputy_id_card not like", value, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardIn(List<String> values) {
      addCriterion("deputy_id_card in", values, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardNotIn(List<String> values) {
      addCriterion("deputy_id_card not in", values, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardBetween(String value1, String value2) {
      addCriterion("deputy_id_card between", value1, value2, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardNotBetween(String value1, String value2) {
      addCriterion("deputy_id_card not between", value1, value2, "deputyIdCard");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusIsNull() {
      addCriterion("application_status is null");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusIsNotNull() {
      addCriterion("application_status is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusEqualTo(String value) {
      addCriterion("application_status =", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusNotEqualTo(String value) {
      addCriterion("application_status <>", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusGreaterThan(String value) {
      addCriterion("application_status >", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusGreaterThanOrEqualTo(String value) {
      addCriterion("application_status >=", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusLessThan(String value) {
      addCriterion("application_status <", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusLessThanOrEqualTo(String value) {
      addCriterion("application_status <=", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusLike(String value) {
      addCriterion("application_status like", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusNotLike(String value) {
      addCriterion("application_status not like", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusIn(List<String> values) {
      addCriterion("application_status in", values, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusNotIn(List<String> values) {
      addCriterion("application_status not in", values, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusBetween(String value1, String value2) {
      addCriterion("application_status between", value1, value2, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusNotBetween(String value1, String value2) {
      addCriterion("application_status not between", value1, value2, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonIsNull() {
      addCriterion("application_reason is null");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonIsNotNull() {
      addCriterion("application_reason is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonEqualTo(String value) {
      addCriterion("application_reason =", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonNotEqualTo(String value) {
      addCriterion("application_reason <>", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonGreaterThan(String value) {
      addCriterion("application_reason >", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonGreaterThanOrEqualTo(String value) {
      addCriterion("application_reason >=", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonLessThan(String value) {
      addCriterion("application_reason <", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonLessThanOrEqualTo(String value) {
      addCriterion("application_reason <=", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonLike(String value) {
      addCriterion("application_reason like", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonNotLike(String value) {
      addCriterion("application_reason not like", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonIn(List<String> values) {
      addCriterion("application_reason in", values, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonNotIn(List<String> values) {
      addCriterion("application_reason not in", values, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonBetween(String value1, String value2) {
      addCriterion("application_reason between", value1, value2, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonNotBetween(String value1, String value2) {
      addCriterion("application_reason not between", value1, value2, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andCreatedByIsNull() {
      addCriterion("created_by is null");
      return (Criteria) this;
    }

    public Criteria andCreatedByIsNotNull() {
      addCriterion("created_by is not null");
      return (Criteria) this;
    }

    public Criteria andCreatedByEqualTo(String value) {
      addCriterion("created_by =", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByNotEqualTo(String value) {
      addCriterion("created_by <>", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByGreaterThan(String value) {
      addCriterion("created_by >", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
      addCriterion("created_by >=", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByLessThan(String value) {
      addCriterion("created_by <", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByLessThanOrEqualTo(String value) {
      addCriterion("created_by <=", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByLike(String value) {
      addCriterion("created_by like", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByNotLike(String value) {
      addCriterion("created_by not like", value, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByIn(List<String> values) {
      addCriterion("created_by in", values, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByNotIn(List<String> values) {
      addCriterion("created_by not in", values, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByBetween(String value1, String value2) {
      addCriterion("created_by between", value1, value2, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedByNotBetween(String value1, String value2) {
      addCriterion("created_by not between", value1, value2, "createdBy");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeIsNull() {
      addCriterion("created_time is null");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeIsNotNull() {
      addCriterion("created_time is not null");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeEqualTo(Date value) {
      addCriterion("created_time =", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeNotEqualTo(Date value) {
      addCriterion("created_time <>", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeGreaterThan(Date value) {
      addCriterion("created_time >", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("created_time >=", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeLessThan(Date value) {
      addCriterion("created_time <", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
      addCriterion("created_time <=", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeIn(List<Date> values) {
      addCriterion("created_time in", values, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeNotIn(List<Date> values) {
      addCriterion("created_time not in", values, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeBetween(Date value1, Date value2) {
      addCriterion("created_time between", value1, value2, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
      addCriterion("created_time not between", value1, value2, "createdTime");
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
