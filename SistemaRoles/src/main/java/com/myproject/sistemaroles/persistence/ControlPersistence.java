package com.myproject.sistemaroles.persistence;

import com.myproject.sistemaroles.logica.Rol;
import com.myproject.sistemaroles.logica.Usuario;
import com.myproject.sistemaroles.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlPersistence {
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
        
    }

    public void eliminar(int id_usuario) {
        try {
            usuarioJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    public void crearUsuario(Usuario usuario) {
        usuarioJpa.create(usuario);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuarioJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControlPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id_usuario) {
        return usuarioJpa.findUsuario(id_usuario);
    }

   
    
}
