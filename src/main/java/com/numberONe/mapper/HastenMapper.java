package com.numberONe.mapper;

import com.numberONe.entity.HastenFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface HastenMapper extends BaseMapper{
	HastenFormMap selectFirstOneByApplyId(HastenFormMap hastenFormMap);
}
