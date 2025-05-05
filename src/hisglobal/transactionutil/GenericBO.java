/**
 * 
 */
package hisglobal.transactionutil;

/**
 * @author dell
 *
 */
public class GenericBO {

	/*
	 *  creates business logics to generate report.
	 */
	
	
	public void LISTPAGE(GenericVO vo, int rec_per_page, int page_per_block, String mode, String mainQuery, String[] orderBy) throws Exception {
		String prevNext = "";		
		int minrow = 0;
		int blockNo = 0;
		int max_rownum = 0;	
		try{			
		    prevNext = vo.getPrevNext();
			minrow = Integer.parseInt(vo.getRowNum());
			blockNo = Integer.parseInt(vo.getBlockNo().equals("null")?"0":vo.getBlockNo());
			
			if(mode.equals("LISTPAGE")){				
				//minrow = Integer.parseInt(vo.getMinrow());
				minrow = Integer.parseInt(vo.getRowNum());
				max_rownum = Integer.parseInt(vo.getMax_rownum());								
			}
			
			if (mode.equals("DELETE")) {
				minrow = Integer.parseInt(vo.getMinRow());
				max_rownum = Integer.parseInt(vo.getMax_rownum());
			}
			else {
				if(prevNext.equals("1")) {
					max_rownum = (minrow + (rec_per_page * page_per_block)) + 1;	
				}
				else {
					if(prevNext.equals("2")) {
						//minrow = (rec_per_page * page_per_block) + 1;
						max_rownum = (blockNo * (rec_per_page * page_per_block)) + 1;
						minrow = ((blockNo - 1) * (rec_per_page * page_per_block));		
					}
					else {
						blockNo = 1;
						max_rownum = (minrow + (rec_per_page * page_per_block)) + 1;		
					}
				}
				
				/*
				if (mode.equals("DEFAULT") || mode.equals("null")
						|| mode == null) {
					blockNo = 1;
					max_rownum = (minrow + (rec_per_page * page_per_block)) + 1;					
				}
				else {
					if (prevNext.equals("1")) // 1 means next, 2 means previous
					{
						max_rownum = (minrow + (rec_per_page * page_per_block)) + 1;						
					}
					else
						if (prevNext.equals("2")) // 1 means next, 2 means previous
						{
							minrow = (rec_per_page * page_per_block) + 1;
							max_rownum = (blockNo * (rec_per_page * page_per_block)) + 1;
							minrow = ((blockNo - 1) * (rec_per_page * page_per_block));							
						}
				}
				*/
				
			}
			vo.setBlockNo(String.valueOf(blockNo));
			vo.setMinRow(String.valueOf(minrow));
			vo.setMax_rownum(String.valueOf(max_rownum));	
			GenericDAO.LISTPAGE(vo, getMainQuery(mainQuery, vo), orderBy);
			if(vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}			
		} catch(Exception e)
		{			
			vo.setStrMsgString("GenericBO.LISTPAGE --> "+vo.getStrMsgString());
			vo.setStrMsgType("1");
			throw new Exception("GenericBO.LISTPAGE --> "+e.getMessage());
		}
	}
	
	public void getArrayList(String query, GenericVO vo){
		
		try{
			GenericDAO.getArrayList(query, vo);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
		} catch(Exception e){
			e.printStackTrace();
			vo.setStrMsgString("GenericBO.getArrayList --> "+vo.getStrMsgString());
			vo.setStrMsgType("1");			
		}		
	}
	
	/*
	 *  creates business logics to generate report.
	 */
	public void getReports(GenericVO vo, String query, int record_per_page, int record_per_block){
		try{
			int minRow = (Integer.parseInt(vo.getBlockNo()) * (record_per_page * record_per_block))	- (record_per_page * record_per_block);
			int maxRow = (Integer.parseInt(vo.getBlockNo())* (record_per_page * record_per_block) + 1);
			GenericDAO.getReports(vo, this.getMainQuery(query, vo), maxRow, minRow);
			if(vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}
		} catch(Exception e){
			e.printStackTrace();
			vo.setStrMsgString("GenericBO.getReports --> "+vo.getStrMsgString());
			vo.setStrMsgType("1");	
		}
	}
	
