<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Sample Register</title>


<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">


<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script type="text/javascript"><!--

function validate1()
{
		  var hisValidator = new HISValidator("sampleRegisterTransBean");
          hisValidator.addValidation("strTenderNo","req","Tender No. is a Mandatory Field");
          hisValidator.addValidation("strQuotationNo","req","Quotation No. is a Mandatory Field");
          hisValidator.addValidation("strSupplierName","dontselect=0","Please select Supplier Name" );
       	  var retVal = hisValidator.validate(); 
          hisValidator.clearAllValidations();
     	 if(retVal)
     	 {
     	 	if(document.getElementsByName("itemParamValue").length=="1")
     		{
     			alert("Please Search Item/Drug Details");
     			return false;
     		}
     		else
     		{
     			retVal=true;
     		}
     	 }
     	if(retVal)
     	{
     		 hisValidator.addValidation("strBatchSlNo","req","Batch Sl.No. is a Mandatory Field" );
     		 hisValidator.addValidation("strQty","req","Quantity is a Mandatory Field" );
     		 hisValidator.addValidation("strQty","amount=7,2","Quantity should be in proper format" );
     		 hisValidator.addValidation("strUnitName","dontselect=0","Please select Unit" );
     		 hisValidator.addValidation("strRemarks","req","Remarks is a Mandatory Field" );
     		 hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
     	 	 var retVal = hisValidator.validate(); 
          	 hisValidator.clearAllValidations();
         }
          if(retVal){
                       document.forms[0].hmode.value = "INSERT";
                       document.forms[0].submit();
            }else{

           return false;
           }
	
}

 function invokeCheckQty(mode, index, unitObject){
 	//checkQty(index,'strQty','strUnitName');
  }
function getItemSelectPopup(){
	
		var strModeVal 					= "2" ; 
		var strItemCategory 			= document.forms[0].strItemCategory.value; 
		var strIssueType 				= "0";
		var strFromStoreId 				= document.forms[0].strStoreId.value;
		var strToStoreId  				= "0";
		var strRequestType				="53";
		var strStoreTypeId  			= document.forms[0].strStoreTypeId.value
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strExpDate','strBatchSlNo','strQty','strUnitName');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','d','t','t','s');
		
		var strMultiRowFetchDataArray 	= new Array('1','0^strUnitName^invokeCheckQty');
		
		var layerIndex = "1";
		searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
}


function view1(id1,id2,id3)
{
		document.getElementById(id1).style.display="none";
		document.getElementById(id2).style.display="block";
		document.getElementById(id3).style.display="block";
}
function view2(id1,id2,id3)
{
		document.getElementById(id1).style.display="block";
		document.getElementById(id2).style.display="none";
		document.getElementById(id3).style.display="none";
}

function cancelDesk()
{
	document.forms[0].hmode.value="INITIALPAGE";
	document.forms[0].submit();
}
function clearFun(obj)
{
	document.forms[0].mode.value=obj;
	document.forms[0].hmode.value="CLEAR";
	document.forms[0].submit();
}

function  enterData(){

 var url="MmsCNT.cnt?hmode=INITVALFORNEWITEM&strCatCode="+document.forms[0].strItemCategory.value;
  ajaxFunction(url,"1");
}
function getAjaxResponse(res,mode){
				
				var err = document.getElementById("errMsg");
				var temp = res.split("####");
				if(temp[0] == "ERROR")
				{
					err.innerHTML = temp[1];
					return;
				}
				
				var objVal;
				if(mode=="1"){				
				
				temp = res.split("^");
				
				
				
					document.getElementById("manufactureDIV").innerHTML="<select name='strNewManufauterName'>"+temp[0]+"</select>";	
					document.getElementById("itemTypeDIV").innerHTML="<select name='strNewItemType'>"+temp[1]+"</select>";	
					document.getElementById("blanket").style.display="none";
					popup('itemDiv','100','200');
				}
				
}

