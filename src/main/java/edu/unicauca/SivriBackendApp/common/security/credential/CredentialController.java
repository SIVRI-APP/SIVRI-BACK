package edu.unicauca.SivriBackendApp.common.security.credential;

import edu.unicauca.SivriBackendApp.common.security.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/v1/credential")
@RequiredArgsConstructor
public class CredentialController {

    private final CredentialService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("registration")
    public  ResponseEntity<Boolean> userRegistration(@RequestBody RegisterRequest request){

        service.registrarUsuario(request);

        return ResponseEntity.ok().body(true);
    }
}
