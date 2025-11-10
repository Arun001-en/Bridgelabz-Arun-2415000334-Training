class InvalidRatingException extends Exception {
    public InvalidRatingException(String message) { super(message); }
}

class EmptyReviewException extends Exception {
    public EmptyReviewException(String message) { super(message); }
}

public class Problem11_ProductReview {

    public static void submitReview(int rating, String comment) throws InvalidRatingException, EmptyReviewException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5.");
        }
        if (comment == null || comment.trim().isEmpty()) {
            throw new EmptyReviewException("Review comment cannot be empty.");
        }
        System.out.println("Review submitted! Rating: " + rating + ", Comment: " + comment);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Submitting review 1 (Invalid Rating):");
            submitReview(0, "Not good.");
        } catch (InvalidRatingException e) {
            System.out.println("Failed: " + e.getMessage());
        } catch (EmptyReviewException e) {
            System.out.println("Failed: " + e.getMessage());
        }

        try {
            System.out.println("Submitting review 2 (Empty Comment):");
            submitReview(4, "   ");
        } catch (InvalidRatingException e) {
            System.out.println("Failed: " + e.getMessage());
        } catch (EmptyReviewException e) {
            System.out.println("Failed: " + e.getMessage());
        }
        
        try {
            System.out.println("Submitting review 3 (Success):");
            submitReview(5, "Excellent product!");
        } catch (InvalidRatingException | EmptyReviewException e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }
}
