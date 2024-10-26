/**
 * Esta é a Classe de serviço responsável pela lógica de negócios relacionada aos usuários.
 * Utiliza o InterfaceUserRepository para realizar operações no banco de dados.

 */
package com.uniasselvi.to_do_list_API.service;
import com.uniasselvi.to_do_list_API.model.User;
import com.uniasselvi.to_do_list_API.repository.InterfaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;






















/**
 * Esta classe fornece métodos para operações CRUD (Criar, Ler, Atualizar e Deletar) relacionadas aos usuários.
 * - das linhas 50 em diante, temos:
 * - findAllUsers: Retorna todos os usuários cadastrados.
 * - createUser: Cria um novo usuário e retorna o objeto criado.
 * - updateUser: Atualiza os dados de um usuário existente pelo ID e retorna o usuário atualizado se encontrado.
 * - deleteUser: Deleta um usuário pelo ID especificado.
 * - existsById: Verifica se um usuário existe pelo ID.
 * - findUserById: Busca um usuário pelo ID e retorna um Optional com o usuário encontrado, se existir.
 */
@Service
public class UserService {

    @Autowired
    private InterfaceUserRepository userRepository; // Injeção de dependência do repositório de usuários

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

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}
