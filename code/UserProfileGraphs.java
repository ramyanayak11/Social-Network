
/* Ramya Nayak
 * 03/25/2023  
 */

import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class UserProfileGraphs {

	private String username;
	private String status;
	private int birthYear;
	private String country;
	private String favoriteColor;
	private String photoFilePath = null;
	private File photoFile;
	private BufferedImage photo;
	private DirectedGraph<String> friends = new DirectedGraph<>();

	// ------------------------------------------------ 
	
	public UserProfileGraphs (String name) {
		username = name;
		friends.addVertex(username);
	}

	// ------------------------------------------------
	
	public void setUsername (String name) {
		username = name;
	}

	// ------------------------------------------------
	
	public String getUsername () {
		return username;
	}

	// ------------------------------------------------

	public void setStatus (String userStatus) {
		status = userStatus;
	}

	// ------------------------------------------------
	
	public String getStatus () {
		return status;
	}

	// ------------------------------------------------
	
	public void setBirthYear (int year) {
		birthYear = year;
	}

	// ------------------------------------------------
	
	public int getBirthYear () {
		return birthYear;
	}

	// ------------------------------------------------

	public void setCountry (String country) {
		this.country = country;
	}

	// ------------------------------------------------
	
	public String getCountry () {
		return country;
	}

	// ------------------------------------------------

	public void setFavColor (String color) {
		favoriteColor = color;
	}

	// ------------------------------------------------
	
	public String getFavColor () {
		return favoriteColor;
	}

	// ------------------------------------------------

	public void setProfilePicture (String profilePic) {
		int width = 963;
		int height = 640;
		photoFilePath = profilePic;
		
		try {
			photoFile = new File(photoFilePath);
			photo = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			photo = ImageIO.read(photoFile);
			System.out.println("The photo file was successfully read!");
			System.out.println("Profile picture was succesfully changed!");
		}
		catch (IOException exc) {
			System.out.println("There was an error: " + exc);
		}
	}

	// ------------------------------------------------
	
	public void getProfilePicture () {
		try {
			photoFile = new File(photoFilePath);
			ImageIO.write(photo, "jpg", photoFile);
		}
		catch (IOException exc) {
			System.out.println("There was an error: " + exc);
		}
	}

	// ------------------------------------------------
	
	protected void addANewFriend (String friend) {
		if (existing(friend) != true) {
			friends.addVertex(friend);
			friends.addEdge(username, friend);
			System.out.println(friend + " was successfully added as a friend! :))");
		}
		else {
			System.out.println(friend + " is already a friend.");
		}
	}
	
	// ------------------------------------------------
	
	protected void removeAFriend (String friend) {
		if (existing(friend) == true) {
			friends.removeEdge(username, friend);
			friends.removeVertex(friend);
			System.out.println(friend + " was successfully removed as a friend!");
		}
		else {
			System.out.println(friend + " was not on the friend list.");
		}
	}
	
	// ------------------------------------------------
	
	protected void removeAFriendAfterDeletion (String friend) {
		if (existing(friend) == true) {
			friends.removeEdge(username, friend);
			friends.removeVertex(friend);
		}
	}
	
	// ------------------------------------------------
	
	public boolean existing (String name) {
		boolean exists = false;
		
		if ((friends.hasEdge(username, name)) == true) {
			exists = true;
		}
		
		return exists;
	}
	
	// ------------------------------------------------
	
	public int numberOfFriends () {
		return (friends.getNumberOfEdges());
	}
	
	// ------------------------------------------------
	
	public void printProfile () { 
		
		if (photoFilePath == null) {
			System.out.println("--Profile picture: (This user currently does not have a profile picture)");
		}
		else {
			System.out.println("--Profile picture: (Please check your Downloads folder for the profile picture.)");
			getProfilePicture();
		}
		
		System.out.println("--Username: " + username); 
		System.out.println("--Status: " + status);
		System.out.println("--Birth year: " + birthYear);
		System.out.println("--Country: " + country);
		System.out.println("--Favorite color: " + favoriteColor);
		System.out.println("--List of friends: ");
		
		if (friends.getNumberOfEdges() == 0) {
			System.out.println("  There are currently no friends for this profile. ://");
		}
		else {
			friends.displayEdges();
		}
	}

	// ------------------------------------------------
	
	public void friendsList () {
		System.out.println("--List of friends for " + username + ": ");
	
		if (friends.getNumberOfEdges() == 0) {
			System.out.println("  There are currently no friends for this profile. ://");
		}
		else {
			friends.displayEdges();
		}
	}
	
	// ------------------------------------------------
	
}
