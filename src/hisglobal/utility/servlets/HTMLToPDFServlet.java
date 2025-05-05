package hisglobal.utility.servlets;

/**
 * @author : C-DAC, Noida
 * Project : AHIMS
 * Developed By : Pragya Sharma
 * 
 * Purpose : This is a servlet that will generate a PDF document
 *  and send the document to the client via the ServletOutputStream
 * 
 */

import hisglobal.utility.HTMLParsingUTIL;
import hisglobal.utility.HTMLToPDFUTIL;
import hisglobal.utility.HisFileControlUtil;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class HTMLToPDFServlet extends HttpServlet
{
	public HTMLToPDFServlet()
	{
		super();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException
	{
		doGet(req, resp);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException
	{
		ByteArrayOutputStream baosPDF = null;
		PdfWriter docWriter = null;
		Document doc = new Document();
		HttpSession session = req.getSession();
		try
		{
			
			String strHtmData = "";
			if(session.getAttribute(ServletsUtilityConfig.HTML_TO_PDF_UTIL_HTML_CODE)!= null)
				strHtmData = (String) session.getAttribute(ServletsUtilityConfig.HTML_TO_PDF_UTIL_HTML_CODE);
			else if(req.getAttribute(ServletsUtilityConfig.HTML_TO_PDF_UTIL_HTML_CODE)!=null)
				strHtmData = (String) req.getAttribute(ServletsUtilityConfig.HTML_TO_PDF_UTIL_HTML_CODE);
			else if(req.getParameter(ServletsUtilityConfig.HTML_TO_PDF_UTIL_HTML_CODE)!=null)
				strHtmData = (String) req.getParameter(ServletsUtilityConfig.HTML_TO_PDF_UTIL_HTML_CODE);
			
			strHtmData = HTMLParsingUTIL.makeHTMLPDFCompatible(strHtmData);
			
			HTMLToPDFUTIL converter = new HTMLToPDFUTIL(session, doc, strHtmData);
			//ConvertHTMLToPDF converter = new ConvertHTMLToPDF(doc, strHtmData);

			// Byte Array Output Stream to write to the Response 
			baosPDF = new ByteArrayOutputStream();
			
			// Creating Pdf Writer of iText to write to Pdf as well as to Byte Reader
			docWriter = PdfWriter.getInstance(doc, baosPDF);
			docWriter.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);

			// Setting PDF Document
			/*doc.addTitle("PRAGYA SHARMA RnD");
			doc.addKeywords("pdf, itext, Java, open source, http");
			doc.setPageSize(PageSize.A4);
			HeaderFooter header = new HeaderFooter(	new Phrase("This is a Header"),false);
			HeaderFooter footer = new HeaderFooter(	new Phrase("This is a footer."),false);
			doc.setHeader(header);
			doc.setFooter(footer);*/
			
			/*doc.addAuthor("C-DAC,Noida");
			doc.addCreator("AHIMS Team");
			doc.addSubject("PDF for Printing Purpose");
			doc.open();
			doc.newPage();
			
			Chunk c= new Chunk("Pragya Sharma");
			doc.add(c);

			PdfPTable table = new PdfPTable(2);
			Paragraph p = new Paragraph("Quick brown fox jumps over the lazy dog. Quick brown fox jumps over the lazy dog.");
			table.addCell("default alignment");
			PdfPCell cell = new PdfPCell(p);
			table.addCell(cell);
			table.addCell("centered alignment");
			cell = new PdfPCell(p);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			table.addCell("right alignment");
			//doc.add(table);

			PdfPTable tbl = new PdfPTable(2);
			tbl.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tbl.setWidthPercentage(new float[]{30,70},PageSize.A4);
			tbl.setWidthPercentage(80);

			cell = new PdfPCell(new Paragraph("Pragya"));
			
			//cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.getColumn().setAlignment(Element.ALIGN_RIGHT);
			cell.addElement(new Paragraph("Pragya"));
			//cell.setColspan(1);
			tbl.addCell(cell);

			cell = new PdfPCell(new Paragraph("Mohita"));
			
			//cell.setColspan(1);
			//cell.addElement(new Paragraph("Mohita"));			
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			//cell.normalize();
			tbl.addCell(cell);
			//cell.getColumn().setAlignment(Element.ALIGN_RIGHT);

			cell = new PdfPCell();
			//cell.addElement(new Paragraph("Pragya Sharma"));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.getColumn().setAlignment(Element.ALIGN_CENTER);
			p = new Paragraph("Pragya Sharma");
			p.setAlignment(Element.ALIGN_CENTER);
			cell.getColumn().addElement(p);
			cell.getColumn().addText(new Chunk("Pragya it Sharma"));
			cell.getColumn().addElement(table);
			cell.setColspan(2);
			
			//tbl.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			tbl.addCell(cell);
			doc.add(tbl);
			
			
			
			doc.close();*/
			
			converter.convertToPDF();
			
			//doc.open();
			//Chunk c= new Chunk("Praga");
			//doc.add(c);

			if (doc != null) doc.close();
			if (docWriter != null) docWriter.close();
			if (baosPDF.size() < 1) throw new DocumentException("document has " + baosPDF.size() + " bytes");

			System.out.println(doc.getPageSize());

			// Saving To a File at C:\
			HisFileControlUtil hfcu = new HisFileControlUtil("abc.pdf","C:\\","/root/");
			hfcu.setFileContent(baosPDF.toByteArray());
			hfcu.saveFile();
			
			// Writing to Response
			ServletOutputStream sos;
			sos = resp.getOutputStream();
			baosPDF.writeTo(sos);
			sos.flush();
		}
		catch (DocumentException dex)
		{
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println(this.getClass().getName() + " caught an exception: " + dex.getClass().getName() + "<br>");
			writer.println("<pre>");
			dex.printStackTrace(writer);
			writer.println("</pre>");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println("Unable to Convert HTML To PDF");
		}
		finally
		{
			if (baosPDF != null)
			{
				baosPDF.reset();
			}
		}
	}
}
