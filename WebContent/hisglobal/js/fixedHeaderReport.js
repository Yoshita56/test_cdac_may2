$(function() {
	var height= window.innerHeight - 220;
	if(document.getElementById("indentItemListDivId"))
    	document.getElementById("indentItemListDivId").style.display = 'none';
 	var tblObj = document.getElementById("mstTable");
 	var reportHeader=document.getElementById("reportDisplayHeaderData").innerHTML;
 	var newTableHtml; 	   
 	if(document.forms[0].strTableWidth)
		tblObj.width = document.forms[0].strTableWidth.value + "%";
	var mainDivRptObj = document.getElementById("wrapper");	
	newTableHtml= '<div id="reportHeaderName" style="">'+reportHeader+'</div>';		
	newTableHtml+= '<div id="content" style="width:100%;border-bottom: 1px solid #BBBBBB;">';
	newTableHtml+= '<div id="boundary">'; 
	newTableHtml+= '<table id="headerTable" cellpadding="3" cellspacing="0" border="0" style="width:100%;text-align:left;table-layout:fixed;border-collapse:collapse;">';
	newTableHtml+= '<thead style="display:table-header-group;"><tr>'+document.getElementById('tableHeaderId').innerHTML +'</tr></thead></table></div>';
	newTableHtml+= '<div id="boxHeaderFixed" style="height:'+height+'px">';
	newTableHtml+= '<table id="tbl-content" cellpadding="3" cellspacing="0" border="0" style="width:100%;table-layout:fixed;background:#fff;border-collapse:collapse;">';
	newTableHtml+= document.getElementById('mainTableRptId').innerHTML;
	newTableHtml+= '</table></div></div></div>';	
	mainDivRptObj.innerHTML = newTableHtml;
			
	document.getElementById("tableHeaderId").style.display="none";
	document.getElementById("reportDisplayHeaderRow").style.display="none";
	
	if(document.getElementById("indentItemListDivId"))
		document.getElementById("indentItemListDivId").style.display = 'block';	
		
	if($('#tbl-content').height() > height)
		$( "#headerTable th:last" ).attr("id", "right-border");			
		
	$('#mask').css('display','none');
	$('#dvLoading').css('display','none');	  
	
 }); 
 