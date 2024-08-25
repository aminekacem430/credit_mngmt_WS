package stackw.spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "detail_credit_transaction")
public class Detail_Credit_Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(name = "id_credit_transaction")
  private Integer idcredittransaction;

  @NotBlank
  private Double montant_achat;
  private String libelle_produit_achete;
  private Date datesit;
  private String sit;

  public Detail_Credit_Transaction() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getIdcredittransaction() {
    return idcredittransaction;
  }

  public void setIdcredittransaction(Integer idcredittransaction) {
    this.idcredittransaction = idcredittransaction;
  }

  public Double getMontant_achat() {
    return montant_achat;
  }

  public void setMontant_achat(Double montant_achat) {
    this.montant_achat = montant_achat;
  }

  public String getLibelle_produit_achete() {
    return libelle_produit_achete;
  }

  public void setLibelle_produit_achete(String libelle_produit_achete) {
    this.libelle_produit_achete = libelle_produit_achete;
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
