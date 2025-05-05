function disableButton(_buttonID){
	try{
		document.getElementById(_buttonID+"enable").style.display="none";
		document.getElementById(_buttonID+"disable").style.display="inline";
	}catch(_err){
		_buttonID="";
	}
}

function enableButton(_buttonID){
	try{
		document.getElementById(_buttonID+"enable").style.display="inline";
		document.getElementById(_buttonID+"disable").style.display="none";
	}catch(_err){
		_buttonID="";
	}
}

function chkUserFunc(these)
{
	try
	{
		chkUserDefinedFunc(these);
	}
	catch(_err)
	{
	}
}
