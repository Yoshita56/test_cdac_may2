<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Sample Register</title>


<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">


<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../purchase/js/glbl_purchase_tld.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script type="text/javascript">

function validate1(){
		
			
		  var hisValidator = new HISValidator("sampleRegisterPurTransBean");
          
	          hisValidator.addValidation("strProposalNo","dontselect=0","Please select Proposal No." );
	          hisValidator.addValidation("strSupplierId","dontselect=0","Please select Supplier Name" );
	          hisValidator.addValidation("strItemId","dontselect=0","Please select Drug Name" );
	          hisValidator.addValidation("strReservedQty","req","Please select Received Qty." );
	          hisValidator.addValidation("strUnitId","dontselect=0","Please select Unit Name" );
       	  
       	  var retVal = hisValidator.validate(); 
          hisValidator.clearAllValidations();
     	 if(retVal){
             document.forms[0].hmode.value = "INSERT";
             document.forms[0].submit();
         }else{
           		return false;
           }
	}

 

function cancelDesk()
{
	document.forms[0].hmode.value="INITIALPAGE";
	document.forms[0].submit();
}
function clearFun(obj)
{
	document.forms[0].mode.value=obj;
	document.forms[0].hmode.value="CLEAR";
	document.forms[0].submit();
}


function getProposalDtl(obj)
{
 		if(obj.value!="0")
 		{ 		
			var temp = document.forms[0].strProposalNo.value ;
			var mode="GETPROPOSALDTL";
			var url="SampleRegisterPurTransCNT.cnt?hmode="+mode+"&proposalNo="+temp;
			ajaxFunction(url,"1");
		}
		else
		{
		   document.getElementById("sampleReceiveDtlDivId").style.display="none";
		   document.getElementById("getProposalDtlId").style.display="none";
		}	
				
}
function getSupplierCmb(){
 		 		 		 			 		
  	 		var temp = document.forms[0].strProposalNo.value;
  	 		var tender_No=(document.forms[0].strProposalTLDHiddenVal.value).split("^")[0];
  	 		alert("tender_No->"+tender_No);
			var mode="GETSUPPCMB";
			var url="SampleRegisterPurTransCNT.cnt?hmode="+mode+"&proposalNo="+temp+"&tenderNo="+tender_No;
			
			ajaxFunction(url,"2");
		
	}	
	
function getProposalNo(){
 		 	
 		 		
	 		 	var temp = document.forms[0].strItemCategory.value;
				var mode="GETPROPOSALNO";
				var url="SampleRegisterPurTransCNT.cnt?hmode="+mode+"&itemCatNo="+temp;
				ajaxFunction(url,"3");
 		 		  	 		
	}	
function getItemCmb(){
 		 	
 		 	
	 		 	var temp1 = document.forms[0].strSupplierId.value;
	 		 	var temp2 = document.forms[0].strProposalNo.value;
				var mode="GETITEMCMB";
				var url="SampleRegisterPurTransCNT.cnt?hmode="+mode+"&supplierId="+temp1+"&proposalNo="+temp2;
				ajaxFunction(url,"4");
 		 		  	 		
	}

function getUnitCmb(){
 		 	
	 		 	var temp = document.forms[0].strItemId.value;
	 		 	var temp1 = temp.split('^');
				var mode="GETUNITCMB";
				var url="SampleRegisterPurTransCNT.cnt?hmode="+mode+"&itemUnitId="+temp1[4];
				ajaxFunction(url,"5");
 		 		  	 		
	}	
		
function getAjaxResponse(res,mode){
				
					
				
				if(mode==1){
				
				
					document.getElementById("getProposalDtlId").innerHTML = res;
					document.getElementById("sampleReceiveDtlDivId").style.display="block";
					document.getElementById("getProposalDtlId").style.display="block";
					getSupplierCmb();
					}
					
				if(mode==2){
	
				 	var objVal = document.getElementById("supplierId");
					objVal.innerHTML = "<select name = 'strSupplierId' class='comboNormal' onchange='getItemCmb();'>" + res + "</select>";	
					
					// getItemCmb();
					
				}	
				
				if(mode==3){
	
				 	var objVal = document.getElementById("proposalId");
					objVal.innerHTML = "<select name = 'strProposalNo' class='comboNormal' onchange='getProposalDtl(this);'>" + res + "</select>";	
					
					
					
				}	
				
				if(mode==4){
	
				 	var objVal = document.getElementById("itemId");
					objVal.innerHTML = "<select name = 'strItemId' class='comboNormal' onchange='getUnitCmb();'>" + res + "</select>";	
										
				}	
				
				if(mode==5){
	
				 	var objVal = document.getElementById("unitId");
					objVal.innerHTML = "<select name = 'strUnitId' class='comboNormal' >" + res + "</select>";	
					
				}	
			
		}


</script>

</head>

<body onload="getProposalNo();">
<html:form name="sampleRegisterPurTransBean" action="/transactions/SampleRegisterPurTransCNT"
	type="mms.transactions.controller.fb.SampleRegisterPurTransFB">


<div class="errMsg" id="errMsg"><bean:write name="sampleRegisterPurTransBean" property="strErr"/></div>
<div class="warningMsg"><bean:write name="sampleRegisterPurTransBean" property="strWarning"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="sampleRegisterPurTransBean" property="strMsg"/></div>

