package com.wjq.order.model.mobile_card;

import java.time.LocalDateTime;

/**
 * 
 *
 * @author wjq
 * @date 2019/01/17
 */
public class MccConsumeStatusTransform {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long consumeId;

    /**
     * 
     */
    private Long statusId;

    /**
     * 前端提示消息
     */
    private String message;

    /**
     * 
     */
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(Long consumeId) {
        this.consumeId = consumeId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}