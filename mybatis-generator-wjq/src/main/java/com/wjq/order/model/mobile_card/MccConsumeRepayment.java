package com.wjq.order.model.mobile_card;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author wjq
 * @date 2019/01/17
 */
public class MccConsumeRepayment {
    /**
     * 
     */
    private Long id;

    /**
     * 历史是否存在逾期
     */
    private Integer historyIsOverdue;

    /**
     * 逾期金额
     */
    private BigDecimal overdueAmount;

    /**
     * 逾期天数
     */
    private Integer overdueDay;

    /**
     * 期数
     */
    private Integer periods;

    /**
     * 实际还款金额
     */
    private BigDecimal realAmount;

    /**
     * 还款金额应还
     */
    private BigDecimal remainAmount;

    /**
     * 应还金额
     */
    private BigDecimal shouldAmount;

    /**
     * 应还日期
     */
    private LocalDate shouldDate;

    /**
     * 0:未还款 1:逾期 2:还清
     */
    private Integer repaymentStatus;

    /**
     * 
     */
    private Long consumeId;

    /**
     * 还款完成时间
     */
    private LocalDateTime endDate;

    /**
     * 还款状态 （0:未还款,1：手动还款,2：系统代收还款,3连连还款，4银联还款，5微信支付）
     */
    private Integer playStatusId;

    /**
     * 资方平台通知状态:0:未通知(默认);1:已通知
     */
    private Byte capitalNotifyStatus;

    /**
     * 第三方通知状态:0:未通知(默认);1:已通知
     */
    private Byte thirdNotifyStatus;

    /**
     * 
     */
    private BigDecimal cutAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHistoryIsOverdue() {
        return historyIsOverdue;
    }

    public void setHistoryIsOverdue(Integer historyIsOverdue) {
        this.historyIsOverdue = historyIsOverdue;
    }

    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    public BigDecimal getShouldAmount() {
        return shouldAmount;
    }

    public void setShouldAmount(BigDecimal shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    public LocalDate getShouldDate() {
        return shouldDate;
    }

    public void setShouldDate(LocalDate shouldDate) {
        this.shouldDate = shouldDate;
    }

    public Integer getRepaymentStatus() {
        return repaymentStatus;
    }

    public void setRepaymentStatus(Integer repaymentStatus) {
        this.repaymentStatus = repaymentStatus;
    }

    public Long getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(Long consumeId) {
        this.consumeId = consumeId;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPlayStatusId() {
        return playStatusId;
    }

    public void setPlayStatusId(Integer playStatusId) {
        this.playStatusId = playStatusId;
    }

    public Byte getCapitalNotifyStatus() {
        return capitalNotifyStatus;
    }

    public void setCapitalNotifyStatus(Byte capitalNotifyStatus) {
        this.capitalNotifyStatus = capitalNotifyStatus;
    }

    public Byte getThirdNotifyStatus() {
        return thirdNotifyStatus;
    }

    public void setThirdNotifyStatus(Byte thirdNotifyStatus) {
        this.thirdNotifyStatus = thirdNotifyStatus;
    }

    public BigDecimal getCutAmount() {
        return cutAmount;
    }

    public void setCutAmount(BigDecimal cutAmount) {
        this.cutAmount = cutAmount;
    }
}