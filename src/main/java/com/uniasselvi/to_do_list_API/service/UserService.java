package com.uniasselvi.to_do_list_API.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Métodos para criar, ler, atualizar e deletar usuários
}
