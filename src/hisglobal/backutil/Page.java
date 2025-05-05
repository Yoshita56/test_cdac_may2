package hisglobal.backutil;


/*
Project		:	HIS
FileName	:	Page.java
Version		:	1.0
Developer	:	HIS Team
*/

/*
FUNCTIONS DEFINED IN THIS CLASS FILE

1>String getTable(int page_no,List l1,List primary,List headlist,Map mymap,Map searchmap,String[] combolist)
2>int getNoOfPages(int total_elements)
3>String paginationTable(int no_of_pages,String var1,String var2,int block,int totRec,String[] combolist)
4>String getSortColumnlist(List headlist,Map mymap,String[] combolist)
5>String getSortColumnlist(List headlist,Map mymap)	
6>String getDataRows(int page_no,List l1,List primary)
7>String toolbar(String previouspage,String dataPage_width)
8>String tableHeading(String table_heading,String paginationtable)
9>String getFooter(Map searchmap,List headlist)
10>void setColor(String topColor, String hdrColor, String rowColor,String font)
11>void setVariables(int noFields,int noPrimary,int recordPage,String pageName,int pageBlock,String sFld,String sVal)							
12>String getViewPage(List AL_List,List viewHdr,Map viewConTrol,int no_of_column,String mstName)
13>String getHtmlStr()
14>String getViewRows(List AL_List,List viewHdr,Map viewControl)
15>String getViewHeader(String mstName)
16>String getViewToolBar()
17>String getControl(String fieldVal,String fieldName,Map viewControl)
18>void getPrintHtml(String rptName,List rptHeader, List rptWidth, 
 String query,List cmbHeader,List combo,List colIndex,int totColumn)throws SQLException
19>String getPrintHeader(String rptName,List rptHeader,List rptWidth,List cmbHeader,List combo)
20>String getPrintData(List AL_List,List rptWidth,int noFields,List colIndex,int totColumn) 
21>String getPrintFooter(int colspan)
	
*/

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Page 
{
	private String htmlStr		=	"";
	private int  total_elements	=	0;
	private int  no_of_pages	=	0;
	private int  start_element	=	0;
	private int  start_primary	=	0;
	private int  end_element	=	0;
	//color variables
	private String topcolor		=	"";
	private String hdrcolor		=	"";
	private String rowcolor		=	"";
	private String fontUsed		=	"";
	//page related variable
	private int record_per_page		= 	0;
	private int no_of_fields		=	0;
	private int	no_of_primary_keys	=	0;
	private	String pagename			=	"";
	private int page_per_block		=	0;
	private String searchFld		=	"";
	private	String searchVal		=	"";		
	//combo related variable
	private String[] combolist;
	private int no_of_combo			=	0;
	private String hsptName			= 	"eSushrut,Noida";
		
	public String getTable(int page_no,List l1,List primary,List headlist,Map mymap,Map searchmap)
	{
		
		StringBuffer buffer = new StringBuffer();
		
		total_elements	=	l1.size();

		no_of_pages		=	getNoOfPages(l1.size());
		
		start_element	=	record_per_page	*	 no_of_fields 		* (page_no-1);
		start_primary	=	record_per_page	*	 no_of_primary_keys * (page_no-1);
		end_element		=	start_element  	+ 	 (record_per_page	*	no_of_fields)-1;
		
		
		//html = "<tr bgcolor='" + hdrcolor + "'>\n";
		
		buffer.append("<tr bgcolor='#b6c2d0'>\n");
        //this function creates header
		//html += getSortColumnlist(headlist,mymap,combolist);
		
			
		buffer.append(getSortColumnlist(headlist,mymap));
		buffer.append("</tr>\n");
		
		//this function creates the data rows
		buffer.append(getDataRows(page_no,l1,primary));
		
		//this block generates the footer 
		buffer.append("<tr bgcolor='" + topcolor + "'>\n");
		buffer.append("<td height='19' colspan='" + (no_of_fields + 1) + "'>\n");
		buffer.append( getFooter(searchmap,headlist));
		buffer.append( "</td>\n");
		buffer.append("</tr>\n");
		
		return buffer.toString();
	}//1

//////////////////////// Function for SEARCHEMPLOYEES //////////////////////
	public String getTable1(int page_no,List l1,List primary,List headlist,Map mymap,Map searchmap)
	{
		
		StringBuffer buffer = new StringBuffer();
		
		total_elements	=	l1.size();

		no_of_pages		=	getNoOfPages(l1.size());
		
		start_element	=	record_per_page	*	 no_of_fields 		* (page_no-1);
		start_primary	=	record_per_page	*	 no_of_primary_keys * (page_no-1);
		end_element		=	start_element  	+ 	 (record_per_page	*	no_of_fields)-1;
		
		
		//html = "<tr bgcolor='" + hdrcolor + "'>\n";
		
		buffer.append("<tr bgcolor='#b6c2d0'>\n");
        //this function creates header
		//html += getSortColumnlist(headlist,mymap,combolist);
		
			
		buffer.append(getSortColumnlist1(headlist,mymap));
		buffer.append("</tr>\n");
		
		//this function creates the data rows
		buffer.append(getDataRows1(page_no,l1,primary));
		
		//this block generates the footer 
		buffer.append("<tr bgcolor='" + topcolor + "'>\n");
		buffer.append("<td height='19' colspan='" + (no_of_fields + 1) + "'>\n");
		buffer.append( getFooter(searchmap,headlist));
		buffer.append( "</td>\n");
		buffer.append("</tr>\n");
		
		return buffer.toString();
	}//1


	public String getTableSearch(int page_no,List l1,List primary,List headlist)
	{
		StringBuffer buffer = new StringBuffer();
		total_elements	=	l1.size();

		no_of_pages		=	getNoOfPages(l1.size());

		start_element	=	record_per_page	*	 no_of_fields 		* (page_no-1);
		start_primary	=	record_per_page	*	 no_of_primary_keys * (page_no-1);
		end_element		=	start_element  	+ 	 (record_per_page	*	no_of_fields)-1;
		
		//html = "<tr bgcolor='" + hdrcolor + "'>\n";
		
		buffer.append("<tr bgcolor='#b6c2d0'>\n");
        //this function creates header
		//html += getSortColumnlistSearch(headlist);
		buffer.append(getSortColumnlistSearch(headlist));
		buffer.append("</tr>\n");
		
		//this function creates the data rows
		buffer.append(getDataRowsSearch(page_no,l1,primary));
		
		//this block generates the footer 
		buffer.append("<tr bgcolor='" + topcolor + "'>\n");
		buffer.append( "<td height='19' colspan='" + (no_of_fields + 1) + "'>\n");
		//html += getFooter(searchmap,headlist);
		buffer.append("</td>\n");
		buffer.append( "</tr>\n");
		
		return buffer.toString();
	}//1


//////////////////////// Function for VIEWEMPLOYEES //////////////////////


	public String getTableView(int page_no,List l1,List primary,List headlist)
	{
		StringBuffer buffer = new StringBuffer();
		total_elements	=	l1.size();

		no_of_pages		=	getNoOfPages(l1.size());

		start_element	=	record_per_page	*	 no_of_fields 		* (page_no-1);
		start_primary	=	record_per_page	*	 no_of_primary_keys * (page_no-1);
		end_element		=	start_element  	+ 	 (record_per_page	*	no_of_fields)-1;
		
		//html = "<tr bgcolor='" + hdrcolor + "'>\n";
		
		buffer.append("<tr bgcolor='#b6c2d0'>\n");
        //this function creates header
		//html += getSortColumnlistSearch(headlist);
		buffer.append( getSortColumnlistSearch(headlist));
		buffer.append( "</tr>\n");
		
		//this function creates the data rows
		buffer.append( getDataRowsView(page_no,l1,primary));
		
		//this block generates the footer 
		buffer.append( "<tr bgcolor='" + topcolor + "'>\n");
		buffer.append( "<td height='19' colspan='" + (no_of_fields + 1) + "'>\n");
		//html += getFooter(searchmap,headlist);
		buffer.append( "</td>\n");
		buffer.append( "</tr>\n");
		
		return buffer.toString();
	}//1


//////////////////////// Function for SEARCHEMPLOYEES for FIRSTOREDR //////////////////////


	public String getTableFirstOrder(int page_no,List l1,List primary,List headlist)
	{
		StringBuffer buffer = new StringBuffer();
		total_elements	=	l1.size();

		no_of_pages		=	getNoOfPages(l1.size());

		start_element	=	record_per_page	*	 no_of_fields 		* (page_no-1);
		start_primary	=	record_per_page	*	 no_of_primary_keys * (page_no-1);
		end_element		=	start_element  	+ 	 (record_per_page	*	no_of_fields)-1;
		
		//html = "<tr bgcolor='" + hdrcolor + "'>\n";
		
		buffer.append("<tr bgcolor='#b6c2d0'>\n");
        //this function creates header
		//html += getSortColumnlistSearch(headlist);
		buffer.append(getSortColumnlistSearch(headlist));
		buffer.append("</tr>\n");
		
		//this function creates the data rows
		buffer.append( getDataRowsFirstOrder(page_no,l1,primary));
		
		//this block generates the footer 
		buffer.append( "<tr bgcolor='" + topcolor + "'>\n");
		buffer.append( "<td height='19' colspan='" + (no_of_fields + 1) + "'>\n");
		//html += getFooter(searchmap,headlist);
		buffer.append( "</td>\n");
		buffer.append( "</tr>\n");
		
		return buffer.toString();
	}//1




	public int getNoOfPages(int total_elements)
	{
		
		int temp = total_elements/no_of_fields;
		
	
		int no_of_pages = 0;
		int temp1 = temp%record_per_page;
		
		
		if(temp1==0)
			no_of_pages = (temp/record_per_page);
		else
			no_of_pages = (temp/record_per_page) + 1;

		return no_of_pages;
	}//2

	public String paginationTable(int no_of_pages,String var1,String var2,int block,int totRec)
	{
		int i = 0;
		int j = 0;
		StringBuffer buffer = new StringBuffer();
		String combostr	=	"";
     
		for(i=0;i<no_of_combo;i++)
		{
			if(!combolist[i].equals(""))
				combostr+="combo"+(i+1)+"="+combolist[i]+"&";
		}
		
		
		
		
		buffer.append( "<td colspan = '" + (no_of_fields + 1) + "'>\n");	
		buffer.append( "<table name=pagination width = '100%' border=0 cellPadding=0 cellSpacing=0>\n");
		buffer.append( "<tr bgcolor = '" + topcolor + "'>\n");
		buffer.append( "<td height='19' align = 'left'>\n<font size = '-1' face = '");
		buffer.append( fontUsed + "'>Total - <strong>" + totRec + "</strong>record(s)</font>\n</td>\n");
		
		if (no_of_pages > 0)
		{
			buffer.append( "<td height='19' align = 'right'>\n<strong><font size = '-2' face='");
			buffer.append( fontUsed + "' color = '#000099'>\n<");
					
			j = (block == 0?1:(block - 1) * page_per_block + 1);
			
			for(i = j;i <= (page_per_block + j - 1);i++)
			{
				if(i > no_of_pages) break;
				if (i == j && block > 1)
				{
					//html += "<a tabindex='1' href='" + pagename +"?" + combostr + "page_no=" + (i - page_per_block) + "&var1=" + var1;
					//html += "<a href='" + pagename +"?" + "page_no=" + (i - page_per_block) + "&var1=" + var1;
					//html += "&var2=" + var2 + "&var3=" + (block - 1);
					//html += "&cboSearch=" + searchFld + "&txtSearch=" + searchVal +"&menuURL="+menuURL+"&seatId="+seatID+"&empId="+empId+"&roleId="+roleId + "'>prev</a>\n";				
				    
				    
				    
				    
				   buffer.append( "<a tabindex='1' href=\"javascript:createQueryString('"+pagename+"','','"+(i - page_per_block)+"','"+var1);
                    buffer.append( "','"+var2+"','"+(block-1));
				   buffer.append("','"+searchFld+"','"+searchVal+"')\" >prev</a>\n");				
				}
			
				//html += "<a tabindex='1' href='"+pagename + "?" + combostr+"page_no=" + i + "&var1="+var1;
				//html += "<a href='"+pagename + "?" +"page_no=" + i + "&var1="+var1;
			//	html += "&var2=" + var2 + "&var3=" + (block == 0?1:block);
				//html += "&cboSearch=" + searchFld + "&txtSearch=" + searchVal +"&menuURL="+menuURL+"&seatId="+seatID+"&empId="+empId+"&roleId="+roleId + "'>" + i + "</a>\n";
				
				buffer.append( "<a tabindex='1' href=\"javascript:createQueryString('"+pagename+"','',"+i+",'"+var1);
                buffer.append( "','"+var2+"','"+(block == 0?1:block));
				buffer.append( "','"+searchFld+"','"+searchVal+"')\" >"+i+"</a>\n");
			}
		
			if (no_of_pages >= i)
			{
				//html += "<a href='" + pagename +"?" + combostr + "page_no=" + i + "&var1=" + var1;
				//html += "<a href='" + pagename +"?" + "page_no=" + i + "&var1=" + var1;
				//html += "&var2=" + var2 + "&var3=" + (block == 0?2:block + 1);
				//html += "&cboSearch=" + searchFld + "&txtSearch=" + searchVal +"&menuURL="+menuURL+"&seatId="+seatID+"&empId="+empId+"&roleId="+roleId + "'>next</a>\n";
			
				buffer.append( "<a href=\"javascript:createQueryString('"+pagename+"','','"+i+"','"+var1);
             	buffer.append("','"+var2+"','"+(block == 0?2:block+1));
				buffer.append( "','"+searchFld+"','"+searchVal+"')\" >next</a>\n");
			
			}
		
			buffer.append("></font></strong>\n</td>\n");
		}
				
		buffer.append("</tr>\n");
		buffer.append( "</table>\n");
		buffer.append( "</td>\n");

		return buffer.toString();
	}//3
	
	
	//Making the row for combo boxes option in stores 
	public String getComboList(String[] combohdr, String[] combohtml)
	{
		StringBuffer buffer = new StringBuffer();
		
		if(no_of_combo > 0)
		{
			//html = "<tr bgcolor='" + topcolor + "'>\n";
			buffer.append( "<tr class=addheader>\n");
			buffer.append( "<td colspan='" + (no_of_fields + 1) + "' align = 'right'>\n");
			//html += "<font size='-1' face='" + fontUsed + "'>\n";
			for(int i = 0;i < no_of_combo;i++)
			{
				buffer.append( combohdr[i] + "\n");
				buffer.append(combohtml[i] + "\n");
			}
			buffer.append( "</font></td>\n");
			buffer.append( "</tr>");
		}
		return buffer.toString();
		
	}//4
	
	public String getSortColumnlist(List headlist,Map mymap)
	{
		int i=0;
		StringBuffer buffer = new StringBuffer();
		
		
		String combostr	=	"";

		for(i=0;i<no_of_combo;i++)
		{
			combostr+="combo"+(i+1)+"="+combolist[i]+"&";
		}
		
		for(i = 0; i<headlist.size(); i++)
		{
		   
			if (i == 0)
			{
				//html += "<td height='19' align = 'center' bgcolor='#b6c2d0'>\n<strong>"; 
              	buffer.append( "<td class='addSubheader' height='19' >"); 
              	buffer.append( "<input type='checkbox' name='chkSelect' id='chkSelect'  value='1' tabindex='1' onClick='selectAllBox();'/></strong>\n</td>\n");
			}
			
			//
			//html += "<td bgcolor='#b6c2d0' align = 'left'>\n<strong><font size='2' face='" + fontUsed +"'>";
			buffer.append( "<td  class='addSubheader'>");
			String strtemp1 = String.valueOf(headlist.get(i));
			buffer.append( strtemp1 + "\n");  
			String strtemp2 = "";
			
			
		
			if(mymap.containsKey(strtemp1))
			{
				strtemp2 = String.valueOf(mymap.get(strtemp1));
				
			
			
				
				
				buffer.append( "<a tabindex='1' href=\"javascript:createQueryString1('"+ pagename + "','" + combostr + "','1','"+strtemp2+"',");
				buffer.append( "'','0','"+searchFld+"','"+ searchVal+"') \" >");
				
					
				buffer.append( "<img src='..\\..\\hisglobal\\images\\arrow_up.gif' width='10' tabindex='1' height='10' border=0 alt='ascending order'>");
				buffer.append( "</a>\n");				
				
				
						
				
				buffer.append( "<a tabindex='1' href=\"javascript:createQueryString1('"+ pagename + "','" + combostr + "','1','"+strtemp2+"',");
				buffer.append( "'desc','0','"+searchFld+"','"+ searchVal+"') \">");
			
				buffer.append( "<img src='..\\..\\hisglobal\\images\\arrow_down.gif' width='10' tabindex='1' height='10' border=0 alt='ascending order'>");
				buffer.append( "</a>\n");	
				
			}
			buffer.append( "</font></strong>\n</td>\n");

		}
		
			return buffer.toString();

	}//5

	
	public String getSortColumnlist1(List headlist,Map mymap)
	{
		int i=0;
		StringBuffer buffer = new StringBuffer();
		
		
		String combostr	=	"";

		for(i=0;i<no_of_combo;i++)
		{
			combostr+="combo"+(i+1)+"="+combolist[i]+"&";
		}
		
		for(i = 0; i<headlist.size(); i++)
		{
		   
			if (i == 0)
			{
				//html += "<td height='19' align = 'center' bgcolor='#b6c2d0'>\n<strong>"; 
              	buffer.append( "<td class='addSubheader' height='19' >"); 
              	buffer.append( "<input type='radio' name='chkSelect' id='chkSelect'  value='1' tabindex='1' onClick='selectAllBox();'/></strong>\n</td>\n");
			}
			
			//
			//html += "<td bgcolor='#b6c2d0' align = 'left'>\n<strong><font size='2' face='" + fontUsed +"'>";
			buffer.append( "<td  class='addSubheader'>");
			String strtemp1 = String.valueOf(headlist.get(i));
			buffer.append( strtemp1 + "\n");  
			String strtemp2 = "";
		
			
			
			if(mymap.containsKey(strtemp1))
			{
				strtemp2 = String.valueOf(mymap.get(strtemp1));
				
			
				
				
				buffer.append( "<a tabindex='1' href=\"javascript:createQueryString1('"+ pagename + "','" + combostr + "','1','"+strtemp2+"',");
				buffer.append( "'','0','"+searchFld+"','"+ searchVal+"') \" >");
				
					
				buffer.append( "<img src='..\\..\\hisglobal\\images\\arrow_up.gif' width='10' tabindex='1' height='10' border=0 alt='ascending order'>");
				buffer.append( "</a>\n");				
				
				
						
				
				buffer.append( "<a tabindex='1' href=\"javascript:createQueryString1('"+ pagename + "','" + combostr + "','1','"+strtemp2+"',");
				buffer.append( "'desc','0','"+searchFld+"','"+ searchVal+"') \">");
			
				buffer.append( "<img src='..\\..\\hisglobal\\images\\arrow_down.gif' width='10' tabindex='1' height='10' border=0 alt='ascending order'>");
				buffer.append( "</a>\n");	
				
			}
			buffer.append( "</font></strong>\n</td>\n");

		}
		
			return buffer.toString();

	}//5

////////////// Function for SEARCHEMPLOYEES /////////////////


	public String getSortColumnlistSearch(List headlist)
	{	
		StringBuffer buffer = new StringBuffer();
		int i=0;
		
		String combostr	=	"";

		for(i=0;i<no_of_combo;i++)
		{
			combostr+="combo"+(i+1)+"="+combolist[i]+"&";
		}
		
		for(i = 0; i<headlist.size(); i++)
		{
			if (i == 0)
			{
				//html += "<td height='19' align = 'center' bgcolor='#b6c2d0'>\n<strong>"; 
              	buffer.append( "<td class='addSubheader' height='19' >"); 
              	//html += "<input type='radio' name='select' value='1' tabindex='1' onClick = 'testradio(this,"+i+");'>\n\n";
			}
			
			//
			//html += "<td bgcolor='#b6c2d0' align = 'left'>\n<strong><font size='2' face='" + fontUsed +"'>";
			buffer.append("</font></strong><td  class='addSubheader'><strong><font size='2' face='" + fontUsed +"'>");
			String strtemp1 = String.valueOf(headlist.get(i));
			buffer.append( strtemp1 + "\n");  
			String strtemp2 = "";
			//
			
			buffer.append( "</font></strong>\n</td>\n");

		}
		
		return buffer.toString();

	}//5





	public String getDataRows(int page_no,List l1,List primary)
	{
		StringBuffer pageBuffer = new StringBuffer();
		int i,j,k		=	0;
		int temp		=	start_element;
		int l			=	start_primary;
		String waste	=	"";
		
		
		if(no_of_pages==0)
			record_per_page	=	0;
		
		for(i=0;i<record_per_page;i++)
		{
			pageBuffer.append(  "<tr bgcolor='#b6c2d0'>\n");

		
			
			for(k=0;k<no_of_primary_keys;k++)
			{
				
				waste = waste + primary.get(l++) + "^";
			}
			
			pageBuffer.append( "<td class=adddatalabel height='19' align = 'center'>\n<input type=checkbox name=chk id='chk' value="+waste+" tabindex='1' />\n\n");
			waste = "";
		
			for(j=0;j<no_of_fields;j++)
			{
				
				pageBuffer.append(  "<td class=adddatalabel height='19' align = 'left' nowrap>");
				
				pageBuffer.append( l1.get(temp++) + "\n</td>\n");
			}
			
			
			pageBuffer.append( "</tr>\n");
			
			if(temp >= total_elements)
				break;
		}
		return pageBuffer.toString();
	}//6

	
	public String getDataRows1(int page_no,List l1,List primary)
	{
		StringBuffer pageBuffer = new StringBuffer();
		int i,j,k		=	0;
		int temp		=	start_element;
		int l			=	start_primary;
		String waste	=	"";
		
		
		if(no_of_pages==0)
			record_per_page	=	0;
	
		for(i=0;i<record_per_page;i++)
		{
			pageBuffer.append(  "<tr bgcolor='#b6c2d0'>\n");

			
			
			for(k=0;k<no_of_primary_keys;k++)
			{
				
				waste = waste + primary.get(l++) + "";
			}
			
			pageBuffer.append( "<td class=adddatalabel height='19' align = 'center'>\n<input type=radio name=chk id='chk' value="+waste+" tabindex='1' onclick='radioClicked()' />\n\n");
			waste = "";
			
			for(j=0;j<no_of_fields;j++)
			{
				
				pageBuffer.append(  "<td class=adddatalabel height='19' align = 'left' nowrap  >");
			
				pageBuffer.append( " <input type='text' name='field"+j+"' id='field"+j+"' readonly='true'value='"+l1.get(temp++)+"'/>\n</td>\n");
			}
			
		
			pageBuffer.append( "</tr>\n");
			
			if(temp >= total_elements)
				break;
		}
		return pageBuffer.toString();
	}//6

	////////////// FUNCTION for SEARCHEMPLOYEES ///////////////////


	public String getDataRowsSearch(int page_no,List l1,List primary)
	{
		StringBuffer pageBuffer = new StringBuffer();
		int i,j,k		=	0;
		int temp		=	start_element;
		int l			=	start_primary;
		String waste	=	"";
		
		
		if(no_of_pages==0)
			record_per_page	=	0;

		for(i=0;i<record_per_page;i++)
		{
			pageBuffer.append( "<tr bgcolor='#b6c2d0'>\n");

			
			pageBuffer.append(  "<td class=adddatalabel height='19' align = 'center'>\n<input type=radio name=select onClick=testradio(this,"+i+");>\n\n");
			waste = "";

			pageBuffer.append(  "<td class=adddatalabel height='19' align = 'center'>\n<input name=employee_number value='"+l1.get(temp++)+"' type=text readonly >\n</td>\n");

			pageBuffer.append(  "<td class=adddatalabel height='19' align = 'center'>\n<input name=employee_name value='"+l1.get(temp++)+"'  type=text readonly >\n</td>\n");

			pageBuffer.append(  "<td class=adddatalabel height='19' align = 'center'>\n<input  name=post_internal value='"+l1.get(temp++)+"' type=text readonly>\n</td>\n");

			pageBuffer.append(  "<td class=adddatalabel height='19' align = 'center'>\n<input  name=post_external value='"+l1.get(temp++)+"' type=text readonly >\n</td>\n");

			pageBuffer.append(  "<td class=adddatalabel height='19' align = 'center'>\n<input  name=department value='"+l1.get(temp++)+"' type=text readonly >\n</td>\n");
			
			
			pageBuffer.append(  "\n");
			if(temp >= total_elements)
				break;
		}
		return pageBuffer.toString();
	}//6


////////////// FUNCTION for VIEWEMPLOYEES ///////////////////


	public String getDataRowsView(int page_no,List l1,List primary)
	{
		StringBuffer pageBuffer = new StringBuffer();
		int i,j,k		=	0;
		int temp		=	start_element;
		int l			=	start_primary;
		String waste	=	"";
		
		
		if(no_of_pages==0)
			record_per_page	=	0;
		
		
		for(i=0;i<record_per_page;i++)
		{
			pageBuffer.append( "<tr bgcolor='#b6c2d0'>\n");
			
			for(k=0;k<no_of_primary_keys;k++)
			{
				waste = waste + primary.get(l++) + "^";
			}
			
			pageBuffer.append("<td class=adddatalabel height='19' align = 'center'>\n<input type=radio name=select value="+waste+">\n\n");
			waste = "";
			for(j=0;j<no_of_fields;j++)
			{
				
				waste = "";
				
				pageBuffer.append( "<td class=adddatalabel height='19' align='center' nowrap>\n");
				pageBuffer.append( l1.get(temp++)+"\n</td>\n");
				
			
			}
			
			pageBuffer.append( "\n");
			if(temp >= total_elements)
				break;
		}
		return pageBuffer.toString();
	}//6
	

	
////////////// FUNCTION for SEARCHEMPLOYEES ///////////////////


	public String getDataRowsFirstOrder(int page_no,List l1,List primary)
	{
		StringBuffer pageBuffer = new StringBuffer();
		int i,j,k		=	0;
		int temp		=	start_element;
		int l			=	start_primary;
		String waste	=	"";
		
		
		if(no_of_pages==0)
			record_per_page	=	0;

		for(i=0;i<record_per_page;i++)
		{
			pageBuffer.append(  "<tr bgcolor='#b6c2d0'>\n");

			
			pageBuffer.append(  "<td class=adddatalabel height='19' align = 'center'>\n<input type=radio name=select onClick=testradio(this,"+i+");>\n\n");
			waste = "";

			pageBuffer.append(  "<td class=adddatalabel height='19' align = 'center'>\n<input name=employee_number value='"+l1.get(temp++)+"' type=text readonly >\n</td>\n");

			pageBuffer.append( "<td class=adddatalabel height='19' align = 'center'>\n<input name=employee_name value='"+l1.get(temp++)+"'  type=text readonly >\n</td>\n");

			pageBuffer.append( "\n");
			if(temp >= total_elements)
				break;
		}
		return pageBuffer.toString();
	}//6

	
	
	public String toolbar(String previouspage,String dataPage_width)
	{
		StringBuffer pageBuffer = new StringBuffer();
	

		pageBuffer.append( "<td colspan='" + (no_of_fields + 1) + "'>\n");
		pageBuffer.append("<table width='" + dataPage_width + "' border='0' cellspacing='1' cellpadding='0' align = 'center'>\n");
		pageBuffer.append( "<tr>\n");
		pageBuffer.append( "<td class=addtoolbar height='23' align = 'center'>\n");
		
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Add.gif' border=0 tabindex='1' onKeyPress='add(event);' onClick='add(event);'></a>\n");
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Modify.gif' width='60' height='20' border=0 tabindex='1' onKeyPress='edit(event);' onClick='edit(event);' ></a>\n");
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Delete.gif' width='60' height='20' border=0  tabindex='1' onKeyPress='del(event);' onClick='del(event);'></a>\n");
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\View.gif' width='60' height='20' border=0  tabindex='1' onKeyPress='view(event);' onClick='view(event);'></a>\n");
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Report.gif' width='60' height='20' border=0  tabindex='1' ></a>\n");

		pageBuffer.append( "</td>\n");				
		pageBuffer.append( "</tr>\n");
		pageBuffer.append( "</table>\n");
		pageBuffer.append( "</td>\n");
				
			
		return pageBuffer.toString();
	}//7


///////////// FUNCTION for SEARCHEMPLOYEES ////////////////////////////////


	public String toolbar1(String previouspage,String dataPage_width)
	{
		StringBuffer pageBuffer = new StringBuffer();
		

		pageBuffer.append( "<td colspan='" + (no_of_fields + 1) + "'>\n");
		pageBuffer.append( "<table width='" + dataPage_width + "' border='0' cellspacing='1' cellpadding='0' align = 'center'>\n");
		pageBuffer.append( "<tr>\n");
		pageBuffer.append( "<td class=addtoolbar height='23' align = 'center'>\n");
		
		pageBuffer.append("<a style=cursor:hand><img src='..\\..\\hisglobal\\images\\close copy.gif' border=0 onClick='close_window();'></a>\n");
		
		pageBuffer.append( "</td>\n");				
		pageBuffer.append( "</tr>\n");
		pageBuffer.append("</table>\n");
		pageBuffer.append( "</td>\n");
				
			
		return pageBuffer.toString();
	}//7


///////////// FUNCTION for VIEWEMPLOYEES ////////////////////////////////


	public String toolbar2(String previouspage,String dataPage_width)
	{
		StringBuffer pageBuffer = new StringBuffer();
	

		pageBuffer.append( "<td colspan='" + (no_of_fields + 1) + "'>\n");
		pageBuffer.append( "<table width='" + dataPage_width + "' border='0' cellspacing='1' cellpadding='0' align = 'center'>\n");
		pageBuffer.append("<tr>\n");
		pageBuffer.append( "<td class=addtoolbar height='23' align = 'center'>\n");
		
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\view_tab.gif' border=0 onClick=viewdata('VIEW1');></a>\n");
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\delete_tab.gif' border=0 onClick=viewdata('DELETE');></a>\n");
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\cancel_tab.gif' border=0 onClick=setModeCancel('DEFAULT');></a>\n");
		
		pageBuffer.append( "</td>\n");				
		pageBuffer.append( "</tr>\n");
		pageBuffer.append( "</table>\n");
		pageBuffer.append("</td>\n");
				
			
		return pageBuffer.toString();
	}//7


///////////// FUNCTION for VIEWEMPLOYEES FIRSTORDER ////////////////////////////////


	public String toolbar3(String previouspage,String dataPage_width)
	{
		StringBuffer pageBuffer = new StringBuffer();
		
		pageBuffer.append( "<td colspan='" + (no_of_fields + 1) + "'>\n");
		pageBuffer.append( "<table width='" + dataPage_width + "' border='0' cellspacing='1' cellpadding='0' align = 'center'>\n");
		pageBuffer.append( "<tr>\n");
		pageBuffer.append( "<td class=addtoolbar height='23' align = 'center'>\n");
		
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\view_tab.gif' border=0 onClick=viewdata('VIEW1');></a>\n");
		pageBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\cancel_tab.gif' border=0 onClick=setMode('DEFAULT',0);></a>\n");
		
		pageBuffer.append( "</td>\n");				
		pageBuffer.append( "</tr>\n");
		pageBuffer.append( "</table>\n");
		pageBuffer.append( "</td>\n");
				
			
		return pageBuffer.toString();
	}//7

	public String tableHeading(String table_heading,String paginationtable,String filter)
	{
		StringBuffer pageBuffer = new StringBuffer();
		
		pageBuffer.append( "<tr bgcolor='#FFFFFF'>\n");
		pageBuffer.append( "<td class=pagetitle colspan='" + (no_of_fields + 1) + "'>\n");
	  	//page_html += "<font color='#000066' size='2' face='Verdana'>\n<strong>"; 
	  	pageBuffer.append( table_heading + " >>");
	  	//page_html += "</strong></font>\n";
	  	pageBuffer.append( "</td>\n");
	  	pageBuffer.append( "</tr>\n");
		
		pageBuffer.append( "<tr class=addheader >\n");
		pageBuffer.append(paginationtable);  
	  	pageBuffer.append("</tr>\n");
	  	pageBuffer.append(filter + "\n");
	  	return pageBuffer.toString();
	}//8
	
	public String getFooter(Map searchmap,List headlist)
	{
		StringBuffer buffer = new StringBuffer();
		int i			=	0;
		
		buffer.append( "<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n");
		buffer.append( "<tr class=addheader>\n");
		buffer.append( "<td align = 'right' height='19'>\n");
		
		if (!searchmap.isEmpty())
		{
			buffer.append( "<select name='cboSearch' tabindex='1' class='cbo2'>\n");
			buffer.append( "<option value = '-1' selected>Select field</option>\n");
			
			for(i = 0;i<headlist.size();i++)
			{
				String strtemp1 = String.valueOf(headlist.get(i));
				String strtemp2 = "";
				
				if(searchmap.containsKey(strtemp1))
				{
					strtemp2 = String.valueOf(searchmap.get(strtemp1));
					if(strtemp2.equalsIgnoreCase(searchFld))
						buffer.append("<option value = '" + strtemp2 + "' selected>" + strtemp1 + "</option>\n");
					else
						buffer.append( "<option value = '" + strtemp2 + "'>" + strtemp1 + "</option>\n");
				}
			}
			
			buffer.append( "</select>\n");
			buffer.append("<input type='text' name='txtSearch' class='textbox' onKeyPress=cancelNew('"+pagename+"',event); value = '" + searchVal);
			buffer.append("' tabindex='1' >\n");
						
			buffer.append( "<a style=cursor:hand><img src='..\\..\\hisglobal\\images\\Search.gif' ");
			buffer.append( " width='70' height='19' align=Top border=0 tabindex='1' onKeyPress=cancelNew('"+pagename+"',event); onClick=cancelNew('"+pagename+"',event);>");
			buffer.append( "\n");
			
			buffer.append( "</select></td>\n");
			buffer.append("</tr>\n");
			buffer.append( "</table>\n");
		}
		
		return buffer.toString();
			
	}//9
	
	public void setColor(String topColor, String hdrColor, String rowColor,String font)
	{
		topcolor	=	topColor;
		hdrcolor	=	hdrColor;
		rowcolor	=	rowColor;
		fontUsed	=	font;
	}//10
	
	public void setVariables(int noFields,int noPrimary,int recordPage,String pageName,
	int pageBlock,String sFld,String sVal,int noCombo,String[] strCombo)
	{
		no_of_fields		=	noFields;	
		no_of_primary_keys	=	noPrimary;
		record_per_page		=	recordPage;
		pagename			=	pageName;
		page_per_block		=	pageBlock;
		searchFld			=	sFld;
		searchVal			=	sVal;
		//combo
		no_of_combo			=	noCombo;
		combolist			=	strCombo;
	}//11
	
	
	/*
	this function generates the view page
	*/
	public void getViewPage(List AL_List,List viewHdr,Map viewConTrol,String mstName)
	{
		StringBuffer htmlStrBuffer = new StringBuffer();
		
		htmlStrBuffer.append(getViewHeader(mstName));
		htmlStrBuffer.append(getViewRows(AL_List,viewHdr,viewConTrol));
		
		htmlStr += htmlStrBuffer.toString();
	}//12
	
	public void getViewPage1(List AL_List,List viewHdr,Map viewConTrol,String mstName,int count)
	{
		StringBuffer htmlStrBuffer = new StringBuffer();
		htmlStrBuffer.append(getViewHeader(mstName));
			
		
		for(int i=0;i<count;i++)
		{
			int check=i;
		
			htmlStrBuffer.append( getViewRows1(AL_List,viewHdr,viewConTrol,check));
		}
		htmlStrBuffer.append( getViewToolBar());
   		
   		htmlStr += htmlStrBuffer.toString();
   	}
	
	public String getHtmlStr()
	{
		return htmlStr;
	}//13
	
	
	public String getViewRows1(List AL_List,List viewHdr,Map viewControl,int check)
	{
		StringBuffer buffer = new StringBuffer();
		
		String strtemp1 = "";
		String strtemp2 = "";
		int index,i,fields,flag,j;
		
		fields = viewHdr.size();
		
		
		if(check==0)
		{
			j=0;
		}
		else
		{
			j=check*3;
		}
		
		for(i = 0;i < fields;i++)
		{
			flag = 0;
			buffer.append( "<tr>\n");
			
			strtemp1 = String.valueOf(viewHdr.get(i));
			
			index = strtemp1.indexOf('^');
			
			while(index != -1)
			{
				
				if(flag == 0)
				{
					buffer.append( "<td class=adddatalabel colspan = '2'>\n");
					
					flag = 1;
				}
				
				strtemp1 = strtemp1.substring(0,index);
				
				buffer.append(strtemp1);
				
				
				buffer.append(getControl(String.valueOf(AL_List.get(i)),strtemp1,viewControl,i));
				
				if(++i < fields)
				{
					strtemp1 = String.valueOf(viewHdr.get(i));
					index = strtemp1.indexOf('^');
				}
				else
					break;
			
			}
			
			if(flag == 1)
			{
				buffer.append( "</font></td>\n");
				buffer.append( "</tr>\n");
			}
			
			if(i < fields)
			{
				buffer.append( "<tr>");
				buffer.append( "<td class=adddatalabel >\n");
				//html += "<font size='2' face='Verdana, Arial, Helvetica, sans-serif'>\n";
				buffer.append( strtemp1 + "\n");
				//html += "</font>\n";
				buffer.append( "</td>\n");
				buffer.append( "<td class=adddatavalue>\n");
				buffer.append( getControl(String.valueOf(AL_List.get(j)),strtemp1,viewControl,i));
				buffer.append( "</td>\n");
				buffer.append( "</tr>\n");
			}
			
		j++;	
		}
		
        buffer.append( "<tr class=addheader>\n");
		buffer.append( "<td height='17' colspan='2'></td>\n");
		buffer.append("</tr>\n");
		buffer.append( "\n");
		
		return buffer.toString();	
            
	}//14
	
	
	
	public String getViewRows(List AL_List,List viewHdr,Map viewControl)
	{
		StringBuffer buffer = new StringBuffer();
		
		String strtemp1 = "";
		String strtemp2 = "";
		int index,i,fields,flag;
		
		fields = viewHdr.size();
		for(i = 0;i < fields;i++)
		{
			flag = 0;
			buffer.append("<tr>\n");
			
			strtemp1 = String.valueOf(viewHdr.get(i));
			
			index = strtemp1.indexOf('^');
		
			while(index != -1)
			{
				if(flag == 0)
				{
					buffer.append( "<td class=adddatalabel colspan = '2'>\n");
					
					flag = 1;
				}
				
				strtemp1 = strtemp1.substring(0,index);
				
				buffer.append( strtemp1);
				//this function gives the control with value
				
				buffer.append( getControl(String.valueOf(AL_List.get(i)),strtemp1,viewControl,i));
				
				if(++i < fields)
				{
					strtemp1 = String.valueOf(viewHdr.get(i));
					index = strtemp1.indexOf('^');
				}
				else
					break;
			
			}
			
			if(flag == 1)
			{
				buffer.append( "</font></td>\n");
				buffer.append( "</tr>\n");
			}
			
			if(i < fields)
			{
				buffer.append( "<tr>");
				buffer.append( "<td class=adddatalabel >\n");
				
				buffer.append(strtemp1 + "\n");
				
				buffer.append("</td>\n");
				buffer.append( "<td class=adddatavalue>\n");
			
				buffer.append( getControl(String.valueOf(AL_List.get(i)),strtemp1,viewControl,i));
				buffer.append( "</td>\n");
				buffer.append( "</tr>\n");
			}
			
			
		}
		
       buffer.append( "<tr class=addheader>\n");
		buffer.append( "<td height='17' colspan='2'></td>\n");
		buffer.append( "</tr>\n");
		buffer.append( "\n");
		
		return buffer.toString();	
            
	}//14
	
	
	public String getViewHeader(String mstName)
	{
		StringBuffer buffer = new StringBuffer();
		
		
		buffer.append( "<table width='60%' border='0' cellspacing='0' cellpadding='0' align = 'center'>\n");
		buffer.append( "<tr class=pagetitle>\n");
		buffer.append( "<td colspan='2' >\n");
	
		buffer.append( "" + mstName + " >>View");
		
		buffer.append( "<td>\n");
		buffer.append( "<tr>\n");
		buffer.append( "<tr class=addheader>\n");
		buffer.append( "<td colspan='2' ></td>\n");
		buffer.append( "</tr>\n"); 
              
		return buffer.toString();
	}//15
	
	
	public String getViewToolBar()
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<table width='60%' border='0' cellspacing='1' cellpadding='0' align = 'center'>\n");
		buffer.append( "<tr class=addtoolbar>\n");
		buffer.append( "<td colspan = '2' height='23'>\n");
		buffer.append( "<a style=cursor:hand>\n");
		buffer.append( "<img src='..\\..\\images\\Cancel.gif' width='60' height='20' onClick='submitpage(\"DEFAULT\");'>\n");
		buffer.append( "</a>\n");
		buffer.append( "</td>\n");
		buffer.append( "</tr>\n");
		buffer.append( "</table>\n");
		
		return buffer.toString();
  	}//16
	
	// Additional function such as statusCombo()
	
	public String getStatusCombo(String statusLabel, int numoffield)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append( "<tr class=addheader>  \n");
		
		for(int i=0;i<=numoffield;i++)
			buffer.append( "<td align = 'right' height='19'>\n");
			
		/*buffer.append( "<td align = 'right' height='19'>\n");
		buffer.append( "<td align = 'right' height='19'>\n");
		buffer.append( "<td align = 'right' height='19'>\n");
		buffer.append( "<td align = 'right' height='19'>\n");
		buffer.append( "<td align = 'right' height='19'>\n"); */
		//buffer.append( "Status <select name='statusSearch' tabindex='1' class='cbo2' onClick='statusNew("+pagename+",event)';>\n");
		//buffer.append( "Status <select name='statusSearch' tabindex='1' class='cbo2' onKeyPress=statusNew('"+pagename+"'); onChange=statusNew('"+pagename+"'); onClick=statusNew('"+pagename+"');>\n");
		buffer.append( "Status <select name='statusSearch' tabindex='1' class='cbo2' onChange=statusNew('"+pagename+"');>\n");
		//buffer.append( "<option value = '-1' >-------</option>\n");
		
		buffer.append( "<option value = '0'"); 
		if(statusLabel.equalsIgnoreCase("Inactive"))
		{
			buffer.append(" selected ");
		}	
		buffer.append(">Inactive</option>\n");
		
		buffer.append( "<option value = '1'"); 
		if(statusLabel.equalsIgnoreCase("Active"))
		{
			buffer.append(" selected ");
		}	
		buffer.append(">Active</option>\n");
		//buffer.append( "<option value = '1' >Active</option>\n");
		buffer.append( "</select>\n");
		buffer.append("</tr>\n");
		return buffer.toString();
				
	}// Additonal Function is Closed
	
	public String getControl(String fieldVal,String fieldName,Map viewControl,int conIndex)
	{
		StringBuffer buffer = new StringBuffer();
		String strtemp = "";
		String html = "";
		char ch = 'd';	//default
		
		if(viewControl.containsKey(fieldName))
		{
			strtemp = String.valueOf(viewControl.get(fieldName));
			ch = strtemp.charAt(0);
		}
		
		switch(ch)
		{
			case 'T':	//TextArea
				buffer.append("<textarea name='" + fieldName + "' rows='2' class='textarea' readonly>\n");
				buffer.append( fieldVal + "\n");
				buffer.append("</textarea>\n");
				break;
				
			case 'C':	//CheckBox
				if(fieldVal.equals("1"))
					buffer.append( "<input name='" + fieldName + "' type='checkbox' checked disabled tabindex='1'>\n");
				else
					buffer.append( "<input name='" + fieldName + "' type='checkbox' disabled tabindex='1'>\n");
				break;
				
			case 'O':	//Option
				if(fieldVal.equals("1"))
					buffer.append( "<input name='radioButton" + String.valueOf(conIndex) + "' type='radio' checked disabled>\n");
				else
					buffer.append( "<input name='radioButton " + String.valueOf(conIndex) + "' type='radio' disabled>\n");
				break;
				
			default:	//TextBox	
				buffer.append("<input name='" + fieldName + "' type='text' value='" + fieldVal + "' readonly>\n");
				break;
		}
		
		
		return buffer.toString();
			
	}//17
	
	/*For master page's printout. it does not return html string.
	call getHtmlStr() for Report's page
	*/
	public void getPrintHtml(String rptName,List rptHeader, List rptWidth,String query,List cmbHeader,List combo,List colIndex,int totColumn)throws SQLException
	{
		StringBuffer htmlStrBuffer = new StringBuffer(); 
		List AL_List = new ArrayList();
		int noFields = rptHeader.size();
		try
		{
		 AL_List = CommonDataBaseManip.getDetail(query);
		}
	    catch(Exception e){}
		if(AL_List.size() <= 0)
			htmlStrBuffer.append( "NO DATA FOUND");
		else
		{
			//toolbar
			htmlStrBuffer.append( "<table width='100%' border='0' cellspacing='1' cellpadding='0'>");
			htmlStrBuffer.append("<tr><td><div  id = 'id1' align='right'>");
          	htmlStrBuffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Cancel.gif' border=0 onClick='submitpage(\"DEFAULT\");'></a>\n");
			htmlStrBuffer.append("<a style=cursor:hand><img src='..\\..\\images\\Print.gif' border=0 onClick='callMe();'></a>\n");
			htmlStrBuffer.append( "</div></td></tr></table>\n");
			
			//report view
			htmlStrBuffer.append( "<table width='100%' border='0' cellspacing='1' cellpadding='0'>\n");
			htmlStrBuffer.append( getPrintHeader(rptName,rptHeader,rptWidth,cmbHeader,combo));
		
			htmlStrBuffer.append( getPrintData(AL_List,rptWidth,noFields,colIndex,totColumn));
			htmlStrBuffer.append( getPrintFooter(noFields));
			htmlStrBuffer.append( "</table>");
		}
	
		htmlStr += htmlStrBuffer.toString();
	
	}//18
	
	
	//Header that will reflect on every page while printing
	private String getPrintHeader(String rptName,List rptHeader, 
	List rptWidth,List cmbHeader,List combo)
	{	
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		
		int colspan;
		String strFormat = "MMM dd,yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		java.util.Date dt = new java.util.Date();
		
		
		colspan = rptHeader.size() + 1;
		buffer.append("<thead style='DISPLAY:TABLE-HEADER-GROUP'>\n");
		buffer.append( "<tr>\n");
		buffer.append( "<td align = 'center' colspan = '" + colspan + "'><strong>\n");
		buffer.append( "<font size='3' face='Verdana, Arial, Helvetica, sans-serif'>\n");
		buffer.append( hsptName + "\n");
		buffer.append( "</font></strong>\n");
		buffer.append("</td>\n");
		buffer.append( "</tr>\n");
		buffer.append( "<tr>\n");
		buffer.append("<td align = 'center' colspan = '" + colspan + "'><strong>\n");
		buffer.append( "<font size='2' face='Verdana, Arial, Helvetica, sans-serif'>\n");
		buffer.append( "Report for " + rptName + "\n");
		buffer.append( "</font></strong>\n");
		buffer.append( "</td>\n");
		buffer.append( "</tr>\n");
		buffer.append("<tr>\n");
		buffer.append( "<td align = 'right' colspan = '" + colspan + "'>\n");
		buffer.append( "<font size='2' face='Verdana, Arial, Helvetica, sans-serif'>\n");
		buffer.append( "<strong>Date of Report : </strong>\n");
		buffer.append(sdf.format(dt));
		buffer.append("</font></td>\n");
		buffer.append("</tr>");
		
		for(i = 0; i<cmbHeader.size();i++)
		{
			buffer.append( "<tr>\n");
			buffer.append("<td height='19' colspan = '" + colspan + "'>\n");
			buffer.append("<Strong>" + cmbHeader.get(i) + " :</Strong>\n");
			buffer.append( combo.get(i) + "\n");
			buffer.append( "</td>");
			buffer.append( "</tr>\n");
		}
      
      	buffer.append("<tr>\n");
		buffer.append( "<td colspan = '" + colspan + "'><hr></td>\n");
		buffer.append("<tr>\n");
		
		for(i = 0;i<colspan;i++)
		{
			if(i == 0)
			{
				buffer.append( "<td width = '5%' align = 'left'>\n");
				buffer.append( "<font size='3'>\n");
				buffer.append( "<strong>S.No</strong>\n");
				buffer.append( "</font></td>\n");
			}
			else
			{
				buffer.append( "<td width='" + rptWidth.get(i-1) + "%' align = 'left'>\n");
				buffer.append("<font size='3'>\n");
				buffer.append("<strong>" + rptHeader.get(i-1) + "</strong>\n");
				buffer.append("</font>\n");
				buffer.append( "</td>");
			}
		}
	  	
	  	buffer.append( "</tr>\n");
      	buffer.append( "<tr>\n");
		buffer.append( "<TD COLSPAN = '" + colspan + "'><HR></TD>\n");  
		buffer.append( "</tr>\n");
		buffer.append( "</thead>\n"); 
		
		return buffer.toString();
	}//19
	
	
	//Data rows 
	private String getPrintData(List AL_List,List rptWidth,int noFields,
	List colIndex,int totColumn) 
	{
		StringBuffer buffer = new StringBuffer();
		
		String tempVal = "";
		int i = 0,index = 0;
		int j = 0;
		int noRows = AL_List.size()/totColumn;
		
		buffer.append( "<tbody>\n");
				   	
		for(i = 0;i<noRows;i++)
		{
			buffer.append( "<tr>\n");
			buffer.append("<td align = 'left' width = '5%'>" + (i+1) + ".</td>\n");
			
			for(j = 0;j<noFields;j++)
			{
				index = Integer.parseInt((String)colIndex.get(j)) - 1;
				buffer.append("<td align = 'left' width = '" + rptWidth.get(j) + "'>");
				tempVal = (String)AL_List.get(i*totColumn + index);
				buffer.append( tempVal.trim() + "</td>\n");
			}
			buffer.append( "</tr>\n");
		}
		
		buffer.append("");
		return buffer.toString();
	}//20
	
	//Footer that will reflect on every page while printing
	private String getPrintFooter(int colspan)
	{
		StringBuffer buffer = new StringBuffer();
		
		
		buffer.append("<tfoot style='DISPLAY:TABLE-FOOTER-GROUP'>\n");
		buffer.append( "<tr>\n");
		buffer.append( "<TD COLSPAN = '" + (colspan + 1) + "'><HR></TD>\n");
		buffer.append( "</tr>\n");
		buffer.append( "\n");
		
		return buffer.toString();
	}//21
	
}//end of class</table>