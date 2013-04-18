package com.asal.projectmanager.service;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class Homework22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Mongo mongo = new Mongo("localhost", 27017);
			Mongo mongo = new Mongo("localhost");
			DB db = mongo.getDB("students");
			
			//BasicDBObject whereQuery = new BasicDBObject();
			//whereQuery.p
			
			DBCollection collection = db.getCollection("grades");
			BasicDBObject document;// = new BasicDBObject();

			//"_id" : "50906d7fa3c412bb040eb895"
				
//				document = new BasicDBObject();
//				document.put("_id", "50906d7fa3c412bb040eb895");
//				collection.remove(document);
				
				//"_id" : ObjectId("50906d7fa3c412bb040eb895")

			
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("type", "homework");
			
			
			DBCursor cursor;
			DBObject currentObject, previousObject, oldObject=null, nextObject = null;
			//collection.distinct("student_id").
			
			//.find(whereQuery).sort(new BasicDBObject("student_id", 1).append("score", 1));
			cursor = collection.find(whereQuery).sort(new BasicDBObject("student_id", 1).append("score", -1));//.sort(new BasicDBObject("student_id", 1));//.sort(new BasicDBObject("score", -1));
		
			System.out.println("Going In MMMMMMMMM");
			int count = 0;
			int deleteCount = 0, curNull = 0;
			
			int studentId = 0, deleteNo = 0;
			
			
			while(cursor.hasNext()){
				
				//System.out.println("Doing Stuff!!");
				//cursor.
				//currentObject = cursor.next();
				//collection.re
				currentObject = cursor.curr();
//				if (cursor.curr() != null)
//				{
//					if (cursor.curr().get("student_id").equals(studentId))
//					{
//						System.out.println(" Will delete  "+studentId+" 's current record"+ ++deleteNo);
//					}
//					
//					studentId = (Integer)cursor.curr().get("student_id");
//					
//					System.out.println(" ************** Curr Not Null"+ ++curNull+"  STUD ID previous"+ oldObject.get("student_id") +" from curr"+cursor.curr().get("student_id"));
//					if (!cursor.curr().get("student_id").equals(oldObject.get("student_id")))
//					{
//						//delete old object
//						System.out.println(" ############## Delete Number XXXXXXXX "+ ++deleteCount);
//						
//					}
//				}
					
					nextObject = cursor.next();
				    oldObject = nextObject;
						
				System.out.println("NO :: "+ ++count +"      "+nextObject);
				
//				if (currentObject == null);
//				else{
//					if (!currentObject.get("student_id").equals(nextObject.get("student_id"))){
//						System.out.println(" Will delete  "+studentId+" 's current record"+ ++deleteNo+" object id is "+currentObject.get("_id"));
//						
//						document = new BasicDBObject();
//						document.put("_id", currentObject.get("_id"));
//						collection.remove(document);
//						
//					}
//				}
				
				
			}
			
			System.out.println("Out and Done");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
