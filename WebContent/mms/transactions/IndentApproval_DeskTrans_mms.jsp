<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>


<head>
<meta charset=utf-8>
<title>Indent View</title>

<!-- CSS -->
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<!-- JS -->
<script language="Javascript" src="../js/IndentApproval.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/dropdown.js"></script>
<script language="Javascript" src="../js/mms.js"></script>

<!-- added -->
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
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<script type="text/javascript">
function initPage()
{
   var chkObj = document.getElementsByName("strInsSancQty");
   var issueFrmReservStockObj= document.getElementsByName("strIssueFrmReservStock");
	var len = chkObj.length;
	
	for ( var i = 0; i < len; i++)
	{	
		document.getElementById("strInsSancQty" + i).value = '0';
		issueFrmReservStockObj[i].checked=false;
	}
	document.forms[0].strRemarks.value="";
}
function calUnitBaseCost(index,selected_obj)
{
              
     var issueQty      = (document.forms[0].strInsSancQty.value)*(selected_obj.value.split("^")[1]);
     //var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
     var avlQtyBaseVal = document.forms[0].strAvlQtyReceving.value;
     		    
   if (parseFloat(avlQtyBaseVal) < parseFloat(issueQty)) 
   {
	  alert("Approved Quantity cannot be greater than Avalaible Quantity in Rasining Store!!!");
	  document.forms[0].strInsSancQty.value = "0";
	  document.getElementsByName("strInsUnitCombo"+ index).value = "0";
   	  return false;
   }          
}

function calculateCostOnChange(index,obj) 
{
	if (document.getElementById("strInsUnitCombo" + index).value != "0"	&& document.getElementById("strInsUnitCombo" + index).value != "") 
	{
	    var bkgQtyQtyUnit  = document.getElementById("strInsUnitCombo" + index).value;
		var bkgQty      = (document.getElementById("strInsSancQty" + index).value)*(bkgQtyQtyUnit.split("^")[1]);
		var avlQtyBaseVal = document.forms[0].strAvlQtyReceving.value;
		
		if (parseFloat(avlQtyBaseVal) < parseFloat(bkgQty)) 
		{
			alert("Approved Quantity cannot be greater than Avalaible Quantity in Rasining Store!!!");
			document.getElementById("strInsSancQty" + index).value = 0;
			return false;
		}
	} 
	else 
	{
		if(document.getElementById("strUnitName" + index).value == "0") 
		{
			alert("Please Select Unit!!!");
		}
		return false;
	}
}

function clickChkBox()
{
	   if(document.forms[0].batchCheckbox.checked == true)
	   {
	         var appDtls =  document.forms[0].strSpecialAppDtls.value;
	         
	         alert((document.forms[0].strSpecialAppDtls.value).split("$")[2]);
	                        // user_name $ Level $ Special Approval Flag 
	         if((appDtls.split("$")[2].trim())=="1")
	         {	 
				 var conf = confirm("U Select Special Approval at Level  [ "  + appDtls.split("$")[1] +"  ] \n All the Approval Level Below and Above of Your Level \n Will be Approved/Rejected  Automatically" );
			     if(conf == true)
			     {
			    	  var conf1 = confirm("You Want to Apply Special Approval Power !!!");
				      if(conf1 == true)
				      {
				    	  var conf2 = confirm("Are you sure !!!");
					      if(conf2 == true)
					      {
					    	  document.forms[0].strSpecialAppFlg.value	 = "1";	
							 
						  }
					      else
					      {
					    	  document.forms[0].strSpecialAppFlg.value	 = "0";	
					          return false;	
					      }
					  }
				      else
				      {
 							document.forms[0].strSpecialAppFlg.value	 = "0";	
				          	return false;	
				      }
			     }
		         else
		         {
		        	 document.forms[0].strSpecialAppFlg.value	 = "0";	
		                  
				          return false;	
		         }     
           }
           else
           {
                  alert("Special Approval Power Not Applicable !!");
                  document.forms[0].strSpecialAppFlg.value	 = "0";	
                  document.forms[0].batchCheckbox.checked = false;
		          return false;	
           }  
	   }
	   else
	   {
		   document.forms[0].strSpecialAppFlg.value	 = "0";	
		   return false;	
	   }
}
function controlToMainPage()
{	    
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
}
</script>

