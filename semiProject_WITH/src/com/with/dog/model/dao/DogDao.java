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
			pstmt.setString(4, d.getDogBreed1());
			pstmt.setString(5, d.getDogBreed2());
			pstmt.setDouble(6, d.getDogWeight());
			pstmt.setString(7, d.getDogBirth());
			pstmt.setString(8, d.getDogNeuter());
			pstmt.setString(9, d.getDogProfile());
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
				d.setDogBreed1(rs.getString("dog_breed1"));
				d.setDogBreed2(rs.getString("dog_breed2"));
				d.setDogWeight(rs.getDouble("dog_weight"));
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
	
	public int updateDog(Connection conn, Dog d) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			if(d.getDogProfile()==null) {
				pstmt = conn.prepareStatement(prop.getProperty("updateDogNull"));
				pstmt.setString(1, d.getDogName());
				pstmt.setString(2, d.getDogGender());
				pstmt.setString(3, d.getDogBreed1());
				pstmt.setString(4, d.getDogBreed2());
				pstmt.setDouble(5, d.getDogWeight());
				pstmt.setString(6, d.getDogBirth());
				pstmt.setString(7, d.getDogNeuter());
				pstmt.setString(8, d.getDogOwner());
			}else {
				pstmt = conn.prepareStatement(prop.getProperty("updateDog"));
				pstmt.setString(1, d.getDogName());
				pstmt.setString(2, d.getDogGender());
				pstmt.setString(3, d.getDogBreed1());
				pstmt.setString(4, d.getDogBreed2());
				pstmt.setDouble(5, d.getDogWeight());
				pstmt.setString(6, d.getDogBirth());
				pstmt.setString(7, d.getDogNeuter());
				pstmt.setString(8, d.getDogProfile());
				pstmt.setString(9, d.getDogOwner());
			}	
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
}
