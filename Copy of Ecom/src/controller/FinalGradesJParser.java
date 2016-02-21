package controller;

import java.util.ArrayList;
import model.GradeModel;
import services.FinalGradesService;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.util.Log;

public class FinalGradesJParser {

	 public ArrayList<GradeModel> search_grades(String ID,String term,Context ctx) throws JSONException, InterruptedException, ExecutionException
	    {
		 
		 ArrayList<GradeModel>allresult=new ArrayList<GradeModel>(); 
	        FinalGradesService c=new FinalGradesService(ctx);
	        
	        String year="2015";
	     //   Log.v("test","StartJson");
	        c.execute("http://10.0.2.2/grades/grades.php",ID,term,year,"getGrades");
	        String r2="";
	        
	     String result="";
	     result=c.get();
	     JSONArray jarray=new JSONArray(result);
	     GradeModel gm;
	     Log.v("test",""+jarray.length());
	    for(int i=0;i<jarray.length();i++)
	     {
	    	
	    	gm=new GradeModel();
	    	FinalGradesService c2=new FinalGradesService(ctx);
	    	 JSONObject jobj=jarray.getJSONObject(i);
	    	 String crsID=jobj.getString("subj_id");
	    	 Log.v("now",crsID);
	    	 c2.execute("http://10.0.2.2/grades/getCourse.php",crsID,"getCourseNameService");
	    	 String result2=c2.get();
	    	 JSONArray jarray2=new JSONArray(result2);
	 	    for(int j=0;j<jarray2.length();j++)
	 	     {
	 	    	 JSONObject jobj2=jarray2.getJSONObject(j);
	 	    	
	 	    	 r2=jobj2.getString("subj_name");
	 	    	 Log.v("bd2na",r2);
	 	     }
	 	    gm.setCourseName(r2);
	 	    gm.setTerm_work(jobj.getString("term_work"));
	 	    gm.setExam_work(jobj.getString("exam_work"));
	 	    gm.setResult(jobj.getString("result"));
	 	    gm.setGrade(jobj.getString("grade")); 
	 	   
	 	   
	 	   allresult.add(gm); 
	 	   
	     }
	    //Log.v("y raaab",r);
	       return allresult; 
	    }
	
}
