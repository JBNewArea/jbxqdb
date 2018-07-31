package com.numberONe.controller.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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
import com.numberONe.entity.LogFormMap;
import com.numberONe.entity.MatterThemeFormMap;
import com.numberONe.entity.ResUserFormMap;
import com.numberONe.entity.UserFormMap;
import com.numberONe.entity.UserGroupsFormMap;
import com.numberONe.exception.SystemException;
import com.numberONe.mapper.MatterThemeMapper;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.DateUtils;
import com.numberONe.util.PasswordHelper;
import com.numberONe.util.httpServiceUtils;
import com.numberONe.vo.applyInfo;
import com.numberONe.vo.material;

@Controller
@RequestMapping(value="/matterTheme")
public class MatterThemeController extends BaseController{
	@Inject
	private MatterThemeMapper matterThemeMapper; 
	
	@RequestMapping(value="/listpzUI")
	public String listpzUI(Model model) throws Exception{
		model.addAttribute("res", findByRes());
		return Common.WEB_PATH+"/matterTheme/listpzUI";
	}
	
	@ResponseBody
	@RequestMapping(value="/transDetail")
	@SystemLog(module="代办业务",methods="展示事项详情")//此处记录点击代办按钮的操作，不是页面页面菜单操作
	public HashMap<String,Object> transDetail(){
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		String matterId = getPara("matterId");
		ArrayList<HashMap<String, Object>> matterInfoList = httpServiceUtils.getMaterialListByMatterId(matterId);
		if(!matterInfoList.isEmpty()){
			@SuppressWarnings("unchecked")
			ArrayList<material> materialList = (ArrayList<material>) matterInfoList.get(0).get("materialList");
			String returnDom = "<ul class=yjclUL>";
			for(int i=0;i<materialList.size();i++){
				int j = i+1;
				returnDom += "<li>"+j+" : "+materialList.get(i).getMaterialName()+"</li>";
			}
			returnDom += "</ul>";
			returnMap.put("transName", matterInfoList.get(0).get("transName"));
			returnMap.put("yjcl", returnDom);
		}
		return returnMap;
	}
	
//	@ResponseBody
//	@RequestMapping(value="/findByPage")
//	public HashMap<String,Object> findByPage(String pageNow,
//			String pageSize,String column,String sort) throws Exception{
//		//getFormMap方法用于将前台传来的参数封装成对应的map(泛型)
//		MatterThemeFormMap matterThemeFormMap = findHasHMap(MatterThemeFormMap.class);
//		String order = "";
//		if(Common.isNotEmpty(column)){
//			order = " order by "+column+" "+sort;
//		}else{
//			order = " order by id asc";
//		}
//		List<MatterThemeFormMap> list = matterThemeMapper.findAll(matterThemeFormMap);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("records", list);
//		return (HashMap<String, Object>) map;
//	}
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort,String matterThemeName) throws Exception {
		MatterThemeFormMap matterThemeFormMap = findHasHMap(MatterThemeFormMap.class);
		matterThemeFormMap=toFormMap(matterThemeFormMap, pageNow, pageSize,matterThemeFormMap.getStr("orderby"));
		matterThemeFormMap.put("column", column);
		matterThemeFormMap.put("sort", sort);
		matterThemeFormMap.put("matterThemeName",matterThemeName);
		matterThemeFormMap.put("status", Constants.status_work);
		List<MatterThemeFormMap> returnlist = matterThemeMapper.findmatterThemePage(matterThemeFormMap);
		for(MatterThemeFormMap returnVo : returnlist){
			Date date = (Date) returnVo.get("createDate");
			returnVo.put("createDateStr",DateUtils.date2String(date));
		}
        pageView.setRecords(returnlist);//不调用默认分页,调用自已的mapper中findmatterThemePage
        return pageView;
	}
	
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return Common.WEB_PATH+"/matterTheme/addpzUI";
	}
	
	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module="代办项目配置",methods="项目配置-新增")//凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String addEntity(String txtGroupsSelect){
		try {
			MatterThemeFormMap matterThemeFormMap = findHasHMap(MatterThemeFormMap.class);
//			matterThemeFormMap.put("matterThemeId",10086);
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);
			matterThemeFormMap.put("id", UUID.randomUUID().toString());
			matterThemeFormMap.put("userIdMade", userFormMap.get("id"));//获取session中的登录用户id
			matterThemeFormMap.put("status",Constants.status_work);
			matterThemeFormMap.put("createDate", DateUtils.getNowTimeStamp());
			matterThemeFormMap.put("statusDate",DateUtils.getNowTimeStamp());
			String matterThemeType = "";
			String landCharac = "";
			matterThemeType = themeApplyController.getMapValue(matterThemeFormMap,"matterThemeType");
			if(matterThemeType.endsWith(",")){
				matterThemeType = matterThemeType.substring(0,matterThemeType.length()-1);
			}
			landCharac = themeApplyController.getMapValue(matterThemeFormMap,"landCharac");
			if(landCharac.endsWith(",")){
				landCharac = landCharac.substring(0,landCharac.length()-1);
			}
			matterThemeFormMap.put("landCharac",landCharac);
			matterThemeFormMap.put("matterThemeType",matterThemeType);
			matterThemeMapper.addEntity(matterThemeFormMap);//新增后返回新增信息
		} catch (Exception e) {
			 throw new SystemException("新增代办项目异常");
		}
		return "success";
	}
	
	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("matterTheme", matterThemeMapper.findbyFrist("id", id, MatterThemeFormMap.class));
		}
		return Common.WEB_PATH+"/matterTheme/editpzUI";
	}
	
	@ResponseBody
	@RequestMapping(value="editOnload")
	public MatterThemeFormMap editOnload(){
		String id = getPara("id");
		MatterThemeFormMap matterThemeFormMap = matterThemeMapper.findbyFrist("id", id, MatterThemeFormMap.class);
		String tempStr = matterThemeFormMap.get("matterId")==null?"":matterThemeFormMap.get("matterId").toString();
		String[] matterIds = new String[]{};
		if(tempStr!=null&&tempStr!=""){
			matterIds = tempStr.split(",");
		}
		List<NameValuePair> nameValuePairs = null;
		String url=Constants.INTERFACE_URL+"/trans/trans/findOne";
		StringBuffer namebuf =  new StringBuffer();//基础事项名称字符串 逗号分隔
		ArrayList<String> namelist = new ArrayList<String>();//基础事项名称集合 由前台处理
		for(String matterId : matterIds){
			nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("id", matterId));
	        Map<String,Object> result = httpServiceUtils.send(url,nameValuePairs);
//	        if(result!=null&&!"null".equals(result)){
//	        	JSONArray result1=(JSONArray)result;
//	        	JSONObject jsonObject = (JSONObject)result1.get(0);
//	        	String name = jsonObject.get("transName").toString();
//	        	namebuf.append(name+",");
//	        }
	        boolean backflag = (Boolean) result.get("success");
	        if(backflag==true){
	        	JSONArray result1=(JSONArray) result.get("entity");
	        	JSONObject jsonObject = (JSONObject)result1.get(0);
	        	String name = jsonObject.get("transName").toString();
	        	namebuf.append(name+",");
	        	namelist.add(name);
	        }
		}
		matterThemeFormMap.put("matterName", namebuf);
		matterThemeFormMap.put("matterNameList", namelist);
		return matterThemeFormMap;
	}
	
	@ResponseBody
	@RequestMapping("editEntity")
	@SystemLog(module="代办项目配置",methods="项目配置-编辑")//凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String editEntity(String txtGroupsSelect){
		try {
			MatterThemeFormMap matterThemeFormMap = findHasHMap(MatterThemeFormMap.class);
			String id = (String) matterThemeFormMap.get("id");
			String matterThemeType = "";
			String landCharac = "";
			try{
				landCharac = themeApplyController.getMapValue(matterThemeFormMap,"landCharac");
				matterThemeType = themeApplyController.getMapValue(matterThemeFormMap,"matterThemeType");
				if(matterThemeType.endsWith(",")){
					matterThemeType = matterThemeType.substring(0,matterThemeType.length()-1);
				}
				if(landCharac.endsWith(",")){
					landCharac = landCharac.substring(0,landCharac.length()-1);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			matterThemeFormMap.put("matterThemeType",matterThemeType);
			matterThemeFormMap.put("landCharac",landCharac);
			if(id!=null&&id!=""){
				matterThemeFormMap.put("statusDate",DateUtils.getNowTimeStamp());
				matterThemeMapper.editEntity(matterThemeFormMap);//新增后返回新增信息
			}
			else{
				throw new SystemException("编辑代办项目异常");
			}
		} catch (Exception e) {
			 throw new SystemException("编辑代办项目异常");
		}
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="代办项目配置",methods="项目配置-删除")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] idstr = getParaValues("ids");
		String[] ids = idstr[0].split(",");
		MatterThemeFormMap map = null;
		for (String id : ids) {
			map=new MatterThemeFormMap();
			map.put("id", id);
			map.put("status", Constants.status_done);
			map.put("statusDate", DateUtils.getNowTimeStamp());
//			matterThemeMapper.deleteByAttribute("id", id, MatterThemeFormMap.class);
			matterThemeMapper.editEntity(map);
		}
		return "success";
	}
	
	//验证主题事项名称是否存在
	@ResponseBody
	@RequestMapping(value="/ismtNameExist")
	public boolean ismtNameExist(){
		String name = getPara("name");
		String name_old = getPara("name_old");
		if(name.equals(name_old)){
			return true;
		}
		List<MatterThemeFormMap> matterThemeFormMaplist = matterThemeMapper.findByAttribute("matterThemeName", name, MatterThemeFormMap.class);
		if(matterThemeFormMaplist.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
