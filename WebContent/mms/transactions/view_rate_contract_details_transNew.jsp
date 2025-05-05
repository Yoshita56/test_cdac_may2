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


function showPrevRenewDtls()
{
if(document.forms[0].strPrevRenewFlag.value==1)
document.getElementById("previousRenewDtlsDiv").style.display="block";

if(document.forms[0].strCancelDtlsFlag.value==1)
document.getElementById("cancelDtlsDiv").style.display="block";

document.forms[0].strContractToDate.focus();
}
</script>

</head>
<body onLoad="showPrevRenewDtls();">
<html:form name="rateContractDtlBean" action="/transactions/RateContractDtlTransBSCNT" type="mms.transactions.controller.fb.RateContractDtlTransFB">

	<div class="errMsg" id="errMsg"><bean:write name="rateContractDtlBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
	
<%-- <center>
	<div id="errMsg" class="errMsg"><bean:write name="rateContractDtlBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="rateContractDtlBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="rateContractDtlBean"
		property="strMsg" /></div>
<tag:tab tabLabel="Rate Contract Details" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
			</center> --%>
			
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
		</div>
	<!-- <div class="row rowFlex reFlex">
	  <div class="col-sm-12">
	    <p class="subHeaders"><i class="fas fa-file-contract " style="font-size: 26px;"></i>
	    &nbsp;Rate Contract Details&gt;&gt; Renew</p>
	  </div>
	</div> -->
	
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
	    <div class="col-sm-3"><p class='subHeaders'><i class="fas fa-file-contract" style="font-size: 18px;"></i>&nbsp;&nbsp;Current &gt;&gt; Contract Details</p></div>
	    <div class="col-sm-3"><label>Tender No.</label></div>
	    <div class="col-sm-3" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property ="strTenderNo" filter="false"></bean:write></div>
	    <div class="col-sm-3"></div>
	</div>

<div class="container">	 	    
	    <div class="row">
	    <div class="col-sm-2"><label>Contract From</label></div>
	    <div class="col-sm-2" style="color: #46b8da;"><bean:write name="rateContractDtlBean" property ="strContractFromDate" filter="false"></bean:write></div>
	    <div class="col-sm-2"><label>Contract To</label></div>
	    <div class="col-sm-2" style="color: #46b8da;"><bean:write name="rateContractDtlBean" property ="strContractToDate" filter="false"></bean:write></div>
	    <div class="col-sm-2"><label>Quotation No.</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property ="strQuotationNo" filter="false"></bean:write></div>
	    </div>
	    <div class="row">
	    <div class="col-sm-2"><label>RC/Tender SNO.</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property ="strRcTenderSno" filter="false"></bean:write></div>
	    <div class="col-sm-2"><label>TAX(%)</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property ="strTaxWithType" filter="false"></bean:write></div>
	    <div class="col-sm-2"><label>Remarks</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property="strRemarks" filter="false"></bean:write></div>
	    </div>
</div>	    
	    <div class="row">
	      <div class="col-sm-3"><p class='subHeaders'><i class="fas fa-prescription-bottle-alt" style="font-size: 18px;"></i>&nbsp;&nbsp;Current &gt;&gt; Drug Details</p></div>
	  	 <div class="col-sm-3" align="center"><label>Drug Name-</label></div>
	     <div class="col-sm-6" style="font-weight: normal;"><font color="red"><bean:write name="rateContractDtlBean" property="strItemBrandName" filter="false"></bean:write></font></div>
	    </div>
	    
<div class="container">	    
	     <div class="row">
	    <div class="col-sm-2"><label>Contracted Rate/Unit</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property="strLastPurchaseRate" filter="false"></bean:write>/<bean:write name="rateContractDtlBean" property="strLastPurchaseRateUnit" filter="false"/></div>
	    <div class="col-sm-2"><label>Security Amt(%)</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property="strLastSecurityAmount" filter="false"></bean:write></div>
	    <div class="col-sm-2"><label>Contract Quantity</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property="strLastContractQty" filter="false"></bean:write></div>
	    </div>
	    
	     <div class="row">
	    <div class="col-sm-2"><label>Delivery Day(s)</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property ="strDeliveryDays" filter="false"/></div>
	    <div class="col-sm-2"><label>Whether Item Is imported</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property ="strImportTypeViewFlag" filter="false"/></div>
	    <div class="col-sm-2"><label>Shelf Life(In Days)</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property ="strRenewShelfLife" filter="false"/></div>
	    </div>
	     <div class="row">
	     <div class="col-sm-2"><label>Level</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property ="strRenewLevel" filter="false"/></div>
	    <div class="col-sm-2"><label>Pack Size</label></div>
	    <div class="col-sm-2" style="font-weight: normal;"><bean:write name="rateContractDtlBean" property ="strRenewPackSize" filter="false"/></div>
	    <div class="col-sm-2"></div>
	    <div class="col-sm-2" style="font-weight: normal;"></div>
	    </div>
</div>
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			
			
			 <tr>
				<td class="LABEL" width="25%">Shelf Life(In Days)</td>
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
</div>
</div>
</div>
</fieldset>
<cmbPers:cmbPers/>
</html:form>

</body>
</html>