package hisglobal.persistence;

import java.util.*;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.ResultSet;
//import oracle.jdbc.OracleTypes;

import hisglobal.exceptions.HisException;


public class Procedure
{
	String nameProcedure;
	Map mpParameters;
	boolean returns;

	CallableStatement callStmt;

	public Procedure(String _procedureName)
	{
		this.nameProcedure = _procedureName;
		this.mpParameters = new HashMap();
	}

	// the index of param starts from 1
	public void addInParameter(int _idx, int _type, Object _value)
	{
		Parameter param = new Parameter(_idx, _type, _value);
		this.mpParameters.put(new Integer(_idx), param);
		//System.out.println(".........addInParam");
	}

	public void addOutParameter(int _idx, int _type)
	{
		Parameter param = new Parameter(_idx, _type);
		this.mpParameters.put(new Integer(_idx), param);
	//	System.out.println(".........addOutParam");
	}

	public void addInOutParameter(int _idx, int _type, Object _value)
	{
		Parameter param = new Parameter(_idx, _type, _value, true);
		this.mpParameters.put(new Integer(_idx), param);
		//System.out.println(".........addInOutParam");
	}

	// index of returntype is 0
	public void setReturnType(int _type)
	{
		this.returns = true;
		Parameter param = new Parameter(0, _type);
		this.mpParameters.put(new Integer(0), param);
	}

	public Object execute(Connection _conn) throws HisException
	{
		Object result = null;
		String strCallStmt = "";

		strCallStmt += this.nameProcedure;

		ResultSet rs = null;

		String strParamList = "";

		Collection lstValueCol = this.mpParameters.values();
		Iterator itValueCol = lstValueCol.iterator();
		while (itValueCol.hasNext())
		{
			Parameter param = (Parameter) itValueCol.next();
			if (param.getIdx() != 0)
			{
				if (strParamList.length() != 0) strParamList += ", ";
				strParamList += "?";
			}
		}

		if (strParamList.length() > 0) strCallStmt += "(" + strParamList + ")";

		strCallStmt = "call " + strCallStmt;

		if (this.returns)
		{
			strCallStmt = "?=" + strCallStmt;
		}

		strCallStmt = "{" + strCallStmt + "}";

		System.out.println(strCallStmt);

		try
		{
			/*
			 * InitialContext ic = new InitialContext(); DataSource ds = (DataSource) ic.lookup("java:comp/env/AHIS");
			 * Connection conn = ds.getConnection();
			 */
			// create Statement
			this.callStmt = _conn.prepareCall(strCallStmt, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_UPDATABLE);
			// bind all Variables
			this.bindVariables();
			this.callStmt.execute();
		}
		catch (Exception e)
		{
			throw new HisException("" + e);
		}

		if (this.returns)
		{
			result = this.getParameterAt(0);
		}

		return result;
	}

	protected void bindVariables()
	{
		if (this.callStmt == null) throw new HisException("Procedure.bindVariables(): " + "Callable Statement Not Prepared");

		Collection lstValueCol = this.mpParameters.values();
		Iterator itValueCol = lstValueCol.iterator();

		while (itValueCol.hasNext())
		{
			Parameter param = (Parameter) itValueCol.next();
			this.setParameter(param);
		}
	}

