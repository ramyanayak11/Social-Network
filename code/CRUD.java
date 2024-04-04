
/* Ramya Nayak
 * 03/25/2023 
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class CRUD {

	private ArrayList<UserProfileGraphs> users;

	// ------ default constructor ------
	public CRUD () {
		users = new ArrayList();
	}
	
	// ------ creates a new profile ------
	public void createNewProfile () {
		Scanner in = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter a username (username is case-sensitive): ");
		String username = in.nextLine();
		
		if (existing(username) != true) {
			UserProfileGraphs profile = new UserProfileGraphs(username);
			
			users.add(profile);
			System.out.println("Profile has been created!");
		}
		else {
			System.out.println("A profile with this username already exists.");
		}
	}
	
	// ------ edits the user's profile ------
	public void editProfile () {
		System.out.println();
		if (users.isEmpty()) {
			System.out.println("There are currently no user profiles.");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the username of the profile you wish to edit: ");
		String name = in.nextLine();
		boolean exists = existing(name);
		
		while (exists != true) {
			System.out.println("A profile with this username does not exist.");
			System.out.println();
			System.out.println("Enter the username of the profile you wish to edit: ");
			name = in.nextLine();
			exists = existing(name);
		}
		
		System.out.println();
		System.out.println("Which of the following would you like to edit?");
		System.out.println("1 - Username");
		System.out.println("2 - Current status");
		System.out.println("3 - Birth year");
		System.out.println("4 - Country");
		System.out.println("5 - Favorite color");
		System.out.println("6 - Profile picture");
		System.out.println("Your choice: ");
		int edit = in.nextInt();
		System.out.println();
		
		if (edit == 1) {
			System.out.println("Enter a new username: ");
			String newName = in.next();
			users.get(getIndex(name)).setUsername(newName);
			System.out.println("Username was succesfully changed!");
		}
		else if (edit == 2) {
			System.out.println("Enter a new status (online, offline, busy, etc.): ");
			String newStatus = in.next();
			users.get(getIndex(name)).setStatus(newStatus);
			System.out.println("Current status was succesfully changed!");
		}
		else if (edit == 3) {
			System.out.println("Enter a new birth year: ");
			int newYear = in.nextInt();
			users.get(getIndex(name)).setBirthYear(newYear);
			System.out.println("Birth year was succesfully changed!");
		}
		else if (edit == 4) {
			System.out.println("Enter a new country: ");
			String newCountry = in.next();
			users.get(getIndex(name)).setCountry(newCountry);
			System.out.println("Country was succesfully changed!");
		}
		else if (edit == 5) {
			System.out.println("Enter a new favorite color: ");
			String newColor = in.next();
			users.get(getIndex(name)).setFavColor(newColor);
			System.out.println("Favorite color was succesfully changed!");
		}
		else if (edit == 6) {
			
			System.out.println("Enter the filepath of your profile picture: ");
			String profilePicture = in.next();
			users.get(getIndex(name)).setProfilePicture(profilePicture);
		}
		else {
			System.out.println("---INVALID CHOICE---");
		}
	}
	
	// ------ adds a new friend to a user's friend list ------
	public void addNewFriend () {
		System.out.println();
		if (users.isEmpty()) {
			System.out.println("There are currently no user profiles.");
			return;
		}
		if (users.size() < 2) {
			System.out.println("There are currently no user profiles you can befriend. :((");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String name = in.nextLine();
		boolean exists = existing(name);
		
		while (exists != true) {
			System.out.println("A profile with this username does not exist.");
			System.out.println();
			System.out.println("Enter your username: ");
			name = in.nextLine();
			exists = existing(name);
		}
		
		System.out.println();
		System.out.println("Enter the username you wish to add as a friend: ");
		String friend = in.nextLine();
		exists = existing(friend);
		
		while (exists != true) {
			System.out.println("A profile with the given username does not exist.");
			System.out.println();
			System.out.println("Enter the username you wish to add as a friend: ");
			friend = in.nextLine();
			exists = existing(friend);
		}
		
		users.get(getIndex(name)).addANewFriend(friend);
	}
	
	// ------ deletes a friend from a user's friend list ------
	public void removeAFriend () {
		System.out.println();
		if (users.isEmpty()) {
			System.out.println("There are currently no user profiles.");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String name = in.nextLine();
		boolean exists = existing(name);
		
		while (exists != true) {
			System.out.println("A profile with this username does not exist.");
			System.out.println();
			System.out.println("Enter your username: ");
			name = in.nextLine();
			exists = existing(name);
		}
		
		if (users.get(getIndex(name)).numberOfFriends() == 0) {
			System.out.println("There are currently no friends for this profile. ://");
			return;
		}
		
		System.out.println();
		System.out.println("Enter the username you wish to remove as a friend: ");
		String friend = in.nextLine();
		exists = existing(friend);
		
		while (exists != true) {
			System.out.println("A profile with the given username does not exist.");
			System.out.println();
			System.out.println("Enter the username you wish to remove as a friend: ");
			friend = in.nextLine();
			exists = existing(friend);
		} 
		
		users.get(getIndex(name)).removeAFriend(friend);
	}
	
	// ------ searches and shows a profile and its attributes ------
	public void searchAndViewAProfile () {
		System.out.println();
		if (users.isEmpty()) {
			System.out.println("There are currently no user profiles.");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the username of the profile you wish to view: ");
		String name = in.nextLine();
		boolean exists = existing(name);
		
		while (exists != true) {
			System.out.println("A profile with this username does not exist.");
			System.out.println();
			System.out.println("Enter the username of the profile you wish to view: ");
			name = in.nextLine();
			exists = existing(name);
		}
		
		System.out.println();
		System.out.println("We found a match!");
		users.get(getIndex(name)).printProfile();
	}
	
	// ------ searches and shows the friends of a friend ------
	public void friendsOfFriends () {
		System.out.println();
		if (users.isEmpty()) {
			System.out.println("There are currently no user profiles.");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String name = in.nextLine();
		boolean exists = existing(name);
		
		while (exists != true) {
			System.out.println("A profile with this username does not exist.");
			System.out.println();
			System.out.println("Enter your username: ");
			name = in.nextLine();
			exists = existing(name);
		}
		
		if (users.get(getIndex(name)).numberOfFriends() == 0) {
			System.out.println("There are currently no friends for this profile. ://");
			return;
		}
		
		System.out.println();
		System.out.println("Enter the username of your friend, whose friends you wish to view: ");
		String friend = in.nextLine();
		exists = existing(friend);
		
		while (exists != true) {
			System.out.println("A profile with the given username does not exist.");
			System.out.println();
			System.out.println("Enter the username of your friend, whose friends you wish to view: ");
			friend = in.nextLine();
			exists = existing(friend);
		} 
		
		while (users.get(getIndex(name)).existing(friend) != true) {
			System.out.println(friend + " is not on your friend list, you will not be able to see their friend list.");
			System.out.println();
			System.out.println("Enter the username of your friend, whose friends you wish to view: ");
			friend = in.nextLine();
		}
		
		System.out.println();
		System.out.println("We found a match!");
		users.get(getIndex(friend)).friendsList();
	}
	
	// ------ deletes the user's profile ------
	public void deleteProfile () {
		System.out.println();
		if (users.isEmpty()) {
			System.out.println("There are currently no user profiles.");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the username of the profile you wish to delete: ");
		String name = in.nextLine();
		boolean exists = existing(name);
		
		while (exists != true) {
			System.out.println("A profile with this username does not exist.");
			System.out.println();
			System.out.println("Enter the username of the profile you wish to delete: ");
			name = in.nextLine();
			exists = existing(name);
		}
		
		users.remove(getIndex(name));
		
		for (int i = 0; i < users.size(); ++i) {
			if (users.get(getIndex(users.get(i).getUsername())).existing(name)) {
				users.get(getIndex(users.get(i).getUsername())).removeAFriendAfterDeletion(name);
			}
		}
		
		System.out.println("User " + name + " was successfully deleted!");
	}
	
	// ------ checks whether a profile with the given username exists ------	
	private boolean existing (String username) {
		boolean exists = false;
		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	// ------ gets user index ------
	private int getIndex (String username) {
		int index = 0;			
		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
}
