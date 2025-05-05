<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<title>Issue To Patient Process</title>
<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossier_trans.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossierItems_util1.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossierDetails_util.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossierissueDetails_util.js"></script>
<script type="text/javascript">
function controlToIssueToPatientPage()
{	    
	//cancelIssue();
	//alert(document.getElementsByName("3")[0].value);
		document.forms[0].hmode.value="INITVAl";
		document.forms[0].submit();
}

function getDossierItemDtls()
{
	//alert('11');
	var url = "DossierRequisitionCNT.cnt?hmode=GETDOSSIERITEMDTLSOPD&dossiercode="
		+ document.forms[0].strDossiercat.value+"&storeId="+document.forms[0].strToStoreName.value;
		ajaxFunction(url,"15");

}

function getServicesDtls()
{

	var url = "DossierRequisitionCNT.cnt?hmode=GETSERVICEDTLS&deptcode="
		+ document.forms[0].strDepartment.value+"&ServiceId="+document.forms[0].strSericeType.value;
		ajaxFunction(url,"116");
}


function getDossierName()
{

	var url = "DossierRequisitionCNT.cnt?hmode=GETDOSSIERNAME&deptcode="
		+document.forms[0].strDepartment.value+"&ServiceId="+document.forms[0].strService.value;
		ajaxFunction(url,"117");
}


	function getAjaxResponse(res, mode) {

		//alert(res);
		//alert(mode);
	if (mode == "15") {
		
			document.getElementById("dossierId").innerHTML = res;
		} 
	//alert(mode);
	if (mode == "116") {
		
		//alert(res);
		var objVal = document.getElementById("serviceCmb");
		var toStoreobjVal = document.getElementById("strToStoreDiv");
		objVal.innerHTML = "<select name ='strService' class='comboNormal' onchange='getDossierName()' >"
				+ res.split('###')[0] + "</select>";

	/* 	toStoreobjVal.innerHTML = "<select name ='strToStoreName' class='comboNormal' onchange='' >"
			+ res.split('###')[1] + "</select>"; */
		
	
	
	}	
if (mode == "117") {
		
		//alert(res);
		var objVal = document.getElementById("DossierId");
		objVal.innerHTML = "<select name ='strDossiercat' class='comboNormal' >"
				+ res + "</select>";
	
	
	}
}
function getLfDetails()
{
	document.getElementById('lfDiv').style.display='block';
}

function closeLfDetails()
{
	document.getElementById('lfDiv').style.display='none';
}
function shwoDiv1()
	{
		//alert('1');
		var chkvalue=document.forms[0].strCIMSIntegration.value;
		//alert(chkvalue);
		if(chkvalue == '1')
			{
			//alert('in');
			 document.getElementById('cimsId1').style.display = '';
			 document.getElementById('cimsId2').style.display = 'none';
			}else
				{
				//alert('else');
				document.getElementById('cimsId1').style.display ='none';
				document.getElementById('cimsId2').style.display ='';
			}
		
	}
</script>

<script type="text/javascript">

function setItemBatchRate(e , id)
{
	//alert(document.getElementById('strItemBatchRate-'+id).value);

	var temp= document.getElementById('strItemBatchRate-'+id).value

	document.getElementById("strAcctualAvailDiv1-"+id).innerHTML= temp.split("^")[2] ;  //	document.getElementsByName("strItemBatchRate")[id].value ;
	document.getElementById("strDefaultRateDiv1-"+id).innerHTML= temp.split("^")[1] ;  
	
	document.getElementById("strAvalqty1-"+id).value= temp.split("^")[2] ;  
	document.getElementById("strRate1-"+id).value= temp.split("^")[1] ;  
	
}

</script>

<script type="text/javascript">
	function setRowIndex()
	{
		//alert(document.forms[0].strRowCount.value);
		document.getElementsByName("rowIndex1")[0].value="0";
		document.getElementsByName("rowLength1")[0].value="0";
		//document.forms[0].rowIndex1.value=document.forms[0].strRowCount.value;
		//document.forms[0].rowLength1.value=document.forms[0].strRowCount.value;
	}
	
