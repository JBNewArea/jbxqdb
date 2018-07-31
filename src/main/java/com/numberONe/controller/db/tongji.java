package com.numberONe.controller.db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberONe.Constants;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.echartsData;
import com.numberONe.entity.monthData;
import com.numberONe.mapper.ThemeApplyMapper;
@Controller
@RequestMapping(value="/tongji")
public class tongji extends BaseController{
	@Inject
	private ThemeApplyMapper themeApplyMapper;
	
	@RequestMapping(value="/zhexian")
	@ResponseBody
	public HashMap<String,Object> zhexian(){
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		String year = getPara("year");
		String agentId = getPara("pingtai");
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("year", year);
		paramMap.put("agentId", agentId);
		paramMap.put("status",Constants.status_theme_applydone);//办结
		monthData monthData1 = themeApplyMapper.getzhexianData(paramMap);
		
		Date date = new Date();
		Calendar date2 = Calendar.getInstance();
        String year2 = String.valueOf(date2.get(Calendar.YEAR));
        int month = date.getMonth();
		ArrayList<String> monthList = monthData1!=null?monthData1.changetoList():initList();
		ArrayList<String> banjie = new ArrayList<String>();
		for(int i=0;i<monthList.size();i++){
			if(year2.equals(year)&&month<=i){
				break;
			}else{
				banjie.add(monthList.get(i));
			}
		}
		
		
		paramMap.clear();
		paramMap.put("year", year);
		paramMap.put("agentId", agentId);
		monthData monthData2 = themeApplyMapper.getzhexianData(paramMap);
		
		ArrayList<String> monthList2 = monthData2!=null?monthData2.changetoList():initList();
		ArrayList<String> daiban = new ArrayList<String>();
		for(int i=0;i<monthList2.size();i++){
			if(year2.equals(year)&&month<=i){
				break;
			}else{
				daiban.add(monthList2.get(i));
			}
		}
		
		returnMap.put("banjie", banjie);
		returnMap.put("daiban", daiban);
		return returnMap;
	}
	
	public static ArrayList<String> initList(){
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<12;i++){
			list.add("0");
		}
		return list;
	}
	
	@RequestMapping(value="/echarts")
	@ResponseBody
	public HashMap<String,Object> echarts(){
		String year = getPara("year");
//		String type = getPara("type");
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("year", year);
		ArrayList<echartsData> echartslandCharac = themeApplyMapper.echartslandCharac(paramMap);
		ArrayList<echartsData> echartsmatterThemeType = themeApplyMapper.echartsmatterThemeType(paramMap);
		ArrayList<echartsData> echartsmoneyResource = themeApplyMapper.echartsmoneyResource(paramMap);
		/*去掉name为null的echartsData元素*/
		removeNull(echartslandCharac);
		removeNull(echartsmatterThemeType);
		removeNull(echartsmoneyResource);
		ArrayList<String> echartslandCharac_name = new ArrayList<String>();
		ArrayList<String> echartsmatterThemeType_name = new ArrayList<String>();
		ArrayList<String> echartsmoneyResource_name = new ArrayList<String>();
		for(echartsData data : echartslandCharac){
			String name = data.getName();
			String name_temp = "";
			if("1".equals(name)){
				name_temp = "划拨";
			}else if("2".equals(name)){
				name_temp = "出让";
			}else if("3".equals(name)){
				name_temp = "集体";
			}
			else if("4".equals(name)){
				name_temp = "自有";
			}
			else if("5".equals(name)){
				name_temp = "其他";
			}else{
				name_temp = "综合";
			}
			data.setName(name_temp);
			echartslandCharac_name.add(name_temp);
		}
		for(echartsData data : echartsmatterThemeType){
			String name = data.getName();
			String name_temp = "";
			if("1".equals(name)){
				name_temp = "区域交通";
			}else if("2".equals(name)){
				name_temp = "城市道路";
			}else if("3".equals(name)){
				name_temp = "环境整治";
			}else if("4".equals(name)){
				name_temp = "商业办公";
			}else if("5".equals(name)){
				name_temp = "居住";
			}else if("6".equals(name)){
				name_temp = "科研";
			}else if("7".equals(name)){
				name_temp = "工业仓储";
			}else if("8".equals(name)){
				name_temp = "市政设施";
			}else if("9".equals(name)){
				name_temp = "公建配套";
			}else if("a".equals(name)){
				name_temp = "公园绿地";
			}else if("b".equals(name)){
				name_temp = "其他";
			}else{
				name_temp = "综合";
			}
			data.setName(name_temp);
			echartsmatterThemeType_name.add(name_temp);
		}
		for(echartsData data : echartsmoneyResource){
			String name = data.getName();
			String name_temp = "";
			if("1".equals(name)){
				name_temp = "政府";
			}else if("2".equals(name)){
				name_temp = "民资";
			}else if("3".equals(name)){
				name_temp = "港澳台";
			}else if("4".equals(name)){
				name_temp = "外资";
			}else if("5".equals(name)){
				name_temp = "其他";
			}else{
				name_temp = "综合";
			}
			data.setName(name_temp);
			echartsmoneyResource_name.add(name_temp);
		}
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("echartslandCharac", echartslandCharac);
		returnMap.put("echartsmatterThemeType", echartsmatterThemeType);
		returnMap.put("echartsmoneyResource", echartsmoneyResource);
		returnMap.put("echartslandCharac_name", echartslandCharac_name);
		returnMap.put("echartsmatterThemeType_name", echartsmatterThemeType_name);
		returnMap.put("echartsmoneyResource_name", echartsmoneyResource_name);
		return returnMap;
		
	}
	
	public static void removeNull(ArrayList<echartsData> list){
		Iterator<echartsData> it = list.iterator();
		while(it.hasNext()){
			echartsData data = it.next();
		    if(null==data.getName()||"null".equals(data.getName())||"".equals(data.getName())){
		    	it.remove();
		    }
		}
	}
	
}
