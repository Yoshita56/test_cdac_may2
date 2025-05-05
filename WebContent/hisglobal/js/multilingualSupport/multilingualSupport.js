function initMultilingual(strToLang) 
{
	
	pramukhIME.addLanguage(PramukhIndic);
    pramukhIME.enable();
        
    FromLanguage = "english";
    if(typeof strToLang==undefined || strToLang==null || strToLang=="")
    	ToLanguageOther = "marathi";
    else
    	ToLanguageOther= strToLang;
		
    FromLanguageFull = "pramukhindic:"+FromLanguage;
	ToLanguageOtherFull = "pramukhindic:"+ToLanguageOther;
}

function multilingualConversion(fromField, toFieldHindi)
{
	InputString = fromField.value;
	changeLanguage(ToLanguageOtherFull);
	ToLanguage = ToLanguageOther;
	convertedTextOther = pramukhIME.convert(InputString, FromLanguage, ToLanguage);
	toFieldHindi.value = convertedTextOther;
	changeLanguage(FromLanguageFull);
}

function callOnBlur()
{
	changeLanguage(FromLanguageFull);
}

function callOnClick()
{
	changeLanguage(ToLanguageOtherFull);
}