	protected void setParameter(Parameter _param)
	{
		// int increment = this.returns?1:0;//if returning increment the idx with one
		try
		{

			System.out.println("idx" + this.getIdx(_param));
			System.out.println("value" + (String) _param.getValue());
			// ////handling null values
			if (_param.getValue() == null)
			{
				_param.setValue("");
			}
			// registerParameter type for OUT & INOUT type params
			if (!_param.isIN())
			{
				this.callStmt.registerOutParameter(this.getIdx(_param), _param.getType());
			}
			// if OUT Param WorkDone return
			if (_param.isOUT()) return;

			//System.out.println("_param.getClass(): " + _param.getValue().getClass());

			// If IN/INOUT param set Values
			switch (_param.type)
			{
				case (Types.TINYINT):
					this.callStmt.setByte(this.getIdx(_param), ((Byte) _param.getValue()).byteValue());
					break;
				case (Types.SMALLINT):
					this.callStmt.setShort(this.getIdx(_param), ((Short) _param.getValue()).shortValue());
					break;
				case (Types.INTEGER):

					this.callStmt.setInt(this.getIdx(_param), ((Integer) _param.getValue()).intValue());
					break;
				case (Types.BIGINT):
					this.callStmt.setLong(this.getIdx(_param), ((Long) _param.getValue()).longValue());
					break;
				case (Types.REAL):
					this.callStmt.setFloat(this.getIdx(_param), ((Float) _param.getValue()).floatValue());
					break;
				case (Types.FLOAT):
				case (Types.DOUBLE):
					this.callStmt.setDouble(this.getIdx(_param), ((Double) _param.getValue()).doubleValue());
					break;
				case (Types.DECIMAL):
				case (Types.NUMERIC):
					// System.out.println("((Integer)_param.getValue()).intValue()"+((Integer)_param.getValue()));
					if (_param.getValue().getClass() == String.class)
					{
						this.callStmt.setString(this.getIdx(_param), (String) _param.getValue());
					}
					else if (_param.getValue().getClass() == BigDecimal.class)
					{
						this.callStmt.setBigDecimal(this.getIdx(_param), (BigDecimal) _param.getValue());
					}
					break;
				case (Types.BIT):
					this.callStmt.setBoolean(this.getIdx(_param), ((Boolean) _param.getValue()).booleanValue());
					break;
				case (Types.CHAR):
				case (Types.VARCHAR):
					if(_param.getValue().toString().trim().equals(""))
						this.callStmt.setNull(this.getIdx(_param), Types.NULL);
					else
						this.callStmt.setString(this.getIdx(_param), (String) _param.getValue());
					break;
				case (Types.BINARY):
				case (Types.VARBINARY):
					throw new HisException("Procedure.setParameter():  " + "UnsupportedOperationException");
					/* this.callStmt.setByte(this.getIdx(_param), ((Byte)_param.getValue()).byteValue()); */
				case (Types.DATE):
					this.callStmt.setDate(this.getIdx(_param), (java.sql.Date) _param.getValue());
					break;
				case (Types.TIME):
					this.callStmt.setTime(this.getIdx(_param), (Time) _param.getValue());
					break;
				case (Types.TIMESTAMP):
					this.callStmt.setTimestamp(this.getIdx(_param), (Timestamp) _param.getValue());
					break;
				case (Types.CLOB):
					this.callStmt.setClob(this.getIdx(_param), (Clob) _param.getValue());
					break;
				case (Types.BLOB):
					this.callStmt.setBlob(this.getIdx(_param), (Blob) _param.getValue());
					break;
				case (Types.ARRAY):
					callStmt.setArray(this.getIdx(_param), (Array) _param.getValue());
					break;
				case (Types.REF):
					callStmt.setRef(this.getIdx(_param), (Ref) _param.getValue());
					break;
				case (Types.STRUCT):
				case (Types.JAVA_OBJECT):
					callStmt.setObject(this.getIdx(_param), _param.getValue());
					break;
				default:
					throw new HisException("Procedure.setParameter(): " + "UnSupportedOperationException - Parameter Type Not Compatible");
			}
		}
		catch (Exception e)
		{
			throw new HisException("Procedure.setParameter(): " + e);
		}
		//System.out.println("parameter set------");
	}

	// get Parameter at the position
	public Object getParameterAt(int _idx) throws HisException
	{
		Object result = null;

		Parameter param = (Parameter) mpParameters.get(new Integer(_idx));
		if (param == null) throw new HisException("Exception: Procedure.getParameterAt:  " + "IndexOutOfBound");

		if (param.isIN()) throw new HisException("Exception: Procedure.getParameterAt:  " + "IN parameter spacified");

		result = getParameterValue(param);
		return result;
	}

	// get Index for the Callable statement
	protected int getIdx(Parameter _param)
	{
		if (this.returns) return _param.getIdx() + 1;
		return _param.getIdx();
	}

