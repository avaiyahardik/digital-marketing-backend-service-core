package com.example.amazonses.dto.request;

import lombok.Data;

@Data
public class TriggerTemplateRequest {
    private Integer emailListId;
    private Integer templateId;
}
