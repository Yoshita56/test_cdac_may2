<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<html>
<head>
<meta charset="UTF-8">
<title>Item Tender Upload Document</title>
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script>
function convertPdfToBase64_ID() {
	try {
	    var fileInput = document.getElementById("Ins_Doc");
	    
	    var filePath = fileInput.value; 
	    var allowedExtensions = /(\.pdf)$/i;
	    
	    if (!allowedExtensions.exec(filePath)) {
	        alert('Invalid file type. Only PDF is allowed.');
	        fileInput.value = '';
	        return false;
	      }
	    
	    var fileSize = fileInput.files[0].size; 
	    var maxSize = 1024 * 1024; //1MB
	    
	    if (fileSize > maxSize) {
	        alert('File size exceeds the maximum limit of 1 MB.');
	        fileInput.value = '';
	        return false;
	      }

	    var file = fileInput.files[0];
	    var reader = new FileReader();
	    reader.onloadend = function() {
	        var base64 = reader.result.replace("data:application/pdf;base64,", "");
	        document.getElementById("strUploadFileIdw4").value = base64;
	    }
	    reader.readAsDataURL(file);
	    document.getElementById("Ins_DocImg").style.display='block';
	}
	catch(e)	{
		 alert("Installation Doc Up-Load Error which shows "+e.message); 
	}    
}
function convertPdfToBase() {
    try {
        var fileInput = document.getElementById("po_Doc");
        var filePath = fileInput.value;
        var allowedExtensions = /(\.pdf)$/i;

        if (!allowedExtensions.exec(filePath)) {
            alert('Invalid file type. Only PDF is allowed.');
            fileInput.value = '';
            return false;
        }

        var fileSize = fileInput.files[0].size;
        var maxSize = 1024 * 1024; // 1MB
        if (fileSize > maxSize) {
            alert('File size exceeds the maximum limit of 1 MB.');
            fileInput.value = '';
            return false;
        }

        var file = fileInput.files[0];
        var reader = new FileReader();

        reader.onloadend = function () {
            try {
                var arrayBuffer = reader.result;
                var uint8Array = new Uint8Array(arrayBuffer);
                var base64 = btoa(String.fromCharCode.apply(null, uint8Array));

                // Replace spaces with '+' in the base64 string
                base64 = base64.replace(/ /g, '+');

               
                document.getElementById("strUploadFileId3").value = base64;
            } catch (e) {
                alert("Error during base64 conversion: " + e.message);
            }
        };

        reader.readAsArrayBuffer(file);
        document.getElementById("po_DocImg").style.display = 'block';
    } catch (e) {
        alert("Installation Doc Up-Load Error which shows " + e.message);
    }
}


function save()	{
	var mode = "SAVE";
        var url ="ItemTenderUploadDocCNT.cnt?hmode="+mode
        +"&strGenericItemId="+document.forms[0].strGenericItemId.value
        +"&strItemId="+document.forms[0].strItemId.value   
        +"&strUploadname1="+document.getElementById("Ins_Doc").files[0].name
        +"&strUploadname2="+document.getElementById("po_Doc").files[0].name
        +"&strUpload1="+document.forms[0].strUploadFileId4.value
        +"&strUpload2="+document.forms[0].strUploadFileId3.value;
		
 		ajaxFunction(url,"2");
}

function getItemCombo()	{
	var mode = "GETITEMNAMECOMBO";
        var url ="ItemTenderUploadDocCNT.cnt?hmode="+mode
        +"&strGenericItemId="+document.forms[0].strGenericItemId.value
        +"&groupCode=0"
        +"&categoryCode=0";
 		ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode)	{
    if(mode=="1")	{
    	document.getElementById("itemCategoryDivId").style.display='';
    	
        var objVal = document.getElementById("itemCategoryDivId");
        objVal.innerHTML = "<select name='strItemCategoryId' name='strItemId' id='strItemId' class='browser-default custom-select' >"+ res +"</select>"	  
    }
    if(mode=="2")	{
    	 var x = document.getElementById("divstatus");
    	 x.style.display = "block";
    }
    
}

function divstatus(){
	 var x = document.getElementById("divstatus");
	 x.style.display = "none";
	 document.forms[0].reset()
}
</script>
<style type="text/css">

