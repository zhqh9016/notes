package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatrolTaskDetailDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public PatrolTaskDetailDOExample() {
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

    public Criteria andTaskDetailIdIsNull() {
      addCriterion("task_detail_id is null");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdIsNotNull() {
      addCriterion("task_detail_id is not null");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdEqualTo(String value) {
      addCriterion("task_detail_id =", value, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdNotEqualTo(String value) {
      addCriterion("task_detail_id <>", value, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdGreaterThan(String value) {
      addCriterion("task_detail_id >", value, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdGreaterThanOrEqualTo(String value) {
      addCriterion("task_detail_id >=", value, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdLessThan(String value) {
      addCriterion("task_detail_id <", value, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdLessThanOrEqualTo(String value) {
      addCriterion("task_detail_id <=", value, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdLike(String value) {
      addCriterion("task_detail_id like", value, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdNotLike(String value) {
      addCriterion("task_detail_id not like", value, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdIn(List<String> values) {
      addCriterion("task_detail_id in", values, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdNotIn(List<String> values) {
      addCriterion("task_detail_id not in", values, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdBetween(String value1, String value2) {
      addCriterion("task_detail_id between", value1, value2, "taskDetailId");
      return (Criteria) this;
    }

    public Criteria andTaskDetailIdNotBetween(String value1, String value2) {
      addCriterion("task_detail_id not between", value1, value2, "taskDetailId");
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

    public Criteria andOrgTaskIdIsNull() {
      addCriterion("org_task_id is null");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdIsNotNull() {
      addCriterion("org_task_id is not null");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdEqualTo(String value) {
      addCriterion("org_task_id =", value, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdNotEqualTo(String value) {
      addCriterion("org_task_id <>", value, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdGreaterThan(String value) {
      addCriterion("org_task_id >", value, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdGreaterThanOrEqualTo(String value) {
      addCriterion("org_task_id >=", value, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdLessThan(String value) {
      addCriterion("org_task_id <", value, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdLessThanOrEqualTo(String value) {
      addCriterion("org_task_id <=", value, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdLike(String value) {
      addCriterion("org_task_id like", value, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdNotLike(String value) {
      addCriterion("org_task_id not like", value, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdIn(List<String> values) {
      addCriterion("org_task_id in", values, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdNotIn(List<String> values) {
      addCriterion("org_task_id not in", values, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdBetween(String value1, String value2) {
      addCriterion("org_task_id between", value1, value2, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andOrgTaskIdNotBetween(String value1, String value2) {
      addCriterion("org_task_id not between", value1, value2, "orgTaskId");
      return (Criteria) this;
    }

    public Criteria andPersonNameIsNull() {
      addCriterion("person_name is null");
      return (Criteria) this;
    }

    public Criteria andPersonNameIsNotNull() {
      addCriterion("person_name is not null");
      return (Criteria) this;
    }

    public Criteria andPersonNameEqualTo(String value) {
      addCriterion("person_name =", value, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameNotEqualTo(String value) {
      addCriterion("person_name <>", value, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameGreaterThan(String value) {
      addCriterion("person_name >", value, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
      addCriterion("person_name >=", value, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameLessThan(String value) {
      addCriterion("person_name <", value, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameLessThanOrEqualTo(String value) {
      addCriterion("person_name <=", value, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameLike(String value) {
      addCriterion("person_name like", value, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameNotLike(String value) {
      addCriterion("person_name not like", value, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameIn(List<String> values) {
      addCriterion("person_name in", values, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameNotIn(List<String> values) {
      addCriterion("person_name not in", values, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameBetween(String value1, String value2) {
      addCriterion("person_name between", value1, value2, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonNameNotBetween(String value1, String value2) {
      addCriterion("person_name not between", value1, value2, "personName");
      return (Criteria) this;
    }

    public Criteria andPersonCodeIsNull() {
      addCriterion("person_code is null");
      return (Criteria) this;
    }

    public Criteria andPersonCodeIsNotNull() {
      addCriterion("person_code is not null");
      return (Criteria) this;
    }

    public Criteria andPersonCodeEqualTo(String value) {
      addCriterion("person_code =", value, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeNotEqualTo(String value) {
      addCriterion("person_code <>", value, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeGreaterThan(String value) {
      addCriterion("person_code >", value, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeGreaterThanOrEqualTo(String value) {
      addCriterion("person_code >=", value, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeLessThan(String value) {
      addCriterion("person_code <", value, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeLessThanOrEqualTo(String value) {
      addCriterion("person_code <=", value, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeLike(String value) {
      addCriterion("person_code like", value, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeNotLike(String value) {
      addCriterion("person_code not like", value, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeIn(List<String> values) {
      addCriterion("person_code in", values, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeNotIn(List<String> values) {
      addCriterion("person_code not in", values, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeBetween(String value1, String value2) {
      addCriterion("person_code between", value1, value2, "personCode");
      return (Criteria) this;
    }

    public Criteria andPersonCodeNotBetween(String value1, String value2) {
      addCriterion("person_code not between", value1, value2, "personCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeIsNull() {
      addCriterion("agency_code is null");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeIsNotNull() {
      addCriterion("agency_code is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeEqualTo(String value) {
      addCriterion("agency_code =", value, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeNotEqualTo(String value) {
      addCriterion("agency_code <>", value, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeGreaterThan(String value) {
      addCriterion("agency_code >", value, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeGreaterThanOrEqualTo(String value) {
      addCriterion("agency_code >=", value, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeLessThan(String value) {
      addCriterion("agency_code <", value, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeLessThanOrEqualTo(String value) {
      addCriterion("agency_code <=", value, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeLike(String value) {
      addCriterion("agency_code like", value, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeNotLike(String value) {
      addCriterion("agency_code not like", value, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeIn(List<String> values) {
      addCriterion("agency_code in", values, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeNotIn(List<String> values) {
      addCriterion("agency_code not in", values, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeBetween(String value1, String value2) {
      addCriterion("agency_code between", value1, value2, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andAgencyCodeNotBetween(String value1, String value2) {
      addCriterion("agency_code not between", value1, value2, "agencyCode");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateIsNull() {
      addCriterion("preevaluate_date is null");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateIsNotNull() {
      addCriterion("preevaluate_date is not null");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateEqualTo(Date value) {
      addCriterion("preevaluate_date =", value, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateNotEqualTo(Date value) {
      addCriterion("preevaluate_date <>", value, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateGreaterThan(Date value) {
      addCriterion("preevaluate_date >", value, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("preevaluate_date >=", value, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateLessThan(Date value) {
      addCriterion("preevaluate_date <", value, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateLessThanOrEqualTo(Date value) {
      addCriterion("preevaluate_date <=", value, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateIn(List<Date> values) {
      addCriterion("preevaluate_date in", values, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateNotIn(List<Date> values) {
      addCriterion("preevaluate_date not in", values, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateBetween(Date value1, Date value2) {
      addCriterion("preevaluate_date between", value1, value2, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andPreevaluateDateNotBetween(Date value1, Date value2) {
      addCriterion("preevaluate_date not between", value1, value2, "preevaluateDate");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeIsNull() {
      addCriterion("insurance_code is null");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeIsNotNull() {
      addCriterion("insurance_code is not null");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeEqualTo(String value) {
      addCriterion("insurance_code =", value, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeNotEqualTo(String value) {
      addCriterion("insurance_code <>", value, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeGreaterThan(String value) {
      addCriterion("insurance_code >", value, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeGreaterThanOrEqualTo(String value) {
      addCriterion("insurance_code >=", value, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeLessThan(String value) {
      addCriterion("insurance_code <", value, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeLessThanOrEqualTo(String value) {
      addCriterion("insurance_code <=", value, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeLike(String value) {
      addCriterion("insurance_code like", value, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeNotLike(String value) {
      addCriterion("insurance_code not like", value, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeIn(List<String> values) {
      addCriterion("insurance_code in", values, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeNotIn(List<String> values) {
      addCriterion("insurance_code not in", values, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeBetween(String value1, String value2) {
      addCriterion("insurance_code between", value1, value2, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceCodeNotBetween(String value1, String value2) {
      addCriterion("insurance_code not between", value1, value2, "insuranceCode");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameIsNull() {
      addCriterion("insurance_name is null");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameIsNotNull() {
      addCriterion("insurance_name is not null");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameEqualTo(String value) {
      addCriterion("insurance_name =", value, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameNotEqualTo(String value) {
      addCriterion("insurance_name <>", value, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameGreaterThan(String value) {
      addCriterion("insurance_name >", value, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameGreaterThanOrEqualTo(String value) {
      addCriterion("insurance_name >=", value, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameLessThan(String value) {
      addCriterion("insurance_name <", value, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameLessThanOrEqualTo(String value) {
      addCriterion("insurance_name <=", value, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameLike(String value) {
      addCriterion("insurance_name like", value, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameNotLike(String value) {
      addCriterion("insurance_name not like", value, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameIn(List<String> values) {
      addCriterion("insurance_name in", values, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameNotIn(List<String> values) {
      addCriterion("insurance_name not in", values, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameBetween(String value1, String value2) {
      addCriterion("insurance_name between", value1, value2, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsuranceNameNotBetween(String value1, String value2) {
      addCriterion("insurance_name not between", value1, value2, "insuranceName");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeIsNull() {
      addCriterion("insurance_papers_type is null");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeIsNotNull() {
      addCriterion("insurance_papers_type is not null");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeEqualTo(Integer value) {
      addCriterion("insurance_papers_type =", value, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeNotEqualTo(Integer value) {
      addCriterion("insurance_papers_type <>", value, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeGreaterThan(Integer value) {
      addCriterion("insurance_papers_type >", value, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("insurance_papers_type >=", value, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeLessThan(Integer value) {
      addCriterion("insurance_papers_type <", value, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeLessThanOrEqualTo(Integer value) {
      addCriterion("insurance_papers_type <=", value, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeIn(List<Integer> values) {
      addCriterion("insurance_papers_type in", values, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeNotIn(List<Integer> values) {
      addCriterion("insurance_papers_type not in", values, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeBetween(Integer value1, Integer value2) {
      addCriterion("insurance_papers_type between", value1, value2, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("insurance_papers_type not between", value1, value2, "insurancePapersType");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoIsNull() {
      addCriterion("insurance_papers_no is null");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoIsNotNull() {
      addCriterion("insurance_papers_no is not null");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoEqualTo(String value) {
      addCriterion("insurance_papers_no =", value, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoNotEqualTo(String value) {
      addCriterion("insurance_papers_no <>", value, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoGreaterThan(String value) {
      addCriterion("insurance_papers_no >", value, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoGreaterThanOrEqualTo(String value) {
      addCriterion("insurance_papers_no >=", value, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoLessThan(String value) {
      addCriterion("insurance_papers_no <", value, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoLessThanOrEqualTo(String value) {
      addCriterion("insurance_papers_no <=", value, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoLike(String value) {
      addCriterion("insurance_papers_no like", value, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoNotLike(String value) {
      addCriterion("insurance_papers_no not like", value, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoIn(List<String> values) {
      addCriterion("insurance_papers_no in", values, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoNotIn(List<String> values) {
      addCriterion("insurance_papers_no not in", values, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoBetween(String value1, String value2) {
      addCriterion("insurance_papers_no between", value1, value2, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePapersNoNotBetween(String value1, String value2) {
      addCriterion("insurance_papers_no not between", value1, value2, "insurancePapersNo");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneIsNull() {
      addCriterion("insurance_phone is null");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneIsNotNull() {
      addCriterion("insurance_phone is not null");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneEqualTo(String value) {
      addCriterion("insurance_phone =", value, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneNotEqualTo(String value) {
      addCriterion("insurance_phone <>", value, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneGreaterThan(String value) {
      addCriterion("insurance_phone >", value, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneGreaterThanOrEqualTo(String value) {
      addCriterion("insurance_phone >=", value, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneLessThan(String value) {
      addCriterion("insurance_phone <", value, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneLessThanOrEqualTo(String value) {
      addCriterion("insurance_phone <=", value, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneLike(String value) {
      addCriterion("insurance_phone like", value, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneNotLike(String value) {
      addCriterion("insurance_phone not like", value, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneIn(List<String> values) {
      addCriterion("insurance_phone in", values, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneNotIn(List<String> values) {
      addCriterion("insurance_phone not in", values, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneBetween(String value1, String value2) {
      addCriterion("insurance_phone between", value1, value2, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsurancePhoneNotBetween(String value1, String value2) {
      addCriterion("insurance_phone not between", value1, value2, "insurancePhone");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressIsNull() {
      addCriterion("insurance_address is null");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressIsNotNull() {
      addCriterion("insurance_address is not null");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressEqualTo(String value) {
      addCriterion("insurance_address =", value, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressNotEqualTo(String value) {
      addCriterion("insurance_address <>", value, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressGreaterThan(String value) {
      addCriterion("insurance_address >", value, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressGreaterThanOrEqualTo(String value) {
      addCriterion("insurance_address >=", value, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressLessThan(String value) {
      addCriterion("insurance_address <", value, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressLessThanOrEqualTo(String value) {
      addCriterion("insurance_address <=", value, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressLike(String value) {
      addCriterion("insurance_address like", value, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressNotLike(String value) {
      addCriterion("insurance_address not like", value, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressIn(List<String> values) {
      addCriterion("insurance_address in", values, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressNotIn(List<String> values) {
      addCriterion("insurance_address not in", values, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressBetween(String value1, String value2) {
      addCriterion("insurance_address between", value1, value2, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andInsuranceAddressNotBetween(String value1, String value2) {
      addCriterion("insurance_address not between", value1, value2, "insuranceAddress");
      return (Criteria) this;
    }

    public Criteria andLongitudeIsNull() {
      addCriterion("longitude is null");
      return (Criteria) this;
    }

    public Criteria andLongitudeIsNotNull() {
      addCriterion("longitude is not null");
      return (Criteria) this;
    }

    public Criteria andLongitudeEqualTo(String value) {
      addCriterion("longitude =", value, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeNotEqualTo(String value) {
      addCriterion("longitude <>", value, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeGreaterThan(String value) {
      addCriterion("longitude >", value, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
      addCriterion("longitude >=", value, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeLessThan(String value) {
      addCriterion("longitude <", value, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeLessThanOrEqualTo(String value) {
      addCriterion("longitude <=", value, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeLike(String value) {
      addCriterion("longitude like", value, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeNotLike(String value) {
      addCriterion("longitude not like", value, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeIn(List<String> values) {
      addCriterion("longitude in", values, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeNotIn(List<String> values) {
      addCriterion("longitude not in", values, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeBetween(String value1, String value2) {
      addCriterion("longitude between", value1, value2, "longitude");
      return (Criteria) this;
    }

    public Criteria andLongitudeNotBetween(String value1, String value2) {
      addCriterion("longitude not between", value1, value2, "longitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeIsNull() {
      addCriterion("latitude is null");
      return (Criteria) this;
    }

    public Criteria andLatitudeIsNotNull() {
      addCriterion("latitude is not null");
      return (Criteria) this;
    }

    public Criteria andLatitudeEqualTo(String value) {
      addCriterion("latitude =", value, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeNotEqualTo(String value) {
      addCriterion("latitude <>", value, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeGreaterThan(String value) {
      addCriterion("latitude >", value, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
      addCriterion("latitude >=", value, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeLessThan(String value) {
      addCriterion("latitude <", value, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeLessThanOrEqualTo(String value) {
      addCriterion("latitude <=", value, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeLike(String value) {
      addCriterion("latitude like", value, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeNotLike(String value) {
      addCriterion("latitude not like", value, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeIn(List<String> values) {
      addCriterion("latitude in", values, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeNotIn(List<String> values) {
      addCriterion("latitude not in", values, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeBetween(String value1, String value2) {
      addCriterion("latitude between", value1, value2, "latitude");
      return (Criteria) this;
    }

    public Criteria andLatitudeNotBetween(String value1, String value2) {
      addCriterion("latitude not between", value1, value2, "latitude");
      return (Criteria) this;
    }

    public Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return (Criteria) this;
    }

    public Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return (Criteria) this;
    }

    public Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return (Criteria) this;
    }

    public Criteria andServiceTypeIsNull() {
      addCriterion("service_type is null");
      return (Criteria) this;
    }

    public Criteria andServiceTypeIsNotNull() {
      addCriterion("service_type is not null");
      return (Criteria) this;
    }

    public Criteria andServiceTypeEqualTo(Integer value) {
      addCriterion("service_type =", value, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeNotEqualTo(Integer value) {
      addCriterion("service_type <>", value, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeGreaterThan(Integer value) {
      addCriterion("service_type >", value, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("service_type >=", value, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeLessThan(Integer value) {
      addCriterion("service_type <", value, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeLessThanOrEqualTo(Integer value) {
      addCriterion("service_type <=", value, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeIn(List<Integer> values) {
      addCriterion("service_type in", values, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeNotIn(List<Integer> values) {
      addCriterion("service_type not in", values, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeBetween(Integer value1, Integer value2) {
      addCriterion("service_type between", value1, value2, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("service_type not between", value1, value2, "serviceType");
      return (Criteria) this;
    }

    public Criteria andServiceItemsIsNull() {
      addCriterion("service_items is null");
      return (Criteria) this;
    }

    public Criteria andServiceItemsIsNotNull() {
      addCriterion("service_items is not null");
      return (Criteria) this;
    }

    public Criteria andServiceItemsEqualTo(String value) {
      addCriterion("service_items =", value, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsNotEqualTo(String value) {
      addCriterion("service_items <>", value, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsGreaterThan(String value) {
      addCriterion("service_items >", value, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsGreaterThanOrEqualTo(String value) {
      addCriterion("service_items >=", value, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsLessThan(String value) {
      addCriterion("service_items <", value, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsLessThanOrEqualTo(String value) {
      addCriterion("service_items <=", value, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsLike(String value) {
      addCriterion("service_items like", value, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsNotLike(String value) {
      addCriterion("service_items not like", value, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsIn(List<String> values) {
      addCriterion("service_items in", values, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsNotIn(List<String> values) {
      addCriterion("service_items not in", values, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsBetween(String value1, String value2) {
      addCriterion("service_items between", value1, value2, "serviceItems");
      return (Criteria) this;
    }

    public Criteria andServiceItemsNotBetween(String value1, String value2) {
      addCriterion("service_items not between", value1, value2, "serviceItems");
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

    public Criteria andIsCriticalIsNull() {
      addCriterion("is_critical is null");
      return (Criteria) this;
    }

    public Criteria andIsCriticalIsNotNull() {
      addCriterion("is_critical is not null");
      return (Criteria) this;
    }

    public Criteria andIsCriticalEqualTo(Integer value) {
      addCriterion("is_critical =", value, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalNotEqualTo(Integer value) {
      addCriterion("is_critical <>", value, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalGreaterThan(Integer value) {
      addCriterion("is_critical >", value, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalGreaterThanOrEqualTo(Integer value) {
      addCriterion("is_critical >=", value, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalLessThan(Integer value) {
      addCriterion("is_critical <", value, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalLessThanOrEqualTo(Integer value) {
      addCriterion("is_critical <=", value, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalIn(List<Integer> values) {
      addCriterion("is_critical in", values, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalNotIn(List<Integer> values) {
      addCriterion("is_critical not in", values, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalBetween(Integer value1, Integer value2) {
      addCriterion("is_critical between", value1, value2, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsCriticalNotBetween(Integer value1, Integer value2) {
      addCriterion("is_critical not between", value1, value2, "isCritical");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareIsNull() {
      addCriterion("is_kinship_care is null");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareIsNotNull() {
      addCriterion("is_kinship_care is not null");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareEqualTo(Integer value) {
      addCriterion("is_kinship_care =", value, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareNotEqualTo(Integer value) {
      addCriterion("is_kinship_care <>", value, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareGreaterThan(Integer value) {
      addCriterion("is_kinship_care >", value, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareGreaterThanOrEqualTo(Integer value) {
      addCriterion("is_kinship_care >=", value, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareLessThan(Integer value) {
      addCriterion("is_kinship_care <", value, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareLessThanOrEqualTo(Integer value) {
      addCriterion("is_kinship_care <=", value, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareIn(List<Integer> values) {
      addCriterion("is_kinship_care in", values, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareNotIn(List<Integer> values) {
      addCriterion("is_kinship_care not in", values, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareBetween(Integer value1, Integer value2) {
      addCriterion("is_kinship_care between", value1, value2, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsKinshipCareNotBetween(Integer value1, Integer value2) {
      addCriterion("is_kinship_care not between", value1, value2, "isKinshipCare");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeIsNull() {
      addCriterion("is_privilege is null");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeIsNotNull() {
      addCriterion("is_privilege is not null");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeEqualTo(Integer value) {
      addCriterion("is_privilege =", value, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeNotEqualTo(Integer value) {
      addCriterion("is_privilege <>", value, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeGreaterThan(Integer value) {
      addCriterion("is_privilege >", value, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeGreaterThanOrEqualTo(Integer value) {
      addCriterion("is_privilege >=", value, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeLessThan(Integer value) {
      addCriterion("is_privilege <", value, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeLessThanOrEqualTo(Integer value) {
      addCriterion("is_privilege <=", value, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeIn(List<Integer> values) {
      addCriterion("is_privilege in", values, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeNotIn(List<Integer> values) {
      addCriterion("is_privilege not in", values, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeBetween(Integer value1, Integer value2) {
      addCriterion("is_privilege between", value1, value2, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andIsPrivilegeNotBetween(Integer value1, Integer value2) {
      addCriterion("is_privilege not between", value1, value2, "isPrivilege");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneIsNull() {
      addCriterion("person_phone is null");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneIsNotNull() {
      addCriterion("person_phone is not null");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneEqualTo(String value) {
      addCriterion("person_phone =", value, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneNotEqualTo(String value) {
      addCriterion("person_phone <>", value, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneGreaterThan(String value) {
      addCriterion("person_phone >", value, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("person_phone >=", value, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneLessThan(String value) {
      addCriterion("person_phone <", value, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneLessThanOrEqualTo(String value) {
      addCriterion("person_phone <=", value, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneLike(String value) {
      addCriterion("person_phone like", value, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneNotLike(String value) {
      addCriterion("person_phone not like", value, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneIn(List<String> values) {
      addCriterion("person_phone in", values, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneNotIn(List<String> values) {
      addCriterion("person_phone not in", values, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneBetween(String value1, String value2) {
      addCriterion("person_phone between", value1, value2, "personPhone");
      return (Criteria) this;
    }

    public Criteria andPersonPhoneNotBetween(String value1, String value2) {
      addCriterion("person_phone not between", value1, value2, "personPhone");
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
