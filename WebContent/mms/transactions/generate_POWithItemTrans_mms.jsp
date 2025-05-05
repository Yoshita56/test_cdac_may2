<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>	
<meta charset=UTF-8">
<title>PO Desk</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" 	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>	
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>

<script language="Javascript" src="../../mms/js/POGenerateWithItem.js"></script>
<script language="Javascript" src="../../hisglobal/js/utilityFunctions.js"></script>
	
<script language="javascript">
		var progressEnd = 12; // set to number of progress <span>'s.
		var progressColor = '#1B82E6'; // set to progress bar color
		var progressInterval = 100; // set to time between updates (milli-seconds)
		
		var progressAt = progressEnd;
		var progressTimer;
		function progress_clear()
		{
			for (var i = 1; i <= progressEnd; i++) document.getElementById('progress'+i).style.backgroundColor = 'transparent';
			progressAt = 0;
		}
		function progress_update() 
		{
		    
			document.getElementById('showbar').style.visibility = 'visible';
			//document.getElementById('showbarMsg').style.visibility = 'visible';
			progressAt++;
			if (progressAt > progressEnd) 
			    progress_clear();
			else 
			    document.getElementById('progress'+progressAt).style.backgroundColor = progressColor;
			
			progressTimer = setTimeout('progress_update()',progressInterval);
		}
		function progress_stop() 
		{
			clearTimeout(progressTimer);
			progress_clear();
			document.getElementById('showbar').style.visibility = 'hidden';
			//document.getElementById('showbarMsg').style.visibility = 'hidden';
		}
		//progress_update(); // start progress bar

</script>
</head>
<body onLoad="pageResetMethod(3);">
<html:form action="/transactions/PODeskGenerateTransCNT">
	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="PODeskGenerateTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="PODeskGenerateTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="PODeskGenerateTransBean" property="strMsg" /></div>
