function getAjaxResponse(res,mode){
	
	if (mode == "1") 
	{
		// ISSUE TRACK RPT 
		objVal = document.getElementById("issueTrackRpt");
		objVal.style.display = "block";
		objVal.innerHTML = res;
		
		objVal1 = document.getElementById("footerid");
		objVal1.style.display = "block";
		//alert(res);
	}
	
	if(mode == "2")
	{ 
		/*//POP UP
		var itemStockObj = document.getElementById("issueDtlsDivId");
		itemStockObj.innerHTML = res;			
		popup('popUpDiv', '220', '220');*/	
		
		var objVal = document.getElementById("issueDtl");
		objVal.innerHTML = res;
		$("#issueDtlModal").modal("show");
		
	}
	
	if(mode == "3")
	{ 
		/*//POP UP
		var itemStockObj = document.getElementById("issueDtlsDivId");
		itemStockObj.innerHTML = res;			
		popup('popUpDiv', '220', '220');*/	
		
		var objVal = document.getElementById("issueDtl");
		objVal.innerHTML = res;
		$("#issueDtlModal").modal("show");
		
	}
	if(mode == "4")
	{ 
		var objVal = document.getElementById("issueDtl");
		objVal.innerHTML = res;
		$("#issueDtlModal").modal("show");
		
	}
	if(mode == "5")
	{ 
		var objVal = document.getElementById("issueDtl");
		objVal.innerHTML = res;
		$("#issueDtlModal").modal("show");
		
	}
}

