<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>


<html>
<head>
<meta charset=UTF-8">
<title>Drug Dispensing For OPD On-Line</title>
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">


<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>


<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet">

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
 
 <script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>

<script language="Javascript" src="../js/IssueTransBs.js"></script>

<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>

<script language="Javascript" src="../../hisglobal/js/jquery-3.5.1.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>

<script type="text/javascript">
	function setRowIndex()
	{
		alert(document.forms[0].strRowCount.value);
		document.getElementsByName("rowIndex1")[0].value=document.forms[0].strRowCount.value;
		document.getElementsByName("rowLength1")[0].value=document.forms[0].strRowCount.value;
		//document.forms[0].rowIndex1.value=document.forms[0].strRowCount.value;
		//document.forms[0].rowLength1.value=document.forms[0].strRowCount.value;
		//alert()
	}
	
	
	
	function printDiv() {
        var divContents = document.getElementById("issueDtlsDivId").innerHTML;
        //var a = window.open('', '', 'height=500, width=500');	
        var a = window.open('', 'printwin','text-align=center,top=100,width=800,height=800,scrollbars=yes ');
        a.document.write('<html>');
//         a.document.write('<body > <h1>Div contents are <br>');
		a.document.write('<img src="/HIS/hisglobal/images/aiimsp_logo.PNG" text-align=center/><br><br>');
        a.document.write(divContents);
//         a.document.write('</body></html>');
        a.document.close();
        a.print();
    }


function controlToIssueToPatientPage()
{	    
	//cancelIssue();
	//alert(document.getElementsByName("strId")[0].value);
		document.forms[0].hmode.value="INITVAL";
		document.forms[0].submit();
}
function getLfDetails()
{
	document.getElementById('lfDiv').style.display='block';
}

function closeLfDetails()
{
	document.getElementById('lfDiv').style.display='none';
}

function searchDrug(id)
{
	//console.log(id);
	    
		var comboId= '#strMultiRowItemId'+id+' option';
		var itemList = [];
		
		//console.log(comboId);
		
		$(comboId).each(function() {
		    itemList.push({ "value" :this.textContent , "data" : this.value });
		});	
		
		var searchId= '#strSearchDrug'+id;
		
		//console.log(searchId);
	
		$(searchId).autocomplete({
		   lookup: itemList,
		   minChars:2,
		   onSelect: function (suggestion) 
		   {        
		     getDrugNameSelected(suggestion.data,id);	    
		   }	    
		 });
		 
		 $(searchId).click(function(){	 
		 	$(this).val("");
		 	
		 });	
	 
	
}	

function getDrugNameSelected(itemId,id)
{
	//alert("Item Id-->>"+itemId+"- Index -"+id);
	
	var  totRow = parseInt(document.getElementsByName("rowLength1")[0].value,10);
	var indxRow = parseInt(document.getElementsByName("rowIndex1")[0].value,10);
	
	var rowBatch          = document.getElementsByName("itemParamValue");
	
	
	 var len = rowBatch.length;
	 
	 var passBatch = itemId.split("^")[0]+""+itemId.split("^")[1].toUpperCase();
	
	 console.log("Length--"+len);
	 
	        for(var j=0;j<len;j++)
   			{	        	
	        	console.log("--"+j+"-PASS_BATCH-"+passBatch);
	        	
	        	var cBatch = (rowBatch[j].value).split("^")[0]+""+(rowBatch[j].value).split("^")[1];
	        	console.log("--"+j+"-PASS_BATCH-"+passBatch+"--ROW_BATCH---"+cBatch);
	        	
	        	
   				if(passBatch == cBatch)
   				{
   					alert("Duplicate  ["+ document.getElementsByName("strSearchDrug")[id].value +"] Batch not allowed !!");  
   					var searchId= 'strSearchDrug'+id;	
   					document.getElementById(searchId).value = "";
   					return false;
   				}		
   			}	
	
	addRows(new Array('strQtyText','strTotalCostText'),new Array('t','t'),'1','1','R');
	
	// hstnum_itembrand_id ^ HSTSTR_BATCH_NO ^ ROUND(HSTNUM_INHAND_QTY) ^ ROUND(NVL(HSTNUM_RATE,0),2) ^ TO_CHAR(HSTDT_EXPIRY_DATE
	document.getElementById("strBrandName1-"+(indxRow+1)).innerHTML=document.getElementsByName("strSearchDrug")[id].value;
	document.getElementById("strBrandBatch1-"+(indxRow+1)).innerHTML=itemId.split("^")[1];
	document.getElementById("strAvlQty1-"+(indxRow+1)).innerHTML=itemId.split("^")[2];
	document.getElementById("strBrandRate1-"+(indxRow+1)).innerHTML=itemId.split("^")[3];
	document.getElementById("itemParamValue1-"+(indxRow+1)).value = itemId;
	
	var searchId= 'strSearchDrug'+id;	
	document.getElementById(searchId).value = "";
	
	
	 
}

