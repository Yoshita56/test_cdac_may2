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
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<html>
<head>
<meta charset=UTF-8">
<title>Drug Ack Supplier Receipt</title>



 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="../../hisglobal/jquery/3.6.0.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    
    

    <script src="/INVMGM/mms/lpasset/bootstrap.min.js"></script>  
<!--  <script src="/INVMGM/mms/lpasset/gijgo.min.js" type="text/javascript"></script> -->
<!--   <script src="/INVMGM/mms/lpasset/popper.min.js"></script> -->
<!-- <link rel="stylesheet" href="/INVMGM/mms/lpasset/font-awesome.min.css"> -->
<!--     <link href="/INVMGM/mms/lpasset/gijgo.min.css" rel="stylesheet" type="text/css" /> -->
<!--   <link rel="stylesheet" href="/INVMGM/mms/lpasset/bootstrap.min.css"> -->

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
<script  src="../../ipd/js/jquery.simplemodal.js"></script>
<link rel="stylesheet" href="/INVMGM/mms/flexdatalist/jquery.flexdatalist.min.css">
<script src="/INVMGM/mms/flexdatalist/jquery.flexdatalist.min.js"></script> 

<script language="Javascript" src="/INVMGM/mms/js/AckSupplierReceipt.js"></script>

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
	//alert("ggtreTRETerertretre");
	
	//alert("j----"+j+"----i----"+i+"--itemid--"+itemId+"----"+obj.value);
	//alert("strBrandId---------------->"+ strBrandId);
	var flag = 0;
	var sel = document.forms[0].strMultiRowItemId;	
	document.getElementsByName("strBrandId")[0].value = "0";
	
	//document.getElementsByName("strBrandId")[j].value = itemId; //document.forms[0].strMultiRowItemId.value;	
	//alert("sel.options.length---------------->"+ sel.options.length);	
	//alert("strBrandId---------------->"+ strBrandId);
	for (var i=0; i<sel.options.length; i++) 
	{	
		
		//alert("itemId----"+itemId+"--SET------"+sel.options[i].value);
	
		//if ( sel.options[i].text == obj.value)
		if ( (sel.options[i].text.replace(/\s+/g, "")) == (obj.value.replace(/\s+/g, "")))
 
		{
			
			//alert("chk1");
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


function save()
{
	document.getElementById('ACKSAVE').style.display = 'none';
	
	var saveObj = document.getElementById("saveId");
 	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		     saveObj.style.display = "none";
		     document.forms[0].hmode.value = "SAVE";            
		     document.forms[0].submit();    
	}
 	else 
	{
			saveObj.style.display = ""; 
			return false;
	}
   
   
}
function back()
{	     
     document.forms[0].hmode.value = "CANCELTODESK";     
     document.forms[0].submit();
}



function DateTest()
{
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	
	
	var costObj = document.getElementsByName("strMfgDate");
	var dateObj = document.getElementsByName("dateVal");
	var total = parseFloat("0.00");
	
	
	
	if (costObj.length > 0) 
	{
			
			
		for ( var k = 0; k < (costObj.length+1) ; k++)
		{		      
			
			$('#strMfgDate'+k).datepicker({ uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
			$('#strExpDate'+k).datepicker({ uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
			
			$('#strMfgDate'+k).val((dateObj[k].value).split("^")[0]);
			$('#strExpDate'+k).val((dateObj[k].value).split("^")[1]);
			
			//total = total + parseFloat(document.getElementById("strCost"+i).value);
			
			//calQty(this,k);
		}
			
	}
	
}
</script>
<html>
<head>
<title>LOCAL PURCHASE(GRN)</title>




</head>
<body onLoad="DateTest();">
	<html:form action="/transactions/AckSuppReceiptCNT.cnt" name="AckSuppReceiptBean" type="mms.transactions.controller.fb.AckSuppReceiptFB" method="post" >


		<div class="viewport" id="nonPrintable">
			<div class="container-fluid">
<br>		
						<div class="prescriptionTile">
							
							<div class="row">
								<div class="col-sm-10">
									<p class="subHeaders">
										<button type="button"
											class="btn btn-info">
											<i class="fa fa-shopping-bag" title="Cancel"></i>
										</button>
										&nbsp;Acknowledge Material Material Receipt
									</p>
								</div>
								<div class="col-sm-2 text-right" id="saveId">
										<button type="button" id="ACKSAVE" class="btn btn-info" onclick="save();">
											Save
										</button>
										<button type="button" class="btn btn-info" onclick="back();">
											Back
										</button>
								</div>
						   </div>
						   
						   <bean:write  name="AckSuppReceiptBean" property="strPrintDtls"   filter="false" />
						   
					</div>
				</div>
			</div>			   
								
<div class="modal fade" id="preModal" role="dialog">
    <div class="modal-dialog modal-lg" style="max-width: 1000px;">
    
      <!-- Modal content-->
      <div class="modal-content">
      <div class="modal-header" style="font-size: 20px;font-weight: bold;color: black;">Item Preview<button type="button" class="close" data-dismiss="modal">&times;</button></div>      
        <div class="modal-body">
        <div class="row">
        	
        	<div class="col-sm-4">
        		
          

        	</div>
        	<div class="col-sm-5" style="line-height: 15px">
        		<div class="row" style="padding-bottom: 0;font-weight: bold;">
        			<label style="margin-bottom: 0;"></label>
        		</div>
        		<div class="row" style="padding-bottom: 0;font-weight: bold;">
        			<div class="col-sm-1"></div>
        			<div class="col-sm-10"><label style="margin-bottom: 0;">.</label></div>
        			<div class="col-sm-1"></div>
        		</div>
        		<div class="row" style="padding-bottom: 0;font-weight: bold;">
        			<div class="col-sm-1"></div>
        			<div class="col-sm-10"><label style="margin-bottom: 0;">Store Name : </label><bean:write  name="AckSuppReceiptBean" property="strStoreName" filter="false" /></div>
        			<div class="col-sm-3"></div>
        		</div>
        	</div>
        	<div class="col-sm-3"></div>
        </div>
<br>     


<div class="row">
	<div class="col-sm-8"></div>
	<div class="col-sm-2" align="right"><label style="font-weight: bold;">Grand Total(<i class="fa fa-rupee"></i>):</label></div>
	<div id="gtotal" class="col-sm-2"><label>0</label></div>
	
</div>
<div class="row">
	
	<div class="col-sm-2" align="right"><label style="font-weight: bold;"></label></div>
	<div class="col-sm-2"><label></label></div>
	<div class="col-sm-8"></div>
</div>
   </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" onclick="save();">Ok&Save</button>
        </div>
      </div>
      
    </div>
  </div>

  <div class="modal fade" id="RowpreviewModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
      <div class="modal-header" style="font-size: 20px;font-weight: bold;color: black;">Item Preview<button type="button" class="close" data-dismiss="modal">&times;</button></div>      
        <div id="prvwpop" class="modal-body">
      
         <div class="row">
         	<div class="col-md-4" style="border-right:1px dotted black ; line-height: 15px;" align="Right">
         		<b>Item Name</b></div>
         <div class="col-md-8"></div>
         <div class="col-md-4" style="border-right:1px dotted black" align="Right">
         		<b>Type</b></div>
         <div class="col-md-8">Drug</div>
         <div class="col-md-4" style="border-right:1px dotted black" align="Right">
         		<b>Serial No.</b></div>
         <div class="col-md-8">9610120</div>
         <div class="col-md-4" style="border-right:1px dotted black" align="Right">
         		<b>Exp Date</b></div>
         <div class="col-md-8">25-feb-2020</div>
         <div class="col-md-4" style="border-right:1px dotted black" align="Right">
         		<b>GST(%)</b></div>
         <div class="col-md-8">9610120</div>
         <div class="col-md-4" style="border-right:1px dotted black" align="Right">
         		<b>Adm(%)</b></div>
         <div class="col-md-8">9610120</div>
         	<div class="col-md-4" style="border-right:1px dotted black" align="Right">
         		<b>Qty(No.)</b></div>
         <div class="col-md-8">9610120</div>
        <div class="col-md-4" style="border-right:1px dotted black" align="Right">
        	<b>Pur Rate/Unit(encl Taxes):</b></div>
         	<div class="col-md-8">1234</div>
         	<div class="col-md-4" style="border-right:1px dotted black" align="Right">
         		<b>ADM Charges:</b></div>
         		<div class="col-md-8"> 4235654</div>
         		<div class="col-md-4" style="border-right:1px dotted black" align="Right">
         			<b>Cost to Patient: </b></div>
         			<div class="col-md-8">4235</div>

        </div>
        <div class="row">
        	<div class="col-sm-7"></div>
        	<div class="col-sm-5" style="color: #173479;font-weight: bold;">Total Quantity(No.):
        		<label style="color: #736767;">1000</label></div>
        </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-success" onclick="validateFunc();">Ok&Save</button>
        </div>
 -->      </div>
      
    </div>
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
		  addDp("strMfgDate"+new_row.id);
		  addDp("strExpDate"+new_row.id);	  
	}

	function addDp(id){
		
		  $("#"+id).datepicker({ uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});

		var today=new Date();
		var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
		var mmm=arr[today.getMonth()];
		var hrs=today.getHours();
		var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
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


function validate1()
{
	
	var flag = false;
	//var cboCountry = document.getElementsByName("strCountry")[0];
	document.getElementById("savebutton").setAttribute("data-target", "#validateModal"); 

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if (retVal) {
// 		previewForm();	
		save();
	}
}

//call on cancel button 
function cancelToDesk(){
	document.forms[0].hmode.value="CANCELTODESK";
	document.forms[0].submit();
}



function previewForm()
{
	alert("strSearchDrug  "+document.getElementsByName("strSearchDrug").length);
	 var x = document.getElementById('POITable');
	 var y=x.querySelectorAll("tbody")[0];
	 var len = y.rows.length;
	 var otd="<td>";
	 var otd1="<td style='line-height: 15px;'>";
	 var ctd="</td>";
	 var otr="<tr>";
	 var ctr="</tr>";
	 var tmpdiv1="";
		alert("length ::"+len);
	var lDiv = "<div class='col-sm-3' align='right'><label style='margin-bottom: 1;'>";
	var rDiv = "<div class='col-sm-2'>";
	var cDiv = "</div>";
	
	var tmpDiv = lDiv + "<b>LP Delivery Challan No. : </b>"+ cDiv + rDiv + document.forms[0].strDCNo.value + cDiv + rDiv + cDiv + lDiv + "<b>LP Invoice No. : </b>"+ cDiv + rDiv + document.forms[0].strInvoiceNo.value + cDiv;
	tmpDiv = tmpDiv + lDiv + "<b>LP Delivery Challan Date : </b>"+ cDiv + rDiv + document.forms[0].strChallanDate.value + cDiv + rDiv + cDiv + lDiv + "<b>LP Invoice Date : </b>"+ cDiv + rDiv + document.forms[0].strInvoiceDate.value + cDiv;
	//tmpDiv = tmpDiv + lDiv + "<b>Supplier : </b>"+ cDiv + rDiv + document.forms[0].strSupplier[document.forms[0].strSupplier.selectedIndex].text  + cDiv + rDiv + cDiv + rDiv + cDiv + lDiv + cDiv + rDiv + cDiv ;
	tmpDiv = tmpDiv + lDiv + "<b>Supplier : </b>"+ cDiv + rDiv + document.forms[0].strSupplier[document.forms[0].strSupplier.selectedIndex].text + cDiv + rDiv + cDiv + lDiv + "<b>LP L.P.O No. : </b>"+ cDiv + rDiv + document.forms[0].strLpoNo.value + cDiv;
		
		var gtot=0;
	 var i=1;
	 do
	 {
		//alert("purwidtax"+ document.getElementsByName("strPurRate")[i].value +"-----"+document.getElementsByName("strPurWidTax")[i].value);
		var purtax = parseFloat(document.getElementsByName("strPurRate")[i].value)+(parseFloat(document.getElementsByName("strPurRate")[i].value) * parseFloat(document.getElementsByName("strGST")[i].value))/100 ;
		alert(purtax);
		 tmpdiv1 = tmpdiv1 + "<tr>";
		tmpdiv1 = tmpdiv1 + otd + (i) + ctd;
		tmpdiv1 = tmpdiv1 + otd1 + document.getElementsByName("strSearchDrug")[i].value + ctd;
		tmpdiv1 = tmpdiv1 + otd + document.getElementsByName("strTotalQty")[i].value + ctd;
		tmpdiv1 = tmpdiv1 + otd + document.getElementsByName("strbatchno")[i].value + ctd;
		tmpdiv1 = tmpdiv1 + otd + document.forms[0].strItemCategoeryName.value + ctd;
		tmpdiv1 = tmpdiv1 + otd + document.getElementsByName("strExpDate")[i].value + ctd;
		tmpdiv1 = tmpdiv1 + otd + document.getElementsByName("strGST")[i].value + ctd;
		tmpdiv1 = tmpdiv1 + otd + document.getElementsByName("strPurRate")[i].value + ctd;
		tmpdiv1 = tmpdiv1 + otd + purtax  + ctd;
		var totamt = Math.round((parseFloat(purtax) * parseFloat(document.getElementsByName("strTotalQty")[i].value)) *100.0)/100.0;
		
		tmpdiv1 = tmpdiv1 + otd + totamt.toFixed(2) + ctd;
		tmpdiv1 = tmpdiv1 + "</tr>";
		gtot = gtot + totamt;
		i++;
		//tmpdiv1 = tmpdiv1 + otd + document.getElementsByName("strSearchDrug")[i].value + ctd;
	 }while(i < parseInt(len/2))

	 document.getElementById("previewItem").innerHTML=tmpDiv;
	 document.getElementById("itemrow").innerHTML=tmpdiv1;
	 document.getElementById("gtotal").innerHTML=gtot.toFixed(2);
	// document.getElementById("savebutton").setAttribute("data-target","#preModal");
		$('#preModal').modal('show');
}

	</script>
	
	<input type="hidden" name="hmode"/>
<input type="hidden" name="strCtDate" value="${AckSuppReceiptBean.strCtDate}" />
<input type="hidden" name="strStoreId" value="${AckSuppReceiptBean.strStoreId}" />
<input type="hidden" name="strItemCategoeryName" value="${AckSuppReceiptBean.strItemCategoeryName}" />
<input type="hidden" name="strItemCategoryNo" value="${AckSuppReceiptBean.strReqTypeId}" />

<cmbPers:cmbPers />

</html:form>


<input type="hidden" name="hmode"/>
<input type="hidden" name="strCtDate" value="${AckSuppReceiptBean.strCtDate}" />
<input type="hidden" name="strStoreId" value="${AckSuppReceiptBean.strStoreId}" />
<input type="hidden" name="strItemCategoeryName" value="${AckSuppReceiptBean.strItemCategoeryName}" />
<input type="hidden" name="strItemCategoryNo" value="${AckSuppReceiptBean.strReqTypeId}" />
</body>
</html>