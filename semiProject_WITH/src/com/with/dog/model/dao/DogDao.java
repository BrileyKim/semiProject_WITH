package com.with.dog.model.dao;

import static com.with.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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
			pstmt.setString(7, d.getDogProfile());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Dog selectDogOne(Connection conn,String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dog d = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectDogOne"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				d = new Dog();
				d.setDogIdx(rs.getInt("dog_idx"));
				d.setDogOwner(rs.getString("dog_owner"));
				d.setDogName(rs.getString("dog_name"));
				d.setDogGender(rs.getString("dog_gender"));
				d.setDogBreed(rs.getString("dog_breed"));
				d.setDogBirth(rs.getString("dog_birth"));
				d.setDogNeuter(rs.getString("dog_neuter"));
				d.setDogStatus(rs.getString("dog_status"));
				d.setDogProfile(rs.getString("dog_profile"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return d;
	}
	
}