function QtyValidation(index)
{
	   
		if(document.getElementById("strQtyText"+index).value!="")
		{
			    var issueQty     = document.getElementById("strQtyText"+index).value;
			    
			 // hstnum_itembrand_id ^ HSTSTR_BATCH_NO ^ ROUND(HSTNUM_INHAND_QTY) ^ ROUND(NVL(HSTNUM_RATE,0),2) ^ TO_CHAR(HSTDT_EXPIRY_DATE
			    var   avlQty     = document.getElementById("itemParamValue"+index).value.split("^")[2];			     
			
				if(parseInt(avlQty)<parseInt(issueQty,10))
				{
					alert("Issue Quantity ["+issueQty+"] cannot be greater than Available Quantity [ "+avlQty+" ] ");					
					document.getElementById("strQtyText"+index).value="";
					document.getElementById("strTotalCostText"+index).value = "0";
					
					var i=0;
					var Total=0;
					while((i<document.getElementsByName("strTotalCostText").length) )
					{
					      if( document.getElementsByName("strTotalCostText")[i].value!="")
						  {
					           Total=parseFloat(Total)+parseFloat(document.getElementsByName("strTotalCostText")[i].value);
					
						  }
					   i++;
				    }						
																		
                      document.getElementById("strNetCostDiv").innerHTML = "Rs. "+Total.toFixed(2);			
					  document.getElementsByName("strNetCost")[0].value= Total.toFixed(2);
					  document.getElementsByName("strPayDtl")[0].value= Total.toFixed(2);
						  
					return false;
				}
				else
				{
					// hstnum_itembrand_id ^ HSTSTR_BATCH_NO ^ ROUND(HSTNUM_INHAND_QTY) ^ ROUND(NVL(HSTNUM_RATE,0),2) ^ TO_CHAR(HSTDT_EXPIRY_DATE
					 var  rateObj              = document.getElementById("strQtyText"+index).value;
					 var  qtyObj               = document.getElementById("itemParamValue"+index).value.split("^")[3];	
					 
					 var total = parseFloat("0.00");
					 var qty = parseFloat("0.00");
					 var rate = parseFloat("0.00");
					 
					  qty    = qtyObj;	
					  rate   = rateObj;
							 
				
					 if(isNaN(rate) || rate=="") rate = "0";
					 if(isNaN(qty)  || qty=="") qty = "0";
					 if(qty=='0')		
					 {					  
					  total = parseFloat("0.00");
					 }
					 else
					 {
					   total = parseFloat(qty * rate );
					 } 
					 document.getElementById("strTotalCostText"+index).value = roundValue(total,2);
				}
				
				
						
				  var i=0;
				  var Total=0;
				while((i<document.getElementsByName("strTotalCostText").length) )
				{
				      if( document.getElementsByName("strTotalCostText")[i].value!="")
					  {
				           Total=parseFloat(Total)+parseFloat(document.getElementsByName("strTotalCostText")[i].value);
				
					  }
				   i++;
			    }
					
																	
                      document.getElementById("strNetCostDiv").innerHTML = "Rs. "+Total.toFixed(2);			
					  document.getElementsByName("strNetCost")[0].value= Total.toFixed(2);
					  document.getElementsByName("strPayDtl")[0].value= Total.toFixed(2);
					  //alert( document.getElementsByName("strNetCost")[0].value);
							
		}
}

