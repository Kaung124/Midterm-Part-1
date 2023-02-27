public class ProfileManager {

  private DictionaryInterface<String, Profile> profileList;

  public ProfileManager() {
    profileList = new HashedDictionary<>();
  }

  // Creating a profile
  public boolean createProfile (String userName, String email, String password) {

    // Check if the user-name is taken
    if (profileList.contains(userName) {
      System.out.println("Profile with username " + userName + " already exists.");
      return false;
    }
    // create the profile if the userName is available
    else {
      Profile profile = new Profile(String userName, String email, String password);
      profileList.add(userName, profile);
      System.out.println("Profile created successfully.");
      return true;
    }
    
  } // end createProfile

  // Login function
  public Profile login(String userName, String password) {

    // check if the profile exists
    if (profileList.contains(userName)) {
      Profile profile = profileList.getValue(userName); // get profile from the profile list

      // check Password
      if (profile.getPassword().equals(password)) {
        System.out.println("You have successfully log in");
        return profile;
      }
      else {
        System.out.println("Your username or password does not match.");
      }
    }
    else {
      System.out.println("Username not found.");
    }
  } // end Login function

  // Delete Profile function
  public boolean deleteProfiel(String userName) {
    Profile profile = profileList.remove(userName);
    if (profile == null) {
      return false;
    }
    else {
      // Remove the deleted profiel from all friend lists
      Iterator<String> iterator = profileList.getKeyIterator();
      while (iterator.hasNext()) {
        String key = iterator.next();
        Profile friend = profileList.getValue(key);
        if (friend.getFriendList().contains(userName)) {
          friend.removeFriend(userName);
        }
      }
      return true;
    }
  }
  
}