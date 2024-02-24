package com.myproject.sistemaroles.logica;

import com.myproject.sistemaroles.persistence.ControlPersistence;
import java.util.List;

public class Controller {

    ControlPersistence controlPersis;
    
    public Controller () {
        controlPersis = new ControlPersistence();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {

        Usuario user = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        for (Usuario usua : listaUsuarios) {
            if (usua.getNomUsuario().equals(usuario)) {
                if (usua.getContrasenia().equals(contrasenia)) {
                    user = usua;
                    return user;
                } else {
                    user = null;
                    return user;
                }
            } else {
                user = null;
            }
        }
        return user;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public void eliminar(int id_usuario) {
        controlPersis.eliminar(id_usuario);
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String nombre, String contrasenia, String rol) {
        
        Usuario usuario = new Usuario();
        usuario.setNomUsuario(nombre);
        usuario.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado=this.traerRol(rol);
        if(rolEncontrado!= null) {
            usuario.setRol(rolEncontrado);
        }
        //Creando un metodo para traer el último ID registrado
        int id = this.buscarUltimoId();
        usuario.setId(id+1);
        
        controlPersis.crearUsuario(usuario);
        
    }

    private Rol traerRol(String rol) {
        List<Rol> listaRoles = controlPersis.traerRoles();
        for(Rol role : listaRoles) {
            if (role.getNombreRol().equals(rol)) {
                return role;
            }
        }
        return null;
    }

    private int buscarUltimoId() {
        List<Usuario> listaUsuarios = this.traerUsuarios();
        
        Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);
        return usu.getId();
    }

    public void editarUsuario(Usuario usu, String nombre, String contrasenia, String rol) {
        usu.setNomUsuario(nombre);
        usu.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rol);
        if (rolEncontrado!= null) {
            usu.setRol(rolEncontrado);
        }
        
        controlPersis.editarUsuario(usu);
    }

    public Usuario traerUsuario(int id_usuario) {
        return controlPersis.traerUsuario(id_usuario);
    }

}
