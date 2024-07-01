package com.okd.TicketingV2.Repository;

import com.okd.TicketingV2.Modele.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
