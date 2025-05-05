<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Rate Contract Details</title>
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
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/rate_contract_trans.js"></script>

<script language="Javascript" src="../js/searchItems_util.js"></script>

<script language="javaScript">

function getItemSelectPopup()
{
		var strModeVal 					= "2" ; 
		var strItemCategory 			= document.forms[0].strItemCategoryNo.value ;
		var strSupplierId   			= document.forms[0].strSupplierId.value ;  
		var strContractTypeId   		= document.forms[0].strContractTypeID.value ; 
		//alert("strItemCategory"+strItemCategory);
		//alert("strSupplierId"+strSupplierId);
		//alert("strContractTypeId"+strContractTypeId);
		var strRequestType				= "67";
		var strFromStoreId 				= "0";
		var strToStoreId  				= "0";
		
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strTenderItemNo','strRate','strUnitName','strRateContQty','strSecurityAmtPercent','strSecurityAmt');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','t','s','t','t','t');
		// for mode val 2
		var strMultiRowFetchDataArray 	= new Array('1','0^strUnitName^invokeCheckQty');
		
		var testFunction                = "setQtyDetails";
		var arg                         = " ";  
		
		var userInfo = "0";
		var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		
		var layerIndex = "1";		
		var strUserInfo = strSupplierId+'@'+strContractTypeId; 	 //    Orignal Vale
	    //alert('1');
	    //searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );
	    searchItems(strModeVal, strItemCategory, strRequestType, strFromStoreId, strMultiRowCompArray, strMultiRowCompTypeArray,strMultiRowFetchDataArray, layerIndex,strUserInfo);
}




</script>

