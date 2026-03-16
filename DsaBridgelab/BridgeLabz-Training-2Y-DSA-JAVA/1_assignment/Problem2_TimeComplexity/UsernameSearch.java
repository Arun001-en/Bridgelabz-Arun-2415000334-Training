import java.util.Arrays;
import java.util.HashSet;

public class UsernameSearch {
    public static void main(String[] args) {
        String[] userList = {"alice", "bob", "charlie", "david", "eve"};
        String target = "charlie";

        System.out.println("Linear Search: " + linearSearch(userList, target));
        
        // Sort for binary search
        Arrays.sort(userList);
        System.out.println("Binary Search: " + binarySearch(userList, target));
        
        // Hash Set
        HashSet<String> userSet = new HashSet<>(Arrays.asList(userList));
        System.out.println("Hash Search: " + hashSearch(userSet, target));
    }

    public static boolean linearSearch(String[] userList, String targetUsername) {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i].equals(targetUsername)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(String[] sortedUserList, String targetUsername) {
        int left = 0;
        int right = sortedUserList.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int res = sortedUserList[mid].compareTo(targetUsername);

            if (res == 0) {
                return true;
            } else if (res < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean hashSearch(HashSet<String> hashTable, String targetUsername) {
        return hashTable.contains(targetUsername);
    }
}