	protected Object getParameterValue(Parameter _param) throws HisException
	{
		if (_param.isIN()) throw new HisException("procedure.getParameterValue(): IN type parameter");

		try
		{

			//System.out.println("_param.getIdx():  " + this.getIdx(_param));
			Object result = null;
			switch (_param.type)
			{
				case (Types.TINYINT):
					result = new Byte(this.callStmt.getByte(this.getIdx(_param)));
					break;
				case (Types.SMALLINT):
					result = new Short(this.callStmt.getShort(this.getIdx(_param)));
					break;
				case (Types.INTEGER):
					result = new Integer(this.callStmt.getInt(this.getIdx(_param)));
					break;
				case (Types.BIGINT):
					result = new Long(this.callStmt.getLong(this.getIdx(_param)));
					break;
				case (Types.REAL):
					result = new Float(this.callStmt.getFloat(this.getIdx(_param)));
					break;
				case (Types.FLOAT):
				case (Types.DOUBLE):
					result = new Double(this.callStmt.getDouble(this.getIdx(_param)));
					break;
				case (Types.DECIMAL):
				case (Types.NUMERIC):
					result = this.callStmt.getBigDecimal(this.getIdx(_param));
					break;
				case (Types.BIT):
					result = new Boolean(this.callStmt.getBoolean(this.getIdx(_param)));
					break;
				case (Types.CHAR):
				case (Types.VARCHAR):
					result = this.callStmt.getString(this.getIdx(_param));
					break;
				case (Types.BINARY):
				case (Types.VARBINARY):
					result = this.callStmt.getBytes(this.getIdx(_param));
					break;
				case (Types.DATE):
					result = this.callStmt.getDate(this.getIdx(_param));
					break;
				case (Types.TIME):
					result = this.callStmt.getTime(this.getIdx(_param));
					break;
				case (Types.TIMESTAMP):
					result = this.callStmt.getTimestamp(this.getIdx(_param));
					break;
				case (Types.CLOB):
					result = this.callStmt.getClob(this.getIdx(_param));
					break;
				case (Types.BLOB):
					result = this.callStmt.getBlob(this.getIdx(_param));
					break;
				case (Types.ARRAY):
					result = this.callStmt.getArray(this.getIdx(_param));
					break;
				case (Types.REF):
					//result = this.callStmt.getRef(this.getIdx(_param));
					result = this.callStmt.getObject(this.getIdx(_param));
					break;
				case (Types.STRUCT):
				case (Types.JAVA_OBJECT):
					result = this.callStmt.getObject(this.getIdx(_param));
					break;
				/*case (OracleTypes.CURSOR):
					result = this.callStmt.getObject(this.getIdx(_param));
					break;*/
				case (Types.OTHER):
					result = this.callStmt.getObject(this.getIdx(_param));
					break;
				default:
					throw new HisException("Procedure.getParameterValue(): " + "Parameter Type Not Compatible");
			}
			return result;
		}
		catch (Exception e)
		{
			throw new HisException("Procedure.getParameterValue(): " + e);
		}
	}

	protected CallableStatement prepareCallableStmt()
	{
		CallableStatement callableStmt = null;

		return callableStmt;
	}

	private class Parameter implements Comparable
	{
		private int idx;
		private int type;
		private Object value;
		private byte isINOUT; // 0 IN, 1 OUT, 2 INOUT

		public int getIdx()
		{
			return idx;
		}

		public Parameter(int _idx, int _type, Object _value)
		{
			this.idx = _idx;
			this.type = _type;
			this.value = _value;
			this.isINOUT = 0; // parameter is IN
			//System.out.println("IN type Param Created @" + _idx);
		}

		public Parameter(int _idx, int _type, Object _value, boolean _isINOUT)
		{
			this.idx = _idx;
			this.type = _type;
			this.value = _value;
			if (_isINOUT) this.isINOUT = 2; // parameter is INOUT
			else this.isINOUT = 0;// parameter is IN

			//System.out.println("INOUT type Param Created @" + _idx);
		}

		public Parameter(int _idx, int _type)
		{
			this.idx = _idx;
			this.type = _type;
			this.isINOUT = 1; // parameter is OUT
			//System.out.println("OUT type Param Created @" + _idx);
		}

		public boolean isIN()
		{
			if (this.isINOUT == 0) return true;
			return false;
		}

		public boolean isOUT()
		{
			if (this.isINOUT == 1) return true;
			return false;
		}

		public boolean isINOUT()
		{
			if (this.isINOUT == 2) return true;
			return false;
		}

		public boolean equals(Object obj)
		{
			if (obj == this) // reflexive condition
			return true;

			if (obj != null && (obj instanceof Parameter))
			{ // null Condition & Symmetric
				Parameter param = (Parameter) obj;
				if (this.idx == param.idx)
				{
					return true;
				}
			}
			return false;
		}

		public int hashCode()
		{
			return (new Integer(this.idx)).hashCode();
		}

		public int compareTo(Object obj)
		{
			int result;
			try
			{
				result = (new Integer(this.idx)).compareTo((new Integer(((Parameter) obj).idx)));
			}
			catch (Exception e)
			{ //ClassCastException
				throw new HisException("Parameter: compareTo() ");
			}
			return result;
		}

		protected int getType()
		{
			return type;
		}

		protected void setType(int type)
		{
			//System.out.println("setType:" + type);
			this.type = type;
		}

		protected Object getValue()
		{
			return value;
		}

		protected void setValue(Object value)
		{

			this.value = value;
		}
	}
}