</head>
<body onLoad="document.forms[0].strContractFromDate.focus();">
<html:form name="rateContractDtlBean" action="/transactions/RateContractDtlTransCNT" type="mms.transactions.controller.fb.RateContractDtlTransFB">
	<center>
	<div id="errMsg" class="errMsg"><bean:write name="rateContractDtlBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="rateContractDtlBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="rateContractDtlBean"
		property="strMsg" /></div>
   <tag:tab tabLabel="Rate Contract Details"	selectedTab="FIRST" align="center" width="TABLEWIDTH">
				
	</tag:tab>
	</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		
		<tr class="HEADER">
			<td colspan="4">Rate Contract >> ADD</td>
		</tr>

		<tr>
			<td class="LABEL" width="25%" >Supplier Name</td>
			<td width="25%" class="CONTROL" ><bean:write name="rateContractDtlBean"
				property="strSupplierName" filter="false" /></td>
				
				<td class="LABEL" width="25%" >Contract Type</td>
			<td width="25%" class="CONTROL" ><bean:write name="rateContractDtlBean"
				property="strContractType" filter="false" /></td>
				

		</tr>
		<tr>
			<td class="LABEL" width="25%" >Item Category</td>
			<td class="CONTROL" colspan="3"><bean:write name="rateContractDtlBean"
				property="strItemCategoryName" filter="false" /></td>
				
				

		</tr>
		<tr>
			<td class="TITLE"  colspan="4">Contract details</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Contract Date</td>
			<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strCtDate" filter="false"/></td>

			<td class="LABEL" width="25%"><font  color="red">*</font>Delivery Day(s)</td>
			<td class="CONTROL" >
			   <input type="text" class="txtFldMax"
					name="strDeliveryDays" maxlength="3" value="${rateContractDtlBean.strDeliveryDays}"
					onkeypress="return validateData(event,5);">
			</td>

		</tr>
		
		<tr>
				<td width="25%" class="LABEL" ><font  color="red">*</font>Contract From</td>
				<td width="25%" class="CONTROL"><dateTag:date name="strContractFromDate" value ="${rateContractDtlBean.strCtDate}"></dateTag:date></td>
					<td width="25%" class="LABEL"><font color="red">*</font>Contract To</td>
				<td width="25%" class="CONTROL"><dateTag:date name="strContractToDate" value ="${rateContractDtlBean.strNtDate}"></dateTag:date></td>
			</tr>
			
		    <tr>
				<td width="25%" class="LABEL"><font  color="red">*</font>Tender No.</td>
				<td width="25%" class="CONTROL"><input type="text" autocomplete='off' class="txtFldMax"
					name="strTenderNo" maxlength="50" value=""
					onkeypress=""></td>
					<td width="25%" class="LABEL">Quotation No.</td>
				<td width="25%" class="CONTROL"><input type="text" autocomplete='off' class="txtFldMax"
					name="strQuotationNo" maxlength="50" value=""
					onkeypress=""></td>
			</tr>
			
			<tr>
				<td class="LABEL" width="25%" colspan='1'><font  color="red">*</font>Tender Date:</td>
				<td class="CONTROL" width="25%" colspan='1'><dateTag:date name="strTenderDate"  id="strTenderDate"></dateTag:date> </td>
				
				<td class="LABEL" width="25%" colspan='1'>Quotation Date</td>
				<td class="CONTROL" width="25%"><dateTag:date name="strQuotationDate" id="strQuotationDate"></dateTag:date> </td>			    
			</tr>
		
		    <tr>
				<td class="LABEL" width="25%" colspan='1'>Tax Type:</td>
				<td class="CONTROL" width="25%"  colspan='1'>
						<select name="strTaxType" class="comboMin">
						<option value="1">GST</option>
						<!-- <option value="2">CST</option> -->				
					    </select>
			   </td>
				
				<td class="LABEL" width="25%" colspan='1'><div style='display:none;'><font  color="red">*</font>TAX(%)</div></td>
				<td class="CONTROL" width="25%"><div style='display:none;'><input type="text" autocomplete='off' class="txtFldMin"
					name="strTax" maxlength="2" value="${rateContractDtlBean.strTax}"
					onkeypress="return validateData(event,7);" onkeyup="notGreaterThanCent(this);"></div></td>			    
			</tr>
			
			<tr class="TITLE">
			<td colspan="4"><div align="right"><img style="cursor: pointer;height: 20px" 
			     id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
                 title='Click Here To Search Items' onclick='getItemSelectPopup();'/></div></td>
		</tr>
		
		</table><table class="TABLEWIDTH" align="center" bgcolor='#126ea8' cellpadding="1px" cellspacing="1px">
			<tr>
			<td width="15%" class="multiRPTLabel">Item/Drug Name</td>
			<td width="10%" class="multiRPTLabel">RC/Tender S.No.</td>
			<td width="8%" class="multiRPTLabel"><font color="red">*</font>Rate/Unit</td>
			<td width="8%" class="multiRPTLabel"><font color="red">*</font>Rate Unit</td>
			<td width="7%" class="multiRPTLabel">Qty.</td>
			<td width="7%" class="multiRPTLabel"><font color="red">*</font>Tax(%)	</td>
			<td width="8%" class="multiRPTLabel">Security Amt(%)	</td>
			<td width="10%" class="multiRPTLabel">Security Amt.</td>
			<td width="7%"  class="multiRPTLabel">Imported</td>
			<td width="7%"  class="multiRPTLabel"><font color="red">*</font>Shelf Life (In Days)</td>
			<td width="7%" class="multiRPTLabel"><font color="red">*</font>Level</td>
			<td width="7%" class="multiRPTLabel"><font color="red">*</font>Pack Size</td>
			</tr>
			</table>
			<div id="id1"></div>
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr class="FOOTER">
			 <td colspan="4"> </td>
		</tr>
			<tr >
    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Remarks</td>
    <td width ="50%" class ="CONTROL" colspan="2"><textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
  </tr>
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
src="../../hisglobal/images/btn-sv.png"
onClick=" return validate1();" title="Save Record"/> <img
style="cursor: pointer; " title="Clear Content"
src="../../hisglobal/images/btn-clr.png"
onClick="clearPage();" />
<img style="cursor: pointer; " title="Click Here Go Back To Main Desk" 
src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			
			</td>
		</tr>
	</table>-->
	
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="clearPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div> 
<input type="hidden" name="hmode"/>
<input type="hidden" name="ctDate" value="${rateContractDtlBean.strCtDate}"/>
<input type="hidden" name="strSupplierId" value="${rateContractDtlBean.strSupplierId}"/>
<input type="hidden" name="strSupplierName" value="${rateContractDtlBean.strSupplierName}"/>
<input type="hidden" name="strContractTypeID" value="${rateContractDtlBean.strContractTypeID}"/>
<input type="hidden" name="strContractType" value="${rateContractDtlBean.strContractType}"/>
<input type="hidden" name="strItemCategoryNo" value="${rateContractDtlBean.strItemCategoryNo}"/>
<input type="hidden" name="strItemCategoryName" value="${rateContractDtlBean.strItemCategoryName}"/>
<input type="hidden" name="strReOrderFlgColor" value="${rateContractDtlBean.strReOrderFlgColor}"/>



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

<cmbPers:cmbPers/>
</html:form>
<jsp:include page="rate_contract_item_search_row.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>