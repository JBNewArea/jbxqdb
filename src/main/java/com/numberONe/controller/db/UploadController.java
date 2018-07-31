package com.numberONe.controller.db;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.numberONe.Constants;
import com.numberONe.annotation.SystemLog;
import com.numberONe.controller.index.BaseController;
import com.numberONe.util.Common;
import com.numberONe.util.httpServiceUtils;
import com.numberONe.vo.jsonFile;
import com.numberONe.vo.jsonUserMaterial;
import com.numberONe.vo.material;
import com.thoughtworks.xstream.XStream;

@Controller
@RequestMapping(value="/upload")
public class UploadController extends BaseController{
	
	@RequestMapping(value="/uploadUI")
	public String uploadUI(Model model){
		String matterId = getPara("matterId");
		String applicantDocumentType = getPara("applicantDocumentType");
		String applicationDocumentNumber = getPara("applicationDocumentNumber");
		model.addAttribute("matterId",matterId);
		model.addAttribute("applicantDocumentType",applicantDocumentType);
		model.addAttribute("applicationDocumentNumber",applicationDocumentNumber);
		
		ArrayList<HashMap<String, Object>> list = httpServiceUtils.getMatterInfoByIds(matterId);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map = list.get(0);
		@SuppressWarnings("unchecked")
		ArrayList<material> materialList = (ArrayList<material>) map.get("materialList");
		//给材料集合中的每个对象添加一个属性，标识该材料是否有上传过材料
		for(material material : materialList){
			ArrayList<jsonFile> returnlist = new ArrayList<jsonFile>();
			String url0=Constants.INTERFACE_URL+"/userMaterial/userMaterial/findMaterialsByUser";
			List<NameValuePair> nameValuePairs0 = new ArrayList<NameValuePair>();
			nameValuePairs0.add(new BasicNameValuePair("userIdCard",applicationDocumentNumber));
			nameValuePairs0.add(new BasicNameValuePair("userType", applicantDocumentType));
			nameValuePairs0.add(new BasicNameValuePair("ids",material.getMaterialId()));
			JSONArray jsonarray0 = (JSONArray) httpServiceUtils.post(url0, nameValuePairs0);
			jsonUserMaterial tempVo = new jsonUserMaterial();
			String materialName = "";
			if(!jsonarray0.isEmpty()&&!"[null]".equals(jsonarray0.toString())&&null!=jsonarray0){
				JSONObject object = (JSONObject) jsonarray0.get(0);
				tempVo.setId(object.get("id").toString());
				materialName = object.get("materialNameget").toString();
			}else{
				tempVo.setId("");
			}
			
			String url=Constants.INTERFACE_URL+"/realUserMaterial/realUserMaterial/findListByUserMaterialid";
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("userMaterialid",tempVo.getId()));
			JSONArray jsonarray = (JSONArray) httpServiceUtils.post(url, nameValuePairs);
			if(!jsonarray.isEmpty()&&jsonarray!=null){
				for(int i=0;i<jsonarray.size();i++){
					JSONObject object = (JSONObject) jsonarray.get(i);
					jsonFile returnvo = new jsonFile();
					returnvo.setId(object.get("id").toString());
					returnvo.setFileName(object.get("fileName").toString());
					returnvo.setRemarks(object.get("remarks").toString());
					returnvo.setUserMaterialid(object.get("userMaterialid").toString());
					returnvo.setFileAddress(object.get("fileAddress").toString());
					returnlist.add(returnvo);
				}
			}
			if(returnlist.isEmpty()){
				material.setIsShow("hide");
			}else{
				material.setIsShow("nohide");
			}
		}
		
		
		model.addAttribute("materialList",materialList);
		
		return Common.WEB_PATH+"/upload/uploadUI";
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadFile")
	@SystemLog(module="/代办业务",methods="/上传文件")//业务逻辑的控制类，加systemlog注解，切点留痕
	public String upload(HttpServletRequest request,@RequestParam(value="file",required = false)CommonsMultipartFile file) throws UnsupportedEncodingException{
		String userIdCard = request.getParameter("userIdCard");
		String userType = request.getParameter("userType");
		String materialId = request.getParameter("materialId");
//		String comeType = request.getParameter("");
//		System.out.println(userIdCard+","+userType+","+materialId);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		String url=Constants.INTERFACE_URL+"/userMaterial/userMaterial/save";
		XStream xstream = new XStream();
		nameValuePairs.add(new BasicNameValuePair("userIdCard",userIdCard));
		nameValuePairs.add(new BasicNameValuePair("userType", userType));
		nameValuePairs.add(new BasicNameValuePair("materialId", materialId));
	    nameValuePairs.add(new BasicNameValuePair("file", xstream.toXML(file)));
	    nameValuePairs.add(new BasicNameValuePair("comeType", "2"));
	 //   Object result = httpServiceUtils.post(url,nameValuePairs).toString();
	    String result = "";
	    result = httpServiceUtils.upload(url,request, file);
	    result.replace("\n", "true");
	    String flag = "false";
	    if("fail".indexOf(result)<0&&!"".equals(result)){
	    	flag = "success";
	    }
//	    System.out.println(result);
	    return flag;
	}
	
	@RequestMapping(value="/showAllfileUI")
	public String showAllfileUI(Model model){
		String materialId =getPara("materialId");
		String userIdCard =getPara("userIdCard");
		String userType =getPara("userType");
		ArrayList<jsonFile> returnlist = new ArrayList<jsonFile>();
		String url0=Constants.INTERFACE_URL+"/userMaterial/userMaterial/findMaterialsByUser";
		List<NameValuePair> nameValuePairs0 = new ArrayList<NameValuePair>();
		nameValuePairs0.add(new BasicNameValuePair("userIdCard",userIdCard));
		nameValuePairs0.add(new BasicNameValuePair("userType", userType));
		nameValuePairs0.add(new BasicNameValuePair("ids",materialId));
		JSONArray jsonarray0 = (JSONArray) httpServiceUtils.post(url0, nameValuePairs0);
		jsonUserMaterial tempVo = new jsonUserMaterial();
		String materialName = "";
		if(!jsonarray0.isEmpty()&&!"[null]".equals(jsonarray0.toString())&&null!=jsonarray0){
			JSONObject object = (JSONObject) jsonarray0.get(0);
			tempVo.setId(object.get("id").toString());
			materialName = object.get("materialNameget").toString();
		}else{
			tempVo.setId("");
		}
		
		String url=Constants.INTERFACE_URL+"/realUserMaterial/realUserMaterial/findListByUserMaterialid";
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("userMaterialid",tempVo.getId()));
		JSONArray jsonarray = (JSONArray) httpServiceUtils.post(url, nameValuePairs);
		if(!jsonarray.isEmpty()&&jsonarray!=null){
			for(int i=0;i<jsonarray.size();i++){
				JSONObject object = (JSONObject) jsonarray.get(i);
				jsonFile returnvo = new jsonFile();
				returnvo.setId(object.get("id").toString());
				returnvo.setFileName(object.get("fileName").toString());
				returnvo.setRemarks(object.get("remarks").toString());
				returnvo.setUserMaterialid(object.get("userMaterialid").toString());
				returnvo.setFileAddress(object.get("fileAddress").toString());
				returnlist.add(returnvo);
			}
		}
		
		for(jsonFile temp : returnlist){
			temp.setUserMaterialName(materialName);
		}
		model.addAttribute("materialGetList",returnlist);
		return Common.WEB_PATH+"/upload/showAllfileUI";
	}
	
}
