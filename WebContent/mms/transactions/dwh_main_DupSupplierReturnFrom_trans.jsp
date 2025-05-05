<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<!--  Developer : Santosh Chauhan
	  Version	: 1.0	 
	  Date 		: 28-Jun-2013
	  Module 	: Mms
	  Process	: Return/Condemnation Order
-->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Replacement Condemnation Order</title>


<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
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
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/dwh_main_dupSupplierReturnFrom_transNEW.js"></script>

<!-- <link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" /> -->
<!-- <link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet"> -->
<!-- <link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> -->

<!-- <script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script> -->
<!-- <link href="../css/master.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css"> -->
<!-- <script language="Javascript" src="../../hisglobal/js/validation.js"></script> -->
<!-- <script language="Javascript" src="../../hisglobal/js/util.js"></script> -->
<!-- <script language="JavaScript" src="../js/BreakageItem.js"></script> -->

	
	
	
<style>
.gj-textbox-md
{
border:1px solid #ced4da;
padding: 0.375rem 0.75rem;
font-weight: 400;
border-radius: 0.25rem;
border-bottom: 1px solid #ced4da;
display: block;
font-family: Helvetica,Arial,sans-serif;
font-size: 14px;
line-height: 16px;
padding: 8px inherit;
margin: 0;
width: 100%;
background: 0 0;
text-align: left;
}