<script>
function controlToMainPage()
{	    
	document.forms[0].hmode.value="APPROVAL";
	document.forms[0].submit();
}
</script>


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
   top: -2.1em;
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
	padding: 0.25rem !important;
    text-align: center;	
 }
    
.table td {
  padding: 0.1rem !important;
}
.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 21px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
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
</style>


</head>
<body onload="OnLoadCheck();">
<html:form name="indentApprovalTransBean" action="/transactions/IndentApprovalDeskCNT" type="mms.transactions.controller.fb.IndentApprovalDeskFB">

<div class="container-fluid">
 <div class="prescriptionTile">	
	<center>
		 <div id="errMsg" class="errMsg"         style="font-size:16px;"><bean:write name="indentApprovalTransBean" property="strErrMsg" /></div>
		 <div id="warningMsg" class="warningMsg" style="font-size:16px;"><bean:write name="indentApprovalTransBean" property="strWarning" /></div>
		 <div id="normalMsg" class="normalMsg"   style="font-size:16px;"><bean:write name="indentApprovalTransBean" property="strMsg" /></div>
	</center>
	
  	<div class="row">
		<div class="col-sm-6" style="text-align: initial;">
			<p class="subHeaders mb-0">
				<i class="fas fa-file-alt iround"
					style="font-size: 20px; color: #28a745" title=""></i>
				&nbsp;Indent Approval Desk
			</p>
		</div>
				
		<div class="col-sm-6" id="">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" onclick="cancelToDesk();">
					<i class="fas fa-times iround" title="Cancel"></i>
				</button>
				<button type="button" class="float-right btn btn-secondary btn-circle" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="controlToMainPage();">
					<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;"> -->
					<i class="fas fa-broom iround" title="Clear"></i>
				</button>
				<button type="button" id="saveId" class="float-right btn btn-success mt-1 btn-circle savebtn" tabindex='2' onclick='return validate1();'>
					<i class="fa fa-download fa-beat iround" title="Save"></i>
				</button>
			</div>
		</div>
	</div>
	
 <!--  <div class="legend2" id='nonPrintableLegend2'>
		<button type="button" 
			class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
			onclick="cancelToDesk();" style="border-radius:50%;  padding:10px 12px" title="Cancel">
			<i class="fas fa-times iround" title="Cancel"></i>
		</button>
		onclick="initPage();"
		<button type="button" class="float-right btn btn-secondary btn-circle"
			onclick="controlToMainPage();"
			style="border-radius:50%; padding:10px 8px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Clear">
			<i class="fas fa-broom iround" title="Clear"></i>
		</button>
		<button type="button" id="saveId"
			class="float-right btn btn-success mt-1 btn-circle"
			tabindex='2' onClick=' return validate1();'
			style="border-radius:50%;  padding:10px 10px">
			<i class="fa fa-download iround" title="Save"></i>
		</button>
  </div> -->
 

<div class='popup' id='StockTable' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th style="display:flex;justify-content:right;">
			<img style="cursor:pointer;cursor:pointer" src="../../hisglobal/images/popUp_cancel.JPG" onclick="hideItemDetails('StockTable');">
		</th>
    </tr>
 </table>   
 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">		
	 <tr>
	    <div id="stockTableHLPDiv"></div>
	</tr>
     </table>
</div> 
       
