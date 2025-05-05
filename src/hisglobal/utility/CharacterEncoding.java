package hisglobal.utility;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;


public class CharacterEncoding {
	public static void setCharacterEncoding(HttpServletRequest objRequest_p) 
	 {
		 System.out.println("CharacterEncoding :: setCharacterEncoding()");
		 try
		 {
			 objRequest_p.setCharacterEncoding("UTF-8");
		 }
		 catch(UnsupportedEncodingException e)
		 {
			 System.out.println("Error in Reset -> Character Encoding Try Block = ");
			 e.printStackTrace();
		 }
	 }
}
//While MODIFY Case use this Function :- %%%%%%%%%%%   CharacterEncoding.setCharacterEncoding(objRequest);
