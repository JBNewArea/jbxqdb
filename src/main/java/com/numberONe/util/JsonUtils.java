package com.numberONe.util;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
  
public class JsonUtils { 
	
	/**
	 *  一个String字符串转换为json格式
	 *@descript
	 *@param s
	 *@return
	 *@author lijianning
	 *@date 2015年6月15日
	 *@version 1.0v
	 */
    public static String stringToJson(String s) { 
        if (s == null) { 
            return nullToJson(); 
        } 
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < s.length(); i++) { 
            char ch = s.charAt(i); 
            switch (ch) { 
            case '"': 
                sb.append("\\\""); 
                break; 
            case '\\': 
                sb.append("\\\\"); 
                break; 
            case '\b': 
                sb.append("\\b"); 
                break; 
            case '\f': 
                sb.append("\\f"); 
                break; 
            case '\n': 
                sb.append("\\n"); 
                break; 
            case '\r': 
                sb.append("\\r"); 
                break; 
            case '\t': 
                sb.append("\\t"); 
                break; 
            case '/': 
                sb.append("\\/"); 
                break; 
            default: 
                if (ch >= '\u0000' && ch <= '\u001F') { 
                    String ss = Integer.toHexString(ch); 
                    sb.append("\\u"); 
                    for (int k = 0; k < 4 - ss.length(); k++) { 
                        sb.append('0'); 
                    } 
                    sb.append(ss.toUpperCase()); 
                } else { 
                    sb.append(ch); 
                } 
            } 
        } 
        return sb.toString(); 
    } 
   
    public static String nullToJson() { 
        return ""; 
    } 
   
    /**
     * 一个obj对象转换为json格式
     *@descript
     *@param obj
     *@return
     *@author lijianning
     *@date 2015年6月15日
     *@version 1.0v
     */
    public static String objectToJson(Object obj) { 
        StringBuilder json = new StringBuilder(); 
        if (obj == null) { 
            json.append("\"\""); 
        } else if (obj instanceof Number) { 
            json.append(numberToJson((Number) obj)); 
        } else if (obj instanceof Boolean) { 
            json.append(booleanToJson((Boolean) obj)); 
        } else if (obj instanceof String) { 
            json.append("\"").append(stringToJson(obj.toString())).append("\""); 
        } else if (obj instanceof Object[]) { 
            json.append(arrayToJson((Object[]) obj)); 
        } else if (obj instanceof List) { 
            json.append(listToJson((List<?>) obj)); 
        } else if (obj instanceof Map) { 
            json.append(mapToJson((Map<?, ?>) obj)); 
        } else if (obj instanceof Set) { 
            json.append(setToJson((Set<?>) obj)); 
        } else { 
            json.append(beanToJson(obj)); 
        } 
        return json.toString(); 
    } 
   
    public static String numberToJson(Number number) { 
        return number.toString(); 
    } 
   
    public static String booleanToJson(Boolean bool) { 
        return bool.toString(); 
    } 
   
   /**
    *  一个bean对象转换为json格式
    *@descript
    *@param bean
    *@return
    *@author lijianning
    *@date 2015年6月15日
    *@version 1.0v
    */
    public static String beanToJson(Object bean) { 
        StringBuilder json = new StringBuilder(); 
        json.append("{"); 
        PropertyDescriptor[] props = null; 
        try { 
            props = Introspector.getBeanInfo(bean.getClass(), Object.class) 
                    .getPropertyDescriptors(); 
        } catch (IntrospectionException e) { 
        } 
        if (props != null) { 
            for (int i = 0; i < props.length; i++) { 
                try { 
                    String name = objectToJson(props[i].getName()); 
                    String value = objectToJson(props[i].getReadMethod() 
                            .invoke(bean)); 
                    json.append(name); 
                    json.append(":"); 
                    json.append(value); 
                    json.append(","); 
                } catch (Exception e) { 
                } 
            } 
            json.setCharAt(json.length() - 1, '}'); 
        } else { 
            json.append("}"); 
        } 
        return json.toString(); 
    } 
   
    /**

     *@descript
     *@param list
     *@return
     *@author lijianning
     *@date 2015年6月15日
     *@version 1.0v
     */
    public static String listToJson(List<?> list) { 
        StringBuilder json = new StringBuilder(); 
        json.append("["); 
        if (list != null && list.size() > 0) { 
            for (Object obj : list) { 
                json.append(objectToJson(obj)); 
                json.append(","); 
            } 
            json.setCharAt(json.length() - 1, ']'); 
        } else { 
            json.append("]"); 
        } 
        return json.toString(); 
    } 
   
    /**
     *  一个数组集合转换为json格式
     *@descript
     *@param array
     *@return
     *@author lijianning
     *@date 2015年6月15日
     *@version 1.0v
     */
    public static String arrayToJson(Object[] array) { 
        StringBuilder json = new StringBuilder(); 
        json.append("["); 
        if (array != null && array.length > 0) { 
            for (Object obj : array) { 
                json.append(objectToJson(obj)); 
                json.append(","); 
            } 
            json.setCharAt(json.length() - 1, ']'); 
        } else { 
            json.append("]"); 
        } 
        return json.toString(); 
    } 
   
   /**
    * 一个Map集合转换为json格式
    *@descript
    *@param map
    *@return
    *@author lijianning
    *@date 2015年6月15日
    *@version 1.0v
    */
    public static String mapToJson(Map<?, ?> map) { 
        StringBuilder json = new StringBuilder(); 
        json.append("{"); 
        if (map != null && map.size() > 0) { 
            for (Object key : map.keySet()) { 
                json.append(objectToJson(key)); 
                json.append(":"); 
                json.append(objectToJson(map.get(key))); 
                json.append(","); 
            } 
            json.setCharAt(json.length() - 1, '}'); 
        } else { 
            json.append("}"); 
        } 
        return json.toString(); 
    } 
   
   /**
    * 一个Set集合转换为json格式 
    *@descript
    *@param set
    *@return
    *@author lijianning
    *@date 2015年6月15日
    *@version 1.0v
    */
    public static String setToJson(Set<?> set) { 
        StringBuilder json = new StringBuilder(); 
        json.append("["); 
        if (set != null && set.size() > 0) { 
            for (Object obj : set) { 
                json.append(objectToJson(obj)); 
                json.append(","); 
            } 
            json.setCharAt(json.length() - 1, ']'); 
        } else { 
            json.append("]"); 
        } 
        return json.toString(); 
    } 
    /**
     * json字符串转换为List
     *@descript
     *@param jsonStr
     *@return
     *@author lijianning
     *@date 2015年6月15日
     *@version 1.0v
     */
    public static List<Map<String, Object>> parseJSONList(String jsonStr){  
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);  
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
        Iterator<JSONObject> it = jsonArr.iterator();  
        while(it.hasNext()){  
            JSONObject JSON = it.next();  
            list.add(parseJSONMap(JSON.toString()));  
        }  
        return list;  
    }  
      
     /**
      * json字符串转换为map
      *@descript
      *@param jsonStr
      *@return
      *@author lijianning
      *@date 2015年6月15日
      *@version 1.0v
      */
    public static Map<String, Object> parseJSONMap(String jsonStr){  
        Map<String, Object> map = new HashMap<String, Object>();  
        try {
			//最外层解析  
			JSONObject json = JSONObject.fromObject(jsonStr);
			for (Object k : json.keySet()) {
				Object v = json.get(k);
				//如果内层还是数组的话，继续解析  
				if (v instanceof JSONArray) {
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					Iterator<JSONObject> it = ((JSONArray) v).iterator();
					while (it.hasNext()) {
						JSONObject JSON = it.next();
						list.add(parseJSONMap(JSON.toString()));
					}
					map.put(k.toString(), list);
				} else {
					map.put(k.toString(), v);
				}
			} 
		} catch (Exception e) {
			map.put("exception", jsonStr);
		}
		return map;  
    }  
      
     /**
      * 根据一个url地址.获取json数据.转换为List
      *@descript
      *@param url
      *@return
      *@author lijianning
      *@date 2015年6月15日
      *@version 1.0v
      */
    public static List<Map<String, Object>> getListByUrl(String url){  
        try {  
            //通过HTTP获取JSON数据  
            InputStream in = new URL(url).openStream();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
            StringBuilder sb = new StringBuilder();  
            String line;  
            while((line=reader.readLine())!=null){  
                sb.append(line);  
            }  
            return parseJSONList(sb.toString());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
     /**
      * 根据一个url地址.获取json数据.转换为MAP
      *@descript
      *@param url
      *@return
      *@author lijianning
      *@date 2015年6月15日
      *@version 1.0v
      */
    public static Map<String, Object> getMapByUrl(String url){  
        try {  
            //通过HTTP获取JSON数据  
            InputStream in = new URL(url).openStream();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
            StringBuilder sb = new StringBuilder();  
            String line;  
            while((line=reader.readLine())!=null){  
                sb.append(line);  
            }  
            return parseJSONMap(sb.toString());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    /**
     * 检验身份证是否合法
     * */
    /**
     * 功能：身份证的有效验证
     * 
     * @param IDStr
     *            身份证号
     * @return true 有效：false 无效
     * @throws ParseException
     */
    public static boolean IDCardValidate(String IDStr) throws ParseException {
        String[] ValCodeArr = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" };
        String Ai = "";
        // ================ 号码的长度18位 ================
        if (IDStr.length() != 18) {
            return false;
        }
        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } 
        if (isNumeric(Ai) == false) {
            //errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return false;
        }
        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 日
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
//          errorInfo = "身份证生日无效。";
            return false;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150 || (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                //errorInfo = "身份证生日不在有效范围。";
                return false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            //errorInfo = "身份证月份无效";
            return false;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            //errorInfo = "身份证日期无效";
            return false;
        }
        // ================ 地区码时候有效 ================
        Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            //errorInfo = "身份证地区编码错误。";
            return false;
        }
        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                //errorInfo = "身份证无效，不是合法的身份证号码";
                return false;
            }
        } else {
            return true;
        }
        return true;
    }
    
    /**
     * 功能：设置地区编码
     * 
     * @return Hashtable 对象
     */
    @SuppressWarnings("unchecked")
    private static Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
