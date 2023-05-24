package org.koreait.commons.rest;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JSONResult<T> {
    private HttpStatus status = HttpStatus.OK;
    private boolean success; // 응답 성공, 실패
    private String message;
    private T data; // 응답 성공 데이터
}
