package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //String lineSeparator=System.lineSeparator();
    Job testValueJob1=new Job("Product tester", new Employer("ACME"),
            new Location("Desert"), new PositionType("Quality control"),
            new CoreCompetency("Persistence"));;
    Job testValueJob2 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
    Job testValueJob3 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));

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

//assertTrue(objectUnderTest instanceof TargetObject);
        assertTrue(testValueJob1 instanceof Job);
        assertTrue(testValueJob1.getEmployer() instanceof Employer);
        assertTrue(testValueJob1.getLocation() instanceof Location);
        assertTrue(testValueJob1.getPositionType() instanceof PositionType);
        assertTrue(testValueJob1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testValueJob1.getName(), "Product tester");
        assertEquals(testValueJob1.getEmployer().getValue(), "ACME");
        assertEquals(testValueJob1.getLocation().getValue(), "Desert");
        assertEquals(testValueJob1.getPositionType().getValue(), "Quality control");
        assertEquals(testValueJob1.getCoreCompetency().getValue(), "Persistence");

    }
    @Test
    public void testJobsForEquality(){
        assertFalse(testValueJob2.equals(testValueJob3));
    }

   @Test
    public void  testToStringStartsAndEndsWithNewLine(){
       Job testValueJob1=new Job("Product tester", new Employer("ACME"),
               new Location("Desert"), new PositionType("Quality control"),
               new CoreCompetency("Persistence"));



       String firstChar = String.valueOf(testValueJob1.toString().charAt(0));
       String lastChar = String.valueOf(testValueJob1.toString().charAt(testValueJob1.toString().length()-1));

       assertEquals(firstChar, lineSeparator());
       assertEquals(lastChar, lineSeparator());


   }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testValueJob1=new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String [] resultOutput=testValueJob1.toString().trim().split(lineSeparator());
        assertTrue(resultOutput[0].startsWith("ID"));
        assertTrue(resultOutput[1].startsWith("Name"));
        assertTrue(resultOutput[2].startsWith("Employer"));
        assertTrue(resultOutput[3].startsWith("Location"));
        assertTrue(resultOutput[4].startsWith("Position Type"));
        assertTrue(resultOutput[5].startsWith("Core Competency"));

       assertTrue(resultOutput[0].endsWith(Integer.toString(testValueJob1.getId())));
       assertTrue(resultOutput[1].endsWith(testValueJob1.getName()));
       assertTrue(resultOutput[2].endsWith(testValueJob1.getEmployer().toString()));
       assertTrue(resultOutput[3].endsWith(testValueJob1.getLocation().toString()));
       assertTrue(resultOutput[4].endsWith(testValueJob1.getPositionType().toString()));
       assertTrue(resultOutput[5].endsWith(testValueJob1.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testValueJob1=new Job("Product tester", new Employer(""),
                new Location(""), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String [] resultOutput=testValueJob1.toString().trim().split(lineSeparator());
           assertTrue(resultOutput[2].endsWith("Data not available"));
           assertTrue(resultOutput[3].endsWith("Data not available"));
    }

}

