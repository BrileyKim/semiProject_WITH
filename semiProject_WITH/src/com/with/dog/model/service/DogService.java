package com.with.dog.model.service;

import static com.with.common.JDBCTemplate.commit;
import static com.with.common.JDBCTemplate.getConnection;
import static com.with.common.JDBCTemplate.rollback;
import static com.with.common.JDBCTemplate.close;
import java.sql.Connection;

import com.with.dog.model.dao.DogDao;
import com.with.dog.model.vo.Dog;

public class DogService {
	
	private DogDao dao = new DogDao();
	
	public int insertDog(Dog d) {
		Connection conn = getConnection();
		int result = dao.insertDog(conn,d);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	public Dog selectDogOne(String id) {
		Connection conn = getConnection();
		Dog d = dao.selectDogOne(conn,id);
		close(conn);
		return d;
	}
}
