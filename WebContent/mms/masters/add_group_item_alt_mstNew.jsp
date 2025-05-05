<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=utf-8>
<title>Generic Item Alteration Master</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>




<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>



<script language="javaScript">

function validate1()
{     
      var hisValidator = new HISValidator("groupItemAltMstBean");
              
			hisValidator.addValidation("strItemCat", "dontselect=0","Please Select Drug Category");
			hisValidator.addValidation("strExGroupId", "dontselect=0","Please Select Existing Group");
			hisValidator.addValidation("strRpGroupId", "dontselect=0","Please Select Replaced Group");
			hisValidator.addValidation("strRpSubGroupId", "dontselect=0","Please Select Replaced Sub Group");
			hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
	   	 	hisValidator.addValidation("strRemarks", "req", "Please Enter Remarks" );
	   	 	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			var retVal = hisValidator.validate();
          	if(retVal)
          	{
          		 var count = selectListRecords("strRightItemIds");
          		 var count1 = selectListRecords("strRightNewItemIds");
        		 if(count==0 && count1==0)
        		 {
        		 	alert("Please Select Items in Right List");
        		 	return false;
        		 }        		 
        		 document.forms[0].hmode.value = "SAVE";
                 document.forms[0].submit();            	 
			}
			else
            {
				return false;
			}
}
function getAjaxResponse(res,mode)
{
		var objVal;
		var objVal2;
		objVal= document.getElementById("SubGroupDivId");
		objVal.innerHTML ="<select name ='strRpSubGroupId' class='form-control'>"+
						  "<option value='0'>No Change</option><option value='0'>No Sub Group</option></select>";
	    if(mode=='1')
	    {   
				objVal= document.getElementById("LeftItemIds");
				objVal.innerHTML = "<select class='form-control' name='strLeftItemIds' size='6' multiple style='width: 480px'></select>";
				objVal= document.getElementById("LeftNewItemIds");				
				objVal.innerHTML = "<select class='form-control'name='strLeftNewItemIds' size='6' multiple style='width: 480px'></select>";
				objVal= document.getElementById("RightItemIds");
				objVal.innerHTML = "<select class='form-control' name='strRightItemIds' size='6' multiple style='width: 480px'></select>";
				objVal= document.getElementById("RightNewItemIds");
				objVal.innerHTML = "<select class='form-control' name='strRightNewItemIds' size='6' multiple style='width: 480px'></select>";				
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
	       		if(temp1[0] == "ERROR")
	       		{
         			err.innerHTML = temp1[1];
        		}
				else
				{
					objVal= document.getElementById("exGrp");
					objVal.innerHTML = "<select name='strExGroupId' class='form-control' onchange='getNextCombo(2,this)'>"+res+"</select>";				
					objVal= document.getElementById("rpGrp");
					objVal.innerHTML = "<select name='strRpGroupId' onchange='getNextCombo(3,this)' class='form-control'>"+res+"</select>";
				}
	       		//document.getElementById("normalMsg").style.display="none";//hiding loading img
	       		document.getElementById("loadmsg").style.display = "none";
		}
		if(mode=='2')
		{   
				objVal= document.getElementById("LeftItemIds");
				objVal.innerHTML = "<select class='form-control' name='strLeftItemIds' size='6' multiple style='width: 480px'></select>";
				objVal= document.getElementById("LeftNewItemIds");				
				objVal.innerHTML = "<select class='form-control' name='strLeftNewItemIds' size='6' multiple style='width: 480px'></select>";
				objVal= document.getElementById("RightItemIds");
				objVal.innerHTML = "<select class='form-control' name='strRightItemIds' size='6' multiple style='width: 480px'></select>";
				objVal= document.getElementById("RightNewItemIds");
				objVal.innerHTML = "<select class='form-control' name='strRightNewItemIds' size='6' multiple style='width: 480px'></select>";
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
        		if(temp1[0] == "ERROR")
        		{
         			err.innerHTML = temp1[1];	
        		}
				else
				{
					objVal= document.getElementById("LeftItemIds");
					objVal.innerHTML = "<select class='form-control' name='strLeftItemIds' size='6' multiple style='width: 480px' >"+res.split('^')[0]+"</select>";
					objVal= document.getElementById("LeftNewItemIds");				
					objVal.innerHTML = "<select class='form-control' name='strLeftNewItemIds' size='6' multiple style='width: 480px' >"+res.split('^')[1]+"</select>";
				}
        		//document.getElementById("normalMsg").style.display="none";//hiding loading img
        		//document.getElementById("newDrug").innerHTML=document.forms[0].strNewDrugCnt.value;
        		//document.getElementById("exDrug").innerHTML=document.forms[0].strExDrugCnt.value;
        		document.getElementById("loadmsg").style.display = "none";
		 }
		 if(mode=='3')
		 {   
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
        		if(temp1[0] == "ERROR")
        		{
         			err.innerHTML = temp1[1];	
        		}
				else
				{
					var temp = res.split("#");	
					objVal= document.getElementById("SubGroupDivId"); 
					objVal.innerHTML = "<select name ='strRpSubGroupId' class='form-control'>"+res+"</select>";
				}
        	//	document.getElementById("normalMsg").style.display="none";//hiding loading img
        		document.getElementById("loadmsg").style.display = "none";
		 }
		 if(mode=='4')
		 {   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			    if(temp1[0] == "ERROR")
        		{
         			err.innerHTML = temp1[1];	
        		}
				else
				{					
					objVal= document.getElementById("LeftItemIds");
					objVal.innerHTML = "<select class='form-control' name='strLeftItemIds' size='6' multiple style='width: 480px'>"+res.split('^')[0]+"</select>";
					objVal= document.getElementById("LeftNewItemIds");				
					objVal.innerHTML = "<select class='form-control' name='strLeftNewItemIds' size='6' multiple style='width: 480px'>"+res.split('^')[1]+"</select>";
				}
			    //document.getElementById("normalMsg").style.display="none";//hiding loading img
			    document.getElementById("loadmsg").style.display = "none";
			    
		 }
}
/*
function loading_msg()
{
	 var qh=80;
	 var qw=300;
	 var dh=0;
	 var dw=0;
	 
	   if(window.innerHeight){
	   	  dh=window.innerHeight;
	   	  dw=window.innerWidth;
	   }else {
	   	  dh=document.documentElement.clientHeight;
	   	  dw=document.documentElement.clientWidth;
	   }
	   
	 var tpos=parseInt((dh-qh)/2);
	 var lpos=parseInt((dw-qw)/2); 
	// var wt='<div id="qmvi_loading_div" style="top:'+tpos+'px;left:'+lpos+'px;height:'+qh+'px;width:'+qw+'px;position:absolute;text-align:center;font-family:Arial;text-decoration:none;font-weight:normal;font-size:13px;color:#00224A;background-color:#ffffff;border-width:1px;border-color:#828EA2;border-style:solid;">';
	// wt+='<div style="padding:20px;"><img src="../../hisglobal/images/loading.gif" width=16 height=16><br><br><font size="2" weight="bold">Fetching Detail(s).Please Wait!</font></div>';
	// wt+='</div>';
	 
	 document.getElementById("normalMsg").innerHTML=wt;
	  document.getElementById("normalMsg").style.display = "block";
	 }
	 */
