package com.taikang.dic.ltci.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonSetPerDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public MonSetPerDOExample() {
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

    public Criteria andMonSetCodeIsNull() {
      addCriterion("mon_set_code is null");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeIsNotNull() {
      addCriterion("mon_set_code is not null");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeEqualTo(String value) {
      addCriterion("mon_set_code =", value, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeNotEqualTo(String value) {
      addCriterion("mon_set_code <>", value, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeGreaterThan(String value) {
      addCriterion("mon_set_code >", value, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeGreaterThanOrEqualTo(String value) {
      addCriterion("mon_set_code >=", value, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeLessThan(String value) {
      addCriterion("mon_set_code <", value, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeLessThanOrEqualTo(String value) {
      addCriterion("mon_set_code <=", value, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeLike(String value) {
      addCriterion("mon_set_code like", value, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeNotLike(String value) {
      addCriterion("mon_set_code not like", value, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeIn(List<String> values) {
      addCriterion("mon_set_code in", values, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeNotIn(List<String> values) {
      addCriterion("mon_set_code not in", values, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeBetween(String value1, String value2) {
      addCriterion("mon_set_code between", value1, value2, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andMonSetCodeNotBetween(String value1, String value2) {
      addCriterion("mon_set_code not between", value1, value2, "monSetCode");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidIsNull() {
      addCriterion("in_recorduuid is null");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidIsNotNull() {
      addCriterion("in_recorduuid is not null");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidEqualTo(String value) {
      addCriterion("in_recorduuid =", value, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidNotEqualTo(String value) {
      addCriterion("in_recorduuid <>", value, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidGreaterThan(String value) {
      addCriterion("in_recorduuid >", value, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidGreaterThanOrEqualTo(String value) {
      addCriterion("in_recorduuid >=", value, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidLessThan(String value) {
      addCriterion("in_recorduuid <", value, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidLessThanOrEqualTo(String value) {
      addCriterion("in_recorduuid <=", value, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidLike(String value) {
      addCriterion("in_recorduuid like", value, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidNotLike(String value) {
      addCriterion("in_recorduuid not like", value, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidIn(List<String> values) {
      addCriterion("in_recorduuid in", values, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidNotIn(List<String> values) {
      addCriterion("in_recorduuid not in", values, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidBetween(String value1, String value2) {
      addCriterion("in_recorduuid between", value1, value2, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andInRecorduuidNotBetween(String value1, String value2) {
      addCriterion("in_recorduuid not between", value1, value2, "inRecorduuid");
      return (Criteria) this;
    }

    public Criteria andReceiptNumIsNull() {
      addCriterion("receipt_num is null");
      return (Criteria) this;
    }

    public Criteria andReceiptNumIsNotNull() {
      addCriterion("receipt_num is not null");
      return (Criteria) this;
    }

    public Criteria andReceiptNumEqualTo(String value) {
      addCriterion("receipt_num =", value, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumNotEqualTo(String value) {
      addCriterion("receipt_num <>", value, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumGreaterThan(String value) {
      addCriterion("receipt_num >", value, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumGreaterThanOrEqualTo(String value) {
      addCriterion("receipt_num >=", value, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumLessThan(String value) {
      addCriterion("receipt_num <", value, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumLessThanOrEqualTo(String value) {
      addCriterion("receipt_num <=", value, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumLike(String value) {
      addCriterion("receipt_num like", value, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumNotLike(String value) {
      addCriterion("receipt_num not like", value, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumIn(List<String> values) {
      addCriterion("receipt_num in", values, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumNotIn(List<String> values) {
      addCriterion("receipt_num not in", values, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumBetween(String value1, String value2) {
      addCriterion("receipt_num between", value1, value2, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andReceiptNumNotBetween(String value1, String value2) {
      addCriterion("receipt_num not between", value1, value2, "receiptNum");
      return (Criteria) this;
    }

    public Criteria andSetDateIsNull() {
      addCriterion("set_date is null");
      return (Criteria) this;
    }

    public Criteria andSetDateIsNotNull() {
      addCriterion("set_date is not null");
      return (Criteria) this;
    }

    public Criteria andSetDateEqualTo(Date value) {
      addCriterion("set_date =", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateNotEqualTo(Date value) {
      addCriterion("set_date <>", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateGreaterThan(Date value) {
      addCriterion("set_date >", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateGreaterThanOrEqualTo(Date value) {
      addCriterion("set_date >=", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateLessThan(Date value) {
      addCriterion("set_date <", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateLessThanOrEqualTo(Date value) {
      addCriterion("set_date <=", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateIn(List<Date> values) {
      addCriterion("set_date in", values, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateNotIn(List<Date> values) {
      addCriterion("set_date not in", values, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateBetween(Date value1, Date value2) {
      addCriterion("set_date between", value1, value2, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateNotBetween(Date value1, Date value2) {
      addCriterion("set_date not between", value1, value2, "setDate");
      return (Criteria) this;
    }

    public Criteria andReimbTypeIsNull() {
      addCriterion("reimb_type is null");
      return (Criteria) this;
    }

    public Criteria andReimbTypeIsNotNull() {
      addCriterion("reimb_type is not null");
      return (Criteria) this;
    }

    public Criteria andReimbTypeEqualTo(String value) {
      addCriterion("reimb_type =", value, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeNotEqualTo(String value) {
      addCriterion("reimb_type <>", value, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeGreaterThan(String value) {
      addCriterion("reimb_type >", value, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeGreaterThanOrEqualTo(String value) {
      addCriterion("reimb_type >=", value, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeLessThan(String value) {
      addCriterion("reimb_type <", value, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeLessThanOrEqualTo(String value) {
      addCriterion("reimb_type <=", value, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeLike(String value) {
      addCriterion("reimb_type like", value, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeNotLike(String value) {
      addCriterion("reimb_type not like", value, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeIn(List<String> values) {
      addCriterion("reimb_type in", values, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeNotIn(List<String> values) {
      addCriterion("reimb_type not in", values, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeBetween(String value1, String value2) {
      addCriterion("reimb_type between", value1, value2, "reimbType");
      return (Criteria) this;
    }

    public Criteria andReimbTypeNotBetween(String value1, String value2) {
      addCriterion("reimb_type not between", value1, value2, "reimbType");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseIsNull() {
      addCriterion("is_account_use is null");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseIsNotNull() {
      addCriterion("is_account_use is not null");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseEqualTo(String value) {
      addCriterion("is_account_use =", value, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseNotEqualTo(String value) {
      addCriterion("is_account_use <>", value, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseGreaterThan(String value) {
      addCriterion("is_account_use >", value, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseGreaterThanOrEqualTo(String value) {
      addCriterion("is_account_use >=", value, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseLessThan(String value) {
      addCriterion("is_account_use <", value, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseLessThanOrEqualTo(String value) {
      addCriterion("is_account_use <=", value, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseLike(String value) {
      addCriterion("is_account_use like", value, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseNotLike(String value) {
      addCriterion("is_account_use not like", value, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseIn(List<String> values) {
      addCriterion("is_account_use in", values, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseNotIn(List<String> values) {
      addCriterion("is_account_use not in", values, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseBetween(String value1, String value2) {
      addCriterion("is_account_use between", value1, value2, "isAccountUse");
      return (Criteria) this;
    }

    public Criteria andIsAccountUseNotBetween(String value1, String value2) {
      addCriterion("is_account_use not between", value1, value2, "isAccountUse");
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

    public Criteria andSocSecNumIsNull() {
      addCriterion("soc_sec_num is null");
      return (Criteria) this;
    }

    public Criteria andSocSecNumIsNotNull() {
      addCriterion("soc_sec_num is not null");
      return (Criteria) this;
    }

    public Criteria andSocSecNumEqualTo(String value) {
      addCriterion("soc_sec_num =", value, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumNotEqualTo(String value) {
      addCriterion("soc_sec_num <>", value, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumGreaterThan(String value) {
      addCriterion("soc_sec_num >", value, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumGreaterThanOrEqualTo(String value) {
      addCriterion("soc_sec_num >=", value, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumLessThan(String value) {
      addCriterion("soc_sec_num <", value, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumLessThanOrEqualTo(String value) {
      addCriterion("soc_sec_num <=", value, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumLike(String value) {
      addCriterion("soc_sec_num like", value, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumNotLike(String value) {
      addCriterion("soc_sec_num not like", value, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumIn(List<String> values) {
      addCriterion("soc_sec_num in", values, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumNotIn(List<String> values) {
      addCriterion("soc_sec_num not in", values, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumBetween(String value1, String value2) {
      addCriterion("soc_sec_num between", value1, value2, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andSocSecNumNotBetween(String value1, String value2) {
      addCriterion("soc_sec_num not between", value1, value2, "socSecNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumIsNull() {
      addCriterion("be_care_person_card_num is null");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumIsNotNull() {
      addCriterion("be_care_person_card_num is not null");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumEqualTo(String value) {
      addCriterion("be_care_person_card_num =", value, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumNotEqualTo(String value) {
      addCriterion("be_care_person_card_num <>", value, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumGreaterThan(String value) {
      addCriterion("be_care_person_card_num >", value, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumGreaterThanOrEqualTo(String value) {
      addCriterion("be_care_person_card_num >=", value, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumLessThan(String value) {
      addCriterion("be_care_person_card_num <", value, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumLessThanOrEqualTo(String value) {
      addCriterion("be_care_person_card_num <=", value, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumLike(String value) {
      addCriterion("be_care_person_card_num like", value, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumNotLike(String value) {
      addCriterion("be_care_person_card_num not like", value, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumIn(List<String> values) {
      addCriterion("be_care_person_card_num in", values, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumNotIn(List<String> values) {
      addCriterion("be_care_person_card_num not in", values, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumBetween(String value1, String value2) {
      addCriterion("be_care_person_card_num between", value1, value2, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andBeCarePersonCardNumNotBetween(String value1, String value2) {
      addCriterion("be_care_person_card_num not between", value1, value2, "beCarePersonCardNum");
      return (Criteria) this;
    }

    public Criteria andCardTypeIsNull() {
      addCriterion("card_type is null");
      return (Criteria) this;
    }

    public Criteria andCardTypeIsNotNull() {
      addCriterion("card_type is not null");
      return (Criteria) this;
    }

    public Criteria andCardTypeEqualTo(Integer value) {
      addCriterion("card_type =", value, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeNotEqualTo(Integer value) {
      addCriterion("card_type <>", value, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeGreaterThan(Integer value) {
      addCriterion("card_type >", value, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("card_type >=", value, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeLessThan(Integer value) {
      addCriterion("card_type <", value, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeLessThanOrEqualTo(Integer value) {
      addCriterion("card_type <=", value, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeIn(List<Integer> values) {
      addCriterion("card_type in", values, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeNotIn(List<Integer> values) {
      addCriterion("card_type not in", values, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeBetween(Integer value1, Integer value2) {
      addCriterion("card_type between", value1, value2, "cardType");
      return (Criteria) this;
    }

    public Criteria andCardTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("card_type not between", value1, value2, "cardType");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameIsNull() {
      addCriterion("nurse_obj_name is null");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameIsNotNull() {
      addCriterion("nurse_obj_name is not null");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameEqualTo(String value) {
      addCriterion("nurse_obj_name =", value, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameNotEqualTo(String value) {
      addCriterion("nurse_obj_name <>", value, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameGreaterThan(String value) {
      addCriterion("nurse_obj_name >", value, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameGreaterThanOrEqualTo(String value) {
      addCriterion("nurse_obj_name >=", value, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameLessThan(String value) {
      addCriterion("nurse_obj_name <", value, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameLessThanOrEqualTo(String value) {
      addCriterion("nurse_obj_name <=", value, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameLike(String value) {
      addCriterion("nurse_obj_name like", value, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameNotLike(String value) {
      addCriterion("nurse_obj_name not like", value, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameIn(List<String> values) {
      addCriterion("nurse_obj_name in", values, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameNotIn(List<String> values) {
      addCriterion("nurse_obj_name not in", values, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameBetween(String value1, String value2) {
      addCriterion("nurse_obj_name between", value1, value2, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjNameNotBetween(String value1, String value2) {
      addCriterion("nurse_obj_name not between", value1, value2, "nurseObjName");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexIsNull() {
      addCriterion("nurse_obj_sex is null");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexIsNotNull() {
      addCriterion("nurse_obj_sex is not null");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexEqualTo(Integer value) {
      addCriterion("nurse_obj_sex =", value, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexNotEqualTo(Integer value) {
      addCriterion("nurse_obj_sex <>", value, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexGreaterThan(Integer value) {
      addCriterion("nurse_obj_sex >", value, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexGreaterThanOrEqualTo(Integer value) {
      addCriterion("nurse_obj_sex >=", value, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexLessThan(Integer value) {
      addCriterion("nurse_obj_sex <", value, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexLessThanOrEqualTo(Integer value) {
      addCriterion("nurse_obj_sex <=", value, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexIn(List<Integer> values) {
      addCriterion("nurse_obj_sex in", values, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexNotIn(List<Integer> values) {
      addCriterion("nurse_obj_sex not in", values, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexBetween(Integer value1, Integer value2) {
      addCriterion("nurse_obj_sex between", value1, value2, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseObjSexNotBetween(Integer value1, Integer value2) {
      addCriterion("nurse_obj_sex not between", value1, value2, "nurseObjSex");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeIsNull() {
      addCriterion("nurse_starttime is null");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeIsNotNull() {
      addCriterion("nurse_starttime is not null");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeEqualTo(Date value) {
      addCriterion("nurse_starttime =", value, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeNotEqualTo(Date value) {
      addCriterion("nurse_starttime <>", value, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeGreaterThan(Date value) {
      addCriterion("nurse_starttime >", value, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeGreaterThanOrEqualTo(Date value) {
      addCriterion("nurse_starttime >=", value, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeLessThan(Date value) {
      addCriterion("nurse_starttime <", value, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeLessThanOrEqualTo(Date value) {
      addCriterion("nurse_starttime <=", value, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeIn(List<Date> values) {
      addCriterion("nurse_starttime in", values, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeNotIn(List<Date> values) {
      addCriterion("nurse_starttime not in", values, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeBetween(Date value1, Date value2) {
      addCriterion("nurse_starttime between", value1, value2, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseStarttimeNotBetween(Date value1, Date value2) {
      addCriterion("nurse_starttime not between", value1, value2, "nurseStarttime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeIsNull() {
      addCriterion("nurse_endtime is null");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeIsNotNull() {
      addCriterion("nurse_endtime is not null");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeEqualTo(Date value) {
      addCriterion("nurse_endtime =", value, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeNotEqualTo(Date value) {
      addCriterion("nurse_endtime <>", value, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeGreaterThan(Date value) {
      addCriterion("nurse_endtime >", value, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeGreaterThanOrEqualTo(Date value) {
      addCriterion("nurse_endtime >=", value, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeLessThan(Date value) {
      addCriterion("nurse_endtime <", value, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeLessThanOrEqualTo(Date value) {
      addCriterion("nurse_endtime <=", value, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeIn(List<Date> values) {
      addCriterion("nurse_endtime in", values, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeNotIn(List<Date> values) {
      addCriterion("nurse_endtime not in", values, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeBetween(Date value1, Date value2) {
      addCriterion("nurse_endtime between", value1, value2, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseEndtimeNotBetween(Date value1, Date value2) {
      addCriterion("nurse_endtime not between", value1, value2, "nurseEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountIsNull() {
      addCriterion("nurse_total_amount is null");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountIsNotNull() {
      addCriterion("nurse_total_amount is not null");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountEqualTo(BigDecimal value) {
      addCriterion("nurse_total_amount =", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountNotEqualTo(BigDecimal value) {
      addCriterion("nurse_total_amount <>", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountGreaterThan(BigDecimal value) {
      addCriterion("nurse_total_amount >", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("nurse_total_amount >=", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountLessThan(BigDecimal value) {
      addCriterion("nurse_total_amount <", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("nurse_total_amount <=", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountIn(List<BigDecimal> values) {
      addCriterion("nurse_total_amount in", values, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountNotIn(List<BigDecimal> values) {
      addCriterion("nurse_total_amount not in", values, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("nurse_total_amount between", value1, value2, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("nurse_total_amount not between", value1, value2, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andSiPayIsNull() {
      addCriterion("si_pay is null");
      return (Criteria) this;
    }

    public Criteria andSiPayIsNotNull() {
      addCriterion("si_pay is not null");
      return (Criteria) this;
    }

    public Criteria andSiPayEqualTo(BigDecimal value) {
      addCriterion("si_pay =", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayNotEqualTo(BigDecimal value) {
      addCriterion("si_pay <>", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayGreaterThan(BigDecimal value) {
      addCriterion("si_pay >", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("si_pay >=", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayLessThan(BigDecimal value) {
      addCriterion("si_pay <", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayLessThanOrEqualTo(BigDecimal value) {
      addCriterion("si_pay <=", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayIn(List<BigDecimal> values) {
      addCriterion("si_pay in", values, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayNotIn(List<BigDecimal> values) {
      addCriterion("si_pay not in", values, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("si_pay between", value1, value2, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("si_pay not between", value1, value2, "siPay");
      return (Criteria) this;
    }

    public Criteria andPaySelfIsNull() {
      addCriterion("pay_self is null");
      return (Criteria) this;
    }

    public Criteria andPaySelfIsNotNull() {
      addCriterion("pay_self is not null");
      return (Criteria) this;
    }

    public Criteria andPaySelfEqualTo(BigDecimal value) {
      addCriterion("pay_self =", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfNotEqualTo(BigDecimal value) {
      addCriterion("pay_self <>", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfGreaterThan(BigDecimal value) {
      addCriterion("pay_self >", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("pay_self >=", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfLessThan(BigDecimal value) {
      addCriterion("pay_self <", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfLessThanOrEqualTo(BigDecimal value) {
      addCriterion("pay_self <=", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfIn(List<BigDecimal> values) {
      addCriterion("pay_self in", values, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfNotIn(List<BigDecimal> values) {
      addCriterion("pay_self not in", values, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("pay_self between", value1, value2, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("pay_self not between", value1, value2, "paySelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfIsNull() {
      addCriterion("expense_self is null");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfIsNotNull() {
      addCriterion("expense_self is not null");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfEqualTo(BigDecimal value) {
      addCriterion("expense_self =", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfNotEqualTo(BigDecimal value) {
      addCriterion("expense_self <>", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfGreaterThan(BigDecimal value) {
      addCriterion("expense_self >", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("expense_self >=", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfLessThan(BigDecimal value) {
      addCriterion("expense_self <", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfLessThanOrEqualTo(BigDecimal value) {
      addCriterion("expense_self <=", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfIn(List<BigDecimal> values) {
      addCriterion("expense_self in", values, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfNotIn(List<BigDecimal> values) {
      addCriterion("expense_self not in", values, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("expense_self between", value1, value2, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("expense_self not between", value1, value2, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andAccountPayIsNull() {
      addCriterion("account_pay is null");
      return (Criteria) this;
    }

    public Criteria andAccountPayIsNotNull() {
      addCriterion("account_pay is not null");
      return (Criteria) this;
    }

    public Criteria andAccountPayEqualTo(BigDecimal value) {
      addCriterion("account_pay =", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayNotEqualTo(BigDecimal value) {
      addCriterion("account_pay <>", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayGreaterThan(BigDecimal value) {
      addCriterion("account_pay >", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("account_pay >=", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayLessThan(BigDecimal value) {
      addCriterion("account_pay <", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayLessThanOrEqualTo(BigDecimal value) {
      addCriterion("account_pay <=", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayIn(List<BigDecimal> values) {
      addCriterion("account_pay in", values, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayNotIn(List<BigDecimal> values) {
      addCriterion("account_pay not in", values, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account_pay between", value1, value2, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account_pay not between", value1, value2, "accountPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayIsNull() {
      addCriterion("bank_card_pay is null");
      return (Criteria) this;
    }

    public Criteria andBankCardPayIsNotNull() {
      addCriterion("bank_card_pay is not null");
      return (Criteria) this;
    }

    public Criteria andBankCardPayEqualTo(BigDecimal value) {
      addCriterion("bank_card_pay =", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayNotEqualTo(BigDecimal value) {
      addCriterion("bank_card_pay <>", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayGreaterThan(BigDecimal value) {
      addCriterion("bank_card_pay >", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("bank_card_pay >=", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayLessThan(BigDecimal value) {
      addCriterion("bank_card_pay <", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayLessThanOrEqualTo(BigDecimal value) {
      addCriterion("bank_card_pay <=", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayIn(List<BigDecimal> values) {
      addCriterion("bank_card_pay in", values, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayNotIn(List<BigDecimal> values) {
      addCriterion("bank_card_pay not in", values, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bank_card_pay between", value1, value2, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bank_card_pay not between", value1, value2, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andUnrFeeIsNull() {
      addCriterion("unr_fee is null");
      return (Criteria) this;
    }

    public Criteria andUnrFeeIsNotNull() {
      addCriterion("unr_fee is not null");
      return (Criteria) this;
    }

    public Criteria andUnrFeeEqualTo(BigDecimal value) {
      addCriterion("unr_fee =", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeNotEqualTo(BigDecimal value) {
      addCriterion("unr_fee <>", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeGreaterThan(BigDecimal value) {
      addCriterion("unr_fee >", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("unr_fee >=", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeLessThan(BigDecimal value) {
      addCriterion("unr_fee <", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("unr_fee <=", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeIn(List<BigDecimal> values) {
      addCriterion("unr_fee in", values, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeNotIn(List<BigDecimal> values) {
      addCriterion("unr_fee not in", values, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("unr_fee between", value1, value2, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("unr_fee not between", value1, value2, "unrFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeIsNull() {
      addCriterion("over_limit_fee is null");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeIsNotNull() {
      addCriterion("over_limit_fee is not null");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeEqualTo(BigDecimal value) {
      addCriterion("over_limit_fee =", value, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeNotEqualTo(BigDecimal value) {
      addCriterion("over_limit_fee <>", value, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeGreaterThan(BigDecimal value) {
      addCriterion("over_limit_fee >", value, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("over_limit_fee >=", value, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeLessThan(BigDecimal value) {
      addCriterion("over_limit_fee <", value, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("over_limit_fee <=", value, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeIn(List<BigDecimal> values) {
      addCriterion("over_limit_fee in", values, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeNotIn(List<BigDecimal> values) {
      addCriterion("over_limit_fee not in", values, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("over_limit_fee between", value1, value2, "overLimitFee");
      return (Criteria) this;
    }

    public Criteria andOverLimitFeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("over_limit_fee not between", value1, value2, "overLimitFee");
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

    public Criteria andVersionIsNull() {
      addCriterion("version is null");
      return (Criteria) this;
    }

    public Criteria andVersionIsNotNull() {
      addCriterion("version is not null");
      return (Criteria) this;
    }

    public Criteria andVersionEqualTo(Long value) {
      addCriterion("version =", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionNotEqualTo(Long value) {
      addCriterion("version <>", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionGreaterThan(Long value) {
      addCriterion("version >", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionGreaterThanOrEqualTo(Long value) {
      addCriterion("version >=", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionLessThan(Long value) {
      addCriterion("version <", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionLessThanOrEqualTo(Long value) {
      addCriterion("version <=", value, "version");
      return (Criteria) this;
    }

    public Criteria andVersionIn(List<Long> values) {
      addCriterion("version in", values, "version");
      return (Criteria) this;
    }

    public Criteria andVersionNotIn(List<Long> values) {
      addCriterion("version not in", values, "version");
      return (Criteria) this;
    }

    public Criteria andVersionBetween(Long value1, Long value2) {
      addCriterion("version between", value1, value2, "version");
      return (Criteria) this;
    }

    public Criteria andVersionNotBetween(Long value1, Long value2) {
      addCriterion("version not between", value1, value2, "version");
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
