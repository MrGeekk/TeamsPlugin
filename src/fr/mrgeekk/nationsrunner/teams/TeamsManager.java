package fr.mrgeekk.nationsrunner.teams;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.mrgeekk.nationsrunner.dbmanager;

public class TeamsManager {
	
	public void addplayertoteam(String pseudo, String team) {
		
		try {
			PreparedStatement sts = dbmanager.getConnection().prepareStatement("INSERT INTO ngrunner (pseudo, team, point) VALUES (?, ?, ?)");
			sts.setString(1, pseudo);
			sts.setString(2, team);
			sts.setInt(3, 0);
			
			sts.executeUpdate();
			
			sts.close();
			System.out.println("Insertion de " + pseudo + " dans " + team);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean playerhasteam(String pseudo) {
		
		PreparedStatement sts;
		try {
			sts = dbmanager.getConnection().prepareStatement("SELECT * FROM ngrunner WHERE pseudo = ?");			
			sts.setString(1, pseudo);

			ResultSet rs = sts.executeQuery();
			
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getplayerteam(String pseudo) {
		
		try {
			PreparedStatement sts = dbmanager.getConnection().prepareStatement("SELECT * FROM ngrunner WHERE pseudo = ?");
			sts.setString(1, pseudo);
			
			ResultSet rs = sts.executeQuery();
			
			String team = "";
			if(rs.next()) {
				team = rs.getString("team");
			}
			
			sts.close();
			return team;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Aucune équipe";
	}
	
	public void removeplayertoteam(String pseudo) {
		
		try {
			PreparedStatement sts = dbmanager.getConnection().prepareStatement("DELETE FROM ngrunner WHERE pseudo = ?");
			sts.setString(1, pseudo);
			
			sts.executeUpdate();
			
			sts.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getteams() {
		
		try {
			PreparedStatement sts = dbmanager.getConnection().prepareStatement("SELECT * FROM ngrunner");
			
			ResultSet rs = sts.executeQuery();
			
			String teams = "";
			
			while(rs.next()) {
				if(!teams.contains(rs.getString("team"))) {
					teams = teams+","+rs.getString("team");
				}
			}
			return teams;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Aucune équipe";
	}
	
	public String getteam(String team) {
		try {
			PreparedStatement sts = dbmanager.getConnection().prepareStatement("SELECT * FROM ngrunner WHERE team = ?");
			sts.setString(1, team);
			
			ResultSet rs = sts.executeQuery();
			
			String teamcontent = "";
			
			while(rs.next()) {
				
				teamcontent = teamcontent + ","+rs.getString("pseudo");
			}
			return teamcontent;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Aucune équipe";
	}
}
