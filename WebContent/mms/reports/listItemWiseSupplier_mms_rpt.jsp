<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Rate Contract Details</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href=".../../css/newlayout.css" rel="stylesheet" type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
	
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script type="text/javascript">

/*function validate(){

	var hisValidator = new HISValidator("listItemWiseSupplierRpt");

	hisValidator.addValidation("strItemCategoryNo", "dontselect=0","Please Select Item Category");
	hisValidator.addValidation("strSupplierId", "dontselect=-1","Please Select Supplier Name");
	hisValidator.addValidation("strhospCmb","dontselect=0","Please Select Hospital  Name");

	if(document.getElementsByName("strActiveOrNearExpiry")[1].checked == true)
	{
		hisValidator.addValidation("strFrmExpiryDays", "req","Expiry days is a mandatory field");
			
	}
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if(retVal)
	{
	
		if( parseInt(document.getElementsByName("strFrmExpiryDays")[0].value) ==0)
		{
			alert("Please select the Expiry Days > 0");
			document.getElementsByName("strFrmExpiryDays")[0].focus();
			return false;
		}	
	
			document.forms[0].hmode.value = "SHOWRPT";
			document.forms[0].target = "_self";
			document.forms[0].target = "_blank";
			document.forms[0].submit();
	}
	else
	{
		return false;
	}
	
}*/

function validate(){
	var hisValidator = new HISValidator("listItemWiseSupplierRpt");

	hisValidator.addValidation("strItemCategoryNo", "dontselect=0","Please Select Item Category");
    //hisValidator.addValidation("strSupplierId", "dontselect=0","Please Select an Supplier Name");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal){
			
	 	document.forms[0].strItemCategoryName.value = document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].text;
	 	document.forms[0].strGroupName.value = document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].text;
	 	document.forms[0].strSupplierName.value = document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
 
	  	var hmode = "SHOWRPTNEW"; 
	  	
		var url = "ListItemWiseSupplierRptCNT.cnt?hmode="+hmode+
		"&strItemCatId="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value+
		"&strItemCategoryName="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].text+
		"&strGroupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
		"&strGroupName="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].text+
		"&strSupplierId="+document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value+
		"&strSupplierName="+document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
		/*"&strFromDate="+document.forms[0].strFromDate.value+
		"&strToDate="+document.forms[0].strToDate.value;*/
	
		alert(url);		
	 	
		ajaxFunction(url,"4");
	
	}else{
		return false;
	} 
 }

function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onLoadPage(){

	document.getElementsByName("strActiveOrNearExpiry")[0].checked = true;

	document.forms[0].strItemCategoryNo.value = "0";
}

function groupNameCombo()
{
   var mode ="GROUPNAME";  
   var url="ListItemWiseSupplierRptCNT.cnt?hmode=GROUPNAME&itemCatNo="+document.forms[0].strItemCategoryNo.value;
   ajaxFunction(url,"1");
} 

function subGroupNameCombo()
{
   var mode ="SUBGROUPNAME";  
   var url="ListItemWiseSupplierRptCNT.cnt?hmode=SUBGROUPNAME&groupId="+document.forms[0].strGroupId.value+
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
		  objVal.innerHTML = "<select name ='strGroupId' class='browser-default custom-select' onChange='subGroupNameCombo();'>" + res + "</select>";
		  
        }
        subGroupNameCombo();
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
		  objVal.innerHTML = "<select name ='strSubGroupId' class='browser-default custom-select' onChange='itemNameCombo()'>" + temp[0] + "</select>";
		   
		  objVal= document.getElementById("ItemId");
		  objVal.innerHTML = "<select name ='strItemId' class='browser-default custom-select' >" + temp[1] + "</select>";
		     
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
		    objVal.innerHTML = "<select name ='strItemId' class='browser-default custom-select' >" + res + "</select>";
		   
        }
    }
     if(mode=="4"){ 
 		objVal = document.getElementById("rateContractRptDiv");
 		objVal.style.display = "block";
 		//alert(res);
 		 objVal.innerHTML = res;
 		 /*document.getElementById("strStoreId").disabled = true;
 		 document.getElementById("strItemCatNo").disabled = true;
 		 document.getElementById("strFromDate").disabled = true; 
 		 document.getElementById("strToDate").disabled = true;	*/
 	}	
}