function validateIssue1()
{
	var retVal = false;
	var hisValidator = new HISValidator("DossierRequisitionBean");
	hisValidator.addValidation("strDepartment", "dontselect=0",	 "Please Select Department Name");
	hisValidator.addValidation("strService", "dontselect=0",	 "Please Select Service Name");
	hisValidator.addValidation("strDossiercat", "dontselect=0",	 "Please Select Dossier Name");
	hisValidator.addValidation("strToStoreName", "dontselect=0",	 "Please Select Store Name");
	hisValidator.addValidation("strRemarks", "maxlen=100","Remarks should have less than or equal to 100 Characters");
	hisValidator.addValidation("strRemarks", "req",	 "Please Enter Remarks");


	 
	    
	
	var len=document.getElementsByName("strQtyText2").length;
	var totqty=0.00;
	for(var j = 1 ;j <=len ; j++ )
		{
			if(document.getElementById("strQtyText1-"+j).value == '')
				{
					alert('Please Enter Quantity');
					return false;
				}else{
					totqty=totqty+parseFloat(document.getElementById("strQtyText1-"+j).value);
					}	
		}


	var len1=document.getElementsByName("strQtyText1").length;
	var totqty1=0.00;
	//alert(len1);
	for(var k = 1 ;k <=len1-1 ; k++ )
		{
			if(document.getElementById("strQtyText11-"+k).value == '')
				{
					alert('Please Enter Quantity');
					return false;
				}else{
					totqty1=totqty1+parseFloat(document.getElementById("strQtyText11-"+k).value);
					}	
		}
	//alert((totqty1+totqty1));
	if((totqty+totqty1) <= 0)
		{
		alert('Please Select One Item Quantity Is greater Than Zero');
		return false;	
		}
	retVal = hisValidator.validate();
	hisValidator.clearAllValidations()
	if(retVal){
	var conf = confirm("Are you Sure, Want to Save!!!!");

	//alert(document.getElementsByName("IsBroughtByPatient1")[0].value);
	if(conf)
		{	
			document.forms[0].hmode.value="INSERTOPD";
			document.forms[0].submit();
		}else
			{
				return false;
			}
	}else{
		return false;
		}
	
}
</script>
</head>
<body onload="onCheckCategory(),chkVisitDtl(),getReport()">  <!-- return OnLoadFunction(), commented by ashutosh pandey function not on use -->


<html:form action="/transaction/DossierRequisitionCNT.cnt"  name="DossierRequisitionBean" type="dossier.transaction.controller.fb.DossierRequisitionFB" method="post" >

	<div id="errMsg" class="errMsg"><bean:write name="DossierRequisitionBean"
		property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="DossierRequisitionBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="DossierRequisitionBean" property="strNormalMsg" /></div>


	<logic:equal value="0" name="DossierRequisitionBean" property="strMode">

		<tag:tab tabLabel="Issue To Patient" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Patient&gt;&gt;</td>
			</tr>
		</table>

	</logic:equal>

	<logic:equal value="1" name="DossierRequisitionBean" property="strMode">
		<tag:tab tabLabel="Issue To Staff" selectedTab="FIRST" align="center"
			width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Staff&gt;&gt;</td>
			</tr>
		</table>
	</logic:equal>


	<logic:equal value="2" name="DossierRequisitionBean" property="strMode">
		<tag:tab tabLabel="Issue To Patient/Staff" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
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

			<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideBalQtyDetails('balQtyDtlId');"></th>
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

