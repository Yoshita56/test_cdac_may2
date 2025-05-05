

	// Global Variables
	
	var defaultColor = "blue";
	var setColor = "red";
			var child = null;
			var popIndex = 0;
			var gblCntrlObj = null;
	
	// gblRowPerPage - which determines how many record should be shown in a Page, also determines how many record should be fetch from 
	var gblRowPerPage = "10";
	
/**
 * showPatientListingWindow
 * @param {String} mode  -  1 is Cash Collection.
 * 							2 is Discount Approval.
 * 							3 is Refund Approval.
 * 							4 is Billing Reconcillation.
 * 							5 is Online Request Cancellation.
 * 							6 Online Bill Cancellation.
 *							7 Guarantor Name List.
 * 
 *  @param {String} Obj - Cr Number Text Box
 * @param {String} userJsFunctionName - User Defined Function. 
 */
 function showMmsListingWindow(mode , obj , userJsFuncName) 
 {
  	if(obj.value == "" && obj.disabled == false)
  	{
 				var hmode = "MMSLISTING"; 
				
				var url = 'MmsCNT.cnt?hmode='+hmode+"&mmsList="+mode+"&usrFuncName="+userJsFuncName;				
					
				openPopUp(url,'700','400','1',null);
						
 	}
				
 }
 
 
 
