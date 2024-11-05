package com.souleimen.avions.security;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;
  
@Component
public class KeycloakRoleConverter implements Converter<Jwt, AbstractAuthenticationToken> {
	
	private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter=
			new JwtGrantedAuthoritiesConverter();

	
	
	@Override
	public AbstractAuthenticationToken convert(Jwt jwt) {
		
		Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
		
		if (realmAccess == null || realmAccess.isEmpty()) {
			return null;
		}
		
		Collection<GrantedAuthority> authorities = ((List<String>) realmAccess.get("roles")).stream()
				.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		
		//ajouter les rôles de la rubrique scope (email, profile)
		 authorities = Stream.concat( jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
		 authorities.stream()
		 ).collect(Collectors.toSet());
		

		return new JwtAuthenticationToken(jwt, authorities, jwt.getClaim("preferred_username"));

	}
}