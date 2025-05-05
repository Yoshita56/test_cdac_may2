
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title></title>

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

<!-- <script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script> -->

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bs-stepper/dist/css/bs-stepper.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
<link rel="stylesheet" type="text/css" href="styles.css">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js""></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bs-stepper/dist/js/bs-stepper.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>

.bs-stepper-content .content {
    display: none;
}
.bs-stepper-content .content.active {
    display: block;
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
			
	.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15); !important
 }   
    
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}


.styled-table th,
.styled-table td {
    padding: 12px 15px;
}


.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}

			
			
</style>


<script type="text/javascript">

function validate(){

 		var hisValidator = new HISValidator("newConsRptBean");
 		
        hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Combo" );
        //hisValidator.addValidation("strItemCategNo", "dontselect=0", "Please Select Item Category Combo" );

        
            var retVal = hisValidator.validate();
        		
            hisValidator.clearAllValidations(); 
   

	if(retVal){
    	var hmode = "SHOWRPTNEW"; 
    	var url = "NewConsLedgerRptCNT.cnt?hmode="+hmode+
    	//strToDate,strFromDate,strItemBrandId,strItemCategNo,strStoreId
    	"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
    	"&strItemCategNo="+document.forms[0].strItemCategNo[document.forms[0].strItemCategNo.selectedIndex].value.split('^')[0]+
        "&months="+document.forms[0].strMonthId[document.forms[0].strMonthId.selectedIndex].value+
        "&year="+document.forms[0].strFYearId[document.forms[0].strFYearId.selectedIndex].value+		//changed from value to text.. same result
    	"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
    	"&itemName="+document.forms[0].strItemCategNo[document.forms[0].strItemCategNo.selectedIndex].text.split('^')[0];
    	
    	//"&itemBrandName="+document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;
//"&strItemBrandId="+document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value+
    	//"&strFromDate="+document.forms[0].strFromDate.value+
    	//"&strToDate="+document.forms[0].strToDate.value+
    	
    	ajaxFunction(url,"4");
    }
	else{
		return false;
	}
}	

function itemNameClick(obj,itemBrandID)		//chkBoxClick
{	  								// createFHashAjaxQuery(url) method resides in hisglobal/validation.js file 
	  	 /* Value Pass in Web Row Set		 
		  	1  Store name, 
			2  Item Category,
			3  Month Selected,
			4  Financial year,
			5  Issue Qty, --> Get   
			6  Recieved Qty, --> Get from the table/Procedure
			7  Opening Bal, --> Get
			8 Closing Bal, --> Get

          	 */    	   	
          	console.log("Method invoked by click!");
		 	console.log("med id recorded: "+itemBrandID);
	  // var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	   		var medID=itemBrandID;
          	//var popupWindow = window.open("", "popupWindow", "width=800,height=400,top=100,left=50,scrollbars=yes");
			// window.open(createFHashAjaxQuery(url), "popupWindow",	"width=1200,height=600,top=100,left=50,scrollbars=yes");
          	 var mode="DETAILEDRPTNEW";
          	var url = "NewConsLedgerRptCNT.cnt?hmode="+mode+
          	"&medID="+medID+
        	"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
        	"&strItemCategNo="+document.forms[0].strItemCategNo[document.forms[0].strItemCategNo.selectedIndex].value.split('^')[0]+
            "&months="+document.forms[0].strMonthId[document.forms[0].strMonthId.selectedIndex].value+
            "&year="+document.forms[0].strFYearId[document.forms[0].strFYearId.selectedIndex].value+		//changed from value to text.. same result
        	"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
        	"&itemName="+document.forms[0].strItemCategNo[document.forms[0].strItemCategNo.selectedIndex].text.split('^')[0];
          	
          	window.open(createFHashAjaxQuery(url), "popupWindow",	"width=1200,height=600,top=100,left=50,scrollbars=yes");
          	//ajaxFunction(url,"5");
          	
      /*  fetch("getData.jsp") // Fetches data from the server
                .then(response => response.text())
                .then(data => {
                	console.log("getData.jsp");
   
                	
                    popupWindow.document.write(`
                        <html>
                        <head>
                            <title>Stock Details</title>
                            <style>
                                body { font-family: Arial, sans-serif; padding: 20px; }
                                table { width: 100%; border-collapse: collapse; margin-top: 20px; }
                                th, td { border: 1px solid black; padding: 8px; text-align: left; }
                                th { background-color: #f2f2f2; }
                            </style>
                        </head>
                        <body>
                            <h3>Stock Ledger Details</h3>
                           
                            
                            ${data}
                            <br>
                            <button onclick="window.print()">Print</button>
                            <button onclick="window.close()">Close</button>
                        </body>
                        </html>
                    `);
                    popupWindow.document.close();
                })
                .catch(error => {
                    console.error("Error fetching data:", error);
                    popupWindow.document.write("<p style='color:red;'>Error loading data.</p>");
                }); 
      */
	   	
}


