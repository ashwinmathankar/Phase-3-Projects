package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.Category;
import com.simplilearn.entity.Order;
import com.simplilearn.entity.Product;
import com.simplilearn.entity.User;
import com.simplilearn.service.AdminService;
import com.simplilearn.service.CategoryService;
import com.simplilearn.service.OrderService;
import com.simplilearn.service.ProductService;
import com.simplilearn.service.UserService;

@RestController
@RequestMapping("/api")

public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin/insert")
	public Admin addNewAdmin(@RequestBody Admin admin)
	{
		return adminService.addAdmin(admin);
	}
	
	@GetMapping("/admin/list")
	public List<Admin> listAdmin()
	{
		return adminService.getAllAdmin();
	}
	
	@PutMapping("/admin/updatepwd/{aid}")
	public Admin updatePwd(@PathVariable("aid")int aid,@RequestBody Admin admin)
	{
		return adminService.updateAdmin(aid,admin);
	}
	
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/insert")
	public User addNewUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@GetMapping("/user/list")
	public List<User> listUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/user/{uid}")
	public User findUserById(@PathVariable("uid")int uid)
	{
		return userService.getUserById(uid);
	}

	
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category/insert")
	public Category addNewCategory(@RequestBody Category category)
	{
		return categoryService.addCategory(category);
	}
	
	@GetMapping("/category/list")
	public List<String> listCategory()
	{
		return categoryService.getAllCategory();
	}
	
	
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/insert")
	public Product addNewProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@GetMapping("/product/list")
	public List<String> listProduct()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{pid}")
	public List<String> findProductById(@PathVariable("pid") int pid)
	{
		return productService.ProductById(pid);
	}
	
	@PutMapping("/product/update/{pid}")
	public Product updateProduct(@PathVariable("pid")int pid,@RequestBody Product product)
	{
		return productService.updateProduct(pid,product);
	}
	
	@DeleteMapping("/product/{pid}")
	public void deleteProduct(@PathVariable("pid")int pid)
	{
		productService.deleteProduct(pid);
		System.out.println("Deleted");
	}
	
	
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders/list")
	public List<Order> listOrders()
	{
		return orderService.getAllOrders();
	}
	
	@GetMapping("/orders/filter")
	public List<Order> listOrdersByDate(@RequestParam(value="dateoforder") String dateoforder)  
	{
		return orderService.findByDate(dateoforder);
	}
	
	@GetMapping("/orders/{cid}")
	public List<String> listOrdersByCategory(@PathVariable("cid")int cid)
	{
		return categoryService.CategoryByCid(cid);
	}
	
	@PutMapping("/orders/update/{oid}")
	public Order updateOrder(@PathVariable("oid")int oid,@RequestBody Order order)
	{
		return orderService.update(oid,order);
	}

}
