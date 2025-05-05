

 // Developer : Pramod Kumar Mehta 
 // Version : 1.0 
 // Date : 01/April/2009
 //  Module:MMS
 // Unit:issue details view  
 
function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}
// global variable


var parentPopUp = "";

function approvalDtl(obj,i){    
    
    parentPopUp = obj;
    
        var strApprovedDetail = document.getElementById("strApprovedDtl"+i).value;        
       
        myArray = strApprovedDetail.split("^");
       
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
        
        var strAppQty = obj.title;

        if(parseInt(strAppQty) > 0){      
                              
			display_popup_menu(parentPopUp,'approvedDtl','300','');
		
		}else{
		
			alert("Approved Quantity should be greater than zero");
		
		}
	}
