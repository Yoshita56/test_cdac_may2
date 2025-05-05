<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
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


<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/rate_contract_trans.js"></script>

<style type="text/css">
.comboNormal{
width: 35%;
height: calc(1.3em + 0.75rem + 2px);
padding: 0.375rem 0.75rem;
font-size: 1rem;
font-weight: 400;
line-height: 1.5;
color: #495057;
background-color: #fff;
background-clip: padding-box;
border: 1px solid #ced4da;
border-radius: 0.25rem;
}
.txtFldMax{
width: 35%;
height: calc(1.3em + 0.75rem + 2px);
padding: 0.375rem 0.75rem;
font-size: 1rem;
font-weight: 400;
line-height: 1.5;
color: #495057;
background-color: #fff;
background-clip: padding-box;
border: 1px solid #ced4da;
border-radius: 0.25rem;
}
.fa-edit::before {
    color: white;
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
</style>

<script language="javaScript">


function showPrevRenewDtls()
{
if(document.forms[0].strPrevRenewFlag.value==1)
document.getElementById("previousRenewDtlsDiv").style.display="block";

if(document.forms[0].strCancelDtlsFlag.value==1)
document.getElementById("cancelDtlsDiv").style.display="block";

document.forms[0].strContractToDate.focus();
}

function modify()
{   
      var hisValidator = new HISValidator("rateContractDtlBean"); 
       var retVal=true;
         
             hisValidator.addValidation("strDeliveryDays",     "req", "Delivery Day(s) is a Mandatory Field" );
             if(parseInt(document.forms[0].strDeliveryDays.value)==0)
             {
             	alert("Please Enter Delivery Day(s) Greater than Zero!!!");
             	return false;
             }
            //      alert(document.forms[0].strContractFromDate.value);
            hisValidator.addValidation("strContractFromDate", "req", "Contract From Date is a Mandatory Field" );
	        hisValidator.addValidation("strContractToDate",   "req", "Contract To Date is a Mandatory Field" ); 
            /* hisValidator.addValidation("strTenderDate",       "req", "Tender Date is a Mandatory Field" ); */
           /*  hisValidator.addValidation("strContractFromDate", "dtgt=${rateContractDtlBean.strPreviousContractFromDate}", "Contract From Date should be greater than to Previous Contract from Date"); */
           //  hisValidator.addValidation("strContractFromDate", "dtgt=${rateContractDtlBean.strContractFromDate}", "Contract from Date should be greater than Current Date");
            hisValidator.addValidation("strContractToDate",   "dtgt=${rateContractDtlBean.strContractFromDate}", "Contract To Date should be greater than Previous Contract To Date");
             
            /* hisValidator.addValidation("strTenderDate",       "dtltet="+document.forms[0].strContractFromDate.value+"", "Tender Date should be Less than or Equal to Contract From Date"); */
            hisValidator.addValidation("strRemarks",          "req", "Please enter the reason for RC Modification in Remarks" );
            hisValidator.addValidation("strRemarks",          "maxlen=250", "Remarks should have less than or equal to 250 Characters" );
            hisValidator.addValidation("strLastPurchaseRate",        "req", "Rate is a Mandatory Field" );  
            hisValidator.addValidation("strLastPurchaseRate",        "amount=11,2", "Rate should be in format 000000000.00" );
            /* hisValidator.addValidation("strRenewRateUnitId",  "dontselect=0", "Please select a Unit" ); */  
            hisValidator.addValidation("strRenewRateContQty",       "req",  "Qty is a Mandatory Field" );  
            hisValidator.addValidation("strRenewSecurityAmtPercent", "req", "Security Amount is a Mandatory Field" ); 
            retVal = hisValidator.validate(); 
            hisValidator.clearAllValidations();

           
           /*  if(document.forms[0].strRCChk.checked)
            	document.forms[0].strRCChk.value = "1";
            else
            	document.forms[0].strRCChk.value = "0";  */
           if(retVal)
           {
          				 document.forms[0].hmode.value = "MODIFYSAVE";
                        document.forms[0].submit();
            }
            else
            {
					return false;
			}
    }
</script>

</head>
<body onLoad=""><!-- showPrevRenewDtls(); -->
<html:form name="rateContractDtlBean" action="/transactions/RateContractDtlTransBSCNT"
	type="mms.transactions.controller.fb.RateContractDtlTransFB">
<center>
	<div id="errMsg" class="errMsg"><bean:write name="rateContractDtlBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="rateContractDtlBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="rateContractDtlBean"
		property="strMsg" /></div>
</center>
			
<fieldset form="form1">
<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader my-2' id='nonPrintableLegend' style="font-weight:600;font-size: 18px;" >Rate Contract Details</div>
	
		<div class="legend2" id='nonPrintableLegend2'>
			<button type="button" 
				class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
				onclick="cancel();" style="border-radius:50%;  padding:11px 13px" title="Cancel">
				<i class="fas fa-times iround" title="Cancel"></i>
			</button>
			
			<button type="button" id="modifybutton"
					class="float-right btn btn-success mt-1 btn-circle"
					tabindex='2' onClick="modify();"
					style="border-radius:50%;  padding:11px 10px">
					<i class="fa fa-edit iround" title="Modify"></i>
			</button>
		</div>
	
		<div class="row rowFlex reFlex">
		  <div class="col-sm-12">
		    <p class="subHeaders"><i class="fas fa-file-contract " style="font-size: 18px;"></i>
		    &nbsp;Rate Contract Details &gt;&gt; Modify </p>
		  </div>
		</div>
		
		<div class="row">
			<div class="col-sm-2"><label>Supplier Name</label></div>
			<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strSupplierName" filter="false" /></div>
			<div class="col-sm-2"><label>Contract Type</label></div>
			<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strContractType" filter="false" /></div>
			<div class="col-sm-2"><label>Item Category</label></div>
			<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strItemCategoryName" filter="false" /></div>
		</div>
	
		<div id="previousRenewDtlsDiv" style="display: none" >
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr class="TITLE">
			<td colspan="4"><div id=''>Renew &gt;&gt;  Contract Details</div></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Renew Date</td>
			<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strPrevRenewDate" filter="false"/></td>

			<td class="LABEL" width="25%">Delivery Day(s)</td>
			<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strDeliveryDays" filter="false"/></td>

		</tr>
		
		<tr>
				<td width="25%" class="LABEL" >Contract From</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewContractFromDate" filter="false"></bean:write></td>
					<td width="25%" class="LABEL">Contract To</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewContractToDate" filter="false"></bean:write></td>
			</tr>
			
		<tr>
				<td width="25%" class="LABEL">Tender No.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewTenderNo" filter="false"></bean:write>
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
				<td width="25%" class="LABEL">TAX(%)</td>
				<td  class="CONTROL" >
				<bean:write name="rateContractDtlBean" property ="strPrevTaxWithType" filter="false"></bean:write>
				
			</td>
				
				<td width="25%" class="LABEL">Remarks</td>
				<td  class="CONTROL" >
				<bean:write name="rateContractDtlBean" property ="strPrevRenewRemarks" filter="false"></bean:write>
				</td>
				<tr class="TITLE">
			<td colspan="4"><div id=''>Renew &gt;&gt;  Drug Details</div></td>
		    </tr>
			<tr>
				<td colspan="1" width="25%" class="LABEL">Drug Name
				</td>
				<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strPrevRenewItemName" filter="false"></bean:write>
				</td>
				<td colspan="1" width="25%" class="LABEL">Contracted Rate/Unit
				</td>
				<td colspan="1" width="25%" class="CONTROL">
				<bean:write name="rateContractDtlBean" property="strPrevRenewRate" filter="false"></bean:write>/
				<bean:write name="rateContractDtlBean" property="strPrevRenewRateUnit" filter="false"/>
				</td>
		    </tr>
		    <tr>
				<td colspan="1" width="25%" class="LABEL">Security Amt(%)
				</td>
				<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strPrevSecurityAmt" filter="false"></bean:write>
				</td>
				<td colspan="1" width="25%" class="LABEL">Rate Contract Qty
				</td>
				<td colspan="2" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strPrevContractQty" filter="false"></bean:write>
				</td>
			</tr>
			
	
		</table> 
		</div>
		
		<div class="row">
	      <div class="col-sm-8"><p class='subHeaders'><i class="fas fa-file-contract" style="font-size: 18px;"></i>&nbsp;&nbsp;Current &gt;&gt; Contract Details</p></div>
	    <div class="col-sm-2"><label>Tender No.</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><input type="text" class="form-control" name="strTenderNo" maxlength="50" value="${rateContractDtlBean.strTenderNo}" onkeypress="return validateData(event,8);"></div>
	    </div>
	    
	     <div class="row">
	    <div class="col-sm-2"><label>Contract From</label></div>
	    <div class="col-sm-2" style="font-weight: normal;color: #46b8da;"><input class="form-control datepicker" name="strContractFromDate" value ="${rateContractDtlBean.strContractFromDate}"></div>
	    <div class="col-sm-2"><label>Contract To</label></div>
	    <div class="col-sm-2" style="font-weight: normal;color: #46b8da;"><input class="form-control datepicker" name="strContractToDate" value ="${rateContractDtlBean.strContractToDate}"></div>
	    <div class="col-sm-2"><label>Quotation No.</label></div>
	    <div class="col-sm-2"><input type="text" class="form-control" name="strQuotationNo" maxlength="50" value="${rateContractDtlBean.strQuotationNo}" onkeypress="return validateData(event,8);"></div>
	    </div>
	    
	     <div class="row">
	    <div class="col-sm-2"><label>RC/Tender SNO.</label></div>
	    <div class="col-sm-2"><input type="text" class="form-control" name="strRcTenderSno" maxlength="10" value="${rateContractDtlBean.strRcTenderSno}"></div>
	    <div class="col-sm-2"><label>TAX(%)</label></div>
	    <div class="col-sm-2"><input type="text" class="form-control" name="strTax" maxlength="4" value="${rateContractDtlBean.strTax}" onkeypress="return validateData(event,7);" onkeyup="notGreaterThanCent(this);"></div>
	    <div class="col-sm-2"><label>Remarks</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><textarea class="form-control" name="strRemarks" cols="20" rows="1" id="strRemarks" value="${rateContractDtlBean.strRemarks}" onkeypress="return validateData(event,9);"></textarea></div>
	    </div>
	    
	    <div class="row">
	      <div class="col-sm-3"><p class='subHeaders'><i class="fas fa-prescription-bottle-alt" style="font-size: 18px;"></i>&nbsp;&nbsp;Current &gt;&gt; Drug Details</p></div>
	   <div class="col-sm-2" align="right"><label>Drug Name-</label></div>
	     <div class="col-sm-7" style="font-weight: normal;"><font color="red"><bean:write name="rateContractDtlBean" property="strItemBrandName" filter="false"></bean:write></font></div>
	    
	    </div>
	    
	    <div class="row">
	    <div class="col-sm-2"><label>Rate/Unit</label></div>
	    <div class="col-sm-3">
	    <div class="row">
	    <div class="col-sm-6" ><input type="text" class="form-control" name="strLastPurchaseRate" maxlength="12" value="${rateContractDtlBean.strLastPurchaseRate}" onkeypress="return validateData(event,7);"></div>
	    <div class="col-sm-6"><select name="strRenewRateUnitId" id="strRenewRateUnitId" class="browser-default custom-select" ><bean:write name="rateContractDtlBean" property="strUnitCmbValues" filter="false"></bean:write></select></div>
	    </div></div>
	    <div class="col-sm-1"></div>
	    <div class="col-sm-2"><label>Security Amt(%)</label></div>
	    <div class="col-sm-3"><input type="text" class="form-control" name="strRenewSecurityAmtPercent" maxlength="5" value="${rateContractDtlBean.strLastSecurityAmount}" onkeyup="notGreaterThanCent(this);"></div>
	    </div>
	    
	    <div class="row">
	    <div class="col-sm-2"><label>Quantity</label></div>
	    <div class="col-sm-3" style="font-weight: normal;color: #46b8da;"><input type="text" class="form-control" name="strRenewRateContQty" maxlength="12" value="${rateContractDtlBean.strLastContractQty}" onkeypress="return validateData(event,7);"></div>
	    <div class="col-sm-1"></div>
	    <div class="col-sm-2"><label>Delivery Day(s)</label></div>
	    <div class="col-sm-3" style="font-weight: normal;"><input type="text" class="form-control" name="strDeliveryDays" maxlength="3" value="${rateContractDtlBean.strDeliveryDays}" onkeypress="return validateData(event,5);"></div>
	    </div>
	    
	    <div class="row">
	    <div class="col-sm-2"><label>Whether Item Is imported</label></div>
	    <div class="col-sm-3" style="font-weight: normal;color: #46b8da;"><bean:write name="rateContractDtlBean" property ="strImportTypeViewFlag" filter="false"/></div>
	    <div class="col-sm-1"></div>
	    <div class="col-sm-2"><label>Shelf Life(In Days)</label></div>
	    <div class="col-sm-3" style="font-weight: normal;"><input type="text" class="form-control" name="strRenewShelfLife" maxlength="3" value="${rateContractDtlBean.strRenewShelfLife}" onkeypress="return validateData(event,5);"></div>
	    </div>
	    
	     <div class="row">
	    <div class="col-sm-2"><label>Pack Size</label></div>
	    <div class="col-sm-3" style="font-weight: normal;color: #46b8da;"><bean:write name="rateContractDtlBean" property ="strRenewPackSize" filter="false"/></div>
	    <div class="col-sm-1"></div>
	    <div class="col-sm-2"></div>
	    <div class="col-sm-3" style="font-weight: normal;"></div>
	    </div>
	    
	  <%--   <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			
		
			
			 <tr>
				
				<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strRenewShelfLife" filter="false"/></td>
				<td class="LABEL" width="25%">Level</td>
				<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strRenewLevel" filter="false"/></td>
			</tr>
			
		</table> --%>
		<div id="cancelDtlsDiv" style="display: none">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			
		<tr class="TITLE">
			<td colspan="4"><div id=''>Cancel Details</div></td>
		</tr>
	
		</table><table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			<td colspan="1" width="25%" class="LABEL">Cancel Date
			</td>
			<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strCancelDate" filter="false"></bean:write>
			</td>
			<td colspan="1" width="25%" class="LABEL">Cancel Seat Id
			</td>
			<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strCancelSeatId" filter="false"></bean:write>
			</td>
		</tr>
		<tr>
			<td colspan="1" width="25%" class="LABEL">Cancel Remarks
			</td>
			<td colspan="3"  class="CONTROL"><bean:write name="rateContractDtlBean" property="strCancelRemarks" filter="false"></bean:write>
			</td>
			
		</tr>
	</table>
	</div>
			<div id="id1"></div>
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			
		
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			
<img style="cursor: pointer; " title="Click Here To Come Back On Desk" 
src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			
			</td>
		</tr>
	</table> -->
	
					


	<div id="blanket" style="display:none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display:none;">
	<table bgcolor="white">
	<tr>
	<td>
	<div id="searchItemsDtlsDivId" style="display:block;"></div>
	</td>
	</tr>
	</table>

<input type="hidden" name="hmode"/>
<input type="hidden" name="strPrevRenewFlag" value="${rateContractDtlBean.strPrevRenewFlag}"/>
<input type="hidden" name="strCancelDtlsFlag" value="${rateContractDtlBean.strCancelDtlsFlag}"/>
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
<input type="hidden" name="strDeiveryLeadTime" value="${rateContractDtlBean.strDeiveryLeadTime}"/>
<input type="hidden" name="strDeiveryLeadTimeUnit" value="${rateContractDtlBean.strDeiveryLeadTimeUnit}"/>
<input type="hidden" name="strChk1" value="${rateContractDtlBean.strChk1}"/>
<input type="hidden" name="comboValue" value="${rateContractDtlBean.comboValue}"/>
<input type="hidden" name="strTenderDate" value="${rateContractDtlBean.strTenderDate}"/>
<input type="hidden" name="strTaxType" value="${rateContractDtlBean.strTaxType}"/>
<input type="hidden" name="strRenewSecurityAmount" value="${rateContractDtlBean.strRenewSecurityAmount}"/>
<input type="hidden" name="strRenewLevel" value="${rateContractDtlBean.strRenewLevel}"/>
<input type="hidden" name="strQuotationDate" value="${rateContractDtlBean.strQuotationDate}"/>
<input type="hidden" name="strPreviousContractFromDate" value="${rateContractDtlBean.strPreviousContractFromDate}"/>

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
	//$('.datepicker').val(dd);
	</script>
</body>
</html>