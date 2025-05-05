<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=UTF-8">
<title>Cost Estimation Calculator</title>
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
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/costEstimation.js"></script>

<script type="text/javascript">
    function getItemSelectPopup()
    {
       document.getElementById("id1").innerHTML = "";    
       document.getElementById("strTotalTransferCostDivId").innerHTML = "0.00";
                    document.forms[0].strTotalTransferCost.value="0.00";
    
		var strModeVal 					= "2" ; 
		var strItemCategory 			= document.forms[0].strItemCatCmb.value;
		var strSupplierId   			= "";  
		var strContractTypeId   		= "";  
		var strRequestType				= "75";
		var strFromStoreId 				= "0";
		var strToStoreId  				= "0";
		
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strTransferQty');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t');
		// for mode val 2
		var strMultiRowFetchDataArray 	= new Array('1','3');
		
		var layerIndex = "1";		
		var strUserInfo = ""; 	 //    Orignal Vale
	    
	    //searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, StoreCmb, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );
	    searchItems( strModeVal, strItemCategory, strRequestType, strFromStoreId, strMultiRowCompArray, strMultiRowCompTypeArray,strMultiRowFetchDataArray, layerIndex,strUserInfo);
}

</script>
</head>
<body>

<html:form action="/transactions/CostEstimationCNT.cnt"  name="costEstimationBean" type="mms.transactions.controller.fb.CostEstimationFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="costEstimationBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="costEstimationBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="costEstimationBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Cost Estimation Calculator" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>

   <table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
	   		   	
		<tr class="HEADER">

			<td colspan="4"></td>
			<!-- <td align="right"><span><html:checkbox name="costEstimationBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Transfer Drug Detail"></html:checkbox></span>View</td> -->
		</tr>
				
	    </table>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   
		<tr>
			<td width="25%" colspan="1" class="LABEL">
			    Estimation Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			 
			     <bean:write name="costEstimationBean" property="strCtDate" filter="false" />
          	</td>
          	 <td width="25%" colspan="1" class="LABEL">
			   <font color="red">*</font>Category
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			 
               <select name="strItemCatCmb" class='comboNormal'>
					<option value="10">Drug</option>
			   </select>	
              
		    </td>
		  </tr>				
	    </table>
      
       
	   <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">
	   <tr class="HEADER">
			 <td  class="TITLE" width="100%" colspan="6"><div align="right"><img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
                               onclick='getItemSelectPopup();' TITLE='Click Here To Search Item'></div></td> 
		</tr>
		</table>
		
		 <table class="TABLEWIDTH" align="center" cellpadding="1px"  bgcolor="#CC9966" cellspacing="1px">
			<tr>
			<td width="45%" class="multiRPTLabel">Drug Name
			</td>
			<td width="15%" class="multiRPTLabel">Rate/Unit
			</td>
			<td width="15%" class="multiRPTLabel">Req Qty
			</td>
			<td width="15%" class="multiRPTLabel">Approx. Cost
			</td>
			</tr>
			</table>				
		    <div id="id1"></div>
		    
		   <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
           <tr>
		     <td  class="LABEL" width="85%">Total Approx. Cost ::</td>
		     <td  class="multiPOControl" width="15%">
		       <div id="strTotalTransferCostDivId" style="color: red;font-weight:bold">0.00</div>
		          <input type="hidden" name="strTotalTransferCost">
		     </td>
	       </tr>	
	     </table>  
	      <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
       		<tr>
       			<td class="TITLE" colspan="2">      				
       			</td>
       		</tr>
       	</table> 
	<table  class="TABLEWIDTH" align="center">
	    <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/print_tab.gif"  onClick=" return printCostEstimation();" />
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" />
			</td>
		</tr>
	</table>	
    
    <input type="hidden" name="hmode"/>     

	  <input type="hidden" name="strTmpTransferDate" value="${costEstimationBean.strTmpTransferDate}"/>
	  <input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
	  <input type="hidden" name="strHiddenValue" id="strHiddenValue" />
	  

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
<jsp:include page="cost_estimation_SearchRow.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>