<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta charset=UTF-8">
<title>Breakage/Lost Item Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_utilNEW.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>

<script language="JavaScript" src="../js/BreakageItemDtlTransNEW.js"></script>

<!-- added 20 April 2020 -->
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
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
	
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
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script><!-- end -->
	
<style type="text/css">
.comboMin{
	display: inline-block;
	width: 100%;
	height: calc(1.5em + 0.75rem + 2px);
	padding: 0.375rem 1.75rem 0.375rem 0.75rem;
	font-size: 0.8rem;
	font-weight: 400;
	line-height: 1.5;
	color: #495057;
	vertical-align: middle;
	background: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 4 5'%3e%3cpath fill='%23343a40' d='M2 0L0 2h4zm0 5L0 3h4z'/%3e%3c/svg%3e") no-repeat right 0.75rem center/8px 10px;
    background-color: rgba(0, 0, 0, 0);
	background-color: #fff;
	border: 1px solid #ced4da;
	border-radius: 0.25rem;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
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

.table .thead-dark {
  	color: #000 !important;
  	border: none !important;
  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
}
.thead-dark th{
	background:none !important;
	border: none !important;
	padding: 0.25rem;
    text-align: center;	
}

</style>

<script type="text/javascript">

function calculateCostOnChange(index) 
{
//alert("Hello");

	if (document.getElementById("strUnitName" + index).value != "0"	&& document.getElementById("strBkgQty" + index).value != "") 
	{
	    var bkgQtyQtyUnit  = document.getElementById("strUnitName" + index).value;
		var bkgQty      = (document.getElementById("strBkgQty" + index).value)*(bkgQtyQtyUnit.split("^")[1]);
		
		
		var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		var avlQtyBaseVal = temp[0];

		
		if (parseFloat(avlQtyBaseVal) < bkgQty) 
		{
			alert("Breakage Quantity should not be Greater than Inhand Quantity");
			document.getElementById("strBkgQty" + index).value = 0;
			calculateTotalCost(index);
			return false;
		}

	} 
	else 
	{
		if(document.getElementById("strUnitName" + index).value == "0") 
		{
			alert("Please Select Unit!!!");
		}
		
			calculateTotalCost(index);
		return false;

	}
	calculateTotalCost(index);
}




function calculateTotalCost(index) 
{      
	    var  temp1          = document.getElementById("itemCalcValue" + index).value.split("^");
        var  rateObj        = temp1[1];
            
	    //var rateObj = document.getElementById("itemParamValue"+index).value.split("^")[4];
		var qtyObj  = document.getElementById("strBkgQty"+index).value;
       	var  qty_base_value = document.getElementById("strUnitName"+index).value.split("^")[1];
		
       					
			var qty    = qtyObj;	
			var rate   = rateObj;
		
		
		    var total = parseFloat("0.00");
		
			if(isNaN(rate) || rate=="") rate = "0";
			if(isNaN(qty)  || qty=="") qty = "0";
			if(qty=='0')
			{
			   total = parseFloat("0.00");
			}
			else
			{
			   total = parseFloat(qty * qty_base_value * rate);	
			} 
		 
						
			document.getElementById("strCostFinalDivId"+index).value = total;
			document.getElementById("strCostFinal"+index).value= total;
			
			
			var cost=document.getElementById("strCostFinalDivId"+index).value;
			
			
			totalCostforNewDemand(index);
			
	return true;
}

function calUnitBaseCost(mode,index,selected_obj)
{
               var issueQty      = (document.getElementById("strBkgQty" + index).value)*(selected_obj.value.split("^")[1]);
		       var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		       var avlQtyBaseVal = temp[0];
		    
		    
			    if (parseFloat(avlQtyBaseVal) < issueQty) 
			    {
				  alert("Breakage Quantity cannot be greater than Avalaible Quantity");
				  document.getElementById("strBkgQty" + index).value = "0";
				  document.getElementsByName("strUnitName"+ index).value = "0";
				  calculateTotalCost(index);
				 
				   return false;
			    }
			    else
			    {
			    
			       
		            var  temp1          = document.getElementById("itemCalcValue" + index).value.split("^");
		            var  rateObj        = temp1[1];
			   
				    var  qtyObj         = document.getElementById("strBkgQty"+index).value;
				    if(selected_obj.value=='0')
				    {
				       var  qty_base_value = '0';
				    }
				    else
				    {
				       var  qty_base_value = selected_obj.value.split("^")[1];
				    } 
				    
		       					
					var qty    = qtyObj;	
					var rate   = rateObj;
				
					var total = parseFloat("0.00");
				
					if(isNaN(rate) || rate=="") rate = "0";
					if(isNaN(qty)  || qty=="") qty = "0";
							
					    if(qty=='0' || selected_obj.value =='0' ||selected_obj.value=='')
						{
						   total = parseFloat("0.00");
						}
						else
						{
						   total = parseFloat(qty * qty_base_value * rate);	
						} 
					
					document.getElementById("strCostFinalDivId"+index).value = total;
					document.getElementById("strCostFinal"+index).value= total;
					
					var cost=document.getElementById("strCostFinalDivId"+index).value;
					
					calculateTotalCost(index);
            
			    
			    }
           
           
           
}

function totalCostforNewDemand(index)
{	   


       	    var costObj = document.getElementsByName("strCostFinal");
			var total = parseFloat("0.00");
			//alert(costObj.length);
		   	if (costObj.length > 0) 
			{
				
		       
				for ( var i = 0; i <costObj.length-1; i++)
				{		
				
//				alert("costObj"+costObj[i].value);        	
						
					total = total + parseFloat(costObj[i].value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strApproxAmtDivId").value = total;
	   document.getElementsByName("strApproxAmt")[0].value=total;
        
       
}


/*


function totalIssueCost()
{
       	    var costObj = document.getElementsByName("strCostFinal");
			var total = parseFloat("0.00");
			
		   	if (costObj.length > 0) 
			{
		        
				for ( var i = 0; i <costObj.length; i++)
				{		        					
					
					total = total + parseFloat(document.getElementById("strCostFinalDivId"+i).value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strApproxAmtDivId").disabled = false;
	    document.getElementById("strApproxAmtDivId").value = total;
	     document.getElementById("strApproxAmtDivId").disabled = true;
        document.forms[0].strApproxAmt.value=total;
       
}

function calculateCostOnChange(index)
{
	 alert("index"+index);
	 
	 if (document.getElementById("strUnitName" + index).value != "0"	&& document.getElementById("strBkgQty" + index).value != "") 
		{
			var BkgQty      = document.getElementById("strBkgQty" + index).value;
			var BkgQtyUnit  = document.getElementById("strUnitName" + index).value;
		//	var reqQty        = document.getElementById("strReqQty" + index).value;
			var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
			var avlQtyBaseVal = temp[0];
	
			
				document.getElementById("strBkgQty" + index).value = "0";
				calculateTotalCost(index);
		} 
}

*/

/*
function calculateTotalCost(index) 
{      
	  
	    var rateObj = (document.getElementById("itemParamValue"+index).value.split("#")[1]).split("^")[1];
		var qtyObj  = document.getElementById("strBkgQty"+index).value;
       					
			var qty    = qtyObj;	
			var rate   = rateObj;
		
			var total  = 0;
		
			if(isNaN(rate) || rate=="") rate = "0";
			if(isNaN(qty)  || qty=="") qty = "0";
			
			total = rate*qty;
			document.getElementById("strCostFinal"+index).value = total;
			
//			totalCostforNewDemand();
			
//	return true;
}


//

function calculateCostOnChange(mode, index, unitObject)
{
	if( checkQty(index,'strBkgQty','strUnitName'))
		 {
		 
		 		calculateCost(mode, 'strBkgQty', 'strUnitName', 'strCostFinal', index , 'strApproxAmt','1');
		 }
}

*/

   function invokeCheckQty(mode, index, unitObject)
	{
	   // alert(unitObject);
	    //if( document.getElementById(unitObject + "" + index).value!=0){
	    	///alert(checkQty(index,'strReqQty','strUnitName'))
	   // } 
	  if( checkQty(index,'strBkgQty','strUnitName'))
		 {
		 
		 		calculateCost(mode, 'strBkgQty', 'strUnitName', 'strCostFinal', index , 'strApproxAmt','1');
		 }
			
		 
	}	
	


    function CallFunc()
	{
			 var unitNameCmb = document.getElementsByName("strUnitName");
			 var strBkgQty = document.getElementsByName("strBkgQty");	
			    for(var i=0;i<unitNameCmb.length;i++)
				{
					 document.getElementsByName("strUnitName")[i].disabled=false;
					  strBkgQty[i].value = "0";	
				}
				
 			
	 		  
	}

	
	function getItemSelectPopup()
	{
	   setItemDtlWithIssueQty();
	   var    StoreCmb   = document.forms[0].strStoreName.value;
	   var ItemCatgCmb   = document.forms[0].strItemCatgCombo.value;
	   
	   if(StoreCmb!=0 && ItemCatgCmb!=0)
       {	
	    var strModeVal 					= "3" ; 
		var strRequestType              = "56";
		var strItemCategory 			= ItemCatgCmb;
		var strFromStoreId 				= StoreCmb;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strBkgQty','strUnitName','strCostFinal');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','t');
		var testFunction                = "setQtyDetails";
		var arg                         = " ";  
		
		var strMultiRowFetchDataArray 	= new Array('1','4','11','0^strUnitName^calUnitBaseCost');
		    
	    var layerIndex = "1";
		//alert(strItemCategory)
		//alert(strFromStoreId);
		//alert(strItemCategory);
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
        chequeDiv();
	  }
	  else
	   {
	       if(ItemCatgCmb ='0')
	       {
	           alert("Please Select Item Category!!!");
	           ItemCatgCmb.focus();
	       }
	   	   if(StoreCmb = '0')
	       {
	           alert("Please Select Store Name!!!");
	           StoreCmb.focus();
	       }
	      
	    return false;
	 }
}

function setQtyDetails()
{
	
  		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strBkgQty");
  		//var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		var costObj     = document.getElementsByName("strCostFinal");
		
		if(itemWithIssueQty.value.length > 1){
		
			var itemWithIssueQtyArray = itemWithIssueQty.value.split("$$$$");
			
				for(var i = 0 ; i < itemUserVal.length -1 ; i++){
				
					for(var j = 0 ; j < itemWithIssueQtyArray.length ; j ++){
				
								
							var newArrayTemp = itemWithIssueQtyArray[j].split('@@@@');
				
							if( itemUserVal[i].value == newArrayTemp[0] ){
							
								issueQty[i].value = newArrayTemp[1];
								//reqQty[i].value = newArrayTemp[2];
								unitNameCmb[i].value = newArrayTemp[2];
								costObj[i].value = newArrayTemp[3];
							
							}
					
					}
							
				}
			
					itemWithIssueQty.value = "";
			
				var finalTotal = parseFloat("0");
			
				 for ( var i = 0; i <costObj.length - 1; i++)
					{		        					
		
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}		
			        finalTotal = roundValue(finalTotal, 2);
			         document.getElementById("strApproxAmtDivId").value = finalTotal;
	                 document.getElementsByName("strApproxAmt")[0].value=finalTotal;
			
			
					
		} 
	
	}
function setItemDtlWithIssueQty()
{
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strBkgQty");
  		//var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		var costObj     = document.getElementsByName("strCostFinal");
		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{

															
					if(i == 0 )
					{
						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+unitNameCmb[i].value+"@@@@"+costObj[i].value;	
						
					}
					else
					{
					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+unitNameCmb[i].value+"@@@@"+costObj[i].value;
					
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}

function costReq()
{	
         document.forms[0].strTypeMode.value = '1'; 
        document.forms[0].strBreakageMode.checked = true;
 		document.forms[0].strLostMode.checked = false;
 		
 	
	if(document.getElementsByName("strCostRequired")[0].value=="1"){
		
		document.getElementById("costDivReqId").style.display="block";
		document.getElementById("costDivNotReqId").style.display="none";
		document.getElementById("totalCostId").style.display="block";
	}else{
		document.getElementById("costDivNotReqId").style.display="block";
		document.getElementById("costDivReqId").style.display="none";
		document.getElementById("totalCostId").style.display="none";
	}
}
function chequeDiv()
{
     document.getElementById("storeCmbDivIdOne").style.display="none";
     document.getElementById("storeCmbDivIdTwo").style.display="block";
     document.getElementById("storeCmbDivIdTwo").innerHTML = document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;
     document.getElementById("itemCatgCmbDivIdOne").style.display="none";
     document.getElementById("itemCatgCmbDivIdTwo").style.display="block";
      document.getElementById("itemCatgCmbDivIdTwo").innerHTML =document.forms[0].strItemCatgCombo[document.forms[0].strItemCatgCombo.selectedIndex].text;
}


/**
 * changeViewMode
 * @param {Object} chkObj 
 */
 function changeViewMode(chkObj)
{ 	
    if(chkObj.value =='1')
 	{ 	
     	
 		 document.forms[0].strTypeMode.value = '1'; 
 		 document.forms[0].strBreakageMode.checked = true;
 		 document.forms[0].strLostMode.checked = false;
 		document.getElementById("id11").style.display="block";
 		document.getElementById("id21").style.display="none";
 		 
 	}
 	if(chkObj.value =='2')
 	{ 		 
 		 
 		 document.forms[0].strTypeMode.value = '2'; 
        
         document.forms[0].strBreakageMode.checked = false;
 		 document.forms[0].strLostMode.checked = true;
 		document.getElementById("id11").style.display="none";
 		document.getElementById("id21").style.display="block";
 	}
}
 function onloadcheck()
 {
	 document.getElementById("id11").style.display="block";
	 document.getElementById("id21").style.display="none";
} 

</script>

</head>

<body onload="costReq();getItemCategoryCombo();onloadcheck();">

<html:form action="/transactions/BreakageItemDtlTransCNTNEW.cnt"  name="bkgItemDtlTransBean" type="mms.transactions.controller.fb.BreakageItemDtlTransFB" method="post">
	 			<div class="errMsg"     id="errMsg" style="font-size:18px;"><bean:write name="bkgItemDtlTransBean" property="strErr"/></div>
				<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="bkgItemDtlTransBean" property="strWarning"/></div>
				<div class="normalMsg"  id="normalMsg" style="font-size:18px;"><bean:write name="bkgItemDtlTransBean" property="strMsg"/></div>

<%-- <div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="rateContractDtlBean" property="strErr" /></div>
<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
--%>	
<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader my-2' id='nonPrintableLegend' style="font-weight:600;font-size: 18px;" >Breakage/Lost Item Details</div>
					
<!--   <legend style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400;margin-left:10px;color: #666;" id='nonPrintableLegend'> Breakage/Lost Item Details</legend>
 -->  
 <div class="legend2" id='nonPrintableLegend2'>
		<button type="button" 
			class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
			onclick="cancelFunc();" style="border-radius:50%;  padding:12px 12px" title="Cancel">
			<i class="fas fa-times fa-lg iround" title="Cancel"></i>
		</button>
		<button type="button" class="float-right btn btn-secondary btn-circle"
			onclick="document.forms[0].reset();"
			style="border-radius:50%; padding:12px 7px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Clear">
			<i class="fas fa-broom fa-lg iround" title="Clear"></i>
		</button>
		<button  type="button" class="float-right btn btn-primary mt-1 btn-circle printbtn" style="border-radius:50%;  padding:12px" onclick="transferToViewPageNEW();"  title="View">
			<i class="fas fa-eye iround"  title="View"></i>
		</button>
		<button type="button" id="savebutton"
			class="float-right btn btn-success mt-1 btn-circle"
			tabindex='2' onClick="return validate1();"
			name="patientAdmissionModiTransBean"
			style="border-radius:50%;  padding:12px 10px">
			<i class="fa fa-download fa-lg iround" title="Save"></i>
		</button>
 </div>
	
	<div class="container">
		<div class="row my-2">
			<div class="col-sm-1">
				<div class="custom-control custom-radio">
					<input type="radio" id='customRadio'
						class="custom-control-input" name="strBreakageMode" checked="checked" value="1"
						onclick="changeViewMode(this);"> <label
						class="custom-control-label" for="customRadio">Breakage</label>
				</div>
			</div>
			<div class="col-sm-1">
				<div class="custom-control custom-radio">
					<input type="radio" id='customRadio1'
						class="custom-control-input" name="strLostMode"
						value="2" onclick="changeViewMode(this);"> <label
						class="custom-control-label" for="customRadio1">Lost</label>
				</div>
			</div>
	   </div>
	   <br>
	   <div class="row ">
			<div class="col-md-2">Store Name<font color="red">*</font></div>
			<div class="col-md-4">
				<div id="storeCmbDivIdOne">
	    			<select name="strStoreName" class="browser-default custom-select"  tabindex="1" onChange="getItemCategoryCombo();">
	                		<bean:write name="bkgItemDtlTransBean" property="strStoreName" filter="false"/>
	           		</select>
		        </div>
	       		 <div id="storeCmbDivIdTwo" style="display:none;color:blue;"></div> 
			</div>
			
			
			<div class="col-md-2">Item Category<font color="red">*</font></div>
			<div class="col-md-4">
				<div id="itemCatgCmbDivIdOne">	
					<div id="ItemCatg">
	    				<select name='strItemCatgCombo' class="browser-default custom-select" tabindex="1"> 
	          				 	<bean:write name="bkgItemDtlTransBean" property="strItemCatgCombo" filter="false"/><option value="0">Select Value</option>  
	       				</select>
   					</div>    
  				</div> 
  				<div id="itemCatgCmbDivIdTwo" style="display:none;"></div>
			</div>
	   </div>
<hr>
	   <div class="row">
		   <div class="col" align="right">
				<button type="button" class="btn btn-success"  onclick='getItemSelectPopup();' title="Click Here To Search Items">
					<i class="fas fa-search" >&nbsp;<span>Item Finder</span></i>
				</button>
				<!-- <img style="cursor: pointer;height: 20px" title='' height="20" align="middle" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" > -->
		  </div>
	  </div>
<hr>					
	  <div id='costDivReqId' style="display: none">
		   <table class="table" >
		   		<thead class='thead-dark' align='center'>
					<tr>
					<th width="35%" style="font-weight:350 !important ;font-size: 16px !important;">Item Name</th>
					<th width="15%" style="font-weight:350 !important ;font-size: 16px !important;">Batch/SlNo</th>
					<th width="15%" style="font-weight:350 !important ;font-size: 16px !important;">InHand Qty</th>
					<th width="15%" style="font-weight:350 !important ;font-size: 16px !important;">
						<div id="id11">Bkg Qty<font color='red'>*</font></div>
						<div id="id21">Lost Qty<font color='red'>*</font></div>
					</th>
					<th width="10%" style="font-weight:350 !important ;font-size: 16px !important;">Unit<font color='red'>*</font></th>
					<th width="15%" style="font-weight:350 !important ;font-size: 16px !important;">Approx Cost</th>
					</tr>
				</thead>
		  </table>
	  </div>
	  <div id='costDivNotReqId'  style="display: none">
		<table class="table text-uppercase" align="center" >
		   		<thead class='thead-dark' align='center'>
				<tr>
					<th width="35%" style="font-weight:350 !important ;font-size: 16px !important;">Item Name</th>
					<th width="15%" style="font-weight:350 !important ;font-size: 16px !important;" >Batch/SlNo</th>
					<th width="15%" style="font-weight:350 !important ;font-size: 16px !important;">InHand Qty</th>
					<th width="10%" style="font-weight:350 !important ;font-size: 16px !important;">Bkg Qty<font color='red'>*</font></th>
					<th width="15%" style="font-weight:350 !important ;font-size: 16px !important;">Unit<font color='red'>*</font></th>
				</tr>
		</table>
		</div>	
       	<div id="id1"></div>
    
		<div class="row">
			<div class="col-md-12" id='totalCostId' style="display: none;" align="right">
    			<label class="LABEL">Total Approx Cost(Rs):</label>
    			<div id='strApproxAmtDivId' align="center" style="display: none;">0.00</div>
     				<input disabled="disabled" style="color: red; font-weight: bold" name="strApproxAmt" value="0.00" type="text" size="10">   
			</div>	
		</div>		
		<div class="row">
			<div class="col"><i class="fas fa-thumbs-up" style="font-size:20px;"></i>&nbsp;<label>Approved Details</label></div>
		</div>
	<div class="container">
		<div class="row my-1">
			<div class="col-md-2 "><font color='red'>*</font><label>Approved By</label></div>
			<div class="col-md-4">
				<div id="ApprovedBy" >
				     <select name='strApprovedBy' tabindex="1" class="browser-default custom-select"> 
			              <bean:write name="bkgItemDtlTransBean" property="strApprovedBy" filter="false"/><option value="0">Select Value</option>  
			         </select>
            	</div>
           	</div>
			<div class="col-md-2"><font color='red'>*</font><label>Approved Date</label></div>
			<div class="col-md-4">
				<input  name="strApprovedDate" class="form-control datepicker" value="${bkgItemDtlTransBean.strCurrentDate}" style="color: rgba(113, 111, 111, 0.87);">
				<%-- <input id="datepicker" name=""  value="${bkgItemDtlTransBean.strCurrentDate}"/> --%>
   			</div>
		</div>
	
		<div class="row my-1">
			<div class="col-md-2 "><font color='red'>*</font>Approved Remarks</div>
			<div class="col-md-9">
				<textarea class="form-control" name="strAprovedRemarks" tabindex="1"></textarea>
			</div>
		</div>
	
	<div class="row my-1">
		<div class="col-md-2"><label> Remarks</label></div>
		<div class="col-md-9">
			<textarea class="form-control" name="strRemarks" cols="20" rows="2"id="strRemarks" tabindex="1" ></textarea>
		</div>
	</div>
</div>
<hr>	
	<div class="row ">
		<div class="col-md-12" align="right"><font size="2" color="red">*</font> Mandatory Fields  , ['*'] Reserved/Branded Item </div>
				
	</div>
	
<!-- 	<div class="row" align="center" id=" ">			
    	<div class="col-md-6" align="right" style="margin-right:-20px;">
   				 <button type="button" id="btnPreID" class="btn btn-info" onclick=' return validate1();'>
                    						<i class="fa fa-save" style="font-size: 24px; width:70px;" aria-hidden="true"></i>
               						 </button>
        </div>
        <div class="col-md-6" align="left">		
    			<button type="button" id="btnPreID" class="btn btn-info" onclick="initPage();">
                    						
                    						<span class="clear">Clear</span>
               						 </button>
        </div>       						  		 
					
	</div> 
 -->    	
   		<input type="hidden" name="hmode"/>
     	<input type="hidden" name="strCostRequired" value="${bkgItemDtlTransBean.strCostRequired}"/>
     	<input type="hidden" name="strCurrentDate" value="${bkgItemDtlTransBean.strCurrentDate}"/>
      	<input type="hidden" name="strReOrderFlgColor" value=""/>
      	<input type="hidden" name="strTypeMode" />
      	<input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
    
  	<div id="blanket" style="display:none;"></div>
    <div class="popUpDiv" id="popUpDiv" style="display:none;">
   	 <table bgcolor="white">
      <tr>
      <td>
         <div id="searchItemsDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
    </div>
</div>

</div>    
</div>  
</html:form>
<jsp:include page="breakageItem_itemSearchRowNEW.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex> 

<script type="text/javascript">

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script>

</body>
</html>