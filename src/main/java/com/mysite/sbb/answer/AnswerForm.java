package com.mysite.sbb.answer;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AnswerForm {
    @NotEmpty(message = "답변을 입력해주세요")
    private String content;
}
