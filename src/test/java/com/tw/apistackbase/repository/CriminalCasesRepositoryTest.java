package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertSame;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CriminalCasesRepositoryTest {
    @Autowired
    private CriminalCasesRepository criminalCasesRepository;
    @Test
    public void should_add_criminal_case_when_give_vaild_criminal_case(){
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCaseName("AAA");
        criminalCase.setIncidentTime(563363732);
        CriminalCase criminalCase1 = criminalCasesRepository.save(criminalCase);
        assertSame("AAA",criminalCase1.getCaseName());
    }
    @Test
    public void should_not_add_criminal_case_when_give_unvaild_criminal_case(){
        CriminalCase criminalCase = new CriminalCase();
        CriminalCase criminalCase1 =criminalCasesRepository.save(criminalCase);
        assertSame(null,criminalCase1.getCaseName());
    }

}