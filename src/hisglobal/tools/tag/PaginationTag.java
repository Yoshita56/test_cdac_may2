package hisglobal.tools.tag;

/**
 * @author  CDAC
 */

import hisglobal.presentation.WebUTIL;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PaginationTag extends TitleTag
{
	public static final String PAGINATION_START_INDEX = "paginationStartIndex";
	public static final String PAGINATION_END_INDEX = "paginationEndIndex";

	private PaginationFB fbPagination;
	private boolean isArray = true;
	private Object[] pgtnObjArr = null;
	private List<Object> pgtnObjLst = null;

	public int doStartTag() throws JspTagException
	{
		try
		{
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			HttpSession session = WebUTIL.getSession(request);

			this.fbPagination = (PaginationFB) this.getBean();

			if (this.fbPagination.getObjArrName() == null) return TagSupport.EVAL_BODY_INCLUDE;

			Object o = (Object) session.getAttribute(this.fbPagination.getObjArrName());
			if (o == null)	o = (Object) request.getAttribute(this.fbPagination.getObjArrName());
			if (o == null) return TagSupport.EVAL_BODY_INCLUDE;
			
			if (o.getClass().isArray())
			{
				this.pgtnObjArr = (Object[]) o;
				this.isArray = true;
			}
			else if (o instanceof List)
			{
				this.pgtnObjLst = (List) o;
				this.isArray = false;
			}

			if (this.isArray)
			{
				if (this.pgtnObjArr.length <= 0) return TagSupport.EVAL_BODY_INCLUDE;
			}
			else
			{
				if (this.pgtnObjLst.size() <= 0) return TagSupport.EVAL_BODY_INCLUDE;
			}
			this.fbPagination.setObjArrList(o);

			// Setting Initials
			setPaginationSettings(this);

			// Setting Indices in Request
			String title="";
			if(fbPagination.isTitleRequired())
			{
				if(fbPagination.isTotalRequired())	title = "Total " + this.fbPagination.getTotalRecords() + " " ;
				title+=this.fbPagination.getAppendInTitle();
			}
			else
			{
				title=fbPagination.getAppendInTitle();
			}
			
			// Getting Title Tag
			TitleTag tt = new TitleTag();
			tt.setName(title);
			
			String strDivTop = tt.getFrontBar(request);

			String pagesLinks = "\n<b><font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">";
			int start = this.fbPagination.getFirstPage();
			int end = this.fbPagination.getLastPage();
			if (start > 1)
			{
				pagesLinks +="<a style=\"cursor:pointer\" onclick=\"doPagination(event,'1')\"";
				if(this.fbPagination.isBOverviewRequired())	
					pagesLinks +=" onmouseover=\"doPageOverview(event,'1')\" onmouseout='setView(false);' ";
				pagesLinks +=" >1</a>&nbsp;..";
			}
			for (int i = start; i <= end; i++)
			{
				if (i != this.fbPagination.getCurrentPage())
				{
					pagesLinks +="<a style=\"cursor:pointer\" onclick=\"doPagination(event,'" +i+ "')\"";
					if(this.fbPagination.isBOverviewRequired())	pagesLinks +=" onmouseover=\"doPageOverview(event,'"+ i +"')\" onmouseout='setView(false);' ";
					pagesLinks +=" >&nbsp;" + i + "</a>";
				}
				else pagesLinks += "<font color=\"#FF0000\">&nbsp;" + i + "</font>";
			}
			if (end < this.fbPagination.getTotalPages())
			{
				pagesLinks +="&nbsp;..&nbsp;<a style=\"cursor:pointer\" onclick=\"doPagination(event,'"+this.fbPagination.getTotalPages()+"')\"";
				if(this.fbPagination.isBOverviewRequired())	
					pagesLinks +=" onmouseover=\"doPageOverview(event,'"+this.fbPagination.getTotalPages()+"')\" onmouseout='setView(false);' ";
				pagesLinks +=" >"+this.fbPagination.getTotalPages()+"</a>";
			}

			pagesLinks += "</font></b>";
			
			if(this.fbPagination.isBOverviewRequired())	
				pagesLinks +="<div id='divPaginationTag' style='position: absolute; display: none;'></div>";

			String strDivBottom = tt.getEndBar(request);

			
			JspWriter out = this.pageContext.getOut();
			out.println(strDivTop + pagesLinks + strDivBottom);
			//System.out.println("Pagination >>>>>>"+strDivTop + pagesLinks + strDivBottom);

			Map<String, Object> mp = new HashMap<String, Object>();
			mp.put(PAGINATION_START_INDEX, this.fbPagination.getStartIndex());
			mp.put(PAGINATION_END_INDEX, this.fbPagination.getEndIndex());
			mp.put(PaginationFB.PAGINATION_BEAN_NAME, this.fbPagination);
			WebUTIL.setMapInRequest(mp, request);
			WebUTIL.setMapInSession(mp, request);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	private static void setPaginationSettings(PaginationTag tag_p)
	{
		// Setting Initial Properties
		if (tag_p.isArray) tag_p.fbPagination.setTotalRecords(tag_p.pgtnObjArr.length);
		else tag_p.fbPagination.setTotalRecords(tag_p.pgtnObjLst.size());

		if (tag_p.fbPagination.getTotalRecords() > 0)
		{
			tag_p.fbPagination.setTotalPages((int) Math
					.ceil((double) tag_p.fbPagination.getTotalRecords() / (double) tag_p.fbPagination.getMaxRecords()));
			if ((tag_p.fbPagination.getCurrentPage() + tag_p.fbPagination.getMaxPages() / 2) <= tag_p.fbPagination.getTotalPages()) tag_p.fbPagination
					.setFirstPage(((tag_p.fbPagination.getCurrentPage() - tag_p.fbPagination.getMaxPages() / 2) < 1) ? 1 : (tag_p.fbPagination
							.getCurrentPage() - tag_p.fbPagination.getMaxPages() / 2));
			else tag_p.fbPagination.setFirstPage(((tag_p.fbPagination.getTotalPages() - tag_p.fbPagination.getMaxPages() + 1) < 1) ? 1
					: (tag_p.fbPagination.getTotalPages() - tag_p.fbPagination.getMaxPages() + 1));
			tag_p.fbPagination.setLastPage(((tag_p.fbPagination.getFirstPage() + tag_p.fbPagination.getMaxPages() - 1) >= tag_p.fbPagination
					.getTotalPages()) ? tag_p.fbPagination.getTotalPages() : (tag_p.fbPagination.getFirstPage() + tag_p.fbPagination.getMaxPages() - 1));

			// Setting Indices
			tag_p.fbPagination.setStartIndex((tag_p.fbPagination.getCurrentPage() - 1) * tag_p.fbPagination.getMaxRecords());
			int endIndex = tag_p.fbPagination.getCurrentPage() * tag_p.fbPagination.getMaxRecords() - 1;
			endIndex = (endIndex < tag_p.fbPagination.getTotalRecords()) ? endIndex : (tag_p.fbPagination.getTotalRecords() - 1);
			tag_p.fbPagination.setEndIndex(endIndex);
		}
	}

	public static List<String> getPageOverview(HttpServletRequest request_p, int pageNo_p)
	{
		HttpSession session = null;
		List<String> lstData = new ArrayList<String>();
		PaginationTag tag = new PaginationTag();
		try
		{
			// Getting Pagination FB from session
			session = WebUTIL.getSession(request_p);
			if(session.getAttribute(PaginationFB.PAGINATION_BEAN_NAME)==null)	return lstData;
			tag.fbPagination = (PaginationFB) session.getAttribute(PaginationFB.PAGINATION_BEAN_NAME);
	
			// Getting Feild Name for Overview 
			if(tag.fbPagination.getArrOverviewFields()==null || tag.fbPagination.getArrOverviewFields().length==0)
				return lstData;
			
			// Getting Data
			if (tag.fbPagination.getObjArrList() == null) return lstData;
			Object o = tag.fbPagination.getObjArrList(); 
				
			if (o.getClass().isArray())
			{
				tag.pgtnObjArr = (Object[]) o;
				tag.isArray = true;
			}
			else if (o instanceof List)
			{
				tag.pgtnObjLst = (List) o;
				tag.isArray = false;
			}
	
			if (tag.isArray)	{	if (tag.pgtnObjArr.length <= 0) return lstData;		}
			else				{	if (tag.pgtnObjLst.size() <= 0) return lstData;		}
	
			// Setting Current Page
			tag.fbPagination.setCurrentPage(pageNo_p);
			
			// Setting Initials
			setPaginationSettings(tag);
	
			// Setting Indices in Request
			if(tag.fbPagination.isBOverviewRequired())
			{
				int start = tag.fbPagination.getStartIndex();
				int end = tag.fbPagination.getEndIndex();

				for (int i = start; i <= end; i++)
				{
					StringBuffer rowData = new StringBuffer("");
					Object objData = null;
					if (tag.isArray) objData = tag.pgtnObjArr[i];
					else objData = tag.pgtnObjLst.get(i);
					Method[] arrMethods = objData.getClass().getMethods();
					for(String field : tag.fbPagination.getArrOverviewFields())
						for (int j = 0; j < arrMethods.length; j++)
							if (arrMethods[j].getName().indexOf("get") == 0)
								if (field.equalsIgnoreCase(arrMethods[j].getName().substring(3)))
								{
									Object str = arrMethods[j].invoke(objData);
									if(str == null)	str = "";
									rowData.append(str.toString());
									rowData.append("@");
								}
					lstData.add(rowData.toString());
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return lstData;
	}
	
	private String width;
	private String name;
	private Object bean;

	public String getWidth()
	{
		return width;
	}

	public void setWidth(String width)
	{
		this.width = width;
	}

	public void setName(String name)
	{
		this.name = name;
		try
		{
			this.setBean();
		}
		catch(JspException e)
		{
			e.printStackTrace();
		}
	}

	public String getName()
	{
		return name;
	}

	public Object getBean()
	{
		return bean;
	}

	public void setBean() throws JspException
	{
		this.bean = TagUtil.getAttribute(this.pageContext, this.getName());
		if (this.bean == null) throw new RuntimeException("No bean with name: " + this.getName());
	}

	public String getRequiredWidth()
	{
		if (this.width == null) return DEFAULT_WIDTH;
		return this.width;
	}

	String DEFAULT_WIDTH = "100%";
}
