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

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
 
<script language="Javascript" src="../js/IndentSuperApproval.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/dropdown.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
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
	         
	        // alert((document.forms[0].strSpecialAppDtls.value).split("$")[2]);
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


</script>

	
</head>
<body onload="OnLoadCheck()";>
<html:form name="indentSuperApprovalTransBean" action="/transactions/IndentSuperApprovalTransCNT" type="mms.transactions.controller.fb.IndentSuperApprovalTransFB">
	
<center>
	 <div id="errMsg" class="errMsg"><bean:write name="indentSuperApprovalTransBean" property="strErrMsg" /></div>
	 <div id="warningMsg" class="warningMsg"><bean:write name="indentSuperApprovalTransBean" property="strWarning" /></div>
	 <div id="normalMsg" class="normalMsg"><bean:write name="indentSuperApprovalTransBean" property="strMsg" /></div>
	
</center>
        
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
				onClick="hideItemDetails('Agenda');"></th>
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
   
   
        
        
              <tag:tab tabLabel="Indent Approval Desk" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>
	<div  id ="Receving" style="display:none">
	   <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		 <tr class="HEADER">
			<td colspan="4">Apporoval Desk&gt;&gt;Receving</td>
		 </tr>
	   </table>
	</div>
	<div  id ="Raising" style="display:block">
       <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		 <tr class="HEADER">
			<td colspan="4"></td>
		 </tr>
		 </table>
	</div>	 
		 <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		      <bean:write name="indentSuperApprovalTransBean" property="strIndentDetails" filter="false" />
		 </table>
		
		
		<div style='display:none;'><table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		      <bean:write name="indentSuperApprovalTransBean" property="strLstApprovalDetails" filter="false" />
		 </table></div>
		
		
	    <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		<tr class="TITLE">
			<td colspan="4"><div id="" style="font-family: Arial, Helvetica, sans-serif;font-size:13px;">Indent Detail(s)</div></td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">
		
		<bean:write name="indentSuperApprovalTransBean" property="strSetItemDetails"	filter="false" />
		
		</table>
		
	     <div class='popup' id='issueDtlId' style='display: none'></div>
	     
	     <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		<tr class="TITLE">
			<td colspan="5"><div id="" style="color:white;">Approval Details</div></td>
		</tr>
		</table>
	     <bean:write name="indentSuperApprovalTransBean" property="strSetApprovedDetails" filter="false" />
	   
	     <bean:write name="indentSuperApprovalTransBean" property="strSetPreTechApprovedDetails"	filter="false" />
	     
  <div id="AllRequest" style="display:block">	
	 <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1"> 
	    <tr class="TITLE">
			<td colspan="4"></td>
	    </tr>  
	    <tr>
			<td class="LABEL" width="25%">Approval Status</td>
			<td width="25%" class="CONTROL" colspan="3"><input type="radio" name="strApproved" value="1" checked="checked" onClick="FuncTick(this)"/>
			Approved <input type="radio" name="strRejected" value="2" onClick="FuncTick(this),setApprovedQty();"/>Rejected
		</tr>
		</table>
		<div id="CommitteTypeComboDiv" style="display:none">
		<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Committe Type</td>
			 <td width="50%" class="CONTROL">
			 <select name="strCommitteTypeCode"
				class="comboMax">
				<bean:write
				          name="indentSuperApprovalTransBean" property="strCommitteTypeCmb"
				          filter="false" />
			</select>
			 
                      
			 </td>			
		 </tr>
		</table>
		</div>
		<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">
		<tr>
		<td width="50%" class="LABEL" ><font color="red">*</font>
		Approved By & Remarks</td>
			<td width="50%" class="CONTROL" colspan="3"><textarea
				name="strRemarks" cols="25" rows="2"></textarea></td>
	   </tr>
	</table>
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
		   
			<td width="50%" class="LABEL"><font color="red">*</font>Delivery Date
			From</td>
			<td width="50%" class="CONTROL">
			   <dateTag:date name="strDeliveryDate" value="${indentSuperApprovalTransBean.strDeliveryDate}"></dateTag:date>
			</td>
			
		</tr>
		
	  </table>
	</div>
	 	<!-- 
   <table  class="TABLEWIDTH" align="center">
	 <tr class="FOOTER">
               <td width="TABLEWIDTH" colspan="2" ></td>
               </tr>
		<tr>
	  <tr id="saveId">
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer"  title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" />
	                <img style="cursor:pointer;cursor:pointer"  title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancelToDesk();" title="Click Here Go Back To Main Desk"/>
			</td>
		</tr>
	</table> -->
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	<tr class="FOOTER">
               <td width="TABLEWIDTH" colspan="2" ><font  color="blue">['*'] Reserved/Branded Item</font></td>
               </tr>
               </table>
	<br>
	<div align="center" id="saveId">					 
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
					</div> 
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strCommitteType"  	value="${indentSuperApprovalTransBean.strCommitteTypeCode}">
	<input type="hidden" name="strLevelType"  		value="${indentSuperApprovalTransBean.strLevelType}">
	<input type="hidden" name="strReqTypeId"  		value="${indentSuperApprovalTransBean.strReqTypeId}">
	<input type="hidden" name="strPath"       		value="${indentSuperApprovalTransBean.strPath}">
	<input type="hidden" name="strChk"        		value="${indentSuperApprovalTransBean.strChk}">
	<input type="hidden" name="strMultiRow" 		value="${indentSuperApprovalTransBean.strMultiRow}">
	<input type="hidden" name="strSpecialAppDtls"   value="${indentSuperApprovalTransBean.strSpecialAppDtls}">
	<input type="hidden" name="strSpecialAppFlg"    value="0">
	
	<cmbPers:cmbPers/>
	</html:form>
	<tag:autoIndex></tag:autoIndex>  
</body>
