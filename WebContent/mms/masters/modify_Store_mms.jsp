<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset="utf-8">
<title>Store Master-Modify</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">
function validate1()
{   
     
      var hisValidator = new HISValidator("StoreBean");
		
		hisValidator.addValidation("strStoreName", "req","Store Name is a Mandatory Field");
		hisValidator.addValidation("strDrugWarehouseTypeId", "dontselect=0","Please select Store Type ");
		hisValidator.addValidation("strLocation", "req","Store Location is a Mandatory Field");           			
		//hisValidator.addValidation("strDistrictId", "dontselect=0","Please select a District Name " );           			
        //hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" );  
           
           
         // hisValidator.addValidation("strDeptCode", "dontselect=0","Please select a Department Name " );
        //    hisValidator.addValidation("strBuildingCode", "dontselect=0","Please select a Building Name" );
        //    hisValidator.addValidation("strBlockId", "dontselect=0","Please select a Block Name " );
        //    hisValidator.addValidation("strDistrictId", "dontselect=0","Please select a District Name " );
            //hisValidator.addValidation("strPhoneNo", "req", "Phone No. is a Mandatory Field" ); //Aritra
          	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
			
            
            if(document.forms[0].strOwner.value=='2')
            {
            	hisValidator.addValidation("strOwnerName", "req", "Owner Name is a Mandatory Field" );
            	hisValidator.addValidation("strOwnerAddress", "maxlen=250", "Owner Address should have less than or equal to 250 Characters" );
            	hisValidator.addValidation("strContactNo", "req", "Contact No. is a Mandatory Field" );
            	
            }
            else{
            	  hisValidator.addValidation("strEmpCode", "dontselect=0","Please select an Incharge Name" );
            }
            
            
            hisValidator.addValidation("strStartDateMonth", "dontselect=0","Please select a financial start day month." );
            hisValidator.addValidation("strStartDateYear", "req", "Please enter financial start year value." );
          //  hisValidator.addValidation("strStartDateYear", "minlen=4", "Please follow Year Format: YYYY." );
            
            hisValidator.addValidation("strEndDateMonth", "dontselect=0","Please select a Financial End Month." );
            hisValidator.addValidation("strEndDateYear", "req", "Please enter Financial End year value." );
         //   hisValidator.addValidation("strEndDateYear", "minlen=4", "Please follow Year Format: YYYY." );
            //alert("Aritra:::"+document.forms[0].strFinEndDate.value);
            hisValidator.addValidation("strFinEndDate", "dtgtet="+document.forms[0].strFinStartDate.value,"Financial End Date should be greater than Financial Start Date");
            
            
            var retVal = hisValidator.validate(); 
    	
          if(retVal){
           				 var flag = checkFinancialDates();
           				 
           				/*
   				    	The following lines are commented by Aritra on 10th Jan 2011.
   				    	
   				    	Reason : Change Request from Ajay Sir: "No need for 'Bounded with item' and 'to add new item' field."
   				    	*/
   				    	/*
   				    	
      				    if(!document.getElementsByName("strItemBounded")[0].checked){
      				     flag=confirm('You are not going to bound this store with any items\nAre you sure');
      				    }
           				*/
           			 	if(flag) {
        				 	var elementTimeBoundFlag =document.getElementsByName("fTimeBoundFlag")[0];
        				 	if(elementTimeBoundFlag.checked==true) {
        					 	flag=checkTimeFormat();	 
        				 	}
        			 	}
      				    if(flag)
      				    {
      				        var count = selectListRecords("strRightRequestTypes");
			        		 if(count==0)
			        		 {
			        		   alert("Please select a Request Type which is not already added");
			        		   return false;
			        		 }
      				    	document.forms[0].hmode.value = "UPDATE";
                       		 document.forms[0].submit();
      				    }else{
      				    	return false;
      				    }
      				   
            }else{
			     return false;
	    }
    }
