package models.emp;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor // 기본 생성자
//@RequiredArgsConstructor
@Data
public class Emp {
    private long EMPNO;

    private String ENAME;

    private String JOB;
}
