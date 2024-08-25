package stackw.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stackw.spring.models.Credit_Transaction;
import stackw.spring.models.Detail_Credit_Transaction;
import stackw.spring.repository.CreditTransRepository;
import stackw.spring.repository.DetailsCreditTransRepository;

import java.util.List;

//for Angular Client (withCredentials)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/detailstrans")
public class DetailsTransController {

  @Autowired
  private DetailsCreditTransRepository detcredTransDao;
  @GetMapping("/all")
  public List<Detail_Credit_Transaction> getAllDetailsTrans( ) {
    return detcredTransDao.findAll();
  }

  @GetMapping("/bytrans")
  public List<Detail_Credit_Transaction> getAllDetailsTransbytrans(@RequestParam(name="id") Integer idtrans) {
    return detcredTransDao.findByIdcredittransaction(idtrans).stream().toList();
  }

}
