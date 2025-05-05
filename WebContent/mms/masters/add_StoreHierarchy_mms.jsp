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
<title>Store Hierarchy Master Add Page</title>
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
     
     selectListRecords("strRightStoreNames"); 
      var hisValidator = new HISValidator("StoreHierarchyBean"); 
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
        //hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
       //  hisValidator.addValidation("strRightStoreNames", "dontselect=0","Please move atleast one store from left to right \n And select only those stores which are to be added from right list");
        
      var retVal = hisValidator.validate(); 
    	
          if(retVal){
        		 var count = selectListRecords("strRightStoreNames");
        		 if(count==0)
        		 {alert("Please select a store which is not already added");
        		 return false;
        		 }
       			   document.forms[0].hmode.value = "SAVE";
                        document.forms[0].submit();
            }else{
	           return false;
			   }
    }


function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftStoreNames.value;
	var ob=document.getElementById("LeftStores");
	shiftToRight("strLeftStoreNames","strRightStoreNames",1);
}

function searchInList()
{ 
   searchInListBox("strLeftStoreNames",document.forms[0].searchVal.value);  
}


function changeViewMode(chkObj)
{ 	
    if(chkObj.value =='1')
 	{ 	
 		 document.forms[0].strCheck.value = '1'; 
         document.forms[0].strAll.checked = true;
 		 document.forms[0].strAssociated.checked = false;
 		 getAssociatedStore("1");
 	}
 	if(chkObj.value =='2')
 	{ 		 
 		 
 		 document.forms[0].strCheck.value = '2'; 
         document.forms[0].strAll.checked = false;
 		 document.forms[0].strAssociated.checked = true;
 		 getAssociatedStore("2");
 		 
 	}
}
function setValue()
{
         document.forms[0].strCheck.value = '1'; 
         document.forms[0].strAll.checked = true;
 		 document.forms[0].strAssociated.checked = false;
} 


function getAssociatedStore(flg)
{	
	 var url;
	 
	 var mode = 'ASSOCIATEDSTORE';   
	 url="StoreHierarchyMstCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strFromStoreId.value+"&ItemCatId="+document.forms[0].strItemCatgory.value+"&RequestTypeId="+document.forms[0].strRequestTypeId.value+"&Flag="+flg;       
	 //alert(url);
	 ajaxFunction(url,"1");
}
function getAjaxResponse(res,mode)
{
		
	   if(mode=="1")
	   {   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR")
        		 {
         			err.innerHTML = temp1[1];	
        		 }
				 else
				 {
				    var ox = res.split("^^^^");
				    objVal= document.getElementById("LeftStores");
				    objVal.innerHTML = "<select name='strLeftStoreNames' size='8' multiple style='width: 280px'>"+ox[0]+"</select>";
				    
				    objVal= document.getElementById("RightStores");
				    objVal.innerHTML = "<select name='strRightStoreNames' size='8' multiple style='width: 280px'>"+ox[1]+"</select>";
				 }
		 }
		  
}


</script>

</head>
<body onLoad="setValue();">
<html:form name="StoreHierarchyBean" action="/masters/StoreHierarchyMstCNT"
	type="mms.masters.controller.fb.StoreHierarchyMstFB">
<center>
	<div class="errMsg"><bean:write name="StoreHierarchyBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="StoreHierarchyBean"
		property="strWarning" /></div>
	<div id="normalMsg"  class="normalMsg"><bean:write name="StoreHierarchyBean"
		property="strMsg" /></div>

	<tag:tab tabLabel="Store Hierarchy Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	</center>		
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Store Hierarchy Master &gt;&gt; Add</td>
		</tr>


		<tr>
			<td class="LABEL">From Store</td>
			<td width="50%" class="CONTROL"><bean:write
				name="StoreHierarchyBean" property="strFromStoreName" filter="false" />

			</td>

		</tr>
		<tr>
			<td class="LABEL">Item Category </td>
			<td width="50%" class="CONTROL"><bean:write
				name="StoreHierarchyBean" property="strItemCatId" filter="false" />

			</td>

		</tr>
		
		<tr>
			<td class="LABEL">Request Type </td>
			<td width="50%" class="CONTROL"><bean:write
				name="StoreHierarchyBean" property="strRequestType" filter="false" />

			</td>

		</tr>
		
		<tr>
			<td class="LABEL">Hospital</td>
		    <td class="CONTROL">
		            <input type="radio"	name="strAll"    value="1" 	onClick="changeViewMode(this);"/>All
		            <input type="radio"	name="strAssociated" value="2"	onClick="changeViewMode(this);" />Associated
            </td>
         </tr>  
		<tr>
		<td colspan="2"  class="LABEL"><center><font color="red">*</font>To Store</center></td>
		</tr>
		</table>
		<!--<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			<td colspan="3"  class="CONTROL" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="txtFldMax" name="searchVal" class="txtFldNormal"/> 
			<img style="cursor: pointer;" src="../../hisglobal/images/btn-search.png" onclick='searchInList();' title="Search Member Name"> 
			</td>
			
		    </tr> 
	   </table>  -->
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr>
  			 <td class="CONTROL" colspan="3">
  			 
			<div id="LeftStores" align="right">
			    <select name="strLeftStoreNames" size="8" 
				multiple style="width: 280px">
				<bean:write name="StoreHierarchyBean" property="strLeftStoreNamesList" filter="false"/>
				</select>
			</div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">
			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="35"
				height="31" 
				onclick ="LeftListTransfer();"></center>
				
				<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" 
				align="middle" onClick="shiftAllToRight('strLeftStoreNames','strRightStoreNames',1);"/></center>
				<br/>
				<center>
				
				<img src="../../hisglobal/images/backward.gif" width="35"
				height="31" 
				onClick='shiftAllToLeft("strLeftStoreNames","strRightStoreNames",1);'>
				</center>
				
				<center><img src="../../hisglobal/images/back3.gif" width="35" 
				height="31" 
				onclick="shiftToLeft('strLeftStoreNames','strRightStoreNames',1);"/></center>
			</td>
			
			<td colspan="3" class="CONTROL" >
			<div id="RightStores" align="left"><select name="strRightStoreNames" size="8" 
			multiple style="width: 280px"><bean:write name="StoreHierarchyBean" property="strRightStoreNamesList" filter="false"/>
			</select></div>
			</td>		
			</tr> 
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font
				color="red">*</font> Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${StoreHierarchyBean.strCtDate}"></dateTag:date></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks if Any</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2"></textarea></td>
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
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="comboValue" value="${StoreHierarchyBean.strComboValue}">
<input type="hidden" name="strCheck" value="">
<input type="hidden" name="strFromStoreId" value="${StoreHierarchyBean.strFromStoreId}">
<input type="hidden" name="strRequestTypeId" value="${StoreHierarchyBean.strRequestTypeId}">
<input type="hidden" name="strItemCatId" value="${StoreHierarchyBean.strItemCatId}">
<input type="hidden" name="strItemCatgory" value="${StoreHierarchyBean.strItemCatgory}">

<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>