package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import util.Connector;

public class NumValDao {

	public boolean addNum(String no){
		Connector connector = new Connector();
		Connection conn = connector.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String select = "select id from ticket where no = '" + no + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select);
			
			long flag = 0l;
			while (rs.next()) {
				flag++;
            }
			
			//如果记录存在，返回
			if(flag!=0){
				System.out.println("已经存在当前数据:"+no);
				return false; 
			}
			
			Date date =new java.sql.Date(new java.util.Date().getTime());
			String insert = "insert into ticket (no,date,id) values ('"+no+"','"+date+"','"+UUID.randomUUID().toString()+"')";
			int result = stmt.executeUpdate(insert);
			if(result!=-1){
				System.out.println("数据创建成功");
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false; 
		} finally{
			try {
				conn.close();
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false; 
			}
		}
		
		return false;
	}
	
	
}
