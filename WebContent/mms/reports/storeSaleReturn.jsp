<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<title>Store Wise Sale Return Report</title>

<style type="text/css">
.ui-datepicker-calendar {
    display: none;
    }
		.prescriptionTile {
				margin: 20px;
				border-bottom: 1px solid #d7d7d7;
				padding-bottom: 10px;
				padding: 1% 2% 0.5% 2%;
				background-color: #fff;
				transition: 0.5s;
				box-shadow: 0.5px 0.5px 10px 2px #b0acac;
				border-radius: .35rem;
				color: #666;
				color: rgba(75, 75, 75, 0.9);
				color: rgb(21, 21, 21);
		}
		legend {
		 
		  color: white;
		  padding: 5px 10px;
		}
		.legend2 {
			  position: absolute;
			  top: 0.5em;
			  right: 44px;
			  line-height: 1.2em;
		}
</style>

<!-- CSS -->
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<!-- JS -->
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<!-- EXT JS -->
<script language="Javascript" src="/INVMGM/mms/js/StoreSaleReturn.js"></script>

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>

</head>

<body onload="onLoadPage();">

<html:form action="/reports/StoreSaleReturnCNT" type="mms.reports.controller.fb.StoreSaleReturnFB" name="StoreSaleReturnBean" method="post">
	
<div class="errMsg" id="errMsg" style='font-size: 16px;'><bean:write name="StoreSaleReturnBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg" style='font-size: 16px;'><bean:write name="StoreSaleReturnBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg" style='font-size: 16px;'><bean:write name="StoreSaleReturnBean" property="strWarningMsg"/></div>
<fieldset style="border: 1px solid #00000069;margin: 1%;">
	<legend style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400;margin-left:10px;color: #666;" id="nonPrintableLegend"><i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Store Wise Sale Return</legend>
		<div class="container-fluid">
			<div class="prescriptionTile">
				
			<div class='legendHeader' style='font-size: 18px;font-weight: bold;'>
				</div>
				
				<div class="row">
					<div class="legend2" id='nonPrintableLegend2'>
						<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-circle btn-icon" style="border-radius:50%; padding:10px 12px" onclick="cancelFunc();">	
							<div class="popupToast" style="color: #fff;">
								<i class="fas fa-times" title="Cancel"></i>
							</div>
						</button>
						
						 <button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon " style="background-color: #2196f3; border-radius:50%; padding:10px 8px" onClick="onClearPage();">	
							<div class="popupToast" style="color: #fff;">
								<i class="fas fa-broom" title="Clear"></i>
							</div>
						</button>		 
						
						<button onclick="return getIssueTrackDtlRpt();" type="button" id="download" title="download" class="float-right btn btn-outline-success btn-circle mt-1 btn-icon" style="background-color: #28a745;border-radius:50%; padding:10px 11px" >	
							<div class="popupToast" style="color: #fff;">
								<i class="fa fa-download" title="Clear"></i>
							</div>
						</button>
						
		 			</div>  
				</div>
				
					
					<div class="row">
						<div class="col-sm-2">
							<label class="container">Date Range
								<input type="radio" name="strCriteria" id="dRange" value="1" checked onclick="chkCriteria('1');">
								<span class="checkmark"></span>
							</label>
						</div>
						<div class="col-sm-2">
							<label class="container">Year Wise
								<input type="radio" name="strCriteria" id="yRange" value="2" onclick="chkCriteria('2');">
								<span class="checkmark"></span>
							</label>
						</div>
					</div>
					
     				
					<div class="row" style="margin: 1% 12%;display: none;text-align: right;" id="d_range">
						<div class="col-sm-2 py-2"><font color="red">*</font>Select Year</div>
						<div class="col-sm-3">
							<input class="Ydate form-control" name="Ydate" id="Ydate" type="number" placeholder="YYYY" min="2020" max="2099">
				 		</div>
					</div>	
					
					
					<div class="row" style="margin: 1% 12%; text-align: right;" id="d_range1">
						<div class="col-sm-2 py-2"><label><font color="red">*</font>From Date </label></div>
						<div class="col-sm-3">
							<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${StoreSaleReturnBean.strCurrentDate}" />
						</div>
						
						
						<div class="col-sm-2 py-2"><label><font color="red">*</font>To Date </label></div>
						<div class="col-sm-3">
							<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${StoreSaleReturnBean.strCurrentDate}" />
						</div>
					</div>
					
				<hr>

					<div class="row" style="margin: 1% 12%;text-align: right; ">
							<div class="col-sm-2 py-2"><label><font color="red">*</font>Store Name</label></div>
							<div class="col-sm-8">
								<select id= "strStoreId" name="strStoreId" class='custom-select' onchange=""> 
									<bean:write name="StoreSaleReturnBean" property="strStoreValues" filter="false" />
								</select>
							</div>
					</div>

				<input type="hidden" name="hmode"/>
				<input type="hidden" name="strEndFinancialYearTemp" value="${StoreSaleReturnBean.strEndFinancialYearTemp}"/>
				<input type="hidden" name="strCurrentDate" value="${StoreSaleReturnBean.strCurrentDate}"/>
				<input type="hidden" name="strStoreName" value=""/>
			
				
		
			</div>
		</div>
				<div class="container-fluid" id="issueTrackRpt1" style="display: none;">
					<div class="prescriptionTile" >
						<div align="center" id="issueTrackRpt" style='display:none;'></div>
					</div>
				</div>
				<div class="col-sm-12" align="right" id="myDIV1">
				 	<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
				</div>
</fieldset>
</html:form>
<script type="text/javascript">
    $(document).ready(function(){
      $('#Ydate').on('input', function() {
        var inputValue = $(this).val();
        if (inputValue.length === 4 && !isNaN(inputValue)) {
          var selectedYear = inputValue;
          console.log(selectedYear);
        }
      });
    });
  </script>


 <script type="text/javascript">
 function padZero(number) {
	  return number < 10 ? '0' + number : number;
	}
 
    $('#datepicker1').datepicker({modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    $('#datepicker2').datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    var today=new Date();
    var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
    var mmm=arr[today.getMonth()];
    var hrs=today.getHours();
    var day = padZero(today.getDate());
    var dd=day+"-"+mmm+"-"+today.getFullYear();
    $('#datepicker1').val(dd);
    $('#datepicker2').val(dd);

</script>


<tag:autoIndex></tag:autoIndex>

</body>
</html>