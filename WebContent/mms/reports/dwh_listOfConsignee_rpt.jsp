<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>List Of Consignee Report</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	


<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>
<script language="Javascript" src="../../hisglobal/js/dateDifference.js"></script>
<script language="Javascript" src="../../mms/js/dwh_listOfConsignee_rpt.js"></script>

</head>
<body >
<html:form action="/reports/ListOfConsigneeRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="listOfConsigneeRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="listOfConsigneeRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="listOfConsigneeRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="List Of Consignee Report" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
	
		<tr>
			<td width="50%" colspan="1" class="LABEL">Supplier Name</td>
			<td width="50%" colspan="1" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strSupplierId" class="comboNormal" onchange="resetPODetailsHlpDivId();">
					<bean:write name="listOfConsigneeRptFB" property="strManufactureCombo" filter="false"/>
				</select>
			</div>				
			</td>
			<td width="20%" colspan="3" class="LABEL"></td>
		</tr>		
		
		
     </table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

 
         <tr>
			<td class="LABEL" width="25%" ><font color="red">*</font>Order From Date</td>
			<td class="CONTROL" width="25%" ><dateTag:date name="strOrderFromDate" value="${listOfConsigneeRptFB.strCurrentDate}" /></td>
			<td class="LABEL" width="25%" ><font color="red">*</font>Order To Date</td>
			<td class="CONTROL" width="25%" ><dateTag:date name="strOrderToDate" value="${listOfConsigneeRptFB.strCurrentDate}" /></td>
			
		</tr>
		<tr>
		  
		  <td class="CONTROL" colspan="4"><div id='id' align='center'><img style="cursor: pointer" src="../../hisglobal/images/Go.png" onclick="generatePoDetailHlp();" /></div></td>
		</tr>	
		
			
	</table>
	<div id="showMandatoryBefore" style="display:block;"> 
		<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
			<tr class="FOOTER">
				 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
			</tr>
		</table>
	</div>
	<div id="PODetailsHlpDivId" style="display:block;"></div>
	
	<%-- Pop up Main Screen --%>
	<div id="blanket" style="display:none;"></div>
    <div class="popUpDiv" id="popUpDivMain" style="display:none;">
	    <table bgcolor="white">
	    	<tr>
		      	<td>
		           <div id="ConsigneeDetailHlpPopUpPrintDivId" style="display:block;"></div>
		       	</td>
	     	</tr>
	    </table>
   	</div>
	
<!-- 	 Pop up Main Screen -->
<!--  <div id="blanket" style="display:none;"></div>  -->
<!--     <div class="popUpDiv" id="popUpDivMain" style="display:none;">  -->
<!--     <table bgcolor="white">  -->
<!--       <tr>  -->
<!--        <td>  -->
<!--             <div id="suppPerformanceDtlsDivIdMain" style="display:block;"></div>  -->
<!--        </td>  -->
<!--       </tr>  -->
<!--      </table> -->
<!--     </div>  -->


<div id="showButtonID" style="display:none;"> 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="genrateConsigneeDetailHlpPrint();" />
<!-- 		<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getSuppPerformanceDtlPrint();" /> -->
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="resetPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
	
</div>

<!-- <div id="blanket" style="display:none;"></div> -->
<!--    <div class="popUpDiv" id="listOfConsigneeDtlMainDivId" style="display:none;"> -->
<!--    <table bgcolor="white"> -->
<!--      <tr> -->
<!--       <td> -->
<!--            <div id="PODetailDivId" style="display:block;"></div> -->
           
<!--        </td> -->
<!--      </tr> -->
<!--     </table> -->
<!--   </div> -->
	
	
	
	
	<input type="hidden" name="strSecCheckHidValue"></input>
	<input type="hidden" name="hmode"></input>
	<input type="hidden" name="strCurrentDate" value="${listOfConsigneeRptFB.strCurrentDate}" />
	
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