<div class='popup' id='Return' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
		<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
			onClick="hideItemDetails('Return');"></th>
	    </tr>
 	</table>   
 	<table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	 	<tr>
		   <td width='25%' class='multiRPTLabel'>Rate/Unit</td>
		   <td width='25%' class='multiPOControl'><div id ='35'></div></td>
		   <td width='25%' class='multiRPTLabel'>Manufacture Date</td>
		   <td width='25%' class='multiPOControl'><div id ='36'></div></td>	
	 	</tr>  
		 <tr>
		   <td width='25%' class='multiRPTLabel'>Exp Date</td>
		   <td width='25%' class='multiPOControl'><div id ='37'></div></td>
		   <td width='25%' class='multiRPTLabel'></td>
		   <td width='25%' class='multiPOControl'></td>	
		 </tr>  
	 	<tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
    	</table>
</div>
       
<div class='popup' id='Agenda' style="display:none">
	 <table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
		    <th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
		    <th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window'  src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('Agenda');">
		   </th>
	    </tr>
	 </table>   
	 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
		  <tr>
			<td width='25%' class='multiRPTLabel'>Last PO No</td>
			   <td width='25%' class='multiPOControl'><div id ='30'></div></td>
			   <td width='25%' class='multiRPTLabel'>Last Po Date</td>
			   <td width='25%' class='multiPOControl'><div id ='31'></div></td>	
		   </tr>  
	    <tr>
		   <td width='25%' class='multiRPTLabel'>Last Rec Qty</td>
		   <td width='25%' class='multiPOControl'><div id ='32'></div></td>
		   <td width='25%' class='multiRPTLabel'>Last Rec Date</td>
		   <td width='25%' class='multiPOControl'><div id ='33'></div></td>	
		</tr>  
		<tr>
		   <td width='25%' class='multiRPTLabel'>Last Supplied By</td>
		   <td colspan="3" class='multiPOControl'><div id ='34'></div></td>
		</tr>  
		<tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
	 </table>
</div>
   
<div class='popup' id='issueToThirdParty' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('issueToThirdParty');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
		<tr>
			
			<td colspan="1" class='multiRPTLabel'>Rate/Unit</td>
			<td colspan="1" class='multiRPTLabel'>Expiry Date</td>
						
		</tr>
		<tr>
			<td colspan="1" class='multiPOControl'><div id ='28'></div></td>
			<td colspan="1" class='multiPOControl'><div id ='29'></div></td>
			
		</tr>
		<tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
        </table>
	</div>  
                 
<div class='popup' id='ReceiveFrmThirdParty' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='3' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('ReceiveFrmThirdParty');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
		<tr>
			
			<td colspan="1" class='multiRPTLabel'>Exp Date</td>
			<td colspan="1" class='multiRPTLabel'>Item Make</td>
			<td colspan="1" class='multiRPTLabel'>Rate/Unit</td>
			
		</tr>
		<tr>
			
			<td colspan="1" class='multiPOControl'><div id ='100'></div></td>
			<td colspan="1" class='multiPOControl'><div id ='101'></div></td>
			<td colspan="1" class='multiPOControl'><div id ='102'></div></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="3"></td>
		</tr>
        </table>
	</div>            
            
<div class='popup' id='issueDtl' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
onClick="hideItemDetails('issueDtl');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	<tr>
		
		<td colspan="1" class='multiRPTLabel'>ReOrder Value</td>
		<td colspan="1" class='multiRPTLabel'>Last Indent Qty</td>
		<td colspan="1" class='multiRPTLabel'>Last Issue Qty</td>
		
	</tr>
	<tr>
		
		<td colspan="1" class='multiPOControl'><div id ='2'></div></td>
		<td colspan="1" class='multiPOControl'><div id ='3'></div></td>
		<td colspan="1" class='multiPOControl'><div id ='4'></div></td>
	</tr>
	<tr class="FOOTER">
		<td colspan="4"></td>
	</tr>
       </table>
</div>  
 
