package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatrolTaskDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public PatrolTaskDOExample() {
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

    public Criteria andPatrolObjectTypeIsNull() {
      addCriterion("patrol_object_type is null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeIsNotNull() {
      addCriterion("patrol_object_type is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeEqualTo(Integer value) {
      addCriterion("patrol_object_type =", value, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeNotEqualTo(Integer value) {
      addCriterion("patrol_object_type <>", value, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeGreaterThan(Integer value) {
      addCriterion("patrol_object_type >", value, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("patrol_object_type >=", value, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeLessThan(Integer value) {
      addCriterion("patrol_object_type <", value, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeLessThanOrEqualTo(Integer value) {
      addCriterion("patrol_object_type <=", value, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeIn(List<Integer> values) {
      addCriterion("patrol_object_type in", values, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeNotIn(List<Integer> values) {
      addCriterion("patrol_object_type not in", values, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeBetween(Integer value1, Integer value2) {
      addCriterion("patrol_object_type between", value1, value2, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("patrol_object_type not between", value1, value2, "patrolObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdIsNull() {
      addCriterion("patrol_object_id is null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdIsNotNull() {
      addCriterion("patrol_object_id is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdEqualTo(String value) {
      addCriterion("patrol_object_id =", value, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdNotEqualTo(String value) {
      addCriterion("patrol_object_id <>", value, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdGreaterThan(String value) {
      addCriterion("patrol_object_id >", value, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_object_id >=", value, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdLessThan(String value) {
      addCriterion("patrol_object_id <", value, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdLessThanOrEqualTo(String value) {
      addCriterion("patrol_object_id <=", value, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdLike(String value) {
      addCriterion("patrol_object_id like", value, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdNotLike(String value) {
      addCriterion("patrol_object_id not like", value, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdIn(List<String> values) {
      addCriterion("patrol_object_id in", values, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdNotIn(List<String> values) {
      addCriterion("patrol_object_id not in", values, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdBetween(String value1, String value2) {
      addCriterion("patrol_object_id between", value1, value2, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectIdNotBetween(String value1, String value2) {
      addCriterion("patrol_object_id not between", value1, value2, "patrolObjectId");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameIsNull() {
      addCriterion("patrol_object_name is null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameIsNotNull() {
      addCriterion("patrol_object_name is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameEqualTo(String value) {
      addCriterion("patrol_object_name =", value, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameNotEqualTo(String value) {
      addCriterion("patrol_object_name <>", value, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameGreaterThan(String value) {
      addCriterion("patrol_object_name >", value, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_object_name >=", value, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameLessThan(String value) {
      addCriterion("patrol_object_name <", value, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameLessThanOrEqualTo(String value) {
      addCriterion("patrol_object_name <=", value, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameLike(String value) {
      addCriterion("patrol_object_name like", value, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameNotLike(String value) {
      addCriterion("patrol_object_name not like", value, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameIn(List<String> values) {
      addCriterion("patrol_object_name in", values, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameNotIn(List<String> values) {
      addCriterion("patrol_object_name not in", values, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameBetween(String value1, String value2) {
      addCriterion("patrol_object_name between", value1, value2, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectNameNotBetween(String value1, String value2) {
      addCriterion("patrol_object_name not between", value1, value2, "patrolObjectName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneIsNull() {
      addCriterion("patrol_object_phone is null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneIsNotNull() {
      addCriterion("patrol_object_phone is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneEqualTo(String value) {
      addCriterion("patrol_object_phone =", value, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneNotEqualTo(String value) {
      addCriterion("patrol_object_phone <>", value, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneGreaterThan(String value) {
      addCriterion("patrol_object_phone >", value, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_object_phone >=", value, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneLessThan(String value) {
      addCriterion("patrol_object_phone <", value, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneLessThanOrEqualTo(String value) {
      addCriterion("patrol_object_phone <=", value, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneLike(String value) {
      addCriterion("patrol_object_phone like", value, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneNotLike(String value) {
      addCriterion("patrol_object_phone not like", value, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneIn(List<String> values) {
      addCriterion("patrol_object_phone in", values, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneNotIn(List<String> values) {
      addCriterion("patrol_object_phone not in", values, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneBetween(String value1, String value2) {
      addCriterion("patrol_object_phone between", value1, value2, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectPhoneNotBetween(String value1, String value2) {
      addCriterion("patrol_object_phone not between", value1, value2, "patrolObjectPhone");
      return (Criteria) this;
    }

    public Criteria andIdCardIsNull() {
      addCriterion("id_card is null");
      return (Criteria) this;
    }

    public Criteria andIdCardIsNotNull() {
      addCriterion("id_card is not null");
      return (Criteria) this;
    }

    public Criteria andIdCardEqualTo(String value) {
      addCriterion("id_card =", value, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardNotEqualTo(String value) {
      addCriterion("id_card <>", value, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardGreaterThan(String value) {
      addCriterion("id_card >", value, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardGreaterThanOrEqualTo(String value) {
      addCriterion("id_card >=", value, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardLessThan(String value) {
      addCriterion("id_card <", value, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardLessThanOrEqualTo(String value) {
      addCriterion("id_card <=", value, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardLike(String value) {
      addCriterion("id_card like", value, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardNotLike(String value) {
      addCriterion("id_card not like", value, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardIn(List<String> values) {
      addCriterion("id_card in", values, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardNotIn(List<String> values) {
      addCriterion("id_card not in", values, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardBetween(String value1, String value2) {
      addCriterion("id_card between", value1, value2, "idCard");
      return (Criteria) this;
    }

    public Criteria andIdCardNotBetween(String value1, String value2) {
      addCriterion("id_card not between", value1, value2, "idCard");
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

    public Criteria andAgencyNameIsNull() {
      addCriterion("agency_name is null");
      return (Criteria) this;
    }

    public Criteria andAgencyNameIsNotNull() {
      addCriterion("agency_name is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyNameEqualTo(String value) {
      addCriterion("agency_name =", value, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameNotEqualTo(String value) {
      addCriterion("agency_name <>", value, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameGreaterThan(String value) {
      addCriterion("agency_name >", value, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameGreaterThanOrEqualTo(String value) {
      addCriterion("agency_name >=", value, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameLessThan(String value) {
      addCriterion("agency_name <", value, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameLessThanOrEqualTo(String value) {
      addCriterion("agency_name <=", value, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameLike(String value) {
      addCriterion("agency_name like", value, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameNotLike(String value) {
      addCriterion("agency_name not like", value, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameIn(List<String> values) {
      addCriterion("agency_name in", values, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameNotIn(List<String> values) {
      addCriterion("agency_name not in", values, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameBetween(String value1, String value2) {
      addCriterion("agency_name between", value1, value2, "agencyName");
      return (Criteria) this;
    }

    public Criteria andAgencyNameNotBetween(String value1, String value2) {
      addCriterion("agency_name not between", value1, value2, "agencyName");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrIsNull() {
      addCriterion("patrol_object_addr is null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrIsNotNull() {
      addCriterion("patrol_object_addr is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrEqualTo(String value) {
      addCriterion("patrol_object_addr =", value, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrNotEqualTo(String value) {
      addCriterion("patrol_object_addr <>", value, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrGreaterThan(String value) {
      addCriterion("patrol_object_addr >", value, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_object_addr >=", value, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrLessThan(String value) {
      addCriterion("patrol_object_addr <", value, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrLessThanOrEqualTo(String value) {
      addCriterion("patrol_object_addr <=", value, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrLike(String value) {
      addCriterion("patrol_object_addr like", value, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrNotLike(String value) {
      addCriterion("patrol_object_addr not like", value, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrIn(List<String> values) {
      addCriterion("patrol_object_addr in", values, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrNotIn(List<String> values) {
      addCriterion("patrol_object_addr not in", values, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrBetween(String value1, String value2) {
      addCriterion("patrol_object_addr between", value1, value2, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolObjectAddrNotBetween(String value1, String value2) {
      addCriterion("patrol_object_addr not between", value1, value2, "patrolObjectAddr");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkIsNull() {
      addCriterion("patrol_remark is null");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkIsNotNull() {
      addCriterion("patrol_remark is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkEqualTo(String value) {
      addCriterion("patrol_remark =", value, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkNotEqualTo(String value) {
      addCriterion("patrol_remark <>", value, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkGreaterThan(String value) {
      addCriterion("patrol_remark >", value, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_remark >=", value, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkLessThan(String value) {
      addCriterion("patrol_remark <", value, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkLessThanOrEqualTo(String value) {
      addCriterion("patrol_remark <=", value, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkLike(String value) {
      addCriterion("patrol_remark like", value, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkNotLike(String value) {
      addCriterion("patrol_remark not like", value, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkIn(List<String> values) {
      addCriterion("patrol_remark in", values, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkNotIn(List<String> values) {
      addCriterion("patrol_remark not in", values, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkBetween(String value1, String value2) {
      addCriterion("patrol_remark between", value1, value2, "patrolRemark");
      return (Criteria) this;
    }

    public Criteria andPatrolRemarkNotBetween(String value1, String value2) {
      addCriterion("patrol_remark not between", value1, value2, "patrolRemark");
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

    public Criteria andTaskCategoryIsNull() {
      addCriterion("task_category is null");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryIsNotNull() {
      addCriterion("task_category is not null");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryEqualTo(Integer value) {
      addCriterion("task_category =", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryNotEqualTo(Integer value) {
      addCriterion("task_category <>", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryGreaterThan(Integer value) {
      addCriterion("task_category >", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryGreaterThanOrEqualTo(Integer value) {
      addCriterion("task_category >=", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryLessThan(Integer value) {
      addCriterion("task_category <", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryLessThanOrEqualTo(Integer value) {
      addCriterion("task_category <=", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryIn(List<Integer> values) {
      addCriterion("task_category in", values, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryNotIn(List<Integer> values) {
      addCriterion("task_category not in", values, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryBetween(Integer value1, Integer value2) {
      addCriterion("task_category between", value1, value2, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryNotBetween(Integer value1, Integer value2) {
      addCriterion("task_category not between", value1, value2, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskLevelIsNull() {
      addCriterion("task_level is null");
      return (Criteria) this;
    }

    public Criteria andTaskLevelIsNotNull() {
      addCriterion("task_level is not null");
      return (Criteria) this;
    }

    public Criteria andTaskLevelEqualTo(Integer value) {
      addCriterion("task_level =", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelNotEqualTo(Integer value) {
      addCriterion("task_level <>", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelGreaterThan(Integer value) {
      addCriterion("task_level >", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelGreaterThanOrEqualTo(Integer value) {
      addCriterion("task_level >=", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelLessThan(Integer value) {
      addCriterion("task_level <", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelLessThanOrEqualTo(Integer value) {
      addCriterion("task_level <=", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelIn(List<Integer> values) {
      addCriterion("task_level in", values, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelNotIn(List<Integer> values) {
      addCriterion("task_level not in", values, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelBetween(Integer value1, Integer value2) {
      addCriterion("task_level between", value1, value2, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelNotBetween(Integer value1, Integer value2) {
      addCriterion("task_level not between", value1, value2, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeIsNull() {
      addCriterion("patrols_type is null");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeIsNotNull() {
      addCriterion("patrols_type is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeEqualTo(Integer value) {
      addCriterion("patrols_type =", value, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeNotEqualTo(Integer value) {
      addCriterion("patrols_type <>", value, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeGreaterThan(Integer value) {
      addCriterion("patrols_type >", value, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("patrols_type >=", value, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeLessThan(Integer value) {
      addCriterion("patrols_type <", value, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeLessThanOrEqualTo(Integer value) {
      addCriterion("patrols_type <=", value, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeIn(List<Integer> values) {
      addCriterion("patrols_type in", values, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeNotIn(List<Integer> values) {
      addCriterion("patrols_type not in", values, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeBetween(Integer value1, Integer value2) {
      addCriterion("patrols_type between", value1, value2, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andPatrolsTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("patrols_type not between", value1, value2, "patrolsType");
      return (Criteria) this;
    }

    public Criteria andTaskStateIsNull() {
      addCriterion("task_state is null");
      return (Criteria) this;
    }

    public Criteria andTaskStateIsNotNull() {
      addCriterion("task_state is not null");
      return (Criteria) this;
    }

    public Criteria andTaskStateEqualTo(Integer value) {
      addCriterion("task_state =", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateNotEqualTo(Integer value) {
      addCriterion("task_state <>", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateGreaterThan(Integer value) {
      addCriterion("task_state >", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateGreaterThanOrEqualTo(Integer value) {
      addCriterion("task_state >=", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateLessThan(Integer value) {
      addCriterion("task_state <", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateLessThanOrEqualTo(Integer value) {
      addCriterion("task_state <=", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateIn(List<Integer> values) {
      addCriterion("task_state in", values, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateNotIn(List<Integer> values) {
      addCriterion("task_state not in", values, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateBetween(Integer value1, Integer value2) {
      addCriterion("task_state between", value1, value2, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateNotBetween(Integer value1, Integer value2) {
      addCriterion("task_state not between", value1, value2, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskNumberIsNull() {
      addCriterion("task_number is null");
      return (Criteria) this;
    }

    public Criteria andTaskNumberIsNotNull() {
      addCriterion("task_number is not null");
      return (Criteria) this;
    }

    public Criteria andTaskNumberEqualTo(String value) {
      addCriterion("task_number =", value, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberNotEqualTo(String value) {
      addCriterion("task_number <>", value, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberGreaterThan(String value) {
      addCriterion("task_number >", value, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberGreaterThanOrEqualTo(String value) {
      addCriterion("task_number >=", value, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberLessThan(String value) {
      addCriterion("task_number <", value, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberLessThanOrEqualTo(String value) {
      addCriterion("task_number <=", value, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberLike(String value) {
      addCriterion("task_number like", value, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberNotLike(String value) {
      addCriterion("task_number not like", value, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberIn(List<String> values) {
      addCriterion("task_number in", values, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberNotIn(List<String> values) {
      addCriterion("task_number not in", values, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberBetween(String value1, String value2) {
      addCriterion("task_number between", value1, value2, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andTaskNumberNotBetween(String value1, String value2) {
      addCriterion("task_number not between", value1, value2, "taskNumber");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdIsNull() {
      addCriterion("complaint_object_id is null");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdIsNotNull() {
      addCriterion("complaint_object_id is not null");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdEqualTo(String value) {
      addCriterion("complaint_object_id =", value, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdNotEqualTo(String value) {
      addCriterion("complaint_object_id <>", value, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdGreaterThan(String value) {
      addCriterion("complaint_object_id >", value, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdGreaterThanOrEqualTo(String value) {
      addCriterion("complaint_object_id >=", value, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdLessThan(String value) {
      addCriterion("complaint_object_id <", value, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdLessThanOrEqualTo(String value) {
      addCriterion("complaint_object_id <=", value, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdLike(String value) {
      addCriterion("complaint_object_id like", value, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdNotLike(String value) {
      addCriterion("complaint_object_id not like", value, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdIn(List<String> values) {
      addCriterion("complaint_object_id in", values, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdNotIn(List<String> values) {
      addCriterion("complaint_object_id not in", values, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdBetween(String value1, String value2) {
      addCriterion("complaint_object_id between", value1, value2, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectIdNotBetween(String value1, String value2) {
      addCriterion("complaint_object_id not between", value1, value2, "complaintObjectId");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeIsNull() {
      addCriterion("complainant_object_type is null");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeIsNotNull() {
      addCriterion("complainant_object_type is not null");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeEqualTo(Integer value) {
      addCriterion("complainant_object_type =", value, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeNotEqualTo(Integer value) {
      addCriterion("complainant_object_type <>", value, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeGreaterThan(Integer value) {
      addCriterion("complainant_object_type >", value, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("complainant_object_type >=", value, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeLessThan(Integer value) {
      addCriterion("complainant_object_type <", value, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeLessThanOrEqualTo(Integer value) {
      addCriterion("complainant_object_type <=", value, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeIn(List<Integer> values) {
      addCriterion("complainant_object_type in", values, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeNotIn(List<Integer> values) {
      addCriterion("complainant_object_type not in", values, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeBetween(Integer value1, Integer value2) {
      addCriterion("complainant_object_type between", value1, value2, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplainantObjectTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("complainant_object_type not between", value1, value2, "complainantObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeIsNull() {
      addCriterion("complaint_type is null");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeIsNotNull() {
      addCriterion("complaint_type is not null");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeEqualTo(Integer value) {
      addCriterion("complaint_type =", value, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeNotEqualTo(Integer value) {
      addCriterion("complaint_type <>", value, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeGreaterThan(Integer value) {
      addCriterion("complaint_type >", value, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("complaint_type >=", value, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeLessThan(Integer value) {
      addCriterion("complaint_type <", value, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeLessThanOrEqualTo(Integer value) {
      addCriterion("complaint_type <=", value, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeIn(List<Integer> values) {
      addCriterion("complaint_type in", values, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeNotIn(List<Integer> values) {
      addCriterion("complaint_type not in", values, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeBetween(Integer value1, Integer value2) {
      addCriterion("complaint_type between", value1, value2, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("complaint_type not between", value1, value2, "complaintType");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeIsNull() {
      addCriterion("complaint_time is null");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeIsNotNull() {
      addCriterion("complaint_time is not null");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeEqualTo(Date value) {
      addCriterion("complaint_time =", value, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeNotEqualTo(Date value) {
      addCriterion("complaint_time <>", value, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeGreaterThan(Date value) {
      addCriterion("complaint_time >", value, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("complaint_time >=", value, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeLessThan(Date value) {
      addCriterion("complaint_time <", value, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeLessThanOrEqualTo(Date value) {
      addCriterion("complaint_time <=", value, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeIn(List<Date> values) {
      addCriterion("complaint_time in", values, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeNotIn(List<Date> values) {
      addCriterion("complaint_time not in", values, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeBetween(Date value1, Date value2) {
      addCriterion("complaint_time between", value1, value2, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplaintTimeNotBetween(Date value1, Date value2) {
      addCriterion("complaint_time not between", value1, value2, "complaintTime");
      return (Criteria) this;
    }

    public Criteria andComplainantIdIsNull() {
      addCriterion("complainant_id is null");
      return (Criteria) this;
    }

    public Criteria andComplainantIdIsNotNull() {
      addCriterion("complainant_id is not null");
      return (Criteria) this;
    }

    public Criteria andComplainantIdEqualTo(String value) {
      addCriterion("complainant_id =", value, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdNotEqualTo(String value) {
      addCriterion("complainant_id <>", value, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdGreaterThan(String value) {
      addCriterion("complainant_id >", value, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdGreaterThanOrEqualTo(String value) {
      addCriterion("complainant_id >=", value, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdLessThan(String value) {
      addCriterion("complainant_id <", value, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdLessThanOrEqualTo(String value) {
      addCriterion("complainant_id <=", value, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdLike(String value) {
      addCriterion("complainant_id like", value, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdNotLike(String value) {
      addCriterion("complainant_id not like", value, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdIn(List<String> values) {
      addCriterion("complainant_id in", values, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdNotIn(List<String> values) {
      addCriterion("complainant_id not in", values, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdBetween(String value1, String value2) {
      addCriterion("complainant_id between", value1, value2, "complainantId");
      return (Criteria) this;
    }

    public Criteria andComplainantIdNotBetween(String value1, String value2) {
      addCriterion("complainant_id not between", value1, value2, "complainantId");
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

    public Criteria andComplaintContentIsNull() {
      addCriterion("complaint_content is null");
      return (Criteria) this;
    }

    public Criteria andComplaintContentIsNotNull() {
      addCriterion("complaint_content is not null");
      return (Criteria) this;
    }

    public Criteria andComplaintContentEqualTo(String value) {
      addCriterion("complaint_content =", value, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentNotEqualTo(String value) {
      addCriterion("complaint_content <>", value, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentGreaterThan(String value) {
      addCriterion("complaint_content >", value, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentGreaterThanOrEqualTo(String value) {
      addCriterion("complaint_content >=", value, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentLessThan(String value) {
      addCriterion("complaint_content <", value, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentLessThanOrEqualTo(String value) {
      addCriterion("complaint_content <=", value, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentLike(String value) {
      addCriterion("complaint_content like", value, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentNotLike(String value) {
      addCriterion("complaint_content not like", value, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentIn(List<String> values) {
      addCriterion("complaint_content in", values, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentNotIn(List<String> values) {
      addCriterion("complaint_content not in", values, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentBetween(String value1, String value2) {
      addCriterion("complaint_content between", value1, value2, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andComplaintContentNotBetween(String value1, String value2) {
      addCriterion("complaint_content not between", value1, value2, "complaintContent");
      return (Criteria) this;
    }

    public Criteria andDeputyNameIsNull() {
      addCriterion("deputy_name is null");
      return (Criteria) this;
    }

    public Criteria andDeputyNameIsNotNull() {
      addCriterion("deputy_name is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyNameEqualTo(String value) {
      addCriterion("deputy_name =", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameNotEqualTo(String value) {
      addCriterion("deputy_name <>", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameGreaterThan(String value) {
      addCriterion("deputy_name >", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_name >=", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameLessThan(String value) {
      addCriterion("deputy_name <", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameLessThanOrEqualTo(String value) {
      addCriterion("deputy_name <=", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameLike(String value) {
      addCriterion("deputy_name like", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameNotLike(String value) {
      addCriterion("deputy_name not like", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameIn(List<String> values) {
      addCriterion("deputy_name in", values, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameNotIn(List<String> values) {
      addCriterion("deputy_name not in", values, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameBetween(String value1, String value2) {
      addCriterion("deputy_name between", value1, value2, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameNotBetween(String value1, String value2) {
      addCriterion("deputy_name not between", value1, value2, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileIsNull() {
      addCriterion("deputy_mobile is null");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileIsNotNull() {
      addCriterion("deputy_mobile is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileEqualTo(String value) {
      addCriterion("deputy_mobile =", value, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileNotEqualTo(String value) {
      addCriterion("deputy_mobile <>", value, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileGreaterThan(String value) {
      addCriterion("deputy_mobile >", value, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_mobile >=", value, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileLessThan(String value) {
      addCriterion("deputy_mobile <", value, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileLessThanOrEqualTo(String value) {
      addCriterion("deputy_mobile <=", value, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileLike(String value) {
      addCriterion("deputy_mobile like", value, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileNotLike(String value) {
      addCriterion("deputy_mobile not like", value, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileIn(List<String> values) {
      addCriterion("deputy_mobile in", values, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileNotIn(List<String> values) {
      addCriterion("deputy_mobile not in", values, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileBetween(String value1, String value2) {
      addCriterion("deputy_mobile between", value1, value2, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andDeputyMobileNotBetween(String value1, String value2) {
      addCriterion("deputy_mobile not between", value1, value2, "deputyMobile");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardIsNull() {
      addCriterion("insured_person_card is null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardIsNotNull() {
      addCriterion("insured_person_card is not null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardEqualTo(String value) {
      addCriterion("insured_person_card =", value, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardNotEqualTo(String value) {
      addCriterion("insured_person_card <>", value, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardGreaterThan(String value) {
      addCriterion("insured_person_card >", value, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardGreaterThanOrEqualTo(String value) {
      addCriterion("insured_person_card >=", value, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardLessThan(String value) {
      addCriterion("insured_person_card <", value, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardLessThanOrEqualTo(String value) {
      addCriterion("insured_person_card <=", value, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardLike(String value) {
      addCriterion("insured_person_card like", value, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardNotLike(String value) {
      addCriterion("insured_person_card not like", value, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardIn(List<String> values) {
      addCriterion("insured_person_card in", values, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardNotIn(List<String> values) {
      addCriterion("insured_person_card not in", values, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardBetween(String value1, String value2) {
      addCriterion("insured_person_card between", value1, value2, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCardNotBetween(String value1, String value2) {
      addCriterion("insured_person_card not between", value1, value2, "insuredPersonCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardIsNull() {
      addCriterion("complainant_card is null");
      return (Criteria) this;
    }

    public Criteria andComplainantCardIsNotNull() {
      addCriterion("complainant_card is not null");
      return (Criteria) this;
    }

    public Criteria andComplainantCardEqualTo(String value) {
      addCriterion("complainant_card =", value, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardNotEqualTo(String value) {
      addCriterion("complainant_card <>", value, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardGreaterThan(String value) {
      addCriterion("complainant_card >", value, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardGreaterThanOrEqualTo(String value) {
      addCriterion("complainant_card >=", value, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardLessThan(String value) {
      addCriterion("complainant_card <", value, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardLessThanOrEqualTo(String value) {
      addCriterion("complainant_card <=", value, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardLike(String value) {
      addCriterion("complainant_card like", value, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardNotLike(String value) {
      addCriterion("complainant_card not like", value, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardIn(List<String> values) {
      addCriterion("complainant_card in", values, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardNotIn(List<String> values) {
      addCriterion("complainant_card not in", values, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardBetween(String value1, String value2) {
      addCriterion("complainant_card between", value1, value2, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplainantCardNotBetween(String value1, String value2) {
      addCriterion("complainant_card not between", value1, value2, "complainantCard");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeIsNull() {
      addCriterion("complaint_object_type is null");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeIsNotNull() {
      addCriterion("complaint_object_type is not null");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeEqualTo(Integer value) {
      addCriterion("complaint_object_type =", value, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeNotEqualTo(Integer value) {
      addCriterion("complaint_object_type <>", value, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeGreaterThan(Integer value) {
      addCriterion("complaint_object_type >", value, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("complaint_object_type >=", value, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeLessThan(Integer value) {
      addCriterion("complaint_object_type <", value, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeLessThanOrEqualTo(Integer value) {
      addCriterion("complaint_object_type <=", value, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeIn(List<Integer> values) {
      addCriterion("complaint_object_type in", values, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeNotIn(List<Integer> values) {
      addCriterion("complaint_object_type not in", values, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeBetween(Integer value1, Integer value2) {
      addCriterion("complaint_object_type between", value1, value2, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andComplaintObjectTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("complaint_object_type not between", value1, value2, "complaintObjectType");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdIsNull() {
      addCriterion("patrol_staff_id is null");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdIsNotNull() {
      addCriterion("patrol_staff_id is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdEqualTo(String value) {
      addCriterion("patrol_staff_id =", value, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdNotEqualTo(String value) {
      addCriterion("patrol_staff_id <>", value, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdGreaterThan(String value) {
      addCriterion("patrol_staff_id >", value, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_staff_id >=", value, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdLessThan(String value) {
      addCriterion("patrol_staff_id <", value, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdLessThanOrEqualTo(String value) {
      addCriterion("patrol_staff_id <=", value, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdLike(String value) {
      addCriterion("patrol_staff_id like", value, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdNotLike(String value) {
      addCriterion("patrol_staff_id not like", value, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdIn(List<String> values) {
      addCriterion("patrol_staff_id in", values, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdNotIn(List<String> values) {
      addCriterion("patrol_staff_id not in", values, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdBetween(String value1, String value2) {
      addCriterion("patrol_staff_id between", value1, value2, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffIdNotBetween(String value1, String value2) {
      addCriterion("patrol_staff_id not between", value1, value2, "patrolStaffId");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameIsNull() {
      addCriterion("patrol_staff_name is null");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameIsNotNull() {
      addCriterion("patrol_staff_name is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameEqualTo(String value) {
      addCriterion("patrol_staff_name =", value, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameNotEqualTo(String value) {
      addCriterion("patrol_staff_name <>", value, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameGreaterThan(String value) {
      addCriterion("patrol_staff_name >", value, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_staff_name >=", value, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameLessThan(String value) {
      addCriterion("patrol_staff_name <", value, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameLessThanOrEqualTo(String value) {
      addCriterion("patrol_staff_name <=", value, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameLike(String value) {
      addCriterion("patrol_staff_name like", value, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameNotLike(String value) {
      addCriterion("patrol_staff_name not like", value, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameIn(List<String> values) {
      addCriterion("patrol_staff_name in", values, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameNotIn(List<String> values) {
      addCriterion("patrol_staff_name not in", values, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameBetween(String value1, String value2) {
      addCriterion("patrol_staff_name between", value1, value2, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andPatrolStaffNameNotBetween(String value1, String value2) {
      addCriterion("patrol_staff_name not between", value1, value2, "patrolStaffName");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateIsNull() {
      addCriterion("execute_message_state is null");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateIsNotNull() {
      addCriterion("execute_message_state is not null");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateEqualTo(Integer value) {
      addCriterion("execute_message_state =", value, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateNotEqualTo(Integer value) {
      addCriterion("execute_message_state <>", value, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateGreaterThan(Integer value) {
      addCriterion("execute_message_state >", value, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateGreaterThanOrEqualTo(Integer value) {
      addCriterion("execute_message_state >=", value, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateLessThan(Integer value) {
      addCriterion("execute_message_state <", value, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateLessThanOrEqualTo(Integer value) {
      addCriterion("execute_message_state <=", value, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateIn(List<Integer> values) {
      addCriterion("execute_message_state in", values, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateNotIn(List<Integer> values) {
      addCriterion("execute_message_state not in", values, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateBetween(Integer value1, Integer value2) {
      addCriterion("execute_message_state between", value1, value2, "executeMessageState");
      return (Criteria) this;
    }

    public Criteria andExecuteMessageStateNotBetween(Integer value1, Integer value2) {
      addCriterion("execute_message_state not between", value1, value2, "executeMessageState");
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
