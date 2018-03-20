/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 20, 2018 8:35:19 PM
 */
public class Connection {

    public ODB getConnection() {
        return ODBFactory.open("exemplo.neodatis", "admin", "admin");
    }
}
