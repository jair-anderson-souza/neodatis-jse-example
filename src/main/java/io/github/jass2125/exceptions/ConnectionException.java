/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.exceptions;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 21, 2018 2:42:09 PM
 */
public class ConnectionException extends RuntimeException {

    public ConnectionException(Exception e, String msg) {
        super(msg, e);
    }

}
