package hisglobal.persistence;

import java.util.ArrayList;

public class ResultSet
{
	int noOfCols;
	int cursor = -1;
	public ArrayList rs = new ArrayList();

	public ResultSet(hisglobal.persistence.HisResultSet _rs, int _noOfCols)
	{
		while (_rs.next())
		{
			ArrayList al = new ArrayList();
			for (int i = 0; i < _noOfCols; i++)
			{
				System.out.println("_rs.getString(i+1):  " + _rs.getString(i + 1));
				al.add(_rs.getString(i + 1));
			}
			this.rs.add(al);
		}
		this.noOfCols = _noOfCols;
	}

	public ResultSet getMetaData()
	{
		return this;
	}

	public int getColumnCount()
	{
		return noOfCols;
	}

	public boolean next()
	{
		this.cursor++;
		if (this.cursor < rs.size())
		{
			// this.cursor = this.cursor +1;
			System.out.println("cursor incremented: " + cursor);
			return true;
		}
		return false;
	}

	public String getString(int idx)
	{
		if (!(this.cursor < rs.size())) throw new IndexOutOfBoundsException("");

		if (idx <= noOfCols)
		{
			System.out.println("((ArrayList)rs.get(this.cursor)).get(idx-1): " + ((ArrayList) rs.get(this.cursor)).get(idx - 1).getClass());
			return (String) ((ArrayList) rs.get(this.cursor)).get(idx - 1);
		}
		else throw new IndexOutOfBoundsException("");
	}

	public void add(ArrayList _al)
	{
		rs.add(_al);
	}

}
