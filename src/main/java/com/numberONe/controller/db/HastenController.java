package com.numberONe.controller.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.numberONe.Constants;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.HastenFormMap;
import com.numberONe.entity.UserFormMap;
import com.numberONe.exception.SystemException;
import com.numberONe.mapper.HastenMapper;
import com.numberONe.util.Common;
import com.numberONe.util.DateUtils;
import com.numberONe.util.httpServiceUtils;
@Controller
@RequestMapping(value="/hasten")
public class HastenController extends BaseController{
	@Inject
	private HastenMapper hastenMapper;
	
	@RequestMapping(value="/hastenUI")
	public String hastenUI(Model model){
		String applyId = getPara("applyId");
		String themeApplyId = getPara("themeApplyId");
		model.addAttribute("applyId",applyId);
		model.addAttribute("themeApplyId",themeApplyId);
		return Common.WEB_PATH+"/hasten/hastenUI";
	}
	
	@ResponseBody
	@RequestMapping(value="/hasten")
	@SystemLog(module="代办业务",methods="催办操作")//此处记录点击代办按钮的操作，不是页面页面菜单操作
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String hasten() throws Exception{
		String remarks = getPara("remarks");
		String hastenIdea = getPara("hastenIdea");
		String applyId = getPara("applyId");
		String themeApplyId = getPara("themeApplyId");
		HastenFormMap hastenFormMap = new HastenFormMap();
		String url=Constants.INTERFACE_URL+"/hasten/hasten/save";
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);//获取当前用户信息
		try{
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("officeNumber",applyId));
//			nameValuePairs.add(new BasicNameValuePair("hastenMan","tj"));//预留
			nameValuePairs.add(new BasicNameValuePair("hastenMan",userFormMap.get("userName").toString()));//预留
			nameValuePairs.add(new BasicNameValuePair("hastenIdea",hastenIdea));//
			nameValuePairs.add(new BasicNameValuePair("remarks",remarks));
			Map<String,Object> resultmap = httpServiceUtils.send(url, nameValuePairs);
			boolean flag =(Boolean) resultmap.get("success");
			String hastenId = "";
			if(flag == true){
				hastenId = resultmap.get("entity").toString();
				hastenFormMap.put("id", hastenId);
				hastenFormMap.put("applyId", applyId);
				hastenFormMap.put("themeApplyId", themeApplyId);
				hastenFormMap.put("createDate", DateUtils.getNowTimeStamp());
				hastenFormMap.put("statusDate", DateUtils.getNowTimeStamp());
				hastenFormMap.put("status", Constants.status_hasten);
				hastenMapper.addEntity(hastenFormMap);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new SystemException("催办失败");
		}
		return "success";
		
	}
	
	@RequestMapping(value="/hishastenUI")
	public String hishastenUI(Model model){
		String hastenId = getPara("hastenId");
		String url=Constants.INTERFACE_URL+"/hasten/hasten/findHastenForOffice";
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("hastenNumber",hastenId));
		Map<String,Object> resultmap = httpServiceUtils.send(url, nameValuePairs);
		boolean flag = (Boolean) resultmap.get("success");
		HashMap<String,String> hastenInfoMap = new HashMap<String,String>();
		if(flag == true){
			JSONArray array = (JSONArray) resultmap.get("entity");
			JSONObject object = (JSONObject) array.get(0);
			setMapValue(hastenInfoMap,"applicantName",object.get("applicantName"));
			setMapValue(hastenInfoMap,"hastenDate",object.get("hastenDate"));
			setMapValue(hastenInfoMap,"hastenIdea",object.get("hastenIdea"));
			setMapValue(hastenInfoMap,"hastenMan",object.get("hastenMan"));
			setMapValue(hastenInfoMap,"isTrue",object.get("isTrue"));
			setMapValue(hastenInfoMap,"officeName",object.get("officeName"));
			setMapValue(hastenInfoMap,"officeNumber",object.get("officeNumber"));
			setMapValue(hastenInfoMap,"promiseDay",object.get("promiseDay"));
			setMapValue(hastenInfoMap,"remarks",object.get("remarks"));
			setMapValue(hastenInfoMap,"status",object.get("status"));
			setMapValue(hastenInfoMap,"transName",object.get("transName"));
			setMapValue(hastenInfoMap,"updateby",object.get("updateby"));
			setMapValue(hastenInfoMap,"hupdateDate",object.get("hupdateDate"));
			String _Status = dictStatus(object.get("status").toString());
			String _hastenStatus = dict(object.get("hastenStatus").toString());
			setMapValue(hastenInfoMap,"_Status",_Status);
			setMapValue(hastenInfoMap,"_hastenStatus",_hastenStatus);
			model.addAttribute("hastenInfo",hastenInfoMap);
		}
		
		return Common.WEB_PATH+"/hasten/hishastenUI";
	}
	
	public static void setMapValue(HashMap<String,String> hastenInfoMap,String key ,Object value){
		hastenInfoMap.put(key, null==value||"null".equals(value)||"".equals(value)?"":value.toString());
	}
	
	public static String dictStatus(String Status){
		String _Status = "";
		if("0".equals(Status)){
			_Status = "待接件";
		}else if("1".equals(Status)){
			_Status = "已删除";
		}else if("2".equals(Status)){
			_Status = "审批中";
		}else if("3".equals(Status)){
			_Status = "待办结";
		}else if("4".equals(Status)){
			_Status = "已办结";
		}else if("5".equals(Status)){
			_Status = "已归档";
		}else if("6".equals(Status)){
			_Status = "待受理";
		}
		return _Status;
	}
	
	public static String dict(String hastenStatus){
		String _hastenStatus = "";
		if("1".equals(hastenStatus)){
			_hastenStatus = "在督办";
		}else if("2".equals(hastenStatus)){
			_hastenStatus = "办结督办";
		}
		return _hastenStatus;
	}
}
