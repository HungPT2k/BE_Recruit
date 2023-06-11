package com.vn.recruit.repository;

import com.vn.recruit.entity.TypeNotifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeNotificationRepository extends JpaRepository<TypeNotifications,Long> {
    TypeNotifications findTypeNotificationsById(Long id);
}
