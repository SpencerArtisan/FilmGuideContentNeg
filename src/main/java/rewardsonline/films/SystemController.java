package rewardsonline.films;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A controller for obtaining login names. This is for demo purposes only - you
 * would never do this in a real application.
 */
@Controller
public class SystemController {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SystemController(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}