package hisglobal.utility.filetransfer.config;

import hisglobal.utility.Entry;

import java.util.HashMap;
import java.util.Map;

public class FileTransferConfig
{
	// Keys
	public static String KEY_PROCESS_ID = "strProcessId";
	public static String KEY_CRNO_HOSPITAL_CODE = "strCRNoHospCode";
	public static String KEY_FILE_NAME = "strFileName";

	public static String KEY_UPLOADED_FILE_CONTENT = "keyUploadedFileContent";
	public static String KEY_UPLOADED_FILE_NAME = "keyUploadedFileName";
	public static String KEY_UPLOADED_FILE_CONENT_TYPE = "keyUploadedFileContentType";

	public static String KEY_UPLOADED_LIST_FILE_CONTENT = "keyUploadedListFilesContent";
	public static String KEY_UPLOADED_LIST_FILE_NAME = "keyUploadedListFilesName";
	public static String KEY_UPLOADED_LIST_FILE_CONENT_TYPE = "keyUploadedListFilesContentType";

	
	// Flags
	public static String PROCESS_TYPE_PATIENT_WISE = "1"; 
	public static String PROCESS_TYPE_NON_PATIENT_WISE = "2"; 
	
	
	// Process List
	public static String PROCESS_ID_PATIENT_IMAGE_UPLOAD = "11";
	public static String PROCESS_ID_PATIENT_INVESTIGATION_DOCUMENTS = "12";
	public static String PROCESS_ID_PATIENT_PROFILES = "13";
	public static String PROCESS_ID_PATIENT_MLC_DOCUMENTS = "14";
	public static String PROCESS_ID_PATIENT_SCANNED_DOCUMENTS = "15";
	public static String PROCESS_ID_PATIENT_DOCUMENTS = "16";
	
	public static String PROCESS_ID_TEMPLATE = "51";
	public static String PROCESS_ID_IMAGE_EXAMINAION = "52";
	public static String PROCESS_ID_INVESTIGATION = "53";
	public static String PROCESS_ID_INVESTIGATION_OUTSIDE_DOCUMENTS = "54";

	public static Map<String, Entry> MAP_PROCESS_DETIAL;
	static
	{
		Map<String, Entry> mpProcessDetail = new HashMap<String, Entry>();
		mpProcessDetail.put(PROCESS_ID_PATIENT_IMAGE_UPLOAD, new Entry("PatientImages",PROCESS_TYPE_PATIENT_WISE));
		mpProcessDetail.put(PROCESS_ID_PATIENT_INVESTIGATION_DOCUMENTS, new Entry("Investigation",PROCESS_TYPE_PATIENT_WISE));
		mpProcessDetail.put(PROCESS_ID_PATIENT_PROFILES, new Entry("PatientProfiles",PROCESS_TYPE_PATIENT_WISE));
		mpProcessDetail.put(PROCESS_ID_PATIENT_MLC_DOCUMENTS, new Entry("MLCDocs",PROCESS_TYPE_PATIENT_WISE));
		mpProcessDetail.put(PROCESS_ID_PATIENT_SCANNED_DOCUMENTS, new Entry("ScannedDocs",PROCESS_TYPE_PATIENT_WISE));
		mpProcessDetail.put(PROCESS_ID_PATIENT_DOCUMENTS, new Entry("PatDocs",PROCESS_TYPE_PATIENT_WISE));

		mpProcessDetail.put(PROCESS_ID_TEMPLATE, new Entry("Templates",PROCESS_TYPE_NON_PATIENT_WISE));
		mpProcessDetail.put(PROCESS_ID_IMAGE_EXAMINAION, new Entry("ImageExamination",PROCESS_TYPE_NON_PATIENT_WISE));
		mpProcessDetail.put(PROCESS_ID_INVESTIGATION, new Entry("InvestigationDefImages",PROCESS_TYPE_NON_PATIENT_WISE));
		mpProcessDetail.put(PROCESS_ID_INVESTIGATION_OUTSIDE_DOCUMENTS, new Entry("InvestigationOutside",PROCESS_TYPE_NON_PATIENT_WISE));
		
		
		MAP_PROCESS_DETIAL = mpProcessDetail; 
	}
	

}
