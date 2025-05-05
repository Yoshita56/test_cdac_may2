


/******************************************************************************/

function openItemDivForItem(obj)
{          
      if(obj.value.split("^")[1]!='0')
      {
	             var itemNameObj    = document.getElementsByName("itemName");
	             var  batchNoObj    = document.getElementsByName("batchNo");
	             var divIndexObj    = document.getElementsByName("divIndex");
	             var      endVal    = document.forms[0].TotalLayer.value;
	             var x,y ;
                  
		          for(var i = 1; i <= itemNameObj.length ; i++)
				  {
				   // alert("Select Name:::::"+obj.value.split("^")[0]+"::Batch No::::"+batchNoObj[i].value.split("^")[0]);
					 if( (obj.value.split("^")[0] == batchNoObj[i].value.split("^")[0]) && (obj.value.split("^")[1] == itemNameObj[i].value.split("^")[0]))
					 {					    
					     x = divIndexObj[i].value;
					     y = batchNoObj[i].value.split("^")[1];					     
					     break;
					     
					 }
				  }
		  
		          for(var i = 1; i <= endVal ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				  document.getElementById("DivId"+x).style.display="block";
				 
				 document.getElementsByName("pageIndeCmb")[0].value =  x ;			
	            
	              var   colorOne = "LIGHTGREEN";
			       					     
				  document.getElementById("tdId1"+y).style.backgroundColor = colorOne; 
				  document.getElementById("tdId2"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId3"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId4"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId5"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId6"+y).style.backgroundColor = colorOne;	
	              
	   }
	   else
	   {
	              x=1;
	              for(var i = 1; i <= endVal ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				  document.getElementById("DivId"+x).style.display="block";
				   document.getElementsByName("pageIndeCmb")[0].value =  x ;
				 
	             
	   }
		  
}

function prevFunction() 
{
          var currentPage = document.forms[0].pageIndeCmb.value;
          var endVal = document.forms[0].TotalLayer.value;
          var  index = parseInt(currentPage);
               index = index -1;
          
	          if (currentPage > 1)
	          {
	              for(var i = 1; i <= endVal ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				   document.getElementById("DivId"+index).style.display="block";
	                  document.getElementsByName("pageIndeCmb")[0].value =  index ;
	            
	            
	          } 
	          else
	          {
	            alert("No More Record Left!!!!");
	          } 
	          
	       
	       
             
}
function nextFunction() 
{
         var currentPage = document.forms[0].pageIndeCmb.value;
         var   totalPage = document.forms[0].TotalLayer.value;
        
           var  index = parseInt(currentPage);
               index = index +1;
 
         if(totalPage > index)
         {	          
	             for(var i = 1; i <= totalPage ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				  document.getElementById("DivId"+index).style.display="block";
				   document.getElementsByName("pageIndeCmb")[0].value =  index ;
				 
	           
	      }
	      
	      else
	      {
	        if(totalPage == index)
	        {
	              for(var i = 1; i <= totalPage ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				  document.getElementById("DivId"+index).style.display="block";	
				   document.getElementsByName("pageIndeCmb")[0].value =  index ;			  
	     	     
	        }
	        else
	        {
	         alert("No More Record Left!!!!");
	        }   
	      }   
        
         
}       

/******************************************************************************/
function hidePopup()
 {

	hide_popup('popUpDiv');

}



function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
	document.getElementById("existingDemandId").style.display="block";
	document.getElementById("newDemandId").style.display="none";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
	document.getElementById("existingDemandId").style.display="none";
	document.getElementById("newDemandId").style.display="block";
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

function CheckedFlgValue(obj,index)
{

  if(obj.checked)
  {	 
	document.getElementById("chkFlg"+index).value='1';
  }
  else
  {
  	document.getElementById("chkFlg"+index).value='0';
  }
}

function CheckedAll(chkObj)
{
	var size=document.getElementsByName("chkFlg").length;
    if(chkObj.checked)
 	{
     	for(var i=0;i<size;i++)
		{
			document.getElementsByName("chkFlg")[i].checked=true;
			document.getElementsByName("chkFlg")[i].value='1';
		}
	 	
 	}
 	else
 	{
 		for(var i=0;i<size;i++)
		{
			document.getElementsByName("chkFlg")[i].checked=false;
			document.getElementsByName("chkFlg")[i].value='0';
		}
	 	
 	}
	
}


function cancel() {
	document.forms[0].hmode.value = "INITIALPAGE";
	document.forms[0].submit();
}

/**
 * 
 */
function initPage() 
{
    document.getElementsByName("strStoreName")[0].value="0";
    document.getElementById("strSampleSentDtlDivId").innerHTML = "";
    document.getElementById("strSampleSentDtlSearchDivId").style.display = "none";
    document.forms[0].strStoreName.disabled=false;
    document.forms[0].strItemCatgCombo.disabled=false;
    document.forms[0].strLabId.disabled=false;
    document.forms[0].reset();
	//document.forms[0].hmode.value = "FIRSTDATA";
	//document.forms[0].submit();
}

function cancel() {
	document.getElementById("errMsg").innerHTML = "";
	document.forms[0].hmode.value = "CANCEL";
	document.forms[0].submit();
}

function getItemCategoryCombo() 
{
	if(document.getElementById("strSampleSentDtlDivId")!=null)
	{
		document.getElementById("strSampleSentDtlDivId").innerHTML="";
		document.getElementById("strSampleSentDtlSearchDivId").style.display="none";
	}	
	var temp =null;
	if(document.forms[0].strStoreName!=null) {
		temp = document.forms[0].strStoreName.value;
	}
	if(temp==null || temp=="" || temp=="0") {
		var objVal = document.getElementById("ItemCatg");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onChange='getLabNameCombo();' class='comboNormal'><option value='0'>Select Value</option></select>";
		return;
	}
	var mode = "ItemCatgoryCombo";
	var url = "QcDetailOnlineTransCNT.cnt?hmode=" + mode + "&storeId="+document.forms[0].strStoreName.value;
	ajaxFunction(url, "2");
	var objVal1 = document.getElementById("labNameDivId");
		objVal1.innerHTML = "<select name = 'strLabId' onChange='setSampleSentDiv();' class='comboMax'><option value='0'>Select Value</option></select>";
}

function getLabNameCombo() 
{

	if(document.getElementById("strSampleSentDtlDivId")!=null)
	{
		document.getElementById("strSampleSentDtlDivId").innerHTML="";
		document.getElementById("strSampleSentDtlSearchDivId").style.display="none";
	}
	if(document.forms[0].strItemCatgCombo.value=="0")
   {
	
   	
   		alert("Please select drug category.");
   		
   		return false;
   }
	else
	{
		var categoryNo = document.forms[0].strItemCatgCombo.value;
		var storeId = document.forms[0].strStoreName.value;
		
		var mode = "LabNameCombo";
		var url = "QcDetailOnlineTransCNT.cnt?hmode=" + mode + "&storeId="+ storeId + "&categoryNo=" + categoryNo;
		ajaxFunction(url, "1");
	}
}

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
	  newwin.document.write(document.getElementById('sampleSenlLabelDivId').innerHTML);
	}
	
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	
function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("sampleSenlLabelDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
}

function printSampleSentLabel()
{	
	var  labSendNo  = document.forms[0].strLabSendNumber.value
	
	if(labSendNo!='0')
	{
      var mode="PRINTSAMPLESENTLABEL";
     // alert(document.forms[0].strPrintValues.value);
	  var url="QcDetailOnlineTransCNT.cnt?hmode="+mode+"&labSendNo="+labSendNo+"&strHiddenDtl="+document.forms[0].strPrintValues.value+"^"+document.forms[0].strTmpCtrNo.value;
	  //alert(url);
	  ajaxFunction(url,"6");
	} 	
}

function printSampleSentLabelView()
{	
	
	var size=document.getElementsByName("chkFlg").length;
	var strSampleSentHiddenDtlVal="0^0^0^0^0^0^0^0";
    for(var i=0;i<size;i++)
	{
			if(document.getElementsByName("chkFlg")[i].value=='1')
			{
			  strSampleSentHiddenDtlVal = strSampleSentHiddenDtlVal +"$$$$"+document.getElementById("strCheckHidValue"+i).value.replace("%", " 0/0");
			} 
			
	}	
		//alert(strHiddenDtl);
	
	  var mode="PRINTSAMPLESENTLABELVIEW";
	  var url="QcDetailOnlineTransCNT.cnt?hmode="+mode+"&strSampleSentPrintHiddenDtl="+strSampleSentHiddenDtlVal;
	  
	  ajaxFunction(url,"7");
}

function getSampleSent_With_Search() 
{
 
	
		var categoryNo    = document.forms[0].strItemCatgCombo.value;
		var storeId    	  = document.forms[0].strStoreName.value;
		var labId         = document.forms[0].strLabId.value;
		var searchType    = document.forms[0].strSearchNameCmb.value;
		var searchStrintg = document.forms[0].strSearchString.value;
		
		if(searchStrintg!='%' ||searchStrintg!='%%'||searchStrintg!='% %' )
		{
			var mode = "GET_SAMPLESENT_DTLS_WITHSEARCHSTRING";
			var url = "QcDetailOnlineTransCNT.cnt?hmode=" + mode + "&storeId="+ storeId + "&categoryNo=" + categoryNo+"&labId="+labId+"&searchType="+searchType+"&searchStrintg="+searchStrintg;
		
			ajaxFunction(url, "8");
		}
		else
		{
			alert("% Not Allowed");
			return false;
		}
	
}


function getAjaxResponse(res, mode) {

	var err = document.getElementById("errMsg");
	var temp = res.split("####");
	if (temp[0] == "ERROR") {
		err.innerHTML = temp[1];
		return;
	}
	if (mode == "1") {
		var objVal1 = document.getElementById("labNameDivId");
		objVal1.innerHTML = "<select name = 'strLabId' onChange='setSampleSentDiv();' class='comboMax'>"	+ res + "</select>";
				
			   	 
				
	}
	if (mode == "2") 
	{
		
		var objVal = document.getElementById("ItemCatg");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onChange='getLabNameCombo();' class='comboMax'>" + res + "</select>";
		getLabNameCombo();
				
	}

	if (mode == "3") {
		var objVal = document.getElementById("ItemCatgViewId");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onChange='getGroupNameCombo();' class='comboMax'>"
				+ res
				+ "</select>"
				+ " <img src='../../hisglobal/images/Go.png'"
				+ "onClick='getViewItemDtl();' align='top' style='cursor: pointer; ' title='Click Here To View Breakage Item Details'>";
	}
	if (mode == "4") {

		var storeName = document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;
		var itemCategName = document.forms[0].strItemCatgCombo[document.forms[0].strItemCatgCombo.selectedIndex].text;

		document.getElementById("strSampleSentDtlDivId").innerHTML = res;
		document.getElementById("strSampleSentDtlDivId").style.display = "block";
		//document.getElementById("strSampleSentDtlSearchDivId").style.display="block";
		
	}
	if(mode=="5")
    {
       var objVal = document.getElementById("strSampleSentDtlDivId");
       objVal.innerHTML =  res;
       document.getElementById("strSampleSentDtlSearchDivId").style.display="block";

    }
	
	if (mode == "6") 
	{				
		
		objVal = document.getElementById("sampleSenlLabelDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');
		
		
	}
	if (mode == "7") 
	{				
		
		objVal = document.getElementById("sampleSenlLabelDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');
		
		
	}
	
	if (mode == "8") 
	{
      
		document.getElementById("strSampleSentDtlDivId").innerHTML = res;
		document.getElementById("strSampleSentDtlDivId").style.display = "block";
		document.getElementById("strSampleSentDtlSearchDivId").style.display="block";
		
	}
	
	
}
function getItemCategoryComboViewPage() {

	var temp = document.forms[0].strStoreName.value.split("^");
	var mode = "ItemCatgoryCombo";
	var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&modName="
			+ temp[0];
	ajaxFunction(url, "3");
}

function transferToViewPage() 
{
	if (document.getElementsByName("strViewChk")[0].checked) 
	{
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	}
}

function clearViewPage()
{
	document.forms[0].hmode.value = "VIEWPAGE";
	document.forms[0].submit();
}


function getViewItemDtl() 
{

	var hisValidator = new HISValidator("qcDetailOnlineTransFB");

	hisValidator.addValidation("strStoreName", "dontselect=0","Please Select a HQ Name");
	hisValidator.addValidation("strItemCatgCombo", "dontselect=0","Please Select a Drug Category");
	hisValidator.addValidation("strFromDate", "req","From Date is a Mandatory Field");
	hisValidator.addValidation("strToDate", "req","To Date is a Mandatory Field");
	hisValidator.addValidation("strToDate", "dtgtet="+document.forms[0].strFromDate.value,"To Date should be Greater Than or Equal From Date");
	
	var retVal = hisValidator.validate();
	
	
	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
  
     if(parseInt(diffdate)>365)
     {
        alert("Difference Between From Date and To Date Should not be greater than 365 days");
		return false;
	 }

	if (retVal)
	{
	
		var temp = document.forms[0].strStoreName.value;
		var mode = "GOVIEWPAGE";
		var url = "QcDetailOnlineTransCNT.cnt?hmode=" + mode + "&storeId="
				+ temp + "&itemCatNo="
				+ document.forms[0].strItemCatgCombo.value + "&fromDate="
				+ document.forms[0].strFromDate.value + "&ToDate="
				+ document.forms[0].strToDate.value
				+"&labId="+document.forms[0].strLabId.value;
		ajaxFunction(url, "4");
	}
	else
	{
		return false;
	}  
}


function showPopUp(obj, i) 
{
	indexglobal = i;
	parentPopup = obj;

	var mode = "GETPOPUP";
	var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&hiddenVal="
			+ document.getElementById('strHlpIssueNo' + i).value + "&index="
			+ i + "&storeId=" + document.forms[0].strStoreName.value
			+ "&itemCatNo=" + document.forms[0].strItemCatgCombo.value
			+ "&fromDate=" + document.forms[0].strFromDate.value + "&ToDate="
			+ document.forms[0].strToDate.value;
	// alert("url-"+url);
	ajaxFunction(url, "5");

}

// function to show report after save data
function getReport() {

//	var issueNo = document.forms[0].strTmpIssueNo.value;
//	var storeId = document.forms[0].strTmpStoreNo.value;
//	var IndentNo = document.forms[0].strTmpIndentNo.value;
//	var IndentDate = document.forms[0].strTmpIndentDate.value

//	if (issueNo != "0") {
	//	getIssueDtls('2', storeId, issueNo, IndentNo, IndentDate);
//	}
//	document.forms[0].strTmpIssueNo.value = "0";
}

function generateIssueReportFunc(obj, i) {
	indexglobal = i;
	parentPopup = obj;
	var issueNo = document.getElementById('strHlpIssueNo' + i).value;
	var storeId = document.forms[0].strStoreName.value;
	var IndentNo = document.getElementById('strHlpIndentNo' + i).value;
	var IndentDate = document.getElementById('strHlpIndentDate' + i).value
	// alert("IssueNo::"+issueNo+"::Store ID::"+storeId+"::Indent
	// No::"+IndentNo+"::Indent date::"+IndentDate);
	if (issueNo != "0") {
		getIssueDtls('2', storeId, issueNo, IndentNo, IndentDate);
	}

}



function setDefaultValue(elementQty) 
{
	if(elementQty.value=="") 
	{
		elementQty.value="0";
	}
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
	 

function drugDtl(obj,index) 
{
	parentPopUp = obj;

	var strBalQtyDetail = document.getElementById("strPrintLabelValue"+index).value;
	alert(strBalQtyDetail);

	myArray = strBalQtyDetail.split("^");

	/*
		      			   
	    1. LAB_NAME	
	    2. ITEMNAME
	    3. BATCHNO	
	   	4. EXPIRYDATE	
	    5. CTR_NO	
	    6. QC_STATUS	
	    7. REPORT_DATE_TIME	
	    
	    
	    8. STORENAME	
	    9. MFGDATE	
	   10. HSTNUM_ITEM_ID	
	   11. HSTNUM_STORE_ID	
	   12. HSTNUM_LAB_SEND_NO	
	   13. HSTNUM_ITEMBRAND_ID	
	   14. HSTDT_LAB_SEND_DATE	
	   15. HSTSTR_ITEM_SL_NO	
	   16. HSTNUM_STOCK_STATUS_CODE	
	   17. HSTNUM_INHAND_QTY	
	   18. MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_INHAND_QTY_UNITID)	
	   19. HSTNUM_RATE	
	   20. HSTNUM_RATE_UNITID	
	   21. HSTNUM_SUPPLIER_ID	
	   22. GSTR_SEND_REAMRKS	
	   23. GSTR_RECEIVE_REAMRKS	
	   24. HSTNUM_IS_RESEND	
	   25. HSTNUM_PO_NO
	   26. HSTDT_PO_DATE
	   27. HSTNUM_MANUFACTURER_ID
			   			
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
	
	
     
     

	display_popup_menu(parentPopUp, 'drugDtlId', '300', '');

}
	 

function hideDrugDetails(divId) 
{
	hide_popup_menu(divId);
}


function getQcOnlineDetails()
{
	   var hisValidator = new HISValidator("qcDetailOnlineTransFB");
         
          hisValidator.addValidation("strStoreName","dontselect=0","Please Select HQ Name");
          hisValidator.addValidation("strItemCatgCombo","dontselect=0","Please Select Drug Category");		
          
          hisValidator.addValidation("strLabId","dontselect=0","Please Select Lab Name");		
      

      
            
 		 var retVal = hisValidator.validate(); 

          if(retVal)
          {
          	        document.forms[0].strStoreName.disabled=true;
          	        document.forms[0].strItemCatgCombo.disabled=true;
          	        document.forms[0].strLabId.disabled=true;
 				   	var mode = "GETSAMPLESENTDTLS";
	
					 var url ="QcDetailOnlineTransCNT.cnt?hmode="+mode
				        +"&storeId="+document.forms[0].strStoreName.value
				        +"&categoryCode="+document.forms[0].strItemCatgCombo.value
				        +"&labNo="+document.forms[0].strLabId.value;
				        
				        
				 		ajaxFunction(url,"5");
          }
          else
          {
             return false;
          }
	
	

}
function validate1()
{
	var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
				var size=document.getElementsByName("chkFlg").length;
				var count=0;
			
			  	for(var i=0;i<size;i++)
				{
			    	if(document.getElementsByName("chkFlg")[i].checked)
			    	{
			    		count = 1;
			    		break;
			    	}
				}
				
				if(count==0){
					 alert("Please Select atleast One record");
					 saveObj.style.display = '';
					 return false;
				}
				
			
			  var hisValidator = new HISValidator("qcDetailOnlineTransFB");
		         
		      hisValidator.addValidation("strStoreName","dontselect=0","Please Select HQ Name");
		      hisValidator.addValidation("strItemCatgCombo","dontselect=0","Please Select Drug Category");		      
		      hisValidator.addValidation("strLabId","dontselect=0","Please Select Lab Name");		
		      hisValidator.addValidation("strCTRNumber", "req","CTR Number is a Mandatory Field");
		      hisValidator.addValidation("strReceiveDate", "req","Received Date is a Mandatory Field");
		      hisValidator.addValidation("strReceiveDate", "dtltet="+document.forms[0].strCurrentDate.value,"Received Date should be Less than or Equal to Current Date"); 
			  //hisValidator.addValidation("strReceiveDate", "dtgtet="+document.forms[0].strReportDate.value,"Received Date should be Greater than or Equal to Report Date"); 
			 // alert("document.forms[0].strSampleSendDate.value "+document.forms[0].strSampleSendDate.value );
			  hisValidator.addValidation("strReceiveDate", "dtgtet="+document.forms[0].strSampleSendDate.value,"Received Date should be Greater than or Equal to Sample Send Date : "+document.forms[0].strSampleSendDate.value +" of Selected Record"); 				
		      hisValidator.addValidation("strReportNumber", "req","Report Number is a Mandatory Field");
		      hisValidator.addValidation("strReportDate", "req","Report Date is a Mandatory Field");
		      
		      if(document.forms[0].strReportDate.value!='')
		      {
					hisValidator.addValidation("strReportDate", "dtltet="+document.forms[0].strCurrentDate.value,"Report Date should be Less than or Equal to Current Date"); 
			  		hisValidator.addValidation("strReportDate", "dtltet="+document.forms[0].strReceiveDate.value,"Report Date should be Less than or Equal to Received Date");      	
		      }
		       		
		      
		      //hisValidator.addValidation("strLabInchargeName", "req","Lab In-Charge Name is a Mandatory Field");
			  var retVal = hisValidator.validate(); 
				hisValidator.clearAllValidations();
			
		  	if(retVal)
		  	{
		  		
												           
			              var conf = confirm("You Are Going To Save Records");
		                  if(conf == true)
		                  {
		                       var conf1 = confirm("Are you sure !!!");
		                       if(conf1 == true)
		                       {
		                           document.forms[0].strStoreName.disabled=false;
				          	        document.forms[0].strItemCatgCombo.disabled=false;
				          	        document.forms[0].strLabId.disabled=false;
						
									//alert("strCheckHiddenValues :"+document.forms[0].strCheckHiddenValues.value);
									var mode = "SAVEQCDETAIL";
								 	document.forms[0].hmode.value = mode;
								  	document.forms[0].submit();
		                       }
		                      else
		                       {
		                       	 saveObj.style.display = '';
		                         return false;
		                       }
		                   }
		                  else
		                   {	saveObj.style.display = '';
		                        return false;
		                   }
				
				
				 
		  	}
		  else
		  {
		  	 saveObj.style.display = '';
		     return false;
		  }
		  
  }
  else
  {
  	    saveObj.style.display = '';
		return false;
  }  
}

function CheckedFlg(obj,index)
{

	if(obj.checked)
	{
		document.forms[0].strCheckHiddenValues.value = document.getElementById("strCheckHidValue"+index).value;
		document.forms[0].strTmpPrintValues.value    = document.getElementById("strCheckHidValue"+index).value;
		document.forms[0].strSampleSendDate.value    = document.getElementById("strCheckHidValue"+index).value.split("^")[1];
		
			
	}
	//alert(document.forms[0].strCheckHiddenValues.value);
}


function clearSampleSentData()
{
		document.getElementById("strSampleSentDtlDivId").innerHTML="";
		
			
}

function drugDtl(obj,index) 
{
	parentPopUp = obj;

	var strBalQtyDetail = document.getElementById("strCheckHidValue"+index).value;

	myArray = strBalQtyDetail.split("^");

/*
					 1- Item Id
					 2- Lab Sent Date
					 3- Sent Store Name
					 4- Generic Name
					 5-Brand Name
					 6- Batch
					 7-Exp Date
					 8-Transfer Qty
					 9-Store Id Sent
					 10-Item Id
					 11-Item Brand ID
					 12-Rate With Unit
					 13-Rate Base value
					 14-Consumed Qty
					 15=Consumed Qty Wit Unit
					 16-Qty Base Value
					 17-Item Sl No
					 18-Item Sl No
					 19-Catg Code
					 20- Lab Send No
					 21-Lab Name
					 22-CTR Number
					 23-Net Cost
					 24-PO No
					 25-PO Date
					 26-Mfd Date
					 27-Is Send Decode Value */


	var objVal1 = document.getElementById("1");
	
	if (myArray[23] != 'null' || myArray[23] != '') 
	{
		objVal1.innerHTML = myArray[23];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[24] != 'null' || myArray[24] != '') 
	{
		objVal2.innerHTML = myArray[24];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}


    var objVal3 = document.getElementById("3");

	if (myArray[6] != 'null' || myArray[6] != '') 
	{
		objVal3.innerHTML = myArray[6];
	} 
	else 
	{
		objVal3.innerHTML = "  ----";
	}
	
	var objVal4 = document.getElementById("4");

	if (myArray[25] != 'null' || myArray[25] != '') 
	{
		objVal4.innerHTML = myArray[25];
	} 
	else 
	{
		objVal4.innerHTML = "  ----";
	}
	
	var objVal5 = document.getElementById("5");

	if (myArray[26] != 'null' || myArray[26] != '') 
	{
		objVal5.innerHTML = myArray[26];
	} 
	else 
	{
		objVal5.innerHTML = "  ----";
	}
     
     

	display_popup_menu(parentPopUp, 'drugDtlId', '300', '');

}




// function for Reference Detail to block or hide
function ftn11()
{     
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("referenceDetailsDivId").style.display="block";
    document.getElementById("minus1").style.display="block";
    document.getElementById("plus1").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus1").style.display="none";
    document.getElementById("plus1").style.display="block";
    document.getElementById("referenceDetailsDivId").style.display="none";
    document.forms[0].button1.value = 0;
   } 
  
}

function setSampleSentDiv(){
	
		
		
		document.getElementById("strSampleSentDtlDivId").innerHTML="";
		//document.getElementById("breakageItemDtlId").innerHTML="";
	
}
