package com.example.addressbookusingmongodb.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
}