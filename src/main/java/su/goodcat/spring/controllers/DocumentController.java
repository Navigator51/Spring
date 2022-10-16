package su.goodcat.spring.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import su.goodcat.commonlib.domain.DocumentRequestDTO;
import su.goodcat.commonlib.domain.DocumentResponseDTO;
import su.goodcat.commonlib.faign.DocumentFeignClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(
        name = "document-controller",
        description = "Контроллер для работы с документами"
)
public class DocumentController {

    private final DocumentFeignClient documentFeignClient;

    @PostMapping(path = "/api/v1/document/status")
    public ResponseEntity<List<DocumentResponseDTO>> getDocumentByStatus(@RequestBody DocumentRequestDTO documentRequestDTO) {
        return ResponseEntity.ok(documentFeignClient.getDocumentByStatus(documentRequestDTO).getBody());
    }
}
