package mms.dao;

import hisglobal.transactionmgnt.HisDAO;
import mms.masters.vo.DesignationMstVO;


		/**
		 * @author Amit Kumar
		 * Creation Date:- 1-June-2011 
		 * Modifying Date:- 1-June-2011
		 * Used For:- 
		 * Team Lead By:-  
		 *  Module:- 
		 * 
		 */
		public class PistDesignationMstDAO 
		{
			public static void insert(DesignationMstVO vo,HisDAO hisDAO_p)throws Exception
			{
				    /*   Total Variable 12   */
					final String strproc_name = "{CALL  pkg_mms_dml.proc_PIST_DESIGNATION_MST(?,?,?,?,?,?,?,?,?,?,?,?)}";
					final int nProcedureIndex;
					try 
					{															
//						  //System.out.println("mode:::"+vo.getStrMode());
//						  //System.out.println("Desg Id:::"+vo.getStrDesignationId());
//						  //System.out.println("Hosp Code:::"+vo.getStrHospitalCode());
//						  //System.out.println("Desg Name:::"+vo.getStrDesignationName());
//						  //System.out.println("Remarks:::"+vo.getStrRemarks());
//						  //System.out.println("Eff from :::"+vo.getStrEffectiveFrom());
//						  //System.out.println("last Modfi Seat id::::"+vo.getStrLastModifiedSeatId());
//						  //System.out.println("Is valid:::"+vo.getStrIsValid());
						  
							nProcedureIndex = hisDAO_p.setProcedure(strproc_name);
							hisDAO_p.setProcInValue(nProcedureIndex,"p_mode",vo.getStrMode());                          //1
							hisDAO_p.setProcInValue(nProcedureIndex,"p_NUM_DESIG_ID",vo.getStrDesignationId());         //2 
							hisDAO_p.setProcInValue(nProcedureIndex,"p_GNUM_HOSPITAL_CODE",vo.getStrHospitalCode());    //3
							hisDAO_p.setProcInValue(nProcedureIndex,"p_STR_DESIG_NAME",vo.getStrDesignationName());     //4
							hisDAO_p.setProcInValue(nProcedureIndex,"p_GSTR_REMARKS",vo.getStrRemarks());               //5
							hisDAO_p.setProcInValue(nProcedureIndex,"p_GDT_EFFECTIVE_FRM",vo.getStrEffectiveFrom());    //6
							/** Default Value**/							
							hisDAO_p.setProcInValue(nProcedureIndex,"p_GNUM_LSTMOD_SEATID",vo.getStrLastModifiedSeatId());                        //7
							hisDAO_p.setProcInValue(nProcedureIndex,"p_GDT_ENTRY_DATE",vo.getStrEffectiveFrom());       //8
							hisDAO_p.setProcInValue(nProcedureIndex,"p_GDT_LSTMOD_DATE",vo.getStrEffectiveFrom());      //9
							/** Default Value**/
							hisDAO_p.setProcInValue(nProcedureIndex,"p_GNUM_SEATID",vo.getStrSeatId());                 //10
							hisDAO_p.setProcInValue(nProcedureIndex,"p_GNUM_ISVALID" , vo.getStrIsValid());             //11
																
							/* Setting and Registering In and Out Parameters */
							hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1); // varchar                             //12
								
							/* Executing Procedure */
							hisDAO_p.execute(nProcedureIndex, 1);
											

						
				} 
				catch (Exception exception) 
				{					
				   throw new Exception("HemtItemMcDtlDAO.getItemBrandCombo(HemtItemMcDtlVO)-->"
						+ exception.getMessage());
				}
				
			}


}
