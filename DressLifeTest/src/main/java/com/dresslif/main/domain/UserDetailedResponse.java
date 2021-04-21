package com.dresslif.main.domain;

import lombok.*;

import java.util.Set;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDetailedResponse {
    private List<String> titleWords;
    private List<String> bodyWords;
    private Set<String> commonWords;
}
