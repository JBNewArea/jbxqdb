package com.numberONe.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.numberONe.Constants;
import com.numberONe.ErrConstants;
import com.numberONe.vo.applyInfo;
import com.numberONe.vo.material;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class httpServiceUtils {
	private static Logger logger = Logger.getLogger(httpServiceUtils.class);
	public static void main(String[] args) {
//		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
//	    nameValuePairs.add(new BasicNameValuePair("username", "185518049861"));  
//	    nameValuePairs.add(new BasicNameValuePair("password", "123123123"));  
//	    nameValuePairs.add(new BasicNameValuePair("validCode", "123123"));  
//        String url="http://47.96.161.157:8090/xzsp-interface/a/rpc/trans/trans/findOne";
//        nameValuePairs.add(new BasicNameValuePair("id", "0fdc88081f9b4300bdfada27a2246252"));
////        JSONArray result =(JSONArray) post(url,nameValuePairs);
//	    nameValuePairs.add(new BasicNameValuePair("username", "185518049861"));  
//	    nameValuePairs.add(new BasicNameValuePair("password", "123123123"));
//	    XStream xstream = new XStream();
//	    nameValuePairs.add(new BasicNameValuePair("123", xstream.toXML(new File("12"))));  
//        String url="http://localhost:8080/api/user/login";
//		String result = post(url,nameValuePairs).toString();
//		System.out.println(result);
		//File user2 = (File) xstream.fromXML(xstream.toXML(new File("12")));
//		
//		 List<NameValuePair> applyValePairs = new ArrayList<NameValuePair>();
//        applyValePairs.add(new BasicNameValuePair("applicantDocumentNumber","341124199406230030"));
//        applyValePairs.add(new BasicNameValuePair("applicantDocumentType","1"));
//        String applyUtl=Constants.INTERFACE_URL+"/application/application/findListByapplicantDocumentNumber";
//        Map<String,Object> resultmap = send(applyUtl,applyValePairs);
	}
	@SuppressWarnings("null")
	public static Object post(String url,List<NameValuePair> nameValuePairs){
		 @SuppressWarnings({ "deprecation", "resource" })
		HttpClient httpclient = new DefaultHttpClient();  
        HttpPost httppost = new HttpPost(url);  
        String strResult = ""; 
        JSONArray jsonArray = null;
        JSONObject sobj = null;
        try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
			HttpResponse response = httpclient.execute(httppost);  
			if (response.getStatusLine().getStatusCode() == 200) {  
				 /*读返回数据*/  
               String conResult = EntityUtils.toString(response  
                       .getEntity()); 
               if(conResult.startsWith("[")){
            	   jsonArray = JSONArray.fromObject(conResult);
               }else if(conResult.startsWith("{")){
                   sobj = JSONObject.fromObject(conResult);
                   jsonArray = new JSONArray();
                   jsonArray.add(sobj);
               }else{
            	   return conResult;
               }
//               String result = sobj.getString("token");  
//               String code = sobj.getString("expire");  
//               if(code.equals("3600")){  
//                   strResult += "发送成功"+sobj;  
//               }else{  
//                   strResult += "发送失败，"+code;  
//               } 
			}else{
				String err = response.getStatusLine().getStatusCode()+"";  
               strResult += "发送失败:"+err;  
               return strResult;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return jsonArray;  
	}
	
	public static Map<String,Object> send(String url,List<NameValuePair> nameValuePairs){
		@SuppressWarnings({ "deprecation", "resource" })
		HttpClient httpclient = new DefaultHttpClient();  
        HttpPost httppost = new HttpPost(url);  
        String strResult = ""; 
        JSONArray jsonArray = null;
        JSONObject sobj = null;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",false);
        map.put("entity", "调用接口出错");
        try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
			HttpResponse response;
			response = httpclient.execute(httppost);
			if (response.getStatusLine().getStatusCode() == 200) {  
				 /*读返回数据*/  
               String conResult = EntityUtils.toString(response  
                       .getEntity()); 
               if(conResult.startsWith("[")){
            	   jsonArray = JSONArray.fromObject(conResult);
            	   map.put("success", true);
            	   map.put("entity", jsonArray);
               }else if(conResult.startsWith("{")){
                   sobj = JSONObject.fromObject(conResult);
                   jsonArray = new JSONArray();
                   jsonArray.add(sobj);
                   map.put("success", true);
                   map.put("entity", jsonArray);
               }else{
            	   map.put("success", true);
            	   map.put("entity", conResult);
               }
               logger.debug("调用接口"+nameValuePairs.toString()+url+"("+map.get("success")+"):"+map.get("entity"));
//               String result = sobj.getString("token");  
//               String code = sobj.getString("expire");  
//               if(code.equals("3600")){  
//                   strResult += "发送成功"+sobj;  
//               }else{  
//                   strResult += "发送失败，"+code;  
//               } 
			}else{
				String err = response.getStatusLine().getStatusCode()+"";  
				strResult += "调用接口失败:"+err; 
				JSONArray array = new JSONArray();
				JSONObject object = new JSONObject();
				object.put("errInfo",strResult);
				array.add(object);
               map.put("success", false);
               map.put("entity", strResult);
               map.put("errCode",ErrConstants.ERR_WRONG);
               logger.debug("调用接口"+nameValuePairs.toString()+url+"("+map.get("success")+"):"+map.get("entity"));
			}
		}  catch (NoRouteToHostException e){
			//err 捕获超时异常
			map.put("success", false);
			map.put("entity", "调用接口超时");
			map.put("errCode", ErrConstants.ERR_TIMEOUT);
			logger.debug("调用接口"+nameValuePairs.toString()+url+"("+map.get("success")+"):"+map.get("entity"));
		} catch (UnsupportedEncodingException e) {
			//捕获编码格式异常
			e.printStackTrace();
			logger.debug("调用接口"+nameValuePairs.toString()+url+"("+map.get("success")+"):"+map.get("entity"));
		} catch (ClientProtocolException e) {
			// 客户端异常
			map.put("success", false);
			map.put("entity", "客户端异常");
			logger.debug("调用接口"+nameValuePairs.toString()+url+"("+map.get("success")+"):"+map.get("entity"));
		} catch (IOException e) {
			//流异常
			e.printStackTrace();
			logger.debug("调用接口"+nameValuePairs.toString()+url+"("+map.get("success")+"):"+map.get("entity"));
		}  
        return map;  
	}
	
//	private static String getStringFromJson(JSONObject adata) {  
//        StringBuffer sb = new StringBuffer();  
//        sb.append("{");  
//        for(Object key:adata.keySet()){  
//            sb.append("\""+key+"\":\""+adata.get(key)+"\",");  
//        }  
//        String rtn = sb.toString().substring(0, sb.toString().length()-1)+"}";  
//        return rtn;  
//    }  
	
	
	public static String upload(String urlStr,HttpServletRequest request,CommonsMultipartFile multipartFile) throws UnsupportedEncodingException{
		String res = "";  
		String fileName = multipartFile.getOriginalFilename();
//		fileName=new String(fileName.getBytes(),"UTF-8");
		  if(fileName.equals("blob")){
			  fileName = "在线表" + new Date().getTime() + ".png";
		  }
		  //将MultipartFile转化为File
		  CommonsMultipartFile cf= (CommonsMultipartFile)multipartFile; 
		  DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
		  File file = fi.getStoreLocation();
		  //手动创建临时文件  
		  if(!file.exists()){  
			  file = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +   
                  file.getName());  
	            try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}  
	        }  
		  //封装参数为map
		  @SuppressWarnings("unchecked")
		  Map<String,String[]> readOnlyMap = request.getParameterMap();
		  Map<String,String> map = new HashMap<String,String>();
		  Set<String> keySet = readOnlyMap.keySet();
		  Iterator<String> it =  keySet.iterator();
		  while (it.hasNext()) {  
			  String str = it.next();  
			  map.put(str, readOnlyMap.get(str)[0]);
		  } 
		  map.put("comeType","2");
	  
		  
		  HttpURLConnection conn = null;  
		  String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符  
		  try {  
			    URL url = new URL(urlStr);  
			    conn = (HttpURLConnection) url.openConnection();  
			    conn.setConnectTimeout(5000);  
			    conn.setReadTimeout(30000);  
			    conn.setDoOutput(true);  
			    conn.setDoInput(true);  
			    conn.setUseCaches(false);  
			    conn.setRequestMethod("POST");  
			    conn.setRequestProperty("Connection", "Keep-Alive");  
			    conn.setRequestProperty("User-Agent",  
			            "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");  
			    conn.setRequestProperty("Content-Type",  
			            "multipart/form-data; boundary=" + BOUNDARY);  
			
			    OutputStream out = new DataOutputStream(conn.getOutputStream());  
			    // text  
			    if (map != null) {  
			        StringBuffer strBuf = new StringBuffer();  
			        Iterator<Entry<String, String>> iter = map.entrySet().iterator();  
			        while (iter.hasNext()) {   
			            @SuppressWarnings("rawtypes")
						Map.Entry entry = (Map.Entry) iter.next();  
			            String inputName = (String) entry.getKey();  
			            String inputValue = (String) entry.getValue();  
			            if (inputValue == null) {  
			                continue;  
			            }  
			            strBuf.append("\r\n").append("--").append(BOUNDARY)  
			                    .append("\r\n");  
			            strBuf.append("Content-Disposition: form-data; name=\""  
			                    + inputName + "\"\r\n\r\n");  
			            strBuf.append(inputValue);  
			        }  
			        out.write(strBuf.toString().getBytes());  
			    }  
			
			    // file
			    if(null != file){
			        String contentType = new MimetypesFileTypeMap().getContentType(file);  
			        if (fileName.endsWith(".png")) {  
			            contentType = "image/png";  
			        }  
			        if (contentType == null || contentType.equals("")) {  
			            contentType = "application/octet-stream";  
			        }
			        StringBuffer strBuf = new StringBuffer();  
			        strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");  
			        strBuf.append("Content-Disposition: form-data; name=\""  
			                    + "file\"; filename=\"" + URLEncoder.encode(fileName,"GBK")
			                    + "\"\r\n");  
			        strBuf.append("Content-Type:" + contentType + "\r\n\r\n");  
			        out.write(strBuf.toString().getBytes());  
			        DataInputStream in = new DataInputStream(new FileInputStream(file));  
			        int bytes = 0;  
			        byte[] bufferOut = new byte[1024];  
			        while ((bytes = in.read(bufferOut)) != -1) {  
			             out.write(bufferOut, 0, bytes);  
			        }  
			        in.close(); 
			    }
			    byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();  
			    out.write(endData);  
			    out.flush();  
			    out.close();  
			
			    // 数据返回  
			    StringBuffer strBuf = new StringBuffer();  
			    BufferedReader reader = new BufferedReader(new InputStreamReader(  
			            conn.getInputStream()));  
			    String line = null;  
			    while ((line = reader.readLine()) != null) {  
			        strBuf.append(line).append("\n");  
			    }  
			    res = strBuf.toString();  
			    reader.close();  
			    reader = null;  
		  } catch (Exception e) {  
			  	e.printStackTrace();  
		  } finally {  
			    if (conn != null) {  
			        conn.disconnect();  
			        conn = null;  
			    }  
		  }  
		  return res;
	}
	
	//通过事项ids查询事项的名称，ID，材料
	public static ArrayList<HashMap<String,Object>> getMatterInfoByIds(String idsStr){
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		String[] ids = idsStr.split(",");
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		String getMatterurl=Constants.INTERFACE_URL+"/trans/trans/findOne";
		String materialUrl=Constants.INTERFACE_URL+"/material/material/findMaterialList";
		for(String id : ids){
			//事项id部位空
			if(id!=null&&id!=""){
				//通过事项id，获取事项的相关信息 
//				nameValuePairs.clear();
				nameValuePairs.add(new BasicNameValuePair("id", id));
	            Map<String,Object> resultmap = httpServiceUtils.send(getMatterurl,nameValuePairs);
	            boolean flag = (Boolean) resultmap.get("success");
	            JSONArray result = null;
	            if(flag==true){
            	result = (JSONArray) resultmap.get("entity");
            	HashMap<String,Object> map = new HashMap<String,Object>();
        		JSONObject jsonObject = (JSONObject) result.get(0);
        		map.put("matterId", jsonObject.get("id").toString());
        		map.put("materialIds", jsonObject.get("materialIds").toString());
        		map.put("transName", jsonObject.get("transName").toString());
        		map.put("transBaseCode", jsonObject.get("transBaseCode").toString());
        		JSONObject temp = (JSONObject) jsonObject.get("office");
        		map.put("officeId", temp.get("id").toString());
//	            		list.add(map);
        		//AAAAAAAAAAAAAAAA
                nameValuePairs.clear();
                
            	nameValuePairs.add(new BasicNameValuePair("ids",map.get("materialIds").toString()));
            	 Map<String,Object> resultmap1 = httpServiceUtils.send(materialUrl,nameValuePairs);
                 boolean flag1 = (Boolean) resultmap1.get("success");
                 if(flag1 == true){
                	 JSONArray resultmaterialId = (JSONArray) resultmap1.get("entity");
                     if(resultmaterialId!=null&&!"[null]".equals(resultmaterialId.toString())){
//     	                            returnlist.get(i).setMaterialNames(strbuf.toString());
                         ArrayList<material> materialList = new ArrayList<material>();
                         //将申请材料名称组装成集合 放入实体对象
                         for(int j=0;j<resultmaterialId.size();j++){
                         	JSONObject materialIdObject = (JSONObject)resultmaterialId.get(j);
                         	material material = new material();
                         	material.setMaterialId(materialIdObject.get("id").toString());
                         	material.setMaterialName(materialIdObject.get("materialName").toString());
                         	materialList.add(material);
                         }
                         map.put("materialList",materialList);
                 }
                
                }
                list.add(map);
            }
	            		
	            		
	            	
			}
		}
		
		
		return list;
        
        
	}
	
	/**
	 * @param id 事项id
	 * @return 材料map的集合
	 * @author Administrator taojie
	 */
	public static ArrayList<HashMap<String,Object>> getMaterialListByMatterId(String id){
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		String getMatterurl=Constants.INTERFACE_URL+"/trans/trans/findOne";
		String materialUrl=Constants.INTERFACE_URL+"/material/material/findMaterialList";
		StringBuffer strbuf = null;
		if(id!=null&&id!=""){
			nameValuePairs.add(new BasicNameValuePair("id", id));
            Map<String,Object> resultmap = httpServiceUtils.send(getMatterurl,nameValuePairs);
            boolean flag = (Boolean) resultmap.get("success");
            JSONArray result = null;
            if(flag==true){
	        	result = (JSONArray) resultmap.get("entity");
	        	HashMap<String,Object> map = new HashMap<String,Object>();
	    		JSONObject jsonObject = (JSONObject) result.get(0);
	    		map.put("matterId", jsonObject.get("id").toString());
	    		map.put("materialIds", jsonObject.get("materialIds").toString());
	    		map.put("transName", jsonObject.get("transName").toString());
	    		map.put("transBaseCode", jsonObject.get("transBaseCode").toString());
	            nameValuePairs.clear();
	        	nameValuePairs.add(new BasicNameValuePair("ids",map.get("materialIds").toString()));
	        	Map<String,Object> resultMap = httpServiceUtils.send(materialUrl,nameValuePairs);
//	        	JSONArray resultmaterialId = (JSONArray)httpServiceUtils.post(materialUrl,nameValuePairs);
	            strbuf =  new StringBuffer();
	            boolean flag1 = (Boolean) resultMap.get("success");
	            if(flag1==true){
	            	JSONArray resultmaterialId = (JSONArray) resultMap.get("entity");
	            	if(resultmaterialId!=null&&!"[null]".equals(resultmaterialId.toString())){
		            	//给每个事项实体对象添加申请材料名称 字符串
		            	for(int j=0;j<resultmaterialId.size();j++){
		                	JSONObject materialNameObject = (JSONObject)resultmaterialId.get(j);
		                	strbuf.append(materialNameObject.get("materialName")+",");
		                }
		                if(strbuf.length()>0){
		                	strbuf.substring(0, strbuf.length()-1);
		                }
		                map.put("materialNamesStr", strbuf.toString());
		                ArrayList<material> materialList = new ArrayList<material>();
		                //将申请材料名称组装成集合 放入实体对象
		                for(int j=0;j<resultmaterialId.size();j++){
		                	JSONObject materialIdObject = (JSONObject)resultmaterialId.get(j);
		                	material material = new material();
		                	material.setMaterialId(materialIdObject.get("id").toString());
		                	material.setMaterialName(materialIdObject.get("materialName").toString());
		                	materialList.add(material);
		                }
		                map.put("materialList",materialList);
		            }
	            }
	            list.add(map);
            }
		}
		return list;
	}
	
	/**
	 * 
	 */
	
	
	//判断指定用户某事项材料是否有关联的材料
