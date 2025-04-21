package com.example.room_rent.service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.room_rent.dtos.BookingResponseDto;
import com.example.room_rent.dtos.Roomdto;
import com.example.room_rent.dtos.SupportTicketDto;
import com.example.room_rent.dtos.Userdto;
import com.example.room_rent.enitity.Bookingentity;
import com.example.room_rent.enitity.Roomentity;
import com.example.room_rent.enitity.SupportTicketEntity;
import com.example.room_rent.enitity.Userentity;
import com.example.room_rent.repository.Userrepo;

@Service
public class Userservice {
    @Autowired
    private Userrepo urep;
    public String adduser(Userdto dt)
    {
        Userentity e=new Userentity();
        // if(urep.existsByEmail(dt.getEmail()))
        e.setName(dt.getName());
        e.setPhone(dt.getPhone());
        e.setEmail(dt.getEmail());
        e.setPassword(dt.getPassword());
        // return urep.save(e);
        if (urep.existsByEmail(e.getEmail())) {
            // return ResponseEntity.status(HttpStatus.CONFLICT)
            //         .body("Email already exists");
            return "Email exists";
        }
        // return ResponseEntity.status(HttpStatus.CREATED).body(urep.save(e));
        urep.save(e);
        return "added";
    
    }    
    public List<Userdto> getall()
    {
        List<Userentity> entity=urep.findAll();
        return entity.stream().map(user->{
            List<Roomentity> urooms=user.getRooms();
            List<Roomdto> sample=urooms.stream().map(room->{
                 return new Roomdto(room.getRoomid(), room.getRoomtype(), room.getLocation(), room.getPrice(), room.getIsac(), room.getDescription(), room.getAvailability(), room.getMaxoccupancy());
            }).collect(Collectors.toList());
            List<SupportTicketEntity> tickets=user.getTickets();
            List<SupportTicketDto> ticket=tickets.stream().map(tic ->{
                return new SupportTicketDto(tic.gettId(),tic.getSubject(),tic.getIssueInDetail(),tic.getStatus(),tic.getDatetime());
            }).collect(Collectors.toList());
            List<Bookingentity> booking=user.getBookings();
            List<BookingResponseDto> res=booking.stream().map
            ( book->{
                Roomentity room=book.getRoom();
                Roomdto dto=new Roomdto(room.getRoomid(),room.getRoomtype(),room.getLocation(),room.getPrice(),room.getIsac(),room.getDescription(),room.getAvailability(),room.getMaxoccupancy());
                return new BookingResponseDto(book.getBooking_date(), book.getBookingid(), 0, 0, book.getStartdate(), book.getEnddate(), book.getStatus(), null,dto);
            }).collect(Collectors.toList());
            return new Userdto(user.getUserid(), user.getName(), user.getPhone(), user.getEmail(), user.getPassword(),sample,ticket,res);
        }).collect(Collectors.toList());
    }
    public Userdto gettingbyid(Integer id)
    {
        Optional<Userentity> uen=urep.findById(id);
        if(uen.isPresent())
        {   
            Userentity data=uen.get();
            List<SupportTicketEntity> utickets=data.getTickets();
            List<Roomentity> urooms=data.getRooms();
            List<Bookingentity> booking=data.getBookings();
            List<BookingResponseDto> res=booking.stream().map
            ( book->{
                Roomentity room=book.getRoom();
                Roomdto dto=new Roomdto(room.getRoomid(),room.getRoomtype(),room.getLocation(),room.getPrice(),room.getIsac(),room.getDescription(),room.getAvailability(),room.getMaxoccupancy());
                return new BookingResponseDto(book.getBooking_date(), book.getBookingid(), 0, 0, book.getStartdate(), book.getEnddate(), book.getStatus(), null,dto);
            }).collect(Collectors.toList());
            List<Roomdto> sample=urooms.stream().map(room->{
                return new Roomdto(room.getRoomid(),room.getRoomtype(), room.getLocation(), room.getPrice(), room.getIsac(), room.getDescription(), room.getAvailability(), room.getMaxoccupancy());
            }).collect(Collectors.toList());
            List<SupportTicketDto> sample1=utickets.stream().map(ticket->{
                return new SupportTicketDto(ticket.gettId(),ticket.getSubject(), ticket.getIssueInDetail(), ticket.getStatus(), ticket.getDatetime());
            }).collect(Collectors.toList());
            
            return new Userdto(id, data.getName(), data.getPhone(), data.getEmail(), data.getPassword(),sample,sample1,res);
        }
        return new Userdto(id, null, null, null, null);
    }
    public String update(Integer id,Userdto value)
    {
        Optional<Userentity> derivedvalue=urep.findById(id);
        if(derivedvalue.isPresent())
        {
            Userentity user=derivedvalue.get();
            if(value.getEmail()!=null)
                user.setEmail(value.getEmail());
            if(value.getName()!=null)
                user.setName(value.getName());
            if(value.getPassword()!=null)
                user.setPassword(value.getPassword());
            if(value.getPhone()!=null)
                user.setPhone(value.getPhone());
            urep.save(user);
            return "updated";
        }
        return "not updated";
    }
    public String delete(Integer id)
    {
        try{
            urep.deleteById(id);
            return "deleted";
        }
        catch(Error e)
        {
            return "error";
        }
    }
}

