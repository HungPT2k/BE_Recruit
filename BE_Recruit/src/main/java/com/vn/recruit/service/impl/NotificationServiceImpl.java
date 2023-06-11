package com.vn.recruit.service.impl;

import com.vn.recruit.dto.NotificationDTO;
import com.vn.recruit.entity.Notifications;
import com.vn.recruit.repository.NotificationRepository;
import com.vn.recruit.service.NotificationService;
import com.vn.recruit.service.mapper.NotificationMapper;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationMapper notificationMapper;

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationMapper notificationMapper, NotificationRepository notificationRepository) {
        this.notificationMapper = notificationMapper;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notifications save(NotificationDTO notificationDTO) {
        Notifications notifications=notificationMapper.toEntity(notificationDTO);
        notificationRepository.save(notifications);
        return notifications;
    }
}
