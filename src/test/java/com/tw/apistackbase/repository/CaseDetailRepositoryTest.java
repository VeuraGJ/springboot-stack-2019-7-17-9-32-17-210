package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CaseDetail;
import com.tw.apistackbase.entity.CriminalCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertThrows(Exception.class,()->{
            caseDetailRepository.saveAndFlush(caseDetail);
        });
    }
    @Test
    public void should_specific_casedetail_with_criminalcase_when_query_function(){
        CaseDetail caseDetail = caseDetailRepository.findById(1L).orElse(null);
        assertEquals("DHOUHUIUYG",caseDetail.getSubjectiveDescription());
        assertEquals("IHIUGIBUKB",caseDetail.getObjectiveDescription());
    }
    @Before
    public void setUp() throws Exception {
        List<CaseDetail> caseDetails = new ArrayList<>();
        caseDetails.add(new CaseDetail("DHOUHUIUYG","IHIUGIBUKB"));
        caseDetails.add(new CaseDetail("DHOUHUYG","IHIUGIBUKB"));
        caseDetails.add(new CaseDetail("YG","IUKB"));
        caseDetailRepository.saveAll(caseDetails);
    }
}