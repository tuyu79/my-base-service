package com.turan.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public DevInfoExample() {
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

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
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

        public Criteria andDevNoIsNull() {
            addCriterion("dev_no is null");
            return (Criteria) this;
        }

        public Criteria andDevNoIsNotNull() {
            addCriterion("dev_no is not null");
            return (Criteria) this;
        }

        public Criteria andDevNoEqualTo(Long value) {
            addCriterion("dev_no =", value, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoNotEqualTo(Long value) {
            addCriterion("dev_no <>", value, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoGreaterThan(Long value) {
            addCriterion("dev_no >", value, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoGreaterThanOrEqualTo(Long value) {
            addCriterion("dev_no >=", value, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoLessThan(Long value) {
            addCriterion("dev_no <", value, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoLessThanOrEqualTo(Long value) {
            addCriterion("dev_no <=", value, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoIn(List<Long> values) {
            addCriterion("dev_no in", values, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoNotIn(List<Long> values) {
            addCriterion("dev_no not in", values, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoBetween(Long value1, Long value2) {
            addCriterion("dev_no between", value1, value2, "devNo");
            return (Criteria) this;
        }

        public Criteria andDevNoNotBetween(Long value1, Long value2) {
            addCriterion("dev_no not between", value1, value2, "devNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoIsNull() {
            addCriterion("sim_card_no is null");
            return (Criteria) this;
        }

        public Criteria andSimCardNoIsNotNull() {
            addCriterion("sim_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andSimCardNoEqualTo(String value) {
            addCriterion("sim_card_no =", value, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoNotEqualTo(String value) {
            addCriterion("sim_card_no <>", value, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoGreaterThan(String value) {
            addCriterion("sim_card_no >", value, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("sim_card_no >=", value, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoLessThan(String value) {
            addCriterion("sim_card_no <", value, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoLessThanOrEqualTo(String value) {
            addCriterion("sim_card_no <=", value, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoLike(String value) {
            addCriterion("sim_card_no like", value, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoNotLike(String value) {
            addCriterion("sim_card_no not like", value, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoIn(List<String> values) {
            addCriterion("sim_card_no in", values, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoNotIn(List<String> values) {
            addCriterion("sim_card_no not in", values, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoBetween(String value1, String value2) {
            addCriterion("sim_card_no between", value1, value2, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andSimCardNoNotBetween(String value1, String value2) {
            addCriterion("sim_card_no not between", value1, value2, "simCardNo");
            return (Criteria) this;
        }

        public Criteria andDevTypeIsNull() {
            addCriterion("dev_type is null");
            return (Criteria) this;
        }

        public Criteria andDevTypeIsNotNull() {
            addCriterion("dev_type is not null");
            return (Criteria) this;
        }

        public Criteria andDevTypeEqualTo(Integer value) {
            addCriterion("dev_type =", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotEqualTo(Integer value) {
            addCriterion("dev_type <>", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeGreaterThan(Integer value) {
            addCriterion("dev_type >", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dev_type >=", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeLessThan(Integer value) {
            addCriterion("dev_type <", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dev_type <=", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeIn(List<Integer> values) {
            addCriterion("dev_type in", values, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotIn(List<Integer> values) {
            addCriterion("dev_type not in", values, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeBetween(Integer value1, Integer value2) {
            addCriterion("dev_type between", value1, value2, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dev_type not between", value1, value2, "devType");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNull() {
            addCriterion("dev_id is null");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNotNull() {
            addCriterion("dev_id is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdEqualTo(String value) {
            addCriterion("dev_id =", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotEqualTo(String value) {
            addCriterion("dev_id <>", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThan(String value) {
            addCriterion("dev_id >", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThanOrEqualTo(String value) {
            addCriterion("dev_id >=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThan(String value) {
            addCriterion("dev_id <", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThanOrEqualTo(String value) {
            addCriterion("dev_id <=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLike(String value) {
            addCriterion("dev_id like", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotLike(String value) {
            addCriterion("dev_id not like", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdIn(List<String> values) {
            addCriterion("dev_id in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotIn(List<String> values) {
            addCriterion("dev_id not in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdBetween(String value1, String value2) {
            addCriterion("dev_id between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotBetween(String value1, String value2) {
            addCriterion("dev_id not between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andChannelCountIsNull() {
            addCriterion("channel_count is null");
            return (Criteria) this;
        }

        public Criteria andChannelCountIsNotNull() {
            addCriterion("channel_count is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCountEqualTo(Integer value) {
            addCriterion("channel_count =", value, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountNotEqualTo(Integer value) {
            addCriterion("channel_count <>", value, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountGreaterThan(Integer value) {
            addCriterion("channel_count >", value, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_count >=", value, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountLessThan(Integer value) {
            addCriterion("channel_count <", value, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountLessThanOrEqualTo(Integer value) {
            addCriterion("channel_count <=", value, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountIn(List<Integer> values) {
            addCriterion("channel_count in", values, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountNotIn(List<Integer> values) {
            addCriterion("channel_count not in", values, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountBetween(Integer value1, Integer value2) {
            addCriterion("channel_count between", value1, value2, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelCountNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_count not between", value1, value2, "channelCount");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledIsNull() {
            addCriterion("channel_enabled is null");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledIsNotNull() {
            addCriterion("channel_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledEqualTo(String value) {
            addCriterion("channel_enabled =", value, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledNotEqualTo(String value) {
            addCriterion("channel_enabled <>", value, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledGreaterThan(String value) {
            addCriterion("channel_enabled >", value, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("channel_enabled >=", value, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledLessThan(String value) {
            addCriterion("channel_enabled <", value, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledLessThanOrEqualTo(String value) {
            addCriterion("channel_enabled <=", value, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledLike(String value) {
            addCriterion("channel_enabled like", value, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledNotLike(String value) {
            addCriterion("channel_enabled not like", value, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledIn(List<String> values) {
            addCriterion("channel_enabled in", values, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledNotIn(List<String> values) {
            addCriterion("channel_enabled not in", values, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledBetween(String value1, String value2) {
            addCriterion("channel_enabled between", value1, value2, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andChannelEnabledNotBetween(String value1, String value2) {
            addCriterion("channel_enabled not between", value1, value2, "channelEnabled");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIsNull() {
            addCriterion("protocol_type is null");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIsNotNull() {
            addCriterion("protocol_type is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeEqualTo(Integer value) {
            addCriterion("protocol_type =", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotEqualTo(Integer value) {
            addCriterion("protocol_type <>", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeGreaterThan(Integer value) {
            addCriterion("protocol_type >", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("protocol_type >=", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLessThan(Integer value) {
            addCriterion("protocol_type <", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLessThanOrEqualTo(Integer value) {
            addCriterion("protocol_type <=", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIn(List<Integer> values) {
            addCriterion("protocol_type in", values, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotIn(List<Integer> values) {
            addCriterion("protocol_type not in", values, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeBetween(Integer value1, Integer value2) {
            addCriterion("protocol_type between", value1, value2, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("protocol_type not between", value1, value2, "protocolType");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIsNull() {
            addCriterion("auth_code is null");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIsNotNull() {
            addCriterion("auth_code is not null");
            return (Criteria) this;
        }

        public Criteria andAuthCodeEqualTo(String value) {
            addCriterion("auth_code =", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotEqualTo(String value) {
            addCriterion("auth_code <>", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeGreaterThan(String value) {
            addCriterion("auth_code >", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_code >=", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLessThan(String value) {
            addCriterion("auth_code <", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLessThanOrEqualTo(String value) {
            addCriterion("auth_code <=", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLike(String value) {
            addCriterion("auth_code like", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotLike(String value) {
            addCriterion("auth_code not like", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIn(List<String> values) {
            addCriterion("auth_code in", values, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotIn(List<String> values) {
            addCriterion("auth_code not in", values, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeBetween(String value1, String value2) {
            addCriterion("auth_code between", value1, value2, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotBetween(String value1, String value2) {
            addCriterion("auth_code not between", value1, value2, "authCode");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
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