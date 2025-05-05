function getDrugNameSelected(itemId, selectId)
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
		displaySelectedDrug(selectId);		
	}	    
	 
}

function displaySelectedDrug(selectId) 
{ 
  	document.getElementById("DrugNameId").innerHTML = $("#"+selectId+" option:selected").text();
} 