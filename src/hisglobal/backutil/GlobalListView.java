package hisglobal.backutil;


import hisglobal.backutil.dto.DataTransferObject;

import java.util.*;


public class GlobalListView extends Page
{
   	// Varibales local to this file used to set the page call variable
   	private String primaryKey = "";
   	private int no_of_fields_view;
	private int no_of_primary_keys_view;
	private int record_per_page_view;
	private String pagename_view;
	private int	page_per_block_view;
	private String search_Fld_view="";
	private String search_Val_view="";
	private String topColor_view="";
	private String hdrColor_view="";
	private String rowColor_view="";
	private String fontUsed_view="";
	private List headlist_view;
	private Map sortmap_view;
	private Map searchmap_view;
	private String table="";
	private int page_no_view;
	private String statusLabel="";

//constructor for the GlobalListView

   public GlobalListView(int no_of_fields,int no_of_primary_keys,int record_per_page,String pagename,int page_per_block,String topColor,String hdrColor,String rowColor,String fontUsed,List headlist,Map sortmap,Map searchmap,int page_no,String strLabel)
   {
	//System.out.println("Start of globalList View Constructor===");
	no_of_fields_view=no_of_fields;
	no_of_primary_keys_view=no_of_primary_keys;
	record_per_page_view=record_per_page;
	pagename_view=pagename;
	page_per_block_view=page_per_block;
	topColor_view=topColor;
	hdrColor_view=hdrColor;
	rowColor_view=rowColor;
	fontUsed_view=fontUsed;
    headlist_view=headlist;
	sortmap_view=sortmap;
	searchmap_view=searchmap;
	page_no_view=page_no;
	statusLabel=strLabel;

	//System.out.println("End of of globalList View Constructor===");
   }

 // query1 for no of records and query2 for primary key

 //Function to create the table at run time

