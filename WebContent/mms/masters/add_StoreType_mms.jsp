<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
		
<html>
<head>
<meta charset=utf-8>
<title>Store Type Master Add Page</title>
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">

function validate1(){   
     
             var hisValidator = new HISValidator("storetypeBean");
           
           hisValidator.addValidation("strStoreTypeName", "req", "Store Type Name is a Mandatory Field" );  
            hisValidator.addValidation("strStoreTypeName", "maxlen=100" , "Store Type Name should have less than or equal to 100 Characters" );
       		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            //hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		  //hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" );  
            var retVal = hisValidator.validate(); 

          if(retVal){
                 	   document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}

</script>
</head>

<body onLoad="document.forms[0].strStoreTypeName.focus()">
<html:form name="storetypeBean" action="/masters/StoreTypeMstCNT" type="mms.masters.controller.fb.StoreTypeMstFB">
 	<center>
 	<div class="errMsg"><bean:write name="storetypeBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="storetypeBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="storetypeBean" property="strMsg"/></div>
<tag:tab tabLabel="Store Type Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class="HEADER"> 
    <td colspan="2">Store Type Master&gt;&gt;Add</td>
  </tr> 
 
  <tr >
    <td class="LABEL"><font color="red">*</font>Store Type Name</td>
    <td width="50%" class ="CONTROL"><input type="text" class='txtFldMax' name="strStoreTypeName" value ="" maxlength="100" onkeypress="return validateData(event,18);"> </td>
  </tr>
  
      
    <!--  <tr >
    <td class ="LABEL" width ="50%"><font color="red">*</font>Effective From</td>
    <td class ="CONTROL"><dateTag:date name="strEffectiveFrom" value ="${storetypeBean.strCtDate}"></dateTag:date></td>
    </tr>-->
    
    <tr>
      <td class="LABEL"><div align="right">Remarks</div></td>
      <td class="CONTROL">
	  <div align="left">
        <textarea name="strRemarks" rows="2"></textarea>
      </div></td>
      </tr>
    
    
   
   <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>
	 
	    <table CLASS ="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	      <tr> 
		<td align="center">
		<!-- 	<img
				src="../../hisglobal/images/btn-sv.png" style="cursor:pointer;cursor:pointer;" title="Save Record" onClick=" return validate1();" />
			<img src="../../hisglobal/images/btn-clr.png" style="cursor:pointer;cursor:pointer;" title="Reset Content"
				onClick="document.forms[0].reset(),document.forms[0].strStoreTypeName.focus();" />
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor:pointer;cursor:pointer;" title="Cancel Process"
				onClick="cancel('LIST');" /> -->
				<br>
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="document.forms[0].reset(),document.forms[0].strStoreTypeName.focus();"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</td>
	      </tr>
	    </table>
	    <input type="hidden" name="hmode" />
	    


<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	