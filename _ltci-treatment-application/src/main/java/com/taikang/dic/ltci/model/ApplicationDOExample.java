package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public ApplicationDOExample() {
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

    public Criteria andApplicationidIsNull() {
      addCriterion("applicationid is null");
      return (Criteria) this;
    }

    public Criteria andApplicationidIsNotNull() {
      addCriterion("applicationid is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationidEqualTo(String value) {
      addCriterion("applicationid =", value, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidNotEqualTo(String value) {
      addCriterion("applicationid <>", value, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidGreaterThan(String value) {
      addCriterion("applicationid >", value, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidGreaterThanOrEqualTo(String value) {
      addCriterion("applicationid >=", value, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidLessThan(String value) {
      addCriterion("applicationid <", value, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidLessThanOrEqualTo(String value) {
      addCriterion("applicationid <=", value, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidLike(String value) {
      addCriterion("applicationid like", value, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidNotLike(String value) {
      addCriterion("applicationid not like", value, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidIn(List<String> values) {
      addCriterion("applicationid in", values, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidNotIn(List<String> values) {
      addCriterion("applicationid not in", values, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidBetween(String value1, String value2) {
      addCriterion("applicationid between", value1, value2, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationidNotBetween(String value1, String value2) {
      addCriterion("applicationid not between", value1, value2, "applicationid");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeIsNull() {
      addCriterion("application_code is null");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeIsNotNull() {
      addCriterion("application_code is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeEqualTo(String value) {
      addCriterion("application_code =", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeNotEqualTo(String value) {
      addCriterion("application_code <>", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeGreaterThan(String value) {
      addCriterion("application_code >", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeGreaterThanOrEqualTo(String value) {
      addCriterion("application_code >=", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeLessThan(String value) {
      addCriterion("application_code <", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeLessThanOrEqualTo(String value) {
      addCriterion("application_code <=", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeLike(String value) {
      addCriterion("application_code like", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeNotLike(String value) {
      addCriterion("application_code not like", value, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeIn(List<String> values) {
      addCriterion("application_code in", values, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeNotIn(List<String> values) {
      addCriterion("application_code not in", values, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeBetween(String value1, String value2) {
      addCriterion("application_code between", value1, value2, "applicationCode");
      return (Criteria) this;
    }

    public Criteria andApplicationCodeNotBetween(String value1, String value2) {
      addCriterion("application_code not between", value1, value2, "applicationCode");
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

    public Criteria andDeputyIdTypeIsNull() {
      addCriterion("deputy_id_type is null");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeIsNotNull() {
      addCriterion("deputy_id_type is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeEqualTo(String value) {
      addCriterion("deputy_id_type =", value, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeNotEqualTo(String value) {
      addCriterion("deputy_id_type <>", value, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeGreaterThan(String value) {
      addCriterion("deputy_id_type >", value, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_id_type >=", value, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeLessThan(String value) {
      addCriterion("deputy_id_type <", value, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeLessThanOrEqualTo(String value) {
      addCriterion("deputy_id_type <=", value, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeLike(String value) {
      addCriterion("deputy_id_type like", value, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeNotLike(String value) {
      addCriterion("deputy_id_type not like", value, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeIn(List<String> values) {
      addCriterion("deputy_id_type in", values, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeNotIn(List<String> values) {
      addCriterion("deputy_id_type not in", values, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeBetween(String value1, String value2) {
      addCriterion("deputy_id_type between", value1, value2, "deputyIdType");
      return (Criteria) this;
    }

    public Criteria andDeputyIdTypeNotBetween(String value1, String value2) {
      addCriterion("deputy_id_type not between", value1, value2, "deputyIdType");
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

    public Criteria andDeputyAddressIsNull() {
      addCriterion("deputy_address is null");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressIsNotNull() {
      addCriterion("deputy_address is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressEqualTo(String value) {
      addCriterion("deputy_address =", value, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressNotEqualTo(String value) {
      addCriterion("deputy_address <>", value, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressGreaterThan(String value) {
      addCriterion("deputy_address >", value, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressGreaterThanOrEqualTo(String value) {
      addCriterion("deputy_address >=", value, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressLessThan(String value) {
      addCriterion("deputy_address <", value, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressLessThanOrEqualTo(String value) {
      addCriterion("deputy_address <=", value, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressLike(String value) {
      addCriterion("deputy_address like", value, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressNotLike(String value) {
      addCriterion("deputy_address not like", value, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressIn(List<String> values) {
      addCriterion("deputy_address in", values, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressNotIn(List<String> values) {
      addCriterion("deputy_address not in", values, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressBetween(String value1, String value2) {
      addCriterion("deputy_address between", value1, value2, "deputyAddress");
      return (Criteria) this;
    }

    public Criteria andDeputyAddressNotBetween(String value1, String value2) {
      addCriterion("deputy_address not between", value1, value2, "deputyAddress");
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

    public Criteria andBidTypeIsNull() {
      addCriterion("bid_type is null");
      return (Criteria) this;
    }

    public Criteria andBidTypeIsNotNull() {
      addCriterion("bid_type is not null");
      return (Criteria) this;
    }

    public Criteria andBidTypeEqualTo(String value) {
      addCriterion("bid_type =", value, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeNotEqualTo(String value) {
      addCriterion("bid_type <>", value, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeGreaterThan(String value) {
      addCriterion("bid_type >", value, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeGreaterThanOrEqualTo(String value) {
      addCriterion("bid_type >=", value, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeLessThan(String value) {
      addCriterion("bid_type <", value, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeLessThanOrEqualTo(String value) {
      addCriterion("bid_type <=", value, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeLike(String value) {
      addCriterion("bid_type like", value, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeNotLike(String value) {
      addCriterion("bid_type not like", value, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeIn(List<String> values) {
      addCriterion("bid_type in", values, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeNotIn(List<String> values) {
      addCriterion("bid_type not in", values, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeBetween(String value1, String value2) {
      addCriterion("bid_type between", value1, value2, "bidType");
      return (Criteria) this;
    }

    public Criteria andBidTypeNotBetween(String value1, String value2) {
      addCriterion("bid_type not between", value1, value2, "bidType");
      return (Criteria) this;
    }

    public Criteria andDiseaseIsNull() {
      addCriterion("disease is null");
      return (Criteria) this;
    }

    public Criteria andDiseaseIsNotNull() {
      addCriterion("disease is not null");
      return (Criteria) this;
    }

    public Criteria andDiseaseEqualTo(String value) {
      addCriterion("disease =", value, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseNotEqualTo(String value) {
      addCriterion("disease <>", value, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseGreaterThan(String value) {
      addCriterion("disease >", value, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseGreaterThanOrEqualTo(String value) {
      addCriterion("disease >=", value, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseLessThan(String value) {
      addCriterion("disease <", value, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseLessThanOrEqualTo(String value) {
      addCriterion("disease <=", value, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseLike(String value) {
      addCriterion("disease like", value, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseNotLike(String value) {
      addCriterion("disease not like", value, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseIn(List<String> values) {
      addCriterion("disease in", values, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseNotIn(List<String> values) {
      addCriterion("disease not in", values, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseBetween(String value1, String value2) {
      addCriterion("disease between", value1, value2, "disease");
      return (Criteria) this;
    }

    public Criteria andDiseaseNotBetween(String value1, String value2) {
      addCriterion("disease not between", value1, value2, "disease");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineIsNull() {
      addCriterion("is_task_deadline is null");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineIsNotNull() {
      addCriterion("is_task_deadline is not null");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineEqualTo(String value) {
      addCriterion("is_task_deadline =", value, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineNotEqualTo(String value) {
      addCriterion("is_task_deadline <>", value, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineGreaterThan(String value) {
      addCriterion("is_task_deadline >", value, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineGreaterThanOrEqualTo(String value) {
      addCriterion("is_task_deadline >=", value, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineLessThan(String value) {
      addCriterion("is_task_deadline <", value, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineLessThanOrEqualTo(String value) {
      addCriterion("is_task_deadline <=", value, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineLike(String value) {
      addCriterion("is_task_deadline like", value, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineNotLike(String value) {
      addCriterion("is_task_deadline not like", value, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineIn(List<String> values) {
      addCriterion("is_task_deadline in", values, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineNotIn(List<String> values) {
      addCriterion("is_task_deadline not in", values, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineBetween(String value1, String value2) {
      addCriterion("is_task_deadline between", value1, value2, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsTaskDeadlineNotBetween(String value1, String value2) {
      addCriterion("is_task_deadline not between", value1, value2, "isTaskDeadline");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredIsNull() {
      addCriterion("is_relative_cared is null");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredIsNotNull() {
      addCriterion("is_relative_cared is not null");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredEqualTo(String value) {
      addCriterion("is_relative_cared =", value, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredNotEqualTo(String value) {
      addCriterion("is_relative_cared <>", value, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredGreaterThan(String value) {
      addCriterion("is_relative_cared >", value, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredGreaterThanOrEqualTo(String value) {
      addCriterion("is_relative_cared >=", value, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredLessThan(String value) {
      addCriterion("is_relative_cared <", value, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredLessThanOrEqualTo(String value) {
      addCriterion("is_relative_cared <=", value, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredLike(String value) {
      addCriterion("is_relative_cared like", value, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredNotLike(String value) {
      addCriterion("is_relative_cared not like", value, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredIn(List<String> values) {
      addCriterion("is_relative_cared in", values, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredNotIn(List<String> values) {
      addCriterion("is_relative_cared not in", values, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredBetween(String value1, String value2) {
      addCriterion("is_relative_cared between", value1, value2, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andIsRelativeCaredNotBetween(String value1, String value2) {
      addCriterion("is_relative_cared not between", value1, value2, "isRelativeCared");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseIsNull() {
      addCriterion("disease_cause is null");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseIsNotNull() {
      addCriterion("disease_cause is not null");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseEqualTo(String value) {
      addCriterion("disease_cause =", value, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseNotEqualTo(String value) {
      addCriterion("disease_cause <>", value, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseGreaterThan(String value) {
      addCriterion("disease_cause >", value, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseGreaterThanOrEqualTo(String value) {
      addCriterion("disease_cause >=", value, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseLessThan(String value) {
      addCriterion("disease_cause <", value, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseLessThanOrEqualTo(String value) {
      addCriterion("disease_cause <=", value, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseLike(String value) {
      addCriterion("disease_cause like", value, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseNotLike(String value) {
      addCriterion("disease_cause not like", value, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseIn(List<String> values) {
      addCriterion("disease_cause in", values, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseNotIn(List<String> values) {
      addCriterion("disease_cause not in", values, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseBetween(String value1, String value2) {
      addCriterion("disease_cause between", value1, value2, "diseaseCause");
      return (Criteria) this;
    }

    public Criteria andDiseaseCauseNotBetween(String value1, String value2) {
      addCriterion("disease_cause not between", value1, value2, "diseaseCause");
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

    public Criteria andSourcesIsNull() {
      addCriterion("sources is null");
      return (Criteria) this;
    }

    public Criteria andSourcesIsNotNull() {
      addCriterion("sources is not null");
      return (Criteria) this;
    }

    public Criteria andSourcesEqualTo(String value) {
      addCriterion("sources =", value, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesNotEqualTo(String value) {
      addCriterion("sources <>", value, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesGreaterThan(String value) {
      addCriterion("sources >", value, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesGreaterThanOrEqualTo(String value) {
      addCriterion("sources >=", value, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesLessThan(String value) {
      addCriterion("sources <", value, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesLessThanOrEqualTo(String value) {
      addCriterion("sources <=", value, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesLike(String value) {
      addCriterion("sources like", value, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesNotLike(String value) {
      addCriterion("sources not like", value, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesIn(List<String> values) {
      addCriterion("sources in", values, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesNotIn(List<String> values) {
      addCriterion("sources not in", values, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesBetween(String value1, String value2) {
      addCriterion("sources between", value1, value2, "sources");
      return (Criteria) this;
    }

    public Criteria andSourcesNotBetween(String value1, String value2) {
      addCriterion("sources not between", value1, value2, "sources");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusIsNull() {
      addCriterion("application_status is null");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusIsNotNull() {
      addCriterion("application_status is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusEqualTo(String value) {
      addCriterion("application_status =", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusNotEqualTo(String value) {
      addCriterion("application_status <>", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusGreaterThan(String value) {
      addCriterion("application_status >", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusGreaterThanOrEqualTo(String value) {
      addCriterion("application_status >=", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusLessThan(String value) {
      addCriterion("application_status <", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusLessThanOrEqualTo(String value) {
      addCriterion("application_status <=", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusLike(String value) {
      addCriterion("application_status like", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusNotLike(String value) {
      addCriterion("application_status not like", value, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusIn(List<String> values) {
      addCriterion("application_status in", values, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusNotIn(List<String> values) {
      addCriterion("application_status not in", values, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusBetween(String value1, String value2) {
      addCriterion("application_status between", value1, value2, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationStatusNotBetween(String value1, String value2) {
      addCriterion("application_status not between", value1, value2, "applicationStatus");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonIsNull() {
      addCriterion("application_reason is null");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonIsNotNull() {
      addCriterion("application_reason is not null");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonEqualTo(String value) {
      addCriterion("application_reason =", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonNotEqualTo(String value) {
      addCriterion("application_reason <>", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonGreaterThan(String value) {
      addCriterion("application_reason >", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonGreaterThanOrEqualTo(String value) {
      addCriterion("application_reason >=", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonLessThan(String value) {
      addCriterion("application_reason <", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonLessThanOrEqualTo(String value) {
      addCriterion("application_reason <=", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonLike(String value) {
      addCriterion("application_reason like", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonNotLike(String value) {
      addCriterion("application_reason not like", value, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonIn(List<String> values) {
      addCriterion("application_reason in", values, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonNotIn(List<String> values) {
      addCriterion("application_reason not in", values, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonBetween(String value1, String value2) {
      addCriterion("application_reason between", value1, value2, "applicationReason");
      return (Criteria) this;
    }

    public Criteria andApplicationReasonNotBetween(String value1, String value2) {
      addCriterion("application_reason not between", value1, value2, "applicationReason");
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