//		public static boolean takeMaterial(MaterialVo vo){
//			boolean flag = false;
////			ArrayList<jsonFile> returnlist = new ArrayList<jsonFile>();
//			String url0=Constants.INTERFACE_URL+"/userMaterial/userMaterial/findMaterialsByUser";
//			List<NameValuePair> nameValuePairs0 = new ArrayList<NameValuePair>();
//			nameValuePairs0.add(new BasicNameValuePair("userIdCard",vo.getUserIdCard()));
//			nameValuePairs0.add(new BasicNameValuePair("userType", vo.getUserType()));
//			nameValuePairs0.add(new BasicNameValuePair("ids",vo.getMaterialId()));
//			Map<String,Object> resultmap = httpServiceUtils.send(url0, nameValuePairs0);
//			boolean backflag = (boolean) resultmap.get("success");
//			JSONArray jsonarray0 = null;
//			jsonUserMaterial tempVo = new jsonUserMaterial();
//			if(backflag==true){
//				jsonarray0 = (JSONArray) resultmap.get("entity");
//				JSONObject object = (JSONObject) jsonarray0.get(0);
//				tempVo.setId(object.get("id").toString());
//			}else{
//				tempVo.setId("");
//			}
//			String url=Constants.INTERFACE_URL+"/realUserMaterial/realUserMaterial/findListByUserMaterialid";
//			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//			nameValuePairs.add(new BasicNameValuePair("userMaterialid",tempVo.getId()));
//			Map<String,Object> resultmap1 = httpServiceUtils.send(url, nameValuePairs);
//			boolean backflag1 = (boolean) resultmap1.get("success");
//			if(backflag1==true){
//				JSONArray array = (JSONArray) resultmap1.get("entity");
//				if(array.size()>0){
//					flag=true;
//				}
//			}
//			return flag;
//		}
//		
//		
//		
//		//方法返回的list，实际返回的集合中最多只有1个元素
//		public static List<trans> getMatterInfoByMatterId(trans trans){
//			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//			String url=Constants.INTERFACE_URL+"/trans/trans/findOne";
////			String transId = trans.getId();
//	        if(trans.getId()!=null&&!"".equals(trans.getId())){
//	        	nameValuePairs.add(new BasicNameValuePair("id", trans.getId()));
//	            Map<String,Object> resultmap = httpServiceUtils.send(url,nameValuePairs);
//	            boolean flag = (boolean) resultmap.get("success");
//	            JSONArray result = null;
////	            System.out.println(result);
//	            trans mattervo = null;
//	            List<trans> returnlist = new ArrayList<trans>();
//	            StringBuffer strbuf = null;
//	            if(flag==true){
//	            	result = (JSONArray) resultmap.get("entity");
//	            	for(int i=0;i<result.size();i++){
//	                	JSONObject jsonObject = (JSONObject)result.get(i);
//	                	//将jsonobject转换成matterVo对象
//	                	mattervo = new trans();
//	                	mattervo.setId(jsonObject.get("id").toString());
//	                	mattervo.setMaterialIds(jsonObject.get("materialIds").toString());
//	                	mattervo.setTransName(jsonObject.get("transName").toString());
//	                	mattervo.setTransBaseCode(jsonObject.get("transBaseCode").toString());
//	                	returnlist.add(mattervo);
//	                }
//	                String url1=Constants.INTERFACE_URL+"/material/material/findMaterialList";
//	                nameValuePairs.clear();
//	                for(int i=0;i<result.size();i++){
//	                	nameValuePairs.add(new BasicNameValuePair("ids", returnlist.get(i).getMaterialIds()));
//	                    JSONArray resultmaterialId = (JSONArray)httpServiceUtils.post(url1,nameValuePairs);
//	                    strbuf =  new StringBuffer();
//	                    ArrayList<String> nameList = new ArrayList<String>();
//	                    ArrayList<String> idList = new ArrayList<String>();
//	                    if(resultmaterialId!=null&&!"[null]".equals(resultmaterialId.toString())){
//	                    	//给每个事项实体对象添加申请材料名称 字符串
//	                    	for(int j=0;j<resultmaterialId.size();j++){
//	                        	JSONObject jsonObject = (JSONObject)resultmaterialId.get(j);
//	                        	strbuf.append(jsonObject.get("materialName")+",");
//	                        }
//	                        if(strbuf.length()>0){
//	                        	strbuf.substring(0, strbuf.length()-1);
//	                        }
//	                        returnlist.get(i).setMaterialNames(strbuf.toString());
//	                        //将申请材料名称组装成集合 放入实体对象
//	                        for(int j=0;j<resultmaterialId.size();j++){
//	                        	JSONObject jsonObject = (JSONObject)resultmaterialId.get(j);
//	                        	nameList.add(jsonObject.get("materialName").toString());
//	                        	idList.add(jsonObject.get("id").toString());
//	                        }
//	                        returnlist.get(i).setMaterialNameList(nameList);
//	                        returnlist.get(i).setMaterialIdList(idList);
//	                    }
//	                }
//	            }
//	            return returnlist;
//	        }else{
//	        	return null;
//	        }
//		}
	
	public static ArrayList<applyInfo> findApplyHises(String applicationDocumentNumber , String applicantDocumentType){
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
        return hislist;
	}
}
