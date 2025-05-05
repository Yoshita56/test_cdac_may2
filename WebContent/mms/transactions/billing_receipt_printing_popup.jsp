<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="java.io.*" %>
<%@ page import ="java.util.*,java.text.*" %> 
<%@page import="hisglobal.hisconfig.*,hisglobal.utility.HisUtil,billing.BillConfigUtil"%>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
<meta charset=utf-8><title>Bill Receipt Print Pop Up</title>


<link href="../css/transaction.css" rel="stylesheet" type="text/css" media="print">
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../transUtil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<style type='text/css'>
.SLIPCONTROL {
	
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
}
.SLIPCONTROLBOLD {
	
	font-family: Courier New;;
	font-size: 16px;
	font-style: inherit;
	font-weight: bold;
}

@media print {
thead {
display: table-header-group;
}}
#print {
    float: right;
}
</style>
</head>
<% 
		HisUtil hisUtil=new HisUtil("Billing","BillSlip");
		String hospcode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
		//final String strHeader=hisUtil.getHospitalHeader1(hospcode, 1, "html");
		
			Map require =new HashMap();
		require.put("REQUEST", request);
		require.put("FORMAT", "html");
		require.put("HOSPCODE", hospcode);
		final String strHeader=hisUtil.getHospitalHeaderMain(require);  //(hospcode, 1, "html");
%>
<body>
<form action="CashCollectionOfflineTransCNT.cnt" method="post">

<%-- <%if(new BillConfigUtil(hospcode).getLogoReq().equals("1")){%> --%>
	<%=strHeader%>
	<table style="border:1px solid black;border-collapse: collapse;background-color: rgba(186, 185, 185, 1); " width="100%" cellspacing="0"  cellpadding="0">
		<tr>
			<td class='SLIPCONTROL' colspan="6"><div align="center"><b></b></div></td>
		</tr>
		<tr>
		<% if(request.getAttribute("isEstimation")!=null && request.getAttribute("isEstimation").equals("1"))
			{ %>
				<td class='SLIPCONTROLBOLD' colspan="6"><div align="center"><b>ESTIMATION RECEIPT</b></div></td>
			<%}
			else 
			{%>
				<td class='SLIPCONTROLBOLD' colspan="6"><div align="center"><b>BILLING SERVICES RECEIPT</b></div></td>
		<%  } %>
		</tr>		
	</table>
			
	<table style="border:1px solid black;border-collapse: collapse; " width="100%" cellspacing="0"  cellpadding="0">
		<tr>
			<td width="100%">	
			<%
				if(request.getAttribute("filePath")!=null)
				{
					String file=request.getAttribute("filePath").toString();
					//String file="C:/NIMS/AHIMSG5/PrintTemp/Billing10047.dat";
					BufferedReader reader = new BufferedReader(new FileReader(file));
				    StringBuilder sb = new StringBuilder();
				    String line;
				    while((line = reader.readLine())!= null)
				    {
				    	sb.append(line+"\n");
				    }
				    out.println("<center><pre>"+sb.toString()+"</pre></center>");
				}
			   
		    %>
		    </td>
		</tr>
		<% if(request.getAttribute("isEstimation")!=null && request.getAttribute("isEstimation").equals("1"))
			{ %>
				<tr>
					<td width="80%" align='center' rowspan="1" height="55">NOT PAID</td>
				</tr>	
		<%  } %>
	</table>
	<%-- <% } 
	else 
	{%>
	<table width="100%" cellspacing="0"  cellpadding="0">
	<thead><tr style="height:100px;"><th></th></tr></thead>
	<tr><td><div align="center">
	<table style="border:1px solid black;border-collapse: collapse;background-color: rgba(186, 185, 185, 1); " width="100%" cellspacing="0"  cellpadding="0">
		<tr>
			<td class='SLIPCONTROL' colspan="6"><div align="center"><b></b></div></td>
		</tr>
		<tr>
		<% if(request.getAttribute("isEstimation")!=null && request.getAttribute("isEstimation").equals("1"))
			{ %>
				<td class='SLIPCONTROLBOLD' colspan="6"><div align="center"><b>ESTIMATION RECEIPT</b></div></td>
			<%}
			else 
			{%>
				<td class='SLIPCONTROLBOLD' colspan="6"><div align="center"><b>BILLING SERVICES RECEIPT</b></div></td>
		<%  } %>
		</tr>		
	</table>			
	<table style="border:1px solid black;border-collapse: collapse; " width="100%" cellspacing="0"  cellpadding="0">
		<tr>
			<td width="100%">	
			<%
				if(request.getAttribute("filePath")!=null)
				{
					String file=request.getAttribute("filePath").toString();
					//String file="C:/NIMS/AHIMSG5/PrintTemp/Billing10047.dat";
					BufferedReader reader = new BufferedReader(new FileReader(file));
				    StringBuilder sb = new StringBuilder();
				    String line;
				    while((line = reader.readLine())!= null)
				    {
				    	sb.append(line+"\n");
				    }
				    out.println("<center><pre>"+sb.toString()+"</pre></center>");
				}			   
		    %>
		    </td>
		</tr>
		<% if(request.getAttribute("isEstimation")!=null && request.getAttribute("isEstimation").equals("1"))
			{ %>
				<tr>
					<td width="80%" align='center' rowspan="1" height="55">NOT PAID</td>
				</tr>	
		<%  } %>
	</table>
	</div></td></tr></table>
	<% } %> --%>
   
	<!--  <input type="hidden" name="filePath" value="${cashCollectionOfflineTransBean.filePath}" />-->
	
</form>


<script>$("#printModal").modal('show');
		//printSlip();
		modalSlipPrint();
		
		window.onafterprint = function(){
			
			$("#printSection").css('display','none');
			$("#printModal").modal('hide');
			}
		
</script>
</body>
</html>