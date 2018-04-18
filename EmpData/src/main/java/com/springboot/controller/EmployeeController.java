package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.dao.EmployeeDao;
import com.springboot.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao dao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	   public String viewHome() {
	 
	    return ("index");
	   }
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveEmployee(HttpServletRequest req){
		Employee e=new Employee();
		e.setId(Integer.parseInt(req.getParameter("id")));
		e.setEname(req.getParameter("ename"));
		e.setSalary(Long.parseLong(req.getParameter("salary")));
		e.setAddress(req.getParameter("address"));
		System.out.println("starting.....");
		dao.insertEmployee(e);
		System.out.println("data stored successfully");
		return  new ModelAndView("success");
	}

	@RequestMapping(value="/find",method=RequestMethod.GET)
	public ModelAndView listEmployees(ModelMap map){
		System.out.println("method call");
		List<Employee> list=dao.findAll();
		System.out.println("executed");
		System.out.println(list);
		map.addAttribute("employees",list);
		
		return new ModelAndView("employeeList");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("id")int empid,ModelMap map){
		Employee e=new Employee();
		e.setId(empid);
		dao.deleteEmp(e);
		List<Employee> list=dao.findAll();
		System.out.println(list);
		map.addAttribute("employees",list);
		
		return new ModelAndView("employeeList");
	}

}
