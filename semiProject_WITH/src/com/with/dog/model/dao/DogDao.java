package com.with.dog.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import static com.with.common.JDBCTemplate.close;

import com.with.dog.model.vo.Dog;

public class DogDao {

	private Properties prop = new Properties();
	
	public DogDao() {
		try {
			String path = DogDao.class.getResource("/sql/dog/dog_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertDog(Connection conn, Dog d) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertDog"));
			pstmt.setString(1, d.getDogOwner());
			pstmt.setString(2, d.getDogName());
			pstmt.setString(3, d.getDogGender());
			pstmt.setString(4, d.getDogBreed());
			pstmt.setString(5, d.getDogBirth());
			pstmt.setString(6, d.getDogNeuter());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