function goBack(mode){
	//mode=1 -> return from issue voucher of indent no
	//mode=2 -> return from issue voucher of Drug/Item dtl
	
 	//0                       //1                       //2                    //3                       //4                      //5                    //6
	//"vo.getStrStoreId()+"^"+vo.getStrReqStoreId()+"^"+vo.getStrIssueNo()+"^"+vo.getStrIndentNo()+"^"+vo.getStrReqStoreId()+"^"+vo.getStrStartDate()+"^"+vo.getStrEndDate()+"^"
	//7                       //8                  //9                             //10                     //11                    //12
	//+vo.getStrCmodeId()+"^"+vo.getStrStoreName()+vo.getStrRaisingStoreName()+"^"+vo.getStrIssuedBy()+"^"+vo.getStrReceivedBy()+"^"+vo.getStrCategoryCode()"'>"
	//13                         //14                      //15
	//+"^"+vo.getStrItemId()+"^"+vo.getStrItemBrandId()+"^"+vo.getStrBatchNo()
	var hmode="UNDO";
	var hiddenId = document.getElementById("hiddenId").value;
	console.log("hiddenId = "+ hiddenId);
	var issueNo = hiddenId.split('^')[2];
	var indentNo = hiddenId.split('^')[3];
	var issueBy = hiddenId.split('^')[10];
	var receiveBy = hiddenId.split('^')[11];
	var catgCode = hiddenId.split('^')[12];
	var reqStoreId = hiddenId.split('^')[1];                            
	var storeId = hiddenId.split('^')[0];  
	var itemBrandId = hiddenId.split('^')[14];
	var batchNo = hiddenId.split('^')[15];
	var itemId = hiddenId.split('^')[13] ;
 	var reqStoreName = hiddenId.split('^')[1] ;
 	var itemName = hiddenId.split('^')[13] ;
 	var cMode = hiddenId.split('^')[7] ;
 	var startDate = hiddenId.split('^')[5] ;
 	var endDate = hiddenId.split('^')[6] ;
 	var storeName = hiddenId.split('^')[8] ;
	var url = "IssueTrackRptCNT.cnt?hmode="+hmode+
	"&reqMode="+mode+
	"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
	"&issueNo="+issueNo+
	"&catgCode="+catgCode+
	"&itemId="+itemId+
	"&itemBrandId="+itemBrandId+
	"&itemName="+itemName+
	"&batchNo="+batchNo+
	"&indentNo="+indentNo+
	"&issueBy="+issueBy+
	"&receiveBy="+receiveBy+
	"&reqStoreName="+reqStoreName+
	"&storeName="+storeName+
	"&strFromDate="+startDate+
	"&strToDate="+endDate+
	"&strReqStoreId="+reqStoreId+
	"&strCmodeId="+cMode;
	ajaxFunction(url,"4");
}
function getIssueDtlForSubStore(row,cMode){
	console.log("row clicked =" +row);
	var hmode="ISSUEDTLBYSUBSTORE";
//	0.hstnum_issue_no @ 1.HSTNUM_STORE_ID @ 2.HSTNUM_INDENT_NO @ 3.HSTNUM_REQ_STOREID @ 4.hstnum_item_id @ 5.hstnum_itembrand_id @ 6.HSTSTR_BATCH_SL_NO @ 7.sstnum_item_cat_no
	var hiddenId = document.getElementById("rowHiddenDetails"+row).value;
	console.log("hiddenId = "+ hiddenId);
	var issueNo = hiddenId.split('@')[0];
	var indentNo = hiddenId.split('@')[2];
	var issueBy = document.getElementById("issueBy"+row).value;
	var receiveBy = document.getElementById("receiveBy"+row).value;
	var catgCode = hiddenId.split('@')[7];
	var reqStoreId = hiddenId.split('@')[3];
	var itemBrandId = hiddenId.split('@')[5] ;
	var batchNo = hiddenId.split('@')[6];
	var itemId = hiddenId.split('@')[4] ;
 	var reqStoreName = document.getElementById("reqStoreName"+row).value;
 	var itemName = document.getElementById("itemName"+row).value;
	
 	console.log("itemName = "+ itemName);
	var url = "IssueTrackRptCNT.cnt?hmode="+hmode+
	"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
	"&issueNo="+issueNo+
	"&catgCode="+catgCode+
	"&itemId="+itemId+
	"&itemBrandId="+itemBrandId+
	"&itemName="+itemName+
	"&batchNo="+batchNo+
	"&indentNo="+indentNo+
	"&issueBy="+issueBy+
	"&receiveBy="+receiveBy+
	"&strReqStoreId="+reqStoreId+
	"&reqStoreName="+reqStoreName+
	"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
	"&strFromDate="+document.forms[0].strFromDate.value+
	"&strToDate="+document.forms[0].strToDate.value+
	"&strCmodeId="+cMode;


	   
	 //  alert(url);
	   ajaxFunction(url,"5");
}
function getIndentDtlsForRow(row,cMode){
	console.log("row clicked =" +row);
	var hmode="ISSUEDTLPRINT";
//	hstnum_issue_no @ HSTNUM_STORE_ID @ HSTNUM_INDENT_NO @ HSTNUM_REQ_STOREID @ hstnum_item_id @ hstnum_itembrand_id
	var hiddenId = document.getElementById("rowHiddenDetails"+row).value;
	console.log("hiddenId = "+ hiddenId);
	var issueNo = hiddenId.split('@')[0];
	var indentNo = hiddenId.split('@')[2];
	var reqStoreId = hiddenId.split('@')[3];
	var issueBy = document.getElementById("issueBy"+row).value;
	var receiveBy = document.getElementById("receiveBy"+row).value;
	   
	var url = "IssueTrackRptCNT.cnt?hmode="+hmode+
	"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
	"&strReqStoreId="+reqStoreId+
	"&issueNo="+issueNo+
	"&indentNo="+indentNo+
	"&issueBy="+issueBy+
	"&receiveBy="+receiveBy+
	"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
	"&strFromDate="+document.forms[0].strFromDate.value+
	"&strToDate="+document.forms[0].strToDate.value+
	"&strCmodeId="+cMode;


	   
	 //  alert(url);
	   ajaxFunction(url,"3");
}

function getIssueTrackDtlRpt() 
{
 	var hisValidator = new HISValidator("IssueTrackRptBean");
 	
 	var strFromStoreId = document.getElementsByName('strStoreId')[0].value;
	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 

 	if (strFromStoreId == 0 ) 
 	{
	  alert("Please Select Store Name");
	  return false;
	}
    if(parseInt(diffdate)>365)
	{
      alert("Difference Between From Date and To Date Should not be greater than 365 days");
      return false;
	}
    
    var retVal = hisValidator.validate();
    hisValidator.clearAllValidations();
    
    objVal = document.getElementById("issueTrackRpt");
    objVal.innerHTML = ""; 
	
    if (retVal) {
		
 	var hmode = "SHOWRPTNEW"; 
	var url = "IssueTrackRptCNT.cnt?hmode="+hmode+
	
	"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
	"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
	
	"&strFromDate="+document.forms[0].strFromDate.value+
	"&strToDate="+document.forms[0].strToDate.value;
	//alert(url);		
	
	ajaxFunction(url,"1");
	} else {
			return false;
		} 
}

