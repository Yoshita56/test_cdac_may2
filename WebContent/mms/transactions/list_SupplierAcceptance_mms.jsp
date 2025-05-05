<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Drug Master</title>

<link rel="stylesheet" href="/HBIMS/mms/jqueryCSS/jquery-ui.css" type="text/css">
<link rel="stylesheet" href="/HBIMS/mms/jqGrid/css/ui.jqgrid.css" type="text/css">
<link rel="stylesheet" href="/HBIMS/mms/jqGrid/css/ui.multiselect.css" type="text/css">
<link rel="stylesheet" href="/HBIMS/hisglobal/css/dwh.css" type="text/css">
<style>


 .button 
 {
  display: inline-block;
  border-radius: 4px;
  background-color:#0F5D8F;	
  border: none;
  color: #FFF;
  text-align: center;
  font-size: 30px;
  font-weight:bold;
  padding: 8px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  /* background: -moz-linear-gradient(top,  rgba(0,150,250,0.3) 0%, rgba(0,150,250,1) 100%);
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,150,250,0.3)), color-stop(100%,rgba(0,150,250,1)));
background: -webkit-linear-gradient(top,  rgba(0,150,250,0.3) 0%,rgba(0,150,250,1) 100%);
background: -o-linear-gradient(top,  rgba(0,150,250,0.3) 0%,rgba(0,150,250,1) 100%);
background: -ms-linear-gradient(top,  rgba(0,150,250,0.3) 0%,rgba(0,150,250,1) 100%);
background: linear-gradient(to bottom,  rgba(0,150,250,0.3) 0%,rgba(0,150,250,1) 100%); */
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px; 
  -webkit-transform: scale(1.3);
	transform: scale(1.3);
}

.button:hover span:after {
  opacity: 2;
  right: 0; 
}

.disabled {
    opacity: 0.6;
    cursor: not-allowed;
}
.button {border-radius: 8px;}


.buttonS 
 {
  display: inline-block;
  border-radius: 4px;
  background-color:#335058;
  border: none;
  border-radius: 50%;
  color: #FFF;
  text-align: center;
  font-size: 10px;
  font-weight:bold;
  padding: 8px;
  width: 75px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.buttonS span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.buttonS span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.buttonS:hover span {
  padding-right: 25px; 
}

.buttonS:hover span:after {
  opacity: 2;
  right: 0; 
}

.disabled {
    opacity: 0.6;
    cursor: not-allowed;
}
.buttonS {border-radius: 8px;}

.round-button
 {
   display: inline-block;
    width:50px;
    height:50px;
    line-height:50px;
    border: 2px solid #f5f5f5;
    border-radius: 50%;
    color:#f5f5f5;
    text-align:center;
    text-decoration:none;
    background: #007BA7;
    box-shadow: 0 0 3px gray;
    font-size:20px;
    font-weight:bold;
}
.round-button:hover {
    background: #35b128;
}
#borderGrid
{
background-color : #1277b5;
border-radius : 2px 2px 2px 2px;
border-style: solid;
 border-left-width: 3px;
  border-right-width: 4px;

}

#opacity    {
    opacity : 0.4;
    filter: alpha(opacity=40); 
}

</style>


<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<!-- <script language="JavaScript" src="../../jsrptutil/tableExport.js"></script>
<script language="JavaScript" src="../../jsrptutil/jquery.base64.js"></script>

<script language="JavaScript" src="../../jsrptutil/html2canvas.js"></script>
<script language="JavaScript" src="../../jsrptutil/jspdf/libs/sprintf.js"></script>

<script language="JavaScript" src="../../jsrptutil/jspdf/jspdf.js"></script>
<script language="JavaScript" src="../../jsrptutil/jspdf/libs/base64.js"></script>	 -->





<script language="JavaScript" src="/HBIMS/mms/jqGrid/js/jquery.ui.widget.js"></script>
<script language="JavaScript" src="/HBIMS/mms/jqGrid/js/ui.multiselect.js"></script>



<script language="JavaScript" src="/HBIMS/mms/jqGrid/js/i18n/grid.locale-en.js"></script>


<script language="JavaScript" src="/HBIMS/mms/jqGrid/js/jquery.jqGrid.src.js"></script>






<script language="javaScript">


//JAVASCRIPT FUNCTIONS CALLED ON BUTTON/ACTION BUTTON CLICK
function add()
{                      
                 	   document.forms[0].hmode.value = "ADD";
                       document.forms[0].submit();         
}

