package com.odk.V5_Ticketing.repository;

import com.odk.V5_Ticketing.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository  extends JpaRepository<Notification, Integer> {

}
