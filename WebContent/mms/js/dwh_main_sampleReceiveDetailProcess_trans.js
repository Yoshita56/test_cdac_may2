
function chkBoxClick(obj,index)
{
	 if(obj.checked)
	 {
	 	var avlQty = document.getElementById("strCheckHidValue"+index).value.split("^")[30];
	  	document.getElementById("strBkgQty"+index).disabled=false;
	  	document.getElementById("strBkgQty"+index).value = '0';
	  	document.getElementById("strReceivedQty"+index).value = avlQty;
	  	
	 }
	 else
	 {
		  document.getElementById("strBkgQty"+index).disabled=true;
		  document.getElementById("strReceivedQty"+index).value = '0';
		  document.getElementById("strBkgQty"+index).value = '0';
	 }

}
function notGreaterThanReceQty(_these,index)
{
	var bkgQty = _these.value;
	var avlQty = document.getElementById("strCheckHidValue"+index).value.split("^")[30];
	
	if(bkgQty.length==0)
	{		
		bkgQty.value='0';
		return false;	
	}
	
	
	if(parseInt(avlQty,10)<parseInt(bkgQty,10))
	{
		alert("Breakage/Lost Quantity Can't be Greater than Avalaible Quantity!!!");
		_these.value = 0;
		document.getElementById("strReceivedQty"+index).value = avlQty;
		return false;
	}
	else
	{
	  document.getElementById("strReceivedQty"+index).value = parseInt(avlQty,10) - parseInt(bkgQty,10) ;	
	}
}


function controlToMainPage()
	{	    
		document.forms[0].hmode.value="INITVAL";
		document.forms[0].submit();
	}

function GetIndex(index,endVal)  // Pagenation  One
{
	
	
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+index).style.display="block";
		
			 
}


// For Sample Receive Detail Transaction:

/**
 * Developer : Adil Wasi
 * Version : 1.0 
 * Date : 09-Jan-2012
 * 
 */
 
function drugDtl(obj,index) 
{
	parentPopUp = obj;

	var strBalQtyDetail = document.getElementById("strPrintLabelValue"+index).value;

	myArray = strBalQtyDetail.split("^");

	/*
	 
 */


	var objVal1 = document.getElementById("1");
	
	if (myArray[0] != 'null' || myArray[0] != '') 
	{
		objVal1.innerHTML = myArray[0];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[1] != 'null' || myArray[1] != '') 
	{
		objVal2.innerHTML = myArray[1];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}


    var objVal3 = document.getElementById("3");

	if (myArray[2] != 'null' || myArray[2] != '') 
	{
		objVal3.innerHTML = myArray[2];
	} 
	else 
	{
		objVal3.innerHTML = "  ----";
	}
	
	var objVal4 = document.getElementById("4");

	if (myArray[3] != 'null' || myArray[3] != '') 
	{
		objVal4.innerHTML = myArray[3];
	} 
	else 
	{
		objVal4.innerHTML = "  ----";
	}
	
	var objVal5 = document.getElementById("5");

	if (myArray[4] != 'null' || myArray[4] != '') 
	{
		objVal5.innerHTML = myArray[4];
	} 
	else 
	{
		objVal5.innerHTML = "  ----";
	}
     
     

	display_popup_menu(parentPopUp, 'drugDtlId', '300', '');

}

