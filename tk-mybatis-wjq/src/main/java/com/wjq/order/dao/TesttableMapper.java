package com.wjq.order.dao;

import com.wjq.order.model.Testtable;
import com.wjq.order.model.TesttableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TesttableMapper extends Mapper<Testtable> {
    long countByExample(TesttableExample example);

    int deleteByExample(TesttableExample example);

    List<Testtable> selectByExample(TesttableExample example);

    int updateByExampleSelective(@Param("record") Testtable record, @Param("example") TesttableExample example);

    int updateByExample(@Param("record") Testtable record, @Param("example") TesttableExample example);
}