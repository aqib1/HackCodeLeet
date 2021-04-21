package com.dresslif.main.domain;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse {
    private int userId;
    private int id;
    private String title;
    private String body;
}
