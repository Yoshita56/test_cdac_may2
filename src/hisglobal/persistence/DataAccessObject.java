package hisglobal.persistence;

public abstract class DataAccessObject
{
	protected TransactionContext transactionContext;

	protected DataAccessObject(TransactionContext _tx)
	{
		this.transactionContext = _tx;
	}

	protected TransactionContext getTransactionContext()
	{
		return transactionContext;
	}
}
