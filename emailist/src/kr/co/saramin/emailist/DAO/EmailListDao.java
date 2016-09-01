package kr.co.saramin.emailist.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.saramin.emailist.VO.emaillistVO;

public class EmailListDao {
	public void insert(emaillistVO vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1 Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			String url  = "jdbc:mysql://localhost/webdb";
			// 2 get connection 
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3 create statement
			String sql = 
					"insert into emaillist values(null, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			
			// 4 execute sql
			pstmt.setString(1,  vo.getFirstName());
			pstmt.setString(2,  vo.getLastName());
			pstmt.setString(3,  vo.getEmail());
			
			pstmt.executeUpdate();
			
			// 5 restore result 
			
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Driver Loading Fail");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("error = " + ex);
			
		}finally{
			try{
				
				pstmt.close();
				conn.close();
				
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	public List getList(){
		List list = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1 Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			String url  = "jdbc:mysql://localhost/webdb";
			// 2 get connection 
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3 create statement
			stmt = conn.createStatement();
			
			// 4 execute sql
			String sql = "select * from emaillist";
			rs = stmt.executeQuery(sql);
			
			// 5 restore result 
			while (rs.next()) {
				Long no = rs.getLong( 1 );
				String firstName = rs.getString( 2 );
				String lastName = rs.getString( 3 );
				String email = rs.getString( 4 );
				
				emaillistVO vo = new emaillistVO();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				list.add(vo);
			}
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Driver Loading Fail");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("error = " + ex);
			
		}finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
				
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			
		}
		
		return list;
	}

}
