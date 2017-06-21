package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public ResDOExample() {
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

    public Criteria andParentIdIsNull() {
      addCriterion("parent_id is null");
      return (Criteria) this;
    }

    public Criteria andParentIdIsNotNull() {
      addCriterion("parent_id is not null");
      return (Criteria) this;
    }

    public Criteria andParentIdEqualTo(String value) {
      addCriterion("parent_id =", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotEqualTo(String value) {
      addCriterion("parent_id <>", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdGreaterThan(String value) {
      addCriterion("parent_id >", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdGreaterThanOrEqualTo(String value) {
      addCriterion("parent_id >=", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLessThan(String value) {
      addCriterion("parent_id <", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLessThanOrEqualTo(String value) {
      addCriterion("parent_id <=", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLike(String value) {
      addCriterion("parent_id like", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotLike(String value) {
      addCriterion("parent_id not like", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdIn(List<String> values) {
      addCriterion("parent_id in", values, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotIn(List<String> values) {
      addCriterion("parent_id not in", values, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdBetween(String value1, String value2) {
      addCriterion("parent_id between", value1, value2, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotBetween(String value1, String value2) {
      addCriterion("parent_id not between", value1, value2, "parentId");
      return (Criteria) this;
    }

    public Criteria andResNameIsNull() {
      addCriterion("res_name is null");
      return (Criteria) this;
    }

    public Criteria andResNameIsNotNull() {
      addCriterion("res_name is not null");
      return (Criteria) this;
    }

    public Criteria andResNameEqualTo(String value) {
      addCriterion("res_name =", value, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameNotEqualTo(String value) {
      addCriterion("res_name <>", value, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameGreaterThan(String value) {
      addCriterion("res_name >", value, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameGreaterThanOrEqualTo(String value) {
      addCriterion("res_name >=", value, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameLessThan(String value) {
      addCriterion("res_name <", value, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameLessThanOrEqualTo(String value) {
      addCriterion("res_name <=", value, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameLike(String value) {
      addCriterion("res_name like", value, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameNotLike(String value) {
      addCriterion("res_name not like", value, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameIn(List<String> values) {
      addCriterion("res_name in", values, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameNotIn(List<String> values) {
      addCriterion("res_name not in", values, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameBetween(String value1, String value2) {
      addCriterion("res_name between", value1, value2, "resName");
      return (Criteria) this;
    }

    public Criteria andResNameNotBetween(String value1, String value2) {
      addCriterion("res_name not between", value1, value2, "resName");
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

    public Criteria andUrlIsNull() {
      addCriterion("url is null");
      return (Criteria) this;
    }

    public Criteria andUrlIsNotNull() {
      addCriterion("url is not null");
      return (Criteria) this;
    }

    public Criteria andUrlEqualTo(String value) {
      addCriterion("url =", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotEqualTo(String value) {
      addCriterion("url <>", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlGreaterThan(String value) {
      addCriterion("url >", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlGreaterThanOrEqualTo(String value) {
      addCriterion("url >=", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLessThan(String value) {
      addCriterion("url <", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLessThanOrEqualTo(String value) {
      addCriterion("url <=", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLike(String value) {
      addCriterion("url like", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotLike(String value) {
      addCriterion("url not like", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlIn(List<String> values) {
      addCriterion("url in", values, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotIn(List<String> values) {
      addCriterion("url not in", values, "url");
      return (Criteria) this;
    }

    public Criteria andUrlBetween(String value1, String value2) {
      addCriterion("url between", value1, value2, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotBetween(String value1, String value2) {
      addCriterion("url not between", value1, value2, "url");
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

    public Criteria andSequenceEqualTo(String value) {
      addCriterion("sequence =", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceNotEqualTo(String value) {
      addCriterion("sequence <>", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceGreaterThan(String value) {
      addCriterion("sequence >", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceGreaterThanOrEqualTo(String value) {
      addCriterion("sequence >=", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceLessThan(String value) {
      addCriterion("sequence <", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceLessThanOrEqualTo(String value) {
      addCriterion("sequence <=", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceLike(String value) {
      addCriterion("sequence like", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceNotLike(String value) {
      addCriterion("sequence not like", value, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceIn(List<String> values) {
      addCriterion("sequence in", values, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceNotIn(List<String> values) {
      addCriterion("sequence not in", values, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceBetween(String value1, String value2) {
      addCriterion("sequence between", value1, value2, "sequence");
      return (Criteria) this;
    }

    public Criteria andSequenceNotBetween(String value1, String value2) {
      addCriterion("sequence not between", value1, value2, "sequence");
      return (Criteria) this;
    }

    public Criteria andIsMenuIsNull() {
      addCriterion("is_menu is null");
      return (Criteria) this;
    }

    public Criteria andIsMenuIsNotNull() {
      addCriterion("is_menu is not null");
      return (Criteria) this;
    }

    public Criteria andIsMenuEqualTo(Integer value) {
      addCriterion("is_menu =", value, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuNotEqualTo(Integer value) {
      addCriterion("is_menu <>", value, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuGreaterThan(Integer value) {
      addCriterion("is_menu >", value, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuGreaterThanOrEqualTo(Integer value) {
      addCriterion("is_menu >=", value, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuLessThan(Integer value) {
      addCriterion("is_menu <", value, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuLessThanOrEqualTo(Integer value) {
      addCriterion("is_menu <=", value, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuLike(Integer value) {
      addCriterion("is_menu like", value, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuNotLike(Integer value) {
      addCriterion("is_menu not like", value, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuIn(List<Integer> values) {
      addCriterion("is_menu in", values, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuNotIn(List<Integer> values) {
      addCriterion("is_menu not in", values, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuBetween(Integer value1, Integer value2) {
      addCriterion("is_menu between", value1, value2, "isMenu");
      return (Criteria) this;
    }

    public Criteria andIsMenuNotBetween(Integer value1, Integer value2) {
      addCriterion("is_menu not between", value1, value2, "isMenu");
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

    public Criteria andUpdateTimeIsNull() {
      addCriterion("update_time is null");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeIsNotNull() {
      addCriterion("update_time is not null");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeEqualTo(Date value) {
      addCriterion("update_time =", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeNotEqualTo(Date value) {
      addCriterion("update_time <>", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeGreaterThan(Date value) {
      addCriterion("update_time >", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("update_time >=", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeLessThan(Date value) {
      addCriterion("update_time <", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
      addCriterion("update_time <=", value, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeIn(List<Date> values) {
      addCriterion("update_time in", values, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeNotIn(List<Date> values) {
      addCriterion("update_time not in", values, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeBetween(Date value1, Date value2) {
      addCriterion("update_time between", value1, value2, "updateTime");
      return (Criteria) this;
    }

    public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
      addCriterion("update_time not between", value1, value2, "updateTime");
      return (Criteria) this;
    }

    public Criteria andCreateByIsNull() {
      addCriterion("create_by is null");
      return (Criteria) this;
    }

    public Criteria andCreateByIsNotNull() {
      addCriterion("create_by is not null");
      return (Criteria) this;
    }

    public Criteria andCreateByEqualTo(String value) {
      addCriterion("create_by =", value, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByNotEqualTo(String value) {
      addCriterion("create_by <>", value, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByGreaterThan(String value) {
      addCriterion("create_by >", value, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByGreaterThanOrEqualTo(String value) {
      addCriterion("create_by >=", value, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByLessThan(String value) {
      addCriterion("create_by <", value, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByLessThanOrEqualTo(String value) {
      addCriterion("create_by <=", value, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByLike(String value) {
      addCriterion("create_by like", value, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByNotLike(String value) {
      addCriterion("create_by not like", value, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByIn(List<String> values) {
      addCriterion("create_by in", values, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByNotIn(List<String> values) {
      addCriterion("create_by not in", values, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByBetween(String value1, String value2) {
      addCriterion("create_by between", value1, value2, "createBy");
      return (Criteria) this;
    }

    public Criteria andCreateByNotBetween(String value1, String value2) {
      addCriterion("create_by not between", value1, value2, "createBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByIsNull() {
      addCriterion("update_by is null");
      return (Criteria) this;
    }

    public Criteria andUpdateByIsNotNull() {
      addCriterion("update_by is not null");
      return (Criteria) this;
    }

    public Criteria andUpdateByEqualTo(String value) {
      addCriterion("update_by =", value, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByNotEqualTo(String value) {
      addCriterion("update_by <>", value, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByGreaterThan(String value) {
      addCriterion("update_by >", value, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
      addCriterion("update_by >=", value, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByLessThan(String value) {
      addCriterion("update_by <", value, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByLessThanOrEqualTo(String value) {
      addCriterion("update_by <=", value, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByLike(String value) {
      addCriterion("update_by like", value, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByNotLike(String value) {
      addCriterion("update_by not like", value, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByIn(List<String> values) {
      addCriterion("update_by in", values, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByNotIn(List<String> values) {
      addCriterion("update_by not in", values, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByBetween(String value1, String value2) {
      addCriterion("update_by between", value1, value2, "updateBy");
      return (Criteria) this;
    }

    public Criteria andUpdateByNotBetween(String value1, String value2) {
      addCriterion("update_by not between", value1, value2, "updateBy");
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
