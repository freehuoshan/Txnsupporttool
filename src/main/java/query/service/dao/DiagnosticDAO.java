package query.service.dao;

import java.sql.SQLException;

/**
 * Created by rmills on 3/24/17.
 */
public interface DiagnosticDAO {

  public boolean authRecordExists(String invoiceId) throws SQLException;

}
