package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public ScheduleDOExample() {
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

    public Criteria andMoudleTypeIsNull() {
      addCriterion("moudle_type is null");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeIsNotNull() {
      addCriterion("moudle_type is not null");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeEqualTo(String value) {
      addCriterion("moudle_type =", value, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeNotEqualTo(String value) {
      addCriterion("moudle_type <>", value, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeGreaterThan(String value) {
      addCriterion("moudle_type >", value, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeGreaterThanOrEqualTo(String value) {
      addCriterion("moudle_type >=", value, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeLessThan(String value) {
      addCriterion("moudle_type <", value, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeLessThanOrEqualTo(String value) {
      addCriterion("moudle_type <=", value, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeLike(String value) {
      addCriterion("moudle_type like", value, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeNotLike(String value) {
      addCriterion("moudle_type not like", value, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeIn(List<String> values) {
      addCriterion("moudle_type in", values, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeNotIn(List<String> values) {
      addCriterion("moudle_type not in", values, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeBetween(String value1, String value2) {
      addCriterion("moudle_type between", value1, value2, "moudleType");
      return (Criteria) this;
    }

    public Criteria andMoudleTypeNotBetween(String value1, String value2) {
      addCriterion("moudle_type not between", value1, value2, "moudleType");
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

    public Criteria andExecutionScheduleIsNull() {
      addCriterion("execution_schedule is null");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleIsNotNull() {
      addCriterion("execution_schedule is not null");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleEqualTo(Integer value) {
      addCriterion("execution_schedule =", value, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleNotEqualTo(Integer value) {
      addCriterion("execution_schedule <>", value, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleGreaterThan(Integer value) {
      addCriterion("execution_schedule >", value, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleGreaterThanOrEqualTo(Integer value) {
      addCriterion("execution_schedule >=", value, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleLessThan(Integer value) {
      addCriterion("execution_schedule <", value, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleLessThanOrEqualTo(Integer value) {
      addCriterion("execution_schedule <=", value, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleIn(List<Integer> values) {
      addCriterion("execution_schedule in", values, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleNotIn(List<Integer> values) {
      addCriterion("execution_schedule not in", values, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleBetween(Integer value1, Integer value2) {
      addCriterion("execution_schedule between", value1, value2, "executionSchedule");
      return (Criteria) this;
    }

    public Criteria andExecutionScheduleNotBetween(Integer value1, Integer value2) {
      addCriterion("execution_schedule not between", value1, value2, "executionSchedule");
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

    public Criteria andTimeWindowIsNull() {
      addCriterion("time_window is null");
      return (Criteria) this;
    }

    public Criteria andTimeWindowIsNotNull() {
      addCriterion("time_window is not null");
      return (Criteria) this;
    }

    public Criteria andTimeWindowEqualTo(Integer value) {
      addCriterion("time_window =", value, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowNotEqualTo(Integer value) {
      addCriterion("time_window <>", value, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowGreaterThan(Integer value) {
      addCriterion("time_window >", value, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowGreaterThanOrEqualTo(Integer value) {
      addCriterion("time_window >=", value, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowLessThan(Integer value) {
      addCriterion("time_window <", value, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowLessThanOrEqualTo(Integer value) {
      addCriterion("time_window <=", value, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowIn(List<Integer> values) {
      addCriterion("time_window in", values, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowNotIn(List<Integer> values) {
      addCriterion("time_window not in", values, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowBetween(Integer value1, Integer value2) {
      addCriterion("time_window between", value1, value2, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andTimeWindowNotBetween(Integer value1, Integer value2) {
      addCriterion("time_window not between", value1, value2, "timeWindow");
      return (Criteria) this;
    }

    public Criteria andIpIsNull() {
      addCriterion("ip is null");
      return (Criteria) this;
    }

    public Criteria andIpIsNotNull() {
      addCriterion("ip is not null");
      return (Criteria) this;
    }

    public Criteria andIpEqualTo(String value) {
      addCriterion("ip =", value, "ip");
      return (Criteria) this;
    }

    public Criteria andIpNotEqualTo(String value) {
      addCriterion("ip <>", value, "ip");
      return (Criteria) this;
    }

    public Criteria andIpGreaterThan(String value) {
      addCriterion("ip >", value, "ip");
      return (Criteria) this;
    }

    public Criteria andIpGreaterThanOrEqualTo(String value) {
      addCriterion("ip >=", value, "ip");
      return (Criteria) this;
    }

    public Criteria andIpLessThan(String value) {
      addCriterion("ip <", value, "ip");
      return (Criteria) this;
    }

    public Criteria andIpLessThanOrEqualTo(String value) {
      addCriterion("ip <=", value, "ip");
      return (Criteria) this;
    }

    public Criteria andIpLike(String value) {
      addCriterion("ip like", value, "ip");
      return (Criteria) this;
    }

    public Criteria andIpNotLike(String value) {
      addCriterion("ip not like", value, "ip");
      return (Criteria) this;
    }

    public Criteria andIpIn(List<String> values) {
      addCriterion("ip in", values, "ip");
      return (Criteria) this;
    }

    public Criteria andIpNotIn(List<String> values) {
      addCriterion("ip not in", values, "ip");
      return (Criteria) this;
    }

    public Criteria andIpBetween(String value1, String value2) {
      addCriterion("ip between", value1, value2, "ip");
      return (Criteria) this;
    }

    public Criteria andIpNotBetween(String value1, String value2) {
      addCriterion("ip not between", value1, value2, "ip");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusIsNull() {
      addCriterion("execution_status is null");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusIsNotNull() {
      addCriterion("execution_status is not null");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusEqualTo(Integer value) {
      addCriterion("execution_status =", value, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusNotEqualTo(Integer value) {
      addCriterion("execution_status <>", value, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusGreaterThan(Integer value) {
      addCriterion("execution_status >", value, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("execution_status >=", value, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusLessThan(Integer value) {
      addCriterion("execution_status <", value, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusLessThanOrEqualTo(Integer value) {
      addCriterion("execution_status <=", value, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusIn(List<Integer> values) {
      addCriterion("execution_status in", values, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusNotIn(List<Integer> values) {
      addCriterion("execution_status not in", values, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusBetween(Integer value1, Integer value2) {
      addCriterion("execution_status between", value1, value2, "executionStatus");
      return (Criteria) this;
    }

    public Criteria andExecutionStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("execution_status not between", value1, value2, "executionStatus");
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