function QtyValidationBeforeDelete(index)
{	
	
	deleteRow(index,'1','0');
	
	
	  var i=0;
	  var Total=0;
	  
		while((i<document.getElementsByName("strTotalCostText").length) )// document.getElementsByName("strTotalCostText")[i].value!="")//!=null && document.getElementsByName("strTotalCostText")[i]!=null)
		{
		  if( document.getElementsByName("strTotalCostText")[i].value!="")
		  {
		   Total=parseFloat(Total)+parseFloat(document.getElementsByName("strTotalCostText")[i].value);
		
		  }
		  i++;
	    }
				
      document.getElementById("strNetCostDiv").innerHTML = "Rs. "+Total.toFixed(2);			
	  document.getElementsByName("strNetCost")[0].value= Total;
	  
	  document.getElementsByName("strPayDtl")[0].value= Total;
	  
	  

}

function generateSlNo()
{
	 var depNamelength= document.getElementsByName("strBrandName").length - 1;
     
    // alert("depNamelength: "+depNamelength);
     
     for(var i=0;i<depNamelength;i++)
     {
     	document.getElementsByName("strSNo")[i].value=i+1;
     	
     }
}

	
</script>
<style>
        .example {
            page-break-after: always;
        }
        .activePrev{
        font-size:3rem;
        color:bisque;
        }
        
        .modal-body1 {
    					overflow:auto;
					}
		.autocomplete-suggestions{
		
		background-color: cornsilk;
		}
       
    </style>
</head>
<!-- <body onload="checkMsg();chkVisitDtl();"> -->
<body>

