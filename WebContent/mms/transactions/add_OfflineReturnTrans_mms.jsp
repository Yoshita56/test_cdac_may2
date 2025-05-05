<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!--
Developer : Amit Kumar
  Version : 1.0 
  Date : 16/Sep/2010
   Module:MMS
  Unit:OffLine Return Transaction
    -->

<html>
<head>
<meta charset=UTF-8">
<title>Insert Title Here</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>

<script language="JavaScript" src="../js/OffLineReturnTrans.js"></script>

<script type="text/javascript">

   
	
	function getItemSelectPopup()
	{
	 
	
	     setItemDtlWithIssueQty();
	    ///////////////// Calculate Total Cost  ////////////////////
		var finalTotal  = parseFloat("0.00");
		document.forms[0].strNewDemandApproxAmtDivId.value="0.00";
		document.forms[0].strNewDemandFinalApproxAmt.value="0.00";
		 var itemParVal  = document.getElementsByName("itemParamValue");
       
        if(itemParVal.length>1)
        {
          var costObj = document.getElementsByName("strCost");
                    for ( var i = 0; i <costObj.length; i++)
					{		        					
					   
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}		
			        finalTotal = roundValue(finalTotal, 2);
			        document.getElementById("strNewDemandApproxAmtDivId").value = finalTotal;
		            document.forms[0].strNewDemandFinalApproxAmt.value=finalTotal;
        }
       ///////////////// End Calculate Total Cost  ////////////////////
	   var StoreCmb          = document.forms[0].strStoreName.value;
	   var ItemCatgCmb       = document.forms[0].strItemCatgCombo.value;
	   var IndentingStore    = document.forms[0].strIndentingStoreID.value;
	  
	   if(StoreCmb!=0 && ItemCatgCmb!=0 )
       {	
	    var strModeVal 					= "3" ; 
		var strRequestType              = "18";
		var strItemCategory 			= ItemCatgCmb;
		var strFromStoreId 				= StoreCmb;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strReturnQty');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','t');
		var testFunction                = "setQtyDetailsOfflineReturn";
		var arg                         = "a";  
		var userInfo = IndentingStore;
		var unitMode = "0";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		
		var strMultiRowFetchDataArray 	= new Array('1','11','4','19');
		    
	    var layerIndex = "1";
		//alert(strItemCategory)
		//alert(strFromStoreId);
		//alert(strItemCategory);
        //searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, StoreCmb, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, StoreCmb, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );
        
        
	  }
	  else
	   {
	   	   if(StoreCmb == 0)
	       {
	           alert("Please Select Store Name!!!");
	           StoreCmb.focus();
	       }
	       if(ItemCatgCmb == 0)
	       {
	           alert("Please Select Item Category!!!");
	           ItemCatgCmb.focus();
	       }
	      	       
	    return false;
	 }
}
 
