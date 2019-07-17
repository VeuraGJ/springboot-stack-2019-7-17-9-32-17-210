package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CaseDetail;
import com.tw.apistackbase.entity.CriminalCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CaseDetailRepositoryTest {
    @Autowired
    private CaseDetailRepository caseDetailRepository;

    @Test
    public void should_add_casedetail_when_give_vaild_casedetail(){
        CaseDetail caseDetail = new CaseDetail();
        caseDetail.setObjectiveDescription("叫了一辆车赶往市里，结果失踪。");
        caseDetail.setSubjectiveDescription("因网络约车引发的刑事案件并不鲜见");
        CaseDetail saveCaseDetail = caseDetailRepository.save(caseDetail);
        assertSame("叫了一辆车赶往市里，结果失踪。",saveCaseDetail.getObjectiveDescription());
    }
    @Test
    public void should_not_add_casedetail_case_when_give_unvaild_casedetail(){
        CaseDetail caseDetail = new CaseDetail();
        CaseDetail saveCaseDetail = caseDetailRepository.save(caseDetail);
        assertEquals(null,saveCaseDetail.getObjectiveDescription());
    }
    @Test
    public void should_specific_casedetail_with_criminalcase_when_query_function(){
        CaseDetail caseDetail = caseDetailRepository.findById(Long.valueOf(1)).orElse(null);
        assertEquals("BBBB",caseDetail.getCriminalCase().getCaseName());
        assertEquals(123143223,caseDetail.getCriminalCase().getIncidentTime());
    }
    @Before
    public void setUp() throws Exception {
        List<CaseDetail> caseDetails = new ArrayList<>();
        caseDetails.add(new CaseDetail("DHOUHUIUYG","IHIUGIBUKB",new CriminalCase("BBBB",123143223)));
        caseDetails.add(new CaseDetail("DHOUHUYG","IHIUGIBUKB",new CriminalCase("BBBB",123143233)));
        caseDetails.add(new CaseDetail("YG","IUKB",new CriminalCase("CCCC",663143223)));
        caseDetailRepository.saveAll(caseDetails);
    }
}