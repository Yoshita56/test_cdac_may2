
function calCostBaseOnUnit(index)
{	        
	        var cost     = document.getElementById("strTransferCost"+index).value;
	        var rateObj  = document.getElementById("itemCalcValue"+index).value;
	        var qtyObj   = document.getElementById("strTransferQty"+index).value;
	        var dispCost = document.getElementById("strTransferCostDivId"+index).value;	       
	        cost  = roundValue(parseFloat(qtyObj * rateObj), 2);
	        document.getElementById("strTransferCost"+index).value = cost;
	        document.getElementById("strTransferCostDivId"+index).value = cost;
	       //  alert("cost::"+cost+"::Rate::"+rateObj.split("^")[5]+"::Qty::"+qtyObj);
			totalCost(index);			
}
function totalCost(index)
{	   
            var cost     = document.getElementById("strTransferCost"+index).value;
	        var rateObj  = document.getElementById("itemUserValue"+index).value;
	        var delArray = document.getElementById("itemParamValue"+index).value;
	        
	       
	        var dispCost = document.getElementById("strTransferCostDivId"+index).value;
	        	        
       	    var costObj   = document.getElementsByName("strTransferCost");
       	    var delArray  = document.getElementsByName("itemParamValue");
       	     var qtyObj   = document.getElementsByName("strTransferQty");
			var total   = parseFloat("0.00");	
			var newStr  = ""; 
			var flag    = true;	
			var UnitName ;
		   	if (costObj.length > 0) 
			{	       			
		 		
		 		for ( var i = 0; i <costObj.length-1; i++)
				{		
				  total = total + parseFloat(costObj[i].value);        	
					if(flag)
			        {			 //    Drug Name                  #            Rate                  ""  Unit Name            #     Quantity      #      Cost          
			            newStr = delArray[i].value.split("^")[0]+"^"+delArray[i].value.split("^")[2]+"^"+qtyObj[i].value+"^"+costObj[i].value;
						flag = false;
					 }
					 else
					 {                        //    Drug Name                  #            Rate                  "" Unit Name #    Quantity      #      Cost  
					    newStr= newStr+"$$$$"+delArray[i].value.split("^")[0]+"^"+delArray[i].value.split("^")[2]+"^"+qtyObj[i].value+"^"+costObj[i].value;
					 }	
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strTotalTransferCostDivId").innerHTML = total;
        document.forms[0].strTotalTransferCost.value=total;
        document.getElementById("strHiddenValue").value = newStr; 
       
}
 
 
 

function cancel()
{
	 	document.forms[0].hmode.value="INITIALPAGE";
		document.forms[0].submit();
}
 

function initPage()
{
  document.forms[0].hmode.value="FIRSTDATA";
  document.forms[0].submit();
}

 function cancel()
 {
        document.getElementById("errMsg").innerHTML = "";
	 	document.forms[0].hmode.value = "CANCEL";
  	    document.forms[0].submit();
 }
  

function hideTransferPopup()
{
          document.getElementById("transferDtlsDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');			
}
function printCostEstimation()
{
  if(document.forms[0].strHiddenValue.value!='')
  {
  //var hidden = document.forms[0].strHiddenValue.value.replace("%","@@@");
  var hidden = document.forms[0].strHiddenValue.value;
   var mode="PRINTCOST";
   
   var url="CostEstimationCNT.cnt?hmode="+mode+"&hidden="+hidden+"&totalCost="+document.forms[0].strTotalTransferCost.value;
   url = (url.replace(/%/g, '0/0'));
   //alert(url);
   
   ajaxFunction(url,"1");
  }
  else
  {
     alert("Please Select at least one Drug Name!!!");
     return false;
  }  

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
        objVal = document.getElementById("transferDtlsDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');
        
     }
}

function printData() 
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
	
	newwin.document.write(document.getElementById('transferDtlsDivId').innerHTML);
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	
 
  