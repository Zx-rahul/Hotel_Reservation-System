import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateReservation {
     static void updateReservation(Statement statement, Scanner scanner) {
         System.out.print("Enter reservation ID to update: ");
         int reservationId = scanner.nextInt();
         scanner.nextLine(); // Consume the newline character

         if (!ReservationExists.reservationExists(statement, reservationId)) {
             System.out.println("Reservation not found for the given ID.");
             return;
         }

         System.out.print("Enter new guest name: ");
         String newGuestName = scanner.nextLine();
         System.out.print("Enter new room number: ");
         int newRoomNumber = scanner.nextInt();
         System.out.print("Enter new contact number: ");
         String newContactNumber = scanner.next();

         String sql = "UPDATE reservations SET guest_name = '" + newGuestName + "', " +
                 "room_number = " + newRoomNumber + ", " +
                 "contact_number = '" + newContactNumber + "' " +
                 "WHERE reservation_id = " + reservationId;

         try  {
             int affectedRows = statement.executeUpdate(sql);

             if (affectedRows > 0) {
                 System.out.println("Reservation updated successfully!");
             } else {
                 System.out.println("Reservation update failed.");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}