function getVoucher(index, cMode) 
{   
	
   var hmode="INDENTPRINT";
   
   var url = "IssueTrackRptCNT.cnt?hmode="+hmode+
	"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
	"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
	"&strFromDate="+document.forms[0].strFromDate.value+
	"&strToDate="+document.forms[0].strToDate.value+
	"&strReqStoreId="+document.getElementById("strReqStoreId"+index).value+
	"&strCmodeId="+cMode;

   
 //  alert(url);
   ajaxFunction(url,"2");
	 
}



function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onLoadPage()
{
	document.forms[0].strStoreId.value = "0";
	
}

function printDataOne(mode) 
{
	var x = document.getElementById("printImg");
	if(x!=null){
		x.style.display = "none";		
	}
	
	var legend = document.getElementById("legendsId");
	if(legend!=null){
		legend.style.display = "none";		
	}
	
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
	if(mode=='1')
	{
	  newwin.document.write(document.getElementById('issueTrackRpt').innerHTML);	  
	}
	if(mode=='2')
	{
	  newwin.document.write(document.getElementById('issueDtl').innerHTML);	  
	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
	if(legend!=null){
		legend.style.display = "block";		
	}
	//document.getElementById("strCrNo").focus();

}


function get_MonthInt(str)
{
	var month = "0";
	switch(str.toUpperCase())
	{
		case "JAN":
			month = "1";
			break;
		case "FEB":
			month = "2";
			break;
		case "MAR":
			month = "3";
			break;
		case "APR":
			month = "4";
			break;
		case "MAY":
			month = "5";
			break;
		case "JUN":
			month = "6";
			break;
		case "JUL":
			month = "7";
			break;
		case "AUG":
			month = "8";
			break;
		case "SEP":
			month = "9";
			break;
		case "OCT":
			month = "10";
			break;
		case "NOV":
			month = "11";
			break;
		case "DEC":
			month = "12";
			break;
	}
	return month;
}

function Days_InMonth(mon, year) 
{
	var retVal;
	
	retVal = 31;
	if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {retVal = 30;}
	if (mon == 2) {retVal = days_InFebruary(year);}
   	return retVal;
}

//this is internal function that returns day in feb month for specified year
function days_InFebruary (year)
{
	return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}

function get_Seperator(dtStr)
{
	var seprator = "";
	if (dtStr.indexOf("-") > -1)
		seprator = "-";
	else
	{
		if (dtStr.indexOf("/") > -1)
			seprator = "/";
		else
		{
			if (dtStr.indexOf(".") > -1)
				seprator = ".";
		}
	}	//endif
	return seprator;
}

function parse_Date(dtStr,seprator)
{
	var pos1,pos2,tempLen=0;
	var tempStr = "";
	var intDay = 0,intMon = 0,intYear = 0;
	var retValue = false;
	pos1 = dtStr.indexOf(seprator);
	pos2 = dtStr.indexOf(seprator,pos1+1);
	if(pos1 > 0 && pos2 > (pos1 + 1))
	{
		//day
		tempStr = dtStr.substring(0,pos1);
		tempLen = tempStr.length;
		if(tempLen > 0 && tempLen <=2)
		{
			intDay = parseInt(tempStr,'10');
			//month
			tempStr = dtStr.substring(pos1+1,pos2);
			tempLen = tempStr.length;
			if(tempLen > 0 && tempLen <= 3)
			{
				//format given as dd/mmm/yyyy
				if(tempLen == 3) tempStr = get_MonthInt(tempStr);	
				intMon = parseInt(tempStr,'10');
				if(intMon > 0) 
				{
					//year
					tempStr = dtStr.substring(pos2+1);
					tempLen = tempStr.length;
					if(tempLen == 4)
					{
						intYear = parseInt(tempStr,'10');
						if (intYear >= 1900 && intYear <= 9900)
						{
							if (intMon >= 1 && intMon <= 12)
							{
								if (intDay > 0 && intDay <= Days_InMonth(intMon, intYear))
									retValue = true;
							}
						}
					}
				}
			}
		}
	}
	
	return {cancelKey :retValue,day:intDay,month:intMon,year:intYear};
}

function compare_Date(frDate,toDate)
{
	var seprator1 = "", seprator2 = "";
	var retValue = false;
	var dtMode = 0;
	var retValues1,retValues2;
	if (frDate != "" && frDate != null && toDate != "" && toDate != null)
	{
		seprator1 = get_Seperator(frDate);		//function that returns seperator
		seprator2 = get_Seperator(toDate);		//function that returns seperator
		if (seprator1 != "" && frDate.length >= 8)
		{
			retValues1 = parse_Date(frDate,seprator1);
			if (seprator2 != "" && toDate.length >= 8 && retValues1.cancelKey == true)
			{
				retValues2 = parse_Date(toDate,seprator2);
				if(retValues2.cancelKey == true)
				{
					if(retValues1.year == retValues2.year)
					{
						if(retValues1.month == retValues2.month)
						{
							if(retValues1.day == retValues2.day)
								dtMode = 1;
							else
							{
								if(retValues1.day > retValues2.day)
									dtMode = 2;
								else
									dtMode = 0;
							}
						}
						else
						{
							if(retValues1.month > retValues2.month)
								dtMode = 2;
							else
								dtMode = 0;	
						}
					}
					else
					{
						if(retValues1.year > retValues2.year)
							dtMode = 2;
						else
							dtMode = 0;		
					}
					
					retValue = true;
				}
			}
		}
	}
	
	return {cancelKey :retValue,mode:dtMode};
} //end compareDate() function

function dateDiff1(date_1,date_2) 
{
	if(date_1==date_2)
	{
	//alert("same day");
	//var o=document.getElementById("daysOnLeave");
	//o.innerHTML="<font color='blue' weight='strong'>same day</font>";
	//document.forms[0].strDaysOnLeave.value=1;
	return 0;
	}
	var retVal=compare_Date(date_1,date_2);
	//alert("retVal.mode->"+retVal.mode);
	if(retVal.mode!=0)
	{
		//alert("From Date should be less than To Date");
		return;
	}		
	if(retVal.mode==0)
	{
		var ret=parse_Date(date_1,"-");
		var ret1=parse_Date(date_2,"-");
		var dt1=ret.month+"-"+ret.day+"-"+ret.year;
		var dt2=ret1.month+"-"+ret1.day+"-"+ret1.year;
		date1 = new Date();
		date2 = new Date();
		diff  = new Date();
		//alert("Valid From/in format DD-MM-YYYY->"+dt1);
		//alert("Valid To/in format DD-MM-YYYY->"+dt2);
		{ // Validates first date 
		var myDate1=new Array();
		myDate1=dt1.split("-");
		date1temp = new Date(myDate1[2],myDate1[0],myDate1[1]);
		date1.setTime(date1temp.getTime());
		}
		{ // Validates second date 
		var myDate2=new Array();
		myDate2=dt2.split("-");
		date2temp = new Date(myDate2[2],myDate2[0],myDate2[1]);
		//alert("date2temp.getTime()->"+date2temp.getTime());
		date2.setTime(date2temp.getTime());
		}
		// sets difference date to difference of first date and second date
		//alert("date1.getTime()->"+date1.getTime());
		diff.setTime(Math.abs(date1.getTime() - date2.getTime()));
		timediff = diff.getTime();
		//alert("timediff->"+timediff);
		weeks = Math.floor(timediff / (1000 * 60 * 60 * 24 * 7));
		timediff -= weeks * (1000 * 60 * 60 * 24 * 7);
		days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
		timediff -= days * (1000 * 60 * 60 * 24);
		days=parseInt(weeks)*7+days;
		//var diff = /*weeks + " weeks, " +*/ days + " days " ;
		diff=days;
		//alert("date diff->"+diff);
		//var o=document.getElementById("daysOnLeave");
		//o.innerHTML="<font color='blue' weight='strong'>"+diff+"</font>";
		//document.forms[0].strDaysOnLeave.value=diff;
		return diff;
	}
}




