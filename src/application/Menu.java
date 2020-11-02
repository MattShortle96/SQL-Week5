package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.SportsDAO;
import entities.Sports;

public class Menu {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<String> options = Arrays.asList(
			"Display Sports", "Add Sports", "Delete Sports");
	
	private SportsDAO sportsDAO = new SportsDAO();
	
	public void start() {
		String select = "";
		
		do {
			printMenu();
			select = sc.nextLine();
			
			try {
				if(select.equals("1")) {
					displaySports();
				}else if(select.equals("2")) {
					addSports();
				}else if(select.equals("3")) {
					deleteSports();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press again.");
			sc.nextLine();
			
		}while(!select.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an option below: \n");
		
		for(int i=0; i < options.size(); i++) {
			System.out.println(i + 1 + ".) " + options.get(i));
		}
	}
	
	private void displaySports() throws SQLException {
		List<Sports> sports = sportsDAO.getSports();
		for(Sports sport : sports) {
			System.out.println(sport.getSport_id() + ": " + sport.getSport_name());
		}
		
	}
	
	private void addSports() throws SQLException{
		System.out.print("Enter a sport you want to add: ");
		String sportName = sc.nextLine();
		sportsDAO.addSport(sportName);
	}
	
	private void deleteSports() throws SQLException{
		System.out.print("Enter id of sport you want to delete: ");
		int id = Integer.parseInt(sc.nextLine());
		sportsDAO.deleteSportByID(id);
	}
	


}
