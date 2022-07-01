package br.com.unip.tcc.config;

import br.com.unip.tcc.entities.UsuarioEntity;
import br.com.unip.tcc.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtTokenEnhancer implements TokenEnhancer {

    private final UsuarioRepository userRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UsuarioEntity user = userRepository.findByEmail(authentication.getName());

        Map<String, Object> map = new HashMap<>();
        map.put("userFirstName", user.getNome());
        map.put("userId", user.getId());

        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(map);

        return accessToken;
    }

}
