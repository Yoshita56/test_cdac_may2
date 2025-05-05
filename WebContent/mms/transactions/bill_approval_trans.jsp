<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<!--  
 * Developer :Deepak Tiwari
 * Version : 1.0 
 * Date : 02/April/2009
 * Module:MMS
 * Unit:Bill Approval   
 -->
 
<html>
<head>
<meta charset=UTF-8">
<title>Bill Approval View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/billApprovalTrans.js"></script>
<script language="javaScript">

function openBalAdvanceDtl(obj)
{
   display_popup_menu(obj,'balanceAdvancePopUp','450','410');
}
function getPONoSearchView()
{
   var ret=false;
   if(document.forms[0].strPONo.readOnly==false)
   {
      ret=true;
   }
         
   if(document.forms[0].strPONo.readOnly!=true && ret==true)
   { 
      var hmode = "LIST"; 
	  var url='BillApprovalTransCNT.cnt?hmode='+hmode;
	  var featuresList = "width=700,height=300,ALIGN=CENTER,left=300,top=300,scrollbars=yes";
	  myWindow = window.open(url,'popupWindow',featuresList); 
	  myWindow.focus();
		
	  if(! myWindow.opener){
		myWindow.opener = window;
   	  }
	  return false;
  }	  
  else
  {
    if(ret==true)
    {
       alert("No Searching allowed.Record already Opened.!!");
    }
  }
}
function view1(id1,id2,id3)
{
	  document.getElementById(id1).style.display="none";
	  document.getElementById(id2).style.display="block";
	  document.getElementById(id3).style.display="block";
}
function view2(id1,id2,id3)
{
	document.getElementById(id1).style.display="block";
	document.getElementById(id2).style.display="none";
	document.getElementById(id3).style.display="none";
}
</script>
</head>
<body onLoad="initPage();">
<html:form name="billApprovalTransBean" action="transactions/BillApprovalTransCNT"
	type="mms.transactions.controller.fb.BillApprovalTransFB" >
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="billApprovalTransBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="billApprovalTransBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="billApprovalTransBean" property="strNormalMsg"/></div>
</center>	

			<tag:tab tabLabel="Bill Approval Verify"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>



<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
	<tr>
		<td class="LABEL" colspan="1" width="25%">Store Name</td>
    	<td width="25%" colspan="1" class ="CONTROL">
    	<bean:write name="billApprovalTransBean" property="strStoreName" filter="false" /></td>
    	<td class="LABEL" colspan="1" width="25%">Bill Type</td>
    	<td width="25%" colspan="1" class ="CONTROL">
    	<bean:write name="billApprovalTransBean" property="strBillTypeName" filter="false" /></td>
	</tr>
	<tr>
		<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>PO No</td>
    	<td width="75%" colspan="3" class ="CONTROL">
    	    <div id="poNoWithPrefixDIV" align="left">
			  <select name="strPONoCmb"><bean:write property="strPONoCmb" name="billApprovalTransBean" filter="false"></bean:write></select>
			  <img align="top" style="cursor: pointer; " title="To click for Records" src="../../hisglobal/images/Go.png" onclick="goFunc();" />
		    </div> 
		</td>
   	</tr>
