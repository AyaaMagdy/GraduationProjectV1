package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import model.GradeModel;
import model.StaffEmails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import services.FinalGradesService;
import services.StaffEmailsService;

import android.content.Context;
import android.util.Log;

public class StaffEmailsJParser {
	public ArrayList<StaffEmails> getDepartmentEmails(String dep,Context ctx) throws JSONException, InterruptedException, ExecutionException
    {
		ArrayList<StaffEmails>stfEmails=new ArrayList<StaffEmails>();
	//    FinalGradesService c=new FinalGradesService(ctx);
	    StaffEmailsService service=new StaffEmailsService(ctx);
       
     //   Log.v("test","StartJson");
        service.execute("http://10.0.2.2/grades/emails.php",dep,"getEmails");
        String r2="";
        
     String result="";
     result=service.get();
     JSONArray jarray=new JSONArray(result);
     StaffEmails se;
   //  Log.v("test",""+jarray.length());
    for(int i=0;i<jarray.length();i++)
     {
    	se=new StaffEmails();
    	JSONObject jobj=jarray.getJSONObject(i);
   	    
	 	    se.setStaffemail((jobj.getString("staff_email")));
	 	    se.setStaffName((jobj.getString("staff_name")));
	 	    if(jobj.getString("Prof_Dr_TA").equals("1"))
	 	    	se.setFlag("Prof");
	 	    else if(jobj.getString("Prof_Dr_TA").equals("2"))
	 	    	se.setFlag("Dr");
	 	    else se.setFlag("TA");
	 	    stfEmails.add(se);
     }
   

		
		return stfEmails;
		
    }
}
