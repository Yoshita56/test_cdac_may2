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
<title></title>
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
<script language="Javascript" src="../../mms/js/PODesk.js"></script>
<script language="Javascript" src="../../mms/js/POGenerateWithItem.js"></script>
<script language="javascript">
		var progressEnd = 12; // set to number of progress <span>'s.
		var progressColor =  '#1B82E6'; // set to progress bar color
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
<body>
<html:form action="/transactions/PODeskGenerateTransCNT">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="PODeskGenerateTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="PODeskGenerateTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="PODeskGenerateTransBean" property="strMsg" /></div>


<!--<table align="center">
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



    <div class='popup' id='PoDtl' style="display:none">
	<table width='800' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'><div id='PoPUpHeader'></div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Pop Up' src='../../hisglobal/images/stop.png'
				onClick="hideItemDetails('PoDtl');"></th>
	    </tr>
	 </table>   
	 <table width='800' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
		<tr>
			<td colspan="1" class='multiPOLabel'>Qty Demanded by Hospitals</td>
			<td colspan="1" class='multiPOLabel'>Qty Ordered by Hospitals</td>
			<td colspan="1" class='multiPOLabel'>Total Qty Supplied at Store</td>			
			<td colspan="1" class='multiPOLabel'>Qty Issued to Sub Stores</td>
			<td colspan="1" class='multiPOLabel'>Qty in PipeLine(transit)</td>
			<td colspan="1" class='multiPOLabel'>Current Stock</td>
			
			<td colspan="1" class='multiPOLabel'>Qty in Major Sub-Stores</td>
			<td colspan="1" class='multiPOLabel'>Re-Order Level</td>			
		</tr>
		<tr>
		    <td colspan="1" class='multiRPTControl'><div id ='100'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='200'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='300'></div></td>		    
		    <td colspan="1" class='multiRPTControl'><div id ='1'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='2'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='3'></div></td>
			<td colspan="1" class='multiRPTControl' style="display:none;"><div id ='4' ></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='5'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='6'></div></td>
			
		</tr>
		<tr class="FOOTER">
			<td colspan="8"></td>
		</tr>
        </table>
	</div>
	
	
	<div class='popup' id='ScheduleDtl' style="display:none">
	<table width='600' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'><div id='SchedulePoPUpHeader'></div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Pop Up' src='../../hisglobal/images/stop.png'
				onClick="hideItemDetails('ScheduleDtl');"></th>
	    </tr>
	 </table>   
	 <table width='600' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
		<tr>
			
			<td colspan="1" class='multiPOLabel'>Schedule</td>
			<td colspan="1" class='multiPOLabel'>Order Qty</td>
			<td colspan="1" class='multiPOLabel'>Accp. Qty</td>
			<td colspan="1" class='multiPOLabel'>Rejected Qty</td>
			<td colspan="1" class='multiPOLabel'>Total Recev. Qty</td>
			
			
		</tr>
		<tr>
		    <td colspan="1" class='multiPOLabel'>1</td>
			<td colspan="1" class='multiRPTControl'><div id ='21'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='22'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='23'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='24'></div></td>		
		</tr>
		<tr>
		    <td colspan="1" class='multiPOLabel'>2</td>
			<td colspan="1" class='multiRPTControl'><div id ='25'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='26'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='27'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='28'></div></td>			
		</tr>
		<tr>
		    <td colspan="1" class='multiPOLabel'>3</td>
			<td colspan="1" class='multiRPTControl'><div id ='29'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='30'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='31'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='32'></div></td>			
		</tr>
		<tr>
		    <td colspan="1" class='multiPOLabel'>4</td>
			<td colspan="1" class='multiRPTControl'><div id ='33'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='34'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='35'></div></td>
			<td colspan="1" class='multiRPTControl'><div id ='36'></div></td>			
		</tr>
		<tr class="FOOTER">
			<td colspan="5"></td>
		</tr>
        </table>
	</div>  -->
	
	
	

	<tag:tab tabLabel="Purchase Order Approval Form" selectedTab="FIRST"	align="center" width="TABLEWIDTH"></tag:tab>
			
	</center>		
	<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%"  class="CONTROL"><bean:write
				name="PODeskGenerateTransBean" property="strStoreName" filter="false"></bean:write></td>
			<td width="25%" class="LABEL">Demand Year</td>
			<td width="25%" class="CONTROL"><bean:write
				name="PODeskGenerateTransBean" property="strPODemandYear" filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO No.</td>
			<td width="25%" class="CONTROL"><bean:write
				name="PODeskGenerateTransBean" property="strPONo" filter="false"></bean:write></td>
			<td width="25%" class="LABEL">PO Date</td>
			<td width="25%" class="CONTROL"><bean:write
				name="PODeskGenerateTransBean" property="strPODate" filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO Type</td>
			<td width="25%" class="CONTROL"><bean:write
				name="PODeskGenerateTransBean" property="strPOType" filter="false"></bean:write></td>

			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><bean:write
				name="PODeskGenerateTransBean" property="strItemCatName"
				filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Supplier Name</td>
			<td width="75%" colspan="3" class="CONTROL"><bean:write
				name="PODeskGenerateTransBean" property="strSupplierName"
				filter="false"></bean:write></td>
		</tr>
		
	<!--<tr>
		  <td width="25%" class="LABEL"><font color="red">*</font>Item Name</td>
			<td width="25%" class="CONTROL">
			<select name="strPOItemID"  class="comboMax" onChange="getUnitCombo1();">
				<bean:write name="PODeskGenerateTransBean"	property="strPOItemCmb" filter="false"></bean:write>
			</select>
			</td>
								
				<td colspan="1" class="LABEL" width="25%">
						
				</td>
								
				<td width="25%" class="LABEL" width="15%" style="text-align:left;"><div id="imageDiv"><html:img src="../../hisglobal/images/Go.png" align="left" style="cursor:pointer" title="Click to see Purchase Details" onclick="progress_update();putDaynamicDiv(2);" /></div></td>
				
			</tr>  -->	
		
	   </table>
	   <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">
		
		<bean:write name="PODeskGenerateTransBean" property="strSetItemDetails"	filter="false" />
		
		</table>
	  
	<!--<div  id="poRateDivId"  style="display:none;">
	 
	 <table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">
		
		<tr>
		
		        <td width="25%" class="LABEL"><font color="red">*</font>Rate Unit</td>
				<td width="25%" class="CONTROL">
				<div id="rateDivID">
					<select name="strItemRateUnitId" id="strRateUnitId" onChange="resetDiv(2);">
					   <bean:write name="PODeskGenerateTransBean"	property="strRateUnitValues" filter="false"></bean:write>
				    </select>
				 </div>   
				</td>
				
				<td width="25%" class="LABEL"><font color="red">*</font>Rate</td>
				<td width="25%" class="CONTROL">
				<input type="text"	maxlength="6" onkeypress="return validateData(event,7);" onKeyUp="resetDiv(1);" value="" name="strItemRate"   class="txtFldNormal"></td>
	
				
			</tr>
				
			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>Tax</td>
				<td width="25%" class="CONTROL">
				  <input type="text"	maxlength="3" onkeypress="return validateData(event,7);" value="" onKeyUp="resetDiv(1);"   name="strItemRateTax"  class="txtFldNormal">
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
				  <div id="itemMakeDiv">
				   <select name="strItemMake" >
							<option value="1">Indian</option>
							<option value="2">Imported</option>
							</select>
				</div>
				</td>
				<td width="25%" class="LABEL"><font color="red">*</font>Total Cost</td>
				<td width="25%" class="CONTROL">
					<input type="text" name="strItemTotalRate" value="0"  readonly  class="txtFldNormal" >
				     						    		
				</td>
			</tr>
			<tr class="FOOTER">
			<td colspan="4" align="left">Purchase Order Schedule Details</td>
		</tr>
	    </table>
	    
	 </div>  --> 
	 
	 	
	<div  id="generateDynamicDiv"></div>
	
