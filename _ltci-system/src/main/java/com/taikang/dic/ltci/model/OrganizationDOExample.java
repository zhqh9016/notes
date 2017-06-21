package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrganizationDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public OrganizationDOExample() {
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

    public Criteria andIsOrgIsNull() {
      addCriterion("is_org is null");
      return (Criteria) this;
    }

    public Criteria andIsOrgIsNotNull() {
      addCriterion("is_org is not null");
      return (Criteria) this;
    }

    public Criteria andIsOrgEqualTo(Integer value) {
      addCriterion("is_org =", value, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgNotEqualTo(Integer value) {
      addCriterion("is_org <>", value, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgGreaterThan(Integer value) {
      addCriterion("is_org >", value, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgGreaterThanOrEqualTo(Integer value) {
      addCriterion("is_org >=", value, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgLessThan(Integer value) {
      addCriterion("is_org <", value, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgLessThanOrEqualTo(Integer value) {
      addCriterion("is_org <=", value, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgIn(List<Integer> values) {
      addCriterion("is_org in", values, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgNotIn(List<Integer> values) {
      addCriterion("is_org not in", values, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgBetween(Integer value1, Integer value2) {
      addCriterion("is_org between", value1, value2, "isOrg");
      return (Criteria) this;
    }

    public Criteria andIsOrgNotBetween(Integer value1, Integer value2) {
      addCriterion("is_org not between", value1, value2, "isOrg");
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

    public Criteria andParentidIsNull() {
      addCriterion("parentid is null");
      return (Criteria) this;
    }

    public Criteria andParentidIsNotNull() {
      addCriterion("parentid is not null");
      return (Criteria) this;
    }

    public Criteria andParentidEqualTo(String value) {
      addCriterion("parentid =", value, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidNotEqualTo(String value) {
      addCriterion("parentid <>", value, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidGreaterThan(String value) {
      addCriterion("parentid >", value, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidGreaterThanOrEqualTo(String value) {
      addCriterion("parentid >=", value, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidLessThan(String value) {
      addCriterion("parentid <", value, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidLessThanOrEqualTo(String value) {
      addCriterion("parentid <=", value, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidLike(String value) {
      addCriterion("parentid like", value, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidNotLike(String value) {
      addCriterion("parentid not like", value, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidIn(List<String> values) {
      addCriterion("parentid in", values, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidNotIn(List<String> values) {
      addCriterion("parentid not in", values, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidBetween(String value1, String value2) {
      addCriterion("parentid between", value1, value2, "parentid");
      return (Criteria) this;
    }

    public Criteria andParentidNotBetween(String value1, String value2) {
      addCriterion("parentid not between", value1, value2, "parentid");
      return (Criteria) this;
    }

    public Criteria andCodeIsNull() {
      addCriterion("code is null");
      return (Criteria) this;
    }

    public Criteria andCodeIsNotNull() {
      addCriterion("code is not null");
      return (Criteria) this;
    }

    public Criteria andCodeEqualTo(String value) {
      addCriterion("code =", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotEqualTo(String value) {
      addCriterion("code <>", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeGreaterThan(String value) {
      addCriterion("code >", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeGreaterThanOrEqualTo(String value) {
      addCriterion("code >=", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLessThan(String value) {
      addCriterion("code <", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLessThanOrEqualTo(String value) {
      addCriterion("code <=", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeLike(String value) {
      addCriterion("code like", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotLike(String value) {
      addCriterion("code not like", value, "code");
      return (Criteria) this;
    }

    public Criteria andCodeIn(List<String> values) {
      addCriterion("code in", values, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotIn(List<String> values) {
      addCriterion("code not in", values, "code");
      return (Criteria) this;
    }

    public Criteria andCodeBetween(String value1, String value2) {
      addCriterion("code between", value1, value2, "code");
      return (Criteria) this;
    }

    public Criteria andCodeNotBetween(String value1, String value2) {
      addCriterion("code not between", value1, value2, "code");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeIsNull() {
      addCriterion("soc_org_code is null");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeIsNotNull() {
      addCriterion("soc_org_code is not null");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeEqualTo(String value) {
      addCriterion("soc_org_code =", value, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeNotEqualTo(String value) {
      addCriterion("soc_org_code <>", value, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeGreaterThan(String value) {
      addCriterion("soc_org_code >", value, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeGreaterThanOrEqualTo(String value) {
      addCriterion("soc_org_code >=", value, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeLessThan(String value) {
      addCriterion("soc_org_code <", value, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeLessThanOrEqualTo(String value) {
      addCriterion("soc_org_code <=", value, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeLike(String value) {
      addCriterion("soc_org_code like", value, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeNotLike(String value) {
      addCriterion("soc_org_code not like", value, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeIn(List<String> values) {
      addCriterion("soc_org_code in", values, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeNotIn(List<String> values) {
      addCriterion("soc_org_code not in", values, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeBetween(String value1, String value2) {
      addCriterion("soc_org_code between", value1, value2, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andSocOrgCodeNotBetween(String value1, String value2) {
      addCriterion("soc_org_code not between", value1, value2, "socOrgCode");
      return (Criteria) this;
    }

    public Criteria andNameIsNull() {
      addCriterion("name is null");
      return (Criteria) this;
    }

    public Criteria andNameIsNotNull() {
      addCriterion("name is not null");
      return (Criteria) this;
    }

    public Criteria andNameEqualTo(String value) {
      addCriterion("name =", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotEqualTo(String value) {
      addCriterion("name <>", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThan(String value) {
      addCriterion("name >", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("name >=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThan(String value) {
      addCriterion("name <", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("name <=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLike(String value) {
      addCriterion("name like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotLike(String value) {
      addCriterion("name not like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameIn(List<String> values) {
      addCriterion("name in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotIn(List<String> values) {
      addCriterion("name not in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameBetween(String value1, String value2) {
      addCriterion("name between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("name not between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andDescriptionIsNull() {
      addCriterion("description is null");
      return (Criteria) this;
    }

    public Criteria andDescriptionIsNotNull() {
      addCriterion("description is not null");
      return (Criteria) this;
    }

    public Criteria andDescriptionEqualTo(String value) {
      addCriterion("description =", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotEqualTo(String value) {
      addCriterion("description <>", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionGreaterThan(String value) {
      addCriterion("description >", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
      addCriterion("description >=", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLessThan(String value) {
      addCriterion("description <", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLessThanOrEqualTo(String value) {
      addCriterion("description <=", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLike(String value) {
      addCriterion("description like", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotLike(String value) {
      addCriterion("description not like", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionIn(List<String> values) {
      addCriterion("description in", values, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotIn(List<String> values) {
      addCriterion("description not in", values, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionBetween(String value1, String value2) {
      addCriterion("description between", value1, value2, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotBetween(String value1, String value2) {
      addCriterion("description not between", value1, value2, "description");
      return (Criteria) this;
    }

    public Criteria andStreetIsNull() {
      addCriterion("street is null");
      return (Criteria) this;
    }

    public Criteria andStreetIsNotNull() {
      addCriterion("street is not null");
      return (Criteria) this;
    }

    public Criteria andStreetEqualTo(String value) {
      addCriterion("street =", value, "street");
      return (Criteria) this;
    }

    public Criteria andStreetNotEqualTo(String value) {
      addCriterion("street <>", value, "street");
      return (Criteria) this;
    }

    public Criteria andStreetGreaterThan(String value) {
      addCriterion("street >", value, "street");
      return (Criteria) this;
    }

    public Criteria andStreetGreaterThanOrEqualTo(String value) {
      addCriterion("street >=", value, "street");
      return (Criteria) this;
    }

    public Criteria andStreetLessThan(String value) {
      addCriterion("street <", value, "street");
      return (Criteria) this;
    }

    public Criteria andStreetLessThanOrEqualTo(String value) {
      addCriterion("street <=", value, "street");
      return (Criteria) this;
    }

    public Criteria andStreetLike(String value) {
      addCriterion("street like", value, "street");
      return (Criteria) this;
    }

    public Criteria andStreetNotLike(String value) {
      addCriterion("street not like", value, "street");
      return (Criteria) this;
    }

    public Criteria andStreetIn(List<String> values) {
      addCriterion("street in", values, "street");
      return (Criteria) this;
    }

    public Criteria andStreetNotIn(List<String> values) {
      addCriterion("street not in", values, "street");
      return (Criteria) this;
    }

    public Criteria andStreetBetween(String value1, String value2) {
      addCriterion("street between", value1, value2, "street");
      return (Criteria) this;
    }

    public Criteria andStreetNotBetween(String value1, String value2) {
      addCriterion("street not between", value1, value2, "street");
      return (Criteria) this;
    }

    public Criteria andProvinceidIsNull() {
      addCriterion("provinceid is null");
      return (Criteria) this;
    }

    public Criteria andProvinceidIsNotNull() {
      addCriterion("provinceid is not null");
      return (Criteria) this;
    }

    public Criteria andProvinceidEqualTo(String value) {
      addCriterion("provinceid =", value, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidNotEqualTo(String value) {
      addCriterion("provinceid <>", value, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidGreaterThan(String value) {
      addCriterion("provinceid >", value, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidGreaterThanOrEqualTo(String value) {
      addCriterion("provinceid >=", value, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidLessThan(String value) {
      addCriterion("provinceid <", value, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidLessThanOrEqualTo(String value) {
      addCriterion("provinceid <=", value, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidLike(String value) {
      addCriterion("provinceid like", value, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidNotLike(String value) {
      addCriterion("provinceid not like", value, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidIn(List<String> values) {
      addCriterion("provinceid in", values, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidNotIn(List<String> values) {
      addCriterion("provinceid not in", values, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidBetween(String value1, String value2) {
      addCriterion("provinceid between", value1, value2, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceidNotBetween(String value1, String value2) {
      addCriterion("provinceid not between", value1, value2, "provinceid");
      return (Criteria) this;
    }

    public Criteria andProvinceNameIsNull() {
      addCriterion("province_name is null");
      return (Criteria) this;
    }

    public Criteria andProvinceNameIsNotNull() {
      addCriterion("province_name is not null");
      return (Criteria) this;
    }

    public Criteria andProvinceNameEqualTo(String value) {
      addCriterion("province_name =", value, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameNotEqualTo(String value) {
      addCriterion("province_name <>", value, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameGreaterThan(String value) {
      addCriterion("province_name >", value, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
      addCriterion("province_name >=", value, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameLessThan(String value) {
      addCriterion("province_name <", value, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameLessThanOrEqualTo(String value) {
      addCriterion("province_name <=", value, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameLike(String value) {
      addCriterion("province_name like", value, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameNotLike(String value) {
      addCriterion("province_name not like", value, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameIn(List<String> values) {
      addCriterion("province_name in", values, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameNotIn(List<String> values) {
      addCriterion("province_name not in", values, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameBetween(String value1, String value2) {
      addCriterion("province_name between", value1, value2, "provinceName");
      return (Criteria) this;
    }

    public Criteria andProvinceNameNotBetween(String value1, String value2) {
      addCriterion("province_name not between", value1, value2, "provinceName");
      return (Criteria) this;
    }

    public Criteria andCityidIsNull() {
      addCriterion("cityid is null");
      return (Criteria) this;
    }

    public Criteria andCityidIsNotNull() {
      addCriterion("cityid is not null");
      return (Criteria) this;
    }

    public Criteria andCityidEqualTo(String value) {
      addCriterion("cityid =", value, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidNotEqualTo(String value) {
      addCriterion("cityid <>", value, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidGreaterThan(String value) {
      addCriterion("cityid >", value, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidGreaterThanOrEqualTo(String value) {
      addCriterion("cityid >=", value, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidLessThan(String value) {
      addCriterion("cityid <", value, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidLessThanOrEqualTo(String value) {
      addCriterion("cityid <=", value, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidLike(String value) {
      addCriterion("cityid like", value, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidNotLike(String value) {
      addCriterion("cityid not like", value, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidIn(List<String> values) {
      addCriterion("cityid in", values, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidNotIn(List<String> values) {
      addCriterion("cityid not in", values, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidBetween(String value1, String value2) {
      addCriterion("cityid between", value1, value2, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityidNotBetween(String value1, String value2) {
      addCriterion("cityid not between", value1, value2, "cityid");
      return (Criteria) this;
    }

    public Criteria andCityNameIsNull() {
      addCriterion("city_name is null");
      return (Criteria) this;
    }

    public Criteria andCityNameIsNotNull() {
      addCriterion("city_name is not null");
      return (Criteria) this;
    }

    public Criteria andCityNameEqualTo(String value) {
      addCriterion("city_name =", value, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameNotEqualTo(String value) {
      addCriterion("city_name <>", value, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameGreaterThan(String value) {
      addCriterion("city_name >", value, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameGreaterThanOrEqualTo(String value) {
      addCriterion("city_name >=", value, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameLessThan(String value) {
      addCriterion("city_name <", value, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameLessThanOrEqualTo(String value) {
      addCriterion("city_name <=", value, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameLike(String value) {
      addCriterion("city_name like", value, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameNotLike(String value) {
      addCriterion("city_name not like", value, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameIn(List<String> values) {
      addCriterion("city_name in", values, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameNotIn(List<String> values) {
      addCriterion("city_name not in", values, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameBetween(String value1, String value2) {
      addCriterion("city_name between", value1, value2, "cityName");
      return (Criteria) this;
    }

    public Criteria andCityNameNotBetween(String value1, String value2) {
      addCriterion("city_name not between", value1, value2, "cityName");
      return (Criteria) this;
    }

    public Criteria andCountyidIsNull() {
      addCriterion("countyid is null");
      return (Criteria) this;
    }

    public Criteria andCountyidIsNotNull() {
      addCriterion("countyid is not null");
      return (Criteria) this;
    }

    public Criteria andCountyidEqualTo(String value) {
      addCriterion("countyid =", value, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidNotEqualTo(String value) {
      addCriterion("countyid <>", value, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidGreaterThan(String value) {
      addCriterion("countyid >", value, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidGreaterThanOrEqualTo(String value) {
      addCriterion("countyid >=", value, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidLessThan(String value) {
      addCriterion("countyid <", value, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidLessThanOrEqualTo(String value) {
      addCriterion("countyid <=", value, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidLike(String value) {
      addCriterion("countyid like", value, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidNotLike(String value) {
      addCriterion("countyid not like", value, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidIn(List<String> values) {
      addCriterion("countyid in", values, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidNotIn(List<String> values) {
      addCriterion("countyid not in", values, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidBetween(String value1, String value2) {
      addCriterion("countyid between", value1, value2, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyidNotBetween(String value1, String value2) {
      addCriterion("countyid not between", value1, value2, "countyid");
      return (Criteria) this;
    }

    public Criteria andCountyNameIsNull() {
      addCriterion("county_name is null");
      return (Criteria) this;
    }

    public Criteria andCountyNameIsNotNull() {
      addCriterion("county_name is not null");
      return (Criteria) this;
    }

    public Criteria andCountyNameEqualTo(String value) {
      addCriterion("county_name =", value, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameNotEqualTo(String value) {
      addCriterion("county_name <>", value, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameGreaterThan(String value) {
      addCriterion("county_name >", value, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameGreaterThanOrEqualTo(String value) {
      addCriterion("county_name >=", value, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameLessThan(String value) {
      addCriterion("county_name <", value, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameLessThanOrEqualTo(String value) {
      addCriterion("county_name <=", value, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameLike(String value) {
      addCriterion("county_name like", value, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameNotLike(String value) {
      addCriterion("county_name not like", value, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameIn(List<String> values) {
      addCriterion("county_name in", values, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameNotIn(List<String> values) {
      addCriterion("county_name not in", values, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameBetween(String value1, String value2) {
      addCriterion("county_name between", value1, value2, "countyName");
      return (Criteria) this;
    }

    public Criteria andCountyNameNotBetween(String value1, String value2) {
      addCriterion("county_name not between", value1, value2, "countyName");
      return (Criteria) this;
    }

    public Criteria andPhoneIsNull() {
      addCriterion("phone is null");
      return (Criteria) this;
    }

    public Criteria andPhoneIsNotNull() {
      addCriterion("phone is not null");
      return (Criteria) this;
    }

    public Criteria andPhoneEqualTo(String value) {
      addCriterion("phone =", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneNotEqualTo(String value) {
      addCriterion("phone <>", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneGreaterThan(String value) {
      addCriterion("phone >", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("phone >=", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneLessThan(String value) {
      addCriterion("phone <", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneLessThanOrEqualTo(String value) {
      addCriterion("phone <=", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneLike(String value) {
      addCriterion("phone like", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneNotLike(String value) {
      addCriterion("phone not like", value, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneIn(List<String> values) {
      addCriterion("phone in", values, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneNotIn(List<String> values) {
      addCriterion("phone not in", values, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneBetween(String value1, String value2) {
      addCriterion("phone between", value1, value2, "phone");
      return (Criteria) this;
    }

    public Criteria andPhoneNotBetween(String value1, String value2) {
      addCriterion("phone not between", value1, value2, "phone");
      return (Criteria) this;
    }

    public Criteria andSequenceIsNull() {
      addCriterion("sequence is null");
      return (Criteria) this;
    }

    public Criteria andSequenceIsNotNull() {
      addCriterion("sequence is not null");
      return (Criteria) this;
    }

    public Criteria andSequenceEqualTo(Integer value) {
      addCriterion("sequence =", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceNotEqualTo(Integer value) {
      addCriterion("sequence <>", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceGreaterThan(Integer value) {
      addCriterion("sequence >", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
      addCriterion("sequence >=", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceLessThan(Integer value) {
      addCriterion("sequence <", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceLessThanOrEqualTo(Integer value) {
      addCriterion("sequence <=", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceIn(List<Integer> values) {
      addCriterion("sequence in", values, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceNotIn(List<Integer> values) {
      addCriterion("sequence not in", values, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceBetween(Integer value1, Integer value2) {
      addCriterion("sequence between", value1, value2, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
      addCriterion("sequence not between", value1, value2, "sequence");
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
