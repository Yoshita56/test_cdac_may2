<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>

<head>
	<title>Return Request Detail Report</title>

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

<!--CSS-->
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	

<!--JS-->	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<!--JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!--BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!--JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<script type="text/javascript">


function getAjaxResponse(res,mode)
{
	if(mode=="1")
	{ 
		
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatId' class='custom-select' onChange='getReqTypeCmb();'>"+res+"</select>";		
	}	

	if(mode=="2")
	{ 
		var objVal= document.getElementById("reqDivId");
		objVal.innerHTML = "<select name ='strReqTypeId'    class='custom-select'  onChange='getIssueStoreCmb();'>"+res+"</select>";		
	}	
	if(mode=="3")
	{ 
		var objVal= document.getElementById("returnreqRpt");
		objVal.style.display = "block";	
		objVal.innerHTML = res; 
	}	
	if(mode=="4")
	{ 
		var objVal= document.getElementById("issuingStoreId");
		objVal.innerHTML = "<select name ='strIssuingStoreId'    class='custom-select'  >"+res+"</select>";		
	}	
	
}
function getReport(){
			var hisValidator = new HISValidator("listofNARpt");
			
	     	hisValidator.addValidation("strStoreId", "dontselect=-1","Select Store From Store Combo");
		    document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

			hisValidator.addValidation("strItemCatId", "dontselect=-1","Select Item Category From Item Category Combo");
		
			var retVal = hisValidator.validate();
		// alert(document.forms[0].strIsMisc.checked);
		
			hisValidator.clearAllValidations();
			if(retVal){ 
				var hmode = "SHOWRPT"; 
				var url = "ListofNARptCNT.cnt?hmode="+hmode+
							"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
							"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+							
							"&strCategoryId="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].value+
							"&strCategoryName="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].text+
							"&strFromDate="+document.forms[0].strFromDate.value+
							"&strToDate="+document.forms[0].strToDate.value+
							"&reqTypeId="+document.forms[0].strReqTypeId[document.forms[0].strReqTypeId.selectedIndex].value+
							"&reqTypeName="+document.forms[0].strReqTypeId[document.forms[0].strReqTypeId.selectedIndex].text+
							"&issuingStoreId="+document.forms[0].strIssuingStoreId[document.forms[0].strIssuingStoreId.selectedIndex].value+
							"&issuingStoreName="+document.forms[0].strIssuingStoreId[document.forms[0].strIssuingStoreId.selectedIndex].text;
							
			                ajaxFunction(url,"3");
	}
	else
		{
         return false;
		}		
	}
	
function getItemCatCmb()
{ 
		if(document.forms[0].strStoreId.value!=0)
		{
			var url ="ListofNARptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}
		else
	 	{
		document.forms[0].strItemCatNo.value="0";
	    }
}
function getReqTypeCmb()
{ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatId.value!=0 )
	{
		var url ="ListofNARptCNT.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatId.value;
 		ajaxFunction(url,"2");
 	}
	else
	{
	   document.forms[0].strItemCatId.value="0";
    }
}
function getIssueStoreCmb()
{ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatId.value!=0 && document.forms[0].strReqTypeId.value!=0 )
	{
		var url ="ListofNARptCNT.cnt?hmode=ISSUE_STORE_LIST&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatId.value+"&reqId="+document.forms[0].strReqTypeId.value;
 		ajaxFunction(url,"4");
 	}
	else
	{
	 
	   document.forms[0].strReqTypeId.value="0";
	   document.forms[0].strItemCatId.value="0";
    }
}


	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
}

