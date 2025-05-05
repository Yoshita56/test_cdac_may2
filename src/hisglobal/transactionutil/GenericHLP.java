/**
 * 
 */
package hisglobal.transactionutil;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

/**
 * @author dell
 * 
 */
public class GenericHLP {

	int no_of_column = 0;
	int no_of_combo = 0;
	int max_rownum = 0;
	int page_per_block = 0;
	int rec_per_page = 0;
	String combo[] = null;
	String cmb[] = null;
	int no_of_combo_in_row = 0; // these two fields are added on 05-12-2007 by
	// Rahul.
	int no_of_primary_keys = 0;

	// used for button
	String btnBgColor = "#CFE7E2";//"#f1f6f6";
	String btnFontColor = "#990000";
	String btnHeight = "23";
	String btnWidth = "125";
	String pagingColor="#2E6E9E";
	String pagingColorSelected="red";

	/**
	 * This is the main function that generates data for the List Page.
	 * 
	 * @param vo
	 * @param columnHdr
	 * @param pagePerBlock
	 * @param masterName
	 * @param searchFld
	 * @param recPerPage
	 * @param comboHdr
	 * @param comboQry
	 * @param comboData
	 * @param clr
	 * @param no_of_Combo
	 * @param HdrNote
	 * @param footerNote
	 * @param rowStatus
	 * @param buttons
	 * @param eventState
	 * @return
	 * 
	 */
	public String generateData(GenericVO vo, String[] columnHdr,
			int pagePerBlock, String masterName, String[] searchFld,
			int recPerPage, String[] comboHdr, String[] comboQry,
			String[] comboData, String clr, int no_of_Combo, String HdrNote,
			String footerNote, String[] rowStatus, String buttons,
			String eventState, String menuOption, String comboEventState,
			String[] ordrBy, List viewHdr) {
		GenericBO bo = null;
		StringBuilder br = new StringBuilder(1000);
		String mode = vo.getHmode();
		// String searchColumn = vo.getSearchColumn();
		String prevNext = vo.getPrevNext();
		// String search = vo.getSearch();
		// String orderby = vo.getOrderby();
		String comboQuery[] = null;
		String combo_data = "";
		String divisionId = "";
		int x=0;
		// by rahul for user defined combo
		// String[] userComboList = null;
		// String[] userComboValue = null;

		// no. of combos in a row.
		no_of_combo_in_row = no_of_Combo;
		// no. of primary keys.
		// no_of_primary_keys = masterObj.getNo_of_primary_keys();

		int rowsetSize = 0;
		int nextpage_no = 0;
		int actual_page_block = 0;
		// int minrow = Integer.parseInt(vo.getRowNum());
		// int blockNo = Integer.parseInt(vo.getBlockNo());

		int total_page = 0;
		// int i = 0;

		// HisDAO dao = null;
		WebRowSet rowset = null;

		int minrow = Integer.parseInt(vo.getMinRow());
		int max_rownum = Integer.parseInt(vo.getMax_rownum());
		int blockNo = Integer.parseInt(vo.getBlockNo());

		no_of_column = columnHdr.length;
		page_per_block = pagePerBlock;
		rec_per_page = recPerPage;

		if (comboHdr == null)
			no_of_combo = 0;
		else
			no_of_combo = comboHdr.length / 2;

		combo = vo.getCombo();

		try {
			/*
			 * if (mode.equals("DEFAULT") || mode.equals("null") || mode ==
			 * null) { blockNo = 1; nextpage_no = (((blockNo * page_per_block) -
			 * page_per_block) + 1); } else { if (prevNext.equals("1")) // 1
			 * means next, 2 means // previous { nextpage_no = (((blockNo *
			 * page_per_block) - page_per_block) + 1); } else if
			 * (prevNext.equals("2")) // 1 means next, 2 means // previous {
			 * nextpage_no = (((blockNo * page_per_block) - page_per_block) +
			 * 1); } }
			 */

			if (mode.equals("DELETE")) {
				divisionId = vo.getDivisionId();
				nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
			} else {
				if (prevNext.equals("1") || prevNext.equals("2")) {
					nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
				} else {
					blockNo = 1;
					nextpage_no = 1;
				}
			}

			rowset = vo.getLstWs();
			rowsetSize = rowset.size();
			total_page = (rowsetSize % rec_per_page == 0) ? (rowsetSize / rec_per_page)
					: ((rowsetSize / rec_per_page) + 1);

			// code changed to put header n pagination in same row on 20-08-07
			// by Rahul

			br.append(rec_per_page + "####" + no_of_combo + "####"
					+ actual_page_block + "####" + total_page + "####");

			// int b = 1;

			/*
			 * br.append("<DIV ALIGN='RIGHT' ID='m^" + b + "'
			 * STYLE='DISPLAY:BLOCK;position:relative' TITLE='Click to View More
			 * Data' >" // + "<TD CLASS='MASTERNAME'><DIV ALIGN='LEFT'><b>" // +
			 * masterObj.getMasterName() // + ">></b></DIV></TD>" +"</div>");
			 */

			/* Un neceessary Code*/
			
			//br.append("<TABLE BORDER='0' CELLSPACING='1px' CELLPADDING='1px' WIDTH='100%'>";
			//br.append("<TR><TD CLASS='TDCOMBOHEADER'>";
			
			
			
			if (rowsetSize <= 0) 
			{
				br.append("<DIV CLASS='wrapper rounded'>");
				br.append("<TABLE width='100%' BGCOLOR='#6097BC' cellspacing='1px'><TR class='TRFONTHEAD'>");
				br.append(getColoumnHeaderString(columnHdr, vo, ordrBy));
				br.append("</TR></TABLE>");
				br.append("<TABLE  WIDTH='100%' ALIGN='CENTER' CELLPADDING='1' CELLSPACING='1'>");
				br.append("<TR CLASS='ONMOUSEOUT1'><TD WIDTH='100%' HEIGHT='250px;' COLSPAN='"+ (columnHdr.length + 1)+ "'><DIV ALIGN='CENTER'><FONT COLOR='RED'><B>No Record Found !!</B></FONT><DIV></TD></TR></TABLE>");
				br.append("</DIV>");
			}
			
			//br.append(getCheckBoxData(rowset, (100 / columnHdr.length), minrow,eventState, rowStatus, vo,columnHdr,ordrBy));
			br.append(getQueryData(rowset, (100 / columnHdr.length), minrow,eventState, rowStatus, vo,columnHdr,ordrBy));
			//br.append("</div>");
			br.append("<TABLE WIDTH='100%' CELLSPACING='1px' CELLPADDING='1px'>");
			br.append("<TR>");
			
			if(vo.getExtraInfoData()!=null && vo.getExtraInfoData().length>0)
			{
				//br.append("<TD CLASS='TDNOTES' WIDTH='50%'><DIV ALIGN='LEFT'>");
				br.append("<TD WIDTH='50%'><DIV ALIGN='LEFT'>");//White Background for Extra Info
				for(int i=0;i<vo.getExtraInfoData().length/2;i++)
				{
					br.append("<FONT SIZE='1'>"+ vo.getExtraInfoData()[i+x]+ ":&nbsp;");
					x++;
					br.append(vo.getExtraInfoData()[i+x]+"</FONT><BR>");
				}
				br.append("<FONT COLOR='"+pagingColor+"'>Total Records:"+rowsetSize+"&nbsp;"+ HdrNote+"</FONT></DIV></TD>");
			}
			else
			{
				//br.append("<TD CLASS='TDNOTES' WIDTH='50%'><DIV ALIGN='LEFT'>"+ HdrNote	+ "</TD>");
				br.append("<TD WIDTH='50%'><DIV ALIGN='LEFT'><FONT COLOR='"+pagingColor+"'>Total Records:"+rowsetSize+"&nbsp;"+ HdrNote	+ "</FONT></TD>");//White Background for Pagination
			}
			br.append("<TD WIDTH='50%'><DIV ALIGN='RIGHT'><FONT COLOR='"+pagingColor+"'>");

			br.append(getTotalBlock(nextpage_no, total_page, max_rownum,minrow, blockNo, clr, vo));

			br.append("</FONT></DIV></TD></TR></TABLE>");
			br.append(getSearchRowString(vo, minrow, max_rownum, blockNo,total_page, searchFld, columnHdr, pagePerBlock, masterName,menuOption, viewHdr));

			br.append("####<TABLE WIDTH='100%' cellspacing='0'><TR class='ShadedTitleTagImage'>"); 
			br.append("<TD>" + footerNote + "</TD>");
			br.append("<TD><DIV ALIGN='RIGHT'>");
			try
			{
				for (int q = 0; q < rowStatus.length; q += 4) 
				{
					if(!rowStatus[q + 2].equals("")&&!rowStatus[q + 3].equals(""))
					br.append("[<FONT COLOR='" + rowStatus[q + 2] + "'>"+ rowStatus[q + 3] + "</FONT>] ");
				}
			}
			catch(Exception _e)
			{
				
			}
			br.append("</DIV></TD></TABLE>");

			br.append("####"+ getCombo(vo, no_of_Combo, comboHdr, comboQry, masterName,comboData, comboEventState));
			br.append("####" + buttons);

		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GenericHLP.generateData() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			comboQuery = null;
			combo_data = null;
		}
		return br.toString();
	}


