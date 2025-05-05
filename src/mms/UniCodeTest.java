package mms;

import java.io.File;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class UniCodeTest 
{
	public static void main (String [] args) throws Exception {

	    //Get 128B Barcode instance from the Factory
	    Barcode barcode = BarcodeFactory.createCode128B("10100002$10000000$ASD~123123");
	    barcode.setBarHeight(60);
	    barcode.setBarWidth(2);
        System.out.println("---barcode---"+barcode);
	    
	    File imgFile = new File("D:/testsize.png");

	    //Write the bar code to PNG file
	    BarcodeImageHandler.savePNG(barcode, imgFile);
	    
	  }
}