/**
 * showMmsListingWindow
 * @param {String} mode  -  1 is Cash Collection.
 * 							2 is Discount Approval.
 * 							3 is Refund Approval.
 * 							4 is Billing Reconcillation.
 * 							5 is Online Request Cancellation.
 * 							6 Online Bill Cancellation.
 *							7 Guarantor Name List.
 * 
 *  @param {String} Obj - Cr Number Text Box
 *  @param {String} userJsFunctionName - User Defined Function. 
 * @param {String} deptCode - Department code.
 */
 
  
 function showMmsListingWindowWithDeptCode(mode , obj , userJsFuncName , deptCode) 
 {
  	if(obj.value == "" && obj.disabled == false)
  	{
 				var hmode = "MMSLISTING"; 
				
				var url = 'MmsCNT.cnt?hmode='+hmode+"&mmsList="+mode+"&usrFuncName="+userJsFuncName+"&deptCode="+deptCode;				
						
				openPopUp(url,'700','400','1',null);
						
 	}
				
 }
 
 
 
 /**
  * fetchMmsList
  * @param {String} mmsListType 
  */
  function fetchMmsList(fromRows,blockSet) {
  	
  		
  		var convString = "";
  		
  		var searchString = document.forms[0].strSearchString.value ;
  		var searchType =  document.forms[0].strSearchType[document.forms[0].strSearchType.selectedIndex].value;
  		
  		convString = searchString;
  		
  		if(searchString.indexOf('%') != -1){
  			
  			var searchArr = searchString.split("%");
  			for(var i=0;i<searchArr.length;i++)
  				if(i == 0)
  					convString = searchArr[i];
  				else
  					convString = convString + "^" + searchArr[i];
  		}
  		
  		
  	var hmode = "FETCHMMSLISTING"; 
  
  	var url = "MmsCNT.cnt?hmode="+hmode+"&mmsListType="+document.forms[0].mmsListType.value+"&searchString="+convString+"&searchType="+searchType+"&fromRow="+fromRows+"&rowPerPage="+gblRowPerPage+"&ctBlockSet="+blockSet;
			
		ajaxFunction2(url,"1","getMmsListDetailAjaxResponse");
  	
  	
  }
  
  /**
   * getMmsListDetailAjaxResponse
   * @param {String} res
   * @param {String} mode  
   */
   function getMmsListDetailAjaxResponse(res , mode) {
   	
   		if(mode == '1'){

			var objEle = document.getElementById("fetchRecordDivId");
						
			var resultVal = res.split("####");
						
			if(resultVal[0] == "ERROR"){
				
				objEle.innerHTML = "<table width='100%'align='center' cellspacing='1px'><tr><td class='multiControl'><b><font color='red'>"+resultVal[1]+"</font></b></td></tr></table>";
				
			}else{
				objEle.innerHTML = res;
			}
			
			
		}
   	
   }
   
  /**
   	 * setCrNo
   	 * @param {String} result 
   	 */
   	 function setPONo() {
   	 		
   	 		var poNoObj = document.getElementsByName("strPoNo");
   	 		var flag = false;
   	 		for(var i = 0, end = poNoObj.length ; i < end ; i++){
   	 			
   	 			if(poNoObj[i].checked){
   	 				
   	 				var result = poNoObj[i].value;
   	 				flag = true;
   	 				 window.close();
					window.opener.eval(document.forms[0].userJsFunctionName.value+"('"+result+"')");
   	 			}
   	 			
   	 		}
   	 		
   			if(! flag) alert("Please Select a Record");
	
   	 }
   
   
    function layerIndexNavigator(index,endVal){
		
			hideAll(endVal);
		
		initObj = document.getElementsByName("linId");
		
		if(initObj.length > 0){
			
			for(var i = 0 , len = initObj.length ; i < len ; i ++ ){
				
				initObj[i].style.color = defaultColor;
			}
			
	}
		
		
		
		obj = document.getElementById("linId"+index);
		if(obj != null) obj.style.color = setColor;
		
		document.getElementById("tariffDivId"+index).style.display="block";
	}
   
  /* function layerIndexNavigator(index,endVal){
		
			hideAll(endVal);
		
		document.getElementById("tariffDivId"+index).style.display="block";
	}
   */
   function hideAll(endVal){
	
		for(var i = 1; i <= endVal ; i++){
			document.getElementById("tariffDivId"+i).style.display="none";
		}
		
	}   
	
	
	/**
	 * getSearchPatListBySearch
	 * @param {Event} eve 
	 */
	 function getSearchMmsListBySearch() {
	 	
	 	var searchType =  document.forms[0].strSearchType[document.forms[0].strSearchType.selectedIndex].value;
	 	
	 	if (searchType == "1") {
	 		
	 				var hisValidator = new HISValidator("billingBean");  
	
					hisValidator.addValidation("strSearchString", "req", "Please Enter Cr Number" );
					hisValidator.addValidation("strSearchString", "numgt=0", "Cr Number Should be a Number" );
	
					var retVal = hisValidator.validate(); 
					hisValidator.clearAllValidations();
		
					if(retVal){
						fetchMmsList('1','1');
	 				}else{
						return false;
					}
	 		}else{
	 			
	 			var hisValidator = new HISValidator("billingBean");  
	
					hisValidator.addValidation("strSearchString", "req", "Please Enter Patient Name" );
				
	
					var retVal = hisValidator.validate(); 
					hisValidator.clearAllValidations();
		
					if(retVal){
						fetchMmsList('1','1');
	 				}else{
						return false;
					}
	 		}
	 		 return false;
	 		
	 	} 

	 
	 
	 function validateSearchText(eve){
	 	
	 		if(eve.keyCode == 13){
	 				
	 			var searchType =  document.forms[0].strSearchType[document.forms[0].strSearchType.selectedIndex].value;
  	
	 			if (searchType == "1") {
	 		
	 				var hisValidator = new HISValidator("billingBean");  
	
					hisValidator.addValidation("strSearchString", "req", "Please Enter Cr Number" );
					hisValidator.addValidation("strSearchString", "numgt=0", "Cr Number Should be a Number" );
	
					var retVal = hisValidator.validate(); 
					hisValidator.clearAllValidations();
		
					if(retVal){
						fetchMmsList('1','1');
	 				}else{
						return false;
					}
	 		}
	 		 return false;
		 }
		 
		
	 }
	 
	 /**
	 * showCltDetails - shows the given divId by showing the minus image and hiding the plus image.
	 * @param {object} divId - div id which should be shown.
	 */
	function showHelpDetails(divId){
		
		document.getElementById(divId).style.display="block";
				
		document.getElementById('minus'+divId).style.display="block";
		document.getElementById('plus'+divId).style.display="none";
		
	}
	
	
	
	/**
	 * hideCltDetails - hide the given divId by hiding the minus image and showing the plus image.
	 * @param {object} divId - div id which should be shown.
	 */
	function hideHelpDetails(divId){
		document.getElementById(divId).style.display="none";
			
		document.getElementById('minus'+divId).style.display="none";
		document.getElementById('plus'+divId).style.display="block";
		
	}
	
	
	/**
	 * configPatListType
	 */
	 function configMmsListType() {
	 	
	 	var patListVal = document.forms[0].mmsListType.value;
	 	
	 	var searchType =  document.forms[0].strSearchType;
	 	
	 	if(patListVal == '7'){	 		
	 		searchType.selectedIndex = 1;
	 		searchType.disabled = true;
	 				 	
	 	}else{
	 		searchType.selectedIndex = 0;
	 		searchType.disabled = false;
	 	}
	 	
	 }
	 
	 
	 /**
	  * getPatListOnEnter
	  * @param {Event} eve 
	  */
	  function getMmsListOnEnter(eve) {
	  	
	  	if(eve.keyCode == 13){
	  		var val = getSearchMmsListBySearch();
	  		
	  		return val;
	  	}else{
	  		
	  		return false;
	  	} 
	  	
	  }
	 
	