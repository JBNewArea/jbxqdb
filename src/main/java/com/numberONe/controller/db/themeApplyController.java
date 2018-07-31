package com.numberONe.controller.db;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.numberONe.entity.ApplyFormMap;
import com.numberONe.entity.HastenFormMap;
import com.numberONe.entity.MatterThemeFormMap;
import com.numberONe.entity.ThemeApplyFormMap;
import com.numberONe.entity.UserFormMap;
import com.numberONe.exception.SystemException;
import com.numberONe.mapper.ApplyMapper;
import com.numberONe.mapper.HastenMapper;
import com.numberONe.mapper.MatterThemeMapper;
import com.numberONe.mapper.ThemeApplyMapper;
import com.numberONe.util.Common;
import com.numberONe.util.DateUtils;
import com.numberONe.util.JsonUtils;
import com.numberONe.util.httpServiceUtils;
import com.numberONe.vo.applyInfo;
import com.numberONe.vo.jsonFile;
import com.numberONe.vo.jsonUserMaterial;
import com.numberONe.vo.material;
import com.numberONe.vo.project;
import com.numberONe.vo.trans;

@Controller
@RequestMapping(value="themeApply_fq")
public class themeApplyController extends BaseController{
	@Inject
	private MatterThemeMapper matterThemeMapper; 
	@Inject
	private ThemeApplyMapper themeApplyMapper;
	@Inject
	private ApplyMapper applyMapper;
	@Inject
	private HastenMapper hastenMapper;
	
	@RequestMapping(value="/listfqUI")
	public String listfqUI(Model model){
		model.addAttribute("res", findByRes());
		return Common.WEB_PATH+"/themeApply_fq/listfqUI";
	}
	
	@RequestMapping(value="/basicInfo")
	public String basicInfo(Model model){
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("matterTheme", matterThemeMapper.findbyFrist("id", id, MatterThemeFormMap.class));
		}
		
