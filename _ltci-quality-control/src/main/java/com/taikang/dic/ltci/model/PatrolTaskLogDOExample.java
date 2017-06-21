package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatrolTaskLogDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public PatrolTaskLogDOExample() {
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

    public Criteria andPatrolTaskLogidIsNull() {
      addCriterion("patrol_task_logid is null");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidIsNotNull() {
      addCriterion("patrol_task_logid is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidEqualTo(String value) {
      addCriterion("patrol_task_logid =", value, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidNotEqualTo(String value) {
      addCriterion("patrol_task_logid <>", value, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidGreaterThan(String value) {
      addCriterion("patrol_task_logid >", value, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_task_logid >=", value, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidLessThan(String value) {
      addCriterion("patrol_task_logid <", value, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidLessThanOrEqualTo(String value) {
      addCriterion("patrol_task_logid <=", value, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidLike(String value) {
      addCriterion("patrol_task_logid like", value, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidNotLike(String value) {
      addCriterion("patrol_task_logid not like", value, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidIn(List<String> values) {
      addCriterion("patrol_task_logid in", values, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidNotIn(List<String> values) {
      addCriterion("patrol_task_logid not in", values, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidBetween(String value1, String value2) {
      addCriterion("patrol_task_logid between", value1, value2, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskLogidNotBetween(String value1, String value2) {
      addCriterion("patrol_task_logid not between", value1, value2, "patrolTaskLogid");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryIsNull() {
      addCriterion("task_category is null");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryIsNotNull() {
      addCriterion("task_category is not null");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryEqualTo(Integer value) {
      addCriterion("task_category =", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryNotEqualTo(Integer value) {
      addCriterion("task_category <>", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryGreaterThan(Integer value) {
      addCriterion("task_category >", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryGreaterThanOrEqualTo(Integer value) {
      addCriterion("task_category >=", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryLessThan(Integer value) {
      addCriterion("task_category <", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryLessThanOrEqualTo(Integer value) {
      addCriterion("task_category <=", value, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryIn(List<Integer> values) {
      addCriterion("task_category in", values, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryNotIn(List<Integer> values) {
      addCriterion("task_category not in", values, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryBetween(Integer value1, Integer value2) {
      addCriterion("task_category between", value1, value2, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskCategoryNotBetween(Integer value1, Integer value2) {
      addCriterion("task_category not between", value1, value2, "taskCategory");
      return (Criteria) this;
    }

    public Criteria andTaskLevelIsNull() {
      addCriterion("task_level is null");
      return (Criteria) this;
    }

    public Criteria andTaskLevelIsNotNull() {
      addCriterion("task_level is not null");
      return (Criteria) this;
    }

    public Criteria andTaskLevelEqualTo(Integer value) {
      addCriterion("task_level =", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelNotEqualTo(Integer value) {
      addCriterion("task_level <>", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelGreaterThan(Integer value) {
      addCriterion("task_level >", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelGreaterThanOrEqualTo(Integer value) {
      addCriterion("task_level >=", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelLessThan(Integer value) {
      addCriterion("task_level <", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelLessThanOrEqualTo(Integer value) {
      addCriterion("task_level <=", value, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelIn(List<Integer> values) {
      addCriterion("task_level in", values, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelNotIn(List<Integer> values) {
      addCriterion("task_level not in", values, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelBetween(Integer value1, Integer value2) {
      addCriterion("task_level between", value1, value2, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskLevelNotBetween(Integer value1, Integer value2) {
      addCriterion("task_level not between", value1, value2, "taskLevel");
      return (Criteria) this;
    }

    public Criteria andTaskStateIsNull() {
      addCriterion("task_state is null");
      return (Criteria) this;
    }

    public Criteria andTaskStateIsNotNull() {
      addCriterion("task_state is not null");
      return (Criteria) this;
    }

    public Criteria andTaskStateEqualTo(Integer value) {
      addCriterion("task_state =", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateNotEqualTo(Integer value) {
      addCriterion("task_state <>", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateGreaterThan(Integer value) {
      addCriterion("task_state >", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateGreaterThanOrEqualTo(Integer value) {
      addCriterion("task_state >=", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateLessThan(Integer value) {
      addCriterion("task_state <", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateLessThanOrEqualTo(Integer value) {
      addCriterion("task_state <=", value, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateIn(List<Integer> values) {
      addCriterion("task_state in", values, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateNotIn(List<Integer> values) {
      addCriterion("task_state not in", values, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateBetween(Integer value1, Integer value2) {
      addCriterion("task_state between", value1, value2, "taskState");
      return (Criteria) this;
    }

    public Criteria andTaskStateNotBetween(Integer value1, Integer value2) {
      addCriterion("task_state not between", value1, value2, "taskState");
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

    public Criteria andPatrolTaskIdIsNull() {
      addCriterion("patrol_task_id is null");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdIsNotNull() {
      addCriterion("patrol_task_id is not null");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdEqualTo(String value) {
      addCriterion("patrol_task_id =", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdNotEqualTo(String value) {
      addCriterion("patrol_task_id <>", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdGreaterThan(String value) {
      addCriterion("patrol_task_id >", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdGreaterThanOrEqualTo(String value) {
      addCriterion("patrol_task_id >=", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdLessThan(String value) {
      addCriterion("patrol_task_id <", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdLessThanOrEqualTo(String value) {
      addCriterion("patrol_task_id <=", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdLike(String value) {
      addCriterion("patrol_task_id like", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdNotLike(String value) {
      addCriterion("patrol_task_id not like", value, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdIn(List<String> values) {
      addCriterion("patrol_task_id in", values, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdNotIn(List<String> values) {
      addCriterion("patrol_task_id not in", values, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdBetween(String value1, String value2) {
      addCriterion("patrol_task_id between", value1, value2, "patrolTaskId");
      return (Criteria) this;
    }

    public Criteria andPatrolTaskIdNotBetween(String value1, String value2) {
      addCriterion("patrol_task_id not between", value1, value2, "patrolTaskId");
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
