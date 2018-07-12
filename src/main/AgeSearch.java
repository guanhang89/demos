package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgeSearch {

    private List<Person> personList = new ArrayList<Person>();

    /**
     *
     * @param path
     */
    public void init(String path) {
        File file = new File(path);

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!"".equals(line)) {
                    String[] split = line.split(",");
                    if (split.length == 3) {
                        Person person = new Person();
                        person.setName(split[0]);
                        person.setAge(Integer.parseInt(split[1]));
                        person.setYear(Integer.parseInt(split[2]));
                        personList.add(person);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int intsearch(String name, String year) {
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                int birth = person.getYear() - person.getAge();
                return Integer.parseInt(year) - birth;
            }
        }
        return -1;

    }

    public int count(String year,int age) {
        int count = 0;
        int y = Integer.parseInt(year);
        for (Person person : personList) {
            int birth = person.getYear() - person.getAge();
            if (age == (y - birth)) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AgeSearch ageSearch = new AgeSearch();
        ageSearch.init("1.dat");

        System.out.println(ageSearch.intsearch("官航", "2019"));
    }
}
