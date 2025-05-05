<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<html>
<head>
<meta charset="utf-8">
<title>Supplier Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">


<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../mms/js/searchItems_util.js"></script>
<script language="Javascript" src="../../mms/js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script type="text/javascript">

function showEscLevel()
	{
	    var obj	=	document.getElementById("strEsclationMtxAvl");
	   	if(obj.checked) 
	   	{					
			document.getElementById("IsEscMatixAvl").style.display="block";
		}
		else
		{
		    document.getElementById("IsEscMatixAvl").style.display="none";
		}
		
	}
	function showLevelOne()
	{
	    var levelTwo		=	document.getElementById("strLevelTwoEsc");
	    var obj		        =	document.getElementById("strLevelOneEsc");
		 
	   	if(obj.checked==1) 
	   	{			
	   	      		
	   	      		//document.forms[0].strLevelOneOpen.value="1";
	   	      		//document.forms[0].strLevelTwoOpen.value="0";
			document.getElementById("LevelOne").style.display="block";
			levelTwo.value='0';
		}
		else
		{
		    if(levelTwo.checked==1)
			{
			  levelTwo.checked=false;
			  levelTwo.value='0';
			  document.getElementById("LevelTwo").style.display="none";
			} 
		    document.getElementById("LevelOne").style.display="none";
		}
	
	}
	
	function showLevelTwo()
	{
	   var levelOne		=	document.getElementById("strLevelOneEsc");
	   var obj		    =	document.getElementById("strLevelTwoEsc");
		if(levelOne.checked==1)
		{		    
		   	if(obj.checked==1) 
		   	{					
				document.getElementById("LevelTwo").style.display="block";
				obj.value='1';
			}
			else
			{
			    document.getElementById("LevelTwo").style.display="none";
			    obj.value='0';
			}
		}
		else
		{
		 alert("Please Fill Level One Details First!!!");
		 obj.checked=false;
		 obj.value='0';
		 document.getElementById("LevelOne").style.display="block";
		 levelOne.checked=true;
		}
	}

	function bringStateCombo()
	{
	
	   if(document.forms[0].strCountryCode[document.forms[0].strCountryCode.selectedIndex].value=='101')
	   {
	     document.getElementById("stateMandtry").innerHTML = "<font color='red'>*</font>State";
	     document.forms[0].strForeignerSuppFlag.value="0";
	   }
	   else
	   {
	     document.getElementById("stateMandtry").innerHTML = "State";
	     document.forms[0].strForeignerSuppFlag.value="1";
	   }   
	 	 	var mode = "STATE";   
			var url="SupplierMstCNT.cnt?hmode="+mode+"&strCountryCode="+document.forms[0].strCountryCode[document.forms[0].strCountryCode.selectedIndex].value+"&strStateCode=${requestScope.stateCode}";
		 	ajaxFunction(url,"1");
	 	 
	}
	
	function getAjaxResponse(res,mode)
	{
	 var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
	     	 var err = document.getElementById("errMsg");
	         err.innerHTML = temp1[1];
	         return false;	
       }
       if(mode == 1)
       {
	    	
	    	document.getElementById("stateID").innerHTML =  "<select name='strStateCode' class='comboMax'>"+res+"</select>";
	    	 
	   }
    }

	function view1()
	{
		document.getElementById("addressPlusId").style.display="none";
		document.getElementById("addressMinusId").style.display="block";
		document.getElementById("addressDtlId").style.display="block";
	}
	function view2()
	{
		document.getElementById("addressPlusId").style.display="block";
		document.getElementById("addressMinusId").style.display="none";
		document.getElementById("addressDtlId").style.display="none";
	}
	function bringSupplierBlackListedView()
	{
		if(document.forms[0].strSupplierStatus.value=='2' ) 
		{
			document.getElementById("IsSupplierBlackListedId").style.display="block";
			
		}
	else if(document.forms[0].strSupplierStatus.value=='1' && document.forms[0].strIsBlackListMod.value=='1')  
		{
			document.getElementById("IsSupplierBlackListedId").style.display="block";
			
		}
	else{
			document.getElementById("IsSupplierBlackListedId").style.display="none"; 
		}
		
	}
	function blackList()
	{
	
	 document.forms[0].strSupplierStatus.value=document.forms[0].strSupplierStatusCode.value; 
	if(document.forms[0].strSupplierStatus.value=='2') 
	{
		document.getElementById("IsSupplierBlackListedId").style.display="block";
	}
	
	if(document.forms[0].IsSupplier.value=='1')
	{
		document.forms[0].strIsSupplier.checked=true;
	}
	if(document.forms[0].IsManufacturer.value=='1')
	{
		document.forms[0].strIsManufacturer.checked=true;
	}
	if(document.forms[0].IsAgent.value=='1')
	{
		document.forms[0].strIsAgent.checked=true;
	}
	if(document.forms[0].IsBuyer.value=='1')
	{
		document.forms[0].strIsBuyer.checked=true;
	}
	if(document.forms[0].IsLocalPurchaseSupp.value=='1')
	{
		document.forms[0].strLocalPurchaseSuppFlag.checked=true;
	}
	if(document.forms[0].IsForeignSupplier.value=='1')
	{
		document.forms[0].strForeignerSuppFlag.checked=true;
	}
	if(document.forms[0].strIsBlackListMod.value=='0')  
	{
			document.forms[0].strActionDate.value=document.forms[0].strCurrentDate.value;
	}
	if(document.forms[0].strSupplierProvMaintenanceModf.value=='1')
	{
		document.forms[0].strSupplierProvMaintenance.checked=true;
	}
	
	
	if(document.forms[0].strEsclationMtxAvlModf.value=='1')
	{
		document.forms[0].strEsclationMtxAvl.checked=true;
		document.forms[0].strLevelOneEsc.checked=true;
		document.getElementById("IsEscMatixAvl").style.display="block";
		
		
	}
	if(document.forms[0].strLevelOneOpen.value=='1')
	{
		document.forms[0].strLevelOneEsc.checked=true;
		document.getElementById("LevelOne").style.display="block";
		
	}
	if(document.forms[0].strLevelTwoOpen.value=='1')
	{
		document.forms[0].strLevelTwoEsc.checked=true;
		document.getElementById("LevelTwo").style.display="block";
		
	}
	        
		
	}
	function validateInsert()
	{
		 if(checkSupplierType()==false) {
           		alert("Atleast one check box for the supplier type must be selected.\n" +
           				"Supplier Types are : Supplier,Manufacturer,Agent and Buyer");
           		return;
           }
		var hisValidator = new HISValidator("supplierBean");
			
            hisValidator.addValidation("strSupplierName", "req", "Supplier Name is a Mandatory Field" );
        //    hisValidator.addValidation("strSupplierGrade", "dontselect=0","Please Select Supplier Grade");
            //hisValidator.addValidation("strContactPerson", "req", "Contact Person Name is a Mandatory Field" );
            var retVal = hisValidator.validate();
            hisValidator.clearAllValidations();
            if(retVal)
            {
            	hisValidator.addValidation("strAddress", "req", "Address is a Mandatory Field" );
            	hisValidator.addValidation("strCity", "req", "City is a Mandatory Field" );
            	
            	hisValidator.addValidation("strCountryCode", "dontselect=0","Please Select Country Name");
            	if(document.forms[0].strCountryCode.value=='101') {
              		hisValidator.addValidation("strStateCode", "dontselect=0","Please Select State Name");
            	}
           		//hisValidator.addValidation("strPincode", "req", "Pin Code is a Mandatory Field" );
         	 	hisValidator.addValidation("strEmailId1", "req", "Primary Email Id is a Mandatory Field" );
         //  		hisValidator.addValidation("strPhoneNo2", "req", "Mobile No. is a Mandatory Field" );
          		//hisValidator.addValidation("strWebsite", "req", "Website is a Mandatory Field" );
               	retVal = hisValidator.validate(); 
               	hisValidator.clearAllValidations();
            	if(!retVal)
            	{
            		view1();
            	}
            	else
            	{
            		
           			if(document.forms[0].strSupplierStatus.value=='2') 
          	 		{
          	 			hisValidator.addValidation("strActionDate", "req", "Action Date is a Mandatory Field" );
          	 		    hisValidator.addValidation("strCommitee", "dontselect=0","Please Select Commitee Name");
          	 			
          	 		}
          	 		hisValidator.addValidation("strEffectiveFrom", "req", "Effective From Date is a Mandatory Field" );
          	 		// hisValidator.addValidation("strEffectiveFrom", "dtgtet=${supplierBean.strCurrentDate}" , "Effective from Date should be Greater than or Equal to Current Date");
          	 		retVal = hisValidator.validate();
          	 		hisValidator.clearAllValidations();
          	 	}
            }
            
            
            if(retVal) 
		    {
		        var levelTwo  =	document.getElementById("strLevelTwoEsc");
	            var levelOne  =	document.getElementById("strLevelOneEsc");
		        if(levelOne.checked==1)
		        {
		           
		           if(document.forms[0].strCotactPersonForEsc[0].value=="")
		           {
		             alert("Please Enter Name for Level One!!!");
		             retVal = false;
		           }
		           if(document.forms[0].strCotactNoForEsc[0].value=="")
		           {
		             alert("Please Enter Contact No for Level One!!!");
		             retVal = false;
		           }
		        }
		        if(levelTwo.checked==1)
		        {
		           
		           if(document.forms[0].strCotactPersonForEsc[1].value=="")
		           {
		              alert("Please Enter Name for Level Two!!!");
		             retVal = false;
		           }
		           if(document.forms[0].strCotactNoForEsc[1].value=="")
		           {
		             alert("Please Enter Contact No for Level Two!!!");
		             retVal = false;
		           }
		           
		        }
		           
		   		
		    }
		   
		    if(retVal)
		    {
		    
		   		document.forms[0].hmode.value="UPDATE";
		   		 if(document.forms[0].strSupplierStatus.value=="1" && document.forms[0].strIsBlackListMod.value=='0'  )
				{
			
					document.forms[0].strActionDate.value=document.forms[0].strCurrentDate.value; 
					document.forms[0].strCommitee.value="0";
					document.forms[0].strBlackListedRemarks.value="";   
				
				}
		   		document.forms[0].submit();
		   }
	}
	
	function showContractDetails() {
	
		var supplierTypeElement = document.getElementById("strSupplierTypeId").value;
		//alert(supplierTypeElement);
		var contractDtlRow1 = document.getElementById("contractDtlRow1");
		var contractDtlRow2 = document.getElementById("contractDtlRow2");
		if(supplierTypeElement=="0") {
			//alert("Supp is 0.");
			contractDtlRow1.style.display="none";
			contractDtlRow2.style.display="none";
			
			document.getElementById("strContractNo").value="";
			document.getElementById("strContractDate").value="";
			document.getElementById("strExpiryDate").value="";
			

		} else {
			//alert("Supp is "+supplierType+".");
			contractDtlRow1.style.display="table-row";
			contractDtlRow2.style.display="table-row";
		}
		
	}
	
	function checkSupplierType() {
		var isSupplierTypeChecked   = false;
		var supplierCheckBox		=	document.getElementById("strIsSupplier");
		var manufacturerCheckBox	=	document.getElementById("strIsManufacturer");
		var agentCheckBox			=	document.getElementById("strIsAgent");
		var buyerCheckBox			=	document.getElementById("strIsBuyer");
		
		if(supplierCheckBox.checked==1) {
		
			isSupplierTypeChecked = true;
		
		} else if(manufacturerCheckBox.checked==1) {
		
			isSupplierTypeChecked = true;
		
		} else if(agentCheckBox.checked==1) {
		
			isSupplierTypeChecked = true;
		
		} else if(buyerCheckBox.checked==1) {
		
			isSupplierTypeChecked = true;
		
		}
		//alert(isSupplierTypeChecked);
		return isSupplierTypeChecked;
	}
