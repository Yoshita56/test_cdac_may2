/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/

$(function() {	
	 
		loadAutocompleteItems();
	 
});
 
function loadAutocompleteItems(){
	$('#strSearchDrug').val("");
	displaySelectedDrug("strItemId");
	
	var itemList = [];
	$('#strItemId option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value });
	});

	$('#strSearchDrug').autocomplete({
	   lookup: itemList,
	   minChars:3,
	   onSelect: function (suggestion) {        
	     getDrugNameSelected(suggestion.data,"strItemId");	     
	     getDrugNameSelectedInLeftBox(suggestion.data,"strLeftItemIds");	     
	   }	    
	 });
	 
	 $('#strSearchDrug').click(function(){	 
	 	$(this).val("");
	 });	
}

  

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
	 var wt='<div id="qmvi_loading_div" style="top:'+tpos+'px;left:'+lpos+'px;height:'+qh+'px;width:'+qw+'px;position:absolute;text-align:center;font-family:Arial;text-decoration:none;font-weight:normal;font-size:13px;color:#00224A;background-color:#ffffff;border-width:1px;border-color:#828EA2;border-style:solid;">';
	 wt+='<div style="padding:20px;"><img src="../../hisglobal/images/loading.gif" width=16 height=16><br><br><font size="2" weight="bold">Fetching Detail(s).Please Wait!</font></div>';
	 wt+='</div>';
	 
	 document.getElementById("normalMsg").innerHTML=wt;
	  document.getElementById("normalMsg").style.display = "block";
	 }





function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="FTDStockLedgerRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"5");
	 	}else{
		document.forms[0].strItemCatNo.value="0";
		document.forms[0].strGroupId.value="0";
		document.forms[0].strItemId.value="0";
	}
}	

function getGroupCmb(){ 
	
	

	if(document.forms[0].strItemCatId.value!=0){
		var url ="FTDStockLedgerRptCNT.cnt?hmode=GROUPCMB&itemCatId="+document.forms[0].strItemCatId.value;
 		ajaxFunction(url,"2");
 		}else{
		document.forms[0].strGroupId.value="0";
		document.forms[0].strItemId.value="0";
	}
}	

function getItemCmb(){ 
		//alert("inside grp");
		var url ="FTDStockLedgerRptCNT.cnt?hmode=ITEMCMB&groupId="+document.forms[0].strGroupId.value+"&storeId="+document.forms[0].strStoreId.value+"&itemCatId="+document.forms[0].strItemCatId.value;
 		//alert("url"+url);
		ajaxFunction(url,"3");
}

function getAjaxResponse(res,mode){
	
	if(mode=="1")
	{     
			var objVal= document.getElementById("stockLedgerDetailDivId");
			objVal.innerHTML = res;		
			document.getElementById("stockLedgerDetailDivId").style.display='';
			document.getElementById("showButtonID").style.display='';
			document.getElementById("normalMsg").style.display="none";//hiding loading img
			
			view2('itemManagePlusId','itemManageMinusId','itemManageDtlId1','itemManageDtlId2');
	}	
	
	if(mode=="2"){ 
			var objVal= document.getElementById("groupDivId");
			objVal.innerHTML = "<select name ='strGroupId' id ='strGroupId1' class='custom-select' onchange='getItemCmb();'>"+res+"</select>";	
			getItemCmb();
	}	
	if(mode=="3"){ 
		//alert(res);
		
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='10' multiple style='width: 560px' onChange='showSelection(this);' >"+res+"</select>";
		
	}
	if(mode=="4"){ 
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='10' multiple style='width: 560px' onChange='showSelection(this);' >"+res+"</select>";
			
			
			var objVal1= document.getElementById("itemDivId");
			objVal1.innerHTML = "<select id='strItemId' name='strItemId' class='custom-select'  >"+res+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';
					
	}
	
	if(mode=="5"){ 
		
		
		var objVal= document.getElementById("catDivId");
		objVal.innerHTML = "<select name ='strItemCatId' id='strItemCatId1' class='custom-select' onchange='getGroupCmb();'>"+res+"</select>";		
	
}	
}
	
