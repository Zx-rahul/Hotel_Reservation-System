import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteReservation {
    static void deleteReservation(Statement statement, Scanner scanner) {
        System.out.print("Enter reservation ID to delete: ");
        int reservationId = scanner.nextInt();

        if (!ReservationExists.reservationExists(statement, reservationId)) {
            System.out.println("Reservation not found for the given ID.");
            return;
        }


        String sql = "DELETE FROM reservations WHERE reservation_id = " + reservationId;

        try {
            int affectedRows = statement.executeUpdate(sql);

            if (affectedRows > 0) {
                System.out.println("Reservation deleted successfully!");
            } else {
                System.out.println("Reservation deletion failed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}