package com.uniasselvi.to_do_list_API.service;

import com.uniasselvi.to_do_list_API.model.User; // Adicione essa importação
import com.uniasselvi.to_do_list_API.repository.InterfaceUserRepository; // Corrigido
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private InterfaceUserRepository userRepository; // Corrigido

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Método para verificar se o usuário existe pelo ID
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