function LevelCombo()
{
	document.forms[0].strStoreName.focus();
	var options = "";
	for(i=1;i<=1;i++)
	{
		options = options+"<option value=" +i+"> "+i+"</option>";
	}
	var levelDiv= document.getElementById("levelCommbo"); 
	levelDiv.innerHTML= "<select name=strStoreLevel >" +options+" </select>";
	
	
	if(document.forms[0].strOwner.value=='2')
	{
	
	document.getElementById('ownerDtls').style.display="block";
	}
}

function combo1(mode)
	{ 

	 var url;
	 
	 if(mode=="BLOCKNAME"){
		document.forms[0].strFloorId.value='0';
	   url="StoreMstCNT.cnt?hmode="+mode+"&buildingName="+document.forms[0].strBuildingCode.value;
	 ajaxFunction(url,"1");
	}
	
	else if(mode=="FLOORNAME"){
	var blockId = document.forms[0].strBlockId.value; 
	url="StoreMstCNT.cnt?hmode="+mode+"&buildingName="+document.forms[0].strBuildingCode.value+"&blockName="+blockId;

	ajaxFunction(url,"2");
	}
	}


function WardCombo()
{
	var url;
	var mode = "WARDCOMBO";
	url="StoreMstCNT.cnt?hmode="+mode+"&deptId="+document.forms[0].strDeptCode.value; 
 	ajaxFunction(url,"3");

}

