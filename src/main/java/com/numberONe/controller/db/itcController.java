package com.numberONe.controller.db;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.numberONe.controller.index.BaseController;
import com.numberONe.util.Common;
@Controller
@RequestMapping(value="/itc")
public class itcController extends BaseController {
	
	@RequestMapping(value="/itc")
	public String itc(){
		return Common.WEB_PATH+"/ltc/lct";
	}
	
	@RequestMapping(value="/itc_zf")
	public String itc_zf(){
		return Common.WEB_PATH+"/ltc/lct_zf";
	}
}