<html:form name="issuePatBean" action="/transactions/IssueToPatOPDTransCNT" type="mms.transactions.controller.fb.IssueToPatOPDTransFB">
	<fieldset>
	<legend class='legendHeader' id='nonPrintableLegend'>Drug Dispensing For OPD ON-LINE</legend>
	<div class="legend2" id='nonPrintableLegend2'>
		<button  type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" onClick="Backbtn();">
			<div class="popupToast"><i class="fas fa-arrow-left iround" title="Back"></i><span class="popuptextToast">Back</span></div>
		</button>
		<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
		<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i><span class="popuptextToast">Cancel</span></div>
		</button>	
		<button  id="printbutton" type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" data-toggle="modal" data-target="" style="background-color:#2e79b4;" onClick="showSlip();" >
			<div class="popupToast"><i class="fa fa-print iround"  title="Print Last Voucher"></i> <span class="popuptextToast">Print</span></div>
		</button>		
	    <button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' onClick="return checkEpidoseData();"   data-toggle="" data-target="#previewModal" >					
			<div class="popupToast"><i class="fa fa-save iround"  title="Save"></i> <span class="popuptextToast">Save</span></div>
		</button>												                 
  </div>  
  
  <div class="container-fluid">		
			<div class="viewport" id="nonPrintable">
				<div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="issuePatBean" property="strErrMsg" /></div>
				<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="issuePatBean" property="strWarningMsg" /></div>
				<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="issuePatBean" property="strNormalMsg" /></div>			
			</div>
			
			<pDtl:patDtlNew crNo="${issuePatBean.crNo}" address="false"></pDtl:patDtlNew>
			
			<div id="strAdmDtl">
				<bean:write name="issuePatBean" property="strAdmDtl" filter="false" />
			</div>
			
		<div class="prescriptionTile">
			<div class="row rowFlex reFlex">
				<div class="col-sm-6" style="display: none;">
					<label>Store</label>
				</div>
				<div class="col-sm-6"  style="display: none;">						
				<select name="strStoreId" onchange="   " class="browser-default custom-select">
					<bean:write name="issuePatBean" property="strStoreValues" filter="false" />
				</select>
				</div>
			</div>

			<div class="row rowFlex reFlex">
			    <div class="col-sm-2">
					<label></label>
				</div>
				<div class="col-sm-2">					
				</div>				
				<div class="col-sm-2">
				</div>
				<div class="col-sm-6">
				  <button type="button" class="btn btn-success btn-sm" tabindex="2" data-toggle="collapse"  href="#DiagnosisId" style="float: right;">
			   		<span class="btn-label"></span><i class="fas fa-pills"></i>&nbsp;Diagnosis Details</button>				   		
				
					<button type="button" class="btn btn-info btn-sm" tabindex="2" data-toggle="collapse"  href="#TreatmentId" style="float: right;">
			   		<span class="btn-label"></span><i class="fas fa-mortar-pestle"></i>&nbsp;Treatment Details</button>		
			   		<!-- <p id="strTramentDtlval"></p> -->					
					<button type="button" class="btn btn-warning btn-sm" tabindex="2"  onclick="getPrevIssueDtl();" style="float: right;">
			   		<span class="btn-label"></span><i class="fas fa-pills"></i>&nbsp;Previous Issue</button>
				</div>
			</div>
			
			<div class="collapse" id="DiagnosisId">
				<div class="row newrow2"></div>
					<bean:write name="issuePatBean" property="strPatientDiagDetails"	filter="false" />
				<div class="row newrow2"></div>			
				<br>
			</div>

			<div class="collapse show" id="TreatmentId">
				<div class="row newrow2"></div>
					<bean:write name="issuePatBean" property="strPatientTreatmentDtl"	filter="false" />
				<div class="row newrow2"></div>			
				<br>
			</div>
			
			 		
			<div class="row rowFlex reFlex"></div>			
			
			<div class="row rowFlex reFlex">			
				<div class="col-sm-2">
					<label>Prescription From<font color="red">*</font> </label>
				</div>
				<div class="col-sm-2">										
					<select name="strPrescriptionFrom" class="browser-default custom-select">						
						<option value="1">OPD General</option>						
						<option value="4">OPD Special</option>
					</select>
				</div>				
				<div class="col-sm-2">
					<label>Prescribed For(Days)</label>
					
				</div>
				<div class="col-sm-2">									
					<input type="text" class="form-control" name="strPrescribedFor" maxlength="3" onkeypress="return validateData(event,5);" value="0">				
				</div>
				<!--  
				<div class="col-sm-2">
					<label>Prescription Date<font color="red">*</font></label>
				</div>
				<div class="col-sm-2">								
				<input  style='font-size: 14px; font-weight: 400; color: #495057;' class="form-control datepicker1" value="${issuePatBean.strCtDate}" name="strPrescriptionDate">	
				</div>
				-->
				<div class="col-sm-2" >
					<label>Issue By<font color="red">*</font></label>
				</div>
				<div class="col-sm-2" id="consultantDivId">
				
				<select name="strPrescribedBy"  class="browser-default custom-select">
					<option value="0">Select Value</option>
					<bean:write name="issuePatBean" property="strIssueByCombo" filter="false" />
				</select>
				</div>
				
				
			</div>
			<div class="row rowFlex reFlex">
			
		
			<div class="col-sm-6"></div>
			</div>
			<div id='strPresData' style="display: none">
			    <bean:write name="issuePatBean" property="strOnlineTreatment"	filter="false" />
			</div>		
			
			<div class="" id="offlineFinderId">			
				<table class="table"  border="1px">
					<thead>
						<th  style='text-align:center;' width="35%"><b>Name</b></th>
						<th  style='text-align:center;' width="15%"><b>Batch No</b></th>
						<th  style='text-align:center;' width="10%"><b>Available Qty</b></th>
						<th  style='text-align:center;' width="15%"><font color="red">*</font><b>Cost/Unit</b></th>
						<th  style='text-align:center;' width="10%"><font color="red">*</font><b>Quantity</b></th>
						<th  style='text-align:center;' width="10%"><font color="red">*</font><b>Cost</b></th>
						<th  style='text-align:center;' width="5%">#</th>
					</thead>
					<!-- <tbody><tr></tr></tbody> -->
				</table>
				<div id="id1" style="width:100%"></div>
			</div>
					
			<div class="row rowFlex reFlex" style='margin: 5px;'>			
				<logic:equal value="1"  name="issuePatBean" property="strPatStatus">			
					<div class="col-sm-2">
						<label>Payment Mode </label>
					</div>
					<div class="col-sm-2">
						<select	id='strPayMode' name="strPayMode"  class="browser-default custom-select" >
							<bean:write name="issuePatBean" property="strPayModeValues" filter="false" />
						</select>
					</div>
					<div class="col-sm-2">
						<label>Payment Detail</label>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="strPayDtl"  readonly>
					</div>
				</logic:equal>
				<logic:equal value="2"  name="issuePatBean" property="strPatStatus">
						<div class="col-sm-8"></div>
				</logic:equal>
					<div class="col-sm-2">
						<label>Total Amount</label>
					</div>
					<div class="col-sm-2" id="strNetCostDiv" style="color:red;">
						<label><i class="fas fa-rupee-sign"></i>&nbsp;0.00</label>
						
					</div>		
			</div>			
	</div>			
	</div>
	<logic:equal value="0" name="issuePatBean" property="strMode">
		
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Drug Dispensing&gt;&gt;</td>
			</tr>
		</table>
	</logic:equal>

	<logic:equal value="1" name="issuePatBean" property="strMode">
		
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Staff&gt;&gt;</td>
			</tr>
		</table>
	</logic:equal>

	<logic:equal value="2" name="issuePatBean" property="strMode">
		
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Patient/Staff&gt;&gt;</td>
			</tr>
		</table>
	</logic:equal>


	<div class='popup' id='balQtyDtlId' style="display: none">
	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr class="HEADER">
			<td colspan='3'>Quantity Details</td>
			<th align='right'><img style='cursor: pointer; ' src='../../hisglobal/images/popUp_cancel.JPG' onClick="hideBalQtyDetails('balQtyDtlId');"></th>
		</tr>
	</table>

	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr>
			<td colspan="1" class='multiLabel'>Req Qty</td>
			<td colspan="1" class='multiLabel'>Issue Qty</td>

		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='1'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='2'></div>
			</td>

		</tr>
	</table>
	</div>




	
	
	
  <div id='lfDiv' style='display:none;'>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
			cellspacing="1px">
	
			<tr>
				<td colspan="3" width='75%'><div class='line'><label class='DIVLABEL'>Patient LF Account Details</label></div></td>
				<td colspan="1" width='25%'><div class='line'><label onclick='closeLfDetails();' class='DIVLABEL'><font color='red'>Hide LF Details</font></label></div></td>
			</tr>
			<tr>
				<td width="25%" colspan="1" class="LABEL">Account Opening Date</td>
				<td width="25%" colspan="1" class="CONTROL"><bean:write
					name="issuePatBean" property="strLFAccountOpenDate" filter="false" /></td>
	
				<td width="25%" colspan="1" class="LABEL">Current Balance</td>
				<td width="25%" colspan="1" class="CONTROL"><bean:write
					name="issuePatBean" property="strLFBalanceAmount" filter="false" /></td>
			</tr>
			
			<tr>
	
				<td width="25%" colspan="1" class="LABEL">LF Account Status</td>
				<td width="25%" colspan="3" class="CONTROL"><bean:write
					name="issuePatBean" property="strLFAccountStatus" filter="false" /></td>
			</tr>
			
		
		</table>
	</div>
 
    <div id="allDivId" style="display: block;">	</div> 

	<div style="display: none;">
	<div id="patientDetailsDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="issuePatBean" property="strPatientDetails"
				filter="false" />
		</tr>
	</table>
	
		<div id="patientDiagDetailsDivId" style="display: block;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="issuePatBean" property="strPatientDiagDetails"
				filter="false" />
		</tr>
	</table>
	</div>
	
	</div></div>