function getDistrictDWH()
	{
	//alert(document.forms[0].strDrugWarehouseTypeId.value);
	
		if(document.forms[0].strDrugWarehouseTypeId.value.split("^")[1]=='1')
		{
			document.getElementsByName("strDistrictDrugWarehouseType")[0].disabled=true;
			document.getElementById("mandatoryDivId").style.display='none';
			document.getElementById("nonMandatoryDivId").style.display='';
			
			
		}
		else
		{
		document.getElementsByName("strDistrictDrugWarehouseType")[0].disabled=false;
		document.getElementById("mandatoryDivId").style.display='';
		document.getElementById("nonMandatoryDivId").style.display='none';
		
			var url;
			var mode = "DISTRICTDWH";
			url = "StoreMstCNT.cnt?hmode=" + mode + "&dwhTypeId="+ document.forms[0].strDrugWarehouseTypeId.value;
			
			//ajaxFunction(url, "4");
			
		}			
	}
		
	function getAjaxResponse(res,mode)
	{
	
	
	var objVal;
	if(mode=="1"){   
	
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
			objVal= document.getElementById("BlockId");
			objVal.innerHTML = "<select name ='strBlockId' onChange ='combo1(\"FLOORNAME\");'>" + res + "</select>";
			}
	}
	else if(mode=="2"){
				var err = document.getElementById("errMsg");
	 			var temp1 = res.split("####");
         
         
       			  if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
      				   }
				else{
				var objVal = document.getElementById("FloorId");
				objVal.innerHTML = "<select name='strFloorId'>" + res + "</select>";
				}
	}
	else if(mode=="3"){
				var err = document.getElementById("errMsg");
	 			var temp1 = res.split("####");
         
         
       			  if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
      				   }
				else{
				var objVal = document.getElementById("Ward");
				objVal.innerHTML = "<select name='strWardCode'>" + res + "</select>";
				}
	}
	else if (mode == "4") 
		{
			var err = document.getElementById("errMsg");
			var temp1 = res.split("####");

			if (temp1[0] == "ERROR") {
				err.innerHTML = temp1[1];
			} else {
				var objVal = document.getElementById("districtDHWName");
				objVal.innerHTML = "<select name='strDistrictDrugWarehouseType' class='comboMax'>" + res + "</select>";
			}
		}
	}
	
	function OwnerDetails()
	{
		if(document.forms[0].strOwner.value== '2')
		{
		
			
			document.getElementById('ownerDtls').style.display="block"; 
			document.forms[0].strEmpCode.value="0";
			
		}
		else{
			
			document.getElementById('ownerDtls').style.display="none"; 
			
			document.forms[0].strOwnerName.value="";
			document.forms[0].strOwnerAddress.value="";
			document.forms[0].strContactNo.value="";
		}
	}
	
	function setPurchasingMode(){
		document.forms[0].strLocation.value = document.forms[0].strLocation.value.trim();
		document.forms[0].strRemarks.value = document.forms[0].strRemarks.value.trim();
		document.forms[0].strDLNo.value = document.forms[0].strDLNo.value.trim();
		document.forms[0].strEmdType.value = document.forms[0].stremdtypehidden.value.trim();
		if(document.getElementsByName("strSection")[0].checked){
			document.getElementsByName("strSection")[1].disabled=true;
			document.getElementById('purchasingModeId').style.display="none";
			document.getElementById('storeDiv').style.borderLeft="2px solid brown";
			document.getElementById('storeDiv').style.borderTop="2px solid brown";
			document.getElementById('purchaseDiv').style.borderBottom= "2px solid brown";
			
			document.getElementById('purchaseDiv').style.borderRight="0px";
			document.getElementById('purchaseDiv').style.borderTop="0px";
			document.getElementById('storeDiv').style.borderBottom= "0px";
			document.getElementById('EMDTypeId').style.display = "none";
			
		}else{
			document.getElementsByName("strSection")[0].disabled=true;
			document.getElementById('purchasingModeId').style.display="block";
			
			document.getElementById('storeDiv').style.borderLeft="0px";
			document.getElementById('storeDiv').style.borderTop="0px";
			document.getElementById('purchaseDiv').style.borderBottom= "0px";
			
			//document.getElementById('purchaseDiv').style.borderRight="2px solid brown";
			document.getElementById('purchaseDiv').style.borderTop="2px solid brown";
			document.getElementById('storeDiv').style.borderBottom= "2px solid brown";
			document.getElementById('EMDTypeId').style.display = "";
		}
	}
	
	function checkFinancialDates() {

		var elementStartDateMonth = document
				.getElementById("strStartDateMonth");
		var elementStartDateYear = document.getElementById("strStartDateYear");
		var elementEndDateMonth = document.getElementById("strEndDateMonth");
		var elementEndDateYear = document.getElementById("strEndDateYear");

		var strStartDateMonth = elementStartDateMonth.value;
		var strStartDateYear = elementStartDateYear.value;
		var strEndDateMonth = elementEndDateMonth.value;
		var strEndDateYear = elementEndDateYear.value;

		var nStartDateMonth = parseInt(strStartDateMonth);
		var nStartDateYear = parseInt(strStartDateYear);
		var nEndDateMonth = parseInt(strEndDateMonth);
		var nEndDateYear = parseInt(strEndDateYear);

		if (isNaN(nStartDateMonth)) {

			alert("Select Valid Start Date Month");
			return false;

		}
		if (isNaN(nStartDateYear)) {

			alert("Enter Valid Start Date Year");
			return false;

		}
		if (isNaN(nEndDateMonth)) {

			alert("Select Valid End Date Month");
			return false;

		}
		if (isNaN(nEndDateYear)) {

			alert("Enter Valid End Date Year");
			return false;

		}

		if (nStartDateYear > nEndDateYear) {
			alert("Financial Start Date cannot be greater than Financial End Date.");
			return false;
		}
		if (nStartDateYear == nEndDateYear) {
			if (nStartDateMonth > nEndDateMonth) {
				alert("Financial Start Date cannot be greater than Financial End Date.");
				return false;
			}
		}
		
		return true;
	}
