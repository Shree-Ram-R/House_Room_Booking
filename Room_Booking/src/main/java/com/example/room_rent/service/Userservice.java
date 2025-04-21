package com.example.room_rent.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.room_rent.dtos.Roomdto;
import com.example.room_rent.dtos.SupportTicketDto;

import com.example.room_rent.dtos.Userdto;
import com.example.room_rent.enitity.Roomentity;
import com.example.room_rent.enitity.SupportTicketEntity;
import com.example.room_rent.enitity.Userentity;
import com.example.room_rent.repository.Userrepo;

import jakarta.transaction.Transactional;

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
            return new Userdto(user.getUserid(), user.getName(), user.getPhone(), user.getEmail(), user.getPassword(),sample);
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
            List<Roomdto> sample=urooms.stream().map(room->{
                return new Roomdto(room.getRoomid(),room.getRoomtype(), room.getLocation(), room.getPrice(), room.getIsac(), room.getDescription(), room.getAvailability(), room.getMaxoccupancy());
            }).collect(Collectors.toList());
            List<SupportTicketDto> sample1=utickets.stream().map(ticket->{
                return new SupportTicketDto(ticket.gettId(),ticket.getSubject(), ticket.getIssueInDetail(), ticket.getStatus(), ticket.getDatetime());
            }).collect(Collectors.toList());
            
            return new Userdto(id, data.getName(), data.getPhone(), data.getEmail(), data.getPassword(),sample,sample1);
        }
        return new Userdto(id, null, null, null, null,null,null);
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(Userdto dto) {
        if (urep.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException ("User already exists");
        }
        if (urep.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Userentity user = new Userentity();
        Userdto usersecDto = new Userdto();
        usersecDto.setUsername(dto.getUsername());
        usersecDto.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        //user.setIsloggedin("false");
        urep.save(user);
        //.updateUserLoggedInStatus(dto.getUsername(), "false");
       // usersecDto.setIsLoggedIn("false");
        
        return "User registered successfully!";
    }
    @Transactional
    public int authenticate(String username, String password) {
        System.out.println("Authenticating user: " + username);
        Userentity user = urep.findByUsername(username).orElse(null);
        
        if (user == null) {
            System.out.println("Login failed - username not found: " + username);
            return -1;
        }
    
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Login failed - invalid password for user: " + username);
            return -1;
        }
        //user.setIsloggedin("true");

        //urep.updateUserLoggedInStatus(username, "false");
        return user.getUserid();
    }
    // public List<UserSecureDto> getAll() {
    //     return urep.allUsers();
    // }
}