<table align="center">
<tr><td>
<div id="showbar" style="font-size:8pt;padding:2px;border:solid black 1px;visibility:hidden">
<span id="progress1">&nbsp; &nbsp;</span>
<span id="progress2">&nbsp; &nbsp;</span>
<span id="progress3">&nbsp; &nbsp;</span>
<span id="progress4">&nbsp; &nbsp;</span>
<span id="progress5">&nbsp; &nbsp;</span>
<span id="progress6">&nbsp; &nbsp;</span>
<span id="progress7">&nbsp; &nbsp;</span>
<span id="progress8">&nbsp; &nbsp;</span>
<span id="progress9">&nbsp; &nbsp;</span>
<span id="progress10">&nbsp; &nbsp;</span>
<span id="progress11">&nbsp; &nbsp;</span>
<span id="progress12">&nbsp; &nbsp;</span>
</div>
</td></tr>
</table>

	<tag:tab tabLabel="Purchase Order Generation Form" selectedTab="FIRST"
				align="center" width="TABLEWIDTH">
			</tag:tab>
			
	</center>		
	<table class="TABLEWIDTH" align="center" cellspacing="0" id='divHeader'>
		<tr class="HEADER">
			<td colspan="3" width="95%" nowrap="nowrap"></td>
			<td width="5%" align="right"><img style='cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onclick='cancelToDesk()'></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">
	
	   <tr>
			<td class="LABEL" width="25%" colspan="1">PO Generation Period</td>
			<td class="CONTROL" width="25%" colspan="1">			
			    <html:select name="PODeskGenerateTransBean" property="strIndentPeriodValue" styleClass="comboNormal" >
	          	   <html:option value="1"> <bean:write name="PODeskGenerateTransBean" property="strCurrentFinancialYear" filter="false"/></html:option>
				   <html:option value="2"> <bean:write name="PODeskGenerateTransBean" property="strNextFinancialYear" filter="false"/></html:option>	          	
	            </html:select>			   
			</td>
			<td width="25%" class="LABEL"><font color="red">*</font>Purchase Order Date</td>
			<td width="25%" class="CONTROL">
			<div id='poRefDateDiv'></div><div id='poRefDateCalDiv'><dateTag:date name="strPORefrenceDate"  jsFunc="pageResetMethod(3);"  value ="" ></dateTag:date></div>
		    </td>

		</tr>
		
		
	
	
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskGenerateTransBean" property="strStoreId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strStoreName"
				filter="false"></bean:write></td>
				
				
				<td width="25%" class="LABEL"><div style="display:none"><font color="red">*</font>Supplier(*Marked
			are Rated Supplier)</div></td>
			<td width="25%" class="CONTROL">
			<div id="divSupplier" style="display:none"><select name="strSupplierId" class="comboMax" onChange="resetCombo();">
							
				<bean:write name="PODeskGenerateTransBean"  property="strSupplierValues" filter="false"></bean:write>
			</select>
			</div>
			<div id="divSupplierLabel"></div>
			</td>
				
				
			
		</tr>
		<tr>
			
			<tr>
			
			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category</td>
			<td width="25%" class="CONTROL">
			<html:hidden
				name="PODeskGenerateTransBean" property="strItemCat"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strItemCatName"
				filter="false"></bean:write>
			</td>

			<td width="25%" class="LABEL"><font color="red">*</font>PO Type
			</td>
			<td width="25%" class="CONTROL">
			<html:hidden
				name="PODeskGenerateTransBean" property="strPOTypeId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strPOType"
				filter="false"></bean:write>
			</td>
		</tr>
		</tr>
				
		<tr>
		  <td width="25%" class="LABEL"><font color="red">*</font>Item Name</td>
			<td width="25%" class="CONTROL">
			<div id="divPOItemDtl"><select name="strPOItemID" onChange="getUnitCombo();">
				<option value="0">Select Value</option>
			</select></div>
			</td>
								
				<td colspan="1" class="LABEL" width="25%">
						
				</td>
								
				<!-- <td width="25%" class="LABEL" width="15%" style="text-align:left;"><div id="imageDiv"><html:img src="../../hisglobal/images/Go.png" align="left" style="cursor:pointer" title="Click to see Purchase Details" onclick="progress_update();putDaynamicDiv(1);" /></div></td>
				 -->
				<td>
				<div align="center" id="imageDiv">					 
					 	<a href="#" class="button" id="go" onclick='progress_update();putDaynamicDiv(1);'></a>
					</div> 
				</td>
			</tr>
		
		
	</table>
		

   <div  id="poRateDivId">
	 <table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">
		
		<tr>
		<td width="25%" class="LABEL"><font color="red">*</font>Rate Unit</td>
				<td width="25%" class="CONTROL">
				<div id="rateDivID">
					<select name="strItemRateUnitId" id="strRateUnitId">
					   <bean:write name="PODeskGenerateTransBean"	property="strRateUnitValues" filter="false"></bean:write>
				    </select>
				 </div>   
				</td>
		
				<td width="25%" class="LABEL"><font color="red">*</font>Rate</td>
				<td width="25%" class="CONTROL">
				<input type="text"	maxlength="8" onkeypress="return validateData(event,7);" onKeyUp="resetDiv(1);" value="0" name="strItemRate"  class="txtFldNormal" readonly></td>
	
				
			</tr>
				
			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>Tax</td>
				<td width="25%" class="CONTROL">
				  <input type="text"	maxlength="3" onkeypress="return validateData(event,7);" value="0"   onkeyup="notGreaterThanCent(this);resetDiv(1);" name="strItemRateTax"  class="txtFldNormal"  readonly>
				</td>
				<td width="25%" class="LABEL"><font color="red">*</font>Manufacturer</td>
				<td width="25%" class="CONTROL">
					<select name="strItemManufacturerId"  class="comboMax">
					   <bean:write name="PODeskGenerateTransBean"	property="strManufacturerValues" filter="false"></bean:write>
				    </select> 	
				</td>
				
				
			</tr>
			
			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>Make</td>
				<td width="25%" class="CONTROL">
				   <select name="strItemMake" >
							<option value="1">Indian</option>
							<option value="2">Imported</option>
							</select>
				</td>
				<td width="25%" class="LABEL"><font color="red">*</font>Total Cost</td>
				<td width="25%" class="CONTROL">
					<input type="text" name="strItemTotalRate" value="0"  readonly  class="txtFldNormal" readonly>
				     						    		
				</td>
			</tr>
			<tr class="FOOTER">
			<td colspan="4" align="left">Purchase Order Details</td>
		</tr>
	    </table>
	</div>	
	<div  id="generateDynamicDiv"></div>
	
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPurchaseDetailsPlusID" style="display: none;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv1('divPurchaseDetailsMinusID'),hideDiv1('divPurchaseDetailsPlusID'),showDiv1('divPurchaseDetails');"
				style="cursor: pointer;"> Purchase Details</div>
			<div id="divPurchaseDetailsMinusID" style="display: block;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onclick="hideDiv1('divPurchaseDetailsMinusID'),hideDiv1('divPurchaseDetails'),showDiv1('divPurchaseDetailsPlusID');"
				style="cursor: pointer;"> Purchase Details</div>
			</td>
		</tr>
	</table>
	<div id="divPurchaseDetails">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>PO Reference No</td>
			<td width="25%" class="CONTROL">
			
            <div id="divPurchaseRefrenceNoId"><select name="strPoRefrenceNo" class="comboMax">
				<bean:write name="PODeskGenerateTransBean"
					property="strPoRefrenceNoCmb" filter="false"></bean:write>
			</select></div></td>
              
			<td colspan="1" class="LABEL">Supplier Contracted Quantity</td>
			<td colspan="1" class="CONTROL"><div id="contractedDeliveryDaysId"></div></td>
			
		</tr>
		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Purchase
			Source</td>
			<td width="25%" class="CONTROL">
			<div id="divPurchaseSource"><select name="strDPurchaseSource" class="comboMax">
				<bean:write name="PODeskGenerateTransBean"
					property="strPurchaseSourceValues" filter="false"></bean:write>
			</select></div>
			</td>
			<td width="25%" class="LABEL"><font color="red">*</font>Delivery Day(s)</td>
			<td width="25%" class="CONTROL">
			    <div id="deliveryDaysID"></div> 
				<input type="hidden" name="strDDeliveryDays" id="strDDeliveryDays" value=""	maxlength="2" onkeypress='return validateData(event,5);' class="txtFldMin"  readonly>
		        <input type="hidden" name="strDDeliveryDate"><div id="deliveryDateID"></div>  			
			</td>
			
			
		</tr>
		</table>
		<div id="divIDD" style="display:none;">
			<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">
			<tr>
			     <td width="25%" class="LABEL"><font color="red">*</font>Overall
				  Tax</td>
				  <td width="25%" class="CONTROL"><input type="text" maxlength="5" value="0"
					onkeypress='return validateData(event,7);' onkeyup='notGreaterThanCent(this)' name="strDOverAllTax"
					class="txtFldMin">%</td>
				<td width="25%" class="LABEL"></td>
				<td width="25%" class="CONTROL"></td>
				
			</tr>
			</table>
 		</div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL"><div id="tenderLevel"><font color="red">*</font>Tender No.</div></td>
			<td width="25%" class="CONTROL"><input type="text"
				maxlength="50" onkeypress='return validateData(event,16);'
				name="strDTenderNo"  readonly ></td>

            <td width="25%" class="LABEL"><div id="tenderDateLevel"><font color="red">*</font>Tender Date</div></td>
			<td width="25%" class="CONTROL"><input type="text"	name="strDTenderDate"  readonly ></td>
			
			
		</tr>
		<tr>
			<td width="25%" class="LABEL"><div id="quotationLevel">Quotation No.</div></td>
			<td width="25%" class="CONTROL"><input type="text"
				maxlength="50" onkeypress='return validateData(event,16);'  
				name="strDQuotationNo"></td>

			<td width="25%" class="LABEL"><div id="quotationDateLevel">Quotation Date</div></td>
			<td width="25%" class="CONTROL"><dateTag:date name="strDQuotationDate"></dateTag:date></td>
		</tr>
		<tr>
				<td width="25%" class="LABEL" ><Font color="red">*</Font>Verified By</td>
				<td width="25%" class="CONTROL"><select name="strVerifiedBy" class="comboMax">
				<bean:write name="PODeskGenerateTransBean"
					property="strApprovedByVals" filter="false"></bean:write>
				</select>
				</td>
				<td width="25%" class="LABEL" ><Font color="red">*</Font>Verified Date</td>
				<td width="25%" class="CONTROL"><dateTag:date name="strVerifiedDate" value =""></dateTag:date></td>
			</tr>
		<tr>
			<td width="25%" class="LABEL">Remarks</td>
			<td width="25%" class="CONTROL" ><textarea	 name=strDRemarks></textarea></td>
				<td width="25%" class="LABEL">Total PO Cost(Rs.)</td>
			   <td width="25%" class="CONTROL" ><div id ="totalPOCost" style="color: red; font-weight: bold">0.00</div><b>
			                     <input type="hidden"   name="strTotalPOCost">		
			   </td>
			
		</tr>
	</table>
	</div>
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divComponentPlusID" style="display: block;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="hideDiv1('divComponentPlusID'),showDiv1('divComponentMinusID'),showDiv1('divComponentDetails');"
				style="cursor: pointer;"> Component Details</div>
			<div id="divComponentMinusID" style="display: none;" align="left"><img
				src="../../hisglobal/images/minus.gif"
				onclick="hideDiv1('divComponentMinusID'),showDiv1('divComponentPlusID'),hideDiv1('divComponentDetails');"
				style="cursor: pointer;"> Component Details</div>
			</td>
		</tr>
	</table>
	<div id="divComponentDetails" style="display: none;"></div>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px" id="divCompile">
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	
	
	
<!-- 	<div id="divSaveCancelId" style="display: block">
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick="return validate1();" /> 
				<img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="pageResetMethod(1);">
				<img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></td>
		</tr>
	</table> 
	</div>-->
	<br>
	<div align="center" id="divSaveCancelId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="pageResetMethod(1);"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
					</div> 
	<input type="hidden" name="strCurrentDate" value="${ PODeskGenerateTransBean.strCurrentDate}" />
	<input type="hidden" name="strItemIds" />
	<input type="hidden" name="strPOFinancialDtl" />
	<input type="hidden" name="strINRCurrencyId"  value="${ PODeskGenerateTransBean.strINRCurrencyId}" />
	<input type="hidden" name="strItemBrandIds" />
	<input type="hidden" name="strStoreIds" />
	<input type="hidden" name="strRequestIds" />
	<input type="hidden" name="strIsForeignFlg" />
	<input type="hidden" name="strCalDeliveryDate" />
	<input type="hidden" name="strDatePikerFlag" />
	<input type="hidden" name="strPageSize" />
	<input type="hidden" name="strReOrderFlgColor" value="${PODeskGenerateTransBean.strReOrderFlgColor}"/>
	
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>