</table>

 <div id="onGOClickDtlsDivId" style="display:none">	
 
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr>		
		 <td  colspan="4" class="TITLE" width="100%">PO Details</td>	
		</tr>
	</table>
	
  <div id="poDtlDivId">	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr>
			<td width="25%" colspan="2" class="LABEL">
				PO Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="billApprovalTransBean" property="strPODate" />
			</td>
			<td width="25%" colspan="1" class="LABEL">PO Type</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="billApprovalTransBean" property="strPOType"  />
			</td>
	   </tr>
	   <tr>
	       <td width="25%" colspan="2" class="LABEL">
				Supplier Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="billApprovalTransBean" property="strSupplierName" filter="false" />
			</td>
			<td width="25%" colspan="1" class="LABEL">Category</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="billApprovalTransBean" property="strItemCategoryNameH" filter="false" />
			</td>
	   </tr>	   
     </table>
     <div class='popup' id='peneltyListDtlId' style="display:none">
	<div id ="peneltyItemListDtl"></div>
	</div>
   <div id="agentNameDivId" style="display:none">  
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">  
        <tr>
	       <td width="25%" colspan="2" class="LABEL">
				Agent Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="billApprovalTransBean" property="strAgentName" filter="false" />
			</td>
			<td width="25%" colspan="1" class="LABEL">Clearing Agent Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="billApprovalTransBean" property="strCAName" filter="false" />
			</td>
	   </tr>
     </table>
   </div>
   </div>
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr>		 
		 <td  colspan="4" class="TITLE" width="95%">Schedule Details</td>	
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center"> 
	 <tr>
	   <bean:write name="billApprovalTransBean" property="strScheduleDetails" filter="false" />
	 </tr>
	</table>	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr>		 
		 <td  colspan="4" class="TITLE" width="95%">Previous Payment Details</td>	
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center"> 
	 <tr>
	   <bean:write name="billApprovalTransBean" property="strPreviousPaymentDtls" filter="false" />
	 </tr>
	</table>	
	
	<div id="scheduleNoSelectHLPDivId"></div>
	
	<div id='otherDetailsDIV' style='display:block;'>		
		<div id="otherDtlDivId"> <bean:write name="billApprovalTransBean" property="strOtherDetails" filter="false" /></div>	
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr>
	  
	   <td class="TITLE" colspan="4" width="100%">Supplier Bill Details</td>
	 </tr>
	</table>
	<div id="suppBillDtlDivId">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">    
	<tr>
	    <td class="LABEL" width="25%" ><font color="red">*</font>Payment Status</td>
        <td class ="CONTROL" width="25%" >
            <select name="strPaymentStatus">
               <option value="1">Full Payment</option>
               <option value="2">Partial Payment</option>
            </select>
        </td>
        <td class="LABEL" width="25%" ><font color='red'>*</font>Payment Date</td>
        <td class ="CONTROL" width="25%" >     
	          <date:date name="strPaymentDate" value="${billApprovalTransBean.strCurrentDate}"></date:date>
       </td>  </tr>
       
    <tr>
	    <td class="LABEL" colspan="1" width="25%"><font color="red">*</font>UTR No</td>
	    <td class="CONTROL" colspan="1" width="25%">
	       <input type="text"  name="strUTRNo" value="" class="txtFldMax" onkeypress="" maxlength="14">
	    </td>
	    
	     <td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Bill Amt</td>
	    <td class="CONTROL" colspan="1" width="25%">
	       <input type="text"  name="strBillAmount" value="${billApprovalTransBean.strBillAmount}" class="txtFldMax" onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event))" maxlength="14">
	    </td>
	    
    </tr>
    </table>
  
    <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">    
    <tr>
	    <td class="LABEL" colspan="3" width="50%"><font color='red'>*</font>Remarks</td>
	    <td class="CONTROL" colspan="2" width="50%">
	       <textarea rows="3" cols="15" name="strRemarks"></textarea>
	    </td>
    </tr>
    </table>  
 </div>
 </div>
 
<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	    <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
		<tr>
			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearDtl('requestPage');" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel1();" >
		</td>
		</tr>
</table>
<div id="balanceAdvancePopUp" class="popup" style="display:none">
   <table border="0" width="100%" cellpadding="1px" cellspacing="1px">
     <tr class="HEADER">
        <td width="96%" colspan="4">Balance Advance Details</td>
        <td width="4%" colspan="1"><img align="right" style="cursor: pointer; " src="../../hisglobal/images/popUp_cancel.JPG" onClick="hide_popup_menu('balanceAdvancePopUp');" /></td>
     </tr>
     <tr>
        <td class="LABEL" width="25%" colspan="1">Advance Taken</td>
        <td class="CONTROL" width="25%" colspan="1"><bean:write name="billApprovalTransBean" property="strAdvanceTaken"/></td>
        <td class="LABEL" width="25%" colspan="1">Advance Adjusted</td>
        <td class="CONTROL" width="25%" colspan="2"><bean:write name="billApprovalTransBean" property="strAdvanceAdjusted"/></td>
     </tr>
   </table>      
</div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>  
<input type="hidden" name="strBillAmtAfterPayment" value="${billApprovalTransBean.strBillAmount}" />
<input type="hidden" name="strCurrentDate" value="${billApprovalTransBean.strCurrentDate}" />
<input type="hidden" name="strSupplierId" value="${billApprovalTransBean.strSupplierId}" />
<input type="hidden" name="strPOPrefix" value="${billApprovalTransBean.strPOPrefix}" />
<input type="hidden" name="strPONo" value="${billApprovalTransBean.strPONo}" />
<input type="hidden" name="strPODate" value="${billApprovalTransBean.strPODate}" />
<input type="hidden" name="strPOStoreId" value="${billApprovalTransBean.strPOStoreId}" />
<input type="hidden" name="strPOTypeId" value="${billApprovalTransBean.strPOTypeId}" />
<input type="hidden" name="strStoreName" value="${billApprovalTransBean.strStoreName}" />
<input type="hidden" name="strBillTypeName" value="${billApprovalTransBean.strBillTypeName}" />
<input type="hidden" name="strBillType" value="${billApprovalTransBean.strBillType}" />
<input type="hidden" name="strAgentNameShow" value="${billApprovalTransBean.strAgentNameShow}" />
<input type="hidden" name="strStoreId" value="${billApprovalTransBean.strStoreId}" />
<input type="hidden" name="strItemCategoryNoH" value="${billApprovalTransBean.strItemCategoryNoH}" />
<input type="hidden" name="strItemCategoryNameH" value="${billApprovalTransBean.strItemCategoryNameH}" />
<input type="hidden" name="strCurrencyValue" value="${billApprovalTransBean.strCurrencyValue}" />
<input type="hidden" name="strCurrencyId" value="${billApprovalTransBean.strCurrencyId}" />
<input type="hidden" name="strCurrencyName" value="${billApprovalTransBean.strCurrencyName}" />
<input type="hidden" name="strLatePenelty" value="" />
<input type="hidden" name="strRejectedPenelty" value="" />

<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>
