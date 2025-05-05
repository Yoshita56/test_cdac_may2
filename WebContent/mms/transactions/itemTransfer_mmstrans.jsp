<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/multiRow.tld" prefix="multiRowTLD"%>
<html>
<head>
<meta charset=UTF-8">
<title>Item Transfer</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
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
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/ItemTransferDtlTrans.js"></script>

<script type="text/javascript">

	function getItemSelectPopup()
	{
	
	
	    var itemParVal  = document.getElementsByName("itemParamValue");
        var finalTotal  = parseFloat("0.00");
		document.getElementById("strTotalTransferCostDivId").innerHTML ="0.00";
		 document.forms[0].strTotalTransferCost.value=finalTotal;
        if(itemParVal.length>1)
        {
          var costObj = document.getElementsByName("strTotalTransferCost");
                    for ( var i = 0; i <costObj.length; i++)
					{		        					
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}		
			        finalTotal = roundValue(finalTotal, 2);
                    document.getElementById("strTotalTransferCostDivId").innerHTML = finalTotal;
                    document.forms[0].strTotalTransferCost.value=finalTotal;
        }
	    var hisValidator = new HISValidator("itemTransferTransBean");  
	    hisValidator.addValidation("strStoreName","dontselect=0","Please select a value from Store Name Combo" );
	    hisValidator.addValidation("strItemCatCmb","dontselect=0","Please select a value from Item Category Combo" );
	    var retVal = hisValidator.validate(); 
	    hisValidator.clearAllValidations();
	    if(retVal)
	    {
	      var strFromStoreId            = document.forms[0].strStoreName.value; 
		  var strModeVal 			    = "3" ; 
		  var strItemCategory 			= document.forms[0].strItemCatCmb.value ; 
		  var strIssueType 				= "0";
		  var strRequestType            = "51";
		  var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strUnitName','strTransferQty');
		  var strMultiRowCompTypeArray 	= new Array('t','t','t','s','s','t');
		  var strMultiRowFetchDataArray = new Array('1','11','4','0^strUnitName^calCostBaseOnUnit');
		  var layerIndex                = "1";
		  var testFunction              = "CallFunc";
		  var arg                       = " ";  
		  var userInfo = "0";
		  var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
	      //searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
	      searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg,userInfo , unitMode);
	      document.forms[0].strStoreName.disabled=true;
	      document.forms[0].strItemCatCmb.disabled=true;
	    }
	}
	
	/**
	  This function is used to set condition during change of name of reciever.
	**/
	function checkValCombo(){
		var recievedByName=document.forms[0].strReceivedComboBy[document.forms[0].strReceivedComboBy.selectedIndex].text;
		if(document.forms[0].strReceivedComboBy[document.forms[0].strReceivedComboBy.selectedIndex].text=='Other' ){
			
			document.getElementById("labelId").className="LABEL";
			document.getElementById("labelNameId").innerHTML="";
			document.getElementById("nameOtherFld").style.display="block";
			if(document.forms[0].strReceiveBy.readOnly)
				document.forms[0].strReceiveBy.readOnly=false;
			document.forms[0].strReceiveBy.value="";
			document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>Name of the Receiver";
			document.forms[0].strReceiveBy.focus();
		
		}else if(document.forms[0].strReceivedComboBy.value!="0" && document.forms[0].strReceivedComboBy.value!="1"){
			
			document.getElementById("labelId").className="LABEL";
			
			document.getElementById("labelNameId").innerHTML="";
			document.getElementById("nameOtherFld").style.display="block";
			document.getElementById("labelNameId").innerHTML="Name of the Receiver";
			document.forms[0].strReceiveBy.value=recievedByName;
			if(!document.forms[0].strReceiveBy.readOnly)
				document.forms[0].strReceiveBy.readOnly=true;
			document.getElementsByName("strRemarks")[0].focus();
			
			
		}else{
			document.getElementById("labelId").className="CONTROL";
			document.getElementById("nameOtherFld").style.display="none";
			document.getElementById("labelNameId").innerHTML="";
		}
}
function costReq(){
	
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

function transferToViewPage()
{
	if(document.getElementsByName("strViewChk")[0].checked){
		document.forms[0].hmode.value="VIEWPAGE";
		document.forms[0].submit();
	}
}


function CallFunc()
	{
				
	  var  varTemp    = document.getElementsByName("itemUserValue");
	  var itemParVal  = document.getElementsByName("itemParamValue");
	  //var issueQty    = document.getElementsByName("strIssueQty");
	  var reqQty      = document.getElementsByName("strTransferQty");
	  var unitNameCmb = document.getElementsByName("strUnitName");
	  var costObj     = document.getElementsByName("strTransferCost");
	  var costDiv     = document.getElementsByName("strTransferCostDivId");
	  var pValue      = document.getElementById("strItemDtlWithIssueQty").value;			
	  
	  var delArray    = new Array();
	  var finalTotal  = parseFloat("0.00");
	  var total       = parseFloat("0.00");	
	  var flag        = true;
	  var newStr      = ""; 
  
      if(document.getElementById("strItemDtlWithIssueQty").value!='0')
      {
        // if(itemParVal.length>1)
       // {
         delArray = document.getElementById("strItemDtlWithIssueQty").value.split("$$$$");
         //alert("Hidden Length:::"+delArray.length+":::Param Length:::"+(itemParVal.length - 1));
            if((itemParVal.length - 1)>delArray.length)
            {
			  for ( var i = 0; i < (itemParVal.length - 2); i++) 
			  {			 
			       //alert("I::"+i+"::Item Id::"+delArray[i].split("#")[0]+":::Item Brand Id:"+delArray[i].split("#")[1]+"::Batch No::"+delArray[i].split("#")[2]+"::Stock Status::"+delArray[i].split("#")[3]);
			       if( varTemp[i].value.split('^')[0]  == (delArray[i].split("#")[0]) && varTemp[i].value.split('^')[1]  == (delArray[i].split("#")[1]) && varTemp[i].value.split('^')[15]  == (delArray[i].split("#")[2]) && varTemp[i].value.split('^')[32]  == (delArray[i].split("#")[3]))
			       { 
			             // 0=Item ID#1=ItemBrand Id#2=Batch No#3=Stock Status Code#4=RequestedQty(0)#5=Unit Name#6=Transfer Qty#7=Rate                    
						    reqQty[i].value       = delArray[i].split("#")[6];
						    unitNameCmb[i].value  = delArray[i].split("#")[5];
						    				    
						    var  rateObj          = delArray[i].split("#")[7];	   
				            var  qtyObj           = delArray[i].split("#")[6];
				            var  qty_base_value   = unitNameCmb[i].value.split("^")[1];
				            
				            var qty    = qtyObj;	
							var rate   = rateObj;						
								
							if(isNaN(rate) || rate=="") rate = "0";
							if(isNaN(qty)  || qty=="") qty = "0";
						    if(qty=='0')		
							{
							  qty_base_value = '0';	
							  total = parseFloat(qty * qty_base_value * rate);
							}
							else
							{
							  total = parseFloat(qty * qty_base_value * rate);
							} 												
							
						    costObj[i].value = roundValue(total, 2);
						    costDiv[i].value = roundValue(total, 2);
						   			    
				   }
				   else
				   {
						     //issueQty[i].value = "0";	
						     reqQty[i].value = "";
				   } 
				   
			  }
				
			        
					for ( var i = 0; i <costObj.length; i++)
					{		        					
						
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}			
				
			    
			    finalTotal = roundValue(finalTotal, 2);
			    document.getElementById("strTotalTransferCostDivId").innerHTML = finalTotal;
                document.forms[0].strTotalTransferCost.value=finalTotal;
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
				         // 0=Item ID#1=ItemBrand Id#2=Batch No#3=Stock Status Code#4=RequestedQty(0)#5=Unit Name#6=Transfer Qty#7=Rate      
							    reqQty[i].value       = delArray[i].split("#")[6];
							    unitNameCmb[i].value  = delArray[i].split("#")[5];
							    //issueQty[i].value     = delArray[i].split("#")[6];	
							    				    
							    var  rateObj          = delArray[i].split("#")[7];	   
					            var  qtyObj           = delArray[i].split("#")[6];
					            var  qty_base_value   = unitNameCmb[i].value.split("^")[1];
					            
					            var qty    = qtyObj;	
								var rate   = rateObj;						
												
								if(isNaN(rate) || rate=="") rate = "0";
								if(isNaN(qty)  || qty=="") qty = "0";
							    if(qty=='0')		
								{
								  qty_base_value = '0';	
								  total = parseFloat(qty * qty_base_value * rate);
								}
								else
								{
								  total = parseFloat(qty * qty_base_value * rate);
								} 												
								
							    costObj[i].value = roundValue(total, 2);
							    costDiv[i].value = roundValue(total, 2);
							    
							   			    
					   }
				  
				   
			  }
			        for ( var i = 0; i <costObj.length; i++)
					{		        					
						//alert("Total Cost"+costObj[i].value);
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}		
			        finalTotal = roundValue(finalTotal, 2);
			        document.getElementById("strTotalTransferCostDivId").innerHTML = finalTotal;
                    document.forms[0].strTotalTransferCost.value=finalTotal;
			}
			
       // }
	}
	   
}




