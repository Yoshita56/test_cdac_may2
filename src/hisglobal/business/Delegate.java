package hisglobal.business;

public abstract class Delegate
{
	private Object serviceProvider;

	protected Delegate(Object _serviceProvider)
	{
		this.serviceProvider = _serviceProvider;
	}

	protected Object getServiceProvider()
	{
		return serviceProvider;
	}
}
