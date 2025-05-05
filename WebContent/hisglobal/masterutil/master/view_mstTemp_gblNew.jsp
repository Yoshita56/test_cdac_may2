<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

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
<title><%=masterName%></title> 
</head>    
<%
  String cnt_page=request.getParameter("cnt_page");
  String mode=request.getParameter("mode");
  //System.out.println("cnt_page = " + cnt_page);
%>

 <link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css"> 

<script language="JavaScript" src='<%=(String)request.getAttribute("js")%>' ></script>
<!-- ADD VALIDATION.JS ON SECURITY 27-mar-2018 -->
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<link href="../../masterutil/css/master.css" rel="stylesheet" type="text/css">
<body onLoad='fetchViewData();',onUnload="window.opener.closePopUp_master();">

<form>

<div align="center" style="color: red;"><%if(request.getParameter("strMsg") != null) request.getParameter("strMsg"); %></div>		
<TABLE ALIGN="center" WIDTH="100%" CELLPADDING="0" CELLSPACING="0" BORDER="0">
			<TR>     
				<TD ALIGN="center">
							<TABLE width='90%' align='center'>
								<TR>
								<TD>
								<DIV ID="viewdata" ALIGN="top"></DIV>
								</TD>
								</TR>
							</TABLE>
	    		 </TD>
			</TR>

	</TABLE> 
	
<input type="hidden" name="hmode" value='<%=mode%>' >
<input type='hidden' name='chk' 	value='<%=request.getParameter("chk")%>'> 
<input type="hidden" name="cntPage" value="<%=cnt_page%>" >
</form>
</body>
</html>