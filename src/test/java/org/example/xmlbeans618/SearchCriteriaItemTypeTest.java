package org.example.xmlbeans618;

import com.oracle.xmlns.communications.project.fruit.FruitType;
import com.oracle.xmlns.communications.project.fruit.SearchCriteriaItemType;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.io.StringWriter;

public class SearchCriteriaItemTypeTest {
    @Test
    void testSearchCriteriaItemType() throws Exception {
        SearchCriteriaItemType searchCriteriaItemType = SearchCriteriaItemType.Factory.newInstance();
        FruitType fruit = FruitType.Factory.newInstance();
        fruit.setEntityNote("apple");
        FruitType entityLink = fruit.addNewEntityLink();
        entityLink.setEntityNote("pear");
        searchCriteriaItemType.setValue(fruit);
        String output;
        try (StringWriter sw = new StringWriter()) {
            searchCriteriaItemType.save(sw);
            output = sw.toString();
        }
        System.out.println(output);
        try (StringReader sr = new StringReader(output)) {
            SearchCriteriaItemType searchCriteriaItemType2 = SearchCriteriaItemType.Factory.parse(sr);
            try (StringWriter sw = new StringWriter()) {
                searchCriteriaItemType2.save(sw);
                System.out.println(sw.toString());
            }
        }
    }
}
