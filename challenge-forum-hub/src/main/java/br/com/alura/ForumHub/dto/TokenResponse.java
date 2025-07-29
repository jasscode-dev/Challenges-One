package br.com.alura.ForumHub.dto;

public class TokenResponse {
    
    private String token;
    private String tipo;
    
    public TokenResponse() {}
    
    public TokenResponse(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
} 