function delivery(rowId)
{                                        
	var rowData = $('#photos').jqGrid('getRowData', rowId);         	
	if(rowData.status == "Delivery Pending" )
	  {
		 document.forms[0].strChk.value=rowData.po_no + "@" + rowData.storeid + "@" + rowData.supplierid+ "@" + rowData.podate+ "@" + rowData.suppaccflag+ "@" + rowData.potypeid;
		     // alert(document.forms[0].strChk.value);
         document.forms[0].hmode.value = "DELIVERYDETAIL";
         document.forms[0].submit();
	  }
else
	  {
	  alert("Only Delievery Pending record Can be Delivered");
	  return false;
	  }  
		
         
}

function accept(rowId)
{                                        
	var rowData = $('#photos').jqGrid('getRowData', rowId);         	
	if( rowData.status == "Acceptance Pending")
	  {
		 document.forms[0].strChk.value=rowData.po_no + "@" + rowData.storeid + "@" + rowData.supplierid+ "@" + rowData.podate+ "@" + rowData.suppaccflag+ "@" + rowData.potypeid;
		 //alert(document.forms[0].strChk.value);
        document.forms[0].hmode.value = "ACCEPTANCE";
        document.forms[0].submit();
	  }
else
	  {
	  alert("Record Cannot be accepted!");
	  return false;
	  }  
		
         
}



function view(rowId)
{                                        
                   
	//alert("view");
		  var rowData = $('#photos').jqGrid('getRowData', rowId);
		  document.forms[0].strChk.value=rowData.po_no + "@" + rowData.storeid + "@" + rowData.supplierid+ "@" + rowData.podate+ "@" + rowData.suppaccflag+ "@" + rowData.potypeid;
		    //alert(document.forms[0].strChk.value);
          document.forms[0].hmode.value = "VIEW";
          // alert(document.forms[0].strChk.value);
          document.forms[0].submit();
         
}

