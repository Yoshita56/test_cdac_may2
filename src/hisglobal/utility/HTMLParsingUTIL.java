package hisglobal.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.BodyTag;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.Html;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.SelectTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.tags.TextareaTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;
import org.htmlparser.visitors.HtmlPage;
import org.htmlparser.visitors.NodeVisitor;

/**
 * @author : C-DAC, Noida Project : AHIMS Module : Blood Bank Created On : 22 Aug, 2008
 * Developed By : Pragya Sharma
 * Purpose : This is a Global Utility Class containing Helper static methods for Parsing HTML
 */

public class HTMLParsingUTIL
{
	public HTMLParsingUTIL(String str)
	{
		this.htmlCode = str;
	}

	// Making given HTML Code PDF Compatible HTML Code
	// *** Note Points
	// *** Html File Conversion to Pdf ***
	// * 1. must contain <html> and <body> Tags
	// * 2. dont support Attribute 'class', 'style' etc
	// * 3. dont support <div>, <br> tags
	// * 4. dont support &nbsp; values
	// * 5. remove \n and \t and "
	public static StringBuilder replaceData(StringBuilder sb, String src, String target)
	{
		Pattern p = Pattern.compile(src);
		Matcher m = p.matcher(sb);
		while(m.find())
		{
			sb.replace(m.start(), m.group().length(), target);
			m = p.matcher(sb);
		}
		return sb;
	}
	
