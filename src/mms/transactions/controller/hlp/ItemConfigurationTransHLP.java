package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ItemConfigurationTransVO;

public class ItemConfigurationTransHLP 
{
	
	public static String getItemDtls(ItemConfigurationTransVO vo, WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		int i = 1;
		final int REC_PER_PAGE = 500;
		final int PAGE_PER_BLOCK = 50;
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
		String strStoreName = "";
		String batchNo = "0";
		String avlQty = "";
		String expiryDt = "";
		String stockStatus = "";
		String reservedQty = "";
		String blockedQty = "";
		String unitName = "",itemBrandName="";
		String activeQty = "";
		String inActiveQty = "";
		String quarantineQty = "";
		int activeQtyTotal=0,inActiveQtyTotal=0,quarantineQtyTotal=0;
		String mrp,branded;
		int count=0;
		
		try
		{
			if(ws != null )
			{
											
	            if(ws.size() > 0)
				{				
	            			   			
					br.append("<table  class='table table-striped text-uppercase' id='example'>");
					br.append("<thead class='multiPOControl' style='color:grey;'>");
					br.append("<tr>");					
					br.append("<th><div align='center'><input type='checkbox' title='View' name='strSelctAllChk'  id='strSelctAllChk'  value='0'  onclick='selectAllChkBox(this)'></div></th>");
					br.append("<th><div align='center'><b>Store Name</b></div></th>");	
					br.append("<th><div align='center'><b>Name</b></div></th>");	
		  	        br.append("<th><div align='center'><b>Batch No</b></div></th>");
		  	        br.append("<th><div align='center'><b>Expiry Date</b></div></th>");		  
		  	        br.append("<th><div align='center'><b>Cost To Patient/Unit</b></div></th>");		  	       	       
		  	        br.append("<th><div align='center'><b>Total Qty(No.)</b></div></th>");		        
		            br.append("</tr>");
		            br.append("</thead>");
		            br.append("<tbody>");
		           	
		           // Pkg_Mms_View.Proc_stock_detail  [ Mode -  3 ]
								while(ws.next())
								{
					            	strStoreName 		= ws.getString(8);
					            	batchNo 			= ws.getString(15);
					            	expiryDt 			= ws.getString(18);
					            	avlQty 				= ws.getString(9);
					            	stockStatus 		= ws.getString(40);
					            	reservedQty 		= ws.getString(41);
					            	blockedQty 			= ws.getString(42);
					            	unitName 			= ws.getString(43);
					            	itemBrandName		= ws.getString(2);
					            	activeQty 			= ws.getString(44);
					            	inActiveQty 		= ws.getString(45);
					            	quarantineQty 		= ws.getString(46);
					            	mrp					= ws.getString(38);
					            	String newmrp[] 	= mrp.split("/");
					            	mrp					="Rs."+"  "+newmrp[0];
					            	branded				= ws.getString(47);
					            					  					
				  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
				  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
				  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
				  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
				  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
				  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
				  					
				  					if(activeQty == null || activeQty.equals("null") || activeQty.equals(""))activeQty = "---";
				  					if(inActiveQty == null || inActiveQty.equals("null") || inActiveQty.equals(""))inActiveQty = "---";
				  					if(quarantineQty == null || quarantineQty.equals("null") || quarantineQty.equals(""))quarantineQty = "---";
				  				
				  					br.append("<tr>");
				  					
				  					br.append("<td style='text-align:center;'><input type='checkbox' title='View' name='strChkBox'  id='strChkBox"+count+"'  value='"+ ws.getString(11)+"^"+ ws.getString(12)+"^"+ws.getString(13)+"^"+batchNo+"'  onclick='chkboxEnable(this,\""+count+"\")'><input type='hidden' name='strChkFlg' id='strChkFlg"+count+"' value='0'/></td>");
				  					//br.append("<td style='text-align:center;'>"+ i +"</td>");
				  					br.append("<td style='text-align:left;'>"+strStoreName+"</td>");		
				  					br.append("<td style='text-align:left;'>"+itemBrandName+"</td>");	
				  					br.append("<td style='text-align:center;'>"+batchNo+"</td>");
				  					br.append("<td style='text-align:center;'>"+expiryDt+"</td>");
				  					br.append("<td style='text-align:center;'>"+mrp+"</td>");				  					
				  					br.append("<td style='text-align:center;'>"+activeQty+"<input type='hidden' name='strAvlQty' id='strAvlQty" +count+"' value='"+ reservedQty+" "+ "@"+ blockedQty +" " + "'/></td>");				  					
			  					
				  					activeQtyTotal = activeQtyTotal +	Integer.parseInt(activeQty.split("\\ ")[0]);
				  					inActiveQtyTotal    = inActiveQtyTotal	+ 	Integer.parseInt(inActiveQty.split("\\ ")[0]);
				  					quarantineQtyTotal	= quarantineQtyTotal 	+ Integer.parseInt(quarantineQty.split("\\ ")[0]);
				  					
				  					
				  					br.append("</tr>");
				  					i++;
				  					count++;
				  					
								}
							
										    
		            br.append("<tbody>");	
					br.append("</table>");
		           
					
				}
				else
				{
					br.append("<div style='overflow-x:auto;'>");
					br.append("<table class='table table-striped text-uppercase' id='example1'>");
		   			br.append("<tr >");
					br.append("<td colspan='7'><font color='red'>No Record Available</font></td>");
					br.append("</tr>");
					br.append("</table>");
					br.append("</div>");
					
				}
			}
			  			   
			   
				
		}catch(Exception e){
		
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}


	

}