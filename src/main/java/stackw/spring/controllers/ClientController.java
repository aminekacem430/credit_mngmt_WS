package stackw.spring.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import stackw.spring.models.Client;
import stackw.spring.models.ERole;
import stackw.spring.models.Role;
import stackw.spring.models.User;
import stackw.spring.payload.request.ClientAddRequest;
import stackw.spring.payload.request.SignupRequest;
import stackw.spring.payload.response.MessageResponse;
import stackw.spring.repository.ClientRepository;
import stackw.spring.repository.RoleRepository;
import stackw.spring.repository.UserRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//for Angular Client (withCredentials)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ClientController {

  @Autowired
  private ClientRepository clientRepo;
  @Autowired
  RoleRepository roleRepository;
  @Autowired
  PasswordEncoder encoder;
  @Autowired
  UserRepository userRepository;
  @GetMapping("/all")
  public List<Client> getAllClients( ) {
    return clientRepo.findAll();
  }

  @GetMapping("/byadmin")
  public List<Client> getAllClientsbyadmin(@RequestParam(name="id") Integer idadmin) {
    return clientRepo.findByIdadmin(idadmin).stream().toList();
  }


  @PostMapping("/addClient")
  public ResponseEntity<?> registerUser(@Valid @RequestBody ClientAddRequest clientAddRequest) {

    if (userRepository.existsByUsername(clientAddRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }
    System.out.println("////idadmin "+clientAddRequest.getIdadmin());
    // Create new user's account
    User user = new User(clientAddRequest.getUsername()+"_"+clientAddRequest.getIdadmin(),
            encoder.encode(clientAddRequest.getPassword()));

    Set<Role> roles = new HashSet<>();
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);

    user.setRoles(roles);
    userRepository.saveAndFlush(user);
    // Create new Client
    Client client = new Client();
    client.setSit("V");
    client.setDatesit(new Date());
    client.setNomClient(clientAddRequest.getUsername());
    client.setTel(clientAddRequest.getTel());
    client.setIdadmin(clientAddRequest.getIdadmin());
    client.setId_client(user.getId().intValue());
    clientRepo.save(client);


    return ResponseEntity.ok(new MessageResponse("client ajouté avec LOGIN: "+user.getUsername()+"!"));
  }

}