function cancelPage(){
	showMenuFrame();
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function clearPage(){


		//document.forms[0].strItemId.value="0";
		document.forms[0].strStoreId.value="0";
		document.getElementsByName("strWhetherBatchWise")[0].checked=false;
		document.getElementsByName("strValueWise")[0].checked=false;
		//document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value;
		document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value;
		document.getElementById("showButtonID").style.display="none";
		document.getElementById("stockLedgerDetailDivId").style.display="none";
		document.forms[0].selPageIndex.value = "1";
		
		//document.getElementById("strFromDate1").style.display='';
		//document.getElementById("strToDate1").style.display='';
		document.getElementById("generateId").style.display='';
		document.getElementsByName("strWhetherBatchWise")[0].readOnly = false;
		document.getElementsByName("strValueWise")[0].readOnly = false;
		
		

		//displaySelectedDrug("strItemId");
		
		document.forms[0].hmode.value='unspecified';
		document.forms[0].submit();
		
		
		
}


function onLoadPage(){
		
	//	document.forms[0].strStoreId.value="0";
		//document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value;
		document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value;

}


function validate()
{

        var objVal= document.getElementById("stockLedgerDetailDivId");
			objVal.innerHTML = "";
			document.getElementById("stockLedgerDetailDivId").style.display="none";
			document.getElementById("showButtonID").style.display="none";
					 
	    var hisValidator = new HISValidator("stockLedgerBean");
	
		if( (document.getElementsByName("strStoreId")[0].value=='0') )
		{
			alert("Please Select Store Name");
				return false;
		}
		
		if( (document.getElementsByName("strItemCatId")[0].value=='0') )
		{
			alert("Please Select Category Name");
				return false;
		}
		
		if( (document.getElementsByName("strStoreId")[0].value==0) && (document.getElementsByName("strItemId")[0].value==0) )	
		{
			alert("Please Select atleast one of Store Name or Drug Name");
			document.getElementById("strLeftItemIds").focus();
			return false;
		}
		
		//alert("Length-->>"+document.forms[0].strRightItemIds.length);
		var itmeLength = parseInt(document.forms[0].strRightItemIds.length);
		if(itmeLength>0)
		{	
			var itemBrandIds = [];
			$('#strRightItemIds option').each(function() { 
			    itemBrandIds.push( $(this).val() );
			});	
			document.forms[0].strItemBrandId.value = 	itemBrandIds;	   
		}
		else
		{
			document.forms[0].strItemBrandId.value = "0";
		}
		//alert("Brand Id-->>"+document.forms[0].strItemBrandId.value);
		hisValidator.addValidation("strStoreId", "dontselect=0","Please Select Store Name.");
		//hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select From Date Less Than Or Equal To Date");
	
		var dateDiff = dateDifferenceInDays(document.getElementsByName("strFromDate")[0].value,document.getElementsByName("strToDate")[0].value)+1;
		if(dateDiff>365)
		{
			alert("Difference between From Date and To Date should not be greater than 365 days");
			return false;			
		}
		
		//hisValidator.addValidation("strFromDate","dtgtet="+"01-Apr-2012","Please Select From Date Greater Than or Equal To 01-Apr-2012");
		
	
	    var retVal = hisValidator.validate();
	    hisValidator.clearAllValidations();
	
		if(retVal){
		
		
					document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
					
					 var batchFlag,valueFlag;
					 
					 if(document.getElementsByName("strWhetherBatchWise")[0].checked==true)
					 {
					 	batchFlag = '1';
					 }
					 else
					 {
					 	batchFlag = '0';
					 }
					 /*
					 if(document.getElementsByName("strValueWise")[0].checked==true)
					 {
						 valueFlag = '1';
					 }
					 else
					 {
						 valueFlag = '0';
					 }
					 */
					 valueFlag = '0';
				
					var mode="getStockLedgerDtl";
					/*
					var url="FTDStockLedgerRptCNT.cnt?hmode="+mode+
					"&storeId="+document.forms[0].strStoreId.value+
					"&itembrandId="+document.forms[0].strItemBrandId.value+
					"&batchFlag="+batchFlag+
					"&fromDate="+document.forms[0].strJobInitialDate.value+"&toDate="+document.forms[0].strToDate.value+
					"&storeName="+document.forms[0].strStoreName.value+
					"&strItemCatId="+document.forms[0].strItemCatId.value+
					"&strgroupId="+document.forms[0].strGroupId.value+"&valueFlag="+valueFlag;	
					*/	
					
					var url="FTDStockLedgerRptCNT.cnt?hmode="+mode+
					"&storeId="+document.forms[0].strStoreId.value+
					"&itembrandId="+document.forms[0].strItemBrandId.value+
					"&batchFlag="+batchFlag+
					"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+
					//"&fromDate=01-Apr-"+fY.split("-")[0]+"&toDate="+document.forms[0].strToDate.value+	
					"&storeName="+document.forms[0].strStoreName.value+
					"&strItemCatId="+document.forms[0].strItemCatId.value+
					"&strgroupId="+document.forms[0].strGroupId.value+"&valueFlag="+valueFlag+
					"&strJobInitialDate="+document.forms[0].strJobInitialDate.value;
					
					document.getElementById("generateId").style.display='none';
					
					document.getElementsByName("strWhetherBatchWise")[0].readOnly = true;
					//document.getElementsByName("strValueWise")[0].readOnly = true;

					document.getElementById("storeNameDivId").style.display='';
					document.getElementById("storeDivId1").disabled = true;
					document.getElementById("strItemCatId1").disabled = true;
					document.getElementById("strGroupId1").disabled = true;
					document.getElementById("itemManageDtlId2").style.display = "none";
					loading_msg();	
					//alert(url);
					ajaxFunction(url,"1");
		}
		else
		{
			return false;
		}
}

/**
 * 
 */
function printItemDetailedStockLedgerReport(obj)
{	  
    	  
         
         /* Value Pass in Web Row Set
		  1.	TRANS_DATE
		  2.	PARTICULARS	
		  
		  3.	ACTIVE_ISSUE	
		  4.	INACTIVE_ISSUE	
		  5.	QUARTINE_ISSUE
		  	
		  6.	ACTIVE_REC	
		  7.	INACTIVE_REC	
		  8.	QUARTINE_REC
		  	
		  9.	STR_NAME	
		  10.	ITEM_NAME	
		  11.	HSTSTR_BATCH_SL_NO

          	 */    	  	 
	 	
	    	
	   
	   var previousParameters = document.getElementsByName("strHiddenParameter")[0].value;
	   
	   
	   var storeId 		= 	previousParameters.split("^")[0];  	
	   var itemBrandId  = 	previousParameters.split("^")[1]; 
	   var batchNo 		=	previousParameters.split("^")[4];
	   
	   var fromDate		=	previousParameters.split("^")[2];
	   var toDate		=	previousParameters.split("^")[3];
	   
	   var storeName	=	previousParameters.split("^")[6]; 
	   
	   var op_balance	=	previousParameters.split("^")[5];
	   var batchFlg     = 	previousParameters.split("^")[8];
	 	
	   var mode="printDetailedStockLedgerReport";
	   var url="FTDStockLedgerRptCNT.cnt?hmode="+mode+
			"&storeId="+storeId+
			"&itembrandId="+itemBrandId+
			"&batchNo="+batchNo+
			"&fromDate="+fromDate+
			"&toDate="+toDate+
			"&storeName="+storeName+			
			"&openingBalanceActive="+op_balance.split("#")[0]+
			"&openingBalanceInActive="+op_balance.split("#")[1]+
			"&openingBalanceQuarantine="+op_balance.split("#")[2]+
			"&batchFlg="+batchFlg;								
	  	 alert(url);
	//window.close(); 
	
	window.open(url, "popupWindow",	"width=1000,height=600,top=250,left=100,scrollbars=yes");
	
}



function GetIndex(index,record_page)  // Pagenation  One
{
	var trObj;
	var oldIndex = document.forms[0].selPageIndex.value;
    var oldPageAnchor = document.getElementById('pg'+oldIndex);   // Apply CSS
    oldPageAnchor.className = 'pg-normal';
    
    var newPageAnchor = document.getElementById('pg'+index);   // Apply CSS
    newPageAnchor.className = 'pg-selected';
    document.forms[0].selPageIndex.value = index;
    
    for(var i = 1; i <= record_page + 1 ; i++)
    {
    	trObj = document.getElementById("tr"+oldIndex + "-" + i);
    	
    	if(trObj || trObj != null)
    		trObj.style.display="none";
    	else
    		break;	
    }
    
    for(var i = 1; i <= record_page + 1 ; i++)
    {
    	trObj = document.getElementById("tr"+index + "-" + i);
    	if(trObj || trObj != null)
    		trObj.style.display='';
    	else
    		break;	
    }

}


function GetIndex1(index,endVal)  // Pagenation  One
{
	
	 if(index == document.forms[0].TotalLayer1.value)
	 {
	      document.getElementById("closingDiv").style.display="block";
	  
	 }
	 else
	 {
	     document.getElementById("closingDiv").style.display="none";
	 }
	   //alert("Index::::"+index);
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg1'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg1'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId1"+i).style.display="none";
		  }
		  document.getElementById("DivId1"+index).style.display="block";
		
			 
}



