/**********************************************************
 Project:	   HMIS-G6i	
 File:         ProcessPerformanceFilter.java
 Author:       cdac

This code is copyright (c) 2020 C-DAC Noida.

 ***********************************************************/
package application.filters;

import hissso.config.HISSSOClientConfig;
import hisglobal.vo.PatientVO;
//import vo.registration.PatientVO;
import vo.usermgmt.MenuMappingVO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.eclipse.persistence.internal.xr.ValueObject;

import hisglobal.ProcessLogUtil;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

public class ProcessPerformanceFilter implements Filter 
{
	private FilterConfig filterConfig;
	
	public void init(FilterConfig filterConfig) throws ServletException 
	{

		this.filterConfig = filterConfig;
	}	
	public void destroy() 
	{
		this.filterConfig = null;
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest objRequest = (HttpServletRequest) request;
		try 
		{			
			if(HisUtil.getParameterFromHisPathXML("PERFORMANCE_FILTER")!=null && HisUtil.getParameterFromHisPathXML("PERFORMANCE_FILTER").equalsIgnoreCase("ON"))
			{
	            		String strURI = objRequest.getRequestURI();
	            		//System.out.println("strURI"+strURI);
	            		if (strURI.contains(HISSSOClientConfig.SSO_ST_SERVICE_URL)  || strURI.contains("HISDRDESK/services/restful/patdata/digi") )
	        			{
	        				chain.doFilter(request, response);
	        			}
	        			else if(strURI.endsWith(".js") || strURI.endsWith(".css")||strURI.endsWith(".gif")||strURI.endsWith(".png")||strURI.endsWith(".jpg")||strURI.endsWith(".jpeg"))
	        			{
	        				// Forward as-it-is
	        				//chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
	        				chain.doFilter(request, response);
	        			}
	        			else if(strURI.contains("UploadFile.action") ||  strURI.contains("ImageRendererServlet") ||  strURI.contains("EnlargedImage") || strURI.contains("PatientSearch"))
	        			{
	        				//System.out.println("HISREG in UploadFile.action");	        				
	        				chain.doFilter(request, response);
	        			}
	        			else if(strURI.contains("NewChallanProcessTransBSCNT"))
	        			{
							chain.doFilter(request, response);
	        			}
	        			else
	        			{
	        				boolean isMultiPart = ServletFileUpload.isMultipartContent((HttpServletRequest) request);
	        				String hmode;
	        				String puk;
	        				ProcessPerformanceMultipartRequestWrapper multipartRequest = null;
	        				if (isMultiPart) 
	        				{
	        					if(strURI.contains("DoctorDeskAction")){
	        						chain.doFilter(request, response);
	        						return;
	        						
	        					}
	        					DiskFileItemFactory factory = new DiskFileItemFactory();
	        					factory.setSizeThreshold(1024); 
	        					System.out.println(System.getProperty("java.io.tmpdir"));
	        				    factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	        				    
	        					
	        					ServletFileUpload upload = new ServletFileUpload(factory);
	        					
	        					multipartRequest = new ProcessPerformanceMultipartRequestWrapper((HttpServletRequest) request, upload);
	        					hmode=checkHmode(multipartRequest,"hmode",isMultiPart);
								puk=checkCr(multipartRequest,isMultiPart);
	        				}
	        				else
	        				{
	        					hmode=checkHmode(objRequest,"hmode",isMultiPart);
	        					if(strURI.contains("/HISDRDESK/new_opd/transaction/DoctorDeskAction.cnt") && hmode.equals("NEW1"))//Byepass Mobile App DrDesk
	        					{
	        						chain.doFilter(request, response);
	        						return;
	        					}
								puk=checkCr(request,isMultiPart);
	        				}        				
	        				
						
							List<MenuMappingVO> lst=(List<MenuMappingVO>) objRequest.getSession().getAttribute("MENU_CNT_MAPPING_NEW");
							//System.out.println("lst size"+lst.size());
							if(lst==null)
							{
								lst=getMenuMappingDtl(objRequest.getSession().getAttribute("HOSPITAL_CODE").toString(),objRequest.getSession().getAttribute("SEATID").toString());
								objRequest.getSession().setAttribute("MENU_CNT_MAPPING_NEW",lst);
								//System.out.println("lst size new"+lst.size());
							}
							if(lst!=null)
							{
								//System.out.println("lst size"+lst.size());
								String data=parseMenuAndTrack_New(lst,strURI,hmode,objRequest);
								if(data!=null && !data.equals(""))
								{
									String dataString[]=data.replace("||","#").split("#");
									if(dataString!=null && dataString.length>=3)
									{
										String methodFlag=dataString[0];
										String menuId=dataString[1];
										String menuName=dataString[2];
										String shortName=dataString[3];
										if(methodFlag.equals("1"))//Start
										{
											String strTransId=ProcessLogUtil.startTransation(menuId, menuName,shortName, "0",objRequest,puk);
											//System.out.println("strTransId"+strTransId);	
											if (isMultiPart) 
					        				{
												chain.doFilter(multipartRequest,response);
					        				}
											else
											{
												chain.doFilter(objRequest,response);
											}
											
										}
										else if(methodFlag.equals("2"))//End
										{
											//System.out.println("beforesave");
											try 
											{
												ProcessLogUtil.beforeSave(menuId,  "1",objRequest,puk);//Successful
												if (isMultiPart) 
						        				{
													chain.doFilter(multipartRequest,response);
						        				}
												else
												{
													chain.doFilter(objRequest,response);
												}
												ProcessLogUtil.afterSave(menuId,  "1",objRequest,puk);//Successful
												//System.out.println("puk"+puk);
												if(puk.equals("0") || puk.contentEquals(""))
													puk=checkCrFromPatVo(objRequest);
												ProcessLogUtil.completeTransation(menuId,  "1",objRequest,puk);//Successful
												//System.out.println("success");
												
											} 
											catch (Exception e) 
											{
												ProcessLogUtil.completeTransation(menuId,  "0",objRequest,puk);//Unsuccessful
												//System.out.println("unsuccess");
											}						
										}
										else //None
										{
											if (isMultiPart) 
					        				{
												chain.doFilter(multipartRequest,response);
					        				}
											else
											{
												chain.doFilter(objRequest,response);
											}
										}
									}
									else
									{
										if (isMultiPart) 
				        				{
											chain.doFilter(multipartRequest,response);
				        				}
										else
										{
											chain.doFilter(objRequest,response);
										}
									}										
								}
								else
								{
									if (isMultiPart) 
			        				{
										chain.doFilter(multipartRequest,response);
			        				}
									else
									{
										chain.doFilter(objRequest,response);
									}
								}									
							}
							else
							{
								if (isMultiPart) 
		        				{
									chain.doFilter(multipartRequest,response);
		        				}
								else
								{
									chain.doFilter(objRequest,response);
								}
							}							
	        			}
			}
			else
			{
				chain.doFilter(objRequest,response);
			}
		} 
		catch (Exception t) 
		{
			t.printStackTrace();
			chain.doFilter(objRequest,response);
		}

	}
	public String checkHmode(HttpServletRequest request,String paramName,boolean multiPart)
	{
		String hmode="";
		boolean isMultiPart = multiPart;
		if(isMultiPart)
		{
		 		Enumeration<String> paramNames = request.getParameterNames();
				List<ParamObject> paramMap = new ArrayList<ParamObject>();

				while (paramNames.hasMoreElements()) 
				{
					String para = paramNames.nextElement();
					//System.out.println(" param name is " + paramName);
					if(para.equals(paramName)) 
					{
						String[] paramValues = request.getParameterValues(paramName);
						for (int i = 0; i < paramValues.length; i++) 
							{
								hmode=paramValues[i];
								//System.out.println(paramName +"  >>  "+paramValues[i]);															
							}
						
					}

				}
			}
		 	else
		 	{			
		 		String[] values = request.getParameterValues(paramName);
				
				if (values == null) 
				{
					return null;
				}
				int count = values.length;
				for (int i = 0; i < count; i++) 
				{
					//System.out.println(paramName+" Parameter--->>><<" + values[i]);
					hmode=values[i];				
				}
		 	}
			return hmode;			
	}
	public String checkCr(ServletRequest request,boolean multiPart)
	{
			String cr="0";
			boolean isMultiPart = multiPart;
			if(isMultiPart)
			{
			 		Enumeration<String> paramNames = request.getParameterNames();
					List<ParamObject> paramMap = new ArrayList<ParamObject>();

					while (paramNames.hasMoreElements()) 
					{
						String para = paramNames.nextElement();
						//System.out.println(" param name is " + paramName);
						if(para.equals("PUK") || para.equals("strCrNo") || para.equals("patCrNo") || para.equals("crNo") || para.equals("patCRNo") || para.equals("strCrNoVal") 
			               || para.equals("strPukNo") || para.equals("strPuk") || para.equals("strPUK") || para.equals("strHiddenPuk") || para.equals("searchCrNo") || para.equals("tempPatCRNo")) 
						{
							String[] values = request.getParameterValues("PUK");
							int count =0;
							if(values!=null)
								count = values.length;
							for (int i = 0; i < count; i++) 
							{
								cr=values[i];
									//System.out.println(paramName +"  >>  "+paramValues[i]);															
							}
							
							if(cr.equals("0"))
							{
								values = request.getParameterValues("strCrNo");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("patCrNo");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("crNo");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("patCRNo");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("strCrNoVal");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("strPukNo");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("strPuk");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("strPUK");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("strHiddenPuk");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}
							if(cr.equals("0"))
							{
								values = request.getParameterValues("searchCrNo");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}				
							if(cr.equals("0"))
							{
								values = request.getParameterValues("tempPatCRNo");
								if(values!=null)
									count = values.length;
								for (int i = 0; i < count; i++) 
								{
									//System.out.println("CR--->>><<" + values[i]);
									cr=values[i];				
								}
							}	
						}
					}
			}
			else
			{
				String[] values = request.getParameterValues("PUK");
				
				int count =0;
				if(values!=null)
					count = values.length;
				for (int i = 0; i < count; i++) 
				{
					//System.out.println("CR--->>><<" + values[i]);
					cr=values[i];				
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("strCrNo");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("patCrNo");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("crNo");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("patCRNo");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("strCrNoVal");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("strPukNo");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("strPuk");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("strPUK");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("strHiddenPuk");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}
				if(cr.equals("0"))
				{
					values = request.getParameterValues("searchCrNo");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}				
				if(cr.equals("0"))
				{
					values = request.getParameterValues("tempPatCRNo");
					if(values!=null)
						count = values.length;
					for (int i = 0; i < count; i++) 
					{
						//System.out.println("CR--->>><<" + values[i]);
						cr=values[i];				
					}
				}			
			}
			
			return cr;			
	}
	
