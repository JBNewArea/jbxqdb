package com.numberONe.controller.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberONe.Constants;
import com.numberONe.ErrConstants;
import com.numberONe.exception.SystemException;
import com.numberONe.util.Common;
import com.numberONe.util.httpServiceUtils;
import com.numberONe.vo.Page;
import com.numberONe.vo.trans;


@Controller
@RequestMapping(value="basicMatter")
public class BasicMatterController {
//	//通过用户信息和材料id获取该材料上传过的文件
//		@SuppressWarnings("null")
//		@ResponseBody
//		@RequestMapping(value="/getByMaterialId")
//		public ArrayList<jsonFile> getByMaterialId(MaterialVo vo){
//			ArrayList<jsonFile> returnlist = new ArrayList<jsonFile>();
//			String url0=Constants.INTERFACE_URL+"/userMaterial/userMaterial/findMaterialsByUser";
//			List<NameValuePair> nameValuePairs0 = new ArrayList<NameValuePair>();
//			nameValuePairs0.add(new BasicNameValuePair("userIdCard",vo.getUserIdCard()));
//			nameValuePairs0.add(new BasicNameValuePair("userType", vo.getUserType()));
//			nameValuePairs0.add(new BasicNameValuePair("ids",vo.getMaterialId()));
//			JSONArray jsonarray0 = (JSONArray) httpServiceUtils.post(url0, nameValuePairs0);
//			jsonUserMaterial tempVo = new jsonUserMaterial();
//			String materialName = "";
//			if(!jsonarray0.isEmpty()&&!"[null]".equals(jsonarray0.toString())&&null!=jsonarray0){
//				JSONObject object = (JSONObject) jsonarray0.get(0);
//				tempVo.setId(object.get("id").toString());
//				materialName = object.get("materialNameget").toString();
//			}else{
//				tempVo.setId("");
//			}
//			
//			String url=Constants.INTERFACE_URL+"/realUserMaterial/realUserMaterial/findListByUserMaterialid";
//			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//			nameValuePairs.add(new BasicNameValuePair("userMaterialid",tempVo.getId()));
//			JSONArray jsonarray = (JSONArray) httpServiceUtils.post(url, nameValuePairs);
//			if(!jsonarray.isEmpty()&&jsonarray!=null){
//				for(int i=0;i<jsonarray.size();i++){
//					JSONObject object = (JSONObject) jsonarray.get(i);
//					jsonFile returnvo = new jsonFile();
//					returnvo.setId(object.get("id").toString());
//					returnvo.setFileName(object.get("fileName").toString());
//					returnvo.setRemarks(object.get("remarks").toString());
//					returnvo.setUserMaterialid(object.get("userMaterialid").toString());
//					returnvo.setFileAddress(object.get("fileAddress").toString());
//					returnlist.add(returnvo);
//				}
//			}
////			String url2=Constants.INTERFACE_URL+"/material/material/findMaterialList";
////			List<NameValuePair> nameValuePairs2 = new ArrayList<NameValuePair>();
////			nameValuePairs2.add(new BasicNameValuePair("ids",vo.getMaterialId()));
////			Map<String,Object> map = httpServiceUtils.send(url2, nameValuePairs2);
////			boolean flag = (boolean) map.get("success");
////			JSONArray array = null;
////			JSONObject object = null;
////			
////			if(flag==true){
////				array = (JSONArray) map.get("entity");
////				if(array!=null&&!array.isEmpty()){
////					object = (JSONObject) array.get(0);
////				}
////				materialName  = (String) object.get("materialName");
////			}
//			for(jsonFile temp : returnlist){
//				temp.setUserMaterialName(materialName);
//			}
//			return returnlist;
//		}
//		
//		@ResponseBody
//		@RequestMapping(value="/findAllBasicMatter")
//		public Map<String,Object> findAllBasicMatter(Page page,trans transVo){
//			Map<String,Object> beforeMap = new HashMap<String,Object>();
//			String url=Constants.INTERFACE_URL+"/trans/trans/showPageList";
//			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//			nameValuePairs.add(new BasicNameValuePair("transName",transVo.getTransName()));
//			nameValuePairs.add(new BasicNameValuePair("transBaseCode",transVo.getTransBaseCode()));
//			nameValuePairs.add(new BasicNameValuePair("office.id",transVo.getOfficeId()));
//			nameValuePairs.add(new BasicNameValuePair("pageNo",page.getPageNumber()));
//			nameValuePairs.add(new BasicNameValuePair("pageSize",page.getPageSize()));
//			Map<String,Object> returnmap = httpServiceUtils.send(url, nameValuePairs);
//			boolean backflag = (boolean) returnmap.get("success");
//			try{
//				if(backflag==true){
//					JSONArray returnjsonarray = (JSONArray) returnmap.get("entity");
//					JSONObject returnjsonobject = (JSONObject) returnjsonarray.get(0);
//					JSONArray jsonarray = returnjsonobject.getJSONArray("list");
//					ArrayList<trans> returnlist = new ArrayList<trans>();
//					trans tempVo = null;
//						for(int i=0;i<jsonarray.size();i++){
//							JSONObject object = (JSONObject) jsonarray.get(i);
//							tempVo = new trans();
//							tempVo.setTransName(object.get("transName").toString());
//							tempVo.setTransBaseCode(object.get("transBaseCode").toString());
//							JSONObject jsonobject1 = (JSONObject) object.get("office");
//							tempVo.setOfficeName(jsonobject1.get("name").toString());
//							tempVo.setId(object.get("id").toString());
//							returnlist.add(tempVo);
//						}
//					page.setDatalist(returnlist);
//					page.setPageNumber(returnjsonobject.get("pageNo").toString());
//					page.setPageSize(returnjsonobject.get("pageSize").toString());
//					page.setCount(returnjsonobject.get("count").toString());
//					beforeMap.put("success",true);
//					beforeMap.put("entity", page);
//				}else{
//					beforeMap.put("success", false);
//					beforeMap.put("errInfo", returnmap.get("entity"));
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//				beforeMap.put("success", false);
//				beforeMap.put("errInfo", ErrConstants.ERR_SYSERR);//系统异常
//			}
//			return beforeMap;
//		}
		
