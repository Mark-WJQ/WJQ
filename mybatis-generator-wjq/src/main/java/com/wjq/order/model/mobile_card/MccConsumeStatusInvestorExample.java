package com.wjq.order.model.mobile_card;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MccConsumeStatusInvestorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MccConsumeStatusInvestorExample() {
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

        public Criteria andInvestorIdIsNull() {
            addCriterion("investor_id is null");
            return (Criteria) this;
        }

        public Criteria andInvestorIdIsNotNull() {
            addCriterion("investor_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvestorIdEqualTo(Integer value) {
            addCriterion("investor_id =", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdNotEqualTo(Integer value) {
            addCriterion("investor_id <>", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdGreaterThan(Integer value) {
            addCriterion("investor_id >", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("investor_id >=", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdLessThan(Integer value) {
            addCriterion("investor_id <", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdLessThanOrEqualTo(Integer value) {
            addCriterion("investor_id <=", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdIn(List<Integer> values) {
            addCriterion("investor_id in", values, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdNotIn(List<Integer> values) {
            addCriterion("investor_id not in", values, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdBetween(Integer value1, Integer value2) {
            addCriterion("investor_id between", value1, value2, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("investor_id not between", value1, value2, "investorId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNull() {
            addCriterion("status_id is null");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNotNull() {
            addCriterion("status_id is not null");
            return (Criteria) this;
        }

        public Criteria andStatusIdEqualTo(Integer value) {
            addCriterion("status_id =", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotEqualTo(Integer value) {
            addCriterion("status_id <>", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThan(Integer value) {
            addCriterion("status_id >", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_id >=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThan(Integer value) {
            addCriterion("status_id <", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("status_id <=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIn(List<Integer> values) {
            addCriterion("status_id in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotIn(List<Integer> values) {
            addCriterion("status_id not in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("status_id between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("status_id not between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdIsNull() {
            addCriterion("min_status_id is null");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdIsNotNull() {
            addCriterion("min_status_id is not null");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdEqualTo(Integer value) {
            addCriterion("min_status_id =", value, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdNotEqualTo(Integer value) {
            addCriterion("min_status_id <>", value, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdGreaterThan(Integer value) {
            addCriterion("min_status_id >", value, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_status_id >=", value, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdLessThan(Integer value) {
            addCriterion("min_status_id <", value, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("min_status_id <=", value, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdIn(List<Integer> values) {
            addCriterion("min_status_id in", values, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdNotIn(List<Integer> values) {
            addCriterion("min_status_id not in", values, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("min_status_id between", value1, value2, "minStatusId");
            return (Criteria) this;
        }

        public Criteria andMinStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("min_status_id not between", value1, value2, "minStatusId");
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

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andBtnsIsNull() {
            addCriterion("btns is null");
            return (Criteria) this;
        }

        public Criteria andBtnsIsNotNull() {
            addCriterion("btns is not null");
            return (Criteria) this;
        }

        public Criteria andBtnsEqualTo(String value) {
            addCriterion("btns =", value, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsNotEqualTo(String value) {
            addCriterion("btns <>", value, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsGreaterThan(String value) {
            addCriterion("btns >", value, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsGreaterThanOrEqualTo(String value) {
            addCriterion("btns >=", value, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsLessThan(String value) {
            addCriterion("btns <", value, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsLessThanOrEqualTo(String value) {
            addCriterion("btns <=", value, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsLike(String value) {
            addCriterion("btns like", value, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsNotLike(String value) {
            addCriterion("btns not like", value, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsIn(List<String> values) {
            addCriterion("btns in", values, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsNotIn(List<String> values) {
            addCriterion("btns not in", values, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsBetween(String value1, String value2) {
            addCriterion("btns between", value1, value2, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnsNotBetween(String value1, String value2) {
            addCriterion("btns not between", value1, value2, "btns");
            return (Criteria) this;
        }

        public Criteria andBtnRuleIsNull() {
            addCriterion("btn_rule is null");
            return (Criteria) this;
        }

        public Criteria andBtnRuleIsNotNull() {
            addCriterion("btn_rule is not null");
            return (Criteria) this;
        }

        public Criteria andBtnRuleEqualTo(String value) {
            addCriterion("btn_rule =", value, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleNotEqualTo(String value) {
            addCriterion("btn_rule <>", value, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleGreaterThan(String value) {
            addCriterion("btn_rule >", value, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleGreaterThanOrEqualTo(String value) {
            addCriterion("btn_rule >=", value, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleLessThan(String value) {
            addCriterion("btn_rule <", value, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleLessThanOrEqualTo(String value) {
            addCriterion("btn_rule <=", value, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleLike(String value) {
            addCriterion("btn_rule like", value, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleNotLike(String value) {
            addCriterion("btn_rule not like", value, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleIn(List<String> values) {
            addCriterion("btn_rule in", values, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleNotIn(List<String> values) {
            addCriterion("btn_rule not in", values, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleBetween(String value1, String value2) {
            addCriterion("btn_rule between", value1, value2, "btnRule");
            return (Criteria) this;
        }

        public Criteria andBtnRuleNotBetween(String value1, String value2) {
            addCriterion("btn_rule not between", value1, value2, "btnRule");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealMessageIsNull() {
            addCriterion("real_message is null");
            return (Criteria) this;
        }

        public Criteria andRealMessageIsNotNull() {
            addCriterion("real_message is not null");
            return (Criteria) this;
        }

        public Criteria andRealMessageEqualTo(String value) {
            addCriterion("real_message =", value, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageNotEqualTo(String value) {
            addCriterion("real_message <>", value, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageGreaterThan(String value) {
            addCriterion("real_message >", value, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageGreaterThanOrEqualTo(String value) {
            addCriterion("real_message >=", value, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageLessThan(String value) {
            addCriterion("real_message <", value, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageLessThanOrEqualTo(String value) {
            addCriterion("real_message <=", value, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageLike(String value) {
            addCriterion("real_message like", value, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageNotLike(String value) {
            addCriterion("real_message not like", value, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageIn(List<String> values) {
            addCriterion("real_message in", values, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageNotIn(List<String> values) {
            addCriterion("real_message not in", values, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageBetween(String value1, String value2) {
            addCriterion("real_message between", value1, value2, "realMessage");
            return (Criteria) this;
        }

        public Criteria andRealMessageNotBetween(String value1, String value2) {
            addCriterion("real_message not between", value1, value2, "realMessage");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNull() {
            addCriterion("node_type is null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNotNull() {
            addCriterion("node_type is not null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeEqualTo(Integer value) {
            addCriterion("node_type =", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotEqualTo(Integer value) {
            addCriterion("node_type <>", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThan(Integer value) {
            addCriterion("node_type >", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_type >=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThan(Integer value) {
            addCriterion("node_type <", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("node_type <=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIn(List<Integer> values) {
            addCriterion("node_type in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotIn(List<Integer> values) {
            addCriterion("node_type not in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeBetween(Integer value1, Integer value2) {
            addCriterion("node_type between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("node_type not between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeIsNull() {
            addCriterion("is_default_node is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeIsNotNull() {
            addCriterion("is_default_node is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeEqualTo(Integer value) {
            addCriterion("is_default_node =", value, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeNotEqualTo(Integer value) {
            addCriterion("is_default_node <>", value, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeGreaterThan(Integer value) {
            addCriterion("is_default_node >", value, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_default_node >=", value, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeLessThan(Integer value) {
            addCriterion("is_default_node <", value, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeLessThanOrEqualTo(Integer value) {
            addCriterion("is_default_node <=", value, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeIn(List<Integer> values) {
            addCriterion("is_default_node in", values, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeNotIn(List<Integer> values) {
            addCriterion("is_default_node not in", values, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeBetween(Integer value1, Integer value2) {
            addCriterion("is_default_node between", value1, value2, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNodeNotBetween(Integer value1, Integer value2) {
            addCriterion("is_default_node not between", value1, value2, "isDefaultNode");
            return (Criteria) this;
        }

        public Criteria andMinStatusIsNull() {
            addCriterion("min_status is null");
            return (Criteria) this;
        }

        public Criteria andMinStatusIsNotNull() {
            addCriterion("min_status is not null");
            return (Criteria) this;
        }

        public Criteria andMinStatusEqualTo(String value) {
            addCriterion("min_status =", value, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusNotEqualTo(String value) {
            addCriterion("min_status <>", value, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusGreaterThan(String value) {
            addCriterion("min_status >", value, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusGreaterThanOrEqualTo(String value) {
            addCriterion("min_status >=", value, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusLessThan(String value) {
            addCriterion("min_status <", value, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusLessThanOrEqualTo(String value) {
            addCriterion("min_status <=", value, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusLike(String value) {
            addCriterion("min_status like", value, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusNotLike(String value) {
            addCriterion("min_status not like", value, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusIn(List<String> values) {
            addCriterion("min_status in", values, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusNotIn(List<String> values) {
            addCriterion("min_status not in", values, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusBetween(String value1, String value2) {
            addCriterion("min_status between", value1, value2, "minStatus");
            return (Criteria) this;
        }

        public Criteria andMinStatusNotBetween(String value1, String value2) {
            addCriterion("min_status not between", value1, value2, "minStatus");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(LocalDateTime value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(LocalDateTime value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(LocalDateTime value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(LocalDateTime value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<LocalDateTime> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<LocalDateTime> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(LocalDateTime value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(LocalDateTime value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(LocalDateTime value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(LocalDateTime value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<LocalDateTime> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<LocalDateTime> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdIsNull() {
            addCriterion("help_qa_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdIsNotNull() {
            addCriterion("help_qa_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdEqualTo(String value) {
            addCriterion("help_qa_detail_id =", value, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdNotEqualTo(String value) {
            addCriterion("help_qa_detail_id <>", value, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdGreaterThan(String value) {
            addCriterion("help_qa_detail_id >", value, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("help_qa_detail_id >=", value, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdLessThan(String value) {
            addCriterion("help_qa_detail_id <", value, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdLessThanOrEqualTo(String value) {
            addCriterion("help_qa_detail_id <=", value, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdLike(String value) {
            addCriterion("help_qa_detail_id like", value, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdNotLike(String value) {
            addCriterion("help_qa_detail_id not like", value, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdIn(List<String> values) {
            addCriterion("help_qa_detail_id in", values, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdNotIn(List<String> values) {
            addCriterion("help_qa_detail_id not in", values, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdBetween(String value1, String value2) {
            addCriterion("help_qa_detail_id between", value1, value2, "helpQaDetailId");
            return (Criteria) this;
        }

        public Criteria andHelpQaDetailIdNotBetween(String value1, String value2) {
            addCriterion("help_qa_detail_id not between", value1, value2, "helpQaDetailId");
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