function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
   
       if(temp[0] == "ERROR")
	   {
          	err.innerHTML = temp[1];
          	return;
       } 
       
  	
   if(mode=="1")
   {
        var objVal = document.getElementById("itemCategDIV");
        objVal.innerHTML = "<select name = 'strItemCategNo' class='custom-select' >" + res + "</select>";
		      
   }
   
   if(mode=="2")
   {
        var objVal = document.getElementById("strFYearId");
        objVal.innerHTML = "<select name = 'year' class='custom-select' >" + res + "</select>";
		      
   }
   
   if(mode=="3")
   {
   	//alert("res"+res);
    //  var objVal = document.getElementById("ExistingBatchId");
    //    objVal.innerHTML = "<select name = 'strBatchNo' class='custom-select'  >" + res + "</select>";
		      
   }
   if(mode=="4")
   {
	   objVal = document.getElementById("AckReport");
		objVal.style.display = "block";
		var x = document.getElementById("myDIV");
		var y = document.getElementById("myDIV1");
		x.style.display = "none";
		y.style.display = "none";
		objVal.innerHTML = res;
	  document.getElementById("strStoreId").disabled = true;
	//   document.getElementById("datepicker1").disabled = true;
	//   document.getElementById("datepicker2").disabled = true; 
	//   document.getElementById("drugNameDivId").getElementsByTagName("select")[0].disabled = true;
	    document.getElementById("itemCategDIV").getElementsByTagName("select")[0].disabled = true;
   } 
   
   if(mode=="5")
   {
	   window.open(res, "popupWindow",	"width=1200,height=600,top=100,left=50,scrollbars=yes");
   }  
     
}



function getItemCateg(){
 	var mode="ITEMCATEGORYCOMBO";
   var url="NewConsLedgerRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreId.value;
   ajaxFunction(url,"1");
}

/*
function setValueChk(){
	if(document.getElementsByName("strCase")[0].checked){
		document.getElementsByName("strCase")[0].value="1";
	//	document.getElementsByName("strUserRemarks")[0].value="";
		document.getElementsByName("strItemCategNo")[0].value="0";
		document.getElementsByName("strStoreId")[0].value="0";
		
	}else if(document.getElementsByName("strCase")[1].checked){
		document.getElementsByName("strCase")[1].value="2";
	//	document.getElementsByName("strUserRemarks")[0].value="";
		document.getElementsByName("strItemCategNo")[0].value="0";
		document.getElementsByName("strStoreId")[0].value="0";
	}else{
			document.getElementsByName("strCase")[2].value="3";
		//	document.getElementsByName("strUserRemarks")[0].value="";
			document.getElementsByName("strItemCategNo")[0].value="0";
			document.getElementsByName("strStoreId")[0].value="0";
	}
} */

function onLoadPage(){

	document.forms[0].strStoreId.value = "0";
	document.forms[0].strMonthId.value = "0";
	document.forms[0].strFYearId.value = "0";
}

function onClearButton(){
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();

}

/*
function getDrugName()
{
	if(document.forms[0].strItemCategNo.value == "0")
	{
		document.forms[0].strItemBrandId.innerHTML = "<option value='0'>Select Value</option>";
		document.forms[0].strBatchNo.innerHTML = "<option value='0'>All</option>";
	}
	else
	{
		var mode="DRUGNAMECOMBO";
   		var url="NewConsLedgerRptCNT.cnt?hmode="+mode+"&catCode="+document.forms[0].strItemCategNo.value;
   		ajaxFunction(url,"2");
	}
	
}


function getBatchNo()
{
	var mode="EXISTINGBATCH";
   var url="NewConsLedgerRptCNT.cnt?hmode="+mode
	+"&strItemBrandId="+ document.forms[0].strItemBrandId.value 
	+ "&storeId="+ document.forms[0].strStoreId.value;
	
   ajaxFunction(url,"3");
   
} */

function printReport() {
    document.getElementById("printRptId").style.display = "none";
    
    // Clone the content excluding the last column
    const contentToPrint = document.getElementById("AckReport").cloneNode(true);
    


    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<title>Issue Detail Report</title>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
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
        document.getElementById("printRptId").style.display = "block";
    };
}

</script>

</head>

<body onload="onLoadPage();">