function getNextCombo(flag,obj)
{
	var url;
	var mode = '';   
	
	if(flag == '1')//Get Existing Group
	{
		 url="GroupItemAltMstBSCNT.cnt?hmode=EXISTGROUP&strItemCat="+obj.value;
		 document.getElementById("loadmsg").style.display = "block";
		 ajaxFunction(url,"1");
	}
	if(flag == '2')//Get Replaced Group
	{
		 url="GroupItemAltMstBSCNT.cnt?hmode=EXISTINGITEMS&strExGroupId="+obj.value;
		// loading_msg();
		document.getElementById("loadmsg").style.display = "block";
		 ajaxFunction(url,"2");
	}
	if(flag == '3')//Get Replaced Sub Group
	{
		 url="GroupItemAltMstBSCNT.cnt?hmode=REPLACESUBGROUP&strRpGroupId="+obj.value; 
		 //loading_msg();
		 document.getElementById("loadmsg").style.display = "block";
		 ajaxFunction(url,"3");
	}
	if(flag == '4')//Get Existing Items
	{
		 url="GroupItemAltMstBSCNT.cnt?hmode=EXISTINGITEMS&strExGroupId="+document.forms[0].strExGroupId.value;
		 //loading_msg();
		 document.getElementById("loadmsg").style.display = "block";
		 ajaxFunction(url,"4");
	}
}
function searchInList()
{ 

	var valObj = document.forms[0].searchVal;

	if(valObj.value.length == 0 ){
	
		alert("Please Enter a Value to Search from List");
		valObj.focus();
		return false;
	}
	
	searchInListBox("strLeftItemIds",document.forms[0].searchVal.value);  
}
function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftItemIds");
	shiftToRight("strLeftItemIds","strRightItemIds",1);
}
function LeftNewListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftNewItemIds");
	shiftToRight("strLeftNewItemIds","strRightNewItemIds",1);
}
	
