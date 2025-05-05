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
<title>Group Master Modify Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language ="javaScript">

function validate1(){   
     
       var hisValidator = new HISValidator("StoreGrpBean");

			hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" );  
          hisValidator.addValidation("strGroupName", "req", "Group Name is a Mandatory Field" );
          hisValidator.addValidation("strEffectiveFrom", "req", "EffectiveFrom is a Mandatory Field" );
      //    hisValidator.addValidation("strEffectiveFrom", "dtgtet=${StoreGrpBean.strCtDate}" , "Effective From Date should be Greater than or Equal to Current Date");
      hisValidator.addValidation("strGroupName", "maxlen=100", "Group Name should have less than or equal to 100 Characters" );  
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
<body onLoad="document.forms[0].strGroupName.focus()">
<html:form name="StoreGrpBean" action="/masters/StoreGroupMstCNT" type="mms.masters.controller.fb.StoreGroupMstFB">
  <center>
 	<div class="errMsg"><bean:write name="StoreGrpBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="StoreGrpBean" property="strWarning"/></div>
	<div class="normalMsg"><bean:write name="StoreGrpBean" property="strMsg"/></div>
 
 <tag:tab tabLabel="Group Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class="HEADER"> 
    <td colspan="2">Group Master&gt;&gt;Modify</td>
  </tr>          
  
 
  <tr >
    <td class="LABEL"><span class="style1"></span>Drug Category</td>
    <td width="50%" class ="CONTROL">  <bean:write name="StoreGrpBean" property="strItemCatName" /></td>
  </tr>
      
   <tr >
    <td class="LABEL"><font color="red">*</font>Group Name</td>
    <td width="50%" class ="CONTROL"><input type="text" name="strGroupName" class="txtFldNormal" value ="${StoreGrpBean.strGroupName}" onkeypress="return validateData(event,18);" style="width: 178px; height: 21px"> </td>
   </tr>

  <tr >
    <td class ="LABEL" width ="50%"><div align="right"><span class="style1"></span><font color="red">*</font> Effective From</div></td>
    <td class ="CONTROL"><bean:write name="StoreGrpBean" property="strEffectiveFrom"/></td>
  </tr>
  
  
  <tr >
    <td width ="50%" class ="LABEL"valign="top">Remarks if Any </td>
    <td width ="50%" class ="CONTROL"><textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"><bean:write name="StoreGrpBean" property="strRemarks" filter="false"/></textarea></td>
  </tr>
   
    <tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="StoreGrpBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="StoreGrpBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
    </tr>
    
    
    <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>																														
	
	    <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
				<br>
			<td align="right">
			<!-- <img 
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" /> -->
			<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
			</td>
			<td align="left">
			<!-- <img src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" > -->
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>

	    <input type="hidden" name="chk" value="${StoreGrpBean.strChk1 }">
	    <input type="hidden" name="storeTypeId" value="${StoreGrpBean.strItemCatId }">
	    <input type="hidden" name="strItemCatId" value="${StoreGrpBean.strItemCatId }">
	    <input type="hidden" name="comboValue" value="${StoreGrpBean.strItemCatName}">
	   	<input type="hidden" name="hmode">
	   	<input type="hidden" name="strEffectiveFrom" value ="${StoreGrpBean.strEffectiveFrom}">
	 
	 <cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	
			
			