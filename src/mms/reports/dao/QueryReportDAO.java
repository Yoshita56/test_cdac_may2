package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.QueryReportVO;

public class QueryReportDAO {

	public static synchronized void getResults(QueryReportVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			dao = new HisDAO("eAushadi", "QueryReportDAO");

			int index = dao.setQuery(vo.getqName());

		//	//System.out.println(vo.getqName());
			
			ws = dao.executeQry(index);

			if (ws != null) {

				int totalSize = ws.size();
 
				vo.setTotalRows(totalSize );

				if ("1".equals(vo.getfRows())) {

					int fSize = Integer.parseInt(vo.getnRows());
					
					vo.setTotalFetchedRows(totalSize > fSize ? fSize 
							: totalSize );

				} else {

					vo.setTotalFetchedRows(totalSize );

				}

			}

			vo.setResultWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString(e.getMessage().split("ERROR:")[1]);
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

}
