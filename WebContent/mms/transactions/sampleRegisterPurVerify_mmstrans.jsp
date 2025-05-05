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
<title>Sample Register Verify</title>

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
	var url="SampleRegisterPurTransCNT.cnt?hmode="+mode+"&committeType="+document.forms[0].strCommitteeType.value+"&itemCategNo="+document.forms[0].strItemCategory.value;
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
	  var hisValidator = new HISValidator("sampleRegisterPurTransBean");
	  var retVal=true;
 	 hisValidator.addValidation("strCommitteeType","dontselect=0","Please Select Committee Type" );
 	 hisValidator.addValidation("strRemarks","req","Final Remarks is mandatory Field" );
	 hisValidator.addValidation("strRemarks", "maxlen=100", "Final Remarks should have less than or equal to 100 Characters" );

     var retVal = hisValidator.validate(); 
     hisValidator.clearAllValidations();
    	 if(retVal)
    	 {
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
<html:form name="sampleRegisterPurTransBean" action="/transactions/SampleRegisterPurTransCNT"
	type="mms.transactions.controller.fb.SampleRegisterPurTransFB" enctype="multipart/form-data" method="post">


<div class="errMsg" id="errMsg"><bean:write name="sampleRegisterPurTransBean" property="strErr"/></div>
<div class="warningMsg"><bean:write name="sampleRegisterPurTransBean" property="strWarning"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="sampleRegisterPurTransBean" property="strMsg"/></div>

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
			<bean:write name="sampleRegisterPurTransBean" property="strStoreName" filter="false"/>
			</td>
			
		</tr>
			<tr>
			<td  width="25%" class="LABEL">Item Category</td>
			<td  width="25%" class="CONTROL">
				<bean:write name="sampleRegisterPurTransBean" property="strItemCategDtl" filter="false"/>
			</td>
			<td  class="LABEL" width="25%">
					Supplier Name
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterPurTransBean" property="strSupplierName" filter="false"/>
								
					</td>
		</tr>
		
		
			<tr>
				<td  width="25%" class="LABEL">Item/Drug Name</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterPurTransBean" property="strItemName" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Brand Name
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterPurTransBean" property="strItemBrandName" filter="false"/>
								
					</td>
		</tr>
		
		<tr>
				<td  width="25%" class="LABEL">Batch/Sl.No</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterPurTransBean" property="strBatchSlno" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Received Qty
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterPurTransBean" property="strRecQty" filter="false"/>
								
					</td>
		</tr>
		<tr>
				<td  width="25%" class="LABEL">Tender No.</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterPurTransBean" property="strTenderNo" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Quotation No.
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterPurTransBean" property="strQuotationNo" filter="false"/>
								
					</td>
		</tr>
		
		</table>
		
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
				<bean:write name="sampleRegisterPurTransBean" property="strCommitteeValues" filter="false"/>
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
			<td class="CONTROL" colspan="4"><html:radio name="sampleRegisterPurTransBean" property="strApprovalStatus" value="1" >Accepted</html:radio>
			<html:radio name="sampleRegisterPurTransBean" property="strApprovalStatus" value="2" >Rejected</html:radio>
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
				
<input type="hidden" name="comboValue" value="${sampleRegisterPurTransBean.strStoreName}"/>
<input type="hidden" name="strStoreId" value="${sampleRegisterPurTransBean.strStoreId}"/>
<input type="hidden" name="strStoreTypeId" value="${sampleRegisterPurTransBean.strStoreTypeId}"/>
<input type="hidden" name="strStoreName" value="${sampleRegisterPurTransBean.strStoreName}"/>
<input type="hidden" name="strGroupName" value="${sampleRegisterPurTransBean.strGroupName}"/>
<input type="hidden" name="strSubGroupName" value="${sampleRegisterPurTransBean.strSubGroupName}"/>
<input type="hidden" name="strChk" value="${sampleRegisterPurTransBean.strChk}"/>
<input type="hidden" name="chk" value="${sampleRegisterPurTransBean.strChk}"/>
<input type="hidden" name="strPath" value="${sampleRegisterPurTransBean.strPath}"/>

<input type="hidden" name="strItemCategory" value="${sampleRegisterPurTransBean.strItemCategory}"/>



		
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








