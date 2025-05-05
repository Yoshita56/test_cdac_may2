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
<style type='text/css'>
/* .SLIPCONTROL {
	
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

@media print {thead {display: table-header-group;}} */

   body {
        font-family: Courier, monospace; /* Use monospace font for consistent spacing */
        font-size: 12px; /* Adjust font size for readability on dot-matrix printer */
    }
    .receipt-container {
        max-width: 95ch; /* Limit width to fit typical dot-matrix paper width */
        margin: 0 auto;
    }
    .header {
        text-align: center;
        margin-bottom: 10px;
    }
    .billing-details {
        margin-bottom: 10px;
    }
    .billing-row {
        display: flex;
        justify-content: space-between;
    }
    .billing-item1, .billing-total {
        width: 5%;
    }
	.billing-item2, .billing-total {
        width: 40%;
    }
	.billing-item3, .billing-total {
        width: 12%;
    }
	.billing-item4, .billing-total {
        width: 10%;
    }
	.billing-item5, .billing-total {
        width: 10%;
    }
	.billing-item6, .billing-total {
        width: 12%;
    }
</style>
</head>
<body>
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

<form action="CashCollectionOfflineTransBSCNT.cnt" method="post">

<%-- <%if(new BillConfigUtil(hospcode).getLogoReq().equals("1")){%> --%>
<div class="row">

 <div class="col-sm-12" align="center"><%=strHeader%></div> 

</div>

<div class="row" style="justify-content: center;text-align: center;">
<!-- <div class="col-sm-4"></div> -->
<% if(request.getAttribute("isEstimation")!=null && request.getAttribute("isEstimation").equals("1"))
			{ %>
         <!--  <div class="col-sm-12"><b>ESTIMATION RECEIPT</b></div> -->
			<%}
//added as per the raebrali requirement by vipul on 20.07.2021
else if(request.getAttribute("isIPDFinal")!=null && request.getAttribute("isIPDFinal").equals("1")) 
			{ %>
			<!-- <div class="col-sm-12"><b>BILLING SERVICES RECEIPT - IPD Bill Settlement</b></div> -->
			<%}
			else 
			{%>
			<!-- <div class="col-sm-12"><b>BILLING SERVICES RECEIPT</b></div> -->
		<%  } %>
<!-- <div class="col-sm-2"></div> -->
</div>
	<div class="row">
	
	<div class="col-sm-12" align="center">
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
				    out.println("<pre>"+sb.toString()+"</pre>");
				}
			   
		    %>
	</div>

	</div>
			<div class="row">
			<% if(request.getAttribute("isEstimation")!=null && request.getAttribute("isEstimation").equals("1"))
			{ %>
			<div class="col-sm-12" align="center">NOT PAID
			</div>
			<%  } %>
			</div>
	
	

	
</form>


<script>
 $("#printModal").modal('show');
		//printSlip();
		modalSlipPrint();
		

</script>
</body>
</html>