</script>
</head>
<body onload="blackList();showContractDetails();bringStateCombo();">
<html:form action="/masters/SupplierMstCNT" name="supplierBean"
	type="mms.masters.controller.fb.SupplierMstFB">

	<center>
	<div class="errMsg"><bean:write name="supplierBean"
		property="strErrMssgstring" /></div>
	<div class="warningMsg"><bean:write name="supplierBean"
		property="strWarnMssgstring" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="supplierBean" property="strNormMssgstring" /></div>



	<tag:tab tabLabel="Supplier Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr class="HEADER">
			<td colspan="4" width="25%">Supplier Master&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Drug Category Name</td>
			<td class="CONTROL"><bean:write name="supplierBean"
				property="strItemCategoryName" /></td>
			<td width="25%" class="LABEL"><font color="red">*</font>Supplier
			Name</td>
			<td width="25%" class="CONTROL"><input type="text"
				name="strSupplierName" maxlength="200" class="txtFldMax"
				value="${supplierBean.strSupplierName}"
				onkeypress="return validateData(event,18);"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Supplier
			Grade</td>
			<td width="25%" class="CONTROL"><select name="strSupplierGrade"
				class="comboNormal">
				<bean:write name="supplierBean" property="strSupplierValuesModi"
					filter="false" />
			</select></td>
			<td width="25%" class="LABEL">Supplier Type</td>
			<td width="25%" class="CONTROL"><select name="strSupplierType"
				class="comboNormal" id="strSupplierTypeId"
				onchange="showContractDetails();">
				<bean:write name="supplierBean" property="strSupplierTypeVals"
					filter="false" />
			</select></td>
		</tr>
		<tr id="contractDtlRow1">
			<td width="25%" class="LABEL">Contract No:</td>
			<td width="25%" class="CONTROL"><html:text
				property="strContractNo" name="supplierBean" maxlength="50"
				styleClass="txtFldMax" styleId="strContractNo"></html:text></td>
			<td width="25%" class="LABEL">Contract Date</td>
			<td width="25%" class="CONTROL"><dateTag:date
				name="strContractDate" value="${supplierBean.strContractDate}"></dateTag:date></td>
		</tr>
		<tr id="contractDtlRow2">
			<td width="25%" class="LABEL">Expiry Date:</td>
			<td width="25%" class="CONTROL" colspan="3"><dateTag:date
				name="strExpiryDate" value="${supplierBean.strExpiryDate}"></dateTag:date></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Contact Person</td>
			<td width="25%" class="CONTROL" colspan="3"><input type="text"
				name="strContactPerson" maxlength="100" class="txtFldMax"
				value="${supplierBean.strContactPerson}" /></td>
		</tr>

	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="addressPlusId" align="left" style="display: block;"><img
				src="../../hisglobal/images/plus.gif" onClick="view1();"
				style="cursor: pointer;" /> Address Details</div>
			<div id="addressMinusId" style="display: none;" align="left"><img
				src="../../hisglobal/images/minus.gif" onClick="view2();"
				style="cursor: pointer;" /> Address Details</div>
			</td>
		</tr>
	</table>
	<div id="addressDtlId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Address
			</td>
			<td class="CONTROL" colspan="" width="25%"><textarea rows="2"
				cols="20" name="strAddress"><bean:write
				name="supplierBean" property="strAddress" filter="false" /></textarea></td>
			<td class="LABEL" colspan="1" width="25%"></td>
			<td class="LABEL" colspan="1" width="25%"></td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>City</td>
			<td class="CONTROL" width="25%"><input type="text"
				maxlength="100" class="txtFldMax" name="strCity"
				value="${supplierBean.strCity}"></td>
			<td class="LABEL" width="25%">Pin Code</td>
			<td class="CONTROL" width="25%"><input type="text" maxlength="6"
				class="txtFldNormal" name="strPincode"
				value="${supplierBean.strPincode}"></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Country
			</td>
			<td class="CONTROL" width="25%"><select name="strCountryCode"
				class="comboNormal" onchange="bringStateCombo();">
				<bean:write name="supplierBean" property="strCountryNameCombo"
					filter="false" />
			</select></td>
			<td class="LABEL" width="25%">
			<div id="stateMandtry">State</div>
			</td>
			<td class="CONTROL" width="25%">
			<div id="stateID"><select name="strStateCode"
				class="comboNormal">
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Phone No</td>
			<td class="CONTROL" width="25%"><input type="text"
				maxlength="20" class="txtFldMax" name="strPhoneNo1"
				value="${supplierBean.strPhoneNo1}"></td>
			<td width="25%" class="LABEL">Mobile No</td>
			<td class="CONTROL" width="25%"><input type="text"
				maxlength="20" class="txtFldMax" name="strPhoneNo2"
				value="${supplierBean.strPhoneNo2}"></td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color='red'>*</font>Email Id</td>
			<td class="CONTROL" width="25%"><input type="text"
				maxlength="150" class="txtFldMax" name="strEmailId1"
				value="${supplierBean.strEmailId1}"></td>
			<td class="LABEL" width="25%">Alternative Email Id</td>
			<td class="CONTROL" width="25%"><input type="text"
				maxlength="150" class="txtFldMax" name="strEmailId2"
				value="${supplierBean.strEmailId2}"></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Fax No.1</td>
			<td class="CONTROL" width="25%"><input type="text"
				maxlength="20" class="txtFldMax" name="strFaxNo1"
				value="${supplierBean.strFaxNo1}"></td>
			<td width="25%" class="LABEL">Fax No.2</td>
			<td class="CONTROL" width="25%"><input type="text"
				maxlength="20" class="txtFldMax" name="strFaxNo2"
				value="${supplierBean.strFaxNo2}"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Web site</td>
			<td class="CONTROL" colspan="" width="25%"><input type="text"
				maxlength="100" class="txtFldMax" name="strWebsite"
				value="${supplierBean.strWebsite}"
				onkeypress="return validateData(event,1);"></td>
			<td class="LABEL" colspan="1" width="25%">GSTN No.</td>
			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				maxlength="15" class="txtFldMax" name="strLstNo"
				value="${supplierBean.strLstNo}"
				onkeypress="return validateData(event,8);"></td>
		</tr>
		<tr style="display: none;">
			<td class="LABEL" colspan="1" width="25%">CST No.</td>
			<td class="CONTROL" colspan="" width="25%"><input type="text"
				maxlength="10" class="txtFldMax" name="strCstNo"
				value="${supplierBean.strCstNo}"
				onkeypress="return validateData(event,8);"></td>
			<td class="LABEL" colspan="1" width="25%">PAN No.</td>
			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				maxlength="10" class="txtFldMax" name="strPANNo"
				value="${supplierBean.strPANNo}"
				onkeypress="return validateData(event,8);"></td>
		</tr>
	</table>
	</div>
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="TITLE" colspan="4"><font color="red">*</font>
			Supplier Type</td>
		</TR>
		<TR>
			<TD class="LABEL" width="25%">Supplier</TD>
			<TD class="CONTROL" width="25%"><input type="checkbox"
				name="strIsSupplier" value="1" id="strIsSupplier" /></TD>
			<TD class="LABEL" width="25%">Manufacturer</TD>
			<TD class="CONTROL" width="25%"><input type="checkbox"
				name="strIsManufacturer" value="1" id="strIsManufacturer" /></TD>


		</TR>
		<TR>
			<TD class="LABEL" width="25%">Chemist</TD>
			<TD class="CONTROL" width="25%"><input type="checkbox"
				name="strIsAgent" value="1" id="strIsAgent" /></TD>
			<TD class="LABEL" width="25%">Buyer</TD>
			<TD class="CONTROL" width="25%"><input type="checkbox"
				name="strIsBuyer" value="1" id="strIsBuyer" /></TD>

		</TR>
		<TR>
			<td class="LABEL" width="25%"><font color="red">*</font>Supplier
			Status</td>
			<td class="CONTROL" width="25%" colspan="1"><select
				name="strSupplierStatus" onchange="bringSupplierBlackListedView();">
				<option value="1">Active</option>
				<option value="2">Black Listed</option>
			</select></td>
			<TD class="LABEL" width="25%">Turn Over(Last Financial Yr.)</TD>
			<TD class="CONTROL" colspan="1"><input type="text" 	maxlength="3" class="txtFldNormal" value="${supplierBean.strSuppTurnOver}" name="strSuppTurnOver"
				onkeypress="return validateData(event,7);" >&nbsp;
				<bean:write name="supplierBean" property="strSuppTurnOverUnitVal"
					filter="false" />
			</TD>
		</TR>
		<TR>
			<TD class="LABEL" colspan="2">Whether Supplier Provides Maintenance</TD>
			<TD class="CONTROL" colspan="2"><input type="checkbox"
				name="strSupplierProvMaintenance" value="1" id="strSupplierProvMaintenance" /></TD>

		</TR>
		<TR>
			<TD class="LABEL" colspan="2">Whether Escalation Matrix Available</TD>
			<TD class="CONTROL" colspan="2">
			<input type="checkbox"	name="strEsclationMtxAvl" value="1" id="strEsclationMtxAvl"  onClick="showEscLevel();"/>
			</TD>

		</TR>
       </table>

	

 <div id="IsEscMatixAvl" style="display:none">    
	       <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">
			<tr>
	
				<td class="TITLE" colspan="4"><input type="checkbox"
					name="strLevelOneEsc" value="1" id="strLevelOneEsc"  onClick="showLevelOne();" />Level 1
				</td>
	
			</tr>
		</table>
		<div id="LevelOne" style="display:none">
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">
			<tr>
					<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Name</td>
					<td class="CONTROL" colspan="" width="25%"><input type="text" name="strCotactPersonForEsc" value="${supplierBean.strCotactPersonForEscLevelOne}" maxlength="100" class="txtFldMax"
				        onkeypress="return validateData(event,4);" /></td>
					<td class="LABEL" width="25%">Designation</td>
					<td class="CONTROL" width="25%"><input type="text" name="strContactPersonDesgForEsc" value="${supplierBean.strContactPersonDesgForEscLevelOne}" maxlength="100" class="txtFldMax"	
					onkeypress="return validateData(event,18);"></td>

		   </tr>
		   <tr>
					<td class="LABEL" colspan="1" width="25%">E-MailId</td>
					<td class="CONTROL" colspan="" width="25%"><input type="text"
				maxlength="50" class="txtFldMax" name="strCotactEmailIdForEsc" value="${supplierBean.strCotactEmailIdForEscLevelOne}"
				onkeypress=" validateData(event,1);"></td>
					<td class="LABEL" width="25%"><font color="red">*</font>Phone No</td>
					<td class="CONTROL" width="25%"><input type="text"
				maxlength="20" class="txtFldMax" name="strCotactNoForEsc" value="${supplierBean.strCotactNoForEscLevelOne}"
				onkeypress="return validateData(event,2);"></td>

		   </tr>
		   <tr>
					<td class="LABEL" colspan="1" width="25%">Fax No</td>
					<td class="CONTROL" colspan="" width="25%"><input type="text"
				maxlength="20" class="txtFldMax" name="strCotactFaxForEsc"  value="${supplierBean.strCotactFaxForEscLevelOne}"
				onkeypress="return validateData(event,2);"></td>
					<td class="CONTROL" colspan="3"></td>

		   </tr>
		   
		   </table>
		 </div>
			
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">	
			<tr>
	
				<td class="TITLE" colspan="4"><input type="checkbox"
					name="strLevelTwoEsc" value="1" id="strLevelTwoEsc" onClick="showLevelTwo();" />Level 2
				</td>
	
			</tr>
		</table>
		<div id="LevelTwo" style="display:none">
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">
			<tr>
					<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Name</td>
					<td class="CONTROL" colspan="" width="25%"><input type="text" name="strCotactPersonForEsc" value="${supplierBean.strCotactPersonForEscLevelTwo}"  maxlength="100" class="txtFldMax"
				        onkeypress="return validateData(event,4);" /></td>
					<td class="LABEL" width="25%">Designation</td>
					<td class="CONTROL" width="25%"><input type="text" name="strContactPersonDesgForEsc" value="${supplierBean.strContactPersonDesgForEscLevelTwo}" maxlength="100" class="txtFldMax"	
					onkeypress="return validateData(event,18);"></td>

		   </tr>
		   <tr>
					<td class="LABEL" colspan="1" width="25%">E-MailId</td>
					<td class="CONTROL" colspan="" width="25%"><input type="text"
				maxlength="50" class="txtFldMax" name="strCotactEmailIdForEsc"  value="${supplierBean.strCotactEmailIdForEscLevelTwo}"
				onkeypress=" validateData(event,1);"></td>
					<td class="LABEL" width="25%"><font color="red">*</font>Phone No</td>
					<td class="CONTROL" width="25%"><input type="text"
				maxlength="20" class="txtFldMax" name="strCotactNoForEsc"  value="${supplierBean.strCotactNoForEscLevelTwo}"
				onkeypress="return validateData(event,2);"></td>

		   </tr>
		   <tr>
					<td class="LABEL" colspan="1" width="25%">Fax No</td>
					<td class="CONTROL" colspan="1" width="25%"><input type="text"
				maxlength="20" class="txtFldMax" name="strCotactFaxForEsc"  value="${supplierBean.strCotactFaxForEscLevelTwo}"
				onkeypress="return validateData(event,2);"></td>
					<td class="CONTROL" colspan="2"></td>

		   </tr>
		   
		   </table>
		</div>	
	</div>


	
	<div id="IsSupplierBlackListedId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>

			<td class="TITLE" colspan="4"></td>

		</tr>
		
		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Action
			Date</td>
			<td class="CONTROL" colspan="" width="25%"><dateTag:date
				name="strActionDate" value="${supplierBean.strActionDate}"></dateTag:date>
			</td>
			<td class="LABEL" width="25%">Remarks</td>
			<td class="CONTROL" width="25%"><textarea rows="2" cols="20"
				name="strBlackListedRemarks"><bean:write
				name="supplierBean" property="strBlackListedRemarks" filter="false" /></textarea>
			</td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Committee
			Name</td>
			<td class="CONTROL" width="25%"><select name="strCommitee"
				class="comboNormal">
				<bean:write name="supplierBean" property="strCommitteValuesModi"
					filter="false" />
			</select></td>
			<td class="LABEL" width="25%"></td>
			<td class="LABEL" width="25%"></td>

		</tr>
	</table>
	</div>

	<table cellspacing="1px" class="TABLEWIDTH" align="center"
		cellpadding="1px">
		<tr>

			<td class="TITLE" colspan="4"></td>

		</tr>
		
		<tr>
			<td class="LABEL" width="25%">Remarks</td>
			<td class="CONTROL" width="25%" colspan=""><textarea rows="2"
				cols="20" name="strRemarks"><bean:write
				name="supplierBean" property="strRemarks" filter="false" /></textarea></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Effective
			From</td>
			<td class="CONTROL" width="25%" colspan=""><bean:write name="supplierBean" property="strEffectiveFrom"></bean:write>
			</td>
		</tr>
		<tr>
			<td class="LABEL">Record Status</td>
			<td class="CONTROL"><html:radio name="supplierBean"
				property="strIsValid" value="1">Active</html:radio> <html:radio
				name="supplierBean" property="strIsValid" value="2">Inactive</html:radio>
			</td>
			<td class="LABEL" colspan="2"></td>
		</tr>
	</table>
	<table cellspacing="1px" class="TABLEWIDTH" align="center"
		cellpadding="1px">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>
	<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">

		<tr>

			<td align="right" colspan="2" width="25%"><img
				src="../../hisglobal/images/btn-sv.png" onClick="validateInsert();"
				style="cursor: pointer;" title="Save Record" /></td>
			<td align="left" colspan="2" width="25%"><img
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('LIST');" style="cursor: pointer;"
				title="Cancel Process"></td>
		</tr>
	</table>-->
	<br>
