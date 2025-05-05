package in.cdac.mhealth.global.dao;

import java.lang.reflect.Method;
import java.sql.BatchUpdateException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;

public class TransactionMgmnt {

    public static Map <Integer, String> sqlFunctionNames;

    static {
        sqlFunctionNames = new HashMap <Integer, String> ();
        sqlFunctionNames.put(Types.INTEGER, "setStmtInt");
        sqlFunctionNames.put(Types.VARCHAR, "setStmtString");
        sqlFunctionNames.put(Types.NUMERIC, "setStmtNumeric");
        sqlFunctionNames.put(Types.CLOB, "setStmtString");
        sqlFunctionNames.put(Types.DATE, "setStmtDate");
        sqlFunctionNames.put(Types.DOUBLE, "setStmtDouble");
        sqlFunctionNames.put(Types.FLOAT, "setStmtFloat");
        sqlFunctionNames.put(Types.TIME, "setStmtDate");
        sqlFunctionNames.put(Types.TIMESTAMP, "setStmtDate");
    }

    public void setStmtString(PreparedStatement stmt, int index, Object value) 
    		throws SQLException {
    	if (value == null) {
    		stmt.setNull(index, java.sql.Types.VARCHAR);
    	}
        try {
            stmt.setString(index, String.valueOf(value));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.VARCHAR);
        }
    }
    
    public void setStmtNumeric(PreparedStatement stmt, int index, Object value) 
    		throws SQLException {
    	if (value == null || value.toString().equals("")) {
    		stmt.setNull(index, java.sql.Types.NUMERIC);
    	}
        try {
            stmt.setString(index, String.valueOf(value));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.NUMERIC);
        }
    }

    public void setStmtDate(PreparedStatement stmt, int index, Object value)
    		throws SQLException {
        if (value == null || String.valueOf(value).equals("-") || String.valueOf(value).equals("")) {
            stmt.setDate(index, null);
        }
        else {
            java.sql.Date sqlToday = null;
            Calendar cal = Calendar.getInstance();
            String[] dateFormats = {
                "dd-MMM-yyyy hh:mm", "dd-MMM-yyyy", "dd-MMM-yyyy hh:mm:ss",
                "dd-MM-yyyy hh:mm", "dd-MM-yyyy", "dd-MM-yyyy hh:mm:ss",
                "MM-dd-yyyy hh:mm", "MM-dd-yyyy", "MM-dd-yyyy hh:mm:ss",
                "yyyy-MM-dd hh:mm", "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss",
                "dd/MMM/yyyy hh:mm", "dd/MMM/yyyy", "dd/MMM/yyyy hh:mm:ss",
                "dd/MM/yyyy hh:mm", "dd/MM/yyyy", "dd/MM/yyyy hh:mm:ss",
                "MM/dd/yyyy hh:mm", "MM/dd/yyyy", "MM/dd/yyyy hh:mm:ss",
                "yyyy/MM/dd hh:mm", "yyyy/MM/dd", "yyyy/MM/dd hh:mm:ss"
            };
            for (String dateFormat: dateFormats) {
                try {
                    cal.setTime(new SimpleDateFormat(dateFormat).parse(String.valueOf(value)));
                    sqlToday = new java.sql.Date(cal.getTimeInMillis());
                    break;
                } catch (ParseException ignore) {}
            }
            stmt.setDate(index, sqlToday);
        }
    }

    public void setStmtInt(PreparedStatement stmt, int index, Object value)
    		throws SQLException {
    	if (value == null || value.toString().equals("")) {
    		stmt.setNull(index, java.sql.Types.INTEGER);
    	}
        try {
            stmt.setInt(index, Integer.parseInt(String.valueOf(value)));            
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.INTEGER);
        }
    }

    public void setStmtDouble(PreparedStatement stmt, int index, Object value)
    		throws SQLException {
        try {
            stmt.setDouble(index, Double.parseDouble(String.valueOf(value)));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.DOUBLE);
        }
    }

    public void setStmtFloat(PreparedStatement stmt, int index, Object value)
    		throws SQLException {
        try {
            stmt.setFloat(index, Float.parseFloat(String.valueOf(value)));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.FLOAT);
        }
    }

    public void setStmtString(CallableStatement stmt, int index, Object value)
    		throws SQLException {
    	if (value == null) {
    		stmt.setNull(index, java.sql.Types.VARCHAR);
    	}
        try {
            stmt.setString(index, String.valueOf(value));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.VARCHAR);
        }
    }

    public void setStmtNumeric(CallableStatement stmt, int index, Object value) 
    		throws SQLException {
    	if (value == null || value.toString().equals("")) {
    		stmt.setNull(index, java.sql.Types.NUMERIC);
    	}
        try {
            stmt.setString(index, String.valueOf(value));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.NUMERIC);
        }
    }
    
    public void setStmtDate(CallableStatement stmt, int index, Object value)
    		throws SQLException {
    	if (value == null || String.valueOf(value).equals("-") || String.valueOf(value).equals(""))
            stmt.setDate(index, null);
        else {
            java.sql.Date sqlToday = null;
            Calendar cal = Calendar.getInstance();
            String[] dateFormats = {
                "dd-MMM-yyyy hh:mm", "dd-MMM-yyyy", "dd-MMM-yyyy hh:mm:ss",
                "dd-MM-yyyy hh:mm", "dd-MM-yyyy", "dd-MM-yyyy hh:mm:ss",
                "MM-dd-yyyy hh:mm", "MM-dd-yyyy", "MM-dd-yyyy hh:mm:ss",
                "yyyy-MM-dd hh:mm", "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss",
                "dd/MMM/yyyy hh:mm", "dd/MMM/yyyy", "dd/MMM/yyyy hh:mm:ss",
                "dd/MM/yyyy hh:mm", "dd/MM/yyyy", "dd/MM/yyyy hh:mm:ss",
                "MM/dd/yyyy hh:mm", "MM/dd/yyyy", "MM/dd/yyyy hh:mm:ss",
                "yyyy/MM/dd hh:mm", "yyyy/MM/dd", "yyyy/MM/dd hh:mm:ss"
            };
            for (String dateFormat: dateFormats) {
                try {
                    cal.setTime(new SimpleDateFormat(dateFormat).parse(String.valueOf(value)));
                    sqlToday = new java.sql.Date(cal.getTimeInMillis());
                    break;
                } catch (ParseException ignore) {}
            }            
            stmt.setDate(index, sqlToday);
        }
    }

    public void setStmtInt(CallableStatement stmt, int index, Object value)
    		throws SQLException {
    	if (value == null || value.toString().equals("")) {
    		stmt.setNull(index, java.sql.Types.INTEGER);
    	}
        try {
            stmt.setInt(index, Integer.parseInt(String.valueOf(value)));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.INTEGER);
        }
    }

    public void setStmtDouble(CallableStatement stmt, int index, Object value)
    		throws SQLException {
        try {
            stmt.setDouble(index, Double.parseDouble(String.valueOf(value)));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.DOUBLE);
        }
    }

    public void setStmtFloat(CallableStatement stmt, int index, Object value)
    		throws SQLException {
        try {
            stmt.setFloat(index, Float.parseFloat(String.valueOf(value)));
        } catch (Exception e) {
            stmt.setNull(index, java.sql.Types.FLOAT);
        }
    }
    
    public boolean executeUpdate (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		//System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    		//	System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	boolean retval = false;
    	try {
    		con.setAutoCommit(false);
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		pstmt.executeUpdate();
    		retval = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
    	return retval;
    }
        
    @SuppressWarnings("unchecked")
	public boolean executeBatch (String query, List<List<? extends Object>> params, Connection con) 
    		throws Exception {    	
    	int type[] = new int[params.size()];	// 0 for QueryParam, 1 for String
    	for (int i=0;i<params.size();++i) {
	    	if (StringUtils.countMatches(query, "?") != params.get(i).size()) {
	    		System.out.println("Error : Wrong Number of Parameters in List No. " + (i+1));
	    		throw new Exception("Error : Wrong Number of Parameters in List No. " + (i+1));
	    	}
	    	if (params.get(i).size() > 0) {
	    		if (params.get(i).get(0) instanceof QueryParam)
	    			type[i] = 0;
	    		else if (params.get(i).get(0) instanceof String)
	    			type[i] = 1;
	    		else {
	    			System.out.println("Error : Wrong type for query parameter list");
	    			throw new Exception("Error : Wrong type for query parameter list");
	    		}
	    	} else {
	    		type[i] = 0;
	    	}
    	}
    	
    	boolean retval = false;
    	try {
    		con.setAutoCommit(false);
    		PreparedStatement pstmt = con.prepareStatement(query);
    		for (int j=0;j<params.size();++j) {	    			    		
	    		String methodName = "";
	    		if (type[j] == 0) {
	    			List<QueryParam> param = (List<QueryParam>) params.get(j);
		    		for (int i=0;i<param.size();++i) {
		    			QueryParam v = param.get(i);
		    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
		    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
		    			else 
		    				methodName = "setStmtString";
		    			TransactionMgmnt obj = new TransactionMgmnt();
		    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
		    			method.invoke(obj, pstmt, i+1, v.getValue());
		    		}
	    		} else if (type[j] == 1) {
	    			List<String> param = (List<String>) params.get(j);
	    			for (int i=0;i<param.size();++i) {
	    				pstmt.setString(i+1, param.get(i).toString());
	    			}
	    		}
	    		pstmt.addBatch();
    		}
    		pstmt.executeBatch();
    		retval = true;
		} catch (BatchUpdateException e)  {
			throw e.getNextException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
    	return retval;
    }
    
    @SuppressWarnings("unchecked")
	public boolean executeBatch (String[] query, List<List<? extends Object>> params, Connection con) 
    		throws Exception {    	
    	int[] type = new int[query.length] ;	// 0 for QueryParam, 1 for String
    	for (int i=0;i<query.length;++i) {
	    	if (StringUtils.countMatches(query[i], "?") != params.get(i).size()) {
	    		System.out.println("Error : Wrong Number of Parameters in Query No. " + (i+1));
	    		throw new Exception("Error : Wrong Number of Parameters in Query No. " + (i+1));
	    	}
	    	if (params.get(i).size() > 0) {
	    		if (params.get(i).get(0) instanceof QueryParam)
	    			type[i] = 0;
	    		else if (params.get(i).get(0) instanceof String)
	    			type[i] = 1;
	    		else {
	    			System.out.println("Error : Wrong type for query parameter list");
	    			throw new Exception("Error : Wrong type for query parameter list");
	    		}
	    	} else {
	    		type[i] = 0;
	    	}
    	}
    	    	
    	boolean retval = false;
    	try {
    		con.setAutoCommit(false);
    		for (int j=0;j<query.length;++j) {
	    		PreparedStatement pstmt = con.prepareStatement(query[j]);
	    		String methodName = "";
	    		if (type[j] == 0) {
	    			List<QueryParam> param = (List<QueryParam>) params.get(j);
		    		for (int i=0;i<param.size();++i) {
		    			QueryParam v = param.get(i);
		    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
		    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
		    			else 
		    				methodName = "setStmtString";
		    			TransactionMgmnt obj = new TransactionMgmnt();
		    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
		    			method.invoke(obj, pstmt, i+1, v.getValue());
		    		}
	    		} else if (type[j] == 1) {
	    			List<String> param = (List<String>) params.get(j);
	    			for (int i=0;i<param.size();++i) {
	    				pstmt.setString(i+1, param.get(i).toString());
	    			}
	    		}
	    		pstmt.executeUpdate();
    		}
    		retval = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
    	return retval;
    }
    
    public String getSingleResult (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	ResultSet rs = null;
    	String retval = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		if (rs != null && rs.next())
    			retval = rs.getString(1);
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}
    	return retval;
    }
    
    public Map<String, String> getSelectMap (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	map.put("-1", "Select Value");
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		//System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    		//	System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	ResultSet rs = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		while (rs.next())
    			map.put(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}  finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}
    	return map;
    }
    
    public Map<String, String> getSelectMapWithAll (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	map.put("ALL", "ALL");
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		//System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			//System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	ResultSet rs = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		while (rs.next())
    			map.put(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}
    	return map;
    }
    
    public String getSelectOptionsAsHTML (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	String result = "<option value='-1'>Select Value</option>";
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	ResultSet rs = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		while (rs.next())
    			result += "<option value='" + rs.getString(1) +"'>" + rs.getString(2) + "</option>";
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}  finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}
    	return result;
    }
    
    public String getSelectOptionsAsHTMLWithoutDefault (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	String result = "";
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	ResultSet rs = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		while (rs.next())
    			result += "<option value='" + rs.getString(1) +"'>" + rs.getString(2) + "</option>";
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}  finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}
    	return result;
    }
    
    public Map<String, String> getMap (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    	//	System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			//System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	ResultSet rs = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		while (rs.next())
    			map.put(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}  finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}
    	return map;
    }
    
    public List<String> getList (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	List<String> list = new ArrayList<String>();
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		//System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			//System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	ResultSet rs = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		while (rs.next())
    			list.add(rs.getString(1));
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} 
    	return list;
    }
    
    public List<String> getRowAsList (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	List<String> lst = new ArrayList<String>();
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	ResultSet rs = null;    	
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		if (rs.next()) {
    			ResultSetMetaData rsmd = rs.getMetaData();
    			for (int i=1;i<=rsmd.getColumnCount();++i) {
    				lst.add(rs.getString(i));
    			}
    		}    			
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} 
    	return lst;
    }
    
    public JSONObject getRowAsJSONObject (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	JSONObject jobj = null;
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    	//	System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    	//		System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	ResultSet rs = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();    		
    		if (rs.next()) {
    			jobj = new JSONObject();
    			ResultSetMetaData rsmd = rs.getMetaData();
    			for (int i=1;i<=rsmd.getColumnCount();++i) {
    				jobj.put(rsmd.getColumnLabel(i), (rs.getString(i) == null ? "" : rs.getString(i)));
    			}
    		}    			
		} catch (SQLException e) {
			jobj = null;
			throw e;
		} catch (Exception e) {
			jobj = null;
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} 
    	return jobj;
    }
    
    public List<String> getAllRowsAsList (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	List<String> lst = new ArrayList<String>();
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	ResultSet rs = null;
    	ResultSetMetaData rsmd = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		rsmd = rs.getMetaData();
    		while (rs.next()) {
    			for (int i=1;i<=rsmd.getColumnCount();++i) {
    				lst.add(rs.getString(i));
    			}
    		}    			
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
				rsmd = null;
			}
		} 
    	return lst;
    }
    
    public ResultSet getResultSet (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    	//	System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    			//System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		return pstmt.executeQuery();    		  			
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} 
    }
    
    public String getResultSetAsJsonString (String query, List<? extends Object> params, Connection con) 
    		throws Exception {
    	if (StringUtils.countMatches(query, "?") != params.size()) {
    		//System.out.println("Error : Wrong Number of Parameters");
    		throw new Exception("Error : Wrong Number of Parameters");
    	}
    	int type = 0;	// 0 for QueryParam, 1 for String
    	if (params.size() > 0) {
    		if (params.get(0) instanceof QueryParam)
    			type = 0;
    		else if (params.get(0) instanceof String)
    			type = 1;
    		else {
    		//	System.out.println("Error : Wrong type for query parameter list");
    			throw new Exception("Error : Wrong type for query parameter list");
    		}
    	}
    	JSONObject jobj = new JSONObject();
    	ResultSet rs = null;
    	try {
    		PreparedStatement pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    		String methodName = "";
    		if (type == 0) {
	    		for (int i=0;i<params.size();++i) {
	    			QueryParam v = (QueryParam) params.get(i);
	    			if (TransactionMgmnt.sqlFunctionNames.containsKey(v.getType()))
	    				methodName = TransactionMgmnt.sqlFunctionNames.get(v.getType());
	    			else 
	    				methodName = "setStmtString";
	    			TransactionMgmnt obj = new TransactionMgmnt();
	    			Method method = TransactionMgmnt.class.getDeclaredMethod(methodName, PreparedStatement.class, int.class, Object.class);
	    			method.invoke(obj, pstmt, i+1, v.getValue());
	    		}
    		} else if (type == 1) {
    			for (int i=0;i<params.size();++i) {
    				pstmt.setString(i+1, params.get(i).toString());
    			}
    		}
    		rs = pstmt.executeQuery();
    		while (rs.next()) {
    			jobj.put("status", 1);
    			for (int i=1;i<=2;++i) {
    				jobj.put(rs.getString(1), rs.getString(2));
    			}
    		}
    		return jobj.toString();    		  			
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}
    }
}