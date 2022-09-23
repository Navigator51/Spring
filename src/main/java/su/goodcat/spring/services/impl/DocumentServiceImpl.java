package su.goodcat.spring.services.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import su.goodcat.spring.domain.docproject.Document;
import su.goodcat.spring.domain.docproject.Status;
import su.goodcat.spring.domain.dto.DocumentRequestDTO;
import su.goodcat.spring.domain.dto.DocumentResponseDTO;
import su.goodcat.spring.mapper.DocumentMapper;
import su.goodcat.spring.repositories.DocumentRepository;
import su.goodcat.spring.services.interfaces.DocumentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public List<DocumentResponseDTO> getDocumentListByStatus(DocumentRequestDTO documentRequestDTO) {
        List<Status> statusList = documentRequestDTO.status().getStatusList();
        List<Document> documentList = documentRepository.getDocumentsByStatus(statusList);
        return documentList.stream()
                .map(document -> Mappers.getMapper(DocumentMapper.class).fromDocumentToDocumentResponseDTO(document))
                .toList();

    }
}
