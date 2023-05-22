package org.koreait.models.board;

import org.koreait.controllers.board.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(BoardForm boardForm) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT BOARDDATA (ID, SUBJECT, CONTENT) VALUES (BOARDDATA_SEQ.nextval, ?, ?)";
        jdbcTemplate.update(conn -> {
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"ID"});

            pstmt.setString(1, boardForm.getSubject());
            pstmt.setString(2, boardForm.getContent());

            return pstmt;
        }, keyHolder);

        Number key = keyHolder.getKey();
        boardForm.setId(key.longValue());
    }

    public Board get(long id) {
        try {
            String sql = "SELECT * FROM BOARDDATA WHERE ID = ?";
            Board board = jdbcTemplate.queryForObject(sql, this::mapper, id);
            return board;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Board mapper(ResultSet rs, int i) throws SQLException {
        Board board = new Board();
        board.setId(rs.getLong("ID"));
        board.setSubject(rs.getString("SUBJECT"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDt(rs.getTimestamp("REGDT").toLocalDateTime());

        return board;
    }
}