.gj-datepicker-md [role="right-icon"] {
position: absolute;
right: 7px;
top: 7px;
font-size: 24px;
}
</style>
	


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
		
		
		 function printDataOne1() {
			    document.getElementById("printImg").style.display = "none"; 
	            var divContents = document.getElementById("nosqDrugDtDivId").innerHTML;
	            var a = window.open('', '', 'height=500, width=500');
	            a.document.write('<html>');
// 	            a.document.write('<body > <h1>Div contents are <br>');
	            a.document.write(divContents);
	            a.document.write('</body></html>');
	            a.document.close();
	            a.print();
	            document.getElementById("printImg").style.display = "block"; 
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
function setvalues() {
	
	document.getElementById("suppid1").style.display='';
	document.getElementById("suppid2").style.display='';
}
/* function getdata() {
	if(document.forms[0].strActionsId.value=='2')
		{
			document.getElementById("suppid1").style.display='none';
			document.getElementById("suppid2").style.display='none';
		}
		else
		{
			document.getElementById("suppid1").style.display='';
			document.getElementById("suppid2").style.display='';
		}
} */
</script>
<style>
.col-md-1half{
	width:12.5%;
}

</style>
</head>

<body onload="setvalues(),getReport();">
<html:form name="dupSupplierReturnFromTransBean"
	action="/transactions/DupSupplierReturnFromTransCNT"
	type="mms.transactions.controller.fb.DupSupplierReturnFromTransFB" enctype="multipart/form-data">
	
	
	
	
	
<div class="viewport" id="nonPrintable">
			<div class="container-fluid">

				 
			<div class="row justify-content-center">
					<div class="col-sm-12">
						<br>
						<div class="prescriptionTile">
						<div class="row rowFlex reFlex">
						<div class="col-md-12" align="center">
				       	<div class="errMsg" id="errMsg"><bean:write name="dupSupplierReturnFromTransBean" property="strErr" /></div>
						<div class="warningMsg" id="warningMsg"><bean:write name="dupSupplierReturnFromTransBean" property="strWarning" /></div>
						<div class="normalMsg" id="normalMsg"><bean:write name="dupSupplierReturnFromTransBean" property="strMsg" /></div>
						</div>
						</div>
							<div class="row rowFlex reFlex" id="saveId">
								<div class="legend2" id='nonPrintableLegend2'>
									
									
									<button type="button" id="printButton"
										class="float-right btn btn-outline-success mt-1 btn-circle"
										tabindex='2' id="submitId" onclick=' return validate2();'
										name="dupSupplierReturnFromTransBean"
										style="background-color: #5cb85c;">
										<i class="fa fa-print iround" title="Print"></i>
									</button>
									
									<button type="button"
										class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
										onclick="cancelFunc();">
										<i class="fas fa-ban iround" title="Cancel"></i>
									</button>
								
									
									

								</div>
							</div>

			<!-- 	<div class="row rowFlex reFlex">
								<div class="col-sm-5">
									<p class="subHeaders">
										<button type="button"
											class="btn btn-outline-success  btn-circle1">
											<i class="fas fa-file-alt iround" title="Cancel"></i>
										</button>
										&nbsp;Issue(Off Line)
									</p>
							
								</div>
							</div> -->


					<%-- <div class="row rowFlex reFlex">
								<div class="col-md-12" align="center">
									<div id="radionbtn1">
									<html:radio property="strActionsId" name="dupSupplierReturnFromTransBean" value="2" onclick="" >Condemnation</html:radio>
								&nbsp;&nbsp;	<html:radio property="strActionsId" name="dupSupplierReturnFromTransBean" value="1" onclick="getdata();" >Return</html:radio> 
								</div>
								</div>
							</div> --%>
	
	
	<br>
	<div class="row rowFlex reFlex">
		<div class="col-md-2 px-4">Store Name</div>
		<div class="col-md-2"><select name="strStoreId"  class="browser-default custom-select" onchange="getCatcmb();">
				 	<bean:write name="dupSupplierReturnFromTransBean" property="strStoreName" filter="false"></bean:write> 
				</select></div>
		<div class="col-md-2"><font color="red">*</font>Category Name</div>
		<div class="col-md-2"><div id="catcmbdiv">
				<select name="strcatno"  class="browser-default custom-select" onChange="getsuppliername();">
				    <bean:write name="dupSupplierReturnFromTransBean" property="strCatName" filter="false"></bean:write>
				    <option title="select value" value="0">select value</option>
			    </select>
			</div></div>
		<div class="col-md-2" id="suppid1"><font color="red">*</font>Supplier Name</div>
		<div class="col-md-2" id="suppid2"><div id="supplierdiv">
				<select name="strsupplierno"  class="browser-default custom-select" onChange="">
				    <bean:write name="dupSupplierReturnFromTransBean" property="strSupplierName" filter="false"></bean:write>
				    <option title="select value" value="select value">select value</option>
			    </select>
			</div></div>
		
	</div>
	<div class="row">
		<div class="col-md-2 px-4"><font color='red'>*</font>From Date</div>
		<div class='col-md-2'><input  name="strFromDate"
											class="form-control datepicker"
											value ="${dupSupplierReturnFromTransBean.strFromDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
		<div class="col-md-2"><font color='red'>*</font>To Date</div>
		<div class="col-md-2"><input  name="strToDate"
											class="form-control datepicker"
											value ="${dupSupplierReturnFromTransBean.strToDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
		<div class="col-md-1"><a class="btn btn-sm btn-success" href="#" onclick="date_validation();" title="Click to see Details" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a></div>
		<div class="col-md-1"><a class="btn btn-sm btn-success" href="#" onclick="date_detail_validation();" title="Click to see Details" style="font-size:1rem;">Detail <i class="fas fa-angle-double-right"></i></a></div>
	</div>
			
	<br>
	<div class="row" id="debitNoteDiv" style="display:none;">
		<!-- <div class="col-md-12 px-4" align="center">
		<table style="width:100%" align="center">
			<tr style="border-bottom: 1px solid">
				<th style="width:10%; text-align:center">#</th>
				<th style="width:40%; text-align:center">Debit Note Number</th>
				<th style="width:40%; text-align:center">Date of Order</th>
				
				
			</tr>
			<tr>
				<td style="width:10%; text-align:center"><input type="radio" name="strdebitNote" value="4820041300005^13-APR-20^Gfhfgh"></td>
				<td style="width:30%; text-align:center">4820041300005</td>
				<td style="width:30%; text-align:center">13-APR-20</td>
				
			</tr>
			
		</table></div> -->
		</div>
		
	<br>
	<div id ="nosqDrugDtlsDivId"></div>	
	
	<div id ="nosqDrugDtDivId"></div>	
	
	<div style="display: none;" id="actionDtlsDivId">
	<div class="row">	
		<div class="col-md-2"><div style="display: block;" id="">Action Detail(s)</div></div>
		<div class="col-md-2"><div align="right"><font size="2" color="red">*</font>Action </div></div>
		<div class="col-md-2"><div id="actionsDivId">
					<select name="strActionId" class="comboMax" onchange="onChangeAction();" >
							<option value="1" title="Return">Return</option>
							<option value="2" title="Condemnation">Condemnation</option>
			    	</select>
				</div>
		</div>
				
	</div>
	</div>
	
		
	<div style="display: none;" id="returnDtlsDivId">	
	<div class="row">	
		<div class="col-md-12 px-4">Return/Condemnation Details</div>
	</div>
	<div class="row">
		<div class="col-md-2 px-4">Return Date</div>
		<div class="col-md-2"><input  name="strReturnDate"
											class="form-control datepicker"
											value ="${dupSupplierReturnFromTransBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);">
		</div>
		<div class="col-md-2">Return To</div>
		<div class="col-md-2"><input class="form-control" type="text" name="strReturnTo" ></div>
		<div class="col-md-2">Remarks</div>
		<div class="col-md-2"><textarea class="form-control" name="strRemarks" onkeyup="" ></textarea></div>
	</div>
	</div>
	
	<div style="display: none;" id="condemnationDtlsDivId">	
    <div class="row">	
		<div class="col-md-12 px-4">Return/Condemnation Details</div>
	</div>
	<div class="row">
		<div class="col-md-2 px-4">Condemnation Date</div>
		<div class="col-md-2"><input  name="strCondemnationDate"
											class="form-control datepicker"
											value ="${dupSupplierReturnFromTransBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);">
		</div>
		<div class="col-md-2">Issue to CTF/Condemnation Type</div>
		<div class="col-md-2"><select name="strCondemnationType" >
						<bean:write name="dupSupplierReturnFromTransBean" property="strCondemnationTypeCmbOptions" filter="false" />
					</select></div>
		<div class="col-md-2"><div id="mandDivId" style="display: none;"><font size="2" color="red">*</font></div>Remarks</div>
		<div class="col-md-2"><textarea class="form-control" name="strCondemnationRemarks" onkeyup="')" ></textarea></div>
	</div>
	</div>
		
	<br>
	<div class="row rowFlex reFlex">
		<div class="col-md-12" align="right"><font size="2" color="red">*</font>Mandatory Fields</div>
	</div>
	

	
		
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strCtDate" value="${dupSupplierReturnFromTransBean.strCtDate}" />
	<input type="hidden" name="strTempAction" value="" />
	<input type="hidden" name="strVoucherFlag" value="${dupSupplierReturnFromTransBean.strVoucherFlag}" />
	<input type="hidden" name="strHiddenItemDtl" value="${dupSupplierReturnFromTransBean.strHiddenItemDtl}" />
	<input type="hidden" name="strTmpStoreId" value="${dupSupplierReturnFromTransBean.strTmpStoreId}" />
	<input type="hidden" name="strTmpItemcatId" value="${dupSupplierReturnFromTransBean.strTmpItemcatId}" />
	<input type="hidden" name="strTmpitembrandId" value="${dupSupplierReturnFromTransBean.strTmpitembrandId}" />
	<input type="hidden" name="strTmpSupplierId" value="${dupSupplierReturnFromTransBean.strTmpStoreId}" />
	<input type="hidden" name="strsaveflag" value="${dupSupplierReturnFromTransBean.strsaveflag}" />
	
	
	
	
<cmbPers:cmbPers />
</div>
</div>
</div>
</div>
</div>

</html:form>

<tag:autoIndex></tag:autoIndex>
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
<div id="blanket" style="display:none;"></div>
 <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         <div id="voucherDivId" style="display:block;"></div>
      </td>
     </tr>
    </table>
   </div>	

</html>