<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1" width='400'>
		<tr class="HEADER">
			<td colspan='4'>Dossier Details</td>

			
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr style="display: none;">
			<td width="25%" colspan="1" class="LABEL">Store Name</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="DossierRequisitionBean" property="storeName" filter="false" /></td>

			<td width="25%" colspan="1" class="LABEL">Item Category</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="DossierRequisitionBean" property="itemCatName" filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">CR No.</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write name="DossierRequisitionBean"
				property="crNo" filter="false" /></td>
				
			<td width="25%" colspan="1" class="LABEL"></td>
			<td width="25%" colspan="1" class="CONTROL"><a href="#" onclick='getLfDetails();'><bean:write name="DossierRequisitionBean"
				property="strLFAccountNo" filter="false" /></a></td>
		</tr>
	</table>
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
				name="DossierRequisitionBean" property="strLFAccountOpenDate" filter="false" /></td>

			<td width="25%" colspan="1" class="LABEL">Current Balance</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="DossierRequisitionBean" property="strLFBalanceAmount" filter="false" /></td>
		</tr>
		
		<tr>

			<td width="25%" colspan="1" class="LABEL">LF Account Status</td>
			<td width="25%" colspan="3" class="CONTROL"><bean:write
				name="DossierRequisitionBean" property="strLFAccountStatus" filter="false" /></td>
		</tr>
		
	
	</table></div>
 
<div id="allDivId" style="display: block;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus1"
				style="display: none cursor: pointer" onClick="getPatDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus1"
				style="display: block;; cursor: pointer" onClick="getPatDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Demographic Detail</b></td>
		</tr>
	</table>

	<div id="patientDetailsDivId" style="display: block;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="DossierRequisitionBean" property="strPatientDetails"
				filter="false" />
		</tr>
	</table>
	</div>
	
	<div id="diagDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus4"
				style="display: none; cursor: pointer" onClick="getPatDiagDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus4"
				style="display: block; cursor: pointer" onClick="getPatDiagDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Diagnosis Detail</b></td>
		</tr>
	</table>
</div>
	<div id="patientDiagDetailsDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="DossierRequisitionBean" property="strPatientDiagDetails"
				filter="false" />
		</tr>
	</table>
	</div>

