package fr.mrgeekk.event.teams;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.mrgeekk.event.dbmanager;

public class points {
	
	public void setpoint (String player, int point) {
		
		try {
			PreparedStatement sts = dbmanager.getConnection().prepareStatement("UPDATE ngrunner SET point = ? WHERE pseudo = ?");
			sts.setInt(1, point);
			sts.setString(2, player);
			
			sts.executeUpdate();
			
			sts.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getpoint (String player) {
		try {
			PreparedStatement sts = dbmanager.getConnection().prepareStatement("SELECT * FROM ngrunner WHERE pseudo = ?");
			sts.setString(1, player);
			
			ResultSet rs = sts.executeQuery();
			
			int point = 0;
			
			if(rs.next()) {
				point = rs.getInt("point");
			}
			
			return point;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean exist (String player) {
		
		try {
			PreparedStatement sts = dbmanager.getConnection().prepareStatement("SELECT * FROM ngrunner WHERE pseudo = ?");
			sts.setString(1, player);
			
			ResultSet rs = sts.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int getteampoint(String team) {
		
		PreparedStatement sts;
		try {
			sts = dbmanager.getConnection().prepareStatement("SELECT * FROM ngrunner WHERE team = ?");
			sts.setString(1, team);

			ResultSet rs = sts.executeQuery();
			
			int tpoint = 0;
			while(rs.next()) {
				tpoint = tpoint + rs.getInt("point");
			}
			return tpoint;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