function getExpiryDays()
{
	if(document.getElementsByName("strActiveOrNearExpiry")[0].checked == true)
		document.getElementById("expDaysDiv").style.display = 'none';
	else
			document.getElementById("expDaysDiv").style.display = '';
}

function controlToMainPage()
{	    
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
}

/*function printReport() 
{
	document.getElementById("printImg").style.display="none"; 
    const contentToPrint = document.getElementById("rateContractRptDiv").cloneNode(true);
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
//    newWin.document.write('  #toolbar { display: none; }');
//    newWin.document.write('  body { margin: 0; padding: 0; }');
//    newWin.document.write('  @page { margin: 4mm 3mm; size: A4 portrait; }');
//    newWin.document.write('  table { table-layout: fixed; width: 100%; }');
    newWin.document.write('  table {border-collapse: collapse; }');
//    newWin.document.write('  table td { word-wrap: break-word; font-size: 12px; }');

    // Define page break rules for the repeat-table class
//     newWin.document.write('.repeat-table { page-break-before: always; }');

    newWin.document.write('}');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();
    newWin.onload = function () {
        newWin.print();
        newWin.close();
        document.getElementById("printImg").style.display="block"; 
    };
} */

function printReport() {
    document.getElementById("printImg").style.display = "none";
    const contentToPrint = document.getElementById("rateContractRptDiv").cloneNode(true);
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');

    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
    // Customize CSS for printing if needed
    newWin.document.write('  table {border-collapse: collapse; }');
    newWin.document.write('}');
    newWin.document.write('</style>');
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();

    newWin.onload = function () {
        newWin.print();
        newWin.close();
        document.getElementById("printImg").style.display = "block";
    };
}



</script>

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}
.container{
	max-width:1395px;
}
.table th, .table td {
	padding: 0.05rem;
}

.form-control {
	color: rgba(0, 0, 0, 1);
}

.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(0, 0, 0, 1);
}

.prescriptionTile {
	margin: 0.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(0, 0, 0, 1);
}

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
}

.row {
	padding-bottom: 5px;
}

.legend2 {
	position: absolute;
	top: -2.5em;
	right: 44px;
	line-height: 1.2em;
}

.cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
}

.btn-circle {
	width: 37px;
	height: 34px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 17px;
	color: white;
	float: right;
}

.iround {
	color: white;
	font-size: 16px;
}

.btn-outline-success {
	color: #28a745;
	border-color: #28a745;
	background-color: #28a745;
}
</style>

</head>
<body onload="onLoadPage();">
<html:form action="/reports/ListItemWiseSupplierRptCNT" name="listItemWiseSupplierRpt" type="mms.reports.controller.fb.ListItemWiseSupplierRptFB" method="post">
	
