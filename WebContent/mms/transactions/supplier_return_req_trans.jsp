<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<!--  
 * Developer : Deepak Tewari
 * Version : 1.0 
 * Date : 23/Jan/2009
 * Module:MMS
 * Unit:Supplier Return Request Details   
 -->
 
<html>
<head>
<meta charset=UTF-8">
<title>Supplier Return Request Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../mms/js/supplier_return_req.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="javaScript">
function getItemSelectPopup()
{
	    var strFromStoreId              = document.forms[0].strStoreId.value; 
		var strModeVal 					= "3" ; 
		var strItemCategory 			= document.forms[0].strItemCategoryNoH.value ; 
		var strIssueType 				= "0";
		var strRequestType              = "47";
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strUnitName','strReturnQty');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','s','s','t');
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName^unitCmbChng');
		var layerIndex                  = "1";
		var userInfo                    = document.forms[0].strPONo.value  + "^" + document.forms[0].strPOStoreId.value;
	    searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex ,userInfo);
}
	
function goFunc()
{
	var hisValidator = new HISValidator("supplierReturnReqBean");
    hisValidator.addValidation("strItemCatNo","dontselect=0","Please select value from Item Category Combo" );
    hisValidator.addValidation("strPONo","req","Please enter PO No" );
    var retVal = hisValidator.validate();
    //alert(document.forms[0].strPONo.value.length);
   
	if(retVal)
	{
	 	document.forms[0].strItemCategoryNoH.value =document.forms[0].strItemCatNo.value;
	 	document.forms[0].strItemCategoryNameH.value =document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;
	 	document.forms[0].hmode.value="GET_PO_DETAILS";
	 	document.forms[0].submit();
	 	
	}
	 else
	{
		return false;
	}
}	

