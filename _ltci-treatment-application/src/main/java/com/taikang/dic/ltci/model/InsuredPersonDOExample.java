package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsuredPersonDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public InsuredPersonDOExample() {
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

    public Criteria andInsuredPersonidIsNull() {
      addCriterion("insured_personid is null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidIsNotNull() {
      addCriterion("insured_personid is not null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidEqualTo(String value) {
      addCriterion("insured_personid =", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidNotEqualTo(String value) {
      addCriterion("insured_personid <>", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidGreaterThan(String value) {
      addCriterion("insured_personid >", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidGreaterThanOrEqualTo(String value) {
      addCriterion("insured_personid >=", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidLessThan(String value) {
      addCriterion("insured_personid <", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidLessThanOrEqualTo(String value) {
      addCriterion("insured_personid <=", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidLike(String value) {
      addCriterion("insured_personid like", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidNotLike(String value) {
      addCriterion("insured_personid not like", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidIn(List<String> values) {
      addCriterion("insured_personid in", values, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidNotIn(List<String> values) {
      addCriterion("insured_personid not in", values, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidBetween(String value1, String value2) {
      addCriterion("insured_personid between", value1, value2, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidNotBetween(String value1, String value2) {
      addCriterion("insured_personid not between", value1, value2, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeIsNull() {
      addCriterion("insured_person_code is null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeIsNotNull() {
      addCriterion("insured_person_code is not null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeEqualTo(String value) {
      addCriterion("insured_person_code =", value, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeNotEqualTo(String value) {
      addCriterion("insured_person_code <>", value, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeGreaterThan(String value) {
      addCriterion("insured_person_code >", value, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeGreaterThanOrEqualTo(String value) {
      addCriterion("insured_person_code >=", value, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeLessThan(String value) {
      addCriterion("insured_person_code <", value, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeLessThanOrEqualTo(String value) {
      addCriterion("insured_person_code <=", value, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeLike(String value) {
      addCriterion("insured_person_code like", value, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeNotLike(String value) {
      addCriterion("insured_person_code not like", value, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeIn(List<String> values) {
      addCriterion("insured_person_code in", values, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeNotIn(List<String> values) {
      addCriterion("insured_person_code not in", values, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeBetween(String value1, String value2) {
      addCriterion("insured_person_code between", value1, value2, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonCodeNotBetween(String value1, String value2) {
      addCriterion("insured_person_code not between", value1, value2, "insuredPersonCode");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameIsNull() {
      addCriterion("insured_person_name is null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameIsNotNull() {
      addCriterion("insured_person_name is not null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameEqualTo(String value) {
      addCriterion("insured_person_name =", value, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameNotEqualTo(String value) {
      addCriterion("insured_person_name <>", value, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameGreaterThan(String value) {
      addCriterion("insured_person_name >", value, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameGreaterThanOrEqualTo(String value) {
      addCriterion("insured_person_name >=", value, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameLessThan(String value) {
      addCriterion("insured_person_name <", value, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameLessThanOrEqualTo(String value) {
      addCriterion("insured_person_name <=", value, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameLike(String value) {
      addCriterion("insured_person_name like", value, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameNotLike(String value) {
      addCriterion("insured_person_name not like", value, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameIn(List<String> values) {
      addCriterion("insured_person_name in", values, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameNotIn(List<String> values) {
      addCriterion("insured_person_name not in", values, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameBetween(String value1, String value2) {
      addCriterion("insured_person_name between", value1, value2, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonNameNotBetween(String value1, String value2) {
      addCriterion("insured_person_name not between", value1, value2, "insuredPersonName");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderIsNull() {
      addCriterion("insured_person_gender is null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderIsNotNull() {
      addCriterion("insured_person_gender is not null");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderEqualTo(String value) {
      addCriterion("insured_person_gender =", value, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderNotEqualTo(String value) {
      addCriterion("insured_person_gender <>", value, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderGreaterThan(String value) {
      addCriterion("insured_person_gender >", value, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderGreaterThanOrEqualTo(String value) {
      addCriterion("insured_person_gender >=", value, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderLessThan(String value) {
      addCriterion("insured_person_gender <", value, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderLessThanOrEqualTo(String value) {
      addCriterion("insured_person_gender <=", value, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderLike(String value) {
      addCriterion("insured_person_gender like", value, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderNotLike(String value) {
      addCriterion("insured_person_gender not like", value, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderIn(List<String> values) {
      addCriterion("insured_person_gender in", values, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderNotIn(List<String> values) {
      addCriterion("insured_person_gender not in", values, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderBetween(String value1, String value2) {
      addCriterion("insured_person_gender between", value1, value2, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonGenderNotBetween(String value1, String value2) {
      addCriterion("insured_person_gender not between", value1, value2, "insuredPersonGender");
      return (Criteria) this;
    }

    public Criteria andNationIsNull() {
      addCriterion("nation is null");
      return (Criteria) this;
    }

    public Criteria andNationIsNotNull() {
      addCriterion("nation is not null");
      return (Criteria) this;
    }

    public Criteria andNationEqualTo(String value) {
      addCriterion("nation =", value, "nation");
      return (Criteria) this;
    }

    public Criteria andNationNotEqualTo(String value) {
      addCriterion("nation <>", value, "nation");
      return (Criteria) this;
    }

    public Criteria andNationGreaterThan(String value) {
      addCriterion("nation >", value, "nation");
      return (Criteria) this;
    }

    public Criteria andNationGreaterThanOrEqualTo(String value) {
      addCriterion("nation >=", value, "nation");
      return (Criteria) this;
    }

    public Criteria andNationLessThan(String value) {
      addCriterion("nation <", value, "nation");
      return (Criteria) this;
    }

    public Criteria andNationLessThanOrEqualTo(String value) {
      addCriterion("nation <=", value, "nation");
      return (Criteria) this;
    }

    public Criteria andNationLike(String value) {
      addCriterion("nation like", value, "nation");
      return (Criteria) this;
    }

    public Criteria andNationNotLike(String value) {
      addCriterion("nation not like", value, "nation");
      return (Criteria) this;
    }

    public Criteria andNationIn(List<String> values) {
      addCriterion("nation in", values, "nation");
      return (Criteria) this;
    }

    public Criteria andNationNotIn(List<String> values) {
      addCriterion("nation not in", values, "nation");
      return (Criteria) this;
    }

    public Criteria andNationBetween(String value1, String value2) {
      addCriterion("nation between", value1, value2, "nation");
      return (Criteria) this;
    }

    public Criteria andNationNotBetween(String value1, String value2) {
      addCriterion("nation not between", value1, value2, "nation");
      return (Criteria) this;
    }

    public Criteria andBirthdayIsNull() {
      addCriterion("birthday is null");
      return (Criteria) this;
    }

    public Criteria andBirthdayIsNotNull() {
      addCriterion("birthday is not null");
      return (Criteria) this;
    }

    public Criteria andBirthdayEqualTo(Date value) {
      addCriterion("birthday =", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayNotEqualTo(Date value) {
      addCriterion("birthday <>", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayGreaterThan(Date value) {
      addCriterion("birthday >", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
      addCriterion("birthday >=", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayLessThan(Date value) {
      addCriterion("birthday <", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayLessThanOrEqualTo(Date value) {
      addCriterion("birthday <=", value, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayIn(List<Date> values) {
      addCriterion("birthday in", values, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayNotIn(List<Date> values) {
      addCriterion("birthday not in", values, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayBetween(Date value1, Date value2) {
      addCriterion("birthday between", value1, value2, "birthday");
      return (Criteria) this;
    }

    public Criteria andBirthdayNotBetween(Date value1, Date value2) {
      addCriterion("birthday not between", value1, value2, "birthday");
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

    public Criteria andPersonnelIdentityCodeIsNull() {
      addCriterion("personnel_identity_code is null");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeIsNotNull() {
      addCriterion("personnel_identity_code is not null");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeEqualTo(String value) {
      addCriterion("personnel_identity_code =", value, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeNotEqualTo(String value) {
      addCriterion("personnel_identity_code <>", value, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeGreaterThan(String value) {
      addCriterion("personnel_identity_code >", value, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeGreaterThanOrEqualTo(String value) {
      addCriterion("personnel_identity_code >=", value, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeLessThan(String value) {
      addCriterion("personnel_identity_code <", value, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeLessThanOrEqualTo(String value) {
      addCriterion("personnel_identity_code <=", value, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeLike(String value) {
      addCriterion("personnel_identity_code like", value, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeNotLike(String value) {
      addCriterion("personnel_identity_code not like", value, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeIn(List<String> values) {
      addCriterion("personnel_identity_code in", values, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeNotIn(List<String> values) {
      addCriterion("personnel_identity_code not in", values, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeBetween(String value1, String value2) {
      addCriterion("personnel_identity_code between", value1, value2, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityCodeNotBetween(String value1, String value2) {
      addCriterion("personnel_identity_code not between", value1, value2, "personnelIdentityCode");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameIsNull() {
      addCriterion("personnel_identity_name is null");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameIsNotNull() {
      addCriterion("personnel_identity_name is not null");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameEqualTo(String value) {
      addCriterion("personnel_identity_name =", value, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameNotEqualTo(String value) {
      addCriterion("personnel_identity_name <>", value, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameGreaterThan(String value) {
      addCriterion("personnel_identity_name >", value, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameGreaterThanOrEqualTo(String value) {
      addCriterion("personnel_identity_name >=", value, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameLessThan(String value) {
      addCriterion("personnel_identity_name <", value, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameLessThanOrEqualTo(String value) {
      addCriterion("personnel_identity_name <=", value, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameLike(String value) {
      addCriterion("personnel_identity_name like", value, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameNotLike(String value) {
      addCriterion("personnel_identity_name not like", value, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameIn(List<String> values) {
      addCriterion("personnel_identity_name in", values, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameNotIn(List<String> values) {
      addCriterion("personnel_identity_name not in", values, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameBetween(String value1, String value2) {
      addCriterion("personnel_identity_name between", value1, value2, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andPersonnelIdentityNameNotBetween(String value1, String value2) {
      addCriterion("personnel_identity_name not between", value1, value2, "personnelIdentityName");
      return (Criteria) this;
    }

    public Criteria andMobileIsNull() {
      addCriterion("mobile is null");
      return (Criteria) this;
    }

    public Criteria andMobileIsNotNull() {
      addCriterion("mobile is not null");
      return (Criteria) this;
    }

    public Criteria andMobileEqualTo(String value) {
      addCriterion("mobile =", value, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileNotEqualTo(String value) {
      addCriterion("mobile <>", value, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileGreaterThan(String value) {
      addCriterion("mobile >", value, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileGreaterThanOrEqualTo(String value) {
      addCriterion("mobile >=", value, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileLessThan(String value) {
      addCriterion("mobile <", value, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileLessThanOrEqualTo(String value) {
      addCriterion("mobile <=", value, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileLike(String value) {
      addCriterion("mobile like", value, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileNotLike(String value) {
      addCriterion("mobile not like", value, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileIn(List<String> values) {
      addCriterion("mobile in", values, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileNotIn(List<String> values) {
      addCriterion("mobile not in", values, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileBetween(String value1, String value2) {
      addCriterion("mobile between", value1, value2, "mobile");
      return (Criteria) this;
    }

    public Criteria andMobileNotBetween(String value1, String value2) {
      addCriterion("mobile not between", value1, value2, "mobile");
      return (Criteria) this;
    }

    public Criteria andEmailIsNull() {
      addCriterion("email is null");
      return (Criteria) this;
    }

    public Criteria andEmailIsNotNull() {
      addCriterion("email is not null");
      return (Criteria) this;
    }

    public Criteria andEmailEqualTo(String value) {
      addCriterion("email =", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotEqualTo(String value) {
      addCriterion("email <>", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailGreaterThan(String value) {
      addCriterion("email >", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailGreaterThanOrEqualTo(String value) {
      addCriterion("email >=", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLessThan(String value) {
      addCriterion("email <", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLessThanOrEqualTo(String value) {
      addCriterion("email <=", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLike(String value) {
      addCriterion("email like", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotLike(String value) {
      addCriterion("email not like", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailIn(List<String> values) {
      addCriterion("email in", values, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotIn(List<String> values) {
      addCriterion("email not in", values, "email");
      return (Criteria) this;
    }

    public Criteria andEmailBetween(String value1, String value2) {
      addCriterion("email between", value1, value2, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotBetween(String value1, String value2) {
      addCriterion("email not between", value1, value2, "email");
      return (Criteria) this;
    }

    public Criteria andAddressIsNull() {
      addCriterion("address is null");
      return (Criteria) this;
    }

    public Criteria andAddressIsNotNull() {
      addCriterion("address is not null");
      return (Criteria) this;
    }

    public Criteria andAddressEqualTo(String value) {
      addCriterion("address =", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressNotEqualTo(String value) {
      addCriterion("address <>", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressGreaterThan(String value) {
      addCriterion("address >", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressGreaterThanOrEqualTo(String value) {
      addCriterion("address >=", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressLessThan(String value) {
      addCriterion("address <", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressLessThanOrEqualTo(String value) {
      addCriterion("address <=", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressLike(String value) {
      addCriterion("address like", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressNotLike(String value) {
      addCriterion("address not like", value, "address");
      return (Criteria) this;
    }

    public Criteria andAddressIn(List<String> values) {
      addCriterion("address in", values, "address");
      return (Criteria) this;
    }

    public Criteria andAddressNotIn(List<String> values) {
      addCriterion("address not in", values, "address");
      return (Criteria) this;
    }

    public Criteria andAddressBetween(String value1, String value2) {
      addCriterion("address between", value1, value2, "address");
      return (Criteria) this;
    }

    public Criteria andAddressNotBetween(String value1, String value2) {
      addCriterion("address not between", value1, value2, "address");
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

    public Criteria andMarriedIsNull() {
      addCriterion("married is null");
      return (Criteria) this;
    }

    public Criteria andMarriedIsNotNull() {
      addCriterion("married is not null");
      return (Criteria) this;
    }

    public Criteria andMarriedEqualTo(String value) {
      addCriterion("married =", value, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedNotEqualTo(String value) {
      addCriterion("married <>", value, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedGreaterThan(String value) {
      addCriterion("married >", value, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedGreaterThanOrEqualTo(String value) {
      addCriterion("married >=", value, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedLessThan(String value) {
      addCriterion("married <", value, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedLessThanOrEqualTo(String value) {
      addCriterion("married <=", value, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedLike(String value) {
      addCriterion("married like", value, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedNotLike(String value) {
      addCriterion("married not like", value, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedIn(List<String> values) {
      addCriterion("married in", values, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedNotIn(List<String> values) {
      addCriterion("married not in", values, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedBetween(String value1, String value2) {
      addCriterion("married between", value1, value2, "married");
      return (Criteria) this;
    }

    public Criteria andMarriedNotBetween(String value1, String value2) {
      addCriterion("married not between", value1, value2, "married");
      return (Criteria) this;
    }

    public Criteria andEducationidIsNull() {
      addCriterion("educationid is null");
      return (Criteria) this;
    }

    public Criteria andEducationidIsNotNull() {
      addCriterion("educationid is not null");
      return (Criteria) this;
    }

    public Criteria andEducationidEqualTo(String value) {
      addCriterion("educationid =", value, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidNotEqualTo(String value) {
      addCriterion("educationid <>", value, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidGreaterThan(String value) {
      addCriterion("educationid >", value, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidGreaterThanOrEqualTo(String value) {
      addCriterion("educationid >=", value, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidLessThan(String value) {
      addCriterion("educationid <", value, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidLessThanOrEqualTo(String value) {
      addCriterion("educationid <=", value, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidLike(String value) {
      addCriterion("educationid like", value, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidNotLike(String value) {
      addCriterion("educationid not like", value, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidIn(List<String> values) {
      addCriterion("educationid in", values, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidNotIn(List<String> values) {
      addCriterion("educationid not in", values, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidBetween(String value1, String value2) {
      addCriterion("educationid between", value1, value2, "educationid");
      return (Criteria) this;
    }

    public Criteria andEducationidNotBetween(String value1, String value2) {
      addCriterion("educationid not between", value1, value2, "educationid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidIsNull() {
      addCriterion("politicsid is null");
      return (Criteria) this;
    }

    public Criteria andPoliticsidIsNotNull() {
      addCriterion("politicsid is not null");
      return (Criteria) this;
    }

    public Criteria andPoliticsidEqualTo(String value) {
      addCriterion("politicsid =", value, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidNotEqualTo(String value) {
      addCriterion("politicsid <>", value, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidGreaterThan(String value) {
      addCriterion("politicsid >", value, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidGreaterThanOrEqualTo(String value) {
      addCriterion("politicsid >=", value, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidLessThan(String value) {
      addCriterion("politicsid <", value, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidLessThanOrEqualTo(String value) {
      addCriterion("politicsid <=", value, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidLike(String value) {
      addCriterion("politicsid like", value, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidNotLike(String value) {
      addCriterion("politicsid not like", value, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidIn(List<String> values) {
      addCriterion("politicsid in", values, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidNotIn(List<String> values) {
      addCriterion("politicsid not in", values, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidBetween(String value1, String value2) {
      addCriterion("politicsid between", value1, value2, "politicsid");
      return (Criteria) this;
    }

    public Criteria andPoliticsidNotBetween(String value1, String value2) {
      addCriterion("politicsid not between", value1, value2, "politicsid");
      return (Criteria) this;
    }

    public Criteria andOccupationidIsNull() {
      addCriterion("occupationid is null");
      return (Criteria) this;
    }

    public Criteria andOccupationidIsNotNull() {
      addCriterion("occupationid is not null");
      return (Criteria) this;
    }

    public Criteria andOccupationidEqualTo(String value) {
      addCriterion("occupationid =", value, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidNotEqualTo(String value) {
      addCriterion("occupationid <>", value, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidGreaterThan(String value) {
      addCriterion("occupationid >", value, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidGreaterThanOrEqualTo(String value) {
      addCriterion("occupationid >=", value, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidLessThan(String value) {
      addCriterion("occupationid <", value, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidLessThanOrEqualTo(String value) {
      addCriterion("occupationid <=", value, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidLike(String value) {
      addCriterion("occupationid like", value, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidNotLike(String value) {
      addCriterion("occupationid not like", value, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidIn(List<String> values) {
      addCriterion("occupationid in", values, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidNotIn(List<String> values) {
      addCriterion("occupationid not in", values, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidBetween(String value1, String value2) {
      addCriterion("occupationid between", value1, value2, "occupationid");
      return (Criteria) this;
    }

    public Criteria andOccupationidNotBetween(String value1, String value2) {
      addCriterion("occupationid not between", value1, value2, "occupationid");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeIsNull() {
      addCriterion("province_code is null");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeIsNotNull() {
      addCriterion("province_code is not null");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeEqualTo(String value) {
      addCriterion("province_code =", value, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeNotEqualTo(String value) {
      addCriterion("province_code <>", value, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeGreaterThan(String value) {
      addCriterion("province_code >", value, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
      addCriterion("province_code >=", value, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeLessThan(String value) {
      addCriterion("province_code <", value, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
      addCriterion("province_code <=", value, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeLike(String value) {
      addCriterion("province_code like", value, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeNotLike(String value) {
      addCriterion("province_code not like", value, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeIn(List<String> values) {
      addCriterion("province_code in", values, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeNotIn(List<String> values) {
      addCriterion("province_code not in", values, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeBetween(String value1, String value2) {
      addCriterion("province_code between", value1, value2, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andProvinceCodeNotBetween(String value1, String value2) {
      addCriterion("province_code not between", value1, value2, "provinceCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeIsNull() {
      addCriterion("city_code is null");
      return (Criteria) this;
    }

    public Criteria andCityCodeIsNotNull() {
      addCriterion("city_code is not null");
      return (Criteria) this;
    }

    public Criteria andCityCodeEqualTo(String value) {
      addCriterion("city_code =", value, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeNotEqualTo(String value) {
      addCriterion("city_code <>", value, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeGreaterThan(String value) {
      addCriterion("city_code >", value, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
      addCriterion("city_code >=", value, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeLessThan(String value) {
      addCriterion("city_code <", value, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeLessThanOrEqualTo(String value) {
      addCriterion("city_code <=", value, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeLike(String value) {
      addCriterion("city_code like", value, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeNotLike(String value) {
      addCriterion("city_code not like", value, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeIn(List<String> values) {
      addCriterion("city_code in", values, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeNotIn(List<String> values) {
      addCriterion("city_code not in", values, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeBetween(String value1, String value2) {
      addCriterion("city_code between", value1, value2, "cityCode");
      return (Criteria) this;
    }

    public Criteria andCityCodeNotBetween(String value1, String value2) {
      addCriterion("city_code not between", value1, value2, "cityCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeIsNull() {
      addCriterion("area_code is null");
      return (Criteria) this;
    }

    public Criteria andAreaCodeIsNotNull() {
      addCriterion("area_code is not null");
      return (Criteria) this;
    }

    public Criteria andAreaCodeEqualTo(String value) {
      addCriterion("area_code =", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeNotEqualTo(String value) {
      addCriterion("area_code <>", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeGreaterThan(String value) {
      addCriterion("area_code >", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
      addCriterion("area_code >=", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeLessThan(String value) {
      addCriterion("area_code <", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeLessThanOrEqualTo(String value) {
      addCriterion("area_code <=", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeLike(String value) {
      addCriterion("area_code like", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeNotLike(String value) {
      addCriterion("area_code not like", value, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeIn(List<String> values) {
      addCriterion("area_code in", values, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeNotIn(List<String> values) {
      addCriterion("area_code not in", values, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeBetween(String value1, String value2) {
      addCriterion("area_code between", value1, value2, "areaCode");
      return (Criteria) this;
    }

    public Criteria andAreaCodeNotBetween(String value1, String value2) {
      addCriterion("area_code not between", value1, value2, "areaCode");
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
