package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.Courses;
import model.TableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import services.TableService;


import android.content.Context;
import android.util.Log;

public class TableController 
{
	public ArrayList<String> getCoursesAndGroups
	(String ID,Context ctx) throws JSONException, InterruptedException, ExecutionException
    {
	 
        TableService c=new TableService(ctx);
        
        String year="2015";
        String term="2";
       Log.v("test","StartJson");
        c.execute("http://10.0.2.2/ecom/RegesteredCourses.php",ID,term,"getCoursesAndGroups");
        String result = c.get();
        Log.v("test",result);
        JSONArray jArray=new JSONArray(result);
        String id="",group="";
        ArrayList<String> courseIDAndGroup = new ArrayList<String>();     
        for(int i=0;i<jArray.length();i++)
        {
            JSONObject object=jArray.getJSONObject(i);
            id=object.getString("subj_id");
            group=object.getString("group_no");
           Log.v("test",id);
           courseIDAndGroup.add(id);
           courseIDAndGroup.add(group);
           
        }
        
       return courseIDAndGroup; 
    }
	public ArrayList<TableModel> saturdayTable(ArrayList<String>coursesAndGroups,Context ctx) throws InterruptedException, ExecutionException
	{
		   String courseName="",coursePlace="",slot="",stuff="";
	        ArrayList<TableModel>table = new ArrayList<TableModel>(); 
		  for(int i=0;i<coursesAndGroups.size();i+=2)
		  {
			 // Log.v("ggggg","gwa el loop");
			  TableService c=new TableService(ctx);
		  c.execute("http://10.0.2.2/ecom/saturday.php",coursesAndGroups.get(i),coursesAndGroups.get(i+1),"saturdayTable");
		  String result = c.get();
	      Log.v("testtesttesttest",result);
	        JSONArray jArray = null;
			try {
				jArray = new JSONArray(result);
			} catch (JSONException e) {
			
				e.printStackTrace();
			}
	         
	        for(int j=0;j<jArray.length();j++)
	        {
	            JSONObject object = null;
				try {
					object = jArray.getJSONObject(j);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					courseName=object.getString("course_Name");
					    Log.v("test",courseName);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					coursePlace=object.getString("place");
					 Log.v("test",coursePlace);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					slot=object.getString("slot");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					stuff=object.getString("stuff");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          table.add(new TableModel(slot, coursePlace, stuff, courseName));
	      
	           
	        }
		  
		  }
		
		return table;
		
	}
	

}
