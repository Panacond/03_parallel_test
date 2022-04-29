package support;

import java.util.List;

public class ListTestData {

    private List<TestData> listTestData;

    public ListTestData(List<TestData> listData) {
        this.listTestData = listData;
    }

    public List<TestData> getListTestData() {
        return listTestData;
    }

    public void setListTestData(List<TestData> listTestData) {
        this.listTestData = listTestData;
    }

    @Override
    public String toString() {
        return "ListXmlTestData{" +
                "listTestData=" + listTestData +
                '}';
    }
}
