<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
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
<html>
<head>
<meta charset=UTF-8">
<title>Supplier Receipt</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 <script src="../../hisglobal/jquery/3.6.0.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
 <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">


<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script  src="../../hisglobal/js/validationBootstrap.js"></script>
<script type="text/javascript" src="../../mms/bootstrap/js/bootstrap.min.js"></script>
<!-- <script  src="../../ipd/js/jquery.simplemodal.js"></script> -->
<link rel="stylesheet" href="/INVMGM/mms/flexdatalist/jquery.flexdatalist.min.css">
<script src="/INVMGM/mms/flexdatalist/jquery.flexdatalist.min.js"></script> 

<script language="Javascript" src="/INVMGM/mms/js/LocalPurchaseNew_item_mmstrans.js"></script>

<script type="text/javascript">

function drugNameFun(obj)
{
	
	let itemList = [];
	$('#strMultiRowItemId option').each(function() 
	{
		 
		//alert('obj.value----'+obj.value);   
	    itemList.push({ "value" :this.textContent , "data" : obj.value.split("^")[0] });
	    
	});
	
	//console.log('running');
	  $(obj).autocomplete({
		   lookup: itemList,
		   minChars:3,
		   onSelect: function (suggestion) {  
			 			   
		     getDrugNameSelected(suggestion.data , obj);	    
		   }	    
		 }); 

	  $(obj).click(function(){	 
		 	$(this).val("");
		 	
		 }); 
}

function getDrugNameSelected(itemId , obj)
{
	
	var i = obj.parentNode.parentNode.id;
	var j = parseInt(i/2) + 1;
	var flag = 0;
	var sel = document.forms[0].strMultiRowItemId;	
	document.getElementsByName("strBrandId")[0].value = "0";
	for (var i=0; i<sel.options.length; i++) 
	{	
		if ( (sel.options[i].text.replace(/\s+/g, "")) == (obj.value.replace(/\s+/g, ""))) 
		{
			document.getElementsByName("strBrandId")[j].value = sel.options[i].value;			
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	//alert("flag"+flag);
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchDrug.value = "";
	}
	else
	{
		//alert("3");
		displaySelectedDrug();
		ajaxExistingBatchName();
	}	    
	 
}




function displaySelectedDrug() 
{
	//alert("4");
	if(document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].value!='0')
  {	
	 	document.getElementById("DrugNameId").innerHTML=document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].text;
   	if(document.getElementById("itemDivId")!=null)
   		document.getElementById("itemDivId").innerHTML = document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].text;
   	//alert("5");
  }
  else
  {
	//alert("6");
  	document.getElementById("DrugNameId").innerHTML="";
  	if(document.getElementById("itemDivId")!=null)
  		document.getElementById("itemDivId").innerHTML = "";
  }  
}
    
</script>
<style type="text/css">
	
	body {
	font-family: 'Source Sans Pro', sans-serif;
	font-size: 12px;
	line-height: 0.8;
	color: #333;
	background-color: #fff;
	font-weight: 501;
	background: #eaeef3;
}
.form-control {
	font-size: 0.8rem;
	/*font-family:  "Helvetica Neue", "Helvetica";*/
}

.browser-default {
	font-size: 0.8rem;
	/*font-family:  "Helvetica Neue", "Helvetica";*/
}

.row {
	padding-bottom: 5px;
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
	/*color: #666;*/
	
}

.prescriptionTile:hover {
	/*box-shadow: 0 1px 18px 0px #bababa;*/
	box-shadow: 0 2px 10px 2px #847d7d;
	/* -webkit-transform: translateY(-4px); */
	/* transform: translateY(-4px); */
}

.subHeaders {
	font-weight: 501 !important;
	/*color: rgba(33, 32, 32, 0.7);

    font-family: "Helvetica Neue", "Helvetica";*/
	font-size: 20px !important;
	padding-bottom: 0px !important;
}
.newrow {
	padding-top: 2px;
	padding-bottom: 2px;
	background-image: linear-gradient(to right, #49B2F3, #02629C);
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: 5px;
}
.table thead th {
   
    padding-top: 0;
   
}
.table td, .table th {
   
border-bottom: 2px solid
    #dee2e6;
}

.autocomplete-suggestion{
font-weight: 500 !important;
}

</style>
<script >

function alphanumeric(e)
{ 

var k;
document.all ? k = e.keyCode : k = e.which;
//console.log(e.keyCode +'   ===  '+e.which);
return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57) || k == 45 || k == 47);
	
}
</script>
<html>
<head>
<title>Supplier Receipt</title>




