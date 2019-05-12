package com.wjq.order.model.mobile_card;

import java.time.LocalDateTime;

/**
 * 资方大状态列表及前端按钮展示
 *
 * @author wjq
 * @date 2019/01/17
 */
public class MccConsumeStatusInvestor extends MccConsumeStatusInvestorKey {
    /**
     * 父节点
     */
    private Integer parentId;

    /**
     * 按钮列表
     */
    private String btns;

    /**
     * 按钮规则
     */
    private String btnRule;

    /**
     * 
     */
    private String realName;

    /**
     * 真实提示信息
     */
    private String realMessage;

    /**
     * 节点类型
     */
    private Integer nodeType;

    /**
     * 是否是默认节点（0：不是，1：是）
     */
    private Integer isDefaultNode;

    /**
     * 小状态ID 集合, 已英文逗号分隔, 为空则按小状态的parentId
     */
    private String minStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 
     */
    private LocalDateTime createTime;

    /**
     * 
     */
    private LocalDateTime createdAt;

    /**
     * 
     */
    private LocalDateTime updatedAt;

    /**
     * 问题id,标题配置
     */
    private String helpQaDetailId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getBtns() {
        return btns;
    }

    public void setBtns(String btns) {
        this.btns = btns == null ? null : btns.trim();
    }

    public String getBtnRule() {
        return btnRule;
    }

    public void setBtnRule(String btnRule) {
        this.btnRule = btnRule == null ? null : btnRule.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getRealMessage() {
        return realMessage;
    }

    public void setRealMessage(String realMessage) {
        this.realMessage = realMessage == null ? null : realMessage.trim();
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Integer getIsDefaultNode() {
        return isDefaultNode;
    }

    public void setIsDefaultNode(Integer isDefaultNode) {
        this.isDefaultNode = isDefaultNode;
    }

    public String getMinStatus() {
        return minStatus;
    }

    public void setMinStatus(String minStatus) {
        this.minStatus = minStatus == null ? null : minStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getHelpQaDetailId() {
        return helpQaDetailId;
    }

    public void setHelpQaDetailId(String helpQaDetailId) {
        this.helpQaDetailId = helpQaDetailId == null ? null : helpQaDetailId.trim();
    }
}