//      hashtable.put("71", "台湾");
//      hashtable.put("81", "香港");
//      hashtable.put("82", "澳门");
//      hashtable.put("91", "国外");
        return hashtable;
    }
    
    /**
     * 功能：判断字符串是否为数字
     * 
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 功能：判断字符串是否为日期格式
     * 
     * @param str
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 验证统一信用代码
     * @param businessCode
     * @return
     */
    public static boolean isValid(String businessCode) {
        if ((businessCode.equals("")) || businessCode.length() != 18) {
            return false;
        }
        String baseCode = "0123456789ABCDEFGHJKLMNPQRTUWXY";
        char[] baseCodeArray = baseCode.toCharArray();
        Map<Character, Integer> codes = new HashMap<Character, Integer>();
        for (int i = 0; i < baseCode.length(); i++) {
            codes.put(baseCodeArray[i], i);
        }
        char[] businessCodeArray = businessCode.toCharArray();
        Character check = businessCodeArray[17];
        if (baseCode.indexOf(check) == -1) {
            return false;
        }
        int[] wi = { 1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28 };
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            Character key = businessCodeArray[i];
            if (baseCode.indexOf(key) == -1) {
                return false;
            }
            sum += (codes.get(key) * wi[i]);
        }
        int value = 31 - sum % 31;
        return value == codes.get(check);
    }
}