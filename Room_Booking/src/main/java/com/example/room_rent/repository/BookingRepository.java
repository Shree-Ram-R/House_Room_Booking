package com.example.room_rent.repository;

import com.example.room_rent.enitity.Bookingentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookingentity,Integer> {
    @Query("SELECT b FROM Bookingentity b WHERE b.status = 'PENDING' AND b.createdAt <= :expirationThreshold")
    List<Bookingentity> findExpiredPendingBookings(@Param("expirationThreshold") LocalDateTime expirationThreshold);
    List<Bookingentity> findByroom_roomid(Integer id);
     @Query("SELECT b FROM Bookingentity b WHERE b.room.id = :roomId " +
            "AND b.status <> 'CANCELLED' " +
            "AND ((b.startdate <= :endDate AND b.enddate >= :startDate))")
    List<Bookingentity> findOverlappingBookings(
            @Param("roomId") int roomId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