//To open View Page
function openViewPage()
{
	viewData(document.forms[0]);
	//document.getElementsByName("strViewCheckBox")[0].checked=false;
}

function viewData(form1) //View Page
{


					//document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
					//document.forms[0].strDrugName.value = document.forms[0].strItemId[document.forms[0].strItemId.selectedIndex].text;
					
					//alert("strStoreName"+document.forms[0].strStoreName.value );
					//alert("strDrugName"+document.forms[0].strDrugName.value );
					
					 var batchFlag,valueFlag;
					 
					 if(document.getElementsByName("strWhetherBatchWise")[0].checked==true)
					 {
					 	batchFlag = '1';
					 }
					 else
					 {
					 	batchFlag = '0';
					 }
					 /*
					 if(document.getElementsByName("strValueWise")[0].checked==true)
					 {
						 valueFlag = '1';
					 }
					 else
					 {
						 valueFlag = '0';
					 }
					 */
					 valueFlag = '0';

					var mode	=	'getConsolidatedStockLedgerRpt';
			
					
					var url="FTDStockLedgerRptCNT.cnt?hmode="+mode+
					"&storeId="+document.forms[0].strStoreId.value+
					"&itembrandId="+document.forms[0].strItemBrandId.value+
					"&batchFlag="+batchFlag+
					"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+
					"&storeName="+document.forms[0].strStoreName.value+
					"&strItemCatId="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].value+
					"&strgroupId="+document.forms[0].strGroupId.value+"&valueFlag="+valueFlag+
					"&strJobInitialDate="+document.forms[0].strJobInitialDate.value;
			alert("url");		
					
			window.open(createFHashAjaxQuery(url), "popupWindow",	"width=1000,height=600,top=250,left=100,scrollbars=yes");
	
	
}


