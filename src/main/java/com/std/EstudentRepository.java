package com.std;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.std.Entity.Estudent;

public interface EstudentRepository  extends JpaRepository<Estudent,Integer> {
	@Query(value="SELECT * FROM students_table",nativeQuery=true)
	public List<Estudent> gatall();
	
	@Query(value="SELECT name FROM students_table",nativeQuery=true)
	public List<String> getname(String n);
	
	
	@Query(value="SELECT name,age FROM students_table",nativeQuery=true)
	public List<String> getna();

	@Query(value="SELECT age FROM students_table where age > 25",nativeQuery=true)
	public List<Integer> getagegreater();
	
    @Query(value="SELECT name FROM students_table where name like 's%' ",nativeQuery=true)
    public List<String> getlike();
    
    @Query(value="SELECT name FROM students_table where name like '%a' ",nativeQuery=true)
    public List<String> getlask();
    
    @Query(value="SELECT name FROM students_table where name like '%Chitra' ",nativeQuery=true)
    public List<String> getlikes();
    
    @Query(value="SELECT name FROM students_table where name='sumithra' ",nativeQuery=true)
    public List<String> getlike2();
    
    @Query(value="SELECT name FROM students_table where age=29",nativeQuery=true)
    public List<String> getlike3();
    
    @Query(value="SELECT max(age) FROM students_table",nativeQuery=true)
    public Integer getmax();
    
    @Query(value="SELECT min(age) FROM students_table",nativeQuery=true)
    public Integer getmin();
    
    @Query(value="SELECT * FROM students_table where age=(SELECT max(age) FROM students_table)",nativeQuery=true)
    public List<Estudent> getmaxs();
    
    @Query(value="SELECT * FROM students_table where age=(SELECT min(age) FROM students_table)",nativeQuery=true)
    public List<Estudent> getmins();
    
    @Query(value="SELECT * from students_table order by age",nativeQuery=true)
    public List<Estudent> orderage();
    
//    @Query(value="SELECT * from students_table order by age desc ",nativeQuery=true)
//    public List<Estudent> reverse();
    
    @Query(value="SELECT * FROM students_table where name like ?",nativeQuery=true)
    public List<Estudent> getobj(String ns);
    
    @Query(value="SELECT max(age) FROM students_table",nativeQuery=true)
    public int getmax1();
    
    @Query(value="SELECT * FROM students_table where department IN('Computer')",nativeQuery=true)
    public List<Estudent> getcom();
    
    @Query(value="SELECT count(name) FROM students_table ",nativeQuery=true)
    public int getcount();
}