  public String getListForm(String query1,String query2,String table_heading,int block,String var1,String var2,String cboSearch,String txtSearch,String pk) throws Exception
  {
	  //System.out.println("Start of getListForm===");
	  this.primaryKey = pk;
     List l1=new ArrayList(); // list for the data to displayed
    List primary=new ArrayList(); // list for the data of primary key field
	String tabletop="",tablebody="";
	String getcombo[]=new String[1];
	String paginationtable="";


    String searchQry="";
	String ordervar="";

			if (cboSearch == null || cboSearch.equals("-1") || cboSearch.equals("null"))
			{
				cboSearch = "-1";
				txtSearch = "";
			}
			if (txtSearch == null || txtSearch.equals("") || cboSearch.equals("null"))
			{
				txtSearch = "";
				cboSearch = "-1";
			}


		System.out.println("ordervar ==="+ordervar);
		/***** search and sort criteria's ******************/

			if (!txtSearch.equals("") && cboSearch.equals("-1") == false)
			searchQry = "UPPER(" + cboSearch.trim() + ") like '" + txtSearch.trim().toUpperCase() + "%'";

			if(var1!=null)
			{
				if((var1.trim()).length()>1)
					ordervar = " order by " + var1;
			}
			else
				var1 = "";

			if(var2!=null)
				ordervar = ordervar + " " + var2;
			else
				var2 = "";

			System.out.println("ordervar ==="+ordervar);
		/********************************************/

		/* ****** Query's for the fields to be displayed and primary field ***** */

		if (searchQry != "")
		{
			query1 = query1 + " AND " + searchQry;
			query2 = query2 + " AND " + searchQry;
		}

        if(ordervar.equals(""))
		{
			/*String temp1="";
			if( headlist_view.size()>0)
				 temp1 = String.valueOf( headlist_view.get(0));
			if(sortmap_view.containsKey(temp1))
			{
				String temp2 = String.valueOf(sortmap_view.get(temp1));

			}*/

        	query1 += " ORDER BY " + primaryKey;
			query2 += " ORDER BY " + primaryKey;
		}
		else
		{
				query1 += " " + ","+primaryKey;
				query2 += " " + ","+primaryKey;
		}

    //
    try
    {
    	System.out.println("query1 "+query1);
    	System.out.println("query2 "+query2);

	    setColor(topColor_view,hdrColor_view,rowColor_view,fontUsed_view);
	    setVariables(no_of_fields_view,no_of_primary_keys_view,record_per_page_view,pagename_view,page_per_block_view,search_Fld_view,search_Val_view,0,getcombo);

	    l1=CommonDataBaseManip.getDetail(query1);

	    primary=CommonDataBaseManip.getDetail(query2);
	    int totRecords=(l1.size())/no_of_fields_view;
		System.out.println("totRecords========="+totRecords);
		int no_of_pages=getNoOfPages(l1.size());
		paginationtable=paginationTable(no_of_pages,var1,var2,block,totRecords);

		tablebody=getTable(page_no_view,l1,primary,headlist_view,sortmap_view,searchmap_view);
	    //System.out.println("tablebody====="+tablebody);
		tabletop=tableHeading(table_heading,paginationtable,"");

	   // System.out.println("body of the table"+tablebody);
		//System.out.println("top of the table"+tabletop);

		/// new line added for certain changes and let me check please
		//StringBuffer buffer = new StringBuffer();
		//buffer.append( "<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n");
		//buffer.append( "<tr class=addheader>  \n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "Status <select name='statusSearch' tabindex='1' class='cbo2' onChange=cancelNew('"+pagename+"',event); onClick=cancelNew('"+pagename+"',event);>>\n");
		//buffer.append( "<option value = '1' selected>Active</option>\n");
		//buffer.append( "<option value = '0' >Inactive</option>\n");
		//buffer.append( "</select>\n");
		//buffer.append("<input type='text' name='txtSearch' class='textbox' onKeyPress=cancelNew('pagename',event); value = 'searchVal'");
		//buffer.append("' tabindex='1' >\n");
		//buffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Search.gif' ");
		//buffer.append( " width='70' height='19' align=Top border=0 tabindex='1' onKeyPress=cancelNew('pagename',event); onClick=cancelNew('pagename',event);>");
		//buffer.append( "\n");
		//buffer.append( "</select></td>\n");
		//buffer.append("</tr>\n");
		//buffer.append( "</table>\n");


		/// checking over
		String statusCombo=getStatusCombo(statusLabel,no_of_fields_view);
		table=tabletop+statusCombo+tablebody;

   }
	catch (Exception e)
	{
	  throw new Exception("hisglobal.backutil.GlobalListView.getListForm()"+e.getMessage());
	}

	//System.out.println("table======"+table);
	//System.out.println("======rreturning from getList form");
	return table;
 }

//Added as on dated 27052008 