<div class='popup' id='LpPatStaff' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
onClick="hideItemDetails('LpPatStaff');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	<tr>
		<td colspan="1" class='multiRPTLabel'>Issue Qty.</td>
		<td colspan="1" class='multiRPTLabel'>Return Qty</td>
				
	</tr>
	<tr>
		<td colspan="1" class='multiPOControl'><div id ='12'></div></td>
		<td colspan="1" class='multiPOControl'><div id ='13'></div></td>
	  </tr>
	  <tr class="FOOTER">
		<td colspan="2"></td>
	</tr>
       </table>
</div>  
 
<div class='popup' id='LpDept' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
onClick="hideItemDetails('LpDept');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	<tr>
		<td colspan="1" class='multiRPTLabel'>Issue Qty.</td>
		<td colspan="1" class='multiRPTLabel'>Last Rec Qty</td>
		<td colspan="1" class='multiRPTLabel'>Last Rec date</td>
				
	</tr>
	<tr>
		<td colspan="1" class='multiPOControl'><div id ='14'></div></td>
		<td colspan="1" class='multiPOControl'><div id ='15'></div></td>
		<td colspan="1" class='multiPOControl'><div id ='16'></div></td>
	  </tr>
	 <tr class="FOOTER">
		<td colspan="3"></td>
	</tr>
       </table>
</div>  

<div class='popup' id='IndentCondemnation' style="display:none">
 <table width='400' border="0" cellspacing ="0px">
<tr class="HEADER"> 
	<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
onClick="hideItemDetails('IndentCondemnation');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	
	<tr>
	   <td width='25%' class='multiRPTLabel'>Last PO No</td>
	   <td width='25%' class='multiPOControl'><div id ='17'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last PO Date</td>
	   <td width='25%' class='multiPOControl'><div id ='18'></div></td>
	</tr>
	<tr>
	   <td width='25%' class='multiRPTLabel'>Exp Date</td>
	   <td width='25%' class='multiPOControl'><div id ='19'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last Supply By</td>
	   <td width='25%' class='multiPOControl'><div id ='20'></div></td>	
	 </tr> 
	 <tr class="FOOTER">
		<td colspan="4"></td>
	</tr>
 </table>
</div>

<div class='popup' id='IndentForImported' style="display:none">
<table width='400' border="0" cellspacing ="0px">
<tr class="HEADER"> 
	<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
onClick="hideItemDetails('IndentForImported');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	
	<tr>
	   <td width='25%' class='multiRPTLabel'>Last PO No</td>
	   <td width='25%' class='multiPOControl'><div id ='24'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last PO Date</td>
	   <td width='25%' class='multiPOControl'><div id ='25'></div></td>
	</tr>
	<tr>
	   <td width='25%' class='multiRPTLabel'>Lst Recev Date</td>
	   <td width='25%' class='multiPOControl'><div id ='26'></div></td>
	   <td width='25%' class='multiRPTLabel'>Manufact By</td>
	   <td width='25%' class='multiPOControl'><div id ='27'></div></td>	
	 </tr>  
	 <tr class="FOOTER">
		<td colspan="4"></td>
	</tr>
 </table>
</div>

<div class='popup' id='ReturnRequest' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG' onClick="hideItemDetails('ReturnRequest');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	<tr>
	   <td width='25%' class='multiRPTLabel'>Last PO No</td>
	   <td width='25%' class='multiPOControl'><div id ='21'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last PO Date</td>
	   <td width='25%' class='multiPOControl'><div id ='22'></div></td>
	</tr>
	<tr>
	   <td width='25%' class='multiRPTLabel'>Exp Date</td>
	   <td width='25%' class='multiPOControl'><div id ='23'></div></td>
	   <td width='25%' colspan='2' class='multiLabel'></td>
	   
	 </tr>  
	<tr class="FOOTER">
		<td colspan="4"></td>
	</tr>
 </table>
</div>

