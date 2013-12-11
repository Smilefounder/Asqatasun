/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2013  Open-S Company
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.rules.seo;

import org.opens.tanaguru.entity.audit.ProcessRemark;
import org.opens.tanaguru.entity.audit.ProcessResult;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.rules.keystore.RemarkMessageStore;
import org.opens.tanaguru.rules.seo.test.SeoRuleImplementationTestCase;

/**
 *
 * @author jkowalczyk
 */
public class SeoRule07013Test extends SeoRuleImplementationTestCase {
    
    public SeoRule07013Test(String testName) {
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.opens.tanaguru.rules.seo.SeoRule07013");
    }

    @Override
    protected void setUpWebResourceMap() {
        getWebResourceMap().put("Seo.Test.7.1.3-2Failed-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-2Failed-01.html"));
        getWebResourceMap().put("Seo.Test.7.1.3-2Failed-02",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-2Failed-02.html"));
        getWebResourceMap().put("Seo.Test.7.1.3-2Failed-03",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-2Failed-03.html"));
        getWebResourceMap().put("Seo.Test.7.1.3-2Failed-04",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-2Failed-04.html"));
        getWebResourceMap().put("Seo.Test.7.1.3-2Failed-05",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-2Failed-05.html"));
        getWebResourceMap().put("Seo.Test.7.1.3-3NMI-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-3NMI-01.html"));
        getWebResourceMap().put("Seo.Test.7.1.3-3NMI-02",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-3NMI-02.html"));
        getWebResourceMap().put("Seo.Test.7.1.3-4NA-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-4NA-01.html"));
        getWebResourceMap().put("Seo.Test.7.1.3-4NA-02",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "SEO/SeoRule07013/Seo.Test.7.1.3-4NA-02.html"));
    }

    @Override
    protected void setProcess() {
        ProcessResult processResult = 
                processPageTest("Seo.Test.7.1.3-2Failed-01");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1,processResult.getRemarkSet().size());
        assertEquals(RemarkMessageStore.NOT_RELEVANT_H1_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[0]).getMessageCode());
        
        processResult = processPageTest("Seo.Test.7.1.3-2Failed-02");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1,processResult.getRemarkSet().size());
        assertEquals(RemarkMessageStore.NOT_RELEVANT_H1_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[0]).getMessageCode());
        
        processResult = processPageTest("Seo.Test.7.1.3-2Failed-03");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1,processResult.getRemarkSet().size());
        assertEquals(RemarkMessageStore.NOT_RELEVANT_H1_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[0]).getMessageCode());
        
        processResult = processPageTest("Seo.Test.7.1.3-2Failed-04");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1,processResult.getRemarkSet().size());
        assertEquals(RemarkMessageStore.NOT_RELEVANT_H1_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[0]).getMessageCode());
        
        processResult = processPageTest("Seo.Test.7.1.3-2Failed-05");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(4,processResult.getRemarkSet().size());
        assertEquals(RemarkMessageStore.NOT_RELEVANT_H1_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[0]).getMessageCode());
        assertEquals(RemarkMessageStore.NOT_RELEVANT_H1_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[1]).getMessageCode());
        assertEquals(RemarkMessageStore.CHECK_H1_RELEVANCY_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[2]).getMessageCode());
        assertEquals(RemarkMessageStore.CHECK_H1_RELEVANCY_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[3]).getMessageCode());
        
        processResult = processPageTest("Seo.Test.7.1.3-3NMI-01");
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        assertEquals(1,processResult.getRemarkSet().size());
        assertEquals(RemarkMessageStore.CHECK_H1_RELEVANCY_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[0]).getMessageCode());
        
        processResult = processPageTest("Seo.Test.7.1.3-3NMI-02");
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        assertEquals(2,processResult.getRemarkSet().size());
        assertEquals(RemarkMessageStore.CHECK_H1_RELEVANCY_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[0]).getMessageCode());
        assertEquals(RemarkMessageStore.CHECK_H1_RELEVANCY_MSG,
                ((ProcessRemark)processResult.getRemarkSet().toArray()[1]).getMessageCode());
        
        processResult = processPageTest("Seo.Test.7.1.3-4NA-01");
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        assertNull(processResult.getRemarkSet());
        
        processResult = processPageTest("Seo.Test.7.1.3-4NA-02");
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        assertNull(processResult.getRemarkSet());
    }

    @Override
    protected void setConsolidate() {
        assertEquals(TestSolution.FAILED,
                consolidate("Seo.Test.7.1.3-2Failed-01").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("Seo.Test.7.1.3-2Failed-02").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("Seo.Test.7.1.3-2Failed-03").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("Seo.Test.7.1.3-2Failed-04").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("Seo.Test.7.1.3-2Failed-05").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("Seo.Test.7.1.3-3NMI-01").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("Seo.Test.7.1.3-3NMI-02").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("Seo.Test.7.1.3-4NA-01").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("Seo.Test.7.1.3-4NA-02").getValue());
    }

}