  public String getListFormWithHospital(String query1,String query2,String table_heading,int block,String var1,String var2,String cboSearch,String txtSearch,String pk,String HospitalCode) throws Exception
  {
	  //System.out.println("Start of getListForm===");
	this.primaryKey = pk;
    List l1=new ArrayList(); // list for the data to displayed
    List primary=new ArrayList(); // list for the data of primary key field
	String tabletop="",tablebody="";
	String getcombo[]=new String[1];
	String paginationtable="";
    String searchQry="";
	String ordervar="";

			if (cboSearch == null || cboSearch.equals("-1") || cboSearch.equals("null"))
			{
				cboSearch = "-1";
				txtSearch = "";
			}
			if (txtSearch == null || txtSearch.equals("") || cboSearch.equals("null"))
			{
				txtSearch = "";
				cboSearch = "-1";
			}
		System.out.println("ordervar ==="+ordervar);
		/***** search and sort criteria's ******************/
			if (!txtSearch.equals("") && cboSearch.equals("-1") == false)
			searchQry = "UPPER(" + cboSearch.trim() + ") like '" + txtSearch.trim().toUpperCase() + "%'";
			if(var1!=null)
			{
				if((var1.trim()).length()>1)
				ordervar = " order by " + var1;
			}
			else
				var1 = "";

			if(var2!=null)
				ordervar = ordervar + " " + var2;
			else
				var2 = "";

			System.out.println("ordervar ==="+ordervar);
		/**********************************************************************/
		
		/* ****** Additional criteria for Hospital Code integration regarding */
		if (HospitalCode!="")
		{
			query1 = query1 + " AND T.GNUM_HOSPITAL_CODE=" + HospitalCode;
			query2 = query2 + " AND T.GNUM_HOSPITAL_CODE=" + HospitalCode;
			
			System.out.println("Query 1......within HospitalCode"+query1);
			System.out.println("Query 2......within HospitalCode"+query2);
			
		}
		/* ****** Query's for the fields to be displayed and primary field ***** */	
		if (searchQry != "")
		{
			query1 = query1 + " AND " + searchQry;
			query2 = query2 + " AND " + searchQry;
		}
        if(ordervar.equals(""))
		{
			/*String temp1="";
			if( headlist_view.size()>0)
				 temp1 = String.valueOf( headlist_view.get(0));
			if(sortmap_view.containsKey(temp1))
			{
				String temp2 = String.valueOf(sortmap_view.get(temp1));

			}*/

        	query1 += " ORDER BY " + primaryKey;
			query2 += " ORDER BY " + primaryKey;
		}
		else
		{
				//query1 += " " + ","+primaryKey;
				//query2 += " " + ","+primaryKey;
			//SHILPASOOD FOR PAGINATION
			query1 += " ";
			query2 += " ";
	
			
		}

    //
    try
    {
    	System.out.println("query1 "+query1);
    	System.out.println("query2 "+query2);
	    setColor(topColor_view,hdrColor_view,rowColor_view,fontUsed_view);
	    setVariables(no_of_fields_view,no_of_primary_keys_view,record_per_page_view,pagename_view,page_per_block_view,search_Fld_view,search_Val_view,0,getcombo);
	    l1=CommonDataBaseManip.getDetail(query1);
	    primary=CommonDataBaseManip.getDetail(query2);
	    int totRecords=(l1.size())/no_of_fields_view;
		System.out.println("totRecords========="+totRecords);
		int no_of_pages=getNoOfPages(l1.size());
		paginationtable=paginationTable(no_of_pages,var1,var2,block,totRecords);
		tablebody=getTable(page_no_view,l1,primary,headlist_view,sortmap_view,searchmap_view);
	    //System.out.println("tablebody====="+tablebody);
		tabletop=tableHeading(table_heading,paginationtable,"");
	    // System.out.println("body of the table"+tablebody);
		//System.out.println("top of the table"+tabletop);
		/// new line added for certain changes and let me check please
		//StringBuffer buffer = new StringBuffer();
		//buffer.append( "<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n");
		//buffer.append( "<tr class=addheader>  \n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "Status <select name='statusSearch' tabindex='1' class='cbo2' onChange=cancelNew('"+pagename+"',event); onClick=cancelNew('"+pagename+"',event);>>\n");
		//buffer.append( "<option value = '1' selected>Active</option>\n");
		//buffer.append( "<option value = '0' >Inactive</option>\n");
		//buffer.append( "</select>\n");
		//buffer.append("<input type='text' name='txtSearch' class='textbox' onKeyPress=cancelNew('pagename',event); value = 'searchVal'");
		//buffer.append("' tabindex='1' >\n");
		//buffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Search.gif' ");
		//buffer.append( " width='70' height='19' align=Top border=0 tabindex='1' onKeyPress=cancelNew('pagename',event); onClick=cancelNew('pagename',event);>");
		//buffer.append( "\n");
		//buffer.append( "</select></td>\n");
		//buffer.append("</tr>\n");
		//buffer.append( "</table>\n");

		/// checking over
		String statusCombo=getStatusCombo(statusLabel,no_of_fields_view);
		table=tabletop+statusCombo+tablebody;

   }
	catch (Exception e)
	{
	  throw new Exception("hisglobal.backutil.GlobalListView.getListForm()"+e.getMessage());
	}
	//System.out.println("table======"+table);
	//System.out.println("======rreturning from getList form");
	return table;
 }

  
  public String getListFormWithHospitalCode(String query1,String query2,String table_heading,int block,String var1,String var2,String cboSearch,String txtSearch,String pk,String HospitalCode) throws Exception
  {
	  //System.out.println("Start of getListForm===");
	this.primaryKey = pk;
    List l1=new ArrayList(); // list for the data to displayed
    List primary=new ArrayList(); // list for the data of primary key field
	String tabletop="",tablebody="";
	String getcombo[]=new String[1];
	String paginationtable="";
    String searchQry="";
	String ordervar="";

			if (cboSearch == null || cboSearch.equals("-1") || cboSearch.equals("null"))
			{
				cboSearch = "-1";
				txtSearch = "";
			}
			if (txtSearch == null || txtSearch.equals("") || cboSearch.equals("null"))
			{
				txtSearch = "";
				cboSearch = "-1";
			}
		System.out.println("ordervar ==="+ordervar);
		/***** search and sort criteria's ******************/
			if (!txtSearch.equals("") && cboSearch.equals("-1") == false)
			searchQry = "UPPER(" + cboSearch.trim() + ") like '" + txtSearch.trim().toUpperCase() + "%'";
			if(var1!=null)
			{
				if((var1.trim()).length()>1)
				ordervar = " order by " + var1;
			}
			else
				var1 = "";

			if(var2!=null)
				ordervar = ordervar + " " + var2;
			else
				var2 = "";

			System.out.println("ordervar ==="+ordervar);
		/**********************************************************************/
		
		/* ****** Additional criteria for Hospital Code integration regarding */
		if (HospitalCode!="")
		{
			query1 = query1 + " AND T.NUM_HOSPITAL_CODE=" + HospitalCode;
			query2 = query2 + " AND T.NUM_HOSPITAL_CODE=" + HospitalCode;
			
			System.out.println("Query 1......within HospitalCode"+query1);
			System.out.println("Query 2......within HospitalCode"+query2);
			
		}
		/* ****** Query's for the fields to be displayed and primary field ***** */	
		if (searchQry != "")
		{
			query1 = query1 + " AND " + searchQry;
			query2 = query2 + " AND " + searchQry;
		}
        if(ordervar.equals(""))
		{
			/*String temp1="";
			if( headlist_view.size()>0)
				 temp1 = String.valueOf( headlist_view.get(0));
			if(sortmap_view.containsKey(temp1))
			{
				String temp2 = String.valueOf(sortmap_view.get(temp1));

			}*/

        	query1 += " ORDER BY " + primaryKey;
			query2 += " ORDER BY " + primaryKey;
		}
		else
		{
				/*query1 += " " + ","+primaryKey;
				query2 += " " + ","+primaryKey;*/
			//SHILPASOOD FOR PAGINATION
			query1+= " ";
			query2+= " ";
		}

    //
    try
    {
    	System.out.println("query1 "+query1);
    	System.out.println("query2 "+query2);
	    setColor(topColor_view,hdrColor_view,rowColor_view,fontUsed_view);
	    setVariables(no_of_fields_view,no_of_primary_keys_view,record_per_page_view,pagename_view,page_per_block_view,search_Fld_view,search_Val_view,0,getcombo);
	    l1=CommonDataBaseManip.getDetail(query1);
	    primary=CommonDataBaseManip.getDetail(query2);
	    int totRecords=(l1.size())/no_of_fields_view;
		System.out.println("totRecords========="+totRecords);
		int no_of_pages=getNoOfPages(l1.size());
		paginationtable=paginationTable(no_of_pages,var1,var2,block,totRecords);
		tablebody=getTable(page_no_view,l1,primary,headlist_view,sortmap_view,searchmap_view);
	    //System.out.println("tablebody====="+tablebody);
		tabletop=tableHeading(table_heading,paginationtable,"");
	    // System.out.println("body of the table"+tablebody);
		//System.out.println("top of the table"+tabletop);
		/// new line added for certain changes and let me check please
		//StringBuffer buffer = new StringBuffer();
		//buffer.append( "<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n");
		//buffer.append( "<tr class=addheader>  \n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "<td align = 'right' height='19'>\n");
		//buffer.append( "Status <select name='statusSearch' tabindex='1' class='cbo2' onChange=cancelNew('"+pagename+"',event); onClick=cancelNew('"+pagename+"',event);>>\n");
		//buffer.append( "<option value = '1' selected>Active</option>\n");
		//buffer.append( "<option value = '0' >Inactive</option>\n");
		//buffer.append( "</select>\n");
		//buffer.append("<input type='text' name='txtSearch' class='textbox' onKeyPress=cancelNew('pagename',event); value = 'searchVal'");
		//buffer.append("' tabindex='1' >\n");
		//buffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Search.gif' ");
		//buffer.append( " width='70' height='19' align=Top border=0 tabindex='1' onKeyPress=cancelNew('pagename',event); onClick=cancelNew('pagename',event);>");
		//buffer.append( "\n");
		//buffer.append( "</select></td>\n");
		//buffer.append("</tr>\n");
		//buffer.append( "</table>\n");

		/// checking over
		String statusCombo=getStatusCombo(statusLabel,no_of_fields_view);
		table=tabletop+statusCombo+tablebody;

   }
	catch (Exception e)
	{
	  throw new Exception("hisglobal.backutil.GlobalListView.getListForm()"+e.getMessage());
	}
	//System.out.println("table======"+table);
	//System.out.println("======rreturning from getList form");
	return table;
 }

  
  
  
  public String getListForm1(String query1,String query2,String table_heading,int block,String var1,String var2,String cboSearch,String txtSearch,String pk) throws Exception
  {
	  //System.out.println("Start of getListForm===");
	  this.primaryKey = pk;
      List l1=new ArrayList(); // list for the data to displayed
      List primary=new ArrayList(); // list for the data of primary key field
	  String tabletop="",tablebody="";
	  String getcombo[]=new String[1];
	  String paginationtable="";

    //Added
      String searchQry="";
	  String ordervar="";

			if (cboSearch == null || cboSearch.equals("-1") || cboSearch.equals("null"))
			{
				cboSearch = "-1";
				txtSearch = "";
			}
			if (txtSearch == null || txtSearch.equals("") || cboSearch.equals("null"))
			{
				txtSearch = "";
				cboSearch = "-1";
			}


		System.out.println("ordervar ==="+ordervar);
		/***** search and sort criteria's ******************/

			if (!txtSearch.equals("") && cboSearch.equals("-1") == false)
			searchQry = "UPPER(" + cboSearch.trim() + ") like '" + txtSearch.trim().toUpperCase() + "%'";

			if(var1!=null)
			{
				if((var1.trim()).length()>1)
					ordervar = " order by " + var1;
			}
			else
				var1 = "";

			if(var2!=null)
				ordervar = ordervar + " " + var2;
			else
				var2 = "";

			System.out.println("ordervar ==="+ordervar);
		/********************************************/

		/* ****** Query's for the fields to be displayed and primary field ***** */

		if (searchQry != "")
		{
			query1 = query1 + " AND " + searchQry;
			query2 = query2 + " AND " + searchQry;
		}

        if(ordervar.equals(""))
		{
			/*String temp1="";
			if( headlist_view.size()>0)
				 temp1 = String.valueOf( headlist_view.get(0));
			if(sortmap_view.containsKey(temp1))
			{
				String temp2 = String.valueOf(sortmap_view.get(temp1));

			}*/

        	query1 += " ORDER BY " + primaryKey;
			query2 += " ORDER BY " + primaryKey;
		}
		else
		{
				query1 += " " + ordervar+","+primaryKey;
				query2 += " " + ordervar+","+primaryKey;
		}

    //
    try
    {
    	System.out.println(query1);
    	System.out.println(query2);

	    setColor(topColor_view,hdrColor_view,rowColor_view,fontUsed_view);
	    setVariables(no_of_fields_view,no_of_primary_keys_view,record_per_page_view,pagename_view,page_per_block_view,search_Fld_view,search_Val_view,0,getcombo);

	    l1=CommonDataBaseManip.getDetail(query1);
		//System.out.println("atul list===="+l1);
	    primary=CommonDataBaseManip.getDetail(query2);
	    int totRecords=(l1.size())/no_of_fields_view;
		int no_of_pages=getNoOfPages(l1.size());
		paginationtable=paginationTable(no_of_pages,var1,var2,block,totRecords);

		tablebody=getTable1(page_no_view,l1,primary,headlist_view,sortmap_view,searchmap_view);
	    //System.out.println("tablebody====="+tablebody);
		tabletop=tableHeading(table_heading,paginationtable,"");

	   // System.out.println("body of the table"+tablebody);
		//System.out.println("top of the table"+tabletop);

		table=tabletop+tablebody;

   }
	catch (Exception e)
	{
	  throw new Exception("hisglobal.backutil.GlobalListView.getListForm"+e.getMessage());
	}

	//System.out.println("table======"+table);
	//System.out.println("======rreturning from getList form");
	return table;
 }


  
  public String getListFormWithHospital1(String query1,String query2,String table_heading,int block,String var1,String var2,String cboSearch,String txtSearch,String pk,String HospitalCode) throws Exception
  {
   //System.out.println("Start of getListForm===");
	 this.primaryKey = pk;
    List l1=new ArrayList(); // list for the data to displayed
    List primary=new ArrayList(); // list for the data of primary key field
    String tabletop="",tablebody="";
    String getcombo[]=new String[1];
    String paginationtable="";
    String searchQry="";
    String ordervar="";
 
   if (cboSearch == null || cboSearch.equals("-1") || cboSearch.equals("null"))
   {
    cboSearch = "-1";
    txtSearch = "";
   }
   if (txtSearch == null || txtSearch.equals("") || cboSearch.equals("null"))
   {
    txtSearch = "";
    cboSearch = "-1";
   }
  System.out.println("ordervar ==="+ordervar);
  /***** search and sort criteria's ******************/
   if (!txtSearch.equals("") && cboSearch.equals("-1") == false)
   searchQry = "UPPER(" + cboSearch.trim() + ") like '" + txtSearch.trim().toUpperCase() + "%'";
   if(var1!=null)
   {
    if((var1.trim()).length()>1)
    ordervar = " order by " + var1;
   }
   else
    var1 = "";
 
   if(var2!=null)
    ordervar = ordervar + " " + var2;
   else
    var2 = "";
 
   System.out.println("ordervar ==="+ordervar);
  /**********************************************************************/
  
  /* ****** Additional criteria for Hospital Code integration regarding */
  if (HospitalCode!="")
  {
   query1 = query1 + " AND T.NUM_HOSPITAL_CODE=" + HospitalCode;
   query2 = query2 + " AND T.NUM_HOSPITAL_CODE=" + HospitalCode;
   
   
   
   
   System.out.println("Query 1......within HospitalCode"+query1);
   System.out.println("Query 2......within HospitalCode"+query2);
   
  }
  /* ****** Query's for the fields to be displayed and primary field ***** */ 
  if (searchQry != "")
  {
   query1 = query1 + " AND " + searchQry;
   query2 = query2 + " AND " + searchQry;
  }
        if(ordervar.equals(""))
  {
   /*String temp1="";
   if( headlist_view.size()>0)
     temp1 = String.valueOf( headlist_view.get(0));
   if(sortmap_view.containsKey(temp1))
   {
    String temp2 = String.valueOf(sortmap_view.get(temp1));
 
   }*/
 
         query1 += " ORDER BY " + primaryKey;
   query2 += " ORDER BY " + primaryKey;
  }
  else
  {
    //query1 += " " + ","+primaryKey;
    //query2 += " " + ","+primaryKey;
   query1 += " "; //+ ","+primaryKey;
   query2 += " "; //+ ","+primaryKey;
  }
 
    //
    try
    {
     System.out.println("query1 "+query1);
     System.out.println("query2 "+query2);
     setColor(topColor_view,hdrColor_view,rowColor_view,fontUsed_view);
     setVariables(no_of_fields_view,no_of_primary_keys_view,record_per_page_view,pagename_view,page_per_block_view,search_Fld_view,search_Val_view,0,getcombo);
     l1=CommonDataBaseManip.getDetail(query1);
     primary=CommonDataBaseManip.getDetail(query2);
     int totRecords=(l1.size())/no_of_fields_view;
  System.out.println("totRecords========="+totRecords);
  int no_of_pages=getNoOfPages(l1.size());
  paginationtable=paginationTable(no_of_pages,var1,var2,block,totRecords);
  tablebody=getTable1(page_no_view,l1,primary,headlist_view,sortmap_view,searchmap_view);
     //System.out.println("tablebody====="+tablebody);
  tabletop=tableHeading(table_heading,paginationtable,"");
     // System.out.println("body of the table"+tablebody);
  //System.out.println("top of the table"+tabletop);
  /// new line added for certain changes and let me check please
  //StringBuffer buffer = new StringBuffer();
  //buffer.append( "<table width='100%' border='0' cellspacing='0' cellpadding='0'>\n");
  //buffer.append( "<tr class=addheader>  \n");
  //buffer.append( "<td align = 'right' height='19'>\n");
  //buffer.append( "<td align = 'right' height='19'>\n");
  //buffer.append( "<td align = 'right' height='19'>\n");
  //buffer.append( "<td align = 'right' height='19'>\n");
  //buffer.append( "<td align = 'right' height='19'>\n");
  //buffer.append( "Status <select name='statusSearch' tabindex='1' class='cbo2' onChange=cancelNew('"+pagename+"',event); onClick=cancelNew('"+pagename+"',event);>>\n");
  //buffer.append( "<option value = '1' selected>Active</option>\n");
  //buffer.append( "<option value = '0' >Inactive</option>\n");
  //buffer.append( "</select>\n");
  //buffer.append("<input type='text' name='txtSearch' class='textbox' onKeyPress=cancelNew('pagename',event); value = 'searchVal'");
  //buffer.append("' tabindex='1' >\n");
  //buffer.append( "<a style=cursor:hand><img src='..\\..\\images\\Search.gif' ");
  //buffer.append( " width='70' height='19' align=Top border=0 tabindex='1' onKeyPress=cancelNew('pagename',event); onClick=cancelNew('pagename',event);>");
  //buffer.append( "\n");
  //buffer.append( "</select></td>\n");
  //buffer.append("</tr>\n");
  //buffer.append( "</table>\n");
 
  /// checking over
  String statusCombo=getStatusCombo(statusLabel,no_of_fields_view);
  table=tabletop+statusCombo+tablebody;
 
   }
 catch (Exception e)
 {
   throw new Exception("hisglobal.backutil.GlobalListView.getListForm()"+e.getMessage());
 }
 //System.out.println("table======"+table);
 //System.out.println("======rreturning from getList form");
 return table;
 }