<div class="errMsg" id="errMsg"         style="font-size:16px;"><bean:write name="listItemWiseSupplierRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"   style="font-size:16px;"><bean:write name="listItemWiseSupplierRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg" style="font-size:16px;"><bean:write name="listItemWiseSupplierRpt" property="strWarningMsg"/></div>
<br>
		<div class="container-fluid">
			<div class="prescriptionTile" align="center">
				<div class="row">
					<div class="col-sm-6" style="text-align: initial;">
						<p class="subHeaders">
							<i class="fas fa-file-alt iround"
								style="font-size: 20px; color: #28a745" title=""></i>
							&nbsp; Rate Contract Details
						</p>
					
					</div>
					
					<div class="col-sm-6">
						<div class="legend2" id='nonPrintableLegend2'>
							<button type="button"
								class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
								onclick="cancelFunc();">
								<i class="fas fa-times iround" title="Cancel"></i>
							</button>
							<button type="button" class=" btn btn-secondary btn-circle"
								onclick="document.forms[0].reset();"
								style="background: royalblue; border-color: #b9b9b9; margin-top: 0.25rem !important;">
								<i class="fas fa-broom iround" title="Clear"></i>
							</button>

							<button type="button" id="saveid"
								class="float-right btn btn-outline-success mt-1 btn-circle savebtn"
								tabindex='2' onclick='return validate();'>
								<i class="fas fa-download iround" title="Save"></i>
							</button>
						</div>
					</div>
				</div>
			<div class="container">
					<div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>Item Category</label>
						</div>
						<div class="col-sm-3">
							<select name="strItemCategoryNo" class="browser-default custom-select" onChange="groupNameCombo();">
								<bean:write name="listItemWiseSupplierRpt" property="strItemCategoryCombo" filter="false" />
							</select>
						</div>
						<div class="col-sm-3" align="right">
							<label>Group Name</label>
						</div>
						<div class="col-sm-3" align="left" >
							<div id="groupId">
								<select name="strGroupId" class="browser-default custom-select" onchange="subGroupNameCombo();">
									<option value="0">All</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>Item Name</label>
						</div>
						<div class="col-sm-3">
							<div id="ItemId">
								<select name="strItemId" class="browser-default custom-select">
									<option value="0">All</option>
								</select>
							</div>
						</div>
						<div class="col-sm-3" align="right">
							<label><font color="red">*</font>Supplier Name</label>
						</div>
						<div class="col-sm-3" align="left" >
							<div id="strStoreDivId">
								<select name="strSupplierId" class="browser-default custom-select">
									<bean:write name="listItemWiseSupplierRpt" property="strManufactureCombo" filter="false" />
								</select>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>Type</label>
						</div>
						<div class="col-sm-3">
							<div id="TypeId">
								<select name="strTypeId" class="browser-default custom-select">
									<option value="1">For Active Records</option>
									<option value="2">Expiring within 90 Days</option>
									<option value="3">Expired RC</option>
								</select>
									
							</div>
						</div>
						<div class="col-sm-3" align="right">
							<!-- <label>Day(s)</label> -->
						</div>
						<div class="col-sm-3" align="left" >
							<!-- <input class="form-control" type="text" name="strFrmExpiryDays" onkeypress="return validateData(event,5);" value="90" maxlength="3"> -->
						</div>
					</div>
					
                <!--   <div class="row">
						<div class="col-sm-3">
							<label>Report Format</label>
						</div>
						<div class="col-sm-3">
							<select name="strReportFormat" onchange=""
								class="browser-default custom-select">
								<option value="html">Html</option>
								<option value="pdf">Pdf</option>
								<option value="xls">Excel</option>
							</select>
						</div>
						<div class="col-sm-3">
							<label>User Remarks</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="strUserRemarks">
						</div>
					</div> -->
					
					<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
						<tr style="display: none;" >
							<td class="LABEL" colspan="4">
								<input type="radio" name="strActiveOrNearExpiry"    value="1" onclick="getExpiryDays();">Active
								<input type="radio" name="strActiveOrNearExpiry" value="2" onclick="getExpiryDays();">Near Expiry
							</td>
						</tr>
						<tr style="display: none;">
							<td colspan="1" class="LABEL">
									<font color="red">*</font>Hospital Name	
							</td>
							<td colspan="3" class="CONTROL">
								<select name="strhospCmb" class="comboMax" ">
										<bean:write name="listItemWiseSupplierRpt" property="strhospCmb" filter="	false" />
								</select>
							</td>
						</tr>
					
						<tr style="display: none;">
							<td colspan="2" class="LABEL">
								Sub Group Name		
							</td>
							<td colspan="2" class="CONTROL">
								<div id="subGroupId" >
								<select name="strSubGroupId" class="comboNormal" onChange="itemNameCombo();">
										<option value="0">All</option>
								</select></div>
							</td>
						</tr>
				
						<tr id="expDaysDiv" style="display:none;">
					        <td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Expiry Days</td>			        
							<td width="50%" colspan="2" class="CONTROL">
					              <input class="txtFldNormal" type="text" name="strFrmExpiryDays" onkeypress="return validateData(event,5);" maxlength="3" >
						    </td>				    
						    
					    </tr>
						
						<tr style="display: none;">
							<td width="50%" colspan="2" class="LABEL">
							Footer Required
							</td>
							<td width="50%" colspan="2" class="CONTROL">
							<html:checkbox property="strIsFooter" name="listItemWiseSupplierRpt" value="1"></html:checkbox>
							</td>
						</tr>
					</table>
	<hr>
			<div class="col-sm-12 text-right">
    			<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
    		</div>

			<div align="center" id="rateContractRptDiv"></div>

			<input type="hidden" name="hmode"/>
			<input type="hidden" name="strItemCategoryName" value=""/>
			<input type="hidden" name="strGroupName" value=""/>
			<input type="hidden" name="strSupplierName" value=""/>
			
		</div>
	</div>
</div>

</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>