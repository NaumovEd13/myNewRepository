package chat;

import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<ModelOfMessages, Long> {
}
