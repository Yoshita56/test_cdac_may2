// Developer : Pramod Kumar Mehta 
// Version : 1.0 
// Date : 08/April/2009
//  Module:MMS
// Unit:Agenda view Details
 
function hideIndentDetails(divId)
{
      hide_popup_menu(divId);
}

function hideCompiledItemDetails(divId)
{
      hide_popup_menu(divId);
}

// global variable

var parentPopUp = "";


// function for hlp of indent details

function indentDtl(obj,i){   
	parentPopUp = obj; 
    var strIndentDetail = document.getElementById("strIndentDtl"+i).value;        
	myArray = strIndentDetail.split("^");
	var objVal1 = document.getElementById("1");
	if(myArray[2]!='null' || myArray[2]!=''){
		objVal1.innerHTML = myArray[2];
	} else {
		objVal1.innerHTML = "  ----";
	}
	var objVal2 = document.getElementById("2");
	if(myArray[0]!='null'){
		objVal2.innerHTML = myArray[0]; 
	} else {
		objVal2.innerHTML = "  ----";
	}  
	var objVal3 = document.getElementById("3");
	if(myArray[3]!= 'null'){
		objVal3.innerHTML = myArray[3];  
	} else {
		objVal3.innerHTML = "  ----";
	}
	var objVal4 = document.getElementById("4");
	if(myArray[1]!= 'null'){
		objVal4.innerHTML = myArray[1];  
	} else {
		objVal4.innerHTML = "  ----";
	} 
	display_popup_menu(parentPopUp,'indentDtlId','300','');
}
	
	
	// function for hlp of compiled item details
	
	function compiledItemDtl(obj,i){   
	
	parentPopUp = obj;  
    
        var strCompiledItemDetail = document.getElementById("strCompItemDtl"+i).value;        
       
        myArray = strCompiledItemDetail.split("^");
       
        var objVal1 = document.getElementById("1");
       
        if(myArray[2]!='null' || myArray[2]!='')
        {
          objVal1.innerHTML = myArray[2];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[0]!='null')
        {
          objVal2.innerHTML = myArray[0]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("3");
        
        if(myArray[1]!= 'null')
        {
          objVal3.innerHTML = myArray[1];  
        }
        else
        {
          objVal3.innerHTML = "  ----";
        } 
        
        	display_popup_menu(parentPopUp,'compiledItemId','300','');
       
	}
	
