class ServiceOverdueException extends Exception {
    public ServiceOverdueException(String message) { super(message); }
}

class InvalidMileageException extends Exception {
    public InvalidMileageException(String message) { super(message); }
}

public class Problem6_VehicleMaintenance {

    public static void checkMaintenance(boolean isOverdue, int mileage) throws ServiceOverdueException, InvalidMileageException {
        if (mileage < 0) {
            throw new InvalidMileageException("Invalid mileage: " + mileage);
        }
        if (isOverdue) {
            throw new ServiceOverdueException("Vehicle service is overdue.");
        }
        System.out.println("Vehicle maintenance is up to date.");
    }

    public static void main(String[] args) {
        try {
            System.out.println("Checking Car 1 (Overdue, 50000 miles):");
            checkMaintenance(true, 50000);
        } catch (ServiceOverdueException | InvalidMileageException e) {
            System.out.println("Notification: " + e.getMessage());
        }

        try {
            System.out.println("Checking Car 2 (OK, -10 miles):");
            checkMaintenance(false, -10);
        } catch (ServiceOverdueException | InvalidMileageException e) {
            System.out.println("Notification: " + e.getMessage());
        }

        try {
            System.out.println("Checking Car 3 (OK, 25000 miles):");
            checkMaintenance(false, 25000);
        } catch (ServiceOverdueException | InvalidMileageException e) {
            System.out.println("Notification: " + e.getMessage());
        }
    }
}
