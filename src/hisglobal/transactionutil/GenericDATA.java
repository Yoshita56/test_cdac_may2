/**
 * 
 */
package hisglobal.transactionutil;



import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author dell
 *
 */
public class GenericDATA {
//masterObj.getViewHeader()
	
	static String combo[] = null;
	static String mode="";
	
	/**
	 * 
	 * @param masterObj
	 * @param mode
	 * @return
	 */
	public static String checkMode(TransInterface masterObj, int mode){
		String strMode = "";
		try {
			if(masterObj.getMenuOption().equalsIgnoreCase("Tiles"))
				strMode = "/display";			
			if((masterObj.getMenuOption().equalsIgnoreCase("Frames")) && mode == 0 )
				strMode = "/hisglobal/transactionutil/master/frame_displayPage.jsp";
			if((masterObj.getMenuOption().equalsIgnoreCase("Frames")) && mode == 1 )
				strMode = "/hisglobal/transactionutil/master/frame_list_page.jsp";			
			if(masterObj.getMenuOption().equalsIgnoreCase("Normal"))
				strMode = "/hisglobal/transactionutil/master/normal_trans_list.jsp";
		} catch(Exception e){
			new HisException("Transaction Template", "GenericData.checkMode()", e.getMessage());
		}
			
		//System.out.println("strMode IN DATA-->"+strMode);
		return strMode;
	}
	
