package hisglobal.persistence;

import java.util.*;
import java.sql.*;
import java.sql.Connection;

import hisglobal.business.ServiceLocator;
import hisglobal.exceptions.TransactionException;

public class JDBCTransactionContext extends AbstractTransactionContext
{

	public void begin() throws TransactionException
	{
		if (isTxOpen == true) throw new TransactionException("Transaction.isTxtOpen = true");
		isTxOpen = true;
	}

	public boolean commitAll() throws TransactionException
	{
		Set st = this.labelConnectionMap.keySet();
		Iterator it = st.iterator();

		try
		{
			while (it.hasNext())
				((Connection) this.labelConnectionMap.get(it.next())).commit();
		}
		catch (SQLException e)
		{
			throw new TransactionException("Transaction.Commit: " + e.getMessage());
		}

		return true;
	}

	public boolean rollback() throws TransactionException
	{
		Set st = this.labelConnectionMap.keySet();
		Iterator it = st.iterator();
		try
		{
			while (it.hasNext())
				((Connection) this.labelConnectionMap.get(it.next())).rollback();
		}
		catch (SQLException e)
		{
			throw new TransactionException("Transaction.Rollback: " + e.getMessage());
		}
		return true;
	}

	protected boolean isValidConnection(String _label)
	{
		//System.out.println("inside is valid connection");
		if (_label == null) throw new IllegalArgumentException("Label: NULL");
		try
		{
			Connection conn = (Connection) labelConnectionMap.get(_label);
			//System.out.println("conn" + conn);
			String connState = (String) connectionStateMap.get(_label);
			//System.out.println("connState" + connState);
			//System.out.println("is conn closed" + conn.isClosed());
			//System.out.println("conn state" + connState);

			if (conn.isClosed() || connState.equals(CONNECTION_STATE_INVALID))
			// connection is closed using the the raw connection object in the DAO explicitly
			return false;
			//System.out.println("dfdf ");
		}
		catch (SQLException e)
		{
			throw new TransactionException("Transaction.isValidConnection: " + e.getMessage());
		}
		return true;
	}

	protected Connection getNewConnection(String _label) throws TransactionException
	{
		if (_label == null) throw new IllegalArgumentException("Label: NULL");

		Connection conn = null;
		try
		{
			//System.out.println("inside getNEwconnection ");
			ServiceLocator locator = ServiceLocator.getInstance();

			//System.out.println("locator::::"+locator);
			//System.out.println("labelJndiIdMap::::"+labelJndiIdMap);
			//System.out.println("labelJndiIdMapValue::::"+labelJndiIdMap.get(_label));
			conn = locator.getDBConn(((Integer)labelJndiIdMap.get(_label)).intValue());
			//System.out.println(" CONN::"+conn);			

			conn.setAutoCommit(false);
			this.labelConnectionMap.put(_label, CONNECTION_STATE_VALID);

		}
		catch (Exception e)
		{
			throw new TransactionException("Transaction.newConnection: " + e);
		}

		return conn;
	}

	protected void closeAllConnections()
	{
		Set st = this.labelConnectionMap.keySet();
		Iterator it = st.iterator();
		try
		{
			while (it.hasNext())
			{
				String strKey = (String) it.next();
				Connection conn = (Connection) this.labelConnectionMap.get(strKey);
				conn.close();
				this.connectionStateMap.put(strKey, CONNECTION_STATE_INVALID);
			}
		}
		catch (SQLException e)
		{
			throw new TransactionException("Transaction.CloseAllConnections: " + e.getMessage());
		}
	}

}
