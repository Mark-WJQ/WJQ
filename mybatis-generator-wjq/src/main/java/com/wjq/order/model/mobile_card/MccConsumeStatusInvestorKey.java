package com.wjq.order.model.mobile_card;

/**
 * 资方大状态列表及前端按钮展示
 *
 * @author wjq
 * @date 2019/01/17
 */
public class MccConsumeStatusInvestorKey {
    /**
     * 
     */
    private Integer investorId;

    /**
     * 
     */
    private Integer statusId;

    /**
     * 
     */
    private Integer minStatusId;

    public Integer getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Integer investorId) {
        this.investorId = investorId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getMinStatusId() {
        return minStatusId;
    }

    public void setMinStatusId(Integer minStatusId) {
        this.minStatusId = minStatusId;
    }
}