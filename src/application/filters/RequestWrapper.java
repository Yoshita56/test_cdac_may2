/**********************************************************
 Project:	   DWH_CMSS	
 File:         RequestWrapper.java
 Created:      Jul 3, 2014
 Last Changed: May 21, 2018
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package application.filters;


import java.text.ParseException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.StrutsRequestWrapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

/**
 * The Class RequestWrapper.
 */
public final class RequestWrapper extends StrutsRequestWrapper {
	private static final String TOKEN_KEY = "fhttf";

	/**
	 * Instantiates a new request wrapper.
	 * 
	 * @param servletRequest
	 *            the servlet request
	 */
	public RequestWrapper(HttpServletRequest servletRequest) {

		super(servletRequest);
		
		Enumeration requestheaderNames = servletRequest.getHeaderNames();
		//System.out.println("Inside Request Wrapper INVMGM--" + requestheaderNames);
		while (requestheaderNames.hasMoreElements())
		{
			String nextElement = (String) requestheaderNames.nextElement();
			//System.out.println(nextElement);
			String requestDataArray = servletRequest.getHeader(nextElement);
			//System.out.println(requestDataArray);
			cleanXSS(requestDataArray);
		}
		
		
		Enumeration requestParameters = servletRequest.getParameterNames();
		while (requestParameters.hasMoreElements())
		{
			String nextElement = (String) requestParameters.nextElement();
			String requestDataArray[] = servletRequest.getParameterValues(nextElement);
			if (requestDataArray.length != 0) 
				for (int i = 0; i < requestDataArray.length; i++)
					if (requestDataArray[i]!=null &&  !requestDataArray[i].trim().equals(""))
					{
						cleanXSS(requestDataArray[i]);
					}
		
		}
		
		//checkTemparedData(servletRequest);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletRequestWrapper#getParameterValues(java.lang.String)
	 */
	public String[] getParameterValues(String parameter) {

		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		//System.out.println("Count-->>>" + count);
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			//System.out.println("Parameter--->>>" + parameter + "<<" + values[i]);
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	 */
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		//System.out.println("Parameter--->>>" + parameter + ">>" + value);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServletRequestWrapper#getHeader(java.lang.String)
	 */
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (value == null)
			return null;
		return cleanXSS(value);

	}

	/**
	 * Clean xss.
	 * 
	 * @param value
	 *            the value
	 * @return the string
	 */
	private String cleanXSS(String value) {
		Pattern scriptPattern = null;
		Matcher m = null;
		//System.out.println("Two -->>" + value);
		// You'll need to remove the spaces from the html entities below
		  //value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			value = value.replaceAll("'", "");
			value = value.replaceAll("'", "& #39;");
		  /*value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		  value = value.replaceAll("eval\\((.*)\\)", "");
		  value =
		  value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']","\"\"");
		  value = value.replaceAll("script", "");*/
		value = value.replaceAll("confirm", "").replaceAll("prompt", "").replaceAll("alert", "");

		// Avoid null characters
		value = value.replaceAll("", "");
		value = value.replaceAll("___", "^");
		//value = value.replaceAll("a__b__c", "|");
		// //System.out.println("Value Befor Pattern Match-->>"+value);

		// Avoid anything between script tags
		scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
		m = scriptPattern.matcher(value);
		// value = scriptPattern.matcher(value).replaceAll("");

		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-1-> <script>(.*?)</script>");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid anything in a src='...' type of expression
		// scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
		// Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		// value = scriptPattern.matcher(value).replaceAll("");

		// scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
		// Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		// value = scriptPattern.matcher(value).replaceAll("");

		// Remove any lonesome </script> tag
		scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
		// value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-2-> </script>");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		// Remove any lonesome <script ...> tag
		scriptPattern = Pattern.compile("<script(.*?)>",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		// value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-2-> <script(.*?)>");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid eval(...) expressions
		scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		// value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-3-> eval\\((.*?)\\)");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid expression(...) expressions
		scriptPattern = Pattern.compile("expression\\((.*?)\\)",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		// value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-4-> expression\\((.*?)\\)");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid javascript:... expressions
		scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
		// value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper5-> javascript:");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid vbscript:... expressions
		scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
		// value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-6-> vbscript");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid onload= expressions
		scriptPattern = Pattern.compile("onload(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		// value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-7-> onload(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		scriptPattern = Pattern.compile("onblur(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-8-> onblur(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		scriptPattern = Pattern.compile("onClick(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-9-> onClick(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

	/*	scriptPattern = Pattern.compile(" ",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-9-> onmouseover(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}*/

		scriptPattern = Pattern.compile("onmousedown(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-9-> onmousedown(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("onchange(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-9-> onchange(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("ondblclick(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-9-> ondblclick(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("onfocus(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-9-> onfocus(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("onkeydown(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-9-> onkeydown(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("onkeyup(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-9-> onkeyup(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("onmouseout(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-9-> onmouseout(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("onmouseup(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-9-> onmouseup(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("onmousemove(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			//System.out.println("Match Found--In Request Wrapper-9-> onmousemove(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		scriptPattern = Pattern.compile("onselect(.*?)=",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

		m = scriptPattern.matcher(value);
		if (m.find()) {
			 //System.out.println("Match Found--In Request Wrapper-9-> onselect(.*?)=");
			// value = scriptPattern.matcher(value).replaceAll("");
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("<(.*?)>",Pattern.CASE_INSENSITIVE);
		  m = scriptPattern.matcher(value);
		  if (m.find()) 
			{
				//System.out.println("Match Found--In Request Wrapper-1-> Pattern <(.*?)>");
				//value = scriptPattern.matcher(value).replaceAll("");	
				throw new IllegalStateException("Illegal Activity Not Allowed !!");
			}

		//System.out.println("Three Final Value ASASAS-->>" + value);
		return value;
	}

	public Map<String, String[]> getParameterMap()
	{  
		//System.out.println("In getParameterMap-->>");
		Map<String, String[]> paramMapIn = super.getParameterMap();  
        Map<String, String[]> paramMapOut = new HashMap<String, String[]>();  
        Iterator<String> keys = paramMapIn.keySet().iterator();  
        while (keys.hasNext()) {  
             String key = keys.next();  
             String[] values = paramMapIn.get(key);  
             if (values.length == 1)
             {  
     			//System.out.println("Parameter--->>>"+key+"<<"+values[0]);
    			String value = cleanXSS(values[0]);  
                paramMapOut.put(key, new String[] { value });  
             }
             else
             {  
         		for (int i = 0; i < values.length; i++)
         		{
        			//System.out.println("Parameter--->>>" + key + "<<" + values[i]);
        			values[i] = cleanXSS(values[i]);
        		}
				paramMapOut.put(key, values);  
             }  
        }
        return super.getParameterMap();  
   }
	
	/*
	 * public Map getParameterMap() { System.out.println("In getParameterMap");
	 * Map<String, String[]> originalMap = super.getParameterMap(); Map<String,
	 * String[]> filteredMap = new ConcurrentHashMap<String,
	 * String[]>(originalMap.size()); for (String name : originalMap.keySet()) {
	 * filteredMap.put(name, getParameterValues(name)); } return
	 * Collections.unmodifiableMap(filteredMap); }
	 */

	public Object getAttribute(String s) {
		Object attribute = super.getAttribute(s);
		 //System.out.println("In getAttribute-->>"+s);
		return attribute;
	}
	
	String[] arrBypassParameter={"org.apache.struts.taglib.html.TOKEN"};
	String[] arrBypassParameterValue={};
	String[] arrreplaceParameterValue={/*"undefined"," ","\\r?\\n"*/};
	
	private void checkTemparedData(HttpServletRequest servletRequest) 
	{  
		//System.out.println("inside checkTemparedData");
		//StringBuffer sb = new StringBuffer("");	
		//sb.append("[");
		
		
		boolean isTempared=false;
		Enumeration requestParameters = servletRequest.getParameterNames();
		
		List<String> list = Collections.list(requestParameters);
		Collections.sort(list);
		JSONArray jsonArrayA= new JSONArray();// for json generated at server end
		String fHTokenVal=null;
		int countParameter=0;
		String oneParameter=null;
		//while(requestParameters.hasMoreElements()){
		try{
		 for (String  parameter :list) {
			countParameter++;
			//String parameter = (String) requestParameters.nextElement();
			oneParameter=parameter;
			String[] values = servletRequest.getParameterValues(parameter);
			int count = values.length;
			if(bypassString(arrBypassParameter,parameter)){
				continue;
			}
			
			if (values!=null && count>0){
				for (int i = 0; i < count; i++){
	
					if (values[i]!=null)
					{
						if(bypassString(arrBypassParameterValue,values[i])){
							continue;
						}
						
						JSONObject  objectA= new JSONObject();
						if (TOKEN_KEY.equalsIgnoreCase(parameter)) {
							fHTokenVal = cleanXSS(values[i]);		//cleanXSS(values[i]);// values[i];		
							objectA.put("name", parameter);
							objectA.put("value", "");					
						}
						else{
							objectA.put("name", parameter);
							/*if(parameter.equals("patLastName"))  //patLastName  //arrRemarks
								objectA.put("value", "cdac");
							else*/
							objectA.put("value", cleanXSS(values[i]));

						}	
						jsonArrayA.put(objectA);
					}
					
				}
			}
		}
		
		 String fToken=null;
		 //System.out.println("fHTokenVal--"+fHTokenVal);
		 if(jsonArrayA != null && jsonArrayA.length() > 0 ){
			fHTokenVal=Base64Utils.decode(fHTokenVal);
			
			JSONArray jsonArrayB=null;// for json generated at client end 
			
			if(fHTokenVal!=null && !fHTokenVal.equals("")){
				 try {
					 JSONArray jsonArrayBTemp= new JSONArray(fHTokenVal);
					 jsonArrayB = new JSONArray();
					for(int j = 0; j < jsonArrayBTemp.length(); j++){
						JSONObject  objectB = (JSONObject) jsonArrayBTemp.get(j);
						String nameB = objectB.getString("name");
						if(bypassString(arrBypassParameter,nameB)){
							continue;
						}
						jsonArrayB.put(objectB);
					}
					jsonArrayBTemp=null;
					
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					jsonArrayB=null;
					//System.out.println("key tempared");
					isTempared=true;
				}
				 
				 System.out.println("server --" + jsonArrayA.toString());
				 System.out.println("from browser--"+ jsonArrayB.toString());
				 
			}
			
			if(jsonArrayA!=null && jsonArrayB!=null && isTempared==false){
				String temparedParameter="";
				String valueServer="";
				String valueBrowser="";
				
				for(int i = 0; i < jsonArrayA.length(); i++)
				{
					JSONObject  objectA = (JSONObject) jsonArrayA.get(i);
					String nameA = objectA.getString("name");
					String valueA = objectA.getString("value");
					//if(nameA.equals("varHintAnswer"))
						//System.out.println("nameA--" + nameA + " valueA-" + valueA);
					//int cnt=-1;
					// if more than one parameter with same name then checking again for tempared value
					
					for(int j = 0; j < jsonArrayB.length(); j++){
						JSONObject  objectB = (JSONObject) jsonArrayB.get(j);
						String nameB = objectB.getString("name");
						String valueB = objectB.getString("value");
						//if(nameA.equals("varHintAnswer"))
							System.out.println("valueB== "+ valueB + " nameA.equals(nameB) ==" + nameA.equals(nameB) +" valueA.equals(valueB)=="+ valueA.equals(valueB) );						
							if(nameA.equals(nameB)){
								if(valueA.equals(valueB)){
									isTempared=false;													
									//System.out.println("isTempared in for --"+ isTempared);
									break;
								}
								else{
									isTempared=true;
									temparedParameter=nameA;
									valueServer=valueA;
									valueBrowser=valueB;
								}									
							}												
						} // for j ends
					if(isTempared){
						System.out.println("temparedParameter--"+ temparedParameter + " valueServer-"+ valueServer + " valueBrowser--"+ valueBrowser);
						break;
					}
					
				} // for i ends
				
			}
			
		
		}
		System.out.println("isTempared---" + isTempared);
		if(isTempared){
			throw new IllegalStateException("Illigal Activity Not Allowed !!");
		/*	throw new IllegalStateException("Illigal Activity Not Allowed !!");
			RequestDispatcher rd = null;
			rd = servletRequest.getRequestDispatcher(HISSSOConfig.SSO_ILLEGAL_ACTIVITY_ERROR_PAGE_URL);
			rd.forward(request, response);
			*/
		}
		}catch(JSONException e){
			//System.out.println("JsonException:: RequestWrapper :: Registration");
		}
		//System.out.println("fToken--" + fToken);
		//System.out.println("fHTokenVal--" + fHTokenVal);
		
		
	}
	
	private boolean bypassString(String [] arr, String compareValue){
		boolean flag=false;
		if(arr!=null || arr.length!=0){
			for(int i=0;i<arr.length;i++){
				if(arr[i].equals(compareValue)){
					flag=true;
					break;
				}
			}
		}
		else
			flag=true;
		
		return flag;
		
	}	
}