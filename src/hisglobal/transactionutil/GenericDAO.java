/**
 * 
 */
package hisglobal.transactionutil;

import hisglobal.transactionmgnt.HisDAO;
import ipd.IpdConfigUtil;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

/**
 * @author dell
 *
 */
public class GenericDAO {
	
	/*
	 *  executes query and store result in webrowset to generate list page data.
	 */
	public static void LISTPAGE(GenericVO vo, String strData,String[] orderBy) {
		StringBuffer sb = new StringBuffer();
		String orderby = "";
		WebRowSet rowset = null;
		HisDAO dao = new HisDAO("TransactionTemplate", "GenericDAO");
		
		try{			
			/*sb.append("SELECT * FROM (SELECT A.DATA,to_char(ROWNUM) SNO FROM ("+ strData);
			if (vo.getSearch() != null && !vo.getSearch().equals("null") && !vo.getSearch().equals(""))
				sb.append(" AND UPPER(" + vo.getSearchColumn()
						+ ") LIKE UPPER('" + vo.getSearch() + "'||'%')");					
			
			if (vo.getOrderby() == null || vo.getOrderby().equals("null") || vo.getOrderby().equals("")) {
				String orderArray[] = orderBy;
				orderby = orderArray[1] + " ASC";
				sb.append(" ORDER BY " + orderby);
			}
			else {
				orderby = vo.getOrderby();
				sb.append(" ORDER BY " + vo.getOrderby());
			}
			
			sb.append(") A ) B WHERE B.SNO <=" + vo.getMax_rownum()+ "  AND B.SNO > " + vo.getMinRow() + " ");
			*/
			
			sb.append(strData);
			if (vo.getSearch() != null && !vo.getSearch().equals("null") && !vo.getSearch().equals(""))
				sb.append(" AND UPPER ( " + vo.getSearchColumn()
						+ " ) LIKE UPPER ( '" + vo.getSearch() + "'||'%' ) ");					
			
			
			
			if (vo.getOrderby() == null || vo.getOrderby().equals("null") || vo.getOrderby().equals(""))
			{
				
				String orderArray[] = orderBy;
				orderby = orderArray[1] + " DESC";
				//System.out.println("-A-Order By--"+orderby);
				sb.append(" ORDER BY " + orderby);
			}
			else 
			{
				orderby = vo.getOrderby();
				//System.out.println("-B-Order By--"+orderby);
				sb.append(" ORDER BY " + vo.getOrderby() +" DESC");
			}
			
			//System.out.println("--GenericDAO. LIST Page Query--Order By--"+orderby+"-"+sb.toString());
			
			rowset = dao.getQryResultFiltered(sb.toString(),vo.getMinRow(),vo.getMax_rownum());
			vo.setOrderby(orderby);
			vo.setLstWs(rowset);
			
		} catch(Exception e){
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
        HisDAO dao=new HisDAO("TransactionTemplate","GenericHLP");        
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
	
	public static void getReports(GenericVO vo, String query, int maxRow, int minRow){
		StringBuilder sb = new StringBuilder();
		HisDAO dao = null;
		WebRowSet webRs = null;
		try{
			sb.append(" SELECT * FROM (SELECT A.DATA,to_char(ROWNUM) SNO FROM ( "+ query);
			if (vo.getSearch() != null && !vo.getSearch().equals("null") && !vo.getSearch().equals(""))
				sb.append(" AND UPPER(" + vo.getSearchColumn()	+ " ) LIKE UPPER( '" + vo.getSearch() + "'||'%')");		
			sb.append(" ) A ) B WHERE B.SNO <=" + maxRow	+ "  AND B.SNO >  " + minRow + " ");
			
			dao = new HisDAO("TransactionTemplate", "getReports");
			webRs = dao.getQryResult(sb.toString());
			
			vo.setLstWs(webRs);	// set the webrowset in a setter method.
		} catch(Exception e){
			vo.setStrMsgString("GenericDAO.getReports -->"+e.getMessage());
			vo.setStrMsgType("1");
		} finally{
			sb = null;
			if(dao != null){
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
	
	//public static void deleteRecords(String query[], String[] tempChk, int no_of_primary, GenericVO vo) {
	public static void deleteRecords(TransInterface masterInterface, String[] tempChk, int no_of_primary, GenericVO vo) {
		  	     	     
	     //String temp[] = null;
	     String query[] = masterInterface.getDeleteQuery();
	     int[] qryIndex = new int[query.length]; 
	        
	     HisDAO dao = null;
	     int i = 0;
	    // int isExtraInfo = 0;
	     List deleteData = null;
	     int keyLen = 0;
	     String[] delValue = null;
	     boolean flag = false;
	     
	     try {	     
	    	 deleteData = new ArrayList();
	    	 
		    //check for extra information appended into chk with | symbol.
	    	 /*
	    	 if((tempChk[no_of_primary-1].indexOf("|")) > -1)
		    	isExtraInfo = 1;
		    */
		    dao = new HisDAO("TransactionTemplate","GenericDAO");    
		    
		    for (i = 0; i < query.length; i++) 
		    {
		    	qryIndex[i] = dao.setQuery(query[i]);     
		    }
		    
		    //int recIndex = 0;
		    //int prevRecIndex = 0;
		    
		    for (i = 0; i < tempChk.length; i++) {
		    	//call interface function
		    	deleteData = masterInterface.getDeleteData(((tempChk[i].replace('$','#')).split("#"))[0]);
		    	
		    	for(int j= 0;j<query.length; j++) {
		    		
		    		delValue = (String[])deleteData.get(j);
		    		if(delValue != null && delValue.length > 0) {
		    			
		    			flag = true;
		    			keyLen = delValue.length;
		    			for(int k = 0;k<keyLen;k++) {
		    				//set the value
		    				dao.setQryValue(qryIndex[j],(k+1),delValue[k]);
		    			}
		    			
		    		}
		    		else
		    			flag = false;
		    		
		    		//put in batch
		    		if(flag || (!flag && i == 0))
		    			dao.execute(qryIndex[j],0);
		    		
		    		delValue = null;
		    	}
		    	
		    	deleteData.clear();
		    }
		    /*
		    //for (i = 0; i < tempChk.length/no_of_primary; i++) 
		    for (i = 0; i < tempChk.length; i++)	
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
		    */
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
		       delValue = null;
		       
		       if(deleteData != null) {
		    	   deleteData.clear();
		    	   deleteData = null;
		       }
		   }		   		  
	  }
	/*
	 * getUserName(GenericVO vo) methods is called when userName is required
	 * 
	*/
	public static void getUserName(GenericVO vo,String strSeatID,String strHospitalCode){
		StringBuilder sb = new StringBuilder();
		HisDAO dao = null;
		WebRowSet webRs = null;
		try
		{
			sb.append(" SELECT GSTR_USER_NAME FROM GBLT_USER_MST  WHERE GNUM_USERID="+strSeatID+" AND GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE="+strHospitalCode);
			
			dao = new HisDAO("TransactionTemplate", "getUserName");
			webRs = dao.getQryResult(sb.toString());
			
			if(webRs!=null)
			{
				webRs.next();
				vo.setStrUserName(webRs.getString(1)); // set user name in vo
			}
		} 
		catch(Exception e)
		{
			vo.setStrMsgString("GenericDAO.getUserName -->"+e.getMessage());
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
	 * getUserName(GenericVO vo) methods is called when userName is required
	 * 
	*/
	public static void getDBButtons(GenericVO vo,String strSeatID,String strHospitalCode,String strDeskID){
		StringBuilder sb = new StringBuilder();
		HisDAO dao = null;
		WebRowSet webRs = null;
		String tmpDeskId = "";
		String tempMenuId = "";
		int intLen = 0;
		String qry="";
		try{

			String[] deskArr = strDeskID.split("#");
			tmpDeskId = deskArr[0];
			intLen = deskArr.length;

			if(intLen > 1)
			{
				for(int k = 1; k<intLen;k++)
				{
					if(!deskArr[k].equals("") && deskArr[k] != null && !deskArr[k].equals("null"))
					{
						if(k == 1)
							tempMenuId = deskArr[k];
						else
							tempMenuId += "," + deskArr[k];
					}
				}
			}
			
			/*qry = "SELECT B.sgblstr_menu_name || '@' || NVL(B.sgblstr_url,' ') || '@' || NVL(B.sgblnum_menu_status,1) " + 
			" || '@' || DECODE(NVL(A.gnum_menu_position,1),2,'right','left') || '@' || " + 
			" b.sgblnum_menu_access_code as DATA " + 
			" FROM gblt_deskmenu_access_dtl A, sgblt_deskmenu_dtl B " + 
			" WHERE A.gnum_isvalid = 1 " + 
			" AND B.gnum_isvalid = 1 " + 
			" AND gdt_effective_frm <= SYSDATE " + 
			" AND A.GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE " + 
			" AND A.SGBLNUM_MENU_ID = B.SGBLNUM_MENU_ID " + 
			" AND A.sgblnum_desk_id = B.sgblnum_desk_id " + 
			" AND A.gnum_hospital_code = '" + strHospitalCode + "' " +
			" AND A.sgblnum_desk_id = '" + tmpDeskId + "' " + 
			" AND A.gnum_access_seatid = '" + strSeatID + "' ";
			if(!tempMenuId.equals(""))
			{
				qry+="AND A.SGBLNUM_MENU_ID NOT IN (" + tempMenuId + ")";
			}

			qry+="ORDER BY B.sgblnum_display_order, B.sgblnum_menu_access_code "; */
			
			qry = " SELECT B.SGBLSTR_MENU_NAME || '@' || NVL(B.SGBLSTR_URL,' ') || '@' || "+
				  " NVL(B.SGBLNUM_MENU_STATUS,1) || '@' || 'LEFT' || '@' ||  B.SGBLNUM_MENU_ACCESS_CODE AS DATA   "+
				  " FROM SGBLT_DESKMENU_DTL B  WHERE  B.GNUM_ISVALID = 1  "+
				  " AND B.GNUM_HOSPITAL_CODE = '"+IpdConfigUtil.SUPER_HOSPITAL_CODE+"'  AND b.sgblnum_desk_id = '"+tmpDeskId+"' "+  
				  " ORDER BY B.sgblnum_display_order, B.sgblnum_menu_access_code "; 

			sb.append(qry);

			qry = "";
	
	
			System.out.println("Query---"+sb.toString());
			
			dao = new HisDAO("TransactionTemplate", "getDBButtons");
			webRs = dao.getQryResult(sb.toString());
			String[] strTmpDBButtons = new String [30];
			String [] strDBButtons = null;
			int i=0;
			if(webRs!=null){
				while(webRs.next()){
					strTmpDBButtons[i]=webRs.getString(1);
					i++;
				}
				strDBButtons= new String[i];
				for(int j=0;j<i;j++)
					strDBButtons[j]=strTmpDBButtons[j];
				vo.setStrDBButton(strDBButtons); // set db buttons in vo
			}
		} catch(Exception e){
			e.printStackTrace();
			vo.setStrMsgString("GenericDAO.getDBButtons -->"+e.getMessage());
			vo.setStrMsgType("1");
		} finally{
			sb = null;
			if(dao != null){
				dao.free();
				dao = null;
			}			
		}
	}
	/*
	 *  executes query and store result in webrowset to generate list page data.
	 */
	public static void EXTRAINFODATA(GenericVO vo, String strQuery) {
		StringBuffer sb = new StringBuffer();
		WebRowSet rowset = null;
		HisDAO dao = new HisDAO("TransactionTemplate", "GenericDAO");
		
		try{			
			
			
			sb.append(strQuery);
			
			rowset = dao.getQryResult(sb.toString());
			vo.setExtraInfoWS(rowset);			
			
		} catch(Exception e){
			vo.setStrMsgString("GenericDAO.LISTPAGE -->"+e.getMessage());
			vo.setStrMsgType("1");			
		} finally{			
			dao.free();
			dao = null;
		}				
	}
}
