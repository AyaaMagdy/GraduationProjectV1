package controller;

import java.util.ArrayList;
import model.AttendanceModel;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.content.Context;
import android.util.Log;
import services.attendanceService;
import com.example.ecom.*;
import model.Courses;
public class AttendanceController {
	
	public AttendanceController() {
		Log.v("test","Ana henaaa");
	}
 
	public ArrayList<Courses> SelectRegisterCourses(String ID,Context ctx,String Term) throws InterruptedException, ExecutionException, JSONException{
		attendanceService c = new attendanceService(ctx);
		c.execute("http://10.0.2.2/webapp/selectRegesteredCoursesOfaStudent.php","CourseID",ID,Term);
		String result = c.get();
        Log.v("test",result);
        JSONArray jArray=new JSONArray(result);
        String name="";
        String id="";
        ArrayList<Courses> course = new ArrayList<Courses>();
        ArrayList<String> courseID = new ArrayList<String>();
        ArrayList<String> courseName = new ArrayList<String>();
        
        for(int i=0;i<jArray.length();i++)
        {
            JSONObject object=jArray.getJSONObject(i);
            id=object.getString("subj_id");
           Log.v("test",id);
            courseID.add(id);
        }
       
       // Log.v("size",courseID.size()+"");
        courseName=SelectRegisterCoursesName(courseID,ctx);
        //int x=courseName.size();
       // Log.v("test",x+"");
        for(int i=0; i<courseID.size(); i++){
        	name = courseName.get(i);
        	id = courseID.get(i);
        	course.add(new Courses(name , id)); 
        }
        Log.v("CourseSize",course.size()+"");
        return course;
	}
	
	public ArrayList<String> SelectRegisterCoursesName( ArrayList<String> courseID, Context ctx) throws InterruptedException, ExecutionException, JSONException{
		ArrayList<String> courseNameList = new ArrayList<String>();
		for(int i=0 ; i<courseID.size(); i++){
			String courseId=courseID.get(i);
			Log.v("courseID",courseId);
			attendanceService c = new attendanceService(ctx);
			c.execute("http://10.0.2.2/webapp/getCourses.php","CourseName",courseId);
			String result = c.get();
			Log.v("AllObjName",result);
			JSONArray jArray=new JSONArray(result);
			for(int j=0;j<jArray.length();j++)
	        {
	            JSONObject object=jArray.getJSONObject(j);
	            String name=object.getString("subj_name");
	            courseNameList.add(name);   
	            Log.v("afterParsing",name);
	        }
			
		}
		Log.v("wslLHna",courseNameList.size()+"");
        return courseNameList;
	}
	
	public ArrayList<Integer> labAttendance( ArrayList<Courses> course, Context ctx,String StudID) throws InterruptedException, ExecutionException, JSONException{
		
		ArrayList<Integer>labAbsent = new ArrayList<Integer>();
		int absent=1;
		int attend=0;
		 String getattendce="";
		for(int i=0; i<course.size(); i++){
			String courseID = course.get(i).getCourseID();
			String year = "2015";
			attendanceService c = new attendanceService(ctx);
			c.execute("http://10.0.2.2/webapp/labAttendace.php","labAttendance",courseID,StudID,year);
			String result = c.get();
			JSONArray jArray=new JSONArray(result);
			for(int j=0;j<jArray.length();j++)
	        {
	            JSONObject object=jArray.getJSONObject(j);
	            int sum=0;
	            for(int k=0 ; k<15; k++){
	            getattendce=object.getString("week"+(k+1));
	            if(getattendce.equals("yes"))
	            	sum+=1;
	            else
	            	continue;
	            }
	            labAbsent.add(sum);
	            Log.v("labAbsSize",labAbsent.size()+"");
	        }
			
		}
		
		return labAbsent;
	}
	
	public ArrayList<Integer> sectionAttendance( ArrayList<Courses> course, Context ctx,String StudID)
			throws InterruptedException, ExecutionException, JSONException{
		
		ArrayList<Integer>secAbsent = new ArrayList<Integer>();
		int absent=1;
		int attend=0;
		 String getattendce="";
		for(int i=0; i<course.size(); i++){
			String courseID = course.get(i).getCourseID();
			String year = "2015";
			attendanceService c = new attendanceService(ctx);
			c.execute("http://10.0.2.2/webapp/sectionAttendance.php","sectionAttendance",courseID,StudID,year);
			String result = c.get();
			JSONArray jArray=new JSONArray(result);
			for(int j=0;j<jArray.length();j++)
	        {
	            JSONObject object=jArray.getJSONObject(j);
	            int sum=0;
	            for(int k=0 ; k<15; k++){
	            getattendce=object.getString("week"+(k+1));
	            if(getattendce.equals("yes"))
	            	sum+=1;
	            else
	            	continue;
	            }
	            Log.v("sum:",sum+"");
	            secAbsent.add(sum);
	        }
			
		}
		
		return secAbsent;
	}
	
	public ArrayList<AttendanceModel> getAttendance( ArrayList<Courses> course, Context ctx,String StudID) 
			throws InterruptedException, ExecutionException, JSONException{
		ArrayList<AttendanceModel>attend = new ArrayList<AttendanceModel>();
		ArrayList<Integer>sec =  new ArrayList<Integer>();
		ArrayList<Integer>lab =  new ArrayList<Integer>();
		sec= sectionAttendance(course,  ctx, StudID);
		Log.v("sec hwada",sec.size()+"");
		lab = labAttendance(course,  ctx, StudID);
		Log.v("lab howada",lab.size()+"");
		for(int i=0; i<sec.size(); i++){
			attend.add(new AttendanceModel(lab.get(i)+"", sec.get(i)+""));
		}
		Log.v("attend howada",attend.size()+"");
		return attend;
	}
	
}