<div class='popup' id='AnnualPurchase' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
	<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
		onClick="hideItemDetails('AnnualPurchase');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	
	<tr>
	   <td width='25%' class='multiRPTLabel'>Re-OrderLevel</td>
	   <td width='25%' class='multiPOControl'><div id ='5'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last Year Consumption</td>
	   <td width='25%' class='multiPOControl'><div id ='6'></div></td>
	</tr>
	<tr>
	   <td width='25%' class='multiRPTLabel'>Last PO No</td>
	   <td width='25%' class='multiPOControl'><div id ='7'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last Po Date</td>
	   <td width='25%' class='multiPOControl'><div id ='8'></div></td>	
	 </tr>  
	 <tr>
	   <td width='25%' class='multiRPTLabel'>Last Rec Qty</td>
	   <td width='25%' class='multiPOControl'><div id ='9'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last Rec Date</td>
	   <td width='25%' class='multiPOControl'><div id ='10'></div></td>	
	 </tr>  
	 <tr>
	   <td width='25%' class='multiRPTLabel'>Last Supplied By</td>
	   <td colspan="3" class='multiPOControl'><div id ='11'></div></td>
	 </tr>  
	 <tr class="FOOTER">
		<td colspan="4"></td>
	</tr>
     </table>
</div>
     
 <div class='popup' id='issueDtl' style="display:none">
				<table width='400' border="0" cellspacing ="0px">
					<tr class="HEADER"> 
						<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
						<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
							onClick="hideItemDetails('issueDtl');"></th>
				    </tr>
				 </table>   
				 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
					<tr>
						
						<td colspan="1" class='multiRPTLabel'>ReOrder Value</td>
						<td colspan="1" class='multiRPTLabel'>Last Indent Qty</td>
						<td colspan="1" class='multiRPTLabel'>Last Issue Qty</td>
						
					</tr>
					<tr>
						<td colspan="1" class='multiPOControl'><div id ='2'></div></td>
						<td colspan="1" class='multiPOControl'><div id ='3'></div></td>
						<td colspan="1" class='multiPOControl'><div id ='4'></div></td>
					</tr>
					<tr class="FOOTER">
						<td colspan="4"></td>
					</tr>
			        </table>
				</div>  
   
<div class='popup' id='LpPatStaff' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
	<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
		onClick="hideItemDetails('LpPatStaff');"></th>
    </tr>
 </table>   
 <table width='400' border="0"  bgcolor='#6097BC'cellspacing ="1px" cellpadding="1px">
	<tr>
		<td colspan="1" class='multiRPTLabel'>Issue Qty.</td>
		<td colspan="1" class='multiRPTLabel'>Return Qty</td>
				
	</tr>
	<tr>
		<td colspan="1" class='multiPOControl'><div id ='12'></div></td>
		<td colspan="1" class='multiPOControl'><div id ='13'></div></td>
	  </tr>
	  <tr class="FOOTER">
		<td colspan="2"></td>
	</tr>
       </table>
</div>  

<div class='popup' id='LpDept' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
	<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
		onClick="hideItemDetails('LpDept');"></th>
    </tr>
 </table>   
 <table width='400' border="0"  bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	<tr>
		<td colspan="1" class='multiRPTLabel'>Issue Qty.</td>
		<td colspan="1" class='multiRPTLabel'>Last Rec Qty</td>
		<td colspan="1" class='multiRPTLabel'>Last Rec date</td>
				
	</tr>
	<tr>
		<td colspan="1" class='multiPOControl'><div id ='14'></div></td>
		<td colspan="1" class='multiPOControl'><div id ='15'></div></td>
		<td colspan="1" class='multiPOControl'><div id ='16'></div></td>
	  </tr>
	 <tr class="FOOTER">
		<td colspan="3"></td>
	</tr>
       </table>
</div>  

