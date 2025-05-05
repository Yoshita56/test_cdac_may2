<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html >
<head>
<meta charset=UTF-8">
<title></title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>

<script type="text/javascript">
function getItemSelectPopup(){
	
		var strModeVal 					= "3" ; 
		var strItemCategory 			= document.forms[0].strItemCategoryNo.value; 
		var strIssueType 				= "0";
		var strFromStoreId 				= document.forms[0].strStoreId.value;
		var strToStoreId  				= "0";
		var strRequestType				="62";
	//	var strStoreTypeId  			= document.forms[0].strStoreTypeId.value
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue');
		var strMultiRowCompTypeArray 	= new Array('t','t','t');
		
		var strMultiRowFetchDataArray 	= new Array('1','4','16');
		
		var layerIndex = "1";
		searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
}
function validate1()
{
			var hisValidator = new HISValidator("lotsDetailTransBean");
 	       //hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please Select Group" );
 	       hisValidator.addValidation("strCondemnationType","dontselect=0","Please Select Condemnation Type" );
       	  	var retVal = hisValidator.validate(); 
         	 hisValidator.clearAllValidations();
         	 if(retVal){
							if(document.getElementsByName("itemParamValue").length=="1")
     						{
     							alert("Please Search Drug Details");
     							return false;
     						}
							document.forms[0].hmode.value="INSERT";
							document.forms[0].submit();
						}
}
function cancelToDesk()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].submit();
}

function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}
function clearFun()
{
	//document.forms[0].mode.value=obj;
	document.forms[0].hmode.value="CLEAR";
	document.forms[0].submit();
}
</script>

</head>

<body>

<html:form action="/transactions/LotsDetailTransCNT"  name="lotsDetailTransBean" type="mms.transactions.controller.fb.CondemnationRegisterTransFB" method="post" >

    <div class="errMsg"     id="errMsg"><bean:write name="lotsDetailTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="lotsDetailTransBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="lotsDetailTransBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Lots Details Transaction" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>

<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	 	<tr>
	 		<td class="LABEL"  width="25%">
	 			Store Name
	 		</td>
	 		<td class="CONTROL"  width="25%">
	 		<bean:write name="lotsDetailTransBean" property="strStoreName" filter="false"/>
	 		</td>
	 		<td class="LABEL" colspan="1" width="25%">
	 			Item Category Name
	 		</td>
	 		<td class="CONTROL"  width="25%">
	 		<bean:write name="lotsDetailTransBean" property="strItemCategoryName" filter="false"/>
	 		</td>
	 	
	 	</tr>
	 </table>
	 
	   
	  
	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">  
        <tr class="TITLE">
			<td colspan="6"><div align="right"><img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
                onclick='getItemSelectPopup();'></div></td>
		</tr>
        </table>
	
	
	 
	 <div id="itemDetailsId">
	 
	 
	 	
	 		<table cellspacing="1px" class="TABLEWIDTH" align="center" bgcolor='black'  cellpadding='1px' cellspacing='1px'>
						
				<tr>
					<td  class="multiLabel" width="33.33%">
						Item/Drug Name
					</td>
					<td  class="multiLabel"  width="33.33%">
						Aval Qty.
					</td>
					<td  class="multiLabel"  width="33.33%">
						Cost
					</td>
				</tr>
			</table>
		
		<div id="id1" >
		</div>
			<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="1px">
			<tr class="FOOTER">
					<td  colspan="5"> </td>
				</tr>
			</table>
		
	 </div> 
	  <table class="TABLEWIDTH" align="center" cellspacing="1px">
	 	<tr>
	 		<td class="LABEL" width="50%"><font color='red'>*</font>Condemnation Type</td>
	 		<td class="CONTROL" width="50%">
	 				<select name="strCondemnationType" >
	 				
	 				<bean:write property="strCondemnTypeVals" name="lotsDetailTransBean" filter="false"/>
	 		</select>
	 		</td>
	 		
	 	</tr>
	 	<tr>
	 		<td class="LABEL">
	 			Remarks
	 		</td>
	 		<td class="CONTROL">
	 			<textarea name="strRemarks"></textarea>
	 		</td>
	 	</tr>
	 	
	 </table>
	<table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  <font size="2" color="blue">**</font>Condemned Item</td>
  		</tr>
	     <tr> 
		<td align="center">
		<img src="../../hisglobal/images/btn-sv.png"   onClick="return validate1();" style="cursor: pointer;" title="Click Here To Save"/>
		<img src="../../hisglobal/images/btn-clr.png"
				onClick="clearFun();" style="cursor: pointer;" title="Click here to reset the data">
		<img src="../../hisglobal/images/back_tab.png" onClick ="cancelToDesk();" style="cursor: pointer;" title="Click Here To Cancel"/>
	   </td>
	  </tr>
</table>
		<input type="hidden" name="hmode"/>
	    <input type="hidden" name="strStoreId" value="${lotsDetailTransBean.strStoreId}"/>
		<input type="hidden" name="strItemCategoryNo" value="${lotsDetailTransBean.strItemCategoryNo}"/>
		<input type="hidden" name="comboName" value="${lotsDetailTransBean.comboName}"/>
      	<input type="hidden" name="strPath" value="${lotsDetailTransBean.strPath}"/>
      	 <input type="hidden" name="cnt_page" value="${lotsDetailTransBean.cnt_page}"/>
	      
<cmbPers:cmbPers/>
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDivId" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="itemParameterDtlDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>
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

</html:form>
<jsp:include page="lots_details_search_row.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>