</script>

<style type="text/css">
.legendNew {
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: -2.9em;
}
</style>

</head>

<body>
<html:form name="groupItemAltMstBean" action="/masters/GroupItemAltMstBSCNT" 
type="mms.masters.controller.fb.GroupItemAltMstFB">

<fieldset form="form1"><br>
<div class="prescriptionTile">
<div class="d-flex justify-content-center">
<div id='loadmsg' class="spinner-border text-info" role="status" style="display:none;">

  <span class="sr-only">Loading...</span>
</div></div>
	<center>
	<div id="errMsg" class="errMsg"><bean:write name="groupItemAltMstBean" property="strErr" /></div>
	<div class="warningMsg"><bean:write name="groupItemAltMstBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="groupItemAltMstBean" property="strMsg" /></div>
	<%-- <tag:tab tabLabel="Group Drug Alteration Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab> --%></center>
	
	
	
   <div class="row">
				<div class="col-sm-9" align="left">
							<p class="subHeaders" style="margin-bottom: 0;">
								<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Generic Item Alteration Master			
							</p>
				       </div>
				      
							<div class="col-sm-3" align="right">
							<div class="legendNew" id="nonPrintableLegend2">
									<button type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancel('CANCEL');">
										<i class="fas fa-ban iround" title="Cancel"></i>
									</button>
									<button type="button" class=" btn btn-secondary btn-circle" onclick="document.forms[0].reset()" style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
										<img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
									</button>
									<button type="button" id="savebutton" class="float-right btn btn-outline-success mt-1 btn-circle" tabindex="2" onclick=' return validate1();' style="background-color: #5cb85c;">
										<i class="fas fa-save iround" title="save"></i>
									</button>
								</div>
							</div>
						</div>
						
			<hr>
		<div class="row">
		<div class="col-sm-3">
		<label><font color="red">*</font>Drug Category</label>
		</div>
		<div class="col-sm-3">
		<select name="strItemCat" onchange="getNextCombo(1,this)" class="form-control">
			<bean:write name="groupItemAltMstBean" property="strItemCatCombo" filter="false" /></select>
		</div>
		<div class="col-sm-3">
		<label><font color="red">*</font>Existing Group</label>
		</div>
		<div class="col-sm-3">
		<div id="exGrp">
			<select name="strExGroupId" onchange="getNextCombo(2,this)" class="form-control">
			<option value='0'>Select Value</option>
			</select>
			</div>
		</div>
		</div>
			
	
	<div class="row">
	<div class="col-sm-3">
	<label><font color="red">*</font>Replaced Group</label>
	</div>
	<div class="col-sm-3">
	<div id="rpGrp">
			<select name="strRpGroupId" onchange="getNextCombo(3,this)" class="form-control">
				<option value='0'>Select Value</option>
			</select></div>
	</div>
	<div class="col-sm-3">
	<label><font color="red">*</font>Replaced Sub Group</label>
	</div>
	<div class="col-sm-3">
	<div id="SubGroupDivId">
			<select name="strRpSubGroupId" class="form-control">
				<option value="0" selected="selected">No Change</option>
				<option value="1">No Sub Group</option>
				<bean:write name="groupItemAltMstBean" property="strRpSubGroupNameCombo" filter="false" />
			</select></div>
	</div>
	</div>
	
	 <div class="row">
				<div class="col-sm-9" align="left">
							<p class="subHeaders" style="margin-bottom: 0;">
								<font color="red">*</font>Existing Drug		
							</p>
				       </div>
				      
							<div class="col-sm-3" align="right"></div>
						</div>
	
	
	<div class="row">
	
	<div class="col-sm-5">
	<div id="LeftItemIds" align="right">
			<select class="form-control" name="strLeftItemIds" size="6" multiple style="width: 100%">
				<bean:write name="groupItemAltMstBean" property="strLeftItemList" filter="false"/>
			</select></div>
	</div>
	<div class="col-sm-2" style="text-align:center;">
		
			<center>
					<i class="fas fa-caret-right" onclick ="LeftListTransfer();" align="middle" style="border: 1px solid ; padding: 0.1rem 0.7rem; margin-bottom:0.2rem; "></i>		
			</center>
			<center>
			<i class="fas fa-forward" align="middle" onClick="shiftAllToRight('strLeftItemIds','strRightItemIds',1);" style="border: 1px solid ; padding: 0.1rem 0.4rem;"></i>
				
		 	</center>
			<br/>
			<center>				
			
				<i class="fas fa-backward" onClick="shiftAllToLeft('strLeftItemIds','strRightItemIds',1);" align="middle" style="border: 1px solid ; padding: 0.1rem 0.4rem; margin-bottom:0.2rem;"></i>
					</center>
			
			<center>
				<i class="fas fa-caret-left" onclick="shiftToLeft('strLeftItemIds','strRightItemIds',1);" align="middle" style="border: 1px solid ; padding: 0.1rem 0.7rem;"></i>
					</center>
			
	</div>
	<div class="col-sm-5">
	<div id="RightItemIds" align="left">
			<select class="form-control" name="strRightItemIds" size="6" multiple style="width: 100%">
				<bean:write name="groupItemAltMstBean" property="strRightItemList" filter="false"/>
			</select></div>
	</div>
	
	</div>
	
	
	 <div class="row">
				<div class="col-sm-9" align="left">
							<p class="subHeaders" style="margin-bottom: 0;">
								New Drug		
							</p>
				       </div>
				      
							<div class="col-sm-3" align="right"></div>
						</div>
	
	
	<div class="row">
	<!-- <div class="col-sm-2"></div> -->
	<div class="col-sm-5">
	<div id="LeftNewItemIds" align="right">
			<select class="form-control" name="strLeftNewItemIds" size="6" multiple style="width: 100%">
				<bean:write name="groupItemAltMstBean" property="strLeftNewItemList" filter="false"/>
			</select></div>
	</div>
	<div class="col-sm-2" style="text-align:center;">		
			<center>
			
		<i class="fas fa-caret-right" onclick ="LeftNewListTransfer();" align="middle" style="border: 1px solid; padding: 0.1rem 0.7rem; margin-bottom:0.2rem; color:gray;"></i>
			
			</center>
			<center>
					
			<i class="fas fa-forward" align="middle" onClick="shiftAllToRight('strLeftNewItemIds','strRightNewItemIds',1);" style="border: 1px solid; padding: 0.1rem 0.4rem;"></i>
		
				</center>
			<br/>
			<center>				
			<i class="fas fa-backward" onClick="shiftAllToLeft('strLeftNewItemIds','strRightNewItemIds',1);" align="middle" style="border: 1px solid; padding: 0.1rem 0.4rem; margin-bottom:0.2rem;"></i>
	
				</center>
			
			<center>
				<i class="fas fa-caret-left" onclick="shiftToLeft('strLeftNewItemIds','strRightNewItemIds',1);" align="middle" style="border: 1px solid ; padding: 0.1rem 0.7rem;"></i>
		
				</center>
	</div>
	<div class="col-sm-5">
	<div id="RightNewItemIds" align="left">
			<select class="form-control" name="strRightNewItemIds" size="6" multiple style="width: 100%">
				<bean:write name="groupItemAltMstBean" property="strRightNewItemList" filter="false"/>
			</select></div>
	</div>
	<!-- <div class="col-sm-2"></div> -->
	</div>
	
	<div class="row">
	<div class="col-sm-2">
	<label><font color="red">*</font>Effective From</label>
	</div>
	<div class="col-sm-3">
	<%-- <dateTag:date name="strEffectiveFrom" value="${groupItemAltMstBean.strCtDate}"></dateTag:date> --%>
	<input  type="text" class="form-control datepicker" name="strEffectiveFrom" value="${groupItemAltMstBean.strCtDate}">
	</div>
	<div class="col-sm-2" align="right">
	<font color="red">*</font>Remarks
	</div>
	<div class="col-sm-5">
	<textarea name="strRemarks" class="form-control" cols="25" rows="2"></textarea>
	</div>
	</div>
	
	<hr>
<div class="row rowFlex reFlex">
							<div class="col-sm-9"></div>
							<div class="col-sm-3" align="right">
								<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>&nbsp;Fields Mandatory
							</div>
						</div>

	
	
	
	
	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">
		<tr class="HEADER">
			<td colspan="4">Group Drug Alteration Master</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Drug Category</td>
			<td width="25%" class="CONTROL" colspan="1">
			<select name="strItemCat" onchange="getNextCombo(1,this)" class="comboNormal">
			<bean:write name="groupItemAltMstBean" property="strItemCatCombo" filter="false" /></select></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Existing Group</td>
			<td width="25%" class="CONTROL"><div id="exGrp">
			<select name="strExGroupId" onchange="getNextCombo(2,this)" class="comboNormal">
			<option value='0'>Select Value</option>
			</select>
			</div></td>
		</tr>
		<tr>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Replaced Group</td>
			<td width="25%" class="CONTROL">
			<div id="rpGrp">
			<select name="strRpGroupId" onchange="getNextCombo(3,this)" class="comboNormal">
				<option value='0'>Select Value</option>
			</select></div></td>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Replaced Sub Group</td>
			<td width="25%" class="CONTROL" colspan="1">
			<div id="SubGroupDivId">
			<select name="strRpSubGroupId" class="comboNormal">
				<option value="-1" selected="selected">No Change</option>
				<option value="-2">No Sub Group</option>
				<bean:write name="groupItemAltMstBean" property="strRpSubGroupNameCombo" filter="false" />
			</select></div>
			</td>
		</tr>		
		</table> --%>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">
		<tr>
		<td colspan="8"  class="TITLE" ><font color="red">*</font>Existing Drug</td>
		</tr>
		<tr>
  			<td class="CONTROL" colspan="2">  			 
			<div id="LeftItemIds" align="right">
			<select name="strLeftItemIds" size="6" multiple style="width: 280px">
				<bean:write name="groupItemAltMstBean" property="strLeftItemList" filter="false"/>
			</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftListTransfer();"></center>
			<center>
			<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" 
				align="middle" onClick="shiftAllToRight('strLeftItemIds','strRightItemIds',1);"/></center>
			<br/>
			<center>				
			<img src="../../hisglobal/images/backward.gif" width="30" height="21" 
				onClick="shiftAllToLeft('strLeftItemIds','strRightItemIds',1);"></center>
			<center><img src="../../hisglobal/images/back3.gif" width="30" height="21" 
				onclick="shiftToLeft('strLeftItemIds','strRightItemIds',1);"/></center>
			</td>			
			<td colspan="3" class="CONTROL">
			<div id="RightItemIds" align="left">
			<select name="strRightItemIds" size="6" multiple style="width: 280px">
				<bean:write name="groupItemAltMstBean" property="strRightItemList" filter="false"/>
			</select></div>
			</td>		
		</tr>
		<tr>
		<td colspan="8" class="TITLE">New Drug</td>
		</tr>
		<tr>
  			<td class="CONTROL" colspan="2">  			 
			<div id="LeftNewItemIds" align="right">
			<select name="strLeftNewItemIds" size="6" multiple style="width: 280px">
				<bean:write name="groupItemAltMstBean" property="strLeftNewItemList" filter="false"/>
			</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftNewListTransfer();"></center>
			<center>
			<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" 
				align="middle" onClick="shiftAllToRight('strLeftNewItemIds','strRightNewItemIds',1);"/></center>
			<br/>
			<center>				
			<img src="../../hisglobal/images/backward.gif" width="30" height="21" 
				onClick="shiftAllToLeft('strLeftNewItemIds','strRightNewItemIds',1);"></center>
			<center><img src="../../hisglobal/images/back3.gif" width="30" height="21" 
				onclick="shiftToLeft('strLeftNewItemIds','strRightNewItemIds',1);"/></center>
			</td>			
			<td colspan="3" class="CONTROL">
			<div id="RightNewItemIds" align="left">
			<select name="strRightNewItemIds" size="6" multiple style="width: 280px">
				<bean:write name="groupItemAltMstBean" property="strRightNewItemList" filter="false"/>
			</select></div>
			</td>		
		</tr>
		</table>
		<TABLE class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">
		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font color="red">*</font>Effective From</div>
			</td>
			<td class="CONTROL">
			<dateTag:date name="strEffectiveFrom" value="${groupItemAltMstBean.strCtDate}"></dateTag:date></td>
		</tr>
		<!-- <tr>
			<td width="50%" class="LABEL" valign="top"><font color="red">*</font>Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks" cols="25" rows="2"></textarea></td>
		</tr> -->
		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font>Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">
		<tr>
			<td align="center">
			<!-- <img style="cursor: pointer; "
				title="Save Record" src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" />
			<img style="cursor: pointer; " title="Reset Content"
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" />
			<img style="cursor: pointer; " title="Cancel Process" 
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('CANCEL');" />
				 -->
				
				<br>					 
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel('CANCEL');"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />	
	<input type="hidden" name="strNewDrugCnt" value="${groupItemAltMstBean.strNewDrugCnt}" />
	<input type="hidden" name="strExDrugCnt" value="${groupItemAltMstBean.strExDrugCnt}" />
	</div>
	</fieldset>
</html:form>
<tag:autoIndex></tag:autoIndex>
<script type="text/javascript">

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script>

</body>
</html>