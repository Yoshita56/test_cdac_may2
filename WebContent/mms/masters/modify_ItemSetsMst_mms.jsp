<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset="utf-8">
<title>Item Sets Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Item Sets Master</title>
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

function validate11(){   

     
             var hisValidator = new HISValidator("ItemSetsMstBean");
              hisValidator.addValidation("strItemQuantity", "req", "Item Quantity is Mandatory Field" );
            hisValidator.addValidation("strUnitId", "dontselect=0", "Please select a value from Unit" );
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		   // hisValidator.addValidation("strEffectiveFrom", "dtgtet=${ItemSetsMstBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
            var retVal = hisValidator.validate();  

          if(retVal){
                       document.forms[0].hmode.value = "UPDATE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}

</script>
</head>
<body>
<html:form name="ItemSetsMstBean" action="/masters/ItemSetsMstCNT" type="mms.masters.controller.fb.ItemSetsMstFB">
 	
 	<div id="errMsg" class="errMsg"><bean:write name="ItemSetsMstBean" property="strErrorMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="ItemSetsMstBean" property="strMsg"/></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="ItemSetsMstBean" property="strWarning"/></div>
	

	<table class="TABLEWIDTH" align="center" cellpadding="0"
         cellspacing="0">
         <tr>
               <td width="100%"><tag:tab tabLabel="Item Sets Master" selectedTab="FIRST" align="center" width="100%">
               </tag:tab></td>
         </tr>
    </table>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="8">Item Sets Master&gt;&gt; Modify</td>
		</tr>
		
		<tr>
			<td colspan="4" width="50%" class="LABEL">Set Category Name</td>
			<td colspan="4" width="50%" class="CONTROL">
			<bean:write name="ItemSetsMstBean" property="strSetCategoryName" filter="false"/>
		</tr>
		
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			Set Name
			</td>
			<td colspan="4" width="50%" class="CONTROL">
  			<bean:write name="ItemSetsMstBean" property="strSetName" filter="false"/>
   			</td>
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">Item Category Name</td>
			<td colspan="4" width="50%" class="CONTROL">
			<bean:write name="ItemSetsMstBean" property="strItemCatName" filter="false"/>
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			Generic Item Name
			</td>
			<td colspan="4" width="50%" class="CONTROL">
  			<bean:write name="ItemSetsMstBean" property="strGenItemName" filter="false"/>
   			</td>
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			Item Name
			</td>
			<td colspan="4" width="50%" class="CONTROL">
  			<bean:write name="ItemSetsMstBean" property="strItemName" filter="false"/>
   			</td>
		</tr>
		
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
			<tr>
					<td colspan="4" class="LABEL"><font color="red">*</font>Item Quantity</td>
					<td colspan="4" width="50%" class="CONTROL"><input type="text" 
						name="strItemQuantity" class="txtFldNormal" value="${ItemSetsMstBean.strItemQuantity}" maxlength="2"
						onkeypress="return validateData(event,5);"></td>
			   </tr>
				<tr>
					<td colspan="4" class="LABEL" width="50%">
					<font color="red">*</font>Unit Name</td>
					<td colspan="4" class="CONTROL" width="50%">
					<select name="strUnitId" class='comboNormal'>
						<bean:write name="ItemSetsMstBean" property="strUnitCombo" filter="false"/>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" width="50%" class="LABEL">
					<font color="red">*</font>Effective From</td>
					<td colspan="4" class ="CONTROL"><bean:write name="ItemSetsMstBean" property="strEffectiveFrom"/>
				</tr> 
				<tr>
					<td colspan="4" width="50%" class="LABEL">Remarks</td>
					<td colspan="4" width="50%" class="CONTROL">
			  		<div align="left">
        				<textarea name="strRemarks" rows="2"><bean:write name="ItemSetsMstBean" property="strRemarks"/></textarea>
    	 			</div></td>
			  </tr>
			  <tr >
           <td colspan="4" width ="45%" class ="LABEL">Record Status</td>
           <td colspan="4" width ="45%" class ="CONTROL" >
           <html:radio name="ItemSetsMstBean" property="strIsValid" value="1">Active</html:radio>
           <html:radio name="ItemSetsMstBean" property="strIsValid" value="2">Inactive</html:radio></td>
    	</tr>
		
		  
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">  
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate11();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>
	<input type="hidden" name="strSetCatNo" value="${ItemSetsMstBean.combo[0] }"/>
		<input type="hidden" name="strSetId" value="${ItemSetsMstBean.combo[1] }"/>
	<input type="hidden" name="strItemCategoryNo" value="${ItemSetsMstBean.strItemCategoryNo }"/>
	<input type="hidden" name="strItemBrandId" value="${ItemSetsMstBean.strItemBrandId }"/>
	<input type="hidden" name="chk" value="${ItemSetsMstBean.strChk }"/>
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strEffectiveFrom" value="${ItemSetsMstBean.strCtDate}">
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>