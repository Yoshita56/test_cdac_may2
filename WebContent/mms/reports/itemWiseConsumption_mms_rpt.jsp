<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Drug wise Consumption Details</title>

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
</style>

<!-- CSS -->
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<!-- JS -->
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js""></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<script type="text/javascript">

function validate(){

	var hisValidator = new HISValidator("itemWiseConsumptionRpt");

	hisValidator.addValidation("strItemCategoryNo", "dontselect=0","Please Select Item Category");
	
	if(document.forms[0].strDateYear[0].checked){
	
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCtDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	}else if(document.forms[0].strDateYear[1].checked){
	
		hisValidator.addValidation("strFromYear", "req","From Year is a mandatory field");
		hisValidator.addValidation("strToYear", "req","To Year is a mandatory field");
		hisValidator.addValidation("strFromYear","numltet="+document.forms[0].strToYear.value,"Please Select To Year Greater Than or Equal To From Year ");
	
	}
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if(retVal){
		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
		document.forms[0].submit();
		}else{
		return false;
		}
	}
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function groupNameCombo()
{
   var mode ="GROUPNAME";  
   var url="ItemWiseConsumptionRptCNT.cnt?hmode=GROUPNAME&itemCatNo="+document.forms[0].strItemCategoryNo.value;
   ajaxFunction(url,"1");
} 

function subGroupNameCombo()
{
   var mode ="SUBGROUPNAME";  
   var url="ItemWiseConsumptionRptCNT.cnt?hmode=SUBGROUPNAME&groupId="+document.forms[0].strGroupId.value+
   								"&itemCateg="+document.forms[0].strItemCategoryNo.value;
   ajaxFunction(url,"2");
} 

function itemNameCombo()
{
	if(document.forms[0].strGroupId.value!="0"){
		var mode ="ITEMNAME";
	   var url="ListItemWiseSupplierRptCNT.cnt?hmode=ITEMNAME&itemCatNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value+
	   				"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
	   				"&subgrpid="+document.forms[0].strSubGroupId.value;
	   ajaxFunction(url,"3");
   }
} 

function getAjaxResponse(res,mode)
{
	var objVal;
	if(mode=="1")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
       	  objVal= document.getElementById("groupId");
		  objVal.innerHTML = "<select name ='strGroupId' class='custom-select' onChange='subGroupNameCombo();'>" + res + "</select>";
		  
        }
        itemNameCombo();
    }
    
  	if(mode=="2")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
        	var temp = res.split('@');
        	
          objVal= document.getElementById("subGroupId");
		  objVal.innerHTML = "<select name ='strSubGroupId' class='custom-select' onChange='itemNameCombo()'>" + temp[0] + "</select>";
		   
		  objVal= document.getElementById("ItemId");
		  objVal.innerHTML = "<select name ='strItemId' class='custom-select' >" + temp[1] + "</select>";
		     
        }
    }
     if(mode=="3")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
        	objVal= document.getElementById("ItemId");
		    objVal.innerHTML = "<select name ='strItemId' class='custom-select' >" + res + "</select>";
		   
        }
    }
}

function radioButton(obj){
	
	for(var i = 0 ; i < obj.length ; i++){
	
		if(obj[i].checked){
			obj = obj[i];
			break;
		}
		
	}

	if(obj.value == 1){
		document.getElementById("DateDivId").style.display = "block";
		document.getElementById("YearDivId").style.display = "none";
		document.forms[0].strItemCategoryNo.value="0";
		document.forms[0].strFromDate.value = document.forms[0].strCtDate.value;
	 	document.forms[0].strToDate.value = document.forms[0].strCtDate.value;
		
	}else if(obj.value == 2){
		document.getElementById("DateDivId").style.display = "none";
		document.getElementById("YearDivId").style.display = "block";
		document.forms[0].strItemCategoryNo.value="0";
		document.forms[0].strFromYear.value="";
	 	document.forms[0].strToYear.value="";
		
	}

}

function clearButton(){
	 
	 if(document.forms[0].strDateYear[0].checked){
	 	
	 	document.forms[0].strItemCategoryNo.value="0";
	 	document.forms[0].strGroupId.value="0";
	 	document.forms[0].strSubGroupId.value="0";
	 	document.forms[0].strItemId.value="0";
	 
	 }else if(document.forms[0].strDateYear[1].checked){
	 	
	 	document.forms[0].strItemCategoryNo.value="0";
	 	document.forms[0].strGroupId.value="0";
	 	document.forms[0].strSubGroupId.value="0";
	 	document.forms[0].strItemId.value="0";
	 	document.forms[0].strFromYear.value="";
	 	document.forms[0].strToYear.value="";
	 
	 }

}

function onLoadpage(){

	
	document.forms[0].strItemCategoryNo.value="0";
	
	if(document.forms[0].strDateYear[0].checked){
			document.getElementById("DateDivId").style.display = "block";
			document.getElementById("YearDivId").style.display = "none";
			document.forms[0].strFromDate.value=document.forms[0].strCtDate.value;
			document.forms[0].strToDate.value=document.forms[0].strCtDate.value;
		}else if(document.forms[0].strDateYear[1].checked){
			document.getElementById("DateDivId").style.display = "none";
			document.getElementById("YearDivId").style.display = "block";
			document.forms[0].strFromYear.value="";
			document.forms[0].strToYear.value="";
		}
	
}

