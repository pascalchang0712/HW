package com.database;
import java.sql.*;

public class Database{
  private Connection con=null;
  private ResultSet rs=null;
  private Statement stmt=null;
  private String ip="";
  private String port="";
  private String url="";
  private String db="";
  private String user="";
  private String password="";
  private String driver="com.mysql.jdbc.Driver";

  public Database(){}

  public void connectDB(){
    try{
      url="jdbc:mysql://"+ip+":"+port+"/"+db+"?useUnicode=true&characterEncoding=utf-8";
      Class.forName(driver);
      con=DriverManager.getConnection(url,user,password);
      stmt=con.createStatement();

    }catch(Exception ex){
      System.out.println(ex);
    }
  }
  public void query(String sql){
    try{
      rs=stmt.executeQuery(sql);
    }catch(Exception ex){
      System.out.println(ex);
    }
  }
  public void insertData(String userid,String userpass,String name,String birthday,String memo){
    try{
      String sql="insert into userdata (userid,userpass,name,birthday,memo) values ('"+userid+"','"+userpass+"','"+name+"','"+birthday+"','"+memo+"')";
      stmt.executeUpdate(sql);


    }catch(Exception ex){
      System.out.println(ex);
    }

  }
  public void editData(String userid,String userpass,String name,String birthday,String memo){
    try{
      String sql="update userdata set userpass= '"+name+"',name= '"+birthday+"',birthday= '"+memo+"' where userid='"+userid+"'";
      int a=stmt.executeUpdate(sql);
    }catch(Exception ex){
      System.out.println(ex);
    }
  }


public void deleteData(String id){
  try{
    String sql="delete from tra_intro where id ="+id+";";
    int a=stmt.executeUpdate(sql);
  }catch(Exception ex){
    System.out.println(ex);
  }
}

  public Connection getCon(){
    return con;
    }

  public ResultSet getRS(){
    return rs;
  }

  public void setIp(String ip){
    this.ip=ip;
  }

  public void setPort(String port){
    this.port=port;
  }

  public void setUrl(String ip,String port){
    this.url="jdbc:mysql://"+ ip +":"+ port +"/";
  }

  public void setDb(String dbName){
    this.db=dbName;
  }

  public void setUser(String username){
    this.user=username;
  }

  public void setPassword(String password){
    this.password=password;
  }

  public void setDriver(String driver){
    this.driver=driver;
  }


}