	public static String replaceAllData (String target, String from, String to) {   
		  //   target is the original string
		  //   from   is the string to be replaced
		  //   to     is the string which will used to replace
		  //  returns a new String!
		  int start = target.indexOf(from);
		  if (start == -1) return target;
		  int lf = from.length();
		  char [] targetChars = target.toCharArray();
		  StringBuffer buffer = new StringBuffer();
		  int copyFrom = 0;
		  while (start != -1) {
		    buffer.append (targetChars, copyFrom, start-copyFrom);
		    buffer.append (to);
		    copyFrom = start + lf;
		    start = target.indexOf (from, copyFrom);
		    }
		  buffer.append (targetChars, copyFrom, targetChars.length - copyFrom);
		  return buffer.toString();
		  }

	
	public static String makeHTMLPDFCompatible(String strHtmData)
	{
		try
		{
			// Removing \n \t \r
			//StringBuilder sb = new StringBuilder(strHtmData);
			strHtmData = strHtmData.trim();
			//sb.trimToSize();
			strHtmData = strHtmData.replace("\n", "");
			//sb=replaceData(sb, "\\n", "");
			strHtmData = replaceAllData(strHtmData, "\t","");
			strHtmData = strHtmData.replace("\t", "");
			strHtmData = strHtmData.replace("\r", "");

			// Removing &nbsp;, &
			
			strHtmData = strHtmData.replace("&nbsp;", " ");
			strHtmData = strHtmData.replace("&gt;", ">");
			strHtmData = strHtmData.replace("&lt;", "<");
			strHtmData = strHtmData.replace("&amp;", "&");
			//strHtmData = strHtmData.replace("&", "");

			// Adding <html> and <body> tag
			strHtmData = "<html><body>" + strHtmData + "</body></html>";
			System.out.println(strHtmData);

			// Parsing Data
			Parser parser = new Parser(strHtmData);
			NodeList list = parser.parse(null);

			// Creating a Visitor Searching for Attr class,style
			class NonPDFAttrVisitor extends NodeVisitor
			{
				List<Tag> tagList;
				public NonPDFAttrVisitor()
				{
					this.tagList = new ArrayList<Tag>();
				}
				public void visitTag(Tag tag)
				{
					if (tag.getAttribute("class") != null || tag.getAttribute("style") != null)
					{
						this.tagList.add(tag);
					}
				}
				public List<Tag> getTagList()
				{
					return tagList;
				}
			}
			// Removing Attributes
			NonPDFAttrVisitor npav = new NonPDFAttrVisitor();
			list.visitAllNodesWith(npav);
			List<Tag> allParamTags = npav.getTagList();
			for (Tag tag : allParamTags)
			{
				tag.removeAttribute("class");
				tag.removeAttribute("style");
			}

			strHtmData = list.toHtml();
			System.out.println(strHtmData);
			parser = new Parser(strHtmData);
			list = parser.parse(null);

			// Creating a Visitor Searching for <div> and <br> tag
			class NonPDFTagVisitor extends NodeVisitor
			{
				List<Tag> tagList;
				public NonPDFTagVisitor()
				{
					this.tagList = new ArrayList<Tag>();
				}
				public void visitTag(Tag tag)
				{
					if (/*tag.getTagName().equalsIgnoreCase("div") || tag.getTagName().equalsIgnoreCase("br")
							||*/ tag.getTagName().equalsIgnoreCase("tbody") )
					{
						this.tagList.add(tag);
					}
				}
				public void visitEndTag(Tag tag)
				{
					if (/*tag.getTagName().equalsIgnoreCase("div") ||*/ tag.getTagName().equalsIgnoreCase("br")
							|| tag.getTagName().equalsIgnoreCase("tbody") )
					{
						this.tagList.add(tag);
					}
				}

				public List<Tag> getTagList()
				{
					return tagList;
				}
			}
			// Removing Tags
			NonPDFTagVisitor nptv = new NonPDFTagVisitor();
			list.visitAllNodesWith(nptv);
			allParamTags = nptv.getTagList();
			for (Tag tag :allParamTags)
			{
				Node node = tag.getParent();
				if (node != null)
				{
					if(!tag.isEndTag() && tag.getTagName().equalsIgnoreCase("div") && node instanceof Tag)
						((Tag)node).setAttributesEx(tag.getAttributesEx());					
					if(tag.getChildren() != null)	node.getChildren().add(tag.getChildren());
					node.getChildren().remove(tag);
				}
			}

			strHtmData = list.toHtml();
			System.out.println(strHtmData);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			strHtmData = null;
		}
		return strHtmData;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// *****************************************************************************************
	// Converting Html to PDF Compitible
	// *****************************************************************************************

	private String htmlCode;
	private String targetContent;
	private Map map;

	public String getTargetContent()
	{
		return targetContent;
	}

	public void setTargetContent(String targetContent)
	{
		this.targetContent = targetContent;
	}

	public String getHtmlCode()
	{
		return htmlCode;
	}

	public void setHtmlCode(String htmlCode)
	{
		this.htmlCode = htmlCode;
	}

	/**
	 * * Notes 1. Replacing Input value Tags to Values if exists Otherwise to do Empty 2. The HTML code shold contain not
	 * contain \n \t \r etc. 3. It should be a valid HTML
	 */
	public boolean convertToReportHtml(Map map)
	{
		try
		{
			this.map = map;
			if (this.htmlCode.equals("")) return false;
			this.htmlCode = this.htmlCode.replace("\n", "");
			this.htmlCode = this.htmlCode.replace("\t", "");

			Parser parser = new Parser(this.htmlCode);
			NodeList list = parser.parse(null);
			Node[] nodeArr = list.toNodeArray();

			for (int cntNA = 0; cntNA < nodeArr.length; cntNA++)
			{
				Node node = nodeArr[cntNA];
				setTagToValue(node);
			}
			this.targetContent = list.toHtml();
			System.out.println(this.targetContent);
		}
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void setTagToValue(Html node)
	{
		if (node.isEndTag()) return;

		try
		{
			NodeList nl = node.getChildren();
			if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
				setTagToValue((Node) ite.nextNode());
		}
		catch (Exception e)
		{
			return;
		}
	}

	private void setTagToValue(BodyTag node)
	{
		if (node.isEndTag()) return;
		try
		{
			NodeList nl = node.getChildren();
			if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
				setTagToValue((Node) ite.nextNode());
		}
		catch (Exception e)
		{
			return;
		}
	}

	private void setTagToValue(TableTag node)
	{
		if (node.isEndTag()) return;
		try
		{
			NodeList nl = node.getChildren();
			if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
				setTagToValue((Node) ite.nextNode());
		}
		catch (Exception e)
		{
			return;
		}
	}

	private void setTagToValue(TableRow node)
	{
		if (node.isEndTag()) return;
		try
		{
			NodeList nl = node.getChildren();
			if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
				setTagToValue((Node) ite.nextNode());
		}
		catch (Exception e)
		{
			return;
		}
	}

	private void setTagToValue(Div node)
	{
		if (node.isEndTag()) return;
		try
		{
			NodeList nl = node.getChildren();
			if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
				setTagToValue((Node) ite.nextNode());
		}
		catch (Exception e)
		{
			return;
		}
	}

	private void setTagToValue(TableColumn node)
	{
		if (node.isEndTag()) return;

		// Deleting Printing Button
		if (node.getAttribute("name") != null && node.getAttribute("name").equals("tdPrintConsent"))
		{
			Node parentRow = node.getParent();
			while (!(parentRow instanceof TableRow))
				parentRow = parentRow.getParent();
			Node parentTable = parentRow.getParent();
			while (!(parentTable instanceof TableTag))
				parentTable = parentTable.getParent();
			parentTable.getChildren().remove(parentRow);
			setTagToValue((Node) parentTable);
		}
		else
		{
			NodeList nl = node.getChildren();
			if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
				setTagToValue((Node) ite.nextNode());
		}
	}

	private void setTagToValue(TextNode node)
	{
	}

	private void setTagToValue(InputTag node)
	{
		if (node.isEndTag()) return;

		Node parent = node.getParent();
		if (node.getAttribute("name") != null && node.getAttribute("name").startsWith("QUESTION"))
		{
			String name = node.getAttribute("name");
			String value = (String) map.get(name.split("#")[1]);
			if (value != null) value = "<b>" + value + "</b>";
			else value = "";

			NodeList newNodes = new NodeList();
			newNodes.add(new TextNode(value));
			parent.setChildren(newNodes);
		}
	}

	private void setTagToValue(TextareaTag node)
	{
		if (node.isEndTag()) return;

		Node parent = node.getParent();
		if (node.getAttribute("name") != null && node.getAttribute("name").startsWith("PARAMETER"))
		{
			String name = node.getAttribute("name");
			name = name.split("@")[1];
			String id = name.split("&")[0];
			String value = (String) map.get(id);
			if (value != null) value = "<b>" + value + "</b>";
			else value = "";

			NodeList newNodes = new NodeList();
			newNodes.add(new TextNode(value));
			parent.setChildren(newNodes);
		}
	}

	private void setTagToValue(SelectTag node)
	{
		if (node.isEndTag()) return;

		Node parent = node.getParent();
		if (node.getAttribute("name") != null && node.getAttribute("name").startsWith("PARAMETER"))
		{
			String name = node.getAttribute("name");
			name = name.split("@")[1];
			String id = name.split("&")[0];
			String value = (String) map.get(id);
			if (value != null) value = "<b>" + value + "</b>";
			else value = "";

			NodeList newNodes = new NodeList();
			newNodes.add(new TextNode(value));
			parent.setChildren(newNodes);
		}
	}

	private void setTagToValue(Tag node)
	{
		if (node.isEndTag()) return;

		Node parent = node.getParent();
		if (node.getAttribute("name") != null && node.getAttribute("name").startsWith("QUESTION"))
		{
			String name = node.getAttribute("name");
			String value = (String) map.get(name.split("#")[1]);
			if (value != null) value = "<b>" + value + "</b>";
			else value = "";

			NodeList newNodes = new NodeList();
			newNodes.add(new TextNode(value));
			parent.setChildren(newNodes);
		}

	}

	private void setTagToValue(Node node)
	{
		if (node instanceof Html) setTagToValue((Html) node);
		else if (node instanceof BodyTag) setTagToValue((BodyTag) node);
		else if (node instanceof TableTag) setTagToValue((TableTag) node);
		else if (node instanceof TableRow) setTagToValue((TableRow) node);
		else if (node instanceof TableColumn) setTagToValue((TableColumn) node);
		else if (node instanceof TextNode) setTagToValue((TextNode) node);
		else if (node instanceof InputTag) setTagToValue((InputTag) node);
		else if (node instanceof TextareaTag) setTagToValue((TextareaTag) node);
		else if (node instanceof SelectTag) setTagToValue((SelectTag) node);
		else if (node instanceof Div) setTagToValue((Div) node);
		else if (node instanceof Tag) setTagToValue((Tag) node);
		else return;
	}

	// *****************************************************************************************
	// End
	// *****************************************************************************************

}
