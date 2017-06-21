package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffHistoryDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public StaffHistoryDOExample() {
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

    public Criteria andSerialNoIsNull() {
      addCriterion("serial_no is null");
      return (Criteria) this;
    }

    public Criteria andSerialNoIsNotNull() {
      addCriterion("serial_no is not null");
      return (Criteria) this;
    }

    public Criteria andSerialNoEqualTo(String value) {
      addCriterion("serial_no =", value, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoNotEqualTo(String value) {
      addCriterion("serial_no <>", value, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoGreaterThan(String value) {
      addCriterion("serial_no >", value, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoGreaterThanOrEqualTo(String value) {
      addCriterion("serial_no >=", value, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoLessThan(String value) {
      addCriterion("serial_no <", value, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoLessThanOrEqualTo(String value) {
      addCriterion("serial_no <=", value, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoLike(String value) {
      addCriterion("serial_no like", value, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoNotLike(String value) {
      addCriterion("serial_no not like", value, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoIn(List<String> values) {
      addCriterion("serial_no in", values, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoNotIn(List<String> values) {
      addCriterion("serial_no not in", values, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoBetween(String value1, String value2) {
      addCriterion("serial_no between", value1, value2, "serialNo");
      return (Criteria) this;
    }

    public Criteria andSerialNoNotBetween(String value1, String value2) {
      addCriterion("serial_no not between", value1, value2, "serialNo");
      return (Criteria) this;
    }

    public Criteria andActionTypeIsNull() {
      addCriterion("action_type is null");
      return (Criteria) this;
    }

    public Criteria andActionTypeIsNotNull() {
      addCriterion("action_type is not null");
      return (Criteria) this;
    }

    public Criteria andActionTypeEqualTo(String value) {
      addCriterion("action_type =", value, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeNotEqualTo(String value) {
      addCriterion("action_type <>", value, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeGreaterThan(String value) {
      addCriterion("action_type >", value, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeGreaterThanOrEqualTo(String value) {
      addCriterion("action_type >=", value, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeLessThan(String value) {
      addCriterion("action_type <", value, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeLessThanOrEqualTo(String value) {
      addCriterion("action_type <=", value, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeLike(String value) {
      addCriterion("action_type like", value, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeNotLike(String value) {
      addCriterion("action_type not like", value, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeIn(List<String> values) {
      addCriterion("action_type in", values, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeNotIn(List<String> values) {
      addCriterion("action_type not in", values, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeBetween(String value1, String value2) {
      addCriterion("action_type between", value1, value2, "actionType");
      return (Criteria) this;
    }

    public Criteria andActionTypeNotBetween(String value1, String value2) {
      addCriterion("action_type not between", value1, value2, "actionType");
      return (Criteria) this;
    }

    public Criteria andEmpCodeIsNull() {
      addCriterion("emp_code is null");
      return (Criteria) this;
    }

    public Criteria andEmpCodeIsNotNull() {
      addCriterion("emp_code is not null");
      return (Criteria) this;
    }

    public Criteria andEmpCodeEqualTo(String value) {
      addCriterion("emp_code =", value, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeNotEqualTo(String value) {
      addCriterion("emp_code <>", value, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeGreaterThan(String value) {
      addCriterion("emp_code >", value, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeGreaterThanOrEqualTo(String value) {
      addCriterion("emp_code >=", value, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeLessThan(String value) {
      addCriterion("emp_code <", value, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeLessThanOrEqualTo(String value) {
      addCriterion("emp_code <=", value, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeLike(String value) {
      addCriterion("emp_code like", value, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeNotLike(String value) {
      addCriterion("emp_code not like", value, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeIn(List<String> values) {
      addCriterion("emp_code in", values, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeNotIn(List<String> values) {
      addCriterion("emp_code not in", values, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeBetween(String value1, String value2) {
      addCriterion("emp_code between", value1, value2, "empCode");
      return (Criteria) this;
    }

    public Criteria andEmpCodeNotBetween(String value1, String value2) {
      addCriterion("emp_code not between", value1, value2, "empCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeIsNull() {
      addCriterion("staff_code is null");
      return (Criteria) this;
    }

    public Criteria andStaffCodeIsNotNull() {
      addCriterion("staff_code is not null");
      return (Criteria) this;
    }

    public Criteria andStaffCodeEqualTo(String value) {
      addCriterion("staff_code =", value, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeNotEqualTo(String value) {
      addCriterion("staff_code <>", value, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeGreaterThan(String value) {
      addCriterion("staff_code >", value, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeGreaterThanOrEqualTo(String value) {
      addCriterion("staff_code >=", value, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeLessThan(String value) {
      addCriterion("staff_code <", value, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeLessThanOrEqualTo(String value) {
      addCriterion("staff_code <=", value, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeLike(String value) {
      addCriterion("staff_code like", value, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeNotLike(String value) {
      addCriterion("staff_code not like", value, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeIn(List<String> values) {
      addCriterion("staff_code in", values, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeNotIn(List<String> values) {
      addCriterion("staff_code not in", values, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeBetween(String value1, String value2) {
      addCriterion("staff_code between", value1, value2, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffCodeNotBetween(String value1, String value2) {
      addCriterion("staff_code not between", value1, value2, "staffCode");
      return (Criteria) this;
    }

    public Criteria andStaffNameIsNull() {
      addCriterion("staff_name is null");
      return (Criteria) this;
    }

    public Criteria andStaffNameIsNotNull() {
      addCriterion("staff_name is not null");
      return (Criteria) this;
    }

    public Criteria andStaffNameEqualTo(String value) {
      addCriterion("staff_name =", value, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameNotEqualTo(String value) {
      addCriterion("staff_name <>", value, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameGreaterThan(String value) {
      addCriterion("staff_name >", value, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
      addCriterion("staff_name >=", value, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameLessThan(String value) {
      addCriterion("staff_name <", value, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameLessThanOrEqualTo(String value) {
      addCriterion("staff_name <=", value, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameLike(String value) {
      addCriterion("staff_name like", value, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameNotLike(String value) {
      addCriterion("staff_name not like", value, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameIn(List<String> values) {
      addCriterion("staff_name in", values, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameNotIn(List<String> values) {
      addCriterion("staff_name not in", values, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameBetween(String value1, String value2) {
      addCriterion("staff_name between", value1, value2, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffNameNotBetween(String value1, String value2) {
      addCriterion("staff_name not between", value1, value2, "staffName");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneIsNull() {
      addCriterion("staff_phone is null");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneIsNotNull() {
      addCriterion("staff_phone is not null");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneEqualTo(String value) {
      addCriterion("staff_phone =", value, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneNotEqualTo(String value) {
      addCriterion("staff_phone <>", value, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneGreaterThan(String value) {
      addCriterion("staff_phone >", value, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("staff_phone >=", value, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneLessThan(String value) {
      addCriterion("staff_phone <", value, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneLessThanOrEqualTo(String value) {
      addCriterion("staff_phone <=", value, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneLike(String value) {
      addCriterion("staff_phone like", value, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneNotLike(String value) {
      addCriterion("staff_phone not like", value, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneIn(List<String> values) {
      addCriterion("staff_phone in", values, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneNotIn(List<String> values) {
      addCriterion("staff_phone not in", values, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneBetween(String value1, String value2) {
      addCriterion("staff_phone between", value1, value2, "staffPhone");
      return (Criteria) this;
    }

    public Criteria andStaffPhoneNotBetween(String value1, String value2) {
      addCriterion("staff_phone not between", value1, value2, "staffPhone");
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

    public Criteria andCredentialTypeIsNull() {
      addCriterion("credential_type is null");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeIsNotNull() {
      addCriterion("credential_type is not null");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeEqualTo(Integer value) {
      addCriterion("credential_type =", value, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeNotEqualTo(Integer value) {
      addCriterion("credential_type <>", value, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeGreaterThan(Integer value) {
      addCriterion("credential_type >", value, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("credential_type >=", value, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeLessThan(Integer value) {
      addCriterion("credential_type <", value, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeLessThanOrEqualTo(Integer value) {
      addCriterion("credential_type <=", value, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeIn(List<Integer> values) {
      addCriterion("credential_type in", values, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeNotIn(List<Integer> values) {
      addCriterion("credential_type not in", values, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeBetween(Integer value1, Integer value2) {
      addCriterion("credential_type between", value1, value2, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("credential_type not between", value1, value2, "credentialType");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberIsNull() {
      addCriterion("credential_number is null");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberIsNotNull() {
      addCriterion("credential_number is not null");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberEqualTo(String value) {
      addCriterion("credential_number =", value, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberNotEqualTo(String value) {
      addCriterion("credential_number <>", value, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberGreaterThan(String value) {
      addCriterion("credential_number >", value, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberGreaterThanOrEqualTo(String value) {
      addCriterion("credential_number >=", value, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberLessThan(String value) {
      addCriterion("credential_number <", value, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberLessThanOrEqualTo(String value) {
      addCriterion("credential_number <=", value, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberLike(String value) {
      addCriterion("credential_number like", value, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberNotLike(String value) {
      addCriterion("credential_number not like", value, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberIn(List<String> values) {
      addCriterion("credential_number in", values, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberNotIn(List<String> values) {
      addCriterion("credential_number not in", values, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberBetween(String value1, String value2) {
      addCriterion("credential_number between", value1, value2, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialNumberNotBetween(String value1, String value2) {
      addCriterion("credential_number not between", value1, value2, "credentialNumber");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateIsNull() {
      addCriterion("credential_validity_date is null");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateIsNotNull() {
      addCriterion("credential_validity_date is not null");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateEqualTo(Date value) {
      addCriterion("credential_validity_date =", value, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateNotEqualTo(Date value) {
      addCriterion("credential_validity_date <>", value, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateGreaterThan(Date value) {
      addCriterion("credential_validity_date >", value, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateGreaterThanOrEqualTo(Date value) {
      addCriterion("credential_validity_date >=", value, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateLessThan(Date value) {
      addCriterion("credential_validity_date <", value, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateLessThanOrEqualTo(Date value) {
      addCriterion("credential_validity_date <=", value, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateIn(List<Date> values) {
      addCriterion("credential_validity_date in", values, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateNotIn(List<Date> values) {
      addCriterion("credential_validity_date not in", values, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateBetween(Date value1, Date value2) {
      addCriterion("credential_validity_date between", value1, value2, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andCredentialValidityDateNotBetween(Date value1, Date value2) {
      addCriterion(
          "credential_validity_date not between", value1, value2, "credentialValidityDate");
      return (Criteria) this;
    }

    public Criteria andStaffGenderIsNull() {
      addCriterion("staff_gender is null");
      return (Criteria) this;
    }

    public Criteria andStaffGenderIsNotNull() {
      addCriterion("staff_gender is not null");
      return (Criteria) this;
    }

    public Criteria andStaffGenderEqualTo(Integer value) {
      addCriterion("staff_gender =", value, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderNotEqualTo(Integer value) {
      addCriterion("staff_gender <>", value, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderGreaterThan(Integer value) {
      addCriterion("staff_gender >", value, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderGreaterThanOrEqualTo(Integer value) {
      addCriterion("staff_gender >=", value, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderLessThan(Integer value) {
      addCriterion("staff_gender <", value, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderLessThanOrEqualTo(Integer value) {
      addCriterion("staff_gender <=", value, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderIn(List<Integer> values) {
      addCriterion("staff_gender in", values, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderNotIn(List<Integer> values) {
      addCriterion("staff_gender not in", values, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderBetween(Integer value1, Integer value2) {
      addCriterion("staff_gender between", value1, value2, "staffGender");
      return (Criteria) this;
    }

    public Criteria andStaffGenderNotBetween(Integer value1, Integer value2) {
      addCriterion("staff_gender not between", value1, value2, "staffGender");
      return (Criteria) this;
    }

    public Criteria andHighestEducationIsNull() {
      addCriterion("highest_education is null");
      return (Criteria) this;
    }

    public Criteria andHighestEducationIsNotNull() {
      addCriterion("highest_education is not null");
      return (Criteria) this;
    }

    public Criteria andHighestEducationEqualTo(String value) {
      addCriterion("highest_education =", value, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationNotEqualTo(String value) {
      addCriterion("highest_education <>", value, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationGreaterThan(String value) {
      addCriterion("highest_education >", value, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationGreaterThanOrEqualTo(String value) {
      addCriterion("highest_education >=", value, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationLessThan(String value) {
      addCriterion("highest_education <", value, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationLessThanOrEqualTo(String value) {
      addCriterion("highest_education <=", value, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationLike(String value) {
      addCriterion("highest_education like", value, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationNotLike(String value) {
      addCriterion("highest_education not like", value, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationIn(List<String> values) {
      addCriterion("highest_education in", values, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationNotIn(List<String> values) {
      addCriterion("highest_education not in", values, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationBetween(String value1, String value2) {
      addCriterion("highest_education between", value1, value2, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andHighestEducationNotBetween(String value1, String value2) {
      addCriterion("highest_education not between", value1, value2, "highestEducation");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeIsNull() {
      addCriterion("acquire_degree is null");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeIsNotNull() {
      addCriterion("acquire_degree is not null");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeEqualTo(String value) {
      addCriterion("acquire_degree =", value, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeNotEqualTo(String value) {
      addCriterion("acquire_degree <>", value, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeGreaterThan(String value) {
      addCriterion("acquire_degree >", value, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeGreaterThanOrEqualTo(String value) {
      addCriterion("acquire_degree >=", value, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeLessThan(String value) {
      addCriterion("acquire_degree <", value, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeLessThanOrEqualTo(String value) {
      addCriterion("acquire_degree <=", value, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeLike(String value) {
      addCriterion("acquire_degree like", value, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeNotLike(String value) {
      addCriterion("acquire_degree not like", value, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeIn(List<String> values) {
      addCriterion("acquire_degree in", values, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeNotIn(List<String> values) {
      addCriterion("acquire_degree not in", values, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeBetween(String value1, String value2) {
      addCriterion("acquire_degree between", value1, value2, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andAcquireDegreeNotBetween(String value1, String value2) {
      addCriterion("acquire_degree not between", value1, value2, "acquireDegree");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateIsNull() {
      addCriterion("diploma_date is null");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateIsNotNull() {
      addCriterion("diploma_date is not null");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateEqualTo(Date value) {
      addCriterion("diploma_date =", value, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateNotEqualTo(Date value) {
      addCriterion("diploma_date <>", value, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateGreaterThan(Date value) {
      addCriterion("diploma_date >", value, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateGreaterThanOrEqualTo(Date value) {
      addCriterion("diploma_date >=", value, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateLessThan(Date value) {
      addCriterion("diploma_date <", value, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateLessThanOrEqualTo(Date value) {
      addCriterion("diploma_date <=", value, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateIn(List<Date> values) {
      addCriterion("diploma_date in", values, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateNotIn(List<Date> values) {
      addCriterion("diploma_date not in", values, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateBetween(Date value1, Date value2) {
      addCriterion("diploma_date between", value1, value2, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDiplomaDateNotBetween(Date value1, Date value2) {
      addCriterion("diploma_date not between", value1, value2, "diplomaDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateIsNull() {
      addCriterion("degree_date is null");
      return (Criteria) this;
    }

    public Criteria andDegreeDateIsNotNull() {
      addCriterion("degree_date is not null");
      return (Criteria) this;
    }

    public Criteria andDegreeDateEqualTo(Date value) {
      addCriterion("degree_date =", value, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateNotEqualTo(Date value) {
      addCriterion("degree_date <>", value, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateGreaterThan(Date value) {
      addCriterion("degree_date >", value, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateGreaterThanOrEqualTo(Date value) {
      addCriterion("degree_date >=", value, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateLessThan(Date value) {
      addCriterion("degree_date <", value, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateLessThanOrEqualTo(Date value) {
      addCriterion("degree_date <=", value, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateIn(List<Date> values) {
      addCriterion("degree_date in", values, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateNotIn(List<Date> values) {
      addCriterion("degree_date not in", values, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateBetween(Date value1, Date value2) {
      addCriterion("degree_date between", value1, value2, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andDegreeDateNotBetween(Date value1, Date value2) {
      addCriterion("degree_date not between", value1, value2, "degreeDate");
      return (Criteria) this;
    }

    public Criteria andJobScopeIsNull() {
      addCriterion("job_scope is null");
      return (Criteria) this;
    }

    public Criteria andJobScopeIsNotNull() {
      addCriterion("job_scope is not null");
      return (Criteria) this;
    }

    public Criteria andJobScopeEqualTo(String value) {
      addCriterion("job_scope =", value, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeNotEqualTo(String value) {
      addCriterion("job_scope <>", value, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeGreaterThan(String value) {
      addCriterion("job_scope >", value, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeGreaterThanOrEqualTo(String value) {
      addCriterion("job_scope >=", value, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeLessThan(String value) {
      addCriterion("job_scope <", value, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeLessThanOrEqualTo(String value) {
      addCriterion("job_scope <=", value, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeLike(String value) {
      addCriterion("job_scope like", value, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeNotLike(String value) {
      addCriterion("job_scope not like", value, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeIn(List<String> values) {
      addCriterion("job_scope in", values, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeNotIn(List<String> values) {
      addCriterion("job_scope not in", values, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeBetween(String value1, String value2) {
      addCriterion("job_scope between", value1, value2, "jobScope");
      return (Criteria) this;
    }

    public Criteria andJobScopeNotBetween(String value1, String value2) {
      addCriterion("job_scope not between", value1, value2, "jobScope");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberIsNull() {
      addCriterion("qualification_certification_number is null");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberIsNotNull() {
      addCriterion("qualification_certification_number is not null");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberEqualTo(String value) {
      addCriterion(
          "qualification_certification_number =", value, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberNotEqualTo(String value) {
      addCriterion(
          "qualification_certification_number <>", value, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberGreaterThan(String value) {
      addCriterion(
          "qualification_certification_number >", value, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberGreaterThanOrEqualTo(String value) {
      addCriterion(
          "qualification_certification_number >=", value, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberLessThan(String value) {
      addCriterion(
          "qualification_certification_number <", value, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberLessThanOrEqualTo(String value) {
      addCriterion(
          "qualification_certification_number <=", value, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberLike(String value) {
      addCriterion(
          "qualification_certification_number like", value, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberNotLike(String value) {
      addCriterion(
          "qualification_certification_number not like", value, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberIn(List<String> values) {
      addCriterion(
          "qualification_certification_number in", values, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberNotIn(List<String> values) {
      addCriterion(
          "qualification_certification_number not in", values, "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberBetween(String value1, String value2) {
      addCriterion(
          "qualification_certification_number between",
          value1,
          value2,
          "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationNumberNotBetween(String value1, String value2) {
      addCriterion(
          "qualification_certification_number not between",
          value1,
          value2,
          "qualificationCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelIsNull() {
      addCriterion("qualification_level is null");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelIsNotNull() {
      addCriterion("qualification_level is not null");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelEqualTo(Integer value) {
      addCriterion("qualification_level =", value, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelNotEqualTo(Integer value) {
      addCriterion("qualification_level <>", value, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelGreaterThan(Integer value) {
      addCriterion("qualification_level >", value, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelGreaterThanOrEqualTo(Integer value) {
      addCriterion("qualification_level >=", value, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelLessThan(Integer value) {
      addCriterion("qualification_level <", value, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelLessThanOrEqualTo(Integer value) {
      addCriterion("qualification_level <=", value, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelIn(List<Integer> values) {
      addCriterion("qualification_level in", values, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelNotIn(List<Integer> values) {
      addCriterion("qualification_level not in", values, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelBetween(Integer value1, Integer value2) {
      addCriterion("qualification_level between", value1, value2, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationLevelNotBetween(Integer value1, Integer value2) {
      addCriterion("qualification_level not between", value1, value2, "qualificationLevel");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateIsNull() {
      addCriterion("qualification_certification_date is null");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateIsNotNull() {
      addCriterion("qualification_certification_date is not null");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateEqualTo(Date value) {
      addCriterion("qualification_certification_date =", value, "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateNotEqualTo(Date value) {
      addCriterion("qualification_certification_date <>", value, "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateGreaterThan(Date value) {
      addCriterion("qualification_certification_date >", value, "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateGreaterThanOrEqualTo(Date value) {
      addCriterion("qualification_certification_date >=", value, "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateLessThan(Date value) {
      addCriterion("qualification_certification_date <", value, "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateLessThanOrEqualTo(Date value) {
      addCriterion("qualification_certification_date <=", value, "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateIn(List<Date> values) {
      addCriterion("qualification_certification_date in", values, "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateNotIn(List<Date> values) {
      addCriterion(
          "qualification_certification_date not in", values, "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateBetween(Date value1, Date value2) {
      addCriterion(
          "qualification_certification_date between",
          value1,
          value2,
          "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andQualificationCertificationDateNotBetween(Date value1, Date value2) {
      addCriterion(
          "qualification_certification_date not between",
          value1,
          value2,
          "qualificationCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberIsNull() {
      addCriterion("practice_certification_number is null");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberIsNotNull() {
      addCriterion("practice_certification_number is not null");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberEqualTo(String value) {
      addCriterion("practice_certification_number =", value, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberNotEqualTo(String value) {
      addCriterion("practice_certification_number <>", value, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberGreaterThan(String value) {
      addCriterion("practice_certification_number >", value, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberGreaterThanOrEqualTo(String value) {
      addCriterion("practice_certification_number >=", value, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberLessThan(String value) {
      addCriterion("practice_certification_number <", value, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberLessThanOrEqualTo(String value) {
      addCriterion("practice_certification_number <=", value, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberLike(String value) {
      addCriterion("practice_certification_number like", value, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberNotLike(String value) {
      addCriterion("practice_certification_number not like", value, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberIn(List<String> values) {
      addCriterion("practice_certification_number in", values, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberNotIn(List<String> values) {
      addCriterion("practice_certification_number not in", values, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberBetween(String value1, String value2) {
      addCriterion(
          "practice_certification_number between", value1, value2, "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationNumberNotBetween(String value1, String value2) {
      addCriterion(
          "practice_certification_number not between",
          value1,
          value2,
          "practiceCertificationNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelIsNull() {
      addCriterion("practice_level is null");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelIsNotNull() {
      addCriterion("practice_level is not null");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelEqualTo(Integer value) {
      addCriterion("practice_level =", value, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelNotEqualTo(Integer value) {
      addCriterion("practice_level <>", value, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelGreaterThan(Integer value) {
      addCriterion("practice_level >", value, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelGreaterThanOrEqualTo(Integer value) {
      addCriterion("practice_level >=", value, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelLessThan(Integer value) {
      addCriterion("practice_level <", value, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelLessThanOrEqualTo(Integer value) {
      addCriterion("practice_level <=", value, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelIn(List<Integer> values) {
      addCriterion("practice_level in", values, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelNotIn(List<Integer> values) {
      addCriterion("practice_level not in", values, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelBetween(Integer value1, Integer value2) {
      addCriterion("practice_level between", value1, value2, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeLevelNotBetween(Integer value1, Integer value2) {
      addCriterion("practice_level not between", value1, value2, "practiceLevel");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateIsNull() {
      addCriterion("practice_certification_date is null");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateIsNotNull() {
      addCriterion("practice_certification_date is not null");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateEqualTo(Date value) {
      addCriterion("practice_certification_date =", value, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateNotEqualTo(Date value) {
      addCriterion("practice_certification_date <>", value, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateGreaterThan(Date value) {
      addCriterion("practice_certification_date >", value, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateGreaterThanOrEqualTo(Date value) {
      addCriterion("practice_certification_date >=", value, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateLessThan(Date value) {
      addCriterion("practice_certification_date <", value, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateLessThanOrEqualTo(Date value) {
      addCriterion("practice_certification_date <=", value, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateIn(List<Date> values) {
      addCriterion("practice_certification_date in", values, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateNotIn(List<Date> values) {
      addCriterion("practice_certification_date not in", values, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateBetween(Date value1, Date value2) {
      addCriterion(
          "practice_certification_date between", value1, value2, "practiceCertificationDate");
      return (Criteria) this;
    }

    public Criteria andPracticeCertificationDateNotBetween(Date value1, Date value2) {
      addCriterion(
          "practice_certification_date not between", value1, value2, "practiceCertificationDate");
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

    public Criteria andUniqueNumberIsNull() {
      addCriterion("unique_number is null");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberIsNotNull() {
      addCriterion("unique_number is not null");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberEqualTo(String value) {
      addCriterion("unique_number =", value, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberNotEqualTo(String value) {
      addCriterion("unique_number <>", value, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberGreaterThan(String value) {
      addCriterion("unique_number >", value, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberGreaterThanOrEqualTo(String value) {
      addCriterion("unique_number >=", value, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberLessThan(String value) {
      addCriterion("unique_number <", value, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberLessThanOrEqualTo(String value) {
      addCriterion("unique_number <=", value, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberLike(String value) {
      addCriterion("unique_number like", value, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberNotLike(String value) {
      addCriterion("unique_number not like", value, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberIn(List<String> values) {
      addCriterion("unique_number in", values, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberNotIn(List<String> values) {
      addCriterion("unique_number not in", values, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberBetween(String value1, String value2) {
      addCriterion("unique_number between", value1, value2, "uniqueNumber");
      return (Criteria) this;
    }

    public Criteria andUniqueNumberNotBetween(String value1, String value2) {
      addCriterion("unique_number not between", value1, value2, "uniqueNumber");
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

    public Criteria andCauseIsNull() {
      addCriterion("cause is null");
      return (Criteria) this;
    }

    public Criteria andCauseIsNotNull() {
      addCriterion("cause is not null");
      return (Criteria) this;
    }

    public Criteria andCauseEqualTo(String value) {
      addCriterion("cause =", value, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseNotEqualTo(String value) {
      addCriterion("cause <>", value, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseGreaterThan(String value) {
      addCriterion("cause >", value, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseGreaterThanOrEqualTo(String value) {
      addCriterion("cause >=", value, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseLessThan(String value) {
      addCriterion("cause <", value, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseLessThanOrEqualTo(String value) {
      addCriterion("cause <=", value, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseLike(String value) {
      addCriterion("cause like", value, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseNotLike(String value) {
      addCriterion("cause not like", value, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseIn(List<String> values) {
      addCriterion("cause in", values, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseNotIn(List<String> values) {
      addCriterion("cause not in", values, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseBetween(String value1, String value2) {
      addCriterion("cause between", value1, value2, "cause");
      return (Criteria) this;
    }

    public Criteria andCauseNotBetween(String value1, String value2) {
      addCriterion("cause not between", value1, value2, "cause");
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

    public Criteria andStaffLevelIsNull() {
      addCriterion("staff_level is null");
      return (Criteria) this;
    }

    public Criteria andStaffLevelIsNotNull() {
      addCriterion("staff_level is not null");
      return (Criteria) this;
    }

    public Criteria andStaffLevelEqualTo(String value) {
      addCriterion("staff_level =", value, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelNotEqualTo(String value) {
      addCriterion("staff_level <>", value, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelGreaterThan(String value) {
      addCriterion("staff_level >", value, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelGreaterThanOrEqualTo(String value) {
      addCriterion("staff_level >=", value, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelLessThan(String value) {
      addCriterion("staff_level <", value, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelLessThanOrEqualTo(String value) {
      addCriterion("staff_level <=", value, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelLike(String value) {
      addCriterion("staff_level like", value, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelNotLike(String value) {
      addCriterion("staff_level not like", value, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelIn(List<String> values) {
      addCriterion("staff_level in", values, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelNotIn(List<String> values) {
      addCriterion("staff_level not in", values, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelBetween(String value1, String value2) {
      addCriterion("staff_level between", value1, value2, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andStaffLevelNotBetween(String value1, String value2) {
      addCriterion("staff_level not between", value1, value2, "staffLevel");
      return (Criteria) this;
    }

    public Criteria andCategoryIsNull() {
      addCriterion("category is null");
      return (Criteria) this;
    }

    public Criteria andCategoryIsNotNull() {
      addCriterion("category is not null");
      return (Criteria) this;
    }

    public Criteria andCategoryEqualTo(String value) {
      addCriterion("category =", value, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryNotEqualTo(String value) {
      addCriterion("category <>", value, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryGreaterThan(String value) {
      addCriterion("category >", value, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryGreaterThanOrEqualTo(String value) {
      addCriterion("category >=", value, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryLessThan(String value) {
      addCriterion("category <", value, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryLessThanOrEqualTo(String value) {
      addCriterion("category <=", value, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryLike(String value) {
      addCriterion("category like", value, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryNotLike(String value) {
      addCriterion("category not like", value, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryIn(List<String> values) {
      addCriterion("category in", values, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryNotIn(List<String> values) {
      addCriterion("category not in", values, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryBetween(String value1, String value2) {
      addCriterion("category between", value1, value2, "category");
      return (Criteria) this;
    }

    public Criteria andCategoryNotBetween(String value1, String value2) {
      addCriterion("category not between", value1, value2, "category");
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
