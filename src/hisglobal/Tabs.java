package hisglobal;

import java.sql.*;
import java.util.*;
import java.io.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public  class Tabs extends TagSupport
{
	protected LinkedHashMap tabList=null;
	protected String selectedTab	=null;
	protected String onclick		="";
	protected String tabLabel		="";
	protected String width			="100%";
	protected String align			="center";
	protected String onlyTabIndexing	="0";
	
	private String str				="";
	
	public void setTabList(LinkedHashMap tabList)
	{
		this.tabList=tabList;
	}
	
	public void setSelectedTab(String  selectedTab)
	{
		this.selectedTab=selectedTab;
	}
	public void setTabLabel(String  tabLabel)
	{
		this.tabLabel=tabLabel;
	}
	public void setOnclick(String  onclick)
	{
		this.onclick=onclick;
	}
	public void setWidth(String  width)
	{
		this.width=width;
	}
	public void setAlign(String  align)
	{
		this.align=align;
	}
	
	/**
	 * @return the onlyTabIndexing
	 */
	public String getOnlyTabIndexing() {
		return onlyTabIndexing;
	}

	/**
	 * @param onlyTabIndexing the onlyTabIndexing to set
	 */
	public void setOnlyTabIndexing(String onlyTabIndexing) {
		this.onlyTabIndexing = onlyTabIndexing;
	}

	public int doStartTag()//throws JspTagException
	{
		try
		{
			JspWriter out =pageContext.getOut();
						
			String label		="";
			String pagename		="";
			boolean FLAG=false;
			
			if(tabList!=null)
			{
				if(selectedTab == null)
				{
					Set s		=tabList.keySet();
					Iterator it	=s.iterator();
					selectedTab	=(String)it.next();
					selectedTab	=(String)tabList.get(selectedTab);
				}
			
				int i=0;

				Set s		=tabList.keySet();
				Iterator it	=s.iterator();
				
				
				str += "<table cellspacing=0 cellpadding=0 class=\""+width+"\" border=0 align=\""+align+"\" valign=top>\n";
				str += "  <tr colspan=2>\n";
				str += "	<td >\n";
				str += "      <table cellspacing=0 cellpadding=0 width=\"100%\" border=0 align=\"center\">\n";
				str += "       <tr >\n";
	         	str += "		 <td colspan=3>\n";
				
				str += "		   <table cellspacing=0 cellpadding=0 width=\"100%\" border=0>\n";
				str += "			<tbody>\n";
				str += "			<tr>\n";

				while(it.hasNext())
				{
					label		=(String)it.next();
					pagename	=(String)tabList.get(label);

					str += "		<td valign=top  align=BASELINE colspan=3>\n";
					str += "		 <table cellspacing=0 cellpadding=0 width=\"100%\" border=0>\n";
					str += "		 <tbody>\n";
					str += "		 <tr>\n";
					str += "			<td width=1 height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
					str += "			<td width=\"269\" height=1 class=DIVIDER><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
					str += "		</tr>\n";
					str += "		<tr>\n";
					str += "		<td class=DIVIDER><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";

					if(selectedTab.equals(pagename))
					{
						str += "	<td id='cid' class=SELECTEDTAB noWrap height=20 >\n";
						str += "	<b>&nbsp;" + label + "&nbsp;</b>\n";
						str += "	</td>\n";

						if(tabList.size()-i == 1)
						{
							str += "<td class=DIVIDER height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
						}
					}
					else
					{

						str += "	<td id='cid' class=TAB style=cursor:hand nowrap tabindex=1  height=20 " ;
						str += "		onClick=\"onClickTab('" + pagename + "');\" onKeyPress=\"onEnterTab(event,'" + pagename + "')\" ";
						str += "		onMouseOver=\"setColor('" + i + "');\" onMouseOut=\"resetColor('" + i + "');\" ";
						str += "		onFocus=\"setColor('" + i + "');\" onBlur=\"resetColor('" + i + "');\" >\n";
						str += "		<img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0>\n";
						str += "		<a> &nbsp;" + label + "&nbsp; </a><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
						str += "	<td width=\"10\" class=DIVIDER><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
						str += "	</tr>\n";
						str += "	<tr>\n";
						str += "	<td class=DIVIDER width=1 height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
						str += "	<td class=DIVIDER height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
					}

					str += "</tr>\n";
					str += "</tbody>\n";
					str += "</table>\n";
					str += "</td>\n";
					i++;
				}
			}
			else
			{
				str += "<table cellspacing=0 cellpadding=0 class=\""+width+"\" border=0 align=\""+align+"\" valign=top>\n";
				str += "  <tr colspan=2>\n";
				str += "	<td >\n";
				str += "      <table cellspacing=0 cellpadding=0 width=\"100%\" border=0 align=\"center\">\n";
				str += "       <tr >\n";
	         	str += "		 <td colspan=3>\n";
				
				str += "		   <table cellspacing=0 cellpadding=0 width=\"100%\" border=0>\n";
				str += "			<tbody>\n";
				str += "			<tr>\n";


				str += "		<td valign=bottom align=BASELINE colspan=3>\n";
				str += "		 <table cellspacing=0 cellpadding=0 width=\"100%\" border=0>\n";
				str += "		 <tbody>\n";
				str += "		 <tr>\n";
				str += "			<td width=1 height=1><img height=1 src=\".../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
				str += "			<td colspan=2 width=\"269\" height=1 class=DIVIDER><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
				str += "		</tr>\n";
				str += "		<tr>\n";
				str += "		<td class=DIVIDER><img height=1 src=\"/hisglobal/images/tp.gif\" width=1 border=0></td>\n";
				
				str += "	<td id='cid' class=SELECTEDTAB noWrap height=20 >\n";
				str += "	<b>&nbsp;" + tabLabel + "&nbsp;</b>\n";
				str += "	</td>\n";

				str += "<td class=DIVIDER width=1 height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
				
				
				str += "</tr>\n";
				str += "</tbody>\n";
				str += "</table>\n";
				str += "</td>\n";		
			}
			str += "<td valign=bottom width=\"100%\">\n";
			str += "<table cellspacing=0 cellpadding=0 width=\"100%\" border=0>\n";
			str += "<tr>\n";
			str += "<td class=DIVIDER height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
			str += "</tr>\n";
			str += "</table>\n";
			str += "</td>\n";
			str += "</tr>\n";
			str += "</tbody>\n";
			str += "</table>\n";
			
			str += " </td>\n";
			str += "	 <td valign=bottom width=490 colspan=2>\n";
			str += "     <table cellspacing=0 cellpadding=0 width=\"100%\" border=0>\n";
			str += "	 <tr>\n";
			str += "	 <td class=DIVIDER height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>\n";
			str += "	 </tr>\n";
			str += "	 </table>\n";
			str += "	 </td>\n";
			str += "     </tr>\n";
			/*str += "     <tr>\n";
			str += "	 <td colspan=5>\n";
			str += "	<table cellspacing=0 cellpadding=0 width=\"100%\" border=0 align=\"center\" valign=top>\n";
			str += "	<tr>\n";
			str += "	<td class=DIVIDER width=1 rowspan=5> <img height=1 src=\"/hisglobal/images/tp.gif\" width=1 border=0></td>\n";
			str += "	 <td width=10 rowspan=5><img height=1 src=\"/hisglobal/images/tp.gif\" border=0 width=1></td>\n";
			str += "	<td height=10 width=\"1140\"><img height=1 src=\"/hisglobal/images/tp.gif\" width=1 border=0></td>\n";
			str += "	</tr>\n";
			str += "<td width=\"100%\" >\n";*/
			
			
			String strTabIndex ="<script>\n" +
					"var anchorColor = \"\";\n"+
					"var eventElementObj = \"\";\n"+
					"function autoTabIndexing(){\n" +
					"	var fFlagFocusFirst=true;\n" +
				//	"	var disCpPaste = new Function(\"disableMouseCopyPaste()\");\n"+
					"	var allImageObj = document.getElementsByTagName(\"img\");\n" +
					"	var allAnchorObj = document.getElementsByTagName(\"A\");\n" +
					"	var allSelectObj = document.getElementsByTagName(\"SELECT\");\n"+
					"	for(var nTmpI=0; nTmpI<document.forms[0].elements.length; nTmpI++){\n" +
					"		document.forms[0].elements[nTmpI].setAttribute(\"tabIndex\",\"1\");\n" +
					"		if(fFlagFocusFirst && document.forms[0].elements[nTmpI].type!=\"hidden\" && (document.forms[0].elements[nTmpI].tagName==\"INPUT\" ||document.forms[0].elements[nTmpI].tagName==\"SELECT\" || document.forms[0].elements[nTmpI].tagName==\"TEXTAREA\")){\n"+
					"			document.forms[0].elements[nTmpI].focus();\n"+
					"			if(((document.forms[0].elements[nTmpI].tagName==\"INPUT\" && document.forms[0].elements[nTmpI].type==\"text\") || document.forms[0].elements[nTmpI].tagName==\"TEXTAREA\") && document.forms[0].elements[nTmpI].value.length >0)\n"+
					"				document.forms[0].elements[nTmpI].select();\n"+
					"			fFlagFocusFirst=false;\n"+
					"		}\n"+
					"		if(document.forms[0].elements[nTmpI].type=='text' || document.forms[0].elements[nTmpI].tagName=='TEXTAREA'){\n"+
					"			if(document.all){\n"+
					//"		document.forms[0].elements[nTmpI].attributes['onmousedown'] = disCpPaste; " +
					//"		document.forms[0].elements[nTmpI].attributes['onmouseout'] = disCpPaste; " +
					//"		document.forms[0].elements[nTmpI].attributes['onmouseup'] = disCpPaste; " +
					"				var strOnKeyUpFun=''; if(typeof(document.forms[0].elements[nTmpI].attributes['onkeyup'])!=\"undefined\")\n {strOnKeyUpFun = \",\"+document.forms[0].elements[nTmpI].attributes['onkeyup'].value;}"+
					"				var lTrimFunc = new Function((\"lTrim(this)\"+strOnKeyUpFun.replace('return' , '')).replace(/(lTrim[(]this[)][,])+/g,''));\n"+
					"				var strOnBlurFun=''; if(typeof(document.forms[0].elements[nTmpI].attributes['onblur'])!=\"undefined\")\n {strOnBlurFun = \",\"+document.forms[0].elements[nTmpI].attributes['onblur'].value;}"+
					"				var trimFunc = new Function((\"Trim(this)\"+strOnBlurFun.replace('return' , '')).replace(/(Trim[(]this[)][,])+/g,''));\n"+
					//"				var unTipFunc = new Function(\"UnTip()\");\n"+
					//"				var tipFunc = new Function(\"Tip(this.value)\");\n"+
					"				document.forms[0].elements[nTmpI][\"onkeyup\"]=lTrimFunc;\n"+
					//"				document.forms[0].elements[nTmpI][\"onmouseover\"]=tipFunc;\n"+
					//"				document.forms[0].elements[nTmpI][\"onmouseout\"]=unTipFunc;\n"+
					"				document.forms[0].elements[nTmpI][\"onblur\"]=trimFunc;\n"+
					"			}else{\n"+
					"				var strOnKeyUpFun=''; if(typeof(document.forms[0].elements[nTmpI].attributes['onkeyup'])!=\"undefined\")\n {strOnKeyUpFun = \",\"+document.forms[0].elements[nTmpI].attributes['onkeyup'].value;}"+
					"				var strOnBlurFun=''; if(typeof(document.forms[0].elements[nTmpI].attributes['onblur'])!=\"undefined\")\n {strOnBlurFun = \",\"+document.forms[0].elements[nTmpI].attributes['onblur'].value;}"+
					"				document.forms[0].elements[nTmpI].setAttribute(\"onkeyup\",(\"lTrim(this)\"+strOnKeyUpFun.replace('return' , '')).replace(/(lTrim[(]this[)][,])+/g,''));\n"+
					"				document.forms[0].elements[nTmpI].setAttribute(\"onblur\",(\"Trim(this)\"+strOnBlurFun.replace('return' , '')).replace(/(Trim[(]this[)][,])+/g,''));\n"+
					//"				document.forms[0].elements[nTmpI].setAttribute(\"onmouseover\",(\"Tip(this.value)\"));\n"+
					//"				document.forms[0].elements[nTmpI].setAttribute(\"onmouseout\",(\"UnTiP()\"));\n"+
					"			}\n"+ 
					"		}\n"+
					"	}\n" +
					"	for(var nTmpI=0; nTmpI<allImageObj.length; nTmpI++){\n" +
					"		allImageObj[nTmpI].setAttribute(\"tabIndex\",\"1\");\n" +
					"		if(allImageObj[nTmpI][\"onclick\"])\n" +
					"			if(allImageObj[nTmpI].src.split(\"/\")[allImageObj[nTmpI].src.split(\"/\").length-1]!=\"imgDatepicker.png\")\n" +
					"				if(document.all){\n"+
					"					var myFunc = new Function(\"onPressingEnter(this,event)\");\n"+
					"					allImageObj[nTmpI][\"onkeypress\"]=myFunc;\n"+
					"				}else\n"+
					"					allImageObj[nTmpI].setAttribute(\"onkeypress\",\"onPressingEnter(this,event)\");\n" +
					"		if(allImageObj[nTmpI].src.split(\"/\")[allImageObj[nTmpI].src.split(\"/\").length-1]==\"tp.gif\")\n" +
					"			allImageObj[nTmpI].setAttribute(\"tabIndex\",\"0\");\n" +
					"	}\n" +
					
					"	for(var nTmpI=0; nTmpI<allAnchorObj.length; nTmpI++){\n" +
					"		allAnchorObj[nTmpI].setAttribute(\"tabIndex\",\"1\");\n" +
					"		if(allImageObj[nTmpI][\"onclick\"])\n" +
					"			if(document.all){\n"+
					"				var myFunc = new Function(\"{setAnchorBeforeEnterColor(this,event);onPressingEnter(this,event);}\");\n"+
					"				var onFocusFunction = new Function(\"setAnchorColor(this)\");\n"+
					"				var onBlurFunction = new Function(\"resetAnchorColor(this)\");\n"+
					"				allImageObj[nTmpI][\"onfocus\"]=onFocusFunction;\n"+
					"				allImageObj[nTmpI][\"onblur\"]=onBlurFunction;\n"+
					"				allImageObj[nTmpI][\"onkeypress\"]=myFunc;\n"+
					"			}else{\n"+
					"				allAnchorObj[nTmpI].setAttribute(\"onkeypress\",\"setAnchorBeforeEnterColor(this,event),onPressingEnter(this,event)\");\n" +
					"				allAnchorObj[nTmpI].setAttribute(\"onblur\",\"resetAnchorColor(this)\");\n" +
					"				allAnchorObj[nTmpI].setAttribute(\"onfocus\",\"setAnchorColor(this,event)\");\n" +
					"			}\n"+
					"	}\n" +
					"	for(var nTmpI=0; nTmpI<allSelectObj.length; nTmpI++){\n"+
					"		allSelectObj[nTmpI].setAttribute(\"tabIndex\",\"1\"); \n"+
					"		if(allSelectObj[nTmpI][\"onchange\"]) \n"+
					"			if(document.all){\n"+
					"				var myFunc = new Function(\"onPressingEnter(this,event)\");\n"+
					"				allSelectObj[nTmpI][\"onkeydown\"]=myFunc;\n"+
					"			}else\n"+
					"				allSelectObj[nTmpI].setAttribute(\"onkeydown\",\"return onPressingEnter(this,event)\");\n"+ 
					"	}\n"+
					"}\n" +
					
					"function setAnchorBeforeEnterColor(these,e){\n"+
					"	var keyVal; \n"+
					"	if (window.event)\n"+ 
					"		keyVal= window.event.keyCode;\n"+ 
					"	else \n"+
					"		keyVal= e.which;\n"+ 
					"	if(keyVal==13) {\n"+
					"		anchorColor = \"rgb(101, 50, 50)\";\n"+
					"		these.style.color = \"red\";\n"+
					"	}\n"+
					"}\n"+
					"\n"+
					"function setAnchorColor(these){\n"+
					"	anchorColor = these.style.color;\n"+
					"	these.style.color = \"red\";\n"+
					"}\n"+
					"\n"+
					"function resetAnchorColor(these){\n"+
					"	these.style.color = anchorColor;\n"+
					"}\n"+
					
					"\n" +
					"function onPressingEnter(_these,e){\n" +
					"	eventElementObj=_these;\n"+
					"	var keyVal;\n" +
					"	if (window.event)\n" +
					"		keyVal= window.event.keyCode;\n" +
					"	else\n" +
					"		keyVal= e.which;\n" +
					"	if(keyVal==13)\n" +
					"		eval(_these.onclick());\n" +
					"}\n" +
					" \n" +
					"function onPressingTab(_these,e){\n"+ 
					"	eventElementObj=_these;\n"+
					"	var keyVal; \n"+
					"	if (window.event)\n"+ 
					"		keyVal= window.event.keyCode;\n"+ 
					"	else\n"+ 
					"		keyVal= e.which;\n"+ 
					"	if(keyVal==9)\n"+ 
					"		eval(_these.onclick());\n"+
					"	return false;\n"+
					"}\n"+
					"\n"+
					"String.prototype.trim = function() {\n"+
					"	return this.replace(/^\\s+|\\s+$/g,\"\");\n"+
					"}\n"+
					"\n"+
					"String.prototype.ltrim = function() {\n"+
					"	return this.replace(/^\\s+/,\"\");\n"+
					"}\n"+
					"\n"+
					"function Trim(_these){\n"+
					"	_these.value=_these.value.trim();\n"+
					"}\n"+
					"function lTrim(_these){\n"+
					"	_these.value=_these.value.ltrim();\n"+
					"}\n"+
					"function disableMouseCopyPaste(){\n"+
					"	return false;\n"+
					"}\n"+
					"</script>";
			
			
			String strTextPreventCopy = "<script>\n" +
										//"function disableMouseCopyPaste(){\n"+
									//	"	return false;\n"+
									//	"}\n"+
										
										"function autoTabIndexing(){\n" +
									//	"	var disCpPaste = new Function(\"disableMouseCopyPaste()\");\n"+
									//	"for(var nTmpI=0; nTmpI<document.forms[0].elements.length; nTmpI++){\n"+
									//	"if(document.forms[0].elements[nTmpI].type=='text' || document.forms[0].elements[nTmpI].tagName=='TEXTAREA'){\n"+
									//	"			if(document.all){\n"+
									//	"		document.forms[0].elements[nTmpI].attributes['onmousedown'] = disCpPaste; " +
									//	"		document.forms[0].elements[nTmpI].attributes['onmouseout'] = disCpPaste; " +
									//	"		document.forms[0].elements[nTmpI].attributes['onmouseup'] = disCpPaste; " +
									//	" }  }  } } "+
										"   return false; } "+
										"</script>";
			
			
			if(onlyTabIndexing.equals("0")){
				str = str + strTabIndex;
			}else{
				str = str + strTextPreventCopy;
			}
						
			out.print(str);

		}
		catch(Exception e)
		{
			System.out.println("exception in doStartTag() "+e);
		}

		return 	EVAL_BODY_INCLUDE;
	}//end of dostart


	public int doEndTag()throws JspException
	{
		try
		{
			str="";
			JspWriter out =pageContext.getOut();
		
		//str += "</table></td></tr></table></td></tr></table>\n";
			str += "</table></td></tr></table>\n";
		//str += "<input type='hidden' name='selectedTab' value=''>";
		out.print(str);
		}
		catch(Exception e)
		{
			System.out.println("exception in doStartTag() "+e);
		}

		return EVAL_PAGE;

	}//end of do end tag



}