function checkTimeFormat() {
		
		var eleFromTime = document.getElementsByName("strFromTime")[0];
		var eleToTime = document.getElementsByName("strToTime")[0];

		var strFromTime = eleFromTime.value;
		var strToTime = eleToTime.value;

		var arrFromTime = strFromTime.split(":");
		var arrToTime = strToTime.split(":");

		if (arrFromTime.length != 2) {
			alert("Please enter the From Time in HH:MM format only!");
			eleFromTime.focus();
			return false;
		}

		if (arrToTime.length != 2) {
			alert("Please enter the To Time in HH:MM format only!");
			eleToTime.focus();
			return false;
		}

		var strFromTimeHH = arrFromTime[0];
		var strFromTimeMM = arrFromTime[1];

		var strToTimeHH = arrToTime[0];
		var strToTimeMM = arrToTime[1];
		
		var numFromTimeHH = parseInt(strFromTimeHH);
		var numFromTimeMM = parseInt(strFromTimeMM);

		var numToTimeHH = parseInt(strToTimeHH);
		var numToTimeMM =parseInt(strToTimeMM);

		if (isNaN(numFromTimeHH) || isNaN(numFromTimeMM)) {
			alert("Please enter the Preferred Time From in HH:MM format only!");
			eleFromTime.focus();
			return false;
		}

		if (isNaN(numToTimeHH) || isNaN(numToTimeMM)) {
			alert("Please enter the Preferred Time To in HH:MM format only!");
			eleToTime.focus();
			return false;
		}
		
		
		if (numFromTimeHH<0 ||numFromTimeHH>=24 ||numFromTimeMM<0 ||numFromTimeMM>=60 ) {
			alert("Please follow 24-hour clock system. From 00:00 to 23:59");
			eleFromTime.focus();
			return false;
		}
		

		if (numToTimeHH<0 ||numToTimeHH>=24 ||numToTimeMM<0 ||numToTimeMM>=60 ) {
			alert("Please follow 24-hour clock system. From 00:00 to 23:59");
			eleToTime.focus();
			return false;
		}
		
		var numFromTimeInMinutes = (numFromTimeHH*60)+numFromTimeMM ;
		var numToTimeInMinutes = (numToTimeHH*60)+numToTimeMM ;
		
		if(numFromTimeInMinutes>=numToTimeInMinutes) {
			alert("From Time should be less than To Time");
			eleFromTime.focus();
			return false;
		}

		

		return true;
		
	}
	function displayTimeBoundRow() {
		
		var elementTimeBoundRow=document.getElementById("timeBoundRowId");
		var elementTimeBoundFlag =document.getElementsByName("fTimeBoundFlag")[0];
		
		if(elementTimeBoundFlag.checked==true) {
			elementTimeBoundRow.style.display="table-row";
		} else {
			elementTimeBoundRow.style.display="none";
		}
		
	}
	function LeftListTransfer()
    {
	 var ob1=document.forms[0].strLeftReqTypes.value;
	 var ob=document.getElementById("LeftReqTypes");
	 shiftToRight("strLeftReqTypes","strRightRequestTypes",1);
    }
    
    function setModifyDetails()
    {
    	if(document.forms[0].strDrugWarehouseTypeId.value.split("^")[1]=='1')
		{
			document.getElementsByName("strDistrictDrugWarehouseType")[0].disabled=true;
			document.getElementById("mandatoryDivId").style.display='none';
			document.getElementById("nonMandatoryDivId").style.display='';
			
			
		}
		else
		{
			document.getElementById("mandatoryDivId").style.display='';
			document.getElementById("nonMandatoryDivId").style.display='none';
		}
		
    }
	
</script>
</head>

