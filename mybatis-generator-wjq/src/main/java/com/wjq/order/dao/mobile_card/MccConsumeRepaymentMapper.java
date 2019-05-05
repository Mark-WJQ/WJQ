package com.wjq.order.dao.mobile_card;

import com.wjq.order.model.mobile_card.MccConsumeRepayment;
import com.wjq.order.model.mobile_card.MccConsumeRepaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MccConsumeRepaymentMapper {
    long countByExample(MccConsumeRepaymentExample example);

    int deleteByExample(MccConsumeRepaymentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MccConsumeRepayment record);

    int insertSelective(MccConsumeRepayment record);

    List<MccConsumeRepayment> selectByExample(MccConsumeRepaymentExample example);

    MccConsumeRepayment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MccConsumeRepayment record, @Param("example") MccConsumeRepaymentExample example);

    int updateByExample(@Param("record") MccConsumeRepayment record, @Param("example") MccConsumeRepaymentExample example);

    int updateByPrimaryKeySelective(MccConsumeRepayment record);

    int updateByPrimaryKey(MccConsumeRepayment record);
}