<div class='popup' id='IndentCondemnation' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
	<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
		onClick="hideItemDetails('IndentCondemnation');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	
	<tr>
	   <td width='25%' class='multiRPTLabel'>Last PO No</td>
	   <td width='25%' class='multiPOControl'><div id ='17'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last PO Date</td>
	   <td width='25%' class='multiPOControl'><div id ='18'></div></td>
	</tr>
	<tr>
	   <td width='25%' class='multiRPTLabel'>Exp Date</td>
	   <td width='25%' class='multiPOControl'><div id ='19'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last Supply By</td>
	   <td width='25%' class='multiPOControl'><div id ='20'></div></td>	
	 </tr> 
	 <tr class="FOOTER">
		<td colspan="4"></td>
	</tr>
 </table>
</div>

<div class='popup' id='IndentForImported' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
	<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
		onClick="hideItemDetails('IndentForImported');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
		
		<tr>
		   <td width='25%' class='multiRPTLabel'>Last PO No</td>
		   <td width='25%' class='multiPOControl'><div id ='24'></div></td>
		   <td width='25%' class='multiRPTLabel'>Last PO Date</td>
		   <td width='25%' class='multiPOControl'><div id ='25'></div></td>
		</tr>
		<tr>
		   <td width='25%' class='multiRPTLabel'>Lst Recev Date</td>
		   <td width='25%' class='multiPOControl'><div id ='26'></div></td>
		   <td width='25%' class='multiRPTLabel'>Manufact By</td>
		   <td width='25%' class='multiPOControl'><div id ='27'></div></td>	
		 </tr>  
		 <tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
	 </table>
</div>

<div class='popup' id='ReturnRequest' style="display:none">
<table width='400' border="0" cellspacing ="0px">
	<tr class="HEADER"> 
		<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
	<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
		onClick="hideItemDetails('ReturnRequest');"></th>
    </tr>
 </table>   
 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
	
	<tr>
	   <td width='25%' class='multiRPTLabel'>Last PO No</td>
	   <td width='25%' class='multiPOControl'><div id ='21'></div></td>
	   <td width='25%' class='multiRPTLabel'>Last PO Date</td>
	   <td width='25%' class='multiPOControl'><div id ='22'></div></td>
	</tr>
	<tr>
	   <td width='25%' class='multiRPTLabel'></td>
	   <td width='25%' class='multiPOControl'><div id ='23'></div></td>
	   <td width='25%' colspan='2' class='multiLabel'></td>
	   
	 </tr>  
	<tr class="FOOTER">
		<td colspan="4"></td>
	</tr>
 </table>
</div>
  
