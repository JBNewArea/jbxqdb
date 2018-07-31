package com.numberONe;

public interface Constants {
	String status_theme_applying="001";//主题办件还在办
	String status_theme_applydone="000";//主题办件办结了
	String status_done="00W";//数据无效，用于逻辑删除
	String status_work="00Y";//数据有效
	String status_apply="000";//单个办件的状态 正常状态
	String status_hasten="001";//已催办状态
	
//	String INTERFACE_URL="http://47.96.161.157:8090/xzsp-interface/a/rpc";//旧接口地址
	String INTERFACE_URL="http://221.226.86.27:8090/xzsp-interface/a/rpc";//新接口地址
	String PRE_IMGURL="";//文件地址前缀
	
	//utf8编码
	String ENCODING_UTF8 = "UTF-8";
	
	String daibanId = "5";
	
	
	
	
	//========================================================
	/** int类型的NULL表示. */
	int NULL_INT = -2147483648;

	/** float类型的NULL表示. */
	float NULL_FLOAT = 1.4E-45F;

	/** double类型的NULL表示. */
	double NULL_DOUBLE = 4.9E-324D;

	/** long类型的NULL表示. */
	long NULL_LONG = -9999999999999998L; // -9223372036854775808L; 前台JAVASCRIPT没有这么大的值

	/** String类型的NULL标识 */
	String NULL_STRING = "-nullnull-";

	String SPLICE_CHARACTER = "_";
	
	/** 缓存模式_本地缓存 */
	String CACHE_MODE_LOCAL = "LOCAL";

	/** 缓存模式_REDIS */
	String CACHE_MODE_REDIS = "REDIS";
	
	/** UTF-8编码集. */
	String UTF_8_ENCODING = "UTF-8";
	
	/**
	 * 通用分隔符
	 */
	String SPLIT_COMMON = ",";
	
    /**vno_id_path的分隔符**/
    String VNO_PATH_SPLIT = "-";

	/** root Vno */
	Long ROOT_VNO = 0l;
	
	/** 组织部门属性名称 */
	String VNO_FIELD_NAME = "vnoId";
	
	/**
	 * 数据库类型：postgres
	 */
	String DB_TYPE_POSTGRES = "postgres";
	
	/**
	 * 数据库类型：mysql
	 */
	String DB_TYPE_MYSQL = "mysql";
	
	/**
	 * 数据库类型：oracle
	 */
	String DB_TYPE_ORACLE = "oracle";
	
    String SYS_MSG = "SYS_MSG";
    
    String SIGN_TYPE_MD5 = "MD5";
    
    String CONTENT_TYPE_JSON = "application/json";
    
    String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    
    //短信验证码
    String SMS_VALIDCODE_KEY = "SMS_VALIDCODE_KEY";
    
    String description_pingtai = "3";
}
