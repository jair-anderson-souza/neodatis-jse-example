/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 19, 2018 4:20:58 PM
 */
public class Student extends Person {

    private String codeStudent;

    public Student() {
    }

    public Student(String codeStudent, String cpf, String name, int age) {
        super(cpf, name, age);
        this.codeStudent = codeStudent;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    @Override
    public String toString() {
        return "Student{" + "codeStudent=" + codeStudent + '}';
    }

}
