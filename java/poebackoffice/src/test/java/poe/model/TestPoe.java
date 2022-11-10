package poe.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestPoe {
    @Test

    void testDefaultConstructor(){

        LocalDate beginDate = LocalDate.of(2022,10,17);
        LocalDate endDate = LocalDate.of(2023,1,27);
        PoeType poeType = PoeType.POEI;

        Poe poe = new Poe();
        assertNull(poe.getTitle());
        assertNull(poe.getBeginDate());
        assertNull(poe.getEndDate());
        assertNull(poe.getPoeType());


        poe.setPoeType(poeType);
        poe.setBeginDate(beginDate);
        poe.setEndDate(endDate);
        poe.setTitle("FullStack Java");

        assertEquals("FullStack Java", poe.getTitle());
        assertEquals(LocalDate.of(2023,1,27), poe.getEndDate());
        assertEquals(LocalDate.of(2022,10,17), poe.getBeginDate());
        assertEquals(PoeType.POEI, poe.getPoeType());

        assertInstanceOf(Poe.class, poe);

    }

    @Test

    void testAllArgsConstructor(){

        LocalDate beginDate = LocalDate.of(2022,10,24);
        LocalDate endDate = LocalDate.of(2023,1,27);
        PoeType poeType = PoeType.POEI;

        Poe poe = new Poe("FullStack Java", beginDate, endDate, poeType );

        assertEquals(LocalDate.of(2022,10,24), poe.getBeginDate(), "beginDate");
        assertEquals(PoeType.POEI, poe.getPoeType());
        assertEquals(LocalDate.of(2023,1,27), poe.getEndDate());
        assertEquals("FullStack Java", poe.getTitle());

        assertInstanceOf(Poe.class, poe);

    }

    @Test

    void toStringTest(){

        LocalDate beginDate = LocalDate.of(2022,10,24);
        LocalDate endDate = LocalDate.of(2023,1,27);
        PoeType poeType = PoeType.POEI;

        Poe poe = new Poe("FullStack Java", beginDate, endDate, poeType);

        assertEquals("Poe{" +
                "title='" + poe.getTitle() + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", poeType=" + poeType +
                '}', poe.toString());

    }

}