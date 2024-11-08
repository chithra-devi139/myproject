package com.std.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.std.Dao.EstudentDao;
import com.std.Entity.Estudent;
import com.std.Exception.CountException;
import com.std.Exception.DeptException;
import com.std.Exception.MaxException;
import com.std.Exception.NameException;

@Service
public class EstudentService {
@Autowired
EstudentDao sd;
public String post(Estudent s) {
	return sd.post(s);
}
//**** Get Values ******

	public List<Estudent> getAll() {
		return sd.getAll();
	} 
	
	
//****** Even Ages Display **********	
	public List<Estudent> getEvenAges(){		
		List<Estudent> students=sd.getAll();
		List<Estudent> studs=new ArrayList<>();
		students.forEach(x-> {
			if(x.getAge() % 2 == 0) {
				 studs.add(x);
			}
		} );
		return studs;
		}
	
//  **** Get ID PathVariable Display ***
	
public Estudent get(int id) {
	return sd.get(id);
}


//**** PutMapping Change values *******

public String put(Estudent a) {
	return sd.put(a);
}

//*** DeleteMapping Delete values *****

public String delete(int id) {
	return sd.delete(id);
}


// **** Max Age Students *******

public Estudent maxage() {
	List<Estudent> maxs=sd.getAll();
	Estudent  max=maxs.get(0);
	for(int i=0;i<maxs.size();i++)
	{
		if(maxs.get(i).getAge() >max.getAge())
		{
			max=maxs.get(i);
					
		}
    }
	return max;
	}

//*** Age below  40 above 20 ****


public List<Estudent> getage() {
	List<Estudent> age1=sd.getAll();
	return age1.stream().filter(x->x.getAge() < 40 && x.getAge() > 20).toList();
}

// **** Least 3 length of names ******

public List<Estudent> getlengthname() {
	List<Estudent> age2=sd.getAll();
	return age2.stream().filter(x->x.getName().length() <= 4).toList();
}

//**** Female Students with Computer Department ******

public List<Estudent> getfemale() {	
	return sd.getAll().stream().filter(x->x.getGender().equals("female") && x.getDepartment().equals("Computer")).toList();
}
//****** Highest 3 Ages *****

public List<Estudent> gethigh(){
	return sd.getAll().stream()
			          .sorted(Comparator.comparingInt(Estudent::getAge).reversed())
			          .limit(3)
			          .toList();
	
}
//*** Get all Details Query  ****

public List<Estudent> gatall() {
	return sd.gatall();
}
//**** SELECT name FROM students_table;  ******

public List<String> getname(String n) {
	return sd.getname(n);
}
//******* SELECT name,age FROM students_table *****

public List<String> getna() {
	return sd.getna();
}
//******* SELECT age FROM students_table where age > 25 *******

public List<Integer> getagegreater() {
 return sd.getagegreater();
}
//SELECT name FROM students_table where name like 's%' ******

public List<String> getlike() {
	return sd.getlike();	
}
//***** SELECT name FROM students_table where name like '%a'  *******

public List<String> getlask(){
	return sd.getlask();
}

//****** SELECT name FROM students_table where name like '%Chitra%' *******

public List<String> getlikes() {
	return sd.getlikes();
}

//**** SELECT name FROM students_table where name  ='Sumithra' ****
public List<String> getlike2() {
	return sd.getlike2();
}

//**** SELECT name FROM students_table where age=29 ***
public List<String> getlike3() {
	return sd.getlike3();
}

//***** SELECT max(age) FROM students_table ******
public Integer getmax() {
	return sd.getmax();
}

//**** SELECT min(age) FROM students_table *****
public Integer getmin() {
	return sd.getmin();
}

//***** SELECT * FROM students_table where age=(SELECT max(age) FROM students_table) ***
public List<Estudent> getmaxs() {
	return sd.getmaxs();	
}

//****** SELECT * FROM students_table where age=(SELECT min(age) FROM students_table) ***
public List<Estudent> getmins() {
	return sd.getmins();	
}

//***** SELECT * from students_table order by age  *****
public List<Estudent> orderage() {
	return sd.orderage();	
}
////***** SELECT * from students_table order by age desc ********
//public List<Estudent> reverse() {
//	return sd.reverse();	
//}


//******** Exception throw  *********
public String getname(int id) throws NameException {
	if(sd.getname(id).startsWith("S")) {
		return sd.getname(id);
	}
	else {
		throw new NameException();
	}			
}


//***** object use name or throw exception *****
public List<Estudent> getobj(String ns) throws NameException{
	if(sd.getobj(ns).isEmpty()) {
	    throw new NameException();
	}
	else {
		return sd.getobj(ns);
	}
}

//Task Exception Handling
//*** Find max age->if is even throw EvenException and handle it
public int getmax1() throws MaxException {
	if(sd.getmax1() % 2 != 0)
	{
		throw new MaxException();
	}
	else {
		return sd.getmax1();
	}	
	}
// Task 2
//**** Get all Students Who are not in cs dept.if it is empty,throw empty exception ,handle it *******
public List<Estudent> getcom() throws DeptException {
	if(!sd.getcom().isEmpty())
	{
		throw new DeptException();
	}
	else {
		return sd.getcom();
	}	
}
// Task 3
//**** get the count of the student names.if the count is greaterthan 5 throw GreaterException.handle it ******
public int getcount() throws CountException{
	if(sd.getcount()>5) {
		throw new CountException();
	}
	else {
		return sd.getcount();
	}
		
}



}