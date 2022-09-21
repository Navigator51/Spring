package su.goodcat.spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import su.goodcat.spring.domain.dto.DocumentRequestDTO;

import java.util.List;

@RestController
public class DocumentController {

    private DocumentService documentService;

    @PostMapping(path = "/api/v1/document/status")
    public ResponseEntity<List<DocumentResponseDTO>> getDocumentByStatus(@RequestBody DocumentRequestDTO documentRequestDTO){

    }
}
