function getDrugName()
{
			alert("drugname");
	    var url ="StockLedgerForSubStoresRptCNT.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+document.forms[0].strGroupId.value+
		         "&itemType="+document.forms[0].strItemType.value;	    
	    
	   			  ajaxFunction(url,"4");
}