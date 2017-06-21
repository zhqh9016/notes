package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeeAuditLogDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public FeeAuditLogDOExample() {
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
      addCriterion("id is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(String value) {
      addCriterion("id =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(String value) {
      addCriterion("id <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(String value) {
      addCriterion("id >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(String value) {
      addCriterion("id >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(String value) {
      addCriterion("id <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(String value) {
      addCriterion("id <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLike(String value) {
      addCriterion("id like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotLike(String value) {
      addCriterion("id not like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<String> values) {
      addCriterion("id in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<String> values) {
      addCriterion("id not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(String value1, String value2) {
      addCriterion("id between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(String value1, String value2) {
      addCriterion("id not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeIsNull() {
      addCriterion("per_set_code is null");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeIsNotNull() {
      addCriterion("per_set_code is not null");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeEqualTo(String value) {
      addCriterion("per_set_code =", value, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeNotEqualTo(String value) {
      addCriterion("per_set_code <>", value, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeGreaterThan(String value) {
      addCriterion("per_set_code >", value, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeGreaterThanOrEqualTo(String value) {
      addCriterion("per_set_code >=", value, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeLessThan(String value) {
      addCriterion("per_set_code <", value, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeLessThanOrEqualTo(String value) {
      addCriterion("per_set_code <=", value, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeLike(String value) {
      addCriterion("per_set_code like", value, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeNotLike(String value) {
      addCriterion("per_set_code not like", value, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeIn(List<String> values) {
      addCriterion("per_set_code in", values, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeNotIn(List<String> values) {
      addCriterion("per_set_code not in", values, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeBetween(String value1, String value2) {
      addCriterion("per_set_code between", value1, value2, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andPerSetCodeNotBetween(String value1, String value2) {
      addCriterion("per_set_code not between", value1, value2, "perSetCode");
      return (Criteria) this;
    }

    public Criteria andAuditTypeIsNull() {
      addCriterion("audit_type is null");
      return (Criteria) this;
    }

    public Criteria andAuditTypeIsNotNull() {
      addCriterion("audit_type is not null");
      return (Criteria) this;
    }

    public Criteria andAuditTypeEqualTo(Integer value) {
      addCriterion("audit_type =", value, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeNotEqualTo(Integer value) {
      addCriterion("audit_type <>", value, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeGreaterThan(Integer value) {
      addCriterion("audit_type >", value, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("audit_type >=", value, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeLessThan(Integer value) {
      addCriterion("audit_type <", value, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeLessThanOrEqualTo(Integer value) {
      addCriterion("audit_type <=", value, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeIn(List<Integer> values) {
      addCriterion("audit_type in", values, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeNotIn(List<Integer> values) {
      addCriterion("audit_type not in", values, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeBetween(Integer value1, Integer value2) {
      addCriterion("audit_type between", value1, value2, "auditType");
      return (Criteria) this;
    }

    public Criteria andAuditTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("audit_type not between", value1, value2, "auditType");
      return (Criteria) this;
    }

    public Criteria andRejectReasonIsNull() {
      addCriterion("reject_reason is null");
      return (Criteria) this;
    }

    public Criteria andRejectReasonIsNotNull() {
      addCriterion("reject_reason is not null");
      return (Criteria) this;
    }

    public Criteria andRejectReasonEqualTo(String value) {
      addCriterion("reject_reason =", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonNotEqualTo(String value) {
      addCriterion("reject_reason <>", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonGreaterThan(String value) {
      addCriterion("reject_reason >", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonGreaterThanOrEqualTo(String value) {
      addCriterion("reject_reason >=", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonLessThan(String value) {
      addCriterion("reject_reason <", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonLessThanOrEqualTo(String value) {
      addCriterion("reject_reason <=", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonLike(String value) {
      addCriterion("reject_reason like", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonNotLike(String value) {
      addCriterion("reject_reason not like", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonIn(List<String> values) {
      addCriterion("reject_reason in", values, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonNotIn(List<String> values) {
      addCriterion("reject_reason not in", values, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonBetween(String value1, String value2) {
      addCriterion("reject_reason between", value1, value2, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonNotBetween(String value1, String value2) {
      addCriterion("reject_reason not between", value1, value2, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andIsValidIsNull() {
      addCriterion("is_valid is null");
      return (Criteria) this;
    }

    public Criteria andIsValidIsNotNull() {
      addCriterion("is_valid is not null");
      return (Criteria) this;
    }

    public Criteria andIsValidEqualTo(Integer value) {
      addCriterion("is_valid =", value, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidNotEqualTo(Integer value) {
      addCriterion("is_valid <>", value, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidGreaterThan(Integer value) {
      addCriterion("is_valid >", value, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidGreaterThanOrEqualTo(Integer value) {
      addCriterion("is_valid >=", value, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidLessThan(Integer value) {
      addCriterion("is_valid <", value, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidLessThanOrEqualTo(Integer value) {
      addCriterion("is_valid <=", value, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidIn(List<Integer> values) {
      addCriterion("is_valid in", values, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidNotIn(List<Integer> values) {
      addCriterion("is_valid not in", values, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidBetween(Integer value1, Integer value2) {
      addCriterion("is_valid between", value1, value2, "isValid");
      return (Criteria) this;
    }

    public Criteria andIsValidNotBetween(Integer value1, Integer value2) {
      addCriterion("is_valid not between", value1, value2, "isValid");
      return (Criteria) this;
    }

    public Criteria andOperatedByIsNull() {
      addCriterion("operated_by is null");
      return (Criteria) this;
    }

    public Criteria andOperatedByIsNotNull() {
      addCriterion("operated_by is not null");
      return (Criteria) this;
    }

    public Criteria andOperatedByEqualTo(String value) {
      addCriterion("operated_by =", value, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByNotEqualTo(String value) {
      addCriterion("operated_by <>", value, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByGreaterThan(String value) {
      addCriterion("operated_by >", value, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByGreaterThanOrEqualTo(String value) {
      addCriterion("operated_by >=", value, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByLessThan(String value) {
      addCriterion("operated_by <", value, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByLessThanOrEqualTo(String value) {
      addCriterion("operated_by <=", value, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByLike(String value) {
      addCriterion("operated_by like", value, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByNotLike(String value) {
      addCriterion("operated_by not like", value, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByIn(List<String> values) {
      addCriterion("operated_by in", values, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByNotIn(List<String> values) {
      addCriterion("operated_by not in", values, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByBetween(String value1, String value2) {
      addCriterion("operated_by between", value1, value2, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedByNotBetween(String value1, String value2) {
      addCriterion("operated_by not between", value1, value2, "operatedBy");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgIsNull() {
      addCriterion("operated_org is null");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgIsNotNull() {
      addCriterion("operated_org is not null");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgEqualTo(String value) {
      addCriterion("operated_org =", value, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgNotEqualTo(String value) {
      addCriterion("operated_org <>", value, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgGreaterThan(String value) {
      addCriterion("operated_org >", value, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgGreaterThanOrEqualTo(String value) {
      addCriterion("operated_org >=", value, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgLessThan(String value) {
      addCriterion("operated_org <", value, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgLessThanOrEqualTo(String value) {
      addCriterion("operated_org <=", value, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgLike(String value) {
      addCriterion("operated_org like", value, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgNotLike(String value) {
      addCriterion("operated_org not like", value, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgIn(List<String> values) {
      addCriterion("operated_org in", values, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgNotIn(List<String> values) {
      addCriterion("operated_org not in", values, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgBetween(String value1, String value2) {
      addCriterion("operated_org between", value1, value2, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedOrgNotBetween(String value1, String value2) {
      addCriterion("operated_org not between", value1, value2, "operatedOrg");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeIsNull() {
      addCriterion("operated_time is null");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeIsNotNull() {
      addCriterion("operated_time is not null");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeEqualTo(Date value) {
      addCriterion("operated_time =", value, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeNotEqualTo(Date value) {
      addCriterion("operated_time <>", value, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeGreaterThan(Date value) {
      addCriterion("operated_time >", value, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("operated_time >=", value, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeLessThan(Date value) {
      addCriterion("operated_time <", value, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeLessThanOrEqualTo(Date value) {
      addCriterion("operated_time <=", value, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeIn(List<Date> values) {
      addCriterion("operated_time in", values, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeNotIn(List<Date> values) {
      addCriterion("operated_time not in", values, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeBetween(Date value1, Date value2) {
      addCriterion("operated_time between", value1, value2, "operatedTime");
      return (Criteria) this;
    }

    public Criteria andOperatedTimeNotBetween(Date value1, Date value2) {
      addCriterion("operated_time not between", value1, value2, "operatedTime");
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