function numericWithTwoDecimalPlaces(fld, milSep, decSep, e)
{
	var sep = 0;
	var key = '';
	var milSep="";
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	//if (whichCode == 13) return true;  // Enter
	if (whichCode == 0)	return true; //tab-index
	//alert(whichCode);
	if (whichCode == 8) return true;  // Back-Space 
	key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//len = fld.value.length;
		len=11;
		for(i = 0; i < len; i++)
		if ((fld.value.charAt(i) != decSep)) break;
		aux = '';
	for(; i < len; i++)
	if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
	aux += key;
	len = aux.length;
	if (len == 0) fld.value = '';
	if (len == 1) fld.value = ''+ decSep + '' + aux;
	if (len == 2) fld.value = ''+ decSep + aux;
	if (len > 2) {
	aux2 = '';
	for (j = 0, i = len - 3; i >= 0; i--) {
	if (j == 3) {
	aux2 += milSep;
	j = 0;
	}
	aux2 += aux.charAt(i);
	j++;
	}
	fld.value = " ";
	len2 = aux2.length;
	for (i = len2 - 1; i >= 0; i--)
	fld.value += aux2.charAt(i);
	fld.value += decSep + aux.substr(len - 2, len);
	}
	return false;
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
 // Item Category associate with Store Name:
function itemCategoryCombo()
{
    var mode ="ITEMCATEGORY"; 
    
    document.getElementById("itemCategoryId").innerHTML ="<select name='strItemCategoryNo' class='comboNormal' >"+
                                                         "<option value='0'>Select Value</option></select>";
    document.getElementById("batchDivId").innerHTML ="<select name='strBatchNo' class='comboNormal' >"+
                                                         "<option value='0'>Select Value</option></select>";
    document.getElementById("drugNameCmbDivId").innerHTML ="<select name='strItemBrandID' class='comboNormal' >"+
                                                         "<option value='0'>Select Value</option></select>";                                                                                                         
 	
    document.getElementById("sampleSentDWHId").innerHTML ="<select name='strSampleSentDWHId' class='comboNormal' >"+
	                                                     	"<option value='0'>Select Value</option></select>";	 
	 
	                                                 	
   
   if(document.forms[0].strDrugWareHouseId.value==0)
   {
	   if(document.getElementById("sampleRecDtlsHlpDivId"))
	   {
		   document.getElementById("sampleRecDtlsHlpDivId").innerHTML="";
	   }
	   if(document.getElementById("sampleReceiveDtlViewHlpDivId"))
	   {
		   document.getElementById("sampleReceiveDtlViewHlpDivId").innerHTML="";
	   }
	   
		document.getElementById("showButtonID").style.display="block";
		//document.getElementById("showMandatoryBefore").style.display="block";
	   return;
   }
   //alert("drugWarehouseId="+document.forms[0].strDrugWareHouseId.value);
   var url="SampleReceiveDetailProcessTransCNT.cnt?hmode=ITEMCATEGORY&drugWarehouseId="+document.forms[0].strDrugWareHouseId.value;
   //alert("url :"+url);
   ajaxFunction(url,"1");
}




 // Item Category associate with Store Name:
function itemCategoryCombo1()
{
 if(document.forms[0].strDrugWareHouseId.value!='0')
 {
   var mode ="ITEMCATEGORY";         
   var url="SampleReceiveDetailProcessTransCNT.cnt?hmode=ITEMCATEGORY&drugWarehouseId="+document.forms[0].strDrugWareHouseId.value;
   ajaxFunction(url,"11");
 }
 else
 {
 	document.getElementById("itemCategoryId").innerHTML ="<select name='strItemCategoryNo' class='comboNormal' >"+
                                                         "<option value='0'>Select Value</option></select>";
 }
}

 // Item Category associate with Store Name:
function drugWareHouseCombo()
{
   var mode ="GETDRUGWAREHOUSE"; 
   if(document.forms[0].strDrugWareHouseId.value==0)
   {
	   document.getElementById("itemCategoryId").innerHTML ="<select name='strItemCategoryNo' class='comboNormal' >"+
		"<bean:write name='sampleReceiveDetailProcessTransFB' property='strItemCatNoCmb' filter='false' />"+
		"<option value='0'>Select Value</option></select>";
	   if(document.getElementById("sampleRecDtlsHlpDivId")){
		   document.getElementById("sampleRecDtlsHlpDivId").innerHTML="";
	   }
	   if(document.getElementById("sampleReceiveDtlViewHlpDivId")){
		   document.getElementById("sampleReceiveDtlViewHlpDivId").innerHTML="";
	   }
	   
		document.getElementById("showButtonID").style.display="none";
		//document.getElementById("showMandatoryBefore").style.display="block";
	   return;
   }
   //alert("drugWarehouseId="+document.forms[0].strDrugWareHouseId.value);
   var url="SampleReceiveDetailProcessTransCNT.cnt?hmode="+mode+"&drugWarehouseId="+document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].value+"&ItemCatgNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value;
   //alert("url :"+url);
   ajaxFunction(url,"8");
}


