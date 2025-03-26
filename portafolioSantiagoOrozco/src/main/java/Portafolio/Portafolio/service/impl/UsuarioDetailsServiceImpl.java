package Portafolio.Portafolio.service.impl;

import Portafolio.Portafolio.dao.UsuarioDao;
import Portafolio.Portafolio.domain.Rol;
import Portafolio.Portafolio.domain.Usuario;
import Portafolio.Portafolio.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find user by username
        Usuario usuario = usuarioDao.findByUsername(username);
        // Throw exception if user not found
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        session.removeAttribute("usuarioImagen"); 
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        var roles = new ArrayList<GrantedAuthority>(); 
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        // Return UserDetails object
        return new User(
            usuario.getUsername(), 
            usuario.getPassword(), 
            roles
        );
    }
}
