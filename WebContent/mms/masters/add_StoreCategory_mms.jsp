<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Store Category Master Add Page</title>
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

<script language="javaScript">

function validate1(){   
     
     
      var hisValidator = new HISValidator("storeCategoryBean"); 
        hisValidator.addValidation("strStoreCategory", "dontselect=0","Please Select atleast one Category from Combo");
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
        hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
      
        
      var retVal = hisValidator.validate(); 
    	
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


function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftStoreCategorys.value;
	var ob=document.getElementById("LeftStoreCategorys");
	shiftToRight("strLeftStoreCategorys","strRightStoreCategorys",1);
}
</script>

</head>
<body onLoad="">
<html:form name="storeCategoryBean" action="/masters/StoreCategoryMstCNT"
	type="mms.masters.controller.fb.StoreCategoryMstFB">
<center>
	<div class="errMsg"><bean:write name="storeCategoryBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="storeCategoryBean"
		property="strWarning" /></div>
	<div id="normalMsg"  class="normalMsg"><bean:write name="storeCategoryBean"
		property="strMsg" /></div>

	<tag:tab tabLabel="Store Category Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	</center>		
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Store Category Master &gt;&gt; Add</td>
		</tr>


		<tr>
			<td class="LABEL">Store Name </td>
			<td width="50%" class="CONTROL"><bean:write
				name="storeCategoryBean" property="strStoreName" filter="false" />

			</td>

		</tr>

		
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Store Category</td>
			<td width="50%" class="CONTROL"><html:select
				name="storeCategoryBean" property="strStoreItemCategory"
				onchange="SubGroupCombo();">
				<bean:write name="storeCategoryBean" property="strLeftStoreCategoryList"
					filter="false" />
			</html:select></td>
		</tr>
		</table>
		
		
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		
		<tr>
			<td width="50%" class="LABEL">Whether Store is Bounded With
			Items</td>
			<td width="50%" class="CONTROL"><html:checkbox
				property="strItemBounded" value="1" name="storeCategoryBean"></html:checkbox>
			</td>
		</tr>
		<tr style="display: none;">
			<td width="50%" class="LABEL">Whether allow to add new drug from transaction</td>
			<td width="50%" class="CONTROL"><html:checkbox
				property="strIsNewItemFlag" value="1" name="storeCategoryBean"></html:checkbox>
			</td>
		</tr>
		
		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2"></textarea></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font
				color="red">*</font> Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${storeCategoryBean.strCtDate}"></dateTag:date></td>
		</tr>


		

		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();" /> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset()" />
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');" />
			
			</td>
		</tr>
	</table> -->
<br>
<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div> 
					
<input type="hidden" name="hmode"/>
<input type="hidden" name="comboValue"
		value="${storeCategoryBean.strStoreName}">
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>