</head>
<body>
<html:form action="/transactions/AckSuppReceiptCNT.cnt" name="AckSuppReceiptBean" type="mms.transactions.controller.fb.AckSuppReceiptFB" method="post" >


		<div class="viewport" id="nonPrintable">
			<div class="container-fluid">
						<div class="prescriptionTile">						
						   							
							<div class="row">
								<div class="col-sm-8">
									<p class="subHeaders">
										<button type="button"
											class="btn btn-info">
											<i class="fa fa-shopping-bag" title="Cancel"></i>
										</button>
										&nbsp;Material Receipt Modification
									</p>
								</div>
								<div class="col-sm-2" align="left" style="color: #173479;font-weight: bold;">Store Name:
        		                  <label style="color: #736767;">
        		                     <b><bean:write  name="AckSuppReceiptBean" property="strStoreName" filter="false" /></b>
        		                 </label>
        		                </div>
								<div class="col-sm-2" align="left" style="color: #173479;font-weight: bold;">Catg:
        		                  <label style="color: #736767;">
        		                     <b><bean:write  name="AckSuppReceiptBean" property="strItemCategoeryName" filter="false" /></b>
        		                 </label>
        		                </div>
								
							</div>
							<div class="row">
								<div class="col-sm-1">
									<label>PO Date</label>
								</div>
								<div class="col-sm-3">
									<input id="datepicker3" type="text" value="${AckSuppReceiptBean.strPoDate}"  name="strPoDate">
								</div>
								<div class="col-sm-1 py-2">
									<label>Supplier<font color="red">*</font></label>
								</div>
								<div class="col-sm-3">
									<select  class='browser-default custom-select' name='strSupplierId'>
									  <bean:write name="AckSuppReceiptBean" property="strSupplierCombo" filter="false" />
									</select>
								</div>
								
								<div class="col-sm-1 py-2">
									<label>DM No.<font color="red">*</font></label>
								</div>
								<div class="col-sm-3">
									<input type="text" class="form-control"  value="${AckSuppReceiptBean.strDCNo}"  onkeypress="return alphanumeric(event);" onkeyup="uppercasefn(this)" id="strDCNoId"  name="strDCNo" autocomplete="off">
								</div>
								
							</div>
							<div class="row">
								<div class="col-sm-1 py-2">
									<label>Challan\Indent Date<font color="red">*</font></label>
								</div>
								<div class="col-sm-3">
									<input id="datepicker" type="text" name="strChallanDate"  value="${AckSuppReceiptBean.strChallanDate}" >
								</div>
								<div class="col-sm-1 py-2">
									<label>Bill No<font color="red">*</font></label>
								</div>
								<div class="col-sm-3">
									<input type="text" class="form-control" onkeyup="uppercasefn(this)"  onkeypress="return alphanumeric(event);" id="strInvoiceNoId" name="strInvoiceNo" value="${AckSuppReceiptBean.strInvoiceNo}" autocomplete="off">
								</div>
								<div class="col-sm-1 py-2">
									<label>Bill Date<font color="red">*</font></label>
								</div>
								<div class="col-sm-3">
									<input id="datepicker1" type="text" name="strInvoiceDate" value="${AckSuppReceiptBean.strInvoiceDate}">
								</div>
							</div>
							
							<div class="row">
							    <input type="hidden" name="strUcChk" value="0" checked="checked" style="margin-left:10px";>	
								<div class="col-sm-1 py-2">
									<label>Expected Delivery Date</label>
								</div>
								<div class="col-sm-3">
									<input id="datepicker2" type="text" name="strExpDeliveryDate" value="${AckSuppReceiptBean.strExpDeliveryDate}">
								</div>
																
								<div class="col-sm-1 py-2">
									<label>PO No.<font color="red">*</font></label>
								</div>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="strLpoNoId" name="strLpoNo" value="${AckSuppReceiptBean.strLpoNo}" onkeypress="return alphanumeric(event);" onkeyup="uppercasefn(this)" autocomplete="off">
								</div>
								
									<div class="col-sm-1 py-2">
										<label>Purchase Through<font color="red">*</font></label>
									</div>
									<div class="col-sm-3">
										<select  class='browser-default custom-select' name='strInstituteId' id="InstituteId">
											<bean:write name="AckSuppReceiptBean" property="strInstituteCombo" filter="false"/>
										</select>
									</div>							
							</div>
							<div class="row">
							    <input type="hidden" name="strUcChk" value="0" checked="checked" style="margin-left:10px";>	
									<div class="col-sm-1 py-2">
										<label>Manufacturer</label>
									</div>
									<div class="col-sm-3">
										<select  class='browser-default custom-select' name='strManufacturer'>
										  <bean:write name="AckSuppReceiptBean" property="strMfgCombo" filter="false" />
										</select>
									</div>																
									<div class="col-sm-1 py-2">
									</div>
									<div class="col-sm-3"></div>								
									<div class="col-sm-1 py-2"></div>
									<div class="col-sm-3"></div>							
							</div>				  							
							<br>
							<div class="row">		
							  <div class="col-sm-12" align="center">
								 <div id = "printDtlsDivId">
									  <bean:write name="AckSuppReceiptBean"  property="strPrintDtls" filter="false" />
								 </div>
							  </div>
	                        </div> 					
							<div class="row">							
								
								<div class="col-sm-3" align="right">
									<label>Remarks</label>
								</div>
								<div class="col-sm-7">
									<textarea class="form-control" rows="2" id="comment" name="strRemarks" ><bean:write name="AckSuppReceiptBean" property="strRemarks" filter="false" /></textarea>
								</div>
								<div class="col-sm-2"></div>
							</div>
							
							<div class="row">
								<div class="col-sm-12" align="center">
									
									<button type="button" id="savebutton" class="btn btn-success" onclick="validate1();"  ><i class="fa fa-save"></i>
									&nbsp;Save</button>
									<button type="button" class="btn btn-danger" onclick="cancelToDesk();" data-dismiss="modal"><i class="fa fa-ban"></i>&nbsp;Cancel</button>
									
								</div>
							</div>

 
  <div id='mainDiv' style='display:none;'>
					<div class="fade" id="validateModal"   tabindex="-1" role="dialog" aria-labelledby="validateModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					    
					      <div class="modal-body">
					           <h5 id='warn'></h5>
					           <p id='len'></p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
					
					      </div>
					    </div>
					  </div>
					</div>
					</div>


	<form>
	<script type="text/javascript">
	$('#datepicker').datepicker({ uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	$('#datepicker1').datepicker({uiLibrary: 'bootstrap4', modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	$('#datepicker2').datepicker({uiLibrary: 'bootstrap4', modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	$('#datepicker3').datepicker({ uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	//$('#datepicker2').val(dd);
	
		
	$('#datepicker').val(document.forms[0].strChallanDate.value);
	$('#datepicker1').val(document.forms[0].strInvoiceDate.value);
	$('#datepicker2').val(document.forms[0].strExpDeliveryDate.value);
	$('#datepicker3').val(document.forms[0].strPoDate.value);
	
	$('#strMfgDate1').val(dd);

	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();	
	var FullYear = today.getFullYear()+10
	var dd = today.getDate()+"-"+mmm+"-"+FullYear;
	
	

	function insRow() {
	

		  var x = document.getElementById('POITable');
		  var y=x.querySelectorAll("tbody")[0];
		  var new_row = x.rows[1].cloneNode(true);
		  var new_row1 = x.rows[3].cloneNode(true);
		  var len = x.rows.length;
		  new_row.style.display="";
		  new_row.id=parseInt(x.rows[2].id)+(parseInt(len-3));
		  new_row.querySelectorAll("input[name='strMfgDate']")[0].id="strMfgDate"+new_row.id;
		  new_row.querySelectorAll("input[name='strExpDate']")[0].id="strExpDate"+new_row.id;
		  

		 // $('#datepicker2').datepicker({ uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
		  y.appendChild(new_row);
		  
		  new_row.style.display="";
		  new_row1.style.display="";
		  new_row1.id=parseInt(x.rows[2].id)+(parseInt(len-2));
		  y.appendChild(new_row1);
		  new_row1.style.display="";
		  for(var i=0;i<new_row.querySelectorAll("input").length;i++)
			  new_row.querySelectorAll("input")[i].value='';
		  for(var j=0;j<new_row1.querySelectorAll("label").length;j++)
			  new_row1.querySelectorAll("label")[j].innerHTML='0';
		  addDp_MfgDate("strMfgDate"+new_row.id);
		  addDp_ExpDate("strExpDate"+new_row.id);	  
	}
	
	
	function addDp_MfgDate(id){
		$("#"+id).datepicker({ uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});

		var today=new Date();
		var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
		var mmm=arr[today.getMonth()];
		var hrs=today.getHours();	
		var FullYear = today.getFullYear()
		var dd = today.getDate()+"-"+mmm+"-"+FullYear;
		
		$("#"+id).val(dd);
	}
	
	
	function addDp_ExpDate(id){
		$("#"+id).datepicker({ uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});

		var today=new Date();
		var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
		var mmm=arr[today.getMonth()];
		var hrs=today.getHours();	
		var FullYear = today.getFullYear()+10
		var dd = today.getDate()+"-"+mmm+"-"+FullYear;
		
		$("#"+id).val(dd);
	}

	function deleteRow(row) {
  var i = row.parentNode.parentNode.rowIndex;
  document.getElementById('RowId').deleteRow(i);
  document.getElementById('RowId').deleteRow(parseInt(i-1));
}

	
function uppercasefn(obj){

	//document.getElementById(obj.id).value=(obj.value).toUpperCase();
	$("input[type=text]").keyup(function(){
		  $(this).val( $(this).val().toUpperCase() );
		});
}
function preview(obj) 
{
	var i = obj.parentNode.parentNode.id;
	//alert(i);
	var batch = document.getElementById(parseInt(i)).querySelectorAll("input")[0].value;
	var itm = document.getElementById(parseInt(i)).querySelectorAll("input")[1].value;
	var exp = document.getElementById(parseInt(i)).querySelectorAll("input")[3].value;
	//var purrateperpack = document.getElementById(parseInt(i)).querySelectorAll("input")[6].value;
	var gstper = document.getElementById(parseInt(i)).querySelectorAll("input")[6].value;
	var admper = document.getElementById(parseInt(i)).querySelectorAll("input")[7].value;
	var qty = document.getElementById(parseInt(i)).querySelectorAll("input")[4].value;
	//var purwidouttax = document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML;
	var purwidtax = document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML;
	var admchg = document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML;
	var mrp = document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML;
		//var dept = document.getElementsByName("strDeptCode")[0].options[document.getElementsByName("strDeptCode")[0].selectedIndex].text;
	
	var lDiv = "<div class='col-md-12' style ='padding-bottom: 10px;' align='center'>";
	var lDiv1 = "<div class='col-md-12' style ='padding-bottom: 10px;line-height: 15px;' align='center'>";
	var rDiv = "<div class='col-md-8'>";
	var cDiv = "</div>";

	var tmpDiv = lDiv1 + "<b>Item Name : </b>" + itm + cDiv ; // + rDiv + itm + cDiv;
	 tmpDiv = tmpDiv + lDiv + "<b>Type : </b>Item" + cDiv ;//+ rDiv + "Drug" + cDiv;
	 tmpDiv = tmpDiv + lDiv + "<b>Batch No. : </b>"+ batch + cDiv; //+ rDiv + batch + cDiv;
	 tmpDiv = tmpDiv + lDiv + "<b>Expiry Date : </b>"+ exp + cDiv; //+ rDiv + exp + cDiv;
	// tmpDiv = tmpDiv + lDiv + "<b>Purchase Rate/Pack : </b>" + purrateperpack + cDiv; // + rDiv + purrateperpack + cDiv;

	 tmpDiv = tmpDiv + lDiv + "<b>GST% : </b>" + gstper + cDiv; //+ rDiv + gstper + cDiv;
	 tmpDiv = tmpDiv + lDiv + "<b>ADM% : </b>" + admper + cDiv; //+ rDiv + admper + cDiv;
	 tmpDiv = tmpDiv + lDiv + "<b>Total Quantity(No.) : </b>" + qty + cDiv; // + rDiv + qty + cDiv;
	// tmpDiv = tmpDiv + lDiv + "<b>Purchase Rate(Excl. Tax) : </b>" + purwidouttax + cDiv; // + rDiv + purwidouttax + cDiv;
	 tmpDiv = tmpDiv + lDiv + "<b>Purchase Rate(Incl. Tax) : </b>"+ purwidtax + cDiv; // + rDiv + purwidtax + cDiv;
	 tmpDiv = tmpDiv + lDiv + "<b>ADM Charges : </b>" + admchg + cDiv; // + rDiv + admchg + cDiv;
	 tmpDiv = tmpDiv + lDiv + "<b>Cost to Patient : </b>" + mrp + cDiv; //+ rDiv + mrp + cDiv;
	//alert(document.getElementById("prvwpop").innerHTML);
	document.getElementById("prvwpop").innerHTML = tmpDiv;
	//document.getElementById("prevw").setAttribute("data-target","#RowpreviewModal");
}

//call on cancel button 
function cancelToDesk(){
	document.forms[0].hmode.value="CANCELTODESK";
	document.forms[0].submit();
}

function save(){
    var hisValidator = new HISValidator("AckSuppReceiptBean");
    var retVal = hisValidator.validate();
    hisValidator.clearAllValidations();
    //var retVal=true;
    if (retVal) {
           // console.log("3553535"+retVal);
            document.forms[0].hmode.value = "SAVE";
            //document.getElementById("saveid").style.display = "none";
            document.forms[0].submit();
        }
     else {
        return false;
    }
}

function dateDifferenceInDays(mfgDate,expDate)
{
	  var  t1 = convertDate_ddmmyyyy(mfgDate);
      var t2 = convertDate_ddmmyyyy(expDate);
 //Total time for one day
      var one_day=1000*60*60*24; 
 //Here we need to split the inputed dates to convert them into standard format  for furter execution
      var x=t1.split("/");     
      var y=t2.split("/");
 //date format(Fullyear,month,date) 

      var date1=new Date(x[2],(x[1]-1),x[0]);

      var date2=new Date(y[2],(y[1]-1),y[0])
      var month1=x[1]-1;
      var month2=y[1]-1;
      
      //Calculate difference between the two dates, and convert to days
             
      var _Diff=Math.ceil((date2.getTime()-date1.getTime())/(one_day)); 
     // alert("Difference Between Mfg & Exp Dates:::"+_Diff);
     return _Diff;
}

function convertDate_ddmmyyyy(dtValue)
{
  
   var val1  = trimAll(dtValue).split("-").join(".");
   var val2  = val1.split("-").join(".");
   var date  = val2.split(".")[0];
   var month = val2.split(".")[1].toLowerCase();
    
   var convMonth ;   
   
   if(month=='jan')
   {
   	 convMonth = "01";
   }
   if(month=='feb')
   { 
   	 convMonth = "02";		  	   	
   }
   if(month=='mar')
   {
   	 convMonth = "03";
   }
   if(month=='apr')
   { 
   	 convMonth = "04";		  	   	
   }
   if(month=='may')
   {
   	 convMonth = "05";
   }
   if(month=='jun')
   { 
   	 convMonth = "06";		  	   	
   }
   
   if(month=='jul')
   { 
   	 convMonth = "07";		  	   	
   }
   if(month=='aug')
   {
   	 convMonth = "08";
   }
   if(month=='sep')
   { 
   	 convMonth = "09";		  	   	
   }
   
   if(month=='oct')
   { 
   	 convMonth = "10";		  	   	
   }
   if(month=='nov')
   {
   	 convMonth = "11";
   }
   if(month=='dec')
   { 
   	 convMonth = "12";		  	   	
   }
   
   var year  = val2.split(".")[2];   
   return date+"/"+convMonth+"/"+year;
}





function validate1()
{
	
	var flag = false;
	//var cboCountry = document.getElementsByName("strCountry")[0];
	document.getElementById("savebutton").setAttribute("data-target", "#validateModal"); 
	var hisValidator = new HISValidator("AckSuppReceiptBean");
	hisValidator.addValidation("strSupplier", "dontselect=0","Supplier is a Mandatory Field");
	hisValidator.addValidation("strDCNo", "req", "DC No.  is a Mandatory Field");
	hisValidator.addValidation("strChallanDate", "req", "Challan Date  is a Mandatory Field");
	hisValidator.addValidation("strInvoiceNo", "req", "Invoice No.  is a Mandatory Field");
	hisValidator.addValidation("strInvoiceDate", "req", "Invoice Date  is a Mandatory Field");
	//hisValidator.addValidation("strSearchDrug", "req", "Item is a Mandatory Field");
	//hisValidator.addValidation("strbatchno", "req", "Batch No. is a Mandatory Field");
	//hisValidator.addValidation("strExpDate", "req", "Expiry Date is a Mandatory Field");
	//hisValidator.addValidation("strMfgDate", "req", "Mfg Date is a Mandatory Field");
	//hisValidator.addValidation("strTotalQty", "req", "Total Qty is a Mandatory Field");
// 	hisValidator.addValidation("strPurRate", "req", "Purchase Rate is a Mandatory Field");
	//hisValidator.addValidation("strRatePack", "req", "Rate/Pack is a Mandatory Field");
	//hisValidator.addValidation("strGST", "req", "GST% is a Mandatory Field");
	//hisValidator.addValidation("strAdmchg", "req", "ADM% is a Mandatory Field");
	hisValidator.addValidation("strInstituteId", "req", "Purchase Through is a Mandatory Field");

	hisValidator.addValidation("strChallanDate","dtltet="+document.forms[0].strCtDate.value,"Challan Date should not be greater than Today's Date");
	if((document.forms[0].strExpDeliveryDate.value)!="")
	{
		hisValidator.addValidation("strExpDeliveryDate","dtgtet="+document.forms[0].strChallanDate.value,"Expected Delivery Date [ "+document.forms[0].strExpDeliveryDate.value+" ] should not be less than Challan\Indent Date [ "+document.forms[0].strChallanDate.value+" ] ");
	}	
	hisValidator.addValidation("strInvoiceDate","dtltet="+document.forms[0].strCtDate.value,"Invoice Date should not be greater than Today's Date");
	hisValidator.addValidation("strMfgDate","dtltet="+document.forms[0].strCtDate.value,"Mfg Date should not be greater than Today's Date");
	hisValidator.addValidation("strExpDate","dtgtet="+document.forms[0].strCtDate.value,"Expiry Date should not be less than Today's Date");
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if (retVal) 
	{
		
		if((document.forms[0].strExpDeliveryDate.value)!="")
		{			
			var dateDiffOne = dateDifferenceInDays(document.forms[0].strExpDeliveryDate.value,document.forms[0].strInvoiceDate.value);
			//alert("Difference Between Expected Delivery Date [ "+document.forms[0].strExpDeliveryDate.value+" ] &  Bill  Date [ "+document.forms[0].strInvoiceDate.value+" ]  are  ["+dateDiffOne+"] Day(s) !!! ");
			 var conf = confirm("Difference Between Expected Delivery Date [ "+document.forms[0].strExpDeliveryDate.value+" ] &  Bill  Date [ "+document.forms[0].strInvoiceDate.value+" ]  are  ["+dateDiffOne+"] Day(s) !!!" );
	         if(conf){
	        	 if(confirm("You Are Going To Save Record with  [ "  + dateDiffOne +"  ]  Days Late Delivery \n Are You Sure ?"))
				 {
		        	// previewForm();	
		        	 document.forms[0].hmode.value = "MODIFY_SAVE";	           
		             document.forms[0].submit();
		         }
		         else
		         {
		           return false;
		         }
	         }
	         else
	         {
	           return false;
	         }
			
		}
		else
		{
			document.forms[0].strExpDeliveryDate.value = document.forms[0].strInvoiceDate.value;
			//previewForm();	
			 document.forms[0].hmode.value = "MODIFY_SAVE";	      
	         document.forms[0].submit();
		}
		
		
	}
}

//call on cancel button 
function cancelToDesk(){
	document.forms[0].hmode.value="CANCELTODESK";
	document.forms[0].submit();
}
function save(){
    var hisValidator = new HISValidator("AckSuppReceiptBean");
    var retVal = hisValidator.validate();
    hisValidator.clearAllValidations();
    //var retVal=true;
    if (retVal) {
           // console.log("3553535"+retVal);
            document.forms[0].hmode.value = "UPDATE";
            //document.getElementById("saveid").style.display = "none";
            document.forms[0].submit();
        }
     else {
        return false;
    }
}

</script>
</html:form>

<input type="hidden" name="hmode"/>
<input type="hidden" name="strCtDate" value="${AckSuppReceiptBean.strCtDate}" />

<input type="hidden" name="strChalnDate" value="${AckSuppReceiptBean.strChallanDate}" />
<input type="hidden" name="strInvoDate" value="${AckSuppReceiptBean.strInvoiceDate}" />
<input type="hidden" name="strExpectedDeliveryDate" value="${AckSuppReceiptBean.strExpDeliveryDate}" />
<input type="hidden" name="strPODate" value="${AckSuppReceiptBean.strPoDate}" />


<input type="hidden" name="strStoreId" value="${AckSuppReceiptBean.strStoreId}" />
<input type="hidden" name="strItemCategoeryName" value="${AckSuppReceiptBean.strItemCategoeryName}" />
<input type="hidden" name="strItemCategoryNo" value="${AckSuppReceiptBean.strReqTypeId}" />
</body>
</html>