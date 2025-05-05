<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<head>
<meta charset=UTF-8">
<title>Condemnation Register View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script type="text/javascript">
function cancelToDesk()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].submit();
}
function openSpecification(obj,index)
{
	   
       
        
        var strItemDetail = document.getElementById("strItemDtl"+index).value;     
      
       
        myArray = strItemDetail.split("@");
        
        document.getElementById("popUpItemId").innerHTML=myArray[5]+"->Item/Drug Details";
        //alert("myArray--size"+myArray.length);
       
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        } 
        /**
        **/
          objVal2 = document.getElementById("3");
         if(myArray[2]!='null' || myArray[2]!='')
        {
          objVal2.innerHTML = myArray[2]+"/"+myArray[3];
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
              
         objVal2 = document.getElementById("4");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[4]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }   
        display_popup_menu(obj,'itemDtlId','300','');
        	
	
}
function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}
</script>
</head>
<body onload="">
<html:form name="condemnRegisterViewBean" action="/transactions/CondemnationRegisterViewTransCNT"
	type="mms.transactions.controller.fb.CondemnationRegisterViewTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="condemnRegisterViewBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="condemnRegisterViewBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="condemnRegisterViewBean" property="strNormalMsg"/></div>
	
</center>
	
        <tag:tab tabLabel="Condemn Register"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>

		<div class='popup' id='itemDtlId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpItemId"></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('itemDtlId');" title="Click Here To Close Popup"></th>
		    </tr>
		 </table>  
	  
	  
		 <table width='400' border="0" bgcolor='#CC9966'  cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Last P.O. No.</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
				
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Last P.O. Date </td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>	
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Last Rate/Unit</td>
				
				<td colspan="1" class='multiControl'><div id ='3'></div></td>
				
			</tr>
			<tr>
			<td colspan="1" class='multiLabel'>Supplied by</td>
				<td colspan="1" class='multiControl'><div id ='4'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	</div>
		
			

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4">Condemn Register View&gt;&gt;</td>
	</tr>
	
	<tr>
    <td class="LABEL" width="25%" >Store Name</td>
    <td width="25%" class ="CONTROL" >
    <bean:write name="condemnRegisterViewBean" property="strStoreName" filter="false" />
     </td>
     <td class="LABEL" width="25%" >Item Category Name</td>
    <td width="25%" class ="CONTROL" >
    <bean:write name="condemnRegisterViewBean" property="strItemCategoryName" filter="false" />
     </td>
  </tr>	
    </table>
    <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusItemDetailId" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusItemDetailId','minusItemDetailId','condemnRequestId');" style="cursor: pointer;color:blue; "/>
						Item/Drug Details
						
					</div>
					<div id="minusItemDetailId" style="display:block;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusItemDetailId','minusItemDetailId','condemnRequestId');" style="cursor: pointer;color:blue; "/>
								Item/Drug Details
					</div>
				</td>
		</tr>
	</table>
	<div id="condemnRequestId" style="display: block">
<bean:write name="condemnRegisterViewBean" property="strItemDtl" filter="false" /> 
</div>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
    <tr>
    	<td class="TITLE" colspan="4">Condemnation Details</td>
    </tr>
     <tr>
    <td class="LABEL" width="25%" >Condemnation Type</td>
    <td width="25%" class ="CONTROL" >
    <bean:write name="condemnRegisterViewBean" property="strCondemnationType" filter="false" />
     </td>
     <td class="CONTROL" width="25%" colspan="2"></td>
    </tr>
     <tr>
    <td class="LABEL" width="25%" >Remarks</td>
    <td width="25%" class ="CONTROL" >
    <bean:write name="condemnRegisterViewBean" property="strRemarks" filter="false" />
     </td>
     <td class="CONTROL" width="25%" colspan="2"></td>
    </tr>
   </table>
   	
		 
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER"> 
    	<td colspan="4" ></td>
  		</tr>
		<tr>

			<td align="center" colspan="4">
			<img  style="cursor: pointer; "  title="Click to Return on Desk"
					src="../../hisglobal/images/btn-ccl.png" onClick="cancelToDesk();" >
		</td>
		</tr>
	</table>
	
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strPath" value="${condemnRegisterViewBean.strPath}"/>
<cmbPers:cmbPers/>
</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
