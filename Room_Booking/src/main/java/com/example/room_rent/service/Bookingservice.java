package com.example.room_rent.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.room_rent.dtos.Bookingdto;
import com.example.room_rent.enitity.Bookingentity;
import com.example.room_rent.enitity.Roomentity;
import com.example.room_rent.enitity.Userentity;
import com.example.room_rent.repository.BookingRepository;
import com.example.room_rent.repository.Roomrepo;
import com.example.room_rent.repository.Userrepo;

@Service
public class Bookingservice {
    
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private Userrepo userrepo;

    @Autowired
    private Roomrepo roomrepo;


    public Bookingdto createBooking(Bookingdto bookingdto){
        Optional<Userentity> userOpt = userrepo.findById(bookingdto.getUserId());
        Optional<Roomentity> roomOpt = roomrepo.findById(bookingdto.getRoomId());

        if (userOpt.isPresent() && roomOpt.isPresent()) {
            Bookingentity booking = new Bookingentity(
                    null,
                    userOpt.get(),
                    roomOpt.get(),
                    bookingdto.getStartDate(),
                    bookingdto.getEndDate(),
                    bookingdto.getBookingDate(),
                    bookingdto.getStatus()
            );
            booking = bookingRepository.save(booking);
            return new Bookingdto(
                booking.getBookingId(),
                booking.getUser().getUserid(),
                booking.getRoom().getRoomid(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getBookingDate(),
                booking.getStatus()
            );
        } else {
            throw new RuntimeException("User or Room not found.");
        }
    }

    public List<Bookingdto> getAllBookings() {
        return bookingRepository.findAll().stream()
            .map(booking -> new Bookingdto(
                booking.getBookingId(),
                booking.getUser().getUserid(),
                booking.getRoom().getRoomid(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getBookingDate(),
                booking.getStatus()
            ))
            .collect(Collectors.toList());
    }

    public Bookingdto getBookingById(Integer id) {
        Bookingentity booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return new Bookingdto(
            booking.getBookingId(),
            booking.getUser().getUserid(),
            booking.getRoom().getRoomid(),
            booking.getStartDate(),
            booking.getEndDate(),
            booking.getBookingDate(),
            booking.getStatus()
        );
    }

    public void deleteBooking(Integer id){
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Booking not found for deletion");
        }
    }
}
