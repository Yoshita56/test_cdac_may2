<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<title>Rate Contract Details</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"   rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/rate_contract_trans.js"></script>

<style type="text/css">
  .legend3 {
  position: absolute;
  top: 0em;
  right: 40px;
  line-height:1.2em;   
}
.prescriptionTile {
	margin: 20px;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0.5px 0.5px 10px 2px #b0acac;
	border-radius: .35rem;
	color: #666;
	color: rgba(75, 75, 75, 0.9);
	color: rgb(21, 21, 21);
}
.legend2 {
   position: absolute;
   top: 0.5em;
   right: 44px;
   line-height: 1.2em;
}
.table .thead-dark {
  	color: #000 !important;
  	border: none !important;
  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
}
.thead-dark th{
	background:none !important;
	border: none !important;
	padding: 0.25rem;
    text-align: center;	
</style>

<script language="javaScript">
function validateRenew()
{   
      var hisValidator = new HISValidator("rateContractDtlBean"); 
       var retVal=true;
         
            hisValidator.addValidation("strDeliveryDays",     "req", "Delivery Day(s) is a Mandatory Field" );
             if(parseInt(document.forms[0].strDeliveryDays.value)==0)
             {
             	alert("Please Enter Delivery Day(s) Greater than Zero!!!");
             	return false;
             }
            
            hisValidator.addValidation("strContractFromDate", "req", "Contract From Date is a Mandatory Field" );
	        hisValidator.addValidation("strContractToDate",   "req", "Contract To Date is a Mandatory Field" ); 
            hisValidator.addValidation("strTenderDate",       "req", "Tender Date is a Mandatory Field" );
            hisValidator.addValidation("strContractFromDate", "dtgt=${rateContractDtlBean.strPreviousContractFromDate}", "Contract From Date should be greater than to Previous Contract from Date");
            hisValidator.addValidation("strContractFromDate", "dtgt=${rateContractDtlBean.strCtDate}", "Contract from Date should be greater than Current Date");
            hisValidator.addValidation("strContractToDate",   "dtgt=${rateContractDtlBean.strNextContractFromDate}", "Contract To Date should be greater than Previous Contract To Date");
            
            hisValidator.addValidation("strTenderDate",       "dtltet="+document.forms[0].strContractFromDate.value+"", "Tender Date should be Less than or Equal to Contract From Date");
            hisValidator.addValidation("strRemarks",          "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strRenewRate",        "req", "Rate is a Mandatory Field" );  
            hisValidator.addValidation("strRenewRate",        "amount=11,2", "Rate should be in format 000000000.00" );
            hisValidator.addValidation("strRenewRateUnitId",  "dontselect=0", "Please select a Unit" );  
            hisValidator.addValidation("strRenewRateContQty",       "req",  "Qty is a Mandatory Field" );  
            hisValidator.addValidation("strRenewSecurityAmtPercent", "req", "Security Amount is a Mandatory Field" ); 
            retVal = hisValidator.validate(); 
            hisValidator.clearAllValidations();

           
            if(document.forms[0].strRCChk.checked)
            	document.forms[0].strRCChk.value = "1";
            else
            	document.forms[0].strRCChk.value = "0";
           if(retVal)
           {
          				 document.forms[0].hmode.value = "INSERTRENEW";
                        document.forms[0].submit();
            }
            else
            {
					return false;
			}
    }

function CalculateSecurityAmt1()
{
	  	var  rate  = "";    
	  	var  qty   = "";
	  	var  finalRate  = 0.00;
	  	var  cost  = 0.00;
	  	var  rate_unit_base_value = "";
        
        rate    = trimAll(document.getElementById("strRenewRate").value);
        qty     = trimAll(document.getElementById("strRenewRateContQty").value);
       
		if(rate == "" || rate.length <=0)
		{
			rate = "0";
		}
		if(qty == "" || qty.length <=0)
		{
			qty = "0";
		}		
		if(document.getElementById("strRenewRateUnitId").value!="0")
        {
          rate_unit_base_value = document.getElementById("strRenewRateUnitId").value.split("^")[1];
          cost = parseFloat((qty  * rate)/rate_unit_base_value);
		}
		else
		{
		   cost = parseFloat(qty  * rate);
		}
		var  amtPerecentage = "";
		var  amtPerecentage = trimAll(document.getElementById("strRenewSecurityAmtPercent").value);
			   
	    if(amtPerecentage != "" && amtPerecentage.length > 0)
	    {
	    	finalRate = ( cost * parseFloat(amtPerecentage))/100;
	    }
	    else
	    {
	        finalRate  = cost;
	    }
	    
	    document.getElementById("strRenewSecurityAmount").value = roundValue(finalRate, 2);	    
} 

function showPrevRenewDtls()
{
    
	if(document.forms[0].strPrevRenewFlag.value==1)
	
	document.getElementById("previousRenewDtlsDiv").style.display="block";
	
	//document.forms[0].strContractToDate.focus();
	
	//if(document.forms[0].strTaxTypeNumValue.value==1)
	//{
	   document.getElementById("taxTypeDiv").innerHTML ="<select name='strTaxType' class='browser-default custom-select'><option value='1' >GST</option></select>";				
					    
    /*}
    else
    {
       document.getElementById("taxTypeDiv").innerHTML ="<select name='strTaxType' class='comboMin'><option value='1'>GST</option></select>";				
    }*/
}
</script>

</head>
<body onLoad="showPrevRenewDtls();">
<html:form name="rateContractDtlBean" action="/transactions/RateContractDtlTransBSCNT" type="mms.transactions.controller.fb.RateContractDtlTransFB">
 	<div class="errMsg" id="errMsg"><bean:write name="rateContractDtlBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
<fieldset form="form1">

<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader my-2' id='nonPrintableLegend' style="font-weight:600;font-size: 18px;" >Rate Contract Details</div>	
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" 
					class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
					onclick="cancel();" style="border-radius:50%;  padding:10px 12px" title="Cancel">
					<i class="fas fa-times iround" title="Cancel"></i>
				</button>
				<button type="button" class="float-right btn btn-secondary btn-circle"
					onclick="clearPage();"
					style="border-radius:50%; padding:10px 9px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Clear">
					<i class="fas fa-broom iround" title="Clear"></i>
				</button>
				<button type="button" id="savebutton"
					class="float-right btn btn-success mt-1 btn-circle"
					tabindex='2' onClick="return validateRenew();"
					name="requestForLpPatient"
					style="border-radius:50%;  padding:10px 12px">
					<i class="fa fa-download iround" title="Save"></i>
				</button>
			</div>
		
			<div class="row rowFlex reFlex">
			  <div class="col-sm-12">
			    <p class="subHeaders"><i class="fas fa-file-contract " title="Cancel" style="font-size: 18px;"></i></button>
			    &nbsp;Rate Contract Details&gt;&gt; Renew</p>
			  </div>
			</div>

			<div class="row">
				<div class="col-sm-2"><label>Supplier Name</label></div>
				<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strSupplierName" filter="false" /></div>
				<div class="col-sm-2"><label>Contract Type</label></div>
				<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strContractType" filter="false" /></div>
				<div class="col-sm-2"><label>Drug Category</label></div>
				<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strItemCategoryName" filter="false" /></div>
			</div>
	
	
	<div id="previousRenewDtlsDiv" style="display: none" >
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
				<td class="TITLE"  colspan="4">Renew details</td>
			</tr>
			<tr>
				<td class="LABEL" width="25%">Renew Date</td>
				<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strPrevRenewDate" filter="false"/></td>
				<td class="LABEL" width="25%"></td>
				<td class="CONTROL" ></td>
			</tr>
			<tr>
				<td width="25%" class="LABEL" >Contract From</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewContractFromDate" filter="false"></bean:write></td>
				<td width="25%" class="LABEL">Contract To</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewContractToDate" filter="false"></bean:write></td>
			</tr>
		    <tr>
				<td width="25%" class="LABEL">Tender No.</td>
				<td width="25%" class="CONTROL"><div style="pointer-events: none;"><bean:write name="rateContractDtlBean" property ="strPrevRenewTenderNo" filter="false"></bean:write></div>
				</td>
				<td width="25%" class="LABEL">Quotation No.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewQuotationNo" filter="false"></bean:write>
				</td>
			</tr>
			 <tr>
				<td width="25%" class="LABEL">Tender Date.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevTenderDate" filter="false"></bean:write>
				</td>
				<td width="25%" class="LABEL">Quotation Date.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevQuotationDate" filter="false"></bean:write>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Tax(%).</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevTaxWithType" filter="false"></bean:write>
				</td>
				<td width="25%" class="LABEL"></td>
				<td width="25%" class="CONTROL"></td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Remarks</td>
				<td  class="CONTROL" >
				<bean:write name="rateContractDtlBean" property ="strPrevRenewRemarks" filter="false"></bean:write>
				</td>
				<td width="25%" class="LABEL"></td>
				<td  class="CONTROL" ></td>
			</tr>
		</table> 

		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			     <td class="TITLE" colspan="4">Renew Drug Details</td>
	        </tr>
			<tr>
				<td width="25%" class="LABEL">Drug Name</td>
			<td width="25%" class="CONTROL">
			    <bean:write name="rateContractDtlBean" property ="strPrevRenewItemName" filter="false"></bean:write>
			</td>
			    <td width="25%" class="LABEL">Rate/Unit</td>
				<td width="25%" class="CONTROL">
				    <bean:write name="rateContractDtlBean" property ="strPrevRenewRate" filter="false"></bean:write> <bean:write name="rateContractDtlBean" property ="strPrevRenewRateUnit" filter="false"></bean:write>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Security Amount(%)</td>
				<td width="25%" class="CONTROL">
				   <bean:write name="rateContractDtlBean" property ="strPrevSecurityAmt" filter="false"></bean:write>
				</td>
				<td width="25%" class="LABEL">Rate Contract Qty</td>
				<td width="25%" class="CONTROL">
				   <bean:write name="rateContractDtlBean" property ="strPrevContractQty" filter="false"></bean:write>
				</td>
			</tr>
	 	 </table> 
	</div>
		
	<div class="row">
		<div class="col-sm-8"><p class='subHeaders'><i class="fas fa-file-contract" style="font-size: 18px;"></i>&nbsp;&nbsp;Current Contract details</p></div>
		<div class="col-sm-2"><label>Renew Date</label></div>
		<div class="col-sm-2" style="color: #46b8da;"><bean:write name="rateContractDtlBean" property ="strCtDate" filter="false"/></div>
	</div>

<div class="container">
	<div class="row my-1">
		<div class="col-sm-3"><label>Current Validity</label></div>
		<div class="col-sm-3" style="color: #46b8da;"><bean:write name="rateContractDtlBean" property ="strContractValidity" filter="false"/></div>
		<div class="col-sm-3"><label><font  color="red">*</font>Delivery Day(s)</label></div>
		<div class="col-sm-3"><input type="text" class="form-control" name="strDeliveryDays" maxlength="3" value="${rateContractDtlBean.strDeliveryDays}" onkeypress="return validateData(event,5);"></div>
    </div>
    
    <div class="row my-1">
		<div class="col-sm-3"><label><font  color="red">*</font>Contract From</label></div>
		<div class="col-sm-3"><input class="form-control datepicker" name="strContractFromDate" ></div>
		<div class="col-sm-3"><label><font color="red">*</font>Contract To</label></div>
		<div class="col-sm-3"><input class="form-control datepicker" name="strContractToDate" ></div>
	</div>
	
	 <div class="row my-1">
		<div class="col-sm-3"><label><font  color="red">*</font>Tender No.</label></div>
		<div class="col-sm-3"><input type="text" class="form-control" name="strTenderNo" maxlength="50" value="${rateContractDtlBean.strTenderNo}"	onkeypress="return validateData(event,8);" readonly="readonly"></div>
		<div class="col-sm-3"><label>Quotation No.</label></div>
		<div class="col-sm-3"><input type="text" class="form-control" name="strQuotationNo" maxlength="50" value="${rateContractDtlBean.strQuotationNo}"	onkeypress="return validateData(event,8);"></div>
	</div>
	
	<div class="row my-1">
		<div class="col-sm-3"><label><font  color="red">*</font>Tender Date:</label></div>
		<div class="col-sm-3"><input class="form-control datepicker" name="strTenderDate" value="${rateContractDtlBean.strTenderDate}"  ></div>
		<div class="col-sm-3"><label><font color="red">*</font>Quotation Date</label></div>
		<div class="col-sm-3"><input class="form-control datepicker" name="strQuotationDate" value="${rateContractDtlBean.strQuotationDate}" ></div>
	</div>
	
	<div class="row my-1">
		<div class="col-sm-3"><label>Tax Type:</label></div>
		<div class="col-sm-3"><div id="taxTypeDiv"> <select name="strTaxType" class="browser-default custom-select"> <option value="0">Select Value</option></select> </div></div>
		<div class="col-sm-3"><label><font  color="red">*</font>TAX(%)</label></div>
		<div class="col-sm-3"><input type="text" class="form-control" name="strTax" maxlength="4" value="${rateContractDtlBean.strTax}" onkeypress="return validateData(event,7);" onkeyup="notGreaterThanCent(this);"></div>
	</div>
</div>
	
	<p class="subHeaders"><i class="fas fa-prescription-bottle-alt" style='font-size:18px;'></i>&nbsp;Drug Details</p>
		 <table class="table">
		     <thead class="thead-dark">
			      <tr>
					<th width="20%;" style="font-weight:350 !important ;font-size: 16px !important;">Drug Name</th>
					<th width="8%;"  style="font-weight:350 !important ;font-size: 16px !important;">Last Purchase Rate/Unit</th>
					<th width="8%;"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Rate</th>
					<th width="8%;"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Rate Unit</th>
					<th width="8%;"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Qty.</th>					
					<th width="9%;" style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Security Amt(%)</th>			
					<th width="9%;"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Security Amt.</th>
					<th width="9%;" style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Shelf Life (In Days)</th>
					<th width="9%;"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Level</th>
					<th width="2%;"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="black">*</font>Excl. tax</th>
					<th width="10%;" style="font-weight:350 !important ;font-size: 16px !important;">Pack Size</th>
			      </tr>
			 </thead>
			 <tbody>
			   <tr>
			     <td  width="20%;" align ='left'  style="font-weight:350 !important ;font-size: 16px !important;"><bean:write name="rateContractDtlBean" property="strItemBrandName" filter="false"></bean:write></td>
			     <td  width="8%;"  align ='center' style="font-weight:350 !important ;font-size: 16px !important;"><bean:write name="rateContractDtlBean" property="strLastPurchaseRate" filter="false"></bean:write><bean:write name="rateContractDtlBean" property="strLastPurchaseRateUnit" filter="false"></bean:write></td>
			     <td  width="8%;"  align ='center' style="font-weight:350 !important ;font-size: 16px !important;"><input type="text" name="strRenewRate" id="strRenewRate" maxlength="12" class="form-control" maxlength="8" onkeypress="return validateData(event,7);" onkeyup="CalculateSecurityAmt1();"   value="${rateContractDtlBean.strRenewRate}" ></td>
				 <td  width="8%;"  align ='center' style="font-weight:350 !important ;font-size: 16px !important;"><select name="strRenewRateUnitId" id="strRenewRateUnitId" class="browser-default custom-select" onChange="CalculateSecurityAmt1();"><bean:write name="rateContractDtlBean" property="strUnitCmbValues" filter="false"></bean:write></select></td>
			     <td  width="8%;"  align ='center' style="font-weight:350 !important ;font-size: 16px !important;"><input type="text" name="strRenewRateContQty"  id="strRenewRateContQty" maxlength="12" class="form-control" maxlength="8" onkeypress="return validateData(event,7);" onkeyup="CalculateSecurityAmt1();" value="${rateContractDtlBean.strRenewRateContQty}"></td>
			     <td  width="9%;" align ='center' style="font-weight:350 !important ;font-size: 16px !important;"><input type="text" name="strRenewSecurityAmtPercent"  id="strRenewSecurityAmtPercent"  class="form-control"  maxlength="5" onkeypress="return validateData(event,7);" onkeyup="notGreaterThanCent(this);CalculateSecurityAmt1();"></td>
			     <td  width="9%;"  align ='center' style="font-weight:350 !important ;font-size: 16px !important;"><input type="text" name="strRenewSecurityAmount"   id="strRenewSecurityAmount" maxlength="12" class="form-control" readonly></td>
			     <td  width="9%;" align ='center' style="font-weight:350 !important ;font-size: 16px !important;"><input type="text" name="strRenewShelfLife"   id="strRenewShelfLife" value ="${rateContractDtlBean.strRenewShelfLife}" maxlength="3" class="form-control" onkeypress="return validateData(event,5);"></td>
				 <td  width="9%;" align ='center' >
				   <select name='strRenewLevel' id="strRenewLevel" class='browser-default custom-select'>
				         <option value='L1'>L1</option>
				         <option value='L2'>L2</option>
				         <option value='L3'>L3</option>
				         <option value='L4'>L4</option>
				         <option value='L5'>L5</option>
				         <option value='L6'>L6</option>
				         <option value='L7'>L7</option>
				         <option value='L8'>L8</option>
				         <option value='L9'>L9</option>
				   </select>
				 </td>
			     <td style="width: 2%;text-align: center;padding-top: 20px;"><input type='checkbox' name='strRCChk' id='strRCChk' value="0" ></td>
		    	 <td style="width: 10%;text-align: center;padding-top: 12px;" style="font-weight:350 !important ;font-size: 16px !important;">
			   		<input type="text" name="strPackSize"   id="strPackSize" value ="${rateContractDtlBean.strRenewPackSize}" maxlength="10" class="form-control" onkeypress="return validateData(event,9);">
				</td>
			   </tr>
			</tbody>
		</table>
		<div id="id1"></div>
	<br>
	<div class="row">
	<div class="col-sm-2"><label>Remarks</label></div>
	<div class="col-sm-10"><textarea  name="strRemarks" class="form-control" cols="25" rows="2" onkeypress="return validateData(event,9);"><bean:write name="rateContractDtlBean" property="strRemarks" filter="false"></bean:write></textarea></div>
	</div>
	<hr>
	<div class="row rowFlex reFlex">
        <div class="col-sm-10"></div>
              <div class="col-sm-2" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
       </div>
	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
src="../../hisglobal/images/btn-sv.png"
onClick=" return validateRenew();" title="Save Record"/> <img
style="cursor: pointer; " title="Clear Content"
src="../../hisglobal/images/btn-clr.png"
onClick="document.forms[0].reset(),document.forms[0].strContractToDate.focus();" />
<img style="cursor: pointer; " title="Click Here Go Back To Main Desk" 
src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			
			</td>
		</tr>
	</table> -->
		
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="ctDate" value="${rateContractDtlBean.strCtDate}"/>
<input type="hidden" name="strSupplierId" value="${rateContractDtlBean.strSupplierId}"/>
<input type="hidden" name="strSupplierName" value="${rateContractDtlBean.strSupplierName}"/>
<input type="hidden" name="strContractTypeID" value="${rateContractDtlBean.strContractTypeID}"/>
<input type="hidden" name="strContractType" value="${rateContractDtlBean.strContractType}"/>
<input type="hidden" name="strItemCategoryNo" value="${rateContractDtlBean.strItemCategoryNo}"/>
<input type="hidden" name="strItemCategoryName" value="${rateContractDtlBean.strItemCategoryName}"/>
<input type="hidden" name="strItemID" value="${rateContractDtlBean.strItemID}"/>
<input type="hidden" name="strItemBrandID" value="${rateContractDtlBean.strItemBrandID}"/>
<input type="hidden" name="strSlNo" value="${rateContractDtlBean.strSlNo}"/>
<input type="hidden" name="strTenderNo" value="${rateContractDtlBean.strTenderNo}"/>
<input type="hidden" name="strQuotationNo" value="${rateContractDtlBean.strQuotationNo}"/>
<input type="hidden" name="strDeiveryLeadTime" value="${rateContractDtlBean.strDeiveryLeadTime}"/>
<input type="hidden" name="strDeiveryLeadTimeUnit" value="${rateContractDtlBean.strDeiveryLeadTimeUnit}"/>

<input type="hidden" name="strChk1" value="${rateContractDtlBean.strChk1}"/>
<input type="hidden" name="comboValue" value="${rateContractDtlBean.comboValue}"/>
<input type="hidden" name="strPrevRenewFlag" value="${rateContractDtlBean.strPrevRenewFlag}"/>

<input type="hidden" name="strTaxTypeNumValue" value="${rateContractDtlBean.strTaxType}"/>
<input type="hidden" name="strPreviousContractFromDate" value="${rateContractDtlBean.strPreviousContractFromDate}"/>


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
</div>
</div>
</fieldset>

<cmbPers:cmbPers/>
</html:form>

<script type="text/javascript">
	
	$('.datepicker').each(function(){
	    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	});
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	$('.datepicker').val(dd);
	</script>
</body>
</html>