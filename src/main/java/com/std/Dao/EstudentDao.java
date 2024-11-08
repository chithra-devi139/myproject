package com.std.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.std.EstudentRepository;
import com.std.Entity.Estudent;
import com.std.Exception.CountException;
import com.std.Exception.DeptException;
import com.std.Exception.MaxException;
import com.std.Exception.NameException;

@Repository
public class EstudentDao {
@Autowired
EstudentRepository sr;
public String post(Estudent s) {
	sr.save(s);
	return "Post SucessFully";
}

//****  GetValues   *******

public List<Estudent> getAll() {
	return sr.findAll();
}

//**** Get ID PathVariable Display ***

public Estudent get(int id) {
	return sr.findById(id).get();
}

//**** PutMapping Change values *******

public String put(Estudent a) {
 sr.save(a);
 return "Updated Successfully";
}

//*** DeleteMapping Delete values *****

public String delete(int id) {
	sr.deleteById(id);
	return "Deleted SuccessFully";
}
//*** Get all Details Query  ****
public List<Estudent> gatall() {
	return sr.gatall();
	
}
//**** SELECT name FROM students_table;  ******
public List<String> getname(String n) {
	return sr.getname(n);
}

//******* SELECT name,age FROM students_table *****

public List<String> getna() {
	return sr.getna();
}

//******* SELECT age FROM students_table where age > 25 *******

public List<Integer> getagegreater() {
return sr.getagegreater();
}
//SELECT name FROM students_table where name like 's%' ******

public List<String> getlike() {
	return sr.getlike();
}
//***** SELECT name FROM students_table where name like '%a'  *******

public List<String> getlask(){
	return sr.getlask();
}
//****** SELECT name FROM students_table where name like '%Chitra%' *******

public List<String> getlikes() {
	return sr.getlikes();
}
//**** SELECT name FROM students_table where name  ='Sumithra' ****
public List<String> getlike2() {
	return sr.getlike2();
}
//**** SELECT name FROM students_table where age=29 ***
public List<String> getlike3() {
	return sr.getlike3();
}
//***** SELECT max(age) FROM students_table ******
public Integer getmax() {
	return sr.getmax();
}
//**** SELECT min(age) FROM students_table *****
public Integer getmin() {
	return sr.getmin();
}

//***** SELECT * FROM students_table where age=(SELECT max(age) FROM students_table) ***
public List<Estudent> getmaxs() {
	return sr.getmaxs();	
}
//****** SELECT * FROM students_table where age=(SELECT min(age) FROM students_table) ***
public List<Estudent> getmins() {
	return sr.getmins();	
}

//***** SELECT * from students_table order by age  *****
public List<Estudent> orderage() {
	return sr.orderage();	
}

//// ***** SELECT * from students_table order by age desc ********
//public List<Estudent> reverse() {
//	return sr.reverse();	
//}

//******** Exception throw  *********
public String getname(int id) throws NameException {
	return sr.findById(id).get().getName();
}


//***** object use name or throw exception *****
public List<Estudent> getobj(String ns) throws NameException {	
		return sr.getobj(ns);
}


//Task Exception Handling
//*** Find max age->if is even throw EvenException and handle it
public int getmax1() throws MaxException {
	return sr.getmax1();
}

//**** Get all Students Who are not in cs dept.if it is empty,throw empty exception ,handle it *******
public List<Estudent> getcom() throws DeptException {
	return sr.getcom();
}

// **** get the count of the student names.if the count is greaterthan 5 throw GreaterException.handle it ******
public int getcount() throws CountException{
	return sr.getcount();	
}
}