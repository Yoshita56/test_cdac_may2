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
<meta charset="utf-8">
<title>Item Type Master Modify Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">

function validate1(){   
     
       var hisValidator = new HISValidator("ItemTypeBean");

 			//hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
         hisValidator.addValidation("strItemTypeName", "req", "Item Type Name is a Mandatory Field" );
         hisValidator.addValidation("strShortName", "req", "Short Name is a Mandatory Field" );
         // hisValidator.addValidation("strEffectiveFrom", "dtgtet=${ItemTypeBean.strCtDate}" , "Effective From Date should be Greater than or Equal to Current Date");
		 hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );

     	  var retVal = hisValidator.validate(); 
    
          if(retVal)
          {
                 	   document.forms[0].hmode.value = "UPDATE";
                       document.forms[0].submit();
           }
           else
           {
             return false;
           }
    }

</script>


</head>
<body onLoad="document.forms[0].strItemTypeName.focus()">
<html:form name="ItemTypeBean" action="/masters/ItemTypeMstCNT" type="mms.masters.controller.fb.ItemTypeMstFB">
  
  <div class="errMsg"><bean:write name="ItemTypeBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="ItemTypeBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="ItemTypeBean" property="strMsg"/></div>
	
 <tag:tab tabLabel="Item Type Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class="HEADER"> 
    <td colspan="2">Item Type Master&gt;&gt;Modify</td>
  </tr>          
  
 
  <tr >
    <td class="LABEL">Item Category Name</td>
    <td width="50%" class ="CONTROL">  <bean:write name="ItemTypeBean" property="strItemCategoryName" /></td>
  </tr>
      
   <tr >
    <td class="LABEL"><font color="red">*</font>Item Type Name</td>
    <td width="50%" class ="CONTROL"><input type="text" name="strItemTypeName" maxlength="50" class='txtFldMax' value ="${ItemTypeBean.strItemTypeName}" onkeypress="return validateData(event,18);" > </td>
   </tr>
   
   <tr >
    <td class="LABEL"><font size="2" color="red">*</font>Short Name</td>
    <td width="50%" class ="CONTROL"><input type="text" name="strShortName" class="txtFldNormal" maxlength="10" value ="${ItemTypeBean.strShortName}"  onkeypress="return validateData(event,9);"> </td>
  </tr>

  <tr >
    <td class ="LABEL" width ="50%"><div align="right"><font color="red">*</font> Effective From</div></td>
    <td class ="CONTROL"><bean:write name="ItemTypeBean" property="strEffectiveFrom"/></td>
  </tr>
  
  
  <tr >
    <td width ="50%" class ="LABEL"valign="top">Remarks if Any </td>
    <td width ="50%" class ="CONTROL"><textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"><bean:write name="ItemTypeBean" property="strRemarks" filter="false"/></textarea></td>
  </tr>
   
    <tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="ItemTypeBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="ItemTypeBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
    </tr>
    
     
    <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>																														
	
	   <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
	<<br>
			<td align="right">
			<!-- <img style="cursor: pointer; " title="Save Record" 
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" /> -->
			<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
			</td>
			<td align="left">
			<!-- <img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png"  title="Cancel Process" onClick="cancel('LIST');" > -->
				
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>

	    <input type="hidden" name="chk" value="${ItemTypeBean.strChk1 }">
	   
	    <input type="hidden" name="comboValue" value="${ItemTypeBean.strItemCategoryName}">
	   	<input type="hidden" name="hmode">
	 	<input type="hidden" name="strEffectiveFrom" value ="${ItemTypeBean.strEffectiveFrom}" />
	 <cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	
			
			