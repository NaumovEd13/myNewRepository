package chat;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<ModelOfMessages, Long> {
    @Query(value = "SELECT * FROM MESSAGES WHERE IS_CLOSED IS TRUE ",nativeQuery = true)
    Iterable<ModelOfMessages> findAllClosed();

    @Query(value = "UPDATE MESSAGES SET IS_CLOSED=TRUE WHERE ID = id ",nativeQuery = true)
    void update(long id);
}