	public String generateDataDataTable(GenericVO vo, String[] columnHdr,
			int pagePerBlock, String masterName, String[] searchFld,
			int recPerPage, String[] comboHdr, String[] comboQry,
			String[] comboData, String clr, int no_of_Combo, String HdrNote,
			String footerNote, String[] rowStatus, String buttons,
			String eventState, String menuOption, String comboEventState,
			String[] ordrBy, List viewHdr) {
		
		clr="white";
		GenericBO bo = null;
		StringBuilder br = new StringBuilder(1000);
		String mode = vo.getHmode();
		// String searchColumn = vo.getSearchColumn();
		String prevNext = vo.getPrevNext();
		// String search = vo.getSearch();
		// String orderby = vo.getOrderby();
		String comboQuery[] = null;
		String combo_data = "";
		String divisionId = "";
		int x=0;
		// by rahul for user defined combo
		// String[] userComboList = null;
		// String[] userComboValue = null;

		// no. of combos in a row.
		no_of_combo_in_row = no_of_Combo;
		// no. of primary keys.
		// no_of_primary_keys = masterObj.getNo_of_primary_keys();

		int rowsetSize = 0;
		int nextpage_no = 0;
		int actual_page_block = 0;
		// int minrow = Integer.parseInt(vo.getRowNum());
		// int blockNo = Integer.parseInt(vo.getBlockNo());

		int total_page = 0;
		// int i = 0;

		// HisDAO dao = null;
		WebRowSet rowset = null;

		int minrow = Integer.parseInt(vo.getMinRow());
		int max_rownum = Integer.parseInt(vo.getMax_rownum());
		int blockNo = Integer.parseInt(vo.getBlockNo());

		no_of_column = columnHdr.length;
		page_per_block = pagePerBlock;
		rec_per_page = recPerPage;

		if (comboHdr == null)
			no_of_combo = 0;
		else
			no_of_combo = comboHdr.length / 2;

		combo = vo.getCombo();

		try {
			/*
			 * if (mode.equals("DEFAULT") || mode.equals("null") || mode ==
			 * null) { blockNo = 1; nextpage_no = (((blockNo * page_per_block) -
			 * page_per_block) + 1); } else { if (prevNext.equals("1")) // 1
			 * means next, 2 means // previous { nextpage_no = (((blockNo *
			 * page_per_block) - page_per_block) + 1); } else if
			 * (prevNext.equals("2")) // 1 means next, 2 means // previous {
			 * nextpage_no = (((blockNo * page_per_block) - page_per_block) +
			 * 1); } }
			 */

			if (mode.equals("DELETE")) {
				divisionId = vo.getDivisionId();
				nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
			} else {
				if (prevNext.equals("1") || prevNext.equals("2")) {
					nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
				} else {
					blockNo = 1;
					nextpage_no = 1;
				}
			}

			rowset = vo.getLstWs();
			rowsetSize = rowset.size();
			total_page = (rowsetSize % rec_per_page == 0) ? (rowsetSize / rec_per_page)
					: ((rowsetSize / rec_per_page) + 1);

			// code changed to put header n pagination in same row on 20-08-07
			// by Rahul

			br.append(rec_per_page + "####" + no_of_combo + "####"
					+ actual_page_block + "####" + total_page + "####");

			// int b = 1;

			/*
			 * br.append("<DIV ALIGN='RIGHT' ID='m^" + b + "'
			 * STYLE='DISPLAY:BLOCK;position:relative' TITLE='Click to View More
			 * Data' >" // + "<TD CLASS='MASTERNAME'><DIV ALIGN='LEFT'><b>" // +
			 * masterObj.getMasterName() // + ">></b></DIV></TD>" +"</div>");
			 */

			/* Un neceessary Code*/
			
			//br.append("<TABLE BORDER='0' CELLSPACING='1px' CELLPADDING='1px' WIDTH='100%'>";
			//br.append("<TR><TD CLASS='TDCOMBOHEADER'>";
			
			
			
/*			if (rowsetSize <= 0) 
			{
				br.append("<DIV CLASS='wrapper rounded'>");
				br.append("<TABLE width='100%' BGCOLOR='#6097BC' cellspacing='1px'><TR class='TRFONTHEAD'>");
				br.append(getColoumnHeaderStringNewDtTbl(columnHdr, vo, ordrBy));
				br.append("</TR></TABLE>");
				br.append("<TABLE  WIDTH='100%' ALIGN='CENTER' CELLPADDING='1' CELLSPACING='1'>");
				br.append("<TR CLASS='ROWFONT'><TD WIDTH='100%' HEIGHT='250px;' COLSPAN='"+ (columnHdr.length + 1)+ "'><DIV ALIGN='CENTER'><FONT COLOR='RED'><B>No Record Found !!</B></FONT><DIV></TD></TR></TABLE>");
				br.append("</DIV>");
			}*/
			
			//br.append(getCheckBoxData(rowset, (100 / columnHdr.length), minrow,eventState, rowStatus, vo,columnHdr,ordrBy));
			br.append(getQueryDataNewDtTbl(rowset, (100 / columnHdr.length), minrow,eventState, rowStatus, vo,columnHdr,ordrBy));
			//br.append("</div>");
			br.append("<TABLE WIDTH='100%' CELLSPACING='1px' CELLPADDING='1px'>");
			br.append("<TR>");
			
			if(vo.getExtraInfoData()!=null && vo.getExtraInfoData().length>0)
			{
					//br.append("<TD CLASS='TDNOTES' WIDTH='50%'><DIV ALIGN='LEFT'>");
				//br.append("<TD WIDTH='50%'><DIV ALIGN='LEFT'>");//White Background for Extra Info
				for(int i=0;i<vo.getExtraInfoData().length/2;i++)
				{
					br.append("<FONT SIZE='1'>"+ vo.getExtraInfoData()[i+x]+ ":&nbsp;");
					x++;
					br.append(vo.getExtraInfoData()[i+x]+"</FONT><BR>");
				}
				//br.append("<FONT COLOR='"+pagingColor+"'>Total Records:"+rowsetSize+"&nbsp;"+ HdrNote+"</FONT></DIV></TD>");
			}
			else
			{
					//br.append("<TD CLASS='TDNOTES' WIDTH='50%'><DIV ALIGN='LEFT'>"+ HdrNote	+ "</TD>");
				//br.append("<TD WIDTH='50%'><DIV ALIGN='LEFT'><FONT COLOR='"+pagingColor+"'>Total Records:"+rowsetSize+"&nbsp;"+ HdrNote	+ "</FONT></TD>");//White Background for Pagination
			}
			br.append("<TD WIDTH='50%'><DIV ALIGN='RIGHT'><FONT class='nextPrevTag'>");

			br.append(getTotalBlockDtTbl(nextpage_no, total_page, max_rownum,minrow, blockNo, clr, vo));

			br.append("</FONT></DIV></TD></TR></TABLE>");
			br.append(getSearchRowString(vo, minrow, max_rownum, blockNo,total_page, searchFld, columnHdr, pagePerBlock, masterName,menuOption, viewHdr));

			br.append("####<TABLE WIDTH='100%' cellspacing='0'><TR class='ShadedTitleTagImage'>"); 
			br.append("<TD></TD>"); //" + footerNote + "
			br.append("<TD><DIV ALIGN='RIGHT'>");
			try
			{
				for (int q = 0; q < rowStatus.length; q += 4) 
				{
					if(!rowStatus[q + 2].equals("")&&!rowStatus[q + 3].equals(""))
					br.append("[<FONT ><font COLOR='" + rowStatus[q + 2] + "'><span class='glyphicon glyphicon-certificate'></span></font>"+ rowStatus[q + 3] + "</FONT>] "); //  style='color:#fc8686'
				}
			}
			catch(Exception _e)
			{
				
			}
			br.append("</DIV></TD></TABLE>");

			br.append("####"+ getComboNewDtTbl(vo, no_of_Combo, comboHdr, comboQry, masterName,comboData, comboEventState));
			br.append("####" + buttons);

		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GenericHLP.generateData() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			comboQuery = null;
			combo_data = null;
		}
		return br.toString();
	}
	/**
	 * This function generates combo.
	 * 
	 * @param vo
	 * @param no_of_Combo
	 * @param comboHdr
	 * @param comboQry
	 * @param masterName
	 * @param comboData
	 * @return
	 */
	public String getCombo(GenericVO vo, int no_of_Combo, String[] comboHdr,String[] comboQry, String masterName, String[] comboData,String comboEventState) 
	{
		StringBuilder br = new StringBuilder();
		String[] comboQuery = null;
		String[] combo_header = null;
		String[] userComboList = null;
		String[] userComboValue = null;
		String combo_data = "";
		String jsFunc = "";

		//HisUtil util = null;

		int i = 0;
		no_of_combo_in_row = no_of_Combo;
		if (comboHdr == null)
			no_of_combo = 0;
		else
			no_of_combo = comboHdr.length / 2;
		
		try 
		{
			comboQuery = comboQry;
			combo_header = comboHdr;
			i = 1;

			/*util = new HisUtil("Transaction Template", "TransUtil");
			br.append("<TABLE WIDTH='100%' ALIGN='CENTER' BORDER='0' CELLSPACING='0px' CELLPADDING='0px'>");
			br.append("<TR><TD CLASS='TDHEADER'>"+ masterName+ "</TD>");
			br.append("<TD CLASS='TDHEADER'><DIV align='right'>"+ util.getASDate("dd-MMM-yyyy/HH:mm:ss")+ "  "+ (String) vo.getSession().getAttribute("USERNAME")+ "" );
			br.append("<img style='cursor: pointer;' src='../../hisglobal/images/stop.png' onclick='goToMainPage()'>");
			br.append("</TD></TR></TABLE>");*/
			br.append("<div class='rounded' id='combosDiv'><TABLE WIDTH='100%' ALIGN='CENTER' BORDER='0' CELLSPACING='1px' CELLPADDING='1px' id='combosTable'>");
			br.append("<TR><TD  CLASS='TDCOMBOHEADER' >");

			for (int p = 0; p < no_of_combo; p++, i++) 
			{

				// 3 is replaced with (no_of_combo_in_row + 1) field in if loop,
				// to give no. of combos in a row of user choice.

				if (combo_header[2 * p].equals("1")) 
				{
					userComboList = comboQuery[p].split("#");
					combo_data = "";

					for (int k = 0; k < userComboList.length; k++) 
					{
						userComboValue = userComboList[k].replace('^', '#').split("#");
						if (combo != null && combo[p].equals(userComboValue[0]))
							combo_data += "<OPTION SELECTED VALUE='"+ userComboValue[0] + "'>"+ userComboValue[1] + "</OPTION>\n";
						else
							combo_data += "<OPTION VALUE='" + userComboValue[0]+ "'>" + userComboValue[1] + "</OPTION>\n";
					}
				} 
				else 
				{
					combo_data = comboData[p];
				}

				if (comboEventState != null && !comboEventState.equals(""))
					jsFunc = comboEventState + "(this);fetchRecordsCombo(" + p+ ");";
				else
					jsFunc = "fetchRecordsCombo(" + p + ");";
				
				/*Changed By Amit Kumar Ateria on 30 Jun 2011 Check if Combo mandatory or not as per change request dated 13 Jun 2011 */
				
				if(combo_header[2 * p + 1].replace("^","#").split("#").length>=2 && combo_header[2 * p + 1].replace("^","#").split("#")[1].equals("1"))
				{
					br.append("<B><font color='red'>*</font>&nbsp;" + combo_header[2 * p + 1].replace("^","#").split("#")[0]+ "</B>");
					br.append("&nbsp;<SELECT NAME='combo' id='comboid" + p+ "' TITLE='Select Combo' CLASS='CB1' onChange='"+ jsFunc + "'>" + combo_data+ "</SELECT>&nbsp;&nbsp;&nbsp;&nbsp;");
				}
				else
				{
					br.append("<B>" + combo_header[2 * p + 1]+ "</B>&nbsp;");
					br.append("<SELECT NAME='combo' id='comboid" + p+ "' TITLE='Select Combo' CLASS='CB1' onChange='"+ jsFunc + "'>" + combo_data+ "</SELECT>&nbsp;&nbsp;&nbsp;&nbsp;");
				}
					if (i == no_of_combo_in_row) 
					{
						if (p == (no_of_combo - 1)) 
						{
							i = 0;
						} 
						else 
						{
							br.append("</TD></TR><TR><TD CLASS='TDCOMBOHEADER'>");
							i = 0;
						}
					}
				}
			br.append("</TD></TR></TABLE></div>");
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GenericHLP.getCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}

		return br.toString();
	}
	
	public String getComboNewDtTbl(GenericVO vo, int no_of_Combo, String[] comboHdr,String[] comboQry, String masterName, String[] comboData,String comboEventState) 
	{
		StringBuilder br = new StringBuilder();
		String[] comboQuery = null;
		String[] combo_header = null;
		String[] userComboList = null;
		String[] userComboValue = null;
		String combo_data = "";
		String jsFunc = "";

		//HisUtil util = null;

		int i = 0;
		no_of_combo_in_row = no_of_Combo;
		if (comboHdr == null)
			no_of_combo = 0;
		else
			no_of_combo = comboHdr.length / 2;
		
		try 
		{
			comboQuery = comboQry;
			combo_header = comboHdr;
			i = 1;

			/*util = new HisUtil("Transaction Template", "TransUtil");
			br.append("<TABLE WIDTH='100%' ALIGN='CENTER' BORDER='0' CELLSPACING='0px' CELLPADDING='0px'>");
			br.append("<TR><TD CLASS='TDHEADER'>"+ masterName+ "</TD>");
			br.append("<TD CLASS='TDHEADER'><DIV align='right'>"+ util.getASDate("dd-MMM-yyyy/HH:mm:ss")+ "  "+ (String) vo.getSession().getAttribute("USERNAME")+ "" );
			br.append("<img style='cursor: pointer;' src='../../hisglobal/images/stop.png' onclick='goToMainPage()'>");
			br.append("</TD></TR></TABLE>");*/
			br.append("<div class='rounded' id='combosDiv'><TABLE WIDTH='100%' ALIGN='CENTER' BORDER='0' CELLSPACING='1px' CELLPADDING='1px' id='combosTable'>");
			br.append("<TR><TD  CLASS='form-inline' align='right' >");

			for (int p = 0; p < no_of_combo; p++, i++) 
			{

				// 3 is replaced with (no_of_combo_in_row + 1) field in if loop,
				// to give no. of combos in a row of user choice.

				if (combo_header[2 * p].equals("1")) 
				{
					userComboList = comboQuery[p].split("#");
					combo_data = "";

					for (int k = 0; k < userComboList.length; k++) 
					{
						userComboValue = userComboList[k].replace('^', '#').split("#");
						if (combo != null && combo[p].equals(userComboValue[0]))
							combo_data += "<OPTION SELECTED VALUE='"+ userComboValue[0] + "'>"+ userComboValue[1] + "</OPTION>\n";
						else
							combo_data += "<OPTION VALUE='" + userComboValue[0]+ "'>" + userComboValue[1] + "</OPTION>\n";
					}
				} 
				else 
				{
					combo_data = comboData[p];
				}

				if (comboEventState != null && !comboEventState.equals(""))
					jsFunc = comboEventState + "(this);fetchRecordsCombo(" + p+ ");";
				else
					jsFunc = "fetchRecordsCombo(" + p + ");";
				
				/*Changed By Amit Kumar Ateria on 30 Jun 2011 Check if Combo mandatory or not as per change request dated 13 Jun 2011 */
				
				if(combo_header[2 * p + 1].replace("^","#").split("#").length>=2 && combo_header[2 * p + 1].replace("^","#").split("#")[1].equals("1"))
				{
					br.append("<B><font color='red'>*</font>&nbsp;" + combo_header[2 * p + 1].replace("^","#").split("#")[0]+ "</B>");
					br.append("&nbsp;<SELECT NAME='combo' id='comboid" + p+ "' TITLE='Select Combo' CLASS='CB1 form-control input-sm' onChange='"+ jsFunc + "'>" + combo_data+ "</SELECT>&nbsp;&nbsp;&nbsp;&nbsp;");
				}
				else
				{
					br.append("<B>" + combo_header[2 * p + 1]+ "</B>&nbsp;");
					br.append("<SELECT NAME='combo' id='comboid" + p+ "' TITLE='Select Combo' CLASS='CB1 form-control input-sm' onChange='"+ jsFunc + "'>" + combo_data+ "</SELECT>&nbsp;&nbsp;&nbsp;&nbsp;");
				}
					if (i == no_of_combo_in_row) 
					{
						if (p == (no_of_combo - 1)) 
						{
							i = 0;
						} 
						else 
						{
							br.append("</TD></TR><TR><TD CLASS='TDCOMBOHEADER'>");
							i = 0;
						}
					}
				}
			br.append("</TD></TR></TABLE></div>");
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GenericHLP.getCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}

		return br.toString();
	}

	/*
	 * getColoumnHeaderString(MasterInterface masterObj) function make a string
	 * of column header and also assign order by value to column and retuen a
	 * string
	 */