		@ResponseBody
		@RequestMapping(value="/findOffice")
		public Map<String,Object> findOffice(){
			Map<String,Object> beforeMap = new HashMap<String,Object>();
			String url=Constants.INTERFACE_URL+"/sys/office/showAllList";
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			Map<String,Object> returnmap = httpServiceUtils.send(url, nameValuePairs);
			boolean backflag = (Boolean) returnmap.get("success");
			if(backflag==true){
				JSONArray returnjsonarray = (JSONArray) returnmap.get("entity");
				ArrayList<trans> returnlist = new ArrayList<trans>();
				for(int i=0 ;i<returnjsonarray.size();i++){
					trans transVo = new trans();
					JSONObject object = (JSONObject) returnjsonarray.get(i);
					transVo.setOfficeId(object.get("id").toString());
					transVo.setOfficeName(object.get("name").toString());
					returnlist.add(transVo);
				}
				beforeMap.put("success",true);
				beforeMap.put("entity",returnlist);
			}else{
				beforeMap.put("success", false);
				beforeMap.put("errInfo", returnmap.get("entity"));
			}
			return beforeMap;
		}
		
		@SuppressWarnings("null")
		@RequestMapping(value="/showUI")
		public String showUI(Model model,String matterId,String matterName){
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
				model.addAttribute("matterIds",matterId);
				if(matterName!=null&&matterName!=""){
					matterName = new String(matterName.getBytes("ISO-8859-1"),"UTF-8");
				}
				model.addAttribute("matterNames",matterName);
				return Common.WEB_PATH+"/basicMatter/basicMatter";
			}catch(Exception e){
				throw new SystemException("获取部门信息失败");
			}
		}
		
		
		@ResponseBody
		@RequestMapping(value="/findAllBasicMatter")
		public Map<String,Object> findAllBasicMatter(Page page,trans transVo){
			Map<String,Object> beforeMap = new HashMap<String,Object>();
			String url=Constants.INTERFACE_URL+"/trans/trans/showPageList";
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("transName",transVo.getTransName()));
			nameValuePairs.add(new BasicNameValuePair("transBaseCode",transVo.getTransBaseCode()));
			nameValuePairs.add(new BasicNameValuePair("office.id",transVo.getOfficeId()));
			nameValuePairs.add(new BasicNameValuePair("pageNo",page.getPageNumber()));
			nameValuePairs.add(new BasicNameValuePair("pageSize",page.getPageSize()));
			Map<String,Object> returnmap = httpServiceUtils.send(url, nameValuePairs);
			boolean backflag = (Boolean) returnmap.get("success");
			try{
				if(backflag==true){
					JSONArray returnjsonarray = (JSONArray) returnmap.get("entity");
					JSONObject returnjsonobject = (JSONObject) returnjsonarray.get(0);
					JSONArray jsonarray = returnjsonobject.getJSONArray("list");
					ArrayList<trans> returnlist = new ArrayList<trans>();
					trans tempVo = null;
						for(int i=0;i<jsonarray.size();i++){
							JSONObject object = (JSONObject) jsonarray.get(i);
							tempVo = new trans();
							tempVo.setTransName(object.get("transName").toString());
							tempVo.setTransBaseCode(object.get("transBaseCode").toString());
							JSONObject jsonobject1 = (JSONObject) object.get("office");
							tempVo.setOfficeName(jsonobject1.get("name").toString());
							tempVo.setId(object.get("id").toString());
							returnlist.add(tempVo);
						}
					page.setDatalist(returnlist);
					page.setPageNumber(returnjsonobject.get("pageNo").toString());
					page.setPageSize(returnjsonobject.get("pageSize").toString());
					page.setCount(returnjsonobject.get("count").toString());
					beforeMap.put("success",true);
					beforeMap.put("entity", page);
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new SystemException(ErrConstants.ERR_SYSERR);
			}
			return beforeMap;
		}
}
