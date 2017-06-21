package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgencyDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public AgencyDOExample() {
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

    public Criteria andAgencyidIsNull() {
      addCriterion("agencyid is null");
      return (Criteria) this;
    }

    public Criteria andAgencyidIsNotNull() {
      addCriterion("agencyid is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyidEqualTo(String value) {
      addCriterion("agencyid =", value, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidNotEqualTo(String value) {
      addCriterion("agencyid <>", value, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidGreaterThan(String value) {
      addCriterion("agencyid >", value, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidGreaterThanOrEqualTo(String value) {
      addCriterion("agencyid >=", value, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidLessThan(String value) {
      addCriterion("agencyid <", value, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidLessThanOrEqualTo(String value) {
      addCriterion("agencyid <=", value, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidLike(String value) {
      addCriterion("agencyid like", value, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidNotLike(String value) {
      addCriterion("agencyid not like", value, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidIn(List<String> values) {
      addCriterion("agencyid in", values, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidNotIn(List<String> values) {
      addCriterion("agencyid not in", values, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidBetween(String value1, String value2) {
      addCriterion("agencyid between", value1, value2, "agencyid");
      return (Criteria) this;
    }

    public Criteria andAgencyidNotBetween(String value1, String value2) {
      addCriterion("agencyid not between", value1, value2, "agencyid");
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

    public Criteria andAgencyPhoneIsNull() {
      addCriterion("agency_phone is null");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneIsNotNull() {
      addCriterion("agency_phone is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneEqualTo(String value) {
      addCriterion("agency_phone =", value, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneNotEqualTo(String value) {
      addCriterion("agency_phone <>", value, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneGreaterThan(String value) {
      addCriterion("agency_phone >", value, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("agency_phone >=", value, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneLessThan(String value) {
      addCriterion("agency_phone <", value, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneLessThanOrEqualTo(String value) {
      addCriterion("agency_phone <=", value, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneLike(String value) {
      addCriterion("agency_phone like", value, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneNotLike(String value) {
      addCriterion("agency_phone not like", value, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneIn(List<String> values) {
      addCriterion("agency_phone in", values, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneNotIn(List<String> values) {
      addCriterion("agency_phone not in", values, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneBetween(String value1, String value2) {
      addCriterion("agency_phone between", value1, value2, "agencyPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyPhoneNotBetween(String value1, String value2) {
      addCriterion("agency_phone not between", value1, value2, "agencyPhone");
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

    public Criteria andAgencyAddressDetailIsNull() {
      addCriterion("agency_address_detail is null");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailIsNotNull() {
      addCriterion("agency_address_detail is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailEqualTo(String value) {
      addCriterion("agency_address_detail =", value, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailNotEqualTo(String value) {
      addCriterion("agency_address_detail <>", value, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailGreaterThan(String value) {
      addCriterion("agency_address_detail >", value, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailGreaterThanOrEqualTo(String value) {
      addCriterion("agency_address_detail >=", value, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailLessThan(String value) {
      addCriterion("agency_address_detail <", value, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailLessThanOrEqualTo(String value) {
      addCriterion("agency_address_detail <=", value, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailLike(String value) {
      addCriterion("agency_address_detail like", value, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailNotLike(String value) {
      addCriterion("agency_address_detail not like", value, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailIn(List<String> values) {
      addCriterion("agency_address_detail in", values, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailNotIn(List<String> values) {
      addCriterion("agency_address_detail not in", values, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailBetween(String value1, String value2) {
      addCriterion("agency_address_detail between", value1, value2, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andAgencyAddressDetailNotBetween(String value1, String value2) {
      addCriterion("agency_address_detail not between", value1, value2, "agencyAddressDetail");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyIsNull() {
      addCriterion("is_designated_agency is null");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyIsNotNull() {
      addCriterion("is_designated_agency is not null");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyEqualTo(Integer value) {
      addCriterion("is_designated_agency =", value, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyNotEqualTo(Integer value) {
      addCriterion("is_designated_agency <>", value, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyGreaterThan(Integer value) {
      addCriterion("is_designated_agency >", value, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyGreaterThanOrEqualTo(Integer value) {
      addCriterion("is_designated_agency >=", value, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyLessThan(Integer value) {
      addCriterion("is_designated_agency <", value, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyLessThanOrEqualTo(Integer value) {
      addCriterion("is_designated_agency <=", value, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyIn(List<Integer> values) {
      addCriterion("is_designated_agency in", values, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyNotIn(List<Integer> values) {
      addCriterion("is_designated_agency not in", values, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyBetween(Integer value1, Integer value2) {
      addCriterion("is_designated_agency between", value1, value2, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsDesignatedAgencyNotBetween(Integer value1, Integer value2) {
      addCriterion("is_designated_agency not between", value1, value2, "isDesignatedAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyIsNull() {
      addCriterion("is_nursing_agency is null");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyIsNotNull() {
      addCriterion("is_nursing_agency is not null");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyEqualTo(Integer value) {
      addCriterion("is_nursing_agency =", value, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyNotEqualTo(Integer value) {
      addCriterion("is_nursing_agency <>", value, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyGreaterThan(Integer value) {
      addCriterion("is_nursing_agency >", value, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyGreaterThanOrEqualTo(Integer value) {
      addCriterion("is_nursing_agency >=", value, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyLessThan(Integer value) {
      addCriterion("is_nursing_agency <", value, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyLessThanOrEqualTo(Integer value) {
      addCriterion("is_nursing_agency <=", value, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyIn(List<Integer> values) {
      addCriterion("is_nursing_agency in", values, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyNotIn(List<Integer> values) {
      addCriterion("is_nursing_agency not in", values, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyBetween(Integer value1, Integer value2) {
      addCriterion("is_nursing_agency between", value1, value2, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andIsNursingAgencyNotBetween(Integer value1, Integer value2) {
      addCriterion("is_nursing_agency not between", value1, value2, "isNursingAgency");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeIsNull() {
      addCriterion("agency_type is null");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeIsNotNull() {
      addCriterion("agency_type is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeEqualTo(Integer value) {
      addCriterion("agency_type =", value, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeNotEqualTo(Integer value) {
      addCriterion("agency_type <>", value, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeGreaterThan(Integer value) {
      addCriterion("agency_type >", value, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("agency_type >=", value, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeLessThan(Integer value) {
      addCriterion("agency_type <", value, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeLessThanOrEqualTo(Integer value) {
      addCriterion("agency_type <=", value, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeIn(List<Integer> values) {
      addCriterion("agency_type in", values, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeNotIn(List<Integer> values) {
      addCriterion("agency_type not in", values, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeBetween(Integer value1, Integer value2) {
      addCriterion("agency_type between", value1, value2, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("agency_type not between", value1, value2, "agencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelIsNull() {
      addCriterion("agency_level is null");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelIsNotNull() {
      addCriterion("agency_level is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelEqualTo(Integer value) {
      addCriterion("agency_level =", value, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelNotEqualTo(Integer value) {
      addCriterion("agency_level <>", value, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelGreaterThan(Integer value) {
      addCriterion("agency_level >", value, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelGreaterThanOrEqualTo(Integer value) {
      addCriterion("agency_level >=", value, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelLessThan(Integer value) {
      addCriterion("agency_level <", value, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelLessThanOrEqualTo(Integer value) {
      addCriterion("agency_level <=", value, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelIn(List<Integer> values) {
      addCriterion("agency_level in", values, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelNotIn(List<Integer> values) {
      addCriterion("agency_level not in", values, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelBetween(Integer value1, Integer value2) {
      addCriterion("agency_level between", value1, value2, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyLevelNotBetween(Integer value1, Integer value2) {
      addCriterion("agency_level not between", value1, value2, "agencyLevel");
      return (Criteria) this;
    }

    public Criteria andAgencyRankIsNull() {
      addCriterion("agency_rank is null");
      return (Criteria) this;
    }

    public Criteria andAgencyRankIsNotNull() {
      addCriterion("agency_rank is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyRankEqualTo(Integer value) {
      addCriterion("agency_rank =", value, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankNotEqualTo(Integer value) {
      addCriterion("agency_rank <>", value, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankGreaterThan(Integer value) {
      addCriterion("agency_rank >", value, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankGreaterThanOrEqualTo(Integer value) {
      addCriterion("agency_rank >=", value, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankLessThan(Integer value) {
      addCriterion("agency_rank <", value, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankLessThanOrEqualTo(Integer value) {
      addCriterion("agency_rank <=", value, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankIn(List<Integer> values) {
      addCriterion("agency_rank in", values, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankNotIn(List<Integer> values) {
      addCriterion("agency_rank not in", values, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankBetween(Integer value1, Integer value2) {
      addCriterion("agency_rank between", value1, value2, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andAgencyRankNotBetween(Integer value1, Integer value2) {
      addCriterion("agency_rank not between", value1, value2, "agencyRank");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeIsNull() {
      addCriterion("dsignated_agency_type is null");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeIsNotNull() {
      addCriterion("dsignated_agency_type is not null");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeEqualTo(String value) {
      addCriterion("dsignated_agency_type =", value, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeNotEqualTo(String value) {
      addCriterion("dsignated_agency_type <>", value, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeGreaterThan(String value) {
      addCriterion("dsignated_agency_type >", value, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeGreaterThanOrEqualTo(String value) {
      addCriterion("dsignated_agency_type >=", value, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeLessThan(String value) {
      addCriterion("dsignated_agency_type <", value, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeLessThanOrEqualTo(String value) {
      addCriterion("dsignated_agency_type <=", value, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeLike(String value) {
      addCriterion("dsignated_agency_type like", value, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeNotLike(String value) {
      addCriterion("dsignated_agency_type not like", value, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeIn(List<String> values) {
      addCriterion("dsignated_agency_type in", values, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeNotIn(List<String> values) {
      addCriterion("dsignated_agency_type not in", values, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeBetween(String value1, String value2) {
      addCriterion("dsignated_agency_type between", value1, value2, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andDsignatedAgencyTypeNotBetween(String value1, String value2) {
      addCriterion("dsignated_agency_type not between", value1, value2, "dsignatedAgencyType");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateIsNull() {
      addCriterion("agency_begin_date is null");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateIsNotNull() {
      addCriterion("agency_begin_date is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateEqualTo(Date value) {
      addCriterion("agency_begin_date =", value, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateNotEqualTo(Date value) {
      addCriterion("agency_begin_date <>", value, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateGreaterThan(Date value) {
      addCriterion("agency_begin_date >", value, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateGreaterThanOrEqualTo(Date value) {
      addCriterion("agency_begin_date >=", value, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateLessThan(Date value) {
      addCriterion("agency_begin_date <", value, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateLessThanOrEqualTo(Date value) {
      addCriterion("agency_begin_date <=", value, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateIn(List<Date> values) {
      addCriterion("agency_begin_date in", values, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateNotIn(List<Date> values) {
      addCriterion("agency_begin_date not in", values, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateBetween(Date value1, Date value2) {
      addCriterion("agency_begin_date between", value1, value2, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgencyBeginDateNotBetween(Date value1, Date value2) {
      addCriterion("agency_begin_date not between", value1, value2, "agencyBeginDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateIsNull() {
      addCriterion("agenct_end_date is null");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateIsNotNull() {
      addCriterion("agenct_end_date is not null");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateEqualTo(Date value) {
      addCriterion("agenct_end_date =", value, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateNotEqualTo(Date value) {
      addCriterion("agenct_end_date <>", value, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateGreaterThan(Date value) {
      addCriterion("agenct_end_date >", value, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateGreaterThanOrEqualTo(Date value) {
      addCriterion("agenct_end_date >=", value, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateLessThan(Date value) {
      addCriterion("agenct_end_date <", value, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateLessThanOrEqualTo(Date value) {
      addCriterion("agenct_end_date <=", value, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateIn(List<Date> values) {
      addCriterion("agenct_end_date in", values, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateNotIn(List<Date> values) {
      addCriterion("agenct_end_date not in", values, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateBetween(Date value1, Date value2) {
      addCriterion("agenct_end_date between", value1, value2, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andAgenctEndDateNotBetween(Date value1, Date value2) {
      addCriterion("agenct_end_date not between", value1, value2, "agenctEndDate");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormIsNull() {
      addCriterion("ownership_form is null");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormIsNotNull() {
      addCriterion("ownership_form is not null");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormEqualTo(Integer value) {
      addCriterion("ownership_form =", value, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormNotEqualTo(Integer value) {
      addCriterion("ownership_form <>", value, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormGreaterThan(Integer value) {
      addCriterion("ownership_form >", value, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormGreaterThanOrEqualTo(Integer value) {
      addCriterion("ownership_form >=", value, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormLessThan(Integer value) {
      addCriterion("ownership_form <", value, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormLessThanOrEqualTo(Integer value) {
      addCriterion("ownership_form <=", value, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormIn(List<Integer> values) {
      addCriterion("ownership_form in", values, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormNotIn(List<Integer> values) {
      addCriterion("ownership_form not in", values, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormBetween(Integer value1, Integer value2) {
      addCriterion("ownership_form between", value1, value2, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andOwnershipFormNotBetween(Integer value1, Integer value2) {
      addCriterion("ownership_form not between", value1, value2, "ownershipForm");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseIsNull() {
      addCriterion("practice_license is null");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseIsNotNull() {
      addCriterion("practice_license is not null");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseEqualTo(String value) {
      addCriterion("practice_license =", value, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseNotEqualTo(String value) {
      addCriterion("practice_license <>", value, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseGreaterThan(String value) {
      addCriterion("practice_license >", value, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseGreaterThanOrEqualTo(String value) {
      addCriterion("practice_license >=", value, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseLessThan(String value) {
      addCriterion("practice_license <", value, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseLessThanOrEqualTo(String value) {
      addCriterion("practice_license <=", value, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseLike(String value) {
      addCriterion("practice_license like", value, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseNotLike(String value) {
      addCriterion("practice_license not like", value, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseIn(List<String> values) {
      addCriterion("practice_license in", values, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseNotIn(List<String> values) {
      addCriterion("practice_license not in", values, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseBetween(String value1, String value2) {
      addCriterion("practice_license between", value1, value2, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andPracticeLicenseNotBetween(String value1, String value2) {
      addCriterion("practice_license not between", value1, value2, "practiceLicense");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeIsNull() {
      addCriterion("legal_representative is null");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeIsNotNull() {
      addCriterion("legal_representative is not null");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeEqualTo(String value) {
      addCriterion("legal_representative =", value, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeNotEqualTo(String value) {
      addCriterion("legal_representative <>", value, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeGreaterThan(String value) {
      addCriterion("legal_representative >", value, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeGreaterThanOrEqualTo(String value) {
      addCriterion("legal_representative >=", value, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeLessThan(String value) {
      addCriterion("legal_representative <", value, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeLessThanOrEqualTo(String value) {
      addCriterion("legal_representative <=", value, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeLike(String value) {
      addCriterion("legal_representative like", value, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeNotLike(String value) {
      addCriterion("legal_representative not like", value, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeIn(List<String> values) {
      addCriterion("legal_representative in", values, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeNotIn(List<String> values) {
      addCriterion("legal_representative not in", values, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeBetween(String value1, String value2) {
      addCriterion("legal_representative between", value1, value2, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalRepresentativeNotBetween(String value1, String value2) {
      addCriterion("legal_representative not between", value1, value2, "legalRepresentative");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeIsNull() {
      addCriterion("legal_papers_type is null");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeIsNotNull() {
      addCriterion("legal_papers_type is not null");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeEqualTo(String value) {
      addCriterion("legal_papers_type =", value, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeNotEqualTo(String value) {
      addCriterion("legal_papers_type <>", value, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeGreaterThan(String value) {
      addCriterion("legal_papers_type >", value, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeGreaterThanOrEqualTo(String value) {
      addCriterion("legal_papers_type >=", value, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeLessThan(String value) {
      addCriterion("legal_papers_type <", value, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeLessThanOrEqualTo(String value) {
      addCriterion("legal_papers_type <=", value, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeLike(String value) {
      addCriterion("legal_papers_type like", value, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeNotLike(String value) {
      addCriterion("legal_papers_type not like", value, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeIn(List<String> values) {
      addCriterion("legal_papers_type in", values, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeNotIn(List<String> values) {
      addCriterion("legal_papers_type not in", values, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeBetween(String value1, String value2) {
      addCriterion("legal_papers_type between", value1, value2, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalPapersTypeNotBetween(String value1, String value2) {
      addCriterion("legal_papers_type not between", value1, value2, "legalPapersType");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardIsNull() {
      addCriterion("legal_id_card is null");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardIsNotNull() {
      addCriterion("legal_id_card is not null");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardEqualTo(String value) {
      addCriterion("legal_id_card =", value, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardNotEqualTo(String value) {
      addCriterion("legal_id_card <>", value, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardGreaterThan(String value) {
      addCriterion("legal_id_card >", value, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardGreaterThanOrEqualTo(String value) {
      addCriterion("legal_id_card >=", value, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardLessThan(String value) {
      addCriterion("legal_id_card <", value, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardLessThanOrEqualTo(String value) {
      addCriterion("legal_id_card <=", value, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardLike(String value) {
      addCriterion("legal_id_card like", value, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardNotLike(String value) {
      addCriterion("legal_id_card not like", value, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardIn(List<String> values) {
      addCriterion("legal_id_card in", values, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardNotIn(List<String> values) {
      addCriterion("legal_id_card not in", values, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardBetween(String value1, String value2) {
      addCriterion("legal_id_card between", value1, value2, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalIdCardNotBetween(String value1, String value2) {
      addCriterion("legal_id_card not between", value1, value2, "legalIdCard");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateIsNull() {
      addCriterion("legal_papers_validity_date is null");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateIsNotNull() {
      addCriterion("legal_papers_validity_date is not null");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateEqualTo(Date value) {
      addCriterion("legal_papers_validity_date =", value, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateNotEqualTo(Date value) {
      addCriterion("legal_papers_validity_date <>", value, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateGreaterThan(Date value) {
      addCriterion("legal_papers_validity_date >", value, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateGreaterThanOrEqualTo(Date value) {
      addCriterion("legal_papers_validity_date >=", value, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateLessThan(Date value) {
      addCriterion("legal_papers_validity_date <", value, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateLessThanOrEqualTo(Date value) {
      addCriterion("legal_papers_validity_date <=", value, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateIn(List<Date> values) {
      addCriterion("legal_papers_validity_date in", values, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateNotIn(List<Date> values) {
      addCriterion("legal_papers_validity_date not in", values, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateBetween(Date value1, Date value2) {
      addCriterion("legal_papers_validity_date between", value1, value2, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPapersValidityDateNotBetween(Date value1, Date value2) {
      addCriterion(
          "legal_papers_validity_date not between", value1, value2, "legalPapersValidityDate");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoIsNull() {
      addCriterion("legal_phone_no is null");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoIsNotNull() {
      addCriterion("legal_phone_no is not null");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoEqualTo(String value) {
      addCriterion("legal_phone_no =", value, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoNotEqualTo(String value) {
      addCriterion("legal_phone_no <>", value, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoGreaterThan(String value) {
      addCriterion("legal_phone_no >", value, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoGreaterThanOrEqualTo(String value) {
      addCriterion("legal_phone_no >=", value, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoLessThan(String value) {
      addCriterion("legal_phone_no <", value, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoLessThanOrEqualTo(String value) {
      addCriterion("legal_phone_no <=", value, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoLike(String value) {
      addCriterion("legal_phone_no like", value, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoNotLike(String value) {
      addCriterion("legal_phone_no not like", value, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoIn(List<String> values) {
      addCriterion("legal_phone_no in", values, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoNotIn(List<String> values) {
      addCriterion("legal_phone_no not in", values, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoBetween(String value1, String value2) {
      addCriterion("legal_phone_no between", value1, value2, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andLegalPhoneNoNotBetween(String value1, String value2) {
      addCriterion("legal_phone_no not between", value1, value2, "legalPhoneNo");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacIsNull() {
      addCriterion("agency_service_contac is null");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacIsNotNull() {
      addCriterion("agency_service_contac is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacEqualTo(String value) {
      addCriterion("agency_service_contac =", value, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacNotEqualTo(String value) {
      addCriterion("agency_service_contac <>", value, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacGreaterThan(String value) {
      addCriterion("agency_service_contac >", value, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacGreaterThanOrEqualTo(String value) {
      addCriterion("agency_service_contac >=", value, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacLessThan(String value) {
      addCriterion("agency_service_contac <", value, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacLessThanOrEqualTo(String value) {
      addCriterion("agency_service_contac <=", value, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacLike(String value) {
      addCriterion("agency_service_contac like", value, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacNotLike(String value) {
      addCriterion("agency_service_contac not like", value, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacIn(List<String> values) {
      addCriterion("agency_service_contac in", values, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacNotIn(List<String> values) {
      addCriterion("agency_service_contac not in", values, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacBetween(String value1, String value2) {
      addCriterion("agency_service_contac between", value1, value2, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyServiceContacNotBetween(String value1, String value2) {
      addCriterion("agency_service_contac not between", value1, value2, "agencyServiceContac");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneIsNull() {
      addCriterion("agency_contact_phone is null");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneIsNotNull() {
      addCriterion("agency_contact_phone is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneEqualTo(String value) {
      addCriterion("agency_contact_phone =", value, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneNotEqualTo(String value) {
      addCriterion("agency_contact_phone <>", value, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneGreaterThan(String value) {
      addCriterion("agency_contact_phone >", value, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("agency_contact_phone >=", value, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneLessThan(String value) {
      addCriterion("agency_contact_phone <", value, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneLessThanOrEqualTo(String value) {
      addCriterion("agency_contact_phone <=", value, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneLike(String value) {
      addCriterion("agency_contact_phone like", value, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneNotLike(String value) {
      addCriterion("agency_contact_phone not like", value, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneIn(List<String> values) {
      addCriterion("agency_contact_phone in", values, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneNotIn(List<String> values) {
      addCriterion("agency_contact_phone not in", values, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneBetween(String value1, String value2) {
      addCriterion("agency_contact_phone between", value1, value2, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactPhoneNotBetween(String value1, String value2) {
      addCriterion("agency_contact_phone not between", value1, value2, "agencyContactPhone");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailIsNull() {
      addCriterion("agency_contact_email is null");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailIsNotNull() {
      addCriterion("agency_contact_email is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailEqualTo(String value) {
      addCriterion("agency_contact_email =", value, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailNotEqualTo(String value) {
      addCriterion("agency_contact_email <>", value, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailGreaterThan(String value) {
      addCriterion("agency_contact_email >", value, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailGreaterThanOrEqualTo(String value) {
      addCriterion("agency_contact_email >=", value, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailLessThan(String value) {
      addCriterion("agency_contact_email <", value, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailLessThanOrEqualTo(String value) {
      addCriterion("agency_contact_email <=", value, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailLike(String value) {
      addCriterion("agency_contact_email like", value, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailNotLike(String value) {
      addCriterion("agency_contact_email not like", value, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailIn(List<String> values) {
      addCriterion("agency_contact_email in", values, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailNotIn(List<String> values) {
      addCriterion("agency_contact_email not in", values, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailBetween(String value1, String value2) {
      addCriterion("agency_contact_email between", value1, value2, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyContactEmailNotBetween(String value1, String value2) {
      addCriterion("agency_contact_email not between", value1, value2, "agencyContactEmail");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumIsNull() {
      addCriterion("agency_bed_num is null");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumIsNotNull() {
      addCriterion("agency_bed_num is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumEqualTo(Integer value) {
      addCriterion("agency_bed_num =", value, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumNotEqualTo(Integer value) {
      addCriterion("agency_bed_num <>", value, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumGreaterThan(Integer value) {
      addCriterion("agency_bed_num >", value, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("agency_bed_num >=", value, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumLessThan(Integer value) {
      addCriterion("agency_bed_num <", value, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumLessThanOrEqualTo(Integer value) {
      addCriterion("agency_bed_num <=", value, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumIn(List<Integer> values) {
      addCriterion("agency_bed_num in", values, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumNotIn(List<Integer> values) {
      addCriterion("agency_bed_num not in", values, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumBetween(Integer value1, Integer value2) {
      addCriterion("agency_bed_num between", value1, value2, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andAgencyBedNumNotBetween(Integer value1, Integer value2) {
      addCriterion("agency_bed_num not between", value1, value2, "agencyBedNum");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaIsNull() {
      addCriterion("construction_area is null");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaIsNotNull() {
      addCriterion("construction_area is not null");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaEqualTo(Double value) {
      addCriterion("construction_area =", value, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaNotEqualTo(Double value) {
      addCriterion("construction_area <>", value, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaGreaterThan(Double value) {
      addCriterion("construction_area >", value, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaGreaterThanOrEqualTo(Double value) {
      addCriterion("construction_area >=", value, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaLessThan(Double value) {
      addCriterion("construction_area <", value, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaLessThanOrEqualTo(Double value) {
      addCriterion("construction_area <=", value, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaIn(List<Double> values) {
      addCriterion("construction_area in", values, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaNotIn(List<Double> values) {
      addCriterion("construction_area not in", values, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaBetween(Double value1, Double value2) {
      addCriterion("construction_area between", value1, value2, "constructionArea");
      return (Criteria) this;
    }

    public Criteria andConstructionAreaNotBetween(Double value1, Double value2) {
      addCriterion("construction_area not between", value1, value2, "constructionArea");
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

    public Criteria andSecretKeyIsNull() {
      addCriterion("secret_key is null");
      return (Criteria) this;
    }

    public Criteria andSecretKeyIsNotNull() {
      addCriterion("secret_key is not null");
      return (Criteria) this;
    }

    public Criteria andSecretKeyEqualTo(String value) {
      addCriterion("secret_key =", value, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyNotEqualTo(String value) {
      addCriterion("secret_key <>", value, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyGreaterThan(String value) {
      addCriterion("secret_key >", value, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyGreaterThanOrEqualTo(String value) {
      addCriterion("secret_key >=", value, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyLessThan(String value) {
      addCriterion("secret_key <", value, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyLessThanOrEqualTo(String value) {
      addCriterion("secret_key <=", value, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyLike(String value) {
      addCriterion("secret_key like", value, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyNotLike(String value) {
      addCriterion("secret_key not like", value, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyIn(List<String> values) {
      addCriterion("secret_key in", values, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyNotIn(List<String> values) {
      addCriterion("secret_key not in", values, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyBetween(String value1, String value2) {
      addCriterion("secret_key between", value1, value2, "secretKey");
      return (Criteria) this;
    }

    public Criteria andSecretKeyNotBetween(String value1, String value2) {
      addCriterion("secret_key not between", value1, value2, "secretKey");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateIsNull() {
      addCriterion("key_begin_date is null");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateIsNotNull() {
      addCriterion("key_begin_date is not null");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateEqualTo(Date value) {
      addCriterion("key_begin_date =", value, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateNotEqualTo(Date value) {
      addCriterion("key_begin_date <>", value, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateGreaterThan(Date value) {
      addCriterion("key_begin_date >", value, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateGreaterThanOrEqualTo(Date value) {
      addCriterion("key_begin_date >=", value, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateLessThan(Date value) {
      addCriterion("key_begin_date <", value, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateLessThanOrEqualTo(Date value) {
      addCriterion("key_begin_date <=", value, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateIn(List<Date> values) {
      addCriterion("key_begin_date in", values, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateNotIn(List<Date> values) {
      addCriterion("key_begin_date not in", values, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateBetween(Date value1, Date value2) {
      addCriterion("key_begin_date between", value1, value2, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyBeginDateNotBetween(Date value1, Date value2) {
      addCriterion("key_begin_date not between", value1, value2, "keyBeginDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateIsNull() {
      addCriterion("key_end_date is null");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateIsNotNull() {
      addCriterion("key_end_date is not null");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateEqualTo(Date value) {
      addCriterion("key_end_date =", value, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateNotEqualTo(Date value) {
      addCriterion("key_end_date <>", value, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateGreaterThan(Date value) {
      addCriterion("key_end_date >", value, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateGreaterThanOrEqualTo(Date value) {
      addCriterion("key_end_date >=", value, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateLessThan(Date value) {
      addCriterion("key_end_date <", value, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateLessThanOrEqualTo(Date value) {
      addCriterion("key_end_date <=", value, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateIn(List<Date> values) {
      addCriterion("key_end_date in", values, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateNotIn(List<Date> values) {
      addCriterion("key_end_date not in", values, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateBetween(Date value1, Date value2) {
      addCriterion("key_end_date between", value1, value2, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andKeyEndDateNotBetween(Date value1, Date value2) {
      addCriterion("key_end_date not between", value1, value2, "keyEndDate");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesIsNull() {
      addCriterion("agency_coordinates is null");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesIsNotNull() {
      addCriterion("agency_coordinates is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesEqualTo(String value) {
      addCriterion("agency_coordinates =", value, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesNotEqualTo(String value) {
      addCriterion("agency_coordinates <>", value, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesGreaterThan(String value) {
      addCriterion("agency_coordinates >", value, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesGreaterThanOrEqualTo(String value) {
      addCriterion("agency_coordinates >=", value, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesLessThan(String value) {
      addCriterion("agency_coordinates <", value, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesLessThanOrEqualTo(String value) {
      addCriterion("agency_coordinates <=", value, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesLike(String value) {
      addCriterion("agency_coordinates like", value, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesNotLike(String value) {
      addCriterion("agency_coordinates not like", value, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesIn(List<String> values) {
      addCriterion("agency_coordinates in", values, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesNotIn(List<String> values) {
      addCriterion("agency_coordinates not in", values, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesBetween(String value1, String value2) {
      addCriterion("agency_coordinates between", value1, value2, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyCoordinatesNotBetween(String value1, String value2) {
      addCriterion("agency_coordinates not between", value1, value2, "agencyCoordinates");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateIsNull() {
      addCriterion("agency_audit_state is null");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateIsNotNull() {
      addCriterion("agency_audit_state is not null");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateEqualTo(Integer value) {
      addCriterion("agency_audit_state =", value, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateNotEqualTo(Integer value) {
      addCriterion("agency_audit_state <>", value, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateGreaterThan(Integer value) {
      addCriterion("agency_audit_state >", value, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateGreaterThanOrEqualTo(Integer value) {
      addCriterion("agency_audit_state >=", value, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateLessThan(Integer value) {
      addCriterion("agency_audit_state <", value, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateLessThanOrEqualTo(Integer value) {
      addCriterion("agency_audit_state <=", value, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateIn(List<Integer> values) {
      addCriterion("agency_audit_state in", values, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateNotIn(List<Integer> values) {
      addCriterion("agency_audit_state not in", values, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateBetween(Integer value1, Integer value2) {
      addCriterion("agency_audit_state between", value1, value2, "agencyAuditState");
      return (Criteria) this;
    }

    public Criteria andAgencyAuditStateNotBetween(Integer value1, Integer value2) {
      addCriterion("agency_audit_state not between", value1, value2, "agencyAuditState");
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

    public Criteria andSiAreaEqualTo(Integer value) {
      addCriterion("si_area =", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaNotEqualTo(Integer value) {
      addCriterion("si_area <>", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaGreaterThan(Integer value) {
      addCriterion("si_area >", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaGreaterThanOrEqualTo(Integer value) {
      addCriterion("si_area >=", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaLessThan(Integer value) {
      addCriterion("si_area <", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaLessThanOrEqualTo(Integer value) {
      addCriterion("si_area <=", value, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaIn(List<Integer> values) {
      addCriterion("si_area in", values, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaNotIn(List<Integer> values) {
      addCriterion("si_area not in", values, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaBetween(Integer value1, Integer value2) {
      addCriterion("si_area between", value1, value2, "siArea");
      return (Criteria) this;
    }

    public Criteria andSiAreaNotBetween(Integer value1, Integer value2) {
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
