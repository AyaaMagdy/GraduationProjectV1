package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import services.GPAService;
import android.content.Context;
import android.util.Log;

public class GPAController {
	public GPAController() {
		Log.v("test","yraaaaaaaaab");
	}
 
	public ArrayList<String> SelectRegisterCourses(String StudentID,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		GPAService c = new GPAService(ctx);
		c.execute("http://10.0.2.2/webapp/selectAllRegesteredCoursesOfStudent.php","CourseID",StudentID);
		String result = c.get();
       // Log.v("alaaaaaaaa",result);
        JSONArray jArray=new JSONArray(result);
        String id="";
        ArrayList<String> course = new ArrayList<String>();
       
        for(int i=0;i<jArray.length();i++)
        {
           JSONObject object=jArray.getJSONObject(i);
           id=object.getString("subj_id");
          // Log.v("test",id);
           course.add(id);
        }
       
        return course;
	}
	
	public ArrayList<String> SelectFinalGrade(String StudentID,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		
		ArrayList<String> course = SelectRegisterCourses(StudentID, ctx);
		ArrayList<String> Grades = new ArrayList<String>();
		for(int i=0; i<course.size(); i++){
			GPAService c = new GPAService(ctx);
			String subID = course.get(i);
			c.execute("http://10.0.2.2/webapp/SelectFinalGradeOfSubject.php","Grades",subID );
			String result = c.get();
			Log.v("result",result);
	        JSONArray jArray=new JSONArray(result);
	        String grad="";
	        
	        for(int j=0;j<jArray.length();j++)
	        {
	           JSONObject object=jArray.getJSONObject(j);
	           grad=object.getString("grade");
	          
	           Grades.add(grad);
	        }
		}
        return Grades;
	}

}
