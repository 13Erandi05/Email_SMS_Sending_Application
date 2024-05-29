package com.notification.EmailSender_V2.Repository;

import com.notification.EmailSender_V2.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends JpaRepository<Notification,Integer> {
}