<div class='popup' id='AnnualPurchase' style="display:none">
					<table width='400' border="0" cellspacing ="0px">
						<tr class="HEADER"> 
							<th colspan='6' align='left'><div id='msgDiv1' style='color:blue;'>Item Specification</div></th>
							<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close the Window' src='../../hisglobal/images/popUp_cancel.JPG'
								onClick="hideItemDetails('AnnualPurchase');"></th>
					    </tr>
					 </table>   
					 <table width='400' border="0" bgcolor='#6097BC' cellspacing ="1px" cellpadding="1px">
						
						<tr>
						   <td width='25%' class='multiRPTLabel'>Re-OrderLevel</td>
						   <td width='25%' class='multiPOControl'><div id ='5'></div></td>
						   <td width='25%' class='multiRPTLabel'>Last Year Consumption</td>
						   <td width='25%' class='multiPOControl'><div id ='6'></div></td>
						</tr>
						<tr>
						   <td width='25%' class='multiRPTLabel'>Last PO No</td>
						   <td width='25%' class='multiPOControl'><div id ='7'></div></td>
						   <td width='25%' class='multiRPTLabel'>Last Po Date</td>
						   <td width='25%' class='multiPOControl'><div id ='8'></div></td>	
						 </tr>  
						 <tr>
						   <td width='25%' class='multiRPTLabel'>Last Rec Qty</td>
						   <td width='25%' class='multiPOControl'><div id ='9'></div></td>
						   <td width='25%' class='multiRPTLabel'>Last Rec Date</td>
						   <td width='25%' class='multiPOControl'><div id ='10'></div></td>	
						 </tr>  
						 <tr>
						   <td width='25%' class='multiRPTLabel'>Last Supplied By</td>
						   <td colspan="3" class='multiPOControl'><div id ='11'></div></td>
						 </tr>  
						 <tr class="FOOTER">
							<td colspan="4"></td>
						</tr>
				      </table>
					</div>
        <!-- ------------------------------------------------------------------START------------------------------------------------------------------ -->
			 <%--  <tag:tab tabLabel="Indent Approval Desk" selectedTab="FIRST"
					align="center" width="TABLEWIDTH">
			  </tag:tab> 
			<div class="legendHeader " id="nonPrintableLegend" style="font-weight:600;font-size: 22px;">Indent Approval Desk</div> --%>
		
			<div  id ="Receving" style="display:none">
			   <!-- <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
					 <tr class="HEADER">
						<td colspan="4">Apporoval Desk&gt;&gt;Receving</td>
					 </tr>
			   </table> -->
			   <!-- <div class="legendHeader " id="nonPrintableLegend" style="font-weight:600;font-size: 18px;">Approval Desk&gt;&gt;Receiving</div> -->
			  <div>
				<p class="subHeaders mb-0"><i class="fas fa-th-list iround" style="font-size: 16px; color: #28a745" title=""></i>&nbsp;Approval Desk&gt;&gt;Receiving </p></div>
			 </div>
	
			<div  id ="Raising" style="display:block">
		      <!--  <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
					 <tr class="HEADER">
						<td colspan="4"></td>
					 </tr>
				 </table> -->
			</div>	 
			
			 <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
			      <bean:write name="indentApprovalTransBean" property="strIndentDetails" filter="false" />
			 </table>
				
				
			<div style='display:none;'>
				<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
			      <bean:write name="indentApprovalTransBean" property="strLstApprovalDetails" filter="false" />
			    </table>
			</div>
		
		<!-- ----------------------------Indent Detail(s)--IndentApprovalDeskHLP.getItemDetails1()-------------------------- -->
		   <!--  <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
				<tr class="TITLE">
					<td colspan="4">
						<div id="" style="font-family: Arial, Helvetica, sans-serif;font-size:13px;">Indent Detail(s)</div>
					</td>
				</tr>
			</table> 
			
			<div class="legendHeader" id="" style="font-weight:600;font-size: 18px;">Indent Details</div> -->
			<div><hr>
				<p class="subHeaders mb-0"><i class="fas fa-th-list iround" style="font-size: 16px; color: #28a745" title=""></i>&nbsp;Indent Details</p>
			</div>
				
			<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">
				<bean:write name="indentApprovalTransBean" property="strSetItemDetails"	filter="false" />
			</table>
		<!-- ----------------------------Indent Detail(s)---------------------------- -->
				
				
				
		    <div class='popup' id='issueDtlId' style='display: none'></div>
		    
		    
		    
		<!-- ----------------------------Approval Detail(s)--ApprovalDtlHLP.getApprovalDtl()--------------------- -->
			     
		<!--     <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
				<tr class="TITLE">
					<td colspan="5"><div id="" style="color:white;">Approval Details</div></td>
				</tr>
		    </table> 
		    
			 <div class="legendHeader" id="" style="font-weight:600;font-size: 18px;">Approval Details</div>-->
		     <div>
		     	<p class="subHeaders mb-0"><i class="fas fa-th-list iround" style="font-size: 16px; color: #28a745" title=""></i>&nbsp;Approval Details</p>
		     </div>
		    
   			 <bean:write name="indentApprovalTransBean" property="strSetApprovedDetails" filter="false" />
  			
 			 <bean:write name="indentApprovalTransBean" property="strSetPreTechApprovedDetails"	filter="false" />
	    <!-- ----------------------------Approval Detail(s)---------------------------- -->
	    
	     	
		  <div id="AllRequest" style="display:block">	
	<!-- 		<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1"> 
				    <tr class="TITLE">
						<td colspan="4"></td>
				    </tr>  
				    
				    <tr>
						<td class="LABEL" width="25%">Approval Status</td>
						<td width="25%" class="CONTROL" colspan="3">
						<input type="radio" name="strApproved" value="1" checked="checked" onClick="FuncTick(this)"/>
						Approved 
						<input type="radio" name="strRejected" value="2" onClick="FuncTick(this),setApprovedQty();"/>
						Rejected
					</tr>
				</table> -->
				<div class="row">
					<div class="col-sm-2">
						<label>Approval Status</label>
					</div>
					<div class="col-sm-2">
						<span>
						<input type="radio" name="strApproved" value="1" checked="checked" onClick="FuncTick(this)"/>
						Approved</span><span>
						<input type="radio" name="strRejected" value="2" onClick="FuncTick(this),setApprovedQty();"/>
						Rejected 	
						</span>				
	  				</div>
	  				<div class="col-sm-8"></div>
		  		</div>
				
				<div id="CommitteTypeComboDiv" style="display:none">
					<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">
						<tr>
							<td class="LABEL" width="50%"><font color="red">*</font>Committe Type</td>
							 <td width="50%" class="CONTROL">
								 <select name="strCommitteTypeCode" class="comboMax">
									<bean:write name="indentApprovalTransBean" property="strCommitteTypeCmb" filter="false" />
								</select>
							</td>			
						 </tr>
					</table>
				</div>
				
				<div class="row">
					<div class="col-sm-2 my-auto">
						<label>Approved By & Remarks</label>
					</div>
					<div class="col-sm-10">
						<textarea class="form-control" name="strRemarks" rows="2" style="height:35px;"></textarea>
					</div>
		  		</div>
		  </div>
  
		  <div id="Request47" style="display:none">	
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
				<tr>
					<td class="LABEL" width="50%"><font color="red">*</font>Return Type</td>
					<td width="50%" class="CONTROL">
				         <div id="ReturnTypeComboDiv" style="display:block">
					          <select name="strReturnTypeCmb"
						             class="comboNormal">
						             <option value="0">Select Value</option>
						      </select>
				         </div>
					</td>			
				</tr>
				<tr>
					<td width="50%" class="LABEL"><font color="red">*</font>Delivery Date From</td>
					<td width="50%" class="CONTROL">
					   <dateTag:date name="strDeliveryDate" value="${indentApprovalTransBean.strDeliveryDate}"></dateTag:date>
					</td>
				</tr>
			</table>
		 </div>

