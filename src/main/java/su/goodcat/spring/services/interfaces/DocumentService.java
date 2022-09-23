package su.goodcat.spring.services.interfaces;

import su.goodcat.spring.domain.dto.DocumentRequestDTO;
import su.goodcat.spring.domain.dto.DocumentResponseDTO;

import java.util.List;

public interface DocumentService {

    List<DocumentResponseDTO> getDocumentListByStatus(DocumentRequestDTO documentRequestDTO);
}
