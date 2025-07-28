package kg.zllloy.jobsearch.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean existsById(int categoryId) {
        String sql = "SELECT COUNT(*) FROM categories WHERE id = :categoryId";
        MapSqlParameterSource params = new MapSqlParameterSource("categoryId", categoryId);

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return count == null || count <= 0;
    }
}
