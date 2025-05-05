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
<title>Group Master Add Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language ="javaScript">



function validate1(){   
     
      var hisValidator = new HISValidator("StoreGrpBean");
           
			
            hisValidator.addValidation("strGroupName", "req", "Group Name is a Mandatory Field" );
           hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" );  
        //   	hisValidator.addValidation("strEffectiveFrom", "dtgtet=${StoreGrpBean.strCtDate}" , "Effective From Date should be Greater than or Equal to Current Date");
			hisValidator.addValidation("strGroupName", "maxlen=100", "Group Name should have less than or equal to 100 Characters" );           	
			hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );



			
                     
            var retVal = hisValidator.validate(); 
     
          if(retVal){
                       //if(document.forms[0].isPackage.checked)
                       //document.forms[0].isPackage.value=1;
                        //if(document.forms[0].isVisible.checked)
                     //  document.forms[0].isVisible.value=1;
      				   document.forms[0].hmode.value = "SAVE";
         
                        document.forms[0].submit();
            }else{

           return false;

          }
    }

</script>
<style type="text/css">

</style>
</head>
<body onLoad="document.forms[0].strGroupName.focus()">
<html:form name="StoreGrpBean" action="/masters/StoreGroupMstCNT" type="mms.masters.controller.fb.StoreGroupMstFB">
<center>
	<div class="errMsg"><bean:write name="StoreGrpBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="StoreGrpBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="StoreGrpBean" property="strMsg"/></div>

  <tag:tab tabLabel="Group Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
   <tr class ="HEADER">
  <td colspan ="2" >Group Master  &gt;&gt; Add</td>
  </tr> 
  
 
   <tr >
    <td class="LABEL">Drug Category</td>
    <td width="50%" class ="CONTROL"> <bean:write name="StoreGrpBean" property="strItemCatName" filter="false"/> 
      </td>
     
  </tr>
                
   <tr >
    <td class="LABEL"><span class="style1"><font color="red">*</font></span>Group Name</td>
    <td width="50%" class ="CONTROL"><input type="text" name="strGroupName"  class="txtFldMax" onkeypress="return validateData(event,18);"> </td>
  </tr>
  
  <tr >
    <td class ="LABEL" width ="50%"><div align="right"><font color="red">*</font> Effective From</div></td>
    <td class ="CONTROL"><dateTag:date name="strEffectiveFrom" value ="${StoreGrpBean.strCtDate}"></dateTag:date></td>
  </tr>
  
 
  <tr >
    <td width ="50%" class ="LABEL"valign="top">Remarks if Any </td>
    <td width ="50%" class ="CONTROL"><textarea  name="strRemarks" cols="25" rows="2" ></textarea></td>
  </tr>
   
   <tr class ="FOOTER" >
  <td colspan ="2" ><font color="red">*</font> Mandatory Field</td>
  </tr>
</table>
	 <div align="center">
	    <table CLASS ="TABLEWIDTH" cellpadding="1px" cellspacing="1px">
	      <tr> 
	     <td align="center">
			<!--<img
				src="../../hisglobal/images/btn-sv.png" style="cursor:pointer;cursor:pointer;" title="Save Record" onClick=" return validate1();" />
			 <img src="../../hisglobal/images/btn-clr.png" style="cursor:pointer;cursor:pointer;" title="Reset Content"
				onClick="document.forms[0].reset(),document.forms[0].strGroupName.focus();" />
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor:pointer;cursor:pointer;" title="Cancel Process"
				onClick="cancel('LIST');" />-->
				<br>					 
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="document.forms[0].reset(),document.forms[0].strGroupName.focus();"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</td>
	      </tr>
	    </table>
	    
	   	<input type="hidden" name="hmode">
	   	<input type="hidden" name="strEntryDate" value="${StoreGrpBean.strCtDate}">
	  	<input type="hidden" name="comboValue" value="${StoreGrpBean.strItemCatName}">
	 	
       </div>
       <cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	
			
			