<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>



<html>
<head>
<meta charset=UTF-8">
<title>Sample Register</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script type="text/javascript">

function getMemberDtl(mode)
{
	var mode=mode
	var url="SampleRegisterTransCNT.cnt?hmode="+mode+"&committeType="+document.forms[0].strCommitteeType.value+"&itemCategNo="+document.forms[0].strItemCategory.value;
	ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode){
				
				var err = document.getElementById("errMsg");
				var temp = res.split("####");
				if(temp[0] == "ERROR")
				{
					err.innerHTML = temp[1];
					return;
				}
				
				var objVal;
				if(mode=="1"){				
				
					document.getElementById("memberDtlInner").innerHTML=res;	
				}
				
}
function save()
{
	  var hisValidator = new HISValidator("sampleRegisterTransBean");
	  var retVal=true;
	  var recQty="";
	  var unitRecBase="";
	  var consumeQty="";
	  var consumeQtyUnit="";
	  if(document.getElementsByName("strConsumableFlag")[0].value=="1")
	  {
	  	 	hisValidator.addValidation("consumeQty","req","Consumer Quantity is Mandatory Field" );
	 	  	hisValidator.addValidation("strConsumeQtyUnit","dontselect=0","Please Select Consume Quantity Unit" );
	  }
 	 hisValidator.addValidation("strCommitteeType","dontselect=0","Please Select Committee Type" );
 	 hisValidator.addValidation("strRemarks","req","Final Remarks is mandatory Field" );
	 hisValidator.addValidation("strRemarks", "maxlen=100", "Final Remarks should have less than or equal to 100 Characters" );
	
	 

     var retVal = hisValidator.validate(); 
     hisValidator.clearAllValidations();
    	 if(retVal)
    	 {
			
			recQty=document.getElementsByName("strRecQtyVals")[0].value;
			unitRecBase=document.getElementsByName("strUnitBaseVals")[0].value;
			if(document.getElementsByName("strConsumableFlag")[0].value=="1")
	  		{
		  	 	consumeQty=document.getElementsByName("consumeQty")[0].value;
				consumeQtyUnit=document.getElementsByName("strConsumeQtyUnit")[0].value.split("^")[1];
	  		}
	  		else
	  		{
	  			consumeQty=0;
				consumeQtyUnit=0;
	  		}
			var recDtl=parseInt(recQty)*parseInt(unitRecBase);
			var consumeDtl=parseInt(consumeQty)*parseInt(consumeQtyUnit);
			
			if(recDtl<consumeDtl){
				alert("Consume Quantity can't be Greater than Recieve Quantity");
				ocument.getElementsByName("consumeQty")[0].focus();
				return false;
			}
			
			document.forms[0].hmode.value="VERIFYUPDATE";
			document.forms[0].submit();
	    }
		else
		{
			return false;
		}
}
function openDivPopu()
{
		if(document.getElementsByName("strCommitteeType")[0].value=="0")
   	 	{
   	 		alert("Please Select Committee Type")
   	 	}
 	 	else{
  			 popup('memberDtl' , '130','250');
  		}
}
function closePopUpDiv()
{
	hide_popup('memberDtl');
}
function clearData()
{
	var size=document.getElementsByName("strMemberRecommendation").length;
	if(size>1){
		for(var i=0;i<size;i++){
			document.getElementsByName("strMemberRecommendation")[i].value="";
		}
	}
	else{
		document.getElementsByName("strMemberRecommendation")[0].value="";
	}
	hide_popup('memberDtl');
}
function cancelWindow()
{
	document.forms[0].hmode.value="INITIALPAGE";
	document.forms[0].submit();
}
function remarksFunc()
{
	if(document.forms[0].strApprovalStatus[0].checked){
		document.getElementById("remarksId").innerHTML="Remarks";
	}
	else
	{
		document.getElementById("remarksId").innerHTML="<font color='red'>*</font>Remarks";
	}
}

</script>

</head>

<body>
<html:form name="sampleRegisterTransBean" action="/transactions/SampleRegisterTransCNT"
	type="mms.transactions.controller.fb.SampleRegisterTransFB" enctype="multipart/form-data" method="post">


<div class="errMsg" id="errMsg"><bean:write name="sampleRegisterTransBean" property="strErr"/></div>
<div class="warningMsg"><bean:write name="sampleRegisterTransBean" property="strWarning"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="sampleRegisterTransBean" property="strMsg"/></div>

