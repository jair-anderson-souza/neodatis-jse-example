/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.entity;

import java.math.BigDecimal;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 19, 2018 4:21:03 PM
 */
public class Professor extends Person {

    private BigDecimal salary;

    public Professor() {
    }

    public Professor(String cpf, String name, int age, BigDecimal salary) {
        super(cpf, name, age);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Professor{" + "salary=" + salary + '}';
    }

}
