package stackw.spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "credit_transaction")
public class Credit_Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private Integer id_admin;
  @NotBlank
  @Column(name = "id_client")
  private Integer idclient;
  private Double montant_credit;
  private Double montant_debit;
  private Date datesit;
  private String sit;

  public Credit_Transaction() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getId_admin() {
    return id_admin;
  }

  public void setId_admin(Integer id_admin) {
    this.id_admin = id_admin;
  }

  public Integer getIdclient() {
    return idclient;
  }

  public void setIdclient(Integer idclient) {
    this.idclient = idclient;
  }

  public Double getMontant_credit() {
    return montant_credit;
  }

  public void setMontant_credit(Double montant_credit) {
    this.montant_credit = montant_credit;
  }

  public Double getMontant_debit() {
    return montant_debit;
  }

  public void setMontant_debit(Double montant_debit) {
    this.montant_debit = montant_debit;
  }

  public Date getDatesit() {
    return datesit;
  }

  public void setDatesit(Date datesit) {
    this.datesit = datesit;
  }

  public String getSit() {
    return sit;
  }

  public void setSit(String sit) {
    this.sit = sit;
  }
}
