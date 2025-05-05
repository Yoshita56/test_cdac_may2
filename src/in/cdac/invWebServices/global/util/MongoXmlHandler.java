package in.cdac.invWebServices.global.util;



import in.cdac.invWebServices.config.HISConfig;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;




import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

public class MongoXmlHandler {
		
	 private static MongoClient mongoClient;
	    private static DB database;
	    String dbName = HISConfig.HIS_MONGOSERVER_INV_DBNAME;
	    //String dbName = "cdacpatprofile8";
	    
	    private static MongoXmlHandler myInstance = null;

	    public static MongoXmlHandler getInstance() {
	        if (null == myInstance || null == mongoClient || null == database) {
	            myInstance = new MongoXmlHandler();
	        }
	        return myInstance;
	    }

	    private MongoXmlHandler() {
	        createConnection();
	    }

	    public void createConnection() {
	    	//System.out.println(HISConfig.HIS_MONGOSERVER_INV_CONNECTION);
	        if (mongoClient == null || database == null) {
	        	String connectionURI = HISConfig.HIS_MONGOSERVER_INV_CONNECTION;
	            
	        	//connectionURI = "mongodb://10.226.2.96:27017";
	        	mongoClient = new MongoClient(new MongoClientURI(connectionURI));
	            database = mongoClient.getDB(dbName);
	            CommandResult commandResult = database.command("buildInfo");
	            //System.out.println("MongoDB Version : "+commandResult.getString("version"));
	            
	        }
	    }

	    public static DBCollection getDbCollection()
	    {
	    	
	    	return database.getCollection("patientDocumentsFiles1001");
	    	
	    	
	    }

	    public static byte[]  latestFetchFile(String id) throws IOException {
	        String newFileName = id;
	      /*  GridFS gfsPhoto = new GridFS(database,collectionName);*/
	        GridFS gfsPhoto = new GridFS(database);
	        //Map<String, String> hm = new HashMap<String, String>();
	        //hm.put("filename", id);
	       // hm.put("uploadDate", "-1");
	        //BasicDBObject query = new BasicDBObject("metadata", new BasicDBObject(hm));
	        
	        BasicDBObject sort = new BasicDBObject("uploadDate", -1);//sort in descending order
	        BasicDBObject query = new BasicDBObject("filename", id);
	        
	        List<GridFSDBFile> outputFiles = gfsPhoto.find(query, sort);//findOne(newFileName);

	        if (outputFiles == null || outputFiles.size() == 0) {
	         //   Log(Level.INFO, "Document Not found. Id: " + id);
	        	
	        //	System.out.println("Document Not found. Id: " + id);
	            return null;
	        }

	        GridFSDBFile output = outputFiles.get(0);
	       /* for (int i = 0; i < outputFiles.size(); i++) {

	        }*/
	       // System.out.println(outputFiles.get(0).getUploadDate() + " " + outputFiles.get(0).getId());
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        //System.out.println(output);
	        output.writeTo(baos);
	        String r = new String(baos.toByteArray());
	       // System.out.println(r);
	        return baos.toByteArray();
	    }
	    
	    public static byte[]  latestFetchFile1(String id) throws IOException {
	        String newFileName = id;
	        GridFS gfsPhoto = new GridFS(database);
	        
	        //Map<String, String> hm = new HashMap<String, String>();
	        //hm.put("filename", id);
	       // hm.put("uploadDate", "-1");
	        //BasicDBObject query = new BasicDBObject("metadata", new BasicDBObject(hm));
	        
	        BasicDBObject sort = new BasicDBObject("uploadDate", -1);//sort in descending order
	        BasicDBObject query = new BasicDBObject("filename", id);
	        
	        List<GridFSDBFile> outputFiles = gfsPhoto.find(query, sort);//findOne(newFileName);

	        if (outputFiles == null || outputFiles.size() == 0) {
	         //   Log(Level.INFO, "Document Not found. Id: " + id);
	        	
	        //	System.out.println("Document Not found. Id: " + id);
	            return null;
	        }

	        GridFSDBFile output = outputFiles.get(0);
	       /* for (int i = 0; i < outputFiles.size(); i++) {

	        }*/
	       // System.out.println(outputFiles.get(0).getUploadDate() + " " + outputFiles.get(0).getId());
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        //System.out.println(output);
	        output.writeTo(baos);
	        String r = new String(baos.toByteArray());
	       // System.out.println(r);
	        return baos.toByteArray();
	    }
	   

}
