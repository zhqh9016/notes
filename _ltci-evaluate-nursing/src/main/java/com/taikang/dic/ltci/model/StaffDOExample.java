package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public StaffDOExample() {
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

    public Criteria andStaffidIsNull() {
      addCriterion("staffid is null");
      return (Criteria) this;
    }

    public Criteria andStaffidIsNotNull() {
      addCriterion("staffid is not null");
      return (Criteria) this;
    }

    public Criteria andStaffidEqualTo(String value) {
      addCriterion("staffid =", value, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidNotEqualTo(String value) {
      addCriterion("staffid <>", value, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidGreaterThan(String value) {
      addCriterion("staffid >", value, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidGreaterThanOrEqualTo(String value) {
      addCriterion("staffid >=", value, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidLessThan(String value) {
      addCriterion("staffid <", value, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidLessThanOrEqualTo(String value) {
      addCriterion("staffid <=", value, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidLike(String value) {
      addCriterion("staffid like", value, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidNotLike(String value) {
      addCriterion("staffid not like", value, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidIn(List<String> values) {
      addCriterion("staffid in", values, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidNotIn(List<String> values) {
      addCriterion("staffid not in", values, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidBetween(String value1, String value2) {
      addCriterion("staffid between", value1, value2, "staffid");
      return (Criteria) this;
    }

    public Criteria andStaffidNotBetween(String value1, String value2) {
      addCriterion("staffid not between", value1, value2, "staffid");
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

    public Criteria andCertificateDateIsNull() {
      addCriterion("certificate_date is null");
      return (Criteria) this;
    }

    public Criteria andCertificateDateIsNotNull() {
      addCriterion("certificate_date is not null");
      return (Criteria) this;
    }

    public Criteria andCertificateDateEqualTo(Date value) {
      addCriterion("certificate_date =", value, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateNotEqualTo(Date value) {
      addCriterion("certificate_date <>", value, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateGreaterThan(Date value) {
      addCriterion("certificate_date >", value, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("certificate_date >=", value, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateLessThan(Date value) {
      addCriterion("certificate_date <", value, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateLessThanOrEqualTo(Date value) {
      addCriterion("certificate_date <=", value, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateIn(List<Date> values) {
      addCriterion("certificate_date in", values, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateNotIn(List<Date> values) {
      addCriterion("certificate_date not in", values, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateBetween(Date value1, Date value2) {
      addCriterion("certificate_date between", value1, value2, "certificateDate");
      return (Criteria) this;
    }

    public Criteria andCertificateDateNotBetween(Date value1, Date value2) {
      addCriterion("certificate_date not between", value1, value2, "certificateDate");
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

    public Criteria andCertificateNumberIsNull() {
      addCriterion("certificate_number is null");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberIsNotNull() {
      addCriterion("certificate_number is not null");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberEqualTo(String value) {
      addCriterion("certificate_number =", value, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberNotEqualTo(String value) {
      addCriterion("certificate_number <>", value, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberGreaterThan(String value) {
      addCriterion("certificate_number >", value, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberGreaterThanOrEqualTo(String value) {
      addCriterion("certificate_number >=", value, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberLessThan(String value) {
      addCriterion("certificate_number <", value, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberLessThanOrEqualTo(String value) {
      addCriterion("certificate_number <=", value, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberLike(String value) {
      addCriterion("certificate_number like", value, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberNotLike(String value) {
      addCriterion("certificate_number not like", value, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberIn(List<String> values) {
      addCriterion("certificate_number in", values, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberNotIn(List<String> values) {
      addCriterion("certificate_number not in", values, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberBetween(String value1, String value2) {
      addCriterion("certificate_number between", value1, value2, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andCertificateNumberNotBetween(String value1, String value2) {
      addCriterion("certificate_number not between", value1, value2, "certificateNumber");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeIsNull() {
      addCriterion("practice_numbe is null");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeIsNotNull() {
      addCriterion("practice_numbe is not null");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeEqualTo(String value) {
      addCriterion("practice_numbe =", value, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeNotEqualTo(String value) {
      addCriterion("practice_numbe <>", value, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeGreaterThan(String value) {
      addCriterion("practice_numbe >", value, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeGreaterThanOrEqualTo(String value) {
      addCriterion("practice_numbe >=", value, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeLessThan(String value) {
      addCriterion("practice_numbe <", value, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeLessThanOrEqualTo(String value) {
      addCriterion("practice_numbe <=", value, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeLike(String value) {
      addCriterion("practice_numbe like", value, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeNotLike(String value) {
      addCriterion("practice_numbe not like", value, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeIn(List<String> values) {
      addCriterion("practice_numbe in", values, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeNotIn(List<String> values) {
      addCriterion("practice_numbe not in", values, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeBetween(String value1, String value2) {
      addCriterion("practice_numbe between", value1, value2, "practiceNumbe");
      return (Criteria) this;
    }

    public Criteria andPracticeNumbeNotBetween(String value1, String value2) {
      addCriterion("practice_numbe not between", value1, value2, "practiceNumbe");
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

    public Criteria andCredentialBeginDateIsNull() {
      addCriterion("credential_begin_date is null");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateIsNotNull() {
      addCriterion("credential_begin_date is not null");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateEqualTo(Date value) {
      addCriterion("credential_begin_date =", value, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateNotEqualTo(Date value) {
      addCriterion("credential_begin_date <>", value, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateGreaterThan(Date value) {
      addCriterion("credential_begin_date >", value, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateGreaterThanOrEqualTo(Date value) {
      addCriterion("credential_begin_date >=", value, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateLessThan(Date value) {
      addCriterion("credential_begin_date <", value, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateLessThanOrEqualTo(Date value) {
      addCriterion("credential_begin_date <=", value, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateIn(List<Date> values) {
      addCriterion("credential_begin_date in", values, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateNotIn(List<Date> values) {
      addCriterion("credential_begin_date not in", values, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateBetween(Date value1, Date value2) {
      addCriterion("credential_begin_date between", value1, value2, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialBeginDateNotBetween(Date value1, Date value2) {
      addCriterion("credential_begin_date not between", value1, value2, "credentialBeginDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateIsNull() {
      addCriterion("credential_end_date is null");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateIsNotNull() {
      addCriterion("credential_end_date is not null");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateEqualTo(Date value) {
      addCriterion("credential_end_date =", value, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateNotEqualTo(Date value) {
      addCriterion("credential_end_date <>", value, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateGreaterThan(Date value) {
      addCriterion("credential_end_date >", value, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateGreaterThanOrEqualTo(Date value) {
      addCriterion("credential_end_date >=", value, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateLessThan(Date value) {
      addCriterion("credential_end_date <", value, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateLessThanOrEqualTo(Date value) {
      addCriterion("credential_end_date <=", value, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateIn(List<Date> values) {
      addCriterion("credential_end_date in", values, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateNotIn(List<Date> values) {
      addCriterion("credential_end_date not in", values, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateBetween(Date value1, Date value2) {
      addCriterion("credential_end_date between", value1, value2, "credentialEndDate");
      return (Criteria) this;
    }

    public Criteria andCredentialEndDateNotBetween(Date value1, Date value2) {
      addCriterion("credential_end_date not between", value1, value2, "credentialEndDate");
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

    public Criteria andCommentIsNull() {
      addCriterion("comment is null");
      return (Criteria) this;
    }

    public Criteria andCommentIsNotNull() {
      addCriterion("comment is not null");
      return (Criteria) this;
    }

    public Criteria andCommentEqualTo(String value) {
      addCriterion("comment =", value, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentNotEqualTo(String value) {
      addCriterion("comment <>", value, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentGreaterThan(String value) {
      addCriterion("comment >", value, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentGreaterThanOrEqualTo(String value) {
      addCriterion("comment >=", value, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentLessThan(String value) {
      addCriterion("comment <", value, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentLessThanOrEqualTo(String value) {
      addCriterion("comment <=", value, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentLike(String value) {
      addCriterion("comment like", value, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentNotLike(String value) {
      addCriterion("comment not like", value, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentIn(List<String> values) {
      addCriterion("comment in", values, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentNotIn(List<String> values) {
      addCriterion("comment not in", values, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentBetween(String value1, String value2) {
      addCriterion("comment between", value1, value2, "comment");
      return (Criteria) this;
    }

    public Criteria andCommentNotBetween(String value1, String value2) {
      addCriterion("comment not between", value1, value2, "comment");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdIsNull() {
      addCriterion("supervise_approve_id is null");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdIsNotNull() {
      addCriterion("supervise_approve_id is not null");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdEqualTo(String value) {
      addCriterion("supervise_approve_id =", value, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdNotEqualTo(String value) {
      addCriterion("supervise_approve_id <>", value, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdGreaterThan(String value) {
      addCriterion("supervise_approve_id >", value, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdGreaterThanOrEqualTo(String value) {
      addCriterion("supervise_approve_id >=", value, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdLessThan(String value) {
      addCriterion("supervise_approve_id <", value, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdLessThanOrEqualTo(String value) {
      addCriterion("supervise_approve_id <=", value, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdLike(String value) {
      addCriterion("supervise_approve_id like", value, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdNotLike(String value) {
      addCriterion("supervise_approve_id not like", value, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdIn(List<String> values) {
      addCriterion("supervise_approve_id in", values, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdNotIn(List<String> values) {
      addCriterion("supervise_approve_id not in", values, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdBetween(String value1, String value2) {
      addCriterion("supervise_approve_id between", value1, value2, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andSuperviseApproveIdNotBetween(String value1, String value2) {
      addCriterion("supervise_approve_id not between", value1, value2, "superviseApproveId");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateIsNull() {
      addCriterion("\"staff _audit_state\" is null");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateIsNotNull() {
      addCriterion("\"staff _audit_state\" is not null");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateEqualTo(Integer value) {
      addCriterion("\"staff _audit_state\" =", value, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateNotEqualTo(Integer value) {
      addCriterion("\"staff _audit_state\" <>", value, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateGreaterThan(Integer value) {
      addCriterion("\"staff _audit_state\" >", value, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateGreaterThanOrEqualTo(Integer value) {
      addCriterion("\"staff _audit_state\" >=", value, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateLessThan(Integer value) {
      addCriterion("\"staff _audit_state\" <", value, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateLessThanOrEqualTo(Integer value) {
      addCriterion("\"staff _audit_state\" <=", value, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateIn(List<Integer> values) {
      addCriterion("\"staff _audit_state\" in", values, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateNotIn(List<Integer> values) {
      addCriterion("\"staff _audit_state\" not in", values, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateBetween(Integer value1, Integer value2) {
      addCriterion("\"staff _audit_state\" between", value1, value2, "staffAuditState");
      return (Criteria) this;
    }

    public Criteria andStaffAuditStateNotBetween(Integer value1, Integer value2) {
      addCriterion("\"staff _audit_state\" not between", value1, value2, "staffAuditState");
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

    public Criteria andCreateTimeIsNull() {
      addCriterion("create_time is null");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIsNotNull() {
      addCriterion("create_time is not null");
      return (Criteria) this;
    }

    public Criteria andCreateTimeEqualTo(Date value) {
      addCriterion("create_time =", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotEqualTo(Date value) {
      addCriterion("create_time <>", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeGreaterThan(Date value) {
      addCriterion("create_time >", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("create_time >=", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeLessThan(Date value) {
      addCriterion("create_time <", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
      addCriterion("create_time <=", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIn(List<Date> values) {
      addCriterion("create_time in", values, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotIn(List<Date> values) {
      addCriterion("create_time not in", values, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeBetween(Date value1, Date value2) {
      addCriterion("create_time between", value1, value2, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
      addCriterion("create_time not between", value1, value2, "createTime");
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