	/**
	 * 
	 * @param request
	 * @param masterObj
	 * @param cnt_page
	 */
	public static void LISTDATA(HttpServletRequest request, TransInterface masterObj, String cnt_page){
		
		HttpSession htSession = request.getSession();
		masterObj.setHttpSession(htSession);
		GenericHLP hlp = null;
		GenericVO vo = null;
		mode=(String)request.getAttribute("mode");
		try {
			//set combo value
			masterObj.setCombo(request.getParameterValues("combo"));
			request.setAttribute("combo", request.getParameterValues("combo"));
			request.setAttribute("masterName", masterObj.getMasterName());
			request.setAttribute("BUTTONS", masterObj.getButtons());
			request.setAttribute("js", masterObj.getJsFiles());
			request.setAttribute("cnt_page", cnt_page);
			request.setAttribute("comboReset", masterObj.getComboReset());
			request.setAttribute("visibilityMode", masterObj.getVisibilityMode());
				
			
			hlp = new GenericHLP();
			vo = new GenericVO();
			vo.setSession(request.getSession());
			if(masterObj.getMenuOption().equalsIgnoreCase("Tiles")) 
			{
				if(masterObj.getButtonIcons()!=null)
				{
					request.setAttribute("buttonConfigData1",hlp.getButtonLayOut1(masterObj.getUserDefinedButtons(), masterObj.getMenuOption(), masterObj.getButtonConfiguration(), masterObj.getMinPanelButton(), masterObj.getRecord_per_page(), vo, masterObj.getDbButtons(),masterObj.getButtonIcons()));
					request.setAttribute("buttonConfigData2",hlp.getButtonLayOut2(masterObj.getUserDefinedButtons(), masterObj.getMenuOption(), masterObj.getButtonConfiguration(), masterObj.getMinPanelButton(), masterObj.getRecord_per_page(), vo, masterObj.getDbButtons(),masterObj.getButtonIcons()));
				}
				else
				{
					if(masterObj.getUserDefinedButtons()!=null)
					{
						String[] str=new String[masterObj.getUserDefinedButtons().length];
						for(int i=0;i<masterObj.getUserDefinedButtons().length;i++)
						{
							str[i] = "icon-default.png";
						}
						request.setAttribute("buttonConfigData1",hlp.getButtonLayOut1(masterObj.getUserDefinedButtons(), masterObj.getMenuOption(), masterObj.getButtonConfiguration(), masterObj.getMinPanelButton(), masterObj.getRecord_per_page(), vo, masterObj.getDbButtons(),str));
						request.setAttribute("buttonConfigData2",hlp.getButtonLayOut2(masterObj.getUserDefinedButtons(), masterObj.getMenuOption(), masterObj.getButtonConfiguration(), masterObj.getMinPanelButton(), masterObj.getRecord_per_page(), vo, masterObj.getDbButtons(),str));
					}
					if(masterObj.getDbButtons()!=null)
					{
						String[] str=new String[masterObj.getDbButtons().length];
						for(int i=0;i<masterObj.getDbButtons().length;i++)
						{
							str[i] = "icon-default.png";
						}
						request.setAttribute("buttonConfigData1",hlp.getButtonLayOut1(masterObj.getUserDefinedButtons(), masterObj.getMenuOption(), masterObj.getButtonConfiguration(), masterObj.getMinPanelButton(), masterObj.getRecord_per_page(), vo, masterObj.getDbButtons(),str));
						request.setAttribute("buttonConfigData2",hlp.getButtonLayOut2(masterObj.getUserDefinedButtons(), masterObj.getMenuOption(), masterObj.getButtonConfiguration(), masterObj.getMinPanelButton(), masterObj.getRecord_per_page(), vo, masterObj.getDbButtons(),str));
					}
				}
				
			}			
			if(masterObj.getUserDefinedButtons()!=null)
			{
				request.setAttribute("buttonConfig",masterObj.getButtonConfiguration());
			    request.setAttribute("minButton",masterObj.getMinPanelButton());
			    request.setAttribute("no_of_buttons",masterObj.getUserDefinedButtons().length);
			}
		
			
			if(vo.getStrMsgType() == "1") throw new Exception(vo.getStrMsgString());
			
		} catch (Exception e) {		
			e.printStackTrace();
			new HisException("Transaction Template", "GenericData.LISTDATA()", e.getMessage());
		} finally {
			hlp = null;
			vo = null;
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param masterObj
	 */
	public static void BUTTON(HttpServletRequest request, HttpServletResponse response, TransInterface masterObj){		
		GenericVO vo = null;
		GenericHLP hlp = null;
		response.setHeader("Cache-Control","no-cache");	
		PrintWriter out = null;
		
		try{
			out = response.getWriter();
			vo = new GenericVO();
			hlp = new GenericHLP();
			
			if(request.getParameter("mode").equals("1")){				
				out.println(hlp.getButtonLayOut1(masterObj.getUserDefinedButtons(), masterObj.getMenuOption(), masterObj.getButtonConfiguration(), masterObj.getMinPanelButton(), masterObj.getRecord_per_page(), vo, masterObj.getDbButtons(),masterObj.getButtonIcons()));
			} else if(request.getParameter("mode").equals("2")){				
				out.println(hlp.getButtonLayOut2(masterObj.getUserDefinedButtons(), masterObj.getMenuOption(), masterObj.getButtonConfiguration(), masterObj.getMinPanelButton(), masterObj.getRecord_per_page(), vo, masterObj.getDbButtons(),masterObj.getButtonIcons()));				
			}
			
			if(vo.getStrMsgType() == "1") throw new Exception(vo.getStrMsgString());
			
		} catch(Exception e){
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(), "GenericData-->BUTTON()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally{
			vo = null;
			hlp = null;
			if(out != null){
				out.close();
				out = null;
			}
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param _genericFormBean
	 * @param masterObj
	 */
	public static void setUserName(HttpServletRequest _request,GenericFormBean _genericFormBean,TransInterface masterObj){
		GenericVO vo = null;
		GenericBO bo = null;
		try{
			vo = new GenericVO();
			bo = new GenericBO();
			bo.getUserName(vo,(String)_request.getSession().getAttribute("SEATID"),(String)_request.getSession().getAttribute("HOSPITAL_CODE"));
			_genericFormBean.setStrUserName(vo.getStrUserName());
			_request.getSession().setAttribute("USERNAME", _genericFormBean.getStrUserName());
			if(masterObj.getUserDefinedButtons()==null)
			{
				bo.getDBButtons(vo, (String)_request.getSession().getAttribute("SEATID"),(String)_request.getSession().getAttribute("HOSPITAL_CODE"), masterObj.getDbButtons()[0]);
				_request.setAttribute("buttonConfig", vo.getStrDBButton()[0].split("@")[3]);
			}
			if(vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
		}
		catch(Exception e)
		{
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(), "GenericData-->setUserName()", vo.getStrMsgString());
			eObj = null;
		}
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param masterObj
	 */
	public static void LISTPAGE(HttpServletRequest request, HttpServletResponse response, TransInterface masterObj){
		combo = null;		
		HttpSession htSession = null;
		GenericVO vo = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		PrintWriter out = null;
		String[] strData = null;
		HisUtil hisutil = null;
		String lastCombVal="0";
		String[] comboVal=null;
		String[] tempArr=null;
		String[] tempExtraInfo=null;
		String[] tempExtraInfoQry=null;
		
		try {		
			out = response.getWriter();
			
			htSession = request.getSession();
			masterObj.setHttpSession(htSession);
			combo = request.getParameterValues("combo");
			request.setAttribute("combo", combo);
			
			//set combo value in util
			masterObj.setCombo(combo);
			
			vo = new GenericVO();
			vo.setCombo(request.getParameterValues("combo"));
			//for persistence of list page 
				
			vo.setSearchColumn(request.getParameter("searchColumn"));
			vo.setSearch(request.getParameter("search"));
			vo.setRowNum(request.getParameter("rowNum"));
			vo.setBlockNo(request.getParameter("blockNo"));
			vo.setStrHelpData(masterObj.showHelp());
			///////////////
			
			if(request.getParameter("prevNext") == null || request.getParameter("prevNext") == "")
				vo.setPrevNext("1");
			else
				vo.setPrevNext(request.getParameter("prevNext"));
			
			
			
			vo.setOrderby(request.getParameter("orderby"));
						
			bo = new GenericBO();
			bo.LISTPAGE(vo, 10000, masterObj.getPage_per_block(), "LISTPAGE", masterObj.getMainQuery(vo.getCombo()),masterObj.getOrderBy()); 	//masterObj.getRecord_per_page()   =>  10000  for complete record			
			String str = "";
			hisutil = new HisUtil(masterObj.getMasterName(),"Transaction Template.GenericDATA.LISTPAGE()");
			comboVal=new String[masterObj.getComboHeader().length/2];
			if(combo!=null)
				comboVal=combo;
			else
			{
			for(int nI = 0; nI < masterObj.getComboHeader().length/2; nI++){
				comboVal[nI]="0";
				}
			}
			if(masterObj.getComboQuery() != null)
			{
				strData = new String[masterObj.getComboHeader().length/2];
				for(int nI = 0; nI < masterObj.getComboHeader().length/2; nI++)
				{
					tempArr=masterObj.getComboHeader()[2*nI].replace("^","#").split("#");
					if(tempArr[0].equals("0"))//checking if user defined combo
					{
							/*if(vo.getCombo() != null)
							{
									str = hisutil.getOptionValue(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value");
									strData[nI] = str;
							}
							else
							{*/
									if(tempArr.length==2)
									{
										if(tempArr[1].equals("2"))//By default selected
										{
											if(vo.getCombo() != null)
													str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value",tempArr[1]);										
											else
											str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), "0", "Select Value",tempArr[1]);
										}
										else if(tempArr[1].equals("1"))//All
										{
											if(vo.getCombo() != null)
												str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "All","0");
											else
											str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), "0", "All","0");
										}
										else//nothing
										{
											if(vo.getCombo() != null)
												str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value","0");
											else
											str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), "0", "Select Value","0");
										}
									}
									else
									{
										if(vo.getCombo() != null)
											str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value","0");
										else
										str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), "0", "Select Value","0");
									}
									strData[nI] = str.replace("$","#").split("#")[0];
									lastCombVal=str.replace("$","#").split("#")[1];
									comboVal[nI]=lastCombVal;
									
					}
				}
			}					
			if(masterObj.getExtraInformationName()!= null && masterObj.getExtraInformationName().length>0 
					&& masterObj.getExtraInformationQuery(vo.getCombo())!=null && masterObj.getExtraInformationQuery(vo.getCombo()).length>0)
			{
				tempExtraInfo=masterObj.getExtraInformationName();
				tempExtraInfoQry=masterObj.getExtraInformationQuery(vo.getCombo());
				String strVal="";
				String[] extraInfoData=new String[tempExtraInfo.length*2];
				int x=0;
				for(int nI = 0; nI < tempExtraInfo.length; nI++)
				{
					bo.EXTRAINFODATA(vo,tempExtraInfoQry[nI]);
					if(vo.getExtraInfoWS()!=null && vo.getExtraInfoWS().size()>0)
					{
						if(vo.getExtraInfoWS().next())
							strVal=vo.getExtraInfoWS().getString(1);
						extraInfoData[nI+x]=tempExtraInfo[nI];
						x++;
						extraInfoData[nI+x]=strVal;
					}
				}
				vo.setExtraInfoData(extraInfoData);
			}	

			if(masterObj.getExtraInformationName()!= null && masterObj.getExtraInformationName().length>0 
					&& masterObj.getExtraInformationQuery()!=null && masterObj.getExtraInformationQuery().length>0)
			{
				tempExtraInfo=masterObj.getExtraInformationName();
				tempExtraInfoQry=masterObj.getExtraInformationQuery();
				String strVal="";
				String[] extraInfoData=new String[tempExtraInfo.length*2];
				int x=0;
				for(int nI = 0; nI < tempExtraInfo.length; nI++)
				{
					bo.EXTRAINFODATA(vo,tempExtraInfoQry[nI]);
					if(vo.getExtraInfoWS()!=null && vo.getExtraInfoWS().size()>0)
					{
						if(vo.getExtraInfoWS().next())
							strVal=vo.getExtraInfoWS().getString(1);
						extraInfoData[nI+x]=tempExtraInfo[nI];
						x++;
						extraInfoData[nI+x]=strVal;
					}
				}
				vo.setExtraInfoData(extraInfoData);
			}	
			hlp = new GenericHLP();
			vo.setSession(request.getSession());
			vo.setStrUserName((String)request.getAttribute("USERNAME"));
			/*out.print(hlp.generateData(vo, masterObj.getColumnHeader(), masterObj.getPage_per_block(), 
					masterObj.getMasterName(), masterObj.getSearchField(), masterObj.getRecord_per_page(), 
					masterObj.getComboHeader(), masterObj.getComboQuery(), strData, TransInterface.nextprevcolor, 
					masterObj.getNo_of_combo(), masterObj.getHeaderNote(), masterObj.getFooterNote(), 
					masterObj.getRowStatus(), masterObj.getButtons(), masterObj.getEventState(), 
					masterObj.getMenuOption(), masterObj.getComboEventState(),masterObj.getOrderBy(),
					masterObj.getViewHeader()));*/		
			out.print(hlp.generateDataDataTable(vo, masterObj.getColumnHeader(), 10000, 
					masterObj.getMasterName(), masterObj.getSearchField(), 10000, 
					masterObj.getComboHeader(), masterObj.getComboQuery(), strData, TransInterface.nextprevcolor, 
					masterObj.getNo_of_combo(), masterObj.getHeaderNote(), masterObj.getFooterNote(), 
					masterObj.getRowStatus(), masterObj.getButtons(), masterObj.getEventState(), 
					masterObj.getMenuOption(), masterObj.getComboEventState(),masterObj.getOrderBy(),
					masterObj.getViewHeader()));	//masterObj.getRecord_per_page()   =>  10000  for complete record
			
			if(vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			
			HisException eObj = new HisException(masterObj.getMasterName(), "GenericData-->LISTPAGE()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			htSession = null;
			vo = null;
			bo = null;
			hlp = null;
			if(out != null){
				out.close();
				out = null;
			}
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param masterObj
	 */
	public static void SEARCH(HttpServletRequest request, HttpServletResponse response, TransInterface masterObj) {
		GenericVO vo = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		PrintWriter out = null;
		String[] strData = null;
		HisUtil hisutil = null;
		
		vo = new GenericVO();
		vo.setCombo(request.getParameterValues("combo"));
		
		/////////////////////////////////
		//for persistence of list page 
		
		
		vo.setSearchColumn(request.getParameter("searchColumn"));
		vo.setSearch(request.getParameter("search"));
		vo.setRowNum(request.getParameter("rowNum"));
		vo.setBlockNo(request.getParameter("blockNo"));
		////////////////////////////////////////////
		if(request.getParameter("prevNext") == null || request.getParameter("prevNext") == "")
			vo.setPrevNext("1");
		else
			vo.setPrevNext(request.getParameter("prevNext"));
		
		
		
		try{
			//set combo value in util
			masterObj.setCombo(request.getParameterValues("combo"));
			
			out = response.getWriter();
			
			bo = new GenericBO();
			bo.LISTPAGE(vo, masterObj.getRecord_per_page(), masterObj.getPage_per_block(), "SEARCH", masterObj.getMainQuery(vo.getCombo()),masterObj.getOrderBy());			
			
			String str = "";
			hisutil = new HisUtil(masterObj.getMasterName(),"Transaction Template.GenericDATA.SEARCH()");
			if(masterObj.getComboQuery() != null){
				strData = new String[masterObj.getComboHeader().length/2];
				for(int nI = 0; nI < masterObj.getComboHeader().length/2; nI++){
					
					if(masterObj.getComboHeader()[2*nI].equals("0")){
						if(vo.getCombo() != null){							
							str = hisutil.getOptionValue(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value");
							strData[nI] = str;
						}								
						else{							
							str = hisutil.getOptionValue(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), "0", "Select Value");
							strData[nI] = str;
						}								
					}		
				}
			}						
			
			hlp = new GenericHLP();
			vo.setSession(request.getSession());
			vo.setStrUserName((String)request.getAttribute("USERNAME"));
			out.print(hlp.generateDataDataTable(vo, masterObj.getColumnHeader(), masterObj.getPage_per_block(), 
					masterObj.getMasterName(), masterObj.getSearchField(), masterObj.getRecord_per_page(), 
					masterObj.getComboHeader(), masterObj.getComboQuery(), strData, 
					TransInterface.nextprevcolor, masterObj.getNo_of_combo(), masterObj.getHeaderNote(), 
					masterObj.getFooterNote(), masterObj.getRowStatus(), masterObj.getButtons(), 
					masterObj.getEventState(), masterObj.getMenuOption(),masterObj.getComboEventState(),masterObj.getOrderBy(),
					masterObj.getViewHeader()));
			
			if(vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
		} catch (Exception e) {
			
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			
			HisException eObj = new HisException(masterObj.getMasterName(), "GenericData-->SEARCH()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;

		} finally {
			vo = null;
			bo = null;
			hlp = null;
			if(out != null){
				out.close();
				out = null;
			}
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param masterObj
	 */
	
	public static void DEFAULT(HttpServletRequest request, HttpServletResponse response, TransInterface masterObj) {
		combo = null;
		request.setAttribute("combo", request.getParameterValues("combo"));
		GenericVO vo = null;
		HttpSession htSession=null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		PrintWriter out = null;
		String[] strData = null;
		HisUtil hisutil = null;
		String lastCombVal="0";
		String[] comboVal=null;
		String[] tempArr=null;
		String[] tempExtraInfo=null;
		String[] tempExtraInfoQry=null;
		
		vo = new GenericVO();
		htSession = request.getSession();
		masterObj.setHttpSession(htSession);
		request.setAttribute("combo", request.getParameterValues("combo"));
		vo.setCombo(request.getParameterValues("combo"));
		vo.setSearchColumn(request.getParameter("searchColumn"));
		vo.setSearch(request.getParameter("search"));
		vo.setBlockNo(request.getParameter("blockNo"));
		
		if(request.getParameter("prevNext") == null || request.getParameter("prevNext") == "")
			vo.setPrevNext("1");
		else
			vo.setPrevNext(request.getParameter("prevNext"));
		
		vo.setRowNum(request.getParameter("rowNum"));
		vo.setOrderby(request.getParameter("orderby"));
			
		try{
			//set combo value in util
			masterObj.setCombo(request.getParameterValues("combo"));
			
			out = response.getWriter();
			
			bo = new GenericBO();
			bo.LISTPAGE(vo, 10000, masterObj.getPage_per_block(), "DEFAULT", masterObj.getMainQuery(vo.getCombo()),masterObj.getOrderBy());			
			String str = "";
			hisutil = new HisUtil(masterObj.getMasterName(),"Transaction Template.GenericDATA.DEFAULT()");
			comboVal=new String[masterObj.getComboHeader().length/2];
			comboVal=request.getParameterValues("combo");
			if(masterObj.getComboQuery() != null){
				strData = new String[masterObj.getComboHeader().length/2];
				for(int nI = 0; nI < masterObj.getComboHeader().length/2; nI++){
				tempArr=masterObj.getComboHeader()[2*nI].replace("^","#").split("#");
				if(tempArr[0].equals("0"))//checking if user defined combo
				{
						/*if(vo.getCombo() != null)
						{							
								str = hisutil.getOptionValue(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value");
								strData[nI] = str;
						}								
						else
						{*/
								if(tempArr.length==2)
								{
									if(tempArr[1].equals("2"))//By Default Selected
									{
									str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value",tempArr[1]);
									}
									else if(tempArr[1].equals("1"))//All
									{
										str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "All","0");
									}										
									else
									{
										str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value","0");
									}
									
									
								}
								else
								{
									str = hisutil.getOptionValue_DefaultSelected(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value","0");
								}
								strData[nI] = str.replace("$","#").split("#")[0];
								lastCombVal=str.replace("$","#").split("#")[1];
								comboVal[nI]=lastCombVal;
								vo.setCombo(comboVal);
				}
				}
			}			
			if(masterObj.getExtraInformationName()!= null && masterObj.getExtraInformationName().length>0 
					&& masterObj.getExtraInformationQuery()!=null && masterObj.getExtraInformationQuery().length>0)
			{
				tempExtraInfo=masterObj.getExtraInformationName();
				tempExtraInfoQry=masterObj.getExtraInformationQuery();
				String strVal="";
				String[] extraInfoData=new String[tempExtraInfo.length*2];
				for(int nI = 0; nI < tempExtraInfo.length; nI++)
				{
					bo.EXTRAINFODATA(vo,tempExtraInfoQry[nI]);
					if(vo.getExtraInfoWS()!=null && vo.getExtraInfoWS().size()>0)
					{
						if(vo.getExtraInfoWS().next())
							strVal=vo.getExtraInfoWS().getString(1);
						extraInfoData[nI]=tempExtraInfo[nI];
						extraInfoData[nI+1]=strVal;
					}
				}
				vo.setExtraInfoData(extraInfoData);
			}
	
			if(masterObj.getExtraInformationName()!= null && masterObj.getExtraInformationName().length>0 
					&& masterObj.getExtraInformationQuery()!=null && masterObj.getExtraInformationQuery().length>0)
			{
				tempExtraInfo=masterObj.getExtraInformationName();
				tempExtraInfoQry=masterObj.getExtraInformationQuery();
				String strVal="";
				String[] extraInfoData=new String[tempExtraInfo.length*2];
				int x=0;
				for(int nI = 0; nI < tempExtraInfo.length; nI++)
				{
					bo.EXTRAINFODATA(vo,tempExtraInfoQry[nI]);
					if(vo.getExtraInfoWS()!=null && vo.getExtraInfoWS().size()>0)
					{
						if(vo.getExtraInfoWS().next())
							strVal=vo.getExtraInfoWS().getString(1);
						extraInfoData[nI+x]=tempExtraInfo[nI];
						x++;
						extraInfoData[nI+x]=strVal;
					}
				}
				vo.setExtraInfoData(extraInfoData);
			}
			
			hlp = new GenericHLP();
			vo.setSession(request.getSession());
			vo.setStrUserName((String)request.getAttribute("USERNAME"));
			out.print(hlp.generateDataDataTable(vo, masterObj.getColumnHeader(), masterObj.getPage_per_block(), 
					masterObj.getMasterName(), masterObj.getSearchField(), 10000, 
					masterObj.getComboHeader(), masterObj.getComboQuery(), strData, 
					TransInterface.nextprevcolor, masterObj.getNo_of_combo(), 
					masterObj.getHeaderNote(), masterObj.getFooterNote(), masterObj.getRowStatus(), 
					masterObj.getButtons(), masterObj.getEventState(), masterObj.getMenuOption(),
					masterObj.getComboEventState(),masterObj.getOrderBy(),
					masterObj.getViewHeader()));  //masterObj.getRecord_per_page() => 10000
			
			if(vo.getStrMsgType().equals("1")) throw new Exception(vo.getStrMsgString());
		} catch (Exception e) {
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			
			e.printStackTrace();
			
			HisException eObj = new HisException(masterObj.getMasterName(), "GenericData-->DEFAULT()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hlp = null;
			if(out != null){
				out.close();
				out = null;
			}
		}
	}
	
	
	public static void DELETE(HttpServletRequest request, HttpServletResponse response, TransInterface masterObj) {				
		String divid = "";
		PrintWriter out = null;
		GenericVO vo = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		String[] strData = null;
		
		HisUtil hisutil = new HisUtil("Transaction Template", "GenericData");
				
		try {
			HttpSession htSession = request.getSession();
			out = response.getWriter();
			masterObj.setHttpSession(htSession);
			//set combo value in util
			masterObj.setCombo(request.getParameterValues("combo"));
					
			vo = new GenericVO();
			
			if(masterObj.getDeleteQuery() == null || masterObj.getDeleteQuery().length <= 0) {
				vo.setStrMsgType("1");
				vo.setStrMsgString("No Delete Parameter Defined !!");
				throw new Exception("No Delete Parameter Defined !!");
			}
						
			vo.setDivisionId(request.getParameter("divisionId"));
			vo.setChk(request.getParameter("chk"));
			//System.out.println("chk = " + request.getParameter("chk"));
			if(request.getParameter("prevNext") == null || request.getParameter("prevNext") == "")
				vo.setPrevNext("1");
			else
				vo.setPrevNext(request.getParameter("prevNext"));
			
			vo.setRowNum(request.getParameter("rowNum"));
			vo.setMinRow(request.getParameter("minrow"));
			vo.setBlockNo(request.getParameter("blockNo"));
			vo.setMax_rownum(request.getParameter("max_rownum"));
			vo.setSearch(request.getParameter("search"));
			vo.setSearchColumn(request.getParameter("searchColumn"));
			vo.setStrUserName((String)request.getAttribute("USERNAME"));
			divid = request.getParameter("divisionId");
			
			bo = new GenericBO();
			bo.deleteRecords(masterObj, vo);
			//bo.deleteRecords(masterObj.getDeleteQuery(), vo);
			
			bo.LISTPAGE(vo, masterObj.getRecord_per_page(), masterObj.getPage_per_block(), "DELETE", masterObj.getMainQuery(vo.getCombo()), masterObj.getOrderBy());			
			if(masterObj.getComboQuery() != null){
				strData = new String[masterObj.getComboHeader().length/2];
				for(int nI = 0; nI < masterObj.getComboHeader().length/2; nI++){
					if(masterObj.getComboHeader()[2*nI].equals("0")){
						if(vo.getCombo() != null)
							strData[nI] = hisutil.getOptionValue(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), vo.getCombo()[nI], "Select Value");
						else
							strData[nI] = hisutil.getOptionValue(bo.getMainQuery(masterObj.getComboQuery()[nI], vo), "0", "Select Value");
					}		
				}
			}
			
			hlp = new GenericHLP();							
			//strMessage = util.deleteRecords(masterObj.getDeleteQuery(), request.getParameter("chk"));
			vo.setSession(request.getSession());
			String p = hlp.generateDataDataTable(vo, masterObj.getColumnHeader(), masterObj.getPage_per_block(), 
					masterObj.getMasterName(), masterObj.getSearchField(), masterObj.getRecord_per_page(), 
					masterObj.getComboHeader(), masterObj.getComboQuery(), strData, 
					TransInterface.nextprevcolor, masterObj.getNo_of_combo(), masterObj.getHeaderNote(), 
					masterObj.getFooterNote(), masterObj.getRowStatus(), masterObj.getButtons(), 
					masterObj.getEventState(), masterObj.getMenuOption(), masterObj.getComboEventState(),masterObj.getOrderBy(),
					masterObj.getViewHeader());
			
			out.print(p + "####" + hlp.deleteRecords(vo) + "####" + divid);			
		} catch (Exception e) {
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(), "GenericData-->DELETE()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;			
		} finally {
			vo = null;
			bo = null;
			hlp = null;
			/*
			if(out != null) {
				out.close();
				out = null;
			}
			*/
		}
	}
	
	public static void VIEWDATA(HttpServletRequest request, HttpServletResponse response, TransInterface masterObj) {
		
		GenericHLP hlp = null;
		GenericVO vo = null;
		GenericBO bo = null;
		PrintWriter out = null;
		vo = new GenericVO();
		vo.setChk(request.getParameter("chk"));		
		bo = new GenericBO();
		
		try {
			out = response.getWriter();
			
			/*This Method is used to fetch the Data for View*/
			if(masterObj.getViewQuery() == null || masterObj.getViewQuery().equals("") ||
					masterObj.getViewHeader() == null) {
				
				throw new Exception("No View Parameter defined");
			}
			
			bo.getArrayList(masterObj.getViewQuery(), vo);
			if(vo.getStrMsgType() != "1") 
			{
				hlp = new GenericHLP();				
				out.print(hlp.getNextPrevRows(vo, masterObj.getMasterName(), masterObj.nextprevcolor));	
				out.print(hlp.getViewRows(vo, masterObj.getViewHeader()));
			}
			else 
			{				
				throw new Exception(vo.getStrMsgString());
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			
			HisException eObj = new HisException(masterObj.getMasterName(), "GenericData-->VIEWDATA()", e.getMessage());
			out.print("<font color='red'><b><div align='center'>Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Admibnistrator !</div></b></font>");
			eObj = null;
		}
		finally {
			hlp = null;
			vo = null;
			bo = null;
			if(out != null) {
				out.close();
				out = null;
			}
		}
	}
	
	public static void REPORTDATA(HttpServletRequest request, HttpServletResponse response, TransInterface masterObj){		
		GenericVO vo = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		PrintWriter out = null;		
		
		try {
			HttpSession htSession = request.getSession();
			htSession.setAttribute("MSTCOMBO",request.getParameterValues("combo"));
			masterObj.setHttpSession(htSession);		
			//set combo value in util
			masterObj.setCombo(request.getParameterValues("combo"));
			
			out = response.getWriter();
			
			vo = new GenericVO();
			vo.setMinRow(request.getParameter("minrow"));
			vo.setBlockNo(request.getParameter("blockNo"));
			vo.setSearch(request.getParameter("search"));
			vo.setSearchColumn(request.getParameter("searchColumn"));
			vo.setComboValue(request.getParameter("comboValue"));
			vo.setCombo(request.getParameterValues("combo"));
			bo = new GenericBO();			
			bo.getReports(vo, masterObj.getMainQuery(vo.getCombo()), masterObj.getRecord_per_page(), masterObj.getPage_per_block());			
			
			if(vo.getStrMsgType() != "1") {
				hlp = new GenericHLP();				
				out.print(hlp.getReports(vo, masterObj.getComboHeader(), masterObj.getRecord_per_page(), masterObj.getPage_per_block(), masterObj.getColumnHeader()));								
			} else {
				throw new Exception(vo.getStrMsgString());
			}						
		} catch (Exception e) {			
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			
			HisException eObj = new HisException(masterObj.getMasterName(), "GenericData-->REPORTDATA()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally{
				vo = null;
				bo = null;
				hlp = null;
				if(out != null){
					out.close();
					out = null;
				}
		}
	}
	
}