<div class="container mt-5">
    <div id="stepper" class="bs-stepper">
        <div class="bs-stepper-header" role="tablist">
            <div class="step" data-target="#step-1">
                <button type="button" class="step-trigger" role="tab">
                    <span class="bs-stepper-circle">1</span>
                    <span class="bs-stepper-label">Personal Details</span>
                </button>
            </div>
            <div class="line"></div>
            <div class="step" data-target="#step-2">
                <button type="button" class="step-trigger" role="tab">
                    <span class="bs-stepper-circle">2</span>
                    <span class="bs-stepper-label">Contact Info</span>
                </button>
            </div>
            <!-- add new tabs in between -->
             <div class="line"></div>
           <div class="step" data-target="#step-3">
                <button type="button" class="step-trigger" role="tab">
                    <span class="bs-stepper-circle">3</span>
                    <span class="bs-stepper-label">Education</span>
                </button>
            </div>
                       
            <div class="line"></div>
            <div class="step" data-target="#step-4">
                <button type="button" class="step-trigger" role="tab">
                    <span class="bs-stepper-circle">4</span>
                    <span class="bs-stepper-label">Review & Submit</span>
                </button>
            </div>
        </div>

        <div class="bs-stepper-content">
            <form id="myForm">
                <!-- Step 1 -->
                <div id="step-1" class="content">
                    <h4>Step 1: Personal Details</h4>
                    <label>Name:</label>
                    <input type="text" class="form-control">
                    <button class="btn btn-primary mt-3" onclick="stepper.next(); return false;">Next</button>
                </div>

                <!-- Step 2 -->
                <div id="step-2" class="content">
                    <h4>Step 2: Contact Info</h4>
                    <label>Email:</label>
                    <input type="email" class="form-control" placeholder="abc@mail.com"">
                    <button class="btn btn-secondary mt-3" onclick="stepper.previous(); return false;">Previous</button>
                    <button class="btn btn-primary mt-3" onclick="if(validEmail()) stepper.next(); return false;">Next</button>
                </div>
                
				 <!-- add new tabs in between after adding the new stepper header above -->
				 <div id="step-3" class="content">
                    <h4>Step 3: Education Details</h4>
                    <label>Graduate Degree/12th/10th score:</label>
                    <input type="text" class="form-control">
                    <button class="btn btn-secondary mt-3" onclick="stepper.previous(); return false;">Previous</button>
                    <button class="btn btn-primary mt-3" onclick="stepper.next(); return false;">Next</button>
                </div>

                <!-- Step 3 -->
                <div id="step-4" class="content">
                    <h4>Step 4: Review & Submit</h4>
                    <p>Check your details and submit the form.</p>
                    <button class="btn btn-secondary mt-3" onclick="stepper.previous(); return false;">Previous</button>
                    <button class="btn btn-success mt-3" type="submit">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>


<html:form action="/reports/NewConsLedgerRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="newConsRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="newConsRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="newConsRptBean" property="strWarningMsg"/></div>
	
