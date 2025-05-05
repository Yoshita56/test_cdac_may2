package in.cdac.invWebServices.utility;

import in.cdac.invWebServices.global.util.MongoXmlHandler;
import in.cdac.invWebServices.config.HISConfig;
import in.cdac.invWebServices.general.dao.GeneralDao;
import in.cdac.invWebServices.general.vo.Hospital;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;


public class Utility {
	
	public static void printVO (Object obj){
		Class<? extends Object> cls = obj.getClass();
		Method[] methods = cls.getDeclaredMethods();
	//	System.out.println("Values of Class " + cls.getName());
		for (int i=0;i<methods.length;++i) {
			String mName = methods[i].getName();
			if (mName.startsWith("get")) {
				try {
					Object o = methods[i].invoke(obj, (Object[]) null);
					if (o == null) {
						System.out.println(mName.substring(3) + " = null");
					} else {
						if (o instanceof Object[]) {
						//	System.out.print(mName.substring(3) + " = ");
							Object[] oa = (Object[]) o;
							String res = "[";
							int j=0;
							for (;j<oa.length;++j)
								res += (oa[j] == null) ? "" : oa[j].toString() + ",";
							if (j>0)
								res = res.substring(0, res.length()-1);
							res += "]";
							//System.out.println(res);
						} else {
							System.out.println(mName.substring(3) + " = " + o.toString());
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void printVOOnErrorConsole (Object obj){
		Class<? extends Object> cls = obj.getClass();
		Method[] methods = cls.getDeclaredMethods();
		//System.err.println("Values of Class " + cls.getName());
		for (int i=0;i<methods.length;++i) {
			String mName = methods[i].getName();
			if (mName.startsWith("get")) {
				try {
					Object o = methods[i].invoke(obj, (Object[]) null);
					if (o == null) {
						System.err.println(mName.substring(3) + " = null");
					} else {
						if (o instanceof Object[]) {
							System.err.print(mName.substring(3) + " = ");
							Object[] oa = (Object[]) o;
							String res = "[";
							int j=0;
							for (;j<oa.length;++j)
								res += (oa[j] == null) ? "" : oa[j].toString() + ",";
							if (j>0)
								res = res.substring(0, res.length()-1);
							res += "]";
							System.err.println(res);
						} else {
							System.err.println(mName.substring(3) + " = " + o.toString());
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void populateFromParamMap(MultivaluedMap<String, String> params, Object obj) {
		Class<?> objClass = obj.getClass();
		Method[] classMethods = objClass.getMethods();
		HashMap<String, Integer> getterInClass = new HashMap<String, Integer>();
		for (int i=0;i<classMethods.length;++i) {
			if (classMethods[i].getName().indexOf("set") == 0) {
				getterInClass.put(Character.toLowerCase(classMethods[i].getName().charAt(3)) + classMethods[i].getName().substring(4), i);
			}
		}
				
		// Iterate over the Parameter Map and invoke setter methods
		Iterator<String> itr = params.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();			
			if (getterInClass.containsKey(key)) {
				String value = params.getFirst(key);
				try {
					classMethods[getterInClass.get(key)].invoke(obj, new Object[]{value});
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				//	System.out.println("Error for Method " + key);
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void logQueryAndParams (String query, List<? extends Object> params) {
		if (query != null)
			System.out.println("Query = " + query);
		else 
			System.out.println("Query is Null.");
		if (params != null) 
			System.out.println("Parameters = " + params);
		else 
			System.out.println("Parameters are Null.");
	}
	
	public static String errorMsg(String msg) {
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("SUCCESS", false);
			jobj.put("msg", msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		return jobj.toString();
	}
	
	public static String checkForHash (JSONArray jArray, String hash) {
		String result = jArray.toString();
		try {
			if (hash != null && hash.length() >= 1) {
				JSONObject obj = new JSONObject();
				if (hash.equals(String.valueOf(result.hashCode()))) {
					obj.put("hashed", 1);
				} else {
					obj.put("hashed", 0);
					obj.put("value", jArray);
					obj.put("hash", (jArray == null || jArray.length() == 0) ? 0 : result.hashCode());
				}
				result = obj.toString();
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	public static String checkForHash (JSONObject jObject, String hash) {
		String result = jObject.toString();
		try {
			if (hash != null && hash.length() >= 1) {
				JSONObject obj = new JSONObject();
				if (hash.equals(String.valueOf(result.hashCode()))) {
					obj.put("hashed", 1);
				} else {
					obj.put("hashed", 0);
					obj.put("value", jObject);
					obj.put("hash", (jObject == null || !jObject.keys().hasNext()) ? 0 : result.hashCode());
				}
				result = obj.toString();
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	public static String getHospitalSpecificName(String hcode) {
		return hcode.split("-")[0];
	}
	
	public static String getHospitalSpecificCode(String hcode) {		
		return hcode.split("-")[1];
	}	
	
	
	public static int getDayOfWeekFromDate(String dateString){
		String format = "yyyy-MM-dd";
		int dayWeek=0;
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date;
		try {
			date = df.parse(dateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dayWeek;
		
	}
	
	
	public static int getWeekOfMonthFromDate(String dateString){
		String format = "yyyy-MM-dd";
		int week=0;
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date;
		try {
			date = df.parse(dateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			week = cal.get(Calendar.WEEK_OF_MONTH);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return week;
		
	}
	
	public static String getFilename(String crNo,String reqDno,String hosCode) 
	{
		GeneralDao objDao = new GeneralDao();
		String filename = objDao.getFilename( crNo, reqDno, hosCode);
		
		return filename;
	
	} 
	
	public static  byte[] addHeader(byte[] byteArray){
		
		//System.out.println("Add Header to Reports.");
		
		PdfReader reader=null;
		PdfStamper stamp =null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		//HttpSession session=request.getSession();
		
		try
		{
			reader=new PdfReader(byteArray);
			int n = reader.getNumberOfPages();
			//stamp = new PdfStamper(reader, new FileOutputStream("E:/out1.pdf"));
			stamp = new PdfStamper(reader, output);
			
			
			int i = 1;
		    PdfContentByte under;
		    PdfContentByte over;
		     
		     //Image img = Image.getInstance(session.getServletContext().getRealPath(InvestigationConfig.WATERMARK_IMAGE_FOR_DUPLICATE_REPORT_PRINTING));
		     
		     //img.setBackgroundColor(Color.white);		      
		      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,BaseFont.WINANSI, BaseFont.EMBEDDED);
		      
		     //changed by ashu
		     //Image img = Image.getInstance(InvWebSserviceConfig.IMAGE_FOR_HEADER);
		      Image img=null;
		      
		      
		      String osType = System.getProperties().getProperty("os.name");
		      //System.out.println(" osType : "+osType); 
				if(osType.startsWith("Win")){
					img=Image.getInstance(HISConfig.IMAGE_FOR_HEADER_WINDOWS);
				}else{
					
					img=Image.getInstance(HISConfig.IMAGE_FOR_HEADER_LINUX);
				}
	
		      
		      //img.setAbsolutePosition(20, 745);
		      
		      img.setAbsolutePosition(20, 760);
			  img.scalePercent(38);
		     //img.setAbsolutePosition(20, 735);
		     
		    // System.out.println(" i : "+i+" n : "+n);
		
		      while (i <= n) 
		      {
		    	  
		    	  over = stamp.getOverContent(i);
		          over.beginText();
		          over.setFontAndSize(bf, 11);
		          over.setTextMatrix(30, 30);
		         // over.showText("page " + i +" of "+ n);
		          String ove="Page " + i +" of "+ n;
		          //over.setFontAndSize(bf, 25);
		       
		          over.showTextAligned(Element.ALIGN_BOTTOM, ove, 250f, 30f, 0f);
		          
		          over.addImage(img);  
		          over.setColorFill(new Color(0xC0, 0xC0, 0xC0));
		          over.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 54);
		          //over.showTextAligned(Element.ALIGN_CENTER, "Nizam's Institute of Medical Sciences", 350f, 500f, 0f);
		          //over.showTextAligned(Element.ALIGN_CENTER, "Nizam's Institute of Medical Sciences", 350f,800f, 0f);
		         // over.showTextAligned(arg0, arg1, arg2, arg3, arg4);
		          over.endText();
		       // over.endMarkedContentSequence();
		        // Watermark under the existing page
		            
		        /*  under = stamp.getUnderContent(i);  
		        under.addImage(img);  
		        under.setColorFill(new Color(0xC0, 0xC0, 0xC0));
		        under.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 54);*/
		        
		        
		        //under.showTextAligned(Element.ALIGN_CENTER, "Duplicate Report", 295f, 552f, 40f);
		        
		        // Text over the existing page under.showTextAlignedKerned(alignment, text, x, y, rotation);
		        over = stamp.getOverContent(i);
		        over.beginText();       
		        over.setFontAndSize(bf, 18); 
		        over.endText();    
		        i++;
		      }
		    
		      stamp.setFormFlattening(true);
		      stamp.close();
		
			}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		
	}
	finally
	{
		
			if(reader!=null){
				reader.close();
			}
			if(stamp!=null){
				try {
					stamp.close();
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
		
		return output.toByteArray();
		//return byteArray;
	}
	
	
	public  byte[] addHeaderFTP(byte[] byteArray){
		
		//System.out.println("Add Header to Reports.");
		
		PdfReader reader=null;
		PdfStamper stamp =null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		//HttpSession session=request.getSession();
		
		try
		{
			reader=new PdfReader(byteArray);
			int n = reader.getNumberOfPages();
			//stamp = new PdfStamper(reader, new FileOutputStream("E:/out1.pdf"));
			stamp = new PdfStamper(reader, output);
			
			
			int i = 1;
		    PdfContentByte under;
		    PdfContentByte over;
		     
		     //Image img = Image.getInstance(session.getServletContext().getRealPath(InvestigationConfig.WATERMARK_IMAGE_FOR_DUPLICATE_REPORT_PRINTING));
		     
		     //img.setBackgroundColor(Color.white);		      
		      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,BaseFont.WINANSI, BaseFont.EMBEDDED);
		      
		     //changed by ashu
		     //Image img = Image.getInstance(InvWebSserviceConfig.IMAGE_FOR_HEADER);
		      Image img=null;
		      
		      
		      String osType = System.getProperties().getProperty("os.name");
		     // System.out.println(" osType : "+osType); 
				if(osType.startsWith("Win")){
					img=Image.getInstance(HISConfig.IMAGE_FOR_HEADER_WINDOWS);
				}else{
					
					img=Image.getInstance(HISConfig.IMAGE_FOR_HEADER_LINUX);
				}
	
		      
		      //img.setAbsolutePosition(20, 745);
				
				img.setAbsolutePosition(20, 810);
				img.scalePercent(38);
		     //img.setAbsolutePosition(20, 735);
		     
		    // System.out.println(" i : "+i+" n : "+n);
		
		      while (i <= n) 
		      {
		    	  
		    	  over = stamp.getOverContent(i);
		          over.beginText();
		          over.setFontAndSize(bf, 11);
		          over.setTextMatrix(30, 30);
		         // over.showText("page " + i +" of "+ n);
		          String ove="Page " + i +" of "+ n;
		          //over.setFontAndSize(bf, 25);
		       
		          over.showTextAligned(Element.ALIGN_BOTTOM, ove, 250f, 30f, 0f);
		          
		          over.addImage(img);  
		          over.setColorFill(new Color(0xC0, 0xC0, 0xC0));
		          over.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 54);
		          //over.showTextAligned(Element.ALIGN_CENTER, "Nizam's Institute of Medical Sciences", 350f, 500f, 0f);
		          //over.showTextAligned(Element.ALIGN_CENTER, "Nizam's Institute of Medical Sciences", 350f,800f, 0f);
		         // over.showTextAligned(arg0, arg1, arg2, arg3, arg4);
		          over.endText();
		       // over.endMarkedContentSequence();
		        // Watermark under the existing page
		            
		        /*  under = stamp.getUnderContent(i);  
		        under.addImage(img);  
		        under.setColorFill(new Color(0xC0, 0xC0, 0xC0));
		        under.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 54);*/
		        
		        
		        //under.showTextAligned(Element.ALIGN_CENTER, "Duplicate Report", 295f, 552f, 40f);
		        
		        // Text over the existing page under.showTextAlignedKerned(alignment, text, x, y, rotation);
		        over = stamp.getOverContent(i);
		        over.beginText();       
		        over.setFontAndSize(bf, 18); 
		        over.endText();    
		        i++;
		      }
		    
		      stamp.setFormFlattening(true);
		      stamp.close();
		
			}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		
	}
	finally
	{
		
			if(reader!=null){
				reader.close();
			}
			if(stamp!=null){
				try {
					stamp.close();
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
		
		return output.toByteArray();
		//return byteArray;
	
	}	
		
	public static  byte[] getReportMongo(String filename) 
	{
		byte[] byteArray=null;
		         
		try {
			byteArray=MongoXmlHandler.getInstance().latestFetchFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    	
	    return byteArray;
	}
	
	
	public static  byte[] getReport(String filename) 
	{
		byte[] byteArray=null;
		
		//List<InputStream> pdfs = new ArrayList<InputStream>();
		String patientcreatefileftpaddress= HISConfig.HIS_FTPSERVER_INV_CONNECTION;
		
		
		String crNo=filename.substring(0,15);
		//System.out.println(filename.substring(5,7));
		String year=    crNo.substring(5,7); //MergeAllPdfNewInv.getYear(crNo); 
	    String insideyear = getInsideYear(crNo);
	    String count= getcount(crNo);
		         
	    
	    String strPdfPath = patientcreatefileftpaddress+"/"+filename.substring(0,5)+"/"+ "20"+year+"/"+insideyear+"/"+count+"/"+filename.substring(0,15)+"/"+filename;
		//String testingfileNAme="331041400000017_10008_05282015034109PM.pdf";
		  
		//System.out.println("strPdfPath : "+strPdfPath);
		
		//ByteArrayOutputStream Pdf;
		try {
			URL urlftp=new URL(strPdfPath);
			URLConnection urlcon=urlftp.openConnection();
			//pdfs.add(urlcon.getInputStream());
			byteArray = IOUtils.toByteArray(urlcon.getInputStream());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*try {
			byteArray=MongoXmlHandler.getInstance().latestFetchFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		    	
	    return byteArray;
	}

	public static  String getStandardRange(String refRange){
			
			String displayRef="";
			
			if(refRange != null || !refRange.equals(""))
			{
			refRange=refRange.replace("$", "@");
			String[] refValues=refRange.split("@");
			 if(refValues.length>1)
			 {
				 String checkRangetyp=refValues[0];
				 if(checkRangetyp.equals("1"))
				 {
					 String highValue=refValues[1];
						
						String lowValue=refValues[2];
						String highValueUom=refValues[3];
						String lowValueUom=refValues[4];
						 displayRef=lowValue+" "+lowValueUom+" - "+highValue+" "+highValueUom;
				 }
				 else if(checkRangetyp.equals("2"))
				 {
					 
					 String rangetyp=">";
						
						String tovalue=refValues[2];
						String tovalueunit=refValues[1];
						
						 displayRef=rangetyp+" "+tovalue+"  "+tovalueunit;
				 } 
					 
				 else if(checkRangetyp.equals("3"))
				 {
					 String rangetyp=">=";
						
						String tovalue=refValues[2];
						String tovalueunit=refValues[1];
						
						 displayRef=rangetyp+" "+tovalue+"  "+tovalueunit;
				 }
				 else if(checkRangetyp.equals("4"))
				 {
					 String rangetyp="<";
						
						String tovalue=refValues[2];
						String tovalueunit=refValues[1];
						
						 displayRef=rangetyp+" "+tovalue+"  "+tovalueunit;
				 }
				 else if(checkRangetyp.equals("5"))
				 {
					 String rangetyp="<=";
						
						String tovalue=refValues[2];
						String tovalueunit=refValues[1];
						
						 displayRef=rangetyp+" "+tovalue+"  "+tovalueunit;
				 }
			
			 }
			}
			else  
				displayRef="";
			 
			 return displayRef;
			
		}
	
	public static String getInsideYear(String crNo) {
		
		 int insideYear=1000000;
		 
		 //String last6Digits = getLastnCharacters(crNo,6);
		 
		 String compareYearWith = crNo.substring(7,14);
		 
		 //System.out.println("for year "+compareYearWith);
		 
	   if (Integer.parseInt(compareYearWith) <= 100000)
     {
   	  insideYear=100000;
     }
     
     else  if ((Integer.parseInt(compareYearWith)) > 100000 && (Integer.parseInt(compareYearWith)) <= 200000)
     {
   	  insideYear=200000;
     }
     
     else  if ((Integer.parseInt(compareYearWith)) > 200000 && (Integer.parseInt(compareYearWith)) <= 300000)
     {
   	  insideYear=300000;
     }
     else  if ((Integer.parseInt(compareYearWith)) > 300000 && (Integer.parseInt(compareYearWith)) <= 400000)
     {
   	  insideYear=400000;
     }
     else  if ((Integer.parseInt(compareYearWith)) > 400000 && (Integer.parseInt(compareYearWith)) <= 500000)
     {
   	  insideYear=500000;
     }
     
     else  if ((Integer.parseInt(compareYearWith)) > 500000 && (Integer.parseInt(compareYearWith)) <= 600000)
     {
   	  insideYear=600000;
     }
     
     else  if ((Integer.parseInt(compareYearWith)) > 600000 && (Integer.parseInt(compareYearWith)) <= 700000)
     {
   	  insideYear=700000;
     }
     
     else  if ((Integer.parseInt(compareYearWith)) > 700000 && (Integer.parseInt(compareYearWith)) <= 800000)
     {
   	  insideYear=800000;
     }
     
     else  if ((Integer.parseInt(compareYearWith)) > 800000 && (Integer.parseInt(compareYearWith)) <= 900000)
     {
   	  insideYear=900000;
     }
     
     else  if ((Integer.parseInt(compareYearWith)) > 900000 && (Integer.parseInt(compareYearWith)) <= 1000000)
     {
   	  insideYear=1000000;
     }
	   
	   //System.out.println(insideYear);
	   return Integer.toString(insideYear);    
	}
  
  
  
  public static String getcount(String crNo) {
  	
 	  int count=100000;
 	 
 	  String last5Digits = crNo.substring(9,14);
		 
	  int digit=Integer.parseInt(last5Digits);
		 
	  if (digit <= 10000)
    {
	   count=10000;
    }
    
    else  if ((digit) > 10000 && (digit) <= 20000)
    {
 	   count=20000;
    }
    
    else  if ((digit) > 20000 && (digit) <= 30000)
    {
 	   count=30000;
    }
    else  if ((digit) > 30000 && (digit) <= 40000)
    {
 	   count=40000;
    }
    else  if ((digit) > 40000 && (digit) <= 50000)
    {
 	   count=50000;
    }
    
    else  if ((digit) > 50000 && (digit) <= 60000)
    {
 	   count=60000;
    }
    
    else  if ((digit) > 60000 && (digit) <= 70000)
    {
 	   count=70000;
    }
    
    else  if ((digit) > 70000 && (digit) <= 80000)
    {
 	   count=80000;
    }
    
    else  if ((digit) > 80000 && (digit) <= 90000)
    {
 	   count=90000;
    }
    
    else  if ((digit) > 90000 && (digit) <= 99999)
    {
 	   count=100000;
    }
 
		//System.out.println(count);
 	 return Integer.toString(count);
 	 
 
 }
	
	
}