<center><tag:tab tabLabel="Sample Register"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0Px">
		<tr class="HEADER">
			<td colspan="4">Sample Register Verification&gt;&gt; Add
				
			</td>
		</tr>
		
		
		<tr>
			<td  width="25%" class="LABEL">Store Name</td>
			<td  width="25%" class="CONTROL" colspan="3">
			<bean:write name="sampleRegisterTransBean" property="strStoreName" filter="false"/>
			</td>
			
		</tr>
			<tr>
			<td  width="25%" class="LABEL">Item Category</td>
			<td  width="25%" class="CONTROL">
				<bean:write name="sampleRegisterTransBean" property="strItemCategDtl" filter="false"/>
			</td>
			<td  class="LABEL" width="25%">
					Supplier Name
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterTransBean" property="strSupplierName" filter="false"/>
								
					</td>
		</tr>
		
		
			<tr>
				<td  width="25%" class="LABEL">Item/Drug Name</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterTransBean" property="strItemName" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Brand Name
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterTransBean" property="strItemBrandName" filter="false"/>
								
					</td>
		</tr>
		
		<tr>
				<td  width="25%" class="LABEL">Batch/Sl.No</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterTransBean" property="strBatchSlno" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Received Qty
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterTransBean" property="strRecQty" filter="false"/>
								
					</td>
		</tr>
		<tr>
				<td  width="25%" class="LABEL">Tender No.</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterTransBean" property="strTenderNo" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Quotation No.
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterTransBean" property="strQuotationNo" filter="false"/>
								
					</td>
		</tr>
		
		</table>
		<logic:equal value="1" name="sampleRegisterTransBean" property="strConsumableFlag">
			<table cellspacing="0px" class="TABLEWIDTH" align="center" cellpadding="0Px" > 
				<tr>
					<td  width="25%" class="LABEL"><font color='red'>*</font>Consume Quantity</td>
					<td  width="25%" class="CONTROL"><input type="text" name='consumeQty' onkeypress="return validateData(event,5);" ></td>
					<td  width="25%" class="LABEL"><font color='red'>*</font>Consume Quantity Unit</td>
					<td  width="25%" class="CONTROL">
						<select name='strConsumeQtyUnit' class='comboNormal'>
							<bean:write name="sampleRegisterTransBean" property="strUnitVals" filter="false"/>
						</select>
						
					</td>
				</tr>
			</table>
		</logic:equal>
		<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
		<tr>
			<td class="TITLE" colspan="5">
				Verification Details
			</td>
		</tr>
		<tr>
		<td  class="LABEL" width="25%" >
					<font color="red">*</font>Committee Type  
		</td>
		<td class="CONTROL" width="25%">
			<select name="strCommitteeType" class="comboNormal" onchange="getMemberDtl('COMMITEEMEMBERDTL');">
				<bean:write name="sampleRegisterTransBean" property="strCommitteeValues" filter="false"/>
			</select>
		</td>
		<td  class="LABEL" width="25%" >
					Committee Member Dtl  
		</td>
		<td class="CONTROL" width="25%" >
			<img src="../../hisglobal/images/plus.gif" 
									onClick="openDivPopu();" style="cursor: pointer; " title="Click Here To See Member Details"/>
		</td>
		</tr>
	
		</table>
		<jsp:include page="uploadFile.jsp"></jsp:include>
		<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
			<tr>
			<td class="LABEL" >Approval Status</td>
			<td class="CONTROL" colspan="4"><html:radio name="sampleRegisterTransBean" property="strApprovalStatus" value="1" >Accepted</html:radio>
			<html:radio name="sampleRegisterTransBean" property="strApprovalStatus" value="2" >Rejected</html:radio>
			</td>
		</tr>
		<tr>
			<td  class="LABEL" width="25%">
						<div id='remarksId'><font color='red'>*</font>Final Remarks</div>
			</td>
			<td class="CONTROL" width="25%" colspan="4" >
				<textarea rows="2" cols="20" name="strRemarks"></textarea>
			</td>
			</tr>
		</table>
		<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
		
		<tr class="FOOTER">
		<td colspan="4" width="25%"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img src="../../hisglobal/images/btn-sv.png"
				onClick="save();" style="cursor: pointer;">
			<img src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" style="cursor: pointer;">
			<img src="../../hisglobal/images/back_tab.png"
				onClick="cancelWindow();" style="cursor: pointer;">
				</td>
		</tr>
	</table>
				
<input type="hidden" name="comboValue" value="${sampleRegisterTransBean.strStoreName}"/>
<input type="hidden" name="strStoreId" value="${sampleRegisterTransBean.strStoreId}"/>
<input type="hidden" name="strStoreTypeId" value="${sampleRegisterTransBean.strStoreTypeId}"/>
<input type="hidden" name="strStoreName" value="${sampleRegisterTransBean.strStoreName}"/>
<input type="hidden" name="strGroupName" value="${sampleRegisterTransBean.strGroupName}"/>
<input type="hidden" name="strSubGroupName" value="${sampleRegisterTransBean.strSubGroupName}"/>
<input type="hidden" name="strChk" value="${sampleRegisterTransBean.strChk}"/>
<input type="hidden" name="chk" value="${sampleRegisterTransBean.strChk}"/>
<input type="hidden" name="strPath" value="${sampleRegisterTransBean.strPath}"/>
<input type="hidden" name="strRecQtyVals" value="${sampleRegisterTransBean.strRecQtyVals}"/>
<input type="hidden" name="strUnitBaseVals" value="${sampleRegisterTransBean.strUnitBaseVals}"/>
<input type="hidden" name="strConsumableFlag" value="${sampleRegisterTransBean.strConsumableFlag}"/>
<input type="hidden" name="strItemCategory" value="${sampleRegisterTransBean.strItemCategory}"/>



		
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="memberDtl" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="memberDtlInner" style="display:block;"></div>
</td>
</tr>
</table>
</div>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>








