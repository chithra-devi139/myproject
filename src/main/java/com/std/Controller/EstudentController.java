package com.std.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.std.Entity.Estudent;
import com.std.Exception.CountException;
import com.std.Exception.DeptException;
import com.std.Exception.MaxException;
import com.std.Exception.NameException;
import com.std.service.EstudentService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EstudentController {
@Autowired
EstudentService ss;  // dependance injection

@PostMapping(value="/poststd")
public String post(@RequestBody Estudent s) {
	return ss.post(s);
}

//  **** Get value *****
@GetMapping(value="/service")
public List<Estudent> getAll() {
	return ss.getAll();
} 

//****** Even Ages Display ****
@GetMapping(value="/getEven")
public List<Estudent> getEvenAges(){
	return ss.getEvenAges();
}

//**** Get ID PathVariable Display*****

@GetMapping(value="/getstd/{id}")
public Estudent get(@PathVariable int id) {
	return ss.get(id);
}

//**** PutMapping Change values *******

@PutMapping(value="/update") 
public String put(@RequestBody Estudent a) {
	return ss.put(a);
			
}

//*** DeleteMapping Delete values *****

@DeleteMapping(value="/delete/{id}")
public String delete(@PathVariable int id) {
	return ss.delete(id);
	
}

//Task 1
//*** Max Age Student ******

@GetMapping(value="/maxage")
public Estudent maxage() {
	return ss.maxage();
}

// *** Age below  40 above 25 ****

@GetMapping(value="/Age1")
public List<Estudent> getage(){
	return ss.getage();
}

//**** Least 3 length of names ******

@GetMapping(value="/length")
public List<Estudent> getlengthname(){
	return ss.getlengthname();
}

// **** Female Students with Computer Department ******

@GetMapping(value="/female")
public List<Estudent> getfemale(){
	return ss.getfemale();
}

// ****** Highest 3 Ages *****

@GetMapping(value="higestage")
public List<Estudent> gethigh(){
	return ss.gethigh();
}

// *** Get all Details ****
@GetMapping(value="/gatAll")
public List<Estudent> gatall(){
	return ss.gatall();	
}
// ***** Query ***
// **** SELECT name FROM students_table;  ******

@GetMapping(value="/getname1")
public List<String> getname(String n) {
	return ss.getname(n);
}

// ******* SELECT name,age FROM students_table *****

@GetMapping(value="/name_age")
public List<String> getna() {
	return ss.getna();
}

// ******* SELECT age FROM students_table where age > 25 *******

@GetMapping(value="age-25")
public List<Integer> getagegreater() {
    return ss.getagegreater();
}

// SELECT name FROM students_table where name like 's%'; 

@GetMapping(value="likename")
public List<String> getlike(){
	return ss.getlike();
}

// ***** SELECT name FROM students_table where name like '%a'  *******

@GetMapping(value="likelast")
public List<String> getlask(){
	return ss.getlask();
}

// ****** SELECT name FROM students_table where name like '%Chitra%' *******

@GetMapping(value="like1")
public List<String> getlikes() {
	return ss.getlikes();
}

//**** SELECT name FROM students_table where name  ='Sumithra' ****
@GetMapping(value="like2")
public List<String> getlike2() {
	return ss.getlike2();
}

// **** SELECT name FROM students_table where age=29 ***
@GetMapping(value="like3")
public List<String> getlike3() {
	return ss.getlike3();
}

// ***** SELECT max(age) FROM students_table ******
@GetMapping(value="max")
public Integer getmax() {
	return ss.getmax();
}

// **** SELECT min(age) FROM students_table *****
@GetMapping(value="min")
public Integer getmin() {
	return ss.getmin();
}

// ***** SELECT * FROM students_table where age=(SELECT max(age) FROM students_table) ***
@GetMapping(value="detailmax")
public List<Estudent> getmaxs() {
	return ss.getmaxs();	
}

// ****** SELECT * FROM students_table where age=(SELECT min(age) FROM students_table) ***
@GetMapping(value="detailmin")
public List<Estudent> getmins() {
	return ss.getmins();	
}

// ***** SELECT * from students_table order by age  *****
@GetMapping(value="orderage")
public List<Estudent> orderage() {
	return ss.orderage();	
}

//***** SELECT * from students_table order by age desc ********
//@GetMapping(value="check")
//public String checkobject(@RequestParam String name) {
//	Estudent s=new Estudent(name);
//	return ss.checkobjectname(s);	
//}


//  ******** Exception throw  *********
@GetMapping(value="/getname/{id}")
public String getname(@PathVariable int id) throws NameException {
	try {
	return ss.getname(id);
	}
	catch(Exception e) {
		return "No Name Found";
	}
}

// ***** object use name or throw exception *****

@GetMapping(value="/getobj/{ns}")
public List<Estudent> getobj(@PathVariable String ns) throws NameException{
	return ss.getobj(ns);
}

// Task Exception Handling
// Task 1
// *** Find max age->if is even throw EvenException and handle it
@GetMapping(value="/getmax1")
public int getmax1() throws MaxException {
	return ss.getmax1();
	}

// Task 2
// **** Get all Students Who are not in cs dept.if it is empty,throw empty exception ,handle it *******
@GetMapping(value="/getcom")
public List<Estudent> getcom() throws DeptException {
	return ss.getcom();
}

// Task3
//**** get the count of the student names.if the count is greaterthan 5 throw GreaterException.handle it ******
@GetMapping(value="/getcount")
public int getcount() throws CountException {
	return ss.getcount();	
}

}