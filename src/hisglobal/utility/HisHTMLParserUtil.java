package hisglobal.utility;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.utility.servlets.ServletsUtilityConfig;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.*;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.scanners.Scanner;
import org.htmlparser.tags.*;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;
import org.htmlparser.visitors.NodeVisitor;

public class HisHTMLParserUtil
{

	/** 
	 * Create Element In Given Parent if not null
	 * @param _child Child element Tag 
	 * @param _parent Parent element Tag
	 * @throws Exception exception handling required
	 */
	public static void setParent(Tag _child, Tag _parent) throws Exception
	{
		NodeList children = _parent.getChildren();
		if(children == null)
			children = new NodeList();
		children.add(_child);
		_parent.setChildren(children);
		_child.setParent(_parent);
		
		Scanner scanner = (_child).getThisScanner();
		Lexer lex = new Lexer();
		NodeList lst = new NodeList();
		scanner.scan(_child,lex, lst);
	}
	
	// ******** Html Code Parsing for Printing Purpose *****************************************
	private static void freezeElement(InputTag node) throws Exception
	{
		if (node.isEndTag()) return;
		String value = "";
		String html = "";
		if (node.getAttribute("type")==null || node.getAttribute("type").equalsIgnoreCase("text"))
		{
			if (node.getAttribute("value") != null) value = node.getAttribute("value");
			if(node.getParent()!=null)
			{
				Node parent = node.getParent();
				html="<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'><b>&nbsp;"+value+"</b></font>";
				replaceChild(parent,node,new TextNode(html));
			}
		}
		else if (node.getAttribute("type").equalsIgnoreCase("radio"))
		{			
			if (node.getAttribute("value") != null) value = node.getAttribute("value");

			if(node.getAttribute("checked")!=null && (node.getAttribute("checked").equalsIgnoreCase("checked") || node.getAttribute("checked").equalsIgnoreCase("true")))
				html ="<img height=12 width=12 src='/AHIMS"+getPath(ServletsUtilityConfig.imgRadioCheckedPath)+"'>";
			else
				html ="<img height=12 width=12 src='/AHIMS"+getPath(ServletsUtilityConfig.imgRadioPath)+"'>";
			if(node.getParent()!=null)
			{
				Node parent = node.getParent();
				replaceChild(parent,node,new TextNode(html));
			}
		}
		else if (node.getAttribute("type").equalsIgnoreCase("checkbox"))
		{
			if (node.getAttribute("value") != null) value = node.getAttribute("value");
			
			if(node.getAttribute("checked")!=null && (node.getAttribute("checked").equalsIgnoreCase("checked") || node.getAttribute("checked").equalsIgnoreCase("true")))
				html ="<img height=12 width=12 src='/AHIMS"+getPath(ServletsUtilityConfig.imgCheckBoxCheckedPath)+"'>";
			else
				html ="<img height=12 width=12 src='/AHIMS"+getPath(ServletsUtilityConfig.imgCheckBoxPath)+"'>";
			if(node.getParent()!=null)
			{
				Node parent = node.getParent();
				replaceChild(parent,node,new TextNode(html));
			}
		}
	}

	private static void freezeElement(TextareaTag node) throws Exception
	{
		if (node.isEndTag()) return;
		String value = "";
		String html = "";
		if (node.getAttribute("value") != null) value = node.getAttribute("value");
		else if(node.getChildren()!=null)
		{
			SimpleNodeIterator it = node.getChildren().elements();
			while(it.hasMoreNodes())
			{
				Node child = it.nextNode();
				if(child instanceof TextNode)
				{
					value+=((TextNode)child).getText();
				}
			}
		}
		if(node.getParent()!=null)
		{
			Node parent = node.getParent();
			html="<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'><b>&nbsp;"+value+"</b></font>";
			replaceChild(parent,node,new TextNode(html));
		}
	}

	private static void freezeElement(SelectTag node) throws Exception
	{
		if (node.isEndTag()) return;
		String value = "";
		String html = "";

		if (node.getAttribute("value") != null)
		{
			if (!node.getAttribute("value").trim().equalsIgnoreCase("")) value = node.getAttribute("value");
		}
		else
		{
			NodeList nl = node.getChildren();
			if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			{
				Node childNode = ite.nextNode();
				if (childNode instanceof OptionTag)
				{
					OptionTag optNode = (OptionTag) childNode;
					if (optNode.getAttribute("selected") != null && optNode.getAttribute("selected").equalsIgnoreCase("true"))
					{
						value = optNode.getAttribute("value");
						break;
					}
				}
			}
		}
		if(node.getParent()!=null)
		{
			Node parent = node.getParent();
			html="<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'><b>&nbsp;"+value+"</b></font>";
			replaceChild(parent,node,new TextNode(html));
		}
	}

	private static void freezeElement(Node node) throws Exception
	{
		if (node instanceof InputTag) freezeElement((InputTag) node);
		else if (node instanceof TextareaTag) freezeElement((TextareaTag) node);
		else if (node instanceof SelectTag) freezeElement((SelectTag) node);
		else return;
	}

	private static String getPath(String path)
	{
		return path.replace("\\","/");
	}
	
	private static void replaceChild(Node parent, Node curChild, Node targetChild)
	{
		NodeList oldChildren = parent.getChildren();
		SimpleNodeIterator it = oldChildren.elements();
		NodeList newChildren = new NodeList();
		while(it.hasMoreNodes())
		{
			Node child = it.nextNode();
			if(child==curChild)
				newChildren.add(targetChild);
			else
				newChildren.add(child);
		}
		parent.setChildren(newChildren);
	}
	
	public static String freezeHTMLCodeElements(String _htmlCode)
	{
		String htmlCode="";
		try
		{
			Parser parser = new Parser(_htmlCode);
			NodeList list = parser.parse (null);
			
			class ValueNodeVisitor extends NodeVisitor
			{
				List<Tag> valueTagList; 
				public ValueNodeVisitor() {	valueTagList= new ArrayList<Tag>();	}
			    public void visitTag (Tag tag)
			    {
			    	if(tag instanceof InputTag || tag instanceof TextareaTag || tag instanceof SelectTag)
			    		valueTagList.add(tag);
			    }
			    public List<Tag> getValueTagList() {	return valueTagList;	}
				public void visitStringNode (Text string){}
			}
			
			ValueNodeVisitor myVisitor=new ValueNodeVisitor();
			list.visitAllNodesWith(myVisitor);
			List<Tag> allParamTags = myVisitor.getValueTagList();
			for(Tag tag : allParamTags)
			{
				freezeElement(tag);
			}
			htmlCode = list.toHtml();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return htmlCode; 
	}
}
