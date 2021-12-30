package me.gabu.gabazar.editoras.service.impl;

import org.springframework.stereotype.Service;

import me.gabu.gabazar.editoras.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public String getUsuarioFromToken(String token) {
        return "foo";
    }

    @Override
    public boolean isUsuarioAtivo(String usuario) {
        return true;
    }

}