function closeReportPopUp()
{

 	hide_popup('itemDiv'); 
 	document.forms[0].strNewItem.checked=false;
 	document.getElementById("blanket").style.display="block";
}
</script>

</head>

<body>
<html:form name="sampleRegisterTransBean" action="/transactions/SampleRegisterTransCNT"
	type="mms.transactions.controller.fb.SampleRegisterTransFB">


<div class="errMsg" id="errMsg"><bean:write name="sampleRegisterTransBean" property="strErr"/></div>
<div class="warningMsg"><bean:write name="sampleRegisterTransBean" property="strWarning"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="sampleRegisterTransBean" property="strMsg"/></div>

<center><tag:tab tabLabel="Sample Register"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">
		<tr class="HEADER">
			<td colspan="4">Sample Register&gt;&gt; Add
				
			</td>
		</tr>
		
		
		<tr>
			<td  width="25%" class="LABEL">Store Name</td>
			<td  width="25%" class="CONTROL" colspan="3">
				<bean:write name="sampleRegisterTransBean" property="strStoreName" filter="false"/>
			</td>
			
		</tr>
		<tr>
			<td  width="25%" class="LABEL">Item Category</td>
			<td  width="25%" class="CONTROL">
				
				<bean:write name="sampleRegisterTransBean" property="strItemCategoryName" filter="false"/>
			</td>
			<td  class="LABEL" width="25%">
								<font color="red">*</font>Supplier Name
								</td>
								<td  class="CONTROL" width="25%">
									<div id="supplierId">
								 		<select name="strSupplierName" class="comboNormal" onChange = "">
											<bean:write name="sampleRegisterTransBean" property="strSupplierValues" filter="false"/>
										</select>
										</div>
					</td>
		</tr>
		
		<tr>
		
			<td  width="25%" class="LABEL"><font color="red">*</font>Tender No.</td>
			<td  width="25%" class="CONTROL">
				<input type="text" name="strTenderNo" value="" class="txtNormal" onkeypress="return validateData(event,9);" maxlength="25">
			</td>
			
		<td  width="25%" class="LABEL"><font color="red">*</font>Tender Date</td>
			<td  width="25%" class="CONTROL">
				<dateTag:date name="strTendorDate" value="${sampleRegisterTransBean.strCurrentDate}"></dateTag:date>
			</td>
			
		</tr>
		
			<tr>
		
			<td  width="25%" class="LABEL"><font color="red">*</font>Quotation No.</td>
			<td  width="25%" class="CONTROL">
				<input type="text" name="strQuotationNo" value="" class="txtNormal" maxlength="25" onkeypress="return validateData(event,9);">
			</td>
			
		<td  width="25%" class="LABEL"><font color="red">*</font>Quotation Date</td>
			<td  width="25%" class="CONTROL">
				<dateTag:date name="strQuotationDate" value="${sampleRegisterTransBean.strCurrentDate}"></dateTag:date>
			</td>
			
		</tr>
		
		</table>
		
		
		<div id="itemDetailsHeadingId" style="display:block">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusItemDetailsId" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusItemDetailsId','minusItemDetailsId','itemDetailsId');" style="cursor: pointer; "/>
						<img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
 onclick='getItemSelectPopup();' name="searchName" title="Click here to Search Item" >
			
					</div>
					<div id="minusItemDetailsId" style="display:block;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusItemDetailsId','minusItemDetailsId','itemDetailsId');" style="cursor: pointer; "/>
								<img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
 onclick='getItemSelectPopup();' name="searchName" title="Click here to Search Item" >
			
					</div>
				</td>
		</tr>
	</table>
	</div>
		
		<div id="itemDetailsId" style="display:block">
			<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0px">
			
			
				<tr>
					<td  class="multiLabel" width="15%">
						Item/Drug Name
					</td>
					<td  class="multiLabel" width="20%">
						Expiry Date
					</td>
					<td  class="multiLabel" width="30%">
						<font color='red'>*</font>Batch/Serial No
						
					</td>
					
					<td  class="multiLabel"  width="15%">
						<font color='red'>*</font>Recieved Qty.
					</td>
					<td  class="multiLabel"  width="20%">
						<font color='red'>*</font>Unit
					</td>
				</tr>
			</table>
		
		<div id="id1" >
		</div>
			<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
				<tr class="FOOTER">
					<td  colspan="5"> </td>
				</tr>
			</table>
		</div>	
			
		<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
		<tr>
		<td  class="LABEL" width="25%" colspan="1">
					<font color='red'>*</font>Remarks 
		</td>
		<td class="CONTROL" colspan="3">
			<textarea rows="2" cols="20" name="strRemarks"></textarea>
		</td>
					
		</tr>	
		</table>
		<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
		
		<tr class="FOOTER">
		<td colspan="4" width="25%"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img src="../../hisglobal/images/btn-sv.png"
				onClick="validate1();" style="cursor: pointer;" title="Click here to save the data">
			<img src="../../hisglobal/images/btn-clr.png"
				onClick="clearFun('recieve');" style="cursor: pointer;" title="Click here to reset the data">
			<img src="../../hisglobal/images/back_tab.png"
				onClick="cancelDesk();" style="cursor: pointer;" title="Click here to forward control back to Sample Register Desk">
				</td>
		</tr>
	</table>
				
