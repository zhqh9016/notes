package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeputyBindingDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public DeputyBindingDOExample() {
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

    public Criteria andDeputyBindingidIsNull() {
      addCriterion("deputy_bindingid is null");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidIsNotNull() {
      addCriterion("deputy_bindingid is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidEqualTo(String value) {
      addCriterion("deputy_bindingid =", value, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidNotEqualTo(String value) {
      addCriterion("deputy_bindingid <>", value, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidGreaterThan(String value) {
      addCriterion("deputy_bindingid >", value, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_bindingid >=", value, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidLessThan(String value) {
      addCriterion("deputy_bindingid <", value, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidLessThanOrEqualTo(String value) {
      addCriterion("deputy_bindingid <=", value, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidLike(String value) {
      addCriterion("deputy_bindingid like", value, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidNotLike(String value) {
      addCriterion("deputy_bindingid not like", value, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidIn(List<String> values) {
      addCriterion("deputy_bindingid in", values, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidNotIn(List<String> values) {
      addCriterion("deputy_bindingid not in", values, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidBetween(String value1, String value2) {
      addCriterion("deputy_bindingid between", value1, value2, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingidNotBetween(String value1, String value2) {
      addCriterion("deputy_bindingid not between", value1, value2, "deputyBindingid");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeIsNull() {
      addCriterion("deputy_binding_code is null");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeIsNotNull() {
      addCriterion("deputy_binding_code is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeEqualTo(String value) {
      addCriterion("deputy_binding_code =", value, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeNotEqualTo(String value) {
      addCriterion("deputy_binding_code <>", value, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeGreaterThan(String value) {
      addCriterion("deputy_binding_code >", value, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_binding_code >=", value, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeLessThan(String value) {
      addCriterion("deputy_binding_code <", value, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeLessThanOrEqualTo(String value) {
      addCriterion("deputy_binding_code <=", value, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeLike(String value) {
      addCriterion("deputy_binding_code like", value, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeNotLike(String value) {
      addCriterion("deputy_binding_code not like", value, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeIn(List<String> values) {
      addCriterion("deputy_binding_code in", values, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeNotIn(List<String> values) {
      addCriterion("deputy_binding_code not in", values, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeBetween(String value1, String value2) {
      addCriterion("deputy_binding_code between", value1, value2, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andDeputyBindingCodeNotBetween(String value1, String value2) {
      addCriterion("deputy_binding_code not between", value1, value2, "deputyBindingCode");
      return (Criteria) this;
    }

    public Criteria andSerialNumberIsNull() {
      addCriterion("serial_number is null");
      return (Criteria) this;
    }

    public Criteria andSerialNumberIsNotNull() {
      addCriterion("serial_number is not null");
      return (Criteria) this;
    }

    public Criteria andSerialNumberEqualTo(String value) {
      addCriterion("serial_number =", value, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberNotEqualTo(String value) {
      addCriterion("serial_number <>", value, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberGreaterThan(String value) {
      addCriterion("serial_number >", value, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
      addCriterion("serial_number >=", value, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberLessThan(String value) {
      addCriterion("serial_number <", value, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberLessThanOrEqualTo(String value) {
      addCriterion("serial_number <=", value, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberLike(String value) {
      addCriterion("serial_number like", value, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberNotLike(String value) {
      addCriterion("serial_number not like", value, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberIn(List<String> values) {
      addCriterion("serial_number in", values, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberNotIn(List<String> values) {
      addCriterion("serial_number not in", values, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberBetween(String value1, String value2) {
      addCriterion("serial_number between", value1, value2, "serialNumber");
      return (Criteria) this;
    }

    public Criteria andSerialNumberNotBetween(String value1, String value2) {
      addCriterion("serial_number not between", value1, value2, "serialNumber");
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

    public Criteria andDeputyIdCardScanIsNull() {
      addCriterion("deputy_id_card_scan is null");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanIsNotNull() {
      addCriterion("deputy_id_card_scan is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanEqualTo(String value) {
      addCriterion("deputy_id_card_scan =", value, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanNotEqualTo(String value) {
      addCriterion("deputy_id_card_scan <>", value, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanGreaterThan(String value) {
      addCriterion("deputy_id_card_scan >", value, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_id_card_scan >=", value, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanLessThan(String value) {
      addCriterion("deputy_id_card_scan <", value, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanLessThanOrEqualTo(String value) {
      addCriterion("deputy_id_card_scan <=", value, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanLike(String value) {
      addCriterion("deputy_id_card_scan like", value, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanNotLike(String value) {
      addCriterion("deputy_id_card_scan not like", value, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanIn(List<String> values) {
      addCriterion("deputy_id_card_scan in", values, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanNotIn(List<String> values) {
      addCriterion("deputy_id_card_scan not in", values, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanBetween(String value1, String value2) {
      addCriterion("deputy_id_card_scan between", value1, value2, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andDeputyIdCardScanNotBetween(String value1, String value2) {
      addCriterion("deputy_id_card_scan not between", value1, value2, "deputyIdCardScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanIsNull() {
      addCriterion("security_number_scan is null");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanIsNotNull() {
      addCriterion("security_number_scan is not null");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanEqualTo(String value) {
      addCriterion("security_number_scan =", value, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanNotEqualTo(String value) {
      addCriterion("security_number_scan <>", value, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanGreaterThan(String value) {
      addCriterion("security_number_scan >", value, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanGreaterThanOrEqualTo(String value) {
      addCriterion("security_number_scan >=", value, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanLessThan(String value) {
      addCriterion("security_number_scan <", value, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanLessThanOrEqualTo(String value) {
      addCriterion("security_number_scan <=", value, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanLike(String value) {
      addCriterion("security_number_scan like", value, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanNotLike(String value) {
      addCriterion("security_number_scan not like", value, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanIn(List<String> values) {
      addCriterion("security_number_scan in", values, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanNotIn(List<String> values) {
      addCriterion("security_number_scan not in", values, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanBetween(String value1, String value2) {
      addCriterion("security_number_scan between", value1, value2, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andSecurityNumberScanNotBetween(String value1, String value2) {
      addCriterion("security_number_scan not between", value1, value2, "securityNumberScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanIsNull() {
      addCriterion("id_card_scan is null");
      return (Criteria) this;
    }

    public Criteria andIdCardScanIsNotNull() {
      addCriterion("id_card_scan is not null");
      return (Criteria) this;
    }

    public Criteria andIdCardScanEqualTo(String value) {
      addCriterion("id_card_scan =", value, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanNotEqualTo(String value) {
      addCriterion("id_card_scan <>", value, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanGreaterThan(String value) {
      addCriterion("id_card_scan >", value, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanGreaterThanOrEqualTo(String value) {
      addCriterion("id_card_scan >=", value, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanLessThan(String value) {
      addCriterion("id_card_scan <", value, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanLessThanOrEqualTo(String value) {
      addCriterion("id_card_scan <=", value, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanLike(String value) {
      addCriterion("id_card_scan like", value, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanNotLike(String value) {
      addCriterion("id_card_scan not like", value, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanIn(List<String> values) {
      addCriterion("id_card_scan in", values, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanNotIn(List<String> values) {
      addCriterion("id_card_scan not in", values, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanBetween(String value1, String value2) {
      addCriterion("id_card_scan between", value1, value2, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andIdCardScanNotBetween(String value1, String value2) {
      addCriterion("id_card_scan not between", value1, value2, "idCardScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanIsNull() {
      addCriterion("case_history_scan is null");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanIsNotNull() {
      addCriterion("case_history_scan is not null");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanEqualTo(String value) {
      addCriterion("case_history_scan =", value, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanNotEqualTo(String value) {
      addCriterion("case_history_scan <>", value, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanGreaterThan(String value) {
      addCriterion("case_history_scan >", value, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanGreaterThanOrEqualTo(String value) {
      addCriterion("case_history_scan >=", value, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanLessThan(String value) {
      addCriterion("case_history_scan <", value, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanLessThanOrEqualTo(String value) {
      addCriterion("case_history_scan <=", value, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanLike(String value) {
      addCriterion("case_history_scan like", value, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanNotLike(String value) {
      addCriterion("case_history_scan not like", value, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanIn(List<String> values) {
      addCriterion("case_history_scan in", values, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanNotIn(List<String> values) {
      addCriterion("case_history_scan not in", values, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanBetween(String value1, String value2) {
      addCriterion("case_history_scan between", value1, value2, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andCaseHistoryScanNotBetween(String value1, String value2) {
      addCriterion("case_history_scan not between", value1, value2, "caseHistoryScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanIsNull() {
      addCriterion("application_form_scan is null");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanIsNotNull() {
      addCriterion("application_form_scan is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanEqualTo(String value) {
      addCriterion("application_form_scan =", value, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanNotEqualTo(String value) {
      addCriterion("application_form_scan <>", value, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanGreaterThan(String value) {
      addCriterion("application_form_scan >", value, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanGreaterThanOrEqualTo(String value) {
      addCriterion("application_form_scan >=", value, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanLessThan(String value) {
      addCriterion("application_form_scan <", value, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanLessThanOrEqualTo(String value) {
      addCriterion("application_form_scan <=", value, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanLike(String value) {
      addCriterion("application_form_scan like", value, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanNotLike(String value) {
      addCriterion("application_form_scan not like", value, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanIn(List<String> values) {
      addCriterion("application_form_scan in", values, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanNotIn(List<String> values) {
      addCriterion("application_form_scan not in", values, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanBetween(String value1, String value2) {
      addCriterion("application_form_scan between", value1, value2, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andApplicationFormScanNotBetween(String value1, String value2) {
      addCriterion("application_form_scan not between", value1, value2, "applicationFormScan");
      return (Criteria) this;
    }

    public Criteria andCheckStateIsNull() {
      addCriterion("check_state is null");
      return (Criteria) this;
    }

    public Criteria andCheckStateIsNotNull() {
      addCriterion("check_state is not null");
      return (Criteria) this;
    }

    public Criteria andCheckStateEqualTo(String value) {
      addCriterion("check_state =", value, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateNotEqualTo(String value) {
      addCriterion("check_state <>", value, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateGreaterThan(String value) {
      addCriterion("check_state >", value, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateGreaterThanOrEqualTo(String value) {
      addCriterion("check_state >=", value, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateLessThan(String value) {
      addCriterion("check_state <", value, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateLessThanOrEqualTo(String value) {
      addCriterion("check_state <=", value, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateLike(String value) {
      addCriterion("check_state like", value, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateNotLike(String value) {
      addCriterion("check_state not like", value, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateIn(List<String> values) {
      addCriterion("check_state in", values, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateNotIn(List<String> values) {
      addCriterion("check_state not in", values, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateBetween(String value1, String value2) {
      addCriterion("check_state between", value1, value2, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckStateNotBetween(String value1, String value2) {
      addCriterion("check_state not between", value1, value2, "checkState");
      return (Criteria) this;
    }

    public Criteria andCheckReasonIsNull() {
      addCriterion("check_reason is null");
      return (Criteria) this;
    }

    public Criteria andCheckReasonIsNotNull() {
      addCriterion("check_reason is not null");
      return (Criteria) this;
    }

    public Criteria andCheckReasonEqualTo(String value) {
      addCriterion("check_reason =", value, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonNotEqualTo(String value) {
      addCriterion("check_reason <>", value, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonGreaterThan(String value) {
      addCriterion("check_reason >", value, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonGreaterThanOrEqualTo(String value) {
      addCriterion("check_reason >=", value, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonLessThan(String value) {
      addCriterion("check_reason <", value, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonLessThanOrEqualTo(String value) {
      addCriterion("check_reason <=", value, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonLike(String value) {
      addCriterion("check_reason like", value, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonNotLike(String value) {
      addCriterion("check_reason not like", value, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonIn(List<String> values) {
      addCriterion("check_reason in", values, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonNotIn(List<String> values) {
      addCriterion("check_reason not in", values, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonBetween(String value1, String value2) {
      addCriterion("check_reason between", value1, value2, "checkReason");
      return (Criteria) this;
    }

    public Criteria andCheckReasonNotBetween(String value1, String value2) {
      addCriterion("check_reason not between", value1, value2, "checkReason");
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