<div style='display: none;'>
 <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus3"
				style="display: block; cursor: pointer" onClick="getPatTrtDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus3"
				style="display: none; cursor: pointer" onClick="getPatTrtDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Treatment Detail</b></td>
		</tr>
	</table>
	<div id="patientTreatmentDetailsDivId" style="">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="DossierRequisitionBean" property="strPatientTreatmentDtl"
				filter="false" />
		</tr>
	</table>
	</div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center">
			<img src="../../hisglobal/images/plus.gif" id="plus2" 
			style="display: block; cursor: pointer;"
				onClick="disPreviousIssueDtl(),getPrevIssueDtl();"> 
			<img src="../../hisglobal/images/minus.gif" id="minus2" 
			style="display: none; cursor: pointer;"
				onClick="disPreviousIssueDtl1();"></td>
			<td colspan="3" class="TITLE"><b>Previous Issue Details</b></td>
		</tr>
	</table>

	<div id="issueDtlDivId"></div></div>



		<div id="reqDtlDivId" style="display: block;">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">

			<tr>
				<td class="TITLE" colspan="4">Request Details</td>
			</tr>

			<%-- <tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Department</td>
				<td class="CONTROL" width="25%"><select id='dep' name="strDeptCode"
					class="comboNormal" onchange="getUnitCombo();">
					<bean:write name="DossierRequisitionBean" property="strDeptValues"
						filter="false" />
				</select></td>
				<td width="25%" class="LABEL"><font color="red">*</font>Unit</td>
				<td width="25%" class="CONTROL">
				<div id="unitDivId"><select id='unit' name="strUnitCode"
					class="comboNormal" onchange="getConsultantCombo();">
					<option value="0">Select Value</option>
					<bean:write name="DossierRequisitionBean" property="strUnitValues"
						filter="false" />
				</select></div>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Prescribed
				By</td>
				<td width="25%" class="CONTROL">
				<div id="consultantDivId"><select name="strPrescribedBy"
					class="comboNormal">
					<option value="0">Select Value</option>
				</select></div>
				</td>
				<td width="25%" class="LABEL">Prescribed
				For</td>
				<td width="25%" class="CONTROL"><input type="text"
					class="txtFldMin" name="strPrescribedFor" maxlength="3"
					onkeypress="return validateData(event,5);">Days</td>

			</tr> --%>
			<tr style="display: none;">
				<td width="25%" class="LABEL">Prescription
				Date</td>
				<td width="25%" class="CONTROL"><date:date name="strPrescriptionDate"
					value="${DossierRequisitionBean.strCtDate}"></date:date></td>

				<td width="25%" colspan="1" class="LABEL">Prescription
				From</td>
				<td width="25%" colspan="1" class="CONTROL"><select
					name="strPrescriptionFrom" class="comboNormal">
						<option title="Opd Special" value="4" class="important">Opd Special</option>
	<option title="Opd Morning"  value="1" class="noneimportant">Opd Morning</option>
	<option title="Ipd" value="2" class="noneimportant">Ipd</option>
	<option title="Emergency" value="3" selected="" class="noneimportant">Emergency</option>
				</select></td>
			</tr>
			
			<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Issuing Store</td>
				<td class="CONTROL" width="25%"><select id='strToStoreDiv' name="strToStoreName"
					class="comboNormal" onchange="">
					<option value="0">Select Store</option>
					<bean:write name="DossierRequisitionBean" property="strToStoreNameValues"
						filter="false" />
				</select></td>
				<td class="LABEL" width="25%"></td>
				<td class="CONTROL" width="25%"></td>
			</tr>
			
			<logic:equal value="11" name="DossierRequisitionBean" property="strSericeType">
			<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Raising From</td>
			<td class="CONTROL" width="25%">
			<select id='dep1' name="strDepartment"
					class="comboNormal" onchange="getServicesDtls()" >
					<bean:write name="DossierRequisitionBean" property="strDepartmentValues"
						filter="false" />
				</select>
			
				</td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Service</td>
				<td class="CONTROL" width="25%"><select id='serviceCmb' name="strService"
					class="comboNormal" onchange="getDossierName()">
					<option value="0">Select Value</option>
					<bean:write name="DossierRequisitionBean" property="strServiceValues"
						filter="false" />
				</select></td>
				
				</tr>
			</logic:equal>
			
			<logic:equal value="12" name="DossierRequisitionBean" property="strSericeType">
			<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Labs</td>
			<td class="CONTROL" width="25%">
			<select id='dep1' name="strDepartment"
					class="comboNormal" onchange="getServicesDtls()" >
					<bean:write name="DossierRequisitionBean" property="strDepartmentValues"
						filter="false" />
				</select>
			
				</td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Test</td>
				<td class="CONTROL" width="25%"><select id='serviceCmb' name="strService"
					class="comboNormal" onchange="getDossierName()">
					<option value="0">Select Value</option>
					<bean:write name="DossierRequisitionBean" property="strServiceValues"
						filter="false" />
				</select></td>
				
				</tr>
			</logic:equal>
			
			
			<logic:equal value="13" name="DossierRequisitionBean" property="strSericeType">
			<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Service</td>
			<td class="CONTROL" width="25%">
			<select id='dep1' name="strDepartment"
					class="comboNormal" onchange="getServicesDtls()" >
					<bean:write name="DossierRequisitionBean" property="strDepartmentValues"
						filter="false" />
				</select>
			
				</td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Procedure</td>
				<td class="CONTROL" width="25%"><select id='serviceCmb' name="strService"
					class="comboNormal" onchange="getDossierName()">
					<option value="0">Select Value</option>
					<bean:write name="DossierRequisitionBean" property="strServiceValues"
						filter="false" />
				</select></td>
				
				</tr>
			</logic:equal>
			
			<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Dossier Name</td>
			<td class="CONTROL" width="25%">
			<select id='DossierId' name="strDossiercat"
					class="comboNormal" onchange="getDossierItemDtls()" >
					<option value="0">Select Value</option>
					<bean:write name="DossierRequisitionBean" property="strDossiercatValues"
						filter="false" />
				</select>
			
				</td>
			
		<td class="LABEL" width="25%"></td>
				<td class="CONTROL" width="25%"></td>
				
				</tr>
			

		</table>
		
		
		<%-- <bean:write name="DossierRequisitionBean" property="strOnlineTreatment"
				filter="false" /> --%>
		
		
		
		</div>
		<div id="dossierId">
		</div>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px" style="">
