package hisglobal.presentation;

import java.util.*;

public class Tab
{
	private String htmlTabString = "";
	private String subTabString = "";
	private String selectedTab = null;

	public String getHtmlTabString()
	{
		return ((htmlTabString == null) ? "" : htmlTabString);
	}

	public String getSubTabString()
	{
		return ((subTabString == null) ? "" : subTabString);
	}

	public void setSelectedTab(String selectedTab)
	{
		this.selectedTab = selectedTab;
	}

	public String getSelectedTab()
	{
		return selectedTab;
	}

	public String generateTabs(LinkedHashMap map, String selectedTab)
	{
		String str = "";
		String label = "";
		String pagename = "";

		int i = 0;

		Set s = map.keySet();
		Iterator it = s.iterator();

		str += "<table cellspacing=0 cellpadding=0 width=\"100%\" border=0>";
		str += "<tbody>";
		str += "<tr>";

		while (it.hasNext())
		{
			label = (String) it.next();
			pagename = (String) map.get(label);

			str += "<td valign=bottom align=BASELINE colspan=3>";

			str += "<table cellspacing=0 cellpadding=0 width=\"100%\" border=0>";
			str += "<tbody>";
			str += "<tr>";
			str += "<td width=1 height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>";
			str += "<td width=\"269\" height=1 class=DIVIDER><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>";
			str += "</tr>";
			str += "<tr>";
			str += "<td class=DIVIDER><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>";

			if (selectedTab.equals(pagename))
			{
				str += "<td id=\"cid\" class=SELECTEDTAB noWrap height=21 >";
				str += "<b>&nbsp;" + label + "&nbsp;</b>";
				str += "</td>";

				if (map.size() - i == 1)
				{
					str += "<td class=DIVIDER height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>";
				}
			}
			else
			{

				str += "<td id='cid' class=TAB style=cursor:hand nowrap tabindex=1  height=20 ";
				str += "onClick=\"submitForm2('" + pagename + "');\" onKeyPress=\"submitHeaderForm(event,'" + pagename + "')\" ";
				str += "onMouseOver=\"setColor('" + i + "');\" onMouseOut=\"resetColor('" + i + "');\" ";
				str += "onFocus=\"setColor('" + i + "');\" onBlur=\"resetColor('" + i + "');\" >";
				str += "<img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0>";
				str += "<a> &nbsp;" + label + "&nbsp; </a><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0><b></b></td>";
				str += "<td width=\"10\" class=DIVIDER><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>";
				str += "</tr>";
				str += "<tr>";
				str += "<td class=DIVIDER width=1 height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>";
				str += "<td class=DIVIDER height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>";
			}

			str += "</tr>";
			str += "</tbody>";
			str += "</table>";
			str += "</td>";
			i++;
		}

		str += "<td valign=bottom width=\"100%\">";
		str += "<table cellspacing=0 cellpadding=0 width=\"100%\" border=0>";
		str += "<tr>";
		str += "<td class=DIVIDER height=1><img height=1 src=\"../../hisglobal/images/tp.gif\" width=1 border=0></td>";
		str += "</tr>";
		str += "</table>";
		str += "</td>";
		str += "</tr>";
		str += "</tbody>";
		str += "</table>";

		return str;
	}

	public void init_tabs(LinkedHashMap map)
	{
		if (selectedTab == null)
		{
			Set s = map.keySet();
			Iterator it = s.iterator();
			selectedTab = (String) it.next();
			selectedTab = (String) map.get(selectedTab);
		}
		htmlTabString = generateTabs(map, selectedTab);
	}

}
