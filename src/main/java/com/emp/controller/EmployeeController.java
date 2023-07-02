package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.entity.Employee;
import com.emp.services.EmployeeServiceImplementation;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImplementation services;
	
	@GetMapping("/")
	public String home(Model model,HttpSession session)
	{
		List<Employee> list=services.getAllEmployee();
		model.addAttribute("emp",list);
		
		return "index";
	}
	
	@GetMapping("/addEmp")
	public String addEmp() 
	{
		return "add";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Employee e,HttpSession session)
	{
		services.addEmployee(e);
		session.setAttribute("msg", "Employee Added Successfully");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model model)
	{
		Employee e=services.getEmployeeById(id);
		System.out.println(e);
		model.addAttribute("employee", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		services.addEmployee(e);
		session.setAttribute("msg", "Employee Updated Successfully");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
		services.deleteEmployee(id);
		session.setAttribute("msg", "Employee Deleted Successfully");
		return "redirect:/";
	}
	
	@GetMapping("/removeMsg")
	public String removeMsgAttribute(HttpSession session) {
	    session.removeAttribute("msg");
	    return "redirect:/";
	}
	
	
}