<body onLoad="setPurchasingMode();displayTimeBoundRow();LevelCombo();setModifyDetails();">
<html:form name="StoreBean" action="/masters/StoreMstCNT" type="mms.masters.controller.fb.StoreMstFB">
	<CENTER>
		<div id="errMsg" class="errMsg"><bean:write name="StoreBean" property="strErr" /></div>
		<div class="warningMsg"><bean:write name="StoreBean" property="strWarning" /></div>
		<div id="normalMsg" class="normalMsg"><bean:write name="StoreBean" property="strMsg" /></div>
		<tag:tab tabLabel="Store Master" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
	</CENTER>

	<table class="TABLEWIDTH" align="center" cellpadding="0px" cellspacing="0px">
		<tr class="HEADER">
			<td colspan="3">Store Master&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td class="LABEL" style="border-bottom: 2px solid brown; width: 50%;">Section Mode:&nbsp;</td>
			<td class="CONTROL" style="border-collapse: collapse; border-left: 2px solid brown; border-right: 2px solid brown; border-top: 2px solid brown"	id="storeDiv">
				<html:radio name="StoreBean" value="1" property="strSection" onclick="setPurchasingMode();">Store</html:radio></td>
			<td class="CONTROL" style="border-collapse: collapse; border-bottom: 2px solid brown" id="purchaseDiv">
				<html:radio name="StoreBean" value="2" property="strSection" onclick="setPurchasingMode();">Purchase</html:radio></td>
		</tr>
	</table>
	
	<div id='purchasingModeId' style='display: none'>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL">Purchasing mode</td>
			<td class="CONTROL" width="50%">
				<html:radio name="StoreBean" value="1" property="strPurchasingMode">Internal</html:radio>
				<html:radio name="StoreBean" value="2" property="strPurchasingMode">External</html:radio></td>
		</tr>
	</table>
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<%-- 
		<tr>
			<td class="LABEL">Store Type Name</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreBean"
				property="strStoreTypeName" filter="false" /></td>

		</tr>
		--%>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" class="CONTROL">
				<input type="text" name="strStoreName" maxlength="50" value="${StoreBean.strStoreName}" onkeypress="return validateData(event,18);">
			</td>			
			<td width="25%" class="CONTROL">
			<td width="25%" class="CONTROL">
		</tr>
		
		<%--
		Bellow two lines are added with the style :: display:none by Aritra on 10Jan 2011
		Reason: Change Request from Ajay Sir: "No need for 'Bounded with item' and 'to add new item' field."
		--%>
		<tr style="" >
			<td width="50%" class="LABEL">Whether Store is Bounded With Items</td>
			<td width="50%" class="CONTROL"><html:checkbox
				property="strItemBounded" value="1" name="StoreBean"></html:checkbox>
			</td>
		</tr>

		<tr>
			<td width="50%" class="LABEL">Whether Allow Item Adddition in Inventory/Store Inventory Maintained</td>
			<td width="50%" class="CONTROL">
				<html:radio property="strIsNewItemFlag" value="1" name="StoreBean">Allowed</html:radio>
				<html:radio property="strIsNewItemFlag" value="0" name="StoreBean">Not Allowed</html:radio>
			</td>
		</tr>
		
				
<%--	Drug warehouse Type	 (Change Request) --%>

		<tr>
			<td class="LABEL" width="25%" ><font color="red">*</font>Store Type</td>
			<td width="25%" class="CONTROL">			
				<select name="strDrugWarehouseTypeId" class="comboNormal" >
					<bean:write name="StoreBean" property="strDrugWarehouseTypeCmb" filter="false"/>
				</select>			
			</td>		
			<td width="25%" class="LABEL">
			<!--<div id="mandatoryDivId"><font color="red">*</font>District Store Name</div>
			<div id="nonMandatoryDivId" style="display: none;">District Store Name</div>
						
			--><td width="25%" class="CONTROL">
				<!--<div id="districtDHWName">		
					<select name="strDistrictDrugWarehouseType" class="comboMax">
						<bean:write name="StoreBean" property="strDistrictDrugWarehouseTypeCmb" filter="false"/>
					</select>
				</div>
		   --></td>
		</tr>
		
		<tr style="display: none">
			<td width="25%" class="LABEL"><font color="red">*</font>Store Level</td>
			<td width="25%" class="CONTROL">
				<select name=strStoreLevel ><option value='1'>1</option></select>
			</td>			
			<td width="25%" class="CONTROL"></td>
			<td width="25%" class="CONTROL"></td>
		</tr>

		<tr>
			<td class="LABEL">Department</td>
			<td width="50%" class="CONTROL">
				<html:select name="StoreBean" property="strDeptCode" onchange="WardCombo();" styleClass="comboNormal">
					<bean:write name="StoreBean" property="strDepartmentCombo" filter="false" />
				</html:select></td>
		</tr>
		<tr>
			<td class="LABEL">Ward Name</td>
			<td width="50%" class="CONTROL">
			<div id="Ward">
				<select name="strWardCode" class="comboNormal">
					<bean:write name="StoreBean" property="strWardCombo" filter="false" />
				</select></div>
			</td>
		</tr>	
		
			<tr id="EMDTypeId" style="display: none;">
			<td class="LABEL">EMD Type</td>
			<td width="50%" class="CONTROL">
			<div id="Ward">
				<select name="strEmdType" Class="comboNormal">
					<option value="0">Select Value</option>
					<option value="1">Item Wise EMD</option>
					<option value="2">Combined EMD</option>
				</select></div>
			</td>
		</tr>	
			
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Location</td>
			<td width="25%" class="CONTROL">
			<textarea name="strLocation" rows="2" cols="20">
			  <bean:write name="StoreBean" property="strLocation" filter="false" /></textarea></td>
		
			<!--<td class="LABEL" width="25%"><font color="red">*</font>District</td>
			<td width="25%" class="CONTROL">
			 <select name="strDistrictId" class="comboNormal">
				<bean:write name="StoreBean" property="strDistrictCmb" filter="false"/>
			</select>
			</td>
		-->
		
		<td class="LABEL" width="25%"></td>
		<td width="25%" class="CONTROL"></td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL" ><font color="red">*</font>Drug License No.</td>
			<td width="25%" class="CONTROL">
			<textarea name="strDLNo" rows="2" cols="20"><bean:write name="StoreBean" property="strDLNo" filter="false" /></textarea>				
			</td>
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="CONTROL"></td>
		</tr>
		
		
		<!--<tr>
			<td width="25%" class="LABEL">Mobile No.
			<td width="25%" class="CONTROL">
				<input type="text" name="strPhoneNo" maxlength="60" value="${StoreBean.strPhoneNo}"
				onkeypress="return validateDataWithSpecialChars(event,5,',');"></td>
				
			<td width="25%" class="CONTROL">
			<td width="25%" class="CONTROL">	
		</tr>
		

