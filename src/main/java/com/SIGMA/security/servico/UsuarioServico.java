package com.SIGMA.security.servico;

import com.SIGMA.entidade.DTO.user.UserRequest;
import com.SIGMA.entidade.DTO.user.UserResponse;
import com.SIGMA.entidade.User;
import com.SIGMA.entidade.repositorio.UsuarioRepositorio;
import com.SIGMA.security.JasyptAdvancedConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServico {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    JasyptAdvancedConfig jasyp;

    @Transactional
    public UserResponse salvar(UserRequest request){
        User user = new User(request.getNome(),
                    request.getCpf(),
                    jasyp.getPasswordEncryptor().encrypt(request.getSenha()),
                    request.getTelefone(),
                    request.getEmail());
                    usuarioRepositorio.save(user);
    return new UserResponse(user);
    }

    public List<UserResponse> listarTodos(){

        List<User> resultado = (List<User>) usuarioRepositorio.findByAtivoTrue();

        List<UserResponse> resultadoDTO = resultado.stream()
                .map(produto -> new UserResponse(produto))
                .collect(Collectors.toList());
        return resultadoDTO;
    }

    public Optional<User> buscar(Integer id){
        Optional<User> resultado = usuarioRepositorio.findById(id);
        return resultado;
    }

    public void deletar(Integer id){
        Optional<User> resultado = usuarioRepositorio.findById(id);
        if(resultado.isPresent() ){
            resultado.get().inativar();
        }
    }

    public UserResponse atualizar(Integer id, UserRequest request){
        Optional<User> resultado = usuarioRepositorio.findById(id);
        User user = resultado.orElseThrow();
        user.atualizar(request);
        usuarioRepositorio.save(user);
        return new UserResponse(user);
    }
}



