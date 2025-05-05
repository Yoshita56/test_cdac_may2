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


function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='comboNormal' onChange=' ' >"+res+"</select>";		
	}	

	if(mode=="2"){ 
		var objVal= document.getElementById("reqDivId");
		objVal.innerHTML = "<select name ='strReqTypeId' class='comboNormal'>"+res+"</select>";		
	}	
	if(mode=="3"){ 
		var objVal= document.getElementById("returnreqRpt");
		objVal.style.display = "block";
		//alert(res);
		objVal.innerHTML = res; 
	}	
	
}
function getReport(){
			var hisValidator = new HISValidator("ReturnItemListingRPT");
			
	     	hisValidator.addValidation("strStoreId", "dontselect=-1","Select Store From Store Combo");
		    document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

			hisValidator.addValidation("strItemCatId", "dontselect=-1","Select Item Category From Item Category Combo");
		
			var retVal = hisValidator.validate();
		// alert(document.forms[0].strIsMisc.checked);
		
			hisValidator.clearAllValidations();
			if(retVal){ 
				var hmode = "SHOWRPT"; 
				var url = "ReturnItemListingCNT_NEW.cnt?hmode="+hmode+
							"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
							"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+							
							"&strCategoryId="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].value+
							"&strFromDate="+document.forms[0].strFromDate.value+
							"&strToDate="+document.forms[0].strToDate.value+
							"&strCategoryName="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].text;
							
			                ajaxFunction(url,"3");
	}
	else
		{
         return false;
		}		
	}
	
function getItemCatCmb(){ 
		if(document.forms[0].strStoreId.value!=0){
			var url ="ItemListingRPTCNT_NEW.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		document.forms[0].strItemCatNo.value="0";
	}
}
function getReqTypeCmb(){ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatNo.value!=0 ){
		var url ="ItemListingRPTCNT_NEW.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 	}else{
	document.forms[0].strItemCatNo.value="0";
}
}
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
}

function onLoadpage(){
	document.forms[0].strItemCatNo.value = "0";
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
    document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
}

function printDataOne(mode) 
{
	var x = document.getElementById("printImg");
	x.style.display = "none";
	
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
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
	if(mode=='1')
	{
	newwin.document.write(document.getElementById('returnreqRpt').innerHTML);	
	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
	 //document.getElementById("strCrNo").focus();
}

</script>
</head>

<body onload="onLoadpage();">
<html:form action="/reports/ReturnItemListingCNT_NEW" method="post">
	
<div class="errMsg" id="errMsg" style="font-size:18px;"><bean:write name="ReturnItemListingRPT" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg" style="font-size:18px;"><bean:write name="ReturnItemListingRPT" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="ReturnItemListingRPT" property="strWarningMsg"/></div>
	<!--<tag:tab tabLabel="Issue To Patient Report"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>-->

<div class="container-fluid">
	<div class="prescriptionTile">
		
	<div class='legendHeader' style='font-size: 16px;font-weight: bold;'>
		<i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Return Request Report</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel"  class="float-right btn btn-danger mt-1 btn-icon "style="border-radius:50%; padding:10px 12px" onClick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times " title="Cancel"></i>
					</div>
				</button>
				
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon " style="background-color: #2196f3; border-radius:50%; padding:10px 9px" onClick="document.forms[0].reset();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom " title="Clear"></i>
					</div>
				</button>		
				
				<button  type="button" title="Generate" class="float-right btn btn-success mt-1 btn-icon"  style="border-radius:50%; padding:10px 10px;" tabindex='2' onClick="getReport();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download" title="Generate"></i>
					</div>
				</button>
 			</div>  
		</div>
		
	<div class="container">	
		<div class="row" style="margin: 1% 12%">
				<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
				<div class="col-sm-4" id="storeDivId"> 
						<select  name="strStoreId" class='custom-select' onchange=""> 
							<bean:write name="ReturnItemListingRPT" property="strStoreCmb" filter="false" />
						</select>
				</div>
				
			
				<div class="col-sm-2 "><label>Category<font color="red">*</font></label></div>
				<div class="col-sm-4" id="itemCatDivId">
						<select  name="strItemCatId"  class="custom-select" onChange="">
							<bean:write name="ReturnItemListingRPT" property="strItemCategCmb" filter="false" />
					    </select>		
				</div>
		</div>
		
		<div class="row " style="margin: 1% 12%">
			<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
			
				<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${ReturnItemListingRPT.strCurrentDate}" />
	 				<%-- <dateTag:date name="strFromDate" value="${breakageAndLostDrugDetailsRptFB.strCurrentDate}" /> --%>
			</div>
		
		
			<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
				<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${ReturnItemListingRPT.strCurrentDate}" />
			</div>
		</div>	
	</div>
		 
<hr>
	<div class="row text-right">
    	<div class="col-sm-12">
    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
    	</div>
	</div>

<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${ReturnItemListingRPT.strCurrentDate}"/>

<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strCategoryName" value=""/>
<input type="hidden" name="strCategoryCode" value=""/>
<input type="hidden" name="strCurrentDate" value="${New_Report_For_Acknowledgebean.strCurrentDate}" />

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