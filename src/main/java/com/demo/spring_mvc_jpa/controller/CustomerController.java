package com.demo.spring_mvc_jpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring_mvc_jpa.service.CustomerService;
import com.demo.spring_mvc_jpa.model.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("Controller /");
		List<Customer> listCustomer = customerService.listAll();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listCustomer", listCustomer);
		return mv;
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		System.out.println("Controller /new");

	    Customer customer = new Customer();
	    model.put("customer", customer);
	    return "new_customer";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	    customerService.save(customer);
	    return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
	    ModelAndView mv = new ModelAndView("edit_customer");
	    Customer customer = customerService.get(id);
	    mv.addObject("customer", customer);
	 
	    return mv;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
	    customerService.delete(id);
	    return "redirect:/";       
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Customer> result = customerService.search(keyword);
	    ModelAndView mv = new ModelAndView("search");
	    mv.addObject("result", result);
	 
	    return mv;    
	}
}
