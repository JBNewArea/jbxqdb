package test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class test {
	public static void main(String[] args) throws Exception{ 
		boolean[] boolArray = new boolean[]{true,false,true}; 
		JSONArray jsonArray = JSONArray.fromObject( boolArray ); 
		System.out.println( jsonArray ); 

		List list = new ArrayList(); 
		list.add( "first" ); 
		list.add( "second" ); 
		JSONArray jsonArray2 = JSONArray.fromObject( list ); 
		System.out.println( jsonArray2 ); 
		} 
}