	public String checkCrFromPatVo(HttpServletRequest request)
	{
			String cr="0";
			PatientVO patVo=(PatientVO)request.getSession().getAttribute("registrationPatientVo");
			if(patVo!=null)
				cr=patVo.getPatCrNo();
			
			
			//System.out.println("cr"+cr);
			
			
			return cr;			
	}
	
	public String parseMenuAndTrack(List<MenuMappingVO> lst,String strURI,String hmode,HttpServletRequest request)
	{
			String methodFlag="0";//0, None,1, Start Method,2-End Method
			
			try
			{
				if(strURI!=null && !strURI.equals(""))
				{
					for (int i = 0; i <lst.size(); i++) 
					{
						MenuMappingVO vo=lst.get(i);
					
						if(vo!=null)
						{
							if(vo.getMenuUrl()!=null && !vo.getMenuUrl().equals(""))
							{
								if( (vo.getMenuUrl().contains(strURI)) || (vo.getEndMethodWebServiceUrl()!=null && strURI.contains(vo.getEndMethodWebServiceUrl())) || (vo.getEndMethodWebServiceUrl()!=null && vo.getEndMethodWebServiceUrl().contains(strURI)) )
								{
									if((vo.getStartMethod()!=null && !vo.getStartMethod().equals("")) || (vo.getEndMethod()!=null && !vo.getEndMethod().equals("")) || (vo.getEndMethodWebServiceUrl()!=null && !vo.getEndMethodWebServiceUrl().equals("")) ) 
									{
									/*
									 * System.out.println("Menu URL--->>><<" + vo.getMenuUrl());
									 * System.out.println("Menu Name--->>><<" + vo.getMenuName());
									 * System.out.println("Menu Id--->>><<" + vo.getMenuId());
									 * System.out.println("Menu Found--->>><<" + vo.getMenuUrl());
									 * System.out.println("Start Method--->>><<" + vo.getStartMethod());
									 * System.out.println("End Method--->>><<" + vo.getEndMethod());
									 * System.out.println("CNT Path--->>><<" + vo.getCntPath());
									 * System.out.println("End Method Web Service URL--->>><<" +
									 * vo.getEndMethodWebServiceUrl());
									 */
										//System.out.println("hmode--->>><<" + hmode);
										//Menu Id-117026000000, substring(0,6)-117026
										
										//if(hmode.equals(vo.getStartMethod()))
										if(hmode!=null)
										{
											if(vo.getStartMethod().contains(hmode))
											{
												//String strTransId=HisUtil.startTransation(vo.getMenuId().substring(0,6), vo.getMenuName(), "",request);
												//System.out.println("strTransId"+strTransId);
												methodFlag="1";
												return methodFlag+"||"+vo.getMenuId().substring(0,6)+"||"+vo.getMenuName();
											}
											//if(hmode.equals(vo.getEndMethod()))
											if((vo.getEndMethod().contains(hmode)) || (vo.getEndMethodWebServiceUrl()!=null && (strURI.contains(vo.getEndMethodWebServiceUrl()) || vo.getEndMethodWebServiceUrl().contains(strURI))) )
											{
												methodFlag="2";
												return methodFlag+"||"+vo.getMenuId().substring(0,6)+"||"+vo.getMenuName();
												//HisUtil.completeTransation(vo.getMenuId().substring(0,6),  "1",request);
											}
										}
										else
										{
											if(vo.getEndMethodWebServiceUrl()!=null && (strURI.contains(vo.getEndMethodWebServiceUrl()) || vo.getEndMethodWebServiceUrl().contains(strURI)) )
											{
												methodFlag="2";
												return methodFlag+"||"+vo.getMenuId().substring(0,6)+"||"+vo.getMenuName();
												//HisUtil.completeTransation(vo.getMenuId().substring(0,6),  "1",request);
											}
										}
									}
								}
							}
						}
						vo=null;
					}
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return "";
	}	
	
	public String parseMenuAndTrack_New(List<MenuMappingVO> lst,String strURI,String hmode,HttpServletRequest request)
	{
			String methodFlag="0";//0, None,1, Start Method,2-End Method
			String finalURI="";
			
			try
			{
				if(strURI!=null && !strURI.equals("") )
				{
					for (int j = 0; j <lst.size(); j++) 
					{
						MenuMappingVO vo=lst.get(j);
					
						if(vo!=null)
						{
							if(hmode!=null)
							{
								finalURI=strURI+"?hmode="+hmode;								
							}
							else
							{
								finalURI=strURI;								
							}
							//System.out.println("finaltURI"+finalURI);
							
							if(vo.getStartMethod()!=null && !vo.getStartMethod().equals(""))
							{
								//System.out.println("vo.getStartMethod()"+vo.getStartMethod());
								String startMethod[] =vo.getStartMethod().split("#");
								for(int i=0;i<=startMethod.length-1;i++)
								{
									if(startMethod[i].equalsIgnoreCase(finalURI))
									{
										methodFlag="1";
										//return methodFlag+"||"+vo.getMenuId().substring(0,6)+"||"+vo.getMenuName();
										return methodFlag+"||"+vo.getMenuId()+"||"+vo.getMenuName()+"||"+vo.getShortName();
									}
								}
							}
							if(vo.getEndMethod()!=null && !vo.getEndMethod().equals(""))
							{
								//System.out.println("vo.getEndMethod()"+vo.getEndMethod());
								String endMethod[] =vo.getEndMethod().split("#");
								for(int i=0;i<=endMethod.length-1;i++)
								{
									if(endMethod[i].equalsIgnoreCase(finalURI))
									{
										methodFlag="2";
										//return methodFlag+"||"+vo.getMenuId().substring(0,6)+"||"+vo.getMenuName();
										return methodFlag+"||"+vo.getMenuId()+"||"+vo.getMenuName()+"||"+vo.getShortName();
									}
								}								
							}
						}
					}						
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return "";
	}
	
	
	public List<MenuMappingVO> getMenuMappingDtl(String hospCode,String seatId) throws Exception
	{
		int nProcedureIndex;
		String strDBErr;
		ResultSet objResSet=null;
		try
		{
			HisDAO hisDAO_p = new HisDAO("UserManagment", "UserManagementBO");
			nProcedureIndex = hisDAO_p.setProcedure("{call pkg_usermgmt.proc_gblt_menu_mst(?,?,?,?,?,?)}");
			
			// Setting and Registering In and Out Parameters 
		    hisDAO_p.setProcInValue(nProcedureIndex, "p_mode", "5", 1);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_hospital_code", hospCode, 2);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_id", seatId, 3);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_seat_id",seatId, 4);

			hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1, 5); // VarChar
			hisDAO_p.setProcOutValue(nProcedureIndex, "resultset", 2, 6); // Cursor

			// Executing Procedure 
			//hisDAO_p.executeProcedureByPosition(nProcedureIndex);

			// Getting out parameters 
			strDBErr = hisDAO_p.getString(nProcedureIndex, "err");
			objResSet = hisDAO_p.getWebRowSet(nProcedureIndex, "resultset");

			// If Database Error Occurs, No farther processing is required. 
			if (strDBErr != null && !strDBErr.equals(""))
			{
				throw new Exception("Data Base Error:" + strDBErr);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		List<MenuMappingVO> lst = new ArrayList<MenuMappingVO>();
		ValueObject[] arrVOs = {};
		try
		{
			if (objResSet.next())
			{
				objResSet.beforeFirst();
				arrVOs = populateVOfrmRS(MenuMappingVO.class, objResSet);
				for (ValueObject obj : arrVOs)
					lst.add((MenuMappingVO) obj);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}
	
	public static ValueObject[] populateVOfrmRS(Class _voClass, ResultSet _rs) throws Exception
	{
		// data from object2 is populated into obj1
		// getString of RS is called for a col.
		// setter of VO is called for the corresponding data member...
		// Map keeps the mapping
		//System.out.println("Class _voClass :: " + _voClass);
		boolean flag=false;
		Class clsTemp = _voClass;
		while(clsTemp != Object.class)
		{
			if(clsTemp.getSuperclass() == ValueObject.class)
			{
				flag=true;
				break;
			}
			clsTemp = clsTemp.getSuperclass();
		}
		//if (_voClass.getSuperclass() != ValueObject.class) throw new HISException("populateVOfrmRS:  illegal argument Exception");
		if (!flag) throw new Exception("populateVOfrmRS:  illegal argument Exception");

		ArrayList alVO = new ArrayList();
		try
		{
			Class cls = _voClass;
			Method[] clsMethods = cls.getMethods();
			// List alMethods = Arrays.asList(clsMethods);

			ResultSetMetaData rsMetaData = _rs.getMetaData();
			int rsCols = rsMetaData.getColumnCount();
			/*
			 * int y=0; for(int m=0;_rs.next();m++){ y++; } System.out.println("rows returned by rs....y ::"+y);
			 */
			//System.out.println("rsCols" + rsCols);

			for (int rsCounter = 0; _rs.next(); rsCounter++)
			{
				ValueObject _vo = (ValueObject) cls.newInstance();
				for (int i = 1; i <= rsCols; i++)
				{

					String strColLabel = rsMetaData.getColumnLabel(i);
					//System.out.println("strColLabel:  " + strColLabel);

					String strColVal = _rs.getString(rsMetaData.getColumnName(i));
					//System.out.println("strColVal:  " + strColVal);
					char[] arrCh = strColLabel.toCharArray();
					arrCh[0] = Character.toUpperCase(arrCh[0]);
					//System.out.println("strColLabel:  " + strColLabel);

					String strMethodName = new String(arrCh);
					strMethodName = "set" + strMethodName;
					//System.out.println("strMethodName:  " + strMethodName);

					int j;
					for (j = 0; j < clsMethods.length; j++)
					{
						// System.out.println("clsMethods[j].getName(): "+clsMethods[j].getName()+" strMethodName:
						// "+strMethodName);

						if (clsMethods[j].getName().equalsIgnoreCase(strMethodName))
						{// if the method name starts with set
							clsMethods[j].invoke(_vo, new Object[]
							{ strColVal });

							break;
						}

					}
					if (j > clsMethods.length) throw new Exception("HelperMethods.populateVOfrmRS(): No setter for " + strMethodName);

				}

				alVO.add(_vo);

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		ValueObject[] arr = new ValueObject[alVO.size()];

		for (int i = 0; i < alVO.size(); i++)
			arr[i] = (ValueObject) alVO.get(i);

		//System.out.println("befor returning arr in populateVOfrmRS(Class _voClass, ResultSet _rs)");
		return arr;
	}




}