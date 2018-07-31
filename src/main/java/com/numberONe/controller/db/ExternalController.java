package com.numberONe.controller.db;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.numberONe.controller.index.BaseController;
import com.numberONe.util.Common;

@Controller
@RequestMapping(value="/external")
public class ExternalController extends BaseController{
	
	@RequestMapping(value="/externalForestUI")
	public String externalForestUI(Model model){
		String matterThemeId = getPara("matterThemeId");
		String themeApplyId = getPara("themeApplyId");
		String matterId = getPara("matterId");
		model.addAttribute("matterThemeId",matterThemeId);
		model.addAttribute("themeApplyId",themeApplyId);
		model.addAttribute("matterId",matterId);
		return Common.WEB_PATH+"/externalInfo/forest";
	}
	
	@RequestMapping(value="/externalProjectUI")
	public String externalProjectUI(Model model){
		String matterThemeId = getPara("matterThemeId");
		String themeApplyId = getPara("themeApplyId");
		String matterId = getPara("matterId");
		model.addAttribute("matterThemeId",matterThemeId);
		model.addAttribute("themeApplyId",themeApplyId);
		model.addAttribute("matterId",matterId);
		return Common.WEB_PATH+"/externalInfo/project";
	}
	
	 
	@RequestMapping(value="/externalGreenLandUI")
	public String externalGreenLandUI(Model model){
		String matterThemeId = getPara("matterThemeId");
		String themeApplyId = getPara("themeApplyId");
		String matterId = getPara("matterId");
		model.addAttribute("matterThemeId",matterThemeId);
		model.addAttribute("themeApplyId",themeApplyId);
		model.addAttribute("matterId",matterId);
		return Common.WEB_PATH+"/externalInfo/greenLand";
	}
	
	@RequestMapping(value="/externalTreeUI")
	public String externalTreeUI(Model model){
		String matterThemeId = getPara("matterThemeId");
		String themeApplyId = getPara("themeApplyId");
		String matterId = getPara("matterId");
		model.addAttribute("matterThemeId",matterThemeId);
		model.addAttribute("themeApplyId",themeApplyId);
		model.addAttribute("matterId",matterId);
		return Common.WEB_PATH+"/externalInfo/tree";
	}
	
	@RequestMapping(value="/externalRoadUI")
	public String externalRoadUI(Model model){
		String matterThemeId = getPara("matterThemeId");
		String themeApplyId = getPara("themeApplyId");
		String matterId = getPara("matterId");
		model.addAttribute("matterThemeId",matterThemeId);
		model.addAttribute("themeApplyId",themeApplyId);
		model.addAttribute("matterId",matterId);
		return Common.WEB_PATH+"/externalInfo/road";
	}
}