<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader' style='font-size: 16px;font-weight: bold;'>
		<i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Issue Detail
		</div>

		<div class="row " style="display: none;">
			<div class="col" ><label>Store Name<font color="red">*</font></label></div>
			<div class="col" >
				<html:radio property="strCase" name="newConsRptBean" value="1" onclick="setValueChk();">Issuing Store</html:radio>
			</div>
						
			<div class="col" ><label>Hospital name<font color="red">*</font></label></div>
			<div class="col" >
				<select name="strHospCode" class="custom-select">
					<bean:write name="newConsRptBean" property="strHospNameValues" filter="false"/>
				</select>		
			</div>
		</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-icon printbtn" style="border-radius:50%; padding:12px 11px;" onClick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times fa-lg" title="Cancel"></i>
					</div>
				</button>
				
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon clearbtn" style="background-color: #2196f3; border-radius:50%; padding:12px 7px;" onClick="onClearButton();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom fa-lg" title="Clear"></i>
					</div>
				</button>	
				
				<button  type="button" title="Generate" id="generatebutton" class="float-right btn btn-success mt-1 btn-icon savebtn"  style="border-radius:50%; padding:12px 12px;" tabindex='2' onClick="return validate();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download" title="Generate"></i>
					</div>
				</button>
  			</div>  
		</div>
		
		<div class="container">
			<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<select id="strStoreId" name="strStoreId" class='custom-select' onchange="getItemCateg();"> 
						<bean:write name="newConsRptBean" property="strStoreVal" filter="false" />
					</select>
				</div>
	
				<div class="col-sm-2"><label>Item Category<font color="red">*</font></label></div>
				<div class="col-sm-4" id="itemCategDIV">
					<select id="strItemCategNo" name="strItemCategNo"   class="custom-select">
						<bean:write name="newConsRptBean" property="strItemCategCmb" filter="false" />
					</select>		
				</div> 
			</div>
			</div>
			
			<div class="container">
				<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>Month List<font color="red">*</font></label></div>
				<div  class="col-sm-4">
					<select id="strMonthId"	name="strMonthId" class="custom-select">
						<option value="0">Select a month</option>
						<option Value="01-JAN">JAN</option>
                        <option Value="01-FEB">FEB</option>
                        <option Value="01-MAR">MAR</option>
                        <option Value="01-APR">APR</option>
                        <option Value="01-MAY">MAY</option>
                        <option Value="01-JUN">JUN</option>
                        <option Value="01-JUL">JUL</option>
                        <option Value="01-AUG">AUG</option>
                        <option Value="01-SEP">SEP</option>
                        <option Value="01-OCT">OCT</option>
                        <option Value="01-NOV">NOV</option>
                        <option Value="01-DEC">DEC</option>
					</select>
				</div>
		
				<div class="col-sm-2"><label>Financial Year<font color="red">*</font></label></div>
				<div  class="col-sm-4">
					<select id="strFYearId"	name="strFYearId" class="custom-select">
					
				 <bean:write name="newConsRptBean" property="strYearVal" filter="false"/>
					 
					</select>
				</div>
				</div>
	</div>
		
		<%-- 
			<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${newConsRptBean.strCurrentDate}" />
				</div>
			
				<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${newConsRptBean.strCurrentDate}" />
	 			</div>
			</div>	
			
			 <div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2 "><label>Footer Required<font color="red">*</font></label></div>
				<div class="col-sm-2 p-2">
					<html:checkbox property="strIsFooter" name="newConsRptBean" value="1"></html:checkbox>
				</div>
				
			    <div class="col-sm-2 "><label>Report Format<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<select name="strReportFormat"  class="custom-select" onChange="">
						<option value="html">HTML</option>
						<option value="pdf">PDF</option>
						<option value="xls">EXCEL</option>
				    </select>		
				</div>
				 
				<div class="col-sm-2"><label>User Remarks<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<textarea name="strUserRemarks" class="form-control" rows="1"  style="height:38px;" onkeyup="maxLengthRemarks(this,'500')" ></textarea>
				</div>
			</div> --%>
				
					
			<hr id='hr4' style="display: none;"><hr>
		<div class="col-sm-12" id="myDIV" align="center">
    		<label><font color="red">We keep a record here for Issue details.</font></label>
    	</div>
	    	
    	<div align="center" id="AckReport"></div>
    	
    	
 		<hr id='hr4' style="display: none;"><hr>
			
		<div class="col-sm-12" align="right" id="myDIV1">
    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
    	</div>
	</div>
	</div>	
	
<input type="hidden" name="hmode"/>


</html:form>

<script type="text/javascript">

</script>

<script>

function validEmail() {		//Ensuring the right format of the email for successful form submission
    var emailField = document.querySelector("#myForm input[type='email']");
    console.log(emailField.value);
    if (!emailField.checkValidity()) {  // Uses built-in validation
        alert("Please enter a valid email address.");
        return false;
    } else {
      //  alert("Valid email entered!");
        return true;
    }
}

    document.addEventListener("DOMContentLoaded", function () {
        window.stepper = new Stepper(document.querySelector("#stepper"),{
          linear:false,			// making a by-default linear stepper- a non-linear to get rid of sequential steps and achieve direct jump to the steps
          animation:true		// smoothens the transition from one tab -> another tab
        });
    
    
    // Ensure the first step is visible
    document.querySelector(".bs-stepper-content .content").classList.add("active");
    
    
   document.querySelectorAll(".step-trigger").forEach(trigger => {
        trigger.addEventListener("click", function () {
            // Hide all step contents
            document.querySelectorAll(".bs-stepper-content .content").forEach(content => {
                content.classList.remove("active");
            });

            // Show the clicked step's content
            let target = this.parentElement.getAttribute("data-target");
            document.querySelector(target).classList.add("active");
            console.log(target+"");
        });
      });
    
   document.getElementById("myForm").addEventListener("submit", function (event) {
       var inputs = document.querySelectorAll("#myForm input");
       var isValid = true;
       var errorMessage = "Please fill out the following fields:\n";
       

       inputs.forEach(function (input) {
           if (input.value.trim() ==="") {  // Now checking all inputs, even in hidden steps
               isValid = false;				//make sure to fill the email in correct format: abc@mail.com
               let label = input.previousElementSibling ? input.previousElementSibling.innerText : "Unnamed Field";
               errorMessage += "- " + label + "\n";
           }
       });

       if (isValid===false) {
           alert(errorMessage); // Show missing fields alert
           event.preventDefault(); // Prevent form submission
       } else {
           alert("Form submitted successfully!"); // Show success alert
       }
   }); 
   
    
    });
    
</script>
   
<tag:autoIndex></tag:autoIndex>
</body>

</html>