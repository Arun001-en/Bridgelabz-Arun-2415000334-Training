class FriendList {
    int userId;
    String name;
    int age;
    FriendList next;
    int[] friends;

    FriendList(int userId, String name, int age, int[] friends) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.next = null;
        this.friends = friends;
    }
}

class SocialMediaConnections {
    private FriendList head;

    public SocialMediaConnections() {
        head = null;
    }

    public void addUser(int userId, String name, int age, int[] friends) {
        FriendList newUser = new FriendList(userId, name, age, friends);
        if (head == null) {
            head = newUser;
            return;
        }
        FriendList current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newUser;
    }

    public boolean addFriendConnection(int userId1, int userId2) {
        FriendList user1 = findUser(userId1);
        FriendList user2 = findUser(userId2);
        if (user1 == null || user2 == null) return false;

        int[] newFriends1 = addFriendToArray(user1.friends, userId2);
        int[] newFriends2 = addFriendToArray(user2.friends, userId1);
        
        user1.friends = newFriends1;
        user2.friends = newFriends2;
        return true;
    }

    public boolean removeFriendConnection(int userId1, int userId2) {
        FriendList user1 = findUser(userId1);
        FriendList user2 = findUser(userId2);
        if (user1 == null || user2 == null) return false;

        user1.friends = removeFriendFromArray(user1.friends, userId2);
        user2.friends = removeFriendFromArray(user2.friends, userId1);
        return true;
    }

    public void findMutualFriends(int userId1, int userId2) {
        FriendList user1 = findUser(userId1);
        FriendList user2 = findUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.print("Mutual friends between " + userId1 + " and " + userId2 + ": ");
        boolean first = true;
        for (int f1 : user1.friends) {
            for (int f2 : user2.friends) {
                if (f1 == f2) {
                    if (!first) System.out.print(", ");
                    System.out.print(f1);
                    first = false;
                }
            }
        }
        System.out.println();
    }

    public void searchByName(String name) {
        FriendList current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                displayUser(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("User not found.");
        }
    }

    public void searchById(int userId) {
        FriendList user = findUser(userId);
        if (user != null) {
            displayUser(user);
        } else {
            System.out.println("User not found.");
        }
    }
    public void displayAllFriends() {
        FriendList current = head;
        while (current != null) {
            displayUser(current);
            current = current.next;
        }
    }
    public void countFriendsForEachUser() {
        FriendList current = head;
        while (current != null) {
            System.out.printf("User %d (%s): %d friends\n", 
                current.userId, current.name, current.friends.length);
            current = current.next;
        }
    }
    private FriendList findUser(int userId) {
        FriendList current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    private void displayUser(FriendList user) {
        System.out.printf("User ID: %d, Name: %s, Age: %d\nFriends: ", 
            user.userId, user.name, user.age);
        for (int i = 0; i < user.friends.length; i++) {
            System.out.print(user.friends[i]);
            if (i < user.friends.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
    private int[] addFriendToArray(int[] friends, int newFriend) {
        int[] newArray = new int[friends.length + 1];
        for (int i = 0; i < friends.length; i++) {
            newArray[i] = friends[i];
        }
        newArray[friends.length] = newFriend;
        return newArray;
    }

    private int[] removeFriendFromArray(int[] friends, int friendToRemove) {
        int count = 0;
        for (int f : friends) {
            if (f != friendToRemove) count++;
        }
        int[] newArray = new int[count];
        int index = 0;
        for (int f : friends) {
            if (f != friendToRemove) {
                newArray[index++] = f;
            }
        }
        return newArray;
    }
}
class Main {
    public static void main(String[] args) {
        SocialMediaConnections social = new SocialMediaConnections();
        
        social.addUser(1, "Alice", 25, new int[]{2, 3});
        social.addUser(2, "Bob", 30, new int[]{1, 4});
        social.addUser(3, "Charlie", 28, new int[]{1, 4});
        social.addUser(4, "Diana", 27, new int[]{2, 3});
        
        System.out.println("All users and friends:");
        social.displayAllFriends();
        
        social.countFriendsForEachUser();
        
        social.addFriendConnection(1, 4);
        System.out.println("\nAfter adding connection 1-4:");
        social.displayAllFriends();
        
        social.findMutualFriends(1, 2);
        social.findMutualFriends(2, 3);
        
        social.searchByName("Alice");
        social.searchById(3);
        
        social.removeFriendConnection(1, 4);
        System.out.println("\nAfter removing connection 1-4:");
        social.displayAllFriends();
    }
}
