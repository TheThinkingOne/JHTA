package com.leekiye.jspmodel2.controller.member;

import org.mindrot.jbcrypt.BCrypt;

public class TestBoard {
    public static void main(String[] args) {
        String salt = BCrypt.gensalt();
        String hashedPwd = BCrypt.hashpw("123456", salt);

        System.out.println(hashedPwd);
    }
}
