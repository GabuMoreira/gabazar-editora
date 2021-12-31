
package me.gabu.gabazar.editoras.service;

public interface TokenService {

    public void validaToken(String token);
    public String recuperarUsuario(String token);
}
