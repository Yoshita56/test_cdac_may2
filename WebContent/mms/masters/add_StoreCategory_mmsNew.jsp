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
<html:form name="storeCategoryBean" action="/masters/StoreCategoryMstBSCNT"
	type="mms.masters.controller.fb.StoreCategoryMstFB">
<fieldset form="form1"><br>
<div class="prescriptionTile">
<div class="row rowFlex reFlex" >
<div class="legendvs">
<button  type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancel('LIST');">
<i class="fas fa-ban iround"  title="Cancel"></i>
</button>
<button type="button" class=" btn btn-secondary btn-circle" onclick="document.forms[0].reset(),document.forms[0].strStoreName.focus();" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
</button>
<button  type="button" id="submitId" onclick=' return validate1();' class="float-right btn btn-outline-success mt-1 btn-circle" tabindex='2' style="background-color: #5cb85c;">					
<i class="fa fa-save iround"  title="Save" ></i>
</button> 							                 
  </div> 
</div>   



<div class="row" align="left">
<p class="subHeaders" style="margin-bottom: 0;">
<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>
Store Category Master
<i class="fas fa-angle-double-right"></i>
<label>Add</label></p>
<div class="col-sm-8" align="center" >
<div class="row">
<div class="col-sm-4" align="right">
<label>Store Name:</label>
</div>
<div class="col-sm-8" align="left" style="font-weight: 400;">
<bean:write	name="storeCategoryBean" property="strStoreName" filter="false" />
</div>
</div>
</div>
</div>
<center>
	<div class="errMsg"><bean:write name="storeCategoryBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="storeCategoryBean"
		property="strWarning" /></div>
	<div id="normalMsg"  class="normalMsg"><bean:write name="storeCategoryBean"
		property="strMsg" /></div>
</center>
<hr>
<div class="row">
<%-- <div class="col-sm-4" >
<div class="row">
<div class="col-sm-4" >
<label>Store Name:</label>
</div>
<div class="col-sm-8" align="left" style="font-weight: 400;">
<bean:write	name="storeCategoryBean" property="strStoreName" filter="false" />
</div>
</div>
</div> --%>
<div class="col-sm-1" ></div>
<div class="col-sm-2" >
<label><font color="red">*</font>Store Category</label>
</div>
<div class="col-sm-2">
<html:select style="width: 100%; padding: 0.375rem 0.75rem;border: 1px solid #ced4da;border-radius: 0.25rem;" name="storeCategoryBean" property="strStoreItemCategory" onchange="SubGroupCombo();">
<bean:write name="storeCategoryBean" property="strLeftStoreCategoryList" filter="false" />
</html:select>
</div>
<div class="col-sm-5">
<label>Whether Store is Bounded With Items</label>
</div>
<div class="col-sm-1" align="right">
<html:checkbox	property="strItemBounded" value="1" name="storeCategoryBean"></html:checkbox>
</div>
<div class="col-sm-1" ></div>
</div>
<div class="row">
<div class="col-sm-1" ></div>
<div class="col-sm-2">
<label>Effective From</label>
</div>
<div class="col-sm-2">
<input class='form-control datepicker' name="strEffectiveFrom" value="${storeCategoryBean.strCtDate}">
</div>
<div class="col-sm-1">
<label>Remark</label>

</div>
<div class="col-sm-5">
<textarea name="strRemarks" class="form-control"cols="25" rows="2"></textarea>
</div>
<div class="col-sm-1" ></div>
</div>
<hr>
<div class="row">
<div class='col-sm-9'>
</div>
<div class='col-sm-3' align="right">
<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>
<label>&nbsp;Mandatory Fields</label>
</div>
</div>

		
	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Store Category Master 11&gt;&gt; Add</td>
		</tr>


		<tr>
			<td class="LABEL">Store Name </td>
			<td width="50%" class="CONTROL"> <bean:write
				name="storeCategoryBean" property="strStoreName" filter="false" />

			</td>

		</tr>

		
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Store Category</td>
			<td width="50%" class="CONTROL"> <html:select
				name="storeCategoryBean" property="strStoreItemCategory"
				onchange="SubGroupCombo();">
				<bean:write name="storeCategoryBean" property="strLeftStoreCategoryList"
					filter="false" />
			</html:select> </td>
		</tr>
		</table> --%>
		
		
		
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		
		<tr>
			<td width="50%" class="LABEL">Whether Store is Bounded With
			Items</td>
			<td width="50%" class="CONTROL"> <html:checkbox
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
			<td width="50%" class="CONTROL"> <textarea name="strRemarks"
				cols="25" rows="2"></textarea> </td>
		</tr>
		
		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font
				color="red">*</font> Effective From</div>
			</td>
			<td class="CONTROL"> <dateTag:date name="strEffectiveFrom"
				value="${storeCategoryBean.strCtDate}"></dateTag:date> </td>
		</tr>


		

		
		 <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr> 
	</table> --%>
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
					 	<!-- <a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a> -->
				</div> 
					
<input type="hidden" name="hmode"/>
<input type="hidden" name="comboValue"
		value="${storeCategoryBean.strStoreName}">
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