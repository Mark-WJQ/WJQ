package com.wjq.order.dao.mobile_card;

import com.wjq.order.model.mobile_card.MccConsumeStatusInvestor;
import com.wjq.order.model.mobile_card.MccConsumeStatusInvestorExample;
import com.wjq.order.model.mobile_card.MccConsumeStatusInvestorKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MccConsumeStatusInvestorMapper {
    long countByExample(MccConsumeStatusInvestorExample example);

    int deleteByExample(MccConsumeStatusInvestorExample example);

    int deleteByPrimaryKey(MccConsumeStatusInvestorKey key);

    int insert(MccConsumeStatusInvestor record);

    int insertSelective(MccConsumeStatusInvestor record);

    List<MccConsumeStatusInvestor> selectByExample(MccConsumeStatusInvestorExample example);

    MccConsumeStatusInvestor selectByPrimaryKey(MccConsumeStatusInvestorKey key);

    int updateByExampleSelective(@Param("record") MccConsumeStatusInvestor record, @Param("example") MccConsumeStatusInvestorExample example);

    int updateByExample(@Param("record") MccConsumeStatusInvestor record, @Param("example") MccConsumeStatusInvestorExample example);

    int updateByPrimaryKeySelective(MccConsumeStatusInvestor record);

    int updateByPrimaryKey(MccConsumeStatusInvestor record);
}