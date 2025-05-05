package mms.global.controller;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
//import hisglobal.utility.ParseCIMSBrandSearchXML;
import hisglobal.utility.XSLTransformUtility;

import java.io.IOException; 
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.global.bo.MmsBO;
import mms.global.vo.MmsVO;


import com.mims.cds.FastTrackDSM;
 

//import com.fasterxml.jackson.core.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper; 

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
// TODO: Auto-generated Javadoc
/**
 * The Class MmsDATA.
 */
public class MmsDATA {

	/**
	 * Inits the item param.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void initItemParam(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strItemParamView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strItemCatNo = (String) request.getParameter("strItemCatNo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrItemCategoryNo(strItemCatNo);
			formBean.setStrUtilMode(strMode);

			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrUtilMode(formBean.getStrUtilMode());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrParamCheck(formBean.getStrParamCheck());
			vo.setStrParamValue(formBean.getStrParamValue());

			bo.getParentParemeter(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			strItemParamView = MmsHLP.getParentParamView(
					vo.getStrItemParamWs(), vo.getStrUtilMode(), "", "");

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemParamView);

		} catch (Exception e) {

			String strmsgText = "MmsDATA.initItemParam(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.initItemParam(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	
	public static void initItemParamNEW(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strItemParamView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strItemCatNo = (String) request.getParameter("strItemCatNo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrItemCategoryNo(strItemCatNo);
			formBean.setStrUtilMode(strMode);

			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrUtilMode(formBean.getStrUtilMode());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrParamCheck(formBean.getStrParamCheck());
			vo.setStrParamValue(formBean.getStrParamValue());

			bo.getParentParemeter(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			strItemParamView = MmsHLP.getParentParamViewNEW(
					vo.getStrItemParamWs(), vo.getStrUtilMode(), "", "");

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemParamView);

		} catch (Exception e) {

			String strmsgText = "MmsDATA.initItemParam(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.initItemParam(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Inits the item param dtl.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void initItemParamDtl(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strItemParamDtlView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strParentParameterId = (String) request
					.getParameter("strParentParamId");
			String strParentParamIndex = (String) request
					.getParameter("strParentParamIndex");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrParentParameterId(strParentParameterId);
			formBean.setStrUtilMode(strParentParamIndex);

			vo.setStrParentParameterId(formBean.getStrParentParameterId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrParamCheck(formBean.getStrParamCheck());
			vo.setStrParamValue(formBean.getStrParamValue());

			bo.getParentParemeterDtls(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			strItemParamDtlView = MmsHLP.getParentParamDtlsView(
					vo.getStrItemParamDtlsWs(), formBean.getStrUtilMode(),
					formBean.getStrParentParameterId());

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemParamDtlView);

		} catch (Exception e) {

			String strmsgText = "MmsDATA.initItemParamDtl(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.initItemParamDtl(vo) --> ", strmsgText);

			eObj.printStackTrace();

			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Inits the item existing param.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void initItemExistingParam(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strItemParamView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strItemId = (String) request.getParameter("strItemId");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrItemId(strItemId);
			formBean.setStrUtilMode(strMode);

			vo.setStrUtilMode(formBean.getStrUtilMode());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrItemId(formBean.getStrItemId());

			bo.getExistingParemeterDtls(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			strItemParamView = MmsHLP.getExistingParamDtlsView(
					vo.getStrItemParamDtlsWs(), vo.getStrUtilMode(), "0");

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemParamView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.initItemExistingParam(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.initItemExistingParam(vo) --> ", strmsgText);

			eObj.printStackTrace();

			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Inits the existing item param dtl.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void initExistingItemParamDtl(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strItemParamDtlView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strParentParameterId = (String) request
					.getParameter("strParentParamId");
			String strParentParamIndex = (String) request
					.getParameter("strParentParamIndex");

			String strItemId = (String) request.getParameter("strItemId");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrParentParameterId(strParentParameterId);
			formBean.setStrUtilMode(strParentParamIndex);
			formBean.setStrItemId(strItemId);

			vo.setStrParentParameterId(formBean.getStrParentParameterId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getExistingParentParemeterDtls(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			strItemParamDtlView = MmsHLP.getParentParamDtlsView(
					vo.getStrItemParamDtlsWs(), formBean.getStrUtilMode(),
					formBean.getStrParentParameterId());

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemParamDtlView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.initExistingItemParamDtl(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.initExistingItemParamDtl(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Inits the display item param.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * @param strViewMode
	 *            the str view mode
	 * @param strDivIdName
	 *            the str div id name
	 */
	public static void initDisplayItemParam(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean, String strViewMode,
			String strDivIdName) {

		String strItemParamView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strItemId = (String) request.getParameter("strItemId");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrItemId(strItemId);
			formBean.setStrUtilMode(strMode);

			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrUtilMode(formBean.getStrUtilMode());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getDisplayParentParemeter(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			strItemParamView = MmsHLP.getParentParamView(
					vo.getStrItemParamWs(), "1", strViewMode, strDivIdName);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemParamView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.initDisplayItemParam(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.initDisplayItemParam(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Inits the display item param dtl.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void initDisplayItemParamDtl(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strItemParamDtlView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strParentParameterId = (String) request
					.getParameter("strParentParamId");
			String strParentParamIndex = (String) request
					.getParameter("strParentParamIndex");

			String strItemId = (String) request.getParameter("strItemId");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrParentParameterId(strParentParameterId);
			formBean.setStrUtilMode(strParentParamIndex);
			formBean.setStrItemId(strItemId);

			vo.setStrParentParameterId(formBean.getStrParentParameterId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getDisplayParentParemeterDtls(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			strItemParamDtlView = MmsHLP.getDisplayParentParamDtlsView(
					vo.getStrItemParamDtlsWs(), formBean.getStrUtilMode(),
					formBean.getStrParentParameterId());

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemParamDtlView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.initDisplayItemParamDtl(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.initDisplayItemParamDtl(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Inits the display item param dtl.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void initDisplayItemParamDtlForView(
			HttpServletRequest request, HttpServletResponse response,
			MmsFB formBean) {

		String strItemParamDtlView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strParentParameterId = (String) request
					.getParameter("strParentParamId");
			String strParentParamIndex = (String) request
					.getParameter("strParentParamIndex");

			String strItemId = (String) request.getParameter("strItemId");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrParentParameterId(strParentParameterId);
			formBean.setStrUtilMode(strParentParamIndex);
			formBean.setStrItemId(strItemId);

			vo.setStrParentParameterId(formBean.getStrParentParameterId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getDisplayParentParemeterDtls(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			strItemParamDtlView = MmsHLP.getDisplayParentParamDtlsViewForView(
					vo.getStrItemParamDtlsWs(), formBean.getStrUtilMode(),
					formBean.getStrParentParameterId());

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemParamDtlView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.initDisplayItemParamDtlForView(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.initDisplayItemParamDtlForView(vo) --> ",
					strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Insert.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void insert(HttpServletRequest request, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrItemId("1000001");
			vo.setStrSeatId("10008");
			vo.setStrParamCheck(formBean.getStrParamCheck());
			vo.setStrParamValue(formBean.getStrParamValue());

			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {

			String strmsgText = "MmsDATA.insert(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.insert(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Update.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void update(HttpServletRequest request, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrItemId("1000001");
			vo.setStrSeatId("10008");
			vo.setStrParamCheck(formBean.getStrParamCheck());
			vo.setStrParamValue(formBean.getStrParamValue());
			vo.setStrParamDtls(formBean.getStrParamDtls());
			vo.setStrParamStatus(formBean.getStrParamStatus());

			bo.update(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {

			String strmsgText = "MmsDATA.update(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.update(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Search item init.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void searchItemInit(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strFromStoreId = (String) request
					.getParameter("strFromStoreId");
			String strItemCategory = (String) request
					.getParameter("strItemCategory");

			String strRequestType = (String) request
					.getParameter("strRequestType");

			String strUserInfo = "";

			if (request.getParameter("strUserInfo") != null)
				strUserInfo = (String) request.getParameter("strUserInfo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGroupId(strGroupId);
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrUserInfo(strUserInfo);
			formBean.setStrRequestType(strRequestType);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrUtilMode(formBean.getStrUtilMode());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrRequestType(formBean.getStrRequestType());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrUserInfo(formBean.getStrUserInfo());

			bo.getSearchItemInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.searchItemInit()");

			String temp = "<option value='0'>All</option>";

			if (vo.getWsGroupList() != null) {

				if (vo.getStrRequestType().equals("32")) {

					temp = util.getOptionValue(vo.getWsGroupList(), "0",
							"0^All", false);

				} else {

					temp = util.getOptionValue(vo.getWsGroupList(), "-1",
							"-1^Select Value#0^All", false);
				}

			}

			formBean.setStrGroupList(temp);

			temp = "<option value='0'>All</option>";

			/*
			 * if (vo.getStrSubGroupWs() != null) { temp =
			 * util.getOptionValue(vo.getStrSubGroupWs(), "0", "All", false); }
			 */
			// formBean.setStrSubGroupValues(temp);

			/*
			 * temp = "<option value='0'>All</option>";
			 * 
			 * if (vo.getStrItemListWs() != null) { temp =
			 * util.getOptionValue(vo.getStrItemListWs(), "0", "All", false); }
			 */

			// formBean.setStrItemList(temp);

			formBean.setStrNewItemFlag(vo.getStrNewItemFlag());

			strSearchItemInitView = MmsHLP.getSearchItemInitView(formBean);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = "MmsDATA.searchItemInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.searchItemInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}
	}
	
	/**
	 * Search item init.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void searchItemInit_WITHOUTCATG(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strFromStoreId = (String) request
					.getParameter("strFromStoreId");
			String strItemCategory = (String) request
					.getParameter("strItemCategory");

			String strRequestType = (String) request
					.getParameter("strRequestType");

			String strUserInfo = "";

			if (request.getParameter("strUserInfo") != null)
				strUserInfo = (String) request.getParameter("strUserInfo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGroupId(strGroupId);
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrUserInfo(strUserInfo);
			formBean.setStrRequestType(strRequestType);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrUtilMode(formBean.getStrUtilMode());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrRequestType(formBean.getStrRequestType());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrUserInfo(formBean.getStrUserInfo());

			bo.getSearchItemInitDtls_WITHOUTCATG(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.searchItemInit()");

			String temp = "<option value='0'>All</option>";

			if (vo.getWsGroupList() != null) {

				if (vo.getStrRequestType().equals("32")) {

					temp = util.getOptionValue(vo.getWsGroupList(), "0",
							"0^All", false);

				} else {

					temp = util.getOptionValue(vo.getWsGroupList(), "-1",
							"-1^Select Value#0^All", false);
				}

			}

			formBean.setStrGroupList(temp);

			temp = "<option value='0'>All</option>";

			

			formBean.setStrNewItemFlag(vo.getStrNewItemFlag());

			strSearchItemInitView = MmsHLP.getSearchItemInitView(formBean);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = "MmsDATA.searchItemInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.searchItemInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}
	}

	/**
	 * get Sub Group List
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void getSubGroupAndGenericItems(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strFromStoreId = (String) request
					.getParameter("strFromStoreId");
			String strItemCategory = (String) request
					.getParameter("strItemCategory");

			String strRequestType = (String) request
					.getParameter("strRequestType");

			String strUserInfo = "";

			if (request.getParameter("strUserInfo") != null)
				strUserInfo = (String) request.getParameter("strUserInfo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGroupId(strGroupId);
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrUserInfo(strUserInfo);
			formBean.setStrRequestType(strRequestType);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrUtilMode(formBean.getStrUtilMode());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrRequestType(formBean.getStrRequestType());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrUserInfo(formBean.getStrUserInfo());

			bo.getSubGroupsAndGenericItems(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.getSubGroup()");

			String strSubGroups = "<option value='0'>All</option>";

			if (vo.getStrSubGroupWs() != null) {
				strSubGroups = util.getOptionValue(vo.getStrSubGroupWs(), "0",
						"All", false);
			}

			String strGenericItems = "<option value='0'>All</option>";

			if (vo.getStrItemListWs() != null) {
				strGenericItems = util.getOptionValue(vo.getStrItemListWs(),
						"0", "All", false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSubGroups + "@@@@" + strGenericItems);
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = "MmsDATA.getSubGroupAndGenericItems(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getSubGroupAndGenericItems(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Search item list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void searchItemList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strSubGroupId = (String) request
					.getParameter("strSubGroupId");
			String strItemCategory = (String) request
					.getParameter("strItemCatId");
			String strFromStoreId = (String) request
					.getParameter("strFrmStoreId");
			String strRequestType = (String) request
					.getParameter("strRequestType");
			String strUserInfo = "";

			if (request.getParameter("strUserInfo") != null)
				strUserInfo = (String) request.getParameter("strUserInfo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrGroupId(strGroupId);
			formBean.setStrSubGroupId(strSubGroupId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrRequestType(strRequestType);
			formBean.setStrUserInfo(strUserInfo);

			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrRequestType(formBean.getStrRequestType());
			vo.setStrUserInfo(formBean.getStrUserInfo());

			bo.getSearchItemListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.searchItemList()");

			String temp = "<option value='0'>All</option>";

			if (vo.getStrItemListWs() != null) {
				temp = util.getOptionValue(vo.getStrItemListWs(), "0", "All",
						false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.searchItemList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.searchItemList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}
	}

	/**
	 * Search item brand list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void searchItemBrandList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strItemId = (String) request.getParameter("strItemId");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strSubGroupId = (String) request
					.getParameter("strSubGroupId");
			String strFromStoreId = (String) request
					.getParameter("strFrmStoreId");
			String strRequestType = (String) request
					.getParameter("strRequestType");
			String strItemCategoryId = (String) request
					.getParameter("strItemCatId");
			String strUserInfo = "";

			if (request.getParameter("strUserInfo") != null)
				strUserInfo = (String) request.getParameter("strUserInfo");
			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrModeVal(strMode);
			formBean.setStrItemId(strItemId);
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrRequestType(strRequestType);
			formBean.setStrItemCategoryId(strItemCategoryId);
			formBean.setStrUserInfo(strUserInfo);
			formBean.setStrGroupId(strGroupId);
			formBean.setStrSubGroupId(strSubGroupId);

			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrRequestType(formBean.getStrRequestType());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrUserInfo(formBean.getStrUserInfo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());

			bo.getSearchItemBrandListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.searchItemList()");

			String temp = "<option value='0'>All</option>";

			if (vo.getStrBrandItemListWs() != null) {
				temp = util.getOptionValue(vo.getStrBrandItemListWs(), "0", "",
						false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.searchItemBrandList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.searchItemBrandList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}
	
	/**
	 * Search item brand list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void searchItemBrandList_ALLCatg(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strItemId = (String) request.getParameter("strItemId");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strSubGroupId = (String) request
					.getParameter("strSubGroupId");
			String strFromStoreId = (String) request
					.getParameter("strFrmStoreId");
			String strRequestType = (String) request
					.getParameter("strRequestType");
			String strItemCategoryId = (String) request
					.getParameter("strItemCatId");
			String strUserInfo = "";

			if (request.getParameter("strUserInfo") != null)
				strUserInfo = (String) request.getParameter("strUserInfo");
			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrModeVal(strMode);
			formBean.setStrItemId(strItemId);
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrRequestType(strRequestType);
			formBean.setStrItemCategoryId(strItemCategoryId);
			formBean.setStrUserInfo(strUserInfo);
			formBean.setStrGroupId(strGroupId);
			formBean.setStrSubGroupId(strSubGroupId);

			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrRequestType(formBean.getStrRequestType());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrUserInfo(formBean.getStrUserInfo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());

			bo.getSearchItemBrandListDtls_ALLCatg(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.searchItemList_ALLCatg()");

			String temp = "<option value='0'>All</option>";

			if (vo.getStrBrandItemListWs() != null) {
				temp = util.getOptionValue(vo.getStrBrandItemListWs(), "0", "",
						false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.searchItemBrandList_ALLCatg(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.searchItemBrandList_ALLCatg(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the unit combo list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the unit combo list
	 */
	public static void getUnitComboList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strUnitId = (String) request.getParameter("strUnitId");

			String strUnitMode = "0";

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrUnitId(strUnitId);
			

			if (request.getParameter("strUnitMode") != null) {
				strUnitMode = (String) request.getParameter("strUnitMode");
			} else {
				strUnitMode = "0";
			}
			
			if (request.getParameter("itemCat") != null) {
				formBean.setStrItemCategoryNo((String)request.getParameter("itemCat"));
			} else {
				formBean.setStrItemCategoryNo("10");
			}

			vo.setStrUnitId(formBean.getStrUnitId());
			vo.setStrUnitMode(strUnitMode);
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			bo.getUnitListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.getUnitComboList()");

			String temp = "<option value='6301^1^0'>No</option>";
			//System.out.println("MMSDATA.getUnitComboList---Unit Id---"+vo.getStrUnitId()+"--->"+vo.getStrUnitListWs().size());
			if (vo.getStrUnitListWs() != null) 
			{
				//temp = util.getOptionValue(vo.getStrUnitListWs(),vo.getStrUnitId(), "0^Select Value", false, false);
				temp = util.getOptionValue(vo.getStrUnitListWs(),"", "", false, false);
			}
			else
			{
				temp = "<option value='6301^1^0'>No</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = "MmsDATA.getUnitComboList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getUnitComboList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the item mandatory details.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the item mandatory details
	 */
	public static void getItemMandatoryDetails(HttpServletRequest request,
			HttpServletResponse response) {

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			bo = new MmsBO();
			vo = new MmsVO();

			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			vo.setStrItemId(request.getParameter("itemId").toString());

			bo.getItemMandatoryDetails(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(vo.getStrItemMandatoryDtls());

		} catch (Exception e) {

			String strmsgText = "MmsDATA.getItemMandatoryDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getItemMandatoryDetails(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the mms listing dtls.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the mms listing dtls
	 */
	public static void getMmsListingDtls(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsVO voObj = null;
		MmsBO bo = null;

		try {

			voObj = new MmsVO();
			bo = new MmsBO();

			String strPatListType = request.getParameter("patListType");
			String strSearchString = request.getParameter("searchString");
			String strSearchType = request.getParameter("searchType");
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			String strHospitalCode = request.getSession()
					.getAttribute("HOSPITAL_CODE").toString();

			if (strSearchString.contains("^")) {
				strSearchString = strSearchString.replace('^', '%');
			}

			voObj.setStrValue1(strPatListType);
			voObj.setStrValue2(strSearchString);
			voObj.setStrValue3(strSearchType);
			voObj.setStrValue4(strFromRow);

			int nToRow = Integer.parseInt(strFromRow)
					+ Integer.parseInt(strRowPerPage) * 10;

			voObj.setStrValue5(String.valueOf(nToRow));
			voObj.setStrValue6(strRowPerPage);
			voObj.setStrValue7(strCtBlockSet);
			voObj.setStrValue8(strHospitalCode);

			bo.getMmsListingDtl(voObj);

			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());

				// String val = HLPbilling.getPatientListingView(voObj);

				// response.setHeader("Cache-Control", "no-cache");

				// response.getWriter().print(val);

				String val = MmsHLP.getMmsListingView(voObj);
				String[] TestData = val.replace("####", "#").split("#");
				response.setHeader("Cache-Control", "no-cache");
				if (TestData[0].equals("ERROR")) {
					throw new Exception(TestData[1]);
				} else {
					response.getWriter().print(TestData[0]);
				}

			} else {

				throw new Exception(voObj.getStrMsgString());

			}

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try {
				HisException eObj = new HisException("Global Mms File",
						"mms.global.controller.getMmsListingDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			} catch (IOException e1) {
				// //System.out.println("Inside IInd Else::::"+e1.getMessage());
			}

		} finally {

			bo = null;
			voObj = null;
		}
	}

	/**
	 * Stock item dtls init.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void stockItemDtlsInit(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode").split(
					"\\^")[0]; // This is Combination of [ Mode ^ Budget Flag ^
								// Index ]

			String strStockStatus = (String) request
					.getParameter("strStockStatus");
			String strGenricItemId = (String) request
					.getParameter("strGenItemId");
			String strItemId = (String) request.getParameter("strItemId");
			String strIssueQty = (String) request.getParameter("strIssueQty");
			String strIssueQtyInBase = (String) request
					.getParameter("strIssueQtyInBase");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strItemCategory = (String) request
					.getParameter("strCatCode");
			String strReservedFlag = (String) request
					.getParameter("strReservedFlag");

			String strHiddenVal = (String) request
					.getParameter("strHiddenFieldVal");

			String strUnitName = (String) request.getParameter("strUnitName");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrStockStatus(strStockStatus);
			formBean.setStrGenricItemId(strGenricItemId);
			formBean.setStrItemId(strItemId);
			formBean.setStrIssueQty(strIssueQty);
			formBean.setStrIssueQtyInBase(strIssueQtyInBase);
			formBean.setStrReservedFlag(strReservedFlag);
			formBean.setStrHiddenVal(strHiddenVal);
			formBean.setStrUnitName(strUnitName);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrStockStatus(formBean.getStrStockStatus());
			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrIssueQty(formBean.getStrIssueQty());
			vo.setStrIssueQtyInBase(formBean.getStrIssueQtyInBase());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrReservedFlag(formBean.getStrReservedFlag());

			bo.getStockItemDtlsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			// while(vo.getWsStockDetails().next())
			// {
			// //System.out.println("Rack No::::::"+vo.getWsStockDetails().getString(44));
			// formBean.setStrRackNo(vo.getWsStockDetails().getString(44));
			//
			//
			// }
			// vo.getWsStockDetails().beforeFirst();

			formBean.setStrItemName(vo.getStrItemName());
			formBean.setWsStockDetails(vo.getWsStockDetails());
			formBean.setStrRateUnit(vo.getStrRateUnit());
			formBean.setStrRateInBaseValue(vo.getStrRateInBaseValue());

			// This Variable is used to set Budget Avalaible or Not Flag
			formBean.setUsrArg((String) request.getParameter("strMode").split(
					"\\^")[1]);
			// This Variable is Used To Set Index
			formBean.setStrIndex((String) request.getParameter("strMode")
					.split("\\^")[2]);

			strSearchItemInitView = MmsHLP.getStockItemDtlsInitView(formBean);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = "MmsDATA.stockItemDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.stockItemDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Issue dtls init.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void issueDtlsInit(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strIssueNo = (String) request.getParameter("strIssueNo");
			String strIndentNo = (String) request.getParameter("strIndentNo");
			String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");
			
			
			String strIndentDate = (String) request
					.getParameter("strIndentDate");
			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrIssueNo(strIssueNo);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			//vo.setStrValue8(crNo);
			formBean.setStrCrno(crNo);
			
			System.out.println("-----------MmsCNT . ISSUEDTLSINIT [ After Save Issue Voucher - "+formBean.getStrModeVal()+"]--------------");
			bo.getImgHeader(vo);		    
			bo.getIssueDtlsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrModeVal().equals("5")) {
				formBean.setStrReturnReqNo(vo.getStrReturnReqNo());
				formBean.setStrSlNoflg("0");
				formBean.setStrBudget("0");
			}
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrIssueDate(vo.getStrIssueDate());
			formBean.setStrIssueTo(vo.getStrIssueTo());
			formBean.setStrItemCategoryId(vo.getStrItemCategoryNo());
			formBean.setWsIssueDetails(vo.getWsIssueDetails());

			while (formBean.getWsIssueDetails().next()) {
				if (vo.getStrModeVal().equals("2")) {
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(4));
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(27));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrIndentNo(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrIndentDate(formBean.getWsIssueDetails()
							.getString(32));
					formBean.setStrApprovalRemarks(formBean.getWsIssueDetails()
							.getString(36));

				}
				 if(vo.getStrModeVal().equals("1")) 
				 {
						formBean.setStrStoreName(formBean.getWsIssueDetails()
								.getString(4)); 
						formBean.setStrApprovalRemarks(formBean.getWsIssueDetails()
								.getString(33));
						formBean.setStrUserName(formBean.getWsIssueDetails()
								.getString(34));
						formBean.setUsrArg(formBean.getWsIssueDetails()
								.getString(35));  // Pass Patient Hidden  Value
						/*
						 *  General
						 * ^Venkataappaiah Posani - 83 Yr/Male
						 * ^0
						 * ^0
						 * ^Hanumaiah
						 * ^0
						 * ^Hospital Management Information System
						 * ^12-MAR-2019 11:21:46
						 * ^-
						 * ^NO
						 * ^Dental
						 * ^Dental Unit 1
						 * ^General
						 * ^Cubicle 07
						 * ^Cub07 111
						 * ^General
						 * ^Navaneeth Y
						 * ^No
						 * ^0
						 * ^379132022000039
						 * ^03-Nov-2022 11:58:35
						 * 
						 */
						/*
						 * 0 - Dept Name                                            
					       1 - Dept Unit Name                                       
					       2 - Ward Name                                                      
					       3 - Room No                                             
					       4 - Bed No                                               
					       5 - Patient Catg                                         
					       6 - Consultant Name                                       
					       7 - IS New Born                                          
					       8 - Bill Catg 
					       9 - Addmission No
					      10 - Admission Date 						
						  11 - General                                              Patient Category
					      12 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
					      13 - 0                                                    HRGNUM_IS_MLC            
					      14 - 0                                                    HRGNUM_ISNEWBORN  
					      15 - Sdds                                                 HRGSTR_FATHER_NAME
					      16 - 0                                                    HRGNUM_IS_DEAD
					      17 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
					      18 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
					      19 -                                                      HRGSTR_EMG_CNTC
					      20 - NO                                                   HRGNUM_ISNEWBORN 
						 * 
						 * */
				}
				if (vo.getStrModeVal().equals("4")) {
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(3).split("@")[0]);
					formBean.setStrOrgName(formBean.getWsIssueDetails().getString(4));
					formBean.setStrUserName(formBean.getWsIssueDetails().getString(39));
				}
			}

			formBean.getWsIssueDetails().beforeFirst();

			if (!vo.getStrModeVal().equals("2")) {
				formBean.setStrIndentDate(strIndentDate);
				formBean.setStrIndentNo(strIndentNo);
			}
			formBean.setStrSlNoflg(vo.getStrSlNoflg());
			
			System.out.println("-----------MmsHLP.getIssueDtlsInitView--------------");
			
			strSearchItemInitView = MmsHLP.getIssueDtlsInitView(vo,formBean);
			
			
			//System.out.println("strSearchItemInitView" + strSearchItemInitView);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
			
			System.out.println("----------- Issue Voucher END --------------");
			
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}


	
	public static void issueDtlsInitNEW(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strIssueNo = (String) request.getParameter("strIssueNo");
			String strIndentNo = (String) request.getParameter("strIndentNo");
			String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");
			
			
			
			
			String strIndentDate = (String) request
					.getParameter("strIndentDate");
			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrIssueNo(strIssueNo);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			//vo.setStrValue8(crNo);
			formBean.setStrCrno(crNo);
			bo.getImgHeader(vo);
			bo.getIssueDtlsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrModeVal().equals("5")) {
				formBean.setStrReturnReqNo(vo.getStrReturnReqNo());
				formBean.setStrSlNoflg("0");
				formBean.setStrBudget("0");
			}
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrIssueDate(vo.getStrIssueDate());
			formBean.setStrIssueTo(vo.getStrIssueTo());
			formBean.setStrItemCategoryId(vo.getStrItemCategoryNo());
			formBean.setWsIssueDetails(vo.getWsIssueDetails());

			while (formBean.getWsIssueDetails().next()) {
				if (vo.getStrModeVal().equals("2")) {
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(4));
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(27));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrIndentNo(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrIndentDate(formBean.getWsIssueDetails()
							.getString(32));

				}
				 if(vo.getStrModeVal().equals("1")) {
						formBean.setStrStoreName(formBean.getWsIssueDetails()
								.getString(4)); 
						formBean.setStrUserName(formBean.getWsIssueDetails()
								.getString(34));
					 }
				if (vo.getStrModeVal().equals("4")) {
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(3).split("@")[0]);
					formBean.setStrOrgName(formBean.getWsIssueDetails().getString(4));
				}
			}

			formBean.getWsIssueDetails().beforeFirst();

			if (!vo.getStrModeVal().equals("2")) {
				formBean.setStrIndentDate(strIndentDate);
				formBean.setStrIndentNo(strIndentNo);
			}
			formBean.setStrSlNoflg(vo.getStrSlNoflg());
			strSearchItemInitView = MmsHLP.getIssueDtlsInitViewNEW(vo,formBean);
			//System.out.println("strSearchItemInitView" + strSearchItemInitView);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	
	
	public static void duplicateIssueDtlsInitNEW(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strIssueNo = (String) request.getParameter("strIssueNo");
			String strIndentNo = (String) request.getParameter("strIndentNo");
			String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");
			////System.out.println(request.getSession().getAttributeNames());
			
			
			
			String strIndentDate = (String) request
					.getParameter("strIndentDate");
			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrIssueNo(strIssueNo);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			//vo.setStrValue8(crNo);
			formBean.setStrCrno(crNo);
			bo.getIssueDtlsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrModeVal().equals("5")) {
				formBean.setStrReturnReqNo(vo.getStrReturnReqNo());
				formBean.setStrSlNoflg("0");
				formBean.setStrBudget("0");
			}
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrIssueDate(vo.getStrIssueDate());
			formBean.setStrIssueTo(vo.getStrIssueTo());
			formBean.setStrItemCategoryId(vo.getStrItemCategoryNo());
			formBean.setWsIssueDetails(vo.getWsIssueDetails());

			while (formBean.getWsIssueDetails().next()) {
				if (vo.getStrModeVal().equals("2")) {
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(4));
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(27));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrIndentNo(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrIndentDate(formBean.getWsIssueDetails()
							.getString(32));

				}
				 if(vo.getStrModeVal().equals("1")) {
						formBean.setStrStoreName(formBean.getWsIssueDetails()
								.getString(4)); 
						formBean.setStrUserName(formBean.getWsIssueDetails()
								.getString(34));
					 }
				if (vo.getStrModeVal().equals("4")) {
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(3).split("@")[0]);
					formBean.setStrOrgName(formBean.getWsIssueDetails().getString(4));
				}
			}

			formBean.getWsIssueDetails().beforeFirst();

			if (!vo.getStrModeVal().equals("2")) {
				formBean.setStrIndentDate(strIndentDate);
				formBean.setStrIndentNo(strIndentNo);
			}
			formBean.setStrSlNoflg(vo.getStrSlNoflg());
			strSearchItemInitView = MmsHLP.getDuplicateIssueDtlsInitViewNEW(formBean);
			//System.out.println("strSearchItemInitView" + strSearchItemInitView);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	
	/**
	 * Gets the free item dtls.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the free item dtls
	 */
	public static void getFreeItemDtls(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strGenricItemId = (String) request
					.getParameter("strGenItemId");
			String strItemId = (String) request.getParameter("strItemId");
			String strBatchSlNo = (String) request.getParameter("strBatchSlNo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGenricItemId(strGenricItemId);
			formBean.setStrItemId(strItemId);
			formBean.setStrBatchSlNo(strBatchSlNo);

			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrBatchSlNo(formBean.getStrBatchSlNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getFreeItemDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setWsItemOtherDtls(vo.getWsItemOtherDtls());

			strSearchItemInitView = MmsHLP.getFreeAndPartItemDtlsView(formBean,
					"1");

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getFreeItemDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getFreeItemDtls(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the part item dtls.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the part item dtls
	 */
	public static void getPartItemDtls(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strGenricItemId = (String) request
					.getParameter("strGenItemId");
			String strItemId = (String) request.getParameter("strItemId");
			String strBatchSlNo = (String) request.getParameter("strBatchSlNo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGenricItemId(strGenricItemId);
			formBean.setStrItemId(strItemId);
			formBean.setStrBatchSlNo(strBatchSlNo);

			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrBatchSlNo(formBean.getStrBatchSlNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getPartItemDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setWsItemOtherDtls(vo.getWsItemOtherDtls());

			strSearchItemInitView = MmsHLP.getFreeAndPartItemDtlsView(formBean,
					"2");

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getPartItemDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getPartItemDtls(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the item warranty dtls.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the item warranty dtls
	 */
	public static void getItemWarrantyDtls(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strGenricItemId = (String) request
					.getParameter("strGenItemId");
			String strItemId = (String) request.getParameter("strItemId");
			String strBatchSlNo = (String) request.getParameter("strBatchSlNo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGenricItemId(strGenricItemId);
			formBean.setStrItemId(strItemId);
			formBean.setStrBatchSlNo(strBatchSlNo);

			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrBatchSlNo(formBean.getStrBatchSlNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemWarrantyDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setWsItemOtherDtls(vo.getWsItemOtherDtls());

			strSearchItemInitView = MmsHLP.getItemWarrantyDtlsView(formBean);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getItemWarrantyDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getItemWarrantyDtls(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the inits the item other dtls.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the inits the item other dtls
	 */
	public static void getInitItemOtherDtls(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strIsBatchReq = (String) request
					.getParameter("strIsBatchReq");
			String strIsExpDtReq = (String) request
					.getParameter("strIsExpDtReq");

			bo = new MmsBO();
			vo = new MmsVO();
			util = new HisUtil("Mms Trans", "Mms Free Item Details Util");

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrModeVal(strMode);
			formBean.setStrIsBatchReq(strIsBatchReq);
			formBean.setStrIsExpDtReq(strIsExpDtReq);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getInitFreeItemDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			String temp = "<option value='0'>Select Value</option>";
			if (vo.getWsItemCategoryList() != null
					&& vo.getWsItemCategoryList().size() > 0) {

				temp = util.getOptionValue(vo.getWsItemCategoryList(), "0",
						"0^Select Value", false);
			}

			formBean.setStrItemCategoryList(temp);

			temp = "<option value='0'>Select Value</option>";
			if (vo.getWsComponentTypeList() != null
					&& vo.getWsComponentTypeList().size() > 0) {

				temp = util.getOptionValue(vo.getWsComponentTypeList(), "0",
						"0^Select Value", false);
			}

			formBean.setStrComponentTypeList(temp);

			strSearchItemInitView = MmsHLP.getFreeOrPartItemInitView(formBean,
					strMode);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getInitItemOtherDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getInitItemOtherDtls(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}


	public static void getInitItemOtherDtlsNEW(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strIsBatchReq = (String) request
					.getParameter("strIsBatchReq");
			String strIsExpDtReq = (String) request
					.getParameter("strIsExpDtReq");

			bo = new MmsBO();
			vo = new MmsVO();
			util = new HisUtil("Mms Trans", "Mms Free Item Details Util");

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrModeVal(strMode);
			formBean.setStrIsBatchReq(strIsBatchReq);
			formBean.setStrIsExpDtReq(strIsExpDtReq);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getInitFreeItemDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			String temp = "<option value='0'>Select Value</option>";
			if (vo.getWsItemCategoryList() != null
					&& vo.getWsItemCategoryList().size() > 0) {

				temp = util.getOptionValue(vo.getWsItemCategoryList(), "0",
						"0^Select Value", false);
			}

			formBean.setStrItemCategoryList(temp);

			temp = "<option value='0'>Select Value</option>";
			if (vo.getWsComponentTypeList() != null
					&& vo.getWsComponentTypeList().size() > 0) {

				temp = util.getOptionValue(vo.getWsComponentTypeList(), "0",
						"0^Select Value", false);
			}

			formBean.setStrComponentTypeList(temp);

			strSearchItemInitView = MmsHLP.getFreeOrPartItemInitViewNEW(formBean,
					strMode);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getInitItemOtherDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getInitItemOtherDtls(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	
	
	
	/**
	 * Gets the group list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the group list
	 */
	public static void getGroupList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strItemCategory = (String) request
					.getParameter("strItemCategory");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrItemCategoryId(strItemCategory);

			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getGroupListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.getGroupList()");

			String temp = "<option value='0'>Select Value</option>";

			if (vo.getWsGroupList() != null && vo.getWsGroupList().size() > 0) {
				temp = util.getOptionValue(vo.getWsGroupList(), "0",
						"0^Select Value", false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getGroupList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getGroupList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the sub group list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the sub group list
	 */
	public static void getSubGroupList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strGroupId = (String) request.getParameter("strGroupId");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGroupId(strGroupId);

			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getSubGroupListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.getSubGroupList()");

			String temp = "<option value='0'>All</option>";

			if (vo.getStrSubGroupWs() != null
					&& vo.getStrSubGroupWs().size() > 0) {
				temp = util.getOptionValue(vo.getStrSubGroupWs(), "0", "0^All",
						false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getSubGroupList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getSubGroupList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the gen item list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the gen item list
	 */
	public static void getGenItemList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strGroupId = (String) request.getParameter("strGroupId");
			String strSubGroupId = (String) request
					.getParameter("strSubGroupId");
			String strItemCategory = (String) request
					.getParameter("strCategory");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGroupId(strGroupId);
			formBean.setStrSubGroupId(strSubGroupId);
			formBean.setStrItemCategoryId(strItemCategory);

			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getGenItemListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.getGenItemList()");

			String temp = "<option value='0'>Select Value</option>";

			if (vo.getWsGenricItemList() != null
					&& vo.getWsGenricItemList().size() > 0) {
				temp = util.getOptionValue(vo.getWsGenricItemList(), "0",
						"0^Select Value", false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getGenItemList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getGenItemList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the item list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the item list
	 */
	public static void getItemList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strItemId = (String) request.getParameter("strItemId");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strSubGroupId = (String) request
					.getParameter("strSubGroupId");
			String strItemCategory = (String) request
					.getParameter("strCategory");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrItemId(strItemId);
			formBean.setStrGroupId(strGroupId);
			formBean.setStrSubGroupId(strSubGroupId);
			formBean.setStrItemCategoryId(strItemCategory);

			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.getItemList()");

			String temp = "<option value='0'>Select Value</option>";

			if (vo.getWsItemList() != null && vo.getWsItemList().size() > 0) {
				temp = util.getOptionValue(vo.getWsItemList(), "0",
						"0^Select Value", false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getItemList(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getItemList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the other item unit combo list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the other item unit combo list
	 */
	public static void getOtherItemUnitComboList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strItemId = (String) request.getParameter("strItemId");
			String strItemCatNo = (String) request
					.getParameter("strCategoryNo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrItemId(strItemId);
			formBean.setStrItemCategoryNo(strItemCatNo);

			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrItemId(strItemId);
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemOtherUnitListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.getUnitComboList()");

			String temp = "<option value='0'>Select Value</option>";

			if (vo.getWsUnitList() != null && vo.getWsUnitList().size() > 0) {
				temp = util.getOptionValue(vo.getWsUnitList(),
						vo.getStrUnitId(), "0^Select Value", false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getOtherItemUnitComboList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getOtherItemUnitComboList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}
	}

	/**
	 * Gets the other item modify init view.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the other item modify init view
	 */
	public static void getOtherItemModifyInitView(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strItemId = (String) request.getParameter("strItemId");
			String strItemBrandId = (String) request
					.getParameter("strItemBrandId");
			String strBatchNo = (String) request.getParameter("strBatchNo");
			String strLayerIndex = (String) request.getParameter("layerIndex");
			String strMode = (String) request.getParameter("mode");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrOtherItemMode(strMode); // Added by Aritra
			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrLayerIndex(strLayerIndex);
			formBean.setStrItemId(strItemBrandId);
			formBean.setStrGenricItemId(strItemId);
			formBean.setStrBatchSlNo(strBatchNo);

			vo.setStrModeVal(strMode);
			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrBatchSlNo(formBean.getStrBatchSlNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemOtherInitModifyView(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setWsItemOtherDtls(vo.getWsItemOtherDtls());

			String temp = MmsHLP.getFreeOrPartItemInitModifyView(formBean,
					strMode);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getOtherItemModifyInitView(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getOtherItemModifyInitView(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the manufacturer combo list.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the manufacturer combo list
	 */
	public static void getManufacturerComboList(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strCategoryNo = (String) request.getParameter("strCatCode");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrItemCategoryNo(strCategoryNo);

			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getManufacturerListDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP",
					"MmsDATA.getManufacturerComboList()");

			String temp = "<option value='0'>Select Value</option>";

			if (vo.getWsManufacturerList() != null) {
				temp = util.getOptionValue(vo.getWsManufacturerList(), "0",
						"0^Select Value", false);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getManufacturerComboList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getManufacturerComboList(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Search item init.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void getAddNewItemView(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strAddNewItemView = "";

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			bo = new MmsBO();
			vo = new MmsVO();

			String strGenericItemDetails = request.getParameter(
					"strGenericItemDtls").toString();
			String strNewItemFlag = request.getParameter("strNewItemFlag")
					.toString();

			String tempVal[] = strGenericItemDetails.replace("^", "#").split(
					"#");

			formBean.setStrGenricItemId(tempVal[0]);
			formBean.setStrItemCategoryId(tempVal[0].substring(0, 2));
			formBean.setStrUnitId(tempVal[1]);
			formBean.setStrSubGroupId(tempVal[2]);
			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrNewItemFlag(strNewItemFlag);

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrUnitId(formBean.getStrUnitId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());

			bo.getAddNewItemsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP",
					"MmsDATA.getManufacturerComboList()");

			String temp = "<option value='0'>Select Value</option>";

			if (vo.getWsManufacturerList() != null) {
				temp = util.getOptionValue(vo.getWsManufacturerList(), "0",
						"0^Select Value", false);
			}

			formBean.setStrManufacturerList(temp);

			temp = "<option value='0'>Select Value</option>";

			if (vo.getStrUnitListWs() != null) {
				temp = util.getOptionValue(vo.getStrUnitListWs(), "0",
						"0^Select Value", false);
			}

			formBean.setStrUnitList(temp);

			temp = "<option value='0'>Select Value</option>";

			if (vo.getStrItemTypeWs() != null) {
				temp = util.getOptionValue(vo.getStrItemTypeWs(), "0",
						"0^Select Value", false);
			}

			formBean.setStrItemTypeList(temp);

			strAddNewItemView = MmsHLP.getNewItemAddDetails(formBean,
					strGenericItemDetails);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAddNewItemView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.getAddNewItemView(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.getAddNewItemView(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}
	}

	/**
	 * 
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void insertAddNewItemView(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strAddNewItemView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			bo = new MmsBO();
			vo = new MmsVO();

			String strGenericItemDetails = request.getParameter(
					"strGenericItemDtls").toString();

			String tempVal[] = strGenericItemDetails.replace("^", "#").split(
					"#");

			formBean.setStrGenricItemId(tempVal[0]);
			formBean.setStrItemCategoryId(tempVal[0].substring(0, 2));
			formBean.setStrUnitId(tempVal[1]);
			formBean.setStrSubGroupId(tempVal[2]);
			formBean.setStrIsStoreItem(tempVal[4]);
			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrFromStoreId(request.getParameter("strStoreId")
					.toString());
			formBean.setStrGroupId(request.getParameter("strGroupId")
					.toString());
			formBean.setStrNewItemIsQuantifiable(request.getParameter(
					"isQuantify").toString());
			formBean.setStrNewItemIsSetSachet(request
					.getParameter("isSetSatch").toString());
			formBean.setStrNewItemLevelUnit(request.getParameter(
					"strNewItemLevelUnit").toString());
			formBean.setStrNewItemMake(request.getParameter("strNewItemMake")
					.toString());
			formBean.setStrNewItemManufacturer(request.getParameter(
					"strNewItemManufacturer").toString());
			formBean.setStrNewItemMaxLevel(request.getParameter(
					"strNewItemMaxLevel").toString());
			formBean.setStrNewItemName(request.getParameter("strNewItemName")
					.toString());
			formBean.setStrNewItemReorderLevel(request.getParameter(
					"strNewItemReorderLevel").toString());
			formBean.setStrNewItemShortName(request.getParameter(
					"strNewItemShortName").toString());
			formBean.setStrNewItemSpecification(request.getParameter(
					"strNewItemSpecification").toString());
			formBean.setStrNewItemType(request.getParameter("strNewItemType")
					.toString());

			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrUnitId(formBean.getStrUnitId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrNewItemIsQuantifiable(formBean
					.getStrNewItemIsQuantifiable());
			vo.setStrNewItemIsSetSachet(formBean.getStrNewItemIsSetSachet());
			vo.setStrNewItemLevelUnit(formBean.getStrNewItemLevelUnit()
					.replace("^", "#").split("#")[0]);
			vo.setStrNewItemMake(formBean.getStrNewItemMake());
			vo.setStrNewItemManufacturer(formBean.getStrNewItemManufacturer());
			vo.setStrNewItemMaxLevel(formBean.getStrNewItemMaxLevel());
			vo.setStrNewItemName(formBean.getStrNewItemName());
			vo.setStrNewItemReorderLevel(formBean.getStrNewItemReorderLevel());
			vo.setStrNewItemShortName(formBean.getStrNewItemShortName());
			vo.setStrNewItemSpecification(formBean.getStrNewItemSpecification());
			vo.setStrNewItemType(formBean.getStrNewItemType());
			vo.setStrIsStoreItem(formBean.getStrIsStoreItem());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			bo.insertAddNewItemsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				strAddNewItemView = "ERROR####" + vo.getStrMsgString();

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAddNewItemView);
		} catch (Exception e) {

			String strmsgText = "MmsDATA.insertAddNewItemView(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.insertAddNewItemView(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}
	
	public static void issueDtlsInitService(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strIssueNo = (String) request.getParameter("strIssueNo");
			String strIndentNo = (String) request.getParameter("strIndentNo");
			String strIndentDate = (String) request
					.getParameter("strIndentDate");
			String strUCReq="0";
			//if(strMode.equals("1"))		
			//	strUCReq = request.getParameter("strUCReq");
					
			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrIssueNo(strIssueNo);
			
			formBean.setStrModeVal("7");  //Reset Mode
			
			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getIssueDtlsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrModeVal().equals("5")) {
				formBean.setStrReturnReqNo(vo.getStrReturnReqNo());
				formBean.setStrSlNoflg("0");
				formBean.setStrBudget("0");
			}
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrIssueDate(vo.getStrIssueDate());
			formBean.setStrIssueTo(vo.getStrIssueTo());
			formBean.setStrItemCategoryId(vo.getStrItemCategoryNo());
			formBean.setWsIssueDetails(vo.getWsIssueDetails());

			while (formBean.getWsIssueDetails().next()) {
				if (vo.getStrModeVal().equals("2")) {
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(4));
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(27));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrIndentNo(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrIndentDate(formBean.getWsIssueDetails()
							.getString(32));
					formBean.setStrLocDL(formBean.getWsIssueDetails().getString(35));

				}
				if (vo.getStrModeVal().equals("4")) {
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrLocDL(formBean.getWsIssueDetails().getString(38));
				}
				
				if (vo.getStrModeVal().equals("7")|| vo.getStrModeVal().equals("6")) {
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(26));
					if(vo.getStrModeVal().equals("7"))
					{
						formBean.setStrLPRequestNo(formBean.getWsIssueDetails().getString(27));
						formBean.setStrLocDL(formBean.getWsIssueDetails().getString(28));
						formBean.setStrBillNo(formBean.getWsIssueDetails().getString(29));
						formBean.setStrCrno(formBean.getWsIssueDetails().getString(35));
						formBean.setStrUserName(formBean.getWsIssueDetails().getString(34));
						formBean.setStrStoreName(formBean.getWsIssueDetails().getString(4));
						formBean.setStrPatCat(formBean.getWsIssueDetails().getString(36));
						formBean.setStrWardName(formBean.getWsIssueDetails().getString(37));
						formBean.setStrRcvByName(formBean.getWsIssueDetails().getString(25));
					}
					else
						formBean.setStrLocDL(formBean.getWsIssueDetails().getString(27));
				}
				if (vo.getStrModeVal().equals("3") || vo.getStrModeVal().equals("5")) {
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(25));
					if(vo.getStrModeVal().equals("3"))
						formBean.setStrLocDL(formBean.getWsIssueDetails().getString(26));
					else
						formBean.setStrLocDL(formBean.getWsIssueDetails().getString(29));
				}
			}

			formBean.getWsIssueDetails().beforeFirst();

			if (!vo.getStrModeVal().equals("2")) {
				formBean.setStrIndentDate(strIndentDate);
				formBean.setStrIndentNo(strIndentNo);
			}
			formBean.setStrSlNoflg(vo.getStrSlNoflg());
			
			/*strSearchItemInitView = MmsHLP.getIssueDtlsInitView(formBean,strUCReq);
			//System.out.println("strSearchItemInitView" + strSearchItemInitView);*/
			response.setHeader("Cache-Control", "no-cache");
			MmsFB_new newBean = new MmsFB_new();
			BeanUtils.copyProperties(newBean, formBean); 
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(newBean); 
			JSONObject tempJsonObj = new JSONObject(jsonInString);
			
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	 
			String configIssueRate = mmscofigutil.getStrConfigIssueRate();
			String strTinNo = mmscofigutil.getStrTinNo();
			tempJsonObj.put("strTinNo", strTinNo);
			tempJsonObj.put("configIssueRate", configIssueRate);
			
			JSONArray jsonArr = new JSONArray(); 
			WebRowSet ws = formBean.getWsIssueDetails();

			String strIssueBy = "";
			String strRecivedBy = "";
			String strPurchaseCost="";
			String strRemarks="";
			String strItemName="",strIssueQty="",strGenName="";
			String strAdmNo="",strSupp="",strICD="",strOper=""; 
			double cltamt  = 0.00;
			double totalCost = 0.00;
			
			double cltamt1  = 0.00;
			double totalCostWithoutSC = 0.00;
			
			
			String strStoreName="";
			 String returnTo="";
			int i=1;
			String strItemTotCost="0.00";
			String strItemTotCostWithOutSC ="0.00";
			String strBudgetUsed ="0.00";
			DecimalFormat myFormatter = new DecimalFormat("0.00");
			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					JSONObject subJsonObj = new JSONObject();
					
					NumberFormat formatter = new DecimalFormat("############.##");  	
					if(formBean.getStrModeVal().equals("7"))
					{
						strAdmNo=ws.getString(30).replace("^", "#").split("#")[2];
						strIndentDate=ws.getString(30).replace("^", "#").split("#")[1];
						strIndentNo=ws.getString(30).replace("^", "#").split("#")[0];
						strICD=ws.getString(31);
						strSupp=ws.getString(32);
						strOper=ws.getString(33);
					}
					if (formBean.getStrModeVal().equals("4")) 
					{
						
						strIssueBy              = ws.getString(28);
						strRecivedBy            = ws.getString(27);
						strItemTotCost  		= ws.getString(30);
						strPurchaseCost 		= ws.getString(32);
						strItemTotCost          = formatter.format(new BigDecimal(ws.getString(30)));
						//System.out.println("ws.getString(33)::::::::::::::::::::::"+ws.getString(33));
						if(ws.getString(33) == null || ws.getString(33).equals(""))
							strItemTotCostWithOutSC = "0";
						else
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(33)));
					} 
					else 
					{
						if (formBean.getStrModeVal().equals("2"))
						{							
							strStoreName    		= ws.getString(4);	
							strRemarks              = ws.getString(27);
							strRecivedBy    		= ws.getString(28);
							strItemTotCost          = ws.getString(29);
							
							strPurchaseCost         = ws.getString(33);  // With Unit Like e.g. 161 No.
												    
							strItemTotCost          = formatter.format(new BigDecimal(ws.getString(29)));  
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
						//	strBudgetUsed           = formatter.format(new BigDecimal(ws.getString(35)));
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
								
							//	strRemarks   = ws.getString(25);
							//	strRecivedBy = ws.getString(26);
							}
							else
							{
								if(formBean.getStrModeVal().equals("7") || formBean.getStrModeVal().equals("6"))
								{
									
								//	strRemarks   = ws.getString(25);
								//	strRecivedBy = ws.getString(26);
									strRecivedBy = ws.getString(25);
									strItemTotCost = formatter.format(new BigDecimal(Double.parseDouble(formatter.format(new BigDecimal(ws.getString(16)))) * Double.parseDouble(ws.getString(19))));
								}
							}
						}
						
					}
					
					cltamt1  = Double.parseDouble(strItemTotCostWithOutSC); 
					totalCostWithoutSC = totalCostWithoutSC + cltamt1;   //Calculate Total Cost Without Service Charge 
					cltamt  = Double.parseDouble(strItemTotCost);     
					totalCost = totalCost + cltamt;                      //Calculate Total Cost With Service Charge
					
					strItemName=ws.getString(6);
					strGenName=ws.getString(5);
					subJsonObj.put("strItemName",strItemName);
					subJsonObj.put("strGenName",strGenName); 
					subJsonObj.put("strBatchSlNo",(ws.getString(22).equals("/") || ws.getString(22).equals(""))?ws.getString(7):ws.getString(22)); 
					subJsonObj.put("strExpDate",ws.getString(8));
					subJsonObj.put("strRatePerUnit",ws.getString(9)); 
					subJsonObj.put("strIssueQty",ws.getString(10));  
					subJsonObj.put("strItemCost",myFormatter.format(new BigDecimal(strItemTotCost)));    
					jsonArr.put(subJsonObj);
					i++;  
				}
			}
			NumberFormat formatter = new DecimalFormat("############.##");  
			String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
			tempJsonObj.put("totalCostWithoutSC", myFormatter.format(Double.parseDouble(FinaltotalCost)));
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("BasicDtl", tempJsonObj);
			jsonObj.put("ItemList", jsonArr);
			
			response.setContentType("application/json");
			response.getWriter().print(jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}
	public static void searchItemInitBS(HttpServletRequest request,
			HttpServletResponse response, MmsFB formBean) {

		String strSearchItemInitView = "";

		MmsBO bo = null;
		MmsVO vo = null;
		HisUtil util = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strFromStoreId = (String) request
					.getParameter("strFromStoreId");
			String strItemCategory = (String) request
					.getParameter("strItemCategory");

			String strRequestType = (String) request
					.getParameter("strRequestType");

			String strUserInfo = "";

			if (request.getParameter("strUserInfo") != null)
				strUserInfo = (String) request.getParameter("strUserInfo");

			bo = new MmsBO();
			vo = new MmsVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrGroupId(strGroupId);
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrUserInfo(strUserInfo);
			formBean.setStrRequestType(strRequestType);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrUtilMode(formBean.getStrUtilMode());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrRequestType(formBean.getStrRequestType());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrUserInfo(formBean.getStrUserInfo());

			bo.getSearchItemInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			util = new HisUtil("Global Mms HLP", "MmsDATA.searchItemInit()");

			String temp = "<option value='0'>All</option>";

			if (vo.getWsGroupList() != null) {

				if (vo.getStrRequestType().equals("32")) {

					temp = util.getOptionValue(vo.getWsGroupList(), "0",
							"0^All", false);

				} else {

					temp = util.getOptionValue(vo.getWsGroupList(), "-1",
							"-1^Select Value#0^All", false);
				}

			}

			formBean.setStrGroupList(temp);

			temp = "<option value='0'>All</option>";

			/*
			 * if (vo.getStrSubGroupWs() != null) { temp =
			 * util.getOptionValue(vo.getStrSubGroupWs(), "0", "All", false); }
			 */
			// formBean.setStrSubGroupValues(temp);

			
			  temp = "<option value='0'>All</option>";
			  
			  if (vo.getStrItemListWs() != null) 
			  { 
				  temp = util.getOptionValue(vo.getStrItemListWs(), "0", "All", false); 
			  }
			 
			formBean.setStrItemList(temp);

			formBean.setStrNewItemFlag(vo.getStrNewItemFlag());

			strSearchItemInitView = MmsHLP.getSearchItemInitViewBS(formBean);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = "MmsDATA.searchItemInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.searchItemInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}
	}


}
