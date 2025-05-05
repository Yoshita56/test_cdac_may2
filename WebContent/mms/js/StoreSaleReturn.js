function chkCriteria(a){
	
	if(a==1){
		objVal = document.getElementById("d_range");
		objVal.style.display = "none";
		objVal = document.getElementById("d_range1");
		objVal.style.display = "flex";
	}else{
		objVal = document.getElementById("d_range");
		objVal.style.display = "flex";
		objVal = document.getElementById("d_range1");
		objVal.style.display = "none";
	}
}


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
}
function onClearPage(){
	 
	 document.getElementById("strStoreId").disabled  = false;
	 document.getElementById("datepicker1").disabled = false; 
	 document.getElementById("datepicker2").disabled = false;
     document.getElementById("Ydate").disabled = false;
     document.getElementById("dRange").disabled = false;
     document.getElementById("yRange").disabled = false;
     document.getElementById("download").disabled = false;
     
	 objVal = document.getElementById("issueTrackRpt");
	 objVal.innerHTML = "";
	 var x = document.getElementById("issueTrackRpt1");
	 x.style.display = "none";
	 document.forms[0].reset();
}
function getIssueTrackDtlRpt() {
    document.getElementById("strStoreId").disabled = true;
    document.getElementById("datepicker1").disabled = true;
    document.getElementById("datepicker2").disabled = true;
    document.getElementById("Ydate").disabled = true;
    document.getElementById("dRange").disabled = true;
    document.getElementById("yRange").disabled = true;
    document.getElementById("download").disabled = true;
    
    var hisValidator = new HISValidator("StoreSaleReturnBean");

    var strFromStoreId = document.getElementsByName('strStoreId')[0].value;
    var diffdate = dateDiff1(document.forms[0].strFromDate.value, document.forms[0].strToDate.value);

    if (parseInt(diffdate) > 365) {
        alert("Difference Between From Date and To Date Should not be greater than 365 days");
        return false;
    }

    var retVal = hisValidator.validate();
    hisValidator.clearAllValidations();
    var btn = document.getElementById("dRange");
    objVal = document.getElementById("issueTrackRpt");
    objVal.innerHTML = "";

    if (retVal) {
        var hmode = "SHOWRPTNEW";
        var url = "StoreSaleReturnCNT.cnt?hmode=" + hmode +
            "&strStoreId=" + document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value +
            "&storeName=" + document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

        if (btn.checked) {
        	url += "&strFromDate=" + document.forms[0].strFromDate.value +
            "&strToDate=" + document.forms[0].strToDate.value + "&btnchk=1";
        } else {
            url += "&Ydate=" + document.forms[0].Ydate.value + "&btnchk=2";
        }
//        alert("-----url----"+url);
        var x = document.getElementById("issueTrackRpt1");
        x.style.display = "block";

        ajaxFunction(url, "1");
    } else {
        return false;
    }
}


function getVoucher(index, cMode) 
{   
	
   var hmode="INDENTPRINT";
   
   var url = "StoreSaleReturnCNT.cnt?hmode="+hmode+
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
	x.style.display = "none";
	
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
	newwin.document.write(document.getElementById('issueTrackRpt').innerHTML);	  
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
	//document.getElementById("strCrNo").focus();
	
	var x = document.getElementById("printImg");
	x.style.display = "block";

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
		alert("From Date should be less than To Date");
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




