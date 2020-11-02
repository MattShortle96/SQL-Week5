package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Sports;

public class SportsDAO {
	
	private Connection conn;
	private final String GET_SPORTS_QUERY = "SELECT * FROM sports";
	private final String CREATE_NEW_SPORT_QUERY = "INSERT INTO sports(name) VALUES(?)";
	private final String DELETE_SPORT_QUERY = "DELETE FROM sports WHERE id = ?";
	
	public SportsDAO() throws SQLException {
		conn = DBConn.getConnection(); 
	}
	
	public List<Sports> getSports() throws SQLException{
		PreparedStatement ps = conn.prepareStatement(GET_SPORTS_QUERY);
		ResultSet rs = ps.executeQuery();
		List<Sports> sports = new ArrayList<Sports>();
		while(rs.next()) {
			sports.add(populateSports(rs.getInt(1), rs.getString(2)));
		}
		
		return sports;
	}
	

	private Sports populateSports(int id, String name) throws SQLException{
		return new Sports(id, name);
	}

	public void addSport(String sportName) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(CREATE_NEW_SPORT_QUERY);
		ps.setString(1, sportName);
		ps.executeUpdate();
		
	}
	
	public void deleteSportByID(int id) throws SQLException{
		PreparedStatement ps = conn.prepareStatement(DELETE_SPORT_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	
	

}