<!-- 	<div class="row">
		<div class="col-md-12 text-right" ><font size="smaller" color="blue">['*'] Reserved/Branded Item</font></div>
	</div>	 -->
<hr>   
    <div class="row">
		<div class="col-md-12 text-right" ><font size="smaller" color="red">*</font>Mandatory Fields</div>
	</div>	
	
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strCommitteType"  	value="${indentApprovalTransBean.strCommitteTypeCode}">
	<input type="hidden" name="strLevelType"  		value="${indentApprovalTransBean.strLevelType}">
	<input type="hidden" name="strReqTypeId"  		value="${indentApprovalTransBean.strReqTypeId}">
	<input type="hidden" name="strPath"       		value="${indentApprovalTransBean.strPath}">
	<input type="hidden" name="strChk"        		value="${indentApprovalTransBean.strChk}">
	<input type="hidden" name="strMultiRow" 		value="${indentApprovalTransBean.strMultiRow}">
	<input type="hidden" name="strSpecialAppDtls"   value="${indentApprovalTransBean.strSpecialAppDtls}">
	<input type="hidden" name="strSpecialAppFlg"    value="0">
 
 </div>
</div>	
	<cmbPers:cmbPers/>
	</html:form>
	<tag:autoIndex></tag:autoIndex>  
</body>