package su.goodcat.spring.domain.dto;

import su.goodcat.spring.domain.docproject.Status;

//создание ДТО через record
public record DocumentResponseDTO(Long id, String senderUserName, int countFiles, Status status) {
}
