
/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validate1()
 {
     
	  var hisValidator = new HISValidator("bkgItemDtlTransBean");  
	  hisValidator.addValidation("strStoreName","dontselect=0","Please select a value from Drug Warehouse Name Combo" );
	  hisValidator.addValidation("strItemCatgCombo","dontselect=0","Please select a value from Item Category Combo" );
	  //hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
	 
       var retVal = hisValidator.validate(); 
	  hisValidator.clearAllValidations();
	  if(retVal){
	  	
		 if(document.getElementsByName("itemParamValue").length=="1"){
     							alert("Please Search Item Details");
     							document.getElementsByName("strGroupIdForItemSearch")[0].focus();
     							return false;
      	}
	  }
	  
	  if(retVal){
		     
			      hisValidator.addValidation("strBkgQty","req","Bkg Qty is a Mandatory Field" );
				  hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
				  hisValidator.addValidation("strApprovedBy","dontselect=0","Please select a value from Approved By Combo" );
				   
		//	 hisValidator.addValidation("strApprovedDate", "date","Approved Date is a mandatory field");
		//	 hisValidator.addValidation("strApprovedDate","dtgtet="+document.forms[0].strCurrentDate.value,"Please Select Approved Date Less Than or Equal To Current Date");
			  
			  hisValidator.addValidation("strAprovedRemarks","req","Approved Remarks is a Mandatory Field" );
			  hisValidator.addValidation("strAprovedRemarks", "maxlen=100", "Approved Remarks should have less than or equal to 100 Characters" );
			  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
			  
			  
			  
			   var retVal = hisValidator.validate(); 
	  hisValidator.clearAllValidations();
	  }
	 
	  
	 
	  
	  var itemParVal  = document.getElementsByName("itemParamValue");

 	  for(var x=0;x<itemParVal.length-1;x++)
      {
      		document.getElementsByName("strUnitName")[x].disabled = false;
      		document.getElementsByName("strCostFinal")[x].disabled=false;
      		
      }

      var unitNameCmb = document.getElementsByName("strUnitName");

      var bkgQty  = document.getElementsByName("strBkgQty");

      var myArray   = new Array();

      var myArray1  = new Array();

      var bkgQtyVal="0";

      for(var x=0;x<itemParVal.length-1;x++)
      {
       //s alert("itemParVal"+x+"->"+itemParVal[x].value);

        if(retVal)
        {
          myArray = itemParVal[x].value.split("^");
      //    alert("unitNameCmb[x]->"+unitNameCmb[x].value);
          myArray1 = unitNameCmb[x].value.split("^");
       //   alert("parseInt(myArray1[1])-->>>"+parseInt(myArray1[1]));
       //   alert("parseInt(bkgQty[x])-->>>"+parseInt(bkgQty[x].value));
          bkgQtyVal=parseInt(bkgQty[x].value)* parseInt(myArray1[1]); 
       //   alert("bkgQty[x]* myArray1[1] ------>( bkgQtyVal )->"+bkgQtyVal);
        //  alert("In Hand Qty [3]->"+myArray[3]);
          if(bkgQtyVal>myArray[3])
          {
        	 bkgQty[x].value = '0';
        	 unitNameCmb[x].value = '0';
             alert("Breakage Qty cannot be greater than InHand Qty!!");
             retVal=false;
          } 
        } 
      }
      if(retVal)
      {
		                              var conf = confirm("You Are Going To Save Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {
					                          document.forms[0].hmode.value = "INSERT";
                                              document.forms[0].submit();
					                       }
					                      else
					                       {
					                         return false;
					                       }
					                   }
					                  else
					                   {
					                         return false;
					                   }
			                		
	  }
	    else
	    {
		  return false;
		}
 }
	 

function cancel()
{
	 	document.forms[0].hmode.value="INITIALPAGE";
		document.forms[0].submit();
}
 
/**
 * 
 */
