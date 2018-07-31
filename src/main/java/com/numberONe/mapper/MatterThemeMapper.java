package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.MatterThemeFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface MatterThemeMapper extends BaseMapper{
	public List<MatterThemeFormMap> findAll(MatterThemeFormMap formMap);
	
	public List<MatterThemeFormMap> findmatterThemePage(MatterThemeFormMap formMap);
}
