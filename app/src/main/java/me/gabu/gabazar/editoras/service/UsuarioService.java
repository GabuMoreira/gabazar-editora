
package me.gabu.gabazar.editoras.service;

public interface UsuarioService {

    public String getUsuarioFromToken(String token);
    public boolean isUsuarioAtivo(String usuario);
}
