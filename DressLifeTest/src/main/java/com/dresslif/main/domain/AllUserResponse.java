package com.dresslif.main.domain;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AllUserResponse {
    private List<UserResponse> userResponseList;
}