function onLoadpage()
{
	document.forms[0].strItemCatId.value = "0";
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strReqTypeId.value="0";
	document.forms[0].strIssuingStoreId.value="0";	
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
    document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
    document.getElementById('returnreqRpt').innerHTML = "";    

}
function printDataOne() 
{
	    document.getElementById('printImg').style.display = "none";    

		newwin = window.open('', 'printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
		newwin.document.write('<HTML><HEAD>');
		newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
		newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n');
		newwin.document.write('<script>\n');
		newwin.document.write('function chkstate(){ \n');
		// newwin.document.write('if(document.readystate=="complete" ||
		// document.readystate=="undefined"){\n');
		newwin.document.write('window.close();\n');
		// newwin.document.write('}\n');
		// newwin.document.write('else{\n');
		// newwin.document.write('setTimeout("chkstate()",2000)\n');
		// newwin.document.write('}\n');
		newwin.document.write('}\n');
		newwin.document.write('function print_win(){\n');
		newwin.document.write('window.print();\n');
		newwin.document.write('chkstate();\n');
		newwin.document.write('}\n');

		newwin.document.write('<\/script>\n');
		newwin.document.write('</HEAD>\n');
		newwin.document.write('<BODY onload="print_win()">\n');
		//alert(document.getElementById('issueDtlsDivId').innerHTML);
		newwin.document.write(document.getElementById('returnreqRpt').innerHTML);
		newwin.document.write('</BODY>\n');
		newwin.document.write('</HTML>\n');
		newwin.document.close();
}





</script>
</head>

<body onload="onLoadpage();">
<html:form action="/reports/ListofNARptCNT" method="post">
	
<div class="errMsg" id="errMsg" style="font-size:18px;"><bean:write name="listofNARpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg" style="font-size:18px;"><bean:write name="listofNARpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="listofNARpt" property="strWarningMsg"/></div>
	<!--<tag:tab tabLabel="Issue To Patient Report"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>-->

<div class="container-fluid">
	<div class="prescriptionTile">
		
	<div class='legendHeader' style='font-size: 16px;font-weight: bold;'>
		<i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;NA List Report</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel"  class="float-right btn btn-danger mt-1 btn-icon "style="border-radius:50%; padding:11px 12px" onClick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times " title="Cancel"></i>
					</div>
				</button>
				
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon " style="background-color: #2196f3; border-radius:50%; padding:11px 9px" onClick="onLoadpage();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom " title="Clear"></i>
					</div>
				</button>		
				
				<button  type="button" title="Generate" class="float-right btn btn-success mt-1 btn-icon"  style="border-radius:50%; padding:11px 11px;" tabindex='2' onClick="getReport();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download " title="Generate"></i>
					</div>
				</button>
 			</div>  
		</div>
		
	<div class="container">	

		
		<div class="row" style="margin:1% 5%;">
			<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
			<div class="col-sm-4" id="storeDivId"> 
				<select name="strStoreId" class='custom-select' onchange="getItemCatCmb();"> 
					<bean:write name="listofNARpt" property="strStoreCmb" filter="false" />
				</select>
			</div>

			<div class="col-sm-2 "><label>Category<font color="red">*</font></label></div>
			<div class="col-sm-4" id="itemCatDivId">
					<select name="strItemCatId"  class="custom-select" onChange="getReqTypeCmb();" >
					    <bean:write name="listofNARpt" property="strItemCategCmb" filter="false" />
						<option value="0">Select Value</option>
				    </select>		
			</div> 			
		</div>
		
		<div class="row" style="margin:1% 5%;">
			<div class="col-sm-2 "><label>Request Type<font color="red">*</font></label></div>
			<div  class="col-sm-4" id="reqDivId">
				<select	name="strReqTypeId"  class="custom-select">
					<option value="0">SelectValue</option>
				</select>
			</div>
			<div class="col-sm-2 "><label>Issuing Store<font color="red">*</font></label></div>
			<div  class="col-sm-4" id="issuingStoreId">
				  <select	name="strIssuingStoreId"  class="custom-select">
					<option value="0">SelectValue</option>
				 </select>
			</div>
			
					
		</div>
		
		
		
		<div class="row" style="display:none; margin:1% 5%;">
			<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
			
				<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${listofNARpt.strCurrentDate}" />
	 				<%-- <dateTag:date name="strFromDate" value="${breakageAndLostDrugDetailsRptFB.strCurrentDate}" /> --%>
			</div>
		
		
			<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
				<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${listofNARpt.strCurrentDate}" />
			</div>
		</div>	
	</div>
		 
<hr>
	<div class="row text-right" style="display:none;">
    	<div class="col-sm-12">
    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
    	</div>
	</div>

<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strCategoryName" value=""/>
<input type="hidden" name="strCategoryCode" value=""/>
<input type="hidden" name="strCurrentDate" value="${listofNARpt.strCurrentDate}" />

<div align="center" id="returnreqRpt"></div>


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