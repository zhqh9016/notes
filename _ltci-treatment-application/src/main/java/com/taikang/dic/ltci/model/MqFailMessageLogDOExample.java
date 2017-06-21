package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MqFailMessageLogDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public MqFailMessageLogDOExample() {
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

    public Criteria andRetryNumIsNull() {
      addCriterion("retry_num is null");
      return (Criteria) this;
    }

    public Criteria andRetryNumIsNotNull() {
      addCriterion("retry_num is not null");
      return (Criteria) this;
    }

    public Criteria andRetryNumEqualTo(Integer value) {
      addCriterion("retry_num =", value, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumNotEqualTo(Integer value) {
      addCriterion("retry_num <>", value, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumGreaterThan(Integer value) {
      addCriterion("retry_num >", value, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("retry_num >=", value, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumLessThan(Integer value) {
      addCriterion("retry_num <", value, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumLessThanOrEqualTo(Integer value) {
      addCriterion("retry_num <=", value, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumIn(List<Integer> values) {
      addCriterion("retry_num in", values, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumNotIn(List<Integer> values) {
      addCriterion("retry_num not in", values, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumBetween(Integer value1, Integer value2) {
      addCriterion("retry_num between", value1, value2, "retryNum");
      return (Criteria) this;
    }

    public Criteria andRetryNumNotBetween(Integer value1, Integer value2) {
      addCriterion("retry_num not between", value1, value2, "retryNum");
      return (Criteria) this;
    }

    public Criteria andTransportTypeIsNull() {
      addCriterion("transport_type is null");
      return (Criteria) this;
    }

    public Criteria andTransportTypeIsNotNull() {
      addCriterion("transport_type is not null");
      return (Criteria) this;
    }

    public Criteria andTransportTypeEqualTo(Integer value) {
      addCriterion("transport_type =", value, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeNotEqualTo(Integer value) {
      addCriterion("transport_type <>", value, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeGreaterThan(Integer value) {
      addCriterion("transport_type >", value, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("transport_type >=", value, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeLessThan(Integer value) {
      addCriterion("transport_type <", value, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeLessThanOrEqualTo(Integer value) {
      addCriterion("transport_type <=", value, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeIn(List<Integer> values) {
      addCriterion("transport_type in", values, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeNotIn(List<Integer> values) {
      addCriterion("transport_type not in", values, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeBetween(Integer value1, Integer value2) {
      addCriterion("transport_type between", value1, value2, "transportType");
      return (Criteria) this;
    }

    public Criteria andTransportTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("transport_type not between", value1, value2, "transportType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeIsNull() {
      addCriterion("operation_type is null");
      return (Criteria) this;
    }

    public Criteria andOperationTypeIsNotNull() {
      addCriterion("operation_type is not null");
      return (Criteria) this;
    }

    public Criteria andOperationTypeEqualTo(Integer value) {
      addCriterion("operation_type =", value, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeNotEqualTo(Integer value) {
      addCriterion("operation_type <>", value, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeGreaterThan(Integer value) {
      addCriterion("operation_type >", value, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeGreaterThanOrEqualTo(Integer value) {
      addCriterion("operation_type >=", value, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeLessThan(Integer value) {
      addCriterion("operation_type <", value, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeLessThanOrEqualTo(Integer value) {
      addCriterion("operation_type <=", value, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeIn(List<Integer> values) {
      addCriterion("operation_type in", values, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeNotIn(List<Integer> values) {
      addCriterion("operation_type not in", values, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeBetween(Integer value1, Integer value2) {
      addCriterion("operation_type between", value1, value2, "operationType");
      return (Criteria) this;
    }

    public Criteria andOperationTypeNotBetween(Integer value1, Integer value2) {
      addCriterion("operation_type not between", value1, value2, "operationType");
      return (Criteria) this;
    }

    public Criteria andRetryUrlIsNull() {
      addCriterion("retry_url is null");
      return (Criteria) this;
    }

    public Criteria andRetryUrlIsNotNull() {
      addCriterion("retry_url is not null");
      return (Criteria) this;
    }

    public Criteria andRetryUrlEqualTo(String value) {
      addCriterion("retry_url =", value, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlNotEqualTo(String value) {
      addCriterion("retry_url <>", value, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlGreaterThan(String value) {
      addCriterion("retry_url >", value, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlGreaterThanOrEqualTo(String value) {
      addCriterion("retry_url >=", value, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlLessThan(String value) {
      addCriterion("retry_url <", value, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlLessThanOrEqualTo(String value) {
      addCriterion("retry_url <=", value, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlLike(String value) {
      addCriterion("retry_url like", value, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlNotLike(String value) {
      addCriterion("retry_url not like", value, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlIn(List<String> values) {
      addCriterion("retry_url in", values, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlNotIn(List<String> values) {
      addCriterion("retry_url not in", values, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlBetween(String value1, String value2) {
      addCriterion("retry_url between", value1, value2, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andRetryUrlNotBetween(String value1, String value2) {
      addCriterion("retry_url not between", value1, value2, "retryUrl");
      return (Criteria) this;
    }

    public Criteria andHttpActionIsNull() {
      addCriterion("http_action is null");
      return (Criteria) this;
    }

    public Criteria andHttpActionIsNotNull() {
      addCriterion("http_action is not null");
      return (Criteria) this;
    }

    public Criteria andHttpActionEqualTo(String value) {
      addCriterion("http_action =", value, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionNotEqualTo(String value) {
      addCriterion("http_action <>", value, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionGreaterThan(String value) {
      addCriterion("http_action >", value, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionGreaterThanOrEqualTo(String value) {
      addCriterion("http_action >=", value, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionLessThan(String value) {
      addCriterion("http_action <", value, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionLessThanOrEqualTo(String value) {
      addCriterion("http_action <=", value, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionLike(String value) {
      addCriterion("http_action like", value, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionNotLike(String value) {
      addCriterion("http_action not like", value, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionIn(List<String> values) {
      addCriterion("http_action in", values, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionNotIn(List<String> values) {
      addCriterion("http_action not in", values, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionBetween(String value1, String value2) {
      addCriterion("http_action between", value1, value2, "httpAction");
      return (Criteria) this;
    }

    public Criteria andHttpActionNotBetween(String value1, String value2) {
      addCriterion("http_action not between", value1, value2, "httpAction");
      return (Criteria) this;
    }

    public Criteria andErrorMessageIsNull() {
      addCriterion("error_message is null");
      return (Criteria) this;
    }

    public Criteria andErrorMessageIsNotNull() {
      addCriterion("error_message is not null");
      return (Criteria) this;
    }

    public Criteria andErrorMessageEqualTo(String value) {
      addCriterion("error_message =", value, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageNotEqualTo(String value) {
      addCriterion("error_message <>", value, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageGreaterThan(String value) {
      addCriterion("error_message >", value, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageGreaterThanOrEqualTo(String value) {
      addCriterion("error_message >=", value, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageLessThan(String value) {
      addCriterion("error_message <", value, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageLessThanOrEqualTo(String value) {
      addCriterion("error_message <=", value, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageLike(String value) {
      addCriterion("error_message like", value, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageNotLike(String value) {
      addCriterion("error_message not like", value, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageIn(List<String> values) {
      addCriterion("error_message in", values, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageNotIn(List<String> values) {
      addCriterion("error_message not in", values, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageBetween(String value1, String value2) {
      addCriterion("error_message between", value1, value2, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andErrorMessageNotBetween(String value1, String value2) {
      addCriterion("error_message not between", value1, value2, "errorMessage");
      return (Criteria) this;
    }

    public Criteria andExchangeNameIsNull() {
      addCriterion("exchange_name is null");
      return (Criteria) this;
    }

    public Criteria andExchangeNameIsNotNull() {
      addCriterion("exchange_name is not null");
      return (Criteria) this;
    }

    public Criteria andExchangeNameEqualTo(String value) {
      addCriterion("exchange_name =", value, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameNotEqualTo(String value) {
      addCriterion("exchange_name <>", value, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameGreaterThan(String value) {
      addCriterion("exchange_name >", value, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameGreaterThanOrEqualTo(String value) {
      addCriterion("exchange_name >=", value, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameLessThan(String value) {
      addCriterion("exchange_name <", value, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameLessThanOrEqualTo(String value) {
      addCriterion("exchange_name <=", value, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameLike(String value) {
      addCriterion("exchange_name like", value, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameNotLike(String value) {
      addCriterion("exchange_name not like", value, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameIn(List<String> values) {
      addCriterion("exchange_name in", values, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameNotIn(List<String> values) {
      addCriterion("exchange_name not in", values, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameBetween(String value1, String value2) {
      addCriterion("exchange_name between", value1, value2, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andExchangeNameNotBetween(String value1, String value2) {
      addCriterion("exchange_name not between", value1, value2, "exchangeName");
      return (Criteria) this;
    }

    public Criteria andQueryNameIsNull() {
      addCriterion("query_name is null");
      return (Criteria) this;
    }

    public Criteria andQueryNameIsNotNull() {
      addCriterion("query_name is not null");
      return (Criteria) this;
    }

    public Criteria andQueryNameEqualTo(String value) {
      addCriterion("query_name =", value, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameNotEqualTo(String value) {
      addCriterion("query_name <>", value, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameGreaterThan(String value) {
      addCriterion("query_name >", value, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameGreaterThanOrEqualTo(String value) {
      addCriterion("query_name >=", value, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameLessThan(String value) {
      addCriterion("query_name <", value, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameLessThanOrEqualTo(String value) {
      addCriterion("query_name <=", value, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameLike(String value) {
      addCriterion("query_name like", value, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameNotLike(String value) {
      addCriterion("query_name not like", value, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameIn(List<String> values) {
      addCriterion("query_name in", values, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameNotIn(List<String> values) {
      addCriterion("query_name not in", values, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameBetween(String value1, String value2) {
      addCriterion("query_name between", value1, value2, "queryName");
      return (Criteria) this;
    }

    public Criteria andQueryNameNotBetween(String value1, String value2) {
      addCriterion("query_name not between", value1, value2, "queryName");
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
