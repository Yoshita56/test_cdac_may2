package hisglobal.persistence;

import hisglobal.persistence.TransactionContext;
import hisglobal.business.ServiceLocator;
import hisglobal.exceptions.InvalidTransactionStateException;
import hisglobal.exceptions.TransactionException;

import java.sql.Connection;
import java.util.*;

public abstract class AbstractTransactionContext implements TransactionContext
{

	protected HashMap labelConnectionMap = new HashMap();
	protected HashMap connectionStateMap = new HashMap();
	protected boolean isTxOpen;

	protected final HashMap labelJndiIdMap = new HashMap();
	{
		labelJndiIdMap.put("DEFAULT", new Integer(ServiceLocator.AHIS));
		labelJndiIdMap.put("AHIS", new Integer(ServiceLocator.AHIS));
		labelJndiIdMap.put("OLD", new Integer(ServiceLocator.OLD));
		labelJndiIdMap.put("AYUSH", new Integer(ServiceLocator.AYUSH));
		
	}

	public Connection getConnection() throws TransactionException
	{
		return getConnection(CONNECTION_DEFAULT);
	}

	public Connection getConnection(String _label) throws TransactionException
	{
		Connection conn = null;
		if (!isValidTransactionState()) throw new InvalidTransactionStateException("Transaction: NOT STARTED");
		//System.out.println("Transaction is in valid state");
		if (_label == null) throw new IllegalArgumentException("label: NULL");

		conn = this.getRegisteredConnection(_label);
		//System.out.println("Conn is ::" + conn + "    ...in get registered connection");
		if (conn == null)
		{
			//System.out.println("Conn is null in get registered connection");
			conn = this.getNewConnection(_label);
			this.registerConnection(_label, conn); // <<
		}
		return conn;
	}

	public boolean close() throws TransactionException
	{
		if (!this.isTxOpen) throw new InvalidTransactionStateException("Transaction: NOT STARTED");

		this.commitAll();
		this.closeAllConnections();
		this.isTxOpen = false;

		labelConnectionMap = new HashMap();
		connectionStateMap = new HashMap();

		return true;
	}

	protected Connection getRegisteredConnection(String _label)
	{
		Connection conn = null;

		//System.out.println("inside getRegisteredConnection");
		//System.out.println("label" + _label);

		if (_label == null) throw new IllegalArgumentException("Label: NULL");

		conn = (Connection) this.labelConnectionMap.get(_label);

		if (conn != null && !this.isValidConnection(_label)) throw new InvalidTransactionStateException("Invalid Transaction State - Label: "
				+ _label);

		//System.out.println("before obtainig connection");

		return conn;
	}

	protected void registerConnection(String _label, Connection _conn)
	{
		if (_label == null || _conn == null) throw new IllegalArgumentException("Label: " + _label + " Connection: " + _conn);

		this.labelConnectionMap.put(_label, _conn);
		this.connectionStateMap.put(_label, CONNECTION_STATE_VALID);
	}

	protected boolean isValidTransactionState()
	{
		return this.isTxOpen;
	}

	protected abstract void closeAllConnections();

	protected abstract boolean isValidConnection(String _label);

	protected abstract Connection getNewConnection(String _label) throws TransactionException;
}
