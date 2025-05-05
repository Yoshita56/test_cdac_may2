  <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html> 
<head>
<meta charset=utf-8>
<title><%=request.getParameter("masterName") %>Report Page</title>
</head>    
<%    
String p[]=request.getParameterValues("combo");
String comboString="";
String cnt_page=request.getParameter("cnt_page"); 
if(p !=null)
{
for(int i=0;i<p.length;i++){
	comboString +="<input type='hidden' name='combo' value='"+p[i]+"'>	";
	} 
}
%>

<script language="JavaScript" src="../../hisglobal/transactionutil/js/master.js"></script>
<body onLoad='fetchReportsData();'>
<html:form  action='<%=cnt_page%>' >
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="69">  
  <tr> 
    <td width="8%">&nbsp;</td>
    <td width="82%"> <div align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="4">
		Kasturba Hospital</font></b></div></td>
    <td width="10%">&nbsp;</td>
  </tr> 
  <tr> 
    <td width="8%">&nbsp;</td>
    <td width="82%"> <div align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="4">
		Mahatma Gandhi Institute of Medical Sciences</font></b></div></td>
    <td width="10%">&nbsp;</td>
  </tr>
  <tr> 
    <td width="8%">&nbsp;</td>
    <td width="82%"> <div align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="4">
		Sevagram</font></b></div></td>
    <td width="10%">&nbsp;
    
    	</td>
  </tr>
</table>
<TABLE ALIGN='CENTER' WIDTH='100%'><TR> <td align='center' ><b>Reports For<%=request.getParameter("masterName")%></b></td></tr></table>
	

<table width="100%" border="0" cellspacing="0" cellpadding="0" height="69">
  <tr>
	<td colspan=3>
		<div id="id1" align="right">
			<img style="cursor:hand" src='../../hisglobal/images/print_tab.gif'   tabindex=1 onClick='printData();' onKeyPress='printData();'>
			<img style="cursor:hand" src='../../hisglobal/images/btn-ccl.png'  tabindex=1 onClick='submitPage("CANCEL");' onKeyPress="submitPage('CANCEL');">			
		</div>
	</td>
  </tr>
 </table> 
<TABLE width='98%' ALIGN="center"  CELLPADDING="0" CELLSPACING="0" BORDER="0">
			<TR>
				<TD ALIGN="center">
					<TABLE width='98%'>
						<TR>
							<TD>
								<DIV ID="reportdata" ALIGN="top"></DIV>
							</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
	</TABLE>
<input type="hidden" name="hmode">
<input type="hidden" name="search" 			value ='<%=request.getParameter("search")%>' >
<input type='hidden' name='searchColumn' 	value='<%=request.getParameter("searchColumn")%>'>
<input type='hidden' name='prevNext' 		value='<%=request.getParameter("prevNext")%>'>
<input type='hidden' name='minrow' 			value='<%=request.getParameter("minrow")%>'>
<input type='hidden' name='blockNo' 		value='<%=request.getParameter("blockNo")%>'> 
<input type='hidden' name='comboValue' 		value='<%=request.getParameter("comboValue")%>'> 
<input type='hidden' name='no_of_combo'		value='<%=request.getParameter("no_of_combo")%>'> 
<input type='hidden' name='cnt_page'	value='<%=request.getParameter("cnt_page")%>'> 
<%=comboString%>
</html:form>
</body>
</html>