</script>
</head>
<body onload="getReport();">

<html:form action="/transactions/ItemTransferTransCNT.cnt"  name="itemTransferTransBean" type="mms.transactions.controller.fb.ItemTransferTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="itemTransferTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="itemTransferTransBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="itemTransferTransBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Item Transfer Transaction" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>

   <table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
	   		   	
		<tr class="HEADER">

			<td colspan="4"></td>
			<!-- <td align="right"><span><html:checkbox name="itemTransferTransBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Transfer Item Detail"></html:checkbox></span>View</td> -->
		</tr>
				
	    </table>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   
		<tr>
			<td width="25%" colspan="1" class="LABEL">
			    <font color="red">*</font>Store Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			 
			     <select name="strStoreName" class="comboMax"   onChange="getItemCatCombo(this);">
                        <bean:write name="itemTransferTransBean" property="strStoreName" filter="false"/>
                 </select>
          	</td>
          	 <td width="25%" colspan="1" class="LABEL">
			   <font color="red">*</font>Item Category
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <div id="ItemCatCmbDIV">
               <select name="strItemCatCmb" class='comboNormal' onChange='getGroupNameCombo();'>
					<bean:write name="itemTransferTransBean" property="strItemCategoryCombo" filter="false"/>
			   </select>	
               </div>  
		    </td>
		  </tr>
		<tr>
		   <td width="25%" colspan="1" class="LABEL">
			   <font color="red">*</font>Sub Store</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <div id="toStoreName" > 
			     <select name="strToStoreName" class="comboMax" >
                       <option value="0">Select Value</option>
                 </select>
              </div>   
          	</td>
			<td width="25%" colspan="1" class="LABEL">
			   <font color="red">*</font>Transfer Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="itemTransferTransBean" property="strCtDate" filter="false" />
		    </td>
		</tr>
		
	    </table>
      
       
	   <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">
	   <tr class="HEADER">
			 <td  class="TITLE" width="100%" colspan="6"><div align="right"><img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
 onclick='getItemSelectPopup();' TITLE='Click Here To Search Item'></div></td> 
		</tr>
		</table>
		<div id="costDivReqId" style="display: none">
		 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			<td width="30%" class="multiLabel">Item/Drug Name
			</td>
			<td width="14%" class="multiLabel">Batch/SlNo
			</td>
			<td width="14%" class="multiLabel">Avl Qty
			</td>
			<td width="12%" class="multiLabel"><font color="red">*</font>Transfer Qty
			</td>
			<td width="20%" class="multiLabel"><font color="red">*</font>Unit
			</td>
			<td width="10%" class="multiLabel">Cost
			</td>
			</tr>
			</table>	
			</div>
			<div id="costDivNotReqId" style="display: none">
		    <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			<td width="25%" class="multiLabel">Item/Drug Name
			</td>
			<td width="19%" class="multiLabel">Batch/SlNo
			</td>
			<td width="19%" class="multiLabel">Avl Qty
			</td>
			<td width="17%" class="multiLabel"><font color="red">*</font>Transfer Qty
			</td>
			<td width="20%" class="multiLabel"><font color="red">*</font>Unit
			</td>
			
			</tr>
			</table>	
		</div>
		    <div id="id1"></div>
		 <div id="totalCostId" style="display: none">   
		   <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
           <tr>
		     <td colspan="5" class="LABEL" width="80%">Total Transfer Cost</td>
		     <td colspan="1" class="multiControl" width="20%">
		       <div id="strTotalTransferCostDivId" style="color: red;font-weight:bold">0.00</div>
		          <input type="hidden" name="strTotalTransferCost">
		     </td>
	       </tr>	
	       
	       </table>   
	     </div> 
        <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
          
	      <tr> 
            <td width="25%" class="LABEL"> <font color="red">*</font>Received By</td>
            <td class="CONTROL" width="25%">
              <div id="receivedByCmb" > 
                 <select name="strReceivedComboBy" onchange="checkValCombo();">
               	  <bean:write name="itemTransferTransBean" property="strReceivedByOptionVal" filter="false"/>
                 </select>
              </div> 
            </td>
            <td class="CONTROL" width="25%" id='labelId'>
            	<div id='labelNameId'></div>
            </td>
            <td class="CONTROL" width="25%">
            	<div id="nameOtherFld" style="display: none">
            		<input type='text' name='strReceiveBy' value=''  maxlength='50'>
            	</div>
            </td>
          </tr>	  
          <tr> 
            <td width="25%"  class="LABEL"><font color="red">*</font>Remarks</td>
            <td class="CONTROL" colspan="3">
            <textarea name="strRemarks" cols="20" rows="2"id="strRemarks" ></textarea> </td>
          </tr>
          <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		  </tr>
    	</table>
	
	<!-- 
	<table  class="TABLEWIDTH" align="center">
	    <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" />
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" />
			</td>
		</tr>
	</table>
		-->
		<br>
    <div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
					</div> 
    <input type="hidden" name="hmode"/>
     <input type="hidden" name="strCostRequired" value="${itemTransferTransBean.strCostRequired }">
      <input type="hidden" name="strReOrderFlgColor" value="${itemTransferTransBean.strReOrderFlgColor}"/>
      <input type="hidden" name="strTmpStoreNo" value="${itemTransferTransBean.strTmpStoreNo}"/>
      <input type="hidden" name="strTmpTransferNo" value="${itemTransferTransBean.strTmpTransferNo}"/>
	  <input type="hidden" name="strTmpTransferDate" value="${itemTransferTransBean.strTmpTransferDate}"/>
	   <input type="hidden" name="strDwhName" value="${itemTransferTransBean.strDwhName}"/>
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
  <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
         <div id="transferDtlsDivId" style="display:block;"></div>
      </td>
     </tr>
    </table>
   </div>
    
</html:form>
<jsp:include page="itemTransferSearchRow.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>