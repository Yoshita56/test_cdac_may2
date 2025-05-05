<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=UTF-8">
<title>Return from Patient</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="Javascript" src="../../mms/js/miscellaneous_consumption_trans.js"></script>

<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
<style type="text/css">
.col-sm-1half, .col-sm-8half, .col-sm-half {
    position: relative;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}
.custom-radio .custom-control-label::before {
    background-color: white;  /* orange */
}

.col-md-1half, .col-md-8half, .col-md-half {
    position: relative;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}
@media (min-width: 768px) {
    .col-sm-1half,.col-md-1half, .col-sm-8half {
        float: left;
    }
    .col-sm-1half ,.col-md-1half{
        width: 12.495%;
    }
    .col-sm-half,.col-md-half {
        width: 4.165%;
    }
    .col-sm-2half,.col-sm-2half {
        width: 20.495%;
    }
}
.table
{
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-weight: 400;
	color: #212529;
}
textarea
{
width:100%;
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
.legend2 {
position: absolute;
top: 0.5em;
right: 44px;
line-height: 1.2em;
}
</style>

<script type="text/javascript">
	function controlToMainPage()
	{
		document.forms[0].hmode.value="FIRSTDATA";
		document.forms[0].submit();
	}
	
	
	function printDataOne() 
	  {
		  var x = document.getElementById("printImg");
		  x.style.display = "none";
			
	  	newwin = window.open('', 'printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
	  	newwin.document.write('<HTML><HEAD>');
	  	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	  	newwin.document
	  			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	  	newwin.document.write('<script>\n');
	  	newwin.document.write('function chkstate(){ \n');
	  	// newwin.document.write('if(document.readystate=="complete" ||
	  	// document.readystate=="undefined"){\n');
	  	newwin.document.write('window.close();\n');
	  	// newwin.document.write('}\n');
	  	// newwin.document.write('else{\n');
	  	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	  	// newwin.document.write('}\n');
	  	newwin.document.write('}\n');
	  	newwin.document.write('function print_win(){\n');
	  	newwin.document.write('window.print();\n');
	  	newwin.document.write('chkstate();\n');
	  	newwin.document.write('}\n');

	  	newwin.document.write('<\/script>\n');
	  	newwin.document.write('</HEAD>\n');
	  	newwin.document.write('<BODY onload="print_win()">\n');
	  	newwin.document.write(document.getElementById('breakageItemDtlId').innerHTML);
	  	newwin.document.write('</BODY>\n');
	  	newwin.document.write('</HTML>\n');
	  	newwin.document.close();
		  var x = document.getElementById("printImg");
		  x.style.display = "block";

	  }
	
</script>

</head>
<body>
<html:form name="miscellaneousConsumptionBean" action="transactions/MiscellaneousConsumptionTransCNT.cnt" type="mms.transactions.controller.fb.MiscellaneousConsumptionTransFB">


							<div class="errMsg"     id="errMsg" style="font-size:18px;"><bean:write name="miscellaneousConsumptionBean" property="strErrMsg"/></div>
							<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="miscellaneousConsumptionBean" property="strWarningMsg"/></div>
							<div class="normalMsg"  id="normalMsg" style="font-size:18px;"><bean:write name="miscellaneousConsumptionBean" property="strNormalMsg"/></div> 
<div class="container-fluid">
	<div class="prescriptionTile">
            <div class='legendHeader my-2' id='nonPrintableLegend' style="font-weight:600;font-size: 18px;" >Report</div>
            <div class="legend2" id='nonPrintableLegend2'>
				<button type="button" 
					class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
					onclick="cancelFunc();" style="border-radius:50%;  padding:12px 12px" title="Cancel">
					<i class="fas fa-times fa-lg iround" title="Cancel"></i>
				</button>
				
				<button type="button" class="float-right btn btn-secondary btn-circle"
					onclick="document.forms[0].reset();"
					style="border-radius:50%; padding:12px 7px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Clear">
					<i class="fas fa-broom fa-lg iround" title="Clear"></i>
				</button>
			</div>
 
		 	<div class="row my-1">
		  		<div class="col-md-2 "><font color="red">*</font><label>Store Name</label></div>
		 		<div class="col-md-4 "><div id="storeComboID">
					     <select name="strStoreName" class="browser-default custom-select"   onChange="">
		                        <bean:write name="miscellaneousConsumptionBean" property="strStoreName" filter="false"/>
		                 </select>
		                 </div><div id="storeComboNameID" style="display:none; color:blue;"></div></div>
		 		<div class="col-md-2"><font color="red">*</font><label>CR NO</label></div>
		 		    <div class="col-md-4"><div id="ItemCatgViewId" >
					        <input type="text" class="form-control" name="strItemCatgCombo"	onkeypress="return validateData(event,18);" value="0" maxlength="15">
				          </div>  
				      <div id="itemCategViewNameID" style="display: none"></div>
		          	</div>
		 	</div>
 			
			<div class="row my-1">
				<div class="col-sm-2 ">
					<label><font color="red">*</font>From Date</label>
				</div>
				<div class="col-sm-4">
					<input  name="strFromDate"
						class="form-control datepicker"
						value="${miscellaneousConsumptionBean.strCurrentDate}"
						style="color: rgba(113, 111, 111, 0.87);">
				</div>
				<div class="col-sm-2">
					<label><font color="red">*</font>To Date</label>
				</div>
				<div class="col-sm-4">
					<input  name="strToDate"
						class="form-control datepicker"
						value="${miscellaneousConsumptionBean.strCurrentDate}"
						style="color: rgba(113, 111, 111, 0.87);">
				</div>
			</div>
	        <hr>
			<div class="row ">
				<div class="col-sm-12" align="center"> <a class="btn btn-sm btn-success" href="#" onclick="getViewItemDtl();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a></div>
			</div>
		
			<div class="row ">
		 		<div class="col-md-12 col-xs-12 px-4" align="center">
		 			<div id="breakageItemDtlId" align="center" style="display: none"></div>
		 		</div>
 			</div>
 			 
 			 
 			  <input type="hidden" name="hmode"/>
		    <input type="hidden" name="strCurrentDate" value="${miscellaneousConsumptionBean.strCurrentDate}"/>
		    
		    <div id="blanket" style="display:none;"></div>
			   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
				   <table bgcolor="white">
				     <tr>
				      <td>
				           <div id="issueDtlsDivId" style="display:block;"></div>
				       </td>
				     </tr>
				   </table>
			   </div>
 			 
 			
		</div>
		   
	</div>
				

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