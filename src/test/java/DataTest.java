import java.text.ParseException;

import org.junit.Test;

import query.service.data.DataStore;

public class DataTest {
	@Test
	public void testDataStore() throws NumberFormatException, ParseException{
		System.out.println(DataStore.getDataMap());
	}
}
