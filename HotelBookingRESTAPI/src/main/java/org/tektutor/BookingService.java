package org.tektutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;

public class BookingService {

    private ArrayList<Booking> listOfBookings;
    private Connection connection;
    private String sqlQuery;

    public BookingService() {
        connection = new DatabaseConnectionManager().getConnection();
        listOfBookings = new ArrayList<Booking>();

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

    }

    public ArrayList<Booking> getAllBookings() {
        return listOfBookings;        
    }

}