	public String getColoumnHeaderString(String[] columnHdr, GenericVO vo,
			String[] orderby) {

		StringBuilder data = new StringBuilder(300);
		String coulmn_header[] = columnHdr;

		int coulmn_header_length = coulmn_header.length;
		int size_percent = 100 / coulmn_header_length;
		int flag = 0;
		String columnName="";
		String order_by_Array[] = orderby;
		int order_length = order_by_Array.length;
		int orderHead = 0;

		try {
			data
					.append("<TD><INPUT TYPE='CHECKBOX' NAME='chkmain' onclick='isCheckedFirst(this),chkUserFunc(this);;'></TD>");

			/*
			 * for (int columnHead = 0; columnHead < coulmn_header_length;
			 * columnHead++) { flag = 0; data.append("<TD CLASS=TDFONTHEAD
			 * WIDTH='" + size_percent + "%'><B>" + coulmn_header[columnHead] + "</B>
			 * </TD>"); }
			 */
			for (int columnHead = 0; columnHead < coulmn_header_length; columnHead++) {
				flag = 0;
				for (orderHead = 0; orderHead < order_length; orderHead = orderHead + 2) {
					if ((Integer.parseInt(order_by_Array[orderHead]) - 1) == columnHead) {
						flag = 1;
						break;
					}
				}
				if(coulmn_header[columnHead].replace("^","#").split("#").length>=2)
				{
					size_percent=Integer.parseInt(coulmn_header[columnHead].replace("^","#").split("#")[1]);
					columnName=coulmn_header[columnHead].replace("^","#").split("#")[0];
				}
				else
				{
					columnName=coulmn_header[columnHead];
				}
				if (flag == 1) {

					if (vo.getOrderby().equals(
							order_by_Array[orderHead + 1] + " ASC")) {

						data
								.append("<TD WIDTH='"
										+ size_percent
										+ "%'><B>"
										+ columnName
										+ "</B><img style='CURSOR:POINTER' src='../../hisglobal/images/arrdouble-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
										+ order_by_Array[orderHead + 1]
										+ " ASC\");'>"
										+ "<img style='CURSOR:POINTER' src='../../hisglobal/images/arr-dwn.png' width='12px' TITLE='Descending Order' onClick='sortData(\""
										+ order_by_Array[orderHead + 1]
										+ " DESC\");'>");

					} else {

						if (vo.getOrderby().equals(
								order_by_Array[orderHead + 1] + " DESC")) {

							data
									.append("<TD  WIDTH='"
											+ size_percent
											+ "%'><B>"
											+ columnName
											+ "</B><img style='CURSOR:POINTER' src='../../hisglobal/images/arr-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
											+ order_by_Array[orderHead + 1]
											+ " ASC\");'>"
											+ "<img style='CURSOR:POINTER' src='../../hisglobal/images/arrdouble-down.png' width='12px' TITLE='Descending Order' onClick='sortData(\""
											+ order_by_Array[orderHead + 1]
											+ " DESC\");'>");

						} else {
							data
									.append("<TD  WIDTH='"
											+ size_percent
											+ "%'><B>"
											+ columnName
											+ "</B><img style='CURSOR:POINTER' src='../../hisglobal/images/arr-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
											+ order_by_Array[orderHead + 1]
											+ " ASC\");'>"
											+ "<img style='CURSOR:POINTER' src='../../hisglobal/images/arr-dwn.png' width='12px'  TITLE='Descending Order' onClick='sortData(\""
											+ order_by_Array[orderHead + 1]
											+ " DESC\");'>");
						}
					}
				} else {
					data.append("<TD  WIDTH='" + size_percent
							+ "%'><B>" + columnName
							+ "</B>	</TD>");
				}

			}

			//data.append("</TR></TABLE><TABLE WIDTH='100%' CELLSPACING='0px' CELLPADDING='0px'><TR><TD CLASS='TDFONT'>");
			data.append("</TR>");

		} catch (Exception e) {
			vo.setStrMsgString("GenericHLP.getColoumnHeaderString --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

		coulmn_header = null;

		return data.toString();

	}
	
	public String getColoumnHeaderStringNewDtTbl(String[] columnHdr, GenericVO vo,
			String[] orderby) {

		StringBuilder data = new StringBuilder(300);
		String coulmn_header[] = columnHdr;

		int coulmn_header_length = coulmn_header.length;
		int size_percent = 100 / coulmn_header_length;
		int flag = 0;
		String columnName="";
		String order_by_Array[] = orderby;
		int order_length = order_by_Array.length;
		int orderHead = 0;

		try {
			data
					.append("<TD class='no-sort'></TD>");//<INPUT TYPE='CHECKBOX' NAME='chkmain' onclick='isCheckedFirst(this),chkUserFunc(this);;'>

			/*
			 * for (int columnHead = 0; columnHead < coulmn_header_length;
			 * columnHead++) { flag = 0; data.append("<TD CLASS=TDFONTHEAD
			 * WIDTH='" + size_percent + "%'><B>" + coulmn_header[columnHead] + "</B>
			 * </TD>"); }
			 */
			for (int columnHead = 0; columnHead < coulmn_header_length; columnHead++) 
			{
				flag = 0;
				for (orderHead = 0; orderHead < order_length; orderHead = orderHead + 2) 
				{
					//System.out.println("orderHead-----"+Integer.parseInt(order_by_Array[orderHead]));
					//System.out.println("columnHead-----"+columnHead);
					if ((Integer.parseInt(order_by_Array[orderHead]) - 1) == columnHead) 
					{
						flag = 1;
						break;
					}
				}
				//System.out.println("coulmn_header[columnHead]-----"+coulmn_header[columnHead]);
				
				if(coulmn_header[columnHead].replace("^","#").split("#").length>=2)
				{
					size_percent=Integer.parseInt(coulmn_header[columnHead].replace("^","#").split("#")[1]);
					columnName=coulmn_header[columnHead].replace("^","#").split("#")[0];
				}
				else
				{
					columnName=coulmn_header[columnHead];
				}
				
				//System.out.println("flag-----"+flag);
				
				if (flag == 1) 
				{
					
					//System.out.println("vo.getOrderby()-----"+vo.getOrderby());

					if (vo.getOrderby().equals(
							order_by_Array[orderHead + 1] + " DESC")) 
					{

						data
								.append("<TD><B>" //WIDTH='" + size_percent + "%'
										+ columnName
										+ "</B>"
										+ "");
						
						//System.out.println("columnName--ASC---"+columnName);

					} else {

						if (vo.getOrderby().equals(
								order_by_Array[orderHead + 1] + " DESC")) {

							data
									.append("<TD><B>" //WIDTH='" + size_percent + "%'
											+ columnName
											+ "</B>");
							
							//System.out.println("columnName--DESC---"+columnName);

						} else {
							data
									.append("<TD><B>" //WIDTH='" + size_percent + "%'
											+ columnName
											+ "</B>"
											+ "");
							
							//System.out.println("columnName--ELSE---"+columnName);
						}
					}
				} else {
					data.append("<TD><B>" + columnName  //WIDTH='" + size_percent + "%'
							+ "</B>	</TD>");
				}

			}

			//data.append("</TR></TABLE><TABLE WIDTH='100%' CELLSPACING='0px' CELLPADDING='0px'><TR><TD CLASS='TDFONT'>");
			data.append("</TR>");

		} catch (Exception e) {
			vo.setStrMsgString("GenericHLP.getColoumnHeaderString --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

		coulmn_header = null;

		return data.toString();

	}
	
	
	public String getColoumnChecBoxHeaderString(String[] columnHdr, GenericVO vo,
			String[] orderby) {

		StringBuilder data = new StringBuilder(300);
		String coulmn_header[] = columnHdr;

		int coulmn_header_length = coulmn_header.length;
		int size_percent = 100 / coulmn_header_length;
		int flag = 0;
		String columnName="";
		String order_by_Array[] = orderby;
		int order_length = order_by_Array.length;
		int orderHead = 0;

		try {
			//data.append("<TD CLASS='TDFONTHEAD'><INPUT TYPE='CHECKBOX' NAME='chkmain' onclick='isCheckedFirst(this),chkUserFunc(this);;'></TD>");
			data.append("<TR>");

			/*
			 * for (int columnHead = 0; columnHead < coulmn_header_length;
			 * columnHead++) { flag = 0; data.append("<TD CLASS=TDFONTHEAD
			 * WIDTH='" + size_percent + "%'><B>" + coulmn_header[columnHead] + "</B>
			 * </TD>"); }
			 */
			for (int columnHead = 0; columnHead < coulmn_header_length; columnHead++) {
				flag = 0;
				for (orderHead = 0; orderHead < order_length; orderHead = orderHead + 2) {
					if ((Integer.parseInt(order_by_Array[orderHead]) - 1) == columnHead) {
						flag = 1;
						break;
					}
				}
				if(coulmn_header[columnHead].replace("^","#").split("#").length>=2)
				{
					size_percent=Integer.parseInt(coulmn_header[columnHead].replace("^","#").split("#")[1]);
					columnName=coulmn_header[columnHead].replace("^","#").split("#")[0];
				}
				else
				{
					columnName=coulmn_header[columnHead];
				}
				if (flag == 1) {

					if (vo.getOrderby().equals(
							order_by_Array[orderHead + 1] + " ASC")) {

						data
								.append("<TD CLASS=TDFONTHEAD WIDTH='"
										+ size_percent
										+ "%'><B>"
										+ columnName
										+ "</B><img style='CURSOR:POINTER' src='../../hisglobal/images/arrdouble-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
										+ order_by_Array[orderHead + 1]
										+ " ASC\");'>"
										+ "<img style='CURSOR:POINTER' src='../../hisglobal/images/arr-dwn.png' width='12px' TITLE='Descending Order' onClick='sortData(\""
										+ order_by_Array[orderHead + 1]
										+ " DESC\");'>");

					} else {

						if (vo.getOrderby().equals(
								order_by_Array[orderHead + 1] + " DESC")) {

							data
									.append("<TD  CLASS=TDFONTHEAD WIDTH='"
											+ size_percent
											+ "%'><B>"
											+ columnName
											+ "</B><img style='CURSOR:POINTER' src='../../hisglobal/images/arr-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
											+ order_by_Array[orderHead + 1]
											+ " ASC\");'>"
											+ "<img style='CURSOR:POINTER' src='../../hisglobal/images/arrdouble-down.png' width='12px' TITLE='Descending Order' onClick='sortData(\""
											+ order_by_Array[orderHead + 1]
											+ " DESC\");'>");

						} else {
							data
									.append("<TD  CLASS=TDFONTHEAD WIDTH='"
											+ size_percent
											+ "%'><B>"
											+ columnName
											+ "</B><img style='CURSOR:POINTER' src='../../hisglobal/images/arr-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
											+ order_by_Array[orderHead + 1]
											+ " ASC\");'>"
											+ "<img style='CURSOR:POINTER' src='../../hisglobal/images/arr-dwn.png' width='12px'  TITLE='Descending Order' onClick='sortData(\""
											+ order_by_Array[orderHead + 1]
											+ " DESC\");'>");
						}
					}
				} else {
					data.append("<TD  CLASS=TDFONTHEAD WIDTH='" + size_percent
							+ "%'><B>" + columnName
							+ "</B>	</TD>");
				}

			}

			//data.append("</TR></TABLE><TABLE WIDTH='100%' CELLSPACING='0px' CELLPADDING='0px'><TR><TD CLASS='TDFONT'>");
			data.append("</TR>");

		} catch (Exception e) {
			vo.setStrMsgString("GenericHLP.getColoumnHeaderString --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

		coulmn_header = null;

		return data.toString();

	}

	/*
	 * getQueryData(WebRowSet rowset, int size_percent, int minRow) function
	 * makes the data row for list page
	 * 
	 */

	public String getQueryData(WebRowSet rowset, int size_percent, int minRow,
			String eventState, String[] rowStatus, GenericVO vo,String[] columnHdr,String[] ordrBy) {
		int k = 1;
		int j = 1;
		int temp = 0;
		int nI = 0;
		boolean flag = false;
		String coulmn_header[] = columnHdr;
		// String[] strTempArray = new String[no_of_column+1];
		StringBuilder dataBuffer = new StringBuilder(300);

		StringBuilder dataBuffer1 = new StringBuilder(300);
		StringBuilder dataBuffer2 = new StringBuilder(300);
		
		String tempStr = "";
		String[] tempArray;
		String[] tempArray1;

		String rowClassName = "class = 'ONMOUSEOUT1'";

		try {
			while (rowset.next()) {

				flag = false;
				rowClassName = "class = 'ONMOUSEOUT1'";

				tempStr = String.valueOf(rowset.getString(1));
				String tempStr1 = tempStr.replace('^', '#');
				tempArray1 = tempStr1.split("#");

				if (!tempStr1.endsWith("#")) // if last value is null then it
					// can not be split..
					tempArray = tempArray1;
				else {
					tempArray = new String[tempArray1.length + 1];
					for (int i = 0; i < tempArray1.length; i++)
						tempArray[i] = tempArray1[i];

					tempArray[tempArray1.length] = "";
				}
					
				/*
				 * for(nI=0;nI<strTempArray.length;nI++){ strTempArray[nI] =
				 * String.valueOf(rowset.getString(nI+1)); }
				 */
				String str=getColoumnHeaderString(columnHdr, vo, ordrBy);
				if (temp % rec_per_page == 0) 
				{
					String idvalue = "a" + j;
					j++;

					if (idvalue.equals("a1"))
						dataBuffer.append("<DIV ID='"+ idvalue+ "' STYLE='DISPLAY:BLOCK;' class='wrapper rounded'><TABLE width='100%' bgcolor='#6097BC' cellspacing='1px'><TR class='TRFONTHEAD'>"+str+"");
					else
						dataBuffer.append("<DIV ID='"+ idvalue+ "' STYLE='DISPLAY:NONE;' class='wrapper rounded'><TABLE width='100%' bgcolor='#6097BC' cellspacing='1px'><TR class='TRFONTHEAD'>"+str+"");
				}
				if (eventState == null)
					eventState = "";
				
				for (int r = 0; r < rowStatus.length; r += 4) 
				{
					// if (strTempArray[Integer.parseInt(rowStatus[r + 1]) -
					// 1].equalsIgnoreCase(rowStatus[r]))
					if (tempArray[Integer.parseInt(rowStatus[r + 1]) - 1]
							.equalsIgnoreCase(rowStatus[r])) {
						flag = true;
						rowClassName = "class = 'ONMOUSEOUT1match' bgcolor = '"
								+ rowStatus[r + 2] + "'";
						//break;
					} else {
						if ((r + 4 == rowStatus.length) && (flag != true))
							flag = false;
						//break;
					}

				}
				for (int m = 0; m < no_of_column; m++) {
				if(coulmn_header[m].replace("^","#").split("#").length>=2)
				{
					size_percent=Integer.parseInt(coulmn_header[m].replace("^","#").split("#")[1]);
				}
				

					if (m == 0) {
						if (flag) {

							dataBuffer.append("<TR ID='tr" + k + "' "
									+ rowClassName + " >");
						} else {

							dataBuffer.append("<TR ID='tr" + k + "' "
									+ rowClassName
									+ " onMouseOver='changeColor(this," + k
									+ ",0);' onMouseOut='changeColor(this," + k
									+ ",1);' >");
						}

						dataBuffer.append("<TD><INPUT TYPE='CHECKBOX' VALUE='"
								+ tempArray[0] + "$" + (k)
								+ "' NAME='chk' onClick=\"chkFunc(event,this,'"
								+ eventState + "'),chkUserFunc(this);\"></TD>");
						k++;
					}

					dataBuffer.append("<TD  WIDTH='" + size_percent
							+ "%'>&nbsp;" + tempArray[m + 1] + "</TD>");
				}

				dataBuffer.append("</tr>");

				if (temp % rec_per_page == rec_per_page - 1)
					dataBuffer.append("</TABLE></DIV>");					
				temp++;
			}

			if ((temp - 1) % rec_per_page != rec_per_page - 1)
				dataBuffer.append("</TABLE></DIV>");			

		} catch (Exception e) {
			vo.setStrMsgType("1");
			vo.setStrMsgString("GenericHLP.getQueryData --> " + e.getMessage());
		} finally {
			tempArray = null;
			tempArray1 = null;
		}

		return dataBuffer.toString();
	}
	// ---- Data Table 
	public String getQueryDataNewDtTbl(WebRowSet rowset, int size_percent, int minRow,
			String eventState, String[] rowStatus, GenericVO vo,String[] columnHdr,String[] ordrBy) {
		int k = 1;
		int j = 1;
		int temp = 0;
		int nI = 0;
		boolean flag = false;
		String coulmn_header[] = columnHdr;
		// String[] strTempArray = new String[no_of_column+1];
		StringBuilder dataBuffer = new StringBuilder(300);

		StringBuilder dataBuffer1 = new StringBuilder(300);
		StringBuilder dataBuffer2 = new StringBuilder(300);
		
		String tempStr = "";
		String[] tempArray;
		String[] tempArray1;

		String rowClassName = "class = 'ROWFONT'";

		try {

			String str=getColoumnHeaderStringNewDtTbl(columnHdr, vo, ordrBy);
			dataBuffer.append("<DIV STYLE='DISPLAY:BLOCK;' class='wrapper rounded'><TABLE class='table table-condensed table-hover' id='mainTablea1' width='100%' bgcolor='#6097BC' cellspacing='1px'><thead style='background-color: #337ab7;color: white;'><TR class='TRFONTHEAD'>"+str+"</thead><tbody>");
			while (rowset.next()) {

				flag = false;
				rowClassName = "class = 'ROWFONT'";

				tempStr = String.valueOf(rowset.getString(1));
				String tempStr1 = tempStr.replace('^', '#');
				tempArray1 = tempStr1.split("#");

				if (!tempStr1.endsWith("#")) // if last value is null then it
					// can not be split..
					tempArray = tempArray1;
				else {
					tempArray = new String[tempArray1.length + 1];
					for (int i = 0; i < tempArray1.length; i++)
						tempArray[i] = tempArray1[i];

					tempArray[tempArray1.length] = "";
				}
					
				/*
				 * for(nI=0;nI<strTempArray.length;nI++){ strTempArray[nI] =
				 * String.valueOf(rowset.getString(nI+1)); }
				 */
				if (temp % rec_per_page == 0) 
				{
					String idvalue = "a" + j;
					j++; 
				}
				if (eventState == null)
					eventState = "";
				
				for (int r = 0; r < rowStatus.length; r += 4) 
				{
					// if (strTempArray[Integer.parseInt(rowStatus[r + 1]) -
					// 1].equalsIgnoreCase(rowStatus[r]))
					if (tempArray[Integer.parseInt(rowStatus[r + 1]) - 1]
							.equalsIgnoreCase(rowStatus[r])) {
						flag = true;
						rowClassName = "class = 'rowfontmatch' bgcolor = '"
								+ rowStatus[r + 2] + "'";
						//break;
					} else {
						if ((r + 4 == rowStatus.length) && (flag != true))
							flag = false;
						//break;
					}

				}
				for (int m = 0; m < no_of_column; m++) {
				if(coulmn_header[m].replace("^","#").split("#").length>=2)
				{
					size_percent=Integer.parseInt(coulmn_header[m].replace("^","#").split("#")[1]);
				}
				

					if (m == 0) {
						if (flag) {

							dataBuffer.append("<TR ID='tr" + k + "' "
									+ rowClassName + " >");
						} else {

							dataBuffer.append("<TR ID='tr" + k + "' "
									+ rowClassName
									+ " onMouseOver='changeColor(this," + k
									+ ",0);' onMouseOut='changeColor(this," + k
									+ ",1);' >");
						}

						dataBuffer.append("<TD><INPUT TYPE='CHECKBOX' VALUE='"
								+ tempArray[0] + "$" + (k)
								+ "' NAME='chk' onClick=\"chkFunc(event,this,'"
								+ eventState + "'),chkUserFunc(this);\"></TD>");
						k++;
					}

					dataBuffer.append("<TD>&nbsp;" + tempArray[m + 1] + "</TD>"); //WIDTH='" + size_percent + "%'
				}

				dataBuffer.append("</tr>");

				/*if (temp % rec_per_page == rec_per_page - 1)
					dataBuffer.append("</tbody></TABLE></DIV>");	*/				
				temp++;
			}

			//if ((temp - 1) % rec_per_page != rec_per_page - 1)
				dataBuffer.append("</tbody></TABLE></DIV>");			

		} catch (Exception e) {
			vo.setStrMsgType("1");
			vo.setStrMsgString("GenericHLP.getQueryData --> " + e.getMessage());
		} finally {
			tempArray = null;
			tempArray1 = null;
		}

		return dataBuffer.toString();
	}
	
	
	public String getCheckBoxData(WebRowSet rowset, int size_percent, int minRow,
			String eventState, String[] rowStatus, GenericVO vo,String[] columnHdr,String[] ordrBy) {
		int k = 1;
		int j = 1;
		int temp = 0;
		int nI = 0;
		boolean flag = false;
		String coulmn_header[] = columnHdr;
		// String[] strTempArray = new String[no_of_column+1];
		StringBuilder dataBuffer = new StringBuilder("");
		StringBuilder  dataBuffer1 = new StringBuilder("");
		StringBuilder dataBuffer2 = new StringBuilder("");
	
		

		
			dataBuffer1.append("<div style='padding-bottom:20px;white-space: nowrap;'><table cellpadding='1px' cellspacing='2px'>");
			
			
			dataBuffer2.append("<div style='width:570px; overflow-x:scroll ; overflow-y: hidden; padding-bottom:10px;white-space: nowrap;'><table cellpadding='1px' cellspacing='3px'>");
			
		
		String tempStr = "";
		String[] tempArray;
		String[] tempArray1;

		String rowClassName = "class = 'ONMOUSEOUT1'";
		int count=1;
		int count2=1;
		try {
			while (rowset.next()) {

				flag = false;
				rowClassName = "class = 'ONMOUSEOUT1'";

				tempStr = String.valueOf(rowset.getString(1));
				String tempStr1 = tempStr.replace('^', '#');
				tempArray1 = tempStr1.split("#");

				if (!tempStr1.endsWith("#")) // if last value is null then it
					// can not be split..
					tempArray = tempArray1;
				else {
					tempArray = new String[tempArray1.length + 1];
					for (int i = 0; i < tempArray1.length; i++)
						tempArray[i] = tempArray1[i];

					tempArray[tempArray1.length] = "";
				}
					
				/*
				 * for(nI=0;nI<strTempArray.length;nI++){ strTempArray[nI] =
				 * String.valueOf(rowset.getString(nI+1)); }
				 */
				String str=getColoumnChecBoxHeaderString(columnHdr, vo, ordrBy);
				if (temp % rec_per_page == 0) {
					String idvalue = "a" + j;
					j++;

					if (idvalue.equals("a1"))
						dataBuffer
								.append("<DIV ID='"
										+ idvalue
										+ "' STYLE='DISPLAY:BLOCK;position:relative'><TABLE width='100%' bgcolor='white'><TR><TD>");
					else
						dataBuffer
								.append("<DIV ID='"
										+ idvalue
										+ "' STYLE='DISPLAY:NONE;position:relative'><TABLE width='100%' bgcolor='white'><TR><TD>");

				}
				
				
				
				if (eventState == null)
					eventState = "";
				
				for (int r = 0; r < rowStatus.length; r += 4) {
					// if (strTempArray[Integer.parseInt(rowStatus[r + 1]) -
					// 1].equalsIgnoreCase(rowStatus[r]))
					if (tempArray[Integer.parseInt(rowStatus[r + 1]) - 1]
							.equalsIgnoreCase(rowStatus[r])) {
						flag = true;
						rowClassName = "class = 'ONMOUSEOUT1match' bgcolor = '"
								+ rowStatus[r + 2] + "'";
						//break;
					} else {
						if ((r + 4 == rowStatus.length) && (flag != true))
							flag = false;
						//break;
					}

				}
				
				for (int m = 0; m < no_of_column; m++) {
				if(coulmn_header[m].replace("^","#").split("#").length>=2)
				{
					size_percent=Integer.parseInt(coulmn_header[m].replace("^","#").split("#")[1]);
				}
				

					if (m == 0) {
						if(count==1)
						{
							dataBuffer1.append("<TR><TD CLASS='TDFONTHEAD'><INPUT TYPE='CHECKBOX' NAME='chkmain' onclick='isCheckedFirst(this),chkUserFunc(this);;'></TD></TR>");
							count=0;
						}
						if (flag) {

							dataBuffer1.append("<TR ID='tr" + k + "' "
									+ rowClassName + " >");
						} else {

							dataBuffer1.append("<TR ID='tr" + k + "' "
									+ rowClassName
									+ " onMouseOver='changeColor(this," + k
									+ ",0);' onMouseOut='changeColor(this," + k
									+ ",1);' >");
						}
						

						dataBuffer1.append("<TD><INPUT TYPE='CHECKBOX' VALUE='"
								+ tempArray[0] + "$" + (k)
								+ "' NAME='chk' onClick=\"chkFunc(event,this,'"
								+ eventState + "'),chkUserFunc(this);\"></TD>");
						k++;
						
						dataBuffer1.append("</tr>");
					}else{
						
						if(count2==1)
						{
							dataBuffer2.append(str);
							count2=0;
						}
						if (m == 1) {
							
							if (flag) {

								dataBuffer2.append("<TR ID='tr" + k + "' "
										+ rowClassName + " >");
							} else {

								dataBuffer2.append("<TR ID='tr" + k + "' "
										+ rowClassName
										+ " onMouseOver='changeColor(this," + k
										+ ",0);' onMouseOut='changeColor(this," + k
										+ ",1);' >");
							}
							
						} 
						
						
						dataBuffer2.append("<TD WIDTH='" + size_percent
								+ "%'>&nbsp;" + tempArray[m + 1] + "</TD>");
						
					}

					
				}
				dataBuffer2.append("</tr>");
			
				
				if (temp % rec_per_page == rec_per_page - 1){
					
					dataBuffer1.append("</TABLE></DIV></TD>");	
					dataBuffer2.append("</TABLE></DIV></TD>");	
					
					
					dataBuffer.append(dataBuffer1.toString()).append("<TD>").append(dataBuffer2.toString());
					dataBuffer.append("</TR></TABLE></DIV>");					
			
					//System.out.println("buffer 1 :: "+dataBuffer1.toString());
					
					//System.out.println("\n\nbuffer 2 :: "+dataBuffer2.toString());
					
								
					//System.out.println("\n\nbuffer :: "+dataBuffer.toString());
					
					dataBuffer1 = new StringBuilder("");
					dataBuffer2 = new StringBuilder("");
					
				}
				
				temp++;
			}

			if ((temp - 1) % rec_per_page != rec_per_page - 1){
				
				if(dataBuffer1 != null){
					dataBuffer1.append("</TABLE></DIV></TD>");	
					dataBuffer2.append("</TABLE></DIV></TD>");	
					
					//System.out.println("buffer 1 :: "+dataBuffer1.toString());
					
					//System.out.println("\n\nbuffer 2 :: "+dataBuffer2.toString());
					
					dataBuffer.append(dataBuffer1.toString()).append(dataBuffer2.toString());
					
					//System.out.println("\n\nbuffer :: "+dataBuffer.toString());
					
					dataBuffer1 = new StringBuilder("");
					dataBuffer2 = new StringBuilder("");
					
				}
		
				dataBuffer.append("</TABLE></DIV>");	
				
			}
				
				 

		} catch (Exception e) {
			vo.setStrMsgType("1");
			vo.setStrMsgString("GenericHLP.getQueryData --> " + e.getMessage());
		} finally {
			tempArray = null;
			tempArray1 = null;
		}

		return dataBuffer.toString();
	}

	/*
	 * getSearchRowString() method make search row and search combo box
	 */

	public String getSearchRowString(GenericVO vo, int minrow, int max_rownum,
			int blockNo, int total_page, String[] searchFld,
			String[] columnHdr, int pagePerBlock, String masterName,
			String menuOption, List viewHdr) {

		StringBuilder br = new StringBuilder(200);
		String selectSearchValue = "";
		String search = "";
		String searchColumn = "";
		String columnName="";
		try {
			search = vo.getSearch();
			searchColumn = vo.getSearchColumn();

			if (search != null && !search.equals("null") && !search.equals(""))
				selectSearchValue = search;
			if (menuOption.equalsIgnoreCase("frames")) 
			{
				br.append("####<TABLE WIDTH = '100%' ALIGN='CENTER' BORDER='0' cellspacing='0' cellpadding='0' style='border: 1px solid #013157; border-collapse: collapse;'>");
			} 
			else 
			{
				br.append("####<TABLE WIDTH = '100%' ALIGN='CENTER' BORDER='0' cellspacing='0' cellpadding='0'  style='border: 1px solid #013157; border-collapse: collapse;'>");
			}

			if(vo.getStrHelpData()!=null && !vo.getStrHelpData().equals("") )
				br.append("<TR><TD CLASS='TDSEARCH' WIDTH='60%'><DIV ALIGN='LEFT' style='vertical-align: middle;'>Help: "+vo.getStrHelpData()+"</TD>");
			else
				br.append("<TR><TD CLASS='TDSEARCH' WIDTH='60%'><DIV ALIGN='LEFT' style='vertical-align: middle;'></TD>");
			br.append("<TD CLASS='TDSEARCH' WIDTH='25%'><DIV ALIGN='RIGHT' style='vertical-align: middle'> Search By&nbsp;&nbsp;");
			br.append("<SELECT  name='searchColumn' CLASS='CB1' >");
			for (int i = 0; i < searchFld.length; i += 2) 
			{
				if(columnHdr[(Integer.parseInt(searchFld[i]) - 1)].replace("^","#").split("#").length>=2)
				{
					columnName=columnHdr[(Integer.parseInt(searchFld[i]) - 1)].replace("^","#").split("#")[0];
					
				}
				else
				{
					columnName=columnHdr[(Integer.parseInt(searchFld[i]) - 1)];
				}
				if (searchFld[i + 1].equals(searchColumn)) 
				{
					br.append("<OPTION SELECTED VALUE='" + searchFld[i + 1]+ "'>");					
					br.append(columnName+"</OPTION>");

				} 
				else
					br.append("<OPTION VALUE='" + searchFld[i + 1] + "'>"+ columnName+ "</OPTION>");
			}

			br.append("</select>&nbsp;");
			br.append("<input class = 'TEXTBOX1' type='text' name='search' value='"+ selectSearchValue+ "' onkeyup='this.value=this.value.replace(/^\\s+/,\"\");' onKeyPress='if(event.keyCode==13) return searchpage();'>");
			br.append("&nbsp;&nbsp;&nbsp;<A STYLE='CURSOR:POINTER'><IMG SRC='/INVMGM/hisglobal/transactionutil/images/search_icon1.gif' alt='Click To Search Records' onClick='searchpage();' tabindex='0' onKeyPress='if(event.keyCode==13) searchpage();'></A></DIV></TD></TR>");
			br.append("<INPUT TYPE='HIDDEN' NAME='minrow' VALUE='" + minrow	+ "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='max_rownum' VALUE='"+ max_rownum + "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='page_par_block' VALUE='"+ pagePerBlock + "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='masterName' VALUE='"+ masterName + "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='blockNo' VALUE='" + blockNo+ "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='view_row_length' VALUE='"	+ ((viewHdr.size()) / 2) + "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='orderby' VALUE='"	+ vo.getOrderby() + "'>");
			br.append("</TABLE>");

		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GenericHLP.getSearchRowString() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}

		return br.toString();

	}

	/*
	 * getTotalBlock() function return the total block and next and previous
	 * values at list page with link
	 * 
	 */

	public String getTotalBlock(int nextpage_no, int total_page,int max_rownum, int minrow, int blockNo, String colorNextPrev,GenericVO vo) 
	{
		char temp1 = 'a';
		int t = 1;
		int temp = 1;
		int actual_page_block = getActualBlock(total_page);
		StringBuilder data = new StringBuilder(300);
		int tempNextPageNo=nextpage_no;
		
		try 
		{
			if (blockNo != 1)
				data.append("<A STYLE='CURSOR:POINTER' onClick=fetchRecords('m^"+ (blockNo - 1)+ "^0',"	+ (minrow)+ ",'2')><B><FONT COLOR='"+ colorNextPrev+ "'>Previous</FONT></B></A> ");
			
			for (int k = 1; k <= total_page; k++) 
			{
				if (actual_page_block > 1) 
				{
					if (t > page_per_block && nextpage_no<=total_page) 
					{
						data.append("<A  STYLE='CURSOR:POINTER' onClick=fetchRecords('m^"+ (++blockNo)+ "^"+ k+ "','"+ (max_rownum - 1)+ "','1')><B><FONT COLOR='"+ colorNextPrev+ "'>Next</FONT></B></A> ");
						data.append("</TR></TD></DIV>");
						break;
					} 
					else if (nextpage_no<=total_page) 
					{
						data.append("<A ID='bb"+ temp1+ ""+ k+ "' STYLE='CURSOR:POINTER' onClick=changeDiv('"+ temp1 + "" + k + "')><B><U>"+ nextpage_no + "</U></B></A> ");
						nextpage_no++;
						temp++;
						t++;
					}
				} 
				else 
				{
					data.append("<A ID='bb" + temp1 + "" + k+ "' STYLE='CURSOR:POINTER' onClick=changeDiv('"+ temp1 + "" + k + "')><B><U> " + nextpage_no+ "</U></B></A> ");
					temp++;
					nextpage_no++;
				}			
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GenericHLP.getTotalBlock -->" + e.getMessage());
			vo.setStrMsgType("1");
		}

		return data.toString();
	}

	

	public String getTotalBlockDtTbl(int nextpage_no, int total_page,int max_rownum, int minrow, int blockNo, String colorNextPrev,GenericVO vo) 
	{
		char temp1 = 'a';
		int t = 1;
		int temp = 1;
		int actual_page_block = getActualBlock(total_page);
		StringBuilder data = new StringBuilder(300);
		int tempNextPageNo=nextpage_no;
		
		try 
		{
			if (blockNo != 1)
				data.append("<A class='btn btn-sm btn-primary prevPageBtn' style='margin=5px 5px;' onClick=fetchRecords('m^"+ (blockNo - 1)+ "^0',"	+ (minrow)+ ",'2')><B><FONT COLOR='"+ colorNextPrev+ "'><span class='glyphicon glyphicon-chevron-left'></span> Latest</FONT></B></A> ");
			
			data.append("<font class='sectionName' style='font-size:13px;font-weight:bold;'> Section "+blockNo+" </font> ");
			
			for (int k = 1; k <= total_page; k++) 
			{
				if (actual_page_block > 1) 
				{
					if (t > page_per_block && nextpage_no<=total_page) 
					{
						data.append("<A class='btn btn-sm btn-primary prevPageBtn' style='margin=5px 5px;' onClick=fetchRecords('m^"+ (++blockNo)+ "^"+ k+ "','"+ (max_rownum - 1)+ "','1')><B><FONT COLOR='"+ colorNextPrev+ "'>Older <span class='glyphicon glyphicon-chevron-right'></span></FONT></B></A> ");
						data.append("</TR></TD></DIV>");
						break;
					} 
					else if (nextpage_no<=total_page) 
					{
						//data.append("<A ID='bb"+ temp1+ ""+ k+ "' STYLE='CURSOR:POINTER' onClick=changeDiv('"+ temp1 + "" + k + "')><B><U>"+ nextpage_no + "</U></B></A> ");
						nextpage_no++;
						temp++;
						t++;
					}
				} 
				else 
				{
					//data.append("<A ID='bb" + temp1 + "" + k+ "' STYLE='CURSOR:POINTER' onClick=changeDiv('"+ temp1 + "" + k + "')><B><U> " + nextpage_no+ "</U></B></A> ");
					temp++;
					nextpage_no++;
				}			
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GenericHLP.getTotalBlock -->" + e.getMessage());
			vo.setStrMsgType("1");
		}

		return data.toString();
	}
	/*
	 * getActualBlock(int total_page) function returns actual numbers of block
	 * to be made and it will return actual block
	 * 
	 */

	public int getActualBlock(int total_page) {
		int actual_page_block = 0;
		actual_page_block = total_page / page_per_block;
		if (total_page % page_per_block != 0)
			actual_page_block++;
		return actual_page_block;
	}

	/*
	 * getButtonLayOut() method returns button panel for the list page. mode -
	 * it is an int type argument. if user asks to create panel on both sides,
	 * then using this mode we separate buttons for both panels.
	 */
	public String getButtonLayOut1(String[] userDefinedButton,String menuOption, String buttonConfig, int minPanelButton,int recPerPage, GenericVO vo, String[] dbButtons,String[] buttonIcons) 
	{
		//System.out.println("BUtton Lay Out1");
		StringBuffer sb = new StringBuffer("");
		StringBuffer footer = new StringBuffer("");
		String header = "";
		int count = 0;
		int nTableCount = 0;
		String[] strButtonTableEvent = new String[20];
		int avgButton = 0;
		int no_of_button = 0;
		boolean flag = false;
		String[] buttons = null;
		GenericBO bo = null;
		String strPrevStatus = "";
		String imageUrl="/INVMGM/hisglobal/transactionutil/images/icon-default.png";
		String[] buttonIconsFinal;
		try 
		{
			bo = new GenericBO();
			if (userDefinedButton == null) 
			{
				//System.out.println("Step 1");
				bo.getDBButtons(vo, (String) vo.getSession().getAttribute("SEATID"), (String) vo.getSession().getAttribute("HOSPITAL_CODE"), dbButtons[0]);
				userDefinedButton = vo.getStrDBButton();
				buttonConfig = userDefinedButton[0].split("@")[3];
				buttonIconsFinal=new String[userDefinedButton.length];
				for(int i=0;i<userDefinedButton.length;i++)
				{
					buttonIconsFinal[i] = "icon-default.png";
				}
			}
			if (userDefinedButton == null || userDefinedButton[0].split("@").length == 1) //If Database Buttons Then This condition becomes false bcoz userDefinedButton already  set in previous if
			{
				//System.out.println("Step 2"+userDefinedButton.length);
				//System.out.println("BUtton Lay Out1.1");
				if (userDefinedButton != null) 
				{
					//System.out.println("Step 3"+userDefinedButton.length);
					//System.out.println("BUtton Lay Out1.2");
					no_of_button = userDefinedButton.length;
					buttons = new String[userDefinedButton.length];
					buttons = userDefinedButton;
					buttonIconsFinal=buttonIcons;
				} 
				else 
				{
					//System.out.println("Step 4"+userDefinedButton.length);
					bo.getDBButtons(vo, (String) vo.getSession().getAttribute("SEATID"), (String) vo.getSession().getAttribute("HOSPITAL_CODE"), dbButtons[0]);
					dbButtons = vo.getStrDBButton();
					no_of_button = dbButtons.length;
					buttons = new String[dbButtons.length];
					buttons = dbButtons;
					buttonIconsFinal=new String[dbButtons.length];
					for(int i=0;i<dbButtons.length;i++)
					{
						buttonIconsFinal[i] = "icon-default.png";
					}
				}

				if (no_of_button % 2 == 0)
					avgButton = no_of_button / 2;
				else
					avgButton = (no_of_button / 2) + 1;

				/*if (menuOption.equalsIgnoreCase("tiles")) 
				{
					header += "<table width=\"100%\"  border=\"0\" cellpadding=\"1\" cellspacing=\"1\">";
					header += "<tr><td CLASS=\"TDCOMBOHEADER\"><div align='center'>Activity</div></td></tr></table>";
				} 
				else 
				{
					header += "<table width=\"100%\"  border=\"0\" cellpadding=\"1\" cellspacing=\"1\">";
					header += "<tr><td CLASS=\"TDCOMBOHEADER\"><div align='center'>Activity</div></td></tr></table>";
				}*/
				if (buttonConfig.equalsIgnoreCase("left") || buttonConfig.equalsIgnoreCase("right")) 
				{
					//System.out.println("BUtton Lay Out1.3");
					for (int i = 0; i < no_of_button; i++) 
					{
						nTableCount = 1;
						sb.append("<div id='buttonL1Id" + (i + 1)+ "' style='display:block'>");
						/*sb.append("<TABLE  width=\"100%\"  border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\""
										+ btnHeight
										+ "\" bgcolor=\""
										+ btnBgColor
										+ "\" style = \"border: '1px' 'outset'\" " +
												"onMouseDown=\"javascript:this.style.border = 'inset 1px';\" " +
												"onMouseUp=\"javascript:this.style.border = 'outset 1px'; \" " +
												"onMouseOver=\"javascript:this.style.border = '2px solid #3399CC'; \" tabindex='1' " +
												"onfocus=\"javascript:this.style.border = '2px solid #3399CC'; \" " +
												"onblur=\"javascript:this.style.border = 'outset 1px';  \" " +
												"onMouseOut=\"javascript:this.style.border = 'outset 1px';  \"><TR>");*/
						// sb.append("<div id='buttonL1Id"+(i+1)+"'
						// style='display:block'><TABLE class = 'BTNBG'
						// width=\"100%\" cellpadding=\"1\" cellspacing=\"1\"
						// onMouseDown=\"javascript:this.style.border = 'inset
						// 1px';\" onMouseUp=\"javascript:this.style.border =
						// 'outset 1px'; \"
						// onMouseOver=\"javascript:this.style.border = '2px
						// solid #3399CC'; \"
						// onMouseOut=\"javascript:this.style.border = 'outset
						// 1px'; \"><TR>");
						/*sb.append("<TD align=\"center\"><font color=\""	+ btnFontColor + "\">" + buttons[i]+ "</font></td>");
						sb.append("</TR></TABLE></div>");*/
						
						//System.out.println("BUtton Lay Out1");
						sb.append("<TABLE  width=\"100%\"  border=\"1\" cellpadding=\"1\" cellspacing=\"1\"><TR>");
						sb.append("<TD align=\"center\"><img style='width: 30px; height: 30px;' src='/HIS/hisglobal/images/icons/icon-econsulationbox.png' class='icon-imageVerySmallIcon' onmouseover='changeSize(this);' onmouseout='resetSize(this);'></font></td>");
						sb.append("</TR></TABLE></div>");
						
						
						count++;
						flag = true;
					}
				}
				if (buttonConfig.equalsIgnoreCase("both")) 
				{
					//System.out.println("BUtton Lay Out1.4");
					if (minPanelButton >= avgButton) 
					{
						for (int i = 0; i < minPanelButton; i++) 
						{
							sb.append("<div id='buttonLL1Id"
											+ (i + 1)
											+ "'  style='display:block'><TABLE id='buttonTab"
											+ i
											+ "' width=\"100%\"  border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\""
											+ btnHeight
											+ "\" bgcolor=\""
											+ btnBgColor
											+ "\" style = \"border: 'outset' '1px'\" onMouseDown=\"javascript:this.style.border = 'inset 1px'; \" onMouseUp=\"javascript:this.style.border = 'outset 1px'; \" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC'; \" onMouseOut=\"javascript:this.style.border = 'outset 1px';  \"><TR>");
							// sb.append("<div id='buttonLL1Id"+(i+1)+"'
							// style='display:block'><TABLE id='buttonTab"+i+"'
							// width=\"100%\" class = 'BTNBG' cellpadding=\"1\"
							// cellspacing=\"1\"
							// onMouseDown=\"javascript:this.style.border =
							// 'inset 1px'; \"
							// onMouseUp=\"javascript:this.style.border =
							// 'outset 1px'; \"
							// onMouseOver=\"javascript:this.style.border = '2px
							// solid #3399CC'; \"
							// onMouseOut=\"javascript:this.style.border =
							// 'outset 1px'; \"><TR>");
							sb.append("<TD align=\"center\"><font color=\""
									+ btnFontColor + "\">" + buttons[i]
									+ "</font></td>");
							sb.append("</TR></TABLE></div>");
							count++;
							flag = true;
						}
					} 
					else 
					{
						for (int i = 0; i < avgButton; i++) 
						{
							sb.append("<div id='buttonLL2Id"
											+ (i + 1)
											+ "' style='display:block'><TABLE id='buttonTab"
											+ i
											+ "' width=\"100%\"  border=\"1\" cellpadding=\"1\" cellspacing=\"1\" height=\""
											+ btnHeight
											+ "\" bgcolor=\""
											+ btnBgColor
											+ "\" style = \"border: 'outset' '1px'\" onMouseDown=\"javascript:this.style.border = 'inset 1px'; \" onMouseUp=\"javascript:this.style.border = 'outset 1px'; \" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC'; \" onMouseOut=\"javascript:this.style.border = 'outset 1px';  \"><TR>");
							// sb.append("<div id='buttonLL2Id"+(i+1)+"'
							// style='display:block'><TABLE id='buttonTab"+i+"'
							// width=\"100%\" class = 'BTNBG' cellpadding=\"1\"
							// cellspacing=\"1\"
							// onMouseDown=\"javascript:this.style.border =
							// 'inset 1px'; \"
							// onMouseUp=\"javascript:this.style.border =
							// 'outset 1px'; \"
							// onMouseOver=\"javascript:this.style.border = '2px
							// solid #3399CC'; \"
							// onMouseOut=\"javascript:this.style.border =
							// 'outset 1px'; \"><TR>");
							sb.append("<TD align=\"center\"><font color=\""	+ btnFontColor + "\">" + buttons[i]+ "</font></td>");
							sb.append("</TR></TABLE></div>");
							count++;
							flag = true;
						}
					}
				}
			} 
			else//Database Defined Buttons 
			{
				//System.out.println("Step 5 "+userDefinedButton.length);
				//System.out.println("BUtton Lay Out1.5");
				if (userDefinedButton != null) //If Database Buttons Then This condition becomes true bcoz userDefinedButton already  set in previous if
				{
					//System.out.println("Step 6 "+userDefinedButton.length);
					no_of_button = userDefinedButton.length;
					buttons = new String[userDefinedButton.length];
					buttons = userDefinedButton;
					if(buttonIcons.length==1 && buttonIcons[0].equals("icon-default.png"))
					{
						//System.out.println("Step 5.1 "+userDefinedButton.length);
						buttonIconsFinal=new String[userDefinedButton.length];
						for(int i=0;i<userDefinedButton.length;i++)
						{
							//System.out.println("loop"+i);
							buttonIconsFinal[i] = "icon-default.png";
						}
					}
					else
					{
						//System.out.println("Step 5.2 "+userDefinedButton.length);
						buttonIconsFinal=buttonIcons;
					}
				} 
				else 
				{
					//System.out.println("Step 7 "+userDefinedButton.length);
					no_of_button = dbButtons.length;
					buttons = new String[dbButtons.length];
					buttons = dbButtons;
					buttonIconsFinal=new String[dbButtons.length];
					for(int i=0;i<dbButtons.length;i++)
					{
						buttonIconsFinal[i] = "icon-default.png";
					}
				}

				if (no_of_button % 2 == 0)
					avgButton = no_of_button / 2;
				else
					avgButton = (no_of_button / 2) + 1;

				/*if (menuOption.equalsIgnoreCase("tiles")) 
				{
					header += "<table width=\"100%\"  border=\"1\" cellpadding=\"1\" cellspacing=\"1\">";
					header += "<tr><td CLASS=\"TDCOMBOHEADER\"><div align='center'>Activity</div></td></tr></table>";
				} 
				else 
				{
					header += "<table width=\"100%\"  border=\"1\" cellpadding=\"1\" cellspacing=\"1\">";
					header += "<tr><td CLASS=\"TDCOMBOHEADER\"><div align='center'>Activity</div></td></tr></table>";
				}*/
				if (buttonConfig.equalsIgnoreCase("left") || buttonConfig.equalsIgnoreCase("right")) 
				{
					//System.out.println("BUtton Lay Out1.6 ");
					sb.append("<div style='display:none;height: 35px;' id='menuTable1'>");
					sb.append("<TABLE  width=\"100%\">");
					sb.append("<tr><td height='20' align='right'>");
					for (int i = 0; i < no_of_button; i++) 
					{
						if (userDefinedButton[i].split("@").length == 5 && !strPrevStatus.equals(userDefinedButton[i].split("@")[4])) 
						{
							//System.out.println("BUtton Lay Out1.6.1");
							strButtonTableEvent[nTableCount++] = "" + i;
							/*sb.append("<div style='display:none;' id='menuTable"+ userDefinedButton[i].split("@")[4]+ "'>");
							//sb.append("<TABLE  width=\"100%\" bgcolor="+ btnBgColor + ">");
							sb.append("<TABLE  width=\"100%\">");*/
						} 
						else if (i == 0) 
						{
							//System.out.println("BUtton Lay Out1.6.2");
							nTableCount++;
							/*sb.append("<div style='display:none;' id='menuTable1'>");
							//sb.append("<TABLE  width=\"100%\" bgcolor="+ btnBgColor + ">");
							sb.append("<TABLE  width=\"100%\">");*/
						}
						//sb.append("<tr><td height='20'>");
						if (buttons[i].split("@")[2].equals("0")) 
						{
							//System.out.println("BUtton Lay Out1.6.3");
							
								
							if(buttonIconsFinal[i]!=null)
								imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];

							sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" class='btnParentDiv' style='display:inline;'>"); 
							/*sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:block'>");
							sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
							sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
							sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
							sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
							sb.append("onkeypress='onPressingEnter(this,event)' ");
							sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
							sb.append("</div>");
							sb.append("<div class='DIVLABELENABLE'>");
							sb.append(buttons[i].split("@")[0]);
							sb.append("</div>");
							sb.append("</div>");*/
							
							if(buttons[i].split("@").length>3)
							{ 
								sb.append("<button type='button' class='buttonsCls btn btn-sm' style='color:white;background-color:#"+buttons[i].split("@")[3]+"'");
							}
							else{ 
								sb.append("<button type='button' class='buttonsCls btn btn-sm btn-primary'");
							} 
							sb.append("onkeypress='onPressingEnter(this,event)' ");
							sb.append("onclick=\""); 
							sb.append((buttons[i].split("@")[1].equals("") ? "" : ""+ buttons[i].split("@")[1])+ ";\" >"); 
							sb.append("<span class='glyphicon "+(buttons[i].split("@").length>4 ? buttons[i].split("@")[4]:"")+"'></span> ");
							sb.append(buttons[i].split("@")[0]);
							sb.append("</button>");
							sb.append("</div>");
							
							sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" class='btnParentDiv' style='display: inline;'>");
							//sb.append("<button type='button' class='buttonsCls btn btn-sm btn-primary' disabled='true' style='display: none;'>");
							sb.append("<button type='button' class='buttonsCls btn btn-sm btn-primary' disabled='true' style=''>");
							sb.append(buttons[i].split("@")[0]);
							/*
							sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:none;'>");
							sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon' style='background-color: rgb(18, 109, 165);' align='left'>");
							sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
							sb.append("style='width: 30px; height: 30px;z-index:100;' ");
							//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
							//sb.append("onkeypress='onPressingEnter(this,event)' ");
							//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
							sb.append(">");
							sb.append("</div>");
							sb.append("<div class='DIVLABELDISABLE'>");
							sb.append(buttons[i].split("@")[0]);
							sb.append("</div>");*/
							sb.append("</button>");
							sb.append("</div>");
									
							/* Commented Bcoz getting Image Based Buttons in New Desk*/
							
							/*sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style=\"display:block\">");
							sb.append("<div  align=\"center\" id=\""+ buttons[i].split("@")[0]+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" ");
							sb.append("onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" tabindex=\"1\" ");
							sb.append("onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" class=\"m0l0oout\" ");
							sb.append("title=\""+ buttons[i].split("@")[0]+ "\" style=\"position:absolute;\" ");
									// width:" + btnWidth +"px;"
							sb.append("height:"+ btnHeight+ "px;z-index:100;cursor:pointer\"  onkeypress=\"onPressingEnter(this,event)\" ");
							sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" ");
							sb.append("onmousedown=\"javascript:this.className ='m0l0oover'\"  onmouseup=\"javascript:this.className ='m0l0ooout'\">");
							sb.append("<div id=\"eo__i\" class=\"logoutOver\">"+ buttons[i].split("@")[0]+ "</div></div></div>");
					
							sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style=\"display:none\">");
							sb.append("<div  align=\"center\" id=\""+ buttons[i].split("@")[0]+ "dis\" class=\"m0l0odis\" ");
							sb.append("title=\""+ buttons[i].split("@")[0]+ "\" style=\"position:absolute;\" ");
									// width:"
									// + btnWidth + "px;"
							sb.append("height:"+ btnHeight+ "px;z-index:100;\" >");
							sb.append("<div id=\"eo__i\" class=\"logoutOver\">"	+ buttons[i].split("@")[0]+ "</div></div></div>");*/
						} 
						else 
						{
							//System.out.println("BUtton Lay Out1.6.4");
							
							/* Commented Bcoz getting Image Based Buttons in New Desk*/
							
							/* sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style=\"display:none\">");
							sb.append("<div  align=\"center\" id=\""+ buttons[i].split("@")[0]+ "\" ");
							sb.append("onMouseOver=\"javascript:this.style.border = '2px solid #1272AD';\" ");
							sb.append("onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" tabindex=\"1\" ");
							sb.append("onfocus=\"javascript:this.style.border = '2px solid  #1272AD';\" ");
							sb.append("onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" ");
							sb.append("class=\"m0l0oout\" title=\""+ buttons[i].split("@")[0]+ "\" ");
							sb.append("style=\"position:absolute;"+ "height:"+ btnHeight+ "px;z-index:100;cursor:pointer\" ");
							sb.append("onkeypress=\"onPressingEnter(this,event)\"  ");
							sb.append("onclick=\"javascript:this.className ='m0l0oout'"+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" ");
							sb.append("onmousedown=\"javascript:this.className ='m0l0oover'\" ");
							sb.append("onmouseup=\"javascript:this.className ='m0l0ooout'\">");
							sb.append("<div id=\"eo__i\" class=\"logoutOver\">"	+ buttons[i].split("@")[0]+ "</div>");
							sb.append("</div>");
							sb.append("</div>");
							sb
									.append("<div id=\""
											+ buttons[i].split("@")[0]
											+ "disable\" style=\"display:block\"><div  align=\"center\" id=\""
											+ buttons[i].split("@")[0]
											+ "dis\" class=\"m0l0odis\" title=\""
											+ buttons[i].split("@")[0]
											+ "\" style=\"position:absolute;"// width:"
											// + btnWidth +"px;"
											+ "height:"
											+ btnHeight
											+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
											+ buttons[i].split("@")[0]
											+ "</div></div></div>");*/
							if(buttonIconsFinal[i]!=null)
								imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
							
							sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" class='btnParentDiv' style='display: none;'>");
							/*sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:none;'>");
							sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
							sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
							sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
							sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
							sb.append("onkeypress='onPressingEnter(this,event)' ");
							sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
							sb.append("</div>");
							sb.append("<div class='DIVLABELENABLE'>");
							sb.append(buttons[i].split("@")[0]);
							sb.append("</div>");
							sb.append("</div>");*/
							
							if(buttons[i].split("@").length>3)
							{ 
								sb.append("<button type='button' class='buttonsCls btn btn-sm' style='color:white;background-color:#"+buttons[i].split("@")[3]+"'");
							}
							else{ 
								sb.append("<button type='button' class='buttonsCls btn btn-sm btn-primary'");
							}
							//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
							sb.append("onkeypress='onPressingEnter(this,event)' ");
							sb.append("onclick=\"");
							//sb.append("javascript:this.className ='m0l0oout'");
							sb.append((buttons[i].split("@")[1].equals("") ? "" : ""+ buttons[i].split("@")[1])+ ";\" >");
							sb.append("<span class='glyphicon "+(buttons[i].split("@").length>4 ? buttons[i].split("@")[4]:"")+"'></span> ");
							sb.append(buttons[i].split("@")[0]);
							sb.append("</button>");
							sb.append("</div>");
							
							sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" class='btnParentDiv' style='display: inline;'>");
							//sb.append("<button type='button' class='buttonsCls btn btn-sm btn-primary' disabled='true' style='display: none;'>");
							sb.append("<button type='button' class='buttonsCls btn btn-sm btn-primary' disabled='true' style=''>");
							sb.append(buttons[i].split("@")[0]);
							
							/*sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:block;'>");
							sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon'  style='background-color: rgb(18, 109, 165);' align='left'>");
							sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
							sb.append("style='width: 30px; height: 30px;z-index:100;' ");
							//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
							//sb.append("onkeypress='onPressingEnter(this,event)' ");
							//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
							sb.append(">");
							sb.append("</div>");
							sb.append("<div class='DIVLABELDISABLE'>");
							sb.append(buttons[i].split("@")[0]);
							sb.append("</div>");*/
							sb.append("</button>");
							sb.append("</div>");
							
						}
						//sb.append("</td></TR>");
						count++;
						flag = true;
						if (userDefinedButton[i].split("@").length == 5)
							strPrevStatus = userDefinedButton[i].split("@")[4];
						/*if (userDefinedButton[i].split("@").length == 5 && (i == no_of_button - 1 || !(userDefinedButton[i].split("@")[4].equals(userDefinedButton[i + 1].split("@")[4])))) {
							sb.append("</TABLE>");
							sb.append("</div>");
						} 
						else if (i == no_of_button - 1) 
						{
							sb.append("</TABLE>");
							sb.append("</div>");
						}*/
					}
					sb.append("<div style='display:inline;'><button type='button' class='btn btn-sm btn-info' onclick='filterBlckTggl(this,event);'><span class='glyphicon glyphicon-filter'></span> Filter</button></div></td></TR>");
					sb.append("</TABLE><br>");
					sb.append("</div>");
					
				}
				if (buttonConfig.equalsIgnoreCase("both")) 
				{
					//System.out.println("BUtton Lay Out1.7");
					if (minPanelButton >= avgButton) 
					{
						sb.append("<TABLE  width=\"100%\">");
						for (int i = 0; i < minPanelButton; i++) 
						{
							sb.append("<div id='buttonLL1Id" + (i + 1)+ "'  style='display:block'>");
							sb.append("<tr><td height='20'>");
							if (buttons[i].split("@")[2].equals("0")) 
							{
								/* Commented Bcoz getting Image Based Buttons in New Desk*/
								
								/*sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "enable\" style=\"display:block\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" tabindex=\"1\" onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\"  class=\"m0l0oout\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;cursor:pointer\" onkeypress=\"onPressingEnter(this,event)\"  onclick=\"javascript:this.className ='m0l0oout'"
												+ (buttons[i].split("@")[1]
														.equals("") ? ""
														: ","
																+ buttons[i]
																		.split("@")[1])
												+ ";\" onmousedown=\"javascript:this.className ='m0l0oover'\" onmouseup=\"javascript:this.className ='m0l0ooout'\"><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");
								sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "disable\" style=\"display:none\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "dis\" class=\"m0l0odis\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");*/
								
								
								if(buttonIconsFinal[i]!=null)
									imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:block'>");
								sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
								sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								sb.append("onkeypress='onPressingEnter(this,event)' ");
								sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append("</div>");
								sb.append("<div class='DIVLABELENABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:none;'>");
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;' ");
								//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								//sb.append("onkeypress='onPressingEnter(this,event)' ");
								//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append(">");
								sb.append("</div>");
								sb.append("<div class='DIVLABELDISABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
							} 
							else 
							{
								/* Commented Bcoz getting Image Based Buttons in New Desk*/
								
								/*sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "enable\" style=\"display:none\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" tabindex=\"1\" onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\"  class=\"m0l0oout\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;cursor:pointer\" onkeypress=\"onPressingEnter(this,event)\"  onclick=\"javascript:this.className ='m0l0oout'"
												+ (buttons[i].split("@")[1]
														.equals("") ? ""
														: ","
																+ buttons[i]
																		.split("@")[1])
												+ ";\" onmousedown=\"javascript:this.className ='m0l0oover'\" onmouseup=\"javascript:this.className ='m0l0ooout'\"><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");
								sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "disable\" style=\"display:block\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "dis\" class=\"m0l0odis\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");*/
								
								
								if(buttonIconsFinal[i]!=null)
									imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:none;'>");
								sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
								sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								sb.append("onkeypress='onPressingEnter(this,event)' ");
								sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append("</div>");
								sb.append("<div class='DIVLABELENABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:block;'>");
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon'  style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;' ");
								//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								//sb.append("onkeypress='onPressingEnter(this,event)' ");
								//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append(">");
								sb.append("</div>");
								sb.append("<div class='DIVLABELDISABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
							}
							sb.append("</td></TR></div>");								
							count++;
							flag = true;
						}
						sb.append("</table>");
					} 
					else 
					{
						sb.append("<TABLE  width=\"100%\">");
						for (int i = 0; i < avgButton; i++) 
						{
							sb.append("<div id='buttonLL2Id" + (i + 1)+ "' style='display:block'>");
							sb.append("<tr><td height='20'>");
							if (buttons[i].split("@")[2].equals("0")) 
							{
								/* Commented Bcoz getting Image Based Buttons in New Desk*/
								
								/*sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "enable\" style=\"display:block\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" tabindex=\"1\" onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\"  class=\"m0l0oout\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;cursor:pointer\" onkeypress=\"onPressingEnter(this,event)\"  onclick=\"javascript:this.className ='m0l0oout'"
												+ (buttons[i].split("@")[1]
														.equals("") ? ""
														: ","
																+ buttons[i]
																		.split("@")[1])
												+ ";\" onmousedown=\"javascript:this.className ='m0l0oover'\" onmouseup=\"javascript:this.className ='m0l0ooout'\"><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");
								sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "disable\" style=\"display:none\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "dis\" class=\"m0l0odis\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");*/
								
								
								if(buttonIconsFinal[i]!=null)
									imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:block'>");
								sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
								sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								sb.append("onkeypress='onPressingEnter(this,event)' ");
								sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append("</div>");
								sb.append("<div class='DIVLABELENABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:none;'>");
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;' ");
								//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								//sb.append("onkeypress='onPressingEnter(this,event)' ");
								//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append(">");
								sb.append("</div>");
								sb.append("<div class='DIVLABELDISABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
							} 
							else 
							{
								/* Commented Bcoz getting Image Based Buttons in New Desk*/
								
								/*sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "enable\" style=\"display:none\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" tabindex=\"1\" onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\"  class=\"m0l0oout\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;cursor:pointer\" onkeypress=\"onPressingEnter(this,event)\"  onclick=\"javascript:this.className ='m0l0oout'"
												+ (buttons[i].split("@")[1]
														.equals("") ? ""
														: ","
																+ buttons[i]
																		.split("@")[1])
												+ ";\" onmousedown=\"javascript:this.className ='m0l0oover'\" onmouseup=\"javascript:this.className ='m0l0ooout'\"><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");
								sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "disable\" style=\"display:block\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "dis\" class=\"m0l0odis\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");*/
								
								
								if(buttonIconsFinal[i]!=null)
									imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:none;'>");
								sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
								sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								sb.append("onkeypress='onPressingEnter(this,event)' ");
								sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append("</div>");
								sb.append("<div class='DIVLABELENABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:block;'>");
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon'  style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;' ");
								//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								//sb.append("onkeypress='onPressingEnter(this,event)' ");
								//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append(">");
								sb.append("</div>");
								sb.append("<div class='DIVLABELDISABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
							}
							sb.append("</td></TR></div>");
							count++;
							flag = true;
						}
						sb.append("</table>");
					}
				}
			}

			if (menuOption.equalsIgnoreCase("tiles")) 
			{
				//System.out.println("BUtton Lay Out1.8");
				if (nTableCount == 1)
				{
					for (int i = count; i < recPerPage ; i++) 
					{
						/*footer.append("<table width=\"100%\"  border=\"0\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\""+ btnBgColor + "\">");
						footer.append("<TR><td align=\"center\" height=\""+ btnHeight + "\">&nbsp;</td></TR></table>");*/
						//footer.append("<table width=\"100%\"  border=\"0\" cellpadding=\"1\" cellspacing=\"1\">");
						//footer.append("<TR><td align=\"center\" height=\""+ btnHeight + "\">&nbsp;</td></TR></table>");
					}
				}
				else 
				{
					for (int i = 0; i < nTableCount; i++) 
					{
						footer.append("<div style='display:none' id='vaccantRowDiv"	+ userDefinedButton[Integer.parseInt(strButtonTableEvent[i])].split("@")[4] + "'>");
						if (i != nTableCount - 1)
						{
							for (int j = Integer.parseInt(strButtonTableEvent[i + 1])- Integer.parseInt(strButtonTableEvent[i]); j < recPerPage; j++) 
							{
								//footer.append("<table width=\"100%\"  border=\"0\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\""+ btnBgColor + "\">");
								//footer.append("<TR><td align=\"center\" height=\""+ btnHeight+ "\">&nbsp;</td></TR></table>");
							}
						}
						else
						{
							for (int j = no_of_button- Integer.parseInt(strButtonTableEvent[i]); j < recPerPage; j++) 
							{
								//footer.append("<table width=\"100%\"  border=\"0\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\""+ btnBgColor + "\">");
								//footer.append("<TR><td align=\"center\" height=\""+ btnHeight+ "\">&nbsp;</td></TR></table>");
							}
						}
						footer.append("</div>");
					}
				}
			} 
			else 
			{
				//System.out.println("BUtton Lay Out1.9");
				footer.append("");
			}

		} 
		catch (Exception e) 
		{
			sb.append("<table width=\"100%\"  border=\"0\" cellpadding=\"1\" cellspacing=\"1\">");
			sb.append("<tr><td CLASS=\"TDCOMBOHEADER\"><div align='center'>No Access Policy defined Please Define the Access Policy/Buttons Not Defined</div></td></tr></table>");
			vo.setStrMsgString("GenericVO.getButtonLayOut1() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
		if (flag){
			//System.out.println(header + sb.toString() + footer.toString());
			return header + sb.toString() + footer.toString();
		}
		else
			return sb.toString();
	}

	public String getButtonLayOut2(String[] userDefinedButton,String menuOption, String buttonConfig, int minPanelButton,int recPerPage, GenericVO vo, String[] dbButtons,String[] buttonIcons) 
	{
		//System.out.println("BUtton Lay Out2");
		StringBuffer sb = new StringBuffer("");
		StringBuffer footer = new StringBuffer("");
		String header = "";
		int count = 0;
		int avgButton = 0;
		int no_of_button = 0;
		boolean flag = false;
		String[] buttons = null;
		GenericBO bo = null;
		String imageUrl="/INVMGM/hisglobal/transactionutil/images/icon-default.png";
		String[] buttonIconsFinal;
		
		try 
		{
			bo = new GenericBO();
			if (userDefinedButton == null) 
			{
				//System.out.println("BUtton Lay Out2.1");
				bo.getDBButtons(vo, (String) vo.getSession().getAttribute("SEATID"), (String) vo.getSession().getAttribute("HOSPITAL_CODE"), dbButtons[0]);
				userDefinedButton = vo.getStrDBButton();
				buttonIconsFinal=new String[userDefinedButton.length];
				for(int i=0;i<userDefinedButton.length;i++)
				{
					buttonIconsFinal[i] = "icon-default.png";
				}
			}
			if (userDefinedButton != null) 
			{
				//System.out.println("BUtton Lay Out2.2");
				no_of_button = userDefinedButton.length;
				buttons = new String[userDefinedButton.length];
				buttons = userDefinedButton;
				buttonIconsFinal=buttonIcons;
			} 
			else 
			{
				//System.out.println("BUtton Lay Out2.3");
				no_of_button = dbButtons.length;
				buttons = new String[dbButtons.length];
				buttons = dbButtons;
				buttonIconsFinal=new String[dbButtons.length];
				for(int i=0;i<dbButtons.length;i++)
				{
					buttonIconsFinal[i] = "icon-default.png";
				}
			}

			no_of_button = userDefinedButton.length;

			if (no_of_button % 2 == 0)
				avgButton = no_of_button / 2;
			else
				avgButton = (no_of_button / 2) + 1;

			/*if (menuOption.equalsIgnoreCase("tiles")) 
			{
				header = "<table width=\"100%\"  border=\"1\" cellpadding=\"1\" cellspacing=\"1\">";
				header += "<tr><td CLASS=\"TDCOMBOHEADER\"><div align='center'>Activity</div></td></tr></table>";
			} 
			else 
			{
				header = "<table width=\"100%\"  border=\"1\" cellpadding=\"1\" cellspacing=\"1\">";
				header += "<tr><td CLASS=\"TDCOMBOHEADER\"><div align='center'>Activity</div></td></tr></table>";
			}*/
			if (buttonConfig.equalsIgnoreCase("both")) 
			{
				//System.out.println("BUtton Lay Out2.4");
				if ((minPanelButton >= no_of_button) || (minPanelButton >= avgButton)) 
				{
					flag = false;
				} 
				else 
				{
					//System.out.println("BUtton Lay Out2.5");
					flag = true;
					if (minPanelButton >= avgButton) 
					{
						//System.out.println("BUtton Lay Out2.6");
						sb.append("<TABLE  width=\"100%\">");
						for (int i = minPanelButton; i < no_of_button; i++) 
						{
							sb.append("<div id='buttonLR1Id" + (i + 1)+ "' style='display:block'>");
							sb.append("<tr><td height='20'>");
							if (buttons[i].split("@")[2].equals("0")) 
							{
								//System.out.println("BUtton Lay Out2.7");
								/*sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "enable\" style=\"display:block\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" tabindex=\"1\" onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\"  class=\"m0l0oout\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;cursor:pointer\" onkeypress=\"onPressingEnter(this,event)\"  onclick=\"javascript:this.className ='m0l0oout'"
												+ (buttons[i].split("@")[1]
														.equals("") ? ""
														: ","
																+ buttons[i]
																		.split("@")[1])
												+ ";\" onmousedown=\"javascript:this.className ='m0l0oover'\" onmouseup=\"javascript:this.className ='m0l0ooout'\"><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");
								sb
										.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "disable\" style=\"display:none\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "dis\" class=\"m0l0odis\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");*/
								
								
								if(buttonIconsFinal[i]!=null)
									imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:block'>");
								sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
								sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								sb.append("onkeypress='onPressingEnter(this,event)' ");
								sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append("</div>");
								sb.append("<div class='DIVLABELENABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:none;'>");
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;' ");
								//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								//sb.append("onkeypress='onPressingEnter(this,event)' ");
								//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append(">");
								sb.append("</div>");
								sb.append("<div class='DIVLABELDISABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
							} 
							else 
							{
								//System.out.println("BUtton Lay Out2.7");
								/*sb.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "enable\" style=\"display:none\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" " +
														"onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" " +
														"tabindex=\"1\" onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" " +
														"onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\"  " +
														"class=\"m0l0oout\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;cursor:pointer\" onkeypress=\"onPressingEnter(this,event)\"  onclick=\"javascript:this.className ='m0l0oout'"
												+ (buttons[i].split("@")[1]
														.equals("") ? ""
														: ","
																+ buttons[i]
																		.split("@")[1])
												+ ";\" onmousedown=\"javascript:this.className ='m0l0oover'\" onmouseup=\"javascript:this.className ='m0l0ooout'\"><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");
								sb
										.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "disable\" style=\"display:block\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "dis\" class=\"m0l0odis\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");*/
								
								
								if(buttonIconsFinal[i]!=null)
									imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:none;'>");
								sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
								sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								sb.append("onkeypress='onPressingEnter(this,event)' ");
								sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append("</div>");
								sb.append("<div class='DIVLABELENABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:block;'>");
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon'  style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;' ");
								//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								//sb.append("onkeypress='onPressingEnter(this,event)' ");
								//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append(">");
								sb.append("</div>");
								sb.append("<div class='DIVLABELDISABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
							}
							sb.append("</td></TR></div>");
							count++;
						}
						sb.append("</TABLE>");
					} 
					else 
					{
						//System.out.println("BUtton Lay Out2.8");
						sb.append("<TABLE  width=\"100%\" bgcolor="	+ btnBgColor + ">");
						for (int i = avgButton; i < no_of_button; i++) 
						{
							sb.append("<div id='buttonLR2Id" + (i + 1)+ "' style='display:block'>");
							sb.append("<tr><td height='23'>");
							if (buttons[i].split("@")[2].equals("0")) 
							{
								//System.out.println("BUtton Lay Out2.9");
								/*sb
										.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "enable\" style=\"display:block\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" " +
														"onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" " +
														"tabindex=\"1\" onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" " +
														"onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\"  " +
														"class=\"m0l0oout\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;cursor:pointer\" onkeypress=\"onPressingEnter(this,event)\"  onclick=\"javascript:this.className ='m0l0oout'"
												+ (buttons[i].split("@")[1]
														.equals("") ? ""
														: ","
																+ buttons[i]
																		.split("@")[1])
												+ ";\" onmousedown=\"javascript:this.className ='m0l0oover'\" onmouseup=\"javascript:this.className ='m0l0ooout'\"><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");
								sb
										.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "disable\" style=\"display:none\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "dis\" class=\"m0l0odis\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");*/
								
								
								if(buttonIconsFinal[i]!=null)
									imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:block'>");
								sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
								sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								sb.append("onkeypress='onPressingEnter(this,event)' ");
								sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append("</div>");
								sb.append("<div class='DIVLABELENABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:none;'>");
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;' ");
								//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								//sb.append("onkeypress='onPressingEnter(this,event)' ");
								//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append(">");
								sb.append("</div>");
								sb.append("<div class='DIVLABELDISABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
							} 
							else 
							{
								//System.out.println("BUtton Lay Out2.10");
								/*sb
										.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "enable\" style=\"display:none\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "\" onMouseOver=\"javascript:this.style.border = '2px solid #3399CC';\" " +
														"onMouseOut=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\" " +
														"tabindex=\"1\" onfocus=\"javascript:this.style.border = '2px solid #3399CC';\" " +
														"onblur=\"javascript:this.style.border = 'outset 1px',this.className ='m0l0oout';\"  " +
														"class=\"m0l0oout\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;cursor:pointer\" onkeypress=\"onPressingEnter(this,event)\"  onclick=\"javascript:this.className ='m0l0oout'"
												+ (buttons[i].split("@")[1]
														.equals("") ? ""
														: ","
																+ buttons[i]
																		.split("@")[1])
												+ ";\" onmousedown=\"javascript:this.className ='m0l0oover'\" onmouseup=\"javascript:this.className ='m0l0ooout'\"><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");
								sb
										.append("<div id=\""
												+ buttons[i].split("@")[0]
												+ "disable\" style=\"display:block\"><div  align=\"center\" id=\""
												+ buttons[i].split("@")[0]
												+ "dis\" class=\"m0l0odis\" title=\""
												+ buttons[i].split("@")[0]
												+ "\" style=\"position:absolute;"// width:"
												// + btnWidth +"px;"
												+ "height:"
												+ btnHeight
												+ "px;z-index:100;\" ><div id=\"eo__i\" class=\"logoutOver\">"
												+ buttons[i].split("@")[0]
												+ "</div></div></div>");*/
								
								if(buttonIconsFinal[i]!=null)
									imageUrl="/INVMGM/hisglobal/transactionutil/images/"+buttonIconsFinal[i];
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "enable\" style='display:none;'>");
								sb.append("<div id='"+ buttons[i].split("@")[0]+"'  class='rounded innerBigboxVerySmallIcon' onmouseover='changeBGColor(this);' onmouseout='resetBGColor(this);' style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;cursor:pointer' ");
								sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								sb.append("onkeypress='onPressingEnter(this,event)' ");
								sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append("</div>");
								sb.append("<div class='DIVLABELENABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
								
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "disable\" style='display:block;'>");
								sb.append("<div id=\""+ buttons[i].split("@")[0]+ "dis\" class='rounded innerBigboxVerySmallIcon'  style='background-color: rgb(18, 109, 165);' align='left'>");
								sb.append("<img src='"+imageUrl+"' class='icon-imageVerySmallIcon' title=\""+ buttons[i].split("@")[0]+ "\" ");
								sb.append("style='width: 30px; height: 30px;z-index:100;' ");
								//sb.append("onmouseover='changeSize(this);' onmouseout='resetSize(this);'");
								//sb.append("onkeypress='onPressingEnter(this,event)' ");
								//sb.append("onclick=\"javascript:this.className ='m0l0oout'"	+ (buttons[i].split("@")[1].equals("") ? "" : ","+ buttons[i].split("@")[1])+ ";\" >");
								sb.append(">");
								sb.append("</div>");
								sb.append("<div class='DIVLABELDISABLE'>");
								sb.append(buttons[i].split("@")[0]);
								sb.append("</div>");
								sb.append("</div>");
							}
							sb.append("</td></TR></div>");
							count++;
						}
						sb.append("</TABLE>");
					}
				}
			}
			if (menuOption.equalsIgnoreCase("tiles")) 
			{
				//System.out.println("BUtton Lay Out2.11");
				for (int i = count; i < recPerPage - 1; i++) 
				{
					footer.append("<table width=\"100%\"  border=\"0\" cellpadding=\"1\" cellspacing=\"1\" bgcolor=\""+ btnBgColor + "\">");
					footer.append("<TR><td align=\"center\" height=\""+ btnHeight + "\">&nbsp;</td></TR></table>");
				}
			} 
			else 
			{
				footer.append("");
			}

		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GenericVO.getButtonLayOut2() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
		if (flag)
			return header + sb.toString() + footer.toString();
		else
			return sb.toString();
	}

	// new functionality
	/*
	 * deleteRecords(String query, String chk) methods is called when delete
	 * button is clicked on list page
	 */

	// deleteRecords function is changed on 17-Aug-2007 to make function
	// compatible with multiple query execution.
	// chk = extra information could be appended with & symbol
	public String deleteRecords(GenericVO vo) {

		String status = "Successfully deleted !!";
		try {
			if (vo.getStrMsgType().equals("0")) {
				status = "<b><font color='#653232'> " + vo.getStrMsgString()
						+ "  Record(s) Deleted Successfully.</font></b>";
			} else {
				status = "<b><font color='red'>Error While deleting "
						+ vo.getStrMsgString() + " Record(s)</font> </b>";
			}
		} catch (Exception e) {
			status = "<b><font color='red'>Error While deleting "
					+ vo.getStrMsgString() + " Record(s)</font> </b>";
			vo
					.setStrMsgString("GenericHLP.deleteRecords --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return status;
	}

	/*
	 * getReports() method is used to generate the reports and this methods is
	 * also used when click on next or previous link on report page
	 * 
	 */

	public String getReports(GenericVO vo, String[] comboHeader,
			int record_per_page, int page_per_block, String[] colmnHeader) {

		StringBuilder reportQuerydata = new StringBuilder(1000);
		String comboTextValue = vo.getComboValue();
		WebRowSet webRs = null;
		HisDAO dao = null;
		int blockNo = Integer.parseInt(vo.getBlockNo());
		try {
			int minrow = (blockNo * (record_per_page * page_per_block))
					- (record_per_page * page_per_block);
			int maxRow = (blockNo * (record_per_page * page_per_block) + 1);
			dao = new HisDAO("MasterTemplate", "GenericHLP");
			webRs = vo.getLstWs();
			reportQuerydata.append("<TABLE ALIGN='CENTER' WIDTH=100%><TR> ");

			String temp[] = comboTextValue.split("@");

			for (int k = 1, i = 0; i < no_of_combo; i++, k++) {
				if (k % 3 == 0)
					reportQuerydata.append("<TR>");

				reportQuerydata.append("<TD WIDTH='15%'><B>"
						+ comboHeader[2 * i + 1] // changed on 12 july..
						// change is 2*i+1 instead
						// of i
						+ "</TD><TD>:" + temp[i] + "</B></TD> ");
			}
			reportQuerydata.append("</TR><TR><TD COLSPAN='"
					+ (colmnHeader.length + 1) + "' ALIGN='RIGHT'>");
			int prev = blockNo;
			if (blockNo > 1)
				reportQuerydata
						.append("<A  STYLE='CURSOR:POINTER' onClick=fetchNextPrev('"
								+ (--prev)
								+ "')><B><font color='"
								+ TransInterface.nextprevcolor
								+ "'>Previous</FONT></B></A>");

			reportQuerydata.append("&nbsp;&nbsp;" + blockNo + "&nbsp;&nbsp;");
			int next = blockNo;

			int length_min = (record_per_page * page_per_block);

			if (webRs.size() >= length_min)
				reportQuerydata
						.append("<a style='cursor:pointer' onClick=fetchNextPrev('"
								+ (++next)
								+ "')><b><font color='"
								+ TransInterface.nextprevcolor
								+ "'>Next</font></b></a>");

			int size = 90 / (colmnHeader.length);

			reportQuerydata
					.append("</TD></TR></TABLE><TABLE ALIGN='CENTER' WIDTH=100%> <TR><TD COLSPAN='"
							+ (colmnHeader.length + 1) + "'><HR></TD></TR>");
			reportQuerydata.append("<TR><TD WIDTH='10' ><B>S.No</B></TD> ");

			for (int i = 0; i < colmnHeader.length; i++) {
				reportQuerydata.append("<TD WIDTH=" + size + "%><B>"
						+ colmnHeader[i] + "</B></TD> ");
			}
			reportQuerydata.append("</TR><TR><TD COLSPAN='"
					+ (colmnHeader.length + 1) + "'><HR></TD></TR>");
			int length_loop = 1;

			while (webRs.next()) {
				String tempStr = webRs.getString(1);
				String tempStr1 = tempStr.replace('^', '#');
				String tempArray[] = tempStr1.split("#");

				if (length_loop <= (length_min)) {
					reportQuerydata.append("<TR> <TD  WIDTH='10' >"
							+ (++minrow) + "</TD>");

					for (int i = 0; i < colmnHeader.length; i++) {
						reportQuerydata.append("<TD ALIGN='LEFT'  WIDTH="
								+ size + "% >" + tempArray[i + 1] + " </TD>");
					}
				}
				length_loop++;

				reportQuerydata.append("</TR>");
			}
			reportQuerydata.append("<TR><TD COLSPAN='"
					+ (colmnHeader.length + 1) + "'><HR></TD></TR>");

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {
			vo.setStrMsgString("GenericHLP.getReports --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			colmnHeader = null;
			comboHeader = null;
			if (webRs != null) {
				try {

					webRs.close();
					webRs = null;
				} catch (Exception e) {
					vo.setStrMsgString("GenericHLP.getReports --> "
							+ e.getMessage());
					vo.setStrMsgType("1");
				}
			}
			if (dao != null)
				try {
					dao.free();
					dao = null;
				} catch (Exception e) {
					vo.setStrMsgString("GenericHLP.getReports --> "
							+ e.getMessage());
					vo.setStrMsgType("1");
				}
		}

		return reportQuerydata.toString();
	}

	public String getNextPrevRows(GenericVO vo, String mstName,
			String nextprevcolor) {

		StringBuilder viewBuffer = new StringBuilder(500);

		String temp = vo.getChk();
		String temp_chk[] = temp.replace('$', '#').split("#");
		int rowNum = Integer.parseInt(temp_chk[1]);
		int prev = rowNum;
		int next = rowNum;

		try {
			viewBuffer
					.append("<TABLE ALIGN='CENTER' WIDTH='98%' border=0 cellspacing='0' cellpadding='0' >");
			viewBuffer
					.append("<TR>"
							+ "<TD CLASS='VIEWTOPHEADER'>"
							+ mstName
							+ "</TD><TD CLASS='VIEWTOPHEADER' COLSPAN='3' ALIGN='RIGHT' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

			viewBuffer
					.append("<a style='cursor:pointer' onClick=fetchViewPrevious('"
							+ (--prev)
							+ "')><B><font color='"
							+ nextprevcolor
							+ "'>Previous</font></B></A>");

			viewBuffer.append("&nbsp;&nbsp; || &nbsp;&nbsp;");
			viewBuffer
					.append("<a  style='cursor:pointer' onClick=fetchViewNext('"
							+ (next)
							+ "')><B> <font color='"
							+ nextprevcolor
							+ "'>Next </font></B></A></TD></TR></TABLE>");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericHLP.getNextPrevRows -->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return viewBuffer.toString();
	}

	// this method will make a view for view page

	public String getViewRows(GenericVO vo, List hdr) {

		StringBuilder viewBuffer = new StringBuilder(500);
		ResultSetMetaData rsmeteData = null;
		List<String> list = new ArrayList<String>(10);
		String fieldName = "";
		List vwHdr = new ArrayList(20);
		List<String> AL_List = new ArrayList<String>(10);
		int columnCount = 0;
		vwHdr = hdr;
		try {
			rsmeteData = vo.getLstWs().getMetaData();
			columnCount = rsmeteData.getColumnCount();
			while (vo.getLstWs().next())
				for (int i = 1; i <= columnCount; i++) {
					list.add(vo.getLstWs().getString(i));
				}
			AL_List = list;
			String p = "";
			viewBuffer.append("<TABLE ALIGN='CENTER' WIDTH='98%' >");
			if (vwHdr.size() < 0) {
				viewBuffer
						.append("***********Error Occured During Viewing Record**************");
				return viewBuffer.toString();
			}

			else {
				for (int i = 0, j = 0; i < vwHdr.size(); j++, i += 2) {
					fieldName = "txt1" + j;
					p = (String) vwHdr.get(i + 1);
					viewBuffer.append("<TR><TD  CLASS='TDFONTVIEW'>"
							+ vwHdr.get(i)
							+ " </TD><TD  CLASS='TDFONT'  ALIGN='LEFT' >"
							+ getControl((String) AL_List.get(j), fieldName, p
									.charAt(0)) + "</TD></TR>");

				}
			}
			viewBuffer
					.append("<TR><TD CLASS='VIEWTOPHEADER' COLSPAN='3' ALIGN='CENTER'></TD></TR>");
			viewBuffer.append("<TR><TD  COLSPAN='3' ALIGN='CENTER'>");
			viewBuffer
					.append("<IMG STYLE='CURSOR:POINTER' SRC='../../../hisglobal/images/btn-ccl.png'  tabindex='1' onClick='window.opener.closePopUp_master();'");
			viewBuffer.append("</TD></TR></TABLE>");
		} catch (Exception e) {
			vo.setStrMsgString("GenericDAO.getViewRows -->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			vwHdr = null;
			AL_List = null;
		}
		return viewBuffer.toString();
	}

	//
	public String getControl(String fieldVal, String fieldName, char ch) {

		StringBuilder viewBuffer = new StringBuilder(500);

		switch (ch) {
		case 'D': // Option
			viewBuffer.append("<INPUT NAME='" + fieldName
					+ "' TYPE='text' VALUE='" + fieldVal + "' READONLY>\n");
			break;

		case 'T': // TextArea
			viewBuffer.append("<TEXTAREA NAME='" + fieldName
					+ "' ROWS='2' CLASS='TEXTAREA' READONLY>\n");
			viewBuffer.append(fieldVal + "\n");
			viewBuffer.append("</TEXTAREA>\n");
			break;

		case 'C': // CheckBox
			if (fieldVal.equals("1"))
				viewBuffer.append("<INPUT NAME='" + fieldName
						+ "' TYPE='CHECKBOX' CHECKED DISABLED TABINDEX='1'>\n");
			else
				viewBuffer.append("<INPUT NAME='" + fieldName
						+ "' TYPE='checkbox' DISABLED TABINDEX='1'>\n");

			break;

		case 'O': // Option
			viewBuffer.append("<INPUT NAME='RADIOBUTTON " + fieldVal
					+ "' TYPE='radio' DISABLED>\n");
			break;
		default: // TextBox
			viewBuffer.append("<INPUT NAME='" + fieldName
					+ "' TYPE='text' VALUE='" + fieldVal + "' READONLY>\n");
			break;
		}
		return viewBuffer.toString();

	}
	/*
	 * getQueryData(WebRowSet rowset, int size_percent, int minRow) function
	 * makes the data row for list page
	 * 
	 */

	public String getExtraInformationQueryRow(WebRowSet rowset, int size_percent, int minRow,
			String eventState, String[] rowStatus, GenericVO vo,String[] columnHdr) {
		int k = 1;
		int j = 1;
		int temp = 0;
		int nI = 0;
		boolean flag = false;
		
		
		String coulmn_header[] = columnHdr;

			
		
		// String[] strTempArray = new String[no_of_column+1];
		StringBuilder dataBuffer = new StringBuilder(300);

		String tempStr = "";
		String[] tempArray;
		String[] tempArray1;

		String rowClassName = "class = 'ONMOUSEOUT1'";

		try {
			while (rowset.next()) {

				flag = false;
				rowClassName = "class = 'ONMOUSEOUT1'";

				tempStr = String.valueOf(rowset.getString(1));
				String tempStr1 = tempStr.replace('^', '#');
				tempArray1 = tempStr1.split("#");

				if (!tempStr1.endsWith("#")) // if last value is null then it
					// can not be split..
					tempArray = tempArray1;
				else {
					tempArray = new String[tempArray1.length + 1];
					for (int i = 0; i < tempArray1.length; i++)
						tempArray[i] = tempArray1[i];

					tempArray[tempArray1.length] = "";
				}

				/*
				 * for(nI=0;nI<strTempArray.length;nI++){ strTempArray[nI] =
				 * String.valueOf(rowset.getString(nI+1)); }
				 */

				if (temp % rec_per_page == 0) {
					String idvalue = "a" + j;
					j++;

					if (idvalue.equals("a1"))
						dataBuffer
								.append("<DIV ID='"
										+ idvalue
										+ "' STYLE='DISPLAY:BLOCK;position:relative'><TABLE width='100%' bgcolor='white'>");
					else
						dataBuffer
								.append("<DIV ID='"
										+ idvalue
										+ "' STYLE='DISPLAY:NONE;position:relative'><TABLE width='100%' bgcolor='white'>");

				}

				if (eventState == null)
					eventState = "";
				
				for (int r = 0; r < rowStatus.length; r += 4) {
					// if (strTempArray[Integer.parseInt(rowStatus[r + 1]) -
					// 1].equalsIgnoreCase(rowStatus[r]))
					if (tempArray[Integer.parseInt(rowStatus[r + 1]) - 1]
							.equalsIgnoreCase(rowStatus[r])) {
						flag = true;
						rowClassName = "class = 'ONMOUSEOUT1match' bgcolor = '"
								+ rowStatus[r + 2] + "'";
						//break;
					} else {
						if ((r + 4 == rowStatus.length) && (flag != true))
							flag = false;
						//break;
					}

				}

				for (int m = 0; m < no_of_column; m++) {
					if(coulmn_header[m].replace("^","#").split("#").length>=2)
					{
						size_percent=Integer.parseInt(coulmn_header[m].replace("^","#").split("#")[1]);
					}

					if (m == 0) {
						if (flag) {

							dataBuffer.append("<TR ID='tr" + k + "' "
									+ rowClassName + " >");
						} else {

							dataBuffer.append("<TR ID='tr" + k + "' "
									+ rowClassName
									+ " onMouseOver='changeColor(this," + k
									+ ",0);' onMouseOut='changeColor(this," + k
									+ ",1);' >");
						}

						dataBuffer.append("<TD><INPUT TYPE='CHECKBOX' VALUE='"
								+ tempArray[0] + "$" + (k)
								+ "' NAME='chk' onClick=\"chkFunc(event,this,'"
								+ eventState + "'),chkUserFunc(this);\"></TD>");
						k++;
					}

					dataBuffer.append("<TD WIDTH='" + size_percent
							+ "%'>&nbsp;" + tempArray[m + 1] + "</TD>");
				}

				dataBuffer.append("</tr>");

				if (temp % rec_per_page == rec_per_page - 1)
					dataBuffer.append("</TABLE></DIV>");
				temp++;
			}

			if ((temp - 1) % rec_per_page != rec_per_page - 1)
				dataBuffer.append("</TABLE></DIV>");

		} catch (Exception e) {
			vo.setStrMsgType("1");
			vo.setStrMsgString("GenericHLP.getQueryData --> " + e.getMessage());
		} finally {
			tempArray = null;
			tempArray1 = null;
		}

		return dataBuffer.toString();
	}
}
