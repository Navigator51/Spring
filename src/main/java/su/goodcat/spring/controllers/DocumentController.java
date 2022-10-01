package su.goodcat.spring.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import su.goodcat.spring.domain.dto.DocumentRequestDTO;
import su.goodcat.spring.domain.dto.DocumentResponseDTO;
import su.goodcat.spring.services.interfaces.DocumentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(
        name = "document-controller",
        description = "Контроллер для работы документами"
)
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping(path = "/api/v1/document/status")
    public ResponseEntity<List<DocumentResponseDTO>> getDocumentByStatus(@RequestBody DocumentRequestDTO documentRequestDTO) {
        return ResponseEntity.ok(documentService.getDocumentListByStatus(documentRequestDTO));
    }
}
