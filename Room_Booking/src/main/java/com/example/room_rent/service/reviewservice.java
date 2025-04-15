package com.example.room_rent.service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.room_rent.dtos.reviewdto;
import com.example.room_rent.enitity.Bookingentity;
import com.example.room_rent.enitity.Roomentity;
import com.example.room_rent.enitity.reviewentity;
import com.example.room_rent.repository.BookingRepository;
import com.example.room_rent.repository.Roomrepo;
import com.example.room_rent.repository.reviewrepo;
@Service
public class reviewservice {
     // Assuming you have a ReviewRepository to handle review-related operations
     @Autowired
     private reviewrepo reviewrepo;
     // Assuming you have a RoomRepository to handle room-related operations
     @Autowired
     private Roomrepo roomrepo;
     // Assuming you have a BookingRepository to handle booking-related operations
     @Autowired
     private BookingRepository brepo;
     // Add methods to handle review-related operations here

     // add
     public reviewdto addReview(reviewdto dto) {
          Roomentity room = roomrepo.findById(dto.getRoomId())
              .orElseThrow(() -> new RuntimeException("Room not found"));
      
          Bookingentity book = brepo.findById(dto.getBookingId())
              .orElseThrow(() -> new RuntimeException("Booking not found"));
      
          reviewentity review = new reviewentity();
          review.setRating(dto.getRating());
          review.setComment(dto.getComment());
          review.setReviewDate(LocalDate.now()); // or use: dto.getLocalDate().toLocalDate()
          review.setBooking(book);
          review.setRoom(room);
      
          reviewentity savedReview = reviewrepo.save(review);
      
          return new reviewdto(
              savedReview.getRating(),
              savedReview.getComment(),
              savedReview.getBooking().getBookingid(),
              savedReview.getRoom().getRoomid(),
              savedReview.getrId(),
              savedReview.getReviewDate().atStartOfDay()
          );
      }
      // Get All reviews
public List<reviewdto> getAllReviews() {
     return reviewrepo.findAll().stream()
         .map(review -> new reviewdto(
                 review.getRating(),
                 review.getComment(),
                 review.getBooking().getBookingid(),
                 review.getRoom().getRoomid(),
                 review.getrId(),                 // Include review ID
                 review.getReviewDate().atStartOfDay() // Include review date
         ))
         .collect(Collectors.toList());
 }
 
 // Get reviews by roomId
 public List<reviewdto> getReviewsByRoomId(Integer roomId) {
     return reviewrepo.findByRoom_roomid(roomId).stream()
         .map(review -> new reviewdto(
                 review.getRating(),
                 review.getComment(),
                 review.getBooking().getBookingid(),
                 review.getRoom().getRoomid(),
                 review.getrId(),                   // Include review ID
                 review.getReviewDate().atStartOfDay() // Include review date
         ))
         .collect(Collectors.toList());
 }
 
     // delete
     public String deletereview(Integer id){
          reviewrepo.deleteById(id);
          return "Deleted successfully";
     }
     // update 
     public String update(Integer id,reviewdto dto){
          reviewentity rentity=reviewrepo.findById(id)
               .orElseThrow(()-> new RuntimeException("not found"));
          rentity.setRating(dto.getRating());
          rentity.setComment(dto.getComment());
          Roomentity room=roomrepo.findById(dto.getRoomId())
               .orElseThrow(()-> new RuntimeException("Room not found"));
          Bookingentity book=brepo.findById(dto.getBookingId())
               .orElseThrow(()->new RuntimeException("Booking not found"));
          rentity.setBooking(book);
          rentity.setRoom(room);
          reviewrepo.save(rentity);
          return "Successfully updated";
     }
}