function setQtyDetailsOfflineReturn(val){
	

		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strReturnQty");
  		var reqQty      = document.getElementsByName("strReqQty");  	
  		var costObj     = document.getElementsByName("strCost");
		
		if(itemWithIssueQty.value.length > 1)
		{
		      
			var itemWithIssueQtyArray = itemWithIssueQty.value.split("$$$$");
			
				for(var i = 0 ; i < itemUserVal.length -1 ; i++)
				{
				
					for(var j = 0 ; j < itemWithIssueQtyArray.length ; j ++)
					{
				  		   var newArrayTemp = itemWithIssueQtyArray[j].split('@@@@');
				
							if( itemUserVal[i].value == newArrayTemp[0] )
							{
							
								issueQty[i].value = newArrayTemp[1];
								reqQty[i].value = newArrayTemp[2];								
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
			        document.getElementById("strNewDemandApproxAmtDivId").value = finalTotal;
		            document.forms[0].strNewDemandFinalApproxAmt.value=finalTotal;
			
			
					
		} 
	
	}
 

function setItemDtlWithIssueQty()
{
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strReturnQty");
  		var reqQty      = document.getElementsByName("strReqQty");
  		var costObj     = document.getElementsByName("strCost");
		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{

															
					if(i == 0 )
					{
						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+reqQty[i].value+"@@@@"+costObj[i].value	
						
					}
					else
					{
					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+reqQty[i].value+"@@@@"+costObj[i].value
					
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}

function FunctionTechCalling()
{
  //var  varTemp   = document.getElementById("itemUserValue" + index).value.split("^");
  var  varTemp    = document.getElementsByName("itemUserValue");
  var itemParVal  = document.getElementsByName("itemParamValue");
  var issueQty    = document.getElementsByName("strReturnQty");
  var reqQty      = document.getElementsByName("strReqQty");
  var unitNameCmb = document.getElementsByName("strUnitName");
  var costObj     = document.getElementsByName("strCost");
  var pValue      = document.getElementById("strItemDtlWithIssueQty").value;			
  
  var delArray    = new Array();
  var finalTotal  = parseFloat("0.00");
  var total       = parseFloat("0.00");	
  var flag        = true;
  var newStr      = ""; 
  
      //alert("strItemDtlWithIssueQty::"+document.getElementById("strItemDtlWithIssueQty").value);
      if(document.getElementById("strItemDtlWithIssueQty").value!='0' || document.getElementById("strItemDtlWithIssueQty").value!='')
      {
          delArray = document.getElementById("strItemDtlWithIssueQty").value.split("$$$$");
         //alert("Hidden Length:::"+delArray.length+":::Param Length:::"+(itemParVal.length - 1));
            if((itemParVal.length - 1)>delArray.length)
            {
              
			  for ( var i = 0; i < (itemParVal.length - 2); i++) 
			  {		
			       
			       if( varTemp[i].value.split('^')[0]  == (delArray[i].split("#")[0]) && varTemp[i].value.split('^')[1]  == (delArray[i].split("#")[1]) && varTemp[i].value.split('^')[15]  == (delArray[i].split("#")[2]) && varTemp[i].value.split('^')[32]  == (delArray[i].split("#")[3]))
			       { 
			         //0=Item Id#1=Item Brand Id#2=Batch No#3= Stock Status Code#4=Request Qty #5=Unit#6=Return Qty#7=Rate
						    reqQty[i].value       = delArray[i].split("#")[4];
						    //unitNameCmb[i].value  = delArray[i].split("#")[5];
						    issueQty[i].value     = delArray[i].split("#")[6];							    				    
						    var  rateObj          = delArray[i].split("#")[7];	   
				            var  qtyObj           = delArray[i].split("#")[6];
				            //var  qty_base_value   = unitNameCmb[i].value.split("^")[1];
				            
				            var qty    = qtyObj;	
							var rate   = rateObj;						
											
							if(isNaN(rate) || rate=="") rate = "0";
							if(isNaN(qty)  || qty=="") qty = "0";
						    if(qty=='0')		
							{
							 
							  total = parseFloat(qty *  rate);
							}
							else
							{
							  total = parseFloat(qty *  rate);
							} 												
							
						    costObj[i].value = roundValue(total, 2);
						    
						   			    
				   }
				   else
				   {
						     issueQty[i].value = "0";	
						     reqQty[i].value = "";
				   } 
				   
			  }
				
			        
					for ( var i = 0; i <costObj.length; i++)
					{		        					
						//alert("Total Cost"+costObj[i].value);
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}			
				
			    
			    finalTotal = roundValue(finalTotal, 2);
			    document.getElementById("strNewDemandApproxAmtDivId").value = finalTotal;
		        document.forms[0].strNewDemandFinalApproxAmt.value=finalTotal;
			}
			else
			{
			 
			  for ( var i = 0; i < delArray.length; i++) 
			  {		
			  
			     	 // alert("I="+i+"Item ID:::" +delArray[i].split("#")[0]+ "Item Brand ID:::" +delArray[i].split("#")[1]+"Batch:::" +delArray[i].split("#")[2]+  "::Req Qty:::"+delArray[i].split("#")[4]+"::Unit Qty:::"+delArray[i].split("#")[5]+"::Issue Qty:::"+delArray[i].split("#")[6]);
			     	  //alert("I="+i+"Item ID:::" +varTemp[i].value.split('^')[0]+ "Item Brand ID:::" +varTemp[i].value.split('^')[1]+"Batch:::" +varTemp[i].value.split('^')[15]+  "::Stock:::"+varTemp[i].value.split('^')[32]);
			     for(var j = 0 ; j< (itemParVal.length - 1);j++)
			     { 
			     
			       if( (delArray[i].split("#")[0]) == varTemp[j].value.split('^')[0]  &&  (delArray[i].split("#")[1]) == varTemp[j].value.split('^')[1]  &&  (delArray[i].split("#")[2])== varTemp[j].value.split('^')[15] &&  (delArray[i].split("#")[3]) == varTemp[j].value.split('^')[32])
			       { 
			         if(flag)
			         {
			            newStr = delArray[i].split("#")[0]+"#"+delArray[i].split("#")[1]+"#"+delArray[i].split("#")[2]+"#"+delArray[i].split("#")[3]+"#"+delArray[i].split("#")[4]+"#"+delArray[i].split("#")[5]+"#"+delArray[i].split("#")[6]+"#"+delArray[i].split("#")[7];
						flag = false;
					 }
					 else
					 {
					    newStr= newStr+"$$$$"+delArray[i].split("#")[0]+"#"+delArray[i].split("#")[1]+"#"+delArray[i].split("#")[2]+"#"+delArray[i].split("#")[3]+"#"+delArray[i].split("#")[4]+"#"+delArray[i].split("#")[5]+"#"+delArray[i].split("#")[6]+"#"+delArray[i].split("#")[7];
					 }	
			       }
			     }
				   
			  }
			  //alert("After Less Value:::"+newStr);
			  document.getElementById("strItemDtlWithIssueQty").value =  newStr;
			  
			  
			  for ( var i = 0; i < delArray.length; i++) 
			  {			 
			  
			        //alert("I="+i+"Item ID:::" +delArray[i].split("#")[0]+ "Item Brand ID:::" +delArray[i].split("#")[1]+"Batch:::" +delArray[i].split("#")[2]+  "::Req Qty:::"+delArray[i].split("#")[4]+"::Unit Qty:::"+delArray[i].split("#")[5]+"::Issue Qty:::"+delArray[i].split("#")[6]);
			     	// alert("I="+i+"Item ID:::" +varTemp[i].value.split('^')[0]+ "Item Brand ID:::" +varTemp[i].value.split('^')[1]+"Batch:::" +varTemp[i].value.split('^')[15]+  "::Stock:::"+varTemp[i].value.split('^')[32]);
                    // for(var j = 0 ; j< (itemParVal.length - 1);j++)
			        // { 
				       if( varTemp[i].value.split('^')[0]  == (delArray[i].split("#")[0]) && varTemp[i].value.split('^')[1]  == (delArray[i].split("#")[1]) && varTemp[i].value.split('^')[15]  == (delArray[i].split("#")[2]) && varTemp[i].value.split('^')[32]  == (delArray[i].split("#")[3]))
				       { 
				         // 0=Item Id,1=Item Brand Id,2=Batch No 3= Stock Status Code4=Request Qty5=Unit6=Return Qty7=Rate
							    reqQty[i].value       = delArray[i].split("#")[4];
							    //unitNameCmb[i].value  = delArray[i].split("#")[5];
							    issueQty[i].value     = delArray[i].split("#")[6];	
							    				    
							    var  rateObj          = delArray[i].split("#")[7];	   
					            var  qtyObj           = delArray[i].split("#")[6];
					            //var  qty_base_value   = unitNameCmb[i].value.split("^")[1];
					            
					            var qty    = qtyObj;	
								var rate   = rateObj;						
												
								if(isNaN(rate) || rate=="") rate = "0";
								if(isNaN(qty)  || qty=="") qty = "0";
							    if(qty=='0')		
								{
								  //qty_base_value = '0';	
								  total = parseFloat(qty  * rate);
								}
								else
								{
								  total = parseFloat(qty  * rate);
								} 												
								
							    costObj[i].value = roundValue(total, 2);
							    
							   			    
					   }
				  
				   
			  }
			        for ( var i = 0; i <costObj.length; i++)
					{		        					
						//alert("Total Cost Test"+costObj[i].value);
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}		
			        finalTotal = roundValue(finalTotal, 2);
			        document.getElementById("strNewDemandApproxAmtDivId").value = finalTotal;
		            document.forms[0].strNewDemandFinalApproxAmt.value=finalTotal;
			}
			
       // }
	}
    else
    {
                    document.getElementById("strNewDemandApproxAmtDivId").value = "0.00";
		            document.forms[0].strNewDemandFinalApproxAmt.value="0.00";
    }

}

</script>

</head>

<body   onload="getReport();">

<html:form action="/transactions/OfflineReturnTransCNT.cnt"  name="offlineReturnBean" type="mms.transactions.controller.fb.OfflineReturnTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="offlineReturnBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="offlineReturnBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="offlineReturnBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Off Line Return Transaction" selectedTab="FIRST" onlyTabIndexing="1" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
		<tr class="HEADER">

			<td colspan="4"></td>
			<td align="right"><span>
			<html:checkbox name="offlineReturnBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Item Detail"></html:checkbox></span>View</td>
		</tr>
				
	    </table>
	    
	    <table class="TABLEWIDTH" align="center" cellspacing="1px">
		

		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Store Name:</td>
			<td width="25%" class="CONTROL">
			
			     <select name="strStoreName" class="comboMax" tabindex="1"  onChange="getItemCategoryCombo();">
                        <bean:write name="offlineReturnBean" property="strStoreName" filter="false"/>
                 </select>
            </td>
			<td width="25%" class="LABEL"><font color="red">*</font>Item Category:</td>

			<td width="25%" class="CONTROL">
			
			<div id="ItemCatg" >
			     <select class='comboNormal' tabindex="1" name='strItemCatgCombo' onchange='getIndentStoreCombo();'> 
		              <bean:write name="offlineReturnBean" property="strItemCatgCombo" filter="false"/>  
		         </select>
		     </div>    
						
			  </td>
		    </tr>
		    <tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Requesting Store:</td>
			<td width="25%" class="CONTROL">
			<div id="IndentingStore" >
			     
                 <select class='comboNormal' tabindex="1" name='strIndentingStoreID'> 
		              <bean:write name="offlineReturnBean" property="strIndentingStoreID" filter="false"/><option value="0">Select Value</option>  
		         </select>
            </div>
            </td>
			<td width="25%" class="LABEL"><font color="red">*</font>Request Status:</td>
			<td width="25%" class="CONTROL">
			<input type="radio" tabindex="1" name=isNormal value="1" checked="checked" />Normal&nbsp;&nbsp;
			<input type="radio" tabindex="1" name="isNormal" value="0" />Urgent</td>
		</tr>
		
		<tr>
			<td class="LABEL"  width="25%"><font color="red">*</font>Request No:</td>
			<td class="CONTROL" width="25%"><input type="text" tabindex="1" class="txtFldMax" name="strIndentNo"	onkeypress="return validateData(event,5);" maxlength="11"></td>
            <td class="LABEL"  width="25%"><font color="red">*</font>Request Date:</td>
			<td class="CONTROL" width="25%">
			
       			<dateTag:date name="strApprovedDate"  value="${offlineReturnBean.strIndentDate}"></dateTag:date>
       				      			
			</td>


		</tr>
	</table>
	    
	    
        <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
        <tr class="TITLE">
			<td colspan="6"><div align="right" >
			<img   style="cursor: pointer;height: 20px"  title='Click Here To Search Items' height="20" align="middle" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" onclick='getItemSelectPopup();'>
			</div>
			 </td>
		</tr>
        
          
	   </table> 
	 <logic:equal value="0" name="offlineReturnBean" property="strBudgetFlg"> 
		<div id='costDivNotReqId'  style="display: block">
			<table class="TABLEWIDTH" bgcolor='#CC9966' align="center" cellpadding="1px" cellspacing="1px">
	   		
			<tr>
				<td  class="multiRPTLabel" width="25%">Item/Drug Name</td>
				<td  class="multiRPTLabel" width="18%">Batch/SlNo</td>
				<td  class="multiRPTLabel" width="10%">Avl Qty.</td>
				<td  class="multiRPTLabel" width="10%">Unit</td>
				<td  class="multiRPTLabel" width="12%"><font color='red'>*</font>Req Qty.</td>
				<td  class="multiRPTLabel" width="15%"><font color='red'>*</font>Returned Qty.</td>
			</tr>
			</table>
		</div>	
       <div id="id1"></div>
     </logic:equal>       
     <logic:equal value="1" name="offlineReturnBean" property="strBudgetFlg">
       
       <table class="TABLEWIDTH" bgcolor='#CC9966' align="center" cellpadding="1px" cellspacing="1px">
	   		
				<tr>
					<td  class="multiRPTLabel" width="23%">Item/Drug Name</td>
					<td  class="multiRPTLabel" width="8%" >Batch/SlNo</td>
					<td  class="multiRPTLabel" width="9%">Avl Qty</td>
					<td  class="multiRPTLabel" width="6%">Unit</td>
					<td  class="multiRPTLabel" width="12%"><font color='red'>*</font>Req Qty</td>
					<td  class="multiRPTLabel" width="11%"><font color='red'>*</font>Returned Qty</td>
					<td  class="multiRPTLabel" width="10%">Cost</td>
						
				</tr>
				
				</table>
				
	       <div id="id1"></div>
       
       <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
				<tr>
					<td width="92%" class="LABEL">Total Approx Cost(Rs):</td>
					<td width="8%" class="CONTROL" style="color: red; font-weight: bold" align="center">
		    		<input type="text" style="color: red; font-weight: bold"  disabled="disabled" class="txtFldNormal"  value="0.00" name="strNewDemandApproxAmtDivId" id="strNewDemandApproxAmtDivId" >
					<input type="hidden" name="strNewDemandFinalApproxAmt"></td><td width="4%" class="CONTROL"></td>
				</tr>
			</table>
					
		</logic:equal>
       
     
     
       <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
       		<tr>
       			<td class="TITLE" colspan="2">
       				<div id="" >&nbsp; Approval  &amp; Receive Details</div>
       			</td>
       		</tr>
       	</table>
       	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 	 
       	 
       	 
       	 <tr>
			<td width="25%" class="LABEL">Approved By:</td>
			<td width="25%" class="CONTROL">
			 <div id="ApprovedBy" >
			     <select class='comboNormal' tabindex="1" name='strApprovedBy'> 
		              <bean:write name="offlineReturnBean" property="strApprovedBy" filter="false"/><option value="0">Select Value</option>  
		         </select>
		     </div>   

    		</td>

			<td width="25%" class="LABEL">Approval Date:</td>
			<td width="25%" class="CONTROL">
				<dateTag:date name="strApprovalDate"  value="${offlineReturnBean.strApprovalDate}"></dateTag:date>
			</td>
		</tr>
        
        <tr>
			<td width="25%" class="LABEL">Verified By:</td>
			<td width="25%" class="CONTROL">
			    <div id="VerifiedBy" >
			     <select class='comboNormal' tabindex="1" name='strVerifiedBy'> 
		              <bean:write name="offlineReturnBean" property="strVerifiedBy" filter="false"/><option value="0">Select Value</option>  
		         </select>
		     </div>   
    		</td>

			<td width="25%" class="LABEL">Verified Date:</td>
			<td width="25%" class="CONTROL">
				<dateTag:date name="strVerifiedDate"  value="${offlineReturnBean.strVerifiedDate}"></dateTag:date>
			</td>
		</tr>
		</table>	        		
       	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 	
       	
       	<tr>
	   			<td colspan="4" class="TITLE"></td>
	   		</tr>
       	     <tr>
       			<td class="LABEL" width="50%">
       				<font color='red'>*</font>Received By
       			</td>
       			<td class="CONTROL">
       				<input type="text" tabindex="1" class="txtFldMax" name="strReceivedBy"	onkeypress="return validateData(event,3);" maxlength="">
       			</td>
       			
       		</tr>
       	
       	     <tr>
       			<td class="LABEL" width="50%">
       				<font color='red'>*</font>Approved Remarks
       			</td>
       			<td class="CONTROL">
       				<textarea tabindex="1" name="strAprovedRemarks"></textarea>
       			</td>
       			
       		</tr>
       		       		              
     
        <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	
	
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" tabindex="1" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" onkeypress="if(event.keyCode==13) return validate1();"/>
	                <img style="cursor:pointer;cursor:pointer" tabindex="1" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();" onkeypress="if(event.keyCode==13) return initPage();">
	                <img style="cursor: pointer;" tabindex="1" title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" onkeypress="if(event.keyCode==13) return cancel('LIST');"/>
			</td>
		</tr>
	</table>	
    
    <input type="hidden" name="hmode"/>
    
      <input type="hidden" name="strCurrentDate" value="${offlineReturnBean.strCurrentDate}"/>
      <input type="hidden" name="strIsView" value="0"/>
      <input type="hidden" name="strTmpStoreNo" value="${offlineReturnBean.strTmpStoreNo}"/>
      <input type="hidden" name="strTmpReturnNo" value="${offlineReturnBean.strReturnNo}"/>
	  <input type="hidden" name="strTmpIndentNo" value="${offlineReturnBean.strIndentNo}"/>
	  <input type="hidden" name="strTmpIndentDate" value="${offlineReturnBean.strIndentDate}"/>
	  <input type="hidden" name="strIndentDate" value="${offlineReturnBean.strIndentDate}"/>
	  <input type="hidden" name="strTmpIssueNo" value="${offlineReturnBean.strTmpIssueNo}"/>
	  <input type="hidden" name="strIssueNo" value="0"/>
	  <input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
	   <input type="hidden" name="strReOrderFlgColor" value="${offlineReturnBean.strReOrderFlgColor}"/>
    
    
  <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         <div id="searchItemsDtlsDivId" style="display:block;"></div>
         <div id="issueDtlsDivId" style="display:block;"></div>
      
       </td>
     </tr>
    </table>
   </div>
        
</html:form>
<jsp:include page="offLineReturn_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>