package me.gabu.gabazar.editoras.service;

import me.gabu.gabazar.editoras.core.model.Editora;
import me.gabu.gabazar.editoras.service.validations.ValidationEnum;

public interface ValidationService {
    public void validate(Editora editora, ValidationEnum validation);
}
