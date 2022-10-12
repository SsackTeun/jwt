package com.github.ssackteun.portal.jwt.utils.token;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class JwtToken{
	//HEADER : ALGORITHM & TOKEN TYPE
	private String typ;
	private String alg;

	//PAYLOAD : DATA
	private Long iat; //issued at time
	private Long exp; //expiration time
	private String domain; //onware.local
	private String[] perms; //permission about service
	private String acct; //account
}