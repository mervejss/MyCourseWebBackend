package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.entities.Log;
import com.web.MyCourseWeb.repos.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public Log saveOneLog(Log newLog) {
        return logRepository.save(newLog);
    }

    public Log getOneLog(Long logID) {
        return logRepository.findById(logID).orElse(null);
    }

    public Log updateOneLog(Long logID, Log newLog) {
        Optional<Log> log = logRepository.findById(logID);
        if (log.isPresent()) {
            Log foundLog = log.get();
            foundLog.setLogUserID(newLog.getLogUserID());
            logRepository.save(foundLog);
            return foundLog;
        } else {
            return null;
        }
    }

    public void deleteOneLog(Long logID) {
        logRepository.deleteById(logID);
    }

    public void deleteAllLogs() {
        logRepository.deleteAll();
    }

}
