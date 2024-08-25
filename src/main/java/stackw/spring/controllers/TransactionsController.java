package stackw.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stackw.spring.models.Client;
import stackw.spring.models.Credit_Transaction;
import stackw.spring.repository.ClientRepository;
import stackw.spring.repository.CreditTransRepository;

import java.util.List;

//for Angular Client (withCredentials)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transaction")
public class TransactionsController {

  @Autowired
  private CreditTransRepository credTransDao;
  @GetMapping("/all")
  public List<Credit_Transaction> getAllTrans( ) {
    return credTransDao.findAll();
  }

  @GetMapping("/byclient")
  public List<Credit_Transaction> getAllTransbyClient(@RequestParam(name="id") Integer idclient) {
    return credTransDao.findByIdclient(idclient).stream().toList();
  }

}
