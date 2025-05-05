// Java Script Class for Inspection View:

/**
 *  global variable 
 */
var parentPopup="";


/**
 * 
 */
 
 function showPopUp(obj,i){	
	parentPopup = obj;
	alert("showPopUp strItemIdID-->"+document.getElementById('strItemHiddenID'+i).value);
		var hidVal = document.getElementById('strItemHiddenID'+i).value +"@"+i;
	    var mode = "GETPOPUPREPORT";
		var url = "InspectionViewTransCNT.cnt?hmode="+mode+"&popupReport="+hidVal;
		ajaxFunction(url,"1");
	}


function getAjaxResponse(res,mode)
{
	alert(res);
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	  {
          	err.innerHTML = temp[1];
          	return;
      } 
       else{
	
		if(mode==1)	
		{
			var obj=document.getElementById("popup");
           	temp=res.split("@");
	 		i=temp[1];
	 	//	document.getElementById('flag'+i).value=temp[1];
	 		obj.innerHTML  = temp[0];
			display_popup_menu(parentPopup,'popup','200','200'); 
		}
	}
}


 function cancel()
 {
 document.forms[0].hmode.value = "CANCEL";
				document.forms[0].submit();
 }