<input type="hidden" name="comboValue" value="${sampleRegisterTransBean.comboValue}"/>
<input type="hidden" name="strStoreId" value="${sampleRegisterTransBean.strStoreId}"/>
<input type="hidden" name="strStoreTypeId" value="${sampleRegisterTransBean.strStoreTypeId}"/>
<input type="hidden" name="strStoreName" value="${sampleRegisterTransBean.strStoreName}"/>
<input type="hidden" name="strGroupName" value="${sampleRegisterTransBean.strGroupName}"/>
<input type="hidden" name="strPath" value="${sampleRegisterTransBean.strPath}"/>
<input type="hidden" name="strItemCategory" value="${sampleRegisterTransBean.strItemCategory}"/>
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>
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


<div class="popUpDiv" id="itemDiv" style="display: none;">
		<table bgcolor="white"  width="500" cellpadding="1px" cellspacing="1px" border="0" align="center">
				<tr class="HEADER">
			<td colspan="4">New Item/Drug </td>
		</tr>
				<tr>
			<td colspan="1" width="25%" class="LABEL">Item/Drug Name</td>
			<td colspan="1"  class="CONTROL" >
				<input type='text' name='strNewItemName' value="">
      </td>
			<td colspan="1" width="25%" class="LABEL">Item/Drug Type</td>
			<td colspan="1"  class="CONTROL">
			<div id='itemTypeDIV'>
				<select name='strNewItemType'>
					<option value="0">Select Value</option>
				</select>
			</td>
			
		</tr>
		<tr>
			<td colspan="1" width="25%" class="LABEL">Manufacturer</td>
			<td colspan="3"  class="CONTROL" >
			<div id='manufactureDIV'>
				<select name='strNewManufauterName'>
				
				</select>
					</div>
      </td>
		</tr>
		
		<tr>
			<td colspan="1" width="25%" class="LABEL">Rate</td>
			<td colspan="1"  class="CONTROL" >
				<input type='text' name='strNewRate' value="">
             </td>
             <td colspan="1" width="25%" class="LABEL">unit</td>
             	<td colspan="1"  class="CONTROL" >
				<select name='strNewRate'>
					<option value="0">Select Value</option>
				</select>
      </td>
			
			
		</tr>
		<tr class="FOOTER">
			 <td colspan="4"> </td>
		</tr>
		<tr>
			<td colspan="4"  class="multiControl">
			<img src="../../hisglobal/images/btn-ok.png" name="generate"
				onclick="generateReportFunc();" onkeypress="generateReportFunc();">
			<img src="../../hisglobal/images/close_tab.png" name="close"
				onclick="closeReportPopUp();" onkeypress="closeReportPopUp();"></td>
		</tr>
				</table>
</div>
</html:form>
<jsp:include page="sampleRegisterSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>








