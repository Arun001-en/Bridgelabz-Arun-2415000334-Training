// Interface with static method
interface SecurityUtils {
    
    // Static method to check password strength
    static boolean isStrongPassword(String password) {
        // Password must be at least 8 characters
        if (password.length() < 8) return false;

        // Must contain at least one uppercase, one lowercase, one digit, and one special character
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}

// Main class to test
public class VV {
    public static void main(String[] args) {
        String[] passwords = {
            "Password123!",
            "weakpass",
            "Strong1",
            "My$ecurePass2025"
        };

        for (String pwd : passwords) {
            if (SecurityUtils.isStrongPassword(pwd)) {
                System.out.println(pwd + " -> Strong password");
            } else {
                System.out.println(pwd + " -> Weak password");
            }
        }
    }
}