function getIssueDrugDetailsHlp()
{
  	
   
    
		var mode="GETISSUEDRUGDETAIL";
		var drugWarehouseId=document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].value;
		var drugWarehouseName=document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].text;
		var itemCategoryNo=document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value;
		var itemCategoryName=document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].text;
		
	   if(drugWarehouseId!='0' && itemCategoryNo!='0')
	   {
			var url="SampleReceiveDetailProcessTransCNT.cnt?hmode="+mode+"&drugWarehouseId="+document.forms[0].strDrugWareHouseId.value+"&itemCategoryNo="+itemCategoryNo+"&drugWarehouseName"+drugWarehouseName+"&itemCategoryName="+itemCategoryName+"&sampleSentDwhId="+document.forms[0].strSampleSentDWHId[document.forms[0].strSampleSentDWHId.selectedIndex].value+"&ItemBrandId="+document.forms[0].strItemBrandID[document.forms[0].strItemBrandID.selectedIndex].value+"&ItemBatch="+document.forms[0].strBatchNo[document.forms[0].strBatchNo.selectedIndex].value;
			ajaxFunction(url,"2");
	   }
	   else
	   {
	   	  if(drugWarehouseId=='0')
	   	  {
	   	  	alert("Please Select HQ Name!!!");
	   	  	document.forms[0].strDrugWareHouseId.focus();
	   	  }
	   	  else
	   	  {
	   	  	alert("Please Select Drug Category!!!");
	   	  	document.forms[0].strItemCategoryNo.focus();
	   	  }
	   	
	   }
  
}

function CheckedAll(chkObj)
{
	var size=document.getElementsByName("strIssueChkIndex").length;
	var avlQty = 0;
	
    if(chkObj.checked)
 	{
     	for(var i=0;i<size;i++)
		{
			document.getElementsByName("strIssueChkIndex")[i].checked=true;
			document.getElementsByName("strIssueChkIndex")[i].value='1';
			document.getElementsByName("strBkgQty")[i].disabled=false;
			
			avlQty = document.getElementById("strCheckHidValue"+i).value.split("^")[30];
			document.getElementsByName("strBkgQty")[i].value = '0';
			document.getElementsByName("strReceivedQty")[i].value = avlQty;
		}
	 	
 	}
 	else
 	{
 		for(var i=0;i<size;i++)
		{
			document.getElementsByName("strIssueChkIndex")[i].checked=false;
			document.getElementsByName("strIssueChkIndex")[i].value='0';
			document.getElementsByName("strBkgQty")[i].disabled=true;
			
			document.getElementsByName("strBkgQty")[i].value = '0';
			document.getElementsByName("strReceivedQty")[i].value = '0';
		}
	 	
 	}
	
}
/**
 * changeViewMode
 * @param {Object} chkObj 
 */
 function changeViewMode(chkObj) 
 { 	 	 	
 	if(document.forms[0].strViewCheckBox.checked==true){
 		document.forms[0].hmode.value="VIEWPAGE";
 		document.forms[0].submit();
 	}
	 
	
 }
 
 function genrateSampleReceiveDtlViewHlp()
 {	
    if(document.getElementsByName("strDrugWareHouseId")[0].value=="0")
    {
 		alert("Please Select HQ Name from Combo");
 		return false;
 	}
 	if(document.getElementsByName("strItemCategoryNo")[0].value=="0")
 	{
 		alert("Please Select Item Category From Combo");
 		return false;
 	}
 	
 	if(document.getElementsByName("strFromDate")[0].value=="")
 	{
 		alert("From Date is a mandatory field");
 		return false;
 	}
 	
 	if(document.getElementsByName("strToDate")[0].value=="")
 	{
 		alert("To Date is a mandatory field");
 		return false;
 	}
 	
 	 	
 	
 	
 	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
 	//alert(diffdate);
 	 if(parseInt(diffdate)>365)
 	 {
 		alert("Difference Between From Date and To Date Should not be greater than 365 days");
 		return false;
 	 }
 	
 	else
 	{
 	    var hisValidator = new HISValidator("sampleReceiveDetailProcessTransFB");
	    hisValidator.addValidation("strToDate", "dtgtet="+document.forms[0].strFromDate.value,"To Date should be Greater Than or Equal From Date");
	
	    var retVal = hisValidator.validate();
	    if(retVal)	
	    {
	    	document.forms[0].strDrugWareHouseId.disabled=true;
		    document.forms[0].strItemCategoryNo.disabled=true;	
		        
	 		var mode="VIEWSAMPLERECEIVE";	 		
	 		var drugWarehouseId=document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].value;
	 		var drugWarehouseName=document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].text;
	 		var itemCategoryNo="10"; //
	 		//var itemCategoryName=document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].text;
	 		var url="SampleReceiveDetailProcessTransCNT.cnt?hmode="+mode+"&drugWarehouseId="+drugWarehouseId+"&itemCategoryNo="+itemCategoryNo+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&drugWarehouseName="+drugWarehouseName+"&itemCategoryNo="+itemCategoryNo;
	 		//alert("url :"+url);
	 		
	 		ajaxFunction(url,"7");
	    }
	    else
		{
			return false;
		} 
 	}
 }
 
 
 function genrateSampleReceiveDtlViewPrintHlp()
 {
     var mode="GENSAMPLERECEIVEDTLPRINT";
     var drugWarehouseId = document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].value;
	 var drugWarehouseName = document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].text;
	 
	 var itemCatg = document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value;
	 
	 if(drugWarehouseId!='0' && itemCatg!='0')
	 {
	  var itemCategoryNo="10"; 
      var strCheckHidValue=document.forms[0].strCheckHidValue.value;
      var url="SampleReceiveDetailProcessTransCNT.cnt?hmode="+mode+"&drugWarehouseId="+drugWarehouseId+"&itemCategoryNo="+itemCategoryNo+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&drugWarehouseName="+drugWarehouseName+"&itemCategoryNo="+itemCategoryNo+"&strCheckHidValue="+strCheckHidValue;
 	//alert("url :"+url);
 	  ajaxFunction(url,"4");
	 }
	 else
	 {
	 	if(drugWarehouseId=='0')
	 	{
	 		alert("Please Select HQ Name!!!");
	 		document.forms[0].strDrugWareHouseId.focus();
	 		return false;
	 		
	 	}
	 	else
	 	{
	 		alert("Please Select Category!!!");
	 		document.forms[0].strItemCategoryNo.focus();
	 		return false;
	 	}
	 	
	 }
 	
 }
 
 
 
 // Item Name associate with DWH Name:
