package com.confeitariaOnline.CO.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        
        String errorMessage = "Usuário ou senha incorretos."; // Mensagem padrão

        // Verifica se a exceção é sobre credenciais erradas (senha incorreta)
        if (exception.getMessage().contains("Bad credentials")) {
            errorMessage = "Usuário ou senha incorretos..";
        } 
        // Verifica se a exceção é sobre nome de usuário não encontrado
        else if (exception.getMessage().contains("UsernameNotFoundException")) {
            errorMessage = "Usuário não encontrado.";
        }

        // Redireciona com o parâmetro 'message' que irá conter a mensagem de erro
        response.sendRedirect("/login?error=true&message=" + errorMessage);
    }
}