.container{
	max-width:1395px;
}
.prescriptionTile {
	margin: 1.5% 0;
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
<body>																								
<html:form name="ItemTenderUploadDocFB" action="/transactions/ItemTenderUploadDocCNT" type="mms.transactions.controller.fb.ItemTenderUploadDocFB">
  <div class="errMsg" id="errMsg"></div>
	<div class="warningMsg" id="warningMsg"></div>
	<div class="normalMsg" id="normalMsg"></div>
  
  
    <div class="alert alert-success" role="alert" style="display: none;" id="divstatus">
	  File Uploaded successfully
	</div>
    
    <div class="container-fluid">
    	<div class="prescriptionTile" align="center">
			<div class="row ">
				<div class="col-sm-6" style="text-align: initial;">
					<p class="subHeaders">
						<i class="fas fa-file-alt iround" style="font-size: 20px; color: #28a745" title=""></i>
							&nbsp; Item Tender Upload Document
					</p>
				</div>
				<div class="col-sm-6" id="">
					<div class="legend2" id='nonPrintableLegend2'>
						<button type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" title="Cancel" onClick="cancelFunc()" onkeypress="if(event.keyCode==13) cancelFunc()">
							<i class="fas fa-times fa-lg iround" title="Cancel"></i>
						</button>
						<button type="button" class="float-right btn btn-secondary btn-circle" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Clear"name="clearImg" onclick="divstatus();" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('INITVAL');">
							<i class="fas fa-broom fa-lg iround" title="Clear"></i>
						</button>
						<button type="button" id="saveid" class="float-right btn btn-outline-success mt-1 btn-circle savebtn" tabindex='2' onclick="return save();" onkeypress="if(event.keyCode==13) validate1();">
							<i class="fa fa-download fa-beat iround" title="Save "></i>
						</button>
					</div>
				</div>
			</div>	
			<div class="row">	
				<div class="col-sm-2 py-2" style="text-align: right;">
					<label><font color="red">*</font>Generic Item Name</label>
				</div>
				<div class="col-sm-4" style="padding-left: 0px;">
					<select name="strGenericItemId" id="strGenericItemId" class="browser-default custom-select" onchange="getItemCombo();">
							<bean:write name="ItemTenderUploadDocFB" property="strDrugWareHouseNameCmb" filter="false" />
					</select>
				</div>	
				<div class="col-sm-2 py-2" style="text-align: right;">
					<label><font color="red">*</font>Item Name</label>
				</div>
				<div class="col-sm-4" style="padding-left: 0px;">
					<div id="itemCategoryDivId">	
						<select name="strItemId" id="strItemId" class="browser-default custom-select">
						    <option>Select Value</option>
							<bean:write name="ItemTenderUploadDocFB" property="strItemCatgCmb" filter="false" />
						</select>
					</div>
				</div>			
			</div>
			<div class="row">	
				<div class="col-sm-2 py-2" style="text-align: right;">
					<label><font color="red">*</font>Tender Doc</label>
				</div>
			        <div class="col-sm-3 custom-file" style="text-align: left;">
				        <input type="file" class="custom-file-input" id="Ins_Doc" onchange="updateFileName()">
				        <label class="custom-file-label" for="Ins_Doc">Choose file</label>
				    </div>
				    <div class="col-sm-1" style="padding-left: 0px;">
				    	<img src="../../hisglobal/images/FrStartAutoHide.png" id='Ins_DocImg' style='display:none;'  title='File Up-Loaded Successfully'>
				    	<button type="button"  class="btn btn-primary" onClick="convertPdfToBase64_ID();">Upload</button>
				    	 
				    </div>
				<div class="col-sm-2 py-2" style="padding-left: 0px;text-align: right;">
					<label><font color="red">*</font>PO Doc</label>
				</div>
				<div class="col-sm-3" style="padding-left: 0px;">
				    <div class="custom-file" style="text-align: left;">
				        <input type="file" class="custom-file-input" id="po_Doc" onchange="updateFile()">
				        <label class="custom-file-label" for="po_Doc">Choose file</label>
				    </div>
				</div>	
				<div class="col-sm-1" style="padding-left: 0px;">
				    <img src="../../hisglobal/images/FrStartAutoHide.png" id='po_DocImg' style='display:none;'  title='File Up-Loaded Successfully'>
				    <button type="button"  class="btn btn-primary" onClick="convertPdfToBase();">Upload</button>
				    
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" name="strUploadFileId4" id="strUploadFileIdw4"  value="${ItemTenderUploadDocFB.strUploadFileId4}" />
	<input type="hidden" name="strUploadFileId3" id="strUploadFileId3"  value="${ItemTenderUploadDocFB.strUploadFileId3}" />
<script>
function updateFileName() {
    var fileName = document.getElementById("Ins_Doc").files[0].name;
    var customFileLabel = document.getElementById("Ins_Doc").nextElementSibling;
    customFileLabel.innerHTML = fileName;
    document.getElementById("selectedFileName").value = fileName;
}

function uploadFile() {
    var fileName = document.getElementById("selectedFileName").value;
    alert("Uploading file: " + fileName);
}

function updateFile() {
    var fileName = document.getElementById("po_Doc").files[0].name;
    var customFileLabel = document.getElementById("po_Doc").nextElementSibling;
    customFileLabel.innerHTML = fileName;
    document.getElementById("selectedFileName").value = fileName;
}

function uploadFile1() {
    var fileName = document.getElementById("selectedFileName").value;
    alert("Uploading file: " + fileName);
}
</script>
</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>