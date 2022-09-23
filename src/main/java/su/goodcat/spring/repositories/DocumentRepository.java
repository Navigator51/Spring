package su.goodcat.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import su.goodcat.spring.domain.docproject.Document;
import su.goodcat.spring.domain.docproject.Status;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query("select distinct doc from Document doc join fetch doc.sender left join fetch doc.fileList where doc.status in :statusList")
    List<Document> getDocumentsByStatus(List<Status> statusList);

}