function initPage()
{
  document.forms[0].hmode.value="FIRSTDATA";
  document.forms[0].submit();
}

 function cancel()
 {
        document.getElementById("errMsg").innerHTML = "";
        window.parent.closeTab();
	 	/*document.forms[0].hmode.value = "CANCEL";
  	    document.forms[0].submit();*/
 }
 
 function getItemCategoryCombo()
 {  
   var temp = document.forms[0].strStoreName.value.split("^");
   var mode="ItemCatgoryCombo";
   var url="BreakageItemDtlTransCNT.cnt?hmode="+mode+"&modName="+temp[0];
   ajaxFunction(url,"2"); 
 }
 function getGroupNameCombo()
 {
 
   var temp = document.forms[0].strItemCatgCombo.value;
   var mode="GRPNAMECOMBO";
   var url="BreakageItemDtlTransCNT.cnt?hmode="+mode+"&modName="+temp;
   ajaxFunction(url,"1"); 
 }
 
  function getApprovedByCombo() 
  {
		var temp =null;
		if(document.forms[0].strStoreName!=null) 
		{
			temp = document.forms[0].strStoreName.value;
		}
		if(temp==null || temp=="" || temp=="0") 
		{
			var objVal = document.getElementById("ApprovedBy");
			objVal.innerHTML = "<select name = 'strApprovedBy'  class='comboNormal'><option value='0'>Select Value</option></select>";
			return;
		}
		var mode = "ApprovedByCombo";
		var url = "BreakageItemDtlTransCNT.cnt?hmode="+mode+"&modName="+temp;
		ajaxFunction(url, "5");
	}
 
 
 function getAjaxResponse(res,mode)
 {
     
    
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	  {
          	err.innerHTML = temp[1];
          	return;
      } 
     if(mode=="1")
     {
        var objVal1 = document.getElementById("GrpName");
        objVal1.innerHTML = "<select name = 'strGroupIdForItemSearch' class='comboNormal'>" + res + "</select>";
       
     }
     if(mode=="2")
     {
        var objVal = document.getElementById("ItemCatg");
        objVal.innerHTML = "<select name = 'strItemCatgCombo' class='comboNormal'>" + res + "</select>";
         getApprovedByCombo();
     }
     
      if(mode=="3")
     {
        var objVal = document.getElementById("ItemCatgViewId");
        objVal.innerHTML = "<select name = 'strItemCatgCombo' class='comboNormal' onchange='getGroupNameCombo();'>" + res + "</select>";
        
        /*" <img src='../../hisglobal/images/Go.png'"+
        "onClick='getViewItemDtl();' align='top' style='cursor: pointer;' title='Click Here To View Breakage Item Details'>";*/
     }
      if(mode=="4"){
      	
      				var storeName=document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;
      				var itemCategName=document.forms[0].strItemCatgCombo[document.forms[0].strItemCatgCombo.selectedIndex].text;
      				
			      	document.getElementById("breakageItemDtlId").innerHTML=res;
			      	document.getElementById("breakageItemDtlId").style.display="block";
			      	/*document.getElementById("ItemCatgViewId").style.display="none";
			      	document.getElementById("storeComboNameID").style.display="none";
			      	document.getElementById("storeComboID").innerHTML=storeName;
			      	document.getElementById("itemCategViewNameID").innerHTML=itemCategName;
			     	document.getElementById("storeComboNameID").style.display="block";
			      	document.getElementById("itemCategViewNameID").style.display="block";*/
	 }
	 if(mode=="5")
	  {	  	    
	 	    document.getElementById("ApprovedBy").innerHTML  = "<select name = 'strApprovedBy' class='comboMax' >" + res + "</select>";
     
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
function getItemCategoryComboViewPage()
 {
  
   var temp = document.forms[0].strStoreName.value.split("^");
   var mode="ItemCatgoryCombo";
   var url="BreakageItemDtlTransCNT.cnt?hmode="+mode+"&modName="+temp[0];
   ajaxFunction(url,"3"); 
 }

function transferToViewPage()
{
	if(document.getElementsByName("strViewChk")[0].checked){
		document.forms[0].hmode.value="VIEWPAGE";
		document.forms[0].submit();
	}
}

function getViewItemDtl()
{
	
 	if(document.getElementsByName("strStoreName")[0].value=="0"){
		alert("Please Select Store From Combo");
		return false;
	}
	if(document.getElementsByName("strItemCatgCombo")[0].value=="0"){
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
	
	else{
		var temp = document.forms[0].strStoreName.value;
	    var mode="GOVIEWPAGE";
	    var url="BreakageItemDtlTransCNT.cnt?hmode="+mode+"&storeId="+temp+"&itemCatNo="+document.forms[0].strItemCatgCombo.value+"&startDate="+document.forms[0].strFromDate.value+"&endDate="+document.forms[0].strToDate.value;
	    ajaxFunction(url,"4"); 	
	}
	
}
function GetIndex(index,endVal)
{
   // alert("index--.>"+index+"<-Total Recrd-->"+endVal);
          for(var i = 1; i <= endVal ; i++)
		  {
		  //  alert(i+"<---i-->"+document.getElementById("DivId"+i).style.display);
		    document.getElementById("DivId"+i).style.display="none";
		  }
		 // alert("before-->>"+document.getElementById("DivId"+index).style.display);
		  document.getElementById("DivId"+index).style.display="block";
		 // alert("before-->>"+index+"<div>"+document.getElementById("DivId"+index).style.display);
			 
}
 
 
    