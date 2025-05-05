<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta charset=utf-8>
<title>Committee Member Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/CommiteeMember.js"></script>



</head>

<body  onload="RadioButton()";>

<html:form action="/masters/CommitteeMemberDetailMstCNT.cnt"  name="committeeMemberDtlBean" type="mms.masters.controller.fb.CommitteeMemberDetailMstFB" method="post">

    <div class="errMsg" id="errMsg" ><bean:write name="committeeMemberDtlBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="committeeMemberDtlBean" property="strWarning"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="committeeMemberDtlBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Committee Member Detail" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   <tr class="HEADER">
			<td colspan="4">Committee &gt;&gt;Detail</td>
		</tr>
		 <tr >
      <td class="LABEL" width="25%">Item Category</td>
     	<td width="25%" class="CONTROL">
				
				<select name="strCatNo" id="strCatNo" class="comboNormal" onchange="resetCommittePurpose();">
				<bean:write name="committeeMemberDtlBean" property="strCatValues" filter="false"/>
				</select>
			</td> 
			<td width="25%" class="LABEL">
			<font color="red">*</font>Committee Type
			</td>
			<td width="25%"  class="CONTROL">
			 <div id="CommitteTypeDiv" >
			     <select name="strCommitteType"  id="strCommitteType" class='comboNormal' onChange="getCommittePurpose();">
			         <bean:write name="committeeMemberDtlBean" property="strCommitteTypeVals" filter="false"/>
                  </select>
                </div>
                <input type="hidden" name="strCommitteeTypeIDDummy" id="strCommitteeTypeIDDummy" value=""/>
                
			</td>
	  </tr>   
	 </table>	
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
	
        <tr> 
         <td width="25%" class="LABEL">Purpose:</td>
         <td width="25%" class="CONTROL">
                 <div id="Purpose">----</div>
         </td>   
         <td width="25%" class="LABEL"></td>
         <td width="25%" class="CONTROL">
                
         </td>   
        </tr>
            
        
      </table>
   <table class="TABLEWIDTH" align="center" cellspacing ="1px">
   <tr class="HEADER">
			<td colspan="2">Member Detail</td>
		</tr>
   </table>
   
       <div id = "detailsdivid" style="display:block;"></div>
     
   <table class="TABLEWIDTH" align="center" cellspacing ="1px">
   
	
	<tr class="HEADER">

			<td>New Member Detail</td>
			<td align="right">Whether Employee is Chair Person<span>
			<html:checkbox name="committeeMemberDtlBean" property="strIsChairPerson"  onclick="showEmpUserIdCmb();" title="Click Here To Add Chair Person"></html:checkbox></span></td>
		</tr>
	<tr>	
    <td class="LABEL" colspan="2">
    
      <html:radio  property="strCase" name="committeeMemberDtlBean" value="1" onclick="getCombo(this);" >Employee</html:radio>
      <html:radio  property="strCase" name="committeeMemberDtlBean" value="2" onclick="getCombo(this);" >Non-Employee</html:radio>
    
    </td>    
    </tr>
    
    
           <tr>
			<td width="50%" class="LABEL">
			    <div id='Member' style='display:none'><font color="red">*</font>Member Name:</div>
			    <div id='Emp'    style='display:block'><font color="red">*</font>Emp Name:</div>
			</td>
			<td width="50%" class="CONTROL">
			 <div id='Member1' style='display:none'>
		               <input class="txtFldMax" type="text" name="strMemberName" value="" maxlength="33" onkeypress="return validateData(event,11);">
             </div>
		     <div id='Emp1' style='display:block'>
		                 <select name="strEmpNumberCombo"   onChange="getEmpUserIdCmb(this);" class='comboMax'>
                               <bean:write name="committeeMemberDtlBean" property="strEmpNumber" filter="false"/>
                         </select>
		     </div>		
		    </td>
		    
		</tr>
		</table>
		<div id="chairPerson" style="display:none">
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		
			<tr>
				<td width="50%" class="LABEL"><font color="red">*</font>Emp User Name:</td>
				<td width="50%" class="CONTROL">
				 		<div id="empUserIdCmb">     
			                 <select name="strEmpUserId"   onChange=""><option value="0">Select Value</option></select>
			            </div>
			    </td>
			    
			</tr>
		
		</table>
		</div>
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		  <tr>
			<td width="50%" class="LABEL">
			    Phone NO:
			   
			</td>
			<td width="50%" class="CONTROL">
			 
		               <input class="txtFldMax" type="text" name="strMemberPhoneNo" value="" maxlength="13" onkeypress="return validateData(event,2);">
             	
		    </td>
		    
		</tr>
		
		<tr>
			<td width="50%" class="LABEL">
			    E-Mail:
			   
			</td>
			<td width="50%" class="CONTROL">
			 
		               <input class="txtFldMax" type="text" name="strMemberEMail" value="" maxlength="40" onkeypress="return validateData(event,1);">
             	
		    </td>
		    
		</tr>
		
		<tr>
			<!--<td  class="multiLabel" colspan="2" align="center">
	                <img style="cursor: pointer; " src="../../hisglobal/images/btn-add.png" title='Add Committe Member Details' onClick="saveMemberDtl();" />-->
	               
              <td align="right"> 
               <a href="#" class="button" id=" " onclick='saveMemberDtl();'><span class="add">Add</span></a>    
			</td>
		</tr>
		
     </table>	
   
   
	<table class="TABLEWIDTH" align="center">
        <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields ----- [CP]  Chair Person  </td>
		</tr>
	</table>
	
	<!--<div id = 'AddButton' style='display:block;'>
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validateInsert();" />
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" />
			</td>
		</tr>
	</table>
		
    </div>-->
<br>
<div align="center" id = 'AddButton'>					 
					 	<a href="#" class="button" id="submitId" onclick=' return validateInsert();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div> 
   	   
    <input type="hidden" name="hmode"/>
        
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>