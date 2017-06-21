package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WhiteListDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public WhiteListDOExample() {
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

    public Criteria andIntefaceNameIsNull() {
      addCriterion("inteface_name is null");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameIsNotNull() {
      addCriterion("inteface_name is not null");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameEqualTo(String value) {
      addCriterion("inteface_name =", value, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameNotEqualTo(String value) {
      addCriterion("inteface_name <>", value, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameGreaterThan(String value) {
      addCriterion("inteface_name >", value, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameGreaterThanOrEqualTo(String value) {
      addCriterion("inteface_name >=", value, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameLessThan(String value) {
      addCriterion("inteface_name <", value, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameLessThanOrEqualTo(String value) {
      addCriterion("inteface_name <=", value, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameLike(String value) {
      addCriterion("inteface_name like", value, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameNotLike(String value) {
      addCriterion("inteface_name not like", value, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameIn(List<String> values) {
      addCriterion("inteface_name in", values, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameNotIn(List<String> values) {
      addCriterion("inteface_name not in", values, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameBetween(String value1, String value2) {
      addCriterion("inteface_name between", value1, value2, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIntefaceNameNotBetween(String value1, String value2) {
      addCriterion("inteface_name not between", value1, value2, "intefaceName");
      return (Criteria) this;
    }

    public Criteria andIpAddrIsNull() {
      addCriterion("ip_addr is null");
      return (Criteria) this;
    }

    public Criteria andIpAddrIsNotNull() {
      addCriterion("ip_addr is not null");
      return (Criteria) this;
    }

    public Criteria andIpAddrEqualTo(String value) {
      addCriterion("ip_addr =", value, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrNotEqualTo(String value) {
      addCriterion("ip_addr <>", value, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrGreaterThan(String value) {
      addCriterion("ip_addr >", value, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrGreaterThanOrEqualTo(String value) {
      addCriterion("ip_addr >=", value, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrLessThan(String value) {
      addCriterion("ip_addr <", value, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrLessThanOrEqualTo(String value) {
      addCriterion("ip_addr <=", value, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrLike(String value) {
      addCriterion("ip_addr like", value, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrNotLike(String value) {
      addCriterion("ip_addr not like", value, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrIn(List<String> values) {
      addCriterion("ip_addr in", values, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrNotIn(List<String> values) {
      addCriterion("ip_addr not in", values, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrBetween(String value1, String value2) {
      addCriterion("ip_addr between", value1, value2, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andIpAddrNotBetween(String value1, String value2) {
      addCriterion("ip_addr not between", value1, value2, "ipAddr");
      return (Criteria) this;
    }

    public Criteria andPortIsNull() {
      addCriterion("port is null");
      return (Criteria) this;
    }

    public Criteria andPortIsNotNull() {
      addCriterion("port is not null");
      return (Criteria) this;
    }

    public Criteria andPortEqualTo(Integer value) {
      addCriterion("port =", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortNotEqualTo(Integer value) {
      addCriterion("port <>", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortGreaterThan(Integer value) {
      addCriterion("port >", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortGreaterThanOrEqualTo(Integer value) {
      addCriterion("port >=", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortLessThan(Integer value) {
      addCriterion("port <", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortLessThanOrEqualTo(Integer value) {
      addCriterion("port <=", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortIn(List<Integer> values) {
      addCriterion("port in", values, "port");
      return (Criteria) this;
    }

    public Criteria andPortNotIn(List<Integer> values) {
      addCriterion("port not in", values, "port");
      return (Criteria) this;
    }

    public Criteria andPortBetween(Integer value1, Integer value2) {
      addCriterion("port between", value1, value2, "port");
      return (Criteria) this;
    }

    public Criteria andPortNotBetween(Integer value1, Integer value2) {
      addCriterion("port not between", value1, value2, "port");
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