 //ADDED BY SHILPA DUE TO PROBLEM WITH THE NUM_HOSPITAL_CODE & NUM_HOSPITAL_ID  
  
  public String getListFormEstate(String query1,String query2,String table_heading,int block,String var1,String var2,String cboSearch,String txtSearch,String pk,String HospitalCode,String HOS) throws Exception
  {
   //System.out.println("Start of getListForm===");
	 this.primaryKey = pk;
    List l1=new ArrayList(); // list for the data to displayed
    List primary=new ArrayList(); // list for the data of primary key field
    String tabletop="",tablebody="";
    String getcombo[]=new String[1];
    String paginationtable="";
    String searchQry="";
    String ordervar="";
 
   if (cboSearch == null || cboSearch.equals("-1") || cboSearch.equals("null"))
   {
    cboSearch = "-1";
    txtSearch = "";
   }
   if (txtSearch == null || txtSearch.equals("") || cboSearch.equals("null"))
   {
    txtSearch = "";
    cboSearch = "-1";
   }
  System.out.println("ordervar ==="+ordervar);
  /***** search and sort criteria's ******************/
   if (!txtSearch.equals("") && cboSearch.equals("-1") == false)
   searchQry = "UPPER(" + cboSearch.trim() + ") like '" + txtSearch.trim().toUpperCase() + "%'";
   if(var1!=null)
   {
    if((var1.trim()).length()>1)
    ordervar = " order by " + var1;
   }
   else
    var1 = "";
 
   if(var2!=null)
    ordervar = ordervar + " " + var2;
   else
    var2 = "";
 
   System.out.println("ordervar ==="+ordervar);
  /**********************************************************************/
  
  /* ****** Additional criteria for Hospital Code integration regarding */
  if (HospitalCode!="")
  {
   query1 = query1 +  " AND " + HOS +"=" + HospitalCode;
   query2 = query2 +  " AND " + HOS +"=" + HospitalCode;
   
   
   
   
   System.out.println("Query 1......within HospitalCode"+query1);
   System.out.println("Query 2......within HospitalCode"+query2);
   
  }
  /* ****** Query's for the fields to be displayed and primary field ***** */ 
  if (searchQry != "")
  {
   query1 = query1 + " AND " + searchQry;
   query2 = query2 + " AND " + searchQry;
   
   System.out.println("query1 SEARCH"+query1);
   System.out.println("query2 SEARCH"+query2);
  }
        if(ordervar.equals(""))
  {
   /*String temp1="";
   if( headlist_view.size()>0)
     temp1 = String.valueOf( headlist_view.get(0));
   if(sortmap_view.containsKey(temp1))
   {
    String temp2 = String.valueOf(sortmap_view.get(temp1));
 
   }*/
 
         query1 += " ORDER BY " + primaryKey;
   query2 += " ORDER BY " + primaryKey;
  }
  else
  {
    //query1 += " " + ","+primaryKey;
    //query2 += " " + ","+primaryKey;
   query1 += " "; //+ ","+primaryKey;
   query2 += " "; //+ ","+primaryKey;
  }
 
    //
    try
    {
    	System.out.println(query1);
    	System.out.println(query2);

	    setColor(topColor_view,hdrColor_view,rowColor_view,fontUsed_view);
	    setVariables(no_of_fields_view,no_of_primary_keys_view,record_per_page_view,pagename_view,page_per_block_view,search_Fld_view,search_Val_view,0,getcombo);

	    l1=CommonDataBaseManip.getDetail(query1);
		//System.out.println("atul list===="+l1);
	    primary=CommonDataBaseManip.getDetail(query2);
	    int totRecords=(l1.size())/no_of_fields_view;
		int no_of_pages=getNoOfPages(l1.size());
		paginationtable=paginationTable(no_of_pages,var1,var2,block,totRecords);

		tablebody=getTable1(page_no_view,l1,primary,headlist_view,sortmap_view,searchmap_view);
	    //System.out.println("tablebody====="+tablebody);
		tabletop=tableHeading(table_heading,paginationtable,"");

		table=tabletop+tablebody;

 
   }
 catch (Exception e)
 {
   throw new Exception("hisglobal.backutil.GlobalListView.getListForm()"+e.getMessage());
 }
 //System.out.println("table======"+table);
 //System.out.println("======rreturning from getList form");
 return table;
 }

    

  
  
}//End Of Class


