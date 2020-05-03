package com;
import DBconnection.DB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Patient;

import java.io.IOException; 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 


/**
 * Servlet implementation class PatientsAPI
 */
@WebServlet("/PatientsAPI")
public class PatientsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	Patient patientObj = new Patient();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String output = patientObj.insertPatient(
				
				
				request.getParameter("first"),   
				request.getParameter("lname"),    
				request.getParameter("email"), 
				request.getParameter("age"), 
				request.getParameter("mobile"), 
				request.getParameter("password")
				
				); 
		 
		 response.getWriter().write(output); 
		
		
		
		//doGet(request, response);
	}
	
	
	
	
	
	
	
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request)
		{
			Map<String, String> map = new HashMap<String, String>(); 
			try
			{   
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
				String queryString = scanner.hasNext() ?   
						scanner.useDelimiter("\\A").next() : ""; 
						scanner.close(); 
			
		
		 
		  String[] params = queryString.split("&");  
		  for (String param : params)  
		  		{ 
			  	String[] p = param.split("="); 
			  	map.put(p[0], p[1]);  
			  	}  
		  } 
		catch (Exception e) 
		{ 
			
		}  
		return map;
		}
	
	
	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		
		
		
		String output = patientObj.updatePatient(paras.get("hidPatientIDSave").toString(), 
		
		//String output = patientObj.updatePatient(
				
			//	request.getParameter("Uid"),
				
				paras.get("first").toString(), 
				paras.get("lname").toString(), 
				paras.get("email").toString().replace("%40", "@"), 
				paras.get("age").toString(), 
				paras.get("mobile").toString(), 
				paras.get("password").toString() 
				
							
				); 
		 
		 response.getWriter().write(output); 
		
		
		//System.out.println("inside update servlet");
		//doGet(request, response);
	}
	
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Map paras = getParasMap(request); 
		
		String output = patientObj.deletePatient(paras.get("Uid").toString()); 
				
			
		 
		 response.getWriter().write(output); 
		System.out.println("servlet");
	}
	
	
	

}