function letter(rowId)
{                                        
                    	
		  var rowData = $('#photos').jqGrid('getRowData', rowId);
		 // alert("------Test-------------------------"+rowData);   
		  document.forms[0].strChk.value=rowData.po_no + "@" + rowData.storeid + "@" + rowData.supplierid+ "@" + rowData.podate+ "@" + rowData.suppaccflag+ "@" + rowData.potypeid;
		  // alert(document.forms[0].strChk.value);
          document.forms[0].hmode.value = "PRINT";
          document.forms[0].submit();
         
}  

  function getReport()
		  {     // alert("inreport");                            
		  	document.forms[0].strChk.value = document.forms[0].suppliername.value + "^"  + document.forms[0].prefixpono.value + "^" + document.forms[0].podate.value + "^" + document.forms[0].orderdqty.value + "^" + document.forms[0].balanceqty.value + "^" + document.forms[0].itemname.value + "^" + document.forms[0].status[document.forms[0].status.selectedIndex].text;
		  	//alert(document.forms[0].strChk.value);
		     document.forms[0].hmode.value = "GETREPORT";
		      document.forms[0].submit();
		           
		  }
		 
         

 $(document).ready(function()
  {
	// alert("in jsp");
         
	 $("#photos").on("jqGridAfterLoadComplete", function () {
		 
		 maximizeGrid();	
		  
		})
         
	     .jqGrid({
	     ajaxGridOptions : {type:"POST"}, 
	     serializeGridData : function(postdata) 
	     { 
	        postdata.page = 1; 
	        return postdata; 
	     },
	     url: '../../mms/transactions/SupplierDeskInterfaceTransCNT.cnt?hmode=SupplierInterfaceDATA',
	     datatype: "json",			
		 editurl:'../../mms/transactions/SupplierDeskInterfaceTransCNT.cnt',
		 
		 //Column Header
		 colNames : [ 'Po no','Store Id','Supplier Id','Supplier Name','PO No.', 'PO Date', 'Supp Acc Flag','PO Type ID','Predelivery Flag' ,'Ordered Qty.','Balance Qty.','Item Name','Status','Action'],
		 
		 //Column Attributes
		 colModel : [ 
		    
		
		{
		name : 'po_no',
		index : 'po_no',
		width :5,
		editable : false,
		hidden: true
		}, 
		{
			name : 'storeid',
			index : 'storeid',
			width :5,
			editable : false,
			hidden: true
			},
		{
			name : 'supplierid',
			index : 'supplierid',
			width : 5,
			editable : false,
			hidden : true
			}, 
		{
   			name : 'suppliername',
   			index : 'suppliername',
   			width : 20,
   			editable : false,
   			align : 'center'
   		}
		 ,
           {
   			name : 'prefixpono',
   			index : 'prefixpono',
   			width : 20,
   			editable : false,
   			align : 'center'
   		},
   		{
			name : 'podate',
			index : 'podate',
			width : 10,
			editable : false,
			align : 'center',
			sortable:false
			
		},
		  {
   			name : 'suppaccflag',
   			index : 'suppaccflag',
   			width :5,
   			editable : false,
   			hidden: true
   		},
   		{
   			name : 'potypeid',
   			index : 'potypeid',
   			width : 5,
   			editable : false,
   			hidden: true
   		}, 
   		{
   			name : 'predeliveryflag',
   			index : 'predeliveryflag',
   			width : 5,
   			editable : false,
   			hidden: true
   		}, 
   		{
   			name : 'orderdqty',
   			index : 'orderdqty',
   			width : 10,
   			editable : false,
   			align : 'center'
   		}, 
   		{
			name : 'balanceqty',
			index : 'balanceqty',
			width : 10	,
			editable : false,
			align : 'center'
		},
		{
			name : 'itemname',
			index : 'itemname',
			width : 35,
			editable : false,
			align : 'center'
		},
	
		{
			name : 'status',
			index : 'status',
			width :12,
			editable : false,
			align : 'center'
			
			
			
		},
		
		
		 
		{
			name:'act',index:'act', width:13,sortable:false,searchoptions:  { sopt:[''] },search:false,viewable: false
				
		}  
		
		],
		
		//FOR POPULATING DROPDOWNS
		beforeProcessing: function (data) 
		{
			//Supplier acceptance status dropdown
	    	var acceptanceStatusMap = {}, 
	    	acceptanceStatusValues = "",
	    	rows = data.rows, i, acceptancestatus;
	      for (i = 0; i < rows.length; i++) 
	        {
	    	  acceptancestatus = rows[i].acceptanceStatusValue; //name of the column
	            if (!acceptanceStatusMap.hasOwnProperty(acceptancestatus)) 
	            {
	            	acceptanceStatusMap[acceptancestatus] = 1; 
	            	if(acceptancestatus)
	            	acceptanceStatusValues +=  acceptancestatus + ":" + acceptancestatus + ";" ;
	            }
	        }
	      
	      acceptanceStatusValues += ":All";
	      
	        $(this).jqGrid("setColProp", 'acceptanceStatusValue', { stype: "select",  searchoptions: { 	value: acceptanceStatusValues } }).jqGrid('destroyFilterToolbar') .jqGrid('filterToolbar', {
	            stringResult: true,
	            searchOnEnter: false,
	            defaultSearch : "cn",	          
			    formatoptions: { value: 'Select', defaultValue: 'Pending' }
	        });
	        
	      
	        //status dropdown
	    	var statusMap = {}, 
	    	//statusValues = "",
	    	statusValues = ":All",
	    	rows = data.rows, i, status;
	      for (i = 0; i < rows.length; i++) 
	        {
	    	  status = rows[i].status //name of the column
	            if (!statusMap.hasOwnProperty(status)) 
	            {
	            	statusMap[status] = 1; 
	            	if(status)
	            	statusValues += ";" +  status + ":" + status ;
	            }
	        }
	      
	     // statusValues += ":All";
	      
	      
	        $(this).jqGrid("setColProp", 'status', { stype: "select",  searchoptions: { 	value: statusValues } }).jqGrid('destroyFilterToolbar') .jqGrid('filterToolbar', {
	            stringResult: true,
	            searchOnEnter: false,
	            defaultSearch : "cn",	          
			    formatoptions: { value: 'Select', defaultValue: 'Active' }
	        });
	             
	       
	    },	    
		rowNum:10,  //no. of rows per page
		loadonce: true,		
		rowList:[10,20,30],  //to change no. of rows per page to 10,20 or 30
		pager: '#pager2',
		sortname: 'po_no', 
		rownumbers: false,
		viewrecords: true,
		sortorder: "asc",
		caption:"Supplier Interface Desk",
		sortIconsBeforeText: true,		
		editable: false, 
		ignoreCase: true,
		footerrow : true,
		userDataOnFooter : true,
		
		
		
    autowidth: true,
    height: 'auto',
    cmTemplate: {
        autoResizable: true
    },
    autoresizeOnLoad: true,
    autoResizing: {
        compact: true,
        resetWidthOrg: true
    },
    
      //function to display error as alert
         loadError : function(xhr,st,err) 
          { 
               jQuery("#rsperror").html("Type: "+st+"; Response: "+ xhr.status + " "+xhr.statusText); //similar to alert
          }    ,
          toolbar: [true,"top"] ,
           jsonReader : {
          root: "rows",
          page: "page",
          total: "total",
          records: "records",
          repeatitems: false,
          cell: "cell",
          id: "po_no"  //unique for every row
      },
      
       gridComplete: function()
          { 
               var ids = jQuery("#photos").jqGrid('getDataIDs');     
               
              // alert(ids.length);
              
               
               
               var rows = $("#photos").getDataIDs(); 
               
               //alert(rows.length);
               
               for(var i=0;i < ids.length;i++)
               {
                  var cl = ids[i]; //acceptance id
                  var status = $("#photos").getCell(rows[i],"status");
                  var acceptancestatus = $("#photos").getCell(rows[i],"acceptanceStatusValue");
                  if(status == "Acceptance Pending")
                	  {
                	  //acceptaction = "<img src='../../hisglobal/images/Re-Approval3.png' width='15px' onclick='Finalize(\""+ cl+ "\");' title='Finalize' style='vertical-align:right;cursor:pointer;'></img>";
                	  acceptaction = "<img src='../../hisglobal/images/acceptance.png' width='25px'  onclick='accept(\""+ cl+ "\");'title='Acceptance' style='vertical-align:right;cursor:pointer;'></img>";
                	  deliveryaction = "<img id='opacity' src='../../hisglobal/images/Delivery_ok.png' width='25px' onclick='delivery(\""+ cl+ "\");' title='Delivery' style='vertical-align:right;cursor:pointer;'></img>"; 
                      
                	  viewaction = "<img src='../../hisglobal/images/view.png' width='25px' onclick='view(\""+ cl+ "\");'  title='View' style='vertical-align:right;cursor:pointer;'></img>";
                	  //extendaction = "<img id='opacity' src='../../hisglobal/images/edit.png' width='15px' onclick='extend(\""+ cl+ "\");'  title='Extend' style='vertical-align:right;cursor:pointer;'></img>";
                      letteraction = "<img src='../../hisglobal/images/print.gif' width='25px' onclick='letter(\""+ cl+ "\");'  title='Print' style='vertical-align:right;cursor:pointer;'></img>";
                      
                      jQuery("#photos").jqGrid('setRowData',ids[i],{act:acceptaction +"  "+deliveryaction + " "+viewaction+" " + letteraction}); 
                	   }
                  
                  if(status == "Delivery Pending")
            	  {
            	  //acceptaction = "<img id='opacity' src='../../hisglobal/images/Re-Approval3.png' width='15px' onclick='Finalize(\""+ cl+ "\");' title='Accept' style='vertical-align:right;cursor:pointer;'></img>";
            	  acceptaction = "<img id='opacity' src='../../hisglobal/images/acceptance.png' width='25px'  onclick='accept(\""+ cl+ "\");'title='Acceptance' style='vertical-align:right;cursor:pointer;'></img>";
            	  deliveryaction = "<img  src='../../hisglobal/images/Delivery_ok.png' width='25px' onclick='delivery(\""+ cl+ "\");' title='Delivery' style='vertical-align:right;cursor:pointer;'></img>"; 
                  
            	  viewaction = "<img src='../../hisglobal/images/view.png' width='25px' onclick='view(\""+ cl+ "\");'  title='View' style='vertical-align:right;cursor:pointer;'></img>";
                   //extendaction = "<img src='../../hisglobal/images/edit.png' width='15px' onclick='extend(\""+ cl+ "\");'  title='Extend' style='vertical-align:right;cursor:pointer;'></img>";
                  letteraction = "<img src='../../hisglobal/images/print.gif' width='25px' onclick='letter(\""+ cl+ "\");'  title='Print' style='vertical-align:right;cursor:pointer;'></img>";
                  
                  jQuery("#photos").jqGrid('setRowData',ids[i],{act:acceptaction +"  "+deliveryaction + " "+viewaction+" " + letteraction}); 
            	    }
                  
                  if(status == "Rejected" || status == "Closed" || status == "Delivery Done" || status == "NA")
                	  {
                	  //acceptaction = "<img id='opacity' src='../../hisglobal/images/Re-Approval3.png' width='15px' onclick='Finalize(\""+ cl+ "\");' title='Accept' style='vertical-align:right;cursor:pointer;'></img>";
                	  acceptaction = "<img id='opacity' src='../../hisglobal/images/acceptance.png' width='25px'  onclick='accept(\""+ cl+ "\");'title='Acceptance' style='vertical-align:right;cursor:pointer;'></img>";
                	  deliveryaction = "<img id='opacity' src='../../hisglobal/images/Delivery_ok.png' width='25px' onclick='delivery(\""+ cl+ "\");' title='Delivery' style='vertical-align:right;cursor:pointer;'></img>"; 
                      
                	  viewaction = "<img src='../../hisglobal/images/view.png' width='25px' onclick='view(\""+ cl+ "\");'  title='View' style='vertical-align:right;cursor:pointer;'></img>";
                	  //extendaction = "<img id='opacity' src='../../hisglobal/images/edit.png' width='15px' onclick='extend(\""+ cl+ "\");'  title='Extend' style='vertical-align:right;cursor:pointer;'></img>";
                      letteraction = "<img src='../../hisglobal/images/print.gif' width='25px' onclick='letter(\""+ cl+ "\");'  title='Print' style='vertical-align:right;cursor:pointer;'></img>";
                      
                      cancelaction = "<img  src='../../hisglobal/images/cancel.png' width='25px'  onclick='deleteRecord(\""+ cl+ "\");'title='Delete' style='vertical-align:right;cursor:pointer;'></img>"; }
                  
                  jQuery("#photos").jqGrid('setRowData',ids[i],{act:acceptaction +"  "+deliveryaction + " "+viewaction+" " + letteraction}); 
            	  
                 }
               
              
          },    
	});	
	 
		 
	 //BUTTONS
	 //$("#t_photos").append("<button class='button' onClick='add();'  style='vertical-align:middle'><span>ADD</span></button>");
	 $("#t_photos").append("<button class='button' onClick='getReport();'  style='vertical-align:middle'><span>REPORT</span></button>");
	 

	  jQuery("#photos").jqGrid('filterToolbar',{
		    searchOnEnter: false,
		    autosearch:true,
		    //ignoreCase: true,
		    searchOperators: true
		});
		
		jQuery("#photos").jqGrid('navGrid','#pager2',
    {edit:false,add:false,del:false,search:false,view : true,cloneToTop: true},
    { },
          { },
          { }, 
    { 
        sopt:['eq', 'ne', 'lt', 'gt', 'cn', 'bw', 'ew'],
           closeOnEscape: true, 
            multipleSearch: true, 
             closeAfterSearch: true }
  );
		
		jQuery("#photos").jqGrid('navButtonAdd', '#pager2', { caption: "", buttonicon: "ui-icon-calculator", title: "choose columns",
            onClickButton: function () {
            	
            	jQuery("#photos").jqGrid('columnChooser',{
					width: 550, 
					dialog_opts: {
						modal: true,
						minWidth: 470,
						height: 470,
						show: 'blind',
						hide: 'explode',
						dividerLocation: 0.5
					},
					done : function (perm) {
					      if (perm) {
					    	  maximizeGrid();
					      }
					}
            	}
            	);
            	
            	
            }
        });
		
		maximizeGrid = function() {
	        var newWidth = $("#photos").closest(".ui-jqgrid").parent().width();
	        jQuery("#photos").jqGrid("setGridWidth", newWidth, true);
	    };
	    
	    
		 $(window).on("resize", maximizeGrid); 
	  	
   
   	 
        
       
	function commonError(data) {
        return "Error Occured during Operation. Please try again";
    }
	function EditPost(params) {
		//Here you need to define ajax call for update records to server
		console.log(params);
	}
	function AddPost(params) {
		//Here you need to define ajax call for insert records to server
		console.log(params);
	}
	function DeletePost(params) {
		//Here you need to define ajax call for delete records to server
		console.log(params);
	}
  });


 
 