function itemNameCombo()
{
   // if((document.forms[0].strSampleSentDWHId[document.forms[0].strSampleSentDWHId.selectedIndex].value)!=0)
    {
    var mode ="ITEMNAMECMB"; 
   // var url="SampleReceiveDetailProcessTransCNT.cnt?hmode=ITEMNAMECMB"&drugWarehouseId="+document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].value+"&ItemCatgNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value;
    var url="SampleReceiveDetailProcessTransCNT.cnt?hmode="+mode+"&drugWarehouseId="+document.forms[0].strSampleSentDWHId[document.forms[0].strSampleSentDWHId.selectedIndex].value+"&ItemCatgNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value;
    ajaxFunction(url,"9");
    
    }
   
}


 // Item Name associate with DWH Name:
function batchNameCombo()
{
    var mode ="BATCHNAMECMB"; 
   // var url="SampleReceiveDetailProcessTransCNT.cnt?hmode=ITEMNAMECMB"&drugWarehouseId="+document.forms[0].strDrugWareHouseId[document.forms[0].strDrugWareHouseId.selectedIndex].value+"&ItemCatgNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value;
    var url="SampleReceiveDetailProcessTransCNT.cnt?hmode="+mode+"&drugWarehouseId="+document.forms[0].strSampleSentDWHId[document.forms[0].strSampleSentDWHId.selectedIndex].value+"&ItemCatgNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value+"&ItemBrandId="+document.forms[0].strItemBrandID[document.forms[0].strItemBrandID.selectedIndex].value;
    ajaxFunction(url,"10");
}
 
 
function getAjaxResponse(res,mode)
{
	
	var objVal;
	if(mode=="1")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }
       else
       {
          objVal= document.getElementById("itemCategoryId");
		  objVal.innerHTML = "<select name ='strItemCategoryNo' class='comboNormal' >" + res + "</select>";
		  document.getElementById("showButtonID").style.display="block";
		  drugWareHouseCombo();
	    }
        //resetScreen();
    }
	if(mode=="2")
	   {
		  // alert("res"+res);
		   objVal = document.getElementById("sampleRecDtlsHlpDivId");
			objVal.innerHTML = res; 
			document.getElementById("showButtonID").style.display="block";			
			document.forms[0].strDrugWareHouseId.disabled=true;	
			document.forms[0].strItemCategoryNo.disabled=true;
			document.forms[0].strSampleSentDWHId.disabled=true;
			document.forms[0].strItemBrandID.disabled=true;
			document.forms[0].strBatchNo.disabled=true;
			
	   }
	if (mode == "4") 
	{				
		
		objVal = document.getElementById("sampleReceiveDtlViewPrintHlpDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');
		
		
	}
	if (mode == "7") 
	{

		objVal = document.getElementById("sampleReceiveDtlViewHlpDivId");
		objVal.innerHTML = res;
		document.getElementById("showButtonID").style.display = "block";
		
			
	}
	if(mode=="8")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          objVal= document.getElementById("sampleSentDWHId");
		  objVal.innerHTML = "<select name ='strSampleSentDWHId' class='comboNormal' onChange='hideDrugDtlDiv();' >" + res + "</select>";  
		  itemNameCombo();
        }
       
    }
    
    
    if(mode=="9")
	{	
	        objVal = document.getElementById("sampleRecDtlsHlpDivId");
			objVal.innerHTML = ""; 
			document.getElementById("showButtonID").style.display="block";
			
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          objVal= document.getElementById("drugNameCmbDivId");
		  objVal.innerHTML = "<select name ='strItemBrandID' class='comboMax' onChange='batchNameCombo();' >" + res + "</select>";
		 batchNameCombo();
        }
       
    }
    
    if(mode=="10")
	{		  
	  objVal = document.getElementById("sampleRecDtlsHlpDivId");
			objVal.innerHTML = ""; 
			document.getElementById("showButtonID").style.display="block";
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          objVal= document.getElementById("batchDivId");
		  objVal.innerHTML = "<select name ='strBatchNo' class='comboNormal' >" + res + "</select>";
		  
        }
       
    }
    
    if(mode=="11")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }
       else
       {
          objVal= document.getElementById("itemCategoryId");
		  objVal.innerHTML = "<select name ='strItemCategoryNo' class='comboNormal' >" + res + "</select>";
		  document.getElementById("showButtonID").style.display="block";
		  
	    }
        //resetScreen();
    }
}
function hideDrugDtlDiv()
{
  	        objVal = document.getElementById("sampleRecDtlsHlpDivId");
			objVal.innerHTML = ""; 
			document.getElementById("showButtonID").style.display="none";
			//document.getElementById("showMandatoryBefore").style.display="none";
			itemNameCombo();
}
function validate1() 
{
	var saveObj = document.getElementById("saveId");
	var count=0;
	var allChkObj;
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 

		var hisValidator = new HISValidator("sampleReceiveDetailProcessTransFB");
		hisValidator.addValidation("strDrugWareHouseId", "dontselect=0","Please Select HQ !!");
		hisValidator.addValidation("strItemCategoryNo", "dontselect=0","Please Select Category !!");
		
		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
			
		if(retVal)
		{
			var chkObj = document.getElementsByName("strIssueChkIndex");
			var brkQtyObj = document.getElementsByName("strBkgQty");
			var avlQty = 0;
			
			var size = chkObj.length;
			
			for(var i=0;i<size;i++)
			{
			    if(chkObj[i].checked) 
			    {
			    	count = 1;
			    	break;
			    }
			}
			
			if(count==0)
			{
				alert("Please Select atleast One record");
				saveObj.style.display = '';
				return false;
			}
			
			count = 0;
			
			for(var i=0;i<size;i++)
			{
				avlQty = document.getElementById("strCheckHidValue"+i).value.split("^")[30];
				
				if((brkQtyObj[i].value).length == 0) brkQtyObj[i].value = 0;
				document.getElementById("strReceivedQty"+i).value = parseInt(avlQty,10) - parseInt(brkQtyObj[i].value,10);
				
				if(parseInt(document.getElementById("strReceivedQty"+i).value,10) > 0) count = 1;
				
				if(chkObj[i].checked)
					chkObj[i].value='1';
				else
					chkObj[i].value='0';
				
				brkQtyObj[i].disabled = false;	
			    chkObj[i].checked = true;
			}
			
			if(count==0)
			{
				var confMsg = confirm("For All Drugs, Received Qty is Zero !! \n Ary you still want to continue");
				if(confMsg == false)
				{
					allChkObj = document.getElementById("chkmainId");
					allChkObj.checked = false;
					
					CheckedAll(chkObj);
					saveObj.style.display = '';
					return false;
				}
			}
			
			var conf = confirm("You Are Going To Save Records");
            if(conf == true)
            {
            	var conf1 = confirm("Are you sure !!!");
                if(conf1 == true)
                {
                	document.forms[0].strDrugWareHouseId.disabled=false;	
					document.forms[0].strItemCategoryNo.disabled=false;
					document.forms[0].strSampleSentDWHId.disabled=false;
					document.forms[0].strItemBrandID.disabled=false;
					document.forms[0].strBatchNo.disabled=false;
					
					document.forms[0].hmode.value = "INSERT";
					document.forms[0].submit();
                }
                else
                {
                	allChkObj = document.getElementById("chkmainId");
					allChkObj.checked = false;
					CheckedAll(chkObj);
					
                	saveObj.style.display = '';
                    return false;
                }
            }
            else
            {
            	allChkObj = document.getElementById("chkmainId");
				allChkObj.checked = false;
				
				CheckedAll(chkObj);
					
            	saveObj.style.display = '';
                return false;
            }
		}
		else
		{
			allChkObj = document.getElementById("chkmainId");
			allChkObj.checked = false;
			CheckedAll(chkObj);
					
			saveObj.style.display = '';
            return false;
		}
	}
}
	
