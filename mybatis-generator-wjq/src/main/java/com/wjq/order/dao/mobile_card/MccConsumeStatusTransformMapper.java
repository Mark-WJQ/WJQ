package com.wjq.order.dao.mobile_card;

import com.wjq.order.model.mobile_card.MccConsumeStatusTransform;
import com.wjq.order.model.mobile_card.MccConsumeStatusTransformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MccConsumeStatusTransformMapper {
    long countByExample(MccConsumeStatusTransformExample example);

    int deleteByExample(MccConsumeStatusTransformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MccConsumeStatusTransform record);

    int insertSelective(MccConsumeStatusTransform record);

    List<MccConsumeStatusTransform> selectByExample(MccConsumeStatusTransformExample example);

    MccConsumeStatusTransform selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MccConsumeStatusTransform record, @Param("example") MccConsumeStatusTransformExample example);

    int updateByExample(@Param("record") MccConsumeStatusTransform record, @Param("example") MccConsumeStatusTransformExample example);

    int updateByPrimaryKeySelective(MccConsumeStatusTransform record);

    int updateByPrimaryKey(MccConsumeStatusTransform record);
}