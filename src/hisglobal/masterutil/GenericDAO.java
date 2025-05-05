/**
 * 
 */
package hisglobal.masterutil;

import javax.sql.rowset.WebRowSet;


import billing.BillConfigUtil;
import hisglobal.transactionmgnt.*;
import hisglobal.utility.SecurityUtil;

/**
 * @author dell
 *
 */
public class GenericDAO {

	public static void LISTPAGE(GenericVO vo, String strData, String[] orderBy) {
		StringBuilder sb = new StringBuilder();
		String orderby = "";
		WebRowSet rowset = null;
		HisDAO dao = new HisDAO("MasterTemplate", "GenericDAO");
		
		try{
			
			  
			sb.append("SELECT * FROM (SELECT A.DATA,(ROWNUM) SNO FROM ("+ strData);
			
			if (vo.getSearch() != null && !vo.getSearch().equals("null") && !vo.getSearch().equals(""))
				sb.append(" AND (SELECT UPPER(" + SecurityUtil.decrypt(vo.getSearchColumn())
						+ ") FROM DUAL) LIKE (SELECT UPPER('" + vo.getSearch().replace("$", "%") + "'||'%') FROM DUAL) ");					
			
			//System.out.println("vo.getOrderby()"+vo.getOrderby());
			if (vo.getOrderby() == null || vo.getOrderby().equals("null") || vo.getOrderby().equals("")) 
			{
				String orderArray[] = orderBy;
				orderby = orderArray[1] + " ASC";
				sb.append(" ORDER BY " + orderby);
			}
			else 
			{
				orderby = SecurityUtil.decrypt(vo.getOrderby());
				//sb.append(" ORDER BY " + orderby);
			}
			
			sb.append(") A ) B WHERE B.SNO <=" + vo.getMax_rownum()+ "  AND B.SNO > " + vo.getMinrow() + " ");
			
			rowset = dao.getQryResult(sb.toString());
			vo.setOrderby(SecurityUtil.encrypt(orderby));//  commented due to application error on clicking of next button on list page of generic drug master and drug master
			//vo.setOrderby((orderby));
			vo.setLstWs(rowset);
			
			
			
			
		} 
		catch(Exception e){
			e.printStackTrace();
			vo.setStrMsgString("GenericDAO.LISTPAGE -->"+e.getMessage());
			vo.setStrMsgType("1");			
		} finally{			
			dao.free();
			dao = null;
		}				
	}
	
//	 getArrayList() methods will give the data for view mode in form of List.
	public static void getArrayList(String query, GenericVO vo) {		
        WebRowSet rs = null;        
        HisDAO dao=new HisDAO("Master Template","GenericHLP");        
        String[] tempArr = null;
        int qryIndex=0;        
		
        try {
			String temp_chk[] = vo.getChk().replace('$', '#').split("#");
			String chk = temp_chk[0];			
			qryIndex= dao.setQuery(query);
			//does not have index value. already split from the called function
			String temp[] = chk.split("@");			
			//to remove the extra information appended by &
			tempArr = (temp[temp.length - 1].replace('|','#')).split("#");
			temp[temp.length - 1] = tempArr[0];		
			for (int i = 0; i < temp.length; i++)
			{
				if(temp[i].contains("|")){
					
					temp[i] = temp[i].replace('|','#').split("#")[0];
				}
				
               	dao.setQryValue(qryIndex,(i+1),temp[i]);
			}           
           //rs=  new WebRowSetImpl();
           rs=dao.executeQry(qryIndex);           
           vo.setLstWs(rs);           
        
		}
		catch (Exception e) {			
            vo.setStrMsgString("GenericDAO.getArrayList -->"+e.getMessage());
			vo.setStrMsgType("1");           
         }
        finally 
        {
            if(dao != null) {
            	dao.free();
            	dao = null;
            }
            
            query = null;           
           
        }      
	}
	
	public static void getReports(GenericVO vo, String query, int maxRow, int minRow,String strShowAllData)
	{
		StringBuilder sb = new StringBuilder();
		HisDAO dao = null;
		WebRowSet webRs = null;
		try
		{
			String[] strQueryCols={query};
			strQueryCols= strQueryCols[0].replace("||","").replace("'", "").replace("^", "#").split("#");
			strQueryCols[strQueryCols.length-1]=strQueryCols[strQueryCols.length-1].toUpperCase().replace(" DATA ", "#").split("#")[0];
			
			for(int nTmpI=0; nTmpI<strQueryCols.length; nTmpI++)
			{
				if(strQueryCols[nTmpI].replace("(", "#").split("#").length>1)
					strQueryCols[nTmpI]=strQueryCols[nTmpI].replace("(", "#").split("#")[1];
				strQueryCols[nTmpI]=strQueryCols[nTmpI].replace(",", "#").split("#")[0];
				strQueryCols[nTmpI]=strQueryCols[nTmpI].replace(")", "#").split("#")[0];
			}
			
			
			String strGetOrderBy=null;
			for(int nTmpI=0;vo.getStrOrderByCols()!=null && nTmpI<vo.getStrOrderByCols().length;nTmpI++)
			{
				if(strQueryCols[Integer.parseInt(vo.getStrOrderByCols()[nTmpI])].toLowerCase().contains("_date"))
					strQueryCols[Integer.parseInt(vo.getStrOrderByCols()[nTmpI])]="to_date("+strQueryCols[Integer.parseInt(vo.getStrOrderByCols()[nTmpI])]+",'dd-Mon-yyyy')";
				
					if(!strQueryCols[Integer.parseInt(vo.getStrOrderByCols()[nTmpI])].contains("/"))
					{						
						if(nTmpI==0)
							strGetOrderBy = SecurityUtil.decrypt(strQueryCols[Integer.parseInt(vo.getStrOrderByCols()[nTmpI])]);
						else
							strGetOrderBy +=", "+SecurityUtil.decrypt(strQueryCols[Integer.parseInt(vo.getStrOrderByCols()[nTmpI])]);						
					}			
			}
			System.out.println("strGetOrderBy"+strGetOrderBy);
			System.out.println("vo.getRptOrderBy()"+vo.getRptOrderBy());
			if(strGetOrderBy==null)
				strGetOrderBy=SecurityUtil.decrypt(vo.getRptOrderBy());
			System.out.println("strGetOrderBy"+strGetOrderBy);
			sb.append("SELECT * FROM (SELECT X.DATA,ROWNUM SNO FROM ("+ query);

			if (vo.getSearch() != null && !vo.getSearch().equals("null") && !vo.getSearch().equals(""))
				sb.append("  AND EXISTS (SELECT 'X' FROM DUAL WHERE UPPER(" + SecurityUtil.decrypt(vo.getSearchColumn())+ ") LIKE UPPER('" + vo.getSearch().replace("$", "%") + "'||'%')) ");
				
				//sb.append(" AND UPPER(" + vo.getSearchColumn()	+ ") LIKE UPPER('" + vo.getSearch().replace("$", "%") + "'||'%')");	
			sb.append(" ORDER BY "+ strGetOrderBy +"  ) X  ) B ");
			
			if(strShowAllData.equals("0"))
				sb.append(" WHERE B.SNO <=" + maxRow	+ "  AND B.SNO > " + minRow );
			//System.out.println("report query : "+sb.toString());
			
					
			dao = new HisDAO("MasterTemplate", "getReports");
			webRs = dao.getQryResult(sb.toString());
			
			vo.setLstWs(webRs);	// set the webrowset in a setter method.
		} 
		catch(Exception e)
		{
			//e.printStackTrace();
			vo.setStrMsgString("GenericDAO.getReports -->"+e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally
		{
			sb = null;
			if(dao != null)
			{
				dao.free();
				dao = null;
			}			
		}
	}
	
	/*
	 * deleteRecords(String query, String chk) methods is called when delete
	 * button is clicked on list page
	*/
	
	// deleteRecords function is changed on 17-Aug-2007 to make function compatible with multiple query execution.
	//chk = extra information could be appended with & symbol
	public static void deleteRecords(String query[], String[] tempChk, int no_of_primary, GenericVO vo) {
		  	     	     
	     String temp[] = null;
	     int[] qryIndex = new int[query.length]; 
	        
	     HisDAO dao = null;
	     int i = 0;
	     int isExtraInfo = 0;
	     
	     try {	             	    			    
		    //check for extra information appended into chk with | symbol.
		    if((tempChk[no_of_primary-1].indexOf("|")) > -1)
		    	isExtraInfo = 1;
		    
		    dao = new HisDAO("Master Template","GenericDAO");    
		    for (i = 0; i < query.length; i++) 
		    {
		      qryIndex[i] = dao.setQuery(query[i]);     
		    }
		    
		    int recIndex = 0;
		    int prevRecIndex = 0;
		    
		    for (i = 0; i < tempChk.length/no_of_primary; i++) 
		    {
			    for (int j = 0; j < query.length; j++)
			    {
			    	prevRecIndex = recIndex;
			    	for (int k = 0; k < no_of_primary ; k++)
			    	{
			    		if(isExtraInfo == 1)
			    			temp = (tempChk[prevRecIndex++].replace('|','#')).split("#");
			    		else
			    			temp = (tempChk[prevRecIndex++].replace('$','#')).split("#");
			    					    		  
							    		
			    		dao.setQryValue(qryIndex[j],(k+1),temp[0]);
			    	}
			     }
		    		    
			     recIndex = prevRecIndex;
			     for (int psLength = 0; psLength < query.length; psLength++)
			     {
			    	 dao.execute(qryIndex[psLength],0);
			     }
		    }
		    
		    dao.fire();
		    vo.setStrMsgString(""+i);    		    
		    vo.setStrMsgType("0");
		   }
		   catch (Exception e) {			    		    
			    vo.setStrMsgString("GenericDAO.deleteRecords -->"+e.getMessage());
				vo.setStrMsgType("1");
		    }
		   finally {
			   if(dao != null){
				   dao.free();
			       dao=null; 
			   }			   
		       qryIndex=null;		      
		       tempChk = null;
		       temp = null;
		   }		   		  
	  }
	
	public static void insertReportConfig(GenericVO _genericVO) {
		HisDAO dao = null;
		int nQueryIndex;
		StringBuilder strQuery=new StringBuilder();
		strQuery.append("INSERT INTO GBLT_MASTER_REPORT_CONFIG ( ");
		strQuery.append("GSTR_MASTER_NAME, GSTR_GROUPBY_COLS, GSTR_NOTREQUIRED_COLS, "); 
		strQuery.append("GSTR_ORDERBY_COLS, GSTR_ALGN_WITH, GSTR_SHOWALL_DATA, ");
		strQuery.append("GNUM_RECORD_PER_PAGE, GSTR_BORDER_REQUIRED, GSTR_CONCATENATION_REQ, "); 
		strQuery.append("GSTR_GROUPBY_IN_LINE, GNUM_ISVALID, GDT_ENTRY_DATE, "); 
		strQuery.append("GNUM_HOSPITAL_CODE)"); 
		strQuery.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, sysdate, ?)");
		String strDeleteQuery="";
		try {
			dao = new HisDAO("Master Template","GenericDAO");    
			strDeleteQuery="DELETE FROM GBLT_MASTER_REPORT_CONFIG WHERE GSTR_MASTER_NAME='"+_genericVO.getStrMasterName().split("#")[0]+"' AND GNUM_HOSPITAL_CODE="+BillConfigUtil.SUPER_HOSPITAL_CODE;

			nQueryIndex = dao.setQuery(strDeleteQuery); 
			dao.execute(nQueryIndex,0);
			dao.fire();
			dao.free();
			
			String strData="";
			nQueryIndex = dao.setQuery(strQuery.toString());  
			
			dao.setQryValue(nQueryIndex,1,_genericVO.getStrMasterName().split("#")[0]);   
			strData="";
			for(int nTmpI=0; _genericVO.getStrReportGroupBy()!=null && nTmpI<_genericVO.getStrReportGroupBy().length; nTmpI++){
				if(strData.equals(""))
					strData = _genericVO.getStrReportGroupBy()[nTmpI];
				else
					strData +=","+ _genericVO.getStrReportGroupBy()[nTmpI];
			}
			dao.setQryValue(nQueryIndex,2,strData);  
			strData="";  
			for(int nTmpI=0; _genericVO.getStrColNotRequired()!=null && nTmpI<_genericVO.getStrColNotRequired().length; nTmpI++){
				if(strData.equals(""))
					strData = _genericVO.getStrColNotRequired()[nTmpI];
				else
					strData +=","+ _genericVO.getStrColNotRequired()[nTmpI];
			}
			dao.setQryValue(nQueryIndex,3,strData);    
			strData="";
			for(int nTmpI=0; _genericVO.getStrOrderByCols()!=null && nTmpI<_genericVO.getStrOrderByCols().length; nTmpI++){
				if(strData.equals(""))
					strData = _genericVO.getStrOrderByCols()[nTmpI];
				else
					strData +=","+ _genericVO.getStrOrderByCols()[nTmpI];
			}
			dao.setQryValue(nQueryIndex,4,strData);   
			strData=""; 
			for(int nTmpI=0; nTmpI<_genericVO.getStrAlignWith().length; nTmpI++){
				if(strData.equals(""))
					strData = _genericVO.getStrAlignWith()[nTmpI];
				else
					strData +=","+ _genericVO.getStrAlignWith()[nTmpI];
			}
			dao.setQryValue(nQueryIndex,5,strData);
			dao.setQryValue(nQueryIndex,6,_genericVO.getStrShowAllData()); 
			dao.setQryValue(nQueryIndex,7,_genericVO.getStrNoOfRecordPerPages());  
			dao.setQryValue(nQueryIndex,8,_genericVO.getStrBorderRequired());    
			dao.setQryValue(nQueryIndex,9,_genericVO.getStrConcatString());    
			dao.setQryValue(nQueryIndex,10,_genericVO.getStrGroupByPatern());    
			dao.setQryValue(nQueryIndex,11,BillConfigUtil.SUPER_HOSPITAL_CODE);  
			
			dao.execute(nQueryIndex,0);
			
			dao.fire();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			_genericVO.setStrMsgString("GenericDAO.insertReportConfig -->"+e.getMessage());
			_genericVO.setStrMsgType("1");
		}
		finally {
			if(dao != null){
				dao.free();
				dao=null; 
			}			   
		}		   		  
	}
	
	public static void fetchReportConfig(GenericVO _genericVO) {
		StringBuilder strQuery = new StringBuilder();
		WebRowSet wbData = null;
		HisDAO dao = null;
		
		try{
			dao = new HisDAO("MasterTemplate", "GenericDAO");
			strQuery.append(" SELECT ");
			strQuery.append(" G.GSTR_GROUPBY_COLS||'#'||G.GSTR_NOTREQUIRED_COLS||'#'||G.GSTR_ORDERBY_COLS||'#'||"); 
			strQuery.append(" G.GSTR_ALGN_WITH||'#'||G.GSTR_SHOWALL_DATA||'#'||G.GNUM_RECORD_PER_PAGE||'#'||");
			strQuery.append(" G.GSTR_BORDER_REQUIRED||'#'||G.GSTR_CONCATENATION_REQ||'#'||G.GSTR_GROUPBY_IN_LINE ");
			strQuery.append(" FROM GBLT_MASTER_REPORT_CONFIG G WHERE G.GNUM_ISVALID=1 AND ");
			strQuery.append(" G.GSTR_MASTER_NAME = '");  
			strQuery.append(_genericVO.getStrMasterName().split("#")[0]);
			strQuery.append("' AND G.GNUM_HOSPITAL_CODE= "+BillConfigUtil.SUPER_HOSPITAL_CODE); 
			//strQuery.append(_genericVO.getStrHospCode());
			wbData = dao.getQryResult(strQuery.toString());
			if(wbData.size()==1){
				wbData.next();
				_genericVO.setStrReportConfigDtl(wbData.getString(1));
			}else
				_genericVO.setStrReportConfigDtl("False");
		} 
		catch(Exception e){
			e.printStackTrace();
			_genericVO.setStrMsgString("GenericDAO.fetchReportConfig -->"+e.getMessage());
			_genericVO.setStrMsgType("1");			
		} finally{			
			dao.free();
			dao = null;
		}				
	}
}
