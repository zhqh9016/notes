package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExecuteResultDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public ExecuteResultDOExample() {
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

    public Criteria andExecuteResultIdIsNull() {
      addCriterion("execute_result_id is null");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdIsNotNull() {
      addCriterion("execute_result_id is not null");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdEqualTo(String value) {
      addCriterion("execute_result_id =", value, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdNotEqualTo(String value) {
      addCriterion("execute_result_id <>", value, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdGreaterThan(String value) {
      addCriterion("execute_result_id >", value, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdGreaterThanOrEqualTo(String value) {
      addCriterion("execute_result_id >=", value, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdLessThan(String value) {
      addCriterion("execute_result_id <", value, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdLessThanOrEqualTo(String value) {
      addCriterion("execute_result_id <=", value, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdLike(String value) {
      addCriterion("execute_result_id like", value, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdNotLike(String value) {
      addCriterion("execute_result_id not like", value, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdIn(List<String> values) {
      addCriterion("execute_result_id in", values, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdNotIn(List<String> values) {
      addCriterion("execute_result_id not in", values, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdBetween(String value1, String value2) {
      addCriterion("execute_result_id between", value1, value2, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andExecuteResultIdNotBetween(String value1, String value2) {
      addCriterion("execute_result_id not between", value1, value2, "executeResultId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdIsNull() {
      addCriterion("patrol_task_id is null");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdIsNotNull() {
      addCriterion("patrol_task_id is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdEqualTo(String value) {
      addCriterion("patrol_task_id =", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdNotEqualTo(String value) {
      addCriterion("patrol_task_id <>", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdGreaterThan(String value) {
      addCriterion("patrol_task_id >", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_task_id >=", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdLessThan(String value) {
      addCriterion("patrol_task_id <", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdLessThanOrEqualTo(String value) {
      addCriterion("patrol_task_id <=", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdLike(String value) {
      addCriterion("patrol_task_id like", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdNotLike(String value) {
      addCriterion("patrol_task_id not like", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdIn(List<String> values) {
      addCriterion("patrol_task_id in", values, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdNotIn(List<String> values) {
      addCriterion("patrol_task_id not in", values, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdBetween(String value1, String value2) {
      addCriterion("patrol_task_id between", value1, value2, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdNotBetween(String value1, String value2) {
      addCriterion("patrol_task_id not between", value1, value2, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPartolTimeIsNull() {
      addCriterion("partol_time is null");
      return (Criteria) this;
    }

    public Criteria andPartolTimeIsNotNull() {
      addCriterion("partol_time is not null");
      return (Criteria) this;
    }

    public Criteria andPartolTimeEqualTo(Date value) {
      addCriterion("partol_time =", value, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeNotEqualTo(Date value) {
      addCriterion("partol_time <>", value, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeGreaterThan(Date value) {
      addCriterion("partol_time >", value, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("partol_time >=", value, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeLessThan(Date value) {
      addCriterion("partol_time <", value, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeLessThanOrEqualTo(Date value) {
      addCriterion("partol_time <=", value, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeIn(List<Date> values) {
      addCriterion("partol_time in", values, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeNotIn(List<Date> values) {
      addCriterion("partol_time not in", values, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeBetween(Date value1, Date value2) {
      addCriterion("partol_time between", value1, value2, "partolTime");
      return (Criteria) this;
    }

    public Criteria andPartolTimeNotBetween(Date value1, Date value2) {
      addCriterion("partol_time not between", value1, value2, "partolTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeIsNull() {
      addCriterion("receive_result_time is null");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeIsNotNull() {
      addCriterion("receive_result_time is not null");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeEqualTo(Date value) {
      addCriterion("receive_result_time =", value, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeNotEqualTo(Date value) {
      addCriterion("receive_result_time <>", value, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeGreaterThan(Date value) {
      addCriterion("receive_result_time >", value, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("receive_result_time >=", value, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeLessThan(Date value) {
      addCriterion("receive_result_time <", value, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeLessThanOrEqualTo(Date value) {
      addCriterion("receive_result_time <=", value, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeIn(List<Date> values) {
      addCriterion("receive_result_time in", values, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeNotIn(List<Date> values) {
      addCriterion("receive_result_time not in", values, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeBetween(Date value1, Date value2) {
      addCriterion("receive_result_time between", value1, value2, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andReceiveResultTimeNotBetween(Date value1, Date value2) {
      addCriterion("receive_result_time not between", value1, value2, "receiveResultTime");
      return (Criteria) this;
    }

    public Criteria andResultTypeIsNull() {
      addCriterion("result_type is null");
      return (Criteria) this;
    }

    public Criteria andResultTypeIsNotNull() {
      addCriterion("result_type is not null");
      return (Criteria) this;
    }

    public Criteria andResultTypeEqualTo(Integer value) {
      addCriterion("result_type =", value, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeNotEqualTo(Integer value) {
      addCriterion("result_type <>", value, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeGreaterThan(Integer value) {
      addCriterion("result_type >", value, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("result_type >=", value, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeLessThan(Integer value) {
      addCriterion("result_type <", value, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeLessThanOrEqualTo(Integer value) {
      addCriterion("result_type <=", value, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeIn(List<Integer> values) {
      addCriterion("result_type in", values, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeNotIn(List<Integer> values) {
      addCriterion("result_type not in", values, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeBetween(Integer value1, Integer value2) {
      addCriterion("result_type between", value1, value2, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("result_type not between", value1, value2, "resultType");
      return (Criteria) this;
    }

    public Criteria andResultDescIsNull() {
      addCriterion("result_desc is null");
      return (Criteria) this;
    }

    public Criteria andResultDescIsNotNull() {
      addCriterion("result_desc is not null");
      return (Criteria) this;
    }

    public Criteria andResultDescEqualTo(String value) {
      addCriterion("result_desc =", value, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescNotEqualTo(String value) {
      addCriterion("result_desc <>", value, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescGreaterThan(String value) {
      addCriterion("result_desc >", value, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescGreaterThanOrEqualTo(String value) {
      addCriterion("result_desc >=", value, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescLessThan(String value) {
      addCriterion("result_desc <", value, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescLessThanOrEqualTo(String value) {
      addCriterion("result_desc <=", value, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescLike(String value) {
      addCriterion("result_desc like", value, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescNotLike(String value) {
      addCriterion("result_desc not like", value, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescIn(List<String> values) {
      addCriterion("result_desc in", values, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescNotIn(List<String> values) {
      addCriterion("result_desc not in", values, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescBetween(String value1, String value2) {
      addCriterion("result_desc between", value1, value2, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andResultDescNotBetween(String value1, String value2) {
      addCriterion("result_desc not between", value1, value2, "resultDesc");
      return (Criteria) this;
    }

    public Criteria andAuditStateIsNull() {
      addCriterion("audit_state is null");
      return (Criteria) this;
    }

    public Criteria andAuditStateIsNotNull() {
      addCriterion("audit_state is not null");
      return (Criteria) this;
    }

    public Criteria andAuditStateEqualTo(Integer value) {
      addCriterion("audit_state =", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateNotEqualTo(Integer value) {
      addCriterion("audit_state <>", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateGreaterThan(Integer value) {
      addCriterion("audit_state >", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateGreaterThanOrEqualTo(Integer value) {
      addCriterion("audit_state >=", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateLessThan(Integer value) {
      addCriterion("audit_state <", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateLessThanOrEqualTo(Integer value) {
      addCriterion("audit_state <=", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateIn(List<Integer> values) {
      addCriterion("audit_state in", values, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateNotIn(List<Integer> values) {
      addCriterion("audit_state not in", values, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateBetween(Integer value1, Integer value2) {
      addCriterion("audit_state between", value1, value2, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateNotBetween(Integer value1, Integer value2) {
      addCriterion("audit_state not between", value1, value2, "auditState");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonIsNull() {
      addCriterion("rejection_reason is null");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonIsNotNull() {
      addCriterion("rejection_reason is not null");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonEqualTo(String value) {
      addCriterion("rejection_reason =", value, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonNotEqualTo(String value) {
      addCriterion("rejection_reason <>", value, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonGreaterThan(String value) {
      addCriterion("rejection_reason >", value, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonGreaterThanOrEqualTo(String value) {
      addCriterion("rejection_reason >=", value, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonLessThan(String value) {
      addCriterion("rejection_reason <", value, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonLessThanOrEqualTo(String value) {
      addCriterion("rejection_reason <=", value, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonLike(String value) {
      addCriterion("rejection_reason like", value, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonNotLike(String value) {
      addCriterion("rejection_reason not like", value, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonIn(List<String> values) {
      addCriterion("rejection_reason in", values, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonNotIn(List<String> values) {
      addCriterion("rejection_reason not in", values, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonBetween(String value1, String value2) {
      addCriterion("rejection_reason between", value1, value2, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andRejectionReasonNotBetween(String value1, String value2) {
      addCriterion("rejection_reason not between", value1, value2, "rejectionReason");
      return (Criteria) this;
    }

    public Criteria andAuditorIsNull() {
      addCriterion("auditor is null");
      return (Criteria) this;
    }

    public Criteria andAuditorIsNotNull() {
      addCriterion("auditor is not null");
      return (Criteria) this;
    }

    public Criteria andAuditorEqualTo(String value) {
      addCriterion("auditor =", value, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorNotEqualTo(String value) {
      addCriterion("auditor <>", value, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorGreaterThan(String value) {
      addCriterion("auditor >", value, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorGreaterThanOrEqualTo(String value) {
      addCriterion("auditor >=", value, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorLessThan(String value) {
      addCriterion("auditor <", value, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorLessThanOrEqualTo(String value) {
      addCriterion("auditor <=", value, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorLike(String value) {
      addCriterion("auditor like", value, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorNotLike(String value) {
      addCriterion("auditor not like", value, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorIn(List<String> values) {
      addCriterion("auditor in", values, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorNotIn(List<String> values) {
      addCriterion("auditor not in", values, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorBetween(String value1, String value2) {
      addCriterion("auditor between", value1, value2, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorNotBetween(String value1, String value2) {
      addCriterion("auditor not between", value1, value2, "auditor");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneIsNull() {
      addCriterion("auditor_phone is null");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneIsNotNull() {
      addCriterion("auditor_phone is not null");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneEqualTo(String value) {
      addCriterion("auditor_phone =", value, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneNotEqualTo(String value) {
      addCriterion("auditor_phone <>", value, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneGreaterThan(String value) {
      addCriterion("auditor_phone >", value, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("auditor_phone >=", value, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneLessThan(String value) {
      addCriterion("auditor_phone <", value, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneLessThanOrEqualTo(String value) {
      addCriterion("auditor_phone <=", value, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneLike(String value) {
      addCriterion("auditor_phone like", value, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneNotLike(String value) {
      addCriterion("auditor_phone not like", value, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneIn(List<String> values) {
      addCriterion("auditor_phone in", values, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneNotIn(List<String> values) {
      addCriterion("auditor_phone not in", values, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneBetween(String value1, String value2) {
      addCriterion("auditor_phone between", value1, value2, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andAuditorPhoneNotBetween(String value1, String value2) {
      addCriterion("auditor_phone not between", value1, value2, "auditorPhone");
      return (Criteria) this;
    }

    public Criteria andResultInformStateIsNull() {
      addCriterion("result_inform_state is null");
      return (Criteria) this;
    }

    public Criteria andResultInformStateIsNotNull() {
      addCriterion("result_inform_state is not null");
      return (Criteria) this;
    }

    public Criteria andResultInformStateEqualTo(Integer value) {
      addCriterion("result_inform_state =", value, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateNotEqualTo(Integer value) {
      addCriterion("result_inform_state <>", value, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateGreaterThan(Integer value) {
      addCriterion("result_inform_state >", value, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateGreaterThanOrEqualTo(Integer value) {
      addCriterion("result_inform_state >=", value, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateLessThan(Integer value) {
      addCriterion("result_inform_state <", value, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateLessThanOrEqualTo(Integer value) {
      addCriterion("result_inform_state <=", value, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateIn(List<Integer> values) {
      addCriterion("result_inform_state in", values, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateNotIn(List<Integer> values) {
      addCriterion("result_inform_state not in", values, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateBetween(Integer value1, Integer value2) {
      addCriterion("result_inform_state between", value1, value2, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andResultInformStateNotBetween(Integer value1, Integer value2) {
      addCriterion("result_inform_state not between", value1, value2, "resultInformState");
      return (Criteria) this;
    }

    public Criteria andViolationItemIsNull() {
      addCriterion("violation_item is null");
      return (Criteria) this;
    }

    public Criteria andViolationItemIsNotNull() {
      addCriterion("violation_item is not null");
      return (Criteria) this;
    }

    public Criteria andViolationItemEqualTo(String value) {
      addCriterion("violation_item =", value, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemNotEqualTo(String value) {
      addCriterion("violation_item <>", value, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemGreaterThan(String value) {
      addCriterion("violation_item >", value, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemGreaterThanOrEqualTo(String value) {
      addCriterion("violation_item >=", value, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemLessThan(String value) {
      addCriterion("violation_item <", value, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemLessThanOrEqualTo(String value) {
      addCriterion("violation_item <=", value, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemLike(String value) {
      addCriterion("violation_item like", value, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemNotLike(String value) {
      addCriterion("violation_item not like", value, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemIn(List<String> values) {
      addCriterion("violation_item in", values, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemNotIn(List<String> values) {
      addCriterion("violation_item not in", values, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemBetween(String value1, String value2) {
      addCriterion("violation_item between", value1, value2, "violationItem");
      return (Criteria) this;
    }

    public Criteria andViolationItemNotBetween(String value1, String value2) {
      addCriterion("violation_item not between", value1, value2, "violationItem");
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

    public Criteria andSiAreaIsNull() {
      addCriterion("si_area is null");
      return (Criteria) this;
    }

    public Criteria andSiAreaIsNotNull() {
      addCriterion("si_area is not null");
      return (Criteria) this;
    }

    public Criteria andSiAreaEqualTo(String value) {
      addCriterion("si_area =", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaNotEqualTo(String value) {
      addCriterion("si_area <>", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaGreaterThan(String value) {
      addCriterion("si_area >", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaGreaterThanOrEqualTo(String value) {
      addCriterion("si_area >=", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaLessThan(String value) {
      addCriterion("si_area <", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaLessThanOrEqualTo(String value) {
      addCriterion("si_area <=", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaLike(String value) {
      addCriterion("si_area like", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaNotLike(String value) {
      addCriterion("si_area not like", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaIn(List<String> values) {
      addCriterion("si_area in", values, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaNotIn(List<String> values) {
      addCriterion("si_area not in", values, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaBetween(String value1, String value2) {
      addCriterion("si_area between", value1, value2, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaNotBetween(String value1, String value2) {
      addCriterion("si_area not between", value1, value2, "siArea");
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

    public Criteria andCreatedOrgIsNull() {
      addCriterion("created_org is null");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgIsNotNull() {
      addCriterion("created_org is not null");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgEqualTo(String value) {
      addCriterion("created_org =", value, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgNotEqualTo(String value) {
      addCriterion("created_org <>", value, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgGreaterThan(String value) {
      addCriterion("created_org >", value, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgGreaterThanOrEqualTo(String value) {
      addCriterion("created_org >=", value, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgLessThan(String value) {
      addCriterion("created_org <", value, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgLessThanOrEqualTo(String value) {
      addCriterion("created_org <=", value, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgLike(String value) {
      addCriterion("created_org like", value, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgNotLike(String value) {
      addCriterion("created_org not like", value, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgIn(List<String> values) {
      addCriterion("created_org in", values, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgNotIn(List<String> values) {
      addCriterion("created_org not in", values, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgBetween(String value1, String value2) {
      addCriterion("created_org between", value1, value2, "createdOrg");
      return (Criteria) this;
    }

    public Criteria andCreatedOrgNotBetween(String value1, String value2) {
      addCriterion("created_org not between", value1, value2, "createdOrg");
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