function showDetails()
{
   if(parseInt(document.forms[0].strPONo.value)>0) 
   {
        document.getElementById("PODetailsDIV").style.display="block";
		document.getElementById("itemCatCmbDIV").innerHTML=document.forms[0].strItemCategoryNameH.value;
		document.forms[0].strPONo.readOnly=true;
   }
}
function getPONoSearchView()
{
   var ret=false;
   if(document.forms[0].strPONo.readOnly==true)
   {
      ret=true;
   }
   else
   {
      if(document.forms[0].strItemCatNo.value!="0")
        ret=true;
      else
      {
        alert("Please select value from Item Category Combo");
        ret=false;
      }
   }   
         
   if(document.forms[0].strPONo.readOnly!=true && ret==true)
   { 
      var hmode = "LIST"; 
	  var url='SupplierReturnReqTransCNT.cnt?hmode='+hmode;
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

function onReplace(obj)
{
  var divId=document.getElementById("deliveryDateDIV");
  if(obj.value=="1")
  {
     divId.style.display="block";
  }
  else
  {
     divId.style.display="none"; 
  }
}
</script>

</head>
<body onLoad="showDetails();"> 
<html:form name="supplierReturnReqBean" action="transactions/SupplierReturnReqTransCNT"
	type="mms.transactions.controller.fb.SupplierReturnReqTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="supplierReturnReqBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="supplierReturnReqBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="supplierReturnReqBean" property="strNormalMsg"/></div>
</center>
	
<center>
    <tag:tab tabLabel="Supplier Return Request" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
</center>

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
	    <tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Store Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<font color="blue"><bean:write name="supplierReturnReqBean" property="strStoreName" filter="false" /></font>
			</td>
		
			<td width="25%" colspan="1" class="LABEL">Req Date &amp; Time</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <font color="blue"><bean:write name="supplierReturnReqBean" property="strCurrentDate" filter="false" /></font>
			</td>
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Item Category
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			 <div id="itemCatCmbDIV">
			    <select name="strItemCatNo">
			       <bean:write name="supplierReturnReqBean" property="strItemCatValues" filter="false"/>
			    </select>
			 </div>   
			</td>
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			PO No.
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			  <input type="text" name="strPONo" class="txtFldMax" value="${supplierReturnReqBean.strPONo}">
			  <img align="middle" style="cursor: pointer; " title="Click To Search for PO No Detail List" src="../../hisglobal/images/viewDetails.gif" onclick="getPONoSearchView();"/>
			  <img align="middle" style="cursor: pointer; " title="Click To get PO Details" src="../../hisglobal/images/Go.png" onclick="goFunc();" />
			</td>
		</tr>
	</table>
	
  <div id="PODetailsDIV" style="display:none">	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="TITLE">
			<td colspan="4">PO Details
			</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				PO Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnReqBean" property="strPODate" />
			</td>
			<td width="25%" colspan="1" class="LABEL">PO Type</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="supplierReturnReqBean" property="strPOType"  />
			</td>
	   </tr>
	   <tr>
	   
	       <td width="25%" colspan="1" class="LABEL">
				Supplier Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnReqBean" property="strSupplierName" filter="false" />
			</td>
			<td width="25%" colspan="1" class="LABEL">PO Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="supplierReturnReqBean" property="strPOStoreName" filter="false" />
			</td>
	   </tr>
     </table>
 
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr class="TITLE">
			<td colspan="4"><div align="right"><img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
 onclick='getItemSelectPopup();'></div>
			</td>
		</tr>
		
     </table>
 
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			<td width="15%" class="multiLabel">Item/Drug Name
			</td>
			<td width="15%" class="multiLabel">Batch/Serial No.
			</td>
			<td width="15%" class="multiLabel">Received Qty
			</td>
			<td width="15%" class="multiLabel">Avl Qty
			</td>
			<td width="15%" class="multiLabel"><font size="1" color="red">*</font>Return Quantity
			</td>
			<td width="15%" class="multiLabel"><font size="1" color="red">*</font>Unit Name
			</td>
			<td width="10%" class="multiLabel">Cost
			</td>
			</tr>
	</table>
 		
	<div id="id1"></div>
	
	
		   <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
             <tr>
		         <td colspan="5" class="LABEL" width="80%">Total Return Cost</td>
		         <td colspan="1" class="multiControl" width="20%">
		            <div id="strTotalReturnCostDivId" style="color: red;font-weight:bold">0.00</div>
		            <input type="hidden" name="strTotalReturnCost">
		         </td>
	         </tr>	
	       </table>   
	 		
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="TITLE">
			<td colspan="4">Return Details
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL" ><font size="1" color="red">*</font>
			Return Type
			</td>
			<td width="50%" colspan="2" class="CONTROL" >
			    <select name="strReturnType"  onchange="onReplace(this);">
			      <option value = "1">Replacement</option>
			      <option value = "2">Return</option>
			    </select>
			</td>
	   </tr>
	   <tr>
			<td width="100%" colspan="4">
			  <div id="deliveryDateDIV" style="display:block">
			    <table width="100%" align="center" cellpadding="0px" cellspacing="0px">
			      <tr>
			         <td width="50%" colspan="2" class="LABEL" ><font size="1" color="red">*</font>
			           Delivery Date
			         </td>
			         <td width="50%"colspan="2"  class="CONTROL" >
			           <date:date name="strDeliveryDate" value="${supplierReturnReqBean.strDeliveryDate}"></date:date>
			         </td>
			      </tr>
			    </table>
			   </div>
			</td>      
	   </tr>
	   <tr>
			<td colspan="2" width="50%" class="LABEL"><font size="1" color="red">*</font>Return Reason</td>
			<td colspan="2" width="50%" class="CONTROL">
			   <select name="strReturnReason"  onchange="">
			      <option value = "1">Rejected</option>
			      <option value = "2">Breakage</option>
			      <option value = "3">Excess</option>
			      <option value = "4">LP Return</option>
			    </select>
    	 	</td>
		</tr>
		<tr>
			<td colspan="2" width="50%" class="LABEL"><font size="1" color="red">*</font>Remarks</td>
			<td colspan="2" width="50%" class="CONTROL">
			<textarea name="strRemarks" rows="2"></textarea>
    	 	</td>
		</tr>
	</table>
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
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>  
<input type="hidden" name="strCurrentDate" value="${supplierReturnReqBean.strCurrentDate}" />
<input type="hidden" name="strSupplierId" value="${supplierReturnReqBean.strSupplierId}" />
<input type="hidden" name="strPODate" value="${supplierReturnReqBean.strPODate}" />
<input type="hidden" name="strPOStoreId" value="${supplierReturnReqBean.strPOStoreId}" />
<input type="hidden" name="strStoreName" value="${supplierReturnReqBean.strStoreName}" />
<input type="hidden" name="strStoreId" value="${supplierReturnReqBean.strStoreId}" />
<input type="hidden" name="strItemCategoryNoH" value="${supplierReturnReqBean.strItemCategoryNoH}" />
<input type="hidden" name="strItemCategoryNameH" value="${supplierReturnReqBean.strItemCategoryNameH}" />
<input type="hidden" name="comboValue" value="${supplierReturnReqBean.strStoreName}" />

<cmbPers:cmbPers />
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="searchItemsDtlsDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>

</html:form>
<jsp:include page="suppReturnReqSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>