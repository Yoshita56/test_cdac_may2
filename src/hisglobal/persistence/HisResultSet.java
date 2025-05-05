package hisglobal.persistence;

import java.util.ArrayList;
import java.sql.ResultSetMetaData;

public final class HisResultSet
{
	private int position;
	private ArrayList recordList;
	private String[] recordRow;
	private ResultSetMetaData rsmd;

	public ResultSetMetaData getMetaData()
	{
		return this.rsmd;
	}

	public void setMetaData(ResultSetMetaData rsmd)
	{
		this.rsmd = rsmd;
	}

	private HisResultSet()//Private Constructor
	{
		this.position = -1;
		this.recordList = new ArrayList();
		//Does Nothing
	}

	public static HisResultSet getInstance()//Static Method Gives the HisResultSet
	{
		return new HisResultSet();
	}

	public void put(String[] recordRow)//Putting the recordRow in ArrayList 
	{
		this.recordList.add(recordRow);
	}

	//Go to the first Record	

	public boolean first()
	{
		this.position = 0;//Moving to 0 index Position
		if (this.position < this.recordList.size())
		{
			this.recordRow = (String[]) this.recordList.get(this.position);
			return true;
		}
		else return false;
	}

	//Go to the last Record	
	public boolean last()
	{
		this.position = this.recordList.size() - 1;
		if (this.position != -1 && this.recordList.size() > 0)
		{
			this.recordRow = (String[]) this.recordList.get(this.position);
			return true;
		}
		else return false;
	}

	//Is Next Record Is Available
	public boolean next()
	{
		this.position++;//Moving to Next index Position
		if (this.position < this.recordList.size())
		{
			this.recordRow = (String[]) this.recordList.get(this.position);
			return true;
		}
		else return false;
	}

	//Is Next Record Is Available
	public boolean absolute()
	{
		this.position = 0;//Moving to previous index Position
		if (this.position != -1 && this.recordList.size() > 0)
		{
			this.recordRow = (String[]) this.recordList.get(this.position);
			return true;
		}
		else return false;
	}

	public boolean previous()
	{
		this.position--;//Moving to previous index Position
		if (this.position != -1 && this.recordList.size() > 0)
		{
			this.recordRow = (String[]) this.recordList.get(this.position);
			return true;
		}
		else return false;
	}

	//Getting Column
	public String getString(int i)
	{
		return this.recordRow[i - 1];
	}

	//Is First Record
	public boolean isFirst()
	{
		if (this.position == 0 && this.recordList.size() > 0) return true;
		else return false;
	}

	//Is Last Record
	public boolean isLast()
	{
		if (this.position == this.recordList.size() - 1 && this.recordList.size() > 0) return true;
		else return false;
	}

	//Getting RecordList Size
	public int size()
	{
		return (this.recordList == null) ? 0 : this.recordList.size();
	}

	//Closing the HisResultSet
	public void close()
	{
		this.position = -1;
		this.recordList.clear();
	}

}
