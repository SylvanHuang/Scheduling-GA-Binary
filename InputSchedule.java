import java.util.*;
import java.io.*;

class Person
{
    // 7 days, 5 times per day
    int[][] preferences;
    String name;

    public Person(String name)
    {
        this.name = name;
        preferences = new int[7][5];
    }
}

public class InputSchedule
{
    String filename;
    public static ArrayList<Person> people;

    public InputSchedule(String filename)
    {
        this.filename = filename;    
        people = new ArrayList<>();

    }

    public void read_preferences() throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(filename));

        for (int i = 0; i < 7; i++)
        {
            String name = in.next();
            Person p = new Person(name);

            for (int time = 0; time < 5; time++)
            {
                for (int day = 0; day < 7; day++)
                {
                    p.preferences[day][time] = in.nextInt();
                }
            }

            people.add(p);
        }
    }
    public boolean valid_schedule(Chromo X)
    {
        // How many times a person has had a time assigned
        int[] assigned = new int[7];

        for (int day = 0; day < 7; day++)
        {
            for (int time = 0; time < 5; time++)
            {
                // System.out.println(day*15 + 3*time);
                int person_num = Integer.parseInt(X.chromo.substring(day*15 + 3*time, day*15 + 3*time + 3),2);
                
                if (person_num == 7)
                    return false;

                int[][] person_preferences = InputSchedule.people.get(person_num).preferences;
                if (person_preferences[day][time] == 0)
                    return false;

                assigned[person_num] += 1;

                if (assigned[person_num] > 5)
                    return false;
            }
        }

        return true;
    }
}