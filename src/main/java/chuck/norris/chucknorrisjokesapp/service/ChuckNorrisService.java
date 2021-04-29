package chuck.norris.chucknorrisjokesapp.service;

import chuck.norris.chucknorrisjokesapp.model.ChuckNorrisQuotesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ChuckNorrisService extends CrudRepository<ChuckNorrisQuotesEntity, Long> {
}
