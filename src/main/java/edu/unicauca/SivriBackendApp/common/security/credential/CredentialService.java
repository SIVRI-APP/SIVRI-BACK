package edu.unicauca.SivriBackendApp.common.security.credential;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.security.auth.AuthenticationService;
import edu.unicauca.SivriBackendApp.common.security.auth.RegisterRequest;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CredentialService {

    private final PasswordEncoder passwordEncoder;
    private final CredentialRepository credentialRepository;
    private final AuthenticationService authenticationService;
    private final UsuarioRepository usuarioRepository;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (Credential) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        credentialRepository.save(user);
    }

    public Boolean registrarUsuario(RegisterRequest request){

        if (!usuarioRepository.existsByCorreo(request.getEmail())){
            throw new ReglaDeNegocioException("bad.request");
        }

        if (!usuarioRepository.existsById(request.getSecretId())){
            throw new ReglaDeNegocioException("bad.request");
        }

        Optional<Credential> credential = credentialRepository.findByEmail(request.getEmail());
        if (credential.isPresent()){
            if (credential.get().getCreated()) {
                throw new ReglaDeNegocioException("bad.credentials.ya.existen");
            }
        }

        Optional<UsuarioEntity> respuestaBd = usuarioRepository.findByCorreo(request.getEmail());
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.request");
        } else if (respuestaBd.get().getId() != request.getSecretId()) {
            throw new ReglaDeNegocioException("bad.request");
        }


        authenticationService.register(request);

        return true;
    }

    public Boolean crearCredencial(Usuario nuevoUsuario){
        //Creamos la credencial en pendiente
        Optional<Credential> credential = credentialRepository.findByEmail(nuevoUsuario.getCorreo());

        if (credential.isPresent()){
            throw new ReglaDeNegocioException("bad.credentials.ya.existen");
        }else{
            Credential user = Credential.builder()
                    .email(nuevoUsuario.getCorreo())
                    .created(false)
                    .usuario(usuarioRepository.findById(nuevoUsuario.getId()).get())
                    .build();
            credentialRepository.save(user);
        }

        return true;
    }
}
