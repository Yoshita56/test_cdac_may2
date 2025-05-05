<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Desk Access Details</title>
<link href="css/transaction.css" rel="stylesheet" type="text/css">
<link href="../css/tab.css" rel="stylesheet" type="text/css">
<link href="../css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../css/popup.css" rel="stylesheet" type="text/css">	
	

<script language="JavaScript" src="../js/tab.js"></script>
<script language="JavaScript" src="../js/calendar.js"></script>
<script language="Javascript" src="../js/validation.js"></script>
<script language="Javascript" src="../js/util.js"></script>
<script language ="javaScript">

function validate1(){   
     
            var hisValidator = new HISValidator("DeskAccessBean");
            hisValidator.addValidation("strUserId", "dontselect=0", "Please select a User Name" );
            hisValidator.addValidation("strDeskId", "dontselect=0", "Please select a Desk Name" );
           hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		   //  hisValidator.addValidation("strEffectiveFrom", "dtgtet=${ProcessLetterTypeMstBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
            var retVal = hisValidator.validate(); 

          if(retVal){
          
                  var count=selectListRecords("strRightMenuNames");
                        if(count==0)
        		 {alert("Please select a menu name ");
        		 return false;
        		 }
                       document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}

function ajaxFunLeftList()
{ 
// alert("ajaxFunLeftList userid="+document.forms[0].strUserId.value);
// alert("ajaxFunLeftList userid="+document.forms[0].strDeskId.value);  
   var mode ="LEFTMENUNAMES";
   var url="DeskAccessDetailsCNT.cnt?hmode=LEFTMENUNAMES&userId="+document.forms[0].strUserId.value+"&deskId="+document.forms[0].strDeskId.value;
   ajaxFunction(url,"1");
}
function ajaxFunRightList()
{ 
  var mode ="RIGHTMENUNAMES";
  var url="DeskAccessDetailsCNT.cnt?hmode=RIGHTMENUNAMES&userId="+document.forms[0].strUserId.value+"&deskId="+document.forms[0].strDeskId.value; 
  ajaxFunction(url,"2");
}

function getAjaxResponse(res,mode){
			
				 if(mode=="1")
				 {
				   	var obj1 = document.getElementById("LeftMenuId");
			        obj1.innerHTML = "<select name='strLeftMenuNames' size='8' multiple style='width: 280px'>" + res + "</select>";
			 	    ajaxFunRightList();
			 	    
				}
				else if(mode=="2"){
				
					var obj2= document.getElementById("RightMenuId");
					obj2.innerHTML = "<select name='strRightMenuNames' size='8' multiple style='width: 280px'> " + res + " </select>";
					}
}

function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftMenuNames.value;
	var ob=document.getElementById("LeftMenuId");
	shiftToRight("strLeftMenuNames","strRightMenuNames",1);
}

function clearList(list_name)

{
listobj = document.getElementsByName(list_name);
    if(listobj.length > 0){
           listobj[0].length = 0;
		 }
}
</script>

</head>
<body >
<html:form name="DeskAccessBean" action="/DeskAccessDetailsCNT"
	type="hisglobal.transactionutil.controller.fb.DeskAccessDetailsFB">

	<div class="errMsg"><bean:write name="DeskAccessBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="DeskAccessBean"
		property="strWarning" /></div>
	<div id="normalMsg"  class="normalMsg"><bean:write name="DeskAccessBean"
		property="strMsg" /></div>
	<table class="TABLEWIDTH" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="100%"><tag:tab tabLabel="Desk Access Details"
				selectedTab="FIRST" align="center" width="100%">
			</tag:tab></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Desk Access Details &gt;&gt; </td>
		</tr>
	

		<tr >
      <td class="LABEL"><font color="red">*</font>User Name</td>
      <td width="50%" class ="CONTROL"> <html:select name="DeskAccessBean" property="strUserId" >
       <bean:write name="DeskAccessBean" property="strUserNameCombo" filter="false"/>
       </html:select>
      </td>
    </tr> 

		<tr >
      <td class="LABEL"><font color="red">*</font>Desk Name</td>
      <td width="50%" class ="CONTROL"> <html:select name="DeskAccessBean" property="strDeskId" onchange="ajaxFunLeftList();">
       <bean:write name="DeskAccessBean" property="strDeskNameCombo" filter="false"/>
       </html:select>
      </td>
    </tr> 
    </table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr>
  			 <td class="CONTROL" colspan="3">
  			 
			<div id="LeftMenuId" align="right">
			<select name="strLeftMenuNames" size="8" 
				multiple style="width: 280px"><bean:write name="DeskAccessBean" property="strLeftMenuList" filter="false"/></select></div>
				
			</td>
			<td width="6%" class="CONTROL" colspan="2">
			
			<center>
			<img src="../images/forward3.gif" width="35"
				height="31" 
				onclick ="LeftListTransfer();"></center>
				
				<center><img src="../images/forwardward.gif" width="35" height="31" 
				align="middle" onClick="shiftAllToRight('strLeftMenuNames','strRightMenuNames',1);"/></center>
				<br/>
				<center>
				
				<img src="../images/backward.gif" width="35"
				height="31" 
				onClick='shiftAllToLeft("strLeftMenuNames","strRightMenuNames",1);'>
				</center>
				
				<center><img src="../images/back3.gif" width="35" 
				height="31" 
				onclick="shiftToLeft('strLeftMenuNames','strRightMenuNames',1);"/></center>
			</td>
			
			<td colspan="3" class="CONTROL" >
			<div id="RightMenuId" align="left"><select name="strRightMenuNames" size="8" 
			multiple style="width: 280px"><bean:write name="DeskAccessBean" property="strRightMenuList" filter="false"/>
			</select></div>
			</td>		
			</tr> 
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
    <tr>
			<td class="LABEL"><font color="red">*</font>Menu Position
			</td>
			<td width="50%" class="CONTROL"><select
				name="strMenuPosition">
				<option value="1">Left</option>
				<option value="2">Right</option>
				<option value="3">Bottom</option>
			</select></td>
		</tr>
		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font
				color="red">*</font> Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${DeskAccessBean.strCtDate}"></dateTag:date></td>
		</tr>
		
		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; cursor: hand"
src="../images/btn-sv.png"
onClick=" return validate1();" /> <img
style="cursor: pointer; cursor: hand"
src="../images/btn-clr.png"
onClick="document.forms[0].reset(),document.forms[0].strUserId.focus();" />
<img style="cursor: pointer; cursor: hand"
src="../images/btn-ccl.png" onClick="" />
			
			</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
</html:form>
</body>
</html>