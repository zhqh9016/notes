package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsuredInfoDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public InsuredInfoDOExample() {
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

    public Criteria andInsuredPersonidEqualTo(Long value) {
      addCriterion("insured_personid =", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidNotEqualTo(Long value) {
      addCriterion("insured_personid <>", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidGreaterThan(Long value) {
      addCriterion("insured_personid >", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidGreaterThanOrEqualTo(Long value) {
      addCriterion("insured_personid >=", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidLessThan(Long value) {
      addCriterion("insured_personid <", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidLessThanOrEqualTo(Long value) {
      addCriterion("insured_personid <=", value, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidIn(List<Long> values) {
      addCriterion("insured_personid in", values, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidNotIn(List<Long> values) {
      addCriterion("insured_personid not in", values, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidBetween(Long value1, Long value2) {
      addCriterion("insured_personid between", value1, value2, "insuredPersonid");
      return (Criteria) this;
    }

    public Criteria andInsuredPersonidNotBetween(Long value1, Long value2) {
      addCriterion("insured_personid not between", value1, value2, "insuredPersonid");
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