function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("suppPerformanceDtlsDivIdMain").innerHTML = "";			
		  hide_popup('popUpDivMain');
		} 

}

function printThis()
{
	var divObj = document.getElementById("saveId");
	
	divObj.style.display="none";
	window.print();
	divObj.style.display="block";
}
function generateXLS() {
    const table = document.querySelector('table');
    const wb = XLSX.utils.table_to_book(table, { sheet: "Sheet1" });
    XLSX.writeFile(wb, 'StockLedger_data.xlsx');
}
/**
 * Prints the report.
 * @return
 */
function printData(mode) 
{

	newwin = window.open('', 'printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	
	newwin.document.write('window.close();\n');

	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	



/**
 * 
 */
function chkBoxClick(obj,index)
{	  
	  	 /* Value Pass in Web Row Set		 
		  	1  HSTNUM_MONTH, 
			2  HSTNUM_YEAR,
			3  HSTNUM_STORE_ID,
			4  HSTNUM_ITEMBRAND_ID,
			5  STR_NAME, 
			6  ITEM_NAME, 
			7  BATCH_NO,
			8  HSTSTR_ACTIVE_OPBALANCE_QTY, 
			9  HSTSTR_QUAR_OPBALANCE_QTY, 
			10 HSTSTR_REJ_OPBALANCE_QTY, 
          	 */    	   	
	    	 
	   var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	   
	   var itemBrandId  = 	hiddenVal.split("^")[0]; 
	   var batchNo 		=	hiddenVal.split("^")[1];
	   //var fromDate	=	document.forms[0].strJobInitialDate.value;
	   var fromDate		=	document.forms[0].strFromDate.value;
	   var toDate		=	document.forms[0].strToDate.value;
	   var op_balance_active		=	hiddenVal.split("^")[2];
	   var op_balance_quarintine	=	hiddenVal.split("^")[3];
	   var op_balance_inactive		=	hiddenVal.split("^")[4];
	   var storeId = document.forms[0].strStoreId.value;
	   
	   var totIssueRecVal = parseInt(document.getElementById("totIssueRecQty"+index).value); 
	   
	   if(totIssueRecVal > 0)
	   {	   
		   /*
		   var mode="getDetailedStockLedgerDtl";
			var url="FTDStockLedgerRptCNT.cnt?hmode="+mode+
				"&storeId="+storeId+
				"&itembrandId="+itemBrandId+
				"&batchNo="+batchNo+
				"&fromDate="+fromDate+
				"&toDate="+toDate+
				"&openingBalanceActive="+op_balance_active+
				"&openingBalanceInActive="+op_balance_inactive+
				"&openingBalanceQuarantine="+op_balance_quarintine;
				*/
			
			
			var mode="getDetailedStockLedgerDtl";
			var url="FTDStockLedgerRptCNT.cnt?hmode="+mode+
				"&storeId="+storeId+
				"&itembrandId="+itemBrandId+
				"&batchNo="+batchNo+
				"&fromDate="+fromDate+
				"&toDate="+toDate+				
				"&openingBalanceActive="+op_balance_active+
				"&openingBalanceInActive="+op_balance_inactive+
				"&openingBalanceQuarantine="+op_balance_quarintine+
				"&strJobInitialDate="+document.forms[0].strJobInitialDate.value;
	
		window.open(createFHashAjaxQuery(url), "popupWindow",	"width=1200,height=600,top=100,left=50,scrollbars=yes");
	   }
	   else
	   {
	   		alert("No Data To Display !!");
	   		return false;
	   }
	   	
}





function getDrugName()
{
	
	    var url ="FTDStockLedgerRptCNT.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatId.value+
		         "&groupId="+document.forms[0].strGroupId.value+
		         "&itemType="+document.forms[0].strItemType.value+"&section="+document.forms[0].strSectionId.value;	    

	   			  ajaxFunction(url,"4");
}

function getDrugNameSelectedInLeftBox(itemId, selectId)
{	
	var flag = 0;
	var sel = document.getElementById(selectId);
	
	for (i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value == itemId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchDrug.value = "";
	}
	else
	{
		showSelection(sel);		
	}	    
	 
}		


function LeftListTransfer()
{	
	//shiftToRightLimit("strLeftItemIds","strRightItemIds",1,25);
   // $('#strItemId').html($('#strLeftItemIds').html()); 
   // loadAutocompleteItems();          
    
    var ob1=document.forms[0].strLeftItemIds.value;
	 var ob=document.getElementById("strLeftItemIds");
	 shiftToRight("strLeftItemIds","strRightItemIds",1);
}

function transferToLeft()
{        
    shiftToLeft("strLeftItemIds","strRightItemIds",1);
    $('#strItemId').html($('#strLeftItemIds').html()); 
    loadAutocompleteItems();         
}

function showSelection(obj)
{
	 var selectedItems ;
	 var count =0;
	 for (var i = 0; i < obj.options.length; i++)
	 {
	 	if (obj.options[ i ].selected) 
	 	{	 		
 				selectedItems	= obj.options[ i ].text; 			
	 	}
	 } 
	 
	 
	 document.getElementById("txtFromLeftMutltiSelectCombo").style.display='';
	 document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML = selectedItems;  
}


function view1(id1,id2,id3,id4)
{
	
	
	document.getElementById(id1).style.display="none";
	document.getElementById(id2).style.display="block";
	document.getElementById(id3).style.display="block";
	document.getElementById(id4).style.display="block";
}
function view2(id1,id2,id3,id4)
{
	document.getElementById("storeDtlsDivId").innerHTML	= "Store : "+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
															
	document.getElementById(id1).style.display="block";
	document.getElementById(id2).style.display="none";
	document.getElementById(id3).style.display="none";
	document.getElementById(id4).style.display="none";
}

function generatePdf(dataDivId) 
{
	//alert("generateIssueReportPdf issueDetails_util");
	var printImg = document.getElementById("printImg").innerHTML;	
	document.getElementById("printImg").innerHTML = "";
	var dataDivObj="";
	
	if(document.getElementById(dataDivId) !=null)
	{		
		dataDivObj = document.getElementById(dataDivId);			
	}
	else
	{		
		alert("No data to convert in pdf format!");					 
	}	
	
	if (dataDivObj.innerHTML != "") {
				
		document.forms[0].strHtmlCode.value = innerXHTML(dataDivObj);		
		document.forms[0].hmode.value = "generatePdf";
		document.forms[0].submit();
		document.getElementById("printImg").innerHTML = printImg;
		document.forms[0].strHtmlCode.value = "";			

	} else {		
		alert("No data to convert in pdf format!");
	}
}

function generateXLS(e,dataDivId)
{
	//document.forms[0].hmode.value = "getStockLedgerDtlXLS";
    //document.forms[0].submit();
    var printImg = document.getElementById("printImg").innerHTML;	
	document.getElementById("printImg").innerHTML = "";
    window.open('data:application/vnd.ms-excel,' + encodeURIComponent($("#"+dataDivId+"").html()));
	e.preventDefault();
	document.getElementById("printImg").innerHTML = printImg;
       
}

function dateDifferenceInDays(mfgDate,expDate)
{
  	    t1 = convertDate_ddmmyyyy(mfgDate);
        t2 = convertDate_ddmmyyyy(expDate);
   //Total time for one day
        var one_day=1000*60*60*24; 
   //Here we need to split the inputed dates to convert them into standard format  for furter execution
        var x=t1.split("/");     
        var y=t2.split("/");
   //date format(Fullyear,month,date) 

        var date1=new Date(x[2],(x[1]-1),x[0]);
  
        var date2=new Date(y[2],(y[1]-1),y[0])
        var month1=x[1]-1;
        var month2=y[1]-1;
        
        //Calculate difference between the two dates, and convert to days
               
        _Diff=Math.ceil((date2.getTime()-date1.getTime())/(one_day)); 
       // alert("Difference Between Mfg & Exp Dates:::"+_Diff);
       return _Diff;
}

function convertDate_ddmmyyyy(dtValue)
		{
		  
		   var val1  = trimAll(dtValue).split("-").join(".");
		   var val2  = val1.split("-").join(".");
		   var date  = val2.split(".")[0];
		   var month = val2.split(".")[1];
		    
		   var convMonth ;   
		   
		   if(month=='JAN'||month=='Jan')
		   {
		   	 convMonth = "01";
		   }
		   if(month=='Feb')
		   { 
		   	 convMonth = "02";		  	   	
		   }
		   if(month=='Mar')
		   {
		   	 convMonth = "03";
		   }
		   if(month=='Apr')
		   { 
		   	 convMonth = "04";		  	   	
		   }
		   if(month=='May')
		   {
		   	 convMonth = "05";
		   }
		   if(month=='Jun')
		   { 
		   	 convMonth = "06";		  	   	
		   }
		   
		   if(month=='Jul')
		   { 
		   	 convMonth = "07";		  	   	
		   }
		   if(month=='Aug')
		   {
		   	 convMonth = "08";
		   }
		   if(month=='Sep')
		   { 
		   	 convMonth = "09";		  	   	
		   }
		   
		   if(month=='Oct')
		   { 
		   	 convMonth = "10";		  	   	
		   }
		   if(month=='Nov')
		   {
		   	 convMonth = "11";
		   }
		   if(month=='Dec')
		   { 
		   	 convMonth = "12";		  	   	
		   }
		   
		   var year  = val2.split(".")[2];   
		   return date+"/"+convMonth+"/"+year;
		}