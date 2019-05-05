package com.wjq.order.model.mobile_card;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MccConsumeRepaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MccConsumeRepaymentExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueIsNull() {
            addCriterion("history_is_overdue is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueIsNotNull() {
            addCriterion("history_is_overdue is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueEqualTo(Integer value) {
            addCriterion("history_is_overdue =", value, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueNotEqualTo(Integer value) {
            addCriterion("history_is_overdue <>", value, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueGreaterThan(Integer value) {
            addCriterion("history_is_overdue >", value, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("history_is_overdue >=", value, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueLessThan(Integer value) {
            addCriterion("history_is_overdue <", value, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueLessThanOrEqualTo(Integer value) {
            addCriterion("history_is_overdue <=", value, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueIn(List<Integer> values) {
            addCriterion("history_is_overdue in", values, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueNotIn(List<Integer> values) {
            addCriterion("history_is_overdue not in", values, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueBetween(Integer value1, Integer value2) {
            addCriterion("history_is_overdue between", value1, value2, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andHistoryIsOverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("history_is_overdue not between", value1, value2, "historyIsOverdue");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIsNull() {
            addCriterion("overdue_amount is null");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIsNotNull() {
            addCriterion("overdue_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountEqualTo(BigDecimal value) {
            addCriterion("overdue_amount =", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotEqualTo(BigDecimal value) {
            addCriterion("overdue_amount <>", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountGreaterThan(BigDecimal value) {
            addCriterion("overdue_amount >", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overdue_amount >=", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountLessThan(BigDecimal value) {
            addCriterion("overdue_amount <", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overdue_amount <=", value, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountIn(List<BigDecimal> values) {
            addCriterion("overdue_amount in", values, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotIn(List<BigDecimal> values) {
            addCriterion("overdue_amount not in", values, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdue_amount between", value1, value2, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdue_amount not between", value1, value2, "overdueAmount");
            return (Criteria) this;
        }

        public Criteria andOverdueDayIsNull() {
            addCriterion("overdue_day is null");
            return (Criteria) this;
        }

        public Criteria andOverdueDayIsNotNull() {
            addCriterion("overdue_day is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueDayEqualTo(Integer value) {
            addCriterion("overdue_day =", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayNotEqualTo(Integer value) {
            addCriterion("overdue_day <>", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayGreaterThan(Integer value) {
            addCriterion("overdue_day >", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue_day >=", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayLessThan(Integer value) {
            addCriterion("overdue_day <", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayLessThanOrEqualTo(Integer value) {
            addCriterion("overdue_day <=", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayIn(List<Integer> values) {
            addCriterion("overdue_day in", values, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayNotIn(List<Integer> values) {
            addCriterion("overdue_day not in", values, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayBetween(Integer value1, Integer value2) {
            addCriterion("overdue_day between", value1, value2, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayNotBetween(Integer value1, Integer value2) {
            addCriterion("overdue_day not between", value1, value2, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andPeriodsIsNull() {
            addCriterion("periods is null");
            return (Criteria) this;
        }

        public Criteria andPeriodsIsNotNull() {
            addCriterion("periods is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodsEqualTo(Integer value) {
            addCriterion("periods =", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsNotEqualTo(Integer value) {
            addCriterion("periods <>", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsGreaterThan(Integer value) {
            addCriterion("periods >", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("periods >=", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsLessThan(Integer value) {
            addCriterion("periods <", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsLessThanOrEqualTo(Integer value) {
            addCriterion("periods <=", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsIn(List<Integer> values) {
            addCriterion("periods in", values, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsNotIn(List<Integer> values) {
            addCriterion("periods not in", values, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsBetween(Integer value1, Integer value2) {
            addCriterion("periods between", value1, value2, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsNotBetween(Integer value1, Integer value2) {
            addCriterion("periods not between", value1, value2, "periods");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNull() {
            addCriterion("real_amount is null");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNotNull() {
            addCriterion("real_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRealAmountEqualTo(BigDecimal value) {
            addCriterion("real_amount =", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotEqualTo(BigDecimal value) {
            addCriterion("real_amount <>", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThan(BigDecimal value) {
            addCriterion("real_amount >", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_amount >=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThan(BigDecimal value) {
            addCriterion("real_amount <", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_amount <=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountIn(List<BigDecimal> values) {
            addCriterion("real_amount in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotIn(List<BigDecimal> values) {
            addCriterion("real_amount not in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_amount between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_amount not between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIsNull() {
            addCriterion("remain_amount is null");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIsNotNull() {
            addCriterion("remain_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRemainAmountEqualTo(BigDecimal value) {
            addCriterion("remain_amount =", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotEqualTo(BigDecimal value) {
            addCriterion("remain_amount <>", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountGreaterThan(BigDecimal value) {
            addCriterion("remain_amount >", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("remain_amount >=", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountLessThan(BigDecimal value) {
            addCriterion("remain_amount <", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("remain_amount <=", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIn(List<BigDecimal> values) {
            addCriterion("remain_amount in", values, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotIn(List<BigDecimal> values) {
            addCriterion("remain_amount not in", values, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remain_amount between", value1, value2, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remain_amount not between", value1, value2, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountIsNull() {
            addCriterion("should_amount is null");
            return (Criteria) this;
        }

        public Criteria andShouldAmountIsNotNull() {
            addCriterion("should_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShouldAmountEqualTo(BigDecimal value) {
            addCriterion("should_amount =", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountNotEqualTo(BigDecimal value) {
            addCriterion("should_amount <>", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountGreaterThan(BigDecimal value) {
            addCriterion("should_amount >", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("should_amount >=", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountLessThan(BigDecimal value) {
            addCriterion("should_amount <", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("should_amount <=", value, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountIn(List<BigDecimal> values) {
            addCriterion("should_amount in", values, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountNotIn(List<BigDecimal> values) {
            addCriterion("should_amount not in", values, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("should_amount between", value1, value2, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("should_amount not between", value1, value2, "shouldAmount");
            return (Criteria) this;
        }

        public Criteria andShouldDateIsNull() {
            addCriterion("should_date is null");
            return (Criteria) this;
        }

        public Criteria andShouldDateIsNotNull() {
            addCriterion("should_date is not null");
            return (Criteria) this;
        }

        public Criteria andShouldDateEqualTo(LocalDate value) {
            addCriterion("should_date =", value, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateNotEqualTo(LocalDate value) {
            addCriterion("should_date <>", value, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateGreaterThan(LocalDate value) {
            addCriterion("should_date >", value, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("should_date >=", value, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateLessThan(LocalDate value) {
            addCriterion("should_date <", value, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateLessThanOrEqualTo(LocalDate value) {
            addCriterion("should_date <=", value, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateIn(List<LocalDate> values) {
            addCriterion("should_date in", values, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateNotIn(List<LocalDate> values) {
            addCriterion("should_date not in", values, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateBetween(LocalDate value1, LocalDate value2) {
            addCriterion("should_date between", value1, value2, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andShouldDateNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("should_date not between", value1, value2, "shouldDate");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusIsNull() {
            addCriterion("repayment_status is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusIsNotNull() {
            addCriterion("repayment_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusEqualTo(Integer value) {
            addCriterion("repayment_status =", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusNotEqualTo(Integer value) {
            addCriterion("repayment_status <>", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusGreaterThan(Integer value) {
            addCriterion("repayment_status >", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_status >=", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusLessThan(Integer value) {
            addCriterion("repayment_status <", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_status <=", value, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusIn(List<Integer> values) {
            addCriterion("repayment_status in", values, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusNotIn(List<Integer> values) {
            addCriterion("repayment_status not in", values, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusBetween(Integer value1, Integer value2) {
            addCriterion("repayment_status between", value1, value2, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andRepaymentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_status not between", value1, value2, "repaymentStatus");
            return (Criteria) this;
        }

        public Criteria andConsumeIdIsNull() {
            addCriterion("consume_id is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIdIsNotNull() {
            addCriterion("consume_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeIdEqualTo(Long value) {
            addCriterion("consume_id =", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotEqualTo(Long value) {
            addCriterion("consume_id <>", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdGreaterThan(Long value) {
            addCriterion("consume_id >", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("consume_id >=", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdLessThan(Long value) {
            addCriterion("consume_id <", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdLessThanOrEqualTo(Long value) {
            addCriterion("consume_id <=", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdIn(List<Long> values) {
            addCriterion("consume_id in", values, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotIn(List<Long> values) {
            addCriterion("consume_id not in", values, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdBetween(Long value1, Long value2) {
            addCriterion("consume_id between", value1, value2, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotBetween(Long value1, Long value2) {
            addCriterion("consume_id not between", value1, value2, "consumeId");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(LocalDateTime value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(LocalDateTime value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(LocalDateTime value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(LocalDateTime value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<LocalDateTime> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<LocalDateTime> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdIsNull() {
            addCriterion("play_status_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdIsNotNull() {
            addCriterion("play_status_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdEqualTo(Integer value) {
            addCriterion("play_status_id =", value, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdNotEqualTo(Integer value) {
            addCriterion("play_status_id <>", value, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdGreaterThan(Integer value) {
            addCriterion("play_status_id >", value, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_status_id >=", value, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdLessThan(Integer value) {
            addCriterion("play_status_id <", value, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("play_status_id <=", value, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdIn(List<Integer> values) {
            addCriterion("play_status_id in", values, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdNotIn(List<Integer> values) {
            addCriterion("play_status_id not in", values, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("play_status_id between", value1, value2, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("play_status_id not between", value1, value2, "playStatusId");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusIsNull() {
            addCriterion("capital_notify_status is null");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusIsNotNull() {
            addCriterion("capital_notify_status is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusEqualTo(Byte value) {
            addCriterion("capital_notify_status =", value, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusNotEqualTo(Byte value) {
            addCriterion("capital_notify_status <>", value, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusGreaterThan(Byte value) {
            addCriterion("capital_notify_status >", value, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("capital_notify_status >=", value, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusLessThan(Byte value) {
            addCriterion("capital_notify_status <", value, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("capital_notify_status <=", value, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusIn(List<Byte> values) {
            addCriterion("capital_notify_status in", values, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusNotIn(List<Byte> values) {
            addCriterion("capital_notify_status not in", values, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusBetween(Byte value1, Byte value2) {
            addCriterion("capital_notify_status between", value1, value2, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCapitalNotifyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("capital_notify_status not between", value1, value2, "capitalNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusIsNull() {
            addCriterion("third_notify_status is null");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusIsNotNull() {
            addCriterion("third_notify_status is not null");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusEqualTo(Byte value) {
            addCriterion("third_notify_status =", value, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusNotEqualTo(Byte value) {
            addCriterion("third_notify_status <>", value, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusGreaterThan(Byte value) {
            addCriterion("third_notify_status >", value, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("third_notify_status >=", value, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusLessThan(Byte value) {
            addCriterion("third_notify_status <", value, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("third_notify_status <=", value, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusIn(List<Byte> values) {
            addCriterion("third_notify_status in", values, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusNotIn(List<Byte> values) {
            addCriterion("third_notify_status not in", values, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusBetween(Byte value1, Byte value2) {
            addCriterion("third_notify_status between", value1, value2, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andThirdNotifyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("third_notify_status not between", value1, value2, "thirdNotifyStatus");
            return (Criteria) this;
        }

        public Criteria andCutAmountIsNull() {
            addCriterion("cut_amount is null");
            return (Criteria) this;
        }

        public Criteria andCutAmountIsNotNull() {
            addCriterion("cut_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCutAmountEqualTo(BigDecimal value) {
            addCriterion("cut_amount =", value, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountNotEqualTo(BigDecimal value) {
            addCriterion("cut_amount <>", value, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountGreaterThan(BigDecimal value) {
            addCriterion("cut_amount >", value, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cut_amount >=", value, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountLessThan(BigDecimal value) {
            addCriterion("cut_amount <", value, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cut_amount <=", value, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountIn(List<BigDecimal> values) {
            addCriterion("cut_amount in", values, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountNotIn(List<BigDecimal> values) {
            addCriterion("cut_amount not in", values, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cut_amount between", value1, value2, "cutAmount");
            return (Criteria) this;
        }

        public Criteria andCutAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cut_amount not between", value1, value2, "cutAmount");
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