package com.jio.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jio.entity.AddStudent;
import com.jio.entity.Student;
import com.jio.entity.Subject;
import com.jio.service.StudentService;
import com.jio.service.SubjectService;
import com.jio.utils.MyUtils;

@Controller
public class StudentController {
	
	@Autowired()
	private StudentService studentService;
	@Autowired()
	private SubjectService subjectService ;
	
	@RequestMapping("/showAllStudents")
	public String findAllStudents(Model model) {
		
		List<Student> students = studentService.findAllStudents();
		
		List<Subject> subject = subjectService.findAllSubject();
		model.addAttribute("subject", subject);
		model.addAttribute("students", students);

		return "show";
	}
	
	@RequestMapping("/addStudent")
	public String addStudents(Model model) {
		
		List<Subject> subject = subjectService.findAllSubject();
		
		model.addAttribute("subject", subject);
		int num = 1;
		model.addAttribute("num", num);
		return "add";
	}
	

	@RequestMapping("/addSuccess")
	public String addSuccesss(String name,String password,int age,int lession,Model model) {
		Date date  = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sCreateDate= sdf.format(date);
		password = MyUtils.md5(password);
	
		AddStudent add = new AddStudent(name, password, age, sCreateDate, lession);
	    studentService.addStudent(add);
	
		
		return "redirect:/showAllStudents";
	}
	
	@RequestMapping(value="/addSuccess1",method=RequestMethod.POST)
	@ResponseBody
	public String addSuccesss1(String uname) {
		
		int res = 0;
		Student student = studentService.findStudentByName(uname);
		if(student != null) {
			res = res+1;
		}
		String num = ""+res;
		return num;
	}
	
	@RequestMapping(value="/delStudent", method=RequestMethod.POST)
	@ResponseBody
	public String delStudent(Model model,HttpServletRequest req) {
		int id = Integer.valueOf(req.getParameter("del"));
		int res = studentService.delStudent(id);
		String data = ""+res;
		return data;
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent(int id,Model model) {
		Student student = studentService.findStudentById(id);
		model.addAttribute("student", student);
		
		List<Subject> subject = subjectService.findAllSubject();
		model.addAttribute("subject", subject);
		int num = 2;
		model.addAttribute("num", num);
		return "add";
	}
	
	@RequestMapping("/updateSuccess")
	public String updateSuccess(int id,String name,String password,int age,String sCreateDate, int lession,Model model) {
		password = MyUtils.md5(password);
		AddStudent addStudent = new AddStudent(id, name, password, age, sCreateDate, lession);
		int updateStudent = studentService.updateStudent(addStudent);
		
		return "redirect:/showAllStudents";
	}
	@RequestMapping("/getStudentName")
	@ResponseBody
	public String getStudentName(int id,Model model) {
		List<String> list = new ArrayList<String>();
		String str = "";
		List<Student> stu = studentService.findStudentBySubjectId(id);
		for (Student student : stu) {
			list.add(student.getsName());
			str+=student.getsName()+",";
		}
		return str;
	}
}
