
/* Ramya Nayak
 * 03/25/2023  
 */

import java.io.*;
import java.util.*; 
import java.util.Scanner; 

public class Driver {  

	public static void main(String[] args) {  
		
		CRUD one = new CRUD();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome! What would you like to do?");
		displayMenu();
		int choice = in.nextInt();
		System.out.println();
		
		while (choice != 8) {
			if (choice == 1) {
				System.out.println("You chose - CREATE A NEW PROFILE");
				one.createNewProfile();
			}
			else if (choice == 2) {
				System.out.println("You chose - EDIT YOUR PROFILE");
				one.editProfile();
			}
			else if (choice == 3) {
				System.out.println("You chose - ADD A NEW FRIEND");
				one.addNewFriend();
			}
			else if (choice == 4) {
				System.out.println("You chose - REMOVE A FRIEND");
				one.removeAFriend();
			}
			else if (choice == 5) {
				System.out.println("You chose - SEARCH AND VIEW A PROFILE");
				one.searchAndViewAProfile();
			}
			else if (choice == 6) {
				System.out.println("You chose - SEE THE FRIENDS OF A FRIEND");
				one.friendsOfFriends();
			}
			else if (choice == 7) {
				System.out.println("You chose - DELETE YOUR PROFILE");
				one.deleteProfile();
			}
			else {
				System.out.println("---INVALID CHOICE---");
			}
			System.out.println();
			System.out.println("What would you like to do next?"); 
			displayMenu();
			choice = in.nextInt();
		}
		
		System.out.println("You chose - LOG OUT");
		System.out.println();
		System.out.println("Logging you out...");
		System.out.println("You have successfully logged out!");
	}
	
	// ------------------------------------------------
	
	private static void displayMenu () {
		System.out.println("1) Create a new profile");
		System.out.println("2) Edit your profile");
		System.out.println("3) Add a new friend");
		System.out.println("4) Remove a friend");
		System.out.println("5) Search and view a profile");
		System.out.println("6) See the friends of your friend");
		System.out.println("7) Delete your profile");
		System.out.println("8) Log out");
		System.out.println(); 
		System.out.println("Your choice: ");
	}

}

/* ------ SAMPLE OUTPUT ------

Welcome! What would you like to do?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
1

You chose - CREATE A NEW PROFILE

Enter a username (username is case-sensitive): 
ramya
Profile has been created!

What would you like to do next?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
1
You chose - CREATE A NEW PROFILE

Enter a username (username is case-sensitive): 
somebody
Profile has been created!

What would you like to do next?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
1
You chose - CREATE A NEW PROFILE

Enter a username (username is case-sensitive): 
anotherPerson
Profile has been created!

What would you like to do next?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
3
You chose - ADD A NEW FRIEND

Enter your username: 
ramya

Enter the username you wish to add as a friend: 
somebody
somebody was successfully added as a friend! :))

What would you like to do next?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
3
You chose - ADD A NEW FRIEND

Enter your username: 
somebody

Enter the username you wish to add as a friend: 
anotherPerson
anotherPerson was successfully added as a friend! :))

What would you like to do next?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
6
You chose - SEE THE FRIENDS OF A FRIEND

Enter your username: 
ramya

Enter the username of your friend, whose friends you wish to view: 
anotherPerson
anotherPerson is not on your friend list, you will not be able to see their friend list.

Enter the username of your friend, whose friends you wish to view: 
somebody

We found a match!
--List of friends for somebody: 
  anotherPerson

What would you like to do next?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
7
You chose - DELETE YOUR PROFILE

Enter the username of the profile you wish to delete: 
anotherPerson
User anotherPerson was successfully deleted!

What would you like to do next?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
6
You chose - SEE THE FRIENDS OF A FRIEND

Enter your username: 
somebody
There are currently no friends for this profile. ://

What would you like to do next?
1) Create a new profile
2) Edit your profile
3) Add a new friend
4) Remove a friend
5) Search and view a profile
6) See the friends of your friend
7) Delete your profile
8) Log out

Your choice: 
8
You chose - LOG OUT

Logging you out...
You have successfully logged out!

*/



