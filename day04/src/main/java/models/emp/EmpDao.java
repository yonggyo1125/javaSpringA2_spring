package models.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT INTO EMP2 (EMPNO, ENAME, JOB) VALUES (?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql, 2, "사원2", "STAFF");
        System.out.println(affectedRows);
    }

    public void delete(int no) {
        String sql = "DELETE FROM EMP2 WHERE EMPNO = ?";
        int affectedRows = jdbcTemplate.update(sql, no);
        System.out.println(affectedRows);
    }
}
