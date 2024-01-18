package com.unibuc.javaproject.repository;

import com.unibuc.javaproject.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
