/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.services;

import io.github.jass2125.entity.Student;
import java.util.ArrayList;
import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 21, 2018 12:26:20 PM
 */
public class StudentService {

    private ODB database;

    public StudentService(ODB database) {
        this.database = database;
    }

    public List<Student> findStudentByName() {
        List<Student> list = new ArrayList<>();
        IQuery query = new CriteriaQuery(Student.class, Where.equal("name", "Jair"));
        Objects<Student> classRoomIterable = database.getObjects(query);
        while (classRoomIterable.hasNext()) {
            Student next = classRoomIterable.next();
            list.add(next);
        }
        return list;
    }

    public void persist(Student student) {
        database.store(student);
    }
}
