package com.library.mana.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BooksBorrowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public BooksBorrowExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andPkIdIsNull() {
            addCriterion("pk_id is null");
            return (Criteria) this;
        }

        public Criteria andPkIdIsNotNull() {
            addCriterion("pk_id is not null");
            return (Criteria) this;
        }

        public Criteria andPkIdEqualTo(Integer value) {
            addCriterion("pk_id =", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotEqualTo(Integer value) {
            addCriterion("pk_id <>", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdGreaterThan(Integer value) {
            addCriterion("pk_id >", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk_id >=", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLessThan(Integer value) {
            addCriterion("pk_id <", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLessThanOrEqualTo(Integer value) {
            addCriterion("pk_id <=", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdIn(List<Integer> values) {
            addCriterion("pk_id in", values, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotIn(List<Integer> values) {
            addCriterion("pk_id not in", values, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdBetween(Integer value1, Integer value2) {
            addCriterion("pk_id between", value1, value2, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pk_id not between", value1, value2, "pkId");
            return (Criteria) this;
        }

        public Criteria andBooksIdIsNull() {
            addCriterion("books_id is null");
            return (Criteria) this;
        }

        public Criteria andBooksIdIsNotNull() {
            addCriterion("books_id is not null");
            return (Criteria) this;
        }

        public Criteria andBooksIdEqualTo(Integer value) {
            addCriterion("books_id =", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdNotEqualTo(Integer value) {
            addCriterion("books_id <>", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdGreaterThan(Integer value) {
            addCriterion("books_id >", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("books_id >=", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdLessThan(Integer value) {
            addCriterion("books_id <", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdLessThanOrEqualTo(Integer value) {
            addCriterion("books_id <=", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdIn(List<Integer> values) {
            addCriterion("books_id in", values, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdNotIn(List<Integer> values) {
            addCriterion("books_id not in", values, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdBetween(Integer value1, Integer value2) {
            addCriterion("books_id between", value1, value2, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdNotBetween(Integer value1, Integer value2) {
            addCriterion("books_id not between", value1, value2, "booksId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtReturnIsNull() {
            addCriterion("gmt_return is null");
            return (Criteria) this;
        }

        public Criteria andGmtReturnIsNotNull() {
            addCriterion("gmt_return is not null");
            return (Criteria) this;
        }

        public Criteria andGmtReturnEqualTo(Date value) {
            addCriterion("gmt_return =", value, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnNotEqualTo(Date value) {
            addCriterion("gmt_return <>", value, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnGreaterThan(Date value) {
            addCriterion("gmt_return >", value, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_return >=", value, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnLessThan(Date value) {
            addCriterion("gmt_return <", value, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnLessThanOrEqualTo(Date value) {
            addCriterion("gmt_return <=", value, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnIn(List<Date> values) {
            addCriterion("gmt_return in", values, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnNotIn(List<Date> values) {
            addCriterion("gmt_return not in", values, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnBetween(Date value1, Date value2) {
            addCriterion("gmt_return between", value1, value2, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andGmtReturnNotBetween(Date value1, Date value2) {
            addCriterion("gmt_return not between", value1, value2, "gmtReturn");
            return (Criteria) this;
        }

        public Criteria andFineIsNull() {
            addCriterion("fine is null");
            return (Criteria) this;
        }

        public Criteria andFineIsNotNull() {
            addCriterion("fine is not null");
            return (Criteria) this;
        }

        public Criteria andFineEqualTo(BigDecimal value) {
            addCriterion("fine =", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotEqualTo(BigDecimal value) {
            addCriterion("fine <>", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThan(BigDecimal value) {
            addCriterion("fine >", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fine >=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThan(BigDecimal value) {
            addCriterion("fine <", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fine <=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineIn(List<BigDecimal> values) {
            addCriterion("fine in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotIn(List<BigDecimal> values) {
            addCriterion("fine not in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fine between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fine not between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andActualReturnIsNull() {
            addCriterion("actual_return is null");
            return (Criteria) this;
        }

        public Criteria andActualReturnIsNotNull() {
            addCriterion("actual_return is not null");
            return (Criteria) this;
        }

        public Criteria andActualReturnEqualTo(Date value) {
            addCriterion("actual_return =", value, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnNotEqualTo(Date value) {
            addCriterion("actual_return <>", value, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnGreaterThan(Date value) {
            addCriterion("actual_return >", value, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_return >=", value, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnLessThan(Date value) {
            addCriterion("actual_return <", value, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnLessThanOrEqualTo(Date value) {
            addCriterion("actual_return <=", value, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnIn(List<Date> values) {
            addCriterion("actual_return in", values, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnNotIn(List<Date> values) {
            addCriterion("actual_return not in", values, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnBetween(Date value1, Date value2) {
            addCriterion("actual_return between", value1, value2, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andActualReturnNotBetween(Date value1, Date value2) {
            addCriterion("actual_return not between", value1, value2, "actualReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnIsNull() {
            addCriterion("is_return is null");
            return (Criteria) this;
        }

        public Criteria andIsReturnIsNotNull() {
            addCriterion("is_return is not null");
            return (Criteria) this;
        }

        public Criteria andIsReturnEqualTo(Integer value) {
            addCriterion("is_return =", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotEqualTo(Integer value) {
            addCriterion("is_return <>", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnGreaterThan(Integer value) {
            addCriterion("is_return >", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_return >=", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnLessThan(Integer value) {
            addCriterion("is_return <", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnLessThanOrEqualTo(Integer value) {
            addCriterion("is_return <=", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnIn(List<Integer> values) {
            addCriterion("is_return in", values, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotIn(List<Integer> values) {
            addCriterion("is_return not in", values, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnBetween(Integer value1, Integer value2) {
            addCriterion("is_return between", value1, value2, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotBetween(Integer value1, Integer value2) {
            addCriterion("is_return not between", value1, value2, "isReturn");
            return (Criteria) this;
        }
    }

    /**
     */
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