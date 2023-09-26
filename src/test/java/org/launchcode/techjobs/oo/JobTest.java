package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job testEmptyJob1=new Job();
        Job testEmptyJob2=new Job();

        //assertNotEquals(testEmptyJob1.getId(),testEmptyJob2.getId());
        assertNotEquals(testEmptyJob1,testEmptyJob2);
    }


    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob1=new Job("Product tester", new Employer("ACME"),
                     new Location("Desert"), new PositionType("Quality control"),
                     new CoreCompetency("Persistence"));;
//assertTrue(objectUnderTest instanceof TargetObject);
        assertTrue(testJob1 instanceof Job);
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob1.getName(), "Product tester");
        assertEquals(testJob1.getEmployer().getValue(), "ACME");
        assertEquals(testJob1.getLocation().getValue(), "Desert");
        assertEquals(testJob1.getPositionType().getValue(), "Quality control1");
        assertEquals(testJob1.getCoreCompetency().getValue(), "Persistence");

    }
    @Test
    public void testJobsForEquality(){
        Job testJob2 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        Job testJob3 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        assertFalse(testJob2.equals(testJob3));
    }
}

