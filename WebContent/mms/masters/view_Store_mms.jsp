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
<title>Store Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>


<script language="javaScript">
<%-- 
function validate1(){   
     
      var hisValidator = new HISValidator("StoreBean");
           			
           			
           //	hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" );  
            hisValidator.addValidation("strStoreName", "req", "Store Name is a Mandatory Field" );
         // hisValidator.addValidation("strDeptCode", "dontselect=0","Please select a Department Name " );
        //    hisValidator.addValidation("strBuildingCode", "dontselect=0","Please select a Building Name" );
        //    hisValidator.addValidation("strBlockId", "dontselect=0","Please select a Block Name " );
        //    hisValidator.addValidation("strFloorId", "dontselect=0","Please select a Floor Name " );
            //hisValidator.addValidation("strPhoneNo", "req", "Phone No. is a Mandatory Field" ); //Aritra
          	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
			hisValidator.addValidation("strOwnerAddress", "maxlen=250", "Owner Address should have less than or equal to 250 Characters" );
            
            if(document.forms[0].strOwner.value=='2')
            {
            	hisValidator.addValidation("strOwnerName", "req", "Owner Name is a Mandatory Field" );
            	hisValidator.addValidation("strContactNo", "req", "Contact No. is a Mandatory Field" );
            	
            }
            else{
            	  hisValidator.addValidation("strEmpCode", "dontselect=0","Please select an Incharge Name" );
            }
            
            
            hisValidator.addValidation("strStartDateMonth", "dontselect=0","Please select a financial start day month." );
            hisValidator.addValidation("strStartDateYear", "req", "Please enter financial start year value." );
            hisValidator.addValidation("strStartDateYear", "minlen=4", "Please follow Year Format: YYYY." );
            
            hisValidator.addValidation("strEndDateMonth", "dontselect=0","Please select a Financial End Month." );
            hisValidator.addValidation("strEndDateYear", "req", "Please enter Financial End year value." );
            hisValidator.addValidation("strEndDateYear", "minlen=4", "Please follow Year Format: YYYY." );
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
	for(i=1;i<=99;i++)
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
	}
--%>
	function OwnerDetails()
	{
		if(document.forms[0].strOwner.value== '2')
		{
		
			
			document.getElementById('ownerDtls').style.display="block"; 
			//document.forms[0].strEmpCode.value="0";
			document.getElementById('ownerType').innerHTML="Third Party";
			
		}
		else{
			
			document.getElementById('ownerDtls').style.display="none"; 
			
			document.getElementById('ownerType').innerHTML="Hospital";
			//document.forms[0].strOwner.value="";
			//document.forms[0].strOwnerAddress.value="";
			//document.forms[0].strContactNo.value="";
		}
		//alert("strIsvalid :"+ document.forms[0].strIsValid.value);
		if(document.forms[0].strIsValid.value=='1')
		{
			document.getElementById('recordStatus').innerHTML="Active";
		}
		else
		{
			document.getElementById('recordStatus').innerHTML="In-Active";
		}
	}