<tr>
			<td class="LABEL" width="25%" ></td>
			<td class="LABEL" width="25%">Add Additional Items</td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Item Category</td>
				<td class="CONTROL" width="25%"><select id='dep' name="stritemcat"
					class="comboNormal" onchange="">
					<bean:write name="DossierRequisitionBean" property="strItemCatValues"
						filter="false" />
				</select></td>
				
				</tr>

</table>
		<div id="itemDtlOffDivId" style="display: block">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px"  style="">
			<tr>
				<td class='TITLE' colspan='5'><div align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
					onclick='getItemSelectPopup1();' name="searchName"
					title="Click here to Search Item"></div></td>
			</tr>
			<tr>
				<td colspan="5" bgcolor="black"></td>
			</tr>
			
		</table>

		<%-- <logic:equal value="0" name="DossierRequisitionBean" property="strCIMSIntegration"> --%>
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px"  style="display: none;">

			<tr>
				<td class="multiLabel" width="23%">Item Name</td>
				<td class="multiLabel" width="8%">Item Type</td>
				<td class="multiLabel" width="8%">Category</td>
				<td class="multiLabel" width="8%">Is Brought By Patient</td>
				<td class="multiLabel" width="8%">Batch</td>
				<td class="multiLabel" width="8%">Avl Qty</td>
				<td class="multiLabel" width="8%">Rate/Unit</td>
				
		     	<!-- <td class="multiLabel" width="8%"><font color="red">*</font>Cost/Unit</td> -->
				<td class="multiLabel" width="8%"><font color="red">*</font>Quantity</td>
				<td class="multiLabel" width="7%"><font color="red">*</font>Cost</td>
				<td class="multiLabel" width="1%">-</td>
			</tr>
		</table>
	<%-- 	</logic:equal> --%>

		<!-- <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr>
				<td class="multiLabel" width="23%">Item Name</td>
				<td width="33%" class="multiLabel">CIMS Action</td>     Added by warish 22-12-17
				<td width=33%" class="multiLabel" id="cimsId1">CIMS Action</td>
				<td width=33%" class="multiLabel" id="cimsId2"></td>
				<td class="multiLabel" width="8%">Batch No</td>
				<td class="multiLabel" width="8%">Avl Qty</td>
					<td class="multiLabel" width="8%"><font color="red">*</font>Cost/Unit</td>
				<td class="multiLabel" width="8%"><font color="red">*</font>Quantity</td>
				<td class="multiLabel" width="8%"><font color="red">*</font>Cost</td>
				<td class="multiLabel" width="4%">-</td>
			</tr>
		</table> -->

		<div id="id1"></div>
		
          <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px"  style="">

			<tr style="">
				<td class="LABEL" colspan="" width="85%"><font color="red"><b>Total Cost</b></font></td>
				<td  class="LABEL" colspan=""><font color="red"><div id="strNetCost" align="left"></div></font></td>
				<input type="hidden" name="strNetCost1" id="strNetCost1" value="0.00" />
			</tr>
		</table>
		
		 <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px"  style="">

			<tr style="">
				<td class="LABEL" " width="85%" colspan=""><font color="red"><b>Total Amount</b></font></td>
				<td  class="LABEL" colspan=""><font color="red"><div align="left" id="strTotalAmtDiv"></div></font></td>
				
			</tr>
		</table>
		
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="1px">
			<tr>
				<td colspan="5" bgcolor="black"></td>
			</tr>
			<tr class="FOOTER">
				<td colspan="5"></td>
			</tr>
		</table>
		</div>


	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr style="display: none;">
			<td colspan="2" class="LABEL"><font color="red">*</font>Receive	By</td>
			
			<td colspan="2" class="CONTROL"><input type="text"
				class="txtFldMax" name="strReceiveBy" onkeypress="return validateData(event,11);">

				</td>
		</tr>

		<tr>
			<td class="LABEL" align="center" colspan="2"><font color='red'>*</font>Delivery Location/Remarks</td>
			<td class="CONTROL"  align="center" colspan="2"><textarea name="strRemarks"	cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
		</tr>
	</table>
