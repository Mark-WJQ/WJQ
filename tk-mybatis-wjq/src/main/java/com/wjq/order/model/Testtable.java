package com.wjq.order.model;

import javax.persistence.*;

@Table(name = "`testtable`")
public class Testtable {
    /**
     * id
     */
    @Id
    @Column(name = "`test_id`")
    private Integer testId;

    /**
     * 接口
     */
    @Column(name = "`test_api`")
    private String testApi;

    /**
     * 描述
     */
    @Column(name = "`description`")
    private String description;

    /**
     * 获取id
     *
     * @return test_id - id
     */
    public Integer getTestId() {
        return testId;
    }

    /**
     * 设置id
     *
     * @param testId id
     */
    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    /**
     * 获取接口
     *
     * @return test_api - 接口
     */
    public String getTestApi() {
        return testApi;
    }

    /**
     * 设置接口
     *
     * @param testApi 接口
     */
    public void setTestApi(String testApi) {
        this.testApi = testApi == null ? null : testApi.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}