<%--
	function setPurchasingMode(){
		if(document.getElementsByName("strSection")[0].checked){
			document.getElementById('purchasingModeId').style.display="none";
			
			document.getElementById('storeDiv').style.borderLeft="2px solid brown";
			document.getElementById('storeDiv').style.borderTop="2px solid brown";
			document.getElementById('purchaseDiv').style.borderBottom= "2px solid brown";
			
			document.getElementById('purchaseDiv').style.borderRight="0px";
			document.getElementById('purchaseDiv').style.borderTop="0px";
			document.getElementById('storeDiv').style.borderBottom= "0px";
			
		}else{
			document.getElementById('purchasingModeId').style.display="block";
			
			document.getElementById('storeDiv').style.borderLeft="0px";
			document.getElementById('storeDiv').style.borderTop="0px";
			document.getElementById('purchaseDiv').style.borderBottom= "0px";
			
			//document.getElementById('purchaseDiv').style.borderRight="2px solid brown";
			document.getElementById('purchaseDiv').style.borderTop="2px solid brown";
			document.getElementById('storeDiv').style.borderBottom= "2px solid brown";
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
--%>

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
	

</script>

</head>

<body onLoad="displayTimeBoundRow();OwnerDetails()">
<html:form name="StoreBean" action="/masters/StoreMstCNT"
	type="mms.masters.controller.fb.StoreMstFB" >
	<CENTER>
	<div id="errMsg" class="errMsg"><bean:write name="StoreBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="StoreBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="StoreBean" property="strMsg" /></div>


	<tag:tab tabLabel="Store Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab></CENTER>

	<table class="TABLEWIDTH" align="center" cellpadding="0px"
		cellspacing="0px">
		<tr class="HEADER">
			<td colspan="3">Store Master&gt;&gt; View</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%;">Section
			Mode&nbsp;</td>
			<td class="CONTROL">
				<bean:write 
				name="StoreBean" property="strSection" />
			</td>
		</tr>
	</table>
			<!-- 
			<td class="CONTROL"
				style="border-collapse: collapse; border-bottom: 2px solid brown"
				id="purchaseDiv"><html:radio name="StoreBean" value="2"
				property="strSection" >
				Purchase
				</html:radio></td>


		</tr>
	</table>
	
	<div id='purchasingModeId' style='display: none'>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td class="LABEL">Purchasing mode</td>
			<td class="CONTROL" width="50%"><html:radio name="StoreBean"
				value="1" property="strPurchasingMode">
				Internal
				</html:radio> <html:radio name="StoreBean" value="2" property="strPurchasingMode">
				External
				</html:radio></td>
		</tr>
	</table>
	</div>
			 -->
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<%-- 
		<tr>
			<td class="LABEL">Store Type Name</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreBean"
				property="strStoreTypeName" filter="false" /></td>

		</tr>
		--%>
		<tr>
			<td width="50%" class="LABEL">Store Name</td>
			<td width="50%" class="CONTROL"><bean:write 
				name="StoreBean" property="strStoreName" /></td>
		</tr>
		
		<%--
		Bellow two lines are added with the style :: display:none by Aritra on 10Jan 2011
		Reason: Change Request from Ajay Sir: "No need for 'Bounded with item' and 'to add new item' field."
		
		<tr style="display: none" >
			<td width="50%" class="LABEL">Whether Store is Bounded With
			Items</td>
			<td width="50%" class="CONTROL"><html:checkbox
				property="strItemBounded" value="1" name="StoreBean"></html:checkbox>
			</td>
		</tr>

		<tr style="display: none" >
			<td width="50%" class="LABEL">Whether allow to add new item from
			transaction</td>
			<td width="50%" class="CONTROL"><html:checkbox
				property="strIsNewItemFlag" value="1" name="StoreBean"></html:checkbox>
			</td>
		</tr>
		--%>
		
				
<%--	Drug warehouse Type	 (Change Request) --%>

		<tr style="display:none">
			<td class="LABEL">Store Type</td>
			<td width="50%" class="CONTROL">
			
			<select name="strDrugWarehouseTypeCmb"  style="border:thin;width: 100%;background-color: #F1ECE2"> 
				<bean:write name="StoreBean" property="strDrugWarehouseTypeCmb" filter="false"/>
				
			</select>
			</td>
		</tr>
		<tr style="display:none">
			<td class="LABEL">Store Name</td>
			<td width="50%" class="CONTROL">
			
			
			
				<bean:write name="StoreBean" property="strDistrictDrugWarehouseTypeCmb" filter="false"/>
				
			
			</td>
		</tr>
		
		
		<tr style="display: none">
			<td width="50%" class="LABEL">Store	Level</td>
			<td width="50%" class="CONTROL">
				<bean:write name="StoreBean" property="strStoreLevel" />
			</td>
		</tr>
		
        	
		
		
		<tr>
			<td class="LABEL">Location</td>
			<td width="50%" class="CONTROL">
				<bean:write name="StoreBean" property="strLocation" />
			</td>
		</tr>
		
		<tr style="display:none">
			<td class="LABEL">District</td>
			<td width="50%" class="CONTROL">
			
				
			
				<bean:write name="StoreBean" property="strDistrictCmb" filter="false"/>
				
			</td>
		</tr>
		
		<!--<tr>
			<td class="LABEL"><font color="red">*</font>Address</td>
			<td width="50%" class="CONTROL">
				<textarea name="strHeader1" rows="2" cols="12" readonly="readonly"><bean:write name="StoreBean" property="strHeader1" filter="false" /></textarea>
				<textarea name="strHeader2" rows="2" cols="12" readonly="readonly"><bean:write name="StoreBean" property="strHeader2" filter="false" /></textarea>
				<textarea name="strHeader3" rows="2" cols="12" readonly="readonly"><bean:write name="StoreBean" property="strHeader3" filter="false" /></textarea>			 
			</td>
		</tr>  -->
		
		
		
		<tr style="display:none">
			<td width="50%" class="LABEL">Phone No.
			<td width="50%" class="CONTROL">
				<bean:write name="StoreBean" property="strPhoneNo" />
			</td>
		</tr>
		

<!-- Code (Change Request) -->
		
		<tr style="display:none">
			<td width="50%" class="LABEL">Code</td>
			<td width="50%" class="CONTROL">
			<bean:write property="strStateShortCode" name="StoreBean" />-
			<html:hidden name="StoreBean" property="strStateShortCode" />
			<bean:write property="strCode" name="StoreBean" />
		</tr>
		

<!-- No Of Beds (Change Request)-->

		<tr style="display:none">
			<td width="50%" class="LABEL">No Of Beds</td>
			<td width="50%" class="CONTROL">
			<bean:write property="strNoOfBeds" name="StoreBean" />
			</td>
		</tr>		
		
		
		<tr class="HEADER" style="display:none">
			<td colspan="2">Owner Details</td>
		</tr>
		<tr style="display:none">
			<td class="LABEL">Owner Type</td>
			<td width="50%" class="CONTROL"><div id="ownerType"></div>
				
			</td>
		</tr>
	</table>
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Association With Employee</td>
		</tr>
		
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 		<tr>
  			<td colspan="1" class="CONTROL" ><div id="RightReqTypes" align="left">
					<select name="strRightRequestTypes" multiple="multiple" style="border:thin;width: 100%;background-color: #F1ECE2">
					<bean:write name="StoreBean" property="strRightRequestTypeList" filter="false"/>
					</select>
				</div>
			</td>		
		</tr> 
	</table>
	
	<div id="ownerDtls" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL">OwnerName</td>
			<td width="50%" class="CONTROL">
				<bean:write name="StoreBean" property="strOwnerName" filter="false"/>
			</td>
		</tr>
		<tr>
			<td class="LABEL">
			Owner Address
			</td>
			<td class="CONTROL">
			<textarea name="strOwnerAddress" rows="2" readonly="readonly"><bean:write
				name="StoreBean" property="strOwnerAddress" filter="false" /></textarea>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Contact No.</td>
			<td width="50%" class="CONTROL">
				<bean:write name="StoreBean" property="strContactNo" filter="false"/>
			</td>
		</tr>

	</table>
	</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
	<tr>
		<td class="LABEL" width="50%">Whether Store is Time Bound</td>
		<td class="CONTROL" colspan="3" width="50%">
		<bean:write name="StoreBean" property="fTimeBoundFlag" filter="false" /></td>
	
	</tr>
	<tr id="timeBoundRowId" style="display: none">
		<td width="25%" class="LABEL">From Time</td>
		<td width="25%" class="CONTROL">
				<input type="text" name="strFromTime" value="${StoreBean.strFromTime }" 
						maxlength="5" size="5" readonly="readonly">&nbsp;[hh:mm] 24-hour
		</td>
		<td width="25%" class="LABEL">To Time</td>
		<td width="25%" class="CONTROL">
				<input type="text" name="strToTime" value="${StoreBean.strToTime }" 
						maxlength="5" size="5" readonly="readonly">&nbsp;[hh:mm] 24-hour
		</td>
				
	</tr>
	<tr>
		<td class="TITLE" colspan="4">&nbsp;</td>
	</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr style="display: none">
			<td class="LABEL" width="50%">Financial Start Date</td>
			<td class="CONTROL" width="50%">
				<input type="text" name="strStartDateMonth" maxlength="10"
					value="${ StoreBean.strStartDateMonth}" readonly="readonly"></input>
				<html:text name="StoreBean" property="strStartDateYear" styleId="strStartDateYear" maxlength="4"
				size="6" readonly="true" onkeypress="return validateData(event,5);"></html:text>&nbsp;[YYYY]
			</td>
		</tr>
		<tr style="display: none">
			<td class="LABEL" width="50%">Financial End Date</td>
			<td class="CONTROL">
				<input type="text" name="strEndDateMonth" maxlength="10"
					value="${ StoreBean.strEndDateMonth}" readonly="readonly"></input>
				<html:text name="StoreBean" property="strEndDateYear" styleId="strEndDateYear" maxlength="4"
				size="6" readonly="true" onkeypress="return validateData(event,5);"></html:text>&nbsp;[YYYY]
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%">Effective From</td>
			<td class="CONTROL">
				<bean:write name="StoreBean" property="strEffectiveFrom" filter="false" />				
			</td>
		</tr>

		<tr style="display: none">
			<td class="LABEL">Remarks</td>
			<td class="CONTROL"><bean:write
				name="StoreBean" property="strRemarks" filter="false" />
			</td>
		</tr>
		<tr style="display:none">
			<td width="45%" class="LABEL">Record Status</td>
			<td width="45%" class="CONTROL">
				<div id="recordStatus"></div>
			</td>
		</tr>
	</table>


	<table class="TABLEWIDTH" align="center" cellpadding="0"
		cellspacing="0">
		<tr class="FOOTER">
			<td colspan="2"></td>
		</tr>
	</table>

<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img
				
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="window.close();" /></td>
		</tr>
	</table>-->
<br>
<div align="center" id=" ">					 
					 	<a href="#" class="button" onclick="window.close();"><span class="cancel">Cancel</span></a>
				</div>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="chk" value="${StoreBean.strChk1}">
	<input type="hidden" name="strOwner"value="${StoreBean.strOwner}">
	<input type="hidden" name="strIsValid" value="${StoreBean.strIsValid }"/>
	
	<input type="hidden" name="strFinStartDate" id="strFinStartDate" value="${StoreBean.strFinStartDate}" />
	<input type="hidden" name="strFinEndDate" id="strFinEndDate" value="${StoreBean.strFinEndDate}" />
	<cmbPers:cmbPers />
</html:form>

</body>
</html>
