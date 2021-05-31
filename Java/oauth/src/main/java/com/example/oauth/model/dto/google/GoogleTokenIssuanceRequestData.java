package com.example.oauth.model.dto.google;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoogleTokenIssuanceRequestData {
    private String code;

    private String grant_type;

    private String client_id;

    private String client_secret;

    private String redirect_uri;
}
