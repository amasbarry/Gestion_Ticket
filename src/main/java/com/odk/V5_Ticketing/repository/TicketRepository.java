package com.odk.V5_Ticketing.repository;

import com.odk.V5_Ticketing.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
