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
	
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>

<script language="JavaScript" src="../js/BreakageItemDtlTrans.js"></script>

<style type="text/css">
.col-sm-1half, .col-sm-8half, .col-sm-half {
    position: relative;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}
.custom-radio .custom-control-label::before {
    background-color: white;  /* orange */
}

.col-md-1half, .col-md-8half, .col-md-half {
    position: relative;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}
@media (min-width: 768px) {
    .col-sm-1half,.col-md-1half, .col-sm-8half {
        float: left;
    }
    .col-sm-1half ,.col-md-1half{
        width: 12.495%;
    }
    .col-sm-half,.col-md-half {
        width: 4.165%;
    }
    .col-sm-2half,.col-sm-2half {
        width: 20.495%;
    }
}
.table
{
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-weight: 400;
	color: #212529;
}
textarea
{
width:100%;

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
	//alert(document.getElementsByName("strCostRequired")[0].value);
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
<fieldset>

	<legend style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400;margin-left:10px;color: #666;" id='nonPrintableLegend'>
            Breakage/Lost Item Details
	</legend>
	<div class="legend2" id='nonPrintableLegend2'>
	
	<button  type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" onclick="transferToViewPageNEW();">
			<i class="fas fa-eye iround"  title="View"></i>
		</button>
		<button  type="button" class="btn btn-outline-danger mt-1 btn-circle" onclick="cancelFunc();" style="background-color: #d9534f;">
			<i class="fa fa-ban iround"  title="Cancel"></i>
		</button>	
	</div>
	
	
	<div id="nonPrintable">
			<div class="container-fluid">	
						<div class="prescriptionTile">
		
	
	
    <div class="errMsg"     id="errMsg"><bean:write name="bkgItemDtlTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="bkgItemDtlTransBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="bkgItemDtlTransBean" property="strMsg"/></div>
 
 

 
 
	<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-1" align="left"><label>Type:</label></div>
			<div class=" col-md-1 custom-control custom-radio">
  				<input type="radio" class="custom-control-input" id="defaultGroupExample1" name="strBreakageMode" checked>
 				 <label class="custom-control-label" for="defaultGroupExample1">Breakage</label>
			</div>
			
			<!-- <div class="col-md-1 custom-control custom-radio">
			   <input type="radio" class="custom-control-input" name=strBreakageMode value="1"  tabindex="1" onClick="changeViewMode(this);"  />
			   <label class="custom-control-label" for="defaultGroupExample1">Breakage</label>
				
			</div> -->
			<div class="col-md-1 custom-control custom-radio">
			   <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="strBreakageMode" value="1"  tabindex="1" onClick="changeViewMode(this);"  />
			   <label class="custom-control-label" for="defaultGroupExample2">Lost</label>
			   <!-- <input type="radio" name="strLostMode" value="2" tabindex="1" onClick="changeViewMode(this);"  />Lost -->

			</div>
			
			<div class="col-md-1half" align="right"><font color="red">*</font><label>Store Name</label></div>
			<div class="col-md-2half" align="left">
			 <div id="storeCmbDivIdOne">
			     <select name="strStoreName" class="form-control"  tabindex="1" onChange="getItemCategoryCombo();">
                        <bean:write name="bkgItemDtlTransBean" property="strStoreName" filter="false"/>
                 </select>
              </div><div id="storeCmbDivIdTwo" style="display:none; color:blue;"></div> 
          	</div>
          	
          	<div class="col-md-1half" align="right"><font color="red">*</font>Item Category</div>
			<div class="col-md-1half" align="left" style="width:14%">
			<div id="itemCatgCmbDivIdOne">	
			<div id="ItemCatg" >
			     <select name='strItemCatgCombo' class="form-control" tabindex="1"> 
		              <bean:write name="bkgItemDtlTransBean" property="strItemCatgCombo" filter="false"/><option value="0">Select Value</option>  
		         </select>
		     </div>    
		     </div>
		     <div id="itemCatgCmbDivIdTwo" style="display:none; color:blue;"></div>
        	</div>
        	<div class="col-md-1"></div>
	  </div>  
	    
        <div class="row">
        	<div class="col-md-1"></div>
			<div class="col-md-10" align="right">
			<img   style="cursor: pointer;height: 20px" title='Click Here To Search Items' height="20" align="middle" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" onclick='getItemSelectPopup();'>
			
			</div>
			
			<div class="col-md-1"></div>
		</div>	
	
	<div id='costDivReqId' style="display: none" class="table-responsive">
		
	   <table class="table table-striped text-uppercase" cellpadding="1px" cellspacing="1px"  bgcolor="black">
	   		
			<tr>
			<td class="font-weight-bold" width="20.66%"><label>Item Name</label></td>
			
			<td  class="font-weight-bold" width="13.66%" >Batch/SlNo</td>
			<td  class="font-weight-bold" width="15.66%">InHand Qty</td>
			<td  class="font-weight-bold" width="13.66%">
			<div id="id11"><font color='red'>*</font>Bkg Qty</div>
			<div id="id21"><font color='red'>*</font>Lost Qty</div>
			</td>
			
			<td class="font-weight-bold"  width="19.66%"><font color='red'>*</font>Unit</td>
			<td class="font-weight-bold" width="16.66%">Approx Cost</td>
			</tr>
			
			</table>
	</div>
		
		<div id='costDivNotReqId' style="display: none" class="table-responsive">
			<table class="table table-striped text-uppercase" align="center" cellpadding="1px" cellspacing="1px"  bgcolor="black">
	   		
			<tr>
			<td class="font-weight-bold" width="20%">Item Name</td>
			
			<td  class="font-weight-bold" width="20%" >Batch/SlNo</td>
			<td  class="font-weight-bold" width="20%">InHand Qty</td>
			<td  class="font-weight-bold" width="20%"><font color='red'>*</font>Bkg Qty</td>
			
			<td class="font-weight-bold"  width="20%"><font color='red'>*</font>Unit</td>
				
			</tr>
			
			</table>
		</div>
		<div id='totalCostId' style="display: none">
        		<label class="LABEL">Total Approx Cost(Rs):</label>
         		<div id='strApproxAmtDivId' align="center" style="display: none;">0.00</div>
         		<input disabled="disabled" style="color: red; font-weight: bold" name="strApproxAmt" value="0.00" type="text" size="10">
         </div>
         <hr>
         <div class="row">
         	
         	<div class="md-col-10 px-4"><div id=''><label style="font-size: 1rem;">Approved Details</label></div></div>	
         	<div class="col-md-1"></div>
         </div>
         <div class="row">
         	 <div class="col-md-1"></div>
         	<div class="col-md-2 "><font color='red'>*</font><label>Approved By</label></div>
         	<div class="col-md-3">
       				 <div id="ApprovedBy" >
					     <select name='strApprovedBy' tabindex="1" class='form-control' > 
				              <bean:write name="bkgItemDtlTransBean" property="strApprovedBy" filter="false"/><option value="0">Select Value</option>  
				         </select>
		            </div>   
       		</div>
       		
       		<div class="col-md-2" align="right">
       				<font color='red'>*</font><label>Approved Date</label>
       			</div>
       		<div class="col-md-3">
       			 <input id="datepicker"/>
    			<script>
        			$('#datepicker').datepicker({
            		uiLibrary: 'bootstrap4'
        			});
    			</script>	
    		</div>
    		<div class="col-md-1"></div>
    	</div>
    		<div class="row">
    			<div class="col-md-1"></div>
       			<div class="col-md-2">
       				<font color='red'>*</font>Approved Remarks
       			</div>
       			<div class="col-md-8">
       				<textarea class="form-control" name="strAprovedRemarks" tabindex="1"></textarea>
       			</div>
        </div>
       
       <hr>
     <div class="row"> 
     	<div class="col-md-1"></div>
        <div class="col-md-2"> Remarks</div>
        <div class="col-md-8">

        <textarea class="form-control" name="strRemarks" cols="20" rows="2"id="strRemarks" tabindex="1"></textarea> 
    	</div>
     </div>
	<div class="row">
		<div class="col-md-12" align="right">
			 <font size="2" color="red">*</font> Mandatory Fields  , ['*'] Reserved/Branded Item
		</div>
	</div>
	<br>
	
    <div class="row" align="center" id=" ">			
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
					 	<!-- <a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a> -->
						 
					<!-- 	<a href="#" class="button" onclick="cancel('CANCEL');"><span class="cancel">Cancel</span></a> -->
	</div> 
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
    
    
    
    </fieldset>
</html:form>
<jsp:include page="breakageItem_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>