<!--<table class="TABLEWIDTH" align="center" cellpadding="1px"
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
			<select name="strPoRefrenceNo" class="comboMax">
				<bean:write name="PODeskGenerateTransBean"
					property="strPoRefrenceNoCmb" filter="false"></bean:write>
			</select>
			</td>

			<td width="25%" class="LABEL"><font color="red">*</font>PO Reference Date</td>
			<td width="25%" class="CONTROL">
				<dateTag:date name="strPORefrenceDate" value ="${PODeskGenerateTransBean.strPORefrenceDate}" ></dateTag:date></td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Purchase
			Source</td>
			<td width="25%" class="CONTROL">
			<select name="strDPurchaseSource" onChange="chnageLabel();" class="comboMax">
				<bean:write name="PODeskGenerateTransBean"
					property="strPurchaseSourceValues" filter="false"></bean:write>
			</select>
			</td>
			<td width="25%" class="LABEL"><!--<font color="red">*</font>Delivery Day(s)  </td>
			<td width="25%" class="CONTROL">
			<!-- <input type="text" name="strDDeliveryDays" value=""	maxlength="2" onkeypress='return validateData(event,5);' class="txtFldMin"  readonly>
			     			
			    <input type="hidden" name="strDDeliveryDate"><div id="deliveryDateID"></div>   			
			</td>
			
			
		</tr>
		</table>	-->
	
		<!--<div id="divIDD" style="display:none;">
			<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px" id="divCompile">
		
			
			<tr>
			     <td width="25%" class="LABEL"><font color="red">*</font>Overall
				  Tax</td>
				  <td width="25%" class="CONTROL"><input type="text" maxlength="5"  value ="${PODeskGenerateTransBean.strDOverAllTax}"
					onkeypress='return validateData(event,7);' onkeyup='notGreaterThanCent(this)' name="strDOverAllTax"  
					
					class="txtFldMin">%</td>
				<td width="25%" class="LABEL"></td>
				<td width="25%" class="CONTROL"></td>
				
			</tr>
			</table>
		</div>
		
		<tr>
			<td width="25%" class="LABEL"><div id="tenderLevel"><font color="red">*</font>Tender No.</div></td>
			<td width="25%" class="CONTROL"><input type="text"
				maxlength="50" onkeypress='return validateData(event,16);'  value ="${PODeskGenerateTransBean.strDTenderNo}"
				name="strDTenderNo"></td>				
				
			<td width="25%" class="LABEL"><div id="tenderDateLevel"><font color="red">*</font>Tender Date</div></td>
			<td width="25%" class="CONTROL"><dateTag:date name="strDTenderDate"  value ="${PODeskGenerateTransBean.strDTenderDate}"></dateTag:date></td>	
		</tr>
		<tr>
			<td width="25%" class="LABEL"><div id="quotationLevel">Quotation No.</div></td>
			<td width="25%" class="CONTROL"><input type="text"
				maxlength="50" onkeypress='return validateData(event,16);'   value ="${PODeskGenerateTransBean.strDQuotationNo}"
				name="strDQuotationNo"></td>

			<td width="25%" class="LABEL"><div id="quotationDateLevel">Quotation Date</div></td>
			<td width="25%" class="CONTROL"><dateTag:date name="strDQuotationDate" value ="${PODeskGenerateTransBean.strDQuotationDate}"></dateTag:date></td>
		</tr>  -->
		<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px" id="divCompile">
		<tr>
				<td width="25%" class="LABEL" ><Font color="red">*</Font>Approved By</td>
				<td width="25%" class="CONTROL"><select name="strVerifiedBy" class="comboMax">
				<bean:write name="PODeskGenerateTransBean"
					property="strApprovedByVals" filter="false"></bean:write>
				</select>
				</td>
				<td width="25%" class="LABEL" ><Font color="red">*</Font>Approval Date</td>
				<td width="25%" class="CONTROL"><dateTag:date name="strVerifiedDate" value ="${PODeskGenerateTransBean.strVerifiedDate}"></dateTag:date></td>
			</tr>
			
		<!--<tr>
			<td width="25%" class="LABEL">Next PO Date</td>
			<td width="25%" class="CONTROL"><dateTag:date name="strNextPoDate" value ="${PODeskGenerateTransBean.strNextPoDate}"></dateTag:date></td>
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="CONTROL" ></td>
		</tr>  -->		
		
		<tr>
			<td width="25%" class="LABEL"><Font color="red">*</Font>Approval Remarks</td>
			<td width="25%" class="CONTROL" ><textarea
				onkeyup="maxLengthRemarks(this,'100')" name=strDRemarks></textarea></td>
				<td width="25%" class="LABEL">Total PO Cost</td>
			   <td width="25%" class="CONTROL" ><div id ="totalPOCost" style="color: red; font-weight: bold">0.00</div>
			                     <input type="hidden"   name="strTotalPOCost">		
			   </td>
			
		</tr>
		 <tr>
			<td class="LABEL" width="25%">Approval Status</td>
			<td width="25%" class="CONTROL" colspan="3"><input type="radio" name="strApproved" value="1" checked="checked" onClick="FuncTick(this)"/>
			Approved <input type="radio" name="strRejected" value="2" onClick="FuncTick(this),setApprovedQty();"/>Rejected
		</tr>
	</table>
	</div>
	
	
	

	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	
	

	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><!-- <img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick="return approval();" /> 
				<img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="pageResetMethod(2);">
				<img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDeskApproval();"> -->
				<br>
				<a href="#" class="button" id="" onclick=' return approval();'><span class="save">Save</span></a>
							<a href="#" class="button"	onclick="pageResetMethod(2);"><span class="clear">Clear</span></a> 
							<a href="#" class="button" onclick="cancelToDeskApproval();"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strPOHiddenValue" value="${PODeskGenerateTransBean.strPOHiddenValue}"/>
	<input type="hidden" name="strReOrderFlgColor" value="${PODeskGenerateTransBean.strReOrderFlgColor}"/>
	<input type="hidden" name="strStoreId" value="${ PODeskGenerateTransBean.strStoreId}" />
	<input type="hidden" name="strCurrentDate" value="${ PODeskGenerateTransBean.strCurrentDate}" />
	<input type="hidden" name="strPONo" value="${ PODeskGenerateTransBean.strPONo}" />
	<input type="hidden" name="strPOApprovalFlag" value="${ PODeskGenerateTransBean.strPOApprovalFlag}" />
	<input type="hidden" name="strGoFlag" value="0" />
		<input type="hidden" name="strPostatus" value="1" />
	
	<input type="hidden" name="strPODate" value="${ PODeskGenerateTransBean.strPODate}" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>