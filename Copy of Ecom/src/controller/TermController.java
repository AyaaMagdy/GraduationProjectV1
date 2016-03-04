package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.Courses;
import model.MatrialModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import services.TermService;

import android.content.Context;
import android.util.Log;


public class TermController {
	
	public TermController() {
		Log.v("testLaya","b55");
		
	}
	
	public ArrayList<Courses> SelectRegisterCourses(String Term,Context ctx,String Year) throws InterruptedException, ExecutionException, JSONException{
		TermService c = new TermService(ctx);
		c.execute("http://10.0.2.2/webapp/SelectCoursesByLevel.php","selectCourses",Term,Year);
		Log.v("testLaya","b552");
		String result = c.get();
        Log.v("sqlobj",result);
        JSONArray jArray=new JSONArray(result);
        String name="";
        String id="";
        ArrayList<Courses> course = new ArrayList<Courses>();
        for(int i=0;i<jArray.length();i++)
        {
            JSONObject object=jArray.getJSONObject(i);
            id=object.getString("subj_id");
            name=object.getString("subj_name");
            course.add(new Courses(name , id)); 
           // Log.v("test",id);
        }
        Log.v("sqlobj",course.size()+"");
        return course;
	}
	
	
	public ArrayList<MatrialModel> SelectMatrialLinks(String SubjName,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		TermService c = new TermService(ctx);
		c.execute("http://10.0.2.2/webapp/SelectMatrialLinks.php","selectLinks",SubjName);
		Log.v("testLaya","b552");
		String result = c.get();
        Log.v("sqlobj",result);
        JSONArray jArray=new JSONArray(result);
        String Link="";
        String Topic="";
        ArrayList<MatrialModel> MLinks = new ArrayList<MatrialModel>();
        for(int i=0;i<jArray.length();i++)
        {
            JSONObject object=jArray.getJSONObject(i);
            Link=object.getString("link");
            Topic=object.getString("topicName");
            MLinks.add(new MatrialModel(Topic, Link)); 
           // Log.v("test",id);
        }
        Log.v("sqlobj",MLinks.size()+"");
        return MLinks;
	}
	
	public void AddMatrialLinks(String topicName,String Link,String subjName,Context ctx) throws InterruptedException, ExecutionException, JSONException{
		TermService c = new TermService(ctx);
		c.execute("http://10.0.2.2/webapp/InsertLinks.php","addLinks",topicName,Link,subjName);
		String result = c.get();
		Log.v("adddddddd",result);
	}
}