		return Common.WEB_PATH+"/themeApply_fq/basicInfo";
	}
	
	@ResponseBody
	@RequestMapping(value="/gotoApply")
	@SystemLog(module="代办业务",methods="发起代办-代办发起")//凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public HashMap<String,Object> gotoApply() throws Exception{
		HashMap<String,Object> map = new HashMap<String,Object>();
		try{
			ThemeApplyFormMap themeApplyFormMap = findHasHMap(ThemeApplyFormMap.class);
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);//获取当前用户信息
			String id = UUID.randomUUID().toString();
			themeApplyFormMap.put("id", id);
			themeApplyFormMap.put("agentId", userFormMap.get("id"));
			themeApplyFormMap.put("status", Constants.status_theme_applying);
			themeApplyFormMap.put("createDate", DateUtils.getNowTimeStamp());
			themeApplyFormMap.put("statusDate", DateUtils.getNowTimeStamp());
			String moneyResource = "";
			moneyResource = getMapValue(themeApplyFormMap,"moneyResource");
			if(moneyResource.endsWith(",")){
				moneyResource = moneyResource.substring(0,moneyResource.length()-1);
			}
			themeApplyFormMap.put("moneyResource",moneyResource);
			themeApplyMapper.addEntity(themeApplyFormMap);
			map.put("flag", "success");
			map.put("id", id);
		}catch(Exception e){
			e.printStackTrace();
			throw new SystemException("发起代办失败");
		}
		return map;
	}
	
	@RequestMapping(value="/doApplyUI")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String doApplyUI(Model model){
		String id  = getPara("id1");
		String id2 = getPara("id2");
		String applicationDocumentNumber = getPara("applicationDocumentNumber");
		String applicantDocumentType = getPara("applicantDocumentType");
		
		model.addAttribute("themeApplyId",id);//将themeapplyID放入model中
		model.addAttribute("matterThemeId",id2);//将matterThemeId放入model中
		model.addAttribute("applicantDocumentType",applicantDocumentType);
		model.addAttribute("applicationDocumentNumber", applicationDocumentNumber);
		//将组织数据放入model中，加载select
		String url=Constants.INTERFACE_URL+"/sys/office/showAllList";
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		Map<String,Object> returnmap = httpServiceUtils.send(url, nameValuePairs);
		ArrayList<HashMap<String,Object>> officeList = new ArrayList<HashMap<String,Object>>();
		boolean backflag = (Boolean) returnmap.get("success");
		try{
			if(backflag==true){
				JSONArray returnjsonarray = (JSONArray) returnmap.get("entity");
				for(int i=0 ;i<returnjsonarray.size();i++){
					trans transVo = new trans();
					JSONObject object = (JSONObject) returnjsonarray.get(i);
					transVo.setOfficeId(object.get("id").toString());
					transVo.setOfficeName(object.get("name").toString());
					HashMap<String,Object> map = new HashMap<String,Object>();
					map.put("officeId",object.get("id").toString());
					map.put("officeName",object.get("name").toString());
					officeList.add(map);
				}
			}
			model.addAttribute("officeList", officeList);
		}catch(Exception e){
			e.printStackTrace();
			throw new SystemException("获取组织信息错误");
		}
//		ThemeApplyFormMap themeApplyFormMap = (ThemeApplyFormMap) themeApplyMapper.findByAttribute("id", id, ThemeApplyFormMap.class);
		MatterThemeFormMap matterThemeFormMap = (MatterThemeFormMap) matterThemeMapper.findbyFrist("id", id2, MatterThemeFormMap.class);
		//通过主题事项中的matterid 查找到主题事项中基础事项的信息，包括事项名称，材料idlist和namelist
		ArrayList<HashMap<String, Object>> list = httpServiceUtils.getMatterInfoByIds(matterThemeFormMap.get("matterId").toString());
		
		//查找该主题办件的基础办件信息
		 List<ApplyFormMap> applyList = applyMapper.findByAttribute("themeApplyId", id, ApplyFormMap.class);
		 
		 //获取该身份证号或者企业信用代码的历史办件
		 ArrayList<applyInfo> applyhisList = httpServiceUtils.findApplyHises(applicationDocumentNumber,applicantDocumentType);
		
		 //循环主题办件所有的基础事项并预先添加所有事项信息为没有办件，再跟办件list比对，matterId相同的，加入办件信息到matter对象中，供ui展示
		 for(HashMap<String,Object> map : list){
			 String matterId = (String) map.get("matterId");
			 String transName = (String) map.get("transName");
			 String transNameSHOW = transName;
			 if(transName.length()>20){
				 transNameSHOW = transName.substring(0,20)+"...";
			 }
			 map.put("matterStatus", "");//初始化为空
			 map.put("hastenClass", "hasten_hide");//初始化催办a标签的class为**_hide
			 map.put("applyId", "");//初始化为空
			 map.put("doApplyClass", "doApply_usable");//初始化代办按钮的class为**_usable
			 map.put("HishastenClass", "Hishasten_hide");//初始化催办历史反馈的class为**_hide
			 map.put("hastenId", "");//催办信息ID
			 map.put("transNameSHOW", transNameSHOW);
			 map.put("createDateClass", "date_hide");
			 map.put("applyTime", "");
			 for(ApplyFormMap applyFormMap : applyList){
				 String matterIdOfapply = (String) applyFormMap.get("matterId");
				 if(matterIdOfapply!=null&&matterIdOfapply!=""&&matterId.equals(matterIdOfapply)){
					 String status = "";
					 try{
						 String applyId = applyFormMap.get("id").toString();
						//通过办件编号查询办件状态
						 String applyUrl=Constants.INTERFACE_URL+"/application/application/findOneByofficeNumber";
						 nameValuePairs.clear();
						 nameValuePairs.add(new BasicNameValuePair("officeNumber",applyId));
						 Map<String,Object> resultmap = httpServiceUtils.send(applyUrl,nameValuePairs);
						 boolean flag = (Boolean) resultmap.get("success");
						 JSONArray jsonarray = null;
						 String result = "";
						 if(flag==true){
							 String applyTime = "";
							 for(applyInfo applyInfo : applyhisList){
								 if(applyInfo.getOfficeNumber().equals(applyId)){
									 applyTime = applyInfo.getApplyTime();
								 }
							 }
							 jsonarray = (JSONArray) resultmap.get("entity");
							 JSONObject jsonobject = (JSONObject) jsonarray.get(0);
							 status=jsonobject.get("status").toString();
							 map.put("matterStatus", status);//
							 map.put("hastenClass", "hasten_show");//
							 map.put("applyId", applyId);//
							 map.put("doApplyClass", "doApply_disable");//
							 map.put("createDateClass", "date_show");
							 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							 Date date = sdf.parse(applyFormMap.get("createDate").toString());
							 Date dateApply = sdf.parse(applyTime);
							 long time = date.getTime();
							 long timeApply = dateApply==null?0l:dateApply.getTime();
							 map.put("createDate",time);
							 map.put("applyTime", timeApply);
						 }
						 //查询每个办件是否有催办反馈信息
						 HastenFormMap hastenFormMap = new HastenFormMap();
						 hastenFormMap.put("applyId",applyId);
						 HastenFormMap hastenresultmap = hastenMapper.selectFirstOneByApplyId(hastenFormMap);
						 if(hastenresultmap!=null){
							 map.put("hastenId",hastenresultmap.get("id").toString());
							 map.put("HishastenClass", "Hishasten_show");
						 }
					 }catch(Exception e){
						 e.printStackTrace();
						 throw new SystemException("获取办件状态失败");
					 }
					
				 }
			 }
		 }
		 
		/*//组装 历史办件信息
	    //调用 指定企业或个人 的历史办件
		ArrayList<applyInfo> hislist = new ArrayList<applyInfo>();
        List<NameValuePair> applyValePairs = new ArrayList<NameValuePair>();
        applyValePairs.add(new BasicNameValuePair("applicantDocumentNumber",applicationDocumentNumber));
        applyValePairs.add(new BasicNameValuePair("applicantDocumentType",applicantDocumentType));
        String applyUtl=Constants.INTERFACE_URL+"/application/application/findListByapplicantDocumentNumber";
        Map<String,Object> resultmap = httpServiceUtils.send(applyUtl,applyValePairs);
        applyInfo applyinfo = null;
        JSONArray applyarray = null;
        boolean flag = (Boolean) resultmap.get("success");
        if(flag==true){
        	applyarray = (JSONArray) resultmap.get("entity");
        	for(int i=0 ;i<applyarray.size();i++){
    			applyinfo = new applyInfo();
        		JSONObject object = (JSONObject) applyarray.get(i);
        		applyinfo.setOfficeNumber(object.get("officeNumber").toString());
        		applyinfo.setStatus(object.get("status").toString());
        		applyinfo.setApplySource(object.get("applySource").toString());
        		applyinfo.setApplyTime(object.get("applyTime").toString());
        		applyinfo.setFinishTime(object.get("finishTime").toString());
        		JSONObject obj = (JSONObject)(object.get("trans"));
        		applyinfo.setTransName(obj.get("transName").toString());
        		if(applyinfo!=null){
        			hislist.add(applyinfo);
        		}
        	}
        }
        for(HashMap<String,Object> matter : list){
        	String transName = matter.get("transName").toString();
        	ArrayList<applyInfo> hisInfolist = new ArrayList<applyInfo>();
        	for(applyInfo his : hislist){
        		if(his.getTransName().equals(transName)){
        			hisInfolist.add(his);
        		}
        	}
        	matter.put("applyHis", hisInfolist);
        }*/
		
		model.addAttribute("matterList",list);
		return Common.WEB_PATH+"/themeApply_fq/doApply";
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/applyDetail")
	@SystemLog(module="代办业务",methods="展示代办详情")//此处记录点击代办按钮的操作，不是页面页面菜单操作
	public applyInfo applyDetail(){
		String applicationDocumentNumber = getPara("applicationDocumentNumber");
		String applicantDocumentType = getPara("applicantDocumentType");
		String applyId_web = getPara("applyId");
		//组装 历史办件信息
	    //调用 指定企业或个人 的历史办件
        List<NameValuePair> applyValePairs = new ArrayList<NameValuePair>();
        applyValePairs.add(new BasicNameValuePair("applicantDocumentNumber",applicationDocumentNumber));
        applyValePairs.add(new BasicNameValuePair("applicantDocumentType",applicantDocumentType));
        String applyUtl=Constants.INTERFACE_URL+"/application/application/findListByapplicantDocumentNumber";
        Map<String,Object> resultmap = httpServiceUtils.send(applyUtl,applyValePairs);
        applyInfo applyinfo = new applyInfo();
        JSONArray applyarray = null;
        boolean flag = (Boolean) resultmap.get("success");
        if(flag==true){
        	applyarray = (JSONArray) resultmap.get("entity");
        	for(int i=0 ;i<applyarray.size();i++){
        		JSONObject object = (JSONObject) applyarray.get(i);
        		String applyId = object.get("officeNumber").toString();
        		if(applyId.equals(applyId_web)){
        			applyinfo.setOfficeNumber(object.get("officeNumber").toString());
            		applyinfo.setStatus(object.get("status").toString());
            		applyinfo.setApplySource(object.get("applySource").toString());
            		applyinfo.setApplyTime(object.get("applyTime").toString());
            		applyinfo.setFinishTime(object.get("finishTime").toString());
            		JSONObject obj = (JSONObject)(object.get("trans"));
            		applyinfo.setTransName(obj.get("transName").toString());
        		}
        	}
        }
        return applyinfo;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/apply")
	@SystemLog(module="代办业务",methods="发起代办操作")//此处记录点击代办按钮的操作，不是页面页面菜单操作
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String apply(project applyinfo) throws Exception{
		String matterThemeId = getPara("matterThemeId");
		String themeApplyId = getPara("themeApplyId");
		String matterId = getPara("matterId");
		ThemeApplyFormMap themeApplyFormMap = themeApplyMapper.findbyFrist("id", themeApplyId, ThemeApplyFormMap.class);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		String url=Constants.INTERFACE_URL+"/application/application/save";
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);//获取当前用户信息
		//申请材料加入代办操作中  未完待续 该方法是传入matterids的，所有这里返回的对象只有一个
		ArrayList<HashMap<String, Object>> list = httpServiceUtils.getMatterInfoByIds(matterId);
		//此处只传入了一个matterId,故返回的集合只有1个
		HashMap<String,Object> returnMap = list.get(0);
		
		@SuppressWarnings("unchecked")
		ArrayList<material> materialList = (ArrayList<material>) returnMap.get("materialList");
		//paramlist 存放调用 办件申请接口的材料集合参数
//		ArrayList<HashMap<String,Object>> paramlist = new ArrayList<HashMap<String,Object>>();
		if(null!=materialList&&!materialList.isEmpty()&&!"null".equals(materialList)){
			for(material material : materialList){
				String materialId = material.getMaterialId();
				String url0=Constants.INTERFACE_URL+"/userMaterial/userMaterial/findMaterialsByUser";
				List<NameValuePair> nameValuePairs0 = new ArrayList<NameValuePair>();
				nameValuePairs0.add(new BasicNameValuePair("userIdCard",themeApplyFormMap.get("applicationDocumentNumber").toString()));//
				nameValuePairs0.add(new BasicNameValuePair("userType", themeApplyFormMap.get("applicantDocumentType").toString()));//
				nameValuePairs0.add(new BasicNameValuePair("ids",materialId));
				JSONArray jsonarray0 = (JSONArray) httpServiceUtils.post(url0, nameValuePairs0);
				HashMap<String,Object> tempMap = new HashMap<String,Object>();
				if(null!=jsonarray0&&!"[null]".equals(jsonarray0.toString())&&!jsonarray0.isEmpty()){
					JSONObject object = (JSONObject) jsonarray0.get(0);
////					tempVo.setId(object.get("id").toString()); //这里tempvo中存放的就是usermaterialid
//					tempMap.put("id", object.get("id").toString());
//					tempMap.put("materialName", object.get("materialNameget").toString());
//					tempMap.put("materialId",materialId);
					material.setMaterialGetId(object.get("id").toString());
				}
			}
		}
		
		//将材料集合参数组装
		if(materialList!=null&&!materialList.isEmpty()){
        	for(int i=0;i<materialList.size();i++){
        		if(null!=materialList.get(i)){
        			String id = materialList.get(i).getMaterialId();
        			String materialName = materialList.get(i).getMaterialName();
        			String materialGetId = materialList.get(i).getMaterialGetId();
        			nameValuePairs.add(new BasicNameValuePair("materialList["+i+"].material.id",id));
	        		nameValuePairs.add(new BasicNameValuePair("materialList["+i+"].material.materialName",materialName));
	    	        nameValuePairs.add(new BasicNameValuePair("materialList["+i+"].materialGetId",materialGetId));
	    	        nameValuePairs.add(new BasicNameValuePair("materialList["+i+"].getMode",""));
        		}
        	}
        }else{
        	nameValuePairs.add(new BasicNameValuePair("materialList[0].material.id",""));
	        nameValuePairs.add(new BasicNameValuePair("materialList[0].material.materialName",""));
	        nameValuePairs.add(new BasicNameValuePair("materialList[0].materialGetId",""));
	        nameValuePairs.add(new BasicNameValuePair("materialList[0].getMode",""));
        }
        Common.accessable(applyinfo);
        //投资项目信息组装
        nameValuePairs.add(new BasicNameValuePair("trans.id",matterId));
        nameValuePairs.add(new BasicNameValuePair("applyPerson.applicationName",getMapValue(themeApplyFormMap,"applicationName")));
        nameValuePairs.add(new BasicNameValuePair("applicantDocumentType",getMapValue(themeApplyFormMap,"applicantDocumentType")));
        nameValuePairs.add(new BasicNameValuePair("applyPerson.applicationDocumentNumber",getMapValue(themeApplyFormMap,"applicationDocumentNumber")));
        nameValuePairs.add(new BasicNameValuePair("applyPerson.applicationPostCode",getMapValue(themeApplyFormMap,"applicationPostCode")));
        nameValuePairs.add(new BasicNameValuePair("applyPerson.applicationAddress",getMapValue(themeApplyFormMap,"applicationAddress")));
        nameValuePairs.add(new BasicNameValuePair("applyPerson.applicationPhone",getMapValue(themeApplyFormMap,"applicationPhone")));
//        nameValuePairs.add(new BasicNameValuePair("applySource",applyinfo.getApplySource()));
        nameValuePairs.add(new BasicNameValuePair("applySource","3"));//默认传3，代办系统
        nameValuePairs.add(new BasicNameValuePair("agentName",userFormMap.get("userName").toString()));//当前用户
        nameValuePairs.add(new BasicNameValuePair("agentDocumentType",""));//代理人证件类型
        nameValuePairs.add(new BasicNameValuePair("agentDocumentNumber",""));//代理人证件号
        nameValuePairs.add(new BasicNameValuePair("legalRepresentative",getMapValue(themeApplyFormMap,"legalRepresentative")));
        nameValuePairs.add(new BasicNameValuePair("status","0"));//代办系统发起的办件 默认状态为已受理 状态码为6
        nameValuePairs.add(new BasicNameValuePair("express.name",""));
        nameValuePairs.add(new BasicNameValuePair("express.phone",""));
        nameValuePairs.add(new BasicNameValuePair("express.postCode",""));
        nameValuePairs.add(new BasicNameValuePair("express.street",""));
        nameValuePairs.add(new BasicNameValuePair("express.address",""));
        
        nameValuePairs.add(new BasicNameValuePair("projectNumber",getMapValue(themeApplyFormMap,"applicationName")));
        nameValuePairs.add(new BasicNameValuePair("concreteTrans",""));
        //个性化数据 土地建设许可
        
        nameValuePairs.add(new BasicNameValuePair("gongchengName",applyinfo.getGongchengName()));
        nameValuePairs.add(new BasicNameValuePair("gongchengAddress",applyinfo.getGongchengAddress()));
        nameValuePairs.add(new BasicNameValuePair("gongchengCotent",applyinfo.getGongchengCotent()));
        nameValuePairs.add(new BasicNameValuePair("gongchengGuiMo",applyinfo.getGongchengGuiMo()));
        nameValuePairs.add(new BasicNameValuePair("gongchengBeiZhu",applyinfo.getGongchengBeiZhu()));
        String gongchengMianJi = request.getParameter("gongchengMianJi");
        String gongchengZaoJia = request.getParameter("gongchengZaoJia");
        nameValuePairs.add(new BasicNameValuePair("gongchengMianJi",null!=gongchengMianJi?gongchengMianJi:""));
        nameValuePairs.add(new BasicNameValuePair("gongchengZaoJia",null!=gongchengZaoJia?gongchengZaoJia:""));
        nameValuePairs.add(new BasicNameValuePair("gongchengKaiGong",applyinfo.getGongchengKaiGong()));
        nameValuePairs.add(new BasicNameValuePair("gongchengJunGong",applyinfo.getGongchengJunGong()));
            
        //个性化数据 森林
        nameValuePairs.add(new BasicNameValuePair("forestArea",null!=applyinfo.getForestArea()?applyinfo.getForestArea().toString():""));
        nameValuePairs.add(new BasicNameValuePair("forestAccumulation",null!=applyinfo.getForestAccumulation()?applyinfo.getForestAccumulation().toString():""));
        nameValuePairs.add(new BasicNameValuePair("forestAddress",applyinfo.getForestAddress()));
        nameValuePairs.add(new BasicNameValuePair("forestReason",applyinfo.getForestReason()));
        nameValuePairs.add(new BasicNameValuePair("forestType",applyinfo.getForestType()));
        
        //绿地审批 greenLand
		nameValuePairs.add(new BasicNameValuePair("greenLandArea",null!=applyinfo.getGreenLandArea()?applyinfo.getGreenLandArea().toString():""));
		nameValuePairs.add(new BasicNameValuePair("greenLandAddress",applyinfo.getGreenLandAddress()));
		nameValuePairs.add(new BasicNameValuePair("greenLandOccupyTerm",applyinfo.getGreenLandOccupyTerm()));
       
		//tree
        nameValuePairs.add(new BasicNameValuePair("treeName",applyinfo.getTreeName()));
        nameValuePairs.add(new BasicNameValuePair("treeAddress",applyinfo.getTreeAddress()));
        nameValuePairs.add(new BasicNameValuePair("treeNumber",applyinfo.getTreeNumber()));
        
        //road
        nameValuePairs.add(new BasicNameValuePair("roadAddress",applyinfo.getRoadAddress()));
        nameValuePairs.add(new BasicNameValuePair("roadOccupyTerm",applyinfo.getRoadOccupyTerm()));
		nameValuePairs.add(new BasicNameValuePair("roadwayLong",null!=applyinfo.getRoadwayLong()?applyinfo.getRoadwayLong().toString():""));
		nameValuePairs.add(new BasicNameValuePair("roadwayWide",null!=applyinfo.getRoadwayWide()?applyinfo.getRoadwayWide().toString():""));
		nameValuePairs.add(new BasicNameValuePair("roadwayArea",null!=applyinfo.getRoadwayArea()?applyinfo.getRoadwayArea().toString():""));
		nameValuePairs.add(new BasicNameValuePair("footwayLong",null!=applyinfo.getFootwayLong()?applyinfo.getFootwayLong().toString():""));
		nameValuePairs.add(new BasicNameValuePair("footwayWide",null!=applyinfo.getFootwayWide()?applyinfo.getFootwayWide().toString():""));
		nameValuePairs.add(new BasicNameValuePair("footwayArea",null!=applyinfo.getFootwayArea()?applyinfo.getFootwayArea().toString():""));

        
        Map<String,Object> resultmap = httpServiceUtils.send(url,nameValuePairs);//发送到 业务申请接口
		boolean flag = (Boolean) resultmap.get("success");
		String applyId = "";
		//办件发送成功或失败都更新主题事项 办件 statusDate
		ThemeApplyFormMap themeMap = new ThemeApplyFormMap();
		themeMap.put("id",themeApplyId);
		themeMap.put("statusDate",DateUtils.getNowTimeStamp());
		themeApplyMapper.editEntity(themeMap);
		if(flag==true){
			applyId = (String) resultmap.get("entity");
			//办件信息入库
			ApplyFormMap applyFormMap = new ApplyFormMap();
			applyFormMap.put("id", applyId);
			applyFormMap.put("matterId", matterId);
			applyFormMap.put("themeApplyId", themeApplyId);
			applyFormMap.put("createDate", DateUtils.getNowTimeStamp());
			applyFormMap.put("statusDate", DateUtils.getNowTimeStamp());
			applyFormMap.put("status", Constants.status_apply);
			applyMapper.addEntity(applyFormMap);
			return "true";
		} else{
			return "false";
		}
		
	}
	
	@RequestMapping(value="/basicInfoOfUI")
	public String basicInfoOfUI(Model model){
		String matterThemeId = getPara("matterThemeId");
		String themeApplyId = getPara("themeApplyId");
		model.addAttribute("matterThemeId",matterThemeId);
		model.addAttribute("themeApplyId",themeApplyId);
		return Common.WEB_PATH+"/themeApply_fq/basicInfo_themeApply";
	}
	
	@ResponseBody
	@RequestMapping(value="/loadApplyInfo")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public ThemeApplyFormMap loadApplyInfo(){
		String matterThemeId = getPara("matterThemeId");
		String themeApplyId = getPara("themeApplyId");
		
		MatterThemeFormMap matterThemeFormMap = matterThemeMapper.findbyFrist("id", matterThemeId, MatterThemeFormMap.class);
		String tempStr = matterThemeFormMap.get("matterId")==null?"":matterThemeFormMap.get("matterId").toString();
		String[] matterIds = new String[]{};
		if(tempStr!=null&&tempStr!=""){
			matterIds = tempStr.split(",");
		}
		List<NameValuePair> nameValuePairs = null;
		String url=Constants.INTERFACE_URL+"/trans/trans/findOne";
		StringBuffer namebuf =  new StringBuffer();
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
	        }
		}
		matterThemeFormMap.put("matterName", namebuf);
		ThemeApplyFormMap paramMap = new ThemeApplyFormMap();
		paramMap.put("id",themeApplyId);
		List<ThemeApplyFormMap> themeApplyFormMaplist = themeApplyMapper.findById(paramMap);
		ThemeApplyFormMap themeApplyFormMap = themeApplyFormMaplist.get(0);
