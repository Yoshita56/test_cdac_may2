package hisglobal.utility;

/**
 * @author : C-DAC, Noida
 * Project : AHIMS
 * Developed By : Pragya Sharma
 * 
 * Purpose : This is a Global Utility Class  
 * 			for Converting HTML to PDF Document
 * 
 */

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.htmlparser.*;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.*;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import hisglobal.utility.servlets.ServletsUtilityConfig;

public class HTMLToPDFUTIL
{
	// *****************************************************************************************
	// Convert to PDF Document Directly
	// *****************************************************************************************
	public static ByteArrayOutputStream convertHtmlToPDFDirect(HttpServletRequest _request, String _htmlCode)
	{
		ByteArrayOutputStream baosPDF = null;
		PdfWriter docWriter = null;
		Document doc = new Document();
		HttpSession session = null;
		try
		{
			String strHtmData = _htmlCode;
			session = _request.getSession();
			strHtmData = HTMLParsingUTIL.makeHTMLPDFCompatible(strHtmData);			
			HTMLToPDFUTIL converter = new HTMLToPDFUTIL(session, doc, strHtmData);
			baosPDF = new ByteArrayOutputStream();
			docWriter = PdfWriter.getInstance(doc, baosPDF);
			docWriter.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);
			converter.convertToPDF();
			if (doc != null) doc.close();
			if (docWriter != null) docWriter.close();
			if (baosPDF.size() < 1) throw new DocumentException("Document has " + baosPDF.size() + " Bytes");
			System.out.println("Inside Pragya's HTML To PDF Converter : Doc Size "+doc.getPageSize());
		}
		catch (DocumentException dex)
		{
			dex.printStackTrace();
		}
		catch (Exception dex)
		{
			dex.printStackTrace();
		}
		finally
		{
			if (baosPDF == null)
			{
				baosPDF.reset();
			}
		}
		return baosPDF;
	}

	public static boolean savePDFTo(ByteArrayOutputStream _baosPDF, String _fileName, String _winPath, String _linuxPath)
	{
		boolean flag = false;
		try
		{
			HisFileControlUtil hfcu = new HisFileControlUtil(_fileName,_winPath,_linuxPath);
			hfcu.setFileContent(_baosPDF.toByteArray());
			flag = hfcu.saveFile();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			flag = false;
		}
		return flag;
	}

	Document doc;
	String htmlCode;
	Object currentTarget;
	List alDocElements;
	String targetContent;
	Map map;
	HttpSession session;

	Stack<Tag> tagDecorate;

	public HTMLToPDFUTIL(HttpSession session)
	{
		this.session = session;
		this.doc = new Document();
		this.htmlCode = new String();
	}

	public HTMLToPDFUTIL(HttpSession session, String html)
	{
		this.session = session;
		this.doc = new Document();
		this.htmlCode = html;
	}

	public HTMLToPDFUTIL(HttpSession session, Document doc, String html)
	{
		this.session = session;
		this.doc = doc;
		this.htmlCode = html;
	}

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

	public Document getDoc()
	{
		return doc;
	}

	public void setDoc(Document doc)
	{
		this.doc = doc;
	}

	public HttpSession getSession()
	{
		return this.session;
	}

	public void setSession(HttpSession session)
	{
		this.session = session;
	}

	// *****************************************************************************************
	// Convert to PDF Document
	// *****************************************************************************************

	/**
	 * * Notes 1. Adding Equvalent PDF Element with 2. Nothing will addded to Paragraph 3. Only in Chunks
	 */
	public boolean convertToPDF()
	{
		try
		{
			//FontFactory.registerDirectory("C:\\Windows\\fonts");	Font set at Context Initialize from Application

			if (this.htmlCode.equalsIgnoreCase("")) return false;

			Parser parser = new Parser(this.htmlCode);
			NodeList list = parser.parse(null);
			Node[] nodeArr = list.toNodeArray();

			this.alDocElements = new ArrayList();
			this.tagDecorate = new Stack<Tag>();

			this.doc.addAuthor("C-DAC,Noida");
			this.doc.addCreator("Pragya Sharma");
			this.doc.addSubject("PDF for Printing Purpose");
			this.doc.setPageSize(PageSize.A4);

			// Creating a Page in the PDF
			// Converting Each HTML Element into PDF Element and add them to ArrayList 'alDocElements'
			for (int cntNA = 0; cntNA < nodeArr.length; cntNA++)
			{
				Node node = nodeArr[cntNA];
				addHTMLToDocElement(node, this.alDocElements);
			}

			// Add all Elements in 'alDocElements' to the PDF doc
			this.doc.open();
			this.doc.newPage();
			for (Object e : this.alDocElements)
			{
				if (e instanceof String && e.equals("---"))
					this.doc.add(new Paragraph());
				else
				this.doc.add((Element) e);
			}
			this.doc.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// For <html> tag just itearate for its children
	private List addHTMLToDocElement(Html node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		HTMLToPDFUTIL.addElementFromLst(t, lst);

		return t;
	}

	// For <head> tag just itearate for its children
	private List addHTMLToDocElement(HeadTag node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		HTMLToPDFUTIL.addElementFromLst(t, lst);
		return t;
	}

	// For <title> tag just itearate for its children
	private List addHTMLToDocElement(TitleTag node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		this.doc.addTitle(node.getText());

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		HTMLToPDFUTIL.addElementFromLst(t, lst);
		return t;
	}

	// For <body> tag just iterate for its children
	private List addHTMLToDocElement(BodyTag node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		HTMLToPDFUTIL.addElementFromLst(t, lst);
		return t;
	}

	// For <table> tag create PdfPTable
	private List addHTMLToDocElement(TableTag node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();
		Map mpTblProp = new HashMap();
		mpTblProp.put("cols", 0);
		List lstWidths = new ArrayList();
		mpTblProp.put("widths", lstWidths);
		lst.add(mpTblProp);

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		if (lst.size() > 1)
		{
			mpTblProp = (Map) lst.get(0);

			PdfPTable tbl = new PdfPTable((Integer) mpTblProp.get("cols"));
			float[] widths = new float[(Integer) mpTblProp.get("cols")];
			lstWidths = (List) mpTblProp.get("widths");
			for (int i = 0; i < (Integer) mpTblProp.get("cols"); i++)
			{
				float f = (Float) lstWidths.get(i);
				if(f!=0)
					widths[i] = (Float) lstWidths.get(i);
				else
					widths[i] = (float)(100.0/lstWidths.size());
			}
			tbl.setWidthPercentage(widths, PageSize.A4);
			HTMLToPDFUTIL.setTableToPdfPTableProp(node, tbl);

			for (int i = 1; i < lst.size(); i++)
			{
				List l = (ArrayList) lst.get(i);
				if (l != null) for (Object o : l)
					HTMLToPDFUTIL.addPdfPTableCell(tbl, o, node);
			}
			lst.clear();
			lst.add(tbl);
		}
		else
			lst.clear();
		HTMLToPDFUTIL.addElementFromLst(t, lst);
		return t;
	}

	// For <tr> tag set Column Count for PdfPTable
	private List addHTMLToDocElement(TableRow node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();
		lst.add(t.get(0));
		lst.add(0);

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		if (t == null || t.size() < 1 || lst == null || lst.size() < 2) return null;

		int colCount = 0, curCount = (Integer) ((Map) t.get(0)).get("cols");
		lst.remove(0);
		lst.remove(0);
		for (Object o : lst)
		{
			if (o != null)
			{
				if (o instanceof PdfPCell) colCount += ((PdfPCell) o).getColspan();
				else colCount++;
			}
		}
		if (curCount < colCount) ((Map) t.get(0)).put("cols", colCount);
		t.add(lst);

		return t;
	}

	// For <td> tag create PdfPCell
	private List addHTMLToDocElement(TableColumn node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		PdfPCell cell = new PdfPCell();
		cell.setColspan(1);
		cell.setBorder(0);
		HTMLToPDFUTIL.setTDToCellProp(node, cell, t, lst);

		Paragraph p = null;
		List lstNew = new ArrayList();
		for (Object o : lst)
		{
			if(o instanceof Paragraph)
			{
				lstNew.add(o);
				continue;
			}
			if(p==null)	p = new Paragraph();
			try
			{
				if (o instanceof String && o.equals("---"))
				{
					lstNew.add(p);
					p = null;
					continue;
				}
				if(o instanceof Image)
				{
					if(p!=null){	lstNew.add(p);	p = null;	}
					lstNew.add(o);
				}
				else	p.add(o);
			}
			catch (Exception e)
			{
				lstNew.add(o);
				if(p.getChunks().size()==0)	p=null;
			}
		}
		if(p!=null && p.getChunks().size()>0)	lstNew.add(p);
		lst = lstNew;

		for (Object o : lst)
			if(o instanceof Element)
				addElementToPdfPCell(cell, (Element) o);
		t.add(cell);
		return t;
	}

	// For <div> tag
	private List addHTMLToDocElement(Div node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		Paragraph p = null;
		List lstNew = new ArrayList();
		for (Object o : lst)
		{
			if(o instanceof Paragraph)
			{
				lstNew.add(o);
				continue;
			}
			if(p==null)	p = new Paragraph();
			try
			{
				if (o instanceof String && o.equals("---"))
				{
					lstNew.add(p);
					p = null;
					continue;
				}
				if(o instanceof Image)
				{
					if(p!=null){	lstNew.add(p);	p = null;	}
					lstNew.add(o);
				}
				else	p.add(o);
			}
			catch (Exception e)
			{
				lstNew.add(o);
				if(p.getChunks().size()==0)	p=null;
			}
		}
		if(p!=null && p.getChunks().size()>0)	lstNew.add(p);
		lst = lstNew;

		for (Object o : lst)
			if(o instanceof Element)
				HTMLToPDFUTIL.applyDivProToAllElem(node, (Element) o);

		HTMLToPDFUTIL.addElementFromLst(t, lst);
		return t;
	}

	// For <img> tag
	private List addHTMLToDocElement(ImageTag node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		String path = node.getImageURL();
		if(node.getAttribute("id")!=null)	path = node.getAttribute("id");			
		
		if(path!=null && !path.trim().equals(""))
		{
			if(path.startsWith("/AHIMS")) 
			{
				path = path.replace("/AHIMS","");
				path = this.session.getServletContext().getRealPath(path);
			}
			Image img = Image.getInstance(path);
			if(node.getAttribute("width")!=null)
			{
				img.scaleToFit(img.plainWidth()-1, img.plainWidth()-1);
				Chunk c = new Chunk(img, 0, 0);
				t.add(c);
			}
			else
				t.add(img);
		}
		return t;
	}

	// For <span> tag
	private List addHTMLToDocElement(Span node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		Paragraph p = null;
		List lstNew = new ArrayList();
		for (Object o : lst)
		{
			if(o instanceof Paragraph)
			{
				lstNew.add(o);
				continue;
			}
			if(p==null)	p = new Paragraph();
			try
			{
				if (o instanceof String && o.equals("---"))
				{
					lstNew.add(p);
					p = null;
					continue;
				}
				if(o instanceof Image)
				{
					if(p!=null){	lstNew.add(p);	p = null;	}
					lstNew.add(o);
				}
				else	p.add(o);
			}
			catch (Exception e)
			{
				lstNew.add(o);
				if(p.getChunks().size()==0)	p=null;
			}
		}
		if(p!=null && p.getChunks().size()>0)	lstNew.add(p);
		lst = lstNew;

		for (Object o : lst)
			if(o instanceof Element)
				HTMLToPDFUTIL.applySpanProToAllElem(node, (Element) o);

		HTMLToPDFUTIL.addElementFromLst(t, lst);
		return t;
	}

	// // For <input> tag create Chunk of Value of types 'text'. 'radio', 'checkbox'
	private List addHTMLToDocElement(InputTag node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		String value = "";
		// 'text'
		if (node.getAttribute("type")==null || node.getAttribute("type").equalsIgnoreCase("text"))
		{
			if (node.getAttribute("value") != null) value = node.getAttribute("value");

			// PdfPTable tbl = new PdfPTable(1);
			// tbl.setWidthPercentage(new float[] { 150 }, PageSize.A4);
			// PdfPCell cell = new PdfPCell();

			// cell.setPaddingLeft(1);
			// cell.setFixedHeight(25);
			// cell.addElement(new Chunk(value));
			// tbl.addCell(cell);
			// t.add(tbl);
			Chunk c = new Chunk(value);
			t.add(c);
		}
		// 'radio'
		else if (node.getAttribute("type").equalsIgnoreCase("radio"))
		{
			if (node.getAttribute("value") != null) value = node.getAttribute("value");

			/*
			 * PdfPTable tbl = new PdfPTable(1); //tbl.setWidthPercentage(new float[]{15},PageSize.A4); PdfPCell cell = new
			 * PdfPCell(); cell.setPaddingTop(5); cell.setFixedHeight(15); cell.addElement(new Chunk(" "));
			 * tbl.addCell(cell); t.add(tbl);
			 */

			Image img;
			if(node.getAttribute("checked")!=null && (node.getAttribute("checked").equalsIgnoreCase("checked") || node.getAttribute("checked").equalsIgnoreCase("true")))
				img = Image.getInstance(this.session.getServletContext().getRealPath(ServletsUtilityConfig.imgRadioCheckedPath));
			else
				img = Image.getInstance(this.session.getServletContext().getRealPath(ServletsUtilityConfig.imgRadioPath));
			Chunk c = new Chunk(img, 0, -3);
			t.add(c);

			/*
			 * if (node.getAttribute("checked") != null && node.getAttribute("checked").equalsIgnoreCase("true")) value =
			 * node.getAttribute("value"); Node next = node.getNextSibling(); if (next instanceof TextNode) { Node parent =
			 * next.getParent(); parent.getChildren().remove(next); }
			 */
		}
		// 'checkbox'
		else if (node.getAttribute("type").equalsIgnoreCase("checkbox"))
		{
			if (node.getAttribute("value") != null) value = node.getAttribute("value");

			/*
			 * PdfPTable tbl = new PdfPTable(1); //tbl.setWidthPercentage(new float[]{15},PageSize.A4); PdfPCell cell = new
			 * PdfPCell(); cell.setPaddingTop(5); cell.setFixedHeight(15); cell.addElement(new Chunk("__"));
			 * tbl.addCell(cell); t.add(tbl);
			 */

			
			Image img;
			if(node.getAttribute("checked")!=null && (node.getAttribute("checked").equalsIgnoreCase("checked") || node.getAttribute("checked").equalsIgnoreCase("true")))
				img = Image.getInstance(this.session.getServletContext().getRealPath(ServletsUtilityConfig.imgCheckBoxCheckedPath));
			else
				img = Image.getInstance(this.session.getServletContext().getRealPath(ServletsUtilityConfig.imgCheckBoxPath));
			img.scaleToFit(img.plainWidth()-1, img.plainWidth()-1);
			Chunk c = new Chunk(img, 0, -4);
			t.add(c);

			/*
			 * if (node.getAttribute("checked") != null && node.getAttribute("checked").equalsIgnoreCase("true")) value =
			 * node.getAttribute("value");
			 */
		}

		return t;
	}

	// // For <textarea> tag add Its Value
	private List addHTMLToDocElement(TextareaTag node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		HTMLToPDFUTIL.addElementFromLst(t, lst);
		return t;
	}

	// // For <select> tag create Chunk for Its Value
	private List addHTMLToDocElement(SelectTag node, List t) throws Exception
	{
		if (node.isEndTag()) return null;

		String value = "";
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

		Chunk c = new Chunk(value);
		t.add(c);
		return t;
	}

	// For <p> tag
	private List addHTMLToDocElement(ParagraphTag node, List t) throws Exception
	{
		Paragraph para = new Paragraph();
		HTMLToPDFUTIL.setPToParaProp(node, para);

		List lst = new ArrayList();

		NodeList nl = node.getChildren();
		if (nl != null) for (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();)
			addHTMLToDocElement((Node) ite.nextNode(), lst);

		for (Object o : lst)
			para.add(o);
		t.add(para);
		return t;
	}

	// For <label> tag
	private List addHTMLToDocElement(LabelTag node, List t) throws Exception
	{
		Chunk c = new Chunk(node.getText());
		t.add(c);
		return t;
	}

	// For Simple Plain Text
	private List addHTMLToDocElement(TextNode node, List t) throws Exception
	{
		if(!node.getText().trim().equals(""))
		{
			Chunk c = new Chunk(node.getText());
			t.add(c);
		}
		return t;
	}

	private List addHTMLToDocElement(Tag node, List t) throws Exception
	{
		List lst = t;
		if (node.isEndTag())
		{
			if (this.tagDecorate.peek().getTagName().equalsIgnoreCase(node.getTagName()))
			{
				Tag start = this.tagDecorate.pop();
				/*
				 * if (node.getTagName().equalsIgnoreCase("tbody")) { NodeList nl = node.getChildren(); if (nl != null) for
				 * (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();) addHTMLToDocElement((Node) ite.nextNode(),
				 * lst); } else
				 */
				if (node.getTagName().equalsIgnoreCase("b")) for (Object o : lst)
				{
					if (o instanceof Element) HTMLToPDFUTIL.applyBoldProToAllElem((Element) o);
				}
				else if (node.getTagName().equalsIgnoreCase("u")) for (Object o : lst)
				{
					if (o instanceof Element) HTMLToPDFUTIL.applyUnderlinedProToAllElem((Element) o);
				}
				else if (node.getTagName().equalsIgnoreCase("i")) for (Object o : lst)
				{
					if (o instanceof Element) HTMLToPDFUTIL.applyItalicProToAllElem((Element) o);
				}
				else if (node.getTagName().equalsIgnoreCase("font")) for (Object o : lst)
				{
					if (o instanceof Element) HTMLToPDFUTIL.applyFontProToAllElem(start, (Element) o);
				}
				else
				{
				}
			}
		}
		else
		{
			/*
			 * if (node.getTagName().equalsIgnoreCase("tbody")) { NodeList nl = node.getChildren(); if (nl != null) for
			 * (SimpleNodeIterator ite = nl.elements(); ite.hasMoreNodes();) addHTMLToDocElement((Node) ite.nextNode(), lst); }
			 * else
			 */if (node.getTagName().equalsIgnoreCase("b"))
			{
				this.tagDecorate.push(node);
				/*
				 * NodeList nl = node.getChildren(); if (nl != null) for (SimpleNodeIterator ite = nl.elements();
				 * ite.hasMoreNodes();) addHTMLToDocElement((Node) ite.nextNode(), lst); for (Object o : lst)
				 * HTMLToPDFUTIL.applyBoldProToAllElem((Element) o);
				 */
			}
			else if (node.getTagName().equalsIgnoreCase("u"))
			{
				this.tagDecorate.push(node);
			}
			else if (node.getTagName().equalsIgnoreCase("i"))
			{
				this.tagDecorate.push(node);
			}
			else if (node.getTagName().equalsIgnoreCase("font"))
			{
				this.tagDecorate.push(node);
			}
			else if (node.getTagName().equalsIgnoreCase("br"))
			{
				t.add("---");
			}
			else
			{
			}
			// HTMLToPDFUTIL.addElementFromLst(t, lst);
		}
		return t;
	}

	private List addHTMLToDocElement(Node node, List t) throws Exception
	{
		if (node instanceof Html) return addHTMLToDocElement((Html) node, t);
		else if (node instanceof HeadTag) return addHTMLToDocElement((HeadTag) node, t);
		else if (node instanceof TitleTag) return addHTMLToDocElement((TitleTag) node, t);
		else if (node instanceof BodyTag) return addHTMLToDocElement((BodyTag) node, t);
		else if (node instanceof TableTag) return addHTMLToDocElement((TableTag) node, t);
		else if (node instanceof TableRow) return addHTMLToDocElement((TableRow) node, t);
		else if (node instanceof TableColumn) return addHTMLToDocElement((TableColumn) node, t);
		else if (node instanceof Div) return addHTMLToDocElement((Div) node, t);
		else if (node instanceof ImageTag) return addHTMLToDocElement((ImageTag) node, t);
		else if (node instanceof Span) return addHTMLToDocElement((Span) node, t);
		else if (node instanceof InputTag) return addHTMLToDocElement((InputTag) node, t);
		else if (node instanceof TextareaTag) return addHTMLToDocElement((TextareaTag) node, t);
		else if (node instanceof SelectTag) return addHTMLToDocElement((SelectTag) node, t);
		else if (node instanceof ParagraphTag) return addHTMLToDocElement((ParagraphTag) node, t);
		else if (node instanceof LabelTag) return addHTMLToDocElement((LabelTag) node, t);
		else if (node instanceof TextNode) return addHTMLToDocElement((TextNode) node, t);
		else if (node instanceof Tag) return addHTMLToDocElement((Tag) node, t);
		else return null;
	}

	// *****************************************************************************************
	// End
	// *****************************************************************************************

	// Static Methods

	private static void addElementFromLst(List t, List lst)
	{
		if (lst != null && lst.size() > 0) for (Object e : lst)
			t.add(e);
	}

	private static void addPdfPTableCell(PdfPTable tbl, Object e, TableTag tbltag)
	{
		if (e == null) return;
		if (e instanceof String) tbl.addCell((String) e);
		if (e instanceof Phrase) tbl.addCell((Phrase) e);
		if (e instanceof Image)
		{
			Image img = (Image) e;
			//img.scaleToFit(tbl.getTotalWidth(),tbl.getTotalHeight());			
			tbl.addCell(img);			
		}
		if (e instanceof PdfPCell)
		{
			applyTablePropToCell(tbltag, (PdfPCell) e);
			tbl.addCell((PdfPCell) e);
		}
		if (e instanceof PdfPTable) tbl.addCell((PdfPTable) e);

	}

	private static void applyTablePropToCell(TableTag tbl, PdfPCell cell)
	{
		if (tbl.getAttribute("bgcolor") != null && cell.backgroundColor()==null)
			cell.setBackgroundColor(new Color(Integer.parseInt(tbl.getAttribute("bgcolor").replace("#", ""), 16)));
		if (tbl.getAttribute("border") != null && cell.border()==0)
		{
			cell.setBorder(Integer.parseInt(tbl.getAttribute("border")));
			//cell.setLeft(Integer.parseInt(tbl.getAttribute("border"))*cell.borderWidth());
			//cell.setBorderWidth(Integer.parseInt(tbl.getAttribute("border"))*cell.borderWidth());
			cell.setBorderWidthTop(Integer.parseInt(tbl.getAttribute("border"))*cell.borderWidth());
			cell.setBorderWidthLeft(Integer.parseInt(tbl.getAttribute("border"))*cell.borderWidth());
			cell.setBorderWidthRight(Integer.parseInt(tbl.getAttribute("border"))*cell.borderWidth());
			cell.setBorderWidthBottom(Integer.parseInt(tbl.getAttribute("border"))*cell.borderWidth());
			
		}
		if (tbl.getAttribute("bordercolor") != null && cell.borderColor()==null)
		{
			cell.setBorderColor(new Color(Integer.parseInt(tbl.getAttribute("bordercolor").replace("#",""),16)));
			//cell.setBorderColorTop(new Color(Integer.parseInt(tbl.getAttribute("bordercolor").replace("#",""),16)));
			//cell.setBorderColorRight(new Color(Integer.parseInt(tbl.getAttribute("bordercolor").replace("#",""),16)));
			//cell.setBorderColorLeft(new Color(Integer.parseInt(tbl.getAttribute("bordercolor").replace("#",""),16)));
			//cell.setBorderColorBottom(new Color(Integer.parseInt(tbl.getAttribute("bordercolor").replace("#",""),16)));
		}
	}

	private static void addElementToPdfPCell(PdfPCell cell, Element e)
	{
		if (e == null) return;
		else if (e instanceof Paragraph)
		{
			Paragraph p = (Paragraph) e;
			if (cell.getHorizontalAlignment() >= 0 && p.alignment()<0) p.setAlignment(cell.getHorizontalAlignment());
			if (cell.getVerticalAlignment() >= 0 && p.alignment()<0) p.setAlignment(cell.getVerticalAlignment());
			cell.addElement(p);
		}
		else if (e instanceof Chunk)
		{
			Chunk c = (Chunk) e;
			Paragraph p = new Paragraph(c);
			if (cell.getHorizontalAlignment() >= 0 && p.alignment()<0) p.setAlignment(cell.getHorizontalAlignment());
			if (cell.getVerticalAlignment() >= 0 && p.alignment()<0) p.setAlignment(cell.getVerticalAlignment());
			cell.addElement(p);
		}
		else if (e instanceof Image)
		{
			Image img = (Image) e;
			//img.scaleToFit(cell.width(),cell.getFixedHeight());
			cell.addElement(img);
		}
		else if (e instanceof PdfPCell)
		{
			PdfPCell cel = (PdfPCell) e;
			if (cell.getHorizontalAlignment() >= 0 && cel.getHorizontalAlignment()<0) cel.setHorizontalAlignment(cell.getHorizontalAlignment());
			if (cell.getVerticalAlignment() >= 0 && cel.getVerticalAlignment()<0) cel.setVerticalAlignment(cell.getVerticalAlignment());
			cell.addElement(cel);
		}
		else if (e instanceof PdfPTable)
		{
			PdfPTable tbl = (PdfPTable) e;
			if (cell.getHorizontalAlignment() >= 0 && tbl.getHorizontalAlignment()<0) tbl.setHorizontalAlignment(cell.getHorizontalAlignment());
			if (cell.getVerticalAlignment() >= 0 && tbl.getHorizontalAlignment()<0) tbl.setHorizontalAlignment(cell.getVerticalAlignment());
			cell.addElement(tbl);
		}

	}

	/*
	 * private static Paragraph aNewParagraph() throws Exception { Paragraph para = new Paragraph();
	 * 
	 * para.setAlignment(Element.ALIGN_JUSTIFIED_ALL); para.setIndentationLeft(30f); para.setIndentationRight(30f); return
	 * para; }
	 */

	private static void setTDToCellProp(TableColumn td, PdfPCell cell, List t, List children)
	{
		Map mpTblProp = (Map) t.get(0);
		int j = (Integer) t.get(1);
		List lstWidths = (List) mpTblProp.get("widths");

		if (td.getAttribute("bgcolor") != null) cell.setBackgroundColor(new Color(Integer.parseInt(td.getAttribute("bgcolor").replace("#",""),16)));
		if (td.getAttribute("border") != null) cell.setBorder(Integer.parseInt(td.getAttribute("border")));
		if (td.getAttribute("bordercolor") != null) cell.setBorderColor(new Color(Integer.parseInt(td.getAttribute("bordercolor").replace("#", ""),16)));
		if (td.getAttribute("align") != null) cell.setHorizontalAlignment(HTMLToPDFAlign.get(td.getAttribute("align")));
		if (td.getAttribute("valign") != null) cell.setVerticalAlignment(HTMLToPDFAlign.get(td.getAttribute("valign")));
		else	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		if (td.getAttribute("colspan") != null) cell.setColspan(Integer.parseInt(td.getAttribute("colspan")));
		
		if (td.getAttribute("height") != null)
		{
			String height = "0";
			if(!td.getAttribute("height").contains("%"))
			{
				height = td.getAttribute("height").replaceAll("[^0-9]", "");
				cell.setFixedHeight(Float.parseFloat(height)/2);
			}
		}

		int colspan = cell.getColspan();
		t.set(1, j + colspan);

		if (lstWidths.size() == j) for (int i = 0; i < colspan; i++)
			lstWidths.add(new Float(0));

		if (td.getAttribute("width") != null)
		{
			String strWidth = td.getAttribute("width");
			int width = Integer.parseInt(strWidth.replaceAll("\\D", ""));
			// for (int i = 0; i < colspan; i++)
			{
				if (colspan == 1)
				{
					lstWidths.set(j, (float) width);
					// break;
				}
				// float w = width / (float) colspan;
				// if ((Float) lstWidths.get(i + j) < w) lstWidths.set(i + j, w);
			}
		}
		else if(children.size()==0)
		{
			float width = (float)0.01;
			if (colspan == 1)	lstWidths.set(j, width);
		}
	}

	private static void setTableToPdfPTableProp(TableTag tbl, PdfPTable table)
	{
		if (tbl.getAttribute("align") != null) table.setHorizontalAlignment(HTMLToPDFAlign.get(tbl.getAttribute("align")));
		if (tbl.getAttribute("width") != null)
		{
			String strWidth = tbl.getAttribute("width");
			int width = Integer.parseInt(strWidth.replaceAll("\\D", ""));
			table.setWidthPercentage(width);
		}
		else table.setWidthPercentage(100);
	}

	private static void setPToParaProp(ParagraphTag p, Paragraph para)
	{
		if (p.getAttribute("align") != null) para.setAlignment(HTMLToPDFAlign.get(p.getAttribute("align")));
	}

	private static void applyDivProToAllElem(Div div, Element elem)
	{
		if (div.getAttribute("align") != null)
		{
			setAlignmentToElem(elem,div.getAttribute("align"));
			/*if (elem instanceof PdfPTable) setAlignmentToElem(elem,div.getAttribute("align"));
			else if (elem instanceof PdfPCell) setAlignmentToElem(elem,div.getAttribute("align"));
			else if (elem instanceof Paragraph) setAlignmentToElem(elem,div.getAttribute("align"));*/
		}
	}

	private static void applySpanProToAllElem(Span div, Element elem)
	{
		if (div.getAttribute("align") != null)
		{
			setAlignmentToElem(elem,div.getAttribute("align"));
			/*if (elem instanceof PdfPTable) ((PdfPTable) elem).setHorizontalAlignment(HTMLToPDFUTIL.HTMLToPDFAlign.get(div.getAttribute("align")));
			else if (elem instanceof PdfPCell) ((PdfPCell) elem).setHorizontalAlignment(HTMLToPDFUTIL.HTMLToPDFAlign.get(div.getAttribute("align")));
			else if (elem instanceof Paragraph) ((Paragraph) elem).setAlignment(HTMLToPDFUTIL.HTMLToPDFAlign.get(div.getAttribute("align")));*/
		}
	}

	private static void applyBoldProToAllElem(Element elem)
	{
		if (!(elem instanceof Chunk)) return;
		Chunk c = (Chunk) elem;

		Font f = new Font(c.font());
		if (f.style() != -1) f.setStyle(f.style() | Font.BOLD);
		else f.setStyle(Font.BOLD);
		c.setFont(f);
	}

	private static void applyItalicProToAllElem(Element elem)
	{
		if (!(elem instanceof Chunk)) return;
		Chunk c = (Chunk) elem;

		Font f = new Font(c.font());
		if (f.style() != -1) f.setStyle(f.style() | Font.ITALIC);
		else f.setStyle(Font.ITALIC);
		c.setFont(f);
	}

	private static void applyUnderlinedProToAllElem(Element elem)
	{
		if (!(elem instanceof Chunk)) return;
		Chunk c = (Chunk) elem;

		Font f = new Font(c.font());
		if (f.style() != -1) f.setStyle(f.style() | Font.UNDERLINE);
		else f.setStyle(Font.UNDERLINE);
		c.setFont(f);
	}

	private static void applyFontProToAllElem(Tag node, Element elem)
	{
		if (!(elem instanceof Chunk)) return;
		Chunk c = (Chunk) elem;

		Font f = new Font(c.font());
		// Setting Face First & setting f if found
		if (node.getAttribute("face") != null)
		{
			if (f.family() == -1 && f.getBaseFont()==null)
			{
				Font face = null;
				String[] familis = node.getAttribute("face").split(",");
				for(String fam : familis)
				{
					try
					{
						face = FontFactory.getFont(fam.trim());
							//BaseFont.createFont(fam.trim(), BaseFont.CP1252, BaseFont.EMBEDDED);
					}
					catch(Exception e)
					{
						face=null;
						//e.printStackTrace();
					}
					if(face!=null)	break;
				}
				if(face!=null)
				{
					face.setColor(f.color());
					face.setSize(f.size());
					face.setStyle(f.style());
					f=face;
				}
			}
		}
		if (node.getAttribute("color") != null)
		{
			Color color = new Color(Integer.parseInt(node.getAttribute("color").replace("#", ""), 16));
			if(f.color() == null) f.setColor(color);
		}
		if (node.getAttribute("size") != null)
		{
			if (f.size() == -1) f.setSize(Float.parseFloat(node.getAttribute("size")) + 7);
		}
		c.setFont(f);
	}
	
	private static void setAlignmentToElem(Element elem, String align)
	{
		if (elem instanceof PdfPTable) 
		{
			PdfPTable tbl = (PdfPTable)elem;
			if(tbl.getHorizontalAlignment()<0)
				tbl.setHorizontalAlignment(HTMLToPDFUTIL.HTMLToPDFAlign.get(align));
		}
		else if (elem instanceof PdfPCell)
		{
			PdfPCell cell = (PdfPCell)elem;
			if(cell.getHorizontalAlignment()<0)
				cell.setHorizontalAlignment(HTMLToPDFUTIL.HTMLToPDFAlign.get(align));
		}
		else if (elem instanceof Paragraph)
		{
			Paragraph para = (Paragraph)elem;
			if(para.alignment()<0)
				para.setAlignment(HTMLToPDFUTIL.HTMLToPDFAlign.get(align));
		}
		else if (elem instanceof Image)
		{
			Image img = (Image) elem;
			if(img.alignment()<0)
				img.setAlignment(HTMLToPDFUTIL.HTMLToPDFAlign.get(align));
		}
	}

	/*
	 * private static boolean SetAlignment(Node node) throws Exception { // Get TableColumn in Parent Node parent =
	 * node.getParent(); while (!(parent instanceof TableColumn)) parent = parent.getParent(); TableColumn tdImmediate =
	 * (TableColumn) parent; // Get TableColum in Upper Parent parent = parent.getParent(); while (!(parent instanceof
	 * TableColumn)) parent = parent.getParent(); TableColumn tdUpper = (TableColumn) parent;
	 * 
	 * if (tdImmediate.getAttribute("align") != null) { int col = 0; if (tdUpper.getAttribute("colspan") != null) col =
	 * Integer.parseInt(tdUpper.getAttribute("colspan")); if (col == 9) { Paragraph para = null; Element tempEle = null; if
	 * (this.alDocElements.size() > 0 && this.alDocElements.get(this.alDocElements.size() - 1) != null) tempEle = (Element)
	 * this.alDocElements .get(this.alDocElements.size() - 1); if (tempEle != null) { int i = this.alDocElements.size() - 2;
	 * while (i >= 0 && !(tempEle instanceof Paragraph)) tempEle = (Element) this.alDocElements.get(i); if (tempEle
	 * instanceof Paragraph) para = (Paragraph) tempEle; } if (para == null) { para = aNewParagraph();
	 * this.alDocElements.add(para); } if (tdImmediate.getAttribute("align").toLowerCase().equalsIgnoreCase("left"))
	 * para.setAlignment(Element.ALIGN_LEFT); else if
	 * (tdImmediate.getAttribute("align").toLowerCase().equalsIgnoreCase("right")) para.setAlignment(Element.ALIGN_RIGHT);
	 * else if (tdImmediate.getAttribute("align").toLowerCase().equalsIgnoreCase("center"))
	 * para.setAlignment(Element.ALIGN_CENTER); return true; } return false; } return false; }
	 */

	private static Map<String, Integer> HTMLToPDFAlign = new HashMap<String, Integer>();
	static
	{
		HTMLToPDFAlign.put("baseline", Element.ALIGN_BASELINE);
		HTMLToPDFAlign.put("bottom", Element.ALIGN_BOTTOM);
		HTMLToPDFAlign.put("center", Element.ALIGN_CENTER);
		HTMLToPDFAlign.put("justify", Element.ALIGN_JUSTIFIED);
		HTMLToPDFAlign.put("justifyall", Element.ALIGN_JUSTIFIED_ALL);
		HTMLToPDFAlign.put("left", Element.ALIGN_LEFT);
		HTMLToPDFAlign.put("middle", Element.ALIGN_MIDDLE);
		HTMLToPDFAlign.put("right", Element.ALIGN_RIGHT);
		HTMLToPDFAlign.put("top", Element.ALIGN_TOP);
		HTMLToPDFAlign.put("undefined", Element.ALIGN_UNDEFINED);
	}
}
