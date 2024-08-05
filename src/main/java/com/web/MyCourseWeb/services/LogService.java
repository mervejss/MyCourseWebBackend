package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.dtos.LogDTO;
import com.web.MyCourseWeb.entities.Log;
import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.mappers.LogMapper;
import com.web.MyCourseWeb.repos.LogRepository;
import com.web.MyCourseWeb.repos.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LogService {

    private final LogRepository logRepository;
    private final UserRepository userRepository;

    public LogService(LogRepository logRepository, UserRepository userRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
    }

    // Tüm logları getir
    public List<LogDTO> getAllLogs() {
        return logRepository.findAll().stream()
                .map(LogMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Tek bir log getir
    public LogDTO getOneLog(Long logID) {
        return logRepository.findById(logID)
                .map(LogMapper::toDTO)
                .orElse(null);
    }

    // Yeni bir log oluştur
    public LogDTO saveOneLog(LogDTO newLogDTO) {
        Log newLog = LogMapper.toEntity(newLogDTO);

        // User ID ile User nesnesini getir
        Optional<User> user = userRepository.findById(newLogDTO.getUserID());
        if (user.isPresent()) {
            newLog.setUserID(user.get());
        } else {
            // Eğer kullanıcı bulunamazsa uygun bir işlem yapılabilir
            throw new RuntimeException("User not found with ID: " + newLogDTO.getUserID());
        }

        return LogMapper.toDTO(logRepository.save(newLog));
    }

    // Var olan bir logu güncelle
    public LogDTO updateOneLog(Long logID, LogDTO newLogDTO) {
        Optional<Log> optionalLog = logRepository.findById(logID);
        if (optionalLog.isPresent()) {
            Log existingLog = optionalLog.get();
            existingLog.setLogAction(Log.LogAction.values()[newLogDTO.getLogAction()]);

            // User ID ile User nesnesini getir
            Optional<User> user = userRepository.findById(newLogDTO.getUserID());
            if (user.isPresent()) {
                existingLog.setUserID(user.get());
            } else {
                // Eğer kullanıcı bulunamazsa uygun bir işlem yapılabilir
                throw new RuntimeException("User not found with ID: " + newLogDTO.getUserID());
            }

            existingLog.setCreatedAt(new Date()); // Optional, as @PrePersist will handle this
            return LogMapper.toDTO(logRepository.save(existingLog));
        }
        return null;
    }

    // Tek bir logu sil
    public void deleteOneLog(Long logID) {
        logRepository.deleteById(logID);
    }

    // Tüm logları sil
    public void deleteAllLogs() {
        logRepository.deleteAll();
    }

    // Belirli bir kullanıcının loglarını getir
    public List<LogDTO> getLogsByUser(Long userID) {
        return logRepository.findByUserID_UserID(userID).stream()
                .map(LogMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void addLogEntry(Long userID, Log.LogAction logAction) {
        Log log = new Log();

        // Kullanıcıyı UserRepository üzerinden al
        User user = userRepository.findById(userID).orElseThrow(() -> new RuntimeException("User not found"));
        log.setUserID(user);
        log.setLogAction(logAction);
        log.setCreatedAt(new Date());

        logRepository.save(log);
    }
}