</script>
</head>
<body>
<html:form action="/transactions/SupplierDeskInterfaceTransCNT"   name="supplierDeskTransBean"	type="mms.transactions.controller.fb.SupplierDeskInterfaceTransFB" styleClass="formbg">
    	<div class="errMsg" id="errMsg">
				<bean:write name="supplierDeskTransBean" property="strErr" />
			</div>
			<div class="warningMsg" id="warningMsg">
				<bean:write name="supplierDeskTransBean" property="strWarning" />
			</div>
			<div class="normalMsg" id="normalMsg">
				<bean:write name="supplierDeskTransBean" property="strMsg" />
			</div>
   
    <!-- <b>Response:</b> <span id="rsperror" style="color:red">OK</span> <br/> -->
    
    <div id='borderGrid'>
	<table id="photos" class="display" cellspacing="0" width="100%">
    </table>
	<div id="pager2"></div>
	</div>
	
	
		
	<input type="hidden" name="hmode" />
<%-- 	<input type="hidden" name="strStoreId" value="${supplierDeskTransBeanJqgrid.strStoreId}" />
	<input type="hidden" name="strStoreName" value="${supplierDeskTransBeanJqgrid.strStoreName}" /> --%>
	<input type="hidden" name="strChk" />

	</html:form>
</body>
</html>