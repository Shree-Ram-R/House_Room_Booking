package com.example.room_rent.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;

import com.example.room_rent.dtos.BookingRequestDto;

import com.example.room_rent.enitity.Bookingentity;
import com.example.room_rent.enitity.Roomentity;
import com.example.room_rent.enitity.Userentity;
import com.example.room_rent.repository.BookingRepository;
import com.example.room_rent.repository.Roomrepo;
import com.example.room_rent.repository.Userrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private Userrepo userRepo;

    @Autowired
    private Roomrepo roomRepo;

    private static final long EXPIRATION_TIME_MINUTES = 1;

    @Transactional
    public String createBooking(BookingRequestDto dt){
        Optional<Userentity> optUser= userRepo.findById(dt.getUserId());
        //Optional<Roomentity> optRoom=roomRepo.findById(dt.getRoomId());
        if(optUser.isEmpty() ){
            return "Invalid User";
        }
        Roomentity room = roomRepo.findRoomForUpdate(dt.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (room.getAvailability() != null && !room.getAvailability()) {
            return "Room not available";
        }

        room.setAvailability(false);  // Mark the room as unavailable
        roomRepo.save(room);
        Userentity user=optUser.get();


        //Roomentity room=optRoom.get();

//        if(room.getAvailability()!=null || !room.getAvailability() ){
//            return "Not Available for booking";
//        }

        Bookingentity booking=new Bookingentity();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setStatus("PENDING");
        booking.setBooking_date(LocalDate.now());
        booking.setStartdate(dt.getStartDate());
        booking.setEnddate(dt.getEndDate());
        booking.setCreatedAt(LocalDateTime.now());
        bookingRepo.save(booking);
        return "Booking initiated with ID: " + booking.getBookingid() + ". Awaiting payment.";
    }

    public ResponseEntity<String> CancelBooking(int bookingId){
        Optional<Bookingentity> optBooking=bookingRepo.findById(bookingId);
        if(optBooking.isEmpty()){
            return new ResponseEntity<>("Booking not found",HttpStatus.NOT_FOUND);
        }

        Bookingentity booking=optBooking.get();
        booking.setStatus("CANCELLED");

        Roomentity room = booking.getRoom();
        room.setAvailability(true);  // Room is now available
        roomRepo.save(room);  // Save the updated room availability

        bookingRepo.save(booking);
        return ResponseEntity.ok("CANCELLED SUCCESSFULLY");

    }

    public ResponseEntity<String> confirmPayment(int bookingId, boolean payment){
        Optional<Bookingentity> optBooking=bookingRepo.findById(bookingId);
        if(optBooking.isEmpty()){
            return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
        }


        Bookingentity booking= optBooking.get();

        if(payment && booking.getStatus().equals("PENDING")){
            booking.setStatus("CONFIRMED");
            bookingRepo.save(booking);
            return ResponseEntity.ok("BOOKED SUCCESSFULLY");

        }

        booking.setStatus("FAILED");
        bookingRepo.save(booking);
        return ResponseEntity.badRequest().body("Booking failed");

    }

    public Bookingentity getBookingByID(int bookingId) {
        return bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking Not found"));
    }

    public List<Bookingentity> getAllBooking() {
        return bookingRepo.findAll();
    }



    @Scheduled(fixedRate = 30000) // every 1 minute
    public void checkExpiredBookings() {
        LocalDateTime expirationThreshold = LocalDateTime.now().minusMinutes(EXPIRATION_TIME_MINUTES);
        List<Bookingentity> expiredBookings = bookingRepo.findExpiredPendingBookings(expirationThreshold);

        for (Bookingentity booking : expiredBookings) {
            booking.setStatus("EXPIRED");

            Roomentity room = booking.getRoom();
            room.setAvailability(true);  // Room is now available
            roomRepo.save(room);  // Save the updated room availability

            bookingRepo.save(booking);
        }
    }



}
