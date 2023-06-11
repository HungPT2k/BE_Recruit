package com.vn.recruit.service;

import com.vn.recruit.dto.NotificationDTO;
import com.vn.recruit.entity.Notifications;

public interface NotificationService {
    Notifications save(NotificationDTO notificationDTO);
}
