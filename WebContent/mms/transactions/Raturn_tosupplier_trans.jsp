<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<head>
<meta charset=UTF-8">
<title>Return To Supplier</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../mms/js/mms.js"></script>
<script language="Javascript" src="../../mms/js/return_to_supplietr_search_row.js"></script>
<script language="Javascript" src="../js/searchitem_jsforreturntosupplier.js"></script>
<script>
function setDates()
{
	//alert(1);
	document.forms[0].strcase.value = "2";
	//document.getElementsByName("strcase").value=1;
	/* if(document.getElementsByName("strcase")[0].checked==true)
	{
		document.getElementById("fromDateDivId").style.display='none';
		document.getElementById("toDateDivId").style.display='none';
	}
	else
	{
		document.getElementById("fromDateDivId").style.display='';
		document.getElementById("toDateDivId").style.display='';
	} */
}
function showdiv()
{
	//alert(document.getElementsByName("strcase")[1].checked);
	if(document.getElementsByName("strcase")[1].checked==true)
	{
		document.getElementById("approvedByCmb").style.display='none';
		document.getElementById("verifyid").style.display='none';
	}
	else
	{
		document.getElementById("approvedByCmb").style.display='';
		document.getElementById("verifyid").style.display='';
	}
	
}
</script>	


</head>
<body onload="setDates();">
<html:form name="ReturnToSupplierBean" action="transactions/MiscellaneousConsumptionTransCNT" type="mms.transactions.controller.fb.MiscellaneousConsumptionTransFB">
	
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="ReturnToSupplierBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="ReturnToSupplierBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="ReturnToSupplierBean" property="strNormalMsg" /></div>

	
<tag:tab tabLabel="Return To Supplier"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
 </center>

<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
	 
	<tr class="FOOTER">
			<td colspan="4" >
			<span>
     		<html:radio property="strcase"   name="ReturnToSupplierBean" value="1"   onclick="showdiv();">Expired</html:radio>
     		<html:radio property="strcase"   name="ReturnToSupplierBean" value="2" onclick="showdiv();">Condamination</html:radio>
     	</span>
			</td>
		</tr>
	
	<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Store Name</td>
			
      		<td width="25%" class ="CONTROL" align="center" > 
		      <html:select name="ReturnToSupplierBean" styleClass="comboMax" property="strStoreId" onchange="getItemCategoryCmb();">
		       <bean:write name="ReturnToSupplierBean" property="strStoreNameValues" filter="false"/>
       		  </html:select>
     	   </td>
     	   <td class="LABEL" width="25%"><font color="red">*</font>Item Category</td>
  		 	<td width="25%" class ="CONTROL" align="center" > <div id="itemCatDivId">      
       		<select name="strItemCategoryId1" class="comboNormal"><bean:write name="ReturnToSupplierBean" property="strItemCategoryValues" filter="false"/></select>
       		</div>
      		</td>
	</tr>
</table>
<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		
	<tr class="TITLE">
	  <td colspan="4"><div id='' align="right">
		<div>
		  <img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"  title='Click to Search Items' onclick='getItemSelectPopup();'>
		</div>
	  </td>
	</tr>
	</table>
 <table class="TABLEWIDTH" align="center"cellpadding="1px" cellspacing="1px" bgcolor="black">
   <tr>
   
	   <td class='multiRPTLabel' width='30%'>Item/Drug Name</td>
	   <td class='multiRPTLabel' width='10%'>Batch/Serial No.</td>
	   <td class='multiRPTLabel' width='5%'>Avl Qty</td>
	   <td class='multiRPTLabel' width='10%'><font color="red">*</font>Consumption Qty</td>
	   <td class='multiRPTLabel' width='10%'><font color="red">*</font>Consumption unit</td>
	   <td class='multiRPTLabel' width='5%'><font color="red">*</font>Rate</td>
	   <td class='multiRPTLabel' width='10%'><font color="red">*</font>Manuf. Date</td>
	   <td class='multiRPTLabel' width='10%'><font color="red">*</font>Expiry Date</td>
	    <td class='multiRPTLabel' width='10%'><font color="red">*</font>Supplier</td>
    </tr>
  </table>
    <div id="id1"></div>
    <table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6"></td>
		</tr>
		
		<tr>
					<td width="25%" class="LABEL" id="verifyid" ><Font color="red">*</Font>Verified By</td>
					<td width="25%" class="CONTROL">
					<div id="approvedByCmb">
					<html:select name="ReturnToSupplierBean" styleClass="comboMax" property="strverifyby" onchange="getItemCategoryCmb();">
				       <bean:write name="ReturnToSupplierBean" property="strverifybyNameValues" filter="false"/>
		       		  </html:select>
					</div>
					</td>
					<td width="25%" class="LABEL" ><Font color="red">*</Font>Verified Date</td>
					<td width="25%" class="CONTROL"><dateTag:date name="strVerifiedDate" value =""></dateTag:date></td>
				</tr>
		</table>
    <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
    <tr>
    <td class="LABEL" width="50%" colspan="1">Remarks</td>
	    <td width="50%" class ="CONTROL" colspan="1"><textarea name="strRemarks"cols="16" rows="2"></textarea> </td>
    </tr>
   </table>
    
	<table class="TABLEWIDTH" align="center"cellpadding="1px" cellspacing="1px">
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
</table>
<!-- 
<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" title="Click to Save Record"/>
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Click to Clear Page" onClick="Clear();" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Click to cancel process"   onClick="cancelFunc();" >
		</td>
		</tr>
</table>-->
<br>
    <div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
					</div> 
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strStoreName" value=""/>
	<input type="hidden" name="strReOrderFlgColor"	value="${ReturnToSupplierBean.strReOrderFlgColor}">
	<input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
	
		

<cmbPers:cmbPers />

<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="searchItemsDtlsDivId" style="display:block;"></div>
</tr>
</table>
</div>


</html:form>
<jsp:include page="return_to_supplietr_search_row.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
