package com.numberONe.controller.system;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hyperic.sigar.Sigar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberONe.Constants;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.RoleFormMap;
import com.numberONe.entity.ServerInfoFormMap;
import com.numberONe.entity.UserFormMap;
import com.numberONe.mapper.RoleMapper;
import com.numberONe.mapper.ServerInfoMapper;
import com.numberONe.mapper.ThemeApplyMapper;
import com.numberONe.mapper.UserMapper;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.PropertiesUtils;
import com.numberONe.util.SystemInfo;

/**
 * 
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/monitor/")
public class MonitorController extends BaseController {
	
	@Inject
	private ServerInfoMapper serverInfoMapper ;
	
	@Inject
	private ThemeApplyMapper themeApplyMapper;
	
	@Inject
	private UserMapper userMapper;
	
	@Inject 
	private RoleMapper roleMapper;
	
	@RequestMapping("list")
	public String listUI() throws Exception {
		return Common.BACKGROUND_PATH + "/system/monitor/list";
	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize) throws Exception {
		ServerInfoFormMap serverInfoFormMap = getFormMap(ServerInfoFormMap.class);
		serverInfoFormMap=toFormMap(serverInfoFormMap, pageNow, pageSize,serverInfoFormMap.getStr("orderby"));
        pageView.setRecords(serverInfoMapper.findByPage(serverInfoFormMap));
		return pageView;
	}
	
	@RequestMapping("info")
	public String info(Model model) throws Exception {
		model.addAttribute("cpu", PropertiesUtils.findPropertiesKey("cpu"));
		model.addAttribute("jvm", PropertiesUtils.findPropertiesKey("jvm"));
		model.addAttribute("ram", PropertiesUtils.findPropertiesKey("ram"));
		model.addAttribute("toEmail", PropertiesUtils.findPropertiesKey("toEmail"));
		return Common.BACKGROUND_PATH + "/system/monitor/info";
	}
	
	//欢迎页面，同样用到表格，故放在实时监控模块
	@RequestMapping(value="welcome")
	public String welcome(Model model){
//		UserFormMap userFormMap = new UserFormMap();
//		userFormMap.put("roleId", Constants.daibanId);
		RoleFormMap roleFomrMap = new RoleFormMap();
		roleFomrMap.put("description", Constants.description_pingtai);//角色描述为3的表示第三方代办平台
//		List<UserFormMap> pingtaiList = userMapper.findUserByRole(userFormMap);
		List<RoleFormMap> pingtaiList = roleMapper.findByDescription(roleFomrMap);
		//左边方块的数据
		model.addAttribute("jichu",47);
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("status", Constants.status_theme_applying);//在办
		model.addAttribute("zaiban",themeApplyMapper.findbanjian(paramMap));
		paramMap.put("status", Constants.status_theme_applydone);//办结
		model.addAttribute("banjie",themeApplyMapper.findbanjian(paramMap));
		String s1 = String.format("%.2f", themeApplyMapper.findmoney());
		model.addAttribute("money",s1);
		model.addAttribute("pingtaiList",pingtaiList);
		return Common.WEB_PATH+"/welcome";
	}
	
	@RequestMapping("monitor")
	public String monitor() throws Exception {
		return Common.BACKGROUND_PATH + "/system/monitor/monitor";
	}
	
	@RequestMapping("systemInfo")
	public String systemInfo(Model model) throws Exception {
		model.addAttribute("systemInfo", SystemInfo.SystemProperty());
		return Common.BACKGROUND_PATH + "/system/monitor/systemInfo";
	}
	
	@ResponseBody
	@RequestMapping("usage")
	public ServerInfoFormMap usage(Model model) throws Exception {
		return SystemInfo.usage(new Sigar());
	}
	/**
	 * 修改配置　
	 * @param request
	 * @param nodeId
	 * @return
	 * @throws Exception
	 */
    @ResponseBody
	@RequestMapping("/modifySer")
    public Map<String, Object> modifySer(String key,String value) throws Exception{
    	Map<String, Object> dataMap = new HashMap<String,Object>();
    	try {
		// 从输入流中读取属性列表（键和元素对）
    		PropertiesUtils.modifyProperties(key, value);
		} catch (Exception e) {
			dataMap.put("flag", false);
		}
    	dataMap.put("flag", true);
		return dataMap;
    }
}