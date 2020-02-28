package springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class LogicController implements Controller{

	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String forwardName = "Hallo";
		
		System.out.println(req.getParameter("userName") + " ************** " + req.getParameter("password"));
		String name = req.getParameter("userName");
		String password = req.getParameter("password");
		
		if ((req.getParameter("userName")).equals("Purvang")) {
			//LOGIC
			forwardName = "Home";
		} else {
			forwardName = "Bye";
		}
		
		checkingFromDatabase cd = new checkingFromDatabase();
		ArrayList<String> namePass = new ArrayList<String>();
		
		namePass = cd.CheckingUserInDatabase();
		forwardName = "Bye";
		
		for (int i=0; i<namePass.size(); i++) {
			if (namePass.get(i).equals(name)) {
				if (namePass.get(i+1).equals(password)) {
					System.out.println("Credentials are valid: " + "User-name: " + name + "Password: " + password);
					forwardName = "Home";
					
					
				}
			}
		}
		
		if (forwardName.equals("Bye")) {
			System.out.println("Credentials are not valid ");
		}
		
//		name1 = namePass.get(0);
//		password1 = namePass.get(1);
//		
//		if(name.equals(name1) && password.equals(password1))
//		{
//			System.out.println("Credentials are valid: " + "User-name: " + name + "Password: " + password);
//			
//		}
//		else {
//			System.out.println("Credentials are not valid ");
//		}
//		
//		ModelAndView mv = new ModelAndView(forwardName);
//		return mv;
		
		ModelAndView mv = new ModelAndView(forwardName);
		mv.addObject("name", req.getParameter("userName"));
		return mv;
		
	}

}
