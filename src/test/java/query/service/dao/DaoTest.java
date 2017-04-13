package query.service.dao;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;

import java.sql.SQLException;
import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        public Dao dao() {
            return new Dao();
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            return createMock(JdbcTemplate.class);
        }
    }

    @Autowired
    private Dao dao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        reset(jdbcTemplate);
    }

    @Test
    public void testFindData() {
        // given
        expect(jdbcTemplate.queryForList("select * from TABLE_NAME where QUERY_FIELD= ?", new Object[]{"VALUE"}))
                .andReturn(new ArrayList<>());
        replay(jdbcTemplate);

        // when
        dao.findData("TABLE_NAME", "QUERY_FIELD", "VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testIsExistByFieldName() {
        // given
        expect(jdbcTemplate.queryForList("select * from TABLE_NAME where QUERY_FIELD = ?", new Object[]{"VALUE"}))
                .andReturn(new ArrayList<>());
        replay(jdbcTemplate);

        // when
        dao.isExistByFieldName("TABLE_NAME", "QUERY_FIELD", "VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testIsExistClearFile() {
        // given
        expect(jdbcTemplate.queryForList("SELECT * FROM ihub_import_archive.PTS_CLR_DTL_AR clr WHERE clr.merchant_order_nbr = ?", new Object[]{"VALUE"}))
                .andReturn(new ArrayList<>());
        replay(jdbcTemplate);

        // when
        dao.isExistClearFile("VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testIsExistACT10e() {
        // given
        expect(jdbcTemplate.queryForList("SELECT * FROM ihub_import_archive.pts_act0010_ar act10 WHERE act10.merchant_order_nbr = ?", new Object[]{"VALUE"}))
                .andReturn(new ArrayList<>());
        replay(jdbcTemplate);

        // when
        dao.isExistACT10("VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testIsExistAct2() {
        // given
        expect(jdbcTemplate.queryForList("SELECT * FROM ihub_import_archive.pts_act0002_ar act2 WHERE act2.merchant_order_nbr = ?", new Object[]{"VALUE"}))
                .andReturn(new ArrayList<>());
        replay(jdbcTemplate);

        // when
        dao.isExistAct2("VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testIsExistPriced() {
        // given
        expect(jdbcTemplate.queryForList("SELECT * FROM ihub_owner.ihub_txn_price tp,ihub_owner.ihub_txn it" +
                " WHERE tp.txn_id = it.id AND (it.invoice_number = ? OR it.auth_invoice_number = ?)", new Object[]{"VALUE", "VALUE"}))
                .andReturn(new ArrayList<>());
        replay(jdbcTemplate);

        // when
        dao.isExistPriced("VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testIsExistTilr() {
        // given
        expect(jdbcTemplate.queryForList("SELECT * FROM IHUB_IMPORT_ARCHIVE.amex_tilr_roc_detail_ar tilr WHERE tilr.client_txn_id = ?", new Object[]{"VALUE"}))
                .andReturn(new ArrayList<>());
        replay(jdbcTemplate);

        // when
        dao.isExistTilr("VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testIsExistCapConfr() {
        // given
        expect(jdbcTemplate.queryForList("SELECT * FROM IHUB_IMPORT_ARCHIVE.amex_capnconf_rej_ar rej where client_txn_id = ?", new Object[]{"VALUE"}))
                .andReturn(new ArrayList<>());
        replay(jdbcTemplate);

        // when
        dao.isExistCapConf("VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testGetDataById() throws SQLException {
        // given
        expect(jdbcTemplate.query(isA(String.class), new String[]{EasyMock.anyObject(String.class)}, isA(RowMapper.class)))
                .andReturn(new ArrayList<>());

        replay(jdbcTemplate);

        // when
        dao.getDataById("TABLE_NAME", "QUERY_FIELD", "VALUE");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testGetQbmsData() throws SQLException {
        // given
        expect(jdbcTemplate.query(isA(String.class), new String[]{EasyMock.anyObject(String.class)}, isA(RowMapper.class)))
                .andReturn(new ArrayList<>());

        replay(jdbcTemplate);

        // when
        dao.getQbmsData("TABLE_NAME", "QUERY_FIELD");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

    @Test
    public void testGetDataByClientTxnId() throws SQLException {
        // given
        expect(jdbcTemplate.query(isA(String.class), new String[]{EasyMock.anyObject(String.class)}, isA(RowMapper.class)))
                .andReturn(new ArrayList<>());

        replay(jdbcTemplate);

        // when
        dao.getDataByClientTxnId("TABLE_NAME");

        // verify
        verify(jdbcTemplate);
        reset(jdbcTemplate);
    }

}