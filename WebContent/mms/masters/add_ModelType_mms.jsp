<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<html>
<head>
<meta charset=utf-8>
<title>Item Type Master Add Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>


<script language ="javaScript">
function validate1(){   
	  var strGroupNameId="";
	  document.forms[0].strGroupNameId.value= document.forms[0].strGroupNameId[document.forms[0].strGroupNameId.selectedIndex].value;

      var hisValidator = new HISValidator("ModelTypeBean");
           
      var retVal = hisValidator.validate(); 
          if(retVal){
        	var strGroupNameId = document.forms[0].strGroupNameId[document.forms[0].strGroupNameId.selectedIndex].value;
        	//alert(strGroupNameId);  
        	document.forms[0].strGroupNameId.value= document.forms[0].strGroupNameId[document.forms[0].strGroupNameId.selectedIndex].value;
        	//alert(document.forms[0].strGroupNameId.value);  
        	document.forms[0].hmode.value = "SAVE";
        	document.forms[0].submit();
          }else{
           return false;
          }
    }
 
function ItemCombo()
{	
	var strGroupNameId = document.forms[0].strGroupNameId[document.forms[0].strGroupNameId.selectedIndex].value
	var catgId         = document.getElementsByName("combo")[0].value;  
	var url ="ModelTypeMstCNT.cnt?hmode=ITEMCOMBO&GroupId="+strGroupNameId+"&catgId="+catgId;
	//alert(url);
	 
	 ajaxFunction(url,"1");
}
function getAjaxResponse(res,mode)
{
		var objVal;
		if (mode == "1") 
		{
			//alert(res);
			objVal = document.getElementById("Brand");
			objVal.innerHTML = "<select name ='strItemNameId' class='form-select' onChange = '' >"+ res + "</select>";
		}
}
</script>

</head>
<!-- onload="document.forms[0].strGroupName.focus();" -->
<body>
<html:form name="ModelTypeBean" action="/masters/ModelTypeMstCNT" type="mms.masters.controller.fb.ModelTypeMstFB">

	<div class="errMsg"><bean:write name="ModelTypeBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="ModelTypeBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="ModelTypeBean" property="strMsg"/></div>

<tag:tab tabLabel="Model Type Master" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab> 
	
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class ="HEADER">
  <td colspan ="2" >Model Type Master  &gt;&gt; Add</td>
  </tr> 
  <tr>
    <td class="LABEL">Item Category Name</td>
    <td width="50%" class ="CONTROL">
    	<bean:write name="ModelTypeBean" property="strItemCategoryName" filter="false"/>
    </td>
  </tr>
                
   <tr>
    <td class="LABEL"><font color="red">*</font>Group Name</td>
    <td width="50%" class ="CONTROL">
    	<div id="strGroupNameIdDiv">
			<select name="strGroupNameId" class="comboNormal" onchange="ItemCombo();">
				<bean:write name="ModelTypeBean" property="strGroupNameCombo" filter="false"/>
				
			</select> 
		</div>  
	</td>
  </tr>
   
   <tr>
    <td class="LABEL"><font color="red">*</font>Item Name</td>
    <td width="50%" class ="CONTROL">		
		 <div id="Brand">
			<select name="strItemNameId" class="comboNormal">
				<option value="0">All Value</option>
			</select>
		</div>
    </td>
   </tr>
   
   <tr>
    <td class="LABEL"><font color="red">*</font>Model No</td>
    <td width="50%" class ="CONTROL">
   		<input type="text" name="strModelName" class="txtFldNormal" value ="" maxlength="50" onkeypress="return validateData(event,18);" style="width: 200px;"> 
   	</td>
  </tr>
   <tr class ="FOOTER" >
  <td colspan ="2" ><font size="2" color="red">*</font>Mandatory Field</td>
  </tr>
</table>

<div align="center">
   <table CLASS ="TABLEWIDTH" cellpadding="1px" cellspacing="1px">
     <tr> 
	    <td align="center">
			<br>					 
			<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
			<a href="#" class="button"	onclick="document.forms[0].reset(),document.forms[0].strGroupNameId.focus();" ><span class="clear">Clear</span></a> 
			<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
		</td>
     </tr>
   </table>
   
   <input type="hidden" name="hmode">
   <input type="hidden" name="strHospitalCode"  value="${ModelTypeBean.strHospitalCode}">
   
   <%-- <input type="hidden" name="strItemTypeId"    value="${ModelTypeBean.strItemTypeId}"> --%>
   <input type="hidden" name="comboValue"	    value="${ModelTypeBean.strItemCategoryName}"/>  
</div>
	 	
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	
			
			