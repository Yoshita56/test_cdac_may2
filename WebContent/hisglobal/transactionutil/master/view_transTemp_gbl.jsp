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
<title><%=request.getParameter("masterName") %></title> 
</head>    
<%
  String cnt_page=request.getParameter("cnt_page");
  String mode=request.getParameter("mode");
%>

<script language="JavaScript" src='<%=(String)request.getAttribute("js")%>' ></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../transactionutil/js/master.js"></script>
<link href="../../transactionutil/css/master.css" rel="stylesheet" type="text/css">

<body onLoad='fetchViewData();',onUnload="window.opener.closePopUp_master();">

<form>

<div align="center" style="color: red;">
<%
	//System.out.println((String)request.getAttribute("strMsg"));
	if((String)request.getAttribute("strMsg") != null) 
		out.println((String)request.getParameter("strMsg"));
%>
</div>		
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
<input type="hidden" name="cnt_page" value='<%=cnt_page%>'>

</form>
</body>
</html>