<center><tag:tab tabLabel="Sample Register"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">
		<tr class="HEADER">
			<td colspan="4">Sample Register&gt;&gt; Receive
				
			</td>
		</tr>
		
		
		<tr>
			<td  width="25%" class="LABEL" colspan="1">Drug Warehouse Name</td>
			<td  width="25%" class="CONTROL" colspan="1">
				<bean:write name="sampleRegisterPurTransBean" property="strStoreName" filter="false"/>
			</td>
		
			<td  width="25%" class="LABEL" colspan="1">Drug Category</td>
			<td  width="25%" class="CONTROL" colspan="1">
				<bean:write name="sampleRegisterPurTransBean" property="strItemCategoryName" filter="false"/>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%" colspan="2" ><font color="red">*</font>Proposal No.</td>
			<td class="CONTROL" width="50%" colspan="2" ><div id="proposalId">
			<select name="strProposalNo" class="comboNormal" onchange="getProposalDtl(this);">
				<option value="0">Select Value</option>
			</select></div></td>
		</tr>
	</table>
		
		<div id="getProposalDtlId" align="center"></div>
 <div id ="sampleReceiveDtlDivId" style="display:none">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">	
		<tr class="TITLE"><td colspan="4">Sample Receive Details</td></tr>		
		<tr>	
			<td  class="LABEL" width="25%" colspan="1"><font color="red">*</font>Supplier Name</td>
				<td  class="CONTROL" width="25%" colspan="1">
					<div id="supplierId">
				 		<select name="strSupplierId" class="comboNormal" onChange = "">
							<option value="0">Select Value</option>
						</select>
					</div>
				</td>
			<td  class="LABEL" width="25%" colspan="1"><font color="red">*</font>Drug Name</td>
				<td  class="CONTROL" width="25%" colspan="1">
					<div id="itemId">
				 		<select name="strItemId" class="comboNormal" onChange = "getUnitCmb();">
							<option value="0">Select Value</option>
						</select>
					</div>
				</td>	
		</tr>
		<tr>
		
			<td  width="25%" class="LABEL" colspan="1">Batch No.</td>
			<td  width="25%" class="CONTROL" colspan="1">
				<input type="text" name="strBatchNo" value="" class="txtNormal" onkeypress="return validateData(event,9);" maxlength="20">
			</td>
			
			<td  width="25%" class="LABEL" colspan="1">Expiry Date</td>
			<td  width="25%" class="CONTROL" colspan="1">
				<dateTag:date name="strExpiryDate" value="${sampleRegisterPurTransBean.strCurrentDate}"></dateTag:date>
			</td>
		</tr>
		<tr>
		
			<td  width="25%" class="LABEL"><font color="red">*</font>Recieved Qty.</td>
			<td  width="25%" class="CONTROL">
				<input type="text" name="strReservedQty" value="" class="txtNormal" maxlength="10" onkeypress="return validateData(event,5);">
			</td>
			
			<td  class="LABEL" width="25%" colspan="1"><font color="red">*</font>Unit Name</td>
				<td  class="CONTROL" width="25%" colspan="1">
					<div id="unitId">
				 		<select name="strUnitId" class="comboNormal" onChange = "">
							<option value="0">Select Value</option>
						</select>
					</div>
				</td>	
			
		</tr>
		<tr>
		        <td  class="LABEL" width="25%" colspan="1">
					<font color='red'>*</font>Remarks 
		        </td>
		        <td class="CONTROL" colspan="3">
			         <textarea rows="2" cols="20" name="strRemarks"></textarea>
		        </td>
		</tr>	
	</table>
</div>		
	
		<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
		
		<tr class="FOOTER">
		<td colspan="4" width="25%"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img src="../../hisglobal/images/btn-sv.png"
				onClick="validate1();" style="cursor: pointer;" title="Click here to save the data">
			<img src="../../hisglobal/images/btn-clr.png"
				onClick="clearFun('recieve');" style="cursor: pointer;" title="Click here to reset the data">
			<img src="../../hisglobal/images/back_tab.png"
				onClick="cancelDesk();" style="cursor: pointer;" title="Click here to forward control back to Sample Register Desk">
				</td>
		</tr>
	</table>
				
<input type="hidden" name="comboValue" value="${sampleRegisterPurTransBean.comboValue}"/>
<input type="hidden" name="strStoreId" value="${sampleRegisterPurTransBean.strStoreId}"/>
<input type="hidden" name="strStoreTypeId" value="${sampleRegisterPurTransBean.strStoreTypeId}"/>
<input type="hidden" name="strStoreName" value="${sampleRegisterPurTransBean.strStoreName}"/>
<input type="hidden" name="strGroupName" value="${sampleRegisterPurTransBean.strGroupName}"/>
<input type="hidden" name="strPath" value="${sampleRegisterPurTransBean.strPath}"/>
<input type="hidden" name="strItemCategory" value="${sampleRegisterPurTransBean.strItemCategory}"/>
<input type="hidden" name="strItemCategoryId" value="${sampleRegisterPurTransBean.strItemCategory}"/>
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>
<cmbPers:cmbPers/>

</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>