</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center">
			<!--<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-sv.png"
				onclick="return validateIssue();" /> <img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/back_tab.png" onClick="controlToIssueToPatientPage();">-->
				<br>
				<a href="#" class="button" id="" onclick=' return validateIssue1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="clearIssue();"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="controlToIssueToPatientPage();"><span class="cancel">Cancel</span></a>
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strUpdateFlag" value="" />
	
	<input type="hidden" name="storeName" value="${DossierRequisitionBean.storeName}" />
	<input type="hidden" name="itemCatName"
		value="${DossierRequisitionBean.itemCatName}" />
		<input type="hidden" name="strCrNo"
		value="${DossierRequisitionBean.strCrNo}" />
	<input type="hidden" name="crNo" value="${DossierRequisitionBean.crNo}" />
	<input type="hidden" name="strId" value="${DossierRequisitionBean.strId}" />
	<input type="hidden" name="itemCategory"
		value="${DossierRequisitionBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode"
		value="${DossierRequisitionBean.strConfCatCode}" />
	<input type="hidden" name="strIssueNo" value="${DossierRequisitionBean.strIssueNo}" />
	<input type="hidden" name="strIssueDtl"
		value="${DossierRequisitionBean.strIssueDtl}" />
	<input type="hidden" name="disFlag" value="${DossierRequisitionBean.disFlag}" />
	<input type="hidden" name="mode" value="${DossierRequisitionBean.strMode}" />
	<input type="hidden" name="strMode" value="${DossierRequisitionBean.strMode}">
	<input type="hidden" name="strIssueMode"
		value="${DossierRequisitionBean.strIssueMode}">
	<input type="hidden" name="strCtDate" value="${DossierRequisitionBean.strCtDate}" />
	<input type="hidden" name="strVisitDtl" value="${DossierRequisitionBean.strVisitDtl}" />
	<input type="hidden" name="strIssueNum" value="${DossierRequisitionBean.strIssueNum}" />
	<input type="hidden" name="isUpdateOpdDrugReq" value="" />
	<input type="hidden" name="strGlobalval" value="" />
	<input type="hidden" name="strErrMsg" value="${DossierRequisitionBean.strErrMsg}" />
	<input type="hidden" name="strTariff_Flag" value="1" />
	<input type="hidden" name="strcallfromipd" value="5" />
	<%-- <input 	type="hidden" name="strCIMSIntegration" value="${DossierRequisitionBean.strCIMSIntegration}"> --%>
	<input type="hidden" name="strRowCount" value="0" />
	<input type="hidden" name="strSericeType" value="${DossierRequisitionBean.strSericeType}" />
	<input type="hidden" name="strPatientType" value="2" />
	<input type="hidden" name="strBillingHiddenValue" value="${DossierRequisitionBean.strBillingHiddenValue}" />
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
<div class="popUpDiv" id="popUpDiv1" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
						
				<div id="issueDtlsDivId" style="display: block;"></div>
		
			</td>
		</tr>
	</table>
	</div>
	

</html:form>
<jsp:include page="dossier_trans_search_row_opd.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>