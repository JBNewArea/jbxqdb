package com.numberONe.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.numberONe.entity.ThemeApplyFormMap;
import com.numberONe.entity.echartsData;
import com.numberONe.entity.monthData;
import com.numberONe.mapper.base.BaseMapper;

public interface ThemeApplyMapper extends BaseMapper{
	public List<ThemeApplyFormMap> findThemeApplyPage(ThemeApplyFormMap formMap);
	monthData getzhexianData(HashMap<String,Object> map);
	int findbanjian(HashMap<String,Object> map);
	Double findmoney();
	ArrayList<echartsData> echartslandCharac(HashMap<String,Object> map);
	ArrayList<echartsData> echartsmatterThemeType(HashMap<String,Object> map);
	ArrayList<echartsData> echartsmoneyResource(HashMap<String,Object> map);
	ArrayList<ThemeApplyFormMap> findById(ThemeApplyFormMap formMap);
}
