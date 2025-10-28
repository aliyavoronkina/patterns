package ru.netology.domain;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class UserInfo {
    private String city;
    private String name;
    private String phone;
}