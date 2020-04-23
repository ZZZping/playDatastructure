package com.ddb.steiner;

import java.sql.*;

import javax.swing.JOptionPane;

public class connection {

    Connection con = null;

    connection()
    {
    }

    public Connection getConnection(String ur,String pw)
    {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/dblp?user="+ur+"&password="+pw+"&useSSL="+ false + "&serverTimezone="+ "UTC" ;
        System.out.println(ur+pw);
        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL);
            //System.out.println("����DBLP���ݿ�ɹ�");
            return con;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "δ�ܳɹ��������ݿ� ",
                    "��ʾ",JOptionPane.ERROR_MESSAGE);
            System.out.println("Unable to get connection!");

            return null;
        }
    }

    ResultSet getResultSet(String sql)
    {
        ResultSet rt = null;
        if(con == null)
        {
            return null;
        }else{
            try{
                Statement st = con.createStatement();
                rt = st.executeQuery(sql);
                return rt;
            }catch(Exception e){

                System.out.println(e);
            }



        }

        return null;

    }


}

