import java.io.File;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

public class HighScoreTableTest extends TestCase {
	public void testHighScoreTable() {
		HighScoreTable table = new HighScoreTable(3);
		assertEquals(3, table.getCapacity());
		HighScoreTable table2 = new HighScoreTable();
		assertEquals(10, table2.getCapacity());
		
		try {
			HighScoreTable table3 = new HighScoreTable(-10);
			fail("Should throw an exception");
		} catch (Exception e) {
		}	
	}

	public void testSize() {
		HighScoreTable table = new HighScoreTable(10);
		table.add("Jake", 5);
		table.add("Rosa", 3);
		assertEquals(2, table.size());
	}

	public void testgetCapacity() {
		HighScoreTable table = new HighScoreTable(10);
		assertEquals(10, table.getCapacity());

		try {
			HighScoreTable table2 = new HighScoreTable(-10);
			fail("Should throw an exception");
		} catch (Exception e) {
		}
	}

	public void testadd() {
		HighScoreTable table = new HighScoreTable();
		table.add("Charles", 11);
		table.add("Gina", 3);
		table.add("Holt", 11);

		assertEquals("Charles", table.getName(0));
		assertEquals(11, table.getScore(0));
		assertEquals("Gina", table.getName(2));
		assertEquals(3, table.getScore(2));
		assertEquals("Holt", table.getName(1));
		
		try {
			assertEquals("Charles", table.getName(-1));
			fail("Should throw an exception");
		} catch (Exception e) {
		}
		try {
			assertEquals(11, table.getScore(-1));
			fail("Should throw an exception");
		} catch (Exception e) {
		}
	}

	public void testgetName() {
		HighScoreTable table = new HighScoreTable(3);
		table.add("Amy", 11);
		assertEquals("Amy", table.getName(0));

		try {
			table.getName(-2);
			fail("Should throw an exception");
		} catch (Exception e) {
		}
	}

	public void testgetScore() {
		HighScoreTable table = new HighScoreTable();
		table.add("Terry", 11);
		assertEquals(11, table.getScore(0));

		try {
			table.getScore(-2);
			fail("Should throw an exception");
		} catch (Exception e) {
		}
	}

	public void testwrite() {
		HighScoreTable table = new HighScoreTable(5);
		File data = new File("File.txt");

		try {
			table.write(data);
		} catch (Exception e) {
		}
	}

	public void testRead() {
		HighScoreTable table = new HighScoreTable(5);
		table.add("Wunch", 5);
		table.add("Kevin", 8);
		File data = new File("File.txt");

		try {
			table.write(data);
		} catch (FileNotFoundException e) {
		}
  
		HighScoreTable table2 = new HighScoreTable();

		try {
			table2 = HighScoreTable.read(data);
		} catch (FileNotFoundException e) {
		}

		assertEquals("Kevin", table2.getName(0));
assertEquals(8, table2.getScore(0));
		assertEquals("Wunch", table2.getName(1));
		assertEquals(5, table2.getScore(1));
	}
}
