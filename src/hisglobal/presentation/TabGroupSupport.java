package hisglobal.presentation;

import java.util.Comparator;



public class TabGroupSupport {

	 public static final int TAB_UNSELECTED=0;
	    public static final int TAB_SELECTED=1;  
	    
	    
		private String tabName;
		private int tabIdx;
		private int  status=TAB_UNSELECTED;
		private String tabLabel;
		
		public String getTabLabel() {
			return tabLabel;
		}

		public void setTabLabel(String tabLabel) {
			this.tabLabel = tabLabel;
		}

		public TabGroupSupport(String tabName,int tabIdx,int status,String label)
		{
			this.tabName=tabName;
			this.tabIdx=tabIdx;
			this.status=status;	
			this.tabLabel=label;
		}	
		
		public int getStatus() {
			return status;
		}	
		public void setStatus(int status) {
			System.out.println("status setter: "+status);
			this.status = status;
			
		}	
		public int getTabIdx() {
			return tabIdx;
		}
		public void setTabIdx(int tabIdx) {
			this.tabIdx = tabIdx;
		}
		public String getTabName() {
			return tabName;
		}
		public void setTabName(String tabName) {
			this.tabName = tabName;
		}
		
		public boolean equals(Object obj)	
		 {
			 if (obj == this)                                // (2)
		            return true;
		     if (obj == null|| !(obj instanceof TabGroupSupport))                // (3)
		            return false;	     
		     TabGroupSupport objTab= (TabGroupSupport)obj;
		      return objTab.tabName.equals(this.tabName);
		 }
		
		public int hashCode()
		{
			int hashValue=0;
			hashValue=this.tabName.hashCode(); 
			return hashValue;	
		}
		
		public static class TabComparator implements Comparator 
		{
			public int compare(Object obj1, Object obj2) {		
				
				TabGroupSupport objTab1=((TabGroupSupport)obj1);
				TabGroupSupport objTab2=((TabGroupSupport)obj2);
				Integer o1= new Integer(objTab1.tabIdx);
				Integer o2= new Integer(objTab2.tabIdx);			
				return o1.compareTo(o2);
			}
		}
}
