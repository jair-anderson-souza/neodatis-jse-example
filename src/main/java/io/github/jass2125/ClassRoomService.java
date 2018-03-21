/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.neodatis.odb.ClassRepresentation;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 20, 2018 8:40:28 PM
 */
public class ClassRoomService implements Serializable {

    private ODB database;
    private Connection connection;

    public ClassRoomService() {
        this.connection = new Connection();
        this.database = connection.getConnection();
    }

    public void persist(ClassRoom classRoom) {
        database.store(classRoom);
    }

    public List<ClassRoom> findClassRoomByDiscipline(String discipline) {
        List<ClassRoom> list = new ArrayList<>();
        IQuery query = new CriteriaQuery(ClassRoom.class, Where.equal("discipline", discipline));
        Objects<ClassRoom> classRoomIterable = database.getObjects(query);
        while (classRoomIterable.hasNext()) {
            ClassRoom classRoom = classRoomIterable.next();
            list.add(classRoom);
        }
        return list;
    }

    public List<ClassRoom> findClassRoomByNameOfProfessor(String name) {
        List<ClassRoom> list = new ArrayList<>();
        IQuery query = new CriteriaQuery(ClassRoom.class, Where.equal("professor.name", name));
        Objects<ClassRoom> classRoomIterable = database.getObjects(query);
        while (classRoomIterable.hasNext()) {
            ClassRoom next = classRoomIterable.next();
            list.add(next);
        }
        return list;
    }

    public void createIndexInField(String field) {
        ClassRepresentation rep = database.getClassRepresentation(ClassRoom.class);
        String[] chaves = {field};
        rep.addUniqueIndexOn("index", chaves, true);
    }

}