<div style=''>

	
</div>
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strNetCost" 				value="0.00">
	<input type="hidden" name="strUpdateFlag" 			value="" />	
	<input type="hidden" name="storeName" 				value="${issuePatBean.storeName}" />
	<input type="hidden" name="itemCatName"				value="${issuePatBean.itemCatName}" />
	<input type="hidden" name="strCrNo" 				value="${issuePatBean.strCrNo}" />		
	<input type="hidden" name="crNo" 					value="${issuePatBean.crNo}" />
	<input type="hidden" name="strId" 					value="${issuePatBean.strId}" />
	<input type="hidden" name="itemCategory" 			value="${issuePatBean.itemCategory}" />
	<input type="hidden" name="strItemCat" 				value="${issuePatBean.itemCategory}" />	
	<input type="hidden" name="strDuplicateItem" 		value="" />		
	<input type="hidden" name="strConfCatCode"			value="${issuePatBean.strConfCatCode}" />
	<input type="hidden" name="strIssueNo" 				value="${issuePatBean.strIssueNo}" />
	<input type="hidden" name="strIssueDtl"				value="${issuePatBean.strIssueDtl}" />
	<input type="hidden" name="disFlag" 				value="${issuePatBean.disFlag}" />
	<input type="hidden" name="mode" 					value="${issuePatBean.strMode}" />
	<input type="hidden" name="strMode" 				value="${issuePatBean.strMode}">
	<input type="hidden" name="strIssueMode"			value="${issuePatBean.strIssueMode}">
	<input type="hidden" name="strCtDate" 				value="${issuePatBean.strCtDate}" />
	<input type="hidden" name="strVisitDtl" 			value="${issuePatBean.strVisitDtl}" />
	<input type="hidden" name="strIssueNum" 			value="${issuePatBean.strIssueNum}" />
	<input type="hidden" name="isUpdateOpdDrugReq"  	value="" />
	<input type="hidden" name="strGlobalval" 			value="" />
	<input type="hidden" name="strErrMsg" 				value="${issuePatBean.strErrMsg}" />
	<input type="hidden" name="strBillingHiddenValue" 	value="${issuePatBean.strBillingHiddenValue}" />
	<input type="hidden" name="strTariff_Flag" 			value="1" />
	<input type="hidden" name="strPatStatus" 			value="${issuePatBean.strPatStatus}" />
	<input type="hidden" name="strRowCount" 			value="${issuePatBean.strRowCount}" />
	
	
	<cmbPers:cmbPers />
	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
				<div id="searchItemsDtlsDivId" style="display: block;"></div>
				<div id="stockDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>
	
	   <div class="modal fade bd-example-modal-lg" id="issueDtlModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">Previous Issue
						<button type="button" class="btn btn-primary" onclick="printDiv()">Print</button>
					</div>
					<div class="modal-body">
						<div id="issueDtlDivId"></div>
						<hr>
						<div class="modal-body1" id="issueDtlsDivId" style="display: block;height:10rem;"></div>
					</div>
				</div>
			</div>
		
		</div> 





	
							
							
							
							<div class="modal-container" id="payDtlCDMenu" > <!-- style="display: none;"> -->
					<div id="payModeModal" class="modal fade" role="dialog">
						<div class="modal-dialog" style="max-width:700px;">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header" style="border-top: 1px solid black;">
									<h5 class="modal-title">Payment Details &gt;&gt;Credit / Debit Card</h5>
									<button type="button" 
										class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body" id="modalSpaceId">
								
									<div  id='payDtlCDMenuInner ' style="display: block">
				
					
					<!-- <p class="subHeaders">Payment Details &gt;&gt;Credit / Debit Card</p> -->
					<div class="row rowFlex reFlex">
					<div class="col-sm-6"><label><font color="red">*</font>Bank Name</label></div>
					<div class="col-sm-6"><input type='text' name='strPayBankName' tabindex="1" class='form-control' value="" onkeypress="return validateData(event,11);" maxlength="50"  style="border:0.5px solid black;"/></div>
					</div>
					<div class="row rowFlex reFlex">
					<div class="col-sm-6"><label><font color="red">*</font>Card No. (Last 4 Digits)</label></div>
					<div class="col-sm-6"><input type='password' name='strCardNo' tabindex="1" class='form-control' maxlength="4" onkeypress="return validateData(event,5);"  style="border:0.5px solid black;"/></div>
					</div>
					<div class="row rowFlex reFlex">
					<div class="col-sm-6"><label><font color="red">*</font>Transaction No.(Max : 15 Digits)</label></div>
					<div class="col-sm-6"><input type='text' name='strAuthNo' tabindex="1" class='form-control' onkeypress="return validateData(event,5);" maxlength="15"  style="border:0.5px solid black;"/></div>
					</div>
					<div class="row rowFlex reFlex">
					<div class="col-sm-6"><label><font color="red">*</font>Transaction Date</label></div>
					<div class="col-sm-6"><input type="text" class="form-control" tabindex="1" maxlength="11" placeholder="(DD-Mon-YYYY)" name="strAuthDate" value="${issuePatBean.strCtDate }"  style="border:0.5px solid black;"/></div>
					</div>
					<div class="row rowFlex reFlex">
					<div class="col-sm-6"><label><font color="red">*</font>Card Type</label></div>
					<div class="col-sm-6"><select class='form-control' name='strCardType' tabindex="1" >
								<option value='0'>Select Value</option>
								<option value='1'>Master</option>
								<option value='2'>Visa</option>
								<option value='3'>Rupay</option>
								<option value='4'>Others</option>
						</select></div>
				
					</div>
                     <div class="row rowFlex reFlex">
	                   <div class="col-sm-12">
	                   <label class='text-danger'># Ensure that the Transaction/Card Swap is Successful</label>
	                   </div>
					  </div>
					
				
			                       </div>
								</div>
								
								<div class="modal-footer" style="border-top: 1px solid black;">
								<div class="row rowFlex reFlex">
				               <div class="col-sm-12" align="center">
				                <button type="button" class="btn btn-success" onClick='return validateCreditDebit();'>Save</button>
				                <button type="button" class="btn btn-danger" onclick="resetPayMode();" data-dismiss="modal">Cancel</button>
				         </div>
				   </div>
				</div>
							</div>
						</div>
					</div>
				</div>
				
				
				
				<div class="modal-container" id="payDtlCDDMenu" > <!-- style="display: none;"> -->
					<div  id="payDtlCDDModal" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header" style="border-bottom: 1px solid black;">
									<h5 class="modal-title">Payment Details &gt;&gt;Check / DD</h5>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body" id="modalSpaceId">
								
									<div  id='payDtlCDDMenuInner' style="display: block">
								
								<div class="row rowFlex reFlex">
									<div class="col-sm-6">
										<label><font color="red">*</font>Bank Name</label>
									</div>
									<div class="col-sm-6">
										<input type='text' tabindex="1" name='strPayCDDBankName'
											class='form-control'
											onkeypress='return validateData(event,11);' maxlength="50" style="border:0.5px solid black;" />
									</div>
									
								</div>
								<div class="row rowFlex reFlex">
								
									<div class="col-sm-6">
										<label><font color="red">*</font>Cheque / DD No.(Max :
											15 Digits)</label>
									</div>
									<div class="col-sm-6">
										<input type='text' name='strChequeDDNo' tabindex="1"
											class='form-control'
											onkeypress="return validateData(event,5);" maxlength="15" style="border:0.5px solid black;" />
									</div>
								</div>
								<div class="row rowFlex reFlex">
									<div class="col-sm-6">
										<label><font color="red">*</font>Cheque / DD Issue
											Date</label>
									</div>
									<div class="col-sm-6">
										<input type="text" tabindex="1" placeholder="(DD-Mon-YYYY)" class="form-control"
											maxlength="11" name="strChequeDDDate"
											value="${issuePatBean.strCtDate }" style="border:0.5px solid black;"/>
									</div>
									
								</div>
								
							</div>
							
								</div>
								<div class="modal-footer" style="border-top: 1px solid black;">
                                  <div class="row rowflex reflex">  
                               <div class="col-sm-12">
						        <button type="button" class="btn btn-success" onclick="validateCheckDD();">Save</button>
						       <button type="button" class="btn btn-danger" onclick="resetPayMode();" data-dismiss="modal">Cancel</button>
						        </div>
						        </div>
                              </div>
								
							</div>
						</div>
					</div>
				</div>
	
</fieldset>
</html:form>
<jsp:include page="OPD_Generic_SearchRowNew.jsp"></jsp:include>
<script type="text/javascript">
$( document ).ready(function() 
{
    console.log( "ready!"+ $('#strTreatmentDtlCountId').val() );
    $('#strTramentDtlval').html('   Count :: '+$('#strTreatmentDtlCountId').val());
});
</script>
</body>
</html>