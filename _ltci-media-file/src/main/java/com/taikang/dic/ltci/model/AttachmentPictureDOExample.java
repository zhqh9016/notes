package com.taikang.dic.ltci.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttachmentPictureDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public AttachmentPictureDOExample() {
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

    public Criteria andSuffixIsNull() {
      addCriterion("suffix is null");
      return (Criteria) this;
    }

    public Criteria andSuffixIsNotNull() {
      addCriterion("suffix is not null");
      return (Criteria) this;
    }

    public Criteria andSuffixEqualTo(String value) {
      addCriterion("suffix =", value, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixNotEqualTo(String value) {
      addCriterion("suffix <>", value, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixGreaterThan(String value) {
      addCriterion("suffix >", value, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixGreaterThanOrEqualTo(String value) {
      addCriterion("suffix >=", value, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixLessThan(String value) {
      addCriterion("suffix <", value, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixLessThanOrEqualTo(String value) {
      addCriterion("suffix <=", value, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixLike(String value) {
      addCriterion("suffix like", value, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixNotLike(String value) {
      addCriterion("suffix not like", value, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixIn(List<String> values) {
      addCriterion("suffix in", values, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixNotIn(List<String> values) {
      addCriterion("suffix not in", values, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixBetween(String value1, String value2) {
      addCriterion("suffix between", value1, value2, "suffix");
      return (Criteria) this;
    }

    public Criteria andSuffixNotBetween(String value1, String value2) {
      addCriterion("suffix not between", value1, value2, "suffix");
      return (Criteria) this;
    }

    public Criteria andFileNameIsNull() {
      addCriterion("file_name is null");
      return (Criteria) this;
    }

    public Criteria andFileNameIsNotNull() {
      addCriterion("file_name is not null");
      return (Criteria) this;
    }

    public Criteria andFileNameEqualTo(String value) {
      addCriterion("file_name =", value, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameNotEqualTo(String value) {
      addCriterion("file_name <>", value, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameGreaterThan(String value) {
      addCriterion("file_name >", value, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameGreaterThanOrEqualTo(String value) {
      addCriterion("file_name >=", value, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameLessThan(String value) {
      addCriterion("file_name <", value, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameLessThanOrEqualTo(String value) {
      addCriterion("file_name <=", value, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameLike(String value) {
      addCriterion("file_name like", value, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameNotLike(String value) {
      addCriterion("file_name not like", value, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameIn(List<String> values) {
      addCriterion("file_name in", values, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameNotIn(List<String> values) {
      addCriterion("file_name not in", values, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameBetween(String value1, String value2) {
      addCriterion("file_name between", value1, value2, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileNameNotBetween(String value1, String value2) {
      addCriterion("file_name not between", value1, value2, "fileName");
      return (Criteria) this;
    }

    public Criteria andFileSizeIsNull() {
      addCriterion("file_size is null");
      return (Criteria) this;
    }

    public Criteria andFileSizeIsNotNull() {
      addCriterion("file_size is not null");
      return (Criteria) this;
    }

    public Criteria andFileSizeEqualTo(BigDecimal value) {
      addCriterion("file_size =", value, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeNotEqualTo(BigDecimal value) {
      addCriterion("file_size <>", value, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeGreaterThan(BigDecimal value) {
      addCriterion("file_size >", value, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("file_size >=", value, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeLessThan(BigDecimal value) {
      addCriterion("file_size <", value, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("file_size <=", value, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeIn(List<BigDecimal> values) {
      addCriterion("file_size in", values, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeNotIn(List<BigDecimal> values) {
      addCriterion("file_size not in", values, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("file_size between", value1, value2, "fileSize");
      return (Criteria) this;
    }

    public Criteria andFileSizeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("file_size not between", value1, value2, "fileSize");
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
