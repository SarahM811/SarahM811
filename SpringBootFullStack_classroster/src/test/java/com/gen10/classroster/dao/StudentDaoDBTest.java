/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.classroster.dao;

import com.gen10.classroster.entities.Course;
import com.gen10.classroster.entities.Student;
import com.gen10.classroster.entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sakim
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoDBTest {
    
    @Autowired
    TeacherDao teacherDao;
    
    @Autowired
    StudentDao studentDao;
    
    @Autowired
    CourseDao courseDao;
    
    
    public StudentDaoDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<Teacher> teachers = teacherDao.getAllTeachers();
        for(Teacher teacher : teachers) {
            teacherDao.deleteTeacherById(teacher.getId());
        }
        
        List<Student> students = studentDao.getAllStudents();
        for(Student student : students) {
            studentDao.deleteStudentById(student.getId());
        }
        
        List<Course> courses = courseDao.getAllCourses();
        for(Course course : courses) {
            courseDao.deleteCourseById(course.getId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStudentById method, of class StudentDaoDB.
     */
    @Test
    public void testGetStudentById() {
    }

    /**
     * Test of getAllStudents method, of class StudentDaoDB.
     */
    
    @Test
    public void testAddAndGetStudent() {
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        Student fromDao = studentDao.getStudentById(student.getId());
        assertEquals(student, fromDao);
    }
    
    @Test
    public void testGetAllStudents() {
         Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        Student student2 = new Student();
        student2.setFirstName("Test Student First 2");
        student2.setLastName("Test Student Last 2");
        student2 = studentDao.addStudent(student2);
        
        List<Student> students = studentDao.getAllStudents();
        
        assertEquals(2, students.size());
        assertTrue(students.contains(student));
        assertTrue(students.contains(student2));
    }

    /**
     * Test of addStudent method, of class StudentDaoDB.
     */
    @Test
    public void testAddStudent() {
    }

    /**
     * Test of updateStudent method, of class StudentDaoDB.
     */
    @Test
    public void testUpdateStudent() {
         Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        
        Student fromDao = studentDao.getStudentById(student.getId());
        assertEquals(student, fromDao);
        
        student.setFirstName("New Test Student First");
        studentDao.updateStudent(student);
        
        assertNotEquals(student, fromDao);
        
        fromDao = studentDao.getStudentById(student.getId());
        
        assertEquals(student, fromDao);
    }

    /**
     * Test of deleteStudentById method, of class StudentDaoDB.
     */
    @Test
    public void testDeleteStudentById() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test First");
        teacher.setLastName("Test Last");
        teacher.setSpecialty("Test Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        List<Student> students = new ArrayList<>();
        students.add(student);
        
        Course course = new Course();
        course.setName("Test Course");
        course.setTeacher(teacher);
        course.setStudents(students);
        course = courseDao.addCourse(course);
        
        Student fromDao = studentDao.getStudentById(student.getId());
        assertEquals(student, fromDao);
        
        studentDao.deleteStudentById(student.getId());
        
        fromDao = studentDao.getStudentById(student.getId());
        assertNull(fromDao);
    }
    
}
