package com.yedam;

import java.sql.Connection;

import com.yedam.dao.DAO;

public class DbTest {
    public static void main(String[] args) {
        DAO dao = new DAO();
        Connection conn = dao.getConnect();
        if (conn == null) {
            System.out.println("DB 연결 실패! 설정을 확인하세요.");
        } else {
            System.out.println("DB 연결 성공!");
            dao.disConnect();
        }
    }
}
