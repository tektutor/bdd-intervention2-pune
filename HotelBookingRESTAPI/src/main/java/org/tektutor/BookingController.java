package org.tektutor;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("bookings")
public class BookingController {

    private BookingService bookingService = new BookingService();

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("all")
    public ArrayList<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("{id}")
    public Booking getBookingById(@PathParam("id") int id) {
        return bookingService.getBookingById(id);
    }

}
