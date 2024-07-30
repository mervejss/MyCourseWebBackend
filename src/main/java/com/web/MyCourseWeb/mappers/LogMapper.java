package com.web.MyCourseWeb.mappers;

import com.web.MyCourseWeb.dtos.LogDTO;
import com.web.MyCourseWeb.entities.Log;
import com.web.MyCourseWeb.entities.User;

public class LogMapper {

    public static LogDTO toDTO(Log log) {
        LogDTO logDTO = new LogDTO();
        logDTO.setLogID(log.getLogID());
        logDTO.setUserID(log.getUserID().getUserID());
        logDTO.setLogAction(log.getLogAction().ordinal()); // Enum'ü Integer olarak al
        logDTO.setCreatedAt(log.getCreatedAt());
        return logDTO;
    }

    public static Log toEntity(LogDTO logDTO) {
        Log log = new Log();
        log.setLogID(logDTO.getLogID());

        // User nesnesini ID ile oluştur
        User user = new User();
        user.setUserID(logDTO.getUserID());
        log.setUserID(user);

        // Integer olarak gelen LogAction'ı enum'a dönüştür
        Log.LogAction logAction = Log.LogAction.values()[logDTO.getLogAction()];
        log.setLogAction(logAction);

        log.setCreatedAt(logDTO.getCreatedAt());
        return log;
    }
}
