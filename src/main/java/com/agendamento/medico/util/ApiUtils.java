package com.agendamento.medico.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public final class ApiUtils {

    // ---- verifica se string é nula ou vazia
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // ---- verifica se qualquer string é nula ou vazia
    public static boolean isAnyNullOrEmpty(String... values) {
        for (String v : values) {
            if (isNullOrEmpty(v)) return true;
        }
        return false;
    }

    // ---- geração de UUID
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    // ---- monta uma resposta padrão
    public static <T> ResponseEntity<T> buildResponse(HttpStatus status, T body) {
        return ResponseEntity.status(status).body(body);
    }

    // ---- validação de campos obrigatórios
    public static void requireNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException("O campo '" + fieldName + "' é obrigatório.");
        }
    }

    // ---- mascarar parte de uma string (ex: dados sensíveis)
    public static String maskString(String value, int visibleStart, int visibleEnd) {
        if (value == null || value.length() < visibleStart + visibleEnd) return value;
        String start = value.substring(0, visibleStart);
        String end = value.substring(value.length() - visibleEnd);
        return start + "****" + end;
    }

}