function pageResetMethod(mode)
{
	
	document.forms[0].reset();
	document.getElementById("itemCategoryId").innerHTML ="<select name='strItemCategoryNo' class='comboNormal' >"+
							"<bean:write name='sampleReceiveDetailProcessTransFB' property='strItemCatNoCmb' filter='false' />"+
							"<option value='10'>Drug</option></select>";
    if(document.getElementById("sampleSentDWHId"))
	{                                                     	
         document.getElementById("sampleSentDWHId").innerHTML ="<select name='strSampleSentDWHId' class='comboNormal' >"+
	                                                     	"<option value='0'>Select Value</option></select>";	 
	} 		
		
	if(mode==1)
	{
		document.getElementById("sampleRecDtlsHlpDivId").innerHTML="";
		document.getElementById("showButtonID").style.display="block";
		document.forms[0].strDrugWareHouseId.disabled=false;	
		document.forms[0].strItemCategoryNo.disabled=false;
		document.forms[0].strSampleSentDWHId.disabled=false;
		document.forms[0].strItemBrandID.disabled=false;
		document.forms[0].strBatchNo.disabled=false;
	}
	if(mode==2)
	{
		document.getElementById("sampleReceiveDtlViewHlpDivId").innerHTML="";
		document.getElementById("showButtonID").style.display="block";
		document.forms[0].strDrugWareHouseId.disabled=false;	
		document.forms[0].strItemCategoryNo.disabled=false;
	}

	
}

function cancel()
{
	 	document.forms[0].hmode.value="CANCELPAGE";
		document.forms[0].submit();
}
function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("sampleReceiveDtlViewPrintHlpDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 

}

/**
 * Prints the report.
 * @return
 */
function printData(mode) 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
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
	
	if(mode=='1')
	{
	  newwin.document.write(document.getElementById('sampleReceiveDtlViewPrintHlpDivId').innerHTML);
	}
//	if(mode=='2')
//	{
//	  newwin.document.write(document.getElementById('poChallanDtlsDivId').innerHTML);
//	}
//	if(mode=='3')
//	{
//	  newwin.document.write(document.getElementById('poChallanItemDtlsDivId').innerHTML);
//	}
//	if(mode=='4')
//	{
//	  newwin.document.write(document.getElementById('suppliedPOPrintDtlsDivId').innerHTML);
//	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}

//Function for Numeric(11,2)
