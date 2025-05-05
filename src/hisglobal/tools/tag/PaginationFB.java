package hisglobal.tools.tag;

import org.apache.struts.action.ActionForm;

public class PaginationFB extends ActionForm
{
	public static final String OBJECT_INSIDE_PAGINATION_ITERATOR_NAME = "paginationObject";
	public static final String PAGINATION_BEAN_NAME = "fbPagination";

	private int totalRecords;
	private int totalPages;
	private int currentPage;
	private int firstPage;
	private int lastPage;
	private int maxRecords;
	private int maxPages;
	private boolean titleRequired=true;
	private boolean totalRequired=true;

	private String objArrName;
	private Object objArrList;

	private String appendInTitle;

	private int startIndex;
	private int endIndex;
	
	// Overview
	private int iOverviewPage;
	private boolean bOverviewRequired;
	private String[] arrOverviewFields;

	public PaginationFB()
	{
		this.maxRecords = 10;
		this.maxPages = 5;

		this.totalRecords = 0;
		this.totalPages = 0;
		this.currentPage = 0;
		this.firstPage = 0;
		this.lastPage = 0;

		this.objArrName = null;
		this.objArrList = null;
		this.appendInTitle = "Records";

		this.startIndex = -1;
		this.endIndex = -1;
		
		this.iOverviewPage = 0;
		this.bOverviewRequired = false;
		this.arrOverviewFields = new String[0];		
	}

	public int getTotalRecords()
	{
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords)
	{
		this.totalRecords = totalRecords;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getFirstPage()
	{
		return firstPage;
	}

	public void setFirstPage(int firstPage)
	{
		this.firstPage = firstPage;
	}

	public int getLastPage()
	{
		return lastPage;
	}

	public void setLastPage(int lastPage)
	{
		this.lastPage = lastPage;
	}

	public int getMaxRecords()
	{
		return maxRecords;
	}

	public void setMaxRecords(int maxRecords)
	{
		this.maxRecords = maxRecords;
	}

	public int getMaxPages()
	{
		return maxPages;
	}

	public void setMaxPages(int maxPages)
	{
		this.maxPages = maxPages;
	}

	public String getObjArrName()
	{
		return objArrName;
	}

	public void setObjArrName(String objArrName)
	{
		this.objArrName = objArrName;
	}

	public String getAppendInTitle()
	{
		return appendInTitle;
	}

	public void setAppendInTitle(String appendInTitle)
	{
		this.appendInTitle = appendInTitle;
	}

	public int getStartIndex()
	{
		return startIndex;
	}

	public void setStartIndex(int startIndex)
	{
		this.startIndex = startIndex;
	}

	public int getEndIndex()
	{
		return endIndex;
	}

	public void setEndIndex(int endIndex)
	{
		this.endIndex = endIndex;
	}

	public boolean isTitleRequired() {
		return titleRequired;
	}

	public void setTitleRequired(boolean titleRequired) {
		this.titleRequired = titleRequired;
	}

	public boolean isTotalRequired()
	{
		return totalRequired;
	}

	public void setTotalRequired(boolean totalRequired)
	{
		this.totalRequired = totalRequired;
	}

	public String[] getArrOverviewFields()
	{
		return arrOverviewFields;
	}

	public void setArrOverviewFields(String[] arrOverviewFields)
	{
		this.arrOverviewFields = arrOverviewFields;
	}

	public boolean isBOverviewRequired()
	{
		return bOverviewRequired;
	}

	public void setBOverviewRequired(boolean overviewRequired)
	{
		bOverviewRequired = overviewRequired;
	}

	public int getIOverviewPage()
	{
		return iOverviewPage;
	}

	public void setIOverviewPage(int overviewPage)
	{
		iOverviewPage = overviewPage;
	}

	public Object getObjArrList()
	{
		return objArrList;
	}

	public void setObjArrList(Object objArrList)
	{
		this.objArrList = objArrList;
	}
}
