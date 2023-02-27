public class Profile {

  private String userName;
  private int userId;
  private String email;
  private String password;
  private String status;
  private int numberOfFriends;
  private ListInterface<Profile> friendList;

  // Constructor
  public Profile(String userName, int userId, String email, String password) {
    this.userName = userName;
    this.userId = userId;
    this.email = email;
    this.password = password;
    this.status = "Online";
    this.numberOfFriend = 0;
    this.friendList = new LList<>();
  } // end Constructor

  // Setters
  public void setUserName(String userName) {
    this.userName = userName;
  } // end setUserName

  public void setUserId(int userId) {
    this.userId = userId;
  } // end setUserID

  public void setEmail(String email) {
    this.email = email;
  } // end setEmail

  public void setPassword(String password) {
    this.password = password;
  } // end setPassword
  
  public void setStatus(String status) {
    this.status = status; 
  } // end setStatus
  
  //end Setters
  
  // Getters
  public String getUserName() {
    return userName;
  } // end getUserName 

  public int getUserID() {
    return userId;
  } // end userID

  public String getEmail() {
    return email;
  } // end getEmail

  public String getPassword() {
    return password;
  } // end getPassword
  
  public String getStatus() {
    return status;
  } // end getStatus

  public int getNumberOfFriends() {
    return numberOfFriends;
  } // end numberOfFriends

  public ListInterface<Profile> getFriendsList() {
    return friendList;
  } // end getFriendsList
  // end Getters

  // Add friend
  public void addFriend(Profile friend) {

    // Checking if new friend is already in the friend list
    if (!friendList.contains(friend)) {
      friendList.add(friend);
      System.out.println(friend.getUserName() + "has been added to your friend list!");
    }
    else {
      System.out.println(friend.getUserName() + " is already in your friend list.");
    }
    
    numberOfFriends++;
  } // end addFriend
  
  // Remove friend from the friend
  pubic void removeFriend(Profile friend) {
    int i = 0;
    boolean found = false;
    while ((i < numberOfFriends) && (found)) {
      if (friendList.contains(friend)) {
        friendList.remove(i);
        System.out.println(friend.getUserName() + " has been removed from your friend list.");
        found = true;
      }// end if
    }// end while

    if (!found) 
      System.out.println(friend.getUserName() + " is not in your friend list."); 
  }// end removeFriend

    // Delete profile
  public deleteProfile(String userName) {
    this.userName = null;
    this.email = null;
    this.password = null;
    this.status = null;
    this.friendList = null;
  }// end DeleteProfile
  
} // end Profile class

