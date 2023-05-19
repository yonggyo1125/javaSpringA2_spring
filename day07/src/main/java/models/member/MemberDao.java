package models.member;

import controllers.JoinForm;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final JdbcTemplate jdbcTemplate;

    public void insert(JoinForm joinForm) {

    }

    public Member get(String userId) {

        return null;
    }

    public boolean exists(String userId) {

        return false;
    }
}
