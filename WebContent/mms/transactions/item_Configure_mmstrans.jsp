<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>
<%@ taglib uri="/WEB-INF/onLineReqDiscountDtl.tld" prefix="DisDtl"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 18/June/2009
 * 
 */
-->
<html>
<head>
<meta charset=UTF-8">
<title>Item Search Engine</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">


<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<!-- EXT_JS -->
<script language="Javascript" src="../js/ItemConfigureTrans.js"></script>

<style type="text/css">

[class*="col-"] {
  width: 100%;
}

@media only screen and (min-width: 600px) {
  /* For tablets: */
  .col-s-1 {width: 8.33%;}
  .col-s-2 {width: 16.66%;}
  .col-s-3 {width: 25%;}
  .col-s-4 {width: 33.33%;}
  .col-s-5 {width: 41.66%;}
  .col-s-6 {width: 50%;}
  .col-s-7 {width: 58.33%;}
  .col-s-8 {width: 66.66%;}
  .col-s-9 {width: 75%;}
  .col-s-10 {width: 83.33%;}
  .col-s-11 {width: 91.66%;}
  .col-s-12 {width: 100%;}
}
@media only screen and (min-width: 768px) {
  /* For desktop: */
  .col-1 {width: 8.33%;}
  .col-2 {width: 16.66%;}
  .col-3 {width: 25%;}
  .col-4 {width: 33.33%;}
  .col-5 {width: 41.66%;}
  .col-6 {width: 50%;}
  .col-7 {width: 58.33%;}
  .col-8 {width: 66.66%;}
  .col-9 {width: 75%;}
  .col-10 {width: 83.33%;}
  .col-11 {width: 91.66%;}
  .col-12 {width: 100%;}
}
.col-sm-1half, .col-sm-8half, .col-sm-half {
    position: relative;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}

@media (min-width: 768px) {
    .col-sm-1half, .col-sm-8half {
        float: left;
    }
    .col-sm-1half {
        width: 12.495%;
    }
    .col-sm-half {
        width: 4.165%;
    }
    .col-sm-2half {
        width: 20.495%;
    }
}
</style>
<style type="text/css">
	.btn-info
	{
	background-color:#3ac9d6;
	border:none;
	}
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

<!-- ------------------------------------------------- -->

<script type="text/javascript">

function print_div()
{
 var printContent1 = document.getElementById('printDiv');
 var printContent = document.getElementById('tableDiv');
 var printContent2 = document.getElementById('totalDiv');
 var WinPrint = window.open('', '', 'width=800,height=650');
 WinPrint.document.write(new Date());
 
 WinPrint.document.write(printContent1.innerHTML);
 WinPrint.document.write(printContent.innerHTML);
 WinPrint.document.write(printContent2.innerHTML);
 WinPrint.document.close();
 WinPrint.focus();
 WinPrint.print();
 WinPrint.close();
}

$(function() {    
	
	var itemList = [];
	$('#strMultiRowItemId option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value });
	});
	$('strSearchDrug').keyup(function(e){
		if(e.keyCode == 13)
	    {
	    	$(this).trigger("enterKey");
	        getDrugNameSelected(suggestion.data);
	    }
	});
	//alert(itemList.length);
	
	$('#strSearchDrug').autocomplete({
		   lookup: itemList,
		   minChars:3,
		   onSelect: function (suggestion) { 
			  // alert(suggestion.data);
		     getDrugNameSelected(suggestion.data);	    
		   }	    
		 });
		 
		 $('#strSearchDrug').click(function(){	 
		 	$(this).val("");
		 	closeAllDrugProfile();
		 });	

		 $("#strSearchDrug").focus();
	
  });
  
function handleEnter(obj,eve)
{
	document.getElementById("label2").innerHTML=document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].text;
	//alert("before 13");
	if(eve.keyCode == 13)
	{
		//alert("13");
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
		
	}
}

$( document ).ready(function() {
	//document.getElementById("sysdate").innerHTML= new Date().toDateString();
	var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	
 	n =  new Date();
	y = n.getFullYear();
	m = n.getMonth() + 1;
	d = n.getDate();
	document.getElementById("sysdate").innerHTML = d + "/" +months[n.getMonth()] + "/" + y; 
});
 
</script>

</head>
<body>
<html:form action="/transactions/ItemConfigurationTransCNT.cnt" name="itemConfigureBean" type="mms.transactions.controller.fb.ItemConfigurationTransFB" method="post" >
<div class="container-fluid">
		<div class="prescriptionTile">
			
  
 <legend style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400;color: #666;" id='nonPrintableLegend'>
 	<i class="fa fa-search" style="font-size: 20px;" aria-hidden="true"></i>
 	Item Configuration
 </legend>
 
 <div class="legend2" id='nonPrintableLegend2'>
	<button type="button"
		class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
		onclick="cancelFunc();" style="border-radius:50%; padding:12px 12px;">
		<i class="fas fa-times fa-lg" title="Cancel"></i>
	</button>		

 </div>

