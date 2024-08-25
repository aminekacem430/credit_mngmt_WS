package stackw.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stackw.spring.models.Detail_Credit_Transaction;

import java.util.Optional;

@Repository
public interface DetailsCreditTransRepository extends JpaRepository<Detail_Credit_Transaction, Long> {
  Optional<Detail_Credit_Transaction> findByIdcredittransaction(Integer idcredittransaction);


}
