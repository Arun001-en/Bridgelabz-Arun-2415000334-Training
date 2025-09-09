import java.util.*;

public class generate_otp {
    public static String generateOTP() {
        int otp = (int)(100000 + Math.random() * 900000);
        return String.valueOf(otp);
    }

    public static void main(String[] args) {
        String[] otps = new String[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i+1) + ": " + otps[i]);
        }

        boolean unique = true;
        for (int i = 0; i < otps.length; i++) {
            for (int j = i+1; j < otps.length; j++) {
                if (otps[i].equals(otps[j])) {
                    unique = false;
                }
            }
        }
        System.out.println("Are all OTPs unique? " + unique);
    }
}
