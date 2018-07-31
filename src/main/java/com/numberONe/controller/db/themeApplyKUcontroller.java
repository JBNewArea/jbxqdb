package com.numberONe.controller.db;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberONe.Constants;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.MatterThemeFormMap;
import com.numberONe.entity.ThemeApplyFormMap;
import com.numberONe.mapper.ThemeApplyMapper;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;

@Controller
@RequestMapping(value="/themeApply_ku")
public class themeApplyKUcontroller extends BaseController{
	@Inject
	private ThemeApplyMapper themeApplyMapper;
	
	@RequestMapping(value="/listkuUI")
	public String listkuUI(Model model){
		model.addAttribute("res", findByRes());
		return Common.WEB_PATH+"/themeApply_ku/listkuUI";
	}
	
	@ResponseBody
	@RequestMapping(value="/findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort,String matterThemeName,String name,String agentName){
		ThemeApplyFormMap themeApplyFormMap = findHasHMap(ThemeApplyFormMap.class);
		themeApplyFormMap=toFormMap(themeApplyFormMap, pageNow, pageSize,themeApplyFormMap.getStr("orderby"));
		themeApplyFormMap.put("column", column);
		themeApplyFormMap.put("sort", sort);
		themeApplyFormMap.put("matterThemeName",matterThemeName);
		themeApplyFormMap.put("status", Constants.status_theme_applying);
		themeApplyFormMap.put("name",name);
		themeApplyFormMap.put("agentName",agentName);
        pageView.setRecords(themeApplyMapper.findThemeApplyPage(themeApplyFormMap));
        return pageView;
	}
}