<div id="nonPrintable">
	<div class="errMsg" id="errMsg" style="font-size:18px;"><bean:write name="itemConfigureBean" property="strErrorMsg" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="itemConfigureBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:18px;"><bean:write name="itemConfigureBean" property="strNoramalMsg" /></div>

<div class="container">
	<div class="row" style="margin:1% 5%">
		<div class="col text-left" ><label id="sysdate"></label></div>
	</div>
	<div class="row" style="margin:1% 5%">
		<div class="col-sm-2"><label>Category :<font class="fontred" style="color:red;">*</font></label></div>
		<div class="col-sm-4">
			<div id="itemCategoryDivId" align="left">
				<html:radio property="strItemCategoryNo" name="itemConfigureBean" value="1" onclick="getStoreList(this);" >&nbsp;Drug</html:radio>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<html:radio property="strItemCategoryNo" name="itemConfigureBean" value="2" onclick="getStoreList(this);" >&nbsp;Item</html:radio>

		  	</div>
	  	</div>
	  	
		<div class="col-sm-2"><label>Store Name :<font class="fontred" style="color:red;">*</font></label></div>
		<div class="col-sm-4 ">
			<div id="strStoreDivId" align="left" >
				<select name="strStoreId" class="form-control" onChange="itemCombo(this);" onclick="itemCombo(this);">
					<bean:write name="itemConfigureBean" property="strStoreValues" filter="false"/>
				</select>
			</div>	
		</div>
	</div>
	
	<div class="row" style="margin:1% 5%">
		<div class="col-sm-2"><label>Search :<font class="fontred" style="color:red;">*</font></label></div>
		<div class="col-sm-6">
			<div id="itemBrandDivId" style="display: none;">
				<select name="strMultiRowItemId" id="strMultiRowItemId" class="form-control" >
					<bean:write name="itemConfigureBean" property="strItemBrandCombo" filter="false" />
				</select> 
			</div>
			<input type="text" id="strSearchDrug" class="form-control"  placeholder='Enter atleast 3 characters' name="strSearchDrug" size="140%" onkeypress="handleEnter(this,event);"/>	
		</div>
		<div class="col-sm-4">
			<button type="button" id="btnPreID" class="btn btn-info btn-lg" onclick="validate1();">
	           	<i class="fa fa-search" style="font-size: 20px; width:90px;" aria-hidden="true">
	           	</i>
	       	</button>
	    </div>
	</div>
</div>	 

	 <div id="printDiv" align="left" class="collapse show">
		 <div class="row" id="row1" style="visibility: hidden; margin:1% 5%;">  
		 	<div class="col-sm-6" align="left">
		 		<label><font class="text-primary">Store Name:</font></label>&nbsp;<font class="text-primary"><label id="label1"></label></font>
		 	</div>
		 	<div class="col-sm-6" align="left">
				<font class="text-primary"><label>Item Name:</label></font>&nbsp;<font class="text-primary"><label id="label2"></label></font>
			</div>
		 </div>
	</div>
	 
	<div id="itemsDetailsId" class="collapse show" style="visibility: hidden;">

	</div>
	

	<div id='generic' style='display:none;'></div>
	
	<div id="strBatchDivId" style="display: none;">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
			<tr>
				<td width="50%" class="LABEL">
					Batch No		
				</td>
				<td width="50%" class="CONTROL" colspan="3">
					<div id="batchNoId"><select name="strBatchNo" class='comboMax'>
							<bean:write name="itemConfigureBean" property="strBatchNoCmb" filter="false" />
							<option value="0">Select Value</option>
					</select></div>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="strBatchItemDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL">
			Item Serial No		
		</td>
		<td width="50%" class="CONTROL" >
			<div id="itemSlNoId"><select name="strItemSlNo" class='comboMax'>
					<bean:write name="itemConfigureBean" property="strItemSlNoCmb" filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	</table>
	</div>					
	
	<div id="StockDtlDivId" style="display: none;">
	</div>
	
	 <div class='popup' id='avlQtyId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpAvlQtyId"></div></th>
				<th align='right'>
				<a href="#" class="button" onclick="closeAvlQtyPopUp('avlQtyId');"><span class="cancel">Cancel</span></a>
				</th>
		    </tr>
		 </table>  

		 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Reserved Qty</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Blocked Qty</td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	    </div>

		<div class="row" align="center" >
		<div class="col">
            <!--  <button type="button" id="btnExport" class="btn btn-info" style="visibility: hidden;" onclick="exportToExcel('example', 'user-data');"> -->
            <button type="button" id="btnExport" class="btn btn-info" style="visibility: hidden;" onclick="saveRecord();">
				<i class="fa fa-file-excel-o" style="font-size: 20px;" aria-hidden="true"></i>
					SAVE RECORD
	 		</button>
		</div>
	</div>
</div> 		
		
<input type="hidden" name="hmode"/>

</div>
</div>

</html:form>
	
</body>
</html>