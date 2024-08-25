package stackw.spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "client")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer idadmin;

  private Integer id_client;

  private String nomClient;
  private Double total_credit;
  private Double total_debit;
  private Double restant_a_paye;
  private Date datesit;
  private String sit;
  private String tel;

  public Client() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getIdadmin() {
    return idadmin;
  }

  public void setIdadmin(Integer idadmin) {
    this.idadmin = idadmin;
  }

  public Integer getId_client() {
    return id_client;
  }

  public void setId_client(Integer id_client) {
    this.id_client = id_client;
  }

  public String getNomClient() {
    return nomClient;
  }

  public void setNomClient(String nomClient) {
    this.nomClient = nomClient;
  }

  public Double getTotal_credit() {
    return total_credit;
  }

  public void setTotal_credit(Double total_credit) {
    this.total_credit = total_credit;
  }

  public Double getTotal_debit() {
    return total_debit;
  }

  public void setTotal_debit(Double total_debit) {
    this.total_debit = total_debit;
  }

  public Double getRestant_a_paye() {
    return restant_a_paye;
  }

  public void setRestant_a_paye(Double restant_a_paye) {
    this.restant_a_paye = restant_a_paye;
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

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }
}
