package stackw.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stackw.spring.models.Credit_Transaction;

import java.util.Optional;

@Repository
public interface CreditTransRepository extends JpaRepository<Credit_Transaction, Long> {
  Optional<Credit_Transaction> findByIdclient(Integer idclient);


}
