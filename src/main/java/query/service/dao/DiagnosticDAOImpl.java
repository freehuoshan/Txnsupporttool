package query.service.dao;

import java.sql.SQLException;

/**
 * Created by rmills on 3/24/17.
 */
public class DiagnosticDAOImpl implements DiagnosticDAO {

  @Override
  public boolean authRecordExists(String invoiceId) throws SQLException {
    return false;
  }

}