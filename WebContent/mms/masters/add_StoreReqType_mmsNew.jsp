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
<title>Store Request Type Master Add Page</title>
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
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">

function validate1(){   
     
     
     selectListRecords("strRightRequestTypes"); 
      var hisValidator = new HISValidator("storeReqTypeBean"); 
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
        hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
      //   hisValidator.addValidation("strRightRequestTypes", "dontselect=0","Please move atleast one Request Type from left to right \n And select only those Requests which are to be added from right list");
      
      var retVal = hisValidator.validate(); 
      hisValidator.clearAllValidations();
    	
          if(retVal)
          {
        		 var count = selectListRecords("strRightRequestTypes");
        		 if(count==0)
        		 {
        		   alert("Please select a Request Type which is not already added");
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
	var ob1=document.forms[0].strLeftReqTypes.value;
	var ob=document.getElementById("LeftReqTypes");
	shiftToRight("strLeftReqTypes","strRightRequestTypes",1);
}
</script>
<style type="text/css">
.legendvs{
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: 0.6em;
}
</style>
</head>
<body onLoad="">
<html:form name="storeReqTypeBean" action="/masters/StoreReqTypeMstBSCNT"
	type="mms.masters.controller.fb.StoreReqTypeMstFB">
<fieldset form="form1">
<br>
<div class="prescriptionTile">
<div class="d-flex justify-content-center">
<div class="row"><div class="col-sm-12">

<div class="errMsg"><bean:write name="storeReqTypeBean"	property="strErr" /></div>
<div class="warningMsg"><bean:write name="storeReqTypeBean" property="strWarning" /></div>
<div id="normalMsg"  class="normalMsg"><font color="red"><bean:write name="storeReqTypeBean"	property="strMsg" /></font></div>
	
</div></div></div>
<div class="row rowFlex reFlex" >
<div class="legendvs" id="nonPrintableLegend2">
<button type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancel('LIST');">
<i class="fas fa-ban iround" title="Cancel"></i>
</button>
<button type="button" class=" btn btn-secondary btn-circle" onclick="document.forms[0].reset();" style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
<img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
</button>
<button type="button" id="submitId" class="float-right btn btn-outline-success mt-1 btn-circle" tabindex="2" onclick="return validate1('SAVE');" style="background-color: #5cb85c;">
<i class="fas fa-save iround" title="Generate"></i>
</button>
</div>
</div>
<div  class="row" align="left">
<p class="subHeaders" style="margin-bottom: 0;">
<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>
Store Request Type Master
<i class="fas fa-angle-double-right"></i>
<label>Add</label>	
</p>
<div class="col-sm-8" align="center">
<div class="row">
<div class="col-sm-2" align="right">
<label>Store Name:</label>
</div>
<div class="col-sm-4" align="left" style="font-weight: 400;">
<bean:write name="storeReqTypeBean" property="strStoreName" filter="false" />
</div>
<div class="col-sm-4" align="right">
<label>Drug Warehouse Category:</label>
</div>
<div class="col-sm-2" align="left" style="font-weight: 400;">
<bean:write name="storeReqTypeBean" property="strStoreCategory" filter="false" />
</div>
</div>
<%-- <label><bean:write name="storeReqTypeBean" property="strStoreName" filter="false" />&nbsp;/&nbsp;
<bean:write name="storeReqTypeBean" property="strStoreCategory" filter="false" /> </label> --%>
</div>
</div>

<!-- <div class="row rowFlex reFlex" >
<div class="legendvs" id="saveId">
<button  type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancel('LIST');">
<i class="fas fa-ban iround"  title="Cancel"></i>
</button>
<button type="button" class=" btn btn-secondary btn-circle" onclick="document.forms[0].reset()" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
</button>
<button  type="button" id="submitId" onclick=' return validate1();' class="float-right btn btn-outline-success mt-1 btn-circle" tabindex='2' style="background-color: #5cb85c;">					
<i class="fa fa-save iround"  title="Save" ></i>
</button> 							                 
  </div> 
</div>   -->
<%-- <div class="row" align="left">
<!-- <p class="subHeaders" style="margin-bottom: 0;">
<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>
Store Request Type Master</font>
<i class="fas fa-angle-double-right"></i>
<label style="color:;">&nbsp;Add&nbsp;</label></p> -->
<div class="col-sm-5">
 <center>
<div class="errMsg"><bean:write name="storeReqTypeBean"	property="strErr" /></div>
<div class="warningMsg"><bean:write name="storeReqTypeBean" property="strWarning" /></div>
<div id="normalMsg"  class="normalMsg"><bean:write name="storeReqTypeBean"	property="strMsg" /></div>
	</center>
</div>
</div> --%>
<%-- <div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-2" align="right">
<label>Store Name:</label>
</div>
<div class="col-sm-3" align="left" style="font-weight: 400;">
<bean:write name="storeReqTypeBean" property="strStoreName" filter="false" />
</div>
<div class="col-sm-3" align="right">
<label>Drug Warehouse Category:</label>
</div>
<div class="col-sm-2" align="left" style="font-weight: 400;">
<bean:write name="storeReqTypeBean" property="strStoreCategory" filter="false" />
</div>
<div class="col-sm-1"></div>
</div> --%>
<div class="row">
<p class="subHeaders">
Request Type
</p>
</div>

<div class="row" style="margin-bottom: 10px">
<div class="col-sm-5" id="LeftReqTypes" align="right">
<select class="form-control" name="strLeftReqTypes" size="8" multiple>
<bean:write name="storeReqTypeBean" property="strLeftRequestTypeList" filter="false"/>
</select>
</div>
<div class="col-sm-2">

			<center>
				<i class="fas fa-caret-right" onclick="LeftListTransfer();" align="middle" style="border: 1px solid; 
				padding: 0.1rem 0.7rem; margin-bottom:0.2rem;"></i>
				</center><br>
				<center>
				<i class="fas fa-forward" align="middle" onClick="shiftAllToRight('strLeftReqTypes','strRightRequestTypes',1);" 
				style="border: 1px solid; padding: 0.1rem 0.4rem;"></i>
				</center>
				<br/>
				<center>
				<i class="fas fa-backward" align="middle" onClick="shiftAllToLeft('strLeftReqTypes','strRightRequestTypes',1);" 
				style="border: 1px solid; padding: 0.1rem 0.4rem;"></i>
				</center><br>
				
				<center>
				<i class="fas fa-caret-left" onClick="shiftAllToLeft('strLeftReqTypes','strRightRequestTypes',1);" align="middle" 
				style="border: 1px solid; padding: 0.1rem 0.7rem; margin-bottom:0.2rem;"></i>
				</center>
</div>
<%-- <div class="col-sm-4"id="RightReqTypes" align="left">
<select class="form-control" name="strRightRequestTypes" size="8" multiple style="width: 280px">
<bean:write name="storeReqTypeBean" property="strRightRequestTypeList" filter="false"/>
</select>
</div> --%>
<div class="col-sm-5" id="RightReqTypes" align="left">
<select name="strRightRequestTypes" size="8" multiple class="form-control">
<bean:write name="storeReqTypeBean" property="strRightRequestTypeList" filter="false"/>
</select>
</div>
<div class="col-sm-1">
</div>
</div>


<div class="row" style="margin-top: 10px">
<div class="col-sm-2">
<label>Effective From</label>
</div>
<div class="col-sm-3" align="right">
<input class='form-control datepicker' name="strEffectiveFrom" value="${storeReqTypeBean.strCtDate}">
 </div>
<div class="col-sm-2" align="right">
<label>Remark</label>
</div>
<div class="col-sm-5">
<textarea class="form-control" name="strRemarks" rows="1"></textarea>
</div>
</div>
<hr>
<div class="row">
<div class='col-sm-9'>
</div>
<div class='col-sm-3' align="right">

<label><font size="2" color="red">*</font>&nbsp;Mandatory Fields</label>

</div>
</div>
<!-- <div class="row">
<div class='col-sm-9'>
</div>
<div class='col-sm-3' align="right">

<label><font size="2" color="red">*</font>Mandatory Fields</label>
</font>
</div>
</div> -->
<%-- <center>
	<div class="errMsg"><bean:write name="storeReqTypeBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="storeReqTypeBean"
		property="strWarning" /></div>
	<div id="normalMsg"  class="normalMsg"><bean:write name="storeReqTypeBean"
		property="strMsg" /></div>

	<tag:tab tabLabel="Store Request Type Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	</center>	 --%>	
	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Store Request Type Master Add11</td>
		</tr>


		<tr>
			<td class="LABEL">Store Name11</td>
			<td width="50%" class="CONTROL"> <bean:write
				name="storeReqTypeBean" property="strStoreName" filter="false" />

			</td>

		</tr>
		<tr>
			<td class="LABEL">Drug Warehouse Category </td>
			<td width="50%" class="CONTROL"> <bean:write
				name="storeReqTypeBean" property="strStoreCategory" filter="false" />

			</td>

		</tr>

		<tr>
		<td colspan="2"  class="LABEL"><center><font color="red">*</font>Request Type</center></td>
		</tr>
		</table> --%>
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr>
  			 <td class="CONTROL" colspan="3">
  			 
			<div id="LeftReqTypes" align="right">
			<select name="strLeftReqTypes" size="8" 
				multiple style="width: 280px">
				<bean:write name="storeReqTypeBean" property="strLeftRequestTypeList" filter="false"/>
				</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">
			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="35"
				height="31" 
				onclick ="LeftListTransfer();"></center>
				
				<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" 
				align="middle" onClick="shiftAllToRight('strLeftReqTypes','strRightRequestTypes',1);"/></center>
				<br/>
				<center>
				
				<img src="../../hisglobal/images/backward.gif" width="35"
				height="31" 
				onClick="shiftAllToLeft('strLeftReqTypes','strRightRequestTypes',1);">
				</center>
				
				<center><img src="../../hisglobal/images/back3.gif" width="35" 
				height="31" 
				onclick="shiftToLeft('strLeftReqTypes','strRightRequestTypes',1);"/></center>
			</td>
			
			<td colspan="3" class="CONTROL" >
			<div id="RightReqTypes" align="left"><select name="strRightRequestTypes" size="8" 
			multiple style="width: 280px"><bean:write name="storeReqTypeBean" property="strRightRequestTypeList" filter="false"/>
			</select></div>
			</td>		
			</tr> 
		</table> --%>
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
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
				value="${storeReqTypeBean.strCtDate}"></dateTag:date></td>
		</tr>


		

		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table> --%>
	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();" /> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset()" />
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');" />
			
			</td>
		</tr>
	</table> -->
<br>
<!-- <div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div> -->
<input type="hidden" name="hmode"/>
<input type="hidden" name="dummy"	value="${storeReqTypeBean.strDummy}">
<input type="hidden" name="comboValue" value="${storeReqTypeBean.comboValue}">
<input type="hidden" name="storeId" value="${storeReqTypeBean.strStoreId}">
<input type="hidden" name="storeCategoryId" value="${storeReqTypeBean.strStoreCategoryId}">
<cmbPers:cmbPers/>
</div>
</fieldset>
</html:form>
<tag:autoIndex></tag:autoIndex>
<script>
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