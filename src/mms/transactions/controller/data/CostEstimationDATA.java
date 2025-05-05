package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.CostEstimationBO;
import mms.transactions.bo.SampleSentTransBO;
import mms.transactions.controller.fb.CostEstimationFB;
import mms.transactions.controller.fb.SampleSentTransFB;
import mms.transactions.controller.hlp.CostEstimationHLP;
import mms.transactions.controller.hlp.SampleSentTransHLP;
import mms.transactions.vo.CostEstimationVO;
import mms.transactions.vo.SampleSentTransVO;

public class CostEstimationDATA 
{
	/**
	 * <p>Method::GetData is Used to populate the initial data on the JSP Page.
	 * <p>Invoked At the time of body on load of Item Transfer Transaction 
	 * @param <CostEstimationFB>formBean
	 * @param <HttpServletRequest>request
	 */
		public static void GetData(CostEstimationFB formBean,HttpServletRequest request) 
		{
			CostEstimationBO bo = null;
			CostEstimationVO vo = null;
			String strmsgText = "";
			HisUtil hisutil=null;			
			try 
			{
				bo = new CostEstimationBO();
				vo = new CostEstimationVO();				
				String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				String seatId = request.getSession().getAttribute("SEATID").toString();
				hisutil = new HisUtil("transaction", "CostEstimationDATA");
								
				formBean.setStrHospitalCode(hosCode);
				formBean.setStrSeatId(seatId);
				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatId);
				
				//bo.itemCategory(vo);				
				String strCmb="";
				if(vo.getStrItemCategoryComboWS() !=null && vo.getStrItemCategoryComboWS().size() > 0)
				{			
					strCmb = hisutil.getOptionValue(vo.getStrItemCategoryComboWS(),"10", "Select Value", true);
				}
				else
				{
					strCmb = "<option value='0'>Select Value</option>";
				}
				formBean.setStrItemCategoryCombo(strCmb);
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				strmsgText = "CostEstimationDATA.GetData(vo) --> "+ e.getMessage();
				HisException eObj = new HisException("mms","CostEstimationDATA->GetData()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
				eObj = null;
			} finally {
				bo = null;
				vo = null;
			}

		}
		public static void printCostEstimation(CostEstimationFB formBean,HttpServletRequest request, HttpServletResponse response) 
		 {

					CostEstimationBO bo = null;
					CostEstimationVO vo = null;
					MmsConfigUtil mcu = null;
					HisUtil util = null;
					String strmsgText = null;
					
					try 
					{
						bo = new CostEstimationBO();
						vo = new CostEstimationVO();
																		
						vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						mcu = new MmsConfigUtil(vo.getStrHospitalCode());
						vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
						String strSampleSentLabel = CostEstimationHLP.printCostEstimation(request.getParameter("hidden"),request.getParameter("totalCost"),vo.getStrHospitalCode());
						
						
						response.setHeader("Cache-Control", "no-cache");
						response.getWriter().print(strSampleSentLabel);	
						
						if (vo.getStrMsgType().equals("1")) 
						{
							throw new Exception(vo.getStrMsgString());
						}
							
					} 
					catch (Exception e) 
					{
						strmsgText = "mms.transactions.CostEstimationDATA.printCostEstimation() --> "
								+ e.getMessage();
						HisException eObj = new HisException("mms",
								"CostEstimationDATA->printCostEstimation()", strmsgText);
						formBean.setStrErrMsg("Application Error [ERROR ID : "
								+ eObj.getErrorID() + "],Contact System Administrator! ");
						
						eObj = null;
					}
					finally 
					{
					
						if (bo != null)
							bo = null;
						if (vo != null)
							vo = null;
						if (util != null)
							util = null;
						}
					}

}