//		themeApplyFormMap.put("landCharac",getMapValue(matterThemeFormMap,"landCharac"));
//		themeApplyFormMap.put("matterThemeType",getMapValue(matterThemeFormMap,"matterThemeType"));
		themeApplyFormMap.put("matterName",getMapValue(matterThemeFormMap,"matterName"));
		return themeApplyFormMap;
		
	}
	
	//验证发起代办项目时 项目名称
	@ResponseBody
	@RequestMapping(value="/istaNameExist")
	public boolean istaNameExist(){
		String name = getPara("name");
		List<ThemeApplyFormMap> themeApplyList = themeApplyMapper.findByAttribute("name", name, ThemeApplyFormMap.class);
		if(themeApplyList.size()==0){
			return true;
		}else{
			return false;
		}
	}
	//验证证件号的正确性，根据证件类型分开验证
	@ResponseBody
	@RequestMapping(value="/iscorectdocumentNumber")
	public boolean iscorectdocumentNumber() throws ParseException{
		String type = getPara("type");
		String number = getPara("number");
		if("1".equals(type)){//身份证
			return JsonUtils.IDCardValidate(number);
		}else if("2".equals(type)){
			return JsonUtils.isValid(number);
		}else{
			return false;
		}
	}
	
	
	public static String getMapValue(HashMap<String,Object> map ,String key){
		String strRes = "";
		String strDefault = "";
		if(map == null || map.size()==0){
			return strDefault;
		}
		if(map.get(key) == null){
			return strDefault;
		}
		else{
			return map.get(key).toString();
		}
	}
	
}
