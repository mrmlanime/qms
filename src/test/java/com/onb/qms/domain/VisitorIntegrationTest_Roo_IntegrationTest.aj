// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.onb.qms.domain;

import com.onb.qms.domain.VisitorDataOnDemand;
import com.onb.qms.domain.VisitorIntegrationTest;
import com.torm.domain.Visitor;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect VisitorIntegrationTest_Roo_IntegrationTest {
    
    declare @type: VisitorIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: VisitorIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: VisitorIntegrationTest: @Transactional;
    
    @Autowired
    VisitorDataOnDemand VisitorIntegrationTest.dod;
    
    @Test
    public void VisitorIntegrationTest.testCountVisitors() {
        Assert.assertNotNull("Data on demand for 'Visitor' failed to initialize correctly", dod.getRandomVisitor());
        long count = Visitor.countVisitors();
        Assert.assertTrue("Counter for 'Visitor' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void VisitorIntegrationTest.testFindVisitor() {
        Visitor obj = dod.getRandomVisitor();
        Assert.assertNotNull("Data on demand for 'Visitor' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Visitor' failed to provide an identifier", id);
        obj = Visitor.findVisitor(id);
        Assert.assertNotNull("Find method for 'Visitor' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Visitor' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void VisitorIntegrationTest.testFindAllVisitors() {
        Assert.assertNotNull("Data on demand for 'Visitor' failed to initialize correctly", dod.getRandomVisitor());
        long count = Visitor.countVisitors();
        Assert.assertTrue("Too expensive to perform a find all test for 'Visitor', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Visitor> result = Visitor.findAllVisitors();
        Assert.assertNotNull("Find all method for 'Visitor' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Visitor' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void VisitorIntegrationTest.testFindVisitorEntries() {
        Assert.assertNotNull("Data on demand for 'Visitor' failed to initialize correctly", dod.getRandomVisitor());
        long count = Visitor.countVisitors();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Visitor> result = Visitor.findVisitorEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Visitor' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Visitor' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void VisitorIntegrationTest.testFlush() {
        Visitor obj = dod.getRandomVisitor();
        Assert.assertNotNull("Data on demand for 'Visitor' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Visitor' failed to provide an identifier", id);
        obj = Visitor.findVisitor(id);
        Assert.assertNotNull("Find method for 'Visitor' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyVisitor(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Visitor' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void VisitorIntegrationTest.testMergeUpdate() {
        Visitor obj = dod.getRandomVisitor();
        Assert.assertNotNull("Data on demand for 'Visitor' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Visitor' failed to provide an identifier", id);
        obj = Visitor.findVisitor(id);
        boolean modified =  dod.modifyVisitor(obj);
        Integer currentVersion = obj.getVersion();
        Visitor merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Visitor' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void VisitorIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Visitor' failed to initialize correctly", dod.getRandomVisitor());
        Visitor obj = dod.getNewTransientVisitor(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Visitor' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Visitor' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Visitor' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void VisitorIntegrationTest.testRemove() {
        Visitor obj = dod.getRandomVisitor();
        Assert.assertNotNull("Data on demand for 'Visitor' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Visitor' failed to provide an identifier", id);
        obj = Visitor.findVisitor(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Visitor' with identifier '" + id + "'", Visitor.findVisitor(id));
    }
    
}