<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick='validateInsert();'><span class="save">Save</span></a>
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
	<input type="hidden" name="hmode" />

	<input type="hidden" value="${supplierBean.strChk}" name="chk" />
	<input type="hidden" value="${supplierBean.strCurrentDate}"
		name="strCurrentDate" />
	<input type="hidden" name="strItemCatNo"
		value="${supplierBean.combo[0]}">
	<input type="hidden" value="${supplierBean.strSupplierStatusCode}"
		name="strSupplierStatusCode" />
	<input type="hidden" value="${supplierBean.strIsBlackListMod}"
		name="strIsBlackListMod" />
	<input type="hidden" value="${supplierBean.strLocalPurchaseSuppFlag}"
		name="IsLocalPurchaseSupp" />
	<input type="hidden" value="${supplierBean.strSupplierStatus}"
		name="hiddenSupplierStatus" />
	<input type="hidden" value="${supplierBean.strIsSupplier}"
		name="IsSupplier" />
	<input type="hidden" value="${supplierBean.strIsManufacturer}"
		name="IsManufacturer" />
	<input type="hidden" value="${supplierBean.strIsAgent}" name="IsAgent" />
	<input type="hidden" value="${supplierBean.strIsBuyer}" name="IsBuyer" />
	
	<input type="hidden" value="${supplierBean.strLevelOneOpen}" name="strLevelOneOpen" />
	<input type="hidden" value="${supplierBean.strLevelTwoOpen}" name="strLevelTwoOpen" />
	
	<input type="hidden" value="${supplierBean.strForeignerSuppFlag}"	name="IsForeignSupplier" />
	<input type="hidden" value="${supplierBean.strForeignerSuppFlag}"	name="strForeignerSuppFlag" />
	
	<input type="hidden" value="${supplierBean.strSupplierProvMaintenance}"	name="strSupplierProvMaintenanceModf" />
	<input type="hidden" value="${supplierBean.strEsclationMtxAvl}"	name="strEsclationMtxAvlModf" />
	<input type="hidden" name="strEffectiveFrom" value="${supplierBean.strEffectiveFrom}">
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>