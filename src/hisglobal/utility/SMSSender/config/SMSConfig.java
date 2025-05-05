 /*************************************************Start of program***************************************************\
 ## Copyright Information                       :     C-DAC, Noida  
 ## Project Name                                :     NIMS
 ## Name of Developer                           :     Sheeldarshi
 ## Module Name                                 :     
 ## Process/Database Object Name                :
 ## Purpose                                     :    This  is used to send SMS.
 ## Date of Creation                            :    26-Feb-2015
 
/*********************************************************************************************************************/

package hisglobal.utility.SMSSender.config;

import java.util.Date;

public class SMSConfig 
{
  
 /* AIIMS BHUB
   public static final String sms_username = "itdeptaiimsbbsr";//"aiims_mang";//"eraktkosh";
   public static final String sms_password = "Aiims@09876";//"Aiims@12345";//"eraktkosh#123";//"cdac@2013";
   public static final String sms_senderId = "AIIMSB";//"AIIMSM";//"EBLOOD";//"RAJSMS";
   public static final String sms_message  = "Test SMS from By Quartz Job, Sorry for inconvenience!"+new Date();
   public static final String sms_mobileNo = "8745050539";
   public static final String sms_url="https://msdgweb.mgov.gov.in/esms/sendsmsrequest";
   public static final String secureKey = "9e07afa7-90fd-43d2-a47b-fe624fdb11ea";//"e6e1a88c-fa9d-4c65-8125-cb6aff9c2a29";//"c5d170b9-cde3-4933-a48b-54816a6a502b";
 */
	/*AIIMS Nagpur*/
   public static final String sms_username = "AIIMSNAGPUR";//"aiims_mang";//"eraktkosh";
   public static final String sms_password = "Nagpuraiims@12#";//"Aiims@12345";//"eraktkosh#123";//"cdac@2013";
   public static final String sms_senderId = "AIIMSN";//"AIIMSM";//"EBLOOD";//"RAJSMS";
   public static final String sms_message  = "Test SMS from By Quartz Job, Sorry for inconvenience!"+new Date();
   public static final String sms_mobileNo = "9650344666";
   public static final String sms_url="https://msdgweb.mgov.gov.in/esms/sendsmsrequest";
   public static final String secureKey = "1467db1e-6b67-41e1-81a4-c9f02c60f64e";//"e6e1a88c-fa9d-4c65-8125-cb6aff9c2a29";//"c5d170b9-cde3-4933-a48b-54816a6a502b";
 
}
