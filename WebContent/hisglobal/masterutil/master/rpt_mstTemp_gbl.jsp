<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="hisglobal.utility.HisUtil"%>
<%@ page import="hisglobal.vo.HospitalMstVO"%>
<%@ page import ="java.util.*,java.text.*" %>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% 
String temp="";
if(request.getParameter("masterName")!=null)
temp=(String)request.getParameter("masterName");
else
	temp="Master";
String masterName=temp.split("#")[0];
%>
<title><%=masterName%> Report Page</title>
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
String isGlobal="";
String hospitalName="";
String hospitalAdd="";
String hospitalPlace="";
String hospitalContact="";
if(request.getParameter("isGlobal")!=null)
	isGlobal=(String)request.getParameter("isGlobal");
else
	isGlobal="0";
/* if(!isGlobal.equals("1"))
{
	HospitalMstVO hospitalVO=ControllerUTIL.getHospitalVO(request);
	hospitalName=hospitalVO.getHospitalName();
	hospitalAdd=hospitalVO.getAddress1();
	if(hospitalVO.getAddress2()!=null && !hospitalVO.getAddress2().equals(""))
	hospitalPlace=hospitalVO.getAddress2()+(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("")?", "+ hospitalVO.getCity():"")+"-"+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("")? hospitalVO.getPinCode():"***")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("")?", "+ hospitalVO.getState():"")+"(INDIA)";
	else
	hospitalPlace=(hospitalVO.getCity()!=null && !hospitalVO.getCity().equals("")? hospitalVO.getCity()+"-":"")+(hospitalVO.getPinCode()!=null && !hospitalVO.getPinCode().equals("")? hospitalVO.getPinCode():"***")+(hospitalVO.getState()!=null && !hospitalVO.getState().equals("")?", "+ hospitalVO.getState():"")+"(INDIA)";
	hospitalContact="Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("")?hospitalVO.getPhone():" -")+", "+"Fax :"+(hospitalVO.getFax()!=null && !hospitalVO.getFax().equals("")?hospitalVO.getFax():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("")?hospitalVO.getEmail():" -");
} */
String hospitalCode=(String)session.getAttribute("HOSPITAL_CODE");
HisUtil util=new HisUtil("HisGlobal","Master Report Page");
if(isGlobal.equals("1"))
	hospitalCode="100";
//String hospHeader=util.getHospitalHeader(hospitalCode,1,"html");

   	Map logoReq=new HashMap();
		      
		      logoReq.put("FORMAT", "html");
		      logoReq.put("REQUEST", request);
		      logoReq.put("HOSPCODE", hospitalCode);

String hospHeader=util.getHospitalHeaderMain(logoReq);
/* final ResourceBundle hisProp = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties"); 
final String header1 =hisProp.getString("PHDM_HEADER1");
final String header2 =hisProp.getString("PHDM_HEADER2");
final String header3 =hisProp.getString("PHDM_HEADER3");
final String header4 =hisProp.getString("PHDM_HEADER4");*/


%>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<link href="../../hisglobal/masterutil/css/master.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
//window.onscroll = scroll;

/* function scroll () 
{
 //alert("scroll event detected! " + window.pageXOffset + " " + window.pageYOffset);
 // note: you can use window.innerWidth and window.innerHeight to access the width and height of the viewing area
 var appended = false;
 var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
 //alert(scrollTop);
  if (scrollTop > 500) 
  {
    if (!appended) 
    {
       document.getElementById("toTopDiv").style.display="block";
       appended = true;
    }
  } 
  else 
  {
    if (appended) 
    {
       document.getElementById("toTopDiv").style.display="none";
      appended = false;
    }
  }
} */
</script>

<body onLoad='userInterface();' id="top">
<html:form  action='<%=cnt_page%>'>
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="69">
  <tr>
	<td>
		<div id="loadId" align="right" style="display: none"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="RED">
		Loading...			
		</font></b></div>
	</td>
	<td>
		<div id="id1" class="hidecontrol" align="right">
			<img src='../../hisglobal/images/print_on.gif' title='Click here to Print the Report' style="cursor:pointer" id="printId"  tabindex=1 style="cursor:pointer;" onClick='printData();' onKeyPress='printData();' height="25px" width="25px">
			<!-img src='../../hisglobal/images/save_button.gif' title='Click here to Print the Report' style="cursor:pointer" id="printId"  tabindex=1 style="cursor:pointer;" onClick='saveReportData();' onKeyPress='printData();'-->
			<img src='../../hisglobal/images/button_back.png' title='Click here to Go Back' style="cursor:pointer"  tabindex=1 style="cursor:pointer;" onClick='submitPage("CANCEL");' onKeyPress="submitPage('CANCEL');" height="25px" width="25px">
		</div>
	</td>
  </tr>
 </table>
  <%=hospHeader %>


<TABLE ALIGN='CENTER' WIDTH='100%' ><TR> <td align='center' ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">Reports For&nbsp;<%=masterName%></font></b></td></tr></table>
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
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="69">
  <tr>
	<td>
		<div id="id2" class="hidecontrol" align="right">
			<img src='../../hisglobal/images/print_on.gif' title='Click here to Print the Report' style="cursor:pointer" id="printId"  tabindex=1 style="cursor:pointer;" onClick='printData();' onKeyPress='printData();' height="25px" width="25px">	
			<!-img src='../../hisglobal/images/save_button.gif' title='Click here to Print the Report' style="cursor:pointer" id="printId"  tabindex=1 style="cursor:pointer;" onClick='printData();' onKeyPress='printData();'-->
			<img src='../../hisglobal/images/button_back.png' title='Click here to Go Back' style="cursor:pointer"  tabindex=1 style="cursor:pointer;" onClick='submitPage("CANCEL");' onKeyPress="submitPage('CANCEL');" height="25px" width="25px">
		</div>
		<div align="right" id='toTopDiv' style="display: block;"><img src='../../hisglobal/images/up_arrow.png' title='Go Top of The Page' style="cursor:pointer" onClick='javascript:scroll(0,0)' height="25px" width="25px" class='toTop'></div>
		
	</td>
  </tr>
 </table>
<input type="hidden" name="hmode">
<input type="hidden" name="search" 			value ='<%=request.getParameter("search")%>' >
<input type='hidden' name='searchColumn' 	value='<%=request.getParameter("searchColumn")%>'>
<input type='hidden' name='prevNext' 		value='<%=request.getParameter("prevNext")%>'>
<input type='hidden' name='minrow' 			value='<%=request.getParameter("minrow")%>'>
<input type='hidden' name='blockNo' 		value='<%=request.getParameter("blockNo")%>'> 
<input type='hidden' name='comboValue' 		value='<%=request.getParameter("comboValue")%>'> 
<input type='hidden' name='no_of_combo'		value='<%=request.getParameter("no_of_combo")%>'> 
<input type='hidden' name='cnt_page'	value='<%=request.getParameter("cnt_page")%>'> 
<input type="hidden" name="strReportConfig">
<input type='hidden' name='orderByName' id='orderById' value='<%=request.getParameter("orderByName")%>'>
<%=comboString%>
</html:form>
</body>
</html>