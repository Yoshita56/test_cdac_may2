<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Insert Title Here</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="javaScript">

function showDetails(divId){
            document.getElementById(divId).style.display="block";                     
            document.getElementById('minus'+divId).style.display="block";
            document.getElementById('plus'+divId).style.display="none";
}

function hideDetails(divId){
			document.getElementById(divId).style.display="none";
            document.getElementById('minus'+divId).style.display="none";
            document.getElementById('plus'+divId).style.display="block";
}

function ajaxSubGroup(mode)
{ 
   var mode ="SUBGROUPNAME";  
   var url="SparePartsMstCNT.cnt?hmode=SUBGROUPNAME&GroupId="+document.forms[0].strGroupId.value+"&CategoryNo="+document.forms[0].strSparePatCategoryNo.value ;
   ajaxFunction(url,"1");
}
function ajaxItemName()
{
	 var url;
	 var mode = "ITEMNAME";
	// alert("ITEMNAME"); 
	// alert("CategoryNo="+document.forms[0].strSparePatCategoryNo.value);
	// alert("&GroupId="+document.forms[0].strGroupId.value);
	// alert("&subGroupId="+document.forms[0].strSubGroupId.value);  
	 url="SparePartsMstCNT.cnt?hmode=ITEMNAME&CategoryNo="+document.forms[0].strSparePatCategoryNo.value+
	 "&GroupId="+document.forms[0].strGroupId.value+
	 "&subGroupId="+document.forms[0].strSubGroupId.value;     
	 ajaxFunction(url,"2");
}

function getAjaxResponse(res,mode){
				
				//alert("comboValue="+document.forms.combo[0].value);
				var objVal;
				var objVal2;
				if(mode=="1"){				
				var temp = res.split("^");		
					objVal= document.getElementById("SubGroupId");
					objVal.innerHTML = "<select name ='strSubGroupId' class='comboNormal' onChange = 'ajaxItemName()' >" + temp[0] + "</select>";
					
					objVal2= document.getElementById("ItemNameId");
					objVal2.innerHTML = "<select name ='strSparePartItemId' class='comboNormal' >" + temp[1] + "</select>";						 		
				}
				if(mode=="2"){				
					objVal= document.getElementById("ItemNameId");
					objVal.innerHTML = "<select name ='strSparePartItemId' class='comboNormal' >" + res + "</select>";				
				}
}

function validate1()
{	
	    var hisValidator = new HISValidator("sparepartBean");	
		
		hisValidator.addValidation("strSparePatCategoryNo", "dontselect=0","Please select a value from Spare Part Category");
		hisValidator.addValidation("strGroupId", "dontselect=0","Please select a value from Group Name"); 	    hisValidator.addValidation("strSparePartItemId", "dontselect=0","Please select a value from Spare Part Item Name");
 	    hisValidator.addValidation("strEffectiveFrom ", "date","Effective From is a mandatory field");     
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
         
	    var retVal = hisValidator.validate(); 
	 	hisValidator.clearAllValidations();	    
		if(retVal)
		{		      
				document.forms[0].hmode.value = "SAVE";
				document.forms[0].submit();
		
		}
		else
		{
		  return false;
		}
		
}

</script>
</head>
<body>
<html:form action="/masters/SparePartsMstCNT.cnt"  name="sparepartBean" type="mms.masters.controller.fb.SparePartsMstFB" method="post">

    <div class="errMsg" id="errMsg" ><bean:write name="sparepartBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="sparepartBean" property="strWarning"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="sparepartBean" property="strMsg"/></div>
<tag:tab tabLabel="Spare Parts"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">   
	   <tr class="HEADER">
			<td colspan="2">Spare Parts&gt;&gt;Add</td>
		</tr>
		<tr>
			<td colspan="1" width="50%" class="LABEL">Item Category Name</td>
			<td colspan="1" width="50%" class="CONTROL">
			<bean:write name="sparepartBean" property="strItemCatgName" filter="false"/>
		</tr>
		
		<tr>
			<td colspan="1" width="50%" class="LABEL">
			Item Name
			</td>
			<td colspan="1" width="50%" class="CONTROL">
  			<bean:write name="sparepartBean" property="strItemName" filter="false"/>
   			</td>
		</tr>
		</table>
		
 <div id="spareId" style="display: block;">
				<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">  
				<tr>
					<td class="multiLabel" width="5%">

					<div id="plusSpareDivId" style="display: none" ><img
						src="../../hisglobal/images/plus.gif" name="plusonLine"
						align="middle"
						onclick="showDetails('SpareDivId');" /></div>

					<div id="minusSpareDivId" style="display: block;"><img
						src="../../hisglobal/images/minus.gif" name="minusonLine"
						onclick="hideDetails('SpareDivId');"></div>

					</td>
				

					<td colspan="3" width="95%" class="TITLE">Previous Spare Part Detail</td>
				</tr>
				</table>
				</div>
  
            <div id="SpareDivId" style="display:block">
				<bean:write name="sparepartBean" property="strPreviousSparePartDtl" filter="false"/></div>
 
		
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
        			 cellspacing="1px">
        			 
        			 <tr class="TITLE">
			<td colspan="8">Item Details</td>
		</tr>  
        	<tr>
				<td colspan="1" width="50%" class="LABEL">
				<font color="red">*</font>Spare Part Category</td>
				<td colspan="1" width="50%" class="CONTROL">               
               <select name="strSparePatCategoryNo" class="comboNormal">
                        <bean:write name="sparepartBean" property="strSparePartCatgCombo" filter="false"/>     
               </select></td>
		    </tr> 
				<tr>
					<td class="LABEL" width="50%">
					<font color="red">*</font>Group Name
					</td>
					<td class="CONTROL" width="50%">
					<select name="strGroupId" class='comboNormal' onchange="ajaxSubGroup('SUBGROUPNAME');">
						<bean:write name="sparepartBean" property="strGroupCombo" filter="false"/>
						
					</select>
					</td>
				</tr>
				<tr>
					<td class="LABEL" width="50%">
					Sub Group Name
					</td>
					<td class="CONTROL" width="50%"><div id="SubGroupId">
					<select name="strSubGroupId" class="comboNormal" onChange="ajaxItemName();">
					<option value="0">Select Value</option>
					</select></div>
					</td>
				</tr>
				<tr>
					<td class="LABEL" width="50%">
					<font color="red">*</font>Spare Part Item Name
					</td>
					<td class="CONTROL" width="50%">
					<div id="ItemNameId"><select name="strSparePartItemId" class='comboNormal'>
						<option value="0">Select Value</option>
					</select></div>
					</td>
				</tr>
				
				<tr>
					<td width="50%" class="LABEL">
					<font color="red">*</font>Effective From</td>
					<td class ="CONTROL"><date:date name="strEffectiveFrom" value="${sparepartBean.strCtDate}"></date:date></td>
				</tr> 
				<tr>
					<td width="50%" class="LABEL">Remarks</td>
					<td width="50%" class="CONTROL">
			  		<div align="left">
        				<textarea name="strRemarks" rows="2"></textarea>
    	 			</div></td>
			  </tr>
			</table>
		
      <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
        <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	
	<div id="id1"></div>
	
	<table  class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	 <tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>	
	<input type="hidden" name="strItemCatgNo" value="${sparepartBean.combo[0]}"/>
	<input type="hidden" name="strItemCatgName" value="${sparepartBean.strItemCatgName}"/>
	<input type="hidden" name="strItemId" value="${sparepartBean.combo[1]}"/>
	<input type="hidden" name="strItemName" value="${sparepartBean.strItemName}"/>
	<input type="hidden" name="strCtDate" value="${sparepartBean.strCtDate}"/>
	<input type="hidden" name="comboValue" value="${sparepartBean.strComboValues}"/>
    <input type="hidden" name="hmode"/>
    <cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>