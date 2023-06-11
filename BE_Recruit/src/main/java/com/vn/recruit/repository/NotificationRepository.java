package com.vn.recruit.repository;

import com.vn.recruit.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications,Long> {

}
