package hisglobal.masterutil;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.utility.SecurityUtil;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;

public class GenericData {

	static String combo[] = null;
	static String userVal = "0";

	public static void unspecified(HttpServletRequest request,
			MasterInterface masterObj)

	{

		HttpSession htSession = request.getSession();

		htSession.setAttribute("MSTCOMBO", request.getParameterValues("combo"));

		htSession.setAttribute("MSTCOMBO", request.getParameterValues("combo"));
		if (request.getParameter("userValue") != null) {
			userVal = request.getParameter("userValue").toString();
		}
		htSession.setAttribute("USERVALUE", userVal);
        
		masterObj.setHttpSession(htSession);

		Class classObj=masterObj.getClass();
		try
		{
			Field requestField=null;
			for(int i=0;i<classObj.getFields().length;i++)
			{
				//System.out.println("classObj.getFields()[i].getName()  "+classObj.getFields()[i].getName());
				if(classObj.getFields()[i].getName().equals("request"))
				{	
					requestField=classObj.getFields()[i];
				}
			}
			//System.out.println("requestField ::"+requestField);
			if(requestField!=null)
			{
				
							
				for(int i=0;i<classObj.getMethods().length;i++)
				{
					if(classObj.getMethods()[i].getName().equals("setHttpRequest"))
					{
						classObj.getMethods()[i].invoke(masterObj, request);
					}
			}
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		combo = null;

	}

	public static void LIST(HttpServletRequest request,
			MasterInterface masterObj, String cnt_page)

	{

		HttpSession htSession = request.getSession();

		htSession.setAttribute("MSTCOMBO", request.getParameterValues("combo"));

		htSession.setAttribute("USERVALUE", userVal);

		masterObj.setHttpSession(htSession);
		// Setting Request
		Class classObj=masterObj.getClass();
		try
		{
			Field requestField=null;
			for(int i=0;i<classObj.getFields().length;i++)
			{
				//System.out.println("classObj.getFields()[i].getName()  "+classObj.getFields()[i].getName());
				if(classObj.getFields()[i].getName().equals("request"))
				{	
					requestField=classObj.getFields()[i];
				}
			}
			//System.out.println("requestField ::"+requestField);
			if(requestField!=null)
			{
				
							
				for(int i=0;i<classObj.getMethods().length;i++)
				{
					if(classObj.getMethods()[i].getName().equals("setHttpRequest"))
					{
						classObj.getMethods()[i].invoke(masterObj, request);
					}
			}
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("combo", request.getParameterValues("combo"));

		request.setAttribute("masterName", masterObj.getMasterName());
		
		request.setAttribute("isGlobal", masterObj.isGlobal());

		request.setAttribute("BUTTONS", masterObj.getButtons());

		request.setAttribute("js", masterObj.getJsFiles());

		request.setAttribute("cnt_page", cnt_page);

	}

	public static void LISTPAGE(HttpServletRequest request,
			HttpServletResponse response, MasterInterface masterObj) {
		combo = null;
		HttpSession htSession = null;
		PrintWriter out = null;
		GenericVO vo = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		String[] strData = null;

		HisUtil hisutil = new HisUtil("Master Template", "GenericData");
		try {
			out = response.getWriter();

			htSession = request.getSession();
			htSession.setAttribute("MSTCOMBO", request
					.getParameterValues("combo"));

			htSession.setAttribute("USERVALUE", userVal);

			masterObj.setHttpSession(htSession);
			// Setting Request
			Class classObj=masterObj.getClass();
			try
			{
				Field requestField=null;
				for(int i=0;i<classObj.getFields().length;i++)
				{
					//System.out.println("classObj.getFields()[i].getName()  "+classObj.getFields()[i].getName());
					if(classObj.getFields()[i].getName().equals("request"))
					{	
						requestField=classObj.getFields()[i];
					}
				}
				//System.out.println("requestField ::"+requestField);
				if(requestField!=null)
				{
					
								
					for(int i=0;i<classObj.getMethods().length;i++)
					{
						if(classObj.getMethods()[i].getName().equals("setHttpRequest"))
						{
							classObj.getMethods()[i].invoke(masterObj, request);
						}
				}
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			combo = request.getParameterValues("combo");
			vo = new GenericVO();
			vo.setCombo(combo);
			vo.setSearchColumn(request.getParameter("searchColumn"));
			vo.setSearch(request.getParameter("search"));
			vo.setBlockNo(request.getParameter("blockNo"));
			vo.setPrevNext(request.getParameter("prevNext"));
			vo.setRowNum(request.getParameter("rowNum"));
			vo.setOrderby(request.getParameter("orderby"));

			bo = new GenericBO();
			bo.LISTPAGE(vo, 10000, masterObj
					.getPage_per_block(), "LISTPAGE", masterObj.getMainQuery(vo
					.getCombo()), masterObj.getOrderBy()); //masterObj.getRecord_per_page()
			String str = "";

			if (masterObj.getComboQuery() != null) {
				strData = new String[masterObj.getComboHeader().length / 2];
				for (int nI = 0; nI < masterObj.getComboHeader().length / 2; nI++) {

					if (masterObj.getComboHeader()[2 * nI].equals("0")) {
						if (vo.getCombo() != null) {
							str = hisutil.getOptionValue(bo.getMainQuery(
									masterObj.getComboQuery()[nI], vo), vo
									.getCombo()[nI], "Select Value");
							strData[nI] = str;
						} else {
							str = hisutil.getOptionValue(bo.getMainQuery(
									masterObj.getComboQuery()[nI], vo), "0",
									"Select Value");
							strData[nI] = str;
						}
					}
				}
			}

			hlp = new GenericHLP();
			/*out.print(hlp.generateData(vo, masterObj.getColumnHeader(),
					masterObj.getPage_per_block(), (List<String>)masterObj.getViewHeader(),
					masterObj.getMasterName(), masterObj.getSearchField(),
					masterObj.getRecord_per_page(), masterObj.getComboHeader(),
					masterObj.getComboQuery(), strData, masterObj.getOrderBy(),
					MasterInterface.nextprevcolor));*/
			out.print(hlp.generateDataTable(vo, masterObj.getColumnHeader(),
					masterObj.getPage_per_block(), (List<String>)masterObj.getViewHeader(),
					masterObj.getMasterName(), masterObj.getSearchField(),
					10000, masterObj.getComboHeader(),
					masterObj.getComboQuery(), strData, masterObj.getOrderBy(),
					MasterInterface.nextprevcolor)); //masterObj.getRecord_per_page()
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());

		} catch (Exception e) {
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(),
					"GenericData-->LISTPAGE()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			htSession = null;
			bo = null;
			hlp = null;
			vo = null;
			/*
			 * if(out != null){ out.close(); out = null; }
			 */
		}
	}

	public static void DEFAULT(HttpServletRequest request,
			HttpServletResponse response, MasterInterface masterObj) {
		combo = null;
		GenericVO vo = null;
		PrintWriter out = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		String[] strData = null;
		String str = "";
		HisUtil hisutil = new HisUtil("Master Template", "GenericData");

		try {
			out = response.getWriter();
			HttpSession htSession = request.getSession();
			htSession.setAttribute("MSTCOMBO", request
					.getParameterValues("combo"));

			htSession.setAttribute("USERVALUE", userVal);
			masterObj.setHttpSession(htSession);
			// Setting Request
			Class classObj=masterObj.getClass();
			try
			{
				Field requestField=null;
				for(int i=0;i<classObj.getFields().length;i++)
				{
					//System.out.println("classObj.getFields()[i].getName()  "+classObj.getFields()[i].getName());
					if(classObj.getFields()[i].getName().equals("request"))
					{	
						requestField=classObj.getFields()[i];
					}
				}
				//System.out.println("requestField ::"+requestField);
				if(requestField!=null)
				{
					
								
					for(int i=0;i<classObj.getMethods().length;i++)
					{
						if(classObj.getMethods()[i].getName().equals("setHttpRequest"))
						{
							classObj.getMethods()[i].invoke(masterObj, request);
						}
				}
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			vo = new GenericVO();
			request.setAttribute("combo", request.getParameterValues("combo"));
			vo.setCombo(request.getParameterValues("combo"));
			vo.setSearchColumn(request.getParameter("searchColumn"));
			vo.setSearch(request.getParameter("search"));
			vo.setBlockNo(request.getParameter("blockNo"));

			if (request.getParameter("prevNext") == null
					|| request.getParameter("prevNext") == "")
				vo.setPrevNext("1");
			else
				vo.setPrevNext(request.getParameter("prevNext"));

			vo.setRowNum(request.getParameter("rowNum"));
			vo.setOrderby(request.getParameter("orderby"));

			bo = new GenericBO();
			bo.LISTPAGE(vo, 10000, masterObj
					.getPage_per_block(), "DEFAULT", masterObj.getMainQuery(vo
					.getCombo()), masterObj.getOrderBy()); //masterObj.getRecord_per_page()

			if (masterObj.getComboQuery() != null) {
				strData = new String[masterObj.getComboHeader().length / 2];
				for (int nI = 0; nI < masterObj.getComboHeader().length / 2; nI++) {
					if (masterObj.getComboHeader()[2 * nI].equals("0")) {
						if (vo.getCombo()[nI] != null) {
							str = hisutil.getOptionValue(bo.getMainQuery(
									masterObj.getComboQuery()[nI], vo), vo
									.getCombo()[nI], "Select Value");
							strData[nI] = str;
						} else {
							str = hisutil.getOptionValue(bo.getMainQuery(
									masterObj.getComboQuery()[nI], vo), "0",
									"Select Value");
							strData[nI] = str;
						}
					}
				}
			}
			hlp = new GenericHLP();
			out.print(hlp.generateDataTable(vo, masterObj.getColumnHeader(),
					masterObj.getPage_per_block(), masterObj.getViewHeader(),
					masterObj.getMasterName(), masterObj.getSearchField(),
					10000, masterObj.getComboHeader(),
					masterObj.getComboQuery(), strData, masterObj.getOrderBy(),
					MasterInterface.nextprevcolor)); //masterObj.getRecord_per_page()
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(),
					"GenericData-->DEFAULT()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			hlp = null;
			vo = null;
			/*
			 * if(out != null){ out.close(); out = null; }
			 */
		}
	}

	public static void SEARCH(HttpServletRequest request,
			HttpServletResponse response, MasterInterface masterObj) {
		GenericVO vo = null;
		PrintWriter out = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		String[] strData = null;
		HisUtil hisutil = new HisUtil("Master Template", "GenericData");

		try {
			out = response.getWriter();
			HttpSession htSession = request.getSession();
			htSession.setAttribute("MSTCOMBO", request
					.getParameterValues("combo"));

			htSession.setAttribute("USERVALUE", userVal);
			masterObj.setHttpSession(htSession);
			// Setting Request
			Class classObj=masterObj.getClass();
			try
			{
				Field requestField=null;
				for(int i=0;i<classObj.getFields().length;i++)
				{
					//System.out.println("classObj.getFields()[i].getName()  "+classObj.getFields()[i].getName());
					if(classObj.getFields()[i].getName().equals("request"))
					{	
						requestField=classObj.getFields()[i];
					}
				}
				//System.out.println("requestField ::"+requestField);
				if(requestField!=null)
				{
					
								
					for(int i=0;i<classObj.getMethods().length;i++)
					{
						if(classObj.getMethods()[i].getName().equals("setHttpRequest"))
						{
							classObj.getMethods()[i].invoke(masterObj, request);
						}
				}
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			vo = new GenericVO();

			vo.setSearchColumn(request.getParameter("searchColumn"));
			vo.setSearch(request.getParameter("search"));
			vo.setBlockNo(request.getParameter("blockNo"));
			vo.setPrevNext(request.getParameter("prevNext"));
			vo.setRowNum(request.getParameter("rowNum"));
			vo.setCombo(request.getParameterValues("combo"));

			bo = new GenericBO();
			bo.LISTPAGE(vo, masterObj.getRecord_per_page(), masterObj
					.getPage_per_block(), "SEARCH", masterObj.getMainQuery(vo
					.getCombo()), masterObj.getOrderBy());
			if (masterObj.getComboQuery() != null) {
				strData = new String[masterObj.getComboHeader().length / 2];
				for (int nI = 0; nI < masterObj.getComboHeader().length / 2; nI++) {
					// combo data based on query [No user defined]
					if (masterObj.getComboHeader()[2 * nI].equals("0")) {
						if (vo.getCombo() != null)
							strData[nI] = hisutil.getOptionValue(bo
									.getMainQuery(
											masterObj.getComboQuery()[nI], vo),
									vo.getCombo()[nI], "Select Value");
						else
							strData[nI] = hisutil.getOptionValue(bo
									.getMainQuery(
											masterObj.getComboQuery()[nI], vo),
									"0", "Select Value");
					}
				}
			}
			hlp = new GenericHLP();
			out.print(hlp.generateDataTable(vo, masterObj.getColumnHeader(),
					masterObj.getPage_per_block(), masterObj.getViewHeader(),
					masterObj.getMasterName(), masterObj.getSearchField(),
					masterObj.getRecord_per_page(), masterObj.getComboHeader(),
					masterObj.getComboQuery(), strData, masterObj.getOrderBy(),
					MasterInterface.nextprevcolor));

		} catch (Exception e) {
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(),
					"GenericData-->SEARCH()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			hlp = null;
			vo = null;
			/*
			 * if(out != null){ out.close(); out = null; }
			 */
		}
	}

	public static void DELETE(HttpServletRequest request,
			HttpServletResponse response, MasterInterface masterObj) {
		String divid = "";
		PrintWriter out = null;
		GenericVO vo = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		String[] strData = null;
		HisUtil hisutil = new HisUtil("Master Template", "GenericData");

		try {
			out = response.getWriter();
			HttpSession htSession = request.getSession();
			htSession.setAttribute("MSTCOMBO", request
					.getParameterValues("combo"));

			htSession.setAttribute("USERVALUE", userVal);
			masterObj.setHttpSession(htSession);
			// Setting Request
			Class classObj=masterObj.getClass();
			try
			{
				Field requestField=null;
				for(int i=0;i<classObj.getFields().length;i++)
				{
					//System.out.println("classObj.getFields()[i].getName()  "+classObj.getFields()[i].getName());
					if(classObj.getFields()[i].getName().equals("request"))
					{	
						requestField=classObj.getFields()[i];
					}
				}
				//System.out.println("requestField ::"+requestField);
				if(requestField!=null)
				{
					
								
					for(int i=0;i<classObj.getMethods().length;i++)
					{
						if(classObj.getMethods()[i].getName().equals("setHttpRequest"))
						{
							classObj.getMethods()[i].invoke(masterObj, request);
						}
				}
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			vo = new GenericVO();
			vo.setDivisionId(request.getParameter("divisionId"));
			vo.setChk(request.getParameter("chk"));
			if (request.getParameter("prevNext") == null
					|| request.getParameter("prevNext") == "")
				vo.setPrevNext("1");
			else
				vo.setPrevNext(request.getParameter("prevNext"));
			vo.setRowNum(request.getParameter("rowNum"));
			vo.setMinrow(request.getParameter("minrow"));
			vo.setBlockNo(request.getParameter("blockNo"));
			vo.setMax_rownum(request.getParameter("max_rownum"));
			vo.setSearch(request.getParameter("search"));
			vo.setSearchColumn(request.getParameter("searchColumn"));

			divid = request.getParameter("divisionId");

			bo = new GenericBO();
			bo.deleteRecords(masterObj.getDeleteQuery(), vo);

			bo.LISTPAGE(vo, masterObj.getRecord_per_page(), masterObj
					.getPage_per_block(), "DELETE", masterObj.getMainQuery(vo
					.getCombo()), masterObj.getOrderBy());
			if (masterObj.getComboQuery() != null) {
				strData = new String[masterObj.getComboHeader().length / 2];
				for (int nI = 0; nI < masterObj.getComboHeader().length / 2; nI++) {
					if (masterObj.getComboHeader()[2 * nI].equals("0")) {
						if (vo.getCombo() != null)
							strData[nI] = hisutil.getOptionValue(bo
									.getMainQuery(
											masterObj.getComboQuery()[nI], vo),
									vo.getCombo()[nI], "Select Value");
						else
							strData[nI] = hisutil.getOptionValue(bo
									.getMainQuery(
											masterObj.getComboQuery()[nI], vo),
									"0", "Select Value");
					}
				}
			}

			hlp = new GenericHLP();
			// strMessage = util.deleteRecords(masterObj.getDeleteQuery(),
			// request.getParameter("chk"));
			String p = hlp.generateDataTable(vo, masterObj.getColumnHeader(),
					masterObj.getPage_per_block(), masterObj.getViewHeader(),
					masterObj.getMasterName(), masterObj.getSearchField(),
					masterObj.getRecord_per_page(), masterObj.getComboHeader(),
					masterObj.getComboQuery(), strData, masterObj.getOrderBy(),
					MasterInterface.nextprevcolor);
			// String p = util.generateData(vo, masterObj);
			out.print(p + "####" + hlp.deleteRecords(vo) + "####" + divid+ "$$$$" +request.getSession().getAttribute("org.apache.struts.action.TOKEN").toString());

		} 
		catch (Exception e) 
		{
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(),"GenericData-->DELETE()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : "+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			vo = null;
			bo = null;
			hlp = null;
			/*
			 * if(out != null) { out.close(); out = null; }
			 */
		}
	}

	public static void VIEWDATA(HttpServletRequest request,
			HttpServletResponse response, MasterInterface masterObj) {

		GenericHLP hlp = null;
		GenericVO vo = null;
		GenericBO bo = null;
		PrintWriter out = null;
		vo = new GenericVO();
		vo.setChk(request.getParameter("chk"));
		bo = new GenericBO();
		try {
			/* This Method is used to fetch the Data for View */
			bo.getArrayList(masterObj.getViewQuery(), vo);
			if (vo.getStrMsgType() != "1") {
				out = response.getWriter();
				hlp = new GenericHLP();
				out.print(hlp.getNextPrevRows(vo, masterObj.getMasterName(),
						MasterInterface.nextprevcolor));
				out.print(hlp.getViewRows(vo, masterObj.getViewHeader()));
			} else {
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("strMsg", e.getMessage());
			HisException eObj = new HisException(masterObj.getMasterName(),
					"GenericData-->VIEWDATA()", e.getMessage());
			out
					.print("<font color='red'><b><div align='center'>Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "], Contact System Administrator!</div></b></font>");
			eObj = null;
		} finally {
			hlp = null;
			vo = null;
			bo = null;
			/*
			 * if(out != null) { out.close(); out = null; }
			 */
		}
	}
	
	
	/*
	 * Created function for View Bs page by Swapnil
	 */
	public static void VIEWDATABS(HttpServletRequest request,
			HttpServletResponse response, MasterInterface masterObj) {

		GenericHLP hlp = null;
		GenericVO vo = null;
		GenericBO bo = null;
		PrintWriter out = null;
		vo = new GenericVO();
		vo.setChk(request.getParameter("chk"));
		bo = new GenericBO();
		try {
			/* This Method is used to fetch the Data for View */
			bo.getArrayList(masterObj.getViewQuery(), vo);
			if (vo.getStrMsgType() != "1") {
				out = response.getWriter();
				hlp = new GenericHLP();
				out.print(hlp.getNextPrevRowsBS(vo, masterObj.getMasterName(),
						MasterInterface.nextprevcolor));
				out.print(hlp.getViewRowsBS(vo, masterObj.getViewHeader()));
			} else {
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("strMsg", e.getMessage());
			HisException eObj = new HisException(masterObj.getMasterName(),
					"GenericData-->VIEWDATA()", e.getMessage());
			out
					.print("<font color='red'><b><div align='center'>Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "], Contact System Administrator!</div></b></font>");
			eObj = null;
		} finally {
			hlp = null;
			vo = null;
			bo = null;
			/*
			 * if(out != null) { out.close(); out = null; }
			 */
		}
	}

	@SuppressWarnings("unchecked")
	public static void REPORTDATA(HttpServletRequest request,HttpServletResponse response, MasterInterface masterObj) 
	{
		GenericVO vo = null;
		GenericBO bo = null;
		GenericHLP hlp = null;
		ResourceBundle mstReportProp=null;
		String strInterGlobalTrigger = "";
		PrintWriter out = null;
		String hospCode=BillConfigUtil.SUPER_HOSPITAL_CODE ;
		try 
		{
			mstReportProp = ResourceBundle.getBundle("hisglobal.hisconfig.hisReport");
			strInterGlobalTrigger = mstReportProp.getString("HIS_MASTER_INTERFACE_REQUIRED");
			out = response.getWriter();

			HttpSession htSession = request.getSession();
			htSession.setAttribute("MSTCOMBO", request.getParameterValues("combo"));

			htSession.setAttribute("USERVALUE", userVal);
			masterObj.setHttpSession(htSession);
			// Setting Request
			Class classObj=masterObj.getClass();
			try
			{
				Field requestField=null;
				for(int i=0;i<classObj.getFields().length;i++)
				{
					//System.out.println("classObj.getFields()[i].getName()  "+classObj.getFields()[i].getName());
					if(classObj.getFields()[i].getName().equals("request"))
					{	
						requestField=classObj.getFields()[i];
					}
				}
				//System.out.println("requestField ::"+requestField);
				if(requestField!=null)
				{								
					for(int i=0;i<classObj.getMethods().length;i++)
					{
						if(classObj.getMethods()[i].getName().equals("setHttpRequest"))
						{
							classObj.getMethods()[i].invoke(masterObj, request);
						}
					}					
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}

			vo = new GenericVO();
			vo.setMinrow(request.getParameter("minrow"));
			vo.setBlockNo(request.getParameter("blockNo"));
			vo.setSearch(request.getParameter("search"));
			if(vo.getBlockNo().equals("1")&& request.getParameter("strShowAllData").equals("0"))
			{
				request.getSession().removeAttribute("initPageNo");
			}
			try
			{
				vo.setStrLastRowNo(((ArrayList<String>)request.getSession().getAttribute("initPageNo")).get(Integer.parseInt(vo.getBlockNo())));
			}
			catch(Exception e)
			{				
			}
			vo.setSearchColumn(request.getParameter("searchColumn"));
			vo.setComboValue(request.getParameter("comboValue"));
			vo.setCombo(request.getParameterValues("combo"));
			//System.out.println("request.getParameter(orderByName)"+request.getParameter("orderByName"));
			vo.setRptOrderBy(request.getParameter("orderByName"));
			vo.setStrReportGroupBy(request.getParameterValues("strGroupByForReport"));
			vo.setStrColNotRequired(request.getParameterValues("strColsNotRequiredInReport"));
			vo.setStrNoOfRecordPerPages(request.getParameter("strNoOfRecordPerPages"));
			vo.setStrConcatString(request.getParameter("strConcat"));
			vo.setStrGroupByPatern(request.getParameter("strGroupByPatern"));
			vo.setStrRepeat(request.getParameter("fRepeat"));
			vo.setStrOrderByCols(request.getParameterValues("strOrderByCols"));
			vo.setStrAlignWith(request.getParameterValues("strAlignWith"));
			vo.setStrBorderRequired(request.getParameter("strBorderRequired"));
			vo.setStrHospCode(hospCode);
			vo.setStrSeatId((String)request.getSession().getAttribute("SEATID"));
			vo.setStrShowAllData(request.getParameter("strShowAllData"));
			vo.setStrMasterName(masterObj.getMasterName());
			//System.out.println("masterObj.getOrderBy()[0]"+masterObj.getOrderBy()[0]);
			//System.out.println("masterObj.getOrderBy()[1]"+masterObj.getOrderBy()[1]);
			if(vo.getRptOrderBy()==null || vo.getRptOrderBy().trim().equals(""))
				//vo.setRptOrderBy(masterObj.getOrderBy()[1]);
				vo.setRptOrderBy(SecurityUtil.encrypt(masterObj.getOrderBy()[1]));	
			bo = new GenericBO();
			
			/*if((request.getParameter("strReportConfig")==null || !request.getParameter("strReportConfig").equals("true")) && (strInterGlobalTrigger.equals("1") || strInterGlobalTrigger.equals("2")))
				bo.saveReportConfig(vo);*/
			if(vo.getStrRepeat()!=null && vo.getStrRepeat().equals("yes"))
			{
				vo.setLstWs((WebRowSet)request.getSession().getAttribute("MASTERWS"));
				vo.setStrSessionSaveParam((String)request.getSession().getAttribute("MASTERPARAM"));
				vo.setStrSessionColWidth((String[])request.getSession().getAttribute("MASTERCOLWIDTH"));
				vo.setStrSlNo((String)request.getSession().getAttribute("MASTERSLNO"));
				vo.setStrTmpData((String[])request.getSession().getAttribute("MASTERTMPDATA"));
			}
			else
				bo.getReports(vo, masterObj.getMainQuery(vo.getCombo()), masterObj.getRecord_per_page(), masterObj.getPage_per_block(), request.getParameter("strShowAllData"));
				
			if (vo.getStrMsgType() != "1") 
			{
				hlp = new GenericHLP();
				//Commented To Show All Data Irrespective of Groups in Master Reports
				//out.print(hlp.getReports(vo, masterObj.getComboHeader(),masterObj.getRecord_per_page(), masterObj.getPage_per_block(), masterObj.getColumnHeader(),request.getParameter("strShowAllData"),masterObj.getColsWidth(),vo.getStrReportGroupBy()));
				out.print(hlp.getReports(vo, masterObj.getComboHeader(),masterObj.getRecord_per_page(), masterObj.getPage_per_block(), masterObj.getColumnHeader(),"1",masterObj.getColsWidth(),null));
				request.getSession().setAttribute("MASTERPARAM", vo.getStrSessionSaveParam());
				request.getSession().setAttribute("MASTERCOLWIDTH",vo.getStrSessionColWidth());
				request.getSession().setAttribute("MASTERWS",vo.getLstWs());
				request.getSession().setAttribute("MASTERTMPDATA",vo.getStrTmpData());
				//System.out.println("SSLLLLLLNO    "+vo.getStrLastRowNo());
				if(request.getParameter("strShowAllData").equals("0"))
				{
					if(vo.getBlockNo().equals("1"))
					{
						ArrayList<String> initPageNo = new ArrayList<String>();
						initPageNo.add("0");
						initPageNo.add(Integer.parseInt(vo.getBlockNo()),"0");
						try
						{
							initPageNo.remove(Integer.parseInt(vo.getBlockNo())+1);
						}
						catch(Exception e)
						{
							
						}
						initPageNo.add(Integer.parseInt(vo.getBlockNo())+1,vo.getStrLastRowNo());
						request.getSession().setAttribute("initPageNo", initPageNo);
					}
					else
					{
						ArrayList<String> initPageNo =(ArrayList<String>)request.getSession().getAttribute("initPageNo");
						try
						{
							initPageNo.remove(Integer.parseInt(vo.getBlockNo())+1);
						}
						catch(Exception e)
						{							
						}
						initPageNo.add(Integer.parseInt(vo.getBlockNo())+1,vo.getStrLastRowNo());
						request.getSession().setAttribute("initPageNo", initPageNo);
					}
				}
				if(vo.getStrConcatString().equals("1"))
					request.getSession().setAttribute("MASTERSLNO",vo.getStrSlNo());
			} 
			else 
			{
				throw new Exception(vo.getStrMsgString());
			}			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(),"GenericData-->REPORTDATA()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : "+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			vo = null;
			bo = null;
			hlp = null;
			/*
			 * if(out != null){ out.close(); out = null; }
			 */
		}
	}
	
	public static void REPORTINTERFACE(HttpServletRequest request,
			HttpServletResponse response, MasterInterface masterObj) {
		GenericVO vo = null;
		GenericHLP hlp = null;
		PrintWriter out = null;
		ResourceBundle mstReportProp=null;
		String strInterGlobalTrigger = "";
		GenericBO bo = null;
		String hospCode=BillConfigUtil.SUPER_HOSPITAL_CODE ;
		try {
			bo = new GenericBO();
			mstReportProp = ResourceBundle.getBundle("hisglobal.hisconfig.hisReport");
			strInterGlobalTrigger = mstReportProp.getString("HIS_MASTER_INTERFACE_REQUIRED");
			vo = new GenericVO();
			out = response.getWriter();
			hlp = new GenericHLP();
			String interFace = "#false#";
			vo.setStrMasterName(masterObj.getMasterName());
			vo.setStrHospCode(hospCode);
			vo.setStrSeatId((String)request.getSession().getAttribute("SEATID"));
			bo.fetchReportConfig(vo);
			if(masterObj.reportInterFaceRequired()&&strInterGlobalTrigger.equals("1")||vo.getStrReportConfigDtl().equals("False")||strInterGlobalTrigger.equals("2"))
				interFace = "#true#";
			else if(!vo.getStrReportConfigDtl().equals("False"))
				interFace = "#false#"+vo.getStrReportConfigDtl();
			out.print(hlp.getReportInterface(vo, masterObj.getColumnHeader(), (masterObj.getRecord_per_page()*masterObj.getPage_per_block())+"")+interFace);
		} catch (Exception e) {
			vo.setStrMsgString(e.getMessage());
			vo.setStrMsgType("1");
			HisException eObj = new HisException(masterObj.getMasterName(),
					"GenericData-->REPORTDATA()", vo.getStrMsgString());
			out.println("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			vo = null;
			hlp = null;
		}
	}
}