</script>
</head>
<body onload="onLoadpage();">
<html:form action="/reports/ItemWiseConsumptionRptCNT" method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="itemWiseConsumptionRpt" property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="itemWiseConsumptionRpt" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="itemWiseConsumptionRpt" property="strWarningMsg" /></div>

	<div class="container-fluid">
		<div class="prescriptionTile">
			<div class='legendHeader' id='' style='font-size: 16px;font-weight: bold;'><i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Item wise Consumption Details</div>

		<div class="row " style="display: none;">
			<div class="col" >
				<html:radio
				name="itemWiseConsumptionRpt" property="strDateYear" value="1"
				onclick="radioButton(this);">Date</html:radio><html:radio
				name="itemWiseConsumptionRpt" property="strDateYear" value="2"
				onclick="radioButton(this);">Year</html:radio>			
			</div>
						
			<div class="col" ><label>Hospital name<font color="red">*</font></label></div>
			<div class="col" >
				<select name="strHospitalCode" class="custom-select">
					<bean:write name="itemWiseConsumptionRpt" property="strHospNameValues" filter="false" />
				</select>		
			</div>
		</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-icon printbtn"  style="border-radius:50%; padding:12px 11px;" onClick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times fa-lg" title="Cancel"></i>
					</div>
				</button>	
				
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon clearbtn" style="background-color: royalblue; border-radius:50%; padding:12px 7px" onClick="clearButton">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom fa-lg" title="Clear"></i>
					</div>
				</button>	
				
				<button  type="button" title="Generate" id="generatebutton" class="float-right btn btn-success mt-1 btn-icon savebtn" style="border-radius:50%; padding:12px 12px;" tabindex='2' onClick=" return validate();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download " title="Generate"></i>
					</div>
				</button>
  			</div>  
		</div>
		
		<div class="row " style="margin: 1% 12%;">
			<div class="col-sm-2"><label>Item Category<font color="red">*</font></label></div>
			<div class="col-sm-4">
				<select name="strItemCategoryNo" class='custom-select' onchange="groupNameCombo();"> 
					<bean:write name="itemWiseConsumptionRpt" property="strItemCategoryCombo" filter="false" />
				</select>
			</div>
			
			<div class="col-sm-2"><label>Group Name<font color="red">*</font></label></div>
			<div class="col-sm-4" id="groupId">
				<select name="strGroupId" class='custom-select' onchange="subGroupNameCombo();"> 
					<option value="0">All</option>
				</select>
			</div>
		</div>
		
		<div class="row " style="margin: 1% 12%;">
			<div class="col-sm-2"><label>Sub Group Name<font color="red">*</font></label></div>
			<div class="col-sm-4" id="subGroupId">
				<select name="strSubGroupId" class='custom-select' onchange="itemNameCombo();"> 
					<option value="0">All</option>
				</select>
			</div>

			<div class="col-sm-2" ><label>Item Name<font color="red">*</font> </label></div>
			<div class="col-sm-4" id="ItemId">
				<select name="strItemId" class='custom-select'>
					<option value="0">All</option>
				</select>
			</div>
		</div>
		
		<div class="row " style="margin: 1% 12%;">
			<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
			<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${itemWiseConsumptionRptFB.strCurrentDate}" />
			</div>
		
			<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
			<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${itemWiseConsumptionRptFB.strCurrentDate}" />
			</div>
		</div>	

<%-- 	<div id="DateDivId" style="display: block;">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>
				<td class="LABEL" width="50%"><font color="red">*</font>From
				Date</td>
				<td class="CONTROL" width="50%"><dateTag:date name="strFromDate"
					value="${itemWiseConsumptionRpt.strCtDate}"></dateTag:date></td>
			</tr>
			<tr>
				<td class="LABEL" width="50%"><font color="red">*</font>To Date</td>
				<td class="CONTROL" width="50%"><dateTag:date name="strToDate"
					value="${itemWiseConsumptionRpt.strCtDate}"></dateTag:date></td>
			</tr>
		</table>
	</div>

	<div id="YearDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>From
			Year</td>
			<td class="CONTROL" width="50%"><input type="text"
				name="strFromYear" maxlength="4" class="txtFldMin" value=""
				onkeypress="return validateData(event,5);"></td>
		</tr>
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>To Year</td>
			<td class="CONTROL" width="50%"><input type="text"
				name="strToYear" maxlength="4" class="txtFldMin" value=""
				onkeypress="return validateData(event,5);"></td>
		</tr>
	</table>
	</div>
 --%>
		<div class="row " style="margin: 1% 12%;">
		 	<div class="col-sm-2 "><label>Report Format<font color="red">*</font></label></div>
			<div class="col-sm-4">
				<select name="strReportFormat"  class="custom-select" onChange="">
					<option value="html">HTML</option>
					<option value="pdf">PDF</option>
			    </select>		
			</div>
		
			<%-- <div class="col-sm-2 "><label>Footer Required<font color="red">*</font></label></div>
			<div class="col-sm-4 p-2">
				<html:checkbox property="strIsFooter" name="itemWiseConsumptionRpt" value="1"></html:checkbox>
			</div>
			 --%>
			<div class="col-sm-2"><label>User Remarks<font color="red">*</font></label></div>
			<div class="col-sm-4">
				<textarea name="strUserRemarks" class="form-control" rows="1"  style="height:38px;" onkeyup="maxLengthRemarks(this,'500')" ></textarea>
			</div>
		</div>
		
		<hr>
		
		<div class="row text-right">
	    	<div class="col">
	    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
	    	</div>
		</div>
			
		<input type="hidden" name="hmode" />
		<input type="hidden" name="strCtDate" value="${itemWiseConsumptionRpt.strCtDate}" />
	
	</div>
</div>


</html:form>

	<script type="text/javascript">
	    $('#datepicker1').datepicker({modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	    $('#datepicker2').datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	    var today=new Date();
	    var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	    var mmm=arr[today.getMonth()];
	    var hrs=today.getHours();
	    var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	    $('#datepicker1').val(dd);
	    $('#datepicker2').val(dd);
	</script>

<tag:autoIndex></tag:autoIndex>
</body>
</html>