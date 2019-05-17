package org.tektutor;

import java.util.ArrayList;

public class BookingService {

    private ArrayList<Booking> listOfBookings;
    private Connection connection;
    private String sqlQuery;

    public BookingService() {
        listOfBookings = new ArrayList<Booking>();
    }

    public ArrayList<Booking> getAllBookings() {
        connection = new DatabaseConnectionManager().getConnection();
        sqlQuery = "select * from Booking";

        Booking booking = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet rs = statement.executeQuery();

            while ( rs.next() ) {
                booking = new Booking();

                booking.setBookingId(  rs.getInt(1) );
                booking.setGuestName( rs.getString(2) );
                booking.setRoomNo( rs.getString(3) );
                booking.setFromDate( rs.getString(4) );
                booking.setToDate( rs.getString(5) );

                listOfBookings.add( booking );

            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        return listOfBookings;
    }

}
