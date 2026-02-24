package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.Date;

class Test_ToDo {
    private ToDo tarea1, tarea2;
    private Date dueDate;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
        dueDate = new Date(2025, 12, 31);
        tarea1 = new ToDo();
        tarea2 = new ToDo("Estudiar Java", "Repasar TDD", dueDate, false);
	}

	@AfterEach
	void tearDown() throws Exception {
        tarea2 = null;
        tarea1 = null;
        dueDate = null;
	}

    @Test
    void testConstructorSinArgumentos(){
        assertNull(tarea1.getNombre());
        assertNull(tarea1.getDescripcion());
        assertNull(tarea1.getDueDate());
        assertFalse(tarea1.isCompletado());
    }
	@Test
	void testConstructorConArgumentos(){
        assertEquals("Estudiar Java", tarea2.getNombre());
        assertEquals("Repasar TDD", tarea2.getDescripcion());
        assertEquals(dueDate, tarea2.getDueDate());
        assertFalse(tarea2.isCompletado());
	}

    @Test
    void testGetDescripcion(){
        assertEquals("Repasar TDD", tarea2.getDescripcion());
    }

    @Test
    void testSetDescripcion(){
        tarea2.setDescripcion("Repasar C++");
        assertEquals("Repasar C++", tarea2.getDescripcion());
    }

    @Test
    void testGetDate(){
        assertEquals(dueDate, tarea2.getDueDate());
    }

    @Test
    void testSetDate(){
        tarea2.setDueDate(new Date(11,10,15));
        assertEquals(new Date(11,10,15), tarea2.getDueDate());
    }

    @Test
    void testGetIsCompletado(){
        assertFalse(tarea2.isCompletado());
    }

    @Test
    void testSetIsCompletado(){
        tarea2.setCompletado(true);
        assertTrue(tarea2.isCompletado());
    }
}
