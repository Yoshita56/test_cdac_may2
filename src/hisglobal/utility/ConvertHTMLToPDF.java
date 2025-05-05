package hisglobal.utility;

/**
 * @author  CDAC
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.BodyTag;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.Html;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.SelectTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.tags.TextareaTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;


public class ConvertHTMLToPDF 
{
	Document doc;
	String htmlCode;
	Object currentTarget;
	ArrayList alDocElements;
	String targetContent;
	Map map;
	
	public ConvertHTMLToPDF()
	{
		this.doc=new Document();
		this.htmlCode=new String();
	}
	
	public ConvertHTMLToPDF(String html)
	{
		this.doc=new Document();
		this.htmlCode=html;
	}
	
	public ConvertHTMLToPDF(Document doc,String html)
	{
		this.doc=doc;
		this.htmlCode=html;
	}

	public String getTargetContent() {
		return targetContent;
	}
	public void setTargetContent(String targetContent) {
		this.targetContent = targetContent;
	}
	public String getHtmlCode() {
		return htmlCode;
	}
	public void setHtmlCode(String htmlCode) {
		this.htmlCode = htmlCode;
	}
	public Document getDoc() {
		return doc;
	}
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	
	//*****************************************************************************************
	//Convert to Text
	//*****************************************************************************************
	
	/*** Notes 
	 * 1. Let 80 Spaces means One Line And   
	 * 2. Let 9 Spaces Means One Column
	 */
	public boolean convertToText()
	{
		try
		{
			if(this.htmlCode.equals("")) return false;
			Parser parser = new Parser(this.htmlCode);
			NodeList list = parser.parse (null);
			Node[] nodeArr=list.toNodeArray();
			
			this.targetContent=new String();
			
			for(int cntNA=0;cntNA<nodeArr.length;cntNA++)
			{
				Node node=nodeArr[cntNA];
				addHTMLElementToStr(node);
			}
			System.out.println(this.targetContent);
		}
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}	
		return true;
	}

	private boolean addHTMLElementToStr(Html node)
	{
		if(node.isEndTag()) return false;
		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				addHTMLElementToStr((Node)ite.nextNode());
		return false;
	}
	
	private boolean addHTMLElementToStr(BodyTag node)
	{
		if(node.isEndTag()) return false;
		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				addHTMLElementToStr((Node)ite.nextNode());
		return false;
	}	
	
	private boolean addHTMLElementToStr(TableTag node)
	{
		if(node.isEndTag()) return false;
		boolean haveContent=false;
		if(node.getAttribute("id")!=null)
		{
			if( node.getAttribute("id").startsWith("tblTemplate#") )  
				this.targetContent+="\n";
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
					haveContent= addHTMLElementToStr((Node)ite.nextNode()) || haveContent;
			if( !node.getAttribute("id").startsWith("tblTemplate#") && !haveContent) 
				this.targetContent+="         ";
		}	
		if(node.getAttribute("id")==null)
			return false;
		else if(node.getAttribute("id").startsWith("tblTemplate#"))
			return false;
		else
			return haveContent;
	}	

	private boolean addHTMLElementToStr(TableRow node)
	{
		if(node.isEndTag())		return false;
		boolean haveContent=false;
		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				haveContent= addHTMLElementToStr((Node)ite.nextNode()) || haveContent;
		TableTag tbl=(TableTag)node.getParent();
		if(tbl.getAttribute("id").startsWith("tblTemplate#"))
			this.targetContent+="\n";
		return haveContent;
	}
	
	private boolean addHTMLElementToStr(TableColumn node)
	{
		if(node.isEndTag()) return false;
		boolean haveContent=false;
		
		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				haveContent= addHTMLElementToStr((Node)ite.nextNode()) || haveContent;
		if(!haveContent)
			this.targetContent+="         ";
		return haveContent;
	}	
	
	private boolean addHTMLElementToStr(TextNode node)
	{
		String value=node.getText();
		
		//Alignment
		//Get TableColum in Parent
		Node parent =node.getParent();
		while(!(parent instanceof TableColumn))
			parent=parent.getParent();
		TableColumn tdImmediate=(TableColumn)parent;
		//Get TableColum in Upper Parent
		parent =parent.getParent();
		while(!(parent instanceof TableColumn))
			parent=parent.getParent();
		TableColumn tdUpper=(TableColumn)parent;
		
		String finalValue=" "+value+" ";
		if(tdImmediate.getAttribute("align")!=null)
		{
			String space="";
			int col=0;
			if(tdUpper.getAttribute("colspan")!=null)
				col=Integer.parseInt(tdUpper.getAttribute("colspan"));
			for(int i=0;i<col;i++)
				space+="         ";
			if(value.length()<space.length())
				space=space.substring(0,space.length()-value.length());
			else
				space="";
			if(tdImmediate.getAttribute("align").toLowerCase().equals("left"));
			else if(tdImmediate.getAttribute("align").toLowerCase().equals("right"))
				finalValue=space+value;
			else if(tdImmediate.getAttribute("align").toLowerCase().equals("center"))
				finalValue=space.substring(0,space.length()/2)+ value+space.substring(0,space.length()/2);
		}
		if(!value.equals(""))
		{
			this.targetContent+=finalValue;
		}
		return true;
	}
	
	private boolean addHTMLElementToStr(InputTag node)
	{	
		if(node.isEndTag()) return false;
		String value="";
		if(node.getAttribute("type").equals("text"))
			value=node.getAttribute("value");
		else if (node.getAttribute("type").equals("radio"))
		{
			if(node.getAttribute("checked")!=null && node.getAttribute("checked").equals("true"))
				value=node.getAttribute("value");
			Node next= node.getNextSibling();
			if(next instanceof TextNode)
			{
				Node parent =next.getParent();
				parent.getChildren().remove(next);
			}
		}
		else if (node.getAttribute("type").equals("checkbox"))
			if(node.getAttribute("checked")!=null && node.getAttribute("checked").equals("true"))
				value=node.getAttribute("value");
		
		//Alignment
		//Get TableColum in Parent
		Node parent =node.getParent();
		while(!(parent instanceof TableColumn))
			parent=parent.getParent();
		TableColumn tdImmediate=(TableColumn)parent;
		//Get TableColum in Upper Parent
		parent =parent.getParent();
		while(!(parent instanceof TableColumn))
			parent=parent.getParent();
		TableColumn tdUpper=(TableColumn)parent;
		
		String finalValue=" "+value+" ";
		if(tdImmediate.getAttribute("align")!=null)
		{
			String space="";
			int col=0;
			if(tdUpper.getAttribute("colspan")!=null)
				col=Integer.parseInt(tdUpper.getAttribute("colspan"));
			for(int i=0;i<col;i++)
				space+="         ";
			if(value.length()<space.length())
				space=space.substring(0,space.length()-value.length());
			else
				space="";
			if(tdImmediate.getAttribute("align").toLowerCase().equals("left"));
			else if(tdImmediate.getAttribute("align").toLowerCase().equals("right"))
				finalValue=space+value;
			else if(tdImmediate.getAttribute("align").toLowerCase().equals("center"))
				finalValue=space.substring(0,space.length()/2)+ value+space.substring(0,space.length()/2);
		}
		if(!value.equals(""))
		{
			this.targetContent+=finalValue;
		}
		return true;
	}
	
	private boolean addHTMLElementToStr(TextareaTag node)
	{
		if(node.isEndTag()) return false;
		boolean haveContent=false;
		
		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				haveContent= addHTMLElementToStr((Node)ite.nextNode()) || haveContent;
		return haveContent;
	}
	
	private boolean addHTMLElementToStr(SelectTag node)
	{	
		if(node.isEndTag()) return false;
		String value="";

		if(node.getAttribute("value")!=null)
		{
			if(!node.getAttribute("value").trim().equals(""))
				value=node.getAttribute("value");
		}
		else
		{
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				{
					Node childNode=ite.nextNode();
					if(childNode instanceof OptionTag) 
					{
						OptionTag optNode =(OptionTag)childNode;
						if(optNode.getAttribute("selected")!=null && optNode.getAttribute("selected").equals("true"))
						{
							value=optNode.getAttribute("value");
							break;
						}
					}
				}
		}
		
		//Alignment
		//Get TableColum in Parent
		Node parent =node.getParent();
		while(!(parent instanceof TableColumn))
			parent=parent.getParent();
		TableColumn tdImmediate=(TableColumn)parent;
		//Get TableColum in Upper Parent
		parent =parent.getParent();
		while(!(parent instanceof TableColumn))
			parent=parent.getParent();
		TableColumn tdUpper=(TableColumn)parent;
		
		String finalValue=" "+value+" ";
		if(tdImmediate.getAttribute("align")!=null)
		{
			String space="";
			int col=0;
			if(tdUpper.getAttribute("colspan")!=null)
				col=Integer.parseInt(tdUpper.getAttribute("colspan"));
			for(int i=0;i<col;i++)
				space+="         ";
			if(value.length()<space.length())
				space=space.substring(0,space.length()-value.length());
			else
				space="";
			if(tdImmediate.getAttribute("align").toLowerCase().equals("left"));
			else if(tdImmediate.getAttribute("align").toLowerCase().equals("right"))
				finalValue=space+value;
			else if(tdImmediate.getAttribute("align").toLowerCase().equals("center"))
				finalValue=space.substring(0,space.length()/2)+ value+space.substring(0,space.length()/2);
		}
		if(!value.equals(""))
		{
			this.targetContent+=finalValue;
		}
		return true;	
	}
	
	private boolean addHTMLElementToStr(Tag node)
	{
		if(node.isEndTag()) return false;
		
		if(node.getTagName().toLowerCase().equals("b"))
			return false;	
		else if(node.getTagName().toLowerCase().equals("u"))
			return false;	
		else if(node.getTagName().toLowerCase().equals("u"))
			return false;	
		else if(node.getTagName().toLowerCase().equals("font"))
			return false;	
		return false;	
	}	
	

	private boolean addHTMLElementToStr(Node node)
	{
		if(node instanceof Html)
			return addHTMLElementToStr((Html)node);
		else if(node instanceof BodyTag)
			return addHTMLElementToStr((BodyTag)node);
		else if(node instanceof TableTag)
			return addHTMLElementToStr((TableTag)node);
		else if(node instanceof TableRow)
			return addHTMLElementToStr((TableRow)node);
		else if(node instanceof TableColumn)
			return addHTMLElementToStr((TableColumn)node);
		else if(node instanceof TextNode)
			return addHTMLElementToStr((TextNode)node);
		else if(node instanceof InputTag)
			return addHTMLElementToStr((InputTag)node);
		else if(node instanceof TextareaTag)
			return addHTMLElementToStr((TextareaTag)node);
		else if(node instanceof SelectTag)
			return addHTMLElementToStr((SelectTag)node);
		else if(node instanceof Tag)
			return addHTMLElementToStr((Tag)node);
		else
			return false;
	}
	//*****************************************************************************************
	//End
	//*****************************************************************************************
	
	
	
	
	
	
	
	//*****************************************************************************************
	//Convert to PDF Document
	//*****************************************************************************************
	
	/*** Notes 
	 * 1. Adding Empty Paragraphs followed by Chunks in Array List
	 * 2. Nothing will addded to Paragraph
	 * 3. Only in Chunks
	 */
	public boolean convertToPDF()
	{
		try
		{
			if(this.htmlCode.equals("")) return false;
			
			Parser parser = new Parser(this.htmlCode);
			NodeList list = parser.parse (null);
			Node[] nodeArr=list.toNodeArray();
			
			this.doc.open();
			this.doc.newPage();			
			this.alDocElements =new ArrayList();
			this.alDocElements.add(aNewParagraph());
			
			for(int cntNA=0;cntNA<nodeArr.length;cntNA++)
			{
				Node node=nodeArr[cntNA];
				addHTMLToDocElement(node);
			}

			Paragraph para=null;
			for(int i=0;i<this.alDocElements.size();i++)
			{
				Element ele=(Element)this.alDocElements.get(i);
				if(ele instanceof Paragraph)
				{
					if(para !=null)this.doc.add(para);
					para=(Paragraph)ele;
				}
				else if(ele instanceof Chunk && !((Chunk)ele).content().equals(""))
					para.add(ele);
			}
			if(para !=null)this.doc.add(para);
			
			this.doc.close();

		}
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}	
		return true;
	}

	private boolean addHTMLToDocElement(Html node)
	{
		if(node.isEndTag()) return false;

		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				addHTMLToDocElement((Node)ite.nextNode());

		return false;
	}
	
	private boolean addHTMLToDocElement(BodyTag node)
	{
		if(node.isEndTag()) return false;

		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				addHTMLToDocElement((Node)ite.nextNode());

		return false;
	}	
	
	private boolean addHTMLToDocElement(TableTag node)
	{
		if(node.isEndTag()) return false;

		boolean haveContent=false;
		Element lastDocEleInList=null;
		if(this.alDocElements.size()>0 && this.alDocElements.get(this.alDocElements.size()-1)!= null )
			lastDocEleInList=(Element)this.alDocElements.get(this.alDocElements.size()-1);
		
		if(node.getAttribute("id")!=null)
		{
			if( node.getAttribute("id").startsWith("tblTemplate#") )  
				this.alDocElements.add(new Chunk("\n"));
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
					haveContent= addHTMLToDocElement((Node)ite.nextNode()) || haveContent;
			if( !node.getAttribute("id").startsWith("tblTemplate#") && !haveContent) 
				if(lastDocEleInList!=null) 
					this.alDocElements.add(new Chunk("         "));
		}	

		if(node.getAttribute("id")==null)
			return false;
		else if(node.getAttribute("id").startsWith("tblTemplate#"))
			return false;
		else
			return haveContent;
	}	

	private boolean addHTMLToDocElement(TableRow node)
	{
		if(node.isEndTag())		return false;

		boolean haveContent=false;

		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				haveContent= addHTMLToDocElement((Node)ite.nextNode()) || haveContent;
		
		TableTag tbl=(TableTag)node.getParent();
		if(tbl.getAttribute("id").startsWith("tblTemplate#"))
		{
			if(!haveContent)
			{	
				this.alDocElements.add(new Chunk("\n"));
			}
				this.alDocElements.add(aNewParagraph());
			
		}
			
		return haveContent;
	}
	
	private boolean addHTMLToDocElement(TableColumn node)
	{
		if(node.isEndTag()) return false;

		boolean haveContent=false;
		Element lastDocEleInList=null;
		if(this.alDocElements.size()>0 && this.alDocElements.get(this.alDocElements.size()-1)!= null )
			lastDocEleInList=(Element)this.alDocElements.get(this.alDocElements.size()-1);
		
		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				haveContent= addHTMLToDocElement((Node)ite.nextNode()) || haveContent;

		if(!haveContent)
			if(lastDocEleInList!=null) 
				this.alDocElements.add(new Chunk("         "));

		return haveContent;
	}	
	
	private Paragraph aNewParagraph()
	{
		Paragraph para=new Paragraph();
		
		para.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
		para.setIndentationLeft(30f);
    	para.setIndentationRight(30f);
		return para;
	}
	
	private boolean addHTMLToDocElement(TextNode node)
	{
		Element lastDocEleInList=null;
		if(this.alDocElements.size()>0 && this.alDocElements.get(this.alDocElements.size()-1)!= null )
			lastDocEleInList=(Element)this.alDocElements.get(this.alDocElements.size()-1);

		String value=" "+node.getText()+" ";
		
		SetAlignment(node);
		Chunk chk= null;
		if(lastDocEleInList instanceof Chunk && ((Chunk)lastDocEleInList).content().equals(""))
			chk=(Chunk)lastDocEleInList;
		else
		{
			chk=new Chunk("");
			this.alDocElements.add(chk);
			lastDocEleInList=chk;
		}
		if(!value.equals(""))
			chk.append(value);
		return true;
	}
	
	private boolean SetAlignment(Node node)
	{
		//Get TableColum in Parent
		Node parent =node.getParent();
		while(!(parent instanceof TableColumn))
			parent=parent.getParent();
		TableColumn tdImmediate=(TableColumn)parent;
		
		//Get TableColum in Upper Parent
		parent =parent.getParent();
		while(!(parent instanceof TableColumn))
			parent=parent.getParent();
		TableColumn tdUpper=(TableColumn)parent;
		
		if(tdImmediate.getAttribute("align")!=null)
		{
			int col=0;
			if(tdUpper.getAttribute("colspan")!=null)
				col=Integer.parseInt(tdUpper.getAttribute("colspan"));
			if(col==9)
			{
				Paragraph para=null;
				Element tempEle=null;
				if(this.alDocElements.size()>0 && this.alDocElements.get(this.alDocElements.size()-1)!= null )
					tempEle=(Element)this.alDocElements.get(this.alDocElements.size()-1);
				if(tempEle !=null)
				{
					int i=this.alDocElements.size()-2;
					while(i>=0 && !(tempEle instanceof Paragraph))
						tempEle=(Element)this.alDocElements.get(i);
					if(tempEle instanceof Paragraph)para=(Paragraph)tempEle;
				}
				if(para ==null)
				{
					para=aNewParagraph();
					this.alDocElements.add(para);
				}
				if(tdImmediate.getAttribute("align").toLowerCase().equals("left"))
					para.setAlignment(Element.ALIGN_LEFT);
				else if(tdImmediate.getAttribute("align").toLowerCase().equals("right"))
					para.setAlignment(Element.ALIGN_RIGHT);
				else if(tdImmediate.getAttribute("align").toLowerCase().equals("center"))
					para.setAlignment(Element.ALIGN_CENTER);
				return true;
			}
			return false;
		}
		return false;
	}
	
	private boolean addHTMLToDocElement(InputTag node)
	{	
		if(node.isEndTag()) return false;
		
		Element lastDocEleInList=null;
		if(this.alDocElements.size()>0 && this.alDocElements.get(this.alDocElements.size()-1)!= null )
			lastDocEleInList=(Element)this.alDocElements.get(this.alDocElements.size()-1);

		String value="";
		if(node.getAttribute("type").equals("text"))
			value=node.getAttribute("value");
		else if (node.getAttribute("type").equals("radio"))
		{
			if(node.getAttribute("checked")!=null && node.getAttribute("checked").equals("true"))
				value=node.getAttribute("value");
			Node next= node.getNextSibling();
			if(next instanceof TextNode)
			{
				Node parent =next.getParent();
				parent.getChildren().remove(next);
			}
		}
		else if (node.getAttribute("type").equals("checkbox"))
			if(node.getAttribute("checked")!=null && node.getAttribute("checked").equals("true"))
				value=node.getAttribute("value");
		value=" "+value+" ";
		SetAlignment(node);
		Chunk chk= null;
		if(lastDocEleInList instanceof Chunk && ((Chunk)lastDocEleInList).content().equals(""))
			chk=(Chunk)lastDocEleInList;
		else
		{
			chk=new Chunk("");
			this.alDocElements.add(chk);
			lastDocEleInList=chk;
		}
		if(!value.equals(""))
		{
			chk.append(value);
			Font font =chk.font();
			if(font.style()!=-1) font.setStyle(font.style()|Font.BOLD);
			else font.setStyle(Font.BOLD);
		}
		return true;
	}
	
	private boolean addHTMLToDocElement(TextareaTag node)
	{
		if(node.isEndTag()) return false;
		boolean haveContent=false;
		
		NodeList nl=node.getChildren();
		if(nl!=null)
			for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
			{
				Element lastDocEleInList=null;
				if(this.alDocElements.size()>0 && this.alDocElements.get(this.alDocElements.size()-1)!= null )
					lastDocEleInList=(Element)this.alDocElements.get(this.alDocElements.size()-1);
				Chunk chk= null;
				if(lastDocEleInList instanceof Chunk && ((Chunk)lastDocEleInList).content().equals(""))
					chk=(Chunk)lastDocEleInList;
				else
				{
					chk=new Chunk("");
					this.alDocElements.add(chk);
					lastDocEleInList=chk;
				}
				Font font =chk.font();
				if(font.style()!=-1) font.setStyle(font.style()|Font.BOLD);
				else font.setStyle(Font.BOLD);
				haveContent= addHTMLToDocElement((Node)ite.nextNode()) || haveContent;
			}
		return haveContent;
	}
	
	private boolean addHTMLToDocElement(SelectTag node)
	{	
		if(node.isEndTag()) return false;

		Element lastDocEleInList=null;
		if(this.alDocElements.size()>0 && this.alDocElements.get(this.alDocElements.size()-1)!= null )
			lastDocEleInList=(Element)this.alDocElements.get(this.alDocElements.size()-1);

		String value="";

		if(node.getAttribute("value")!=null)
		{
			if(!node.getAttribute("value").trim().equals(""))
				value=node.getAttribute("value");
		}
		else
		{
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
				{
					Node childNode=ite.nextNode();
					if(childNode instanceof OptionTag) 
					{
						OptionTag optNode =(OptionTag)childNode;
						if(optNode.getAttribute("selected")!=null && optNode.getAttribute("selected").equals("true"))
						{
							value=optNode.getAttribute("value");
							break;
						}
					}
				}
		}
		
		value=" "+value+" ";
		SetAlignment(node);
		Chunk chk= null;
		if(lastDocEleInList instanceof Chunk && ((Chunk)lastDocEleInList).content().equals(""))
			chk=(Chunk)lastDocEleInList;
		else
		{
			chk=new Chunk("");
			this.alDocElements.add(chk);
			lastDocEleInList=chk;
		}
		if(!value.equals(""))
		{
			chk.append(value);
			Font font =chk.font();
			if(font.style()!=-1) font.setStyle(font.style()|Font.BOLD);
			else font.setStyle(Font.BOLD);
		}
		return true;	
	}
	
	private boolean addHTMLToDocElement(Tag node)
	{
		if(node.isEndTag()) return false;

		Element lastDocEleInList=null;
		if(this.alDocElements.size()>0 && this.alDocElements.get(this.alDocElements.size()-1)!= null )
			lastDocEleInList=(Element)this.alDocElements.get(this.alDocElements.size()-1);
		
		Chunk chk= null;
		if(lastDocEleInList instanceof Chunk && ((Chunk)lastDocEleInList).content().equals(""))
			chk=(Chunk)lastDocEleInList;
		else
		{
			chk=new Chunk("");
			this.alDocElements.add(chk);
			lastDocEleInList=chk;
		}
		if(node.getTagName().toLowerCase().equals("b"))
		{
			Font font =chk.font();
			if(font.style()!=-1) font.setStyle(font.style()|Font.BOLD);
			else font.setStyle(Font.BOLD);
		}
		else if(node.getTagName().toLowerCase().equals("u"))
		{
			Font font =chk.font();
			if(font.style()!=-1) font.setStyle(font.style()|Font.UNDERLINE);
			else font.setStyle(Font.UNDERLINE);
		}
		else if(node.getTagName().toLowerCase().equals("i"))
		{
			Font font =chk.font();
			if(font.style()!=-1) font.setStyle(font.style()|Font.ITALIC);
			else font.setStyle(Font.ITALIC);
		}
		else if(node.getTagName().toLowerCase().equals("font"))
		{
			Font font =chk.font();
			Color color=new Color(Integer.parseInt(node.getAttribute("color").replace("#",""), 16));
			font.setColor(color);
		}
		return false;	
	}	

	private boolean addHTMLToDocElement(Node node)
	{
		if(node instanceof Html)
			return addHTMLToDocElement((Html)node);
		else if(node instanceof BodyTag)
			return addHTMLToDocElement((BodyTag)node);
		else if(node instanceof TableTag)
			return addHTMLToDocElement((TableTag)node);
		else if(node instanceof TableRow)
			return addHTMLToDocElement((TableRow)node);
		else if(node instanceof TableColumn)
			return addHTMLToDocElement((TableColumn)node);
		else if(node instanceof TextNode)
			return addHTMLToDocElement((TextNode)node);
		else if(node instanceof InputTag)
			return addHTMLToDocElement((InputTag)node);
		else if(node instanceof TextareaTag)
			return addHTMLToDocElement((TextareaTag)node);
		else if(node instanceof SelectTag)
			return addHTMLToDocElement((SelectTag)node);
		else if(node instanceof Tag)
			return addHTMLToDocElement((Tag)node);
		else
			return false;
	}
	
	
	//*****************************************************************************************
	//End
	//*****************************************************************************************



	//*****************************************************************************************
	//	Converting Html to Report View
	//*****************************************************************************************

	
	/*** Notes 
	 * 1. Replacing PARMATER Tags to Values if exists Otherwise to do Empty 
	 * 2. In Consent Remove Print TableRow
	 * 3. Only in Chunks
	 */
	public boolean convertToReportHtml(Map map)
	{
		try
		{
			this.map= map;	
			if(this.htmlCode.equals("")) return false;
			this.htmlCode=this.htmlCode.replace("\n", "");
			this.htmlCode=this.htmlCode.replace("\t", "");
			
			Parser parser = new Parser(this.htmlCode);
			NodeList list = parser.parse (null);
			Node[] nodeArr=list.toNodeArray();
			
			for(int cntNA=0;cntNA<nodeArr.length;cntNA++)
			{
				Node node=nodeArr[cntNA];
				setTagToValue(node);
			}
			this.targetContent= list.toHtml();
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
		if(node.isEndTag()) return;

		try
		{
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
					setTagToValue((Node)ite.nextNode());
		}
		catch(Exception e)
		{
			return;
		}
	}
	
	private void setTagToValue(BodyTag node)
	{
		if(node.isEndTag()) return;
		try
		{
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
					setTagToValue((Node)ite.nextNode());
		}
		catch(Exception e)
		{
			return;
		}
	}	
	
	private void setTagToValue(TableTag node)
	{
		if(node.isEndTag()) return;
		try
		{
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
					setTagToValue((Node)ite.nextNode());
		}
		catch(Exception e)
		{
			return;
		}
	}	

	private void setTagToValue(TableRow node)
	{
		if(node.isEndTag())	return;
		try
		{
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
					setTagToValue((Node)ite.nextNode());
		}
		catch(Exception e)
		{
			return;
		}
	}
	
	private void setTagToValue(Div node)
	{
		if(node.isEndTag())	return;
		try
		{
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
					setTagToValue((Node)ite.nextNode());
		}
		catch(Exception e)
		{
			return;
		}
	}
	
	private void setTagToValue(TableColumn node)
	{
		if(node.isEndTag()) return;

		// Deleting Printing Button
		if(node.getAttribute("id")!=null && node.getAttribute("id").equals("tdPrintConsent"))
		{
			Node parentRow =node.getParent();
			while(!(parentRow instanceof TableRow))	parentRow=parentRow.getParent();
			Node parentTable = parentRow.getParent();
			while(!(parentTable instanceof TableTag))	parentTable=parentTable.getParent();
			parentTable.getChildren().remove(parentRow);
			setTagToValue((Node)parentTable);
		}
		else
		{
			NodeList nl=node.getChildren();
			if(nl!=null)
				for(SimpleNodeIterator ite=nl.elements(); ite.hasMoreNodes();)
					setTagToValue((Node)ite.nextNode());
		}
	}	
	
	private void setTagToValue(TextNode node)
	{}
	
	private void setTagToValue(InputTag node)
	{	
		if(node.isEndTag()) return;
		
		Node parent = node.getParent();
    	if(node.getAttribute("name")!=null && node.getAttribute("name").startsWith("PARAMETER"))
    	{
			String name=node.getAttribute("name");
			name=name.split("@")[1];
			String id= name.split("&")[0];
			String value=(String)map.get(id);
			if(value != null) value="<b>"+value+"</b>";
			else value="";
			
			NodeList newNodes=new NodeList();
			newNodes.add(new TextNode(value));
			parent.setChildren(newNodes);
    	}
	}
	
	private void setTagToValue(TextareaTag node)
	{
		if(node.isEndTag()) return;
		
		Node parent = node.getParent();
    	if(node.getAttribute("name")!=null && node.getAttribute("name").startsWith("PARAMETER"))
    	{
			String name=node.getAttribute("name");
			name=name.split("@")[1];
			String id= name.split("&")[0];
			String value=(String)map.get(id);
			if(value != null) value="<b>"+value+"</b>";
			else value="";
			
			NodeList newNodes=new NodeList();
			newNodes.add(new TextNode(value));
			parent.setChildren(newNodes);
    	}
	}
	
	private void setTagToValue(SelectTag node)
	{	
		if(node.isEndTag()) return;

		Node parent = node.getParent();
    	if(node.getAttribute("name")!=null && node.getAttribute("name").startsWith("PARAMETER"))
    	{
			String name=node.getAttribute("name");
			name=name.split("@")[1];
			String id= name.split("&")[0];
			String value=(String)map.get(id);
			if(value != null) value="<b>"+value+"</b>";
			else value="";
			
			NodeList newNodes=new NodeList();
			newNodes.add(new TextNode(value));
			parent.setChildren(newNodes);
    	}
	}
	
	private void setTagToValue(Tag node)
	{
		if(node.isEndTag()) return;

		Node parent = node.getParent();
    	if(node.getAttribute("name")!=null && node.getAttribute("name").startsWith("PARAMETER"))
    	{
			String name=node.getAttribute("name");
			name=name.split("@")[1];
			String id= name.split("&")[0];
			String value=(String)map.get(id);
			if(value != null) value="<b>"+value+"</b>";
			else value="";
			
			NodeList newNodes=new NodeList();
			newNodes.add(new TextNode(value));
			parent.setChildren(newNodes);
    	}

	}	

	private void setTagToValue(Node node)
	{
		if(node instanceof Html)
			setTagToValue((Html)node);
		else if(node instanceof BodyTag)
			setTagToValue((BodyTag)node);
		else if(node instanceof TableTag)
			setTagToValue((TableTag)node);
		else if(node instanceof TableRow)
			setTagToValue((TableRow)node);
		else if(node instanceof TableColumn)
			setTagToValue((TableColumn)node);
		else if(node instanceof TextNode)
			setTagToValue((TextNode)node);
		else if(node instanceof InputTag)
			setTagToValue((InputTag)node);
		else if(node instanceof TextareaTag)
			setTagToValue((TextareaTag)node);
		else if(node instanceof SelectTag)
			setTagToValue((SelectTag)node);
		else if(node instanceof Div)
			setTagToValue((Div)node);
		else if(node instanceof Tag)
			setTagToValue((Tag)node);
		else
			return;
	}
	
	
	
	//*****************************************************************************************
	//End
	//*****************************************************************************************

}
