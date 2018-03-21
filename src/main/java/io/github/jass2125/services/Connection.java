/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.services;

import io.github.jass2125.exceptions.ConnectionException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 20, 2018 8:35:19 PM
 */
public class Connection {

    private final String fileName;
    private final String username;
    private final String password;

    public Connection(String fileName, String username, String password) {
        this.fileName = fileName;
        this.username = username;
        this.password = password;
    }

    public ODB getConnection() {
        try {
            return ODBFactory.open(fileName, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConnectionException(e, "Connection refused");
        }
    }
}
