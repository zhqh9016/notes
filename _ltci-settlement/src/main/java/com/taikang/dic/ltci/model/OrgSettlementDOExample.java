package com.taikang.dic.ltci.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgSettlementDOExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public OrgSettlementDOExample() {
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

    public Criteria andOrgSetCodeIsNull() {
      addCriterion("org_set_code is null");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeIsNotNull() {
      addCriterion("org_set_code is not null");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeEqualTo(String value) {
      addCriterion("org_set_code =", value, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeNotEqualTo(String value) {
      addCriterion("org_set_code <>", value, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeGreaterThan(String value) {
      addCriterion("org_set_code >", value, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeGreaterThanOrEqualTo(String value) {
      addCriterion("org_set_code >=", value, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeLessThan(String value) {
      addCriterion("org_set_code <", value, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeLessThanOrEqualTo(String value) {
      addCriterion("org_set_code <=", value, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeLike(String value) {
      addCriterion("org_set_code like", value, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeNotLike(String value) {
      addCriterion("org_set_code not like", value, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeIn(List<String> values) {
      addCriterion("org_set_code in", values, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeNotIn(List<String> values) {
      addCriterion("org_set_code not in", values, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeBetween(String value1, String value2) {
      addCriterion("org_set_code between", value1, value2, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andOrgSetCodeNotBetween(String value1, String value2) {
      addCriterion("org_set_code not between", value1, value2, "orgSetCode");
      return (Criteria) this;
    }

    public Criteria andSetDateIsNull() {
      addCriterion("set_date is null");
      return (Criteria) this;
    }

    public Criteria andSetDateIsNotNull() {
      addCriterion("set_date is not null");
      return (Criteria) this;
    }

    public Criteria andSetDateEqualTo(Date value) {
      addCriterion("set_date =", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateNotEqualTo(Date value) {
      addCriterion("set_date <>", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateGreaterThan(Date value) {
      addCriterion("set_date >", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateGreaterThanOrEqualTo(Date value) {
      addCriterion("set_date >=", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateLessThan(Date value) {
      addCriterion("set_date <", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateLessThanOrEqualTo(Date value) {
      addCriterion("set_date <=", value, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateIn(List<Date> values) {
      addCriterion("set_date in", values, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateNotIn(List<Date> values) {
      addCriterion("set_date not in", values, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateBetween(Date value1, Date value2) {
      addCriterion("set_date between", value1, value2, "setDate");
      return (Criteria) this;
    }

    public Criteria andSetDateNotBetween(Date value1, Date value2) {
      addCriterion("set_date not between", value1, value2, "setDate");
      return (Criteria) this;
    }

    public Criteria andOrgCodeIsNull() {
      addCriterion("org_code is null");
      return (Criteria) this;
    }

    public Criteria andOrgCodeIsNotNull() {
      addCriterion("org_code is not null");
      return (Criteria) this;
    }

    public Criteria andOrgCodeEqualTo(String value) {
      addCriterion("org_code =", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeNotEqualTo(String value) {
      addCriterion("org_code <>", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeGreaterThan(String value) {
      addCriterion("org_code >", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
      addCriterion("org_code >=", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeLessThan(String value) {
      addCriterion("org_code <", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeLessThanOrEqualTo(String value) {
      addCriterion("org_code <=", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeLike(String value) {
      addCriterion("org_code like", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeNotLike(String value) {
      addCriterion("org_code not like", value, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeIn(List<String> values) {
      addCriterion("org_code in", values, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeNotIn(List<String> values) {
      addCriterion("org_code not in", values, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeBetween(String value1, String value2) {
      addCriterion("org_code between", value1, value2, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgCodeNotBetween(String value1, String value2) {
      addCriterion("org_code not between", value1, value2, "orgCode");
      return (Criteria) this;
    }

    public Criteria andOrgNameIsNull() {
      addCriterion("org_name is null");
      return (Criteria) this;
    }

    public Criteria andOrgNameIsNotNull() {
      addCriterion("org_name is not null");
      return (Criteria) this;
    }

    public Criteria andOrgNameEqualTo(String value) {
      addCriterion("org_name =", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameNotEqualTo(String value) {
      addCriterion("org_name <>", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameGreaterThan(String value) {
      addCriterion("org_name >", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
      addCriterion("org_name >=", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameLessThan(String value) {
      addCriterion("org_name <", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameLessThanOrEqualTo(String value) {
      addCriterion("org_name <=", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameLike(String value) {
      addCriterion("org_name like", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameNotLike(String value) {
      addCriterion("org_name not like", value, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameIn(List<String> values) {
      addCriterion("org_name in", values, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameNotIn(List<String> values) {
      addCriterion("org_name not in", values, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameBetween(String value1, String value2) {
      addCriterion("org_name between", value1, value2, "orgName");
      return (Criteria) this;
    }

    public Criteria andOrgNameNotBetween(String value1, String value2) {
      addCriterion("org_name not between", value1, value2, "orgName");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeIsNull() {
      addCriterion("fee_starttime is null");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeIsNotNull() {
      addCriterion("fee_starttime is not null");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeEqualTo(Date value) {
      addCriterion("fee_starttime =", value, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeNotEqualTo(Date value) {
      addCriterion("fee_starttime <>", value, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeGreaterThan(Date value) {
      addCriterion("fee_starttime >", value, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeGreaterThanOrEqualTo(Date value) {
      addCriterion("fee_starttime >=", value, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeLessThan(Date value) {
      addCriterion("fee_starttime <", value, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeLessThanOrEqualTo(Date value) {
      addCriterion("fee_starttime <=", value, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeIn(List<Date> values) {
      addCriterion("fee_starttime in", values, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeNotIn(List<Date> values) {
      addCriterion("fee_starttime not in", values, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeBetween(Date value1, Date value2) {
      addCriterion("fee_starttime between", value1, value2, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeStarttimeNotBetween(Date value1, Date value2) {
      addCriterion("fee_starttime not between", value1, value2, "feeStarttime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeIsNull() {
      addCriterion("fee_endtime is null");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeIsNotNull() {
      addCriterion("fee_endtime is not null");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeEqualTo(Date value) {
      addCriterion("fee_endtime =", value, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeNotEqualTo(Date value) {
      addCriterion("fee_endtime <>", value, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeGreaterThan(Date value) {
      addCriterion("fee_endtime >", value, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeGreaterThanOrEqualTo(Date value) {
      addCriterion("fee_endtime >=", value, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeLessThan(Date value) {
      addCriterion("fee_endtime <", value, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeLessThanOrEqualTo(Date value) {
      addCriterion("fee_endtime <=", value, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeIn(List<Date> values) {
      addCriterion("fee_endtime in", values, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeNotIn(List<Date> values) {
      addCriterion("fee_endtime not in", values, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeBetween(Date value1, Date value2) {
      addCriterion("fee_endtime between", value1, value2, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andFeeEndtimeNotBetween(Date value1, Date value2) {
      addCriterion("fee_endtime not between", value1, value2, "feeEndtime");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountIsNull() {
      addCriterion("nurse_total_amount is null");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountIsNotNull() {
      addCriterion("nurse_total_amount is not null");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountEqualTo(BigDecimal value) {
      addCriterion("nurse_total_amount =", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountNotEqualTo(BigDecimal value) {
      addCriterion("nurse_total_amount <>", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountGreaterThan(BigDecimal value) {
      addCriterion("nurse_total_amount >", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("nurse_total_amount >=", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountLessThan(BigDecimal value) {
      addCriterion("nurse_total_amount <", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountLessThanOrEqualTo(BigDecimal value) {
      addCriterion("nurse_total_amount <=", value, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountIn(List<BigDecimal> values) {
      addCriterion("nurse_total_amount in", values, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountNotIn(List<BigDecimal> values) {
      addCriterion("nurse_total_amount not in", values, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("nurse_total_amount between", value1, value2, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andNurseTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("nurse_total_amount not between", value1, value2, "nurseTotalAmount");
      return (Criteria) this;
    }

    public Criteria andSiPayIsNull() {
      addCriterion("si_pay is null");
      return (Criteria) this;
    }

    public Criteria andSiPayIsNotNull() {
      addCriterion("si_pay is not null");
      return (Criteria) this;
    }

    public Criteria andSiPayEqualTo(BigDecimal value) {
      addCriterion("si_pay =", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayNotEqualTo(BigDecimal value) {
      addCriterion("si_pay <>", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayGreaterThan(BigDecimal value) {
      addCriterion("si_pay >", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("si_pay >=", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayLessThan(BigDecimal value) {
      addCriterion("si_pay <", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayLessThanOrEqualTo(BigDecimal value) {
      addCriterion("si_pay <=", value, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayIn(List<BigDecimal> values) {
      addCriterion("si_pay in", values, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayNotIn(List<BigDecimal> values) {
      addCriterion("si_pay not in", values, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("si_pay between", value1, value2, "siPay");
      return (Criteria) this;
    }

    public Criteria andSiPayNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("si_pay not between", value1, value2, "siPay");
      return (Criteria) this;
    }

    public Criteria andPaySelfIsNull() {
      addCriterion("pay_self is null");
      return (Criteria) this;
    }

    public Criteria andPaySelfIsNotNull() {
      addCriterion("pay_self is not null");
      return (Criteria) this;
    }

    public Criteria andPaySelfEqualTo(BigDecimal value) {
      addCriterion("pay_self =", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfNotEqualTo(BigDecimal value) {
      addCriterion("pay_self <>", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfGreaterThan(BigDecimal value) {
      addCriterion("pay_self >", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("pay_self >=", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfLessThan(BigDecimal value) {
      addCriterion("pay_self <", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfLessThanOrEqualTo(BigDecimal value) {
      addCriterion("pay_self <=", value, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfIn(List<BigDecimal> values) {
      addCriterion("pay_self in", values, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfNotIn(List<BigDecimal> values) {
      addCriterion("pay_self not in", values, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("pay_self between", value1, value2, "paySelf");
      return (Criteria) this;
    }

    public Criteria andPaySelfNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("pay_self not between", value1, value2, "paySelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfIsNull() {
      addCriterion("expense_self is null");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfIsNotNull() {
      addCriterion("expense_self is not null");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfEqualTo(BigDecimal value) {
      addCriterion("expense_self =", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfNotEqualTo(BigDecimal value) {
      addCriterion("expense_self <>", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfGreaterThan(BigDecimal value) {
      addCriterion("expense_self >", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("expense_self >=", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfLessThan(BigDecimal value) {
      addCriterion("expense_self <", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfLessThanOrEqualTo(BigDecimal value) {
      addCriterion("expense_self <=", value, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfIn(List<BigDecimal> values) {
      addCriterion("expense_self in", values, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfNotIn(List<BigDecimal> values) {
      addCriterion("expense_self not in", values, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("expense_self between", value1, value2, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andExpenseSelfNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("expense_self not between", value1, value2, "expenseSelf");
      return (Criteria) this;
    }

    public Criteria andAccountPayIsNull() {
      addCriterion("account_pay is null");
      return (Criteria) this;
    }

    public Criteria andAccountPayIsNotNull() {
      addCriterion("account_pay is not null");
      return (Criteria) this;
    }

    public Criteria andAccountPayEqualTo(BigDecimal value) {
      addCriterion("account_pay =", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayNotEqualTo(BigDecimal value) {
      addCriterion("account_pay <>", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayGreaterThan(BigDecimal value) {
      addCriterion("account_pay >", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("account_pay >=", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayLessThan(BigDecimal value) {
      addCriterion("account_pay <", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayLessThanOrEqualTo(BigDecimal value) {
      addCriterion("account_pay <=", value, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayIn(List<BigDecimal> values) {
      addCriterion("account_pay in", values, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayNotIn(List<BigDecimal> values) {
      addCriterion("account_pay not in", values, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account_pay between", value1, value2, "accountPay");
      return (Criteria) this;
    }

    public Criteria andAccountPayNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("account_pay not between", value1, value2, "accountPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayIsNull() {
      addCriterion("bank_card_pay is null");
      return (Criteria) this;
    }

    public Criteria andBankCardPayIsNotNull() {
      addCriterion("bank_card_pay is not null");
      return (Criteria) this;
    }

    public Criteria andBankCardPayEqualTo(BigDecimal value) {
      addCriterion("bank_card_pay =", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayNotEqualTo(BigDecimal value) {
      addCriterion("bank_card_pay <>", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayGreaterThan(BigDecimal value) {
      addCriterion("bank_card_pay >", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("bank_card_pay >=", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayLessThan(BigDecimal value) {
      addCriterion("bank_card_pay <", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayLessThanOrEqualTo(BigDecimal value) {
      addCriterion("bank_card_pay <=", value, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayIn(List<BigDecimal> values) {
      addCriterion("bank_card_pay in", values, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayNotIn(List<BigDecimal> values) {
      addCriterion("bank_card_pay not in", values, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bank_card_pay between", value1, value2, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andBankCardPayNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("bank_card_pay not between", value1, value2, "bankCardPay");
      return (Criteria) this;
    }

    public Criteria andAcountPayableIsNull() {
      addCriterion("acount_payable is null");
      return (Criteria) this;
    }

    public Criteria andAcountPayableIsNotNull() {
      addCriterion("acount_payable is not null");
      return (Criteria) this;
    }

    public Criteria andAcountPayableEqualTo(BigDecimal value) {
      addCriterion("acount_payable =", value, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableNotEqualTo(BigDecimal value) {
      addCriterion("acount_payable <>", value, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableGreaterThan(BigDecimal value) {
      addCriterion("acount_payable >", value, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("acount_payable >=", value, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableLessThan(BigDecimal value) {
      addCriterion("acount_payable <", value, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableLessThanOrEqualTo(BigDecimal value) {
      addCriterion("acount_payable <=", value, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableIn(List<BigDecimal> values) {
      addCriterion("acount_payable in", values, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableNotIn(List<BigDecimal> values) {
      addCriterion("acount_payable not in", values, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("acount_payable between", value1, value2, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andAcountPayableNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("acount_payable not between", value1, value2, "acountPayable");
      return (Criteria) this;
    }

    public Criteria andWarrantyIsNull() {
      addCriterion("warranty is null");
      return (Criteria) this;
    }

    public Criteria andWarrantyIsNotNull() {
      addCriterion("warranty is not null");
      return (Criteria) this;
    }

    public Criteria andWarrantyEqualTo(BigDecimal value) {
      addCriterion("warranty =", value, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyNotEqualTo(BigDecimal value) {
      addCriterion("warranty <>", value, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyGreaterThan(BigDecimal value) {
      addCriterion("warranty >", value, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("warranty >=", value, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyLessThan(BigDecimal value) {
      addCriterion("warranty <", value, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyLessThanOrEqualTo(BigDecimal value) {
      addCriterion("warranty <=", value, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyIn(List<BigDecimal> values) {
      addCriterion("warranty in", values, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyNotIn(List<BigDecimal> values) {
      addCriterion("warranty not in", values, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("warranty between", value1, value2, "warranty");
      return (Criteria) this;
    }

    public Criteria andWarrantyNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("warranty not between", value1, value2, "warranty");
      return (Criteria) this;
    }

    public Criteria andRealPayIsNull() {
      addCriterion("real_pay is null");
      return (Criteria) this;
    }

    public Criteria andRealPayIsNotNull() {
      addCriterion("real_pay is not null");
      return (Criteria) this;
    }

    public Criteria andRealPayEqualTo(BigDecimal value) {
      addCriterion("real_pay =", value, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayNotEqualTo(BigDecimal value) {
      addCriterion("real_pay <>", value, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayGreaterThan(BigDecimal value) {
      addCriterion("real_pay >", value, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("real_pay >=", value, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayLessThan(BigDecimal value) {
      addCriterion("real_pay <", value, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayLessThanOrEqualTo(BigDecimal value) {
      addCriterion("real_pay <=", value, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayIn(List<BigDecimal> values) {
      addCriterion("real_pay in", values, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayNotIn(List<BigDecimal> values) {
      addCriterion("real_pay not in", values, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("real_pay between", value1, value2, "realPay");
      return (Criteria) this;
    }

    public Criteria andRealPayNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("real_pay not between", value1, value2, "realPay");
      return (Criteria) this;
    }

    public Criteria andUnrFeeIsNull() {
      addCriterion("unr_fee is null");
      return (Criteria) this;
    }

    public Criteria andUnrFeeIsNotNull() {
      addCriterion("unr_fee is not null");
      return (Criteria) this;
    }

    public Criteria andUnrFeeEqualTo(BigDecimal value) {
      addCriterion("unr_fee =", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeNotEqualTo(BigDecimal value) {
      addCriterion("unr_fee <>", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeGreaterThan(BigDecimal value) {
      addCriterion("unr_fee >", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("unr_fee >=", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeLessThan(BigDecimal value) {
      addCriterion("unr_fee <", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeLessThanOrEqualTo(BigDecimal value) {
      addCriterion("unr_fee <=", value, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeIn(List<BigDecimal> values) {
      addCriterion("unr_fee in", values, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeNotIn(List<BigDecimal> values) {
      addCriterion("unr_fee not in", values, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("unr_fee between", value1, value2, "unrFee");
      return (Criteria) this;
    }

    public Criteria andUnrFeeNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("unr_fee not between", value1, value2, "unrFee");
      return (Criteria) this;
    }

    public Criteria andOverCostIsNull() {
      addCriterion("over_cost is null");
      return (Criteria) this;
    }

    public Criteria andOverCostIsNotNull() {
      addCriterion("over_cost is not null");
      return (Criteria) this;
    }

    public Criteria andOverCostEqualTo(BigDecimal value) {
      addCriterion("over_cost =", value, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostNotEqualTo(BigDecimal value) {
      addCriterion("over_cost <>", value, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostGreaterThan(BigDecimal value) {
      addCriterion("over_cost >", value, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("over_cost >=", value, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostLessThan(BigDecimal value) {
      addCriterion("over_cost <", value, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostLessThanOrEqualTo(BigDecimal value) {
      addCriterion("over_cost <=", value, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostIn(List<BigDecimal> values) {
      addCriterion("over_cost in", values, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostNotIn(List<BigDecimal> values) {
      addCriterion("over_cost not in", values, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("over_cost between", value1, value2, "overCost");
      return (Criteria) this;
    }

    public Criteria andOverCostNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("over_cost not between", value1, value2, "overCost");
      return (Criteria) this;
    }

    public Criteria andAuditStateIsNull() {
      addCriterion("audit_state is null");
      return (Criteria) this;
    }

    public Criteria andAuditStateIsNotNull() {
      addCriterion("audit_state is not null");
      return (Criteria) this;
    }

    public Criteria andAuditStateEqualTo(Integer value) {
      addCriterion("audit_state =", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateNotEqualTo(Integer value) {
      addCriterion("audit_state <>", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateGreaterThan(Integer value) {
      addCriterion("audit_state >", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateGreaterThanOrEqualTo(Integer value) {
      addCriterion("audit_state >=", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateLessThan(Integer value) {
      addCriterion("audit_state <", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateLessThanOrEqualTo(Integer value) {
      addCriterion("audit_state <=", value, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateIn(List<Integer> values) {
      addCriterion("audit_state in", values, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateNotIn(List<Integer> values) {
      addCriterion("audit_state not in", values, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateBetween(Integer value1, Integer value2) {
      addCriterion("audit_state between", value1, value2, "auditState");
      return (Criteria) this;
    }

    public Criteria andAuditStateNotBetween(Integer value1, Integer value2) {
      addCriterion("audit_state not between", value1, value2, "auditState");
      return (Criteria) this;
    }

    public Criteria andCheckFlagIsNull() {
      addCriterion("check_flag is null");
      return (Criteria) this;
    }

    public Criteria andCheckFlagIsNotNull() {
      addCriterion("check_flag is not null");
      return (Criteria) this;
    }

    public Criteria andCheckFlagEqualTo(Integer value) {
      addCriterion("check_flag =", value, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagNotEqualTo(Integer value) {
      addCriterion("check_flag <>", value, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagGreaterThan(Integer value) {
      addCriterion("check_flag >", value, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagGreaterThanOrEqualTo(Integer value) {
      addCriterion("check_flag >=", value, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagLessThan(Integer value) {
      addCriterion("check_flag <", value, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagLessThanOrEqualTo(Integer value) {
      addCriterion("check_flag <=", value, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagIn(List<Integer> values) {
      addCriterion("check_flag in", values, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagNotIn(List<Integer> values) {
      addCriterion("check_flag not in", values, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagBetween(Integer value1, Integer value2) {
      addCriterion("check_flag between", value1, value2, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andCheckFlagNotBetween(Integer value1, Integer value2) {
      addCriterion("check_flag not between", value1, value2, "checkFlag");
      return (Criteria) this;
    }

    public Criteria andRejectReasonIsNull() {
      addCriterion("reject_reason is null");
      return (Criteria) this;
    }

    public Criteria andRejectReasonIsNotNull() {
      addCriterion("reject_reason is not null");
      return (Criteria) this;
    }

    public Criteria andRejectReasonEqualTo(String value) {
      addCriterion("reject_reason =", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonNotEqualTo(String value) {
      addCriterion("reject_reason <>", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonGreaterThan(String value) {
      addCriterion("reject_reason >", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonGreaterThanOrEqualTo(String value) {
      addCriterion("reject_reason >=", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonLessThan(String value) {
      addCriterion("reject_reason <", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonLessThanOrEqualTo(String value) {
      addCriterion("reject_reason <=", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonLike(String value) {
      addCriterion("reject_reason like", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonNotLike(String value) {
      addCriterion("reject_reason not like", value, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonIn(List<String> values) {
      addCriterion("reject_reason in", values, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonNotIn(List<String> values) {
      addCriterion("reject_reason not in", values, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonBetween(String value1, String value2) {
      addCriterion("reject_reason between", value1, value2, "rejectReason");
      return (Criteria) this;
    }

    public Criteria andRejectReasonNotBetween(String value1, String value2) {
      addCriterion("reject_reason not between", value1, value2, "rejectReason");
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
