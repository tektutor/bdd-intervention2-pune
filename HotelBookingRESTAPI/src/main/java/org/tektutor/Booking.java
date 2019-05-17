package org.tektutor;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {

    private int bookingId;
    private String guestName;
    private String roomNo;
    private String fromDate;
    private String toDate;

    public Booking() {

    }

    public void setBookingId( int id ) {
        this.bookingId = id;
    }

    public void setGuestName ( String guestName ) {
        this.guestName = guestName;
    }

    public void setRoomNo( String roomNo ) {
        this.roomNo = roomNo;
    }

    public void setFromDate( String fromDate ) {
        this.fromDate = fromDate;
    }

    public void setToDate( String toDate ) {
        this.toDate = toDate;
    }

    public int getId() {
        return bookingId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }


}