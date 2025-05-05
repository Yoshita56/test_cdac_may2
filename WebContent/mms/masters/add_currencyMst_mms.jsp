<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=utf-8>
<title>Currency Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language ="javaScript">

function validate1(){   
     
            var hisValidator = new HISValidator("currencyMstBean");
            hisValidator.addValidation("strCurrencyName", "req", "Currency Name is a Mandatory Field" );
            hisValidator.addValidation("strCurrencyName", "maxlen=50", "Currency Name should have less than or equal to 50 Characters" );
            hisValidator.addValidation("strCurrencyShortName", "req", "Currency Short Name is a Mandatory Field" );
            hisValidator.addValidation("strCurrencyShortName", "maxlen=10", "Currency Short Name should have less than or equal to 250 Characters" );
            hisValidator.addValidation("strCurrencyValue", "req", "Currency Value is a Mandatory Field" );
            hisValidator.addValidation("strCurrencyValue", "amount=7,3", "Currency Value should have less than or equal to 7 digits" );
       		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		    //hisValidator.addValidation("strEffectiveFrom", "dtgtet=${currencyMstBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
            var retVal = hisValidator.validate(); 

          if(retVal){
                 	   document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}

function chkDefault()
{ 
	 url="CurrencyMstCNT.cnt?hmode=CHECKDEFAULT";     
	 ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
   
       if(temp[0] == "ERROR")
	   {
          	err.innerHTML = temp[1];
          	return;
       } 
      if(mode=="1")
     {
     	temp=res.split("^");
       	if(temp[0]=="1"){
     		alert("You have already checked default currency for "+temp[1]);
     		document.getElementsByName("strDefault")[0].checked=false;
     	}
     
        
     }
    
}
     


</script>
</head>
<body onLoad="document.forms[0].strCurrencyName.focus()">
<html:form name="currencyMstBean" action="/masters/CurrencyMstCNT" type="mms.masters.controller.fb.CurrencyMstFB">
 	
 	<div id="errMsg" class="errMsg"><bean:write name="currencyMstBean" property="strErrorMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="currencyMstBean" property="strMsg"/></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="currencyMstBean" property="strWarning"/></div>
	

	<tag:tab tabLabel="Currency Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Currency Master&gt;&gt; Add</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			Whether Default Currency
			</td>
			<td width="50%" class="CONTROL">
				<html:checkbox property="strDefault" name="currencyMstBean" value="1" onclick="chkDefault();"></html:checkbox>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Currency Name
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class='txtFldBig' name="strCurrencyName" value ="" maxlength="50" onkeypress="return validateData(event,4);">
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Currency Short Name
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class='txtFldBig' name="strCurrencyShortName" value ="" maxlength="10" onkeypress="return validateData(event,4);">
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Currency Value
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class='txtFldBig' name="strCurrencyValue" value ="" maxlength="7" onkeypress="return validateData(event,7);">
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Effective From
			</td>
			<td class ="CONTROL"><date:date name="strEffectiveFrom" value="${currencyMstBean.strCtDate}"></date:date></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			Remarks
			</td>
			<td width="50%" class="CONTROL">
			  <div align="left">
        		<textarea name="strRemarks" rows="2"></textarea>
              </div>
			</td>
		</tr>
		
		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>
	<input type="hidden" name="strCtDate" value="${currencyMstBean.strCtDate}"/>
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>