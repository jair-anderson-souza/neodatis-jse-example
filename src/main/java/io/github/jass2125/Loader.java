/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125;

import io.github.jass2125.services.Connection;
import io.github.jass2125.services.StudentService;
import io.github.jass2125.services.ClassRoomService;
import io.github.jass2125.entity.Professor;
import io.github.jass2125.entity.Student;
import io.github.jass2125.entity.Person;
import io.github.jass2125.entity.ClassRoom;
import java.math.BigDecimal;
import java.util.List;
import org.neodatis.odb.ODB;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 19, 2018 3:57:35 PM
 */
public class Loader {

    public static void main(String[] args) {

        Connection connection = new Connection("neodatis.odb", "admin", "admin");
        ODB database = connection.getConnection();


        ClassRoomService classRoomService = new ClassRoomService(database);
        StudentService studentService = new StudentService(database);

        Person person = new Person("11111111111", "Anderson", 21);

        Professor prof = new Professor("12323423", "Paulo", 29, new BigDecimal(3000));
        Student student1 = new Student("123123123", "12323423", "Jair", 29);
        Student student2 = new Student("87687", "12323423", "Anderson", 29);
        ClassRoom classroom = new ClassRoom(prof, "Relational Database");

        classroom.addStudent(student1);
        classroom.addStudent(student2);

        studentService.persist(student1);
        studentService.persist(student2);
        classRoomService.persist(classroom);

        List<ClassRoom> listClassRoom = classRoomService.findClassRoomByDiscipline("Relational Database");
        List<Student> listStudents = studentService.findStudentByName();

        listClassRoom.stream().forEach(t -> {
            System.out.println(t);
        });

//		
        database.close();

//        System.exit(0);

    }
}
