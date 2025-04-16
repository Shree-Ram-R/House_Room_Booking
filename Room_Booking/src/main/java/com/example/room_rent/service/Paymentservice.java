package com.example.room_rent.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.room_rent.dtos.Paymentdto;
import com.example.room_rent.enitity.Bookingentity;
import com.example.room_rent.enitity.PaymentEntity;
import com.example.room_rent.repository.BookingRepository;
import com.example.room_rent.repository.Paymentrepo;

@Service
public class Paymentservice {
    @Autowired
    private Paymentrepo prepo;

    @Autowired
    private BookingRepository brepo;

    public Paymentdto createPayment(Paymentdto dto){
        Optional<Bookingentity> Bookingopt = brepo.findById(dto.getBookingId());
        if(!Bookingopt.isPresent()){
            throw new RuntimeException("Booking ID not found");
        }

        PaymentEntity entity = new PaymentEntity(
            Bookingopt.get(),
            dto.getAmount(),
            dto.getPaymentMethod(),
            dto.getPaymentStatus(),
            dto.getDate()
        );

        PaymentEntity saved = prepo.save(entity);

        return new Paymentdto(
            saved.getP_id(),
            saved.getBooking().getBookingid(),
            saved.getAmount(),
            saved.getPaymentMethod(),
            saved.getPaymentStatus(),
            saved.getDate()
        );
    }

    public List<Paymentdto> getAllPayments(){
        return prepo.findAll().stream()
            .map(payment -> new Paymentdto(
                payment.getP_id(),
                payment.getBooking().getBookingid(), 
                payment.getAmount(), 
                payment.getPaymentMethod(), 
                payment.getPaymentStatus(), 
                payment.getDate()
            ))
            .collect(Collectors.toList());
    }

    public Paymentdto getPaymentById(Integer id){
        PaymentEntity payment = prepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Payment not found"));
        
        return new Paymentdto(
            payment.getP_id(),
            payment.getBooking().getBookingid(),
            payment.getAmount(),
            payment.getPaymentMethod(),
            payment.getPaymentStatus(),
            payment.getDate()
        );
    }

    public void deletePayment(Integer id){
        if (!prepo.existsById(id)) {
            throw new RuntimeException("Payment not found");
        }
        prepo.deleteById(id);
    }
}