	//public void deleteRecords(String[] query, GenericVO vo){	
	public void deleteRecords(TransInterface masterInterface, GenericVO vo){	
		 int no_of_primary = 0;  //no of column that is combination of a primary key.
	     String tempChk[] = null;	     	     
	     try{
	    	
	    	 tempChk = vo.getChk().replace('$','#').split("#");
			 no_of_primary = (tempChk[0].replace('@','#').split("#")).length;
			 tempChk = vo.getChk().replace('~', '#').split("#");
			 
			 //GenericDAO.deleteRecords(query, tempChk, no_of_primary, vo);
			 GenericDAO.deleteRecords(masterInterface, tempChk, no_of_primary, vo);
			 if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
			}
	     } catch(Exception e){
	    	 vo.setStrMsgString("GenericBO.deleteRecords --> "+vo.getStrMsgString());
			 vo.setStrMsgType("1");	
	     } 
	}

	/*
	 * getMainQuery(String str_temp_query, String str_temp_combo[]) function
	 * returns main with complete value split and replaces the combo values if
	 * combo box is present in to listing page
	 * 
	 */
	
	public String getMainQuery(String str_temp_query, GenericVO vo) {		
		StringBuilder temp_main_query = new StringBuilder(500);	
		String temp_main[] = str_temp_query.toString().split("#");
		try{			
			int min = 0;
			int max = 0;
			int length = (temp_main.length);			
			if (length > 1) {				
				for (int k = 0; k < length; k++) {
					String int_index_value = "";					
					if (temp_main[k].length() <= 2) {						
						int_index_value = String.valueOf(temp_main[k]);
						min = int_index_value.charAt(0);
						max = int_index_value.charAt(int_index_value.length() - 1);
						if (min >= 48 && max <= 57) {
							int index = Integer.parseInt(temp_main[k]);
							if (vo.getCombo() != null)
								temp_main_query.append(vo.getCombo()[index - 1]);
							else
								temp_main_query.append("null");
		
						}
						else {
							temp_main_query.append(temp_main[k]);
						}
					}
					else {
						temp_main_query.append(temp_main[k]);
					}
		
				}
			}
			else {
				temp_main_query.append(temp_main[0]);
			}
		    temp_main=null;
		    if(vo.getStrMsgType() == "1")
		    	throw new Exception(vo.getStrMsgString());
		} catch(Exception e){
			vo.setStrMsgString("GenericBO.getMainQuery --> "+vo.getStrMsgString());
			 vo.setStrMsgType("1");	
		}			    
		return temp_main_query.toString();
	}
		
	public void getUserName(GenericVO vo,String strSeatID,String strHospitalCode){
		GenericDAO.getUserName(vo,strSeatID,strHospitalCode);
		if(vo.getStrMsgType() == "1")
			vo.setStrMsgString("GenericBO.getUserName --> "+vo.getStrMsgString());	
	}
	
	public void getDBButtons(GenericVO vo,String strSeatID,String strHospitalCode,String strDeskID){
		GenericDAO.getDBButtons(vo,strSeatID,strHospitalCode,strDeskID);
		if(vo.getStrMsgType() == "1")
			vo.setStrMsgString("GenericBO.getDBButtons --> "+vo.getStrMsgString());	
	}
	public void EXTRAINFODATA(GenericVO vo,String extraInfoQuery) throws Exception {
		try
		{			
			GenericDAO.EXTRAINFODATA(vo, extraInfoQuery);
			if(vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}			
		} 
		catch(Exception e)
		{			
			vo.setStrMsgString("GenericBO.LISTPAGE --> "+vo.getStrMsgString());
			vo.setStrMsgType("1");
			throw new Exception("GenericBO.LISTPAGE --> "+e.getMessage());
		}
	}
}