--><!-- Code (Change Request) & No Of Beds (Change Request) -->
		
		<!--<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Store Code(Short Code-User Defined Code)</td>
			<td width="25%" class="CONTROL">
				<bean:write property="strStateShortCode" name="StoreBean" />-
				<html:hidden name="StoreBean" property="strStateShortCode" />
				<input type="text" name="strCode" maxlength="17" value="${StoreBean.strCode}" style="text-transform: uppercase" onkeypress="return validateData(event,16);"></td><!--

			<td width="25%" class="LABEL"><font color="red">*</font>No Of Beds</td>
			<td width="25%" class="CONTROL">
				<input type="text" name="strNoOfBeds" maxlength="3" value="${StoreBean.strNoOfBeds}"
				onkeypress="return validateData(event,5);"></td>
		
		<td class="LABEL" width="25%"></td>
		<td width="25%" class="CONTROL"></td>		
		</tr>	  -->	
		
		
		<tr class="HEADER" style="display: none">
			<td colspan="4">Owner Details</td>
		</tr>
		<tr style="display: none">
			<td width="25%" class="LABEL"><font color="red">*</font>Owner Type</td>
			<td width="25%" class="CONTROL">
				<html:select name="StoreBean" property="strOwner" onchange="OwnerDetails();">
					<html:option value="1">Hospital</html:option>
					<html:option value="2">Third Party</html:option>
				</html:select>
			</td>		
			<td width="25%" class="CONTROL"></td>
			<td width="25%" class="CONTROL"></td>
	</table>
	
	<div id="ownerDtls" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Owner Name</td>
			<td width="50%" class="CONTROL"><input type="text" name="strOwnerName" maxlength="100" value="${StoreBean.strOwnerName}" onkeypress="return validateData(event,9);"></td>
		</tr>
		<tr>
			<td class="LABEL">
				<div align="right">Owner Address</div>
			</td>
			<td class="CONTROL">
				<div align="left"><textarea name="strOwnerAddress" rows="2"><bean:write name="StoreBean" property="strOwnerAddress" filter="false" /></textarea></div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Contact No.</td>
			<td width="50%" class="CONTROL"><input type="text" name="strContactNo" maxlength="50" value="${StoreBean.strContactNo}" onkeypress="return validateData(event,5);"></td>
		</tr>
	</table>
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 		<tr class="HEADER">
			<td colspan="8">Association With Employee</td>
		</tr>
		<tr>
  			 <td class="CONTROL" colspan="3">  			 
				<div id="LeftReqTypes" align="right">
					<select name="strLeftReqTypes" size="8"  multiple style="width: 280px">
						<bean:write name="StoreBean" property="strLeftRequestTypeList" filter="false"/>
					</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">
			<center>
				<img src="../../hisglobal/images/forward3.gif" width="35" height="31" onclick ="LeftListTransfer();"></center>
			<center>
				<img src="../../hisglobal/images/forwardward.gif" width="35" height="31" align="middle" onClick="shiftAllToRight('strLeftReqTypes','strRightRequestTypes',1);"/></center>
			<br/>
			<center>
				<img src="../../hisglobal/images/backward.gif" width="35" height="31" onClick="shiftAllToLeft('strLeftReqTypes','strRightRequestTypes',1);"></center>
			<center>
				<img src="../../hisglobal/images/back3.gif" width="35" height="31" onclick="shiftToLeft('strLeftReqTypes','strRightRequestTypes',1);"/></center>
			</td>
			
			<td colspan="3" class="CONTROL" >
				<div id="RightReqTypes" align="left">
					<select name="strRightRequestTypes" size="8" multiple style="width: 280px"><bean:write name="StoreBean" property="strRightRequestTypeList" filter="false"/></select>
				</div>
			</td>		
			</tr> 
		</table>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	<tr>
		<td class="LABEL" width="25%">Whether Store is Time Bound</td>
		<td class="CONTROL" colspan="3" width="75%"><html:checkbox name="StoreBean" property="fTimeBoundFlag" onclick="displayTimeBoundRow();"/></td>
	</tr>
	<tr id="timeBoundRowId" style="display: none">
		<td width="25%" class="LABEL"><font color="red">*</font>From Time</td>
		<td width="25%" class="CONTROL"><html:text name="StoreBean" property="strFromTime" 
				maxlength="5" onchange="return validateDataWithSpecialChars(event,5,':');"
				onkeypress="return validateDataWithSpecialChars(event,5,':');"
				styleClass="txtFldMin"></html:text>&nbsp;[hh:mm] 24-hour</td>
		<td width="25%" class="LABEL"><font color="red">*</font>To Time</td>
		<td width="25%" class="CONTROL"><html:text name="StoreBean" property="strToTime"
				maxlength="5" onchange="return validateDataWithSpecialChars(event,5,':');"
				onkeypress="return validateDataWithSpecialChars(event,5,':');"
				styleClass="txtFldMin"></html:text>&nbsp;[hh:mm] 24-hour</td>
	</tr>
	<tr>
		<td class="TITLE" colspan="4">&nbsp;</td>
	</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr style="display: none;">
			<td class="LABEL" width="50%"><font color="red">*</font>Financial Start Date</td>
			<td class="CONTROL" width="50%">
				<html:select name="StoreBean" property="strStartDateMonth" styleId="strStartDateMonth" style="width: 120px;">
				<!--<html:option value="01">January</html:option>
				<html:option value="02">February</html:option>
				<html:option value="03">March</html:option>-->
				<html:option value="04">April</html:option>
				<!--<html:option value="05">May</html:option>
				<html:option value="06">June</html:option>
				<html:option value="07">July</html:option>
				<html:option value="08">August</html:option>
				<html:option value="09">September</html:option>
				<html:option value="10">October</html:option>
				<html:option value="11">November</html:option>
				<html:option value="12">December</html:option>-->
				</html:select>-<html:text name="StoreBean" property="strStartDateYear" styleId="strStartDateYear" maxlength="4" size="6" onkeypress="return validateData(event,5);"></html:text>&nbsp;[YYYY]</td>
		</tr>


		<tr style="display: none;">
			<td class="LABEL" width="50%"><font color="red">*</font>Financial End Date</td>
			<td class="CONTROL">
				<html:select name="StoreBean" property="strEndDateMonth" styleId="strEndDateMonth" style="width: 120px; color: black;">
				<!--<html:option value="01">January</html:option>
				<html:option value="02">February</html:option>-->
				<html:option value="03">March</html:option>
				<!--<html:option value="04">April</html:option>
				<html:option value="05">May</html:option>
				<html:option value="06">June</html:option>
				<html:option value="07">July</html:option>
				<html:option value="08">August</html:option>
				<html:option value="09">September</html:option>
				<html:option value="10">October</html:option>
				<html:option value="11">November</html:option>
				<html:option value="12">December</html:option>-->
			</html:select>-<html:text name="StoreBean" property="strEndDateYear" styleId="strEndDateYear" maxlength="4" size="6" onkeypress="return validateData(event,5);"></html:text>&nbsp;[YYYY]</td>

		</tr>
		
		<!--<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Mapped With Hospital</td>
			<td width="25%" class="CONTROL">			
				<select name="strMapHospId" class="comboNormal">
					<bean:write name="StoreBean" property="strMappedHospCmb" filter="false"/>
				</select>			
			</td>
		</tr>-->
		
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Effective From</td>
			<td class="CONTROL" width="50%"><dateTag:date name="strEffectiveFrom"
				value="${StoreBean.strCtDate}"></dateTag:date></td>
		</tr>

		<tr>
			<td class="LABEL">Remarks</td>
			<td class="CONTROL">
				<div align='left'><textarea name="strRemarks" rows="2" >
				<bean:write name="StoreBean" property="strRemarks" filter="false" /></textarea></div></td>
		</tr>
		<tr>
			<td width="45%" class="LABEL">Record Status</td>
			<td width="45%" class="CONTROL"><html:radio name="StoreBean"
				property="strIsValid" value="1">Active</html:radio> <html:radio
				name="StoreBean" property="strIsValid" value="2">Inactive</html:radio>

			</td>
		</tr>
		
		<!--<tr>
		<td class="TITLE" colspan="4">Report Headers</td>
	</tr>
	
	<tr>
			<td width="50%" class="LABEL">HEADER 1</td>
			<td width="50%" colspan="3" class="CONTROL">
				<textarea name="strHeader1" rows="2" cols="30"><bean:write name="StoreBean" property="strHeader1" filter="false" /></textarea>				
			</td>	
			
	</tr>
	
	<tr>			
			<td width="50%" class="LABEL">HEADER 2</td>
			<td width="50%" colspan="3" class="CONTROL">			
				<textarea name="strHeader2" rows="2" cols="30"><bean:write name="StoreBean" property="strHeader2" filter="false" /></textarea>			 
			</td>
	</tr>
	
	<tr>
			<td width="50%" class="LABEL">HEADER 3</td>
			
			<td width="50%" colspan="3" class="CONTROL">			
				<textarea name="strHeader3" rows="2" cols="30"><bean:write name="StoreBean" property="strHeader3" filter="false" /></textarea>			 
			</td>
	</tr>
		
	--></table>


	<table class="TABLEWIDTH" align="center" cellpadding="0" cellspacing="0">
		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>

	<!--<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
				<img src="../../hisglobal/images/btn-sv.png" style="cursor: pointer; " title="Save Record" onClick=" return validate1();" /> 
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor: pointer; " title="Cancel Process" onClick="cancel('LIST');" /></td>
		</tr>
	</table>-->
	<br>
<div align="center" id=" ">					 
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="chk" value="${StoreBean.strChk1}">
	<%-- 
	<input type="hidden" name="strStoreTypeId"
		value="${StoreBean.combo[0]}">
	<input type="hidden" name="comboValue"
		value="${StoreBean.strStoreTypeName}">
	--%>
	<input type="hidden" name="strFinStartDate" id="strFinStartDate" value="${StoreBean.strFinStartDate}">
	<input type="hidden" name="strFinEndDate" id="strFinEndDate" value="${StoreBean.strFinEndDate}">
    <input type="hidden" name="strEffectiveFrom" id="strEffectiveFrom"	value="${StoreBean.strEffectiveFrom}">
      <input type="hidden" name="stremdtypehidden" id="stremdtypehidden"	value="${StoreBean.stremdtypehidden}">
		
		
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>