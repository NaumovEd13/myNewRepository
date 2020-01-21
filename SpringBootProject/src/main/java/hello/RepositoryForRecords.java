package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryForRecords extends CrudRepository<Record, Long> {

    List<Record> findByInitialText(String initialText);

    List<Record> findBylang(String lang);

    List<Record> findBytextOfTranslation(String textOfTranslation);

    Record findById(long id);

    @Query(value = "SELECT MIN(DATEDIFF(MILLISECOND,BEGINNING_OF_TRANSLATION,FINISH_OF_TRANSLATION)) FROM TRANSLATIONS", nativeQuery = true)